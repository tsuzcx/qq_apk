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
  boolean a = false;
  private Context b;
  private volatile int c = 1;
  private Interactive3DResourceInfo d;
  private ARRenderMangerInnerCallback e;
  private GLSurfaceView f;
  private ARNativeBridge g;
  private int h;
  private volatile int i = 1;
  private int j;
  private int k;
  private ARMusicController l;
  private String[] m;
  private String n;
  private int o;
  private int p;
  private long q = 0L;
  
  public Interactive3DRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, Interactive3DResourceInfo paramInteractive3DResourceInfo, GLSurfaceView paramGLSurfaceView)
  {
    this.e = paramARRenderMangerInnerCallback;
    this.d = paramInteractive3DResourceInfo;
    this.f = paramGLSurfaceView;
    this.b = this.e.a();
    this.g = ((ARNativeBridge)this.e.a(0));
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNativeState, mCurState=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", new State=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AREngine_Interactive3DRenderable", 2, ((StringBuilder)localObject).toString());
    }
    this.c = paramInt;
    if (paramInt != 2) {}
    switch (paramInt)
    {
    default: 
    case 10: 
      this.g.nativeDestroyCertainEngine(this.h);
      this.g.setupActionCallback(null);
      this.h = 0;
      localObject = this.l;
      if (localObject != null)
      {
        ((ARMusicController)localObject).b();
        this.l.c();
      }
      this.c = 1;
      return;
    case 9: 
      this.e.a(new Interactive3DRenderable.1(this));
      return;
    case 8: 
      this.g.nativePause(this.h);
      return;
    case 7: 
      this.g.nativeResume(this.h);
      this.i = 0;
      a(11);
      return;
    case 6: 
      this.g.nativeonSurfaceChanged(this.h, this.j, this.k);
      return;
      ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
      this.h = this.g.getIndentification();
      localObject = this.g;
      long l1 = this.h;
      String str = this.d.j;
      Context localContext = this.b;
      ((ARNativeBridge)localObject).nativeCreateEngineBusiness(l1, str, localContext, localContext.getAssets(), this.d.k, this.j, this.k, 100);
      this.g.setupActionCallback(this);
      a(7);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    this.g.nativeOnDrawFrame(this.h, paramDrawFrameParements.a, (float[])paramDrawFrameParements.a("CAMERA_POSITION"));
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
    this.f.queueEvent(new Interactive3DRenderable.10(this, paramString));
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
    this.f.queueEvent(new Interactive3DRenderable.11(this, paramString));
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
    paramString1 = this.e;
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
        paramString1.a(this, this.d.i, paramInt1, 0, paramString2);
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
      if (System.currentTimeMillis() - this.q < 300L) {
        return;
      }
      this.q = System.currentTimeMillis();
      a("res/music/fudai_click.mp3");
      return;
    case 56: 
      a("res/music/fudai_appear.mp3");
      b("res/music/fudai_background.mp3");
      return;
      this.p += 1;
      this.o += paramInt2;
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "init");
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "start");
    }
    if (1 == this.c)
    {
      localObject = this.d.k;
      this.n = ((String)localObject);
      this.m = new String[8];
      String[] arrayOfString = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/loading.mp3");
      arrayOfString[0] = localStringBuilder.toString();
      arrayOfString = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/321ready.mp3");
      arrayOfString[1] = localStringBuilder.toString();
      arrayOfString = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/redpack_open.mp3");
      arrayOfString[2] = localStringBuilder.toString();
      arrayOfString = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/fudai_click.mp3");
      arrayOfString[3] = localStringBuilder.toString();
      arrayOfString = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/fudai_explode.mp3");
      arrayOfString[4] = localStringBuilder.toString();
      arrayOfString = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/fudai_appear.mp3");
      arrayOfString[5] = localStringBuilder.toString();
      arrayOfString = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/redpack_get.mp3");
      arrayOfString[6] = localStringBuilder.toString();
      arrayOfString = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("res/music/aimed.mp3");
      arrayOfString[7] = localStringBuilder.toString();
      this.l = new ARMusicController(1, this.m);
      a(2);
      this.p = 0;
      this.o = 0;
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((ARRenderMangerInnerCallback)localObject).a(this, this.d.i, 100, 0, null);
    }
  }
  
  public void k()
  {
    if (this.c == 11)
    {
      int i1 = this.i + 1;
      this.i = i1;
      if (i1 >= 2) {
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
      QLog.d("AREngine_Interactive3DRenderable", 2, ((StringBuilder)localObject).toString());
    }
    if (this.c == 9)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy, queueEvent, ");
        ((StringBuilder)localObject).append(this);
        QLog.d("AREngine_Interactive3DRenderable", 2, ((StringBuilder)localObject).toString());
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
        QLog.d("AREngine_Interactive3DRenderable", 2, ((StringBuilder)localObject).toString());
        this.e.a(this, this.d.i, 101, 0, null);
      }
      if (this.c == 9) {
        a(10);
      }
    }
    int i1 = this.p;
    if (i1 > 0)
    {
      float f1 = this.o * 1.0F / i1;
      localObject = new HashMap();
      ((HashMap)localObject).put("fps_total", String.valueOf(this.o));
      ((HashMap)localObject).put("fps_count", String.valueOf(this.p));
      ((HashMap)localObject).put("fps_avg", String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(f1) }));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(BaseActivity.sTopActivity.getCurrentAccountUin(), "binhai_fps", true, 0L, 0L, (HashMap)localObject, "", false);
    }
  }
  
  public int m()
  {
    return this.d.i.e;
  }
  
  public String n()
  {
    return this.d.a;
  }
  
  public boolean o()
  {
    return (this.c == 9) && (this.h != 0);
  }
  
  public boolean p()
  {
    return true;
  }
  
  public int q()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable
 * JD-Core Version:    0.7.0.1
 */