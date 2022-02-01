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
import com.tencent.falco.utils.ThreadCenter;
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
  private boolean jdField_f_of_type_Boolean = false;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  private String a()
  {
    Object localObject1 = "";
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("35");
    ((StringBuilder)localObject2).append(Build.BOARD.length() % 10);
    ((StringBuilder)localObject2).append(Build.BRAND.length() % 10);
    ((StringBuilder)localObject2).append(Build.CPU_ABI.length() % 10);
    ((StringBuilder)localObject2).append(Build.DEVICE.length() % 10);
    ((StringBuilder)localObject2).append(Build.DISPLAY.length() % 10);
    ((StringBuilder)localObject2).append(Build.HOST.length() % 10);
    ((StringBuilder)localObject2).append(Build.ID.length() % 10);
    ((StringBuilder)localObject2).append(Build.MANUFACTURER.length() % 10);
    ((StringBuilder)localObject2).append(Build.MODEL.length() % 10);
    ((StringBuilder)localObject2).append(Build.PRODUCT.length() % 10);
    ((StringBuilder)localObject2).append(Build.TAGS.length() % 10);
    ((StringBuilder)localObject2).append(Build.TYPE.length() % 10);
    ((StringBuilder)localObject2).append(Build.USER.length() % 10);
    String str = ((StringBuilder)localObject2).toString();
    try
    {
      localObject2 = Build.class.getField("SERIAL").get(null).toString();
      localObject1 = localObject2;
      localObject2 = new UUID(str.hashCode(), ((String)localObject2).hashCode()).toString();
      return localObject2;
    }
    catch (Exception localException)
    {
      label245:
      break label245;
    }
    return new UUID(str.hashCode(), ((String)localObject1).hashCode()).toString();
  }
  
  private void a(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
    paramContext.putString("9bbfb5eb37", "1.8.0.158-release_qq_8.6.5");
    ThreadCenter.postLogicTask(new AppGeneralInfoServiceImpl.1(this, paramContext));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get opensdk_appid=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("this=");
    localStringBuilder.append(this);
    Log.d("AppGeneralInfoService", localStringBuilder.toString());
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
      this.jdField_a_of_type_Int = 10800;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public String getVersionName()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "1.8.0.158-release_qq_8.6.5";
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
  
  public boolean isHoldPlayerLog()
  {
    return this.jdField_f_of_type_Boolean;
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
  
  public void setIsHoldPlayerLog(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("opensdk_appid=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("this=");
    localStringBuilder.append(this);
    Log.d("AppGeneralInfoService", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.appinfo.AppGeneralInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */