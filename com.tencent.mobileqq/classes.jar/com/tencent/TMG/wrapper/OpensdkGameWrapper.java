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
import com.tencent.TMG.ptt.PttListener.DownloadFileListener;
import com.tencent.TMG.ptt.PttListener.PlayFileListener;
import com.tencent.TMG.ptt.PttListener.RecordFileListener;
import com.tencent.TMG.ptt.PttListener.UploadFileListener;
import com.tencent.TMG.ptt.PttListener.Voice2TextListener;
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
    String str = "PRODUCT=" + Build.PRODUCT + ";";
    str = str + "CPU_ABI=" + Build.CPU_ABI + ";";
    str = str + "TAGS=" + Build.TAGS + ";";
    str = str + "VERSION_CODES_BASE=1;";
    str = str + "MODEL=" + Build.MODEL + ";";
    str = str + "SDK=" + Build.VERSION.SDK_INT + ";";
    str = str + "VERSION_RELEASE=" + Build.VERSION.RELEASE + ";";
    str = str + "DEVICE=" + Build.DEVICE + ";";
    str = str + "DISPLAY=" + Build.DISPLAY + ";";
    str = str + "BRAND=" + Build.BRAND + ";";
    str = str + "BOARD=" + Build.BOARD + ";";
    str = str + "FINGERPRINT=" + Build.FINGERPRINT + ";";
    str = str + "ID=" + Build.ID + ";";
    str = str + "MANUFACTURER=" + Build.MANUFACTURER + ";";
    str = str + "USER=" + Build.USER + ";";
    str = str + "PROCESSORS=" + Runtime.getRuntime().availableProcessors() + ";";
    paramContext = paramContext.getApplicationInfo();
    str = str + "DATADIR=" + paramContext.dataDir + ";";
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = str + "LIBDIR=" + paramContext.nativeLibraryDir + ";";; paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib" + ";")
    {
      paramContext = paramContext + "HW_AVC_ENC=0;";
      paramContext = paramContext + "HW_AVC_DEC=0;";
      paramContext = paramContext + "HW_HEVC_DEC=0;";
      paramContext = paramContext + "HW_HEVC_ENC=0;";
      Log.i("opensdkGameWrapper", "getPhoneInfo=" + paramContext);
      return paramContext;
    }
  }
  
  private void initLog()
  {
    String str = Environment.getExternalStorageDirectory() + "/tencent/imsdklogs/" + this.mActivity.getPackageName().replace('.', '/');
    AVLoggerClient.setIsEnablePrintLog(true);
    AVLoggerClient.setIsEnableWriteLog(true);
    AVLoggerClient.setLogDir(str);
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
    PttManager.createInstance(this.mActivity.getApplicationContext()).downloadFile(paramString2, paramString1, new PttListener.DownloadFileListener()
    {
      public void onCompleted(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        String str = paramAnonymousString1;
        if (paramAnonymousString1 == null) {
          str = "";
        }
        paramAnonymousString1 = paramAnonymousString2;
        if (paramAnonymousString2 == null) {
          paramAnonymousString1 = "";
        }
        Log.i("opensdkGameWrapper", String.format("DownloadRecordedFile|onCompleted| code=%d, filePath=%s,fileid=%s", new Object[] { Integer.valueOf(paramAnonymousInt), str, paramAnonymousString1 }));
        OpensdkGameWrapper.this.nativeDownloadRecordedFileCallback(paramAnonymousInt, str, paramAnonymousString1);
      }
    });
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
    Log.i("opensdkGameWrapper", "playRecordedFile|filePath=" + paramString);
    PttManager.createInstance(this.mActivity.getApplicationContext()).playRecordedFile(paramString, new PttListener.PlayFileListener()
    {
      public void onCompleted(int paramAnonymousInt, String paramAnonymousString)
      {
        String str = paramAnonymousString;
        if (paramAnonymousString == null) {
          str = "";
        }
        Log.i("opensdkGameWrapper", String.format("playRecordedFile|onCompleted| code=%d, filePath=%s", new Object[] { Integer.valueOf(paramAnonymousInt), str }));
        OpensdkGameWrapper.this.nativePlayRecordedFileCallback(paramAnonymousInt, str);
      }
    });
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
    Log.i("opensdkGameWrapper", "StartRecording|filePath=" + paramString);
    PttManager.createInstance(this.mActivity.getApplicationContext()).startRecording(paramString, new PttListener.RecordFileListener()
    {
      public void onCompleted(int paramAnonymousInt, String paramAnonymousString)
      {
        String str = paramAnonymousString;
        if (paramAnonymousString == null) {
          str = "";
        }
        Log.i("opensdkGameWrapper", String.format("startRecording|onCompleted| code=%d, filePath=%s", new Object[] { Integer.valueOf(paramAnonymousInt), str }));
        OpensdkGameWrapper.this.nativestartRecordingCallback(paramAnonymousInt, str);
      }
    });
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
    Log.i("opensdkGameWrapper", "uploadRecordedFile|filePath=" + paramString);
    PttManager.createInstance(this.mActivity.getApplicationContext()).uploadFile(paramString, new PttListener.UploadFileListener()
    {
      public void onCompleted(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        String str = paramAnonymousString1;
        if (paramAnonymousString1 == null) {
          str = "";
        }
        paramAnonymousString1 = paramAnonymousString2;
        if (paramAnonymousString2 == null) {
          paramAnonymousString1 = "";
        }
        Log.i("opensdkGameWrapper", String.format("uploadRecordedFile|onCompleted| code=%d, filePath=%s,fileid=%s", new Object[] { Integer.valueOf(paramAnonymousInt), str, paramAnonymousString1 }));
        OpensdkGameWrapper.this.nativeUploadRecordedFileCallback(paramAnonymousInt, str, paramAnonymousString1);
      }
    });
    return 0;
  }
  
  int voice2Text(String paramString)
  {
    Log.i("opensdkGameWrapper", String.format("voice2Text| fileid=%s.", new Object[] { paramString }));
    PttManager.createInstance(this.mActivity.getApplicationContext()).voice2Text(paramString, new PttListener.Voice2TextListener()
    {
      public void onCompleted(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        String str = paramAnonymousString2;
        if (paramAnonymousString2 == null) {
          str = "";
        }
        paramAnonymousString2 = paramAnonymousString1;
        if (paramAnonymousString1 == null) {
          paramAnonymousString2 = "";
        }
        Log.i("opensdkGameWrapper", String.format("voice2Text|onCompleted| code=%d, fileid=%s,text=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString2, str }));
        OpensdkGameWrapper.this.nativeVoice2TextCallback(paramAnonymousInt, paramAnonymousString2, str);
      }
    });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.wrapper.OpensdkGameWrapper
 * JD-Core Version:    0.7.0.1
 */