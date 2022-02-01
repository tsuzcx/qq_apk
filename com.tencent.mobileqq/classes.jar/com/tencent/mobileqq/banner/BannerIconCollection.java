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
  public static ArrayList<Class<? extends IBannerTempInject>> a = new ArrayList();
  public static int[] b;
  private static final Map<String, Integer> c;
  
  static
  {
    a.add(BannerTempInjectImpl.class);
    b = new int[] { 2130838366, 2130838356, 2130838358, 2130838367, 2130838543, 2130842164, 2130838368, 2130838355, 2130838360, 2130838357, 2130838354, 2130838361, 2130838362, 2130838364, 2130838365, 2130847741 };
    c = new HashMap();
    Map localMap = c;
    Integer localInteger = Integer.valueOf(7);
    localMap.put("m.ke.qq.com", localInteger);
    c.put("ke.qq.com", localInteger);
    c.put("fudao.qq.com", Integer.valueOf(9));
    c.put("buluo.qq.com", Integer.valueOf(10));
    localMap = c;
    localInteger = Integer.valueOf(2);
    localMap.put("m.gamecenter.qq.com", localInteger);
    c.put("imgcache.qq.com", localInteger);
  }
  
  @IdRes
  public static int a(int paramInt)
  {
    return b[paramInt];
  }
  
  public static int a(String paramString)
  {
    Integer localInteger2 = (Integer)c.get(paramString);
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
    if ((!a.isEmpty()) && (a.get(0) != null)) {
      try
      {
        IBannerTempInject localIBannerTempInject = (IBannerTempInject)((Class)a.get(0)).newInstance();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerIconCollection
 * JD-Core Version:    0.7.0.1
 */