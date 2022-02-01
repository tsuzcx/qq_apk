package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPtt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountH5AbilityPttImpl
  implements IPublicAccountH5AbilityPtt, QQRecorder.OnQQRecorderListener
{
  private static String fileNameForPtt;
  private static int fileSizeForPtt;
  private static double mDuration = 0.0D;
  private static String mLocalPathForPttDownload;
  private static String mLocalPathForPttUpload;
  private static String md5ForPtt;
  private static String serverIdForPtt = "";
  private int MAX_TIME = 60000;
  private String TAG = "PublicAccountH5AbilityForPtt";
  Activity activity;
  private File mFile = null;
  private Handler mHandler;
  private VoicePlayer.VoicePlayerListener mListener = new PublicAccountH5AbilityPttImpl.1(this);
  VoicePlayer mPlayer;
  private QQRecorder mQQRecorder;
  WebViewPlugin.PluginRuntime mRuntime;
  private FileOutputStream outputStream = null;
  private String uin;
  
  static
  {
    md5ForPtt = "";
    fileNameForPtt = "";
    fileSizeForPtt = 0;
    mLocalPathForPttUpload = "";
    mLocalPathForPttDownload = "";
  }
  
  public PublicAccountH5AbilityPttImpl() {}
  
  public PublicAccountH5AbilityPttImpl(Activity paramActivity, String paramString, WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    this.mRuntime = paramPluginRuntime;
    this.activity = paramActivity;
    this.uin = paramString;
  }
  
  public static String getFileNameForPtt()
  {
    return fileNameForPtt;
  }
  
  public static int getFileSizeForPtt()
  {
    return fileSizeForPtt;
  }
  
  public static String getLocalPathForPttDownload()
  {
    return mLocalPathForPttDownload;
  }
  
  public static String getLocalPathForPttUpload()
  {
    return mLocalPathForPttUpload;
  }
  
  public static String getMd5ForPtt()
  {
    return md5ForPtt;
  }
  
  public static String getServerIdForPtt()
  {
    return serverIdForPtt;
  }
  
  public static int getTimeForPtt()
  {
    if (mDuration != 0.0D) {
      return QQRecorder.a(mDuration);
    }
    return 0;
  }
  
  private void showAbnormalRecordDlg()
  {
    SpannableString localSpannableString = new SpannableString(this.activity.getString(2131698524));
    DialogUtil.a(this.activity, HardCodeUtil.a(2131708785), localSpannableString, 0, 2131720056, null, null, new PublicAccountH5AbilityPttImpl.4(this)).show();
  }
  
  public void cancelPttRecorderAndPlayTask()
  {
    if (isPlaying()) {
      stopVoice();
    }
    stopRecord();
  }
  
  public void checkFileInfo()
  {
    try
    {
      File localFile = new File(mLocalPathForPttUpload);
      if (localFile.exists())
      {
        md5ForPtt = MD5FileUtil.a(localFile);
        fileSizeForPtt = (int)localFile.length();
        fileNameForPtt = md5ForPtt;
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void closeOutputStream()
  {
    try
    {
      if (this.outputStream != null) {
        this.outputStream.close();
      }
      label14:
      this.outputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public String getLocalIdForPTT()
  {
    Object localObject1 = mLocalPathForPttUpload.split("/");
    Object localObject2 = localObject1[(localObject1.length - 1)];
    localObject1 = "";
    if (localObject2.length() >= 21) {
      localObject1 = localObject2.substring(0, localObject2.length() - 4);
    }
    return localObject1;
  }
  
  public String getLocalIdForPTTDownLoad(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = mLocalPathForPttDownload;
    }
    paramString = str.split("/");
    str = paramString[(paramString.length - 1)];
    paramString = "";
    if (str.length() >= 21) {
      paramString = str.substring(0, str.length() - 4);
    }
    return paramString;
  }
  
  public String getLocalPathFromIdForPtt(String paramString)
  {
    return AppConstants.SDCARD_PATH + "c2bPTT/" + paramString + ".amr";
  }
  
  public void handleRecorderError(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    this.activity.runOnUiThread(new PublicAccountH5AbilityPttImpl.3(this));
  }
  
  public void handleRecorderStart()
  {
    this.activity.runOnUiThread(new PublicAccountH5AbilityPttImpl.2(this));
  }
  
  boolean isFolderExists(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) || (paramString.mkdirs());
  }
  
  public boolean isPlaying()
  {
    return (this.mPlayer != null) && (this.mPlayer.a() == 2);
  }
  
  public boolean isRecorderRecording()
  {
    return (this.mQQRecorder != null) && (!this.mQQRecorder.b());
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    return this.MAX_TIME;
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    handleRecorderError(paramString, paramRecorderParam);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "onInitFailed");
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, new String[] { paramString.toString() });
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void onInitSuccess() {}
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    handleRecorderError(paramString, paramRecorderParam);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "onRecorderAbnormal");
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, new String[] { paramString.toString() });
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    mDuration = paramDouble;
    paramString = new JSONObject();
    for (;;)
    {
      try
      {
        if (mDuration == this.MAX_TIME)
        {
          paramString.put("retCode", 0);
          paramString.put("msg", HardCodeUtil.a(2131708765));
          paramString.put("localId", getLocalIdForPTT());
          if (this.mRuntime.a() != null) {
            this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.voiceRecorderEndCallback, new String[] { paramString.toString() });
          }
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2B", "0X8005D2B", 0, 0, "1", "", "", "");
          return;
        }
        if (this.mFile.exists())
        {
          paramString.put("retCode", 0);
          paramString.put("msg", HardCodeUtil.a(2131708731) + getLocalIdForPTT());
          paramString.put("localId", getLocalIdForPTT());
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, 0, "1", "", "", "");
          if (this.mRuntime.a() == null) {
            break;
          }
          this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStopCallback, new String[] { paramString.toString() });
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString.put("retCode", -1);
      paramString.put("msg", HardCodeUtil.a(2131708791));
      paramString.put("localId", getLocalIdForPTT());
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, -1, "1", "", "", "");
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("retCode", -1);
      paramString1.put("msg", "onRecorderError");
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, new String[] { paramString1.toString() });
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void onRecorderNotReady(String paramString)
  {
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (isFolderExists(AppConstants.SDCARD_PATH + "c2bPTT/"))
    {
      this.mFile = new File(paramString);
      if (this.mFile.exists()) {
        this.mFile.delete();
      }
      try
      {
        this.outputStream = new FileOutputStream(this.mFile);
        this.outputStream.write("#!AMR\n".getBytes());
        return;
      }
      catch (FileNotFoundException paramString)
      {
        this.outputStream = null;
        paramString.printStackTrace();
        return;
      }
      catch (IOException paramString)
      {
        this.outputStream = null;
        return;
      }
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "no sdCard");
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, new String[] { paramString.toString() });
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    try
    {
      if (this.outputStream != null) {
        this.outputStream.write(paramArrayOfByte, 0, paramInt1);
      }
      return;
    }
    catch (IOException paramString) {}
  }
  
  public int onRecorderStart()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", "startRecord");
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, new String[] { localJSONObject.toString() });
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, 0, "1", "", "", "");
      handleRecorderStart();
      return 0;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void onRecorderVolumeStateChanged(int paramInt) {}
  
  public void pauseVoice()
  {
    if ((this.mPlayer != null) && (this.mPlayer.a() == 2)) {
      this.mPlayer.e();
    }
  }
  
  public void playVoice(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if ((this.mPlayer == null) || (this.mHandler == null) || ((this.mPlayer != null) && (this.mPlayer.a() != 3)))
      {
        this.mHandler = new Handler();
        this.mPlayer = new VoicePlayer(paramString, this.mHandler);
      }
      this.mPlayer.a(this.activity);
      this.mPlayer.b();
      this.mPlayer.a(this.mListener);
      if (this.mPlayer.a() == 1)
      {
        this.mPlayer.b();
        return;
      }
    } while (this.mPlayer.a() != 3);
    this.mPlayer.d();
  }
  
  public void setLocalPathForPtt(String paramString)
  {
    mLocalPathForPttDownload = paramString;
  }
  
  public void setServerIdForPtt(String paramString)
  {
    serverIdForPtt = paramString;
  }
  
  public void startRecord()
  {
    if (this.mQQRecorder == null) {
      this.mQQRecorder = new QQRecorder(this.activity);
    }
    mLocalPathForPttUpload = AppConstants.SDCARD_PATH + "c2bPTT/" + FileMsg.getTransFileDateTime() + ".amr";
    QQAudioUtils.a(this.activity, true);
    this.mQQRecorder.a(this);
    this.mQQRecorder.b(mLocalPathForPttUpload);
  }
  
  public void stopRecord()
  {
    if (this.mQQRecorder != null)
    {
      this.mQQRecorder.c();
      this.mQQRecorder = null;
    }
    closeOutputStream();
    QQAudioUtils.a(this.activity, false);
  }
  
  public void stopVoice()
  {
    JSONObject localJSONObject;
    if (this.mPlayer != null)
    {
      this.mPlayer.f();
      this.mPlayer = null;
      this.mHandler = null;
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", HardCodeUtil.a(2131708734) + getLocalIdForPTT() + HardCodeUtil.a(2131708802));
      localJSONObject.put("localId", getLocalIdForPTT());
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.playEndCallback, new String[] { localJSONObject.toString() });
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPttImpl
 * JD-Core Version:    0.7.0.1
 */