package com.tencent.gamecenter.wadl.api.impl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlBaseConfig;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGameConfigServiceImpl
  implements IQQGameConfigService
{
  public static final String CONF_FILE = "conf.json";
  public static final short FAIL_LIMIT = 3;
  public static final String GAME_CENTER_MONITOR_REPORT = "gc_monitor_report.report_public_acct_info";
  public static final String GC_CONF_DIR = "gc_conf";
  public static final long INVALID_TIME = 86400000L;
  public static final String KEY_CONF_COMM = "comminfo";
  private static final String TAG = "Wadl_QQGameConfigServiceImpl";
  public static final long UNCHECK = -1L;
  private HashMap<String, WadlBaseConfig> confMap = new HashMap();
  private short updateConfFailCount = 0;
  private long updateConfTime = -1L;
  
  public QQGameConfigServiceImpl()
  {
    loadConfig();
    GameCenterReceiver.b();
  }
  
  public static File getConfDir()
  {
    File localFile = new File(MobileQQ.sMobileQQ.getFilesDir(), "gc_conf");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void checkConfigUpdate(boolean paramBoolean, long paramLong)
  {
    ThreadManagerV2.excute(new QQGameConfigServiceImpl.2(this, paramBoolean, paramLong), 16, null, false);
  }
  
  public <T> T getConfig(String paramString)
  {
    return this.confMap.get(paramString);
  }
  
  public File getConfigFile()
  {
    return new File(getConfDir(), "conf.json");
  }
  
  public void handlePushConfigCheck(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l2 = -1L;
    long l1 = l2;
    if (!bool) {
      try
      {
        l1 = new JSONObject(paramString).optLong("version", -1L);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        l1 = l2;
      }
    }
    checkConfigUpdate(true, l1);
  }
  
  public void loadConfig()
  {
    ThreadManagerV2.excute(new QQGameConfigServiceImpl.1(this), 64, null, false);
  }
  
  public void requestConfig(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestConfig currVersion=");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("Wadl_QQGameConfigServiceImpl", 1, ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("op_version", paramLong);
      ((JSONObject)localObject).put("req", localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestWebSso("13136", (JSONObject)localObject, null);
  }
  
  public void writeConfig(boolean paramBoolean, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("writeConfig...newVersion=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",content=");
    localStringBuilder.append(paramString);
    QLog.d("Wadl_QQGameConfigServiceImpl", 1, localStringBuilder.toString());
    if (!paramBoolean)
    {
      this.updateConfFailCount = ((short)(this.updateConfFailCount + 1));
    }
    else
    {
      this.updateConfFailCount = 0;
      this.updateConfTime = System.currentTimeMillis();
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong < 0L) {
        return;
      }
      ThreadManagerV2.excute(new QQGameConfigServiceImpl.3(this, paramString, paramLong), 16, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameConfigServiceImpl
 * JD-Core Version:    0.7.0.1
 */