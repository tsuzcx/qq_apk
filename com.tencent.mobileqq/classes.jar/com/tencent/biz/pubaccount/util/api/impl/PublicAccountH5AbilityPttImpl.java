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
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.DialogUtil;
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
  implements IPublicAccountH5AbilityPtt, IQQRecorder.OnQQRecorderListener
{
  private static String fileNameForPtt = "";
  private static int fileSizeForPtt = 0;
  private static double mDuration = 0.0D;
  private static String mLocalPathForPttDownload = "";
  private static String mLocalPathForPttUpload = "";
  private static String md5ForPtt = "";
  private static String serverIdForPtt = "";
  private int MAX_TIME = 60000;
  private String TAG = "PublicAccountH5AbilityForPtt";
  Activity activity;
  private File mFile = null;
  private Handler mHandler;
  private VoicePlayer.VoicePlayerListener mListener = new PublicAccountH5AbilityPttImpl.1(this);
  VoicePlayer mPlayer;
  private IQQRecorder mQQRecorder;
  WebViewPlugin.PluginRuntime mRuntime;
  private FileOutputStream outputStream = null;
  private String uin;
  
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
      return ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(mDuration);
    }
    return 0;
  }
  
  private void showAbnormalRecordDlg()
  {
    SpannableString localSpannableString = new SpannableString(this.activity.getString(2131896537));
    DialogUtil.a(this.activity, HardCodeUtil.a(2131906567), localSpannableString, 0, 2131917392, null, null, new PublicAccountH5AbilityPttImpl.4(this)).show();
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
    Object localObject = mLocalPathForPttUpload.split("/");
    localObject = localObject[(localObject.length - 1)];
    if (((String)localObject).length() >= 21) {
      return ((String)localObject).substring(0, ((String)localObject).length() - 4);
    }
    return "";
  }
  
  public String getLocalIdForPTTDownLoad(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = mLocalPathForPttDownload;
    }
    paramString = str.split("/");
    paramString = paramString[(paramString.length - 1)];
    if (paramString.length() >= 21) {
      return paramString.substring(0, paramString.length() - 4);
    }
    return "";
  }
  
  public String getLocalPathFromIdForPtt(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("c2bPTT/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".amr");
    return localStringBuilder.toString();
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
    if (!paramString.exists()) {
      return paramString.mkdirs();
    }
    return true;
  }
  
  public boolean isPlaying()
  {
    VoicePlayer localVoicePlayer = this.mPlayer;
    return (localVoicePlayer != null) && (localVoicePlayer.g() == 2);
  }
  
  public boolean isRecorderRecording()
  {
    IQQRecorder localIQQRecorder = this.mQQRecorder;
    return (localIQQRecorder != null) && (!localIQQRecorder.b());
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
    }
    catch (JSONException paramRecorderParam)
    {
      paramRecorderParam.printStackTrace();
    }
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, new String[] { paramString.toString() });
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
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
    }
    catch (JSONException paramRecorderParam)
    {
      paramRecorderParam.printStackTrace();
    }
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, new String[] { paramString.toString() });
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    mDuration = paramDouble;
    paramString = new JSONObject();
    try
    {
      paramDouble = mDuration;
      int i = this.MAX_TIME;
      if (paramDouble == i)
      {
        paramString.put("retCode", 0);
        paramString.put("msg", HardCodeUtil.a(2131906550));
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
        paramRecorderParam = new StringBuilder();
        paramRecorderParam.append(HardCodeUtil.a(2131906518));
        paramRecorderParam.append(getLocalIdForPTT());
        paramString.put("msg", paramRecorderParam.toString());
        paramString.put("localId", getLocalIdForPTT());
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, 0, "1", "", "", "");
      }
      else
      {
        paramString.put("retCode", -1);
        paramString.put("msg", HardCodeUtil.a(2131906573));
        paramString.put("localId", getLocalIdForPTT());
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, -1, "1", "", "", "");
      }
      if (this.mRuntime.a() != null)
      {
        this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStopCallback, new String[] { paramString.toString() });
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("retCode", -1);
      paramString1.put("msg", "onRecorderError");
    }
    catch (JSONException paramRecorderParam)
    {
      paramRecorderParam.printStackTrace();
    }
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, new String[] { paramString1.toString() });
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
  }
  
  public void onRecorderNotReady(String paramString)
  {
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    paramRecorderParam = new StringBuilder();
    paramRecorderParam.append(AppConstants.SDCARD_PATH);
    paramRecorderParam.append("c2bPTT/");
    if (isFolderExists(paramRecorderParam.toString()))
    {
      this.mFile = new File(paramString);
      if (this.mFile.exists()) {
        this.mFile.delete();
      }
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
      paramString = new JSONObject();
      try
      {
        paramString.put("retCode", -1);
        paramString.put("msg", "no sdCard");
      }
      catch (JSONException paramRecorderParam)
      {
        paramRecorderParam.printStackTrace();
      }
      if (this.mRuntime.a() == null) {
        break label180;
      }
      this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, new String[] { paramString.toString() });
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (IOException paramString)
    {
      label93:
      break label93;
    }
    this.outputStream = null;
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
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.recordStartCallback, new String[] { localJSONObject.toString() });
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, 0, "1", "", "", "");
    handleRecorderStart();
    return 0;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt) {}
  
  public void pauseVoice()
  {
    VoicePlayer localVoicePlayer = this.mPlayer;
    if ((localVoicePlayer != null) && (localVoicePlayer.g() == 2)) {
      this.mPlayer.e();
    }
  }
  
  public void playVoice(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    VoicePlayer localVoicePlayer = this.mPlayer;
    if ((localVoicePlayer == null) || (this.mHandler == null) || ((localVoicePlayer != null) && (localVoicePlayer.g() != 3)))
    {
      this.mHandler = new Handler();
      this.mPlayer = new VoicePlayer(paramString, this.mHandler);
    }
    this.mPlayer.a(this.activity);
    this.mPlayer.h();
    this.mPlayer.a(this.mListener);
    if (this.mPlayer.g() == 1)
    {
      this.mPlayer.c();
      return;
    }
    if (this.mPlayer.g() == 3) {
      this.mPlayer.d();
    }
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
      this.mQQRecorder = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(this.activity);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("c2bPTT/");
    localStringBuilder.append(FileMsg.getTransFileDateTime());
    localStringBuilder.append(".amr");
    mLocalPathForPttUpload = localStringBuilder.toString();
    QQAudioUtils.a(this.activity, true);
    this.mQQRecorder.a(this);
    this.mQQRecorder.b(mLocalPathForPttUpload);
  }
  
  public void stopRecord()
  {
    IQQRecorder localIQQRecorder = this.mQQRecorder;
    if (localIQQRecorder != null)
    {
      localIQQRecorder.c();
      this.mQQRecorder = null;
    }
    closeOutputStream();
    QQAudioUtils.a(this.activity, false);
  }
  
  public void stopVoice()
  {
    Object localObject = this.mPlayer;
    if (localObject != null)
    {
      ((VoicePlayer)localObject).f();
      this.mPlayer = null;
      this.mHandler = null;
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retCode", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131906521));
        localStringBuilder.append(getLocalIdForPTT());
        localStringBuilder.append(HardCodeUtil.a(2131906583));
        ((JSONObject)localObject).put("msg", localStringBuilder.toString());
        ((JSONObject)localObject).put("localId", getLocalIdForPTT());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().callJs(PublicAccountH5AbilityPluginImpl.playEndCallback, new String[] { ((JSONObject)localObject).toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPttImpl
 * JD-Core Version:    0.7.0.1
 */