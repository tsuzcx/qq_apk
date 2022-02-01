package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.huawei.multimedia.liteav.audioengine.IHwAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.ArrayList;
import java.util.List;

public class HwAudioKit
{
  private static final List<Integer> DEFAULT_FEATURE_LIST = new ArrayList(0);
  private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioEngineService";
  private static final String TAG = "HwAudioKit.HwAudioKit";
  private ServiceConnection mConnection = new HwAudioKit.1(this);
  private Context mContext = null;
  private IBinder.DeathRecipient mDeathRecipient = new HwAudioKit.2(this);
  private FeatureKitManager mFeatureKitManager = FeatureKitManager.getInstance();
  private IHwAudioEngine mIHwAudioEngine = null;
  private boolean mIsServiceConnected = false;
  private IBinder mService = null;
  
  public HwAudioKit(Context paramContext, IAudioKitCallback paramIAudioKitCallback)
  {
    this.mFeatureKitManager.setCallBack(paramIAudioKitCallback);
    this.mContext = paramContext;
  }
  
  private void bindService(Context paramContext)
  {
    TXCLog.i("HwAudioKit.HwAudioKit", "bindService, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.mIsServiceConnected) });
    FeatureKitManager localFeatureKitManager = this.mFeatureKitManager;
    if ((localFeatureKitManager != null) && (!this.mIsServiceConnected)) {
      localFeatureKitManager.bindService(paramContext, this.mConnection, "com.huawei.multimedia.audioengine.HwAudioEngineService");
    }
  }
  
  private void serviceInit(String paramString1, String paramString2)
  {
    TXCLog.i("HwAudioKit.HwAudioKit", "serviceInit");
    try
    {
      if ((this.mIHwAudioEngine != null) && (this.mIsServiceConnected))
      {
        this.mIHwAudioEngine.init(paramString1, paramString2);
        return;
      }
    }
    catch (RemoteException paramString1)
    {
      TXCLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", new Object[] { paramString1.getMessage() });
    }
  }
  
  private void serviceLinkToDeath(IBinder paramIBinder)
  {
    this.mService = paramIBinder;
    try
    {
      if (this.mService == null) {
        break label42;
      }
      this.mService.linkToDeath(this.mDeathRecipient, 0);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      label27:
      break label27;
    }
    this.mFeatureKitManager.onCallBack(5);
    TXCLog.e("HwAudioKit.HwAudioKit", "serviceLinkToDeath, RemoteException");
    label42:
  }
  
  public <T extends AudioFeaturesKit> T createFeature(HwAudioKit.FeatureType paramFeatureType)
  {
    FeatureKitManager localFeatureKitManager = this.mFeatureKitManager;
    if ((localFeatureKitManager != null) && (paramFeatureType != null)) {
      return localFeatureKitManager.createFeatureKit(paramFeatureType.getFeatureType(), this.mContext);
    }
    return null;
  }
  
  public void destroy()
  {
    TXCLog.i("HwAudioKit.HwAudioKit", "destroy, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.mIsServiceConnected) });
    if (this.mIsServiceConnected)
    {
      this.mIsServiceConnected = false;
      this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
    }
  }
  
  public List<Integer> getSupportedFeatures()
  {
    TXCLog.i("HwAudioKit.HwAudioKit", "getSupportedFeatures");
    try
    {
      if ((this.mIHwAudioEngine == null) || (!this.mIsServiceConnected)) {
        break label40;
      }
      List localList = this.mIHwAudioEngine.getSupportedFeatures();
      return localList;
    }
    catch (RemoteException localRemoteException)
    {
      label33:
      break label33;
    }
    TXCLog.e("HwAudioKit.HwAudioKit", "getSupportedFeatures, createFeature,wait bind service fail");
    label40:
    TXCLog.i("HwAudioKit.HwAudioKit", "getSupportedFeatures, service not bind");
    return DEFAULT_FEATURE_LIST;
  }
  
  public void initialize()
  {
    TXCLog.i("HwAudioKit.HwAudioKit", "initialize");
    Context localContext = this.mContext;
    if (localContext == null)
    {
      TXCLog.i("HwAudioKit.HwAudioKit", "mContext is null");
      this.mFeatureKitManager.onCallBack(7);
      return;
    }
    if (!this.mFeatureKitManager.isAudioKitSupport(localContext))
    {
      TXCLog.i("HwAudioKit.HwAudioKit", "not install AudioKitEngine");
      this.mFeatureKitManager.onCallBack(2);
      return;
    }
    bindService(this.mContext);
  }
  
  public boolean isFeatureSupported(HwAudioKit.FeatureType paramFeatureType)
  {
    if (paramFeatureType == null) {
      return false;
    }
    TXCLog.i("HwAudioKit.HwAudioKit", "isFeatureSupported, type = %d", new Object[] { Integer.valueOf(paramFeatureType.getFeatureType()) });
    try
    {
      if ((this.mIHwAudioEngine != null) && (this.mIsServiceConnected))
      {
        boolean bool = this.mIHwAudioEngine.isFeatureSupported(paramFeatureType.getFeatureType());
        return bool;
      }
    }
    catch (RemoteException paramFeatureType)
    {
      TXCLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", new Object[] { paramFeatureType.getMessage() });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit
 * JD-Core Version:    0.7.0.1
 */