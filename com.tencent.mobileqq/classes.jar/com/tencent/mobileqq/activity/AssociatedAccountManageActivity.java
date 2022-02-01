package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.imcore.proxy.utils.ContactUtilsProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountProtocServiceImpl;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.os.MqqHandler;

@RoutePage(desc="小号助手-关联账号管理页面", path="/base/activity/associatedAccountManage")
public class AssociatedAccountManageActivity
  extends SubAccountBaseActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private static final int MSG_HIDE_LOADING = 8194;
  private static final int MSG_SHOW_LOADING = 8193;
  private static final int MSG_SHOW_TOAST = 8195;
  private static final String TAG = "AssociatedAccountManage";
  public static final String TVALUE_CLICK_DEL_ACCOUNT = "0X8007147";
  public static final String TVALUE_CLICK_UNBING_ACCOUNT = "0X8007146";
  private static final int TYPE_ACCOUNT = 1;
  private static final int TYPE_SUBACCOUNT = 0;
  AvatarObserver avatarObserver = new AssociatedAccountManageActivity.9(this);
  private BusinessObserver cardObserver = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getCardObserver(new AssociatedAccountManageActivity.2(this));
  private String delCurrentUin;
  BusinessObserver fob = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getFriendListObserver(new AssociatedAccountManageActivity.8(this));
  private Toast lastToast;
  public List<SimpleAccount> mAccountList;
  public LinearLayout mAccountListView;
  public View mAccountTitle;
  public boolean mChanged = false;
  Dialog mDelAccountDialog;
  private FormSwitchItem mDisplayThirdQQCkb;
  private MqqHandler mHandler = new AssociatedAccountManageActivity.1(this);
  public boolean mIsDisplayThirdFuc = true;
  public boolean mIsFromAccountManage = false;
  private QQProgressDialog mProgressDialog;
  private SubAccountBindObserver mSubAccountBindObserver = new AssociatedAccountManageActivity.11(this);
  public List<SubAccountInfo> mSubAccountList;
  public LinearLayout mSubAccountListView;
  public View mSubAccountTitle;
  ActionSheet menuDialog = null;
  ActionSheet menuUnbindDialog = null;
  private AssociatedAccountManageActivity.AccountDelOnButtonClickListener onBtnClickLisForDelAccount = new AssociatedAccountManageActivity.AccountDelOnButtonClickListener(this);
  private AssociatedAccountManageActivity.SubAccountUnbindOnButtonClickListener onBtnClickLisForUnbind = new AssociatedAccountManageActivity.SubAccountUnbindOnButtonClickListener(this);
  private View.OnClickListener onDeleteClickListener = new AssociatedAccountManageActivity.6(this);
  private View.OnClickListener onDeleteItemSelected = new AssociatedAccountManageActivity.4(this);
  private View.OnClickListener onUnBindClickListener = new AssociatedAccountManageActivity.5(this);
  private RotateSwitchImageView selectedAccountView;
  
  private void bindAccountListView()
  {
    this.mAccountListView.removeAllViews();
    Object localObject = this.mAccountList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.mAccountTitle.setVisibility(0);
      int j = this.mAccountList.size();
      int i = 0;
      while (i < j)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindAccountListView i=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", account=");
          ((StringBuilder)localObject).append(this.mAccountList.get(i));
          QLog.i("AssociatedAccountManage", 2, ((StringBuilder)localObject).toString());
        }
        localObject = (SimpleAccount)this.mAccountList.get(i);
        if (localObject != null)
        {
          View localView = getLayoutInflater().inflate(2131629331, this.mAccountListView, false);
          if ((localView instanceof FormItemRelativeLayout))
          {
            FormItemRelativeLayout localFormItemRelativeLayout = (FormItemRelativeLayout)localView;
            localFormItemRelativeLayout.setNeedFocusBg(false);
            if (i == j - 1) {
              localFormItemRelativeLayout.setBGType(3);
            } else {
              localFormItemRelativeLayout.setBGType(2);
            }
            localFormItemRelativeLayout.setNeedFocusBg(true);
          }
          localView.setTag(localObject);
          ((ImageView)localView.findViewById(2131435219)).setScaleType(ImageView.ScaleType.FIT_CENTER);
          ((RotateSwitchImageView)localView.findViewById(2131431711)).setOnClickListener(this.onDeleteItemSelected);
          ((Button)localView.findViewById(2131431681)).setOnClickListener(this.onDeleteClickListener);
          this.mAccountListView.addView(localView);
        }
        i += 1;
      }
      updateAccountListView();
      return;
    }
    this.mAccountTitle.setVisibility(8);
  }
  
  private void bindSubAccountListView()
  {
    this.mSubAccountListView.removeAllViews();
    Object localObject = this.mSubAccountList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.mSubAccountTitle.setVisibility(0);
      int j = this.mSubAccountList.size();
      int i = 0;
      while (i < j)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("bindSubAccountListView i=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", subaccount=");
          ((StringBuilder)localObject).append(this.mSubAccountList.get(i));
          QLog.i("AssociatedAccountManage", 2, ((StringBuilder)localObject).toString());
        }
        localObject = (SubAccountInfo)this.mSubAccountList.get(i);
        if (localObject != null)
        {
          View localView = getLayoutInflater().inflate(2131629332, this.mSubAccountListView, false);
          localView.setTag(localObject);
          localView.setBackgroundResource(2130839622);
          ((Button)localView.findViewById(2131449071)).setOnClickListener(this.onUnBindClickListener);
          this.mSubAccountListView.addView(localView);
        }
        i += 1;
      }
      updateSubAccountListView();
      return;
    }
    this.mSubAccountTitle.setVisibility(8);
  }
  
  private void delAccountRecord(String paramString, boolean paramBoolean)
  {
    AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
    Object localObject1 = this.app.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Constants.PropertiesKey.uinDisplayName.toString());
    ((StringBuilder)localObject2).append(this.delCurrentUin);
    localObject2 = ((MobileQQ)localObject1).getProperty(((StringBuilder)localObject2).toString());
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = this.delCurrentUin;
    }
    localAccountManager.deleteAccount(this.delCurrentUin, (String)localObject1, new AssociatedAccountManageActivity.DelHistoryAccountObserver(this, paramString, paramBoolean));
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("am.deleteAccount ");
      paramString.append(this.delCurrentUin);
      QLog.d("AssociatedAccountManage", 2, paramString.toString());
    }
  }
  
  private View findItemViewByUin(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinearLayout localLinearLayout;
    if (paramInt == 0) {
      localLinearLayout = this.mSubAccountListView;
    } else if (paramInt == 1) {
      localLinearLayout = this.mAccountListView;
    } else {
      localLinearLayout = null;
    }
    if (localLinearLayout == null) {
      return null;
    }
    int j = localLinearLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localLinearLayout.getChildAt(i);
      Object localObject = localView.getTag();
      if (paramInt == 0)
      {
        if ((localObject != null) && ((localObject instanceof SubAccountInfo)) && (paramString.equals(((SubAccountInfo)localObject).subuin))) {
          return localView;
        }
      }
      else if ((paramInt == 1) && (localObject != null) && ((localObject instanceof SimpleAccount)) && (paramString.equals(((SimpleAccount)localObject).getUin()))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private View getTheName(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131439121);
    }
    return null;
  }
  
  private View getTheShader(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131445741);
    }
    return null;
  }
  
  private void initAccountList()
  {
    Object localObject1 = this.mAccountList;
    if (localObject1 == null) {
      this.mAccountList = new ArrayList();
    } else {
      ((List)localObject1).clear();
    }
    Object localObject2;
    if ((this.mIsDisplayThirdFuc) && (!this.mIsFromAccountManage))
    {
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(getAppRuntime().getApplication().getAllAccounts());
      localObject1 = this.app.getAccount();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject2).next();
        if ((localSimpleAccount != null) && (!((String)localObject1).equals(localSimpleAccount.getUin())))
        {
          int k = 0;
          int i = 0;
          Object localObject3 = this.mSubAccountList;
          int j = k;
          if (localObject3 != null)
          {
            j = k;
            if (((List)localObject3).size() > 0)
            {
              localObject3 = this.mSubAccountList.iterator();
              for (;;)
              {
                j = i;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                SubAccountInfo localSubAccountInfo = (SubAccountInfo)((Iterator)localObject3).next();
                if ((localSubAccountInfo != null) && (localSimpleAccount.getUin().equals(localSubAccountInfo.subuin))) {
                  i = 1;
                }
              }
            }
          }
          if (j == 0) {
            this.mAccountList.add(localSimpleAccount);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initAccountList mAccountList=");
      ((StringBuilder)localObject2).append(this.mAccountList);
      ((StringBuilder)localObject2).append(", size=");
      localObject1 = this.mAccountList;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(((List)localObject1).size());
      } else {
        localObject1 = "null";
      }
      ((StringBuilder)localObject2).append(localObject1);
      QLog.i("AssociatedAccountManage", 2, ((StringBuilder)localObject2).toString());
    }
    bindAccountListView();
    updateAccountViewAsDisplayChanged();
  }
  
  private void initSubAccountList()
  {
    Object localObject = this.mSubAccountList;
    if (localObject == null) {
      this.mSubAccountList = new ArrayList();
    } else {
      ((List)localObject).clear();
    }
    localObject = (SubAccountServiceImpl)this.app.getRuntimeService(ISubAccountService.class, "");
    this.mSubAccountList.addAll(((SubAccountServiceImpl)localObject).getAllSubAccountInfo());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initSubAccountList subaccountList=");
      localStringBuilder.append(this.mSubAccountList);
      localStringBuilder.append(", size=");
      localObject = this.mSubAccountList;
      if (localObject != null) {
        localObject = Integer.valueOf(((List)localObject).size());
      } else {
        localObject = "null";
      }
      localStringBuilder.append(localObject);
      QLog.i("AssociatedAccountManage", 2, localStringBuilder.toString());
    }
    bindSubAccountListView();
  }
  
  private void refreshAllAccount()
  {
    initSubAccountList();
    initAccountList();
    List localList = this.mSubAccountList;
    if ((localList == null) || (localList.size() == 0))
    {
      localList = this.mAccountList;
      if ((localList == null) || (localList.size() == 0)) {
        onBackEvent();
      }
    }
  }
  
  private void setSwitchChecked(boolean paramBoolean)
  {
    this.mDisplayThirdQQCkb.setOnCheckedChangeListener(null);
    this.mDisplayThirdQQCkb.setChecked(paramBoolean);
    this.mDisplayThirdQQCkb.setOnCheckedChangeListener(this);
  }
  
  private void showDelAccountDialog()
  {
    try
    {
      if (this.mDelAccountDialog == null)
      {
        this.mDelAccountDialog = new ReportDialog(this, 2131953338);
        this.mDelAccountDialog.setContentView(2131623999);
        ((TextView)this.mDelAccountDialog.findViewById(2131431876)).setText(getString(2131888463));
        this.mDelAccountDialog.setCancelable(false);
      }
      this.mDelAccountDialog.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, localException.toString());
      }
    }
  }
  
  private void updateAccountListView()
  {
    Object localObject1 = this.mAccountListView;
    if ((localObject1 != null) && (((LinearLayout)localObject1).getChildCount() > 0))
    {
      int j = this.mAccountListView.getChildCount();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateAccountListView account size=");
        ((StringBuilder)localObject1).append(j);
        QLog.i("AssociatedAccountManage", 2, ((StringBuilder)localObject1).toString());
      }
      int i = 0;
      while (i < j)
      {
        localObject1 = this.mAccountListView.getChildAt(i);
        Object localObject2 = (SimpleAccount)((View)localObject1).getTag();
        Object localObject3;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateAccountListView i=");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(", view tag=");
          ((StringBuilder)localObject3).append(localObject2);
          QLog.i("AssociatedAccountManage", 2, ((StringBuilder)localObject3).toString());
        }
        if (localObject2 != null)
        {
          localObject3 = (ImageView)((View)localObject1).findViewById(2131435219);
          SingleLineTextView localSingleLineTextView = (SingleLineTextView)((View)localObject1).findViewById(2131439121);
          String str = SubAccountControllUtil.b(this.app, (SimpleAccount)localObject2);
          localSingleLineTextView.setText(str);
          localObject2 = FaceDrawable.getUserFaceDrawable(this.app, ((SimpleAccount)localObject2).getUin(), (byte)3);
          if ((localObject2 != null) && (localObject3 != null)) {
            ((ImageView)localObject3).setImageDrawable((Drawable)localObject2);
          }
          if (AppSetting.e) {
            ((View)localObject1).setContentDescription(str);
          }
        }
        i += 1;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AssociatedAccountManage", 2, "updateAccountListView mAccountListView is null or size is 0.");
    }
  }
  
  private void updateAccountViewAsDisplayChanged()
  {
    List localList = this.mAccountList;
    if ((localList != null) && (localList.size() > 0))
    {
      this.mAccountTitle.setVisibility(0);
      this.mAccountListView.setVisibility(0);
      this.mDisplayThirdQQCkb.setVisibility(0);
      findViewById(2131431990).setVisibility(0);
      return;
    }
    this.mDisplayThirdQQCkb.setVisibility(8);
    findViewById(2131431990).setVisibility(8);
  }
  
  private void updateSubAccountListView()
  {
    Object localObject1 = this.mSubAccountListView;
    if ((localObject1 != null) && (((LinearLayout)localObject1).getChildCount() > 0))
    {
      int j = this.mSubAccountListView.getChildCount();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateSubAccountListView subaccount size=");
        ((StringBuilder)localObject1).append(j);
        QLog.i("AssociatedAccountManage", 2, ((StringBuilder)localObject1).toString());
      }
      int i = 0;
      while (i < j)
      {
        View localView = this.mSubAccountListView.getChildAt(i);
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)this.mSubAccountList.get(i);
        if (localSubAccountInfo != null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateSubAccountListView i=");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(", view tag=");
            ((StringBuilder)localObject1).append(localSubAccountInfo);
            QLog.i("AssociatedAccountManage", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
          if (i > 0) {
            ((LinearLayout.LayoutParams)localObject1).topMargin = getResources().getDimensionPixelSize(2131296882);
          } else {
            ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
          }
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ImageView localImageView1 = (ImageView)localView.findViewById(2131435219);
          ImageView localImageView2 = (ImageView)localView.findViewById(2131435235);
          SingleLineTextView localSingleLineTextView = (SingleLineTextView)localView.findViewById(2131439121);
          Object localObject2 = ContactUtilsProxy.a((BaseQQAppInterface)this.app, localSubAccountInfo.subuin, false);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localSubAccountInfo.subuin;
          }
          localSingleLineTextView.setText((CharSequence)localObject1);
          localObject2 = FaceDrawable.getUserFaceDrawable(this.app, localSubAccountInfo.subuin, (byte)3);
          if (localObject2 != null) {
            localImageView1.setImageDrawable((Drawable)localObject2);
          }
          if (localSubAccountInfo.status == 1) {
            localImageView2.setBackgroundDrawable(null);
          } else {
            localImageView2.setBackgroundResource(2130852534);
          }
          if (AppSetting.e) {
            localView.setContentDescription((CharSequence)localObject1);
          }
        }
        i += 1;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AssociatedAccountManage", 2, "updateSubAccountListView mSubAccountListView is null or size is 0.");
    }
  }
  
  void deleteAccount(SimpleAccount paramSimpleAccount, boolean paramBoolean)
  {
    if (paramSimpleAccount == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountManage", 2, "deleteAccount account == null");
      }
      return;
    }
    showDelAccountDialog();
    String str = paramSimpleAccount.getUin();
    this.delCurrentUin = str;
    if (TextUtils.equals(str, this.app.getCurrentUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountManage", 2, "deleteAccount error delete current uin");
      }
      return;
    }
    this.mChanged = true;
    delAccountRecord(this.delCurrentUin, paramBoolean);
    HistoryChatMsgSearchKeyUtil.b(str);
    this.mAccountList.remove(paramSimpleAccount);
    ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).clearGestureData(this, paramSimpleAccount.getUin());
    ThreadManager.post(new AssociatedAccountManageActivity.7(this, paramBoolean, str), 8, null, true);
  }
  
  void deleteDataFromSP(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----clear_sp----deleteDataFromSP: uin:");
      localStringBuilder.append(paramString);
      QLog.d("AssociatedAccountManage", 2, localStringBuilder.toString());
    }
    paramString = this.app.getApp().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131629330);
    setContentBackgroundResource(2130838958);
    this.mIsDisplayThirdFuc = SubAccountControllUtil.b(this.app, false);
    if ((getIntent() != null) && (TextUtils.equals(getIntent().getStringExtra("fromWhere"), ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getAccountManagerName()))) {
      this.mIsFromAccountManage = true;
    }
    initUI();
    initSubAccountList();
    initAccountList();
    addObserver(this.fob);
    addObserver(this.avatarObserver);
    addObserver(this.cardObserver);
    addObserver(this.mSubAccountBindObserver);
    this.app.setHandler(getClass(), this.mHandler);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "doOnDestroy");
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
    removeObserver(this.fob);
    removeObserver(this.avatarObserver);
    removeObserver(this.cardObserver);
    removeObserver(this.mSubAccountBindObserver);
    hideDelAccountDialog();
    hideJuhua();
    super.doOnDestroy();
  }
  
  public void hideDelAccountDialog()
  {
    try
    {
      if ((this.mDelAccountDialog != null) && (this.mDelAccountDialog.isShowing()))
      {
        this.mDelAccountDialog.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AssociatedAccountManage", 2, localException.toString());
      }
    }
  }
  
  public void initUI()
  {
    setTitle(2131887081);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131889474);
    this.rightViewText.setOnClickListener(new AssociatedAccountManageActivity.3(this));
    this.mAccountTitle = findViewById(2131427485);
    this.mSubAccountTitle = findViewById(2131446551);
    this.mAccountListView = ((LinearLayout)findViewById(2131427419));
    this.mSubAccountListView = ((LinearLayout)findViewById(2131446505));
    this.leftView.setText(2131887625);
    this.leftView.setVisibility(4);
    this.mDisplayThirdQQCkb = ((FormSwitchItem)findViewById(2131431989));
    setSwitchChecked(SubAccountControllUtil.g(this.app));
    if (AppSetting.e)
    {
      this.mDisplayThirdQQCkb.setContentDescription(getString(2131916865));
      this.leftView.setContentDescription(getString(2131887625));
      this.rightViewText.setContentDescription(getString(2131889474));
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.mChanged) {
      setResult(-1);
    } else {
      setResult(0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBackEvent, finish mChanged = ");
      localStringBuilder.append(this.mChanged);
      QLog.d("AssociatedAccountManage", 2, localStringBuilder.toString());
    }
    boolean bool = super.onBackEvent();
    overridePendingTransition(2130772007, 2130772018);
    return bool;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.mDisplayThirdQQCkb.getSwitch()) {
      if (NetworkUtil.isNetworkAvailable(this))
      {
        ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).setDisplayThirdQQSwitch(this.app, paramBoolean);
        this.mHandler.sendEmptyMessageDelayed(8193, 800L);
      }
      else
      {
        Message localMessage = this.mHandler.obtainMessage(8195);
        localMessage.arg1 = 0;
        localMessage.arg2 = 2131889169;
        this.mHandler.sendMessage(localMessage);
        setSwitchChecked(paramBoolean ^ true);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  void showMenuDialog(SimpleAccount paramSimpleAccount)
  {
    if (paramSimpleAccount == null) {
      return;
    }
    this.menuDialog = ((ActionSheet)ActionSheetHelper.b(this, null));
    String[] arrayOfString = getResources().getStringArray(2130968576);
    int i = 0;
    while (i < arrayOfString.length)
    {
      this.menuDialog.addButton(arrayOfString[i], 1);
      i += 1;
    }
    this.menuDialog.addCancelButton(2131887648);
    this.menuDialog.setOnButtonClickListener(this.onBtnClickLisForDelAccount);
    this.onBtnClickLisForDelAccount.a(paramSimpleAccount);
    paramSimpleAccount = getString(2131897866).replace("${account}", paramSimpleAccount.getUin());
    this.menuDialog.setMainTitle(paramSimpleAccount);
    if (!this.menuDialog.isShowing()) {
      this.menuDialog.show();
    }
  }
  
  void showUnbindMenuDialog(SubAccountInfo paramSubAccountInfo)
  {
    if (paramSubAccountInfo == null) {
      return;
    }
    this.menuUnbindDialog = ((ActionSheet)ActionSheetHelper.b(this, null));
    String[] arrayOfString = getResources().getStringArray(2130968673);
    int i = 0;
    while (i < arrayOfString.length)
    {
      this.menuUnbindDialog.addButton(arrayOfString[i], 3);
      i += 1;
    }
    this.menuUnbindDialog.addCancelButton(2131887648);
    this.menuUnbindDialog.setOnButtonClickListener(this.onBtnClickLisForUnbind);
    this.onBtnClickLisForUnbind.a(paramSubAccountInfo);
    this.menuUnbindDialog.setMainTitle(getString(2131917712));
    if (!this.menuUnbindDialog.isShowing()) {
      this.menuUnbindDialog.show();
    }
  }
  
  void unbindAccount(SubAccountInfo paramSubAccountInfo)
  {
    if (paramSubAccountInfo != null)
    {
      if (TextUtils.isEmpty(paramSubAccountInfo.subuin)) {
        return;
      }
      if (!isNetConnToast()) {
        return;
      }
      this.mChanged = true;
      showJuhua(2131916903);
      SubAccountProtocServiceImpl localSubAccountProtocServiceImpl = (SubAccountProtocServiceImpl)this.app.getRuntimeService(ISubAccountProtocService.class, "");
      if (localSubAccountProtocServiceImpl != null) {
        localSubAccountProtocServiceImpl.unBindAccount(paramSubAccountInfo.subuin);
      }
    }
  }
  
  void updateFace(String paramString, View paramView)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramView == null) {
        return;
      }
      runOnUiThread(new AssociatedAccountManageActivity.10(this, paramString, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity
 * JD-Core Version:    0.7.0.1
 */