package com.tencent.mobileqq.activity;

import abxd;
import abxe;
import abxf;
import abxg;
import abxh;
import abxi;
import adic;
import ajti;
import ajto;
import ajuf;
import ajxj;
import ajxl;
import ajya;
import ajzt;
import akco;
import akcy;
import akgd;
import akge;
import akuz;
import amoq;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aseg;
import asej;
import asfc;
import askn;
import atzn;
import avps;
import axqy;
import bayh;
import bbdh;
import bfhs;
import bfwr;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Date;
import java.util.Locale;
import mxf;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;
import vzl;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final boolean jdField_c_of_type_Boolean = AppSetting.d;
  public int a;
  private ajto jdField_a_of_type_Ajto = new abxe(this);
  private ajuf jdField_a_of_type_Ajuf = new abxg(this);
  ajxj jdField_a_of_type_Ajxj = new abxi(this);
  akge jdField_a_of_type_Akge = new abxf(this);
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplication.getContext().getResources();
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  asej jdField_a_of_type_Asej = null;
  private atzn jdField_a_of_type_Atzn = new abxd(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131695015);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
      paramBundle = this.jdField_b_of_type_AndroidWidgetImageView;
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131695015);
      break;
      i = 0;
      break label179;
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      avps localavps = (avps)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localavps.a("100190.100199");
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.c(localAppInfo);
      g();
      localavps.a(localAppInfo);
    }
  }
  
  private void b(Card paramCard)
  {
    Object localObject = amoq.a(this.app.c(), "hide_qq_xman");
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
      paramCard = findViewById(2131373196);
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
    if ((this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a()))
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
      avps localavps = (avps)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localavps.a("100190.100191");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localavps.a(localAppInfo);
    }
  }
  
  private void c(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (ajzt.a())
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      }
      if (AppSetting.d) {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramString);
      }
    }
  }
  
  private void d()
  {
    View localView = findViewById(2131369174);
    if (!TextUtils.isEmpty(AboutActivity.b()))
    {
      if (Integer.parseInt(AboutActivity.b()) == 5)
      {
        localView.setVisibility(0);
        a(2131369174, 2131699387, 0, 2130839169);
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
    View localView = findViewById(2131361808);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130849300);
    boolean bool = a();
    if (bool) {
      a(localView, 0, localDrawable);
    }
    for (;;)
    {
      if ((!bool) && (akcy.a(1))) {
        a(localView, 0, this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130849297));
      }
      return;
      a(localView, 8, localDrawable);
    }
  }
  
  private void f()
  {
    ((ImageView)findViewById(2131373195).findViewById(2131378605)).setVisibility(8);
  }
  
  private void g()
  {
    ThreadManager.post(new QQSettingSettingActivity.6(this), 8, null, true);
  }
  
  private void h()
  {
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(bfhs.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.a());
    mxf.a(this.app, new abxh(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  private void i()
  {
    if (!this.e)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.c();
      }
      this.e = true;
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
      return;
    }
    if ((this.jdField_a_of_type_Asej != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Asej.a)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      if (ajzt.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(this.jdField_a_of_type_Asej.a);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBackgroundResource(2130839169);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_b_of_type_Boolean = true;
        ThreadManager.post(new QQSettingSettingActivity.12(this), 5, null, false);
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getText(2131699393));
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
        Object localObject = (TextView)localView.findViewById(2131373206);
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
          if (paramInt4 != 2130839185) {
            break label213;
          }
          ((FormItemRelativeLayout)localObject).setBGType(1);
        }
        for (;;)
        {
          if (paramInt1 != 2131373189) {
            break label230;
          }
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).c(30).a();
          b();
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)localView);
          localView.findViewById(2131372031).setVisibility(8);
          localView.findViewById(2131365082).setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365081));
          if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          if (paramInt4 == 2130839179) {
            ((FormItemRelativeLayout)localObject).setBGType(2);
          }
        }
        if (paramInt1 == 2131373197)
        {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).c(30).a();
          c();
          localView.findViewById(2131372031).setVisibility(8);
          localView.findViewById(2131365082).setVisibility(8);
          ((TextView)localView.findViewById(2131365081)).setVisibility(8);
          return;
        }
        if (paramInt1 != 2131373196) {
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365081));
        if (this.jdField_c_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131695066);
          if (jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(null);
          }
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131372031));
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365082));
      } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849297);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    } while ((paramInt1 == 2131373195) || (!jdField_c_of_type_Boolean));
    localView.setContentDescription(getString(paramInt2));
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131373207);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131373208)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131373202);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  void a(Card paramCard)
  {
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText(" ");
    if (paramCard.lLoginDays >= FriendProfileCardActivity.jdField_a_of_type_Long)
    {
      if (this.jdField_a_of_type_ComTencentWidgetThemeImageView != null) {
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(getResources().getDrawable(2130849632));
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(-155129);
      if (jdField_c_of_type_Boolean)
      {
        String str2 = getString(2131691200);
        String str1 = str2;
        if (paramCard.allowPeopleSee) {
          str1 = str2 + paramCard.lLoginDays + getString(2131691201);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(str1);
      }
      if (!paramCard.allowPeopleSee) {
        break label223;
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(3.0F);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.append(paramCard.lLoginDays + ajya.a(2131691461));
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(8.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.b();
      return;
      if (this.jdField_a_of_type_ComTencentWidgetThemeImageView != null) {
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(getResources().getDrawable(2130849631));
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
        ajxl localajxl = (ajxl)this.app.getManager(51);
        if (localajxl != null) {
          ThreadManager.post(new QQSettingSettingActivity.11(this, localajxl, paramString), 8, null, true);
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
    akco localakco = (akco)this.app.getManager(102);
    if ((System.currentTimeMillis() - localakco.jdField_a_of_type_Long > 1800000L) || (localakco.jdField_a_of_type_Boolean) || (paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      akgd localakgd = (akgd)this.app.a(34);
      Locale localLocale;
      if (QLog.isColorLevel())
      {
        localLocale = Locale.getDefault();
        if (localakgd != null) {
          break label205;
        }
      }
      label205:
      for (String str = "null";; str = "is not null")
      {
        QLog.i("QQSetting2Activity", 2, String.format(localLocale, "startGetPhoneUnityStatus force: %s, need: %s, h: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), str }));
        if ((!bool) || (localakgd == null)) {
          break;
        }
        this.jdField_a_of_type_Int += 1;
        localakco.jdField_a_of_type_Long = System.currentTimeMillis();
        localakco.jdField_a_of_type_Boolean = false;
        localakgd.a(0, 31, null, null);
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
      a(true, localakco.jdField_a_of_type_AndroidOsBundle);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {
          break label84;
        }
      }
    }
    label84:
    for (bool1 = bool2; !bool1; bool1 = false)
    {
      asfc localasfc = (asfc)this.app.getManager(244);
      if (localasfc == null) {
        break;
      }
      return localasfc.a();
    }
    return bool1;
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
        a(true, ((akco)this.app.getManager(102)).jdField_a_of_type_AndroidOsBundle);
        return;
      }
    } while ((paramInt1 != 1000000) || (!((askn)this.app.getManager(11)).h()));
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
    super.setContentView(2131561093);
    setTitle(getString(2131699448));
    if (AppSetting.d)
    {
      paramBundle = getString(2131699448);
      this.centerView.setContentDescription(paramBundle);
    }
    setContentBackgroundResource(2130838514);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131361876));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131699383));
    if (jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131699383));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    a(2131373196, 2131699435, 0, 2130839179);
    a(2131373189, 2131699394, 0, 2130839176);
    paramBundle = (FormSimpleItem)findViewById(2131373194);
    paramBundle.a().setText(2131699430);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramBundle;
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = new ThemeImageView(getBaseContext());
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bfwr.c);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(vzl.a(this.app.getApp(), 47.0F), vzl.a(this.app.getApp(), 21.0F));
    localLayoutParams.addRule(0, 2131366627);
    localLayoutParams.setMargins(0, vzl.a(this.app.getApp(), 14.0F), 0, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetThemeImageView, localLayoutParams);
    paramBundle.setOnClickListener(this);
    a(2131373193, 2131699418, 0, 2130839185);
    a(2131373195, 2131699434, 0, 2130839179);
    a(2131373190, 2131699400, 0, 2130839179);
    a(2131373188, 2131699388, 0, 2130839176);
    a(2131361808, 2131699382, 0, 2130839169);
    paramBundle = bayh.a(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon width =" + paramBundle.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon height =" + paramBundle.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(paramBundle, (int)(bbdh.a() * 40.0F), (int)(bbdh.a() * 40.0F));
    }
    this.app.addObserver(this.jdField_a_of_type_Ajuf);
    addObserver(this.jdField_a_of_type_Ajto);
    addObserver(this.jdField_a_of_type_Ajxj);
    addObserver(this.jdField_a_of_type_Akge);
    this.app.registObserver(this.jdField_a_of_type_Atzn);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = akuz.a().a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372870));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372868));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372869));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ((ajti)this.app.a(2)).o();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364861));
    paramBundle = (aseg)this.app.getManager(221);
    if (paramBundle.a())
    {
      this.jdField_a_of_type_Asej = paramBundle.a(0);
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "cu_open_card_guide has init entry: %s ", new Object[] { this.jdField_a_of_type_Asej }));
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
      this.jdField_a_of_type_Asej = null;
      ThreadManager.post(new QQSettingSettingActivity.4(this), 5, null, true);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Ajxj);
    this.app.removeObserver(this.jdField_a_of_type_Ajuf);
    removeObserver(this.jdField_a_of_type_Ajto);
    removeObserver(this.jdField_a_of_type_Akge);
    this.app.unRegistObserver(this.jdField_a_of_type_Atzn);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.mSystemBarComp != null)
    {
      int i = getResources().getColor(2131166910);
      this.mSystemBarComp.setStatusColor(i);
    }
    super.doOnResume();
    f();
    c();
    b();
    g();
    ((akco)this.app.getManager(102)).a();
    i();
    d();
    e();
    a(this.app.getCurrentAccountUin());
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.addObserver(this.jdField_a_of_type_Ajuf);
    addObserver(this.jdField_a_of_type_Ajto);
    addObserver(this.jdField_a_of_type_Ajxj);
    addObserver(this.jdField_a_of_type_Akge);
    bayh localbayh = bayh.a(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (localbayh != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon width =" + localbayh.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon height =" + localbayh.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localbayh, (int)(bbdh.a() * 40.0F), (int)(bbdh.a() * 40.0F));
    }
    a(true);
    b();
    g();
    a(this.app.getCurrentAccountUin());
  }
  
  public boolean onBackEvent()
  {
    adic.c(this, SplashActivity.class);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131361876: 
      startActivity(new Intent(this, AccountManageActivity.class));
      axqy.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
      return;
    case 2131373193: 
      startActivity(new Intent(getActivity(), NotifyPushSettingActivity.class));
      axqy.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
      return;
    case 2131373195: 
      startActivity(new Intent(getActivity(), PermisionPrivacyActivity.class));
      axqy.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
      return;
    case 2131373189: 
      startActivityForResult(new Intent(getActivity(), LoginInfoActivity.class), 0);
      axqy.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
      return;
    case 2131373190: 
      startActivity(new Intent(getActivity(), GeneralSettingActivity.class));
      axqy.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C04", 0, 0, "", "", "", "");
      return;
    case 2131373188: 
      startActivity(new Intent(getActivity(), AssistantSettingActivity.class));
      axqy.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
      return;
    case 2131369174: 
      PublicFragmentActivity.a(this, new Intent(), ArkIDESettingFragment.class);
      return;
    case 2131361808: 
      startActivity(new Intent(getActivity(), AboutActivity.class));
      if (a()) {
        axqy.b(this.app, "CliOper", "", "", "0X8004DB1", "0X8004DB1", 0, 0, "", "", akuz.a(), "");
      }
      axqy.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
      return;
    case 2131373194: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.app.getCurrentAccountUin());
      paramView.putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=set");
      paramView.putExtra("hide_more_button", true);
      startActivity(paramView);
      axqy.b(this.app, "CliOper", "", "", "0X800487F", "0X800487F", 0, 0, "", "", "", "");
      return;
    case 2131373196: 
      axqy.b(this.app, "CliOper", "", "", "0X8005DEA", "0X8005DEA", 0, 0, "", "", "", "");
      axqy.b(this.app, "dc00898", "", "", "0X800689D", "0X800689D", 0, 0, "", "", "", "");
      paramView = (askn)this.app.getManager(11);
      int i = paramView.d();
      if ((i == 1) || (i == 5)) {
        axqy.b(this.app, "dc00898", "", "", "0X800689E", "0X800689E", 0, 0, "", "", "", "");
      }
      if (paramView.h())
      {
        paramView = new Intent(this, PhoneUnityBindInfoActivity.class);
        paramView.putExtra("kSrouce", 1);
        startActivityForResult(paramView, 2001);
        return;
      }
      paramView = new Intent(this, BindNumberActivity.class);
      paramView.putExtra("kSrouce", 1);
      paramView.putExtra("cmd_param_is_from_uni", true);
      startActivityForResult(paramView, 1000000);
      return;
    }
    if (this.jdField_a_of_type_Asej != null) {}
    for (paramView = this.jdField_a_of_type_Asej.c;; paramView = "")
    {
      if (!TextUtils.isEmpty(paramView))
      {
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("uin", this.app.getCurrentAccountUin());
        localIntent.putExtra("url", paramView);
        localIntent.putExtra("hide_more_button", true);
        startActivity(localIntent);
        ThreadManager.post(new QQSettingSettingActivity.8(this), 5, null, false);
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
    bayh localbayh = bayh.a(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (localbayh != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon width =" + localbayh.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon height =" + localbayh.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localbayh, (int)(bbdh.a() * 40.0F), (int)(bbdh.a() * 40.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity
 * JD-Core Version:    0.7.0.1
 */