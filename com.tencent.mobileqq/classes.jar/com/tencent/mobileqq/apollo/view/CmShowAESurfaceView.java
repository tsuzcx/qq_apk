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
import com.tencent.aelight.camera.api.IAEMaterialManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.FrameUtil;
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
  private Runnable A = new CmShowAESurfaceView.2(this);
  private ValueAnimator.AnimatorUpdateListener B = new CmShowAESurfaceView.3(this);
  private AnimatorListenerAdapter C = new CmShowAESurfaceView.4(this);
  HashMap<String, String> a;
  String b;
  CameraController.CmShowCallback c;
  boolean d = false;
  private AEFilterManager e;
  private int f;
  private int g;
  private int h;
  private int i;
  private float[] j = { 1.0F, 1.0F, 1.0F, 1.0F };
  private String k = null;
  private List<AEResInfo> l = new ArrayList();
  private SpaceFilter m = new SpaceFilter();
  private BaseFilter n = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame o = new Frame();
  private Frame p = new Frame();
  private ValueAnimator q;
  private int r = 33;
  private long s = 0L;
  private int t = 0;
  private PointF u = new PointF(0.0F, 0.0F);
  private Rect v;
  private volatile boolean w = false;
  private boolean x = false;
  private boolean y;
  private Runnable z = new CmShowAESurfaceView.1(this);
  
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
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[cmshowFirstTime][updateCmshowMaterial]:");
    localStringBuilder.append(paramVideoMaterial.getDataPath());
    QLog.d("[cmshow]CmShowAESurfaceView", 2, localStringBuilder.toString());
    if (((IAEMaterialManager)QRoute.api(IAEMaterialManager.class)).isSpecialTemplate(paramVideoMaterial))
    {
      QLog.d("PreCheckAERes", 2, "[setMaterial] set special template");
      if (((IAEResUtil)QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.LIGHT_RES_BASE_PACKAGE))
      {
        QLog.d("PreCheckAERes", 2, "[setMaterial] version check success");
        if (FeatureManager.ensureMaterialSoLoaded(paramVideoMaterial))
        {
          QLog.d("PreCheckAERes", 2, "[setMaterial] so load success");
          long l1 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).checkBundleStatus(paramVideoMaterial);
          if (l1 != 0L)
          {
            QLog.d("PreCheckAERes", 2, "[setMaterial] bundleStatus not ready, go fetch bundles ...");
            ((IAEResUtil)QRoute.api(IAEResUtil.class)).fetchBundles(getContext(), l1);
            return;
          }
          QLog.d("PreCheckAERes", 2, "[setMaterial] bundleStatus ready, apply material...");
        }
        else
        {
          QLog.e("PreCheckAERes", 2, "[setMaterial] so load failed");
        }
      }
      else
      {
        QLog.e("PreCheckAERes", 2, "[setMaterial] version check failed");
      }
      this.e.updateMaterialGL(paramVideoMaterial);
      this.y = true;
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
    if (this.v == null) {
      return true;
    }
    return (paramMotionEvent.getX() < this.v.right) && (paramMotionEvent.getX() > this.v.left) && (paramMotionEvent.getY() < this.v.bottom) && (paramMotionEvent.getY() > this.v.top);
  }
  
  private int[] a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    int i2 = paramInt1;
    int i1 = paramInt2;
    if (paramInt2 > 720)
    {
      i1 = (int)(720.0F / paramInt1 * paramInt2);
      i2 = 720;
    }
    arrayOfInt[0] = i2;
    arrayOfInt[1] = i1;
    return arrayOfInt;
  }
  
  private float b(MotionEvent paramMotionEvent)
  {
    double d1 = (paramMotionEvent.getX() - this.u.x) / this.f * 360.0F;
    Double.isNaN(d1);
    float f1 = (float)(d1 * 3.141592653589793D / 180.0D);
    this.u.x = paramMotionEvent.getX(0);
    this.u.y = paramMotionEvent.getY(0);
    return f1;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    SpaceFilter localSpaceFilter = this.m;
    float f1 = paramInt1;
    float f2 = paramInt2;
    localSpaceFilter.applyFilterChain(true, f1, f2);
    this.m.setRenderMode(2);
    this.n.applyFilterChain(true, f1, f2);
    this.n.setRenderMode(2);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[initAEFilterManager]厘米秀渲染分辨率：");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    QLog.d("[cmshow]CmShowAESurfaceView", 2, localStringBuilder.toString());
    this.e = new AEFilterManager();
    this.e.initInGL(paramInt1, paramInt2);
    this.e.switchAbilityInLightNode("ai.face.enable", false);
    this.e.switchAbilityInLightNode("ai.hand.enable", false);
    this.e.switchAbilityInLightNode("ai.segmentation.bg.enable", false);
    this.e.switchAbilityInLightNode("ai.gender.enable", false);
  }
  
  private void d()
  {
    this.l.clear();
    this.l.add(AEResInfo.LIGHT_RES_BUNDLE_ACE3D);
    this.l.add(AEResInfo.LIGHT_RES_BUNDLE_3DMM);
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setRenderer(this);
    setRenderMode(0);
    QLog.i("[cmshow]CmShowAESurfaceView", 1, "init complete.");
  }
  
  private void e()
  {
    this.q = ValueAnimator.ofInt(new int[] { 1, this.r });
    this.q.setDuration(this.r);
    this.q.setRepeatCount(-1);
    this.q.setInterpolator(new LinearInterpolator());
  }
  
  private void f()
  {
    if (this.x)
    {
      this.x = false;
      ApolloDtReportUtil.a("dressup_3d_page", "model", "rotate", null);
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEResInfo)localIterator.next();
      String str = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightBundleDir((AEResInfo)localObject);
      localObject = ((AEResInfo)localObject).agentType;
      if ((this.e != null) && (!StringUtil.isEmpty(str)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[refreshBundlePath] bundlePath =");
        localStringBuilder.append(str);
        QLog.d("[cmshow]CmShowAESurfaceView", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[refreshBundlePath] agentType =");
        localStringBuilder.append((String)localObject);
        QLog.d("[cmshow]CmShowAESurfaceView", 2, localStringBuilder.toString());
        this.e.setLightBundle(str, (String)localObject);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Frame paramFrame)
  {
    this.m.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, 0, 0.0D, this.o);
  }
  
  public void a(HashMap<String, String> paramHashMap, String paramString, CameraController.CmShowCallback paramCmShowCallback)
  {
    this.a = paramHashMap;
    this.b = paramString;
    this.c = paramCmShowCallback;
    if (this.e != null)
    {
      queueEvent(new CmShowAESurfaceView.5(this, paramHashMap, paramString, paramCmShowCallback));
      return;
    }
    this.d = true;
    QLog.e("[cmshow]CmShowAESurfaceView", 2, "[cmshowFirstTime][cmShowSetKapuModel] AEFilterManager is null , pending to set kapuModel");
  }
  
  public void a(CameraController.CameraViewType paramCameraViewType)
  {
    if (this.e != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cmshowFirstTime][cmShowSetKapuCameraViewType] type = ");
      localStringBuilder.append(paramCameraViewType);
      QLog.e("[cmshow]CmShowAESurfaceView", 2, localStringBuilder.toString());
      this.e.cmShowSetKapuCameraViewType(paramCameraViewType);
      return;
    }
    QLog.e("[cmshow]CmShowAESurfaceView", 2, "[cmshowFirstTime][cmShowSetKapuCameraViewType] mAeFilterManager is null, set viewType failed!");
  }
  
  public void b()
  {
    if (this.q == null) {
      e();
    }
    this.q.addUpdateListener(this.B);
    this.q.addListener(this.C);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      QLog.i("[cmshow]CmShowAESurfaceView", 1, "mAnimator.start().");
      this.q.start();
      return;
    }
    removeCallbacks(this.A);
    post(this.z);
  }
  
  public void c()
  {
    if (this.q == null) {
      return;
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      QLog.i("[cmshow]CmShowAESurfaceView", 1, "cancelAnimator().");
      this.q.cancel();
    }
    else
    {
      removeCallbacks(this.z);
      post(this.A);
    }
    this.q.removeUpdateListener(this.B);
    this.q.removeListener(this.C);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    paramGL10 = this.p;
    float[] arrayOfFloat = this.j;
    FrameUtil.clearFrame(paramGL10, arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], this.f, this.g);
    PTFaceAttr.EmptyFaceAttr.setTimeStamp(System.currentTimeMillis());
    int i1 = this.e.drawFrame(this.p.getTextureId(), false, this.s);
    this.n.setRotationAndFlip(0, 0, 1);
    paramGL10 = this.n.RenderProcess(i1, this.p.width, this.p.height);
    a(this.h, this.i, paramGL10);
    paramGL10.unlock();
    if ((this.y) && (this.a != null) && (this.b != null))
    {
      QLog.e("[cmshow]CmShowAESurfaceView", 2, "[cmshowFirstTime][cmShowSetKapuModel][pendingSetKapuModel]");
      a(this.a, this.b, this.c);
      this.y = false;
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
    paramGL10 = new StringBuilder();
    paramGL10.append("onSurfaceChanged ,(");
    paramGL10.append(paramInt1);
    paramGL10.append(",");
    paramGL10.append(paramInt2);
    paramGL10.append(")");
    QLog.i("[cmshow]CmShowAESurfaceView", 1, paramGL10.toString());
    this.h = paramInt1;
    this.i = paramInt2;
    e();
    b();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    QLog.i("[cmshow]CmShowAESurfaceView", 1, "onSurfaceCreated.");
    if (!this.w)
    {
      boolean bool;
      if ((((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init()) && (FeatureManager.loadBasicFeatures())) {
        bool = true;
      } else {
        bool = false;
      }
      this.w = bool;
    }
    paramGL10 = a(getMeasuredWidth(), getMeasuredHeight());
    this.f = paramGL10[0];
    this.g = paramGL10[1];
    if (this.w)
    {
      b(this.f, this.g);
      c(this.f, this.g);
      a();
      a(this.k);
      return;
    }
    QLog.e("[cmshow]CmShowAESurfaceView", 2, "[onSurfaceCreated]初始化AEKit失败！");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a(paramMotionEvent)) {
      return false;
    }
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 5)
          {
            if (i1 != 6) {
              return true;
            }
          }
          else
          {
            this.t = 2;
            return true;
          }
        }
        else
        {
          if (this.t != 1) {
            break label122;
          }
          setTouchRotate(new float[] { 0.0F, b(paramMotionEvent), 0.0F });
          return true;
        }
      }
      this.t = 0;
      f();
      return true;
    }
    else
    {
      this.t = 1;
      this.u.x = paramMotionEvent.getX(0);
      this.u.y = paramMotionEvent.getY(0);
    }
    label122:
    return true;
  }
  
  public void setBackgroundColor(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.j = new float[] { paramFloat1, paramFloat2, paramFloat3, 1.0F };
  }
  
  public void setFrameInterval(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setMaterialPath(String paramString)
  {
    if ((this.e != null) && (FeatureManager.loadBasicFeatures()))
    {
      a(paramString);
      return;
    }
    QLog.e("[cmshow]CmShowAESurfaceView", 2, "[cmshowFirstTime][updateCmshowMaterial]mAeFilterManager is null, pending set material");
    this.k = paramString;
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
    this.v = paramRect;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    c();
    super.surfaceDestroyed(paramSurfaceHolder);
    QLog.i("[cmshow]CmShowAESurfaceView", 1, "surfaceDestroyed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView
 * JD-Core Version:    0.7.0.1
 */