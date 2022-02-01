package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.identification.FaceContext;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng.GuideEntry;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.AssistantSettingFragment;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.settings.util.PrivacySettingUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final boolean jdField_c_of_type_Boolean = AppSetting.jdField_d_of_type_Boolean;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QQSettingSettingActivity.2(this);
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplication.getContext().getResources();
  private Bundle jdField_a_of_type_AndroidOsBundle = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new QQSettingSettingActivity.11(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new QQSettingSettingActivity.6(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QQSettingSettingActivity.10(this);
  SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new QQSettingSettingActivity.3(this);
  CUOpenCardGuideMng.GuideEntry jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry = null;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new QQSettingSettingActivity.1(this);
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new QQSettingSettingActivity.12(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  MultiImageTextView jdField_a_of_type_ComTencentWidgetMultiImageTextView;
  ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  public boolean a;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private RedTouch jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch;
  FormItemRelativeLayout jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  boolean jdField_b_of_type_Boolean;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private RedTouch jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private TextView jdField_d_of_type_AndroidWidgetTextView = null;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h;
  
  public QQSettingSettingActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(long paramLong, String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("sp_qs_settings", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("qsec_status_expired_time" + this.app.getCurrentAccountUin(), paramLong).putString("qsec_status_tip_text" + this.app.getCurrentAccountUin(), paramString).putLong("qsec_status_update_last_time" + this.app.getCurrentAccountUin(), new Date().getTime()).commit();
    }
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    int i = 1;
    int j = 0;
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSetting2Activity", 4, String.format(Locale.getDefault(), "updatePhoneUnityInfo suc: %s, data: %s", new Object[] { Boolean.valueOf(paramBoolean), paramBundle }));
    }
    if (!b())
    {
      QLog.i("QQSetting2Activity", 1, "updatePhoneUnityInfo: Cannot UpdateViews, isRequest=" + this.f);
      return;
    }
    int k;
    if ((paramBoolean) && (paramBundle != null))
    {
      k = paramBundle.getInt("status", 0);
      if (k != 4) {}
    }
    else
    {
      this.jdField_a_of_type_AndroidOsBundle = null;
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject = paramBundle.getString("phone");
    if (k == 3)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694777);
      if (c())
      {
        if ((paramBundle.getInt("need_unify", 0) != 1) || (TextUtils.isEmpty((CharSequence)localObject))) {
          break label270;
        }
        label206:
        localObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if (i == 0) {
          break label275;
        }
      }
    }
    label270:
    label275:
    for (i = j;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      PhoneUnityManager.a(this.app, "0X800B7CA", paramBundle);
      return;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694776);
      break;
      i = 0;
      break label206;
    }
  }
  
  private boolean a(PhoneUnityManager paramPhoneUnityManager)
  {
    return (paramPhoneUnityManager.jdField_a_of_type_AndroidOsBundle == null) || (paramPhoneUnityManager.jdField_a_of_type_Boolean) || (System.currentTimeMillis() - paramPhoneUnityManager.jdField_a_of_type_Long > 1800000L);
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100199");
      this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch.c(localAppInfo);
      j();
      localRedTouchManager.a(localAppInfo);
    }
  }
  
  private void b(Card paramCard)
  {
    Object localObject = CfgProcess.a(this.app.getCurrentUin(), "hide_qq_xman");
    QLog.d("QQSetting2Activity", 2, "newxman_cfg =" + (String)localObject);
    for (;;)
    {
      try
      {
        i = new JSONObject((String)localObject).getInt("hide_qq_xman");
        if (i != 1) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        int i = 0;
        continue;
        FriendProfileCardActivity.jdField_a_of_type_Long = 30L;
        continue;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        e();
        if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
          continue;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(1);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        a(paramCard);
        continue;
      }
      if ((paramCard == null) || (!paramCard.isShowXMan()) || (i == 0)) {
        break label270;
      }
      if (paramCard.lQQMasterLogindays <= 0L) {
        continue;
      }
      FriendProfileCardActivity.jdField_a_of_type_Long = paramCard.lQQMasterLogindays;
      if (paramCard.allowClick) {
        continue;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuffer(200);
        ((StringBuffer)localObject).append("updataQQLoginDays card.lQQMasterLogindays=");
        ((StringBuffer)localObject).append(paramCard.lQQMasterLogindays);
        ((StringBuffer)localObject).append(";card.allowClick=");
        ((StringBuffer)localObject).append(paramCard.allowClick);
        QLog.d("QQSetting2Activity", 2, ((StringBuffer)localObject).toString());
      }
      return;
      i = 1;
    }
    label270:
    StringBuffer localStringBuffer;
    String str;
    if (QLog.isColorLevel())
    {
      localStringBuffer = new StringBuffer(200);
      localStringBuffer.append("updataQQLoginDays card=");
      if (paramCard != null) {
        break label400;
      }
      str = "null";
      label305:
      localStringBuffer.append(str);
      localStringBuffer.append(";card.isShowXMan()=");
      if (paramCard != null) {
        break label407;
      }
    }
    label400:
    label407:
    for (paramCard = "null";; paramCard = Boolean.toString(paramCard.isShowXMan()))
    {
      localStringBuffer.append(paramCard);
      QLog.d("QQSetting2Activity", 2, localStringBuffer.toString());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramCard = findViewById(2131374913);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) || (paramCard == null) || (paramCard.getVisibility() == 0)) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
      return;
      str = "obj";
      break label305;
    }
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch != null) && (this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch.c()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    c(paramString);
  }
  
  private boolean b()
  {
    return (!this.f) && (this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100191");
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
      localRedTouchManager.a(localAppInfo);
    }
  }
  
  private void c(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (LocaleManager.a())
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      }
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramString);
      }
    }
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_all_phone_get", true));
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100193");
      if (localAppInfo != null) {
        localRedTouchManager.a("100190.100193", 30);
      }
      this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
    }
  }
  
  private void e()
  {
    if (SettingsConfigHelper.a(this.app))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(2);
  }
  
  private void f()
  {
    FaceContext.a().a(this.app, this, 101810106, "setFaceData", null);
  }
  
  private void g()
  {
    View localView = findViewById(2131370353);
    if (!TextUtils.isEmpty(AboutActivity.b()))
    {
      if (Integer.parseInt(AboutActivity.b()) == 5)
      {
        localView.setVisibility(0);
        a(2131370353, 2131699108, 0, 2130839575);
        return;
      }
      ArkIDESettingFragment.a().c();
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void h()
  {
    View localView = findViewById(2131361810);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130850833);
    boolean bool = a();
    if (bool) {
      a(localView, 0, localDrawable);
    }
    for (;;)
    {
      if ((!bool) && (PrivacyPolicyHelper.a(1))) {
        a(localView, 0, this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130850830));
      }
      return;
      a(localView, 8, localDrawable);
    }
  }
  
  private void i()
  {
    ((ImageView)findViewById(2131374912).findViewById(2131380895)).setVisibility(8);
  }
  
  private void j()
  {
    ThreadManager.post(new QQSettingSettingActivity.7(this), 8, null, true);
  }
  
  private void k()
  {
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(QPMiscUtils.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.a());
    ProtoUtils.a(this.app, new QQSettingSettingActivity.8(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  private void l()
  {
    int i = 3;
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      i = 4;
    }
    for (;;)
    {
      ReportController.b(this.app, "dc00898", "", "", "0X800B896", "0X800B896", i, 0, "", "", "", "");
      return;
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("phone");
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("status", 0) != 3) {
        if (!TextUtils.isEmpty(str)) {
          i = 1;
        } else {
          i = 2;
        }
      }
    }
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
    localIntent.putExtra("kSrouce", 1);
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtra("kBindPhoneData", this.jdField_a_of_type_AndroidOsBundle);
    }
    startActivityForResult(localIntent, 2001);
  }
  
  private void n()
  {
    if (!this.h)
    {
      ThreadManager.post(new QQSettingSettingActivity.15(this), 5, null, false);
      this.h = true;
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry.a)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      if (LocaleManager.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry.a);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBackgroundResource(2130839575);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_b_of_type_Boolean = true;
        ThreadManager.post(new QQSettingSettingActivity.14(this), 5, null, false);
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getText(2131699112));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = findViewById(paramInt1);
    if (localView == null) {}
    label213:
    label247:
    do
    {
      do
      {
        return;
        Object localObject = (TextView)localView.findViewById(2131374923);
        ((TextView)localObject).setText(paramInt2);
        if (jdField_c_of_type_Boolean) {
          ((TextView)localObject).setContentDescription(getString(paramInt2));
        }
        if (paramInt3 > 0) {
          ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
        }
        localView.setBackgroundResource(paramInt4);
        localView.setOnClickListener(this);
        if ((localView instanceof FormItemRelativeLayout))
        {
          localObject = (FormItemRelativeLayout)localView;
          if (paramInt4 != 2130839591) {
            break label213;
          }
          ((FormItemRelativeLayout)localObject).setBGType(1);
        }
        for (;;)
        {
          if (paramInt1 != 2131374906) {
            break label247;
          }
          this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, localView).d(30).a();
          b();
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)localView);
          localView.findViewById(2131373581).setVisibility(8);
          localView.findViewById(2131365740).setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365739));
          if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          if (paramInt4 == 2130839585) {
            ((FormItemRelativeLayout)localObject).setBGType(2);
          } else if (paramInt4 == 2130839582) {
            ((FormItemRelativeLayout)localObject).setBGType(3);
          }
        }
        if (paramInt1 == 2131374914)
        {
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, localView).d(30).a();
          c();
          localView.findViewById(2131373581).setVisibility(8);
          localView.findViewById(2131365740).setVisibility(8);
          ((TextView)localView.findViewById(2131365739)).setVisibility(8);
          return;
        }
        if (paramInt1 != 2131374913) {
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365739));
        if (this.jdField_c_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694776);
          if (jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(null);
          }
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131373581));
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365740));
      } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850830);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    } while ((paramInt1 == 2131374912) || (!jdField_c_of_type_Boolean));
    localView.setContentDescription(getString(paramInt2));
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131374924);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131374925)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131374919);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  void a(Card paramCard)
  {
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText(" ");
    if (paramCard.lLoginDays >= FriendProfileCardActivity.jdField_a_of_type_Long)
    {
      if (this.jdField_a_of_type_ComTencentWidgetThemeImageView != null) {
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(getResources().getDrawable(2130851252));
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(-155129);
      if (jdField_c_of_type_Boolean)
      {
        String str2 = getString(2131691291);
        String str1 = str2;
        if (paramCard.allowPeopleSee) {
          str1 = str2 + paramCard.lLoginDays + getString(2131691292);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(str1);
      }
      if (!paramCard.allowPeopleSee) {
        break label223;
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(3.0F);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.append(paramCard.lLoginDays + HardCodeUtil.a(2131691529));
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(8.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.c();
      return;
      if (this.jdField_a_of_type_ComTencentWidgetThemeImageView != null) {
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(getResources().getDrawable(2130851251));
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(-5855578);
      break;
      label223:
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(1.0F);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.append(" ");
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(2.0F);
    }
  }
  
  void a(String paramString)
  {
    try
    {
      if (this.app != null)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localFriendsManager != null) {
          ThreadManager.post(new QQSettingSettingActivity.13(this, localFriendsManager, paramString), 8, null, true);
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("QQSetting2Activity", 2, "updateQQLevelInfo Exception!");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f)
    {
      QLog.i("QQSetting2Activity", 1, "startGetPhoneUnityStatus: on requesting, return.");
      return;
    }
    PhoneUnityManager localPhoneUnityManager = (PhoneUnityManager)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    if ((paramBoolean1) || (a(localPhoneUnityManager))) {}
    for (boolean bool = true;; bool = false)
    {
      SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      String str;
      if (QLog.isColorLevel())
      {
        Locale localLocale = Locale.getDefault();
        if (localSecSvcHandler == null)
        {
          str = "null";
          label83:
          QLog.i("QQSetting2Activity", 2, String.format(localLocale, "startGetPhoneUnityStatus force: %s, isUserClicked: %s, need: %s, h: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool), str }));
        }
      }
      else
      {
        if ((!bool) || (localSecSvcHandler == null)) {
          break label245;
        }
        this.f = true;
        this.jdField_a_of_type_Int += 1;
        localPhoneUnityManager.jdField_a_of_type_Long = System.currentTimeMillis();
        localPhoneUnityManager.jdField_a_of_type_Boolean = false;
        if (!paramBoolean2) {
          break label236;
        }
        localSecSvcHandler.a(2);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsBundle = null;
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        str = "is not null";
        break label83;
        label236:
        localSecSvcHandler.a(1);
      }
      label245:
      a(true, localPhoneUnityManager.jdField_a_of_type_AndroidOsBundle);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper != null)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {
          break label84;
        }
      }
    }
    label84:
    for (bool1 = bool2; !bool1; bool1 = false)
    {
      TimUpgradeHongdianManager localTimUpgradeHongdianManager = (TimUpgradeHongdianManager)this.app.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER);
      if (localTimUpgradeHongdianManager == null) {
        break;
      }
      return localTimUpgradeHongdianManager.a();
    }
    return bool1;
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
    int j = 0;
    int i = 0;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      if (paramInt2 != 0)
      {
        paramInt1 = j;
        if (paramInt2 != -1) {}
      }
      else
      {
        paramInt1 = j;
        if (paramIntent != null)
        {
          paramInt1 = j;
          if (paramIntent.getExtras() != null)
          {
            boolean bool = paramIntent.getExtras().getBoolean("auth_dev_open", false);
            paramInt1 = i;
            if (this.e != bool) {
              paramInt1 = 1;
            }
            this.e = bool;
          }
        }
      }
      if (paramInt1 != 0) {
        a(true);
      }
    }
    do
    {
      return;
      if (paramInt1 == 2001)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSetting2Activity", 2, String.format("REQ_CODE_PHONE_UNITY_BIND_INFO [%s]", new Object[] { Integer.valueOf(paramInt2) }));
        }
        if (paramInt2 == 4001)
        {
          a(true);
          return;
        }
        a(true, ((PhoneUnityManager)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).jdField_a_of_type_AndroidOsBundle);
        return;
      }
      if (paramInt1 == 2002)
      {
        this.jdField_d_of_type_Boolean = false;
        a(true);
        return;
      }
    } while ((paramInt1 != 1000000) || (!((PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).i()));
    Intent localIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
    localIntent.putExtra("kSrouce", 1);
    if (paramIntent != null) {
      localIntent.putExtra("check_permission_result", paramIntent.getStringExtra("check_permission_result"));
    }
    startActivityForResult(localIntent, 2001);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561623);
    setTitle(getString(2131699167));
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      paramBundle = getString(2131699167);
      this.centerView.setContentDescription(paramBundle);
    }
    setContentBackgroundResource(2130838979);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131361924));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131699106));
    if (jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131699106));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a()).b(53).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131374906));
    a(2131374913, 2131699149, 0, 2130839585);
    a(2131374906, 2131699113, 0, 2130839582);
    paramBundle = (FormSimpleItem)findViewById(2131374911);
    paramBundle.a().setText(2131699146);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramBundle;
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = new ThemeImageView(getBaseContext());
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(ThemeImageWrapper.MODE_OTHER);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(UIUtils.a(this.app.getApp(), 47.0F), UIUtils.a(this.app.getApp(), 21.0F));
    localLayoutParams.addRule(0, 2131367393);
    localLayoutParams.setMargins(0, UIUtils.a(this.app.getApp(), 14.0F), 0, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetThemeImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramBundle.setOnClickListener(this);
    a(2131374910, 2131699133, 0, 2130839591);
    a(2131374912, 2131699148, 0, 2130839585);
    a(2131374907, 2131699118, 0, 2130839585);
    a(2131374905, 2131699109, 0, 2130839582);
    a(2131361810, 2131699105, 0, 2130839575);
    paramBundle = FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon width =" + paramBundle.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon height =" + paramBundle.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(paramBundle, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374493));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374491));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374492));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramBundle = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
    if (paramBundle != null) {
      paramBundle.getLoginDaysSwitch();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365493));
    paramBundle = (CUOpenCardGuideMng)this.app.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER);
    if (paramBundle.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry = paramBundle.a(0);
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "cu_open_card_guide has init entry: %s ", new Object[] { this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry }));
      }
    }
    for (;;)
    {
      a();
      ReportController.a(this.app, "0X800B7C9");
      ReportController.a(this.app, "0X800B7CA");
      ReportController.a(this.app, "0X800B7CB");
      if (SettingsConfigHelper.a(this.app))
      {
        ReportController.a(this.app, "0X800B7CE");
        ReportController.a(this.app, "0X800B7CF");
        ReportController.a(this.app, "0X800B7CC");
      }
      this.jdField_a_of_type_Boolean = true;
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, "cu_open_card_guide not init");
      }
      this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry = null;
      ThreadManager.post(new QQSettingSettingActivity.5(this), 5, null, true);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.mSystemBarComp != null)
    {
      int i = getResources().getColor(2131167091);
      this.mSystemBarComp.setStatusColor(i);
    }
    super.doOnResume();
    i();
    c();
    d();
    b();
    j();
    ((PhoneUnityManager)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).a();
    n();
    g();
    h();
    a(this.app.getCurrentAccountUin());
    f();
    e();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (localFaceDrawable != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon width =" + localFaceDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon height =" + localFaceDrawable.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localFaceDrawable, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
    a(true);
    b();
    j();
    a(this.app.getCurrentAccountUin());
  }
  
  public boolean onBackEvent()
  {
    HiddenChatHelper.c(this, SplashActivity.class);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131361924: 
    case 2131374910: 
    case 2131374912: 
    case 2131374906: 
    case 2131374907: 
    case 2131374905: 
    case 2131370353: 
    case 2131361810: 
    case 2131374911: 
    case 2131374913: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        startActivity(new Intent(this, AccountManageActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
        ((RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100190.100193");
        ReportController.a(this.app, "0X800B82D");
        continue;
        if (SettingsConfigHelper.a(this.app))
        {
          ReportController.a(this.app, "0X800B830");
          PublicFragmentActivity.a(this, new Intent(), NotifyPushSettingFragment.class);
        }
        for (;;)
        {
          ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
          break;
          startActivity(new Intent(getActivity(), NotifyPushSettingActivity.class));
        }
        localObject = PrivacySettingUtil.a();
        PrivacySettingUtil.a(this.app, this, (Intent)localObject);
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
        continue;
        startActivityForResult(new Intent(getActivity(), LoginInfoActivity.class), 0);
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
        ReportController.a(this.app, "0X800B82F");
        continue;
        if (SettingsConfigHelper.a(this.app)) {
          ReportController.a(this.app, "0X800B832");
        }
        startActivity(new Intent(getActivity(), GeneralSettingActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C04", 0, 0, "", "", "", "");
        continue;
        if (SettingsConfigHelper.a(this.app))
        {
          ReportController.a(this.app, "0X800B833");
          localObject = new Intent();
          PublicFragmentActivity.a(getActivity(), (Intent)localObject, AssistantSettingFragment.class);
        }
        for (;;)
        {
          ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
          break;
          startActivity(new Intent(getActivity(), AssistantSettingActivity.class));
        }
        PublicFragmentActivity.a(this, new Intent(), ArkIDESettingFragment.class);
        continue;
        startActivity(new Intent(getActivity(), AboutActivity.class));
        if (a()) {
          ReportController.b(this.app, "CliOper", "", "", "0X8004DB1", "0X8004DB1", 0, 0, "", "", UpgradeController.a(), "");
        }
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
        continue;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=set");
        ((Intent)localObject).putExtra("hide_more_button", true);
        startActivity((Intent)localObject);
        ReportController.b(this.app, "CliOper", "", "", "0X800487F", "0X800487F", 0, 0, "", "", "", "");
        continue;
        if (!this.f)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8005DEA", "0X8005DEA", 0, 0, "", "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X800689D", "0X800689D", 0, 0, "", "", "", "");
          ReportController.a(this.app, "0X800B82E");
          int i = ((PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).d();
          if ((i == 1) || (i == 5)) {
            ReportController.b(this.app, "dc00898", "", "", "0X800689E", "0X800689E", 0, 0, "", "", "", "");
          }
          if (!c()) {
            l();
          }
          if (this.jdField_a_of_type_AndroidOsBundle == null)
          {
            a(true, true);
            this.g = true;
          }
          else if (this.jdField_a_of_type_AndroidOsBundle.getInt("check_result") == 1)
          {
            localObject = this.jdField_a_of_type_AndroidOsBundle.getString("mibao_set_url");
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              PhoneUnityManager.a(this.app, "0X800B82E", this.jdField_a_of_type_AndroidOsBundle);
              this.jdField_d_of_type_Boolean = true;
              PhoneUnityManager.a(this, this.app, (String)localObject, 2002);
            }
            else
            {
              QLog.e("QQSetting2Activity", 4, "mb set url is null.");
            }
          }
          else if (c())
          {
            PhoneUnityManager.a(this.app, "0X800B82E", this.jdField_a_of_type_AndroidOsBundle);
            m();
          }
          else
          {
            a(true, true);
            this.g = true;
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry.c;; localObject = "")
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("uin", this.app.getCurrentAccountUin());
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("hide_more_button", true);
        startActivity(localIntent);
        ThreadManager.post(new QQSettingSettingActivity.9(this), 5, null, false);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "click cu_open_card_guide url: %s", new Object[] { localObject }));
      break;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (localFaceDrawable != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon width =" + localFaceDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon height =" + localFaceDrawable.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localFaceDrawable, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity
 * JD-Core Version:    0.7.0.1
 */