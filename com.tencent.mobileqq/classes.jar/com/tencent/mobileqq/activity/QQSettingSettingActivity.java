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
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mobileqq.identification.FaceAreaManager;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng.GuideEntry;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecard.utils.QQDarenUtils;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.AssistantSettingFragment;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.settings.util.PrivacySettingUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
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
  private String jdField_a_of_type_JavaLangString = "";
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
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i;
  
  public QQSettingSettingActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(long paramLong, String paramString)
  {
    Object localObject = getSharedPreferences("sp_qs_settings", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qsec_status_expired_time");
      localStringBuilder.append(this.app.getCurrentAccountUin());
      localObject = ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qsec_status_tip_text");
      localStringBuilder.append(this.app.getCurrentAccountUin());
      paramString = ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("qsec_status_update_last_time");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      paramString.putLong(((StringBuilder)localObject).toString(), new Date().getTime()).commit();
    }
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = QLog.isDevelopLevel();
    int j = 1;
    if (bool) {
      QLog.i("QQSetting2Activity", 4, String.format(Locale.getDefault(), "updatePhoneUnityInfo suc: %s, data: %s", new Object[] { Boolean.valueOf(paramBoolean), paramBundle }));
    }
    if (!b())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("updatePhoneUnityInfo: Cannot UpdateViews, isRequest=");
      paramBundle.append(this.g);
      QLog.i("QQSetting2Activity", 1, paramBundle.toString());
      return;
    }
    int k = 8;
    if ((paramBoolean) && (paramBundle != null))
    {
      int m = paramBundle.getInt("status", 0);
      if (m != 4)
      {
        this.jdField_a_of_type_AndroidOsBundle = paramBundle;
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.e = this.jdField_a_of_type_AndroidOsBundle.getBoolean("phone_verified", true);
        if (!a(paramBundle))
        {
          Object localObject = paramBundle.getString("phone");
          if (m == 3) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694763);
          } else if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          } else {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694760);
          }
          if (c())
          {
            if ((paramBundle.getInt("need_unify", 0) != 1) || (TextUtils.isEmpty((CharSequence)localObject))) {
              j = 0;
            }
            localObject = this.jdField_b_of_type_AndroidWidgetImageView;
            if (j != 0) {
              k = 0;
            }
            ((ImageView)localObject).setVisibility(k);
          }
        }
        PhoneUnityManager.a(this.app, "0X800B327", paramBundle);
        return;
      }
    }
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private boolean a(Bundle paramBundle)
  {
    paramBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      int k = paramBundle.length;
      int j = 0;
      while (j < k)
      {
        if (b(paramBundle[j])) {
          return true;
        }
        j += 1;
      }
    }
    return false;
  }
  
  private boolean a(PhoneUnityManager paramPhoneUnityManager)
  {
    return (paramPhoneUnityManager.jdField_a_of_type_AndroidOsBundle == null) || (paramPhoneUnityManager.jdField_a_of_type_Boolean) || (System.currentTimeMillis() - paramPhoneUnityManager.jdField_a_of_type_Long > 1800000L);
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100199");
      this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch.c(localAppInfo);
      j();
      localIRedTouchManager.onReportRedPointExposure(localAppInfo);
    }
  }
  
  private void b(Card paramCard)
  {
    String str = CfgProcess.a(this.app.getCurrentUin(), "hide_qq_xman");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("newxman_cfg =");
    ((StringBuilder)localObject2).append(str);
    QLog.d("QQSetting2Activity", 2, ((StringBuilder)localObject2).toString());
    int j;
    try
    {
      j = new JSONObject(str).getInt("hide_qq_xman");
      if (j != 1) {
        j = 1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      j = 0;
    }
    Object localObject1;
    if ((paramCard != null) && (paramCard.isShowXMan()) && (j != 0))
    {
      if (paramCard.lQQMasterLogindays > 0L) {
        QQDarenUtils.sQQDarenLoginDays = paramCard.lQQMasterLogindays;
      } else {
        QQDarenUtils.sQQDarenLoginDays = 30L;
      }
      if (!paramCard.allowClick)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        if (localObject1 != null) {
          ((FormSimpleItem)localObject1).setBgType(0);
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        e();
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        if (localObject1 != null) {
          ((FormSimpleItem)localObject1).setBgType(1);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        a(paramCard);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuffer(200);
        ((StringBuffer)localObject1).append("updataQQLoginDays card.lQQMasterLogindays=");
        ((StringBuffer)localObject1).append(paramCard.lQQMasterLogindays);
        ((StringBuffer)localObject1).append(";card.allowClick=");
        ((StringBuffer)localObject1).append(paramCard.allowClick);
        QLog.d("QQSetting2Activity", 2, ((StringBuffer)localObject1).toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuffer localStringBuffer = new StringBuffer(200);
        localStringBuffer.append("updataQQLoginDays card=");
        localObject2 = "null";
        if (paramCard == null) {
          localObject1 = "null";
        } else {
          localObject1 = "obj";
        }
        localStringBuffer.append((String)localObject1);
        localStringBuffer.append(";card.isShowXMan()=");
        if (paramCard == null) {
          paramCard = (Card)localObject2;
        } else {
          paramCard = Boolean.toString(paramCard.isShowXMan());
        }
        localStringBuffer.append(paramCard);
        QLog.d("QQSetting2Activity", 2, localStringBuffer.toString());
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramCard = findViewById(2131374449);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (paramCard != null) && (paramCard.getVisibility() != 0)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
      }
    }
  }
  
  private void b(String paramString)
  {
    RedTouch localRedTouch = this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if ((localRedTouch != null) && (localRedTouch.c()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    c(paramString);
  }
  
  private boolean b()
  {
    return (!this.g) && (this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null);
  }
  
  private boolean b(Bundle paramBundle)
  {
    if (paramBundle.getInt("phone_type") == 4)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131694761, new Object[] { paramBundle.getString("phone", "") }));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("phone");
      if (!SharedPreUtils.a(this, this.app.getCurrentUin(), this.jdField_a_of_type_JavaLangString)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100191");
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
      localIRedTouchManager.onReportRedPointExposure(localAppInfo);
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
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    return (localBundle != null) && (localBundle.getBoolean("is_all_phone_get", true));
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100193");
      if (localAppInfo != null) {
        localIRedTouchManager.reportLevelOneRedInfo("100190.100193", 30);
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
    FaceAreaManager.a().a(this.app, this, 101810106, "setFaceData", null);
  }
  
  private void g()
  {
    View localView = findViewById(2131370020);
    if (!TextUtils.isEmpty(AboutActivity.b()))
    {
      if (Integer.parseInt(AboutActivity.b()) == 5)
      {
        localView.setVisibility(0);
        a(2131370020, 2131699212, 0, 2130839433);
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
    View localView = findViewById(2131361816);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130850769);
    boolean bool = a();
    if (bool) {
      a(localView, 0, localDrawable);
    } else {
      a(localView, 8, localDrawable);
    }
    if ((!bool) && (PrivacyPolicyHelper.a(1))) {
      a(localView, 0, this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130850766));
    }
  }
  
  private void i()
  {
    ((ImageView)findViewById(2131374448).findViewById(2131380160)).setVisibility(8);
  }
  
  private void j()
  {
    ThreadManager.post(new QQSettingSettingActivity.7(this), 8, null, true);
  }
  
  private void k()
  {
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(QPMiscUtils.a());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.a());
    ProtoUtils.a(this.app, new QQSettingSettingActivity.8(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    int j;
    if (localObject == null)
    {
      j = 4;
    }
    else
    {
      localObject = ((Bundle)localObject).getString("phone");
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("status", 0) == 3) {
        j = 3;
      } else if (!TextUtils.isEmpty((CharSequence)localObject)) {
        j = 1;
      } else {
        j = 2;
      }
    }
    ReportController.b(this.app, "dc00898", "", "", "0X800B896", "0X800B896", j, 0, "", "", "", "");
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
    localIntent.putExtra("kSrouce", 1);
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null) {
      localIntent.putExtra("kBindPhoneData", localBundle);
    }
    startActivityForResult(localIntent, 2001);
  }
  
  private void n()
  {
    if (!this.i)
    {
      ThreadManager.post(new QQSettingSettingActivity.15(this), 5, null, false);
      this.i = true;
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
      return;
    }
    CUOpenCardGuideMng.GuideEntry localGuideEntry = this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry;
    if ((localGuideEntry != null) && (!TextUtils.isEmpty(localGuideEntry.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      if (LocaleManager.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry.jdField_a_of_type_JavaLangString);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getText(2131699216));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBackgroundResource(2130839433);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        ThreadManager.post(new QQSettingSettingActivity.14(this), 5, null, false);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = findViewById(paramInt1);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131374459);
    ((TextView)localObject2).setText(paramInt2);
    if (jdField_c_of_type_Boolean) {
      ((TextView)localObject2).setContentDescription(getString(paramInt2));
    }
    if (paramInt3 > 0) {
      ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
    }
    ((View)localObject1).setBackgroundResource(paramInt4);
    ((View)localObject1).setOnClickListener(this);
    if ((localObject1 instanceof FormItemRelativeLayout))
    {
      localObject2 = (FormItemRelativeLayout)localObject1;
      if (paramInt4 == 2130839449) {
        ((FormItemRelativeLayout)localObject2).setBGType(1);
      } else if (paramInt4 == 2130839443) {
        ((FormItemRelativeLayout)localObject2).setBGType(2);
      } else if (paramInt4 == 2130839440) {
        ((FormItemRelativeLayout)localObject2).setBGType(3);
      }
    }
    if (paramInt1 == 2131374442)
    {
      this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, (View)localObject1).d(30).a();
      b();
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)localObject1);
      ((View)localObject1).findViewById(2131373161).setVisibility(8);
      ((View)localObject1).findViewById(2131365578).setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131365577));
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
    else
    {
      if (paramInt1 == 2131374450)
      {
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, (View)localObject1).d(30).a();
        c();
        ((View)localObject1).findViewById(2131373161).setVisibility(8);
        ((View)localObject1).findViewById(2131365578).setVisibility(8);
        ((TextView)((View)localObject1).findViewById(2131365577)).setVisibility(8);
        return;
      }
      if (paramInt1 == 2131374449)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131365577));
        localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694760);
          if (jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(null);
          }
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject1).findViewById(2131373161));
        localObject2 = this.jdField_a_of_type_AndroidWidgetProgressBar;
        if (localObject2 != null) {
          ((ProgressBar)localObject2).setVisibility(8);
        }
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131365578));
        localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setImageResource(2130850766);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      else
      {
        if (paramInt1 == 2131374448) {
          return;
        }
        if (jdField_c_of_type_Boolean) {
          ((View)localObject1).setContentDescription(getString(paramInt2));
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131374460);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131374461)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131374455);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  void a(Card paramCard)
  {
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText(" ");
    Object localObject1;
    if (paramCard.lLoginDays >= QQDarenUtils.sQQDarenLoginDays)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetThemeImageView;
      if (localObject1 != null) {
        ((ThemeImageView)localObject1).setImageDrawable(getResources().getDrawable(2130851163));
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(-155129);
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetThemeImageView;
      if (localObject1 != null) {
        ((ThemeImageView)localObject1).setImageDrawable(getResources().getDrawable(2130851162));
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(-5855578);
    }
    Object localObject2;
    if (jdField_c_of_type_Boolean)
    {
      localObject2 = getString(2131691212);
      localObject1 = localObject2;
      if (paramCard.allowPeopleSee)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(paramCard.lLoginDays);
        ((StringBuilder)localObject1).append(getString(2131691213));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription((CharSequence)localObject1);
    }
    if (paramCard.allowPeopleSee)
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(3.0F);
      localObject1 = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramCard.lLoginDays);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131691451));
      ((MultiImageTextView)localObject1).append(((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(8.0F);
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(1.0F);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.append(" ");
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(2.0F);
    }
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.c();
  }
  
  void a(String paramString)
  {
    try
    {
      if (this.app != null)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localFriendsManager != null)
        {
          ThreadManager.post(new QQSettingSettingActivity.13(this, localFriendsManager, paramString), 8, null, true);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting2Activity", 2, "updateQQLevelInfo Exception!");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.g)
    {
      QLog.i("QQSetting2Activity", 1, "startGetPhoneUnityStatus: on requesting, return.");
      return;
    }
    PhoneUnityManager localPhoneUnityManager = (PhoneUnityManager)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    boolean bool;
    if ((!paramBoolean1) && (!a(localPhoneUnityManager))) {
      bool = false;
    } else {
      bool = true;
    }
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    Object localObject;
    if (QLog.isColorLevel())
    {
      Locale localLocale = Locale.getDefault();
      if (localSecSvcHandler == null) {
        localObject = "null";
      } else {
        localObject = "is not null";
      }
      QLog.i("QQSetting2Activity", 2, String.format(localLocale, "startGetPhoneUnityStatus force: %s, isUserClicked: %s, need: %s, h: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool), localObject }));
    }
    if ((bool) && (localSecSvcHandler != null))
    {
      this.g = true;
      this.jdField_a_of_type_Int += 1;
      localPhoneUnityManager.jdField_a_of_type_Long = System.currentTimeMillis();
      localPhoneUnityManager.jdField_a_of_type_Boolean = false;
      if (paramBoolean2) {
        localSecSvcHandler.a(2);
      } else {
        localSecSvcHandler.a(1);
      }
      this.jdField_a_of_type_AndroidOsBundle = null;
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(0);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      a(true, localPhoneUnityManager.jdField_a_of_type_AndroidOsBundle);
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((UpgradeDetailWrapper)localObject).a != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.bNewSwitch == 1) {
            bool1 = true;
          }
        }
      }
    }
    bool2 = bool1;
    if (!bool1)
    {
      localObject = (TimUpgradeHongdianManager)this.app.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER);
      bool2 = bool1;
      if (localObject != null) {
        bool2 = ((TimUpgradeHongdianManager)localObject).a();
      }
    }
    return bool2;
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
    int k = 0;
    int j = 0;
    if (paramInt1 == 0)
    {
      if (paramInt2 != 0)
      {
        paramInt1 = k;
        if (paramInt2 != -1) {}
      }
      else
      {
        paramInt1 = k;
        if (paramIntent != null)
        {
          paramInt1 = k;
          if (paramIntent.getExtras() != null)
          {
            boolean bool = paramIntent.getExtras().getBoolean("auth_dev_open", false);
            paramInt1 = j;
            if (this.f != bool) {
              paramInt1 = 1;
            }
            this.f = bool;
          }
        }
      }
      if (paramInt1 != 0) {
        a(true);
      }
    }
    else
    {
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
      if ((paramInt1 == 1000000) && (((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()))
      {
        Intent localIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
        localIntent.putExtra("kSrouce", 1);
        if (paramIntent != null) {
          localIntent.putExtra("check_permission_result", paramIntent.getStringExtra("check_permission_result"));
        }
        startActivityForResult(localIntent, 2001);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561465);
    setTitle(getString(2131699271));
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      paramBundle = getString(2131699271);
      this.centerView.setContentDescription(paramBundle);
    }
    setContentBackgroundResource(2130838739);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131361930));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131699210));
    if (jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131699210));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a()).b(53).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)findViewById(2131374442));
    a(2131374449, 2131699253, 0, 2130839443);
    a(2131374442, 2131699217, 0, 2130839440);
    paramBundle = (FormSimpleItem)findViewById(2131374447);
    paramBundle.a().setText(2131699250);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramBundle;
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = new ThemeImageView(getBaseContext());
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(ThemeImageWrapper.MODE_OTHER);
    Object localObject = new RelativeLayout.LayoutParams(UIUtils.a(this.app.getApp(), 47.0F), UIUtils.a(this.app.getApp(), 21.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131367175);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, UIUtils.a(this.app.getApp(), 14.0F), 0, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetThemeImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramBundle.setOnClickListener(this);
    a(2131374446, 2131699237, 0, 2130839449);
    a(2131374448, 2131699252, 0, 2130839443);
    a(2131374443, 2131699222, 0, 2130839443);
    a(2131374441, 2131699213, 0, 2130839440);
    a(2131361816, 2131699209, 0, 2130839433);
    paramBundle = FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnCreate setIcon width =");
        ((StringBuilder)localObject).append(paramBundle.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnCreate setIcon height =");
        ((StringBuilder)localObject).append(paramBundle.getMinimumHeight());
        QLog.d("QQSetting2Activity", 2, ((StringBuilder)localObject).toString());
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374031));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374029));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374030));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramBundle = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
    if (paramBundle != null) {
      paramBundle.getLoginDaysSwitch();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365339));
    paramBundle = (CUOpenCardGuideMng)this.app.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER);
    if (paramBundle.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry = paramBundle.a(0);
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "cu_open_card_guide has init entry: %s ", new Object[] { this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry }));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, "cu_open_card_guide not init");
      }
      this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry = null;
      ThreadManager.post(new QQSettingSettingActivity.5(this), 5, null, true);
    }
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
  }
  
  protected void doOnDestroy()
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
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (this.mSystemBarComp != null)
    {
      int j = getResources().getColor(2131167114);
      this.mSystemBarComp.setStatusColor(j);
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
  
  protected void onAccountChanged()
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAccountChanged setIcon width =");
        localStringBuilder.append(localFaceDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAccountChanged setIcon height =");
        localStringBuilder.append(localFaceDrawable.getMinimumHeight());
        QLog.d("QQSetting2Activity", 2, localStringBuilder.toString());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localFaceDrawable, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
    a(true);
    b();
    j();
    a(this.app.getCurrentAccountUin());
  }
  
  protected boolean onBackEvent()
  {
    HiddenChatHelper.c(this, SplashActivity.class);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    Object localObject1 = "";
    switch (j)
    {
    default: 
      break;
    case 2131374449: 
      if ((!this.e) && (!SharedPreUtils.a(this, this.app.getCurrentUin(), this.jdField_a_of_type_JavaLangString)))
      {
        SharedPreUtils.a(this, this.app.getCurrentUin(), this.jdField_a_of_type_JavaLangString, true);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (!this.g)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8005DEA", "0X8005DEA", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X800689D", "0X800689D", 0, 0, "", "", "", "");
        ReportController.a(this.app, "0X800B82E");
        j = ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
        if ((j == 1) || (j == 5)) {
          ReportController.b(this.app, "dc00898", "", "", "0X800689E", "0X800689E", 0, 0, "", "", "", "");
        }
        if (!c()) {
          l();
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle;
        if (localObject1 == null)
        {
          a(true, true);
          this.h = true;
        }
        else if ((((Bundle)localObject1).getInt("check_result") == 1) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("mibao_set_url");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            PhoneUnityManager.a(this.app, "0X800B328", this.jdField_a_of_type_AndroidOsBundle);
            this.jdField_d_of_type_Boolean = true;
            PhoneUnityManager.a(this, this.app, (String)localObject1, 2002);
          }
          else
          {
            QLog.e("QQSetting2Activity", 4, "mb set url is null.");
          }
        }
        else if (c())
        {
          PhoneUnityManager.a(this.app, "0X800B328", this.jdField_a_of_type_AndroidOsBundle);
          m();
        }
        else
        {
          a(true, true);
          this.h = true;
        }
      }
      break;
    case 2131374448: 
      localObject1 = PrivacySettingUtil.a();
      PrivacySettingUtil.a(this.app, this, (Intent)localObject1);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
      break;
    case 2131374447: 
      localObject1 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=set");
      ((Intent)localObject1).putExtra("hide_more_button", true);
      startActivity((Intent)localObject1);
      ReportController.b(this.app, "CliOper", "", "", "0X800487F", "0X800487F", 0, 0, "", "", "", "");
      break;
    case 2131374446: 
      if (SettingsConfigHelper.a(this.app))
      {
        ReportController.a(this.app, "0X800B830");
        PublicFragmentActivity.a(this, new Intent(), NotifyPushSettingFragment.class);
      }
      else
      {
        startActivity(new Intent(getActivity(), NotifyPushSettingActivity.class));
      }
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
      break;
    case 2131374443: 
      if (SettingsConfigHelper.a(this.app)) {
        ReportController.a(this.app, "0X800B832");
      }
      startActivity(new Intent(getActivity(), GeneralSettingActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C04", 0, 0, "", "", "", "");
      break;
    case 2131374442: 
      localObject1 = new Intent(getActivity(), LoginInfoActivity.class);
      ((Intent)localObject1).putExtra("has_unverified_phone", this.e ^ true);
      startActivityForResult((Intent)localObject1, 0);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
      ReportController.a(this.app, "0X800B82F");
      break;
    case 2131374441: 
      if (SettingsConfigHelper.a(this.app))
      {
        ReportController.a(this.app, "0X800B833");
        localObject1 = new Intent();
        PublicFragmentActivity.a(getActivity(), (Intent)localObject1, AssistantSettingFragment.class);
      }
      else
      {
        startActivity(new Intent(getActivity(), AssistantSettingActivity.class));
      }
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
      break;
    case 2131370020: 
      PublicFragmentActivity.a(this, new Intent(), ArkIDESettingFragment.class);
      break;
    case 2131365339: 
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry;
      if (localObject2 != null) {
        localObject1 = ((CUOpenCardGuideMng.GuideEntry)localObject2).c;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        startActivity((Intent)localObject2);
        ThreadManager.post(new QQSettingSettingActivity.9(this), 5, null, false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "click cu_open_card_guide url: %s", new Object[] { localObject1 }));
      }
      break;
    case 2131361930: 
      startActivity(new Intent(this, AccountManageActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
      ((IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("100190.100193");
      ReportController.a(this.app, "0X800B82D");
      break;
    case 2131361816: 
      startActivity(new Intent(getActivity(), AboutActivity.class));
      if (a()) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DB1", "0X8004DB1", 0, 0, "", "", UpgradeController.a(), "");
      }
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPostThemeChanged setIcon width =");
        localStringBuilder.append(localFaceDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPostThemeChanged setIcon height =");
        localStringBuilder.append(localFaceDrawable.getMinimumHeight());
        QLog.d("QQSetting2Activity", 2, localStringBuilder.toString());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localFaceDrawable, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity
 * JD-Core Version:    0.7.0.1
 */