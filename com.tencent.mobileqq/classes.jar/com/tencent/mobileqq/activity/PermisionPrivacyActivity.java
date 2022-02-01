package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionListener;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionParam;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.inputstatus.InputStatusConfig.Config;
import com.tencent.mobileqq.inputstatus.InputStatusObserver;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterConfig;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.Switch;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.os.MqqHandler;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, PermissionListener, PhoneContactManager.IPhoneContactListener
{
  private int jdField_a_of_type_Int = -1;
  View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new PermisionPrivacyActivity.16(this);
  CompoundButton jdField_a_of_type_AndroidWidgetCompoundButton = null;
  protected TextView a;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new PermisionPrivacyActivity.13(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new PermisionPrivacyActivity.10(this);
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new PermisionPrivacyActivity.12(this);
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new PermisionPrivacyActivity.9(this);
  protected TroopHandler a;
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new PermisionPrivacyActivity.8(this);
  InputStatusObserver jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver = new PermisionPrivacyActivity.11(this);
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new PermisionPrivacyActivity.17(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  protected BounceScrollView a;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected QQProgressNotifier a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  private CompoundButton jdField_b_of_type_AndroidWidgetCompoundButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  View jdField_c_of_type_AndroidViewView;
  private CompoundButton jdField_c_of_type_AndroidWidgetCompoundButton;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSimpleItem f;
  protected FormSwitchItem f;
  private FormSimpleItem jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSimpleItem jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchItem i;
  FormSwitchItem j;
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.security", 2, "gotoFriendSettingBrowser context:" + paramContext);
    }
    if (paramContext == null) {}
    while (!QQBrowserActivity.checkNotFrequentlyThenEnter(1000L)) {
      return;
    }
    paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private boolean a()
  {
    try
    {
      InputStatusConfig.Config localConfig = (InputStatusConfig.Config)QConfigManager.a().a(445);
      if (localConfig != null)
      {
        boolean bool = localConfig.jdField_a_of_type_Boolean;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Q.security", 1, localException, new Object[0]);
    }
    return false;
  }
  
  private void b()
  {
    boolean bool2 = true;
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363139));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363140));
    boolean bool1 = SharedPreUtils.c(this, this.app.getCurrentAccountUin());
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setChecked(bool1);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    int k;
    label311:
    Object localObject2;
    if (bool1)
    {
      k = 2131693105;
      ((TextView)localObject1).setText(k);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.d();
      this.jdField_c_of_type_AndroidViewView = findViewById(2131375562);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131374780);
      ReportController.b(null, "dc00898", "", "", "0X800B1B1", "0X800B1B1", 0, 0, "", "", "", "");
      this.jdField_b_of_type_AndroidViewView = findViewById(2131374773);
      ReportController.b(null, "dc00898", "", "", "0X800B1AF", "0X800B1AF", 0, 0, "", "", "", "");
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373235));
      g();
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374803));
      localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (!VipUtils.a(this.app)) {
        break label1484;
      }
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(2);
      ((LinearLayout.LayoutParams)this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams()).bottomMargin = 0;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131699173));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new PermisionPrivacyActivity.1(this));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374817));
      localObject2 = (ContactSyncManager)this.app.getManager(QQManagerFactory.MGR_SYNC_CONTACT);
      if (!((ContactSyncManager)localObject2).b()) {
        break label1504;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((ContactSyncManager)localObject2).a());
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      label371:
      this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131377967));
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131378449));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378060));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.getVisibilityForNetWorkStatus(false));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131378056));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.getVisibilityForInputStatus(false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131372144));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131362697));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364321));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131379908));
      localObject2 = (TroopLuckyCharacterConfig)QConfigManager.a().a(696);
      if (localObject2 != null) {
        this.jdField_a_of_type_Boolean = ((TroopLuckyCharacterConfig)localObject2).a();
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label1516;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131720160));
      ReportController.b(null, "dc00898", "", "", "0X800B60A", "0X800B60A", 0, 0, "", "0", "0", "");
      label595:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131372858));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372859));
      localObject1 = ((FriendsManager)localObject1).b(this.app.getCurrentAccountUin());
      if (!((Card)localObject1).allowClick) {
        break label1533;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label661:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).allowPeopleSee);
      if (((Card)localObject1).allowCalInteractive) {
        break label1554;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(HardCodeUtil.a(2131699151));
      label694:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374787));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      c();
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374789));
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      ReportController.b(null, "dc00898", "", "", "0X800ACA5", "0X800ACA5", 0, 0, "", "0", "0", "");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374782));
      d();
      localObject2 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
      if (localObject2 != null)
      {
        ((TempGetProfileDetailProcessor)localObject2).getLoginDaysSwitch();
        ((TempGetProfileDetailProcessor)localObject2).getCalReactiveSwitch();
      }
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374785));
      localObject2 = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b())) {
        break label1570;
      }
      bool1 = true;
      label862:
      ((FormSwitchItem)localObject2).setChecked(bool1);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      a(this.app.getLocVisibilityForStatus());
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setChecked(this.app.getLocZanAllowedForStatus());
      bool1 = this.app.getLocZanAllowedForPeople();
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool1);
      a(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), ((Card)localObject1).strangerInviteMeGroupOpen);
      this.jdField_b_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131363137));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.i = ((FormSwitchItem)super.findViewById(2131371105));
      if (SharedPreUtils.X(getApplication(), this.app.getCurrentAccountUin()) == 1)
      {
        this.i.setVisibility(0);
        ThreadManager.post(new PermisionPrivacyActivity.2(this), 5, null, true);
        this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      }
      localObject2 = (FormSimpleItem)findViewById(2131365512);
      if ((localObject2 == null) || (!CustomOnlineStatusManager.a().a())) {
        break label1575;
      }
      ((FormSimpleItem)localObject2).setLeftText(getResources().getString(2131691397));
      ((FormSimpleItem)localObject2).a().setMaxWidth(AIOUtils.a(130.0F, getResources()));
      ((FormSimpleItem)localObject2).setOnClickListener(new PermisionPrivacyActivity.3(this));
      PermisionPrivacyActivity.4 local4 = new PermisionPrivacyActivity.4(this, (FormSimpleItem)localObject2);
      local4.run();
      ((FormSimpleItem)localObject2).setTag("online_status_callback".hashCode(), local4);
      CustomOnlineStatusManager.a().a(local4);
      label1256:
      if (AppSetting.d)
      {
        this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131699116));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131707905));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("可通过系统通讯录发起QQ聊天");
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707900));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707898));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131694456));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131690070));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707899));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707901));
      }
      localObject2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!a()) {
        break label1590;
      }
      k = 0;
      label1403:
      ((FormSwitchItem)localObject2).setVisibility(k);
      ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).d();
      this.j = ((FormSwitchItem)findViewById(2131378076));
      localObject2 = this.j;
      if (((Card)localObject1).isHidePrettyGroutIdentity) {
        break label1596;
      }
    }
    label1554:
    label1570:
    label1575:
    label1590:
    label1596:
    for (bool1 = bool2;; bool1 = false)
    {
      ((FormSwitchItem)localObject2).setChecked(bool1);
      this.j.setOnCheckedChangeListener(new PermisionPrivacyActivity.5(this));
      return;
      k = 2131693106;
      break;
      label1484:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(3);
      break label311;
      label1504:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label371;
      label1516:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131720161));
      break label595;
      label1533:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label661;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(HardCodeUtil.a(2131699152));
      break label694;
      bool1 = false;
      break label862;
      if (localObject2 == null) {
        break label1256;
      }
      ((FormSimpleItem)localObject2).setVisibility(8);
      break label1256;
      k = 8;
      break label1403;
    }
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.security", 2, "gotoFriendFindMeSettingBrowser context:" + paramContext);
    }
    if (paramContext == null) {}
    while (!QQBrowserActivity.checkNotFrequentlyThenEnter(1000L)) {
      return;
    }
    paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendshipauth/find?_wv=3&_bid=173"));
  }
  
  private void b(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new PermisionPrivacyActivity.14(this, paramBoolean));
  }
  
  private void c()
  {
    ThreadManager.excute(new PermisionPrivacyActivity.6(this), 16, null, true);
  }
  
  private void d()
  {
    if ((this.app != null) && (FriendIntimateRelationshipHelper.a(this.app.getCurrentUin())))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      ReportController.b(this.app, "dc00898", "", "", "0X8009F73", "0X8009F73", 0, 0, "", "", "", "");
      e();
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void d(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  private void e()
  {
    if ((isFinishing()) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() != 0)) {
      return;
    }
    ThreadManager.excute(new PermisionPrivacyActivity.7(this), 16, null, true);
  }
  
  private void f()
  {
    if (NetworkUtil.g(this)) {
      ((SVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(this.app.getCurrentAccountUin(), true, 257);
    }
  }
  
  private void g()
  {
    Object localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.app.getCurrentUin());
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = VipGrayConfigHelper.a().a(this.app.getCurrentUin(), ((Card)localObject2).namePlateOfKingGameId, ((Card)localObject2).namePlateOfKingDan, ((Card)localObject2).namePlateOfKingDanDisplatSwitch, true);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    localObject2 = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0);
    if (!bool)
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, new ColorDrawable(), new ColorDrawable());
      if (((URLDrawable)localObject1).getStatus() == 1)
      {
        ((URLDrawable)localObject1).setBounds(0, 0, UIUtils.a(this.app.getApp(), 47.0F), UIUtils.a(this.app.getApp(), 14.0F));
        ((URLDrawable)localObject1).setURLDrawableListener(new PermisionPrivacyActivity.18(this));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject1, UIUtils.a(this.app.getApp(), 47.0F), UIUtils.a(this.app.getApp(), 14.0F));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new PermisionPrivacyActivity.19(this, (SharedPreferences)localObject2, bool));
      return;
      ((URLDrawable)localObject1).restartDownload();
      ((URLDrawable)localObject1).setBounds(0, 0, 1, 1);
      break;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131694929));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
  }
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt) {}
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public void a(long paramLong) {}
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, PermissionParam paramPermissionParam)
  {
    paramPermissionParam.a(paramBoolean);
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
  
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
    if (paramInt1 == 1) {
      c();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    super.setContentView(2131561619);
    setTitle(2131699148);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
    b();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    this.app.getVisibilitySwitches();
    this.app.getZanSwitches();
    this.app.getVisibilityForNetWorkStatus(true);
    this.app.getVisibilityForInputStatus(true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    g();
    f();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    int k;
    BounceScrollView localBounceScrollView;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131377555));
      if (!TextUtils.isEmpty(getIntent().getStringExtra("scrollflag")))
      {
        k = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.getTop() - UIUtils.d(this) / 2;
        localBounceScrollView = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
        if (k <= 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      localBounceScrollView.scrollTo(0, k);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130850774);
      ThreadManager.getUIHandler().postDelayed(new PermisionPrivacyActivity.15(this), 1000L);
      return;
      label98:
      k = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(this);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B1B2", "0X800B1B2", 0, 0, "", "", "", "");
      continue;
      b(this);
      ReportController.b(null, "dc00898", "", "", "0X800B1B0", "0X800B1B0", 0, 0, "", "", "", "");
      continue;
      Object localObject1 = QZoneHelper.UserInfo.getInstance();
      ((QZoneHelper.UserInfo)localObject1).qzone_uin = this.app.getCurrentAccountUin();
      ((QZoneHelper.UserInfo)localObject1).nickname = this.app.getCurrentNickname();
      QZoneHelper.forwardToPermissionSetting(this, (QZoneHelper.UserInfo)localObject1, -1);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
      continue;
      ReportController.b(this.app, "dc00898", "", "", "0X8009F72", "0X8009F72", 0, 0, "", "", "", "");
      localObject1 = FriendIntimateRelationshipHelper.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.security", 2, "click qq_setting_intimate_relationship url:" + (String)localObject1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", (String)localObject1));
        continue;
        ReportController.b(this.app, "CliOper", "", "", "0X8007156", "0X8007156", 0, 0, "", "", "", "");
        MutualMarkUtils.a(this.app, this, 1);
        continue;
        if (this.jdField_a_of_type_Boolean) {
          ReportController.b(null, "dc00898", "", "", "0X800B60B", "0X800B60B", 0, 0, "", "0", "0", "");
        }
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        Object localObject2 = "?mode_color=ffffff";
        localObject1 = localObject2;
        if (SimpleUIUtil.a())
        {
          int k = SimpleUIUtil.d();
          localObject1 = localObject2;
          if (k != 0)
          {
            localObject1 = String.format("%08x", new Object[] { Integer.valueOf(k) }).substring(2);
            localObject1 = "?mode_color=" + (String)localObject1;
          }
        }
        localObject1 = "https://qun.qq.com/interactive/usersetting" + (String)localObject1;
        localObject2 = new StringBuilder().append((String)localObject1).append("&showLuckyWord=");
        if (this.jdField_a_of_type_Boolean) {}
        for (localObject1 = "1";; localObject1 = "0")
        {
          localObject1 = (String)localObject1;
          localIntent.putExtra("url", (String)localObject1 + "&_wv=3");
          startActivity(localIntent);
          break;
        }
        AuthorityControlFragment.a(this);
        continue;
        ReportController.b(this.app, "CliOper", "", "", "0X8009DD0", "0X8009DD0", 0, 0, this.jdField_b_of_type_Int + "", "", "", "");
        PublicFragmentActivity.a(this, ShieldFriendsListFragment.class, 1);
        continue;
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
        startActivity((Intent)localObject1);
        ReportController.b(null, "dc00898", "", "", "0X800ACA6", "0X800ACA6", 0, 0, "", "0", "0", "");
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */