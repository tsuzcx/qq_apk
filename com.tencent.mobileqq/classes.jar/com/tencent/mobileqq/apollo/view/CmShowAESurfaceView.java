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
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.FrameUtil;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.light.CameraController.CameraViewType;
import org.light.CameraController.CmShowCallback;

public class CmShowAESurfaceView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private AnimatorListenerAdapter jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter = new CmShowAESurfaceView.4(this);
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new CmShowAESurfaceView.3(this);
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private SpaceFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter = new SpaceFilter();
  private Runnable jdField_a_of_type_JavaLangRunnable = new CmShowAESurfaceView.1(this);
  String jdField_a_of_type_JavaLangString;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private List<AEResInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  CameraController.CmShowCallback jdField_a_of_type_OrgLightCameraController$CmShowCallback;
  boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 1.0F, 1.0F, 1.0F };
  private int jdField_b_of_type_Int;
  private Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private Runnable jdField_b_of_type_JavaLangRunnable = new CmShowAESurfaceView.2(this);
  private String jdField_b_of_type_JavaLangString = null;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e = 33;
  private int f = 0;
  
  public CmShowAESurfaceView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public CmShowAESurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
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
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    QLog.d("CmShowAESurfaceView", 2, "[cmshowFirstTime][updateCmshowMaterial]:" + paramVideoMaterial.getDataPath());
    if (AEMaterialManager.a(paramVideoMaterial))
    {
      AEQLog.a("PreCheckAERes", "[setMaterial] set special template");
      if (!AEResUtil.a(AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo)) {
        break label131;
      }
      AEQLog.a("PreCheckAERes", "[setMaterial] version check success");
      if (!FeatureManager.ensureMaterialSoLoaded(paramVideoMaterial)) {
        break label121;
      }
      AEQLog.a("PreCheckAERes", "[setMaterial] so load success");
      long l = AEResUtil.a(paramVideoMaterial);
      if (l != 0L)
      {
        AEQLog.a("PreCheckAERes", "[setMaterial] bundleStatus not ready, go fetch bundles ...");
        AEResUtil.a(getContext(), l);
      }
    }
    else
    {
      return;
    }
    AEQLog.a("PreCheckAERes", "[setMaterial] bundleStatus ready, apply material...");
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
      this.jdField_d_of_type_Boolean = true;
      return;
      label121:
      AEQLog.d("PreCheckAERes", "[setMaterial] so load failed");
      continue;
      label131:
      AEQLog.d("PreCheckAERes", "[setMaterial] version check failed");
    }
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    queueEvent(new CmShowAESurfaceView.7(this, paramString));
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {}
    while ((paramMotionEvent.getX() < this.jdField_a_of_type_AndroidGraphicsRect.right) && (paramMotionEvent.getX() > this.jdField_a_of_type_AndroidGraphicsRect.left) && (paramMotionEvent.getY() < this.jdField_a_of_type_AndroidGraphicsRect.bottom) && (paramMotionEvent.getY() > this.jdField_a_of_type_AndroidGraphicsRect.top)) {
      return true;
    }
    return false;
  }
  
  private int[] a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt2 > 720)
    {
      i = (int)(720.0F / paramInt1 * paramInt2);
      j = 720;
    }
    arrayOfInt[0] = j;
    arrayOfInt[1] = i;
    return arrayOfInt;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    QLog.d("CmShowAESurfaceView", 2, "[initAEFilterManager]厘米秀渲染分辨率：" + paramInt1 + "|" + paramInt2);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = new AEFilterManager();
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("ai.face.enable", false);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("ai.hand.enable", false);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("ai.segmentation.bg.enable", false);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("ai.gender.enable", false);
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(AEResInfo.j);
    this.jdField_a_of_type_JavaUtilList.add(AEResInfo.k);
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setRenderer(this);
    setRenderMode(0);
    QLog.i("CmShowAESurfaceView", 1, "init complete.");
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
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      ApolloDtReportUtil.a("dressup_3d_page", "model", "rotate", null);
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEResInfo)localIterator.next();
      String str = AEResUtil.c((AEResInfo)localObject);
      localObject = ((AEResInfo)localObject).jdField_c_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (!StringUtil.a(str)))
      {
        QLog.d("CmShowAESurfaceView", 2, "[refreshBundlePath] bundlePath =" + str);
        QLog.d("CmShowAESurfaceView", 2, "[refreshBundlePath] agentType =" + (String)localObject);
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightBundle(str, (String)localObject);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Frame paramFrame)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, 0, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
  }
  
  public void a(HashMap<String, String> paramHashMap, String paramString, CameraController.CmShowCallback paramCmShowCallback)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_OrgLightCameraController$CmShowCallback = paramCmShowCallback;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      queueEvent(new CmShowAESurfaceView.5(this, paramHashMap, paramString, paramCmShowCallback));
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    AEQLog.d("CmShowAESurfaceView", "[cmshowFirstTime][cmShowSetKapuModel] AEFilterManager is null , pending to set kapuModel");
  }
  
  public void a(CameraController.CameraViewType paramCameraViewType)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      QLog.e("CmShowAESurfaceView", 2, "[cmshowFirstTime][cmShowSetKapuCameraViewType] type = " + paramCameraViewType);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.cmShowSetKapuCameraViewType(paramCameraViewType);
      return;
    }
    QLog.e("CmShowAESurfaceView", 2, "[cmshowFirstTime][cmShowSetKapuCameraViewType] mAeFilterManager is null, set viewType failed!");
  }
  
  public void b()
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
  
  public void c()
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
    int i = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), false, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    paramGL10 = this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(i, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.width, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.height);
    a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramGL10);
    paramGL10.unlock();
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaLangString != null))
    {
      QLog.e("CmShowAESurfaceView", 2, "[cmshowFirstTime][cmShowSetKapuModel][pendingSetKapuModel]");
      a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgLightCameraController$CmShowCallback);
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public void onPause()
  {
    queueEvent(new CmShowAESurfaceView.6(this));
    super.onPause();
  }
  
  @RequiresApi(api=16)
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    QLog.i("CmShowAESurfaceView", 1, "onSurfaceChanged ,(" + paramInt1 + "," + paramInt2 + ")");
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    e();
    b();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    QLog.i("CmShowAESurfaceView", 1, "onSurfaceCreated.");
    if (!this.jdField_b_of_type_Boolean) {
      if ((!AEKitForQQ.a()) || (!FeatureManager.loadBasicFeatures())) {
        break label106;
      }
    }
    label106:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      paramGL10 = a(getMeasuredWidth(), getMeasuredHeight());
      this.jdField_a_of_type_Int = paramGL10[0];
      this.jdField_b_of_type_Int = paramGL10[1];
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      a();
      a(this.jdField_b_of_type_JavaLangString);
      return;
    }
    QLog.e("CmShowAESurfaceView", 2, "[onSurfaceCreated]初始化AEKit失败！");
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
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (FeatureManager.loadBasicFeatures()))
    {
      a(paramString);
      return;
    }
    QLog.e("CmShowAESurfaceView", 2, "[cmshowFirstTime][updateCmshowMaterial]mAeFilterManager is null, pending set material");
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setTouchRotate(float[] paramArrayOfFloat)
  {
    queueEvent(new CmShowAESurfaceView.9(this, paramArrayOfFloat));
  }
  
  public void setTouchScale(float paramFloat)
  {
    queueEvent(new CmShowAESurfaceView.8(this, paramFloat));
  }
  
  public void setTouchableRect(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    c();
    super.surfaceDestroyed(paramSurfaceHolder);
    QLog.i("CmShowAESurfaceView", 1, "surfaceDestroyed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView
 * JD-Core Version:    0.7.0.1
 */