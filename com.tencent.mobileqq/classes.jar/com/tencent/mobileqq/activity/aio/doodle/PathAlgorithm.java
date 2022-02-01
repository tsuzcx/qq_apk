package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Path;
import android.graphics.PathMeasure;
import java.util.ArrayList;
import java.util.List;

public abstract class PathAlgorithm
{
  private int a = 10;
  private int b = 25;
  private float c = 1.0F;
  
  private float a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 1) {
      return (paramFloat1 + paramFloat2) / 2.0F;
    }
    return (paramFloat2 - paramFloat1) * (paramInt2 + 1) / paramInt1 + paramFloat1;
  }
  
  private long a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 1) {
      return (paramLong1 + paramLong2) / 2L;
    }
    return (paramLong2 - paramLong1) * (paramInt2 + 1) / paramInt1 + paramLong1;
  }
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<PathDrawer.PathSegment> paramList);
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramFloat;
    if (this.a <= 0) {
      this.a = 10;
    }
    if (this.b <= 0) {
      this.b = 25;
    }
    if (this.c <= 0.0F) {
      this.c = 1.0F;
    }
  }
  
  public abstract void a(Path paramPath, List<PathDrawer.PathSegment> paramList);
  
  public void a(List<PathDrawer.PathSegment> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (paramList.size() <= i) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject = (PathDrawer.PathSegment)paramList.get(i);
      for (;;)
      {
        i += 1;
        if (i >= paramList.size()) {
          break;
        }
        PathDrawer.PathSegment localPathSegment = (PathDrawer.PathSegment)paramList.get(i);
        if ((localPathSegment.d() - ((PathDrawer.PathSegment)localObject).d() < this.b) && (Math.abs(localPathSegment.b() - ((PathDrawer.PathSegment)localObject).b()) < this.c))
        {
          ((PathDrawer.PathSegment)localObject).a(localPathSegment);
        }
        else
        {
          localArrayList.add(localObject);
          if (((PathDrawer.PathSegment)localObject).d() != localPathSegment.d()) {
            localPathSegment.a(0);
          } else {
            localPathSegment.a(((PathDrawer.PathSegment)localObject).e() + 1);
          }
          localObject = localPathSegment;
        }
      }
      localArrayList.add(localObject);
      paramList.clear();
      paramList.addAll(localArrayList);
    }
  }
  
  public abstract void a(List<PathData.PointData> paramList, Path paramPath, List<PathDrawer.PathSegment> paramList1);
  
  public abstract void a(List<PathData.PointData> paramList, Path paramPath, List<PathDrawer.PathSegment> paramList1, int paramInt);
  
  protected boolean a(List<PathDrawer.PathSegment> paramList, Path paramPath)
  {
    int i = 0;
    if ((paramList != null) && (paramPath != null))
    {
      if (paramList.size() == 0) {
        return false;
      }
      PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
      float f3 = localPathMeasure.getLength();
      float f1;
      for (float f2 = 0.0F; i < paramList.size(); f2 = f1)
      {
        Path localPath = new Path();
        float f4 = ((PathDrawer.PathSegment)paramList.get(i)).c() + f2;
        f1 = f4;
        if (f4 > f3) {
          f1 = f3;
        }
        localPathMeasure.getSegment(f2, f1, localPath, true);
        localPath.rLineTo(0.0F, 0.0F);
        paramPath.addPath(localPath);
        ((PathDrawer.PathSegment)paramList.get(i)).a(localPath);
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  protected boolean a(List<PathDrawer.PathSegment> paramList, Path paramPath, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    if (paramList == null) {
      return false;
    }
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f2 = localPathMeasure.getLength();
    int k = (int)Math.ceil(f2 / this.a);
    if (k == 0) {
      return false;
    }
    paramPath = null;
    int j;
    for (int i = 0; i < k; i = j)
    {
      Object localObject = new Path();
      j = i + 1;
      float f1 = this.a * j;
      if (f1 > f2) {
        f1 = f2;
      }
      localPathMeasure.getSegment(this.a * i, f1, (Path)localObject, true);
      ((Path)localObject).rLineTo(0.0F, 0.0F);
      localObject = new PathDrawer.PathSegment((Path)localObject);
      ((PathDrawer.PathSegment)localObject).a(a(paramFloat1, paramFloat2, k, i));
      ((PathDrawer.PathSegment)localObject).a(a(paramLong1, paramLong2, k, i));
      ((PathDrawer.PathSegment)localObject).b(f1 - i * this.a);
      if ((paramPath != null) && (paramPath.d() == ((PathDrawer.PathSegment)localObject).d())) {
        ((PathDrawer.PathSegment)localObject).a(paramPath.e() + 1);
      } else {
        ((PathDrawer.PathSegment)localObject).a(0);
      }
      paramList.add(localObject);
      paramPath = (Path)localObject;
    }
    return true;
  }
  
  public abstract void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<PathDrawer.PathSegment> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathAlgorithm
 * JD-Core Version:    0.7.0.1
 */