package com.tencent.luggage.wxa.ml;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.ma.e.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public abstract class c
  extends b
{
  protected boolean C;
  protected String D;
  protected int E;
  protected int F = 0;
  private boolean G = false;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public void B()
  {
    if (c())
    {
      o.d("MicroMsg.Video.BaseVideoView", "%s it is live video, do not completion", new Object[] { v() });
      e();
      d();
      return;
    }
    super.B();
    if (this.G) {
      a(0.0D, true);
    }
  }
  
  protected d a(Context paramContext)
  {
    return b(paramContext);
  }
  
  public void a()
  {
    if (this.k != null)
    {
      o.d("MicroMsg.Video.BaseVideoView", "%s preloadVideo url:%s, path:%s", new Object[] { v(), this.D, this.k.getVideoPath() });
      if (af.c(this.k.getVideoPath()))
      {
        this.k.setVideoPath(this.D);
        this.s = false;
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.C = paramBoolean;
    this.D = paramString;
    this.E = paramInt;
  }
  
  public boolean a(double paramDouble, boolean paramBoolean)
  {
    if (c())
    {
      o.c("MicroMsg.Video.BaseVideoView", "%s it is live, don't seek ", new Object[] { v() });
      return false;
    }
    return super.a(paramDouble, paramBoolean);
  }
  
  public boolean a(float paramFloat)
  {
    o.d("MicroMsg.Video.BaseVideoView", "%s set play rate [%f]", new Object[] { v(), Float.valueOf(paramFloat) });
    if ((this.k instanceof a)) {
      return ((a)this.k).a(paramFloat);
    }
    return false;
  }
  
  protected abstract d b(Context paramContext);
  
  public boolean c()
  {
    boolean bool = y();
    int i;
    if (this.k != null) {
      i = this.k.getDuration();
    } else {
      i = 0;
    }
    if (this.C) {
      return true;
    }
    return (bool) && (i <= 0);
  }
  
  public void d()
  {
    if (this.k != null)
    {
      o.d("MicroMsg.Video.BaseVideoView", "%s start path [%s] [%s]", new Object[] { v(), this.k.getVideoPath(), af.c() });
      if (af.c(this.k.getVideoPath()))
      {
        this.k.setVideoPath(this.D);
        this.s = true;
        r();
        return;
      }
      this.s = true;
      x();
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.Video.BaseVideoView", "%s onInfo [%d %d]", new Object[] { v(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      r();
      return;
    }
    if (paramInt1 == 702) {
      s();
    }
  }
  
  public void g()
  {
    boolean bool1 = this.b;
    super.g();
    if ((this.k != null) && ((this.k instanceof a)))
    {
      if (this.o)
      {
        x();
        return;
      }
      boolean bool2 = isShown();
      o.d("MicroMsg.Video.BaseVideoView", "onUIResume, oldIsUIAvailable: %b, isShown: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        ((a)this.k).c();
      }
    }
  }
  
  public int getCacheTimeSec()
  {
    try
    {
      if ((this.k instanceof a))
      {
        int i = ((a)this.k).getDownloadPercent();
        int j = super.getVideoDurationSec();
        return (int)(j * (i * 1.0F / 100.0F));
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Video.BaseVideoView", localException, "%s get cache time sec error", new Object[] { v() });
    }
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    int j = this.E;
    int i = j;
    if (j <= 0) {
      i = super.getVideoDurationSec();
    }
    return i;
  }
  
  public int getVideoSource()
  {
    return this.F;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void h()
  {
    super.h();
  }
  
  public void s()
  {
    super.s();
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public void setScaleType(e.h paramh)
  {
    if ((this.k instanceof a)) {
      ((a)this.k).setScaleType(paramh);
    }
  }
  
  public void setVideoSource(int paramInt)
  {
    this.F = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.c
 * JD-Core Version:    0.7.0.1
 */