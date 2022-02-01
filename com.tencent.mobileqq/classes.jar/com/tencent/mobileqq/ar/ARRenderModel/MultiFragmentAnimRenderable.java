package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.ar.model.UniformGLRenderManager;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class MultiFragmentAnimRenderable
  implements Handler.Callback, ARBaseRender, ARRenderMangerInnerCallback
{
  ARRenerArumentManager.DrawFrameParements a = null;
  private ARRenderMangerInnerCallback b;
  private MultiFragmentAnimARResourceInfo c;
  private ARBaseRender d;
  private ARBaseRender e;
  private ArVideoResourceInfo f;
  private int g = 0;
  private Handler h;
  private ReentrantLock i = new ReentrantLock();
  private boolean j = false;
  private boolean k = false;
  
  public MultiFragmentAnimRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, MultiFragmentAnimARResourceInfo paramMultiFragmentAnimARResourceInfo)
  {
    this.b = paramARRenderMangerInnerCallback;
    this.c = paramMultiFragmentAnimARResourceInfo;
    this.h = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private ARBaseRender a(ArVideoResourceInfo paramArVideoResourceInfo, int paramInt)
  {
    ARRenderResourceInfo localARRenderResourceInfo = b(paramArVideoResourceInfo);
    ARBaseRender localARBaseRender = ARRenderableConstructorFactoty.a(this, localARRenderResourceInfo, null);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("create new render here ");
    ((StringBuilder)localObject).append(localARBaseRender);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool2 = true;
    QLog.d("AREngine_MultiFragmentAnimRenderable", 1, (String)localObject);
    if (localARBaseRender != null)
    {
      if ((!TextUtils.isEmpty(paramArVideoResourceInfo.j)) && (FileUtils.fileExists(paramArVideoResourceInfo.j)))
      {
        int m = this.c.i.i.size();
        paramInt += 1;
        if (m > paramInt)
        {
          paramArVideoResourceInfo = (ArVideoResourceInfo)this.c.i.i.get(paramInt);
          if ((paramArVideoResourceInfo.h == 4) && (!TextUtils.isEmpty(paramArVideoResourceInfo.j)) && (!FileUtils.fileExists(paramArVideoResourceInfo.j)))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("preload next online video, ");
              ((StringBuilder)localObject).append(paramArVideoResourceInfo.i);
              ((StringBuilder)localObject).append(", ");
              ((StringBuilder)localObject).append(paramArVideoResourceInfo.j);
              QLog.w("AREngine_MultiFragmentAnimRenderable", 2, ((StringBuilder)localObject).toString());
            }
            AROnlineVideoUtil.a(BaseApplicationImpl.getContext(), paramArVideoResourceInfo);
          }
        }
      }
      if (localARRenderResourceInfo.b == 5)
      {
        bool1 = bool2;
        if (localARRenderResourceInfo.c == 2L) {
          break label269;
        }
        if (localARRenderResourceInfo.c == 2048L)
        {
          bool1 = bool2;
          break label269;
        }
      }
      boolean bool1 = false;
      label269:
      this.b.c().a();
      this.b.c().a(bool1, localARRenderResourceInfo);
      if (localARRenderResourceInfo.b == 0)
      {
        paramArVideoResourceInfo = (GeneralARResourceInfo)localARRenderResourceInfo;
        this.b.c().a(localARRenderResourceInfo.d, localARRenderResourceInfo.b, paramArVideoResourceInfo.l);
        return localARBaseRender;
      }
      if ((localARRenderResourceInfo.b != 2) && (localARRenderResourceInfo.b != 3))
      {
        if (localARRenderResourceInfo.b == 4)
        {
          paramArVideoResourceInfo = (OnlineVideoARRenderableInfo)localARRenderResourceInfo;
          this.b.c().a(localARRenderResourceInfo.d, localARRenderResourceInfo.b, paramArVideoResourceInfo.o);
          return localARBaseRender;
        }
      }
      else
      {
        paramArVideoResourceInfo = (NormalVideoARResourceInfo)localARRenderResourceInfo;
        this.b.c().a(localARRenderResourceInfo.d, localARRenderResourceInfo.b, paramArVideoResourceInfo.m);
      }
    }
    return localARBaseRender;
  }
  
  private ARRenderResourceInfo b(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    ArCloudConfigInfo localArCloudConfigInfo = new ArCloudConfigInfo();
    localArCloudConfigInfo.e = paramArVideoResourceInfo.h;
    if ((QLog.isDebugVersion()) && (paramArVideoResourceInfo.h != 2) && (paramArVideoResourceInfo.h != 3) && (paramArVideoResourceInfo.h != 4))
    {
      ThreadManager.getUIHandler().post(new MultiFragmentAnimRenderable.1(this));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildARRenderResourceInfoForFragmentAnim animInfo.type=");
      ((StringBuilder)localObject).append(paramArVideoResourceInfo.h);
      QLog.i("AREngine_MultiFragmentAnimRenderable", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramArVideoResourceInfo);
    localArCloudConfigInfo.i = ((ArrayList)localObject);
    localObject = new ArFeatureInfo();
    ((ArFeatureInfo)localObject).a = paramArVideoResourceInfo.e;
    ((ArFeatureInfo)localObject).e = this.c.i.j.e;
    localArCloudConfigInfo.j = ((ArFeatureInfo)localObject);
    localArCloudConfigInfo.d = this.c.i.d;
    return QQARSession.a(localArCloudConfigInfo, true, this.c.c, this.c.e, this.c.f, this.c.g, this.c.h);
  }
  
  private void e()
  {
    if ((!this.c.i.i.isEmpty()) && (this.c.i.i.size() > this.g + 1))
    {
      ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)this.c.i.i.get(this.g + 1);
      ARBaseRender localARBaseRender = a(localArVideoResourceInfo, this.g + 1);
      if (localARBaseRender == null)
      {
        this.h.sendEmptyMessageDelayed(0, 100L);
        return;
      }
      this.e = this.d;
      this.d = localARBaseRender;
      this.f = localArVideoResourceInfo;
      this.g += 1;
      this.b.a(new MultiFragmentAnimRenderable.2(this, localARBaseRender));
    }
  }
  
  public Context a()
  {
    return this.b.a();
  }
  
  public Object a(int paramInt)
  {
    return this.b.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(ARBaseRender paramARBaseRender, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    ARBaseRender localARBaseRender = this.d;
    if (localARBaseRender != null)
    {
      if ((!localARBaseRender.p()) && (this.e != null) && (this.a != null))
      {
        this.i.lock();
        paramDrawFrameParements = this.e;
        if (paramDrawFrameParements != null) {
          paramDrawFrameParements.a(this.a);
        }
        this.i.unlock();
        return;
      }
      if (this.e != null) {
        this.b.a(new MultiFragmentAnimRenderable.3(this));
      }
      this.d.a(paramDrawFrameParements);
      this.a = paramDrawFrameParements;
    }
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    e();
    this.k = false;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback) {}
  
  public void a(Runnable paramRunnable)
  {
    this.b.a(paramRunnable);
  }
  
  public void a(String paramString) {}
  
  public void b()
  {
    this.b.b();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyAnimationPlayStatusChange state:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" remainTimes:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("AREngine_MultiFragmentAnimRenderable", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        if (paramInt1 != 2)
        {
          if (paramInt1 == 3) {}
        }
        else
        {
          localObject = this.f;
          if ((localObject != null) && ((((ArVideoResourceInfo)localObject).c()) || (this.c.i.i.size() == this.g + 1)))
          {
            if ((this.c.i.m != null) && (this.c.i.m.a) && (paramInt2 > 0)) {
              return;
            }
            if ((this.j) || (this.e != null)) {
              return;
            }
            this.j = true;
            this.b.b(paramInt1, 0);
            return;
          }
          localObject = this.f;
          if ((localObject != null) && (((ArVideoResourceInfo)localObject).b()))
          {
            if (this.k) {
              return;
            }
            this.k = true;
            this.b.a(this.f, this);
            return;
          }
          localObject = this.f;
          if ((localObject == null) || (!((ArVideoResourceInfo)localObject).a()) || (paramInt2 > 0)) {
            return;
          }
          e();
          return;
        }
      }
      this.h.sendEmptyMessage(0);
    }
    else if (this.g == 0)
    {
      this.b.b(paramInt1, paramInt2);
    }
  }
  
  public ARRenerArumentManager c()
  {
    return this.b.c();
  }
  
  public UniformGLRenderManager d()
  {
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      paramMessage = this.b;
      if (paramMessage != null) {
        paramMessage.a(new MultiFragmentAnimRenderable.5(this));
      }
    }
    return false;
  }
  
  public void i()
  {
    if (!this.c.i.i.isEmpty())
    {
      this.g = 0;
      localObject = (ArVideoResourceInfo)this.c.i.i.get(this.g);
      this.d = a((ArVideoResourceInfo)localObject, this.g);
      this.f = ((ArVideoResourceInfo)localObject);
    }
    Object localObject = this.d;
    if (localObject == null) {
      this.h.sendEmptyMessageDelayed(0, 100L);
    } else {
      ((ARBaseRender)localObject).i();
    }
    this.j = false;
  }
  
  public void j()
  {
    ARBaseRender localARBaseRender = this.d;
    if (localARBaseRender != null) {
      localARBaseRender.j();
    }
  }
  
  public void k()
  {
    ARBaseRender localARBaseRender = this.d;
    if (localARBaseRender != null) {
      localARBaseRender.k();
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy currentRenderable ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("  lastRenderable ");
      ((StringBuilder)localObject).append(this.e);
      QLog.w("AREngine_MultiFragmentAnimRenderable", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      ((ARBaseRender)localObject).l();
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((ARBaseRender)localObject).l();
      this.e = null;
    }
    this.a = null;
    localObject = this.h;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    this.j = false;
    this.k = false;
    AROnlineVideoUtil.a();
  }
  
  public int m()
  {
    ARBaseRender localARBaseRender = this.d;
    if (localARBaseRender != null)
    {
      if (!localARBaseRender.p())
      {
        localARBaseRender = this.e;
        if (localARBaseRender != null) {
          return localARBaseRender.m();
        }
      }
      return this.d.m();
    }
    return 5;
  }
  
  public String n()
  {
    return this.c.a;
  }
  
  public boolean o()
  {
    ARBaseRender localARBaseRender = this.d;
    if (localARBaseRender != null)
    {
      if (!localARBaseRender.p())
      {
        localARBaseRender = this.e;
        if (localARBaseRender != null) {
          return localARBaseRender.o();
        }
      }
      return this.d.o();
    }
    return false;
  }
  
  public boolean p()
  {
    ARBaseRender localARBaseRender = this.d;
    if (localARBaseRender != null)
    {
      if ((this.e != null) && (!localARBaseRender.p())) {
        return this.e.p();
      }
      return this.d.p();
    }
    return false;
  }
  
  public int q()
  {
    ARBaseRender localARBaseRender = this.d;
    if (localARBaseRender != null)
    {
      if ((this.e != null) && (!localARBaseRender.p())) {
        return this.e.q();
      }
      return this.d.q();
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable
 * JD-Core Version:    0.7.0.1
 */