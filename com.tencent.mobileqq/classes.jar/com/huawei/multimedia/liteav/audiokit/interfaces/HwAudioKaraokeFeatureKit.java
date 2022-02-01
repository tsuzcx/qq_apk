package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.huawei.multimedia.liteav.audioengine.IHwAudioKaraokeFeature;
import com.tencent.liteav.basic.log.TXCLog;

public class HwAudioKaraokeFeatureKit
  extends AudioFeaturesKit
{
  private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService";
  private static final String TAG = "HwAudioKit.HwAudioKaraokeFeatureKit";
  private ServiceConnection mConnection = new HwAudioKaraokeFeatureKit.1(this);
  private Context mContext;
  private IBinder.DeathRecipient mDeathRecipient = new HwAudioKaraokeFeatureKit.2(this);
  private FeatureKitManager mFeatureKitManager = null;
  private IHwAudioKaraokeFeature mIHwAudioKaraokeFeatureAidl;
  private boolean mIsServiceConnected = false;
  private IBinder mService = null;
  
  protected HwAudioKaraokeFeatureKit(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void bindService(Context paramContext)
  {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "bindService");
    FeatureKitManager localFeatureKitManager = this.mFeatureKitManager;
    if ((localFeatureKitManager != null) && (!this.mIsServiceConnected)) {
      localFeatureKitManager.bindService(paramContext, this.mConnection, "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService");
    }
  }
  
  private void serviceInit(String paramString)
  {
    try
    {
      if ((this.mIHwAudioKaraokeFeatureAidl != null) && (this.mIsServiceConnected))
      {
        this.mIHwAudioKaraokeFeatureAidl.init(paramString);
        return;
      }
    }
    catch (RemoteException paramString)
    {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "isFeatureSupported,RemoteException ex : %s", new Object[] { paramString.getMessage() });
    }
  }
  
  private void serviceLinkToDeath(IBinder paramIBinder)
  {
    this.mService = paramIBinder;
    if (paramIBinder != null) {}
    try
    {
      paramIBinder.linkToDeath(this.mDeathRecipient, 0);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      label21:
      break label21;
    }
    this.mFeatureKitManager.onCallBack(1002);
    TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "serviceLinkToDeath, RemoteException");
  }
  
  public void destroy()
  {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "destroy, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.mIsServiceConnected) });
    if (this.mIsServiceConnected)
    {
      this.mIsServiceConnected = false;
      this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
    }
  }
  
  public int enableKaraokeFeature(boolean paramBoolean)
  {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature, enable = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    try
    {
      if ((this.mIHwAudioKaraokeFeatureAidl != null) && (this.mIsServiceConnected))
      {
        int i = this.mIHwAudioKaraokeFeatureAidl.enableKaraokeFeature(paramBoolean);
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature,RemoteException ex : %s", new Object[] { localRemoteException.getMessage() });
    }
    return -2;
  }
  
  public int getKaraokeLatency()
  {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "getKaraokeLatency");
    try
    {
      if ((this.mIHwAudioKaraokeFeatureAidl != null) && (this.mIsServiceConnected))
      {
        int i = this.mIHwAudioKaraokeFeatureAidl.getKaraokeLatency();
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "getKaraokeLatency,RemoteException ex : %s", new Object[] { localRemoteException.getMessage() });
    }
    return -1;
  }
  
  protected void initialize(Context paramContext)
  {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize");
    if (paramContext == null)
    {
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize, context is null");
      return;
    }
    if (!this.mFeatureKitManager.isAudioKitSupport(paramContext))
    {
      this.mFeatureKitManager.onCallBack(2);
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize, not install AudioEngine");
      return;
    }
    bindService(paramContext);
  }
  
  public boolean isKaraokeFeatureSupport()
  {
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "isKaraokeFeatureSupport");
    try
    {
      if ((this.mIHwAudioKaraokeFeatureAidl != null) && (this.mIsServiceConnected))
      {
        boolean bool = this.mIHwAudioKaraokeFeatureAidl.isKaraokeFeatureSupport();
        return bool;
      }
    }
    catch (RemoteException localRemoteException)
    {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "isFeatureSupported,RemoteException ex : %s", new Object[] { localRemoteException.getMessage() });
    }
    return false;
  }
  
  public int setParameter(HwAudioKaraokeFeatureKit.ParameName paramParameName, int paramInt)
  {
    if (paramParameName == null) {
      return 1807;
    }
    try
    {
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "parame.getParameName() = %s, parameValue = %d", new Object[] { paramParameName.getParameName(), Integer.valueOf(paramInt) });
      if ((this.mIHwAudioKaraokeFeatureAidl != null) && (this.mIsServiceConnected))
      {
        paramInt = this.mIHwAudioKaraokeFeatureAidl.setParameter(paramParameName.getParameName(), paramInt);
        return paramInt;
      }
    }
    catch (RemoteException paramParameName)
    {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "setParameter,RemoteException ex : %s", new Object[] { paramParameName.getMessage() });
    }
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit
 * JD-Core Version:    0.7.0.1
 */