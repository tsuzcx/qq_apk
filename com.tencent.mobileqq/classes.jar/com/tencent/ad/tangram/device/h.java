package com.tencent.ad.tangram.device;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.file.AdFile;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.io.File;
import java.lang.ref.WeakReference;

 enum h
{
  INSTANCE;
  
  private static final int STAUS_INITIALIZING = 1;
  private static final int STAUS_READY = 2;
  private static final int STAUS_UNKNOWN = 0;
  private static final int STAUS_UPDATING = 3;
  private static final String TAG = "AdDeviceInfoCache";
  private volatile h.a content = new h.a();
  private volatile int status = 0;
  
  private h() {}
  
  private static AdFile createFile(Context paramContext, boolean paramBoolean)
  {
    return new AdFile(paramContext.getDir("ams", 0).getAbsolutePath() + File.separator + "tangram" + File.separator + "cache", "metadata.dat", "UTF-8", paramBoolean);
  }
  
  private void flush(Context paramContext)
  {
    if (this.status != 2) {
      return;
    }
    try
    {
      if (this.status != 2) {
        return;
      }
    }
    finally {}
    setStatus(3);
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      paramContext = new WeakReference(paramContext);
      AdThreadManager.INSTANCE.post(new h.2(this, paramContext), 5);
      return;
    }
  }
  
  private static h.a readFile(Context paramContext)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      AdLog.e("AdDeviceInfoCache", "readFile on main thread");
    }
    String str;
    do
    {
      AdFile localAdFile;
      do
      {
        while (paramContext == null)
        {
          return null;
          AdLog.i("AdDeviceInfoCache", "readFile");
          if (paramContext != null) {
            break;
          }
          paramContext = null;
        }
        paramContext.close();
        return null;
        localAdFile = createFile(paramContext, false);
        paramContext = localAdFile;
      } while (!localAdFile.open());
      str = localAdFile.readFully();
      paramContext = localAdFile;
    } while (TextUtils.isEmpty(str));
    return h.a.fromString(str);
  }
  
  private void setStatus(int paramInt)
  {
    try
    {
      this.status = paramInt;
      return;
    }
    finally {}
  }
  
  private boolean writeFile(Context paramContext, h.a parama)
  {
    String str = null;
    boolean bool2;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AdLog.e("AdDeviceInfoCache", "writeFile on main thread");
      bool2 = false;
      return bool2;
    }
    AdLog.i("AdDeviceInfoCache", "writeFile");
    boolean bool1;
    if (paramContext == null)
    {
      bool1 = false;
      paramContext = null;
    }
    for (;;)
    {
      bool2 = bool1;
      if (paramContext == null) {
        break;
      }
      paramContext.close();
      return bool1;
      paramContext = createFile(paramContext, true);
      if (!paramContext.open())
      {
        bool1 = false;
      }
      else
      {
        if (parama != null) {
          str = parama.toString();
        }
        if (TextUtils.isEmpty(str)) {
          bool1 = false;
        } else {
          bool1 = paramContext.writeFully(str);
        }
      }
    }
  }
  
  public h.a getCache()
  {
    return this.content;
  }
  
  public void init(Context paramContext)
  {
    if (this.status != 0) {
      return;
    }
    try
    {
      if (this.status != 0) {
        return;
      }
    }
    finally {}
    setStatus(1);
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      paramContext = new WeakReference(paramContext);
      AdThreadManager.INSTANCE.post(new h.1(this, paramContext), 5);
      return;
    }
  }
  
  public void update(Context paramContext, h.a parama)
  {
    if (this.content.fill(parama)) {
      flush(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.h
 * JD-Core Version:    0.7.0.1
 */