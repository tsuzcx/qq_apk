package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.adapter.AssociatedAccountListAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.AlbumCleanUtil;
import com.tencent.mobileqq.subaccount.AssociatedAccountListItemData;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.ISubAccountServlet;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

@RoutePage(desc="小号助手-关联账号", path="/base/activity/associatedAccount")
public class AssociatedAccountActivity
  extends SubAccountBaseActivity
  implements Observer
{
  public static final int LOGIN_REQUEST_CHANGE = 1011;
  public static final int MANAGE_ASSOCIATED_ACCOUNT_REQUEST_CODE = 1012;
  public static final long MIN_REFRESH_GAP = 30000L;
  private static final String TAG = "AssociatedAccountActivity";
  public SubAccountInfo curSubAccountInfo;
  private int fromWhereExactly;
  public AssociatedAccountListAdapter mAdapter;
  public SlideDetectListView mAssociatedqqList;
  private AvatarObserver mAvatarObserver = new AssociatedAccountActivity.12(this);
  public boolean mClick2Switch = false;
  public String mCurrentSwitchUin;
  private BusinessObserver mFriendObserver = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getFriendListObserver(new AssociatedAccountActivity.13(this));
  public MqqHandler mHandler = new MqqHandler();
  public boolean mIsDisplayThirdFuc = true;
  public boolean mIsDisplayThirdQQChecked = true;
  public boolean mIsFirstResume = true;
  public boolean mIsFromAccountManage = false;
  public boolean mIsFromPull = false;
  public boolean mIsPullReqSuccess = false;
  public boolean mIsStartRefreshList = false;
  public ArrayList<AssociatedAccountListItemData> mItemDataList;
  public long mLastRefreshTime = 0L;
  private BusinessObserver mMsgObserver = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getMessageObserver(new AssociatedAccountActivity.15(this));
  public int mNeed2ConfirmMsgNum = 0;
  private View.OnClickListener mOnItemClickListener = new AssociatedAccountActivity.11(this);
  public int mPullReqNeedBackNum = 0;
  private OverScrollViewListener mScrollViewListener = new AssociatedAccountActivity.16(this);
  private SubAccountBindObserver mSubAccountBindObserver = new AssociatedAccountActivity.14(this);
  public ArrayList<SubAccountInfo> mSubAccountList;
  private FormSwitchItem mSubAccountNotifySwitch;
  public ArrayList<SimpleAccount> mThirdAccountList;
  public PullRefreshHeader mTopRefreshTop;
  public AssociatedAccountListAdapter thirdAccountsAdapter;
  public ArrayList<AssociatedAccountListItemData> thirdAccountsDataList;
  public HorizontalListView thirdAccountsListView;
  public View thirdRootLayout;
  
  private void bindNewSubAccount()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bindNewSubAccount currentUin=");
      ((StringBuilder)localObject1).append(this.app.getCurrentUin());
      QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject1).toString());
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (SubAccountServiceImpl)this.app.getRuntimeService(ISubAccountService.class, "");
    if (localObject1 != null) {
      localArrayList.addAll(((SubAccountServiceImpl)localObject1).getAllSubUin());
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bindNewSubAccount binded = ");
      ((StringBuilder)localObject1).append(localArrayList.size());
      QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (localArrayList.size() < 2)
    {
      Intent localIntent = new Intent();
      Object localObject2 = SubLoginActivity.class;
      localObject1 = new ArrayList();
      Object localObject3 = this.app.getApplication().getAllAccounts();
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject3);
      }
      localObject3 = ((List)localObject1).iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (SimpleAccount)((Iterator)localObject3).next();
      } while ((localObject1 == null) || (TextUtils.equals(((SimpleAccount)localObject1).getUin(), this.app.getCurrentUin())) || (localArrayList.contains(((SimpleAccount)localObject1).getUin())));
      localObject1 = SubAccountBindActivity.class;
      localIntent.setClass(this, (Class)localObject1);
      localObject2 = this.fromWhere;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = AssociatedAccountActivity.class.getSimpleName();
      }
      localIntent.putExtra("fromWhere", (String)localObject1);
      localIntent.putExtra("fromWhereExactly", this.fromWhereExactly);
      startActivity(localIntent);
      return;
    }
    SubAccountControllUtil.a(this.app, this);
  }
  
  private void checkNeed2ConfirmMsgNum()
  {
    this.mNeed2ConfirmMsgNum = 0;
    Object localObject = (SubAccountServiceImpl)this.app.getRuntimeService(ISubAccountService.class, "");
    Iterator localIterator = this.mSubAccountList.iterator();
    while (localIterator.hasNext()) {
      if (((SubAccountServiceImpl)localObject).getUnreadAllMsgNum(((SubAccountInfo)localIterator.next()).subuin) > 0) {
        this.mNeed2ConfirmMsgNum += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkNeed2ConfirmMsgNum mNeed2ConfirmMsgNum = ");
      ((StringBuilder)localObject).append(this.mNeed2ConfirmMsgNum);
      QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean checkParamsInValid(String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    return (TextUtils.isEmpty(paramString)) || (isFinishing()) || (paramSubAccountBackProtocData == null);
  }
  
  private boolean checkSubAccountParamsInValid(String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    return (isFinishing()) || (paramSubAccountThirdQQBackProtocData == null) || (this.app == null) || (!TextUtils.equals(paramString, this.app.getCurrentUin()));
  }
  
  private void cleanMessagesUnreadAsync(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanMessagesUnreadAsync");
    }
    ThreadManager.post(new AssociatedAccountActivity.8(this, paramBoolean, paramString), 8, null, true);
  }
  
  private void cleanOneSubAccountMessagesUnread(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanOneSubAccountMessagesUnread");
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).setReaded(paramString, 7000);
    Object localObject = this.mThirdAccountList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.mThirdAccountList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if (paramString.equals(localSimpleAccount.getUin()))
        {
          SubAccountControllUtil.a(this.app, localSimpleAccount);
          return;
        }
      }
    }
    localObject = this.mSubAccountList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.mSubAccountList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((SubAccountInfo)((Iterator)localObject).next()).subuin))
        {
          localObject = this.app;
          if ((!paramBoolean) && (this.mNeed2ConfirmMsgNum <= 0)) {
            paramBoolean = false;
          } else {
            paramBoolean = true;
          }
          SubAccountControllUtil.a((AppInterface)localObject, paramBoolean, null, paramString);
        }
      }
    }
  }
  
  private void getDataList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDataList needChangeReaded = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" isRefresh = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean2) {
      this.mIsStartRefreshList = true;
    }
    if (this.mIsFromPull)
    {
      this.mPullReqNeedBackNum = 0;
      this.mIsPullReqSuccess = false;
    }
    getSubAccountDataList(paramBoolean1);
    Object localObject = this.mThirdAccountList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      if ((System.currentTimeMillis() - this.mLastRefreshTime < 30000L) && (paramBoolean2))
      {
        this.mHandler.postDelayed(new AssociatedAccountActivity.4(this), 800L);
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "getDataList current-last<30000ms, startGetThirdQQUnreadNum be ignored.");
        }
      }
      else
      {
        paramBoolean1 = SubAccountControllUtil.a(this.app, false);
        if ((this.mIsFromPull) && (paramBoolean1)) {
          this.mPullReqNeedBackNum += 1;
        }
        if (paramBoolean2) {
          this.mLastRefreshTime = System.currentTimeMillis();
        }
      }
    }
    if ((this.mIsFromPull) && (this.mPullReqNeedBackNum == 0))
    {
      this.mTopRefreshTop.a(0);
      this.mHandler.postDelayed(new AssociatedAccountActivity.5(this), 800L);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDataList mPullReqNeedBackNum = ");
      ((StringBuilder)localObject).append(this.mPullReqNeedBackNum);
      QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void gotoManageAssociatedAccount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "gotoManageAssociatedAccount");
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, AssociatedAccountManageActivity.class);
    if (this.mIsFromAccountManage) {
      localIntent.putExtra("fromWhere", ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getAccountManagerName());
    }
    startActivityForResult(localIntent, 1012);
    overridePendingTransition(2130772014, 2130772007);
  }
  
  private void initData()
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (this.app == null) {
        bool = true;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { "initData", " app is null: ", Boolean.valueOf(bool) });
    }
    this.mItemDataList = new ArrayList();
    this.mAdapter = new AssociatedAccountListAdapter(this.app, this.mItemDataList, this.mOnItemClickListener);
    this.mAssociatedqqList.setAdapter(this.mAdapter);
    this.thirdAccountsDataList = new ArrayList();
    this.thirdAccountsAdapter = new AssociatedAccountListAdapter(this.app, this.thirdAccountsDataList, this.mOnItemClickListener);
    this.thirdAccountsListView.setAdapter(this.thirdAccountsAdapter);
    loadAccountList();
    loadItemDataList();
  }
  
  private void initUI()
  {
    if (QLog.isColorLevel())
    {
      boolean bool = true;
      if (this.app != null) {
        bool = false;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { "initUI", " app is null: ", Boolean.valueOf(bool) });
    }
    setTitle(2131887080);
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131916837);
    localTextView.setOnClickListener(new AssociatedAccountActivity.1(this));
    this.mSubAccountNotifySwitch = ((FormSwitchItem)findViewById(2131430040));
    this.mSubAccountNotifySwitch.setVisibility(0);
    updateSubAccountNotifySwitch();
    this.mSubAccountNotifySwitch.setOnCheckedChangeListener(new AssociatedAccountActivity.2(this));
    this.mAssociatedqqList = ((SlideDetectListView)findViewById(2131446544));
    this.thirdRootLayout = findViewById(2131447308);
    this.thirdAccountsListView = ((HorizontalListView)findViewById(2131447307));
    this.thirdAccountsListView.setDividerWidth(ViewUtils.dip2px(22.0F));
    if (AppSetting.e) {
      localTextView.setContentDescription(getText(2131916837));
    }
    this.mTopRefreshTop = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131625671, this.mAssociatedqqList, false));
    this.mAssociatedqqList.setOverScrollHeader(this.mTopRefreshTop);
    this.mAssociatedqqList.setOverScrollListener(this.mScrollViewListener);
    this.mAssociatedqqList.setBackgroundResource(2130838958);
  }
  
  private void onRefreshRequestBack(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = QLog.isColorLevel();
    int i = 2;
    Object localObject;
    if (paramBoolean2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRefreshRequestBack() mPullReqNeedBackNum = ");
      ((StringBuilder)localObject).append(this.mPullReqNeedBackNum);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    this.mPullReqNeedBackNum -= 1;
    if ((paramBoolean1) && (!this.mIsPullReqSuccess)) {
      this.mIsPullReqSuccess = true;
    }
    if (this.mPullReqNeedBackNum <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "onRefreshRequestBack() end");
      }
      this.mIsStartRefreshList = false;
      this.mPullReqNeedBackNum = 0;
      this.mIsFromPull = false;
      localObject = this.mTopRefreshTop;
      if (this.mIsPullReqSuccess) {
        i = 0;
      }
      ((PullRefreshHeader)localObject).a(i);
      this.mHandler.postDelayed(new AssociatedAccountActivity.10(this), 800L);
      if (this.mIsPullReqSuccess) {
        loadItemDataList();
      }
      this.mIsPullReqSuccess = false;
    }
  }
  
  private void refreshAllData(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshAllData direct=");
      localStringBuilder.append(paramBoolean);
      QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
    }
    if (isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      loadAccountList();
      loadItemDataList();
      return;
    }
    this.mHandler.post(new AssociatedAccountActivity.3(this));
  }
  
  private void showConfirmDialog()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getActivity(), null);
    localActionSheet.setMainTitle(2131917710);
    localActionSheet.addButton(2131892267, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new AssociatedAccountActivity.17(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void showSettingDialog(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showSettingDialog underTwo = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ActionSheet)ActionSheetHelper.b(this, null);
    if (paramBoolean) {
      ((ActionSheet)localObject).addButton(getResources().getString(2131916835), 5);
    }
    ((ActionSheet)localObject).addButton(getResources().getString(2131917709), 5);
    ((ActionSheet)localObject).addButton(getResources().getString(2131916838), 5);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new AssociatedAccountActivity.9(this, paramBoolean, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  private void switchAccount(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("switchAccount to Uin = ");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
      boolean bool = false;
      if (this.app == null) {
        bool = true;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { localObject1, " app is null: ", Boolean.valueOf(bool) });
    }
    if (paramString == null) {
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.app.getApplication().getAllAccounts();
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      ((List)localObject1).addAll((Collection)localObject2);
    }
    if (((List)localObject1).size() < 1) {
      return;
    }
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (SimpleAccount)((Iterator)localObject2).next();
      if (((SimpleAccount)localObject1).getUin().equalsIgnoreCase(paramString)) {
        break label176;
      }
    }
    localObject1 = null;
    label176:
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "switchAccount change ");
      }
      this.mCurrentSwitchUin = paramString;
      this.mClick2Switch = true;
      sendBroadcast(new Intent("before_account_change"));
      this.app.switchAccount((SimpleAccount)localObject1, null);
      SubAccountAssistantForward.a(this.app, this);
      AlbumCleanUtil.a();
      return;
    }
    hideJuhua();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchAccount no change ");
    }
  }
  
  private void switchFail()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchFail");
    }
    if (TextUtils.isEmpty(this.mCurrentSwitchUin)) {
      return;
    }
    dimissDialog();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131916863)).setMessage(getString(2131916862));
    localQQCustomDialog.setPositiveButton(2131888010, new AssociatedAccountActivity.7(this));
    localQQCustomDialog.setCancelable(true);
    localQQCustomDialog.show();
  }
  
  private void updateDataList()
  {
    if ((this.thirdRootLayout != null) && (this.leftView != null) && (this.thirdAccountsAdapter != null))
    {
      if (this.mAdapter == null) {
        return;
      }
      if (this.mThirdAccountList.size() > 0)
      {
        this.thirdRootLayout.setVisibility(0);
        this.thirdAccountsAdapter.notifyDataSetChanged();
      }
      else
      {
        this.thirdRootLayout.setVisibility(8);
      }
      this.mAdapter.notifyDataSetChanged();
      if (this.leftView != null) {
        this.leftView.setText("");
      }
      checkNeed2ConfirmMsgNum();
    }
  }
  
  private void updateRightTextView(boolean paramBoolean, float paramFloat)
  {
    if (this.rightViewText != null)
    {
      this.rightViewText.setEnabled(paramBoolean);
      this.rightViewText.setAlpha(paramFloat);
    }
  }
  
  private void updateSubAccountNotifySwitch()
  {
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
    this.mSubAccountNotifySwitch.setChecked(bool);
  }
  
  private void updateThirdQQUnread(SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    paramSubAccountThirdQQBackProtocData = this.thirdAccountsDataList;
    if ((paramSubAccountThirdQQBackProtocData != null) && (paramSubAccountThirdQQBackProtocData.size() > 0))
    {
      int i = 0;
      paramSubAccountThirdQQBackProtocData = this.thirdAccountsDataList.iterator();
      while (paramSubAccountThirdQQBackProtocData.hasNext())
      {
        AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)paramSubAccountThirdQQBackProtocData.next();
        if ((localAssociatedAccountListItemData != null) && (localAssociatedAccountListItemData.a == 6) && (localAssociatedAccountListItemData.l != null))
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)localAssociatedAccountListItemData.l;
          int j = SubAccountControllUtil.g(this.app, localSimpleAccount.getUin());
          if (localAssociatedAccountListItemData.g != j)
          {
            localAssociatedAccountListItemData.g = j;
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "updateThirdQQUnread changed");
        }
        this.thirdAccountsAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void cleanMessagesUnread(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanMessagesUnread");
    }
    Object localObject = this.mThirdAccountList;
    if (((localObject != null) && (((ArrayList)localObject).size() > 0)) || (this.mIsFromAccountManage)) {
      SubAccountControllUtil.e(this.app);
    }
    localObject = this.mSubAccountList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).setReaded(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
      localObject = this.app;
      if ((!paramBoolean) && (this.mNeed2ConfirmMsgNum <= 0)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      SubAccountControllUtil.a((AppInterface)localObject, paramBoolean, null);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("doOnActivityResult requestCode = ");
      paramIntent.append(paramInt1);
      paramIntent.append(" resultCode=");
      paramIntent.append(paramInt2);
      paramIntent = paramIntent.toString();
      bool = false;
      if (this.app == null) {
        bool = true;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { paramIntent, " app is null: ", Boolean.valueOf(bool) });
    }
    if (paramInt1 != 1011)
    {
      if (paramInt1 != 1012) {
        return;
      }
      bool = SubAccountControllUtil.g(this.app);
      if ((paramInt2 == -1) || (this.mIsDisplayThirdQQChecked != bool))
      {
        this.mIsDisplayThirdQQChecked = bool;
        refreshAllData(true);
      }
    }
    else if (paramInt2 == -1)
    {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnDestroy");
    }
    removeObserver(this.mFriendObserver);
    removeObserver(this.mAvatarObserver);
    removeObserver(this.mSubAccountBindObserver);
    removeObserver(this.mMsgObserver);
    this.app.removeHandler(getClass());
    ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this);
    this.mHandler.removeCallbacksAndMessages(null);
    hideJuhua();
    SlideDetectListView localSlideDetectListView = this.mAssociatedqqList;
    if (localSlideDetectListView != null)
    {
      localSlideDetectListView.setOverscrollHeader(null);
      this.mAssociatedqqList.setOverScrollListener(null);
      this.mAssociatedqqList.setAdapter(null);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (this.app == null) {
        bool = true;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { "doOnPause ", " app is null: ", Boolean.valueOf(bool) });
    }
  }
  
  protected void doOnResume()
  {
    ReportController.b(this.app, "dc00898", "", "", "0X800BDE4", "0X800BDE4", 0, 0, "", "", "", "");
    super.doOnResume();
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.app == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { "doOnResume app is null: ", Boolean.valueOf(bool) });
    }
    hideJuhua();
    if (!this.mIsFirstResume) {
      updateSubAccountStatus();
    }
    this.mIsFirstResume = false;
  }
  
  public void getSubAccountDataList(boolean paramBoolean)
  {
    ISubAccountService localISubAccountService = (ISubAccountService)this.app.getRuntimeService(ISubAccountService.class, "");
    Iterator localIterator = this.mSubAccountList.iterator();
    while (localIterator.hasNext())
    {
      SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
      if (localISubAccountService != null)
      {
        if (paramBoolean) {
          localISubAccountService.setAllMessageReaded(localSubAccountInfo.subuin);
        }
        localISubAccountService.cancelHintIsNew(localSubAccountInfo.subuin);
      }
      SubAccountControllUtil.b(this.app, localSubAccountInfo.subuin, false);
      if (this.mIsFromPull) {
        this.mPullReqNeedBackNum += 1;
      }
      if (!((ISubAccountConfigApi)QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
        ((ISubAccountServlet)QRoute.api(ISubAccountServlet.class)).fetchOneTroopNewMsg(this.app, localSubAccountInfo.subuin);
      }
    }
  }
  
  public void handleCleanAllMessage(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = (SubAccountServiceImpl)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
    Iterator localIterator = this.mSubAccountList.iterator();
    while (localIterator.hasNext()) {
      paramAppInterface.removeAllMessage(((SubAccountInfo)localIterator.next()).subuin);
    }
    cleanMessagesUnread(true);
    showQQToastSuccess(paramString);
    loadItemDataList();
  }
  
  public void initCurSubAccountInfo()
  {
    Object localObject = getIntent();
    String str;
    if (localObject != null)
    {
      str = ((Intent)localObject).getStringExtra("subAccount");
      ((Intent)localObject).removeExtra("subAccount");
    }
    else
    {
      str = null;
    }
    localObject = this.curSubAccountInfo;
    if (localObject != null) {
      str = ((SubAccountInfo)localObject).subuin;
    }
    if (this.mSubAccountList.size() > 0)
    {
      if (!TextUtils.isEmpty(str))
      {
        localObject = this.mSubAccountList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(str)))
          {
            this.curSubAccountInfo = localSubAccountInfo;
            i = 1;
            break label124;
          }
        }
        int i = 0;
        label124:
        if (i == 0) {
          this.curSubAccountInfo = null;
        }
      }
      if (this.curSubAccountInfo == null) {
        this.curSubAccountInfo = ((SubAccountInfo)this.mSubAccountList.get(0));
      }
    }
    else
    {
      this.curSubAccountInfo = null;
    }
  }
  
  public void initThirdAccount(List<SimpleAccount> paramList)
  {
    Object localObject = this.mThirdAccountList;
    if (localObject == null) {
      this.mThirdAccountList = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    if (QLog.isColorLevel())
    {
      boolean bool2 = this.mIsDisplayThirdFuc;
      boolean bool3 = this.mIsFromAccountManage;
      boolean bool4 = this.mIsDisplayThirdQQChecked;
      boolean bool1;
      if (this.app == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { "loadAccountList mThirdAccountList.mIsDisplayThirdFuc = ", Boolean.valueOf(bool2), " mIsFromAccountManage=", Boolean.valueOf(bool3), " mIsDisplayThirdQQChecked=", Boolean.valueOf(bool4), " app is null: ", Boolean.valueOf(bool1) });
    }
    if ((this.mIsDisplayThirdFuc) && (!this.mIsFromAccountManage) && (this.mIsDisplayThirdQQChecked))
    {
      localObject = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        ((List)localObject).addAll(paramList);
      }
      if (((List)localObject).size() > 0)
      {
        paramList = this.app.getAccount();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
          if ((localSimpleAccount != null) && (!paramList.equals(localSimpleAccount.getUin())))
          {
            Iterator localIterator = this.mSubAccountList.iterator();
            for (int i = 0; localIterator.hasNext(); i = 1)
            {
              label265:
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
              if ((localSubAccountInfo == null) || (!localSimpleAccount.getUin().equals(localSubAccountInfo.subuin))) {
                break label265;
              }
            }
            if (i == 0) {
              this.mThirdAccountList.add(localSimpleAccount);
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("loadAccountList mThirdAccountList.size() = ");
        paramList.append(this.mThirdAccountList.size());
        QLog.d("AssociatedAccountActivity", 2, paramList.toString());
      }
    }
  }
  
  public void loadAccountList()
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.app == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { "loadAccountList", " app is null: ", Boolean.valueOf(bool) });
    }
    Object localObject = this.mSubAccountList;
    if (localObject == null) {
      this.mSubAccountList = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    localObject = (SubAccountServiceImpl)this.app.getRuntimeService(ISubAccountService.class, "");
    this.mSubAccountList.addAll(((SubAccountServiceImpl)localObject).getAllSubAccountInfo());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadAccountList mSubAccountList.size() = ");
      ((StringBuilder)localObject).append(this.mSubAccountList.size());
      QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.app.getApplication().getAllAccounts();
    initThirdAccount((List)localObject);
    if ((this.mSubAccountList.size() <= 0) && (this.mThirdAccountList.size() <= 0) && ((this.mIsDisplayThirdQQChecked) || (localObject == null) || (((List)localObject).size() <= 1))) {
      updateRightTextView(false, 0.5F);
    } else {
      updateRightTextView(true, 1.0F);
    }
    initCurSubAccountInfo();
  }
  
  public void loadItemDataList()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "loadItemDataList");
    }
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1;
    Object localObject2;
    if (this.mSubAccountList.size() > 0)
    {
      Object localObject3 = (SubAccountServiceImpl)this.app.getRuntimeService(ISubAccountService.class, "");
      int k = this.mSubAccountList.size();
      Object localObject4 = new ArrayList();
      localObject1 = this.app.getApplication().getAllAccounts();
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        ((List)localObject4).addAll((Collection)localObject1);
      }
      ArrayList localArrayList2 = new ArrayList(k);
      int i = 0;
      boolean bool = false;
      int j;
      while (i < k)
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)this.mSubAccountList.get(i);
        if ((localSubAccountInfo != null) && (!TextUtils.isEmpty(localSubAccountInfo.subuin)))
        {
          AssociatedAccountListItemData localAssociatedAccountListItemData = new AssociatedAccountListItemData();
          localAssociatedAccountListItemData.a = 2;
          localObject2 = ((IContactUtils)QRoute.api(IContactUtils.class)).getBuddyNickName(this.app, localSubAccountInfo.subuin, true);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localSubAccountInfo.subuin;
          }
          localAssociatedAccountListItemData.b = ((String)localObject1);
          localAssociatedAccountListItemData.e = localSubAccountInfo.subuin;
          localAssociatedAccountListItemData.l = localSubAccountInfo;
          localAssociatedAccountListItemData.c = "";
          if (localSubAccountInfo.subuin.equals(this.curSubAccountInfo.subuin)) {
            localAssociatedAccountListItemData.k = true;
          } else {
            localAssociatedAccountListItemData.k = false;
          }
          if (localSubAccountInfo.status != 1)
          {
            localAssociatedAccountListItemData.j = 1;
            localObject1 = ((List)localObject4).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (SimpleAccount)((Iterator)localObject1).next();
              if ((localObject2 != null) && (TextUtils.equals(localSubAccountInfo.subuin, ((SimpleAccount)localObject2).getUin())) && (((SimpleAccount)localObject2).isLogined()))
              {
                j = 1;
                break label368;
              }
            }
            j = 0;
            label368:
            if (j != 0) {
              localAssociatedAccountListItemData.i = true;
            } else {
              localAssociatedAccountListItemData.i = false;
            }
          }
          else
          {
            localAssociatedAccountListItemData.j = 0;
          }
          localAssociatedAccountListItemData.d = 0;
          if (AppSetting.e) {
            localAssociatedAccountListItemData.h = getString(2131916844, new Object[] { localAssociatedAccountListItemData.b });
          }
          if (localSubAccountInfo.subuin.equals(this.curSubAccountInfo.subuin)) {
            bool = localAssociatedAccountListItemData.i;
          }
          localArrayList2.add(localAssociatedAccountListItemData);
        }
        i += 1;
      }
      i = 0;
      localObject1 = new AssociatedAccountListItemData();
      ((AssociatedAccountListItemData)localObject1).a = 2;
      ((AssociatedAccountListItemData)localObject1).l = localArrayList2;
      ((AssociatedAccountListItemData)localObject1).c = "";
      localArrayList1.add(localObject1);
      localObject1 = ((SubAccountServiceImpl)localObject3).getAllMessage(this.curSubAccountInfo.subuin);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        j = ((List)localObject1).size();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("loadItemDataList subaccount msg msgSize = ");
          ((StringBuilder)localObject2).append(j);
          QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject2).toString());
        }
        if (j > 0)
        {
          localObject2 = SubAccountControllUtil.h(this.app, this.curSubAccountInfo.subuin);
          while (i < j)
          {
            localObject3 = (SubAccountMessage)((List)localObject1).get(i);
            localObject4 = new AssociatedAccountListItemData();
            ((AssociatedAccountListItemData)localObject4).a = 3;
            if (i == j - 1) {
              ((AssociatedAccountListItemData)localObject4).d = 2;
            } else {
              ((AssociatedAccountListItemData)localObject4).d = 1;
            }
            if ((localObject2 != null) && (((ArrayList)localObject2).contains(((SubAccountMessage)localObject3).senderuin))) {
              ((AssociatedAccountListItemData)localObject4).f = 2;
            }
            if (i == 0) {
              ((AssociatedAccountListItemData)localObject4).k = true;
            }
            ((AssociatedAccountListItemData)localObject4).l = localObject3;
            localArrayList1.add(localObject4);
            i += 1;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "loadItemDataList subaccount no msg");
        }
        localObject1 = new AssociatedAccountListItemData();
        ((AssociatedAccountListItemData)localObject1).a = 7;
        ((AssociatedAccountListItemData)localObject1).k = true;
        ((AssociatedAccountListItemData)localObject1).d = 3;
        ((AssociatedAccountListItemData)localObject1).l = this.curSubAccountInfo;
        ((AssociatedAccountListItemData)localObject1).i = bool;
        localArrayList1.add(localObject1);
      }
    }
    else
    {
      localObject1 = new AssociatedAccountListItemData();
      ((AssociatedAccountListItemData)localObject1).a = 4;
      ((AssociatedAccountListItemData)localObject1).d = 3;
      ((AssociatedAccountListItemData)localObject1).b = getResources().getString(2131916835);
      ((AssociatedAccountListItemData)localObject1).e = getResources().getString(2131916836);
      if (AppSetting.e)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((AssociatedAccountListItemData)localObject1).b);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(((AssociatedAccountListItemData)localObject1).e);
        ((AssociatedAccountListItemData)localObject1).h = ((StringBuilder)localObject2).toString();
      }
      localArrayList1.add(localObject1);
    }
    this.mItemDataList.clear();
    this.mItemDataList.addAll(localArrayList1);
    loadThirdAccountsDataList();
    updateDataList();
  }
  
  public void loadThirdAccountsDataList()
  {
    if (this.mThirdAccountList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList(this.mThirdAccountList.size());
      int j = this.mThirdAccountList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (SimpleAccount)this.mThirdAccountList.get(i);
        AssociatedAccountListItemData localAssociatedAccountListItemData = new AssociatedAccountListItemData();
        localAssociatedAccountListItemData.a = 6;
        localAssociatedAccountListItemData.b = SubAccountControllUtil.b(this.app, (SimpleAccount)localObject);
        localAssociatedAccountListItemData.g = SubAccountControllUtil.g(this.app, ((SimpleAccount)localObject).getUin());
        localAssociatedAccountListItemData.l = localObject;
        if (AppSetting.e)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localAssociatedAccountListItemData.b);
          localAssociatedAccountListItemData.h = ((StringBuilder)localObject).toString();
        }
        localArrayList.add(localAssociatedAccountListItemData);
        i += 1;
      }
      this.thirdAccountsDataList.clear();
      this.thirdAccountsDataList.addAll(localArrayList);
    }
  }
  
  protected void onAccountChanged()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAccountChanged() mClick2Switch=");
      ((StringBuilder)localObject).append(this.mClick2Switch);
      localObject = ((StringBuilder)localObject).toString();
      bool = true;
      if (this.app != null) {
        bool = false;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { localObject, " app is null: ", Boolean.valueOf(bool) });
    }
    super.onAccountChanged();
    removeObserver(this.mFriendObserver);
    removeObserver(this.mAvatarObserver);
    removeObserver(this.mMsgObserver);
    removeObserver(this.mSubAccountBindObserver);
    if (this.app != null) {
      ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this);
    }
    this.mHandler.removeCallbacksAndMessages(null);
    boolean bool = this.mClick2Switch;
    if (this.app != null)
    {
      this.app.removeHandler(getClass());
      this.app.getApplication().refreAccountList();
    }
    SubAccountAssistantForward.a(this.app, this);
    hideJuhua();
    ReportController.b(this.app, "dc00898", "", "", "0X800BDE6", "0X800BDE6", 0, 0, "", "", "", "");
    this.mCurrentSwitchUin = null;
    Object localObject = new Intent();
    ((Intent)localObject).putExtra(((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getTabIndex(), FrameControllerUtil.a);
    ((Intent)localObject).setFlags(67108864);
    RouteUtils.a(this, (Intent)localObject, "/base/start/splash");
    startActivity((Intent)localObject);
    finish();
  }
  
  protected void onAccoutChangeFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onAccoutChangeFailed");
    }
    hideJuhua();
    switchFail();
  }
  
  protected boolean onBackEvent()
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (this.app == null) {
        bool = true;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { "onBackEvent app is null: ", Boolean.valueOf(bool) });
    }
    Object localObject = this.mThirdAccountList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0) && (!this.mIsFromAccountManage)) {
      SubAccountControllUtil.e(this.app);
    }
    AppInterface localAppInterface = this.app;
    localObject = localAppInterface;
    if (localAppInterface == null) {
      localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    }
    if (localObject != null) {
      ((IMessageFacade)((AppRuntime)localObject).getRuntimeService(IMessageFacade.class, "")).setReaded(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
    }
    if (!this.mIsFromAccountManage)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra(((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getTabIndex(), FrameControllerUtil.a);
      ((Intent)localObject).setFlags(67108864);
      RouteUtils.a(this, (Intent)localObject, "/base/start/splash");
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.app == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("AssociatedAccountActivity", 2, new Object[] { "update() app is null: ", Boolean.valueOf(bool) });
    }
    if ((paramObject instanceof MessageRecord)) {
      return;
    }
    if ((paramObject instanceof String[]))
    {
      paramObservable = (String[])paramObject;
      if ((paramObservable.length == 2) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramObservable[0]))) {
        runOnUiThread(new AssociatedAccountActivity.18(this));
      }
    }
  }
  
  public boolean updateSubAccountStatus()
  {
    Object localObject1 = this.mItemDataList;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject1 = this.mSubAccountList;
        bool1 = bool2;
        if (localObject1 != null)
        {
          bool1 = bool2;
          if (((ArrayList)localObject1).size() > 0)
          {
            Object localObject2 = null;
            int i = 0;
            bool1 = false;
            while (i < this.mItemDataList.size())
            {
              AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)this.mItemDataList.get(i);
              bool2 = bool1;
              Object localObject3 = localObject2;
              if (localAssociatedAccountListItemData.a == 2)
              {
                bool2 = bool1;
                localObject3 = localObject2;
                if (localAssociatedAccountListItemData.l != null)
                {
                  bool2 = bool1;
                  localObject3 = localObject2;
                  if ((localAssociatedAccountListItemData.l instanceof ArrayList))
                  {
                    localObject1 = localObject2;
                    if (localObject2 == null) {
                      localObject1 = (SubAccountServiceImpl)this.app.getRuntimeService(ISubAccountService.class, "");
                    }
                    bool2 = bool1;
                    localObject3 = localObject1;
                    if (localObject1 != null)
                    {
                      localObject2 = ((ArrayList)localAssociatedAccountListItemData.l).iterator();
                      for (;;)
                      {
                        bool2 = bool1;
                        localObject3 = localObject1;
                        if (!((Iterator)localObject2).hasNext()) {
                          break;
                        }
                        localObject3 = (AssociatedAccountListItemData)((Iterator)localObject2).next();
                        int j = ((SubAccountServiceImpl)localObject1).getStatus(((SubAccountInfo)((AssociatedAccountListItemData)localObject3).l).subuin);
                        if (((j == 1) && (((AssociatedAccountListItemData)localObject3).j != 0)) || ((j != 1) && (((AssociatedAccountListItemData)localObject3).j == 0)))
                        {
                          if (j == 1) {
                            ((AssociatedAccountListItemData)localObject3).j = 0;
                          } else {
                            ((AssociatedAccountListItemData)localObject3).j = 1;
                          }
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
              i += 1;
              bool1 = bool2;
              localObject2 = localObject3;
            }
            if (bool1)
            {
              localObject1 = this.mAdapter;
              if (localObject1 != null) {
                ((AssociatedAccountListAdapter)localObject1).notifyDataSetChanged();
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  void updateUnreadNumOnTitleBar()
  {
    if ((!this.mIsFromAccountManage) && (this.leftView != null)) {
      ThreadManager.post(new AssociatedAccountActivity.6(this, (IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, ""), (IConversationFacade)this.app.getRuntimeService(IConversationFacade.class, "")), 8, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity
 * JD-Core Version:    0.7.0.1
 */