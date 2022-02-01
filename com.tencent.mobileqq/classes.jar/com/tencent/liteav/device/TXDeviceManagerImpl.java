package com.tencent.liteav.device;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.d;
import com.tencent.liteav.g;

public class TXDeviceManagerImpl
  implements TXDeviceManager
{
  public static final int AUDIO_ROUTE_EARPIECE = 1;
  public static final int AUDIO_ROUTE_SPEAKER = 0;
  public static final int SystemVolumeTypeAuto = 0;
  public static final int SystemVolumeTypeMedia = 1;
  public static final int SystemVolumeTypeVOIP = 2;
  public static final String TAG = "TXDeviceManagerImpl";
  protected d mCaptureAndEnc;
  private TXDeviceManagerImpl.TXDeviceManagerListener mDeviceManagerListener;
  private boolean mIsFrontCamera;
  protected Handler mSDKHandler;
  
  public TXDeviceManagerImpl(Handler paramHandler)
  {
    this.mSDKHandler = paramHandler;
  }
  
  protected void apiLog(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trtc_api TXDeviceManager:");
    localStringBuilder.append(paramString);
    TXCLog.i("TXDeviceManagerImpl", localStringBuilder.toString());
  }
  
  protected void apiOnlineLog(String paramString, Object... paramVarArgs)
  {
    Monitor.a(1, String.format(paramString, paramVarArgs), "", 0, "trtc_api TXDeviceManager:");
  }
  
  public int enableCameraAutoFocus(boolean paramBoolean)
  {
    runOnSDKThread(new TXDeviceManagerImpl.3(this, paramBoolean));
    return 0;
  }
  
  public boolean enableCameraTorch(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableCameraTorch ");
    localStringBuilder.append(paramBoolean);
    apiLog(localStringBuilder.toString());
    return this.mCaptureAndEnc.f(paramBoolean);
  }
  
  public float getCameraZoomMaxRatio()
  {
    return this.mCaptureAndEnc.r();
  }
  
  public boolean isAutoFocusEnabled()
  {
    return this.mCaptureAndEnc.c().L ^ true;
  }
  
  public boolean isFrontCamera()
  {
    return this.mIsFrontCamera;
  }
  
  protected void runOnSDKThread(Runnable paramRunnable)
  {
    if (this.mSDKHandler != null)
    {
      if (Looper.myLooper() != this.mSDKHandler.getLooper())
      {
        this.mSDKHandler.post(paramRunnable);
        return;
      }
      paramRunnable.run();
    }
  }
  
  public int setAudioRoute(TXDeviceManager.TXAudioRoute paramTXAudioRoute)
  {
    runOnSDKThread(new TXDeviceManagerImpl.5(this, paramTXAudioRoute));
    return 0;
  }
  
  public int setCameraFocusPosition(int paramInt1, int paramInt2)
  {
    runOnSDKThread(new TXDeviceManagerImpl.4(this, paramInt1, paramInt2));
    return 0;
  }
  
  public int setCameraZoomRatio(float paramFloat)
  {
    runOnSDKThread(new TXDeviceManagerImpl.2(this, paramFloat));
    return 0;
  }
  
  public void setCaptureAndEnc(d paramd)
  {
    this.mCaptureAndEnc = paramd;
  }
  
  public void setDeviceManagerListener(TXDeviceManagerImpl.TXDeviceManagerListener paramTXDeviceManagerListener)
  {
    this.mDeviceManagerListener = paramTXDeviceManagerListener;
  }
  
  public void setFrontCamera(boolean paramBoolean)
  {
    this.mIsFrontCamera = paramBoolean;
  }
  
  public int setSystemVolumeType(TXDeviceManager.TXSystemVolumeType paramTXSystemVolumeType)
  {
    runOnSDKThread(new TXDeviceManagerImpl.6(this, paramTXSystemVolumeType));
    return 0;
  }
  
  public int switchCamera(boolean paramBoolean)
  {
    boolean bool = this.mIsFrontCamera;
    this.mIsFrontCamera = paramBoolean;
    runOnSDKThread(new TXDeviceManagerImpl.1(this, bool, paramBoolean));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.device.TXDeviceManagerImpl
 * JD-Core Version:    0.7.0.1
 */