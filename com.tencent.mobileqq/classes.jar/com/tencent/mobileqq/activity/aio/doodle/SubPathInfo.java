package com.tencent.mobileqq.activity.aio.doodle;

import java.util.ArrayList;
import java.util.List;

class SubPathInfo
{
  List<PointSet> a = new ArrayList();
  int b = 2;
  boolean c = false;
  
  public List<PointSet> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.a);
    this.a.clear();
    PointSet localPointSet = new PointSet();
    localPointSet.a((PointSet)localArrayList.get(localArrayList.size() - 1));
    this.a.add(localPointSet);
    this.c = true;
    return localArrayList;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    PointSet localPointSet = new PointSet();
    localPointSet.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.a.add(localPointSet);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b()
  {
    if (this.a.size() == 0) {
      return;
    }
    Object localObject = this.a;
    localObject = (PointSet)((List)localObject).get(((List)localObject).size() - 1);
    ((PointSet)localObject).a.a(((PointSet)localObject).b);
    ((PointSet)localObject).c.a(((PointSet)localObject).d);
    ((PointSet)localObject).b.a(((PointSet)localObject).d);
    this.a.add(localObject);
  }
  
  public boolean b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    PointSet localPointSet = new PointSet();
    if (this.a.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    Object localObject = this.a;
    localObject = (PointSet)((List)localObject).get(((List)localObject).size() - 1);
    localPointSet.a.a(((PointSet)localObject).b);
    localPointSet.c.a(((PointSet)localObject).d);
    localPointSet.b.a((localPointSet.c.a + paramFloat1) / 2.0F, (localPointSet.c.b + paramFloat2) / 2.0F, (localPointSet.c.c + paramFloat3) / 2.0F, (localPointSet.c.d + paramLong) / 2L);
    localPointSet.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.a.add(localPointSet);
    if (this.c)
    {
      this.c = false;
      this.a.remove(0);
    }
    return this.a.size() > this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.SubPathInfo
 * JD-Core Version:    0.7.0.1
 */