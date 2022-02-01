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
  private Application a;
  private String b;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  private int g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private int n;
  private int o;
  private String p;
  private int q;
  private boolean r;
  private String s;
  private String t;
  private String u;
  private int v;
  private boolean w = false;
  private boolean x = false;
  
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
    return this.i;
  }
  
  public Application getApplication()
  {
    return this.a;
  }
  
  public String getChannelID()
  {
    if (TextUtils.isEmpty(this.h)) {
      this.h = this.i;
    }
    return this.h;
  }
  
  public int getClientType()
  {
    return this.g;
  }
  
  public String getDeviceID()
  {
    if (TextUtils.isEmpty(this.m)) {
      this.m = a();
    }
    return this.m;
  }
  
  public String getFromId()
  {
    return this.j;
  }
  
  public String getGuid()
  {
    return this.l;
  }
  
  public int getHostVersionCode()
  {
    return this.q;
  }
  
  public String getHostVersionName()
  {
    return this.p;
  }
  
  public int getOpenSdkAppid()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get opensdk_appid=");
    localStringBuilder.append(this.n);
    localStringBuilder.append("this=");
    localStringBuilder.append(this);
    Log.d("AppGeneralInfoService", localStringBuilder.toString());
    return this.n;
  }
  
  public String getSource()
  {
    return this.k;
  }
  
  public int getTPPlatform()
  {
    if (this.v <= 0) {
      this.v = 6900303;
    }
    return this.v;
  }
  
  public String getTPPlayerGuid()
  {
    if (TextUtils.isEmpty(this.u)) {
      return "ccyy-yycc-ccyy-yycc-ccyy";
    }
    return this.u;
  }
  
  public String getTargetTestEnv()
  {
    return DevOptUtil.getTargetTestEnvStr(null);
  }
  
  public String getTcloudId()
  {
    return this.s;
  }
  
  public String getTcloudLice()
  {
    return this.t;
  }
  
  public int getVersionCode()
  {
    if (this.c <= 0) {
      this.c = 10800;
    }
    return this.c;
  }
  
  public String getVersionName()
  {
    if (TextUtils.isEmpty(this.b)) {
      this.b = "1.8.0.158-release_qq_8.6.5";
    }
    return this.b;
  }
  
  public int getWnsAppid()
  {
    return this.o;
  }
  
  public boolean isDebug()
  {
    return false;
  }
  
  public boolean isHoldPlayerLog()
  {
    return this.x;
  }
  
  public boolean isLiteSdk()
  {
    return this.r;
  }
  
  public boolean isNeedInitTPPlatform()
  {
    return this.w;
  }
  
  public boolean isRelease()
  {
    return this.f;
  }
  
  public boolean isSvrTestEnv()
  {
    return this.d;
  }
  
  public void onCreate(Context paramContext)
  {
    this.d = DevOptUtil.isTestEnv(paramContext);
    this.m = a();
    a(paramContext);
  }
  
  public void onDestroy() {}
  
  public void setAppId(String paramString)
  {
    this.i = paramString;
  }
  
  public void setApplication(Application paramApplication)
  {
    this.a = paramApplication;
  }
  
  public void setChannelID(String paramString)
  {
    this.h = paramString;
  }
  
  public void setClientType(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setDeviceId(String paramString)
  {
    this.m = paramString;
  }
  
  public void setFromId(String paramString)
  {
    this.j = paramString;
  }
  
  public void setHostGuId(String paramString)
  {
    this.l = paramString;
  }
  
  public void setHostVersionCode(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setHostVersionName(String paramString)
  {
    this.p = paramString;
  }
  
  public void setIsHoldPlayerLog(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public void setLiteSdk(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void setNeedInitTPPlatform(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void setOpenSdkAppId(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("opensdk_appid=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("this=");
    localStringBuilder.append(this);
    Log.d("AppGeneralInfoService", localStringBuilder.toString());
    this.n = paramInt;
  }
  
  public void setRelease(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setSource(String paramString)
  {
    this.k = paramString;
  }
  
  public void setSvrTestEnv(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setTPPlatform(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void setTcloudConfig(String paramString1, String paramString2)
  {
    this.s = paramString1;
    this.t = paramString2;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setVersionName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setWnsAppid(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.appinfo.AppGeneralInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */