package com.tencent.mobileqq.activity.qwallet;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.jtcode.JtcodeHelper;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import xab;
import xac;
import xad;
import xae;
import xaf;
import xag;
import xah;

public class PayCodeEntryActivity
  extends BaseActivity
{
  private long jdField_a_of_type_Long;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private xah jdField_a_of_type_Xah;
  private boolean jdField_a_of_type_Boolean;
  private String b = "wlx_city_gray_config_";
  
  private String a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1) {
        return "1016";
      }
      return "1017";
    }
    return "";
  }
  
  private void a()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PayCodeEntryActivity", 2, "wlx checkByDbFileExist is exists , go to default wlxpage");
      }
      xag localxag = new xag(this, null);
      localxag.jdField_a_of_type_JavaLangString = "";
      localxag.b = "";
      localxag.c = "乘车码";
      localxag.d = "公交地铁刷码出行";
      localxag.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilArrayList.add(localxag);
      b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PayCodeEntryActivity", 2, "wlx checkByDbFileExist is not exists , go to pay code");
    }
    d();
  }
  
  private boolean a()
  {
    boolean bool = true;
    Object localObject = MD5.toMD5(this.app.getCurrentAccountUin());
    localObject = BaseApplicationImpl.getApplication().getDatabasePath("wlx_" + (String)localObject);
    if ((localObject == null) || (!((File)localObject).exists()))
    {
      QLog.d("PayCodeEntryActivity", 1, "uinFilePath file not exist.");
      bool = false;
    }
    return bool;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    ((TextView)findViewById(2131363381)).setText("付款");
    ((TextView)findViewById(2131363245)).setOnClickListener(new xab(this));
    ((TextView)findViewById(2131368104)).setOnClickListener(new xac(this));
    findViewById(2131368095).setOnClickListener(new xad(this));
    Object localObject1 = (xag)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    findViewById(2131368096).setOnClickListener(new xae(this, (xag)localObject1));
    ((TextView)findViewById(2131368098)).setText(((xag)localObject1).c);
    ((TextView)findViewById(2131368099)).setText(((xag)localObject1).d);
    Object localObject2 = (ImageView)findViewById(2131368097);
    if (((xag)localObject1).jdField_a_of_type_Boolean) {
      ((ImageView)localObject2).setVisibility(0);
    }
    while (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)
    {
      return;
      ((ImageView)localObject2).setVisibility(8);
    }
    localObject1 = (xag)this.jdField_a_of_type_JavaUtilArrayList.get(1);
    localObject2 = findViewById(2131368100);
    ((View)localObject2).setVisibility(0);
    ((View)localObject2).setOnClickListener(new xaf(this, (xag)localObject1));
    ((TextView)findViewById(2131368102)).setText(((xag)localObject1).c);
    ((TextView)findViewById(2131368103)).setText(((xag)localObject1).d);
    localObject2 = (ImageView)findViewById(2131368101);
    if (((xag)localObject1).jdField_a_of_type_Boolean) {
      ((ImageView)localObject2).setVisibility(0);
    }
    for (;;)
    {
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("wlx.plugin.paycode.enterpage.exit");
      this.jdField_a_of_type_Xah = new xah(this, null);
      registerReceiver(this.jdField_a_of_type_Xah, (IntentFilter)localObject1);
      return;
      ((ImageView)localObject2).setVisibility(8);
    }
  }
  
  private boolean b()
  {
    if (SosoInterface.b() != null)
    {
      Object localObject = SosoInterface.b().a;
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaLangString = ((SosoInterface.SosoLocation)localObject).e;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("wlx checkLocationFromQQ; mCurrentCityName=");
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break label85;
          }
        }
        label85:
        for (localObject = this.jdField_a_of_type_JavaLangString;; localObject = "null")
        {
          QLog.d("PayCodeEntryActivity", 2, (String)localObject);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break;
          }
          return false;
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PayCodeEntryActivity", 2, "wlx SosoInterface.getSosoInfo().mLocation is null");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PayCodeEntryActivity", 2, "wlx SosoInterface.getSosoInfo() is null");
    }
    return false;
  }
  
  private void c()
  {
    finish();
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Long != 0L) {
      VACDReportUtil.a(this.jdField_a_of_type_Long, "", "payCodeEntry.jump", null, 0, null);
    }
    String str = this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("srvBundle").getString("entry");
    Intent localIntent = new Intent(this, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=10&entry=" + str + "&seq=" + this.jdField_a_of_type_Long));
    startActivity(localIntent);
    finish();
  }
  
  private void e()
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("wlx parseConfig mCityConfig=");
      if (this.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject1 = this.jdField_a_of_type_OrgJsonJSONObject;
        QLog.d("PayCodeEntryActivity", 2, localObject1);
      }
    }
    else
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        break label62;
      }
    }
    label62:
    Object localObject3;
    label123:
    Object localObject4;
    label148:
    label229:
    label254:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = "null";
            break;
            localObject1 = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("paycode_city_config");
          } while (localObject1 == null);
          localObject2 = ((JSONObject)localObject1).optJSONObject(this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("wlx parseConfig mCurrentCityName=");
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              break label542;
            }
            localObject1 = this.jdField_a_of_type_JavaLangString;
            localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append("; cityConfig=");
            if (localObject2 == null) {
              break label548;
            }
            localObject1 = ((JSONObject)localObject2).toString();
            QLog.d("PayCodeEntryActivity", 2, (String)localObject1);
          }
        } while (localObject2 == null);
        i = ((JSONObject)localObject2).optInt("is_gray", 0);
        localObject3 = ((JSONObject)localObject2).optString("city_code");
        if (i != 1) {
          break label583;
        }
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder().append("wlx parseConfig current city is gray, mCurrentCityName=");
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break label554;
          }
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append("; cityConfig=");
          if (localObject2 == null) {
            break label560;
          }
          localObject1 = ((JSONObject)localObject2).toString();
          QLog.d("PayCodeEntryActivity", 2, (String)localObject1);
        }
        localObject3 = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(this.b + (String)localObject3);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("wlx parseConfig current city is gray, this user is in gray? isGray=");
          if (localObject3 == null) {
            break label566;
          }
          bool = true;
          localObject4 = ((StringBuilder)localObject1).append(bool).append("mCurrentCityName=");
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break label571;
          }
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append("; cityConfig=");
          if (localObject2 == null) {
            break label577;
          }
          localObject1 = ((JSONObject)localObject2).toString();
          QLog.d("PayCodeEntryActivity", 2, (String)localObject1);
        }
      } while (localObject3 == null);
      localObject1 = ((JSONObject)localObject2).optJSONArray("ykt");
    } while ((localObject1 == null) || (((JSONArray)localObject1).length() == 0));
    label327:
    label355:
    label380:
    int i = 0;
    label400:
    label422:
    if (i < ((JSONArray)localObject1).length())
    {
      localObject3 = ((JSONArray)localObject1).optJSONObject(i);
      if (localObject3 != null)
      {
        localObject4 = new xag(this, null);
        ((xag)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("ykt_id");
        ((xag)localObject4).b = ((JSONObject)localObject2).optString("city_code");
        ((xag)localObject4).c = ((JSONObject)localObject3).optString("show_name");
        ((xag)localObject4).d = ((JSONObject)localObject3).optString("show_tips");
        if (((JSONObject)localObject3).optInt("show_icon") != 1) {
          break label674;
        }
      }
    }
    label542:
    label674:
    for (boolean bool = true;; bool = false)
    {
      ((xag)localObject4).jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
      i += 1;
      break label422;
      break;
      localObject1 = "null";
      break label123;
      label548:
      localObject1 = "null";
      break label148;
      label554:
      localObject1 = "null";
      break label229;
      label560:
      localObject1 = "null";
      break label254;
      label566:
      bool = false;
      break label327;
      label571:
      localObject1 = "null";
      break label355;
      label577:
      localObject1 = "null";
      break label380;
      label583:
      if (!QLog.isColorLevel()) {
        break label400;
      }
      localObject3 = new StringBuilder().append("wlx parseConfig current city is all, mCurrentCityName=");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        label619:
        localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append("; cityConfig=");
        if (localObject2 == null) {
          break label668;
        }
      }
      for (localObject1 = ((JSONObject)localObject2).toString();; localObject1 = "null")
      {
        QLog.d("PayCodeEntryActivity", 2, (String)localObject1);
        break;
        localObject1 = "null";
        break label619;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type=").append(paramString2);
    localStringBuilder.append("&qqversion=").append("7.6.3");
    localStringBuilder.append("&city=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&pageid=").append(a());
    localStringBuilder.append("&dotid=").append(a()).append(paramString3);
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = VACDReportUtil.a(null, "qqwallet", "jtCode", paramString1, localStringBuilder.toString(), 0, null);
      return;
    }
    VACDReportUtil.a(this.jdField_a_of_type_Long, null, paramString1, localStringBuilder.toString(), 0, "");
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 102)
    {
      finish();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130969817);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362840));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("vacreport_key_seq", 0L);
      if (this.jdField_a_of_type_Long != 0L) {
        VACDReportUtil.a(this.jdField_a_of_type_Long, "", "payCodeEntry.create", null, 0, null);
      }
    }
    this.jdField_a_of_type_OrgJsonJSONObject = JtcodeHelper.a(getFilesDir().getPath() + "/QWallet/" + this.app.getCurrentAccountUin() + "/hbThemeConfig.cfg");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("wlx config , hbThemeConfig=");
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        break label236;
      }
    }
    label236:
    for (paramBundle = this.jdField_a_of_type_OrgJsonJSONObject.toString();; paramBundle = "null")
    {
      QLog.d("PayCodeEntryActivity", 2, paramBundle);
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PayCodeEntryActivity", 2, "wlx hbThemeConfig is null , go to pay code");
      }
      d();
      return true;
    }
    if (b() == true)
    {
      e();
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PayCodeEntryActivity", 2, "wlx mTypeConfigList is null , go to check db file");
        }
        a();
        return true;
      }
      b();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PayCodeEntryActivity", 2, "wlx location failed , go to check db file");
    }
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Xah != null) {
      unregisterReceiver(this.jdField_a_of_type_Xah);
    }
  }
  
  public void finish()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Long != 0L)) {
      VACDReportUtil.endReport(this.jdField_a_of_type_Long, "payCodeEntry.finish.NoGotoQrCode", null, 0, null);
    }
    super.finish();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a("payCodeEntry.keyback", "actQQWlxclick", "0006");
      c();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PayCodeEntryActivity
 * JD-Core Version:    0.7.0.1
 */