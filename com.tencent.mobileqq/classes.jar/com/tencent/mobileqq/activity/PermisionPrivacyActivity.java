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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.inputstatus.InputStatusConfig.Config;
import com.tencent.mobileqq.inputstatus.InputStatusObserver;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.phonecontact.permission.PermissionListener;
import com.tencent.mobileqq.phonecontact.permission.PermissionParam;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.luckycharacter.config.TroopLuckyCharacterConfig;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingHandler;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
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
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IPhoneContactListener, PermissionListener
{
  private int jdField_a_of_type_Int = -1;
  View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new PermisionPrivacyActivity.16(this);
  CompoundButton jdField_a_of_type_AndroidWidgetCompoundButton = null;
  protected TextView a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new PermisionPrivacyActivity.13(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new PermisionPrivacyActivity.10(this);
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new PermisionPrivacyActivity.12(this);
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new PermisionPrivacyActivity.8(this);
  InputStatusObserver jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver = new PermisionPrivacyActivity.11(this);
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new PermisionPrivacyActivity.17(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  protected ITroopSettingHandler a;
  TroopSettingObserver jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver = new PermisionPrivacyActivity.9(this);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoFriendSettingBrowser context:");
      localStringBuilder.append(paramContext);
      QLog.d("Q.security", 2, localStringBuilder.toString());
    }
    if (paramContext == null) {
      return;
    }
    if (WebViewComUtils.a(1000L)) {
      paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
    }
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
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363080));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363081));
    boolean bool = SharedPreUtils.c(this, this.app.getCurrentAccountUin());
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setChecked(bool);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool) {
      k = 2131693065;
    } else {
      k = 2131693066;
    }
    ((TextView)localObject1).setText(k);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiITroopSettingHandler.a();
    this.jdField_c_of_type_AndroidViewView = findViewById(2131375080);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374316);
    ReportController.b(null, "dc00898", "", "", "0X800B1B1", "0X800B1B1", 0, 0, "", "", "", "");
    this.jdField_b_of_type_AndroidViewView = findViewById(2131374309);
    ReportController.b(null, "dc00898", "", "", "0X800B1AF", "0X800B1AF", 0, 0, "", "", "", "");
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372814));
    g();
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374348));
    localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    bool = VasUtil.a(this.app).getVipStatus().isBigClub();
    int k = 8;
    if (bool)
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(2);
      ((LinearLayout.LayoutParams)this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams()).bottomMargin = 0;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131699277));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new PermisionPrivacyActivity.1(this));
    }
    else
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(3);
    }
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374362));
    Object localObject2 = (IContactSyncService)this.app.getRuntimeService(IContactSyncService.class);
    if (((IContactSyncService)localObject2).isSyncSupportForTheDevice())
    {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((IContactSyncService)localObject2).isSyncContactAllowed());
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
    else
    {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131377388));
    this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131377863));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377487));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.getVisibilityForNetWorkStatus(false));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377483));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.getVisibilityForInputStatus(false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371725));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131362656));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364233));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131379237));
    localObject2 = (TroopLuckyCharacterConfig)QConfigManager.a().a(696);
    if (localObject2 != null) {
      this.jdField_a_of_type_Boolean = ((TroopLuckyCharacterConfig)localObject2).a();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131719893));
      ReportController.b(null, "dc00898", "", "", "0X800B60A", "0X800B60A", 0, 0, "", "0", "0", "");
    }
    else
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131719894));
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131372437));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372438));
    localObject1 = ((FriendsManager)localObject1).b(this.app.getCurrentAccountUin());
    if (((Card)localObject1).allowClick)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).allowPeopleSee);
    if (!((Card)localObject1).allowCalInteractive) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(HardCodeUtil.a(2131699255));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(HardCodeUtil.a(2131699256));
    }
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374322));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    c();
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374324));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    ReportController.b(null, "dc00898", "", "", "0X800ACA5", "0X800ACA5", 0, 0, "", "0", "0", "");
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374318));
    d();
    localObject2 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
    if (localObject2 != null)
    {
      ((TempGetProfileDetailProcessor)localObject2).getLoginDaysSwitch();
      ((TempGetProfileDetailProcessor)localObject2).getCalReactiveSwitch();
    }
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131374321));
    localObject2 = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if ((localObject3 != null) && (((StatusManager)localObject3).b())) {
      bool = true;
    } else {
      bool = false;
    }
    ((FormSwitchItem)localObject2).setChecked(bool);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    a(this.app.getLocVisibilityForStatus());
    this.jdField_c_of_type_AndroidWidgetCompoundButton.setChecked(this.app.getLocZanAllowedForStatus());
    bool = this.app.getLocZanAllowedForPeople();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool);
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
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131363078));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.i = ((FormSwitchItem)super.findViewById(2131370729));
    if (SharedPreUtils.U(getApplication(), this.app.getCurrentAccountUin()) == 1)
    {
      this.i.setVisibility(0);
      ThreadManager.post(new PermisionPrivacyActivity.2(this), 5, null, true);
      this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
    localObject2 = (FormSimpleItem)findViewById(2131365358);
    if ((localObject2 != null) && (CustomOnlineStatusManager.a().a()))
    {
      ((FormSimpleItem)localObject2).setLeftText(getResources().getString(2131691319));
      ((FormSimpleItem)localObject2).a().setMaxWidth(AIOUtils.b(130.0F, getResources()));
      ((FormSimpleItem)localObject2).setOnClickListener(new PermisionPrivacyActivity.3(this));
      localObject3 = new PermisionPrivacyActivity.4(this, (FormSimpleItem)localObject2);
      ((Runnable)localObject3).run();
      ((FormSimpleItem)localObject2).setTag("online_status_callback".hashCode(), localObject3);
      CustomOnlineStatusManager.a().a((Runnable)localObject3);
    }
    else if (localObject2 != null)
    {
      ((FormSimpleItem)localObject2).setVisibility(8);
    }
    if (AppSetting.d)
    {
      this.jdField_c_of_type_AndroidViewView.setContentDescription(getResources().getString(2131699220));
      this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131707928));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("可通过系统通讯录发起QQ聊天");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707923));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707921));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131694421));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131689986));
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707922));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707924));
    }
    localObject2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (a()) {
      k = 0;
    }
    ((FormSwitchItem)localObject2).setVisibility(k);
    ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).d();
    this.j = ((FormSwitchItem)findViewById(2131377502));
    this.j.setChecked(((Card)localObject1).isHidePrettyGroutIdentity ^ true);
    this.j.setOnCheckedChangeListener(new PermisionPrivacyActivity.5(this));
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoFriendFindMeSettingBrowser context:");
      localStringBuilder.append(paramContext);
      QLog.d("Q.security", 2, localStringBuilder.toString());
    }
    if (paramContext == null) {
      return;
    }
    if (WebViewComUtils.a(1000L)) {
      paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendshipauth/find?_wv=3&_bid=173"));
    }
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
    if (!isFinishing())
    {
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() != 0) {
        return;
      }
      ThreadManager.excute(new PermisionPrivacyActivity.7(this), 16, null, true);
    }
  }
  
  private void f()
  {
    if (NetworkUtil.isNetworkAvailable(this)) {
      ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(this.app.getCurrentAccountUin(), true, 257);
    }
  }
  
  private void g()
  {
    Object localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.app.getCurrentUin());
    if (localObject != null) {
      localObject = VipGrayConfigHelper.a().a(this.app.getCurrentUin(), ((Card)localObject).namePlateOfKingGameId, ((Card)localObject).namePlateOfKingDan, ((Card)localObject).namePlateOfKingDanDisplatSwitch, true);
    } else {
      localObject = "";
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0);
    if (!bool)
    {
      localObject = URLDrawable.getDrawable((String)localObject, new ColorDrawable(), new ColorDrawable());
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        ((URLDrawable)localObject).setBounds(0, 0, UIUtils.a(this.app.getApp(), 47.0F), UIUtils.a(this.app.getApp(), 14.0F));
      }
      else
      {
        ((URLDrawable)localObject).restartDownload();
        ((URLDrawable)localObject).setBounds(0, 0, 1, 1);
      }
      ((URLDrawable)localObject).setURLDrawableListener(new PermisionPrivacyActivity.18(this));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject, UIUtils.a(this.app.getApp(), 47.0F), UIUtils.a(this.app.getApp(), 14.0F));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
    }
    else
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.app.getApp().getResources().getString(2131694919));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new PermisionPrivacyActivity.19(this, localSharedPreferences, bool));
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
        return;
      }
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      c();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    super.setContentView(2131561461);
    setTitle(2131699252);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class));
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.addListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiITroopSettingHandler = ((ITroopSettingHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER));
    b();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    this.app.getVisibilitySwitches();
    this.app.getZanSwitches();
    this.app.getVisibilityForNetWorkStatus(true);
    this.app.getVisibilityForInputStatus(true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppCardObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if (localObject != null) {
      ((StatusManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
    if (localObject != null)
    {
      ((QQProgressNotifier)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
    if (localObject != null) {
      ((IPhoneContactService)localObject).removeListener(this);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    g();
    f();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131376999));
      if (!TextUtils.isEmpty(getIntent().getStringExtra("scrollflag")))
      {
        int k = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.getTop() - UIUtils.d(this) / 2;
        BounceScrollView localBounceScrollView = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
        if (k <= 0) {
          k = 0;
        }
        localBounceScrollView.scrollTo(0, k);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBackgroundResource(2130850700);
        ThreadManager.getUIHandler().postDelayed(new PermisionPrivacyActivity.15(this), 1000L);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131379237: 
      if (this.jdField_a_of_type_Boolean) {
        ReportController.b(null, "dc00898", "", "", "0X800B60B", "0X800B60B", 0, 0, "", "0", "0", "");
      }
      localObject2 = new Intent(this, QQBrowserActivity.class);
      if (SimpleUIUtil.a())
      {
        int k = SimpleUIUtil.d();
        if (k != 0)
        {
          localObject1 = String.format("%08x", new Object[] { Integer.valueOf(k) }).substring(2);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("?mode_color=");
          localStringBuilder.append((String)localObject1);
          localObject1 = localStringBuilder.toString();
          break label217;
        }
      }
      localObject1 = "?mode_color=ffffff";
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://qun.qq.com/interactive/usersetting");
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("&showLuckyWord=");
      if (this.jdField_a_of_type_Boolean) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("&_wv=3");
      ((Intent)localObject2).putExtra("url", localStringBuilder.toString());
      startActivity((Intent)localObject2);
      break;
    case 2131375080: 
      localObject1 = QZoneHelper.UserInfo.getInstance();
      ((QZoneHelper.UserInfo)localObject1).qzone_uin = this.app.getCurrentAccountUin();
      ((QZoneHelper.UserInfo)localObject1).nickname = this.app.getCurrentNickname();
      QZoneHelper.forwardToPermissionSetting(this, (QZoneHelper.UserInfo)localObject1, -1);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
      break;
    case 2131374324: 
      localObject1 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
      startActivity((Intent)localObject1);
      ReportController.b(null, "dc00898", "", "", "0X800ACA6", "0X800ACA6", 0, 0, "", "0", "0", "");
      break;
    case 2131374322: 
      localObject1 = this.app;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject2).append("");
      ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8009DD0", "0X8009DD0", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
      PublicFragmentActivity.a(this, ShieldFriendsListFragment.class, 1);
      break;
    case 2131374318: 
      ReportController.b(this.app, "dc00898", "", "", "0X8009F72", "0X8009F72", 0, 0, "", "", "", "");
      localObject1 = FriendIntimateRelationshipHelper.a();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("click qq_setting_intimate_relationship url:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("Q.security", 2, ((StringBuilder)localObject2).toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", (String)localObject1));
      }
      break;
    case 2131374316: 
      a(this);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B1B2", "0X800B1B2", 0, 0, "", "", "", "");
      break;
    case 2131374309: 
      b(this);
      ReportController.b(null, "dc00898", "", "", "0X800B1B0", "0X800B1B0", 0, 0, "", "", "", "");
      break;
    case 2131364233: 
      ReportController.b(this.app, "CliOper", "", "", "0X8007156", "0X8007156", 0, 0, "", "", "", "");
      MutualMarkUtils.a(this.app, this, 1);
      break;
    case 2131363078: 
      label217:
      AuthorityControlFragment.a(this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */