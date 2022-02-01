package com.tencent.mobileqq.activity.richmedia.trimvideo.video.mediadevice;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.cache.SDCardMountMonitorReceiver.SDCardMountStateListener;
import java.io.File;

public class StorageManager
  implements SDCardMountMonitorReceiver.SDCardMountStateListener
{
  private static StorageManager b;
  private static final Object c = new Object();
  private String a = "";
  private StorageManager.OnSdCardChangedListener d;
  
  private StorageManager()
  {
    c();
    SDCardMountMonitorReceiver.getInstance().addListener(this);
  }
  
  public static StorageManager a()
  {
    if (b == null) {
      synchronized (c)
      {
        if (b == null) {
          b = new StorageManager();
        }
      }
    }
    return b;
  }
  
  private void c()
  {
    this.a = CacheManager.getVideoFileCacheDir();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateStorePath, storeVideoPath=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("StorageManager", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new File(this.a);
      if (!((File)localObject).exists())
      {
        ((File)localObject).mkdirs();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("StorageManager", 2, "create root path directory error", localException);
    }
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void onSDCardMountStateChange(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sdcard mount receiver, isMount=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("StorageManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = CacheManager.getVideoFileCacheDir();
    if ((this.d != null) && (!((String)localObject).equals(this.a)))
    {
      if (paramBoolean)
      {
        this.d.a(1, this.a);
        return;
      }
      this.d.a(0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.mediadevice.StorageManager
 * JD-Core Version:    0.7.0.1
 */