package com.tencent.mobileqq.armap;

import aavh;
import aavi;
import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.util.AttributeSet;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class CameraSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  public int a;
  aavh jdField_a_of_type_Aavh = new aavh(this);
  aavi jdField_a_of_type_Aavi = new aavi(this);
  Camera.PreviewCallback jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = null;
  Camera jdField_a_of_type_AndroidHardwareCamera = null;
  Display jdField_a_of_type_AndroidViewDisplay = null;
  CameraSurfaceView.CameraSurfaceViewCallBack jdField_a_of_type_ComTencentMobileqqArmapCameraSurfaceView$CameraSurfaceViewCallBack;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  boolean b;
  public int c = 17;
  
  public CameraSurfaceView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 320;
    this.jdField_b_of_type_Int = 240;
    a();
  }
  
  public CameraSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 320;
    this.jdField_b_of_type_Int = 240;
    a();
  }
  
  public CameraSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 320;
    this.jdField_b_of_type_Int = 240;
    a();
  }
  
  private Camera.Size a(List paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      return null;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject1).next();
      if ((((Camera.Size)localObject2).width == paramInt1) && (((Camera.Size)localObject2).height == paramInt2)) {
        return localObject2;
      }
    }
    double d3 = paramInt1 / paramInt2;
    localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    double d2;
    if (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (((paramInt1 > paramInt2) && (((Camera.Size)localObject2).width > ((Camera.Size)localObject2).height)) || ((paramInt1 < paramInt2) && (((Camera.Size)localObject2).width < ((Camera.Size)localObject2).height)))
      {
        d2 = ((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height;
        label153:
        if (Math.abs(d2 - d3) > 0.05D) {
          break label221;
        }
        if (Math.abs(((Camera.Size)localObject2).height - paramInt2) >= d1) {
          break label313;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    label307:
    label313:
    for (;;)
    {
      break;
      d2 = ((Camera.Size)localObject2).height / ((Camera.Size)localObject2).width;
      break label153;
      label221:
      break;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        d1 = 1.7976931348623157E+308D;
        localIterator = paramList.iterator();
        localObject2 = localObject1;
        if (localIterator.hasNext())
        {
          paramList = (Camera.Size)localIterator.next();
          if (Math.abs(paramList.height - paramInt2) >= d1) {
            break label307;
          }
          d1 = Math.abs(paramList.height - paramInt2);
        }
      }
      for (;;)
      {
        localObject1 = paramList;
        break;
        return localObject2;
        paramList = (List)localObject1;
      }
    }
  }
  
  void a()
  {
    this.jdField_b_of_type_Boolean = false;
    getHolder().addCallback(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(null);
        this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
        this.jdField_a_of_type_Boolean = false;
        if ((!paramBoolean) && (this.jdField_b_of_type_Boolean)) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(null);
          this.jdField_a_of_type_AndroidHardwareCamera.release();
          this.jdField_a_of_type_AndroidHardwareCamera = null;
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSurfaceView", 2, "openCamera");
    }
    ThreadManager.post(this.jdField_a_of_type_Aavi, 8, null, false);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSurfaceView", 2, "closeCamera");
    }
    ThreadManager.post(this.jdField_a_of_type_Aavh, 8, null, false);
  }
  
  @TargetApi(9)
  public void d()
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidHardwareCamera == null) {}
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(0);
        int i = 90;
        if (CameraCompatibleList.d(CameraCompatibleList.g)) {
          i = 270;
        }
        this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(i);
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        Camera.Size localSize = a(localParameters.getSupportedPreviewSizes(), 640, 480);
        if (localSize != null)
        {
          localParameters.setPreviewSize(localSize.width, localSize.height);
          this.jdField_a_of_type_Int = localSize.width;
          this.jdField_b_of_type_Int = localSize.height;
          if (QLog.isColorLevel()) {
            QLog.i("CameraSurfaceView", 2, "previewSize w h " + this.jdField_a_of_type_Int + "   " + this.jdField_b_of_type_Int);
          }
        }
        if (localParameters.getSupportedFocusModes().contains("continuous-video")) {
          localParameters.setFocusMode("continuous-video");
        }
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
        this.c = localParameters.getPreviewFormat();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera != null) {}
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(getHolder());
        if (this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback != null) {
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback);
        }
        this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
        this.jdField_a_of_type_Boolean = true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          this.jdField_a_of_type_Boolean = false;
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqArmapCameraSurfaceView$CameraSurfaceViewCallBack == null);
    this.jdField_a_of_type_ComTencentMobileqqArmapCameraSurfaceView$CameraSurfaceViewCallBack.onStartPreview(this.jdField_a_of_type_Boolean);
  }
  
  public void setCameraSurfaceCallBack(CameraSurfaceView.CameraSurfaceViewCallBack paramCameraSurfaceViewCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapCameraSurfaceView$CameraSurfaceViewCallBack = paramCameraSurfaceViewCallBack;
  }
  
  public void setDisplay(Display paramDisplay)
  {
    this.jdField_a_of_type_AndroidViewDisplay = paramDisplay;
  }
  
  public void setPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = paramPreviewCallback;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    d();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CameraSurfaceView
 * JD-Core Version:    0.7.0.1
 */