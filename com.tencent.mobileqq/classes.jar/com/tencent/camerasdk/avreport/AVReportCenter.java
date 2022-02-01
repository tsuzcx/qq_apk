package com.tencent.camerasdk.avreport;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings.Secure;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AVReportCenter
{
  private static final String TAG;
  private static final AVReportCenter ourInstance = new AVReportCenter();
  private String app;
  private Boolean auto = Boolean.valueOf(true);
  private Context context;
  private String dir;
  private boolean enable = true;
  private String imei;
  private volatile Handler ioHandler;
  private volatile HandlerThread ioThread;
  private String os;
  private Reporter reporter;
  private String tmpDir;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVReportCenter-");
    localStringBuilder.append(Integer.toHexString(AVReportCenter.class.hashCode()));
    TAG = localStringBuilder.toString();
  }
  
  public static AVReportCenter getInstance()
  {
    return ourInstance;
  }
  
  private void hibernate(String paramString)
  {
    hibernate(paramString, "bean");
  }
  
  private void hibernate(String paramString1, String paramString2)
  {
    Object localObject = this.dir;
    if ((localObject != null) && (((String)localObject).length() != 0)) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.tmpDir);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(System.nanoTime());
        localObject = new File(((StringBuilder)localObject).toString());
        FileOutputStream localFileOutputStream = new FileOutputStream((File)localObject);
        localFileOutputStream.write(paramString1.getBytes());
        localFileOutputStream.close();
        paramString1 = new StringBuilder();
        paramString1.append(this.dir);
        paramString1.append(File.separator);
        paramString1.append(paramString2);
        paramString1.append(".");
        paramString1.append(System.nanoTime());
        ((File)localObject).renameTo(new File(paramString1.toString()));
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    AVRLogUtils.e(TAG, "hibernate: dir is empty");
  }
  
  private static String toUrlParams(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = "attaid=06400000136&token=3598698434";
    Map<String, Object> localMap;
    for (;;)
    {
      localMap = paramMap;
      if (!localIterator.hasNext()) {
        break;
      }
      paramMap = (Map.Entry)localIterator.next();
      Object localObject = paramMap.getValue();
      String str = (String)paramMap.getKey();
      if ((localObject instanceof Number))
      {
        paramMap = new StringBuilder();
        paramMap.append(localMap);
        paramMap.append("&");
        paramMap.append(str);
        paramMap.append("=");
        paramMap.append(localObject.toString());
        paramMap = paramMap.toString();
      }
      else
      {
        paramMap = localMap;
        if ((localObject instanceof String)) {
          try
          {
            paramMap = new StringBuilder();
            paramMap.append(localMap);
            paramMap.append("&");
            paramMap.append(str);
            paramMap.append("=");
            paramMap.append(URLEncoder.encode(localObject.toString(), "UTF-8"));
            paramMap = paramMap.toString();
          }
          catch (UnsupportedEncodingException paramMap)
          {
            paramMap.printStackTrace();
            paramMap = localMap;
          }
        }
      }
    }
    return localMap;
  }
  
  public void commit(BaseBean paramBaseBean)
  {
    commit(paramBaseBean, Boolean.valueOf(false));
  }
  
  public void commit(BaseBean paramBaseBean, Boolean paramBoolean)
  {
    if (!this.enable) {
      return;
    }
    if (this.ioHandler != null) {
      this.ioHandler.post(new AVReportCenter.2(this, paramBaseBean, paramBoolean));
    }
  }
  
  public void flush()
  {
    if (this.ioHandler != null) {
      this.ioHandler.post(new AVReportCenter.3(this));
    }
  }
  
  public void init(Context paramContext)
  {
    this.context = paramContext;
    if (this.ioHandler == null) {
      try
      {
        if (this.ioHandler != null) {
          return;
        }
        try
        {
          paramContext = new StringBuilder();
          paramContext.append(DeviceInfo.getRomFingerprint(this.context));
          paramContext.append(DeviceInfo.getApiLevelInt());
          this.os = paramContext.toString();
          this.app = AppInfo.getPackageName(this.context);
          paramContext = new StringBuilder();
          paramContext.append(this.context.getExternalCacheDir().getAbsolutePath());
          paramContext.append(File.separator);
          paramContext.append("AVReportCenter");
          paramContext.append(File.separator);
          paramContext.append("Report");
          this.dir = paramContext.toString();
          paramContext = new File(this.dir);
          if (!paramContext.exists()) {
            paramContext.mkdirs();
          }
          paramContext = new StringBuilder();
          paramContext.append(this.context.getExternalCacheDir().getAbsolutePath());
          paramContext.append(File.separator);
          paramContext.append("AVReportCenter");
          paramContext.append(File.separator);
          paramContext.append("Report_tmp");
          this.tmpDir = paramContext.toString();
          paramContext = new File(this.tmpDir);
          if (!paramContext.exists()) {
            paramContext.mkdirs();
          }
          try
          {
            this.imei = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
            this.imei = "0";
          }
          this.ioThread = new HandlerThread(TAG);
          this.ioThread.setDaemon(true);
          this.ioThread.start();
          while (!this.ioThread.isAlive()) {}
          this.ioHandler = new Handler(this.ioThread.getLooper());
          this.ioHandler.post(new AVReportCenter.1(this));
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.AVReportCenter
 * JD-Core Version:    0.7.0.1
 */