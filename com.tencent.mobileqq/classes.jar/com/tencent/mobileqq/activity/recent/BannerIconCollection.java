package com.tencent.mobileqq.activity.recent;

import android.support.annotation.IdRes;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import java.util.HashMap;
import java.util.Map;

public class BannerIconCollection
{
  private static final Map a;
  public static int[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837945, 2130837940, 2130837942, 2130837946, 2130838074, 2130839440, 2130837947, 2130837939, 2130837944, 2130837941, 2130837938 };
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put("m.ke.qq.com", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilMap.put("ke.qq.com", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilMap.put("fudao.qq.com", Integer.valueOf(9));
    jdField_a_of_type_JavaUtilMap.put("buluo.qq.com", Integer.valueOf(10));
    jdField_a_of_type_JavaUtilMap.put("m.gamecenter.qq.com", Integer.valueOf(2));
    jdField_a_of_type_JavaUtilMap.put("imgcache.qq.com", Integer.valueOf(2));
  }
  
  @IdRes
  public static int a(int paramInt)
  {
    return jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  public static int a(String paramString)
  {
    Integer localInteger2 = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (!PublicAccountUtil.d(paramString)) {
        break label37;
      }
    }
    label37:
    for (localInteger1 = Integer.valueOf(8);; localInteger1 = Integer.valueOf(6)) {
      return localInteger1.intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerIconCollection
 * JD-Core Version:    0.7.0.1
 */