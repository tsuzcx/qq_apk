package com.tencent.mobileqq.activity.richmedia.view;

import ajow;
import ajru;
import ajrz;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import azdt;
import azei;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicReference;

public class FSurfaceViewLayout
  extends FrameLayout
{
  public GLSurfaceView a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  private volatile boolean e;
  
  public FSurfaceViewLayout(Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public FSurfaceViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    h();
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = false;
  }
  
  public int a()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      return ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_Ajrz.a;
    }
    return 0;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      super.addView(this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) && ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView))) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_Azei.a(paramBoolean, paramFloat1);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.e)
    {
      this.b = VideoEnvironment.a();
      if ((!VideoEnvironment.b()) || (!paramBoolean1)) {
        break label122;
      }
      paramBoolean1 = true;
      this.c = paramBoolean1;
      if (((!this.b) && (!this.c)) || (!paramBoolean2)) {
        break label127;
      }
    }
    label122:
    label127:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.d = paramBoolean1;
      this.e = true;
      if (QLog.isColorLevel()) {
        QLog.d("face", 2, "initEnvVar isSurpportFilter=" + this.c + ",needOpenglView=" + this.d);
      }
      if (!this.c) {
        break label132;
      }
      PtvFilterUtils.c(true);
      CameraFilterGLView.a();
      return;
      paramBoolean1 = false;
      break;
    }
    label132:
    PtvFilterUtils.c(false);
  }
  
  public boolean a()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      return ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).a();
    }
    return false;
  }
  
  public boolean a(Context paramContext, ajru paramajru, PreviewContext paramPreviewContext)
  {
    if (!this.d)
    {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
      return false;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, localDisplayMetrics.heightPixels);
    localLayoutParams.height = localDisplayMetrics.heightPixels;
    localLayoutParams.width = localDisplayMetrics.widthPixels;
    localLayoutParams.gravity = 49;
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "initSurfaceView needChangeNewSurfaceView=" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      super.setVisibility(8);
      if (!this.c) {
        break label241;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        super.removeAllViews();
        if ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) && ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView))) {
          ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).e();
        }
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
      }
      if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView == null)
      {
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView = new CameraFilterGLView(paramContext, null);
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setVisibility(8);
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setId(2131366525);
      }
      paramContext = (CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
      paramContext.setFilterListener(paramajru);
      paramContext.setVideoContext(paramPreviewContext);
      paramContext.b();
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      return true;
      super.setVisibility(0);
      break;
      label241:
      if (this.jdField_a_of_type_Boolean)
      {
        super.removeAllViews();
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
      }
      if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView == null)
      {
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView = new CameraGLSurfaceView(paramContext);
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setId(2131366534);
        this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setVisibility(8);
      }
      paramContext = (CameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
      paramContext.setVideoContext(paramPreviewContext);
      paramContext.a();
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setLayoutParams(localLayoutParams);
    }
  }
  
  public int b()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      return ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_Azdt.c();
    }
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.onPause();
    }
  }
  
  public boolean b()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) && ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView))) {
      return ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_Azei.d;
    }
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.onResume();
    }
  }
  
  public boolean c()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) && ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView))) {
      return ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_Azei.e;
    }
    return true;
  }
  
  public void d()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null))
    {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).f();
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).g();
    }
  }
  
  public void e()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_Azdt.b();
    }
  }
  
  public void f()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).c();
    }
  }
  
  public void g()
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) && ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView))) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).d();
    }
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) && ((this.jdField_a_of_type_AndroidOpenglGLSurfaceView instanceof CameraFilterGLView))) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    }
  }
  
  public void setEnableBeauty(boolean paramBoolean)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setEnableBeauty(paramBoolean);
    }
  }
  
  public void setHwEncoder(SVHwEncoder paramSVHwEncoder)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.getAndSet(paramSVHwEncoder);
    }
  }
  
  public void setNeedWrite(boolean paramBoolean)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setNeedWrite(paramBoolean);
    }
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, ajow paramajow)
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView == null) {
      return;
    }
    if (this.c)
    {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setPreviewSize(paramInt1, paramInt2, paramajow);
      return;
    }
    ((CameraGLSurfaceView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setPreviewSize(paramInt1, paramInt2, paramajow);
  }
  
  public void setVideoFilter(String paramString)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setVideoFilter(paramString);
    }
  }
  
  public void setVideoFilter(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setVideoFilter(paramString1, paramInt, paramString2, paramString3);
    }
  }
  
  public void setVideoFilter(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.c) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
      ((CameraFilterGLView)this.jdField_a_of_type_AndroidOpenglGLSurfaceView).setVideoFilter(paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null) {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.setVisibility(paramInt);
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout
 * JD-Core Version:    0.7.0.1
 */