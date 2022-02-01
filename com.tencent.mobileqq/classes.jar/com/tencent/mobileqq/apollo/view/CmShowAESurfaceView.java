package com.tencent.mobileqq.apollo.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RequiresApi;
import ankl;
import anno;
import annp;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.FrameUtil;
import java.util.HashMap;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CmShowAESurfaceView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AnimatorListenerAdapter jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter = new annp(this);
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new anno(this);
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private SpaceFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter = new SpaceFilter();
  private Runnable jdField_a_of_type_JavaLangRunnable = new CmShowAESurfaceView.1(this);
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 1.0F, 1.0F, 1.0F };
  private int jdField_b_of_type_Int;
  private Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private Runnable jdField_b_of_type_JavaLangRunnable = new CmShowAESurfaceView.2(this);
  private int c;
  private int d;
  private int e = 33;
  private int f;
  
  public CmShowAESurfaceView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public CmShowAESurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    float f1 = (float)((paramMotionEvent.getX() - this.jdField_a_of_type_AndroidGraphicsPointF.x) / this.jdField_a_of_type_Int * 360.0F * 3.141592653589793D / 180.0D);
    this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getX(0);
    this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getY(0);
    return f1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.applyFilterChain(true, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.setRenderMode(2);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.applyFilterChain(true, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setRenderMode(2);
  }
  
  private void a(String paramString)
  {
    queueEvent(new CmShowAESurfaceView.8(this, paramString));
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {}
    while ((paramMotionEvent.getX() < this.jdField_a_of_type_AndroidGraphicsRect.right) && (paramMotionEvent.getX() > this.jdField_a_of_type_AndroidGraphicsRect.left) && (paramMotionEvent.getY() < this.jdField_a_of_type_AndroidGraphicsRect.bottom) && (paramMotionEvent.getY() > this.jdField_a_of_type_AndroidGraphicsRect.top)) {
      return true;
    }
    return false;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = new AEFilterManager();
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.enableAIDetect(false);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.defineFiltersAndOrder(new int[] { 102, 103 });
  }
  
  private void c()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setRenderer(this);
    setRenderMode(0);
    QLog.i("CmShowAESurfaceView", 1, "init complete.");
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() > 0)) {
      queueEvent(new CmShowAESurfaceView.6(this));
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 1, this.e });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.e);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      ankl.a("dressup_3d_page", "model", "rotate", null);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      e();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      QLog.i("CmShowAESurfaceView", 1, "mAnimator.start().");
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(int paramInt1, int paramInt2, Frame paramFrame)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, 0, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      return;
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      QLog.i("CmShowAESurfaceView", 1, "cancelAnimator().");
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeListener(this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter);
      return;
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      post(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    FrameUtil.clearFrame(this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame, this.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_ArrayOfFloat[1], this.jdField_a_of_type_ArrayOfFloat[2], this.jdField_a_of_type_ArrayOfFloat[3], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    PTFaceAttr.EmptyFaceAttr.setTimeStamp(System.currentTimeMillis());
    paramGL10 = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    paramGL10.setParam("SET_TEMP_FACEATTR", PTFaceAttr.EmptyFaceAttr);
    int i = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), false, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    paramGL10 = this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(i, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.width, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.height);
    a(this.c, this.d, paramGL10);
    paramGL10.unlock();
    d();
  }
  
  public void onPause()
  {
    queueEvent(new CmShowAESurfaceView.7(this));
    super.onPause();
  }
  
  @RequiresApi(api=16)
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    QLog.i("CmShowAESurfaceView", 1, "onSurfaceChanged ,(" + paramInt1 + "," + paramInt2 + ")");
    this.c = paramInt1;
    this.d = paramInt2;
    e();
    a();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    QLog.i("CmShowAESurfaceView", 1, "onSurfaceCreated.");
    this.jdField_a_of_type_Int = getMeasuredWidth();
    this.jdField_b_of_type_Int = getMeasuredHeight();
    a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_JavaLangString != null) {
      a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a(paramMotionEvent)) {
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return true;
      this.f = 1;
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getX(0);
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getY(0);
      continue;
      this.f = 2;
      continue;
      if (this.f == 1)
      {
        setTouchRotate(new float[] { 0.0F, a(paramMotionEvent), 0.0F });
        continue;
        this.f = 0;
        f();
      }
    }
  }
  
  public void setBackgroundColor(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[] { paramFloat1, paramFloat2, paramFloat3, 1.0F };
  }
  
  public void setFrameInterval(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setMaterialPath(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramString);
  }
  
  public void setParam(String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      queueEvent(new CmShowAESurfaceView.5(this, paramString, paramObject));
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramObject);
  }
  
  public void setTouchRotate(float[] paramArrayOfFloat)
  {
    queueEvent(new CmShowAESurfaceView.10(this, paramArrayOfFloat));
  }
  
  public void setTouchScale(float paramFloat)
  {
    queueEvent(new CmShowAESurfaceView.9(this, paramFloat));
  }
  
  public void setTouchableRect(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    b();
    super.surfaceDestroyed(paramSurfaceHolder);
    QLog.i("CmShowAESurfaceView", 1, "surfaceDestroyed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView
 * JD-Core Version:    0.7.0.1
 */