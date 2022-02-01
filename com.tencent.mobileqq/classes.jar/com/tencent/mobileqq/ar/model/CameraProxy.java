package com.tencent.mobileqq.ar.model;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ar.arengine.ARCamera.AutoFocusListener;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class CameraProxy
  implements Camera.PreviewCallback, ARCamera.AutoFocusListener
{
  public static HandlerThread a;
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private ARCamera jdField_a_of_type_ComTencentMobileqqArArengineARCamera = null;
  private WeakReference<CameraProxy.OnCameraPreviewCallback> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<WeakReference<ARCamera.AutoFocusListener>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private volatile byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = 1;
  private ArrayList<WeakReference<CameraProxy.CameraOperationStatusCallBack>> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int = 0;
  private ArrayList<WeakReference<CameraProxy.OnCameraPreviewCallback>> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int d = 0;
  private int e = 17;
  private int f = 10;
  private int g;
  
  private CameraProxy()
  {
    if (jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
      jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera = new ARCamera();
    if (Build.MODEL.equalsIgnoreCase("Redmi Note 3")) {
      this.jdField_a_of_type_Long = 500L;
    } else {
      this.jdField_a_of_type_Long = 300L;
    }
    this.f = 0;
  }
  
  public static CameraProxy a()
  {
    return CameraProxy.CameraProxyHolder.a();
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i;
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      i = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
      if (i >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          if (paramBoolean) {
            ((CameraProxy.CameraOperationStatusCallBack)localWeakReference.get()).b();
          } else {
            ((CameraProxy.CameraOperationStatusCallBack)localWeakReference.get()).b(paramInt1, paramInt2);
          }
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String a()
  {
    int i = this.g;
    if (Build.MODEL.equalsIgnoreCase("M1 E")) {
      i = 90;
    }
    String str;
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      str = ((IOCR)QRoute.api(IOCR.class)).savePreviewImage(this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int, this.d, this.e, i);
    } else {
      str = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraProxy", 2, String.format("getLastPreviewFrame, path: %s, rotation: %s", new Object[] { str, Integer.valueOf(i) }));
    }
    return str;
  }
  
  public void a()
  {
    ARCamera localARCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera;
    if (localARCamera != null) {
      localARCamera.c();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openCamera mCurCameraState = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("CameraProxy", 2, localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_Int = 1;
    this.f = 0;
    a(new CameraProxy.1(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ARCamera localARCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera;
    if (localARCamera != null) {
      localARCamera.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ARCamera localARCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera;
    if (localARCamera != null) {
      localARCamera.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Boolean))
    {
      QLog.i("CameraProxy", 2, "startCameraPreview return now");
      return;
    }
    a(new CameraProxy.2(this, paramSurfaceTexture));
  }
  
  public void a(ARCamera.AutoFocusListener paramAutoFocusListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramAutoFocusListener) {
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramAutoFocusListener));
  }
  
  public void a(CameraProxy.CameraOperationStatusCallBack paramCameraOperationStatusCallBack)
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramCameraOperationStatusCallBack) {
          return;
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(new WeakReference(paramCameraOperationStatusCallBack));
      return;
    }
    for (;;)
    {
      throw paramCameraOperationStatusCallBack;
    }
  }
  
  public void a(CameraProxy.OnCameraPreviewCallback paramOnCameraPreviewCallback)
  {
    if (paramOnCameraPreviewCallback == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnCameraPreviewCallback);
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (jdField_a_of_type_AndroidOsHandlerThread)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((ARCamera.AutoFocusListener)localWeakReference.get()).a(paramBoolean);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 2;
  }
  
  public boolean a(float paramFloat, boolean paramBoolean)
  {
    ARCamera localARCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera;
    if (localARCamera != null) {
      return localARCamera.a(paramFloat, paramBoolean);
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(paramBoolean);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    ARCamera localARCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera;
    if (localARCamera != null) {
      localARCamera.d();
    }
  }
  
  public void b(ARCamera.AutoFocusListener paramAutoFocusListener)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get() == paramAutoFocusListener) {
        break label45;
      }
      i += 1;
    }
    i = -1;
    label45:
    if (i != -1) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(i);
    }
  }
  
  public void b(CameraProxy.CameraOperationStatusCallBack paramCameraOperationStatusCallBack)
  {
    int i;
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      int j = this.jdField_b_of_type_JavaUtilArrayList.size();
      i = 0;
      if (i < j) {
        if (((WeakReference)this.jdField_b_of_type_JavaUtilArrayList.get(i)).get() == paramCameraOperationStatusCallBack)
        {
          if (i != -1) {
            this.jdField_b_of_type_JavaUtilArrayList.remove(i);
          }
          return;
        }
      }
    }
  }
  
  public void b(CameraProxy.OnCameraPreviewCallback paramOnCameraPreviewCallback)
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramOnCameraPreviewCallback) {
          return;
        }
      }
      this.jdField_c_of_type_JavaUtilArrayList.add(new WeakReference(paramOnCameraPreviewCallback));
      return;
    }
    for (;;)
    {
      throw paramOnCameraPreviewCallback;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Boolean);
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c()
  {
    ARCamera localARCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera;
    if (localARCamera != null) {
      localARCamera.b();
    }
  }
  
  public void c(CameraProxy.OnCameraPreviewCallback paramOnCameraPreviewCallback)
  {
    int i;
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      int j = this.jdField_c_of_type_JavaUtilArrayList.size();
      i = 0;
      if (i < j) {
        if (((WeakReference)this.jdField_c_of_type_JavaUtilArrayList.get(i)).get() == paramOnCameraPreviewCallback)
        {
          if (i != -1) {
            this.jdField_c_of_type_JavaUtilArrayList.remove(i);
          }
          return;
        }
      }
    }
  }
  
  public void d()
  {
    ARCamera localARCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera;
    if (localARCamera != null) {
      localARCamera.e();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeCamera mCurCameraState = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("CameraProxy", 2, localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_Int = 3;
    a(new CameraProxy.3(this));
  }
  
  public void f()
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      }
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Object localObject = this.jdField_c_of_type_JavaUtilArrayList;
    boolean bool1 = false;
    try
    {
      i = this.jdField_c_of_type_JavaUtilArrayList.size() - 1;
      bool2 = bool1;
      if (i >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.jdField_c_of_type_JavaUtilArrayList.get(i);
        bool2 = bool1;
        if (localWeakReference.get() == null) {
          break label188;
        }
        bool1 = ((CameraProxy.OnCameraPreviewCallback)localWeakReference.get()).a(paramArrayOfByte);
        bool2 = bool1;
        if (!bool1) {
          break label188;
        }
        bool2 = bool1;
      }
      if ((!bool2) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((CameraProxy.OnCameraPreviewCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramArrayOfByte);
      }
      if (this.jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      } else {
        this.jdField_a_of_type_ArrayOfByte = null;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera;
      if (localObject != null) {
        this.g = ((ARCamera)localObject).d();
      }
      paramCamera.addCallbackBuffer(paramArrayOfByte);
      return;
    }
    finally
    {
      for (;;)
      {
        int i;
        boolean bool2;
        for (;;)
        {
          throw paramArrayOfByte;
        }
        label188:
        i -= 1;
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy
 * JD-Core Version:    0.7.0.1
 */