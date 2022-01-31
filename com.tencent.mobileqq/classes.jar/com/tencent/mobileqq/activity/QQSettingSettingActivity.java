package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng.GuideEntry;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Date;
import java.util.Locale;
import protocol.KQQConfig.UpgradeInfo;
import tsb;
import tsc;
import tse;
import tsf;
import tsg;
import tsh;
import tsj;
import tsk;
import tsl;
import tsn;
import tso;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final boolean jdField_c_of_type_Boolean = AppSetting.jdField_b_of_type_Boolean;
  public int a;
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplication.getContext().getResources();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new tsg(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new tsn(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tsf(this);
  SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new tsk(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  public CUOpenCardGuideMng.GuideEntry a;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new tsb(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  MultiImageTextView jdField_a_of_type_ComTencentWidgetMultiImageTextView;
  public boolean a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  boolean jdField_b_of_type_Boolean;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private boolean d;
  private boolean e;
  
  public QQSettingSettingActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry = null;
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
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    if (paramBundle == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131436849);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = paramBundle.getString("phone");
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      if (paramBundle.getInt("need_unify", 0) != 1) {
        break label209;
      }
      label179:
      paramBundle = this.jdField_c_of_type_AndroidWidgetImageView;
      if (i == 0) {
        break label214;
      }
    }
    label209:
    label214:
    for (i = j;; i = 8)
    {
      paramBundle.setVisibility(i);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131436849);
      break;
      i = 0;
      break label179;
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100194");
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localRedTouchManager.a(localAppInfo);
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramString);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100191");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localRedTouchManager.a(localAppInfo);
    }
  }
  
  private void c(Card paramCard)
  {
    Object localObject;
    if ((paramCard != null) && (paramCard.isShowXMan()))
    {
      if (paramCard.lQQMasterLogindays > 0L)
      {
        FriendProfileCardActivity.jdField_a_of_type_Long = paramCard.lQQMasterLogindays;
        if (paramCard.allowClick) {
          break label150;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
        b(paramCard);
      }
      for (;;)
      {
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
        FriendProfileCardActivity.jdField_a_of_type_Long = 30L;
        break;
        label150:
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(1);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        a(paramCard);
      }
    }
    StringBuffer localStringBuffer;
    if (QLog.isColorLevel())
    {
      localStringBuffer = new StringBuffer(200);
      localStringBuffer.append("updataQQLoginDays card=");
      if (paramCard != null) {
        break label322;
      }
      localObject = "null";
      label231:
      localStringBuffer.append((String)localObject);
      localStringBuffer.append(";card.isShowXMan()=");
      if (paramCard != null) {
        break label329;
      }
    }
    label322:
    label329:
    for (paramCard = "null";; paramCard = Boolean.toString(paramCard.isShowXMan()))
    {
      localStringBuffer.append(paramCard);
      QLog.d("QQSetting2Activity", 2, localStringBuffer.toString());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramCard = findViewById(2131369169);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) || (paramCard == null) || (paramCard.getVisibility() == 0)) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
      return;
      localObject = "obj";
      break label231;
    }
  }
  
  private void d()
  {
    View localView = findViewById(2131371408);
    if (!TextUtils.isEmpty(AboutActivity.b()))
    {
      if (Integer.parseInt(AboutActivity.b()) == 5)
      {
        localView.setVisibility(0);
        a(2131371408, 2131438867, 0, 2130838629);
        return;
      }
      ArkIDESettingFragment.a().c();
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void e()
  {
    View localView = findViewById(2131369179);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130846136);
    if (a())
    {
      a(localView, 0, localDrawable);
      return;
    }
    a(localView, 8, localDrawable);
  }
  
  private void f()
  {
    Object localObject = findViewById(2131369174);
    boolean bool = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0).getBoolean("plate_of_king_red_dot_" + this.app.c(), false);
    localObject = (ImageView)((View)localObject).findViewById(2131371308);
    if (!bool)
    {
      ((ImageView)localObject).setVisibility(0);
      return;
    }
    ((ImageView)localObject).setVisibility(8);
  }
  
  private void g()
  {
    ThreadManager.post(new tso(this), 8, null, true);
  }
  
  private void h()
  {
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(QPMiscUtils.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.jdField_a_of_type_Int);
    ProtoUtils.a(this.app, new tsc(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  private void i()
  {
    if (!this.e)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.d();
      }
      this.e = true;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry.a))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry.a);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBackgroundResource(2130838629);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    ThreadManager.post(new tsj(this), 5, null, false);
    return;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = findViewById(paramInt1);
    if (localView == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            TextView localTextView = (TextView)localView.findViewById(2131371304);
            localTextView.setText(paramInt2);
            if (jdField_c_of_type_Boolean) {
              localTextView.setContentDescription(getString(paramInt2));
            }
            if (paramInt3 > 0) {
              localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
            }
            localView.setBackgroundResource(paramInt4);
            localView.setOnClickListener(this);
            if (paramInt1 != 2131371405) {
              break;
            }
            localView.findViewById(2131363485).setVisibility(8);
            localView.findViewById(2131364935).setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364936));
          } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          if (paramInt1 == 2131369177)
          {
            this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).c(30).a();
            c();
            localView.findViewById(2131363485).setVisibility(8);
            localView.findViewById(2131364935).setVisibility(8);
            ((TextView)localView.findViewById(2131364936)).setVisibility(8);
            return;
          }
          if (paramInt1 == 2131369173)
          {
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).c(30).a();
            b();
            return;
          }
          if (paramInt1 == 2131371403)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371305));
            return;
          }
          if (paramInt1 != 2131369169) {
            break;
          }
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364936));
          if (this.jdField_c_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setText(2131435659);
            if (jdField_c_of_type_Boolean) {
              this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(null);
            }
          }
          this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131363485));
          if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
            this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          }
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364935));
        } while (this.jdField_c_of_type_AndroidWidgetImageView == null);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846133);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
        if (paramInt1 != 2131369174) {
          break;
        }
      } while (this.app.getApp().getSharedPreferences("sp_plate_of_king", 0).getBoolean("plate_of_king_red_dot_" + this.app.c(), false));
      ((ImageView)localView.findViewById(2131371308)).setVisibility(0);
      return;
    } while (!jdField_c_of_type_Boolean);
    localView.setContentDescription(getString(paramInt2));
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131371307);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131371306)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131371302);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  void a(Card paramCard)
  {
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText("");
    String str;
    if (paramCard.lLoginDays >= FriendProfileCardActivity.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(-155129);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(2130842930);
      if (jdField_c_of_type_Boolean)
      {
        str = String.format(getString(2131427403), new Object[] { Long.valueOf(paramCard.lLoginDays) });
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(str);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(6.0F);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.append(paramCard.lLoginDays + "天");
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(6.0F);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a();
      return;
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(-5855578);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(2130842929);
      if (jdField_c_of_type_Boolean)
      {
        str = String.format(getString(2131427404), new Object[] { Long.valueOf(paramCard.lLoginDays) });
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(str);
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.app != null)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
        if (localFriendsManager != null) {
          ThreadManager.post(new tsh(this, localFriendsManager, paramString), 8, null, true);
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
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSetting2Activity", 4, String.format(Locale.getDefault(), "startGetPhoneUnityStatus force: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Object localObject = (PhoneUnityManager)this.app.getManager(101);
    if ((System.currentTimeMillis() - ((PhoneUnityManager)localObject).jdField_a_of_type_Long > 1800000L) || (((PhoneUnityManager)localObject).jdField_a_of_type_Boolean) || (paramBoolean))
    {
      ((PhoneUnityManager)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
      ((PhoneUnityManager)localObject).jdField_a_of_type_Boolean = false;
      localObject = (SecSvcHandler)this.app.a(34);
      if (localObject != null)
      {
        this.jdField_a_of_type_Int += 1;
        ((SecSvcHandler)localObject).a(0, 31, null, null);
      }
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    a(true, ((PhoneUnityManager)localObject).jdField_a_of_type_AndroidOsBundle);
  }
  
  public boolean a()
  {
    boolean bool1 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {}
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = ((TimUpgradeHongdianManager)this.app.getManager(243)).a();
      }
      return bool2;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  void b(Card paramCard)
  {
    if ((paramCard.lLoginDays == 1L) || (paramCard.lLoginDays == 0L))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130846418);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getString(2131435466), new Object[] { Integer.valueOf((int)FriendProfileCardActivity.jdField_a_of_type_Long) }));
      if (jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(getString(2131435466), new Object[] { Integer.valueOf((int)FriendProfileCardActivity.jdField_a_of_type_Long) }));
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramCard.lLoginDays <= 1L) || (paramCard.lLoginDays >= FriendProfileCardActivity.jdField_a_of_type_Long)) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130846418);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getString(2131435467), new Object[] { Integer.valueOf((int)paramCard.lLoginDays), Integer.valueOf((int)(FriendProfileCardActivity.jdField_a_of_type_Long - paramCard.lLoginDays)) }));
        } while (!jdField_c_of_type_Boolean);
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(getString(2131435467), new Object[] { Integer.valueOf((int)paramCard.lLoginDays), Integer.valueOf((int)(FriendProfileCardActivity.jdField_a_of_type_Long - paramCard.lLoginDays)) }));
        return;
      } while (paramCard.lLoginDays < FriendProfileCardActivity.jdField_a_of_type_Long);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130846417);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getString(2131435468), new Object[] { Integer.valueOf((int)paramCard.lLoginDays) }));
    } while (!jdField_c_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(getString(2131435468), new Object[] { Integer.valueOf((int)paramCard.lLoginDays) }));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
            bool = paramIntent.getExtras().getBoolean("auth_dev_open", false);
            paramInt1 = i;
            if (this.d != bool) {
              paramInt1 = 1;
            }
            this.d = bool;
          }
        }
      }
      if (paramInt1 != 0) {
        a(true);
      }
    }
    while (paramInt1 != 2001)
    {
      boolean bool;
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970628);
    setTitle(getString(2131433287));
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      paramBundle = getString(2131433287);
      this.centerView.setContentDescription(paramBundle);
    }
    setContentBackgroundResource(2130838219);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131369168));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131436824));
    if (jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131436824));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    a(2131369169, 2131436814, 0, 2130838639);
    paramBundle = (FormSimpleItem)findViewById(2131371403);
    paramBundle.a().setText(2131436815);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramBundle;
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView = paramBundle.a();
    paramBundle.setOnClickListener(this);
    a(2131369172, 2131436816, 0, 2130838641);
    a(2131369173, 2131436843, 0, 2130838639);
    a(2131371404, 2131436844, 0, 2130838636);
    a(2131369174, 2131436818, 0, 2130838639);
    a(2131371405, 2131436819, 0, 2130838641);
    a(2131369175, 2131436822, 0, 2130838636);
    a(2131369179, 2131436823, 0, 2130838629);
    paramBundle = FaceDrawable.a(this.app, this.app.getCurrentAccountUin(), (byte)3);
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
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    e();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371400));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371401));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371402));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    a(this.app.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371407));
    paramBundle = (CUOpenCardGuideMng)this.app.getManager(220);
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
      this.jdField_a_of_type_Boolean = true;
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, "cu_open_card_guide not init");
      }
      this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry = null;
      ThreadManager.post(new tsl(this), 5, null, true);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    }
  }
  
  protected void doOnResume()
  {
    if (this.mSystemBarComp != null)
    {
      int i = getResources().getColor(2131494260);
      this.mSystemBarComp.setStatusColor(i);
    }
    super.doOnResume();
    f();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    c();
    b();
    g();
    ((PhoneUnityManager)this.app.getManager(101)).a();
    d();
    i();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.app, this.app.getCurrentAccountUin(), (byte)3);
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
    g();
    a(this.app.getCurrentAccountUin());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131369168: 
      startActivity(new Intent(this, AccountManageActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
      return;
    case 2131369172: 
      startActivity(new Intent(getActivity(), NotifyPushSettingActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
      return;
    case 2131369173: 
      ((RedTouchManager)this.app.getManager(35)).b("100190.100194");
      paramView = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
      paramView.putExtra("set_display_type", 1);
      getActivity().startActivity(paramView);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_log", 0, 0, "", "", "", "");
      return;
    case 2131371404: 
      QQSettingCleanActivity.a(this);
      ReportController.b(this.app, "dc00898", "", "", "0X8007542", "0X8007542", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      return;
    case 2131369174: 
      startActivity(new Intent(getActivity(), PermisionPrivacyActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
      return;
    case 2131371405: 
      startActivityForResult(new Intent(getActivity(), LoginInfoActivity.class), 0);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
      return;
    case 2131369175: 
      startActivity(new Intent(getActivity(), AssistantSettingActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
      return;
    case 2131371408: 
      PublicFragmentActivity.a(this, new Intent(), ArkIDESettingFragment.class);
      return;
    case 2131369179: 
      startActivity(new Intent(getActivity(), AboutActivity.class));
      if (a()) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DB1", "0X8004DB1", 0, 0, "", "", UpgradeController.a(), "");
      }
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
      return;
    case 2131371403: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.app.getCurrentAccountUin());
      paramView.putExtra("url", "http://ti.qq.com/xman/self.html?_wv=1027&adtag=setting&_bid=297");
      paramView.putExtra("hide_more_button", true);
      startActivity(paramView);
      ReportController.b(this.app, "CliOper", "", "", "0X800487F", "0X800487F", 0, 0, "", "", "", "");
      return;
    case 2131369169: 
      ReportController.b(this.app, "CliOper", "", "", "0X8005DEA", "0X8005DEA", 0, 0, "", "", "", "");
      ReportController.b(this.app, "dc00898", "", "", "0X800689D", "0X800689D", 0, 0, "", "", "", "");
      int i = ((PhoneContactManager)this.app.getManager(10)).c();
      if ((i == 1) || (i == 5)) {
        ReportController.b(this.app, "dc00898", "", "", "0X800689E", "0X800689E", 0, 0, "", "", "", "");
      }
      paramView = new Intent(this, PhoneUnityBindInfoActivity.class);
      paramView.putExtra("kSrouce", 1);
      startActivityForResult(paramView, 2001);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry != null) {}
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqManagersCUOpenCardGuideMng$GuideEntry.c;; paramView = "")
    {
      if (!TextUtils.isEmpty(paramView))
      {
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("uin", this.app.getCurrentAccountUin());
        localIntent.putExtra("url", paramView);
        localIntent.putExtra("hide_more_button", true);
        startActivity(localIntent);
        ThreadManager.post(new tse(this), 5, null, false);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "click cu_open_card_guide url: %s", new Object[] { paramView }));
      return;
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.app, this.app.getCurrentAccountUin(), (byte)3);
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