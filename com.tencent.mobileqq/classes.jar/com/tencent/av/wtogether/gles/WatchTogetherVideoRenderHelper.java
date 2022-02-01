package com.tencent.av.wtogether.gles;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.tencent.av.VideoController;
import com.tencent.av.wtogether.callback.VideoSink;
import com.tencent.av.wtogether.callback.WatchTogetherSurfaceLifeCallback;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class WatchTogetherVideoRenderHelper
  implements VideoSink, WatchTogetherSurfaceLifeCallback
{
  private final float jdField_a_of_type_Float = 64.0F;
  private int jdField_a_of_type_Int;
  private WatchTogetherSurfaceTextureHolder jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final String jdField_a_of_type_JavaLangString;
  private WeakReference<GLSurfaceView> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f = false;
  
  public WatchTogetherVideoRenderHelper(boolean paramBoolean)
  {
    this.f = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder().append("WatchTogetherVideoRenderHelper");
    if (this.f) {}
    for (String str = "Floating-window";; str = "Full-screen")
    {
      this.jdField_a_of_type_JavaLangString = str;
      return;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((GLSurfaceView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).queueEvent(paramRunnable);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int j = 0;
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onSizeChanged");
    if ((this.jdField_a_of_type_Int != paramInt1) || (this.jdField_b_of_type_Int != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      }
      if (i == 0)
      {
        paramInt1 = j;
        if (this.jdField_b_of_type_Boolean) {}
      }
      else
      {
        paramInt1 = 1;
      }
      if (paramInt1 != 0) {
        this.jdField_c_of_type_Int = -1;
      }
      return;
    }
  }
  
  private boolean c()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((GLSurfaceView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).requestRender();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "run requestGLRender");
      return true;
    }
    return false;
  }
  
  private void d()
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.a("tryReleaseVideoSink", this);
    }
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onSurfaceDestroy");
    if ((this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder != null) && (Build.VERSION.SDK_INT >= 16)) {}
    synchronized (this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder.c();
        this.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder.d();
      this.jdField_c_of_type_Int = -1;
      d();
      this.jdField_d_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onSurfaceChange");
    c(paramInt1, paramInt2);
  }
  
  public void a(GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGLSurfaceView);
  }
  
  public boolean a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onVideoFrameResume");
    this.jdField_c_of_type_Boolean = true;
    a(new WatchTogetherVideoRenderHelper.1(this));
    return false;
  }
  
  public boolean a(@NonNull WatchTogetherSurfaceTextureHolder paramWatchTogetherSurfaceTextureHolder, int paramInt1, int paramInt2)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder = paramWatchTogetherSurfaceTextureHolder;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_d_of_type_Int = paramInt1;
      this.jdField_e_of_type_Int = paramInt2;
      return c();
    }
    finally {}
  }
  
  public void b()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onSurfaceCreate");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int j = 1;
    if ((this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder != null) && (this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder.a())) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_d_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder != null) && (this.jdField_c_of_type_Boolean) && (i != 0)) {
        break;
      }
      return;
    }
    c(paramInt1, paramInt2);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.jdField_c_of_type_Int < 0) {
            this.jdField_c_of_type_Int = GlUtil.createTexture(36197);
          }
          this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder.a(this.jdField_c_of_type_Int);
          this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder.a();
          this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherSurfaceTextureHolder.a(this.jdField_a_of_type_ArrayOfFloat);
        }
        int k = AIOUtils.a(64.0F, ((GLSurfaceView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
        int m = WTogetherUtil.a(((GLSurfaceView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getContext());
        int n = WTogetherUtil.a();
        int i1 = WTogetherUtil.a();
        if (paramInt1 < paramInt2)
        {
          i = j;
          if (i == 0) {
            break label277;
          }
          GLES20.glViewport(0, paramInt2 - (m + k + n), paramInt1, i1);
          this.jdField_b_of_type_ArrayOfFloat = GPUBaseFilter.caculateFitCenterMvpMatrix(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, paramInt1, i1);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
          if (i != 0) {
            GLES20.glViewport(0, 0, paramInt1, paramInt2);
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_e_of_type_Boolean = false;
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
      i = 0;
      continue;
      label277:
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.jdField_b_of_type_ArrayOfFloat = GPUBaseFilter.caculateFitCenterMvpMatrix(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onVideoFramePause");
    this.jdField_c_of_type_Boolean = false;
    a(new WatchTogetherVideoRenderHelper.2(this));
    return false;
  }
  
  public void c()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onActivityDestroy");
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      GLES20.glDisable(2929);
      GLES20.glDisable(3042);
      b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
    }
    catch (Exception paramGL10)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onDrawFrame e = " + paramGL10);
      StackTraceElement[] arrayOfStackTraceElement = paramGL10.getStackTrace();
      paramGL10 = "";
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        paramGL10 = paramGL10 + "WL_DEBUG onDrawFrame ste[" + i + "]" + arrayOfStackTraceElement[i].toString() + "\n";
        i += 1;
      }
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, paramGL10);
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.gles.WatchTogetherVideoRenderHelper
 * JD-Core Version:    0.7.0.1
 */