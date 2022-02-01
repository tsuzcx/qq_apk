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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838471, 2130838461, 2130838463, 2130838472, 2130838637, 2130841482, 2130838473, 2130838460, 2130838465, 2130838462, 2130838459, 2130838466, 2130838467, 2130838469, 2130838470, 2130846399 };
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
      if (!a().a(paramString)) {
        break label42;
      }
    }
    label42:
    for (localInteger1 = Integer.valueOf(8);; localInteger1 = Integer.valueOf(6)) {
      return localInteger1.intValue();
    }
  }
  
  static IBannerTempInject a()
  {
    if ((!jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (jdField_a_of_type_JavaUtilArrayList.get(0) != null)) {}
    for (;;)
    {
      try
      {
        IBannerTempInject localIBannerTempInject = (IBannerTempInject)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
        Object localObject3 = localIBannerTempInject;
        if (localIBannerTempInject == null)
        {
          QLog.d(BannerIconCollection.class.getSimpleName(), 2, "getBannerTempInject: return null");
          localObject3 = new BannerIconCollection.1();
        }
        return localObject3;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        Object localObject1 = null;
        continue;
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerIconCollection
 * JD-Core Version:    0.7.0.1
 */