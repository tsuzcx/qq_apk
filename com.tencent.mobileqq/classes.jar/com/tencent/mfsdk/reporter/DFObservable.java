package com.tencent.mfsdk.reporter;

import java.util.HashMap;
import java.util.Observable;

public class DFObservable
  extends Observable
{
  private static DFObservable a;
  public HashMap a;
  
  public static DFObservable a()
  {
    if (jdField_a_of_type_ComTencentMfsdkReporterDFObservable == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkReporterDFObservable == null) {
        jdField_a_of_type_ComTencentMfsdkReporterDFObservable = new DFObservable();
      }
      return jdField_a_of_type_ComTencentMfsdkReporterDFObservable;
    }
    finally {}
  }
  
  public void a(HashMap paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    setChanged();
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.DFObservable
 * JD-Core Version:    0.7.0.1
 */