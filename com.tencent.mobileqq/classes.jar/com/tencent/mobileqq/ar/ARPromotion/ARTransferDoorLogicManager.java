package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.PointF;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircle;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircleResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARGestureResult;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ARTransferDoorLogicManager
  implements ARPhonePoseDetectManager.PhonePoseDetectListener
{
  public static final String a = "ARTransferDoorLogicManager";
  private int A = 0;
  private int B = 15;
  private ARLocalGestureCircleRecogResult C = new ARLocalGestureCircleRecogResult();
  public final int b = 1;
  public final int c = 2;
  public final int d = 3;
  public final int e = 4;
  public final int f = 5;
  public final int g = 6;
  public int h = 1;
  public ARScanEntryView i;
  public WeakReference<QQARSession> j;
  volatile ARTransferDoorVideoInfo.PlayGuideShowInfo k = null;
  MqqHandler l;
  private ARTransferDoorLogicManager.RenderProxy m;
  private AppInterface n;
  private RelativeLayout o;
  private ARTransferPromotionUIContainer p;
  private ARPhonePoseDetectManager q;
  private volatile int r = -1;
  private boolean s = false;
  private String t = "";
  private String u;
  private boolean v = true;
  private String w = "";
  private ArCloudConfigInfo x = null;
  private long y = 0L;
  private boolean z = true;
  
  public void a(int paramInt)
  {
    this.h = paramInt;
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGamePlayMode mode ");
    localStringBuilder.append(paramInt);
    QLog.d(str, 2, localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i(a, 1, "setRecogRes");
    ARTransferDoorLogicManager.RenderProxy localRenderProxy = this.m;
    if (localRenderProxy != null)
    {
      localRenderProxy.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    QLog.i(a, 1, "setRecogRes failed.");
  }
  
  public void a(AppInterface paramAppInterface, ScanTorchActivity paramScanTorchActivity, RelativeLayout paramRelativeLayout)
  {
    this.n = paramAppInterface;
    this.o = paramRelativeLayout;
    this.l = ThreadManager.getUIHandler();
    this.q = new ARPhonePoseDetectManager(paramScanTorchActivity);
    this.q.a(this);
    if ((this.m != null) && (paramRelativeLayout != null))
    {
      paramAppInterface = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init ");
      localStringBuilder.append(paramRelativeLayout.getChildCount());
      QLog.d(paramAppInterface, 2, localStringBuilder.toString());
      this.m.a(this.o);
    }
    else
    {
      paramAppInterface = a;
      paramRelativeLayout = new StringBuilder();
      paramRelativeLayout.append("init ");
      boolean bool;
      if (this.m != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramRelativeLayout.append(bool);
      QLog.d(paramAppInterface, 2, paramRelativeLayout.toString());
    }
    this.p = new ARTransferPromotionUIContainer(paramScanTorchActivity);
  }
  
  public void a(ARTransferDoorLogicManager.RenderProxy paramRenderProxy)
  {
    if (paramRenderProxy != null)
    {
      this.m = paramRenderProxy;
      paramRenderProxy = this.o;
      if (paramRenderProxy != null) {
        this.m.a(paramRenderProxy);
      }
      this.u = this.m.e();
      int i1;
      if (this.m.c()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      this.h = i1;
      this.w = this.m.d();
    }
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRenderTransferGame config ");
    localStringBuilder.append(paramArCloudConfigInfo);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    if (this.x == null) {
      this.x = paramArCloudConfigInfo;
    }
    localObject = paramArCloudConfigInfo;
    if (paramArCloudConfigInfo == null)
    {
      localObject = paramArCloudConfigInfo;
      if (this.x != null)
      {
        localObject = paramArCloudConfigInfo;
        if (a()) {
          localObject = this.x;
        }
      }
    }
    paramArCloudConfigInfo = this.j;
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.get() != null)) {
      ((QQARSession)this.j.get()).a(4096L, (ArCloudConfigInfo)localObject);
    }
  }
  
  public void a(ARLocalGestureCircleRecogResult paramARLocalGestureCircleRecogResult, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d(a, 2, "processInternalGestureRecogResult");
    if (!f()) {
      QLog.d(a, 2, "processInternalGestureRecogResult into Error status");
    }
    this.C = paramARLocalGestureCircleRecogResult;
    int i1;
    if (this.y > 0L) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    int i2;
    int i3;
    if ((this.C.c.f == 0) && (this.C.c.e > 0))
    {
      h();
      if (i1 != 0)
      {
        c(4);
        QLog.d(a, 2, "processInternalGestureRecogResult start draw circle");
      }
      paramARLocalGestureCircleRecogResult = ARLocalGestureCircleRecog.a(paramInt1, paramInt2, paramInt3, paramInt4, new PointF(this.C.c.c.b, this.C.c.c.c));
      i2 = (int)(this.C.c.c.a / paramInt2 * paramInt3);
      i3 = (int)paramARLocalGestureCircleRecogResult.x;
      int i4 = (int)paramARLocalGestureCircleRecogResult.y;
      if (this.C.c.c.d) {
        i1 = 1;
      } else {
        i1 = -1;
      }
      a(i2, i3, i4, i1);
      b(1);
      ARVideoRecordUIControllerImpl.a().a(6);
      this.C.c.k = 0;
    }
    if (this.C.c.e > this.C.c.f)
    {
      boolean bool;
      if (this.C.b.g == 1)
      {
        if (this.C.c.f == 0)
        {
          i1 = 1;
          i3 = 0;
          bool = true;
          i2 = i1;
          i1 = i3;
        }
        else
        {
          i1 = this.C.c.f;
          i2 = 1;
        }
      }
      else {
        for (;;)
        {
          bool = false;
          break label392;
          if (this.C.c.e >= 1) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (this.C.c.f < 1) {
            break;
          }
          i3 = this.C.c.f;
          i2 = i1;
          i1 = i3;
        }
      }
      label392:
      if (i2 != 0)
      {
        Object localObject2;
        if (this.C.b.g == 1)
        {
          paramARLocalGestureCircleRecogResult = new int[this.C.c.e - i1];
          localObject1 = new int[this.C.c.e - i1];
          localObject2 = new int[this.C.c.e - i1];
          paramInt2 = i1;
          while (paramInt2 < this.C.c.e)
          {
            PointF localPointF = ARLocalGestureCircleRecog.a(paramInt1, paramInt1, paramInt3, paramInt4, this.C.c.d[paramInt2]);
            i2 = paramInt2 - i1;
            paramARLocalGestureCircleRecogResult[i2] = ((int)localPointF.x);
            localObject1[i2] = ((int)localPointF.y);
            localObject2[i2] = this.C.c.h[paramInt2];
            paramInt2 += 1;
          }
          a(paramARLocalGestureCircleRecogResult, (int[])localObject1, (int[])localObject2, bool);
        }
        else
        {
          this.A = 0;
          if (this.z)
          {
            this.z = false;
            paramARLocalGestureCircleRecogResult = new ARTransferDoorLogicManager.1(this, paramInt1, paramInt2, paramInt3, paramInt4);
            localObject1 = a;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("DrawCircle. resume. mDrawCirclePuase = ");
            ((StringBuilder)localObject2).append(this.z);
            ((StringBuilder)localObject2).append(", genIdx = ");
            ((StringBuilder)localObject2).append(this.C.c.k);
            QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            localObject1 = this.j;
            if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (!this.z)) {
              ((QQARSession)this.j.get()).b(paramARLocalGestureCircleRecogResult, this.B);
            }
          }
        }
      }
    }
    if ((this.C.c.a == -1) && (this.C.c.b != -1) && (this.C.c.e > 0))
    {
      this.z = true;
      e();
      c(3);
      this.y = System.currentTimeMillis();
      paramARLocalGestureCircleRecogResult = this.j;
      if ((paramARLocalGestureCircleRecogResult != null) && (paramARLocalGestureCircleRecogResult.get() != null)) {
        ((QQARSession)this.j.get()).b(new ARTransferDoorLogicManager.2(this), 1000L);
      }
    }
    paramARLocalGestureCircleRecogResult = a;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("zoomOutWorldCupSparks curent state ");
    ((StringBuilder)localObject1).append(this.C.c.a);
    QLog.i(paramARLocalGestureCircleRecogResult, 1, ((StringBuilder)localObject1).toString());
    if ((this.C.c.a == 0) && (this.C.c.b != 0))
    {
      c(5);
      b(2);
      ThreadManager.getSubThreadHandler().post(new ARTransferDoorLogicManager.3(this));
      paramARLocalGestureCircleRecogResult = this.j;
      if ((paramARLocalGestureCircleRecogResult != null) && (paramARLocalGestureCircleRecogResult.get() != null)) {
        ((QQARSession)this.j.get()).b(new ARTransferDoorLogicManager.4(this), 1500L);
      }
    }
  }
  
  public void a(QQARSession paramQQARSession)
  {
    this.j = new WeakReference(paramQQARSession);
  }
  
  public void a(boolean paramBoolean)
  {
    f();
    if (paramBoolean)
    {
      localObject = this.m;
      if ((localObject != null) && (this.h == 1))
      {
        if (((ARTransferDoorLogicManager.RenderProxy)localObject).b())
        {
          c(6);
          this.m.f();
          this.r = -1;
        }
        else
        {
          this.r = 0;
        }
      }
      else if ((this.m != null) && (this.h == 2))
      {
        c(2);
        this.r = 0;
      }
      else if (this.m == null)
      {
        c(2);
        this.r = 0;
      }
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPhonePoseChaned standBy SUCCESS with mode: ");
      localStringBuilder.append(this.h);
      localStringBuilder.append("-mCurrentPoseStatus:");
      localStringBuilder.append(this.r);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      return;
    }
    Object localObject = this.m;
    if ((localObject != null) && (((ARTransferDoorLogicManager.RenderProxy)localObject).b()) && (this.h == 1)) {
      c(1);
    } else if (this.h == 2) {
      c(1);
    }
    this.r = 1;
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPhonePoseChaned standBy FAIL with mode: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("-mCurrentPoseStatus:");
    localStringBuilder.append(this.r);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateUITipsMessage ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(";");
    localStringBuilder.append(paramString);
    QLog.d(str, 2, localStringBuilder.toString());
    if ((this.s == paramBoolean) && (this.t.equalsIgnoreCase(paramString))) {
      return;
    }
    this.s = paramBoolean;
    this.t = paramString;
    if (this.s)
    {
      this.l.post(new ARTransferDoorLogicManager.6(this, paramString));
      return;
    }
    this.l.post(new ARTransferDoorLogicManager.7(this));
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, boolean paramBoolean)
  {
    QLog.i(a, 1, "insertWorldCupSpark start.");
    ARTransferDoorLogicManager.RenderProxy localRenderProxy = this.m;
    if ((localRenderProxy != null) && (localRenderProxy.a()))
    {
      this.m.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramBoolean);
      return;
    }
    QLog.i(a, 1, "insertWorldCupSpark failed.");
  }
  
  public boolean a()
  {
    return this.h == 2;
  }
  
  public void b()
  {
    ARTransferPromotionUIContainer localARTransferPromotionUIContainer = this.p;
    if (localARTransferPromotionUIContainer != null) {
      localARTransferPromotionUIContainer.b(this.o);
    }
    this.m = null;
    h();
    this.r = -1;
  }
  
  public void b(int paramInt)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchGameStatus ");
    localStringBuilder.append(paramInt);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    localObject = this.m;
    if (localObject != null)
    {
      ((ARTransferDoorLogicManager.RenderProxy)localObject).a(paramInt);
      return;
    }
    localObject = a;
    boolean bool = true;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchGameStatus ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(this.m);
    if (localStringBuilder.toString() == null) {
      bool = false;
    }
    QLog.d((String)localObject, 2, new Object[] { Boolean.valueOf(bool) });
  }
  
  public void b(boolean paramBoolean)
  {
    MqqHandler localMqqHandler = this.l;
    if (localMqqHandler != null) {
      localMqqHandler.post(new ARTransferDoorLogicManager.5(this, paramBoolean));
    }
  }
  
  public void c()
  {
    QLog.d(a, 2, "doOnResume");
    if (this.h == 1) {}
  }
  
  public void c(int paramInt)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnARTransferStatusChanged status changeTo ");
    localStringBuilder.append(paramInt);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    if (this.l != null)
    {
      localObject = this.i;
      if (localObject != null)
      {
        if ((localObject != null) && (!((ARScanEntryView)localObject).j())) {
          return;
        }
        switch (paramInt)
        {
        default: 
          return;
        case 6: 
          this.l.post(new ARTransferDoorLogicManager.13(this));
          return;
        case 5: 
          this.l.post(new ARTransferDoorLogicManager.12(this));
          return;
        case 4: 
          this.l.post(new ARTransferDoorLogicManager.11(this));
          return;
        case 3: 
          this.l.post(new ARTransferDoorLogicManager.10(this));
          return;
        case 2: 
          this.l.post(new ARTransferDoorLogicManager.9(this));
          return;
        }
        this.l.post(new ARTransferDoorLogicManager.8(this));
      }
    }
  }
  
  public void d()
  {
    QLog.d(a, 2, "notifyEnterIntoTransferDoorStatus");
    WeakReference localWeakReference = this.j;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((QQARSession)this.j.get()).d(1);
    }
  }
  
  public void e()
  {
    this.y = 0L;
    this.z = true;
    this.A = 0;
    this.B = 15;
  }
  
  public boolean f()
  {
    ARTransferDoorLogicManager.RenderProxy localRenderProxy = this.m;
    boolean bool = true;
    if (localRenderProxy == null) {
      return true;
    }
    int i1 = j();
    if (i1 != 0)
    {
      if (i1 == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void g()
  {
    QLog.d(a, 2, "startPhonePoseDetect");
    this.q.a();
    this.r = -1;
  }
  
  public void h()
  {
    QLog.d(a, 2, "stopPhonePoseDetect");
    this.q.b();
  }
  
  public int i()
  {
    return this.r;
  }
  
  public int j()
  {
    ARTransferDoorLogicManager.RenderProxy localRenderProxy = this.m;
    if (localRenderProxy != null) {
      return localRenderProxy.g();
    }
    return 0;
  }
  
  public void k()
  {
    QLog.d(a, 2, "doOnPause");
    if (this.m == null)
    {
      QLog.d(a, 2, "doOnPause but do nothing here");
      return;
    }
    ARTransferPromotionUIContainer localARTransferPromotionUIContainer = this.p;
    if (localARTransferPromotionUIContainer != null) {
      localARTransferPromotionUIContainer.b(this.o);
    }
    this.o.setVisibility(8);
    c(6);
    h();
    this.r = -1;
  }
  
  public void l()
  {
    QLog.d(a, 2, "ARWorldGC ARWorldCupGameLogicManager uninit");
    this.m = null;
    Object localObject = this.o;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).setOnTouchListener(null);
      this.o = null;
    }
    this.i = null;
    this.n = null;
    this.k = null;
    localObject = this.l;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    this.p = null;
    localObject = this.q;
    if (localObject != null)
    {
      ((ARPhonePoseDetectManager)localObject).b();
      this.q = null;
    }
    this.r = -1;
    this.x = null;
  }
  
  public void m()
  {
    QLog.i(a, 1, "zoomOutWorldCupSparks .");
    ARTransferDoorLogicManager.RenderProxy localRenderProxy = this.m;
    if (localRenderProxy != null)
    {
      localRenderProxy.h();
      return;
    }
    QLog.i(a, 1, "zoomOutWorldCupSparks failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager
 * JD-Core Version:    0.7.0.1
 */