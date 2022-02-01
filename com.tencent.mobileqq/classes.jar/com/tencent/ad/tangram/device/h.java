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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getDir("ams", 0).getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tangram");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("cache");
    return new AdFile(localStringBuilder.toString(), "metadata.dat", "UTF-8", paramBoolean);
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
      setStatus(3);
      if (paramContext != null) {
        paramContext = paramContext.getApplicationContext();
      } else {
        paramContext = null;
      }
      paramContext = new WeakReference(paramContext);
      AdThreadManager.INSTANCE.post(new h.2(this, paramContext), 5);
      return;
    }
    finally {}
  }
  
  private static h.a readFile(Context paramContext)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AdLog.e("AdDeviceInfoCache", "readFile on main thread");
      return null;
    }
    AdLog.i("AdDeviceInfoCache", "readFile");
    String str;
    if (paramContext == null)
    {
      paramContext = null;
    }
    else
    {
      paramContext = createFile(paramContext, false);
      if (paramContext.open())
      {
        str = paramContext.readFully();
        if (!TextUtils.isEmpty(str)) {
          break label72;
        }
      }
    }
    if (paramContext != null) {
      paramContext.close();
    }
    return null;
    label72:
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
    Object localObject = Looper.myLooper();
    Looper localLooper = Looper.getMainLooper();
    boolean bool = false;
    if (localObject == localLooper)
    {
      AdLog.e("AdDeviceInfoCache", "writeFile on main thread");
      return false;
    }
    AdLog.i("AdDeviceInfoCache", "writeFile");
    localLooper = null;
    if (paramContext == null)
    {
      paramContext = null;
    }
    else
    {
      localObject = createFile(paramContext, true);
      if (!((AdFile)localObject).open())
      {
        paramContext = (Context)localObject;
      }
      else
      {
        paramContext = localLooper;
        if (parama != null) {
          paramContext = parama.toString();
        }
        if (TextUtils.isEmpty(paramContext))
        {
          paramContext = (Context)localObject;
        }
        else
        {
          bool = ((AdFile)localObject).writeFully(paramContext);
          paramContext = (Context)localObject;
        }
      }
    }
    if (paramContext != null) {
      paramContext.close();
    }
    return bool;
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
      setStatus(1);
      if (paramContext != null) {
        paramContext = paramContext.getApplicationContext();
      } else {
        paramContext = null;
      }
      paramContext = new WeakReference(paramContext);
      AdThreadManager.INSTANCE.post(new h.1(this, paramContext), 5);
      return;
    }
    finally {}
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