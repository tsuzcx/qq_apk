package com.tencent.mobileqq.activity.aio.doodle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoodleItem
{
  private long jdField_a_of_type_Long;
  private DoodleParam jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam = new DoodleParam();
  private ArrayList<PathData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public DoodleParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam;
  }
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      PathData localPathData = (PathData)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localPathData != null)
      {
        if (localPathData.a > 0) {
          return String.valueOf(localPathData.a());
        }
        return String.valueOf(localPathData.b());
      }
    }
    return "";
  }
  
  public ArrayList<PathData> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(PathData paramPathData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramPathData == null) {
      return;
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(paramPathData);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramPathData);
    if (paramBoolean2) {
      this.jdField_a_of_type_Long += paramPathData.a();
    }
  }
  
  public void a(List<PathData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList != null)
    {
      long l1 = 0L;
      long l2;
      if (!paramBoolean1)
      {
        l2 = l1;
        if (!paramBoolean2) {}
      }
      else
      {
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          l2 = l1;
          if (!localIterator.hasNext()) {
            break;
          }
          PathData localPathData = (PathData)localIterator.next();
          if (paramBoolean1) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleParam.a(localPathData);
          }
          if (paramBoolean2) {
            l1 += localPathData.a();
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (paramBoolean2) {
        this.jdField_a_of_type_Long += l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleItem
 * JD-Core Version:    0.7.0.1
 */