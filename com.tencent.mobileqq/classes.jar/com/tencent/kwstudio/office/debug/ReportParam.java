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
    this.appVer = (getVersionName() + '.' + getVersionCode());
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
    return "ret_code" + '=' + this.retCode + ',' + "time_cost" + '=' + this.timeCost + ',' + "user_id" + '=' + this.userId + ',' + "terminal" + '=' + this.terminal + ',' + "app_name" + '=' + this.appName + ',' + "app_ver" + '=' + this.appVer + ',' + "platform_name" + '=' + this.platformName + ',' + "platform_ver" + '=' + this.platformVer;
  }
  
  public String getFlow()
  {
    Pair localPair = (Pair)Reporter.OP_CMDS.get(this.opId);
    if ((localPair == null) || (TextUtils.isEmpty(this.userId))) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder().append("uin").append('=');
    if (TextUtils.isDigitsOnly(this.userId)) {}
    for (long l = Long.parseLong(this.userId);; l = this.userId.hashCode()) {
      return l + '&' + "cmd" + '=' + localPair.first + '&' + "sub_cmd" + '=' + localPair.second + '&' + "log_content" + '=' + getContent();
    }
  }
  
  public String getOp()
  {
    return "src_id" + '=' + this.srcId + '&' + "op" + '=' + this.opId + '&' + "ret_code" + '=' + this.retCode + '&' + "time_cost" + '=' + this.timeCost;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.ReportParam
 * JD-Core Version:    0.7.0.1
 */