package com.tencent.TMG.wrapper;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import com.tencent.TMG.logger.LogReporter;
import com.tencent.TMG.ptt.PttManager;
import com.tencent.TMG.sdk.AVLoggerClient;

public class OpensdkGameWrapper
{
  private static final String TAG = "opensdkGameWrapper";
  Activity mActivity = null;
  
  public OpensdkGameWrapper(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  @TargetApi(9)
  private String getPhoneInfo(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PRODUCT=");
    ((StringBuilder)localObject).append(Build.PRODUCT);
    ((StringBuilder)localObject).append(";");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("CPU_ABI=");
    localStringBuilder.append(Build.CPU_ABI);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("TAGS=");
    localStringBuilder.append(Build.TAGS);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("VERSION_CODES_BASE=1;");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("MODEL=");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("SDK=");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("VERSION_RELEASE=");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("DEVICE=");
    localStringBuilder.append(Build.DEVICE);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("DISPLAY=");
    localStringBuilder.append(Build.DISPLAY);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("BRAND=");
    localStringBuilder.append(Build.BRAND);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("BOARD=");
    localStringBuilder.append(Build.BOARD);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("FINGERPRINT=");
    localStringBuilder.append(Build.FINGERPRINT);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("ID=");
    localStringBuilder.append(Build.ID);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("MANUFACTURER=");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("USER=");
    localStringBuilder.append(Build.USER);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("PROCESSORS=");
    localStringBuilder.append(Runtime.getRuntime().availableProcessors());
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    paramContext = paramContext.getApplicationInfo();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("DATADIR=");
    localStringBuilder.append(paramContext.dataDir);
    localStringBuilder.append(";");
    localObject = localStringBuilder.toString();
    if (Build.VERSION.SDK_INT >= 9)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("LIBDIR=");
      localStringBuilder.append(paramContext.nativeLibraryDir);
      localStringBuilder.append(";");
      paramContext = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("LIBDIR=");
      localStringBuilder.append(paramContext.dataDir);
      localStringBuilder.append("/lib;");
      paramContext = localStringBuilder.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("HW_AVC_ENC=0;");
    paramContext = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("HW_AVC_DEC=0;");
    paramContext = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("HW_HEVC_DEC=0;");
    paramContext = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("HW_HEVC_ENC=0;");
    paramContext = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPhoneInfo=");
    ((StringBuilder)localObject).append(paramContext);
    Log.i("opensdkGameWrapper", ((StringBuilder)localObject).toString());
    return paramContext;
  }
  
  private void initLog()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
    ((StringBuilder)localObject).append("/tencent/imsdklogs/");
    ((StringBuilder)localObject).append(this.mActivity.getPackageName().replace('.', '/'));
    localObject = ((StringBuilder)localObject).toString();
    AVLoggerClient.setIsEnablePrintLog(true);
    AVLoggerClient.setIsEnableWriteLog(true);
    AVLoggerClient.setLogDir((String)localObject);
    AVLoggerClient.setMaxFileSize(52428800);
    AVLoggerClient.setLogListener(null);
  }
  
  private boolean loadSdkLibrary()
  {
    try
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("xplatform");
      System.loadLibrary("UDT");
      System.loadLibrary("qavsdk_unity");
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return false;
  }
  
  public static native String nativeGetAppVersion();
  
  public static native String nativeGetSdkVersion();
  
  int DownloadRecordedFile(String paramString1, String paramString2)
  {
    Log.i("opensdkGameWrapper", String.format("DownloadRecordedFile|filePath=%s, fileid=%s.", new Object[] { paramString1, paramString2 }));
    PttManager.createInstance(this.mActivity.getApplicationContext()).downloadFile(paramString2, paramString1, new OpensdkGameWrapper.4(this));
    return 0;
  }
  
  public int cancelRecording()
  {
    Log.i("opensdkGameWrapper", "cancelRecording.");
    PttManager.createInstance(this.mActivity.getApplicationContext()).cancelRecording();
    return 0;
  }
  
  public String getDeviceInfo()
  {
    String str = PttManager.createInstance(this.mActivity.getApplicationContext()).getDeviceInfo();
    Log.i("opensdkGameWrapper", String.format("getDeviceInfo | info=%s", new Object[] { str }));
    return str;
  }
  
  public int getFileSeconds(String paramString)
  {
    Log.i("opensdkGameWrapper", String.format("getFileSeconds| filePath=%s", new Object[] { paramString }));
    return PttManager.createInstance(this.mActivity.getApplicationContext()).getFileSeconds(paramString);
  }
  
  public int getFileSize(String paramString)
  {
    Log.i("opensdkGameWrapper", String.format("GetFileSize| filePath=%s", new Object[] { paramString }));
    PttManager.createInstance(this.mActivity.getApplicationContext());
    return PttManager.getFileSize(paramString);
  }
  
  public String getSign()
  {
    String str2 = QualityReportSign.getInstance().getCosSign();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    Log.i("opensdkGameWrapper", String.format("getSign| sign=%s", new Object[] { str1 }));
    return str1;
  }
  
  public boolean initOpensdk()
  {
    Log.i("opensdkGameWrapper", "initOpensdk start.");
    if (loadSdkLibrary())
    {
      initLog();
      getSign();
      nativeInitOpensdk(this.mActivity.getApplicationContext(), getPhoneInfo(this.mActivity.getApplicationContext()));
      Log.i("opensdkGameWrapper", "initOpensdk end.");
      return true;
    }
    Log.i("opensdkGameWrapper", "initOpensdk end.");
    return false;
  }
  
  public native void nativeDownloadRecordedFileCallback(int paramInt, String paramString1, String paramString2);
  
  public native void nativeInitOpensdk(Context paramContext, String paramString);
  
  public native void nativePlayRecordedFileCallback(int paramInt, String paramString);
  
  public native void nativeUploadRecordedFileCallback(int paramInt, String paramString1, String paramString2);
  
  public native void nativeVoice2TextCallback(int paramInt, String paramString1, String paramString2);
  
  public native void nativestartRecordingCallback(int paramInt, String paramString);
  
  public int playRecordedFile(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playRecordedFile|filePath=");
    localStringBuilder.append(paramString);
    Log.i("opensdkGameWrapper", localStringBuilder.toString());
    return PttManager.createInstance(this.mActivity.getApplicationContext()).playRecordedFile(paramString, new OpensdkGameWrapper.2(this));
  }
  
  public void reportLog()
  {
    Log.i("opensdkGameWrapper", String.format("reportLog", new Object[0]));
    LogReporter.getInstance().reportLog();
  }
  
  public void setAccessToken(String paramString)
  {
    Log.i("opensdkGameWrapper", String.format("setAccessToken| sign=%s", new Object[] { paramString }));
    PttManager.createInstance(this.mActivity.getApplicationContext()).setAccessToken(paramString);
    LogReporter.getInstance().setAccessToken(paramString);
  }
  
  public void setAppInfo(String paramString1, String paramString2, String paramString3)
  {
    Log.i("opensdkGameWrapper", String.format("setAppInfo| appid=%s, accountType=%s, openid=%s", new Object[] { paramString1, paramString2, paramString3 }));
    PttManager.createInstance(this.mActivity.getApplicationContext()).setAppInfo(paramString1, paramString2, paramString3);
    LogReporter.getInstance().setAppInfo(paramString1, paramString3);
  }
  
  public int setMaxRecordTime(int paramInt)
  {
    Log.i("opensdkGameWrapper", String.format("setMaxRecordTime| time=%d", new Object[] { Integer.valueOf(paramInt) }));
    PttManager.createInstance(this.mActivity.getApplicationContext()).setMaxRecordTime(paramInt);
    return 0;
  }
  
  public int startRecording(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StartRecording|filePath=");
    localStringBuilder.append(paramString);
    Log.i("opensdkGameWrapper", localStringBuilder.toString());
    return PttManager.createInstance(this.mActivity.getApplicationContext()).startRecording(paramString, new OpensdkGameWrapper.1(this));
  }
  
  public int stopPlayFile()
  {
    Log.i("opensdkGameWrapper", "stopPlayFile.");
    PttManager.createInstance(this.mActivity.getApplicationContext()).stopPlayFile();
    return 0;
  }
  
  public int stopRecording()
  {
    Log.i("opensdkGameWrapper", "StopRecording.");
    return PttManager.createInstance(this.mActivity.getApplicationContext()).stopRecording();
  }
  
  int uploadRecordedFile(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uploadRecordedFile|filePath=");
    localStringBuilder.append(paramString);
    Log.i("opensdkGameWrapper", localStringBuilder.toString());
    PttManager.createInstance(this.mActivity.getApplicationContext()).uploadFile(paramString, new OpensdkGameWrapper.3(this));
    return 0;
  }
  
  int voice2Text(String paramString)
  {
    Log.i("opensdkGameWrapper", String.format("voice2Text| fileid=%s.", new Object[] { paramString }));
    PttManager.createInstance(this.mActivity.getApplicationContext()).voice2Text(paramString, new OpensdkGameWrapper.5(this));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.wrapper.OpensdkGameWrapper
 * JD-Core Version:    0.7.0.1
 */