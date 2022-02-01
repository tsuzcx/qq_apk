package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import com.tencent.mobileqq.ar.ARMusicController;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback;
import com.tencent.qphone.base.util.QLog;

class GeneralAR3DRenderable
  implements ARNativeBridge.ActionCallback, ARBaseRender
{
  boolean a = false;
  private Context b;
  private volatile int c = 1;
  private GeneralARResourceInfo d;
  private ARRenderMangerInnerCallback e;
  private ARNativeBridge f;
  private int g;
  private volatile int h = 1;
  private int i;
  private int j;
  private ARMusicController k;
  
  public GeneralAR3DRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, GeneralARResourceInfo paramGeneralARResourceInfo)
  {
    this.e = paramARRenderMangerInnerCallback;
    this.d = paramGeneralARResourceInfo;
    this.b = this.e.a();
    this.f = ((ARNativeBridge)this.e.a(paramGeneralARResourceInfo.b));
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setState, mCurState=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", new State=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", arTarget=");
      QLog.d("AREngine_GeneralAR3DRenderable", 2, ((StringBuilder)localObject).toString());
    }
    this.c = paramInt;
    if (paramInt != 2) {}
    switch (paramInt)
    {
    default: 
    case 10: 
      this.f.nativeDestroyCertainEngine(this.g);
      this.f.setupActionCallback(null);
      this.g = 0;
      localObject = this.k;
      if (localObject != null)
      {
        ((ARMusicController)localObject).b();
        this.k.c();
      }
      this.c = 1;
      return;
    case 9: 
      this.e.a(new GeneralAR3DRenderable.1(this));
      return;
    case 8: 
      this.f.nativePause(this.g);
      return;
    case 7: 
      this.f.nativeResume(this.g);
      this.h = 0;
      a(11);
      return;
    case 6: 
      this.f.nativeonSurfaceChanged(this.g, this.i, this.j);
      return;
      this.g = this.f.getIndentification();
      localObject = this.f;
      long l = this.g;
      String str = this.d.i;
      Context localContext = this.b;
      ((ARNativeBridge)localObject).nativeCreateEngine(l, str, localContext, localContext.getAssets(), this.d.j, this.i, this.j);
      this.f.setupActionCallback(this);
      a(7);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    a((float[])paramDrawFrameParements.a("TARGET_SIZE"), (float[])paramDrawFrameParements.a("POSE"), (float[])paramDrawFrameParements.a("CAMERA_MATRIX"), (float[])paramDrawFrameParements.a("CAMERA_POSITION"));
  }
  
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    paramArrayOfFloat1 = this.d;
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat1.d == 1))
    {
      this.f.nativeOnDrawFrame(this.g, paramArrayOfFloat3, paramArrayOfFloat4);
      return;
    }
    this.f.nativeOnDrawFrame(this.g, paramArrayOfFloat2, paramArrayOfFloat4);
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
    paramString1 = this.e;
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
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "init");
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_GeneralAR3DRenderable", 2, "start");
    }
    if (1 == this.c)
    {
      this.k = new ARMusicController(this.d.k, "");
      a(2);
    }
  }
  
  public void k()
  {
    if (this.c == 11)
    {
      int m = this.h + 1;
      this.h = m;
      if (m >= 2) {
        a(9);
      }
    }
  }
  
  public void l()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy, ");
      ((StringBuilder)localObject).append(this);
      QLog.d("AREngine_GeneralAR3DRenderable", 2, ((StringBuilder)localObject).toString());
    }
    if (this.c == 9)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy, queueEvent, ");
        ((StringBuilder)localObject).append(this);
        QLog.d("AREngine_GeneralAR3DRenderable", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.e;
      if ((localObject != null) && (this.a == true))
      {
        ((ARRenderMangerInnerCallback)localObject).b(1, 0);
        this.a = false;
      }
      localObject = this.e;
      if (localObject != null)
      {
        ((ARRenderMangerInnerCallback)localObject).a(this.d.a);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy, remove hsRender here, ");
        ((StringBuilder)localObject).append(this);
        QLog.d("AREngine_GeneralAR3DRenderable", 2, ((StringBuilder)localObject).toString());
      }
      if (this.c == 9) {
        a(10);
      }
    }
  }
  
  public int m()
  {
    GeneralARResourceInfo localGeneralARResourceInfo = this.d;
    if (localGeneralARResourceInfo != null) {
      return localGeneralARResourceInfo.b;
    }
    return 0;
  }
  
  public String n()
  {
    return this.d.a;
  }
  
  public boolean o()
  {
    return (this.c == 9) && (this.g != 0);
  }
  
  public boolean p()
  {
    return true;
  }
  
  public int q()
  {
    GeneralARResourceInfo localGeneralARResourceInfo = this.d;
    if (localGeneralARResourceInfo != null) {
      return localGeneralARResourceInfo.d;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.GeneralAR3DRenderable
 * JD-Core Version:    0.7.0.1
 */