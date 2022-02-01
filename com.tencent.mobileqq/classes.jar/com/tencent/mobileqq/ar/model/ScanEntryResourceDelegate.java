package com.tencent.mobileqq.ar.model;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.IArConfigListener;
import com.tencent.mobileqq.ar.IArFaceResourceListener;
import com.tencent.mobileqq.ar.IArSoListener;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

public final class ScanEntryResourceDelegate
  implements IArConfigListener, IArFaceResourceListener, IArSoListener, SDKInitListener
{
  private boolean a = false;
  private boolean b = false;
  private int c = 0;
  private boolean d = false;
  private boolean e = false;
  private int f = 0;
  private boolean g = true;
  private boolean h = true;
  private boolean i = false;
  private boolean j = false;
  private int k = 0;
  private int l = 0;
  private RemoteArConfigManager m;
  private boolean n = false;
  private Activity o;
  private ScanEntryResourceDelegate.ARBaseResDownLoadCallBack p;
  private ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack q;
  private long r;
  private ScanEntryResourceDelegate.OnAREntryResourcePreapreListener s;
  
  public ScanEntryResourceDelegate(Activity paramActivity, RemoteArConfigManager paramRemoteArConfigManager)
  {
    this.m = paramRemoteArConfigManager;
    this.o = paramActivity;
  }
  
  private void a(long paramLong)
  {
    long l1 = 0x2 & paramLong;
    if ((l1 != 0L) && (!this.b)) {
      g();
    }
    if (((paramLong & 0x8) != 0L) && (!this.e)) {
      h();
    }
    if ((l1 != 0L) && ((!this.i) || (!this.e))) {
      i();
    }
  }
  
  private boolean b(long paramLong)
  {
    return (this.r & 0x2) != 0L;
  }
  
  private void n()
  {
    if ((this.a) && (this.d))
    {
      ScanEntryResourceDelegate.ARBaseResDownLoadCallBack localARBaseResDownLoadCallBack = this.p;
      if (localARBaseResDownLoadCallBack != null) {
        localARBaseResDownLoadCallBack.a();
      }
    }
    else if (!this.b)
    {
      if (this.e) {
        return;
      }
      if (this.p != null)
      {
        QLog.d("ScanEntryResourceDelegate", 1, "ARBaseSo res download fail");
        this.p.b();
      }
    }
  }
  
  private void o()
  {
    boolean bool = b(2L);
    int i1 = 0;
    if (bool) {
      i1 = 0 + this.c;
    }
    int i2 = i1;
    if (b(8L)) {
      i2 = i1 + this.f;
    }
    ScanEntryResourceDelegate.ARBaseResDownLoadCallBack localARBaseResDownLoadCallBack = this.p;
    if (localARBaseResDownLoadCallBack != null) {
      localARBaseResDownLoadCallBack.a(i2 / 2);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1) {
        this.l = paramInt2;
      }
    }
    else {
      this.k = paramInt2;
    }
    ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack localAsyncFaceResDownloadCallBack = this.q;
    if (localAsyncFaceResDownloadCallBack != null) {
      localAsyncFaceResDownloadCallBack.a((this.k + this.l) / 2);
    }
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(long paramLong, ScanEntryResourceDelegate.ARBaseResDownLoadCallBack paramARBaseResDownLoadCallBack, ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack paramAsyncFaceResDownloadCallBack)
  {
    if (paramLong == 0L) {
      return;
    }
    this.r = paramLong;
    this.p = paramARBaseResDownLoadCallBack;
    this.q = paramAsyncFaceResDownloadCallBack;
    a(paramLong);
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (this.n) {
      return;
    }
    ScanEntryResourceDelegate.OnAREntryResourcePreapreListener localOnAREntryResourcePreapreListener = this.s;
    if (localOnAREntryResourcePreapreListener != null) {
      localOnAREntryResourcePreapreListener.a(paramARCommonConfigInfo);
    }
    this.n = true;
  }
  
  public void a(ArConfigInfo paramArConfigInfo) {}
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    ARDeviceController.a().a(paramArEffectConfig);
  }
  
  public void a(ScanEntryResourceDelegate.OnAREntryResourcePreapreListener paramOnAREntryResourcePreapreListener)
  {
    this.s = paramOnAREntryResourcePreapreListener;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onArSoDownloadProcess process.");
    localStringBuilder.append(paramInt);
    QLog.d("ScanEntryResourceDelegate", 1, localStringBuilder.toString());
    this.c = paramInt;
    o();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1)
      {
        this.h = false;
        this.j = false;
      }
    }
    else
    {
      this.g = false;
      this.i = false;
    }
    if (this.q != null)
    {
      QLog.d("ScanEntryResourceDelegate", 1, "face so download not ready download fail");
      this.q.b();
    }
  }
  
  public void c()
  {
    this.a = true;
    this.b = false;
    this.c = 100;
    n();
  }
  
  public boolean c(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 2)
    {
      if (paramInt != 4)
      {
        if (paramInt != 8) {
          return false;
        }
        return this.d;
      }
      bool1 = bool2;
      if (this.g)
      {
        bool1 = bool2;
        if (this.h) {
          return true;
        }
      }
    }
    else
    {
      bool1 = this.a;
    }
    return bool1;
  }
  
  public void d()
  {
    this.a = false;
    this.b = false;
    n();
  }
  
  public void d(int paramInt)
  {
    QLog.d("ScanEntryResourceDelegate", 2, new Object[] { "notifyVoiceScanStatusChange state.", Integer.valueOf(paramInt) });
    RemoteArConfigManager localRemoteArConfigManager = this.m;
    if (localRemoteArConfigManager != null) {
      try
      {
        localRemoteArConfigManager.b(paramInt);
        return;
      }
      catch (Exception localException)
      {
        QLog.d("ScanEntryResourceDelegate", 1, "notifyVoiceScanStatusChange fail.", localException);
      }
    }
  }
  
  public void e()
  {
    long l1 = this.r;
    if (l1 == 0L) {
      return;
    }
    a(l1, this.p, this.q);
  }
  
  public void f()
  {
    this.r = 0L;
    this.p = null;
    this.q = null;
  }
  
  public void g()
  {
    try
    {
      this.a = this.m.g();
      if (!this.a)
      {
        this.b = true;
        this.m.h();
      }
      else
      {
        this.b = false;
        this.c = 100;
      }
      QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARResource mIsArSoReady=%s mArSoDownloading=%s", new Object[] { Boolean.valueOf(this.a), Boolean.valueOf(this.b) }));
      return;
    }
    catch (Exception localException)
    {
      label80:
      break label80;
    }
    QLog.d("ScanEntryResourceDelegate", 1, "downloadARResource fail");
  }
  
  public void h()
  {
    this.d = QQVideoPlaySDKManager.isSDKReady();
    if (!this.d)
    {
      this.e = true;
      if (!QQVideoPlaySDKManager.isSDKReady()) {
        QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getContext(), this);
      }
    }
    else
    {
      this.e = false;
      this.f = 100;
    }
    QLog.d("ScanEntryResourceDelegate", 1, String.format("installVideoPlugin mIsVideoPluginReady=%s mVideoPluginDownloading=%s", new Object[] { Boolean.valueOf(this.d), Boolean.valueOf(this.e) }));
  }
  
  public void i()
  {
    this.h = true;
    this.g = true;
    this.i = false;
    this.k = 100;
    QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARFaceResources mIsFaceSoReady=%s mFaceSoDownloading=%s", new Object[] { Boolean.valueOf(this.h), Boolean.valueOf(this.j) }));
    QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARFaceResources mIsFaceModelReady=%s mFaceModelDownloading=%s", new Object[] { Boolean.valueOf(this.g), Boolean.valueOf(this.i) }));
  }
  
  public boolean j()
  {
    if ((b(2L)) && (!c(2))) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    boolean bool1 = bool2;
    if (b(8L)) {
      if ((bool2) && (c(8))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    boolean bool2 = bool1;
    if (b(4L))
    {
      if ((bool1) && (c(4))) {
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  public void j_(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        this.h = true;
        this.j = false;
        this.l = 100;
      }
    }
    else
    {
      this.g = true;
      this.i = false;
      this.k = 100;
    }
    if ((this.g) && (this.h))
    {
      ScanEntryResourceDelegate.AsyncFaceResDownloadCallBack localAsyncFaceResDownloadCallBack = this.q;
      if (localAsyncFaceResDownloadCallBack != null) {
        localAsyncFaceResDownloadCallBack.a();
      }
    }
  }
  
  public boolean k()
  {
    boolean bool1 = b(2L);
    boolean bool3 = false;
    if (bool1) {
      bool1 = this.b;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (b(8L)) {
      bool2 = this.e;
    } else {
      bool2 = false;
    }
    int i1;
    if ((b(4L)) && ((this.i) || (this.j))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((!bool1) && (!bool2))
    {
      bool1 = bool3;
      if (i1 == 0) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean l()
  {
    return (this.a) && (this.d);
  }
  
  public boolean m()
  {
    return (this.g) && (this.h);
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSDKInited result.");
    localStringBuilder.append(paramBoolean);
    QLog.d("ScanEntryResourceDelegate", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.d = true;
      this.e = false;
      this.f = 100;
      n();
      return;
    }
    this.d = false;
    this.e = false;
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate
 * JD-Core Version:    0.7.0.1
 */