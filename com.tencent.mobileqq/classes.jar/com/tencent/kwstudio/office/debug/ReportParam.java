package com.tencent.kwstudio.office.debug;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.kwstudio.office.base.Global;
import com.tencent.kwstudio.office.preview.IHostInterface;
import java.util.Map;

public class ReportParam
{
  public static final char CHAR_ASSIGN = '=';
  public static final char CHAR_JOINER = '&';
  public static final char CHAR_SEPARATOR = ',';
  private static final String KEY_APP_NAME = "app_name";
  private static final String KEY_APP_VER = "app_ver";
  public static final String KEY_CMD = "cmd";
  public static final String KEY_LOG_CONTENT = "log_content";
  public static final String KEY_OP = "op";
  private static final String KEY_PLATFORM_NAME = "platform_name";
  private static final String KEY_PLATFORM_VER = "platform_ver";
  public static final String KEY_RET_CODE = "ret_code";
  public static final String KEY_SRC_ID = "src_id";
  public static final String KEY_SUB_CMD = "sub_cmd";
  private static final String KEY_TERMINAL = "terminal";
  public static final String KEY_TIME_COST = "time_cost";
  public static final String KEY_UIN = "uin";
  private static final String KEY_USER_ID = "user_id";
  private static volatile String sVersionCode;
  private static volatile String sVersionName;
  private final String appName;
  private final String appVer;
  private final String opId;
  private final String platformName;
  private final int platformVer;
  public volatile int retCode;
  private final String srcId = Noumenon.sHostInterface.getAppId();
  private final String terminal;
  private volatile long timeCost = -1L;
  private volatile long timeStart;
  private final String userId;
  
  public ReportParam(String paramString)
  {
    this.opId = paramString;
    this.terminal = "Android";
    this.appName = Global.getApplicationContext().getPackageName();
    paramString = new StringBuilder();
    paramString.append(getVersionName());
    paramString.append('.');
    paramString.append(getVersionCode());
    this.appVer = paramString.toString();
    this.platformName = Build.MODEL;
    this.platformVer = Build.VERSION.SDK_INT;
    this.userId = Noumenon.sHostInterface.getUserId();
  }
  
  private static String getVersionCode()
  {
    if (sVersionCode == null) {}
    try
    {
      Context localContext = Global.getApplicationContext();
      sVersionCode = Integer.toString(localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0).versionCode);
      label31:
      return sVersionCode;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  private static String getVersionName()
  {
    if (sVersionName == null) {}
    try
    {
      Object localObject = Global.getApplicationContext();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        sVersionName = (String)localObject;
      }
      label37:
      return sVersionName;
    }
    catch (Exception localException)
    {
      break label37;
    }
  }
  
  public void endTime()
  {
    this.timeCost = (SystemClock.elapsedRealtime() - this.timeStart);
  }
  
  protected String getContent()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ret_code");
    localStringBuilder.append('=');
    localStringBuilder.append(this.retCode);
    localStringBuilder.append(',');
    localStringBuilder.append("time_cost");
    localStringBuilder.append('=');
    localStringBuilder.append(this.timeCost);
    localStringBuilder.append(',');
    localStringBuilder.append("user_id");
    localStringBuilder.append('=');
    localStringBuilder.append(this.userId);
    localStringBuilder.append(',');
    localStringBuilder.append("terminal");
    localStringBuilder.append('=');
    localStringBuilder.append(this.terminal);
    localStringBuilder.append(',');
    localStringBuilder.append("app_name");
    localStringBuilder.append('=');
    localStringBuilder.append(this.appName);
    localStringBuilder.append(',');
    localStringBuilder.append("app_ver");
    localStringBuilder.append('=');
    localStringBuilder.append(this.appVer);
    localStringBuilder.append(',');
    localStringBuilder.append("platform_name");
    localStringBuilder.append('=');
    localStringBuilder.append(this.platformName);
    localStringBuilder.append(',');
    localStringBuilder.append("platform_ver");
    localStringBuilder.append('=');
    localStringBuilder.append(this.platformVer);
    return localStringBuilder.toString();
  }
  
  public String getFlow()
  {
    Pair localPair = (Pair)Reporter.OP_CMDS.get(this.opId);
    if ((localPair != null) && (!TextUtils.isEmpty(this.userId)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin");
      localStringBuilder.append('=');
      long l;
      if (TextUtils.isDigitsOnly(this.userId)) {
        l = Long.parseLong(this.userId);
      } else {
        l = this.userId.hashCode();
      }
      localStringBuilder.append(l);
      localStringBuilder.append('&');
      localStringBuilder.append("cmd");
      localStringBuilder.append('=');
      localStringBuilder.append(localPair.first);
      localStringBuilder.append('&');
      localStringBuilder.append("sub_cmd");
      localStringBuilder.append('=');
      localStringBuilder.append(localPair.second);
      localStringBuilder.append('&');
      localStringBuilder.append("log_content");
      localStringBuilder.append('=');
      localStringBuilder.append(getContent());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String getOp()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("src_id");
    localStringBuilder.append('=');
    localStringBuilder.append(this.srcId);
    localStringBuilder.append('&');
    localStringBuilder.append("op");
    localStringBuilder.append('=');
    localStringBuilder.append(this.opId);
    localStringBuilder.append('&');
    localStringBuilder.append("ret_code");
    localStringBuilder.append('=');
    localStringBuilder.append(this.retCode);
    localStringBuilder.append('&');
    localStringBuilder.append("time_cost");
    localStringBuilder.append('=');
    localStringBuilder.append(this.timeCost);
    return localStringBuilder.toString();
  }
  
  public long getTimeCost()
  {
    return this.timeCost;
  }
  
  public void markTime()
  {
    this.timeStart = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.ReportParam
 * JD-Core Version:    0.7.0.1
 */