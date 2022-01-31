package com.tencent.mobileqq.activity.qwallet;

import alud;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import azri;
import bdao;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import cooperation.qwallet.plugin.QWalletHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class QrcodeHbGuiderActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 2;
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  
  public QrcodeHbGuiderActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void c()
  {
    new ImmersionBar(this, -468046, findViewById(2131377007));
    d();
    e();
    f();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131373050));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368670));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131711585));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368655));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131711584));
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaLangString = this.app.c();
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("app_info");
    this.jdField_a_of_type_Long = getIntent().getLongExtra("vacreport_key_seq", 0L);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "GuiderAct.create", "", 0, null);
    }
    for (;;)
    {
      String str = getIntent().getStringExtra("from_plugin");
      this.jdField_c_of_type_JavaLangString = str;
      if ((!TextUtils.isEmpty(str)) && ("131".equals(str))) {
        this.jdField_a_of_type_Int = 1;
      }
      if (TextUtils.isEmpty(str))
      {
        a(QWalletHelper.readQRTokenConfig(this, this.jdField_a_of_type_JavaLangString), "");
        this.jdField_a_of_type_Boolean = false;
        finish();
      }
      return;
      VACDReportUtil.a(this.jdField_a_of_type_Long, null, "GuiderAct.create", null, 0, null);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a()
  {
    long l = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", null, 0, null);
    Intent localIntent = new Intent();
    localIntent.setClass(this, SendHbActivity.class);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", "2048");
      localJSONObject.put("recv_uin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("extra_data", localJSONObject.toString());
      localIntent.putExtra("come_from", 2);
      localIntent.putExtra("app_info", this.jdField_b_of_type_JavaLangString);
      localIntent.addFlags(536870912);
      localIntent.putExtra("vacreport_key_seq", l);
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tenpay_mqq");
    localStringBuilder.append("|");
    localStringBuilder.append(str);
    localStringBuilder.append("||");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|0|1|0|android.");
    try
    {
      localStringBuilder.append(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
      localStringBuilder.append("|");
      localStringBuilder.append(bdao.a());
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(".");
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString.replace("|", ","));
      }
      localStringBuilder.append("|");
      VACDReportUtil.a(this.jdField_a_of_type_Long, null, paramString, "op_type=" + this.jdField_c_of_type_JavaLangString, 0, "");
      azri.a(BaseApplication.getContext()).b(this.app, localStringBuilder.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = new JSONObject();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    try
    {
      paramString2.put("userId", this.jdField_a_of_type_JavaLangString);
      paramString2.put("viewTag", "qrcodeHb");
      paramString2.put("comeForm", 2);
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.putOpt("qrToken", paramString1);
      }
      paramString2.put("extra_data", localJSONObject.toString());
      paramString1 = new Bundle();
      paramString1.putString("json", paramString2.toString());
      paramString1.putString("callbackSn", "0");
      paramString1.putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
      PayBridgeActivity.a(this, 5, paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("viewTag", "redgiftRecord");
      localJSONObject.put("comeForm", 2);
      localJSONObject.put("extra_data", new JSONObject().toString());
      Bundle localBundle = new Bundle();
      localBundle.putString("json", localJSONObject.toString());
      localBundle.putString("callbackSn", "0");
      localBundle.putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
      PayBridgeActivity.a(this, 5, localBundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2131560365);
    c();
    a("face2face.index.show");
    return true;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Long != 0L)) {
      VACDReportUtil.endReport(this.jdField_a_of_type_Long, "GuiderAct.finish", null, 0, null);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131373050: 
      a();
      a("face2face.index.go");
      finish();
      return;
    case 2131368624: 
      a("face2face.index.back");
      finish();
      return;
    }
    b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a("face2face.index.keyback");
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity
 * JD-Core Version:    0.7.0.1
 */