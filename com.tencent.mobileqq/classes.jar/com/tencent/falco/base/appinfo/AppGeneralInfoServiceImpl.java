package com.tencent.falco.base.appinfo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.generalinfo.InfoConfiguration;
import com.tencent.falco.utils.DevOptUtil;
import java.lang.reflect.Field;
import java.util.UUID;

public class AppGeneralInfoServiceImpl
  implements AppGeneralInfoService, InfoConfiguration
{
  private int jdField_a_of_type_Int;
  private Application jdField_a_of_type_AndroidAppApplication;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  private String a()
  {
    Object localObject = "";
    String str2 = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
    try
    {
      String str1 = Build.class.getField("SERIAL").get(null).toString();
      localObject = str1;
      str1 = new UUID(str2.hashCode(), str1.hashCode()).toString();
      return str1;
    }
    catch (Exception localException) {}
    return new UUID(str2.hashCode(), ((String)localObject).hashCode()).toString();
  }
  
  private void a(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
    paramContext.putString("9bbfb5eb37", "1.5.4.117-release_qq_8.5.5");
    paramContext.commit();
    Log.d("AppGeneralInfoService", "initShareBugly end");
  }
  
  public void clearEventOutput() {}
  
  public String getAppId()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public Application getApplication()
  {
    return this.jdField_a_of_type_AndroidAppApplication;
  }
  
  public String getChannelID()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int getClientType()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String getDeviceID()
  {
    if (TextUtils.isEmpty(this.g)) {
      this.g = a();
    }
    return this.g;
  }
  
  public String getFromId()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public String getGuid()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public int getHostVersionCode()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String getHostVersionName()
  {
    return this.h;
  }
  
  public int getOpenSdkAppid()
  {
    Log.d("AppGeneralInfoService", "get opensdk_appid=" + this.jdField_c_of_type_Int + "this=" + this);
    return this.jdField_c_of_type_Int;
  }
  
  public String getSource()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public int getTPPlatform()
  {
    if (this.jdField_f_of_type_Int <= 0) {
      this.jdField_f_of_type_Int = 6900303;
    }
    return this.jdField_f_of_type_Int;
  }
  
  public String getTPPlayerGuid()
  {
    if (TextUtils.isEmpty(this.k)) {
      return "ccyy-yycc-ccyy-yycc-ccyy";
    }
    return this.k;
  }
  
  public String getTargetTestEnv()
  {
    return DevOptUtil.getTargetTestEnvStr(null);
  }
  
  public String getTcloudId()
  {
    return this.i;
  }
  
  public String getTcloudLice()
  {
    return this.j;
  }
  
  public int getVersionCode()
  {
    if (this.jdField_a_of_type_Int <= 0) {
      this.jdField_a_of_type_Int = 10305;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public String getVersionName()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "1.5.4.117-release_qq_8.5.5";
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int getWnsAppid()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public boolean isDebug()
  {
    return false;
  }
  
  public boolean isLiteSdk()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean isNeedInitTPPlatform()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean isRelease()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean isSvrTestEnv()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onCreate(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = DevOptUtil.isTestEnv(paramContext);
    this.g = a();
    a(paramContext);
  }
  
  public void onDestroy() {}
  
  public void setAppId(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void setApplication(Application paramApplication)
  {
    this.jdField_a_of_type_AndroidAppApplication = paramApplication;
  }
  
  public void setChannelID(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setClientType(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setDeviceId(String paramString)
  {
    this.g = paramString;
  }
  
  public void setFromId(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void setHostGuId(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public void setHostVersionCode(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void setHostVersionName(String paramString)
  {
    this.h = paramString;
  }
  
  public void setLiteSdk(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setNeedInitTPPlatform(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setOpenSdkAppId(int paramInt)
  {
    Log.d("AppGeneralInfoService", "opensdk_appid=" + paramInt + "this=" + this);
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setRelease(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setSource(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void setSvrTestEnv(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTPPlatform(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setTcloudConfig(String paramString1, String paramString2)
  {
    this.i = paramString1;
    this.j = paramString2;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setVersionName(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setWnsAppid(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.appinfo.AppGeneralInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */