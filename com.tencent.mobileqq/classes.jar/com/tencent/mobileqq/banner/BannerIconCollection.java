package com.tencent.mobileqq.banner;

import android.support.annotation.IdRes;
import com.tencent.mobileqq.activity.recent.BannerTempInjectImpl;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BannerIconCollection
{
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_temp_inject.yml", version=2)
  public static ArrayList<Class<? extends IBannerTempInject>> a;
  private static final Map<String, Integer> a;
  public static int[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(BannerTempInjectImpl.class);
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838318, 2130838308, 2130838310, 2130838319, 2130838479, 2130841363, 2130838320, 2130838307, 2130838312, 2130838309, 2130838306, 2130838313, 2130838314, 2130838316, 2130838317, 2130846271 };
    jdField_a_of_type_JavaUtilMap = new HashMap();
    Map localMap = jdField_a_of_type_JavaUtilMap;
    Integer localInteger = Integer.valueOf(7);
    localMap.put("m.ke.qq.com", localInteger);
    jdField_a_of_type_JavaUtilMap.put("ke.qq.com", localInteger);
    jdField_a_of_type_JavaUtilMap.put("fudao.qq.com", Integer.valueOf(9));
    jdField_a_of_type_JavaUtilMap.put("buluo.qq.com", Integer.valueOf(10));
    localMap = jdField_a_of_type_JavaUtilMap;
    localInteger = Integer.valueOf(2);
    localMap.put("m.gamecenter.qq.com", localInteger);
    jdField_a_of_type_JavaUtilMap.put("imgcache.qq.com", localInteger);
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
      if (a().a(paramString)) {
        localInteger1 = Integer.valueOf(8);
      } else {
        localInteger1 = Integer.valueOf(6);
      }
    }
    return localInteger1.intValue();
  }
  
  static IBannerTempInject a()
  {
    Object localObject1;
    if ((!jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (jdField_a_of_type_JavaUtilArrayList.get(0) != null)) {
      try
      {
        IBannerTempInject localIBannerTempInject = (IBannerTempInject)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      QLog.d(BannerIconCollection.class.getSimpleName(), 2, "getBannerTempInject: return null");
      localObject2 = new BannerIconCollection.1();
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerIconCollection
 * JD-Core Version:    0.7.0.1
 */