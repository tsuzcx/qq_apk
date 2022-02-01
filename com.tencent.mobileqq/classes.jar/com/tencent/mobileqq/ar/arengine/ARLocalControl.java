package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ARLocalControl
  implements ARLocalFaceRecog.ARLocalFaceRecogCallback, ARLocalGestureCircleRecog.ARLocalGestureCircleRecogCallback, ARLocalMarkerRecog.ARLocalMarkerRecogCallback
{
  private static final Object i = new Object();
  ARLocalMarkerRecog a = null;
  public ARLocalFaceRecog b = null;
  ARLocalGestureCircleRecog c = null;
  ARLocalControl.ARLocalRecogCallback d = null;
  Object e = new Object();
  private long f = 0L;
  private boolean g = false;
  private boolean h = false;
  private boolean j;
  private boolean k = false;
  
  private void a(Context paramContext, int paramInt1, int paramInt2, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo)
  {
    QLog.i("AREngine_ARLocalControl", 1, "initFaceRecogAsync start.");
    ThreadManager.postImmediately(new ARLocalControl.1(this, paramInt1, paramInt2, paramContext, paramARScanStarFaceConfigInfo, System.currentTimeMillis()), null, true);
  }
  
  public void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pause. recogType = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
    if ((1L & paramLong) != 0L)
    {
      localObject = this.a;
      if (localObject != null) {
        ((ARLocalMarkerRecog)localObject).c();
      }
    }
    if ((0x4 & paramLong) != 0L)
    {
      localObject = this.b;
      if (localObject != null) {
        ((ARLocalFaceRecog)localObject).e();
      }
    }
    if ((paramLong & 0x1000) != 0L)
    {
      localObject = this.c;
      if (localObject != null) {
        ((ARLocalGestureCircleRecog)localObject).d();
      }
    }
  }
  
  public void a(long paramLong, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    synchronized (this.e)
    {
      if ((this.h) && (this.d != null)) {
        this.d.a(paramLong, paramARLocalRecogResultBase);
      }
      return;
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (!this.h) {
        return;
      }
      Object localObject;
      if (this.k)
      {
        localObject = this.c;
        if (localObject != null) {
          ((ARLocalGestureCircleRecog)localObject).a(paramLong, paramArrayOfByte);
        }
      }
      else
      {
        localObject = this.a;
        if (localObject != null) {
          ((ARLocalMarkerRecog)localObject).a(paramLong, paramArrayOfByte);
        }
        localObject = this.b;
        if (localObject != null) {
          ((ARLocalFaceRecog)localObject).a(paramLong, paramArrayOfByte);
        }
      }
    }
  }
  
  public void a(ARLocalFaceRecogResult paramARLocalFaceRecogResult)
  {
    a(4L, paramARLocalFaceRecogResult);
  }
  
  public void a(ARLocalGestureCircleRecogResult paramARLocalGestureCircleRecogResult)
  {
    a(4096L, paramARLocalGestureCircleRecogResult);
  }
  
  public void a(ARLocalMarkerRecogResult paramARLocalMarkerRecogResult)
  {
    a(1L, paramARLocalMarkerRecogResult);
  }
  
  public boolean a()
  {
    QLog.i("AREngine_ARLocalControl", 1, "start start.");
    if (!this.g) {
      return false;
    }
    if (this.h) {
      return true;
    }
    Object localObject = this.a;
    if ((localObject != null) && (!((ARLocalMarkerRecog)localObject).b()))
    {
      this.h = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start end. marker recog start failed. mIsStarted = ");
      ((StringBuilder)localObject).append(this.h);
      QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
      return this.h;
    }
    localObject = this.b;
    if ((localObject != null) && (!((ARLocalFaceRecog)localObject).d()))
    {
      this.h = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start end. face recog start failed. mIsStarted = ");
      ((StringBuilder)localObject).append(this.h);
      QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
      return this.h;
    }
    localObject = this.c;
    if ((localObject != null) && (!((ARLocalGestureCircleRecog)localObject).c()))
    {
      this.h = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start end. gesture circle recog start failed. mIsStarted = ");
      ((StringBuilder)localObject).append(this.h);
      QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
      return this.h;
    }
    this.h = true;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start end. mIsStarted = ");
    ((StringBuilder)localObject).append(this.h);
    QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
    return true;
  }
  
  public boolean a(Context arg1, long paramLong, int paramInt1, int paramInt2, ArConfigInfo paramArConfigInfo, ArrayList<ArCloudConfigInfo> paramArrayList, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, ARLocalControl.ARLocalRecogCallback paramARLocalRecogCallback)
  {
    long l = System.currentTimeMillis();
    QLog.i("AREngine_ARLocalControl", 1, String.format("init start. mIsInited=%s recogType=%s imageWidth=%s imageHeight=%s", new Object[] { Boolean.valueOf(this.g), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.g) {
      return true;
    }
    this.f = paramLong;
    this.d = paramARLocalRecogCallback;
    a(???, paramInt1, paramInt2, paramARScanStarFaceConfigInfo);
    QLog.i("AREngine_ARLocalControl", 1, "init running. marker recog start.");
    paramLong = System.currentTimeMillis();
    if ((this.f & 1L) != 0L)
    {
      this.a = new ARLocalMarkerRecog();
      if (!this.a.a(paramInt1, paramInt2, paramArConfigInfo, paramArrayList, this)) {
        this.a = null;
      }
    }
    if ((this.f & 0x1000) != 0L)
    {
      this.c = new ARLocalGestureCircleRecog();
      if (!this.c.a(paramInt1, paramInt2, this)) {
        this.c = null;
      }
    }
    QLog.i("AREngine_ARLocalControl", 1, String.format("init running. marker recog end. time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) }));
    synchronized (i)
    {
      if (!this.j) {
        QLog.i("AREngine_ARLocalControl", 1, "init running. face recog has not init complete, wait...");
      }
    }
    try
    {
      i.wait();
      label242:
      QLog.i("AREngine_ARLocalControl", 1, "init running. face recog init complete.");
      if ((this.a == null) && (this.b == null) && (this.c == null)) {
        this.g = false;
      } else {
        this.g = true;
      }
      this.h = false;
      QLog.i("AREngine_ARLocalControl", 1, String.format("init end. mIsInited=%s time cost:%sms", new Object[] { Boolean.valueOf(this.g), Long.valueOf(System.currentTimeMillis() - l) }));
      ARReport.a().a(System.currentTimeMillis() - l, this.g);
      return this.g;
      paramArConfigInfo = finally;
      throw paramArConfigInfo;
    }
    catch (Exception paramArConfigInfo)
    {
      break label242;
    }
  }
  
  public boolean a(ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    if (!this.h) {
      return false;
    }
    ARLocalFaceRecog localARLocalFaceRecog = this.b;
    if (localARLocalFaceRecog != null) {
      return localARLocalFaceRecog.a(paramARCloudRecogRspFaceResult);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (!this.h) {
      return false;
    }
    ARLocalMarkerRecog localARLocalMarkerRecog = this.a;
    if (localARLocalMarkerRecog != null) {
      return localARLocalMarkerRecog.a(paramString1, paramString2, paramArCloudConfigInfo);
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.c == null)
      {
        this.c = new ARLocalGestureCircleRecog();
        if (!this.c.a(paramInt1, paramInt2, this))
        {
          this.c = null;
          return false;
        }
        this.g = true;
        this.c.c();
        this.h = true;
      }
      this.f |= 0x1000;
    }
    else
    {
      this.f &= 0xFFFFEFFF;
    }
    this.k = paramBoolean;
    return this.k;
  }
  
  public float[] a(int paramInt1, int paramInt2)
  {
    if (!this.g) {
      return null;
    }
    ARLocalMarkerRecog localARLocalMarkerRecog = this.a;
    if (localARLocalMarkerRecog != null) {
      return localARLocalMarkerRecog.a(paramInt1, paramInt2);
    }
    return null;
  }
  
  public void b()
  {
    QLog.i("AREngine_ARLocalControl", 1, "stop start.");
    if (!this.g) {
      return;
    }
    if (!this.h) {
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((ARLocalMarkerRecog)localObject).f();
    }
    localObject = this.b;
    if (localObject != null) {
      ((ARLocalFaceRecog)localObject).i();
    }
    localObject = this.c;
    if (localObject != null) {
      ((ARLocalGestureCircleRecog)localObject).g();
    }
    this.h = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop end. mIsStarted = ");
    ((StringBuilder)localObject).append(this.h);
    QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
  }
  
  public boolean b(long paramLong)
  {
    Object localObject;
    if ((1L & paramLong) != 0L)
    {
      localObject = this.a;
      if (localObject != null) {
        return ((ARLocalMarkerRecog)localObject).d();
      }
    }
    if ((0x4 & paramLong) != 0L)
    {
      localObject = this.b;
      if (localObject != null) {
        return ((ARLocalFaceRecog)localObject).f();
      }
    }
    if ((paramLong & 0x1000) != 0L)
    {
      localObject = this.c;
      if (localObject != null) {
        return ((ARLocalGestureCircleRecog)localObject).e();
      }
    }
    return true;
  }
  
  public void c()
  {
    QLog.i("AREngine_ARLocalControl", 1, "uninit start.");
    if (!this.g) {
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((ARLocalMarkerRecog)localObject).g();
    }
    localObject = this.b;
    if (localObject != null) {
      ((ARLocalFaceRecog)localObject).c();
    }
    localObject = this.c;
    if (localObject != null) {
      ((ARLocalGestureCircleRecog)localObject).h();
    }
    this.g = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uninit end. mIsInited = ");
    ((StringBuilder)localObject).append(this.g);
    QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
  }
  
  public boolean c(long paramLong)
  {
    if ((paramLong & 0x4) != 0L)
    {
      ARLocalFaceRecog localARLocalFaceRecog = this.b;
      if (localARLocalFaceRecog != null) {
        return localARLocalFaceRecog.g();
      }
    }
    return true;
  }
  
  public void d()
  {
    if (this.k)
    {
      ARLocalGestureCircleRecog localARLocalGestureCircleRecog = this.c;
      if ((localARLocalGestureCircleRecog != null) && (!localARLocalGestureCircleRecog.e())) {
        this.c.i();
      }
    }
  }
  
  public void d(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resume. recogType = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
    if ((1L & paramLong) != 0L)
    {
      localObject = this.a;
      if (localObject != null) {
        ((ARLocalMarkerRecog)localObject).e();
      }
    }
    if ((0x4 & paramLong) != 0L)
    {
      localObject = this.b;
      if (localObject != null) {
        ((ARLocalFaceRecog)localObject).h();
      }
    }
    if ((paramLong & 0x1000) != 0L)
    {
      localObject = this.c;
      if (localObject != null) {
        ((ARLocalGestureCircleRecog)localObject).f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalControl
 * JD-Core Version:    0.7.0.1
 */