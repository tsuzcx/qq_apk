package com.tencent.av.app;

import java.util.HashMap;

public class SessionFlag
{
  private static volatile SessionFlag a;
  public int a;
  protected HashMap<String, Integer> a;
  
  public SessionFlag()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = null;
  }
  
  public static SessionFlag a()
  {
    if (jdField_a_of_type_ComTencentAvAppSessionFlag == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvAppSessionFlag == null) {
          jdField_a_of_type_ComTencentAvAppSessionFlag = new SessionFlag();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvAppSessionFlag;
  }
  
  public int a(String paramString)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap == null) {
      return 0;
    }
    if (!localHashMap.containsKey(paramString)) {
      return 0;
    }
    return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.SessionFlag
 * JD-Core Version:    0.7.0.1
 */