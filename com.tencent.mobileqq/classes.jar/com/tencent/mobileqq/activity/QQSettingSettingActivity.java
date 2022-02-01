package com.tencent.mobileqq.activity;

import Override;
import afiq;
import afir;
import afis;
import afit;
import afiu;
import afiv;
import afiw;
import aguy;
import ajng;
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
import anum;
import anuw;
import anvn;
import anyu;
import anyw;
import anzj;
import aobf;
import aodp;
import aohe;
import aohf;
import aoot;
import aqzs;
import avws;
import awzq;
import awzt;
import axam;
import axfr;
import ayxl;
import bbav;
import bdll;
import bhdu;
import bhlo;
import blbf;
import blqj;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Date;
import java.util.Locale;
import nkm;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;
import zps;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final boolean jdField_c_of_type_Boolean = AppSetting.jdField_c_of_type_Boolean;
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new afit(this);
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplication.getContext().getResources();
  private Bundle jdField_a_of_type_AndroidOsBundle;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private anuw jdField_a_of_type_Anuw = new afis(this);
  private anvn jdField_a_of_type_Anvn = new afiv(this);
  anyu jdField_a_of_type_Anyu = new afir(this);
  aohf jdField_a_of_type_Aohf = new afiu(this);
  awzt jdField_a_of_type_Awzt = null;
  private ayxl jdField_a_of_type_Ayxl = new afiq(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  MultiImageTextView jdField_a_of_type_ComTencentWidgetMultiImageTextView;
  ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  public boolean a;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  boolean jdField_b_of_type_Boolean;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private boolean d;
  private boolean e;
  private boolean f;
  
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
    if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    if (paramBundle == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694242);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject = paramBundle.getString("phone");
    if (paramBundle.getInt("status", 0) == 3)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694243);
      if ((paramBundle.getInt("need_unify", 0) != 1) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label258;
      }
      label195:
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (i == 0) {
        break label263;
      }
    }
    label258:
    label263:
    for (i = j;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      ajng.a(this.app, "0X800B327", paramBundle);
      return;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694242);
      break;
      i = 0;
      break label195;
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      bbav localbbav = (bbav)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbav.a("100190.100199");
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.c(localAppInfo);
      h();
      localbbav.a(localAppInfo);
    }
  }
  
  private void b(Card paramCard)
  {
    Object localObject = aqzs.a(this.app.c(), "hide_qq_xman");
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
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
          continue;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(2);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        a(paramCard);
        continue;
      }
      if ((paramCard == null) || (!paramCard.isShowXMan()) || (i == 0)) {
        break label282;
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
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
    label282:
    StringBuffer localStringBuffer;
    String str;
    if (QLog.isColorLevel())
    {
      localStringBuffer = new StringBuffer(200);
      localStringBuffer.append("updataQQLoginDays card=");
      if (paramCard != null) {
        break label412;
      }
      str = "null";
      label317:
      localStringBuffer.append(str);
      localStringBuffer.append(";card.isShowXMan()=");
      if (paramCard != null) {
        break label419;
      }
    }
    label412:
    label419:
    for (paramCard = "null";; paramCard = Boolean.toString(paramCard.isShowXMan()))
    {
      localStringBuffer.append(paramCard);
      QLog.d("QQSetting2Activity", 2, localStringBuffer.toString());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramCard = findViewById(2131374536);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) || (paramCard == null) || (paramCard.getVisibility() == 0)) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
      return;
      str = "obj";
      break label317;
    }
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.b()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    c(paramString);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      bbav localbbav = (bbav)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbav.a("100190.100191");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localbbav.a(localAppInfo);
    }
  }
  
  private void c(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (aobf.a())
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      }
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramString);
      }
    }
  }
  
  private void d()
  {
    avws.a().a(this.app, this, 101810106, "setFaceData", null);
  }
  
  private void e()
  {
    View localView = findViewById(2131369916);
    if (!TextUtils.isEmpty(AboutActivity.b()))
    {
      if (Integer.parseInt(AboutActivity.b()) == 5)
      {
        localView.setVisibility(0);
        a(2131369916, 2131698329, 0, 2130839440);
        return;
      }
      ArkIDESettingFragment.a().c();
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void f()
  {
    View localView = findViewById(2131361809);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130850403);
    boolean bool = a();
    if (bool) {
      a(localView, 0, localDrawable);
    }
    for (;;)
    {
      if ((!bool) && (aodp.a(1))) {
        a(localView, 0, this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130850400));
      }
      return;
      a(localView, 8, localDrawable);
    }
  }
  
  private void g()
  {
    ((ImageView)findViewById(2131374535).findViewById(2131380393)).setVisibility(8);
  }
  
  private void h()
  {
    ThreadManager.post(new QQSettingSettingActivity.7(this), 8, null, true);
  }
  
  private void i()
  {
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(blbf.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.a());
    nkm.a(this.app, new afiw(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  private void j()
  {
    if (!this.f)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.e();
      }
      this.f = true;
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
      return;
    }
    if ((this.jdField_a_of_type_Awzt != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Awzt.a)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      if (aobf.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(this.jdField_a_of_type_Awzt.a);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBackgroundResource(2130839440);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_b_of_type_Boolean = true;
        ThreadManager.post(new QQSettingSettingActivity.13(this), 5, null, false);
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getText(2131698333));
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
    label230:
    do
    {
      do
      {
        return;
        Object localObject = (TextView)localView.findViewById(2131374546);
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
          if (paramInt4 != 2130839456) {
            break label213;
          }
          ((FormItemRelativeLayout)localObject).setBGType(1);
        }
        for (;;)
        {
          if (paramInt1 != 2131374529) {
            break label230;
          }
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).c(30).a();
          b();
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)localView);
          localView.findViewById(2131373075).setVisibility(8);
          localView.findViewById(2131365454).setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365453));
          if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          if (paramInt4 == 2130839450) {
            ((FormItemRelativeLayout)localObject).setBGType(2);
          }
        }
        if (paramInt1 == 2131374537)
        {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).c(30).a();
          c();
          localView.findViewById(2131373075).setVisibility(8);
          localView.findViewById(2131365454).setVisibility(8);
          ((TextView)localView.findViewById(2131365453)).setVisibility(8);
          return;
        }
        if (paramInt1 != 2131374536) {
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365453));
        if (this.jdField_c_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694242);
          if (jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(null);
          }
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131373075));
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365454));
      } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850400);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    } while ((paramInt1 == 2131374535) || (!jdField_c_of_type_Boolean));
    localView.setContentDescription(getString(paramInt2));
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131374547);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131374548)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131374542);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  void a(Card paramCard)
  {
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText(" ");
    if (paramCard.lLoginDays >= FriendProfileCardActivity.jdField_a_of_type_Long)
    {
      if (this.jdField_a_of_type_ComTencentWidgetThemeImageView != null) {
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(getResources().getDrawable(2130850752));
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(-155129);
      if (jdField_c_of_type_Boolean)
      {
        String str2 = getString(2131691059);
        String str1 = str2;
        if (paramCard.allowPeopleSee) {
          str1 = str2 + paramCard.lLoginDays + getString(2131691060);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(str1);
      }
      if (!paramCard.allowPeopleSee) {
        break label223;
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(3.0F);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.append(paramCard.lLoginDays + anzj.a(2131691295));
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(8.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.b();
      return;
      if (this.jdField_a_of_type_ComTencentWidgetThemeImageView != null) {
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(getResources().getDrawable(2130850751));
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(-5855578);
      break;
      label223:
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(1.0F);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.append(" ");
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(2.0F);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.app != null)
      {
        anyw localanyw = (anyw)this.app.getManager(51);
        if (localanyw != null) {
          ThreadManager.post(new QQSettingSettingActivity.12(this, localanyw, paramString), 8, null, true);
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
    ajng localajng = (ajng)this.app.getManager(102);
    if ((System.currentTimeMillis() - localajng.jdField_a_of_type_Long > 1800000L) || (localajng.jdField_a_of_type_Boolean) || (paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      aohe localaohe = (aohe)this.app.a(34);
      Locale localLocale;
      if (QLog.isColorLevel())
      {
        localLocale = Locale.getDefault();
        if (localaohe != null) {
          break label201;
        }
      }
      label201:
      for (String str = "null";; str = "is not null")
      {
        QLog.i("QQSetting2Activity", 2, String.format(localLocale, "startGetPhoneUnityStatus force: %s, need: %s, h: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), str }));
        if ((!bool) || (localaohe == null)) {
          break;
        }
        this.jdField_a_of_type_Int += 1;
        localajng.jdField_a_of_type_Long = System.currentTimeMillis();
        localajng.jdField_a_of_type_Boolean = false;
        localaohe.a(1);
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        return;
      }
      a(true, localajng.jdField_a_of_type_AndroidOsBundle);
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
      axam localaxam = (axam)this.app.getManager(244);
      if (localaxam == null) {
        break;
      }
      return localaxam.a();
    }
    return bool1;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
        a(true, ((ajng)this.app.getManager(102)).jdField_a_of_type_AndroidOsBundle);
        return;
      }
      if (paramInt1 == 2002)
      {
        this.d = false;
        a(true);
        return;
      }
    } while ((paramInt1 != 1000000) || (!((axfr)this.app.getManager(11)).i()));
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
    super.setContentView(2131561569);
    setTitle(getString(2131698383));
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      paramBundle = getString(2131698383);
      this.centerView.setContentDescription(paramBundle);
    }
    setContentBackgroundResource(2130838778);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131361922));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131698327));
    if (jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131698327));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    a(2131374536, 2131698370, 0, 2130839450);
    a(2131374529, 2131698334, 0, 2130839447);
    paramBundle = (FormSimpleItem)findViewById(2131374534);
    paramBundle.a().setText(2131698367);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramBundle;
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = new ThemeImageView(getBaseContext());
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(blqj.c);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(zps.a(this.app.getApp(), 47.0F), zps.a(this.app.getApp(), 21.0F));
    localLayoutParams.addRule(0, 2131367072);
    localLayoutParams.setMargins(0, zps.a(this.app.getApp(), 14.0F), 0, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetThemeImageView, localLayoutParams);
    paramBundle.setOnClickListener(this);
    a(2131374533, 2131698354, 0, 2130839456);
    a(2131374535, 2131698369, 0, 2130839450);
    a(2131374530, 2131698339, 0, 2130839450);
    a(2131374528, 2131698330, 0, 2130839447);
    a(2131361809, 2131698326, 0, 2130839440);
    paramBundle = aoot.a(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon width =" + paramBundle.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon height =" + paramBundle.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(paramBundle, (int)(bhlo.a() * 40.0F), (int)(bhlo.a() * 40.0F));
    }
    this.app.addObserver(this.jdField_a_of_type_Anvn);
    addObserver(this.jdField_a_of_type_Anuw);
    addObserver(this.jdField_a_of_type_Anyu);
    addObserver(this.jdField_a_of_type_Aohf);
    this.app.registObserver(this.jdField_a_of_type_Ayxl);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = bhdu.a().a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374200));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374198));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374199));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ((anum)this.app.a(2)).n();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365228));
    paramBundle = (awzq)this.app.getManager(221);
    if (paramBundle.a())
    {
      this.jdField_a_of_type_Awzt = paramBundle.a(0);
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "cu_open_card_guide has init entry: %s ", new Object[] { this.jdField_a_of_type_Awzt }));
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
      this.jdField_a_of_type_Awzt = null;
      ThreadManager.post(new QQSettingSettingActivity.5(this), 5, null, true);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Anyu);
    this.app.removeObserver(this.jdField_a_of_type_Anvn);
    removeObserver(this.jdField_a_of_type_Anuw);
    removeObserver(this.jdField_a_of_type_Aohf);
    this.app.unRegistObserver(this.jdField_a_of_type_Ayxl);
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
      int i = getResources().getColor(2131167048);
      this.mSystemBarComp.setStatusColor(i);
    }
    super.doOnResume();
    g();
    c();
    b();
    h();
    ((ajng)this.app.getManager(102)).a();
    j();
    e();
    f();
    a(this.app.getCurrentAccountUin());
    d();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.addObserver(this.jdField_a_of_type_Anvn);
    addObserver(this.jdField_a_of_type_Anuw);
    addObserver(this.jdField_a_of_type_Anyu);
    addObserver(this.jdField_a_of_type_Aohf);
    aoot localaoot = aoot.a(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (localaoot != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon width =" + localaoot.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon height =" + localaoot.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localaoot, (int)(bhlo.a() * 40.0F), (int)(bhlo.a() * 40.0F));
    }
    a(true);
    b();
    h();
    a(this.app.getCurrentAccountUin());
  }
  
  public boolean onBackEvent()
  {
    aguy.c(this, SplashActivity.class);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131361922: 
    case 2131374533: 
    case 2131374535: 
    case 2131374529: 
    case 2131374530: 
    case 2131374528: 
    case 2131369916: 
    case 2131361809: 
    case 2131374534: 
    case 2131374536: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        startActivity(new Intent(this, AccountManageActivity.class));
        bdll.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), NotifyPushSettingActivity.class));
        bdll.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), PermisionPrivacyActivity.class));
        bdll.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
        continue;
        startActivityForResult(new Intent(getActivity(), LoginInfoActivity.class), 0);
        bdll.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), GeneralSettingActivity.class));
        bdll.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C04", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), AssistantSettingActivity.class));
        bdll.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
        continue;
        PublicFragmentActivity.a(this, new Intent(), ArkIDESettingFragment.class);
        continue;
        startActivity(new Intent(getActivity(), AboutActivity.class));
        if (a()) {
          bdll.b(this.app, "CliOper", "", "", "0X8004DB1", "0X8004DB1", 0, 0, "", "", bhdu.a(), "");
        }
        bdll.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
        continue;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=set");
        ((Intent)localObject).putExtra("hide_more_button", true);
        startActivity((Intent)localObject);
        bdll.b(this.app, "CliOper", "", "", "0X800487F", "0X800487F", 0, 0, "", "", "", "");
        continue;
        bdll.b(this.app, "CliOper", "", "", "0X8005DEA", "0X8005DEA", 0, 0, "", "", "", "");
        bdll.b(this.app, "dc00898", "", "", "0X800689D", "0X800689D", 0, 0, "", "", "", "");
        int i = ((axfr)this.app.getManager(11)).d();
        if ((i == 1) || (i == 5)) {
          bdll.b(this.app, "dc00898", "", "", "0X800689E", "0X800689E", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_AndroidOsBundle == null)
        {
          QQToast.a(getApplicationContext(), getString(2131694248), 0).b(getTitleBarHeight());
        }
        else if (this.jdField_a_of_type_AndroidOsBundle.getInt("check_result") == 1)
        {
          localObject = this.jdField_a_of_type_AndroidOsBundle.getString("mibao_set_url");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            ajng.a(this.app, "0X800B328", this.jdField_a_of_type_AndroidOsBundle);
            this.d = true;
            ajng.a(this, this.app, (String)localObject, 2002);
          }
          else
          {
            QLog.e("QQSetting2Activity", 4, "mb set url is null.");
          }
        }
        else
        {
          ajng.a(this.app, "0X800B328", this.jdField_a_of_type_AndroidOsBundle);
          localObject = new Intent(this, PhoneUnityBindInfoActivity.class);
          ((Intent)localObject).putExtra("kSrouce", 1);
          if (this.jdField_a_of_type_AndroidOsBundle != null) {
            ((Intent)localObject).putExtra("kBindPhoneData", this.jdField_a_of_type_AndroidOsBundle);
          }
          startActivityForResult((Intent)localObject, 2001);
        }
      }
    }
    if (this.jdField_a_of_type_Awzt != null) {}
    for (Object localObject = this.jdField_a_of_type_Awzt.c;; localObject = "")
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
    aoot localaoot = aoot.a(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (localaoot != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon width =" + localaoot.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon height =" + localaoot.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localaoot, (int)(bhlo.a() * 40.0F), (int)(bhlo.a() * 40.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity
 * JD-Core Version:    0.7.0.1
 */