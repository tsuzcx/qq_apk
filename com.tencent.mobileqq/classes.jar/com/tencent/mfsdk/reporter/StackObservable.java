package com.tencent.mfsdk.reporter;

import java.util.HashMap;
import java.util.Observable;

public class StackObservable
  extends Observable
{
  private static StackObservable a;
  public int a;
  public HashMap a;
  
  public static StackObservable a()
  {
    if (jdField_a_of_type_ComTencentMfsdkReporterStackObservable == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkReporterStackObservable == null) {
        jdField_a_of_type_ComTencentMfsdkReporterStackObservable = new StackObservable();
      }
      return jdField_a_of_type_ComTencentMfsdkReporterStackObservable;
    }
    finally {}
  }
  
  public void a(HashMap paramHashMap)
  {
    paramHashMap.put("key_type", "t_held_thread");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    setChanged();
    notifyObservers();
  }
  
  public void a(HashMap paramHashMap, int paramInt)
  {
    paramHashMap.put("key_type", "t_drop_frame");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Int = paramInt;
    setChanged();
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.StackObservable
 * JD-Core Version:    0.7.0.1
 */