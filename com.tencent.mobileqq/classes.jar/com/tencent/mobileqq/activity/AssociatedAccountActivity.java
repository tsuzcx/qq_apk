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
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.adapter.AssociatedAccountListAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.SubAccountConfigBean;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.AssociatedAccountListItemData;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountServlet;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AssociatedAccountActivity
  extends SubAccountBaseActivity
  implements Observer
{
  public int a;
  public long a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AssociatedAccountActivity.11(this);
  public View a;
  public AssociatedAccountListAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new AssociatedAccountActivity.13(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AssociatedAccountActivity.15(this);
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new AssociatedAccountActivity.14(this);
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new AssociatedAccountActivity.12(this);
  public SubAccountInfo a;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public PullRefreshHeader a;
  public SlideDetectListView a;
  public HorizontalListView a;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new AssociatedAccountActivity.16(this);
  public String a;
  public ArrayList<SubAccountInfo> a;
  public MqqHandler a;
  public boolean a;
  public int b;
  public AssociatedAccountListAdapter b;
  public ArrayList<SimpleAccount> b;
  public boolean b;
  public ArrayList<AssociatedAccountListItemData> c;
  public boolean c;
  public ArrayList<AssociatedAccountListItemData> d;
  public boolean d;
  public boolean e = true;
  public boolean f = true;
  public boolean g = false;
  public boolean h = true;
  private boolean i = false;
  
  public AssociatedAccountActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  }
  
  private void a(SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    int j;
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      paramSubAccountThirdQQBackProtocData = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      for (j = 0; paramSubAccountThirdQQBackProtocData.hasNext(); j = 1)
      {
        label27:
        AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)paramSubAccountThirdQQBackProtocData.next();
        if ((localAssociatedAccountListItemData == null) || (localAssociatedAccountListItemData.jdField_a_of_type_Int != 6) || (localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject == null)) {
          break label27;
        }
        SimpleAccount localSimpleAccount = (SimpleAccount)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
        int k = SubAccountControll.a(this.app, localSimpleAccount.getUin());
        if (localAssociatedAccountListItemData.jdField_d_of_type_Int == k) {
          break label139;
        }
        localAssociatedAccountListItemData.jdField_d_of_type_Int = k;
      }
    }
    label139:
    for (;;)
    {
      break;
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "updateThirdQQUnread changed");
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter.notifyDataSetChanged();
      }
      return;
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchAccount to Uin = " + paramString);
    }
    if (paramString == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new ArrayList();
      localObject2 = this.app.getApplication().getAllAccounts();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    } while (((List)localObject1).size() < 1);
    Object localObject2 = ((List)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (SimpleAccount)((Iterator)localObject2).next();
    } while (!((SimpleAccount)localObject1).getUin().equalsIgnoreCase(paramString));
    for (;;)
    {
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "switchAccount change ");
        }
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_d_of_type_Boolean = true;
        sendBroadcast(new Intent("before_account_change"));
        this.app.switchAccount((SimpleAccount)localObject1, null);
        SubAccountAssistantForward.a(this.app, this);
        AlbumUtil.b();
        return;
      }
      e();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AssociatedAccountActivity", 2, "switchAccount no change ");
      return;
      localObject1 = null;
    }
  }
  
  private void a(boolean paramBoolean, float paramFloat)
  {
    if (this.rightViewText != null)
    {
      this.rightViewText.setEnabled(paramBoolean);
      this.rightViewText.setAlpha(paramFloat);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanOneSubAccountMessagesUnread");
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          this.app.getMessageFacade().c(paramString, 7000);
          if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
              if (paramString.equals(localSimpleAccount.getUin()))
              {
                SubAccountControll.a(this.app, localSimpleAccount);
                return;
              }
            }
          }
        } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    } while (!paramString.equals(((SubAccountInfo)((Iterator)localObject).next()).subuin));
    Object localObject = this.app;
    if ((paramBoolean) || (this.jdField_b_of_type_Int > 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      SubAccountControll.a((QQAppInterface)localObject, paramBoolean, null, paramString);
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "getDataList needChangeReaded = " + paramBoolean1 + " isRefresh = " + paramBoolean2);
    }
    if (paramBoolean2) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_c_of_type_Boolean = false;
    }
    a(paramBoolean1);
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      if ((System.currentTimeMillis() - this.jdField_a_of_type_Long >= 30000L) || (!paramBoolean2)) {
        break label220;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AssociatedAccountActivity.4(this), 800L);
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "getDataList current-last<30000ms, startGetThirdQQUnreadNum be ignored.");
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AssociatedAccountActivity.5(this), 800L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "getDataList mPullReqNeedBackNum = " + this.jdField_a_of_type_Int);
      }
      return;
      label220:
      paramBoolean1 = SubAccountControll.a(this.app, false);
      if ((this.jdField_b_of_type_Boolean) && (paramBoolean1)) {
        this.jdField_a_of_type_Int += 1;
      }
      if (paramBoolean2) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  private boolean a(String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    return (TextUtils.isEmpty(paramString)) || (isFinishing()) || (paramSubAccountBackProtocData == null);
  }
  
  private boolean a(String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    return (isFinishing()) || (paramSubAccountThirdQQBackProtocData == null) || (this.app == null) || (!TextUtils.equals(paramString, this.app.getCurrentUin()));
  }
  
  private void b(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanMessagesUnreadAsync");
    }
    ThreadManager.post(new AssociatedAccountActivity.8(this, paramBoolean, paramString), 8, null, true);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "onRefreshRequestBack() mPullReqNeedBackNum = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int -= 1;
    if ((paramBoolean1) && (!this.jdField_c_of_type_Boolean)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Int <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "onRefreshRequestBack() end");
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Boolean = false;
      PullRefreshHeader localPullRefreshHeader = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (this.jdField_c_of_type_Boolean) {
        j = 0;
      }
      localPullRefreshHeader.a(j);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AssociatedAccountActivity.10(this), 800L);
      if (this.jdField_c_of_type_Boolean) {
        c();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "refreshAllData direct=" + paramBoolean);
    }
    if (isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      a();
      c();
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new AssociatedAccountActivity.3(this));
  }
  
  private void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "showSettingDialog underTwo = " + paramBoolean);
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (paramBoolean) {
      localActionSheet.addButton(getResources().getString(2131719564), 5);
    }
    localActionSheet.addButton(getResources().getString(2131720347), 5);
    localActionSheet.addButton(getResources().getString(2131719567), 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new AssociatedAccountActivity.9(this, paramBoolean, localActionSheet));
    localActionSheet.show();
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "initUI");
    }
    setTitle(2131690262);
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131719566);
    localTextView.setOnClickListener(new AssociatedAccountActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364156));
    if (this.i)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      k();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssociatedAccountActivity.2(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131378651));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131379293);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131379292));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(AIOUtils.a(22.0F, getResources()));
      if (AppSetting.jdField_d_of_type_Boolean) {
        localTextView.setContentDescription(getText(2131719566));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559765, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setBackgroundResource(2130838979);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "initData");
    }
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter = new AssociatedAccountListAdapter(this.app, this.jdField_d_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter);
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter = new AssociatedAccountListAdapter(this.app, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter);
    a();
    c();
  }
  
  private void j()
  {
    this.jdField_b_of_type_Int = 0;
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (localSubAccountManager.c(((SubAccountInfo)localIterator.next()).subuin) > 0) {
        this.jdField_b_of_type_Int += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "checkNeed2ConfirmMsgNum mNeed2ConfirmMsgNum = " + this.jdField_b_of_type_Int);
    }
  }
  
  private void k()
  {
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.leftView == null) || (this.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter == null) || (this.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter == null)) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter.notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter.notifyDataSetChanged();
      if (this.leftView != null) {
        this.leftView.setText("");
      }
      j();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchFail");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    f();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131719592)).setMessage(getString(2131719591));
    localQQCustomDialog.setPositiveButton(2131691144, new AssociatedAccountActivity.7(this));
    localQQCustomDialog.setCancelable(true);
    localQQCustomDialog.show();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "gotoManageAssociatedAccount");
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, AssociatedAccountManageActivity.class);
    if (this.g) {
      localIntent.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    }
    startActivityForResult(localIntent, 1012);
    overridePendingTransition(2130771999, 2130771992);
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "bindNewSubAccount currentUin=" + this.app.getCurrentUin());
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (localObject2 != null) {
      ((List)localObject1).addAll(((SubAccountManager)localObject2).a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "bindNewSubAccount binded = " + ((List)localObject1).size());
    }
    Intent localIntent;
    if (((List)localObject1).size() < 2)
    {
      localIntent = new Intent();
      localObject2 = new ArrayList();
      Object localObject3 = this.app.getApplication().getAllAccounts();
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        ((List)localObject2).addAll((Collection)localObject3);
      }
      localObject2 = ((List)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (SimpleAccount)((Iterator)localObject2).next();
      } while ((localObject3 == null) || (TextUtils.equals(((SimpleAccount)localObject3).getUin(), this.app.getCurrentUin())) || (((List)localObject1).contains(((SimpleAccount)localObject3).getUin())));
    }
    for (localObject1 = SubAccountBindActivity.class;; localObject1 = SubLoginActivity.class)
    {
      localIntent.setClass(this, (Class)localObject1);
      localObject2 = this.jdField_b_of_type_JavaLangString;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = AssociatedAccountActivity.class.getSimpleName();
      }
      localIntent.putExtra("fromWhere", (String)localObject1);
      startActivity(localIntent);
      return;
      SubAccountControll.a(this.app, this);
      return;
    }
  }
  
  private void p()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    localActionSheet.setMainTitle(2131720348);
    localActionSheet.addButton(2131694615, 3);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new AssociatedAccountActivity.17(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "loadAccountList");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(((SubAccountManager)localObject).b());
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "loadAccountList mSubAccountList.size() = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      localObject = this.app.getApplication().getAllAccounts();
      a((List)localObject);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) && (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) && ((this.f) || (localObject == null) || (((List)localObject).size() <= 1))) {
        break label175;
      }
      a(true, 1.0F);
    }
    for (;;)
    {
      b();
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      break;
      label175:
      a(false, 0.5F);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      paramQQAppInterface.d(((SubAccountInfo)localIterator.next()).subuin);
    }
    b(true);
    c(paramString);
    c();
  }
  
  public void a(List<SimpleAccount> paramList)
  {
    label157:
    SimpleAccount localSimpleAccount;
    int j;
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, new Object[] { "loadAccountList mThirdAccountList.mIsDisplayThirdFuc = ", Boolean.valueOf(this.e), " mIsFromAccountManage=", Boolean.valueOf(this.g), " mIsDisplayThirdQQChecked=", Boolean.valueOf(this.f) });
      }
      if ((!this.e) || (this.g) || (!this.f)) {
        break label318;
      }
      Object localObject = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        ((List)localObject).addAll(paramList);
      }
      if (((List)localObject).size() <= 0) {
        break label280;
      }
      paramList = this.app.getAccount();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
          if ((localSimpleAccount != null) && (!paramList.equals(localSimpleAccount.getUin())))
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            j = 0;
            label205:
            if (localIterator.hasNext())
            {
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
              if ((localSubAccountInfo == null) || (!localSimpleAccount.getUin().equals(localSubAccountInfo.subuin))) {
                break label319;
              }
              j = 1;
            }
          }
        }
      }
    }
    label280:
    label318:
    label319:
    for (;;)
    {
      break label205;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      break;
      if (j != 0) {
        break label157;
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(localSimpleAccount);
      break label157;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "loadAccountList mThirdAccountList.size() = " + this.jdField_b_of_type_JavaUtilArrayList.size());
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
      if (localSubAccountManager != null)
      {
        if (paramBoolean) {
          localSubAccountManager.b(localSubAccountInfo.subuin);
        }
        localSubAccountManager.g(localSubAccountInfo.subuin);
      }
      SubAccountControll.a(this.app, localSubAccountInfo.subuin, false);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Int += 1;
      }
      SubAccountConfigBean localSubAccountConfigBean = (SubAccountConfigBean)QConfigManager.a().a(607);
      if ((localSubAccountConfigBean != null) && (!localSubAccountConfigBean.jdField_a_of_type_Boolean)) {
        SubAccountServlet.a(this.app, localSubAccountInfo.subuin);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    if (this.jdField_d_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (this.jdField_d_of_type_JavaUtilArrayList.size() > 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            SubAccountManager localSubAccountManager = null;
            j = 0;
            bool1 = false;
            if (j < this.jdField_d_of_type_JavaUtilArrayList.size())
            {
              Object localObject = (AssociatedAccountListItemData)this.jdField_d_of_type_JavaUtilArrayList.get(j);
              if ((((AssociatedAccountListItemData)localObject).jdField_a_of_type_Int == 2) && (((AssociatedAccountListItemData)localObject).jdField_a_of_type_JavaLangObject != null) && ((((AssociatedAccountListItemData)localObject).jdField_a_of_type_JavaLangObject instanceof ArrayList)))
              {
                if (localSubAccountManager != null) {
                  break label269;
                }
                localSubAccountManager = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
                label128:
                bool2 = bool1;
                if (localSubAccountManager == null) {
                  break label275;
                }
                localObject = ((ArrayList)((AssociatedAccountListItemData)localObject).jdField_a_of_type_JavaLangObject).iterator();
                bool2 = bool1;
                if (!((Iterator)localObject).hasNext()) {
                  break label275;
                }
                AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)((Iterator)localObject).next();
                int k = localSubAccountManager.a(((SubAccountInfo)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject).subuin);
                if (((k != 1) || (localAssociatedAccountListItemData.e == 0)) && ((k == 1) || (localAssociatedAccountListItemData.e != 0))) {
                  break label272;
                }
                if (k == 1) {}
                for (localAssociatedAccountListItemData.e = 0;; localAssociatedAccountListItemData.e = 1)
                {
                  bool1 = true;
                  label230:
                  break;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if ((bool1) && (this.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter != null)) {
        this.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter.notifyDataSetChanged();
      }
      return bool1;
      label269:
      break label128;
      label272:
      break label230;
      label275:
      bool1 = bool2;
    }
  }
  
  public void b()
  {
    Object localObject = getIntent();
    String str;
    if (localObject != null)
    {
      str = ((Intent)localObject).getStringExtra("subAccount");
      ((Intent)localObject).removeExtra("subAccount");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          if (!TextUtils.isEmpty(str))
          {
            localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)((Iterator)localObject).next();
              if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(str))) {
                this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = localSubAccountInfo;
              }
            }
          }
        }
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = null;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) {
            this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = ((SubAccountInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
          }
          return;
          this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = null;
          return;
        }
      }
      str = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "cleanMessagesUnread");
    }
    if (((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) || (this.g)) {
      SubAccountControll.c(this.app);
    }
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.app.getMessageFacade().c(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
      localQQAppInterface = this.app;
      if ((!paramBoolean) && (this.jdField_b_of_type_Int <= 0)) {
        break label105;
      }
    }
    label105:
    for (paramBoolean = true;; paramBoolean = false)
    {
      SubAccountControll.a(localQQAppInterface, paramBoolean, null);
      return;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "loadItemDataList");
    }
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3;
    Object localObject4;
    Object localObject1;
    boolean bool1;
    ArrayList localArrayList2;
    int j;
    SubAccountInfo localSubAccountInfo;
    boolean bool2;
    AssociatedAccountListItemData localAssociatedAccountListItemData;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject3 = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      int m = this.jdField_a_of_type_JavaUtilArrayList.size();
      localObject4 = new ArrayList();
      localObject1 = this.app.getApplication().getAllAccounts();
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        ((List)localObject4).addAll((Collection)localObject1);
      }
      bool1 = false;
      localArrayList2 = new ArrayList(m);
      j = 0;
      for (;;)
      {
        if (j < m)
        {
          localSubAccountInfo = (SubAccountInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          bool2 = bool1;
          if (localSubAccountInfo != null)
          {
            if (TextUtils.isEmpty(localSubAccountInfo.subuin)) {
              bool2 = bool1;
            }
          }
          else
          {
            j += 1;
            bool1 = bool2;
            continue;
          }
          localAssociatedAccountListItemData = new AssociatedAccountListItemData();
          localAssociatedAccountListItemData.jdField_a_of_type_Int = 2;
          localObject2 = ContactUtils.d(this.app, localSubAccountInfo.subuin, true);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localSubAccountInfo.subuin;
          }
          localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString = ((String)localObject1);
          localAssociatedAccountListItemData.jdField_c_of_type_JavaLangString = localSubAccountInfo.subuin;
          localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject = localSubAccountInfo;
          localAssociatedAccountListItemData.jdField_b_of_type_JavaLangString = "";
          if (localSubAccountInfo.subuin.equals(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin))
          {
            localAssociatedAccountListItemData.jdField_b_of_type_Boolean = true;
            label276:
            if (localSubAccountInfo.status == 1) {
              break label457;
            }
            localAssociatedAccountListItemData.e = 1;
            localObject1 = ((List)localObject4).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (SimpleAccount)((Iterator)localObject1).next();
            } while ((localObject2 == null) || (!TextUtils.equals(localSubAccountInfo.subuin, ((SimpleAccount)localObject2).getUin())) || (!((SimpleAccount)localObject2).isLogined()));
          }
        }
      }
    }
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        localAssociatedAccountListItemData.jdField_a_of_type_Boolean = true;
        label363:
        localAssociatedAccountListItemData.jdField_b_of_type_Int = 0;
        if (AppSetting.jdField_d_of_type_Boolean) {
          localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString = getString(2131719573, new Object[] { localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString });
        }
        if (!localSubAccountInfo.subuin.equals(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)) {
          break label914;
        }
        bool1 = localAssociatedAccountListItemData.jdField_a_of_type_Boolean;
      }
      label914:
      for (;;)
      {
        localArrayList2.add(localAssociatedAccountListItemData);
        bool2 = bool1;
        break;
        localAssociatedAccountListItemData.jdField_b_of_type_Boolean = false;
        break label276;
        localAssociatedAccountListItemData.jdField_a_of_type_Boolean = false;
        break label363;
        label457:
        localAssociatedAccountListItemData.e = 0;
        break label363;
        localObject1 = new AssociatedAccountListItemData();
        ((AssociatedAccountListItemData)localObject1).jdField_a_of_type_Int = 2;
        ((AssociatedAccountListItemData)localObject1).jdField_a_of_type_JavaLangObject = localArrayList2;
        ((AssociatedAccountListItemData)localObject1).jdField_b_of_type_JavaLangString = "";
        localArrayList1.add(localObject1);
        localObject1 = ((SubAccountManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          k = ((List)localObject1).size();
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "loadItemDataList subaccount msg msgSize = " + k);
          }
          if (k > 0)
          {
            localObject2 = SubAccountControll.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
            j = 0;
            if (j < k)
            {
              localObject3 = (SubAccountMessage)((List)localObject1).get(j);
              localObject4 = new AssociatedAccountListItemData();
              ((AssociatedAccountListItemData)localObject4).jdField_a_of_type_Int = 3;
              if (j == k - 1) {}
              for (((AssociatedAccountListItemData)localObject4).jdField_b_of_type_Int = 2;; ((AssociatedAccountListItemData)localObject4).jdField_b_of_type_Int = 1)
              {
                if ((localObject2 != null) && (((ArrayList)localObject2).contains(((SubAccountMessage)localObject3).senderuin))) {
                  ((AssociatedAccountListItemData)localObject4).jdField_c_of_type_Int = 2;
                }
                if (j == 0) {
                  ((AssociatedAccountListItemData)localObject4).jdField_b_of_type_Boolean = true;
                }
                ((AssociatedAccountListItemData)localObject4).jdField_a_of_type_JavaLangObject = localObject3;
                localArrayList1.add(localObject4);
                j += 1;
                break;
              }
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "loadItemDataList subaccount no msg");
          }
          localObject1 = new AssociatedAccountListItemData();
          ((AssociatedAccountListItemData)localObject1).jdField_a_of_type_Int = 7;
          ((AssociatedAccountListItemData)localObject1).jdField_b_of_type_Boolean = true;
          ((AssociatedAccountListItemData)localObject1).jdField_b_of_type_Int = 3;
          ((AssociatedAccountListItemData)localObject1).jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
          ((AssociatedAccountListItemData)localObject1).jdField_a_of_type_Boolean = bool1;
          localArrayList1.add(localObject1);
        }
        for (;;)
        {
          this.jdField_d_of_type_JavaUtilArrayList.clear();
          this.jdField_d_of_type_JavaUtilArrayList.addAll(localArrayList1);
          d();
          l();
          return;
          localObject1 = new AssociatedAccountListItemData();
          ((AssociatedAccountListItemData)localObject1).jdField_a_of_type_Int = 4;
          ((AssociatedAccountListItemData)localObject1).jdField_b_of_type_Int = 3;
          ((AssociatedAccountListItemData)localObject1).jdField_a_of_type_JavaLangString = getResources().getString(2131719564);
          ((AssociatedAccountListItemData)localObject1).jdField_c_of_type_JavaLangString = getResources().getString(2131719565);
          if (AppSetting.jdField_d_of_type_Boolean)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((AssociatedAccountListItemData)localObject1).jdField_a_of_type_JavaLangString).append(",");
            ((StringBuilder)localObject2).append(((AssociatedAccountListItemData)localObject1).jdField_c_of_type_JavaLangString);
            ((AssociatedAccountListItemData)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
          }
          localArrayList1.add(localObject1);
        }
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilArrayList.size());
      int k = this.jdField_b_of_type_JavaUtilArrayList.size();
      int j = 0;
      while (j < k)
      {
        Object localObject = (SimpleAccount)this.jdField_b_of_type_JavaUtilArrayList.get(j);
        AssociatedAccountListItemData localAssociatedAccountListItemData = new AssociatedAccountListItemData();
        localAssociatedAccountListItemData.jdField_a_of_type_Int = 6;
        localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString = SubAccountControll.a(this.app, (SimpleAccount)localObject);
        localAssociatedAccountListItemData.jdField_d_of_type_Int = SubAccountControll.a(this.app, ((SimpleAccount)localObject).getUin());
        localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject = localObject;
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString);
          localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject).toString();
        }
        localArrayList.add(localAssociatedAccountListItemData);
        j += 1;
      }
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      this.jdField_c_of_type_JavaUtilArrayList.addAll(localArrayList);
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnActivityResult requestCode = " + paramInt1 + " resultCode=" + paramInt2);
    }
    switch (paramInt1)
    {
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      finish();
      return;
      bool = SubAccountControll.d(this.app);
    } while ((paramInt2 != -1) && (this.f == bool));
    this.f = bool;
    c(true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563057);
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnCreate");
    }
    this.i = SettingsConfigHelper.a(this.app);
    this.e = SubAccountControll.b(this.app, true);
    this.f = SubAccountControll.d(this.app);
    if ((getIntent() != null) && (TextUtils.equals(getIntent().getStringExtra("fromWhere"), AccountManageActivity.class.getSimpleName()))) {
      this.g = true;
    }
    h();
    i();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.getMessageFacade().addObserver(this);
    sendBroadcast(new Intent("before_account_change"));
    SubAccountAssistantForward.b(this.app);
    SubAccountAssistantForward.a(this.app);
    SubAccountAssistantForward.c(this.app);
    if (b()) {
      a(false, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    paramBundle = this.app;
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.g) {}
    for (int j = 1;; j = 0)
    {
      ReportController.b(paramBundle, "dc00898", "", "", "0X800AC3B", "0X800AC3B", 0, 0, j + "", "", "", "");
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnDestroy");
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.removeHandler(getClass());
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverscrollHeader(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(null);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnPause");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "doOnResume");
    }
    e();
    if (!this.h) {
      a();
    }
    this.h = false;
  }
  
  public void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onAccountChanged() mClick2Switch=" + this.jdField_d_of_type_Boolean);
    }
    super.onAccountChanged();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    if ((this.app != null) && (this.app.getMessageFacade() != null)) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if ((!this.jdField_d_of_type_Boolean) || (this.app != null))
    {
      this.app.removeHandler(getClass());
      this.app.getApplication().refreAccountList();
    }
    SubAccountAssistantForward.a(this.app, this);
    e();
    this.jdField_a_of_type_JavaLangString = null;
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  public void onAccoutChangeFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onAccoutChangeFailed");
    }
    e();
    m();
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onBackEvent");
    }
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (!this.g)) {
      SubAccountControll.c(this.app);
    }
    this.app.getMessageFacade().c(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
    if (!this.g)
    {
      Intent localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
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
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "update()");
    }
    if ((paramObject instanceof MessageRecord)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof String[]));
      paramObservable = (String[])paramObject;
    } while ((paramObservable.length != 2) || (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramObservable[0])));
    runOnUiThread(new AssociatedAccountActivity.18(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity
 * JD-Core Version:    0.7.0.1
 */