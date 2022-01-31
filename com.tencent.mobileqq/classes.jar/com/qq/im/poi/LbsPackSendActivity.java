package com.qq.im.poi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aon;
import aoo;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.forward.ForwardLbsHBOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.URLTextImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Random;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class LbsPackSendActivity
  extends LbsPackActivity
  implements View.OnClickListener
{
  protected static long a;
  public int a;
  private Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public LbsPackManager a;
  LbsPackObserver jdField_a_of_type_ComQqImPoiLbsPackObserver = new aon(this);
  public PoiInfo a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private URLTextImageView jdField_a_of_type_ComTencentMobileqqWidgetURLTextImageView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLTextImageView jdField_b_of_type_ComTencentMobileqqWidgetURLTextImageView;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private URLTextImageView jdField_c_of_type_ComTencentMobileqqWidgetURLTextImageView;
  private TextView d;
  
  public LbsPackSendActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComQqImPoiPoiInfo = null;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == this.jdField_c_of_type_Int) {
      return;
    }
    URLTextImageView localURLTextImageView;
    if (this.jdField_c_of_type_Int != 0)
    {
      localURLTextImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetURLTextImageView;
      if (this.jdField_c_of_type_Int == 2)
      {
        localURLTextImageView = this.jdField_b_of_type_ComTencentMobileqqWidgetURLTextImageView;
        label34:
        ViewHelper.b(localURLTextImageView, 1.0F);
        ViewHelper.c(localURLTextImageView, 1.0F);
        localURLTextImageView.setImageResource(2130842559);
        localURLTextImageView.setTextColor(2131493346);
      }
    }
    else
    {
      localURLTextImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetURLTextImageView;
      if (paramInt != 2) {
        break label148;
      }
      localURLTextImageView = this.jdField_b_of_type_ComTencentMobileqqWidgetURLTextImageView;
    }
    for (;;)
    {
      ViewHelper.b(localURLTextImageView, 1.1F);
      ViewHelper.c(localURLTextImageView, 1.1F);
      localURLTextImageView.setImageResource(2130842560);
      localURLTextImageView.setTextColor(2131493347);
      this.jdField_c_of_type_Int = paramInt;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LbsPack", 2, "changeHongBaoPressed " + paramInt);
      return;
      if (this.jdField_c_of_type_Int != 3) {
        break label34;
      }
      localURLTextImageView = this.jdField_c_of_type_ComTencentMobileqqWidgetURLTextImageView;
      break label34;
      label148:
      if (paramInt == 3) {
        localURLTextImageView = this.jdField_c_of_type_ComTencentMobileqqWidgetURLTextImageView;
      }
    }
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    paramActivity.startActivityForResult(new Intent(paramActivity, LbsPackSendActivity.class), paramInt);
  }
  
  private void a(URLTextImageView paramURLTextImageView, String paramString)
  {
    paramURLTextImageView.setOnClickListener(this);
    paramURLTextImageView.setTextSize(DisplayUtil.a(this, 14.0F));
    paramURLTextImageView.e = paramString;
    paramURLTextImageView.setTopPercent(0.8F);
    paramURLTextImageView.setTextColor(2131493346);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370174));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370184);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370180);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    super.findViewById(2131363954).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370183));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370187));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131370186));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131370188));
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable());
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131370189);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370190));
    this.d = ((TextView)super.findViewById(2131370191));
    this.d.setOnClickListener(this);
    this.d.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetURLTextImageView = ((URLTextImageView)super.findViewById(2131370177));
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetURLTextImageView, "左");
    this.jdField_b_of_type_ComTencentMobileqqWidgetURLTextImageView = ((URLTextImageView)super.findViewById(2131370178));
    a(this.jdField_b_of_type_ComTencentMobileqqWidgetURLTextImageView, "中");
    this.jdField_c_of_type_ComTencentMobileqqWidgetURLTextImageView = ((URLTextImageView)super.findViewById(2131370179));
    a(this.jdField_c_of_type_ComTencentMobileqqWidgetURLTextImageView, "右");
    a(new Random().nextInt(3) + 1);
    LbsPackConfig localLbsPackConfig = ((LbsPackManager)this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getManager(214)).jdField_a_of_type_ComQqImPoiLbsPackConfig;
    if (localLbsPackConfig != null) {}
    for (int i = localLbsPackConfig.allFriend;; i = 2)
    {
      if (i == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438768);
        this.jdField_a_of_type_JavaLangString = "-1";
        this.jdField_a_of_type_Int = -1;
      }
      return;
    }
  }
  
  private void f()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      ReportController.b(null, "dc01440", "", "", "0X8007A4E", "0X8007A4E", 0, 0, "", String.valueOf(this.jdField_a_of_type_ComQqImPoiPoiInfo.jdField_a_of_type_Long), "", "");
    }
  }
  
  void a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a(getString(2131438770), -1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComQqImPoiPoiInfo == null)
      {
        if (getString(2131438764).equals(this.jdField_c_of_type_AndroidWidgetTextView.getText()))
        {
          a(getString(2131438763));
          return;
        }
        a(getString(2131438771), -1);
        return;
      }
      if (this.jdField_c_of_type_Int == 0)
      {
        a("没有选择红包位置哦。", -1);
        return;
      }
    } while (this.jdField_a_of_type_ComQqImPoiLbsPackManager == null);
    if (this.jdField_a_of_type_ComQqImPoiLbsPackManager.a(this.jdField_a_of_type_ComQqImPoiPoiInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int))
    {
      c();
      return;
    }
    a(getString(2131438772), -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning()) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt2);
    if (2131438763 != paramInt1)
    {
      a(getString(paramInt1), -1);
      return;
    }
    a(getString(paramInt1));
  }
  
  public void a(PoiInfo paramPoiInfo)
  {
    if (paramPoiInfo != null)
    {
      this.jdField_a_of_type_ComQqImPoiPoiInfo = paramPoiInfo;
      f();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning()) {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComQqImPoiPoiInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    a(2131438763, 2131438764);
  }
  
  void a(String paramString)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setMessage(paramString).setCancelable(true);
    localQQCustomDialog.setNegativeButton(2131432998, null);
    localQQCustomDialog.setPositiveButton(2131438000, new aoo(this, localQQCustomDialog));
    if (!super.isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QQToast.a(this, paramInt, paramString, 0).a();
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, PoiInfo paramPoiInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "CFT_HB_SEND:uin=" + paramString1 + ",uinType=" + paramInt1 + ", pid=" + paramString2 + "poi" + paramPoiInfo.toString());
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      LbsPackStatsCollector.a("actLbsPayBridgeFailure", -10003);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (paramInt1 != -1) {
      if (paramInt1 == 0) {
        paramInt2 = 1;
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("people_num", paramInt2);
        localJSONObject.put("channel", "4096");
        localJSONObject.put("feedsid", paramString2);
        localJSONObject.put("poi", this.jdField_a_of_type_ComQqImPoiLbsPackManager.a(paramPoiInfo));
        paramString2 = "";
        if (paramInt1 != 0) {
          continue;
        }
        paramString2 = "1";
      }
      catch (JSONException paramString1)
      {
        LbsPackStatsCollector.a("actLbsPayBridgeFailure", -10003);
        paramString1.printStackTrace();
        continue;
        if (paramInt1 != 1) {
          continue;
        }
        paramString2 = "3";
        continue;
      }
      localJSONObject.put("recv_type", paramString2);
      localJSONObject.put("recv_uin", paramString1);
      localJSONObject.put("skey", this.jdField_a_of_type_ComQqImPoiLbsPackManager.b());
      localJSONObject.put("skey_type", 2);
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "click HongBao:params=" + localJSONObject.toString());
      }
      paramString1 = new Intent(this, SendHbActivity.class);
      paramString1.putExtra("come_from", 2);
      paramString1.putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#arctc@0006");
      paramString1.putExtra("is_H5", false);
      paramString1.putExtra("extra_data", localJSONObject.toString());
      startActivityForResult(paramString1, 1003);
      return;
      if (paramInt1 != 3000) {
        continue;
      }
      paramString2 = "2";
      continue;
      if (paramInt1 == -1)
      {
        paramString2 = "103";
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getCurrentAccountUin();
      }
    }
  }
  
  void b()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning()) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.start();
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
  }
  
  protected void c()
  {
    try
    {
      if (!super.isFinishing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131437879);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label24:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "LbsPackSendActivity doOnActivityResult");
    }
    if (paramInt1 == 1001)
    {
      if (paramIntent == null) {}
      do
      {
        return;
        paramIntent = paramIntent.getExtras();
        this.jdField_a_of_type_JavaLangString = paramIntent.getString("uin");
        this.jdField_a_of_type_Int = paramIntent.getInt("uintype");
        this.jdField_b_of_type_Int = paramIntent.getInt("forward_extra", 0);
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "count :" + this.jdField_b_of_type_Int);
        }
        paramIntent = paramIntent.getString("uinname");
      } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent);
      return;
    }
    if (paramInt1 == 1003)
    {
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break label534;
      }
      paramIntent = paramIntent.getStringExtra("result");
      if (TextUtils.isEmpty(paramIntent)) {
        break label534;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new JSONObject(paramIntent);
        paramInt1 = paramIntent.getInt("resultCode");
        paramIntent = paramIntent.optString("retmsg");
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "resultCode= " + paramInt1 + "retMsg= " + paramIntent);
        }
        if ((paramInt1 != 0) || (!"SUCCESS".equals(paramIntent))) {
          continue;
        }
        paramIntent = new Intent();
        paramIntent.putExtra("pid", this.jdField_b_of_type_JavaLangString);
        paramIntent.putExtra("send_hb_poi", this.jdField_a_of_type_ComQqImPoiPoiInfo);
        setResult(-1, paramIntent);
        overridePendingTransition(0, 2131034167);
        super.finish();
        LbsPackStatsCollector.a("actLbsPayBridgeFailure");
        paramInt1 = 1;
        if (paramInt1 == 0)
        {
          if (paramInt2 != 0) {
            continue;
          }
          LbsPackStatsCollector.a("actLbsPayBridgeFailure", -10001);
        }
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        paramInt1 = i;
        if (this.jdField_a_of_type_ComQqImPoiPoiInfo == null) {
          continue;
        }
        l = this.jdField_a_of_type_ComQqImPoiPoiInfo.jdField_a_of_type_Long;
        if ((this.jdField_a_of_type_ComQqImPoiPoiInfo == null) || (this.jdField_a_of_type_ComQqImPoiLbsPackManager == null) || (this.jdField_a_of_type_ComQqImPoiLbsPackManager.a() == null)) {
          continue;
        }
        paramInt2 = this.jdField_a_of_type_ComQqImPoiLbsPackManager.a().indexOf(this.jdField_a_of_type_ComQqImPoiPoiInfo);
      }
      catch (JSONException paramIntent)
      {
        long l;
        String str;
        paramInt1 = 0;
        continue;
        paramInt2 = -1;
        continue;
      }
      str = "";
      paramIntent = str;
      if (this.jdField_a_of_type_ComQqImPoiLbsPackManager != null)
      {
        paramIntent = str;
        if (this.jdField_a_of_type_ComQqImPoiLbsPackManager.jdField_a_of_type_JavaLangString != null) {
          paramIntent = this.jdField_a_of_type_ComQqImPoiLbsPackManager.jdField_a_of_type_JavaLangString;
        }
      }
      ReportController.b(null, "dc01440", "", "", "0X8007A83", "0X8007A83", 0, 0, String.valueOf(paramInt1), String.valueOf(l), String.valueOf(paramInt2), paramIntent);
      return;
      try
      {
        LbsPackStatsCollector.a("actLbsPayBridgeFailure", paramInt1);
      }
      catch (JSONException paramIntent)
      {
        paramInt1 = 1;
      }
      paramIntent.printStackTrace();
      continue;
      LbsPackStatsCollector.a("actLbsPayBridgeFailure", -10007);
      continue;
      paramInt1 = 0;
      continue;
      l = 0L;
      continue;
      if ((paramInt1 != 1002) || (paramIntent == null)) {
        break;
      }
      a((PoiInfo)paramIntent.getExtras().getParcelable("select_poi_location"));
      return;
      label534:
      paramInt1 = 0;
    }
  }
  
  public void doOnBackPressed()
  {
    super.finish();
    overridePendingTransition(0, 2131034167);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "LbsPackSendActivity doOnCreate");
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2130970349);
    e();
    getAppRuntime().registObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    this.jdField_a_of_type_ComQqImPoiLbsPackManager = ((LbsPackManager)getAppRuntime().getManager(214));
    if (this.jdField_a_of_type_ComQqImPoiLbsPackManager.a())
    {
      b();
      return true;
    }
    a(2131438763, 2131438764);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "LbsPackSendActivity doOnDestroy");
    }
    this.mSystemBarComp = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
    if (this.jdField_a_of_type_ComQqImPoiLbsPackObserver != null) {
      getAppRuntime().unRegistObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "LbsPackSendActivity doOnResume");
    }
    super.doOnResume();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    if ((l - jdField_a_of_type_Long > 0L) && (l - jdField_a_of_type_Long < 200L)) {}
    int i;
    do
    {
      return;
      jdField_a_of_type_Long = l;
      i = paramView.getId();
      if (2131370184 != i) {
        break;
      }
      if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0)
      {
        if (this.jdField_a_of_type_ComQqImPoiLbsPackManager.a())
        {
          b();
          return;
        }
        a(2131438763, 2131438764);
        return;
      }
    } while (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0);
    LbsPackPoiListActivity.a(this, this.jdField_a_of_type_ComQqImPoiPoiInfo, 1002);
    this.jdField_a_of_type_Boolean = true;
    return;
    if (2131370180 == i)
    {
      paramView = this.jdField_a_of_type_ComQqImPoiLbsPackManager.jdField_a_of_type_ComQqImPoiLbsPackConfig;
      if ((paramView == null) || (paramView.allFriend != 0)) {
        break label224;
      }
    }
    for (;;)
    {
      ForwardLbsHBOption.a(this, 1001, getString(2131438760), bool);
      return;
      if (2131370174 == i)
      {
        a();
        return;
      }
      if (2131370177 == i)
      {
        a(1);
        return;
      }
      if (2131370178 == i)
      {
        a(2);
        return;
      }
      if (2131370179 == i)
      {
        a(3);
        return;
      }
      if ((2131370191 == i) || (2131363954 != i)) {
        break;
      }
      super.finish();
      overridePendingTransition(0, 2131034167);
      return;
      label224:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackSendActivity
 * JD-Core Version:    0.7.0.1
 */