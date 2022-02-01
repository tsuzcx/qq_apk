package com.tencent.comic.data;

import java.util.ArrayList;
import java.util.HashMap;

public class VipComicHippyBounceRateHelper
{
  public static final ArrayList<Integer> a;
  private static HashMap<Integer, HashMap<Integer, Long>> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(13));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(12));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(11));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    Object localObject = (HashMap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localObject == null) {
      return 0L;
    }
    localObject = (Long)((HashMap)localObject).get(Integer.valueOf(paramInt2));
    if (localObject == null) {
      return 0L;
    }
    return ((Long)localObject).longValue();
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt2)))
    {
      HashMap localHashMap2 = (HashMap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
      HashMap localHashMap1 = localHashMap2;
      if (localHashMap2 == null)
      {
        localHashMap1 = new HashMap();
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), localHashMap1);
      }
      localHashMap1.put(Integer.valueOf(paramInt2), Long.valueOf(paramLong));
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = (HashMap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localHashMap == null) {
      return false;
    }
    return localHashMap.containsKey(Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.data.VipComicHippyBounceRateHelper
 * JD-Core Version:    0.7.0.1
 */