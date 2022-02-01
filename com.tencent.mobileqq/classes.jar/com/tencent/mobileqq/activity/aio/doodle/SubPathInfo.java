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
    PointSet localPointSet = (PointSet)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localPointSet.a.a(localPointSet.b);
    localPointSet.c.a(localPointSet.d);
    localPointSet.b.a(localPointSet.d);
    this.jdField_a_of_type_JavaUtilList.add(localPointSet);
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
    PointSet localPointSet1 = new PointSet();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    PointSet localPointSet2 = (PointSet)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localPointSet1.a.a(localPointSet2.b);
    localPointSet1.c.a(localPointSet2.d);
    localPointSet1.b.a((localPointSet1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localPointSet1.c.b + paramFloat2) / 2.0F, (localPointSet1.c.c + paramFloat3) / 2.0F, (localPointSet1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localPointSet1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localPointSet1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.SubPathInfo
 * JD-Core Version:    0.7.0.1
 */