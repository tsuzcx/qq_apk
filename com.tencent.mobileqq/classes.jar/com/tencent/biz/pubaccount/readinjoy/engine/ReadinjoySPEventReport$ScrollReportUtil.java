package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.ArrayList;
import java.util.List;

public class ReadinjoySPEventReport$ScrollReportUtil
{
  public static long a;
  public static List a;
  public static long b;
  public static long c;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    b = -1L;
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilList.clear();
    c = 0L;
  }
  
  public static void a(ReadinjoySPEventReport.ScrollStep paramScrollStep)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty())
    {
      ReadinjoySPEventReport.ScrollStep localScrollStep = (ReadinjoySPEventReport.ScrollStep)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (paramScrollStep.b - localScrollStep.b > jdField_a_of_type_Long) {
        a();
      }
    }
    jdField_a_of_type_JavaUtilList.add(paramScrollStep);
    c += paramScrollStep.jdField_a_of_type_Long;
    if (a())
    {
      paramScrollStep = new ArrayList();
      paramScrollStep.addAll(jdField_a_of_type_JavaUtilList);
      jdField_a_of_type_JavaUtilList.clear();
      ReadinjoySPEventReport.a(paramScrollStep);
    }
  }
  
  public static boolean a()
  {
    return c > b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ScrollReportUtil
 * JD-Core Version:    0.7.0.1
 */