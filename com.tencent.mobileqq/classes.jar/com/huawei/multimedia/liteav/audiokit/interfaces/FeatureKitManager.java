package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.liteav.basic.log.TXCLog;

public class FeatureKitManager
{
  private static final Object BIND_SERVICE_LOCK = new Object();
  private static final String ENGINE_PACKAGE_NAME = "com.huawei.multimedia.audioengine";
  private static final Object NEW_FEATUREMANAGER_LOCK;
  private static final int PACKAGE_INFO_FLAG = 0;
  private static final Object SET_CALL_BACK_LOCK = new Object();
  private static final String TAG = "HwAudioKit.FeatureKitManager";
  private static final Object UNBIND_SERVICE_LOCK = new Object();
  private static FeatureKitManager sInstance = null;
  private IAudioKitCallback mCallBack = null;
  
  static
  {
    NEW_FEATUREMANAGER_LOCK = new Object();
  }
  
  protected static FeatureKitManager getInstance()
  {
    synchronized (NEW_FEATUREMANAGER_LOCK)
    {
      if (sInstance == null) {
        sInstance = new FeatureKitManager();
      }
      FeatureKitManager localFeatureKitManager = sInstance;
      return localFeatureKitManager;
    }
  }
  
  /* Error */
  protected void bindService(Context paramContext, ServiceConnection paramServiceConnection, String paramString)
  {
    // Byte code:
    //   0: getstatic 34	com/huawei/multimedia/liteav/audiokit/interfaces/FeatureKitManager:BIND_SERVICE_LOCK	Ljava/lang/Object;
    //   3: astore 4
    //   5: aload 4
    //   7: monitorenter
    //   8: aload_1
    //   9: ifnonnull +7 -> 16
    //   12: aload 4
    //   14: monitorexit
    //   15: return
    //   16: new 50	android/content/Intent
    //   19: dup
    //   20: invokespecial 51	android/content/Intent:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: ldc 10
    //   29: aload_3
    //   30: invokevirtual 55	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   33: pop
    //   34: ldc 18
    //   36: ldc 56
    //   38: invokestatic 62	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_1
    //   42: aload 5
    //   44: aload_2
    //   45: iconst_1
    //   46: invokevirtual 67	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   49: pop
    //   50: goto +22 -> 72
    //   53: astore_1
    //   54: ldc 18
    //   56: ldc 69
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: invokevirtual 73	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 77	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload 4
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: aload 4
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	FeatureKitManager
    //   0	82	1	paramContext	Context
    //   0	82	2	paramServiceConnection	ServiceConnection
    //   0	82	3	paramString	String
    //   3	75	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	50	53	java/lang/SecurityException
    //   12	15	76	finally
    //   16	34	76	finally
    //   34	50	76	finally
    //   54	72	76	finally
    //   72	75	76	finally
    //   77	80	76	finally
  }
  
  protected <T extends AudioFeaturesKit> T createFeatureKit(int paramInt, Context paramContext)
  {
    TXCLog.i("HwAudioKit.FeatureKitManager", "createFeatureKit, type = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramContext == null) {
      return null;
    }
    if (paramInt != 1)
    {
      TXCLog.i("HwAudioKit.FeatureKitManager", "createFeatureKit, type error");
      return null;
    }
    HwAudioKaraokeFeatureKit localHwAudioKaraokeFeatureKit = new HwAudioKaraokeFeatureKit(paramContext);
    localHwAudioKaraokeFeatureKit.initialize(paramContext);
    return localHwAudioKaraokeFeatureKit;
  }
  
  protected IAudioKitCallback getCallBack()
  {
    return this.mCallBack;
  }
  
  protected boolean isAudioKitSupport(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getPackageManager();
    if (paramContext != null) {}
    try
    {
      if (paramContext.getPackageInfo("com.huawei.multimedia.audioengine", 0) != null) {
        break label43;
      }
      TXCLog.i("HwAudioKit.FeatureKitManager", "packageInfo is null");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label34:
      label43:
      break label34;
    }
    TXCLog.e("HwAudioKit.FeatureKitManager", "isAudioKitSupport ,NameNotFoundException");
    return false;
    return true;
  }
  
  protected void onCallBack(int paramInt)
  {
    TXCLog.i("HwAudioKit.FeatureKitManager", "onCallBack, result = %d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (SET_CALL_BACK_LOCK)
    {
      if (getCallBack() != null) {
        getCallBack().onResult(paramInt);
      }
      return;
    }
  }
  
  protected void setCallBack(IAudioKitCallback paramIAudioKitCallback)
  {
    this.mCallBack = paramIAudioKitCallback;
  }
  
  protected void unbindService(Context paramContext, ServiceConnection paramServiceConnection)
  {
    TXCLog.i("HwAudioKit.FeatureKitManager", "unbindService");
    Object localObject = UNBIND_SERVICE_LOCK;
    if (paramContext != null) {}
    try
    {
      paramContext.unbindService(paramServiceConnection);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audiokit.interfaces.FeatureKitManager
 * JD-Core Version:    0.7.0.1
 */