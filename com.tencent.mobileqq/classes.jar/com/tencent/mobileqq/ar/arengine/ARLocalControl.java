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
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private long jdField_a_of_type_Long = 0L;
  ARLocalControl.ARLocalRecogCallback jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl$ARLocalRecogCallback = null;
  public ARLocalFaceRecog a;
  ARLocalGestureCircleRecog jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = null;
  ARLocalMarkerRecog jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog = null;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  private boolean d = false;
  
  public ARLocalControl()
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog = null;
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo)
  {
    QLog.i("AREngine_ARLocalControl", 1, "initFaceRecogAsync start.");
    ThreadManager.postImmediately(new ARLocalControl.1(this, paramInt1, paramInt2, paramContext, paramARScanStarFaceConfigInfo, System.currentTimeMillis()), null, true);
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalControl", 1, "stop start.");
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog;
    if (localObject != null) {
      ((ARLocalMarkerRecog)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog;
    if (localObject != null) {
      ((ARLocalFaceRecog)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog;
    if (localObject != null) {
      ((ARLocalGestureCircleRecog)localObject).c();
    }
    this.jdField_b_of_type_Boolean = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop end. mIsStarted = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pause. recogType = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
    if ((1L & paramLong) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog;
      if (localObject != null) {
        ((ARLocalMarkerRecog)localObject).b();
      }
    }
    if ((0x4 & paramLong) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog;
      if (localObject != null) {
        ((ARLocalFaceRecog)localObject).c();
      }
    }
    if ((paramLong & 0x1000) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog;
      if (localObject != null) {
        ((ARLocalGestureCircleRecog)localObject).a();
      }
    }
  }
  
  public void a(long paramLong, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl$ARLocalRecogCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl$ARLocalRecogCallback.a(paramLong, paramARLocalRecogResultBase);
      }
      return;
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      Object localObject;
      if (this.d)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog;
        if (localObject != null) {
          ((ARLocalGestureCircleRecog)localObject).a(paramLong, paramArrayOfByte);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog;
        if (localObject != null) {
          ((ARLocalMarkerRecog)localObject).a(paramLong, paramArrayOfByte);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog;
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
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog;
    if ((localObject != null) && (!((ARLocalMarkerRecog)localObject).a()))
    {
      this.jdField_b_of_type_Boolean = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start end. marker recog start failed. mIsStarted = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
      return this.jdField_b_of_type_Boolean;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog;
    if ((localObject != null) && (!((ARLocalFaceRecog)localObject).b()))
    {
      this.jdField_b_of_type_Boolean = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start end. face recog start failed. mIsStarted = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
      return this.jdField_b_of_type_Boolean;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog;
    if ((localObject != null) && (!((ARLocalGestureCircleRecog)localObject).c()))
    {
      this.jdField_b_of_type_Boolean = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start end. gesture circle recog start failed. mIsStarted = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
      return this.jdField_b_of_type_Boolean;
    }
    this.jdField_b_of_type_Boolean = true;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start end. mIsStarted = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
    return true;
  }
  
  public boolean a(long paramLong)
  {
    Object localObject;
    if ((1L & paramLong) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog;
      if (localObject != null) {
        return ((ARLocalMarkerRecog)localObject).b();
      }
    }
    if ((0x4 & paramLong) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog;
      if (localObject != null) {
        return ((ARLocalFaceRecog)localObject).c();
      }
    }
    if ((paramLong & 0x1000) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog;
      if (localObject != null) {
        return ((ARLocalGestureCircleRecog)localObject).d();
      }
    }
    return true;
  }
  
  public boolean a(Context arg1, long paramLong, int paramInt1, int paramInt2, ArConfigInfo paramArConfigInfo, ArrayList<ArCloudConfigInfo> paramArrayList, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, ARLocalControl.ARLocalRecogCallback paramARLocalRecogCallback)
  {
    long l = System.currentTimeMillis();
    QLog.i("AREngine_ARLocalControl", 1, String.format("init start. mIsInited=%s recogType=%s imageWidth=%s imageHeight=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl$ARLocalRecogCallback = paramARLocalRecogCallback;
    a(???, paramInt1, paramInt2, paramARScanStarFaceConfigInfo);
    QLog.i("AREngine_ARLocalControl", 1, "init running. marker recog start.");
    paramLong = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Long & 1L) != 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog = new ARLocalMarkerRecog();
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.a(paramInt1, paramInt2, paramArConfigInfo, paramArrayList, this)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog = null;
      }
    }
    if ((this.jdField_a_of_type_Long & 0x1000) != 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = new ARLocalGestureCircleRecog();
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.a(paramInt1, paramInt2, this)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = null;
      }
    }
    QLog.i("AREngine_ARLocalControl", 1, String.format("init running. marker recog end. time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) }));
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (!this.c) {
        QLog.i("AREngine_ARLocalControl", 1, "init running. face recog has not init complete, wait...");
      }
    }
    try
    {
      jdField_b_of_type_JavaLangObject.wait();
      label242:
      QLog.i("AREngine_ARLocalControl", 1, "init running. face recog init complete.");
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog == null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog == null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog == null)) {
        this.jdField_a_of_type_Boolean = false;
      } else {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_Boolean = false;
      QLog.i("AREngine_ARLocalControl", 1, String.format("init end. mIsInited=%s time cost:%sms", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(System.currentTimeMillis() - l) }));
      ARReport.a().a(System.currentTimeMillis() - l, this.jdField_a_of_type_Boolean);
      return this.jdField_a_of_type_Boolean;
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
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    ARLocalFaceRecog localARLocalFaceRecog = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog;
    if (localARLocalFaceRecog != null) {
      return localARLocalFaceRecog.a(paramARCloudRecogRspFaceResult);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    ARLocalMarkerRecog localARLocalMarkerRecog = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog;
    if (localARLocalMarkerRecog != null) {
      return localARLocalMarkerRecog.a(paramString1, paramString2, paramArCloudConfigInfo);
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = new ARLocalGestureCircleRecog();
        if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.a(paramInt1, paramInt2, this))
        {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = null;
          return false;
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.c();
        this.jdField_b_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Long |= 0x1000;
    }
    else
    {
      this.jdField_a_of_type_Long &= 0xFFFFEFFF;
    }
    this.d = paramBoolean;
    return this.d;
  }
  
  public float[] a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    ARLocalMarkerRecog localARLocalMarkerRecog = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog;
    if (localARLocalMarkerRecog != null) {
      return localARLocalMarkerRecog.a(paramInt1, paramInt2);
    }
    return null;
  }
  
  public void b()
  {
    QLog.i("AREngine_ARLocalControl", 1, "uninit start.");
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog;
    if (localObject != null) {
      ((ARLocalMarkerRecog)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog;
    if (localObject != null) {
      ((ARLocalFaceRecog)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog;
    if (localObject != null) {
      ((ARLocalGestureCircleRecog)localObject).d();
    }
    this.jdField_a_of_type_Boolean = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uninit end. mIsInited = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
  }
  
  public void b(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resume. recogType = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("AREngine_ARLocalControl", 1, ((StringBuilder)localObject).toString());
    if ((1L & paramLong) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog;
      if (localObject != null) {
        ((ARLocalMarkerRecog)localObject).c();
      }
    }
    if ((0x4 & paramLong) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog;
      if (localObject != null) {
        ((ARLocalFaceRecog)localObject).d();
      }
    }
    if ((paramLong & 0x1000) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog;
      if (localObject != null) {
        ((ARLocalGestureCircleRecog)localObject).b();
      }
    }
  }
  
  public boolean b(long paramLong)
  {
    if ((paramLong & 0x4) != 0L)
    {
      ARLocalFaceRecog localARLocalFaceRecog = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecog;
      if (localARLocalFaceRecog != null) {
        return localARLocalFaceRecog.d();
      }
    }
    return true;
  }
  
  public void c()
  {
    if (this.d)
    {
      ARLocalGestureCircleRecog localARLocalGestureCircleRecog = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog;
      if ((localARLocalGestureCircleRecog != null) && (!localARLocalGestureCircleRecog.d())) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalControl
 * JD-Core Version:    0.7.0.1
 */