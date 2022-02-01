package com.tencent.luggage.wxa.f;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.view.View;
import com.tencent.luggage.wxa.g.a.b;
import com.tencent.luggage.wxa.g.b;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

abstract class i
{
  protected final i.a f;
  protected final o g;
  
  i(i.a parama, o paramo)
  {
    this.f = parama;
    this.g = paramo;
  }
  
  abstract float[] A();
  
  abstract boolean B();
  
  abstract void C();
  
  abstract Point D();
  
  View L()
  {
    return this.g.g();
  }
  
  int M()
  {
    return 300;
  }
  
  int N()
  {
    return 1000;
  }
  
  protected a O()
  {
    Object localObject1 = w();
    Object localObject2 = x();
    if ((((r)localObject1).a().contains(j.a)) && (((r)localObject2).a().contains(j.a))) {
      localObject1 = j.a;
    } else if ((((r)localObject1).a().contains(j.b)) && (((r)localObject2).a().contains(j.b))) {
      localObject1 = j.b;
    } else {
      localObject1 = (a)((r)localObject1).a().iterator().next();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("chooseAspectRatio, aspect ratio changed to ");
    ((StringBuilder)localObject2).append(((a)localObject1).toString());
    f.b("CameraViewImpl", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  protected a.b a(Context paramContext, List<q> paramList)
  {
    float f1 = t();
    int i = s();
    Point localPoint = b.a(paramContext);
    int j = b.b(paramContext);
    if ((j != 90) && (j != 270)) {
      localPoint = new Point(localPoint.x, localPoint.y);
    } else {
      localPoint = new Point(localPoint.y, localPoint.x);
    }
    if (f1 == 0.0F)
    {
      f.c("CameraViewImpl", "DisplayRatio is 0, skip getReasonableSize");
      return null;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      float f2 = 1.0F / f1;
      if (f1 >= 1.0F) {
        i = Math.round(i / f2);
      }
      j = u();
      boolean bool;
      if ((j != 90) && (j != 270)) {
        bool = false;
      } else {
        bool = true;
      }
      a.b localb2 = com.tencent.luggage.wxa.g.a.a(paramContext, paramList, localPoint, i, bool);
      a.b localb1;
      if (localb2 != null)
      {
        localb1 = localb2;
        if (localb2.a != null) {}
      }
      else
      {
        f.d("CameraViewImpl", "fuck, preview size still null!!");
        localb1 = com.tencent.luggage.wxa.g.a.b(paramContext, paramList, localPoint, i, bool);
      }
      if (localb1 != null)
      {
        if (localb1.a == null) {
          return null;
        }
        return localb1;
      }
      return null;
    }
    f.c("CameraViewImpl", "supportSizes is empty, skip getReasonableSize");
    return null;
  }
  
  abstract void a(float paramFloat);
  
  abstract void a(float paramFloat1, float paramFloat2);
  
  abstract void a(int paramInt);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture);
  
  abstract void a(q paramq);
  
  abstract void a(Float paramFloat);
  
  abstract void a(boolean paramBoolean);
  
  abstract boolean a();
  
  abstract boolean a(a parama);
  
  abstract boolean a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, CamcorderProfile paramCamcorderProfile, boolean paramBoolean2);
  
  abstract List<q> b(a parama);
  
  abstract void b();
  
  abstract void b(float paramFloat);
  
  abstract void b(int paramInt);
  
  abstract void b(boolean paramBoolean);
  
  abstract void c(float paramFloat);
  
  abstract void c(int paramInt);
  
  abstract void c(boolean paramBoolean);
  
  abstract void d(int paramInt);
  
  abstract boolean d();
  
  abstract int e();
  
  abstract void e(int paramInt);
  
  abstract int f();
  
  abstract Set<a> g();
  
  abstract q h();
  
  abstract a i();
  
  abstract boolean j();
  
  abstract int k();
  
  abstract float l();
  
  abstract float m();
  
  abstract int n();
  
  abstract boolean o();
  
  abstract void p();
  
  abstract void r();
  
  abstract int s();
  
  abstract float t();
  
  abstract int u();
  
  public abstract q v();
  
  public abstract r w();
  
  public abstract r x();
  
  abstract boolean y();
  
  abstract float z();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.i
 * JD-Core Version:    0.7.0.1
 */