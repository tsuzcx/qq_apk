package com.tencent.mobileqq.activity.aio.doodle;

import java.util.ArrayList;
import java.util.List;

public class PathData
{
  public int a;
  private ArrayList<PathData.PointData> a;
  private int b;
  private int c = -1;
  
  public PathData()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      return ((PathData.PointData)localArrayList.get(localArrayList.size() - 1)).a();
    }
    return 0L;
  }
  
  public PathData.PointData a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return (PathData.PointData)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public ArrayList<PathData.PointData> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    PathData.PointData localPointData = new PathData.PointData();
    localPointData.a(paramFloat1);
    localPointData.b(paramFloat2);
    localPointData.c(paramFloat3);
    localPointData.a(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList.add(localPointData);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(PathData paramPathData)
  {
    this.b = paramPathData.b;
    this.c = paramPathData.c;
    this.jdField_a_of_type_Int = paramPathData.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramPathData.a());
  }
  
  public void a(List<PathData.PointData> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public PathData.PointData b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      return (PathData.PointData)localArrayList.get(localArrayList.size() - 1);
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathData
 * JD-Core Version:    0.7.0.1
 */