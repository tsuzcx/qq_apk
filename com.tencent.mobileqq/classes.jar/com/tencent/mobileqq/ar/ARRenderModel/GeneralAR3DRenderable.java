package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import com.tencent.mobileqq.ar.ARMusicController;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback;
import com.tencent.qphone.base.util.QLog;

class GeneralAR3DRenderable
  implements ARNativeBridge.ActionCallback, ARBaseRender
{
  private volatile int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private ARMusicController jdField_a_of_type_ComTencentMobileqqArARMusicController;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  private ARRenderMangerInnerCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
  private GeneralARResourceInfo jdField_a_of_type_ComTencentMobileqqArARRenderModelGeneralARResourceInfo;
  boolean jdField_a_of_type_Boolean = false;
  private int b;
  private volatile int c = 1;
  private int d;
  private int e;
  
  public GeneralAR3DRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, GeneralARResourceInfo paramGeneralARResourceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback = paramARRenderMangerInnerCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGeneralARResourceInfo = paramGeneralARResourceInfo;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a();
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(paramGeneralARResourceInfo.jdField_a_of_type_Int));
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setState, mCurState=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", new State=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", arTarget=");
      QLog.d("AREngine_GeneralAR3DRenderable", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 2) {}
    switch (paramInt)
    {
    default: 
    case 10: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
      this.jdField_b_of_type_Int = 0;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARMusicController;
      if (localObject != null)
      {
        ((ARMusicController)localObject).b();
        this.jdField_a_of_type_ComTencentMobileqqArARMusicController.c();
      }
      this.jdField_a_of_type_Int = 1;
      return;
    case 9: 
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new GeneralAR3DRenderable.1(this));
      return;
    case 8: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.jdField_b_of_type_Int);
      return;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeResume(this.jdField_b_of_type_Int);
      this.c = 0;
      a(11);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeonSurfaceChanged(this.jdField_b_of_type_Int, this.d, this.e);
      return;
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.getIndentification();
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
      long l = this.jdField_b_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGeneralARResourceInfo.jdField_b_of_type_JavaLangString;
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      ((ARNativeBridge)localObject).nativeCreateEngine(l, str, localContext, localContext.getAssets(), this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGeneralARResourceInfo.c, this.d, this.e);
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(this);
      a(7);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    a((float[])paramDrawFrameParements.a("TARGET_SIZE"), (float[])paramDrawFrameParements.a("POSE"), (float[])paramDrawFrameParements.a("CAMERA_MATRIX"), (float[])paramDrawFrameParements.a("CAMERA_POSITION"));
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGeneralARResourceInfo;
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat1.jdField_b_of_type_Int == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.jdField_b_of_type_Int, paramArrayOfFloat3, paramArrayOfFloat4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.jdField_b_of_type_Int, paramArrayOfFloat2, paramArrayOfFloat4);
  }
  
  public int b()
  {
    GeneralARResourceInfo localGeneralARResourceInfo = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGeneralARResourceInfo;
    if (localGeneralARResourceInfo != null) {
      return localGeneralARResourceInfo.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int c()
  {
    GeneralARResourceInfo localGeneralARResourceInfo = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGeneralARResourceInfo;
    if (localGeneralARResourceInfo != null) {
      return localGeneralARResourceInfo.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGeneralARResourceInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "init");
    }
  }
  
  public void callback(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fNativeDoActionCallback action=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", params=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", callbackId=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", result=");
      localStringBuilder.append(paramString2);
      QLog.d("AREngine_GeneralAR3DRenderable", 2, localStringBuilder.toString());
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
    if (paramString1 == null) {
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        return;
      }
      paramString1.b(2, 0);
      return;
    }
    paramString1.b(3, 0);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "start");
    }
    if (1 == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARMusicController = new ARMusicController(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGeneralARResourceInfo.d, "");
      a(2);
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Int == 9) && (this.jdField_b_of_type_Int != 0);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Int == 11)
    {
      int i = this.c + 1;
      this.c = i;
      if (i >= 2) {
        a(9);
      }
    }
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy, ");
      ((StringBuilder)localObject).append(this);
      QLog.d("AREngine_GeneralAR3DRenderable", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Int == 9)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy, queueEvent, ");
        ((StringBuilder)localObject).append(this);
        QLog.d("AREngine_GeneralAR3DRenderable", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
      if ((localObject != null) && (this.jdField_a_of_type_Boolean == true))
      {
        ((ARRenderMangerInnerCallback)localObject).b(1, 0);
        this.jdField_a_of_type_Boolean = false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
      if (localObject != null)
      {
        ((ARRenderMangerInnerCallback)localObject).a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGeneralARResourceInfo.jdField_a_of_type_JavaLangString);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy, remove hsRender here, ");
        ((StringBuilder)localObject).append(this);
        QLog.d("AREngine_GeneralAR3DRenderable", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_Int == 9) {
        a(10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.GeneralAR3DRenderable
 * JD-Core Version:    0.7.0.1
 */