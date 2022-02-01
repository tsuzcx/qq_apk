package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class PathDesc
{
  private PathData a = new PathData();
  private PathDrawer b;
  private DoodleParam c = new DoodleParam();
  
  public PathDesc(DoodleParam paramDoodleParam, int paramInt1, List<PathData.PointData> paramList, int paramInt2)
  {
    if (paramDoodleParam == null) {
      return;
    }
    this.c.a(paramDoodleParam);
    this.a.b(paramInt1);
    this.a.a(paramInt2);
    this.a.a(paramList);
  }
  
  public PathDesc(PathDesc paramPathDesc)
  {
    this.a.a(paramPathDesc.e());
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    PathDrawer localPathDrawer = this.b;
    if (localPathDrawer != null) {
      localPathDrawer.a(paramFloat1, paramFloat2, this.c.b(), 0L);
    }
    this.a.f();
    this.a.a(paramFloat1, paramFloat2, this.c.b(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.c.b();
    Object localObject = this.a.h();
    if (localObject != null)
    {
      long l = paramLong - ((PathData.PointData)localObject).d();
      if (l <= 0L) {
        f = ((PathData.PointData)localObject).c();
      } else {
        f = this.c.a(l, ((PathData.PointData)localObject).a(), ((PathData.PointData)localObject).b(), paramFloat1, paramFloat2);
      }
    }
    else
    {
      this.b = null;
    }
    localObject = this.b;
    if (localObject != null) {
      ((PathDrawer)localObject).b(paramFloat1, paramFloat2, f, paramLong);
    }
    this.a.a(paramFloat1, paramFloat2, f, paramLong);
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.b != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.b.a(0, 0, i, j);
      }
      this.b.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    PathDrawer localPathDrawer = this.b;
    if (localPathDrawer != null) {
      localPathDrawer.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.a == null) {
      return false;
    }
    d();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    PathDrawer localPathDrawer = this.b;
    if (localPathDrawer != null) {
      return localPathDrawer.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public void b()
  {
    PathDrawer localPathDrawer = this.b;
    if (localPathDrawer != null) {
      localPathDrawer.b(-1);
    }
  }
  
  public int c()
  {
    PathDrawer localPathDrawer = this.b;
    if (localPathDrawer == null) {
      return 0;
    }
    return localPathDrawer.c();
  }
  
  public PathDrawer d()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((PathDrawer)localObject).b();
      this.b.a(this.a.c());
      this.b.b(this.a.b());
    }
    else
    {
      localObject = this.c.a();
      this.b = new PathDrawer(this.a, ((Rect)localObject).width(), ((Rect)localObject).height(), -1, -1, 10, 15, 1.0F);
    }
    return this.b;
  }
  
  public PathData e()
  {
    return this.a;
  }
  
  public int f()
  {
    PathData localPathData = this.a;
    if (localPathData == null) {
      return 0;
    }
    return localPathData.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathDesc
 * JD-Core Version:    0.7.0.1
 */