package com.tencent.mobileqq.activity.aio.doodle;

import java.util.ArrayList;
import java.util.List;

class SubPathInfo
{
  int jdField_a_of_type_Int = 2;
  List<PointSet> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  
  public List<PointSet> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    PointSet localPointSet = new PointSet();
    localPointSet.a((PointSet)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localPointSet);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    localObject = (PointSet)((List)localObject).get(((List)localObject).size() - 1);
    ((PointSet)localObject).a.a(((PointSet)localObject).b);
    ((PointSet)localObject).c.a(((PointSet)localObject).d);
    ((PointSet)localObject).b.a(((PointSet)localObject).d);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    PointSet localPointSet = new PointSet();
    localPointSet.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localPointSet);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    PointSet localPointSet = new PointSet();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    localObject = (PointSet)((List)localObject).get(((List)localObject).size() - 1);
    localPointSet.a.a(((PointSet)localObject).b);
    localPointSet.c.a(((PointSet)localObject).d);
    localPointSet.b.a((localPointSet.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localPointSet.c.b + paramFloat2) / 2.0F, (localPointSet.c.c + paramFloat3) / 2.0F, (localPointSet.c.jdField_a_of_type_Long + paramLong) / 2L);
    localPointSet.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localPointSet);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.SubPathInfo
 * JD-Core Version:    0.7.0.1
 */