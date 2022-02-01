package com.tencent.biz.common.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class CommonConfigBase
{
  public Context a;
  public String b;
  public int c;
  
  public CommonConfigBase(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = a(paramContext, paramString);
    a(c());
  }
  
  public int a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(b());
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  protected SharedPreferences a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext);
  }
  
  public abstract String a();
  
  protected String a(ConfigurationService.Config paramConfig)
  {
    paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
      if (paramConfig != null) {
        try
        {
          String str = new String(paramConfig, "UTF-8");
          return str;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(localOutOfMemoryError));
          }
          System.gc();
          try
          {
            paramConfig = new String(paramConfig, "UTF-8");
            return paramConfig;
          }
          catch (Throwable paramConfig)
          {
            if (!QLog.isColorLevel()) {
              break label124;
            }
          }
          QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(paramConfig));
        }
        catch (Exception paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(paramConfig));
          }
        }
      }
      label124:
      return null;
    }
    return paramConfig.content.get().toStringUtf8();
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = a(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(b());
    paramContext.putInt(localStringBuilder.toString(), paramInt).commit();
  }
  
  public void a(AppInterface paramAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleConfig type = ");
      localStringBuilder.append(paramConfig.type.get());
      QLog.d("CommonConfigBase", 2, localStringBuilder.toString());
    }
    this.c = a(this.a, paramAppInterface.getCurrentAccountUin());
    int i = paramConfig.version.get();
    if (this.c == i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonConfigBase", 2, "handleConfig version code not changed .");
      }
      return;
    }
    a(this.a, paramAppInterface.getCurrentAccountUin(), i);
    this.c = i;
    paramConfig = b(paramAppInterface, paramConfig);
    if (!TextUtils.isEmpty(paramConfig))
    {
      if (!a(paramAppInterface, paramConfig))
      {
        b(paramConfig);
        a(paramConfig);
      }
    }
    else
    {
      b(paramConfig);
      a(paramConfig);
    }
  }
  
  public abstract void a(String paramString);
  
  public boolean a(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString(d(), "");
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return false;
      }
      paramAppInterface = ((DownloaderFactory)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(".tmp");
      localObject = ((StringBuilder)localObject).toString();
      paramString = new DownloadTask(paramString, new File((String)localObject));
      paramString.e = 3;
      Bundle localBundle = new Bundle();
      localBundle.putString("file_path", (String)localObject);
      paramAppInterface.startDownload(paramString, new CommonConfigBase.1(this), localBundle);
      return true;
    }
    catch (JSONException paramAppInterface) {}
    return false;
  }
  
  public abstract String b();
  
  public String b(AppInterface paramAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleConfig type = ");
      localStringBuilder.append(paramConfig.type.get());
      QLog.d("CommonConfigBase", 2, localStringBuilder.toString());
    }
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() >= 1) && (paramConfig.msg_content_list.get(0) != null)) {
      return a(paramConfig);
    }
    if (QLog.isColorLevel()) {
      QLog.d("CommonConfigBase", 2, "handleQuickShotShareToStoryConfig data is null!!!");
    }
    b(this.a, paramAppInterface.getCurrentAccountUin());
    return null;
  }
  
  public void b(Context paramContext, String paramString)
  {
    paramContext = a(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(b());
    paramContext.remove(localStringBuilder.toString()).commit();
  }
  
  public void b(String paramString)
  {
    Object localObject = a(this.a);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = ((SharedPreferences)localObject).edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(a());
      paramString.remove(((StringBuilder)localObject).toString());
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(a());
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).commit();
  }
  
  public String c()
  {
    SharedPreferences localSharedPreferences = a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(a());
    return localSharedPreferences.getString(localStringBuilder.toString(), null);
  }
  
  public String d()
  {
    return "more_config_url";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.config.CommonConfigBase
 * JD-Core Version:    0.7.0.1
 */