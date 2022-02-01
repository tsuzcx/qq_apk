package com.tencent.mobileqq.activity.aio.doodle;

import java.util.ArrayList;
import java.util.List;

public class PathData
{
  public int a = -1;
  private ArrayList<PathData.PointData> b = new ArrayList();
  private int c;
  private int d = -1;
  
  public long a()
  {
    if (this.b.size() > 0)
    {
      ArrayList localArrayList = this.b;
      return ((PathData.PointData)localArrayList.get(localArrayList.size() - 1)).d();
    }
    return 0L;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    PathData.PointData localPointData = new PathData.PointData();
    localPointData.a(paramFloat1);
    localPointData.b(paramFloat2);
    localPointData.c(paramFloat3);
    localPointData.a(paramLong);
    this.b.add(localPointData);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(PathData paramPathData)
  {
    this.c = paramPathData.c;
    this.d = paramPathData.d;
    this.a = paramPathData.a;
    this.b.addAll(paramPathData.e());
  }
  
  public void a(List<PathData.PointData> paramList)
  {
    if (paramList != null) {
      this.b.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.b.size();
  }
  
  public ArrayList<PathData.PointData> e()
  {
    return this.b;
  }
  
  public void f()
  {
    this.b.clear();
  }
  
  public PathData.PointData g()
  {
    if (this.b.size() > 0) {
      return (PathData.PointData)this.b.get(0);
    }
    return null;
  }
  
  public PathData.PointData h()
  {
    if (this.b.size() > 0)
    {
      ArrayList localArrayList = this.b;
      return (PathData.PointData)localArrayList.get(localArrayList.size() - 1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathData
 * JD-Core Version:    0.7.0.1
 */