package com.tencent.av.app;

import java.util.HashMap;

public class SessionFlag
{
  public int a;
  protected HashMap<String, Integer> a;
  
  public SessionFlag()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = null;
  }
  
  public static int a(SessionFlag paramSessionFlag, String paramString)
  {
    if (paramSessionFlag == null) {}
    while ((paramSessionFlag.jdField_a_of_type_JavaUtilHashMap == null) || (!paramSessionFlag.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return 0;
    }
    return ((Integer)paramSessionFlag.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
  }
  
  public static void a(SessionFlag paramSessionFlag, String paramString, int paramInt)
  {
    if (paramSessionFlag == null) {
      return;
    }
    if (paramSessionFlag.jdField_a_of_type_JavaUtilHashMap == null) {
      paramSessionFlag.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    paramSessionFlag.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.SessionFlag
 * JD-Core Version:    0.7.0.1
 */