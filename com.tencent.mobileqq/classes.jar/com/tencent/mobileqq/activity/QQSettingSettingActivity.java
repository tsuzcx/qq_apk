package com.tencent.mobileqq.activity;

import Override;
import aesn;
import aeso;
import aesp;
import aesq;
import aesr;
import aess;
import aest;
import agij;
import ajco;
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
import anri;
import ansi;
import anvi;
import anvk;
import anvx;
import anxv;
import aoae;
import aodi;
import aodj;
import aqwg;
import avpm;
import awtc;
import awtf;
import awty;
import awyz;
import ayqy;
import bbbq;
import bdla;
import bgvx;
import bksu;
import blfw;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
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
import ntb;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final boolean jdField_c_of_type_Boolean = AppSetting.jdField_c_of_type_Boolean;
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aesq(this);
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplication.getContext().getResources();
  private Bundle jdField_a_of_type_AndroidOsBundle;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private ansi jdField_a_of_type_Ansi = new aess(this);
  anvi jdField_a_of_type_Anvi = new aeso(this);
  aodj jdField_a_of_type_Aodj = new aesr(this);
  awtf jdField_a_of_type_Awtf = null;
  private ayqy jdField_a_of_type_Ayqy = new aesn(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aesp(this);
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
  private RedTouch jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch;
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694557);
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694558);
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
      ajco.a(this.app, "0X800B327", paramBundle);
      return;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694557);
      break;
      i = 0;
      break label195;
    }
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      bbbq localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a("100190.100199");
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.c(localAppInfo);
      i();
      localbbbq.a(localAppInfo);
    }
  }
  
  private void b(Card paramCard)
  {
    Object localObject = aqwg.a(this.app.getCurrentUin(), "hide_qq_xman");
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
      paramCard = findViewById(2131374542);
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
    if ((this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.c()))
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
      bbbq localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a("100190.100191");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localbbbq.a(localAppInfo);
    }
  }
  
  private void c(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (anxv.a())
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
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      bbbq localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a("100190.100193");
      if (localAppInfo != null) {
        localbbbq.a("100190.100193", 30);
      }
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    }
  }
  
  private void e()
  {
    avpm.a().a(this.app, this, 101810106, "setFaceData", null);
  }
  
  private void f()
  {
    View localView = findViewById(2131370080);
    if (!TextUtils.isEmpty(AboutActivity.b()))
    {
      if (Integer.parseInt(AboutActivity.b()) == 5)
      {
        localView.setVisibility(0);
        a(2131370080, 2131698795, 0, 2130839496);
        return;
      }
      ArkIDESettingFragment.a().c();
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void g()
  {
    View localView = findViewById(2131361811);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130850430);
    boolean bool = a();
    if (bool) {
      a(localView, 0, localDrawable);
    }
    for (;;)
    {
      if ((!bool) && (aoae.a(1))) {
        a(localView, 0, this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130850427));
      }
      return;
      a(localView, 8, localDrawable);
    }
  }
  
  private void h()
  {
    ((ImageView)findViewById(2131374541).findViewById(2131380452)).setVisibility(8);
  }
  
  private void i()
  {
    ThreadManager.post(new QQSettingSettingActivity.7(this), 8, null, true);
  }
  
  private void j()
  {
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(bksu.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.a());
    ntb.a(this.app, new aest(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  private void k()
  {
    if (!this.f)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (localFriendListHandler != null) {
        localFriendListHandler.getSelfXManInfoScene2();
      }
      this.f = true;
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
      return;
    }
    if ((this.jdField_a_of_type_Awtf != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Awtf.a)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      if (anxv.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(this.jdField_a_of_type_Awtf.a);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBackgroundResource(2130839496);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_b_of_type_Boolean = true;
        ThreadManager.post(new QQSettingSettingActivity.13(this), 5, null, false);
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getText(2131698799));
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
        Object localObject = (TextView)localView.findViewById(2131374552);
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
          if (paramInt4 != 2130839512) {
            break label213;
          }
          ((FormItemRelativeLayout)localObject).setBGType(1);
        }
        for (;;)
        {
          if (paramInt1 != 2131374535) {
            break label230;
          }
          this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).d(30).a();
          b();
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)localView);
          localView.findViewById(2131373255).setVisibility(8);
          localView.findViewById(2131365579).setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365578));
          if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          if (paramInt4 == 2130839506) {
            ((FormItemRelativeLayout)localObject).setBGType(2);
          }
        }
        if (paramInt1 == 2131374543)
        {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).d(30).a();
          c();
          localView.findViewById(2131373255).setVisibility(8);
          localView.findViewById(2131365579).setVisibility(8);
          ((TextView)localView.findViewById(2131365578)).setVisibility(8);
          return;
        }
        if (paramInt1 != 2131374542) {
          break;
        }
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365578));
        if (this.jdField_c_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131694557);
          if (jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(null);
          }
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131373255));
        if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365579));
      } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850427);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    } while ((paramInt1 == 2131374541) || (!jdField_c_of_type_Boolean));
    localView.setContentDescription(getString(paramInt2));
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131374553);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131374554)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131374548);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  void a(Card paramCard)
  {
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText(" ");
    if (paramCard.lLoginDays >= FriendProfileCardActivity.jdField_a_of_type_Long)
    {
      if (this.jdField_a_of_type_ComTencentWidgetThemeImageView != null) {
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(getResources().getDrawable(2130850823));
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(-155129);
      if (jdField_c_of_type_Boolean)
      {
        String str2 = getString(2131691184);
        String str1 = str2;
        if (paramCard.allowPeopleSee) {
          str1 = str2 + paramCard.lLoginDays + getString(2131691185);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(str1);
      }
      if (!paramCard.allowPeopleSee) {
        break label223;
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(3.0F);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.append(paramCard.lLoginDays + anvx.a(2131691419));
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a(8.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.c();
      return;
      if (this.jdField_a_of_type_ComTencentWidgetThemeImageView != null) {
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(getResources().getDrawable(2130850822));
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
        anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localanvk != null) {
          ThreadManager.post(new QQSettingSettingActivity.12(this, localanvk, paramString), 8, null, true);
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
    ajco localajco = (ajco)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    if ((System.currentTimeMillis() - localajco.jdField_a_of_type_Long > 1800000L) || (localajco.jdField_a_of_type_Boolean) || (paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      aodi localaodi = (aodi)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      Locale localLocale;
      if (QLog.isColorLevel())
      {
        localLocale = Locale.getDefault();
        if (localaodi != null) {
          break label203;
        }
      }
      label203:
      for (String str = "null";; str = "is not null")
      {
        QLog.i("QQSetting2Activity", 2, String.format(localLocale, "startGetPhoneUnityStatus force: %s, need: %s, h: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), str }));
        if ((!bool) || (localaodi == null)) {
          break;
        }
        this.jdField_a_of_type_Int += 1;
        localajco.jdField_a_of_type_Long = System.currentTimeMillis();
        localajco.jdField_a_of_type_Boolean = false;
        localaodi.a(1);
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
      a(true, localajco.jdField_a_of_type_AndroidOsBundle);
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
      awty localawty = (awty)this.app.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER);
      if (localawty == null) {
        break;
      }
      return localawty.a();
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
        a(true, ((ajco)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).jdField_a_of_type_AndroidOsBundle);
        return;
      }
      if (paramInt1 == 2002)
      {
        this.d = false;
        a(true);
        return;
      }
    } while ((paramInt1 != 1000000) || (!((awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).i()));
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
    super.setContentView(2131561509);
    setTitle(getString(2131698849));
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      paramBundle = getString(2131698849);
      this.centerView.setContentDescription(paramBundle);
    }
    setContentBackgroundResource(2130838911);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131361924));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131698793));
    if (jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131698793));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a()).b(53).a();
    a(2131374542, 2131698836, 0, 2130839506);
    a(2131374535, 2131698800, 0, 2130839503);
    paramBundle = (FormSimpleItem)findViewById(2131374540);
    paramBundle.a().setText(2131698833);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramBundle;
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = new ThemeImageView(getBaseContext());
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(blfw.c);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(UIUtils.dip2px(this.app.getApp(), 47.0F), UIUtils.dip2px(this.app.getApp(), 21.0F));
    localLayoutParams.addRule(0, 2131367208);
    localLayoutParams.setMargins(0, UIUtils.dip2px(this.app.getApp(), 14.0F), 0, 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetThemeImageView, localLayoutParams);
    paramBundle.setOnClickListener(this);
    a(2131374539, 2131698820, 0, 2130839512);
    a(2131374541, 2131698835, 0, 2130839506);
    a(2131374536, 2131698805, 0, 2130839506);
    a(2131374534, 2131698796, 0, 2130839503);
    a(2131361811, 2131698792, 0, 2130839496);
    paramBundle = FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon width =" + paramBundle.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon height =" + paramBundle.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(paramBundle, (int)(DeviceInfoUtil.getDesity() * 40.0F), (int)(DeviceInfoUtil.getDesity() * 40.0F));
    }
    this.app.addObserver(this.jdField_a_of_type_Ansi);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_Anvi);
    addObserver(this.jdField_a_of_type_Aodj);
    this.app.registObserver(this.jdField_a_of_type_Ayqy);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = bgvx.a().a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131374174));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374172));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374173));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ((anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).n();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365344));
    paramBundle = (awtc)this.app.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER);
    if (paramBundle.a())
    {
      this.jdField_a_of_type_Awtf = paramBundle.a(0);
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "cu_open_card_guide has init entry: %s ", new Object[] { this.jdField_a_of_type_Awtf }));
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
      this.jdField_a_of_type_Awtf = null;
      ThreadManager.post(new QQSettingSettingActivity.5(this), 5, null, true);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Anvi);
    this.app.removeObserver(this.jdField_a_of_type_Ansi);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_Aodj);
    this.app.unRegistObserver(this.jdField_a_of_type_Ayqy);
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
      int i = getResources().getColor(2131167084);
      this.mSystemBarComp.setStatusColor(i);
    }
    super.doOnResume();
    h();
    c();
    d();
    b();
    i();
    ((ajco)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).a();
    k();
    f();
    g();
    a(this.app.getCurrentAccountUin());
    e();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.addObserver(this.jdField_a_of_type_Ansi);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_Anvi);
    addObserver(this.jdField_a_of_type_Aodj);
    FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (localFaceDrawable != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon width =" + localFaceDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon height =" + localFaceDrawable.getMinimumHeight());
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localFaceDrawable, (int)(DeviceInfoUtil.getDesity() * 40.0F), (int)(DeviceInfoUtil.getDesity() * 40.0F));
    }
    a(true);
    b();
    i();
    a(this.app.getCurrentAccountUin());
  }
  
  public boolean onBackEvent()
  {
    agij.c(this, SplashActivity.class);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131361924: 
    case 2131374539: 
    case 2131374541: 
    case 2131374535: 
    case 2131374536: 
    case 2131374534: 
    case 2131370080: 
    case 2131361811: 
    case 2131374540: 
    case 2131374542: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        startActivity(new Intent(this, AccountManageActivity.class));
        bdla.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
        ((bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100190.100193");
        continue;
        startActivity(new Intent(getActivity(), NotifyPushSettingActivity.class));
        bdla.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), PermisionPrivacyActivity.class));
        bdla.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
        continue;
        startActivityForResult(new Intent(getActivity(), LoginInfoActivity.class), 0);
        bdla.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), GeneralSettingActivity.class));
        bdla.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C04", 0, 0, "", "", "", "");
        continue;
        startActivity(new Intent(getActivity(), AssistantSettingActivity.class));
        bdla.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
        continue;
        PublicFragmentActivity.a(this, new Intent(), ArkIDESettingFragment.class);
        continue;
        startActivity(new Intent(getActivity(), AboutActivity.class));
        if (a()) {
          bdla.b(this.app, "CliOper", "", "", "0X8004DB1", "0X8004DB1", 0, 0, "", "", bgvx.a(), "");
        }
        bdla.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
        continue;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=set");
        ((Intent)localObject).putExtra("hide_more_button", true);
        startActivity((Intent)localObject);
        bdla.b(this.app, "CliOper", "", "", "0X800487F", "0X800487F", 0, 0, "", "", "", "");
        continue;
        bdla.b(this.app, "CliOper", "", "", "0X8005DEA", "0X8005DEA", 0, 0, "", "", "", "");
        bdla.b(this.app, "dc00898", "", "", "0X800689D", "0X800689D", 0, 0, "", "", "", "");
        int i = ((awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).d();
        if ((i == 1) || (i == 5)) {
          bdla.b(this.app, "dc00898", "", "", "0X800689E", "0X800689E", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_AndroidOsBundle == null)
        {
          QQToast.a(getApplicationContext(), getString(2131694563), 0).b(getTitleBarHeight());
        }
        else if (this.jdField_a_of_type_AndroidOsBundle.getInt("check_result") == 1)
        {
          localObject = this.jdField_a_of_type_AndroidOsBundle.getString("mibao_set_url");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            ajco.a(this.app, "0X800B328", this.jdField_a_of_type_AndroidOsBundle);
            this.d = true;
            ajco.a(this, this.app, (String)localObject, 2002);
          }
          else
          {
            QLog.e("QQSetting2Activity", 4, "mb set url is null.");
          }
        }
        else
        {
          ajco.a(this.app, "0X800B328", this.jdField_a_of_type_AndroidOsBundle);
          localObject = new Intent(this, PhoneUnityBindInfoActivity.class);
          ((Intent)localObject).putExtra("kSrouce", 1);
          if (this.jdField_a_of_type_AndroidOsBundle != null) {
            ((Intent)localObject).putExtra("kBindPhoneData", this.jdField_a_of_type_AndroidOsBundle);
          }
          startActivityForResult((Intent)localObject, 2001);
        }
      }
    }
    if (this.jdField_a_of_type_Awtf != null) {}
    for (Object localObject = this.jdField_a_of_type_Awtf.c;; localObject = "")
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
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localFaceDrawable, (int)(DeviceInfoUtil.getDesity() * 40.0F), (int)(DeviceInfoUtil.getDesity() * 40.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity
 * JD-Core Version:    0.7.0.1
 */