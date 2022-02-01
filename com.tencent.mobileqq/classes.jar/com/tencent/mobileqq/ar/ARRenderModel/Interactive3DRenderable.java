package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ar.ARMusicController;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ActionCallback;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;

public class Interactive3DRenderable
  implements ARNativeBridge.ActionCallback, ARBaseRender
{
  private volatile int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private ARMusicController jdField_a_of_type_ComTencentMobileqqArARMusicController;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  private ARRenderMangerInnerCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
  private Interactive3DResourceInfo jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int b;
  private volatile int c = 1;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public Interactive3DRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, Interactive3DResourceInfo paramInteractive3DResourceInfo, GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback = paramARRenderMangerInnerCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo = paramInteractive3DResourceInfo;
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a();
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(0));
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNativeState, mCurState=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", new State=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AREngine_Interactive3DRenderable", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 2) {}
    switch (paramInt)
    {
    default: 
    case 10: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.b);
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
      this.b = 0;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARMusicController;
      if (localObject != null)
      {
        ((ARMusicController)localObject).b();
        this.jdField_a_of_type_ComTencentMobileqqArARMusicController.c();
      }
      this.jdField_a_of_type_Int = 1;
      return;
    case 9: 
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new Interactive3DRenderable.1(this));
      return;
    case 8: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.b);
      return;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeResume(this.b);
      this.c = 0;
      a(11);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeonSurfaceChanged(this.b, this.d, this.e);
      return;
      ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
      this.b = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.getIndentification();
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
      long l = this.b;
      String str = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo.b;
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      ((ARNativeBridge)localObject).nativeCreateEngineBusiness(l, str, localContext, localContext.getAssets(), this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo.c, this.d, this.e, 100);
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
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.b, paramDrawFrameParements.a, (float[])paramDrawFrameParements.a("CAMERA_POSITION"));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playEffectMusic, ");
      localStringBuilder.append(paramString);
      QLog.d("AREngine_Interactive3DRenderable", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new Interactive3DRenderable.10(this, paramString));
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playBgMusic, ");
      localStringBuilder.append(paramString);
      QLog.d("AREngine_Interactive3DRenderable", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView.queueEvent(new Interactive3DRenderable.11(this, paramString));
  }
  
  public int c()
  {
    return 1;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "init");
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
      QLog.d("AREngine_Interactive3DRenderable", 2, localStringBuilder.toString());
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
    if (paramString1 == null) {
      return;
    }
    if (paramInt1 != 100) {}
    switch (paramInt1)
    {
    default: 
      switch (paramInt1)
      {
      default: 
        paramString1.a(this, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, paramInt1, 0, paramString2);
        return;
      case 64: 
        b("res/music/gameend_background.mp3");
        return;
      case 63: 
        a("res/music/aimed.mp3");
        return;
      case 62: 
        a("res/music/redpack_get.mp3");
        return;
      }
      b("res/music/gameing_background.mp3");
      return;
    case 59: 
      a("res/music/fudai_explode.mp3");
      return;
    case 58: 
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 300L) {
        return;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      a("res/music/fudai_click.mp3");
      return;
    case 56: 
      a("res/music/fudai_appear.mp3");
      b("res/music/fudai_background.mp3");
      return;
      this.g += 1;
      this.f += paramInt2;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "start");
    }
    if (1 == this.jdField_a_of_type_Int)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo.c;
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[8];
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/loading.mp3");
      arrayOfString[0] = localStringBuilder.toString();
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/321ready.mp3");
      arrayOfString[1] = localStringBuilder.toString();
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/redpack_open.mp3");
      arrayOfString[2] = localStringBuilder.toString();
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/fudai_click.mp3");
      arrayOfString[3] = localStringBuilder.toString();
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/fudai_explode.mp3");
      arrayOfString[4] = localStringBuilder.toString();
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/fudai_appear.mp3");
      arrayOfString[5] = localStringBuilder.toString();
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/redpack_get.mp3");
      arrayOfString[6] = localStringBuilder.toString();
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/aimed.mp3");
      arrayOfString[7] = localStringBuilder.toString();
      this.jdField_a_of_type_ComTencentMobileqqArARMusicController = new ARMusicController(1, this.jdField_a_of_type_ArrayOfJavaLangString);
      a(2);
      this.g = 0;
      this.f = 0;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
    if (localObject != null) {
      ((ARRenderMangerInnerCallback)localObject).a(this, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 100, 0, null);
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Int == 9) && (this.b != 0);
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
      QLog.d("AREngine_Interactive3DRenderable", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Int == 9)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy, queueEvent, ");
        ((StringBuilder)localObject).append(this);
        QLog.d("AREngine_Interactive3DRenderable", 2, ((StringBuilder)localObject).toString());
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
        ((ARRenderMangerInnerCallback)localObject).a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo.jdField_a_of_type_JavaLangString);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy, remove hsRender here, ");
        ((StringBuilder)localObject).append(this);
        QLog.d("AREngine_Interactive3DRenderable", 2, ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(this, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelInteractive3DResourceInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 101, 0, null);
      }
      if (this.jdField_a_of_type_Int == 9) {
        a(10);
      }
    }
    int i = this.g;
    if (i > 0)
    {
      float f1 = this.f * 1.0F / i;
      localObject = new HashMap();
      ((HashMap)localObject).put("fps_total", String.valueOf(this.f));
      ((HashMap)localObject).put("fps_count", String.valueOf(this.g));
      ((HashMap)localObject).put("fps_avg", String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(f1) }));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(BaseActivity.sTopActivity.getCurrentAccountUin(), "binhai_fps", true, 0L, 0L, (HashMap)localObject, "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable
 * JD-Core Version:    0.7.0.1
 */