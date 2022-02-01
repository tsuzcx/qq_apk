package com.tencent.avcore.jni.dav;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.avcore.config.CameraConfigHelper;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.engine.dav.DavNativeEventParams;
import com.tencent.avcore.engine.dav.IDavAdapter;
import com.tencent.avcore.engine.dav.IDavEventListener;
import com.tencent.avcore.jni.data.AVCorePbInfo;
import com.tencent.avcore.jni.data.NetAddr;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import com.tencent.avcore.netchannel.IDavNetCallback;
import com.tencent.avcore.netchannel.IDavNetChannel;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.GlStringParser;

public class DavEngineJni
  implements IDavNetCallback
{
  public static final String TAG = "DavEngineJni";
  public static boolean sDisableReOpen = false;
  protected final IDavAdapter mAdapter;
  protected final Handler mEventHandler;
  protected final IDavEventListener mEventListener;
  protected GlStringParser mGlStringParser;
  protected final IDavNetChannel mNetChannel;
  protected final AVCoreSystemInfo mSysInfo;
  
  DavEngineJni(AVCoreSystemInfo paramAVCoreSystemInfo, IDavNetChannel paramIDavNetChannel, IDavAdapter paramIDavAdapter, IDavEventListener paramIDavEventListener)
  {
    this.mNetChannel = paramIDavNetChannel;
    this.mNetChannel.setNetCallback(this);
    this.mSysInfo = paramAVCoreSystemInfo;
    this.mAdapter = paramIDavAdapter;
    this.mEventListener = paramIDavEventListener;
    paramIDavNetChannel = Looper.getMainLooper();
    paramAVCoreSystemInfo = paramIDavNetChannel;
    if (paramIDavNetChannel == null) {
      paramAVCoreSystemInfo = Looper.myLooper();
    }
    paramIDavNetChannel = paramIDavAdapter.getNativeEventProcessor();
    this.mEventHandler = new DavEngineJni.NativeEventHandler(paramAVCoreSystemInfo, paramIDavEventListener, paramIDavNetChannel);
    paramAVCoreSystemInfo = paramIDavAdapter.getContext();
    if (paramAVCoreSystemInfo != null)
    {
      paramIDavAdapter = new DisplayMetrics();
      ((WindowManager)paramAVCoreSystemInfo.getSystemService("window")).getDefaultDisplay().getMetrics(paramIDavAdapter);
      int i = paramIDavAdapter.widthPixels;
      int j = paramIDavAdapter.heightPixels;
      this.mSysInfo.setScreenSize(i, j);
      this.mSysInfo.setDispSize(i, j);
    }
    AVCoreLog.e("DavEngineJni", "DavEngineJni, callback[" + paramIDavNetChannel + "], context[" + paramAVCoreSystemInfo + "]");
  }
  
  private static native void cacheMethodIds();
  
  private void callbackDataTransfered(int paramInt, long paramLong)
  {
    if (this.mEventListener != null) {
      this.mEventListener.dataTransferred(paramInt, paramLong);
    }
  }
  
  private int callbackGetAPAndGateWayIP()
  {
    int i = -1;
    if (this.mEventListener != null) {
      i = this.mEventListener.getAPAndGateWayIP();
    }
    return i;
  }
  
  private String callbackGetCustomInfo(long paramLong, String paramString)
  {
    if (this.mAdapter != null) {
      return this.mAdapter.getCustomInfo(paramLong, paramString);
    }
    return "";
  }
  
  private long callbackGetMSFInviteMessageTimeStamp(long paramLong)
  {
    long l = 0L;
    if (this.mEventListener != null) {
      l = this.mEventListener.getMSFInviteMessageTimeStamp(paramLong);
    }
    return l;
  }
  
  private int callbackIsOfflineSession(long paramLong)
  {
    int i = 0;
    if (this.mEventListener != null) {
      i = this.mEventListener.isOfflineSession(String.valueOf(paramLong));
    }
    return i;
  }
  
  private void callbackOnEvent(int paramInt1, byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString, int paramInt2, int paramInt3, long paramLong5, byte[] paramArrayOfByte2)
  {
    if (this.mEventListener == null) {
      AVCoreLog.printErrorLog("DavEngineJni", "mEventListener is null");
    }
    do
    {
      return;
      if (paramInt1 == 117)
      {
        this.mEventListener.onRecordAudio(paramArrayOfByte1, paramInt2, paramInt3);
        return;
      }
    } while (this.mEventHandler == null);
    DavNativeEventParams localDavNativeEventParams = new DavNativeEventParams();
    localDavNativeEventParams.detail = paramArrayOfByte1;
    localDavNativeEventParams.info = paramLong1;
    localDavNativeEventParams.fromUin = paramLong2;
    localDavNativeEventParams.extraParam0 = paramLong3;
    localDavNativeEventParams.extraParam1 = paramLong4;
    localDavNativeEventParams.extraParam2 = paramString;
    localDavNativeEventParams.extraParam3 = paramInt2;
    localDavNativeEventParams.extraParam4 = paramInt3;
    localDavNativeEventParams.extraParam5 = paramLong5;
    localDavNativeEventParams.extraBuf = paramArrayOfByte2;
    paramArrayOfByte1 = this.mEventHandler.obtainMessage(paramInt1, 0, 0, localDavNativeEventParams);
    this.mEventHandler.sendMessage(paramArrayOfByte1);
  }
  
  private void callbackSendConfigReq(byte[] paramArrayOfByte)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.sendGetVideoConfig(paramArrayOfByte);
    }
    while (!AVCoreLog.isColorLevel()) {
      return;
    }
    AVCoreLog.i("DavEngineJni", "callbackSendConfigReq, net channel is null.");
  }
  
  private void callbackTcpSendSharpCMD(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.sendSharpVideoMsg(paramLong, paramArrayOfByte);
    }
    while (!AVCoreLog.isColorLevel()) {
      return;
    }
    AVCoreLog.i("DavEngineJni", "callbackTcpSendSharpCMD, net channel is null.");
  }
  
  private void changePreviewSize(int paramInt1, int paramInt2)
  {
    if (this.mGlStringParser == null) {
      this.mGlStringParser = new GlStringParser('=', ';');
    }
    if (this.mAdapter != null) {}
    for (Object localObject = this.mAdapter.getContext();; localObject = null)
    {
      localObject = CameraConfigHelper.getInstance((Context)localObject).getCameraParameters();
      this.mGlStringParser.unflatten((String)localObject);
      localObject = this.mGlStringParser.get("preview-size-values");
      if ((localObject != null) && (((String)localObject).contains(paramInt1 + "x" + paramInt2))) {
        break;
      }
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("DavEngineJni", "changePreviewSize, 不包含该分辨率, w[" + paramInt1 + "], h[" + paramInt2 + "]");
      }
      return;
    }
    postInNativeEventHandler(new DavEngineJni.1(this, paramInt1, paramInt2), 0L);
  }
  
  private int getCameraFacing()
  {
    return this.mSysInfo.getCameraFacing();
  }
  
  private int getCpuArchitecture()
  {
    AVCoreSystemInfo localAVCoreSystemInfo = this.mSysInfo;
    return AVCoreSystemInfo.getCpuArchitecture();
  }
  
  private int getCpuMaxFrequency()
  {
    return (int)AVCoreSystemInfo.mMaxCpuFreq;
  }
  
  private String getDeviceName()
  {
    return AVCoreSystemInfo.getDeviceName();
  }
  
  private int getDispHeight()
  {
    return this.mSysInfo.mDisplayHeight;
  }
  
  private int getDispWidth()
  {
    return this.mSysInfo.mDisplayWidth;
  }
  
  private String getManufacture()
  {
    return Build.MANUFACTURER;
  }
  
  private int getNumCores()
  {
    return AVCoreSystemInfo.mCoreNumber;
  }
  
  private String getOsName()
  {
    return Build.VERSION.RELEASE;
  }
  
  private int getOsType()
  {
    return this.mSysInfo.getOsType();
  }
  
  private String getRomInfo()
  {
    return Build.VERSION.INCREMENTAL;
  }
  
  private int getScreenHeight()
  {
    return this.mSysInfo.mScreenHeight;
  }
  
  private int getScreenWidth()
  {
    return this.mSysInfo.mScreenWidth;
  }
  
  private String queryCameraParameters()
  {
    if (this.mAdapter != null) {}
    for (Context localContext = this.mAdapter.getContext();; localContext = null) {
      return CameraConfigHelper.getInstance(localContext).getCameraParameters();
    }
  }
  
  private native int setNetIpAndPort(String paramString, int paramInt);
  
  native int accept(long paramLong, int paramInt1, int paramInt2);
  
  native int acceptVideoMode(long paramLong);
  
  native int cancelVideoMode(long paramLong);
  
  native int close(long paramLong, int paramInt);
  
  native int doQuaReport(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  native void enableDumpAudioData(boolean paramBoolean);
  
  native boolean enableLoopback(boolean paramBoolean);
  
  native String getAVSDKInfo(long paramLong, String paramString);
  
  native int getBusiTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  native long getChatRoomID(long paramLong);
  
  native int getCmdTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  native long getEncodeFrameFunctionPtrFunPtr();
  
  native byte[] getInterestingString(long paramLong);
  
  native long getOnPeerFrameRenderEndFunctionPtr();
  
  native int getSdkVersion();
  
  native int getVolume(boolean paramBoolean);
  
  native int hasAVShiftAbility(long paramLong);
  
  native int ignore(long paramLong);
  
  native int init(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt, String paramString12, SDKConfigInfo paramSDKConfigInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString13, String paramString14, String paramString15);
  
  public void initContext()
  {
    this.mAdapter.loadLibrary();
    this.mAdapter.initConfig();
    this.mAdapter.initClientLogReport();
    if (getSdkVersion() < 18)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("DavEngineJni", "sdk version: " + getSdkVersion());
      }
      throw new UnsatisfiedLinkError();
    }
    cacheMethodIds();
  }
  
  native boolean isEnableLoopback();
  
  native boolean isEngineActive();
  
  native int notifyAnotherSelfIsRing(long paramLong, boolean paramBoolean);
  
  native int notifyAnotherTerChatStatus(long paramLong, int paramInt);
  
  native int onLogOutByKicked();
  
  native void onProcessExit();
  
  native int onRecvVideoCallBytesForSharp(byte[] paramArrayOfByte);
  
  native int onRecvVideoCallBytesForSharpC2SACK(byte[] paramArrayOfByte);
  
  native int onRecvVideoCloudConfig(byte[] paramArrayOfByte);
  
  native byte[] postData(long paramLong, byte[] paramArrayOfByte);
  
  public void postInNativeEventHandler(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable != null)
    {
      if (paramLong <= 0L) {
        this.mEventHandler.post(paramRunnable);
      }
    }
    else {
      return;
    }
    this.mEventHandler.postDelayed(paramRunnable, paramLong);
  }
  
  native AVCorePbInfo processQCallPush(byte[] paramArrayOfByte, AVCorePbInfo paramAVCorePbInfo);
  
  native boolean quaReport(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
  
  public void receiveGatewayMsg(String paramString, int paramInt)
  {
    setNetIpAndPort(paramString, paramInt);
  }
  
  public byte receiveSharpVideoAck(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (onRecvVideoCallBytesForSharpC2SACK(paramArrayOfByte1) >= 0) {
      return 0;
    }
    return -1;
  }
  
  public byte receiveSharpVideoCall(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (onRecvVideoCallBytesForSharp(paramArrayOfByte1) >= 0) {
      return 0;
    }
    return -1;
  }
  
  native int registerAudioDataCallback(int paramInt, boolean paramBoolean);
  
  native int reject(long paramLong, int paramInt);
  
  native int rejectVideoMode(long paramLong);
  
  native int request(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  native int requestByMobileNo(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, byte[] paramArrayOfByte, String paramString4, int paramInt4, int paramInt5);
  
  native int requestFromQQToUnQQ(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString, int paramInt3);
  
  native int requestFromTempChat(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6);
  
  native int requestReConnect(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  native int requestSharp(long paramLong, int paramInt1, int paramInt2);
  
  native int requestSwitchTerminal(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  native int requestUnQQ(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  native int requestVideoMode(long paramLong);
  
  native int sendAVFunChatMsg(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  native int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  native int sendDTMFMessage(long paramLong, char paramChar);
  
  native int sendQueryRoomInfoRequest(long paramLong1, long paramLong2);
  
  native int sendRecordingRequest(long paramLong1, boolean paramBoolean, NetAddr[] paramArrayOfNetAddr, long paramLong2);
  
  native int sendSelectVideoModeRequest(long paramLong, int paramInt);
  
  native void sendTransferMsg(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  native void setAVSDKInfo(long paramLong, String paramString1, String paramString2);
  
  native int setApType(int paramInt);
  
  native int setAudioDataFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native void setAudioDataSendByDefault(boolean paramBoolean);
  
  native void setAudioDataSink(boolean paramBoolean);
  
  native void setAudioOpt(boolean paramBoolean);
  
  native int setAudioOutputMode(int paramInt);
  
  native void setCarrierType(long paramLong, String paramString1, String paramString2);
  
  native int setGatewayIp(String paramString);
  
  native int setGatewayTestResult(int paramInt1, int paramInt2, int paramInt3);
  
  native int setGroundGlassSwitch(long paramLong, int paramInt);
  
  native void setProcessDecoderFrameFunctionptr(long paramLong);
  
  native int setProductId(int paramInt);
  
  native int setSelfUin(long paramLong);
  
  native void setVideoJitterLength(int paramInt);
  
  native int setVoiceType(int paramInt);
  
  native int setupDeviceInfos(String paramString);
  
  native int startAudioRecv();
  
  native int startAudioSend();
  
  native int startVideoSend();
  
  native int stopAudioRecv();
  
  native int stopAudioSend();
  
  native int stopVideoSend();
  
  native int switchAudio(long paramLong);
  
  native int switchVideo(long paramLong);
  
  native int uninit();
  
  native int unregisterAudioDataCallback(int paramInt, boolean paramBoolean);
  
  native int unregisterAudioDataCallbackAll();
  
  native int updateConfigInfo();
  
  native int updateNetworkTestResult(long paramLong, int paramInt);
  
  native int updateProcessInfo(long paramLong, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.dav.DavEngineJni
 * JD-Core Version:    0.7.0.1
 */