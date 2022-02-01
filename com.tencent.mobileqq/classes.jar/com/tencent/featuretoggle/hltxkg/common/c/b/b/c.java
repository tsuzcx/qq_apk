package com.tencent.featuretoggle.hltxkg.common.c.b.b;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import com.tencent.featuretoggle.hltxkg.common.a.o;
import com.tencent.featuretoggle.hltxkg.common.c.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements com.tencent.featuretoggle.hltxkg.common.c.c, Runnable
{
  private static int jdField_a_of_type_Int = -1;
  private static c jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonCBBC = new c();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private com.tencent.featuretoggle.hltxkg.common.c.b jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonCB;
  private Runnable jdField_a_of_type_JavaLangRunnable = new d(this);
  private Map<String, b> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private Runnable jdField_b_of_type_JavaLangRunnable = new e(this);
  private Map<String, c.a> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private Runnable jdField_c_of_type_JavaLangRunnable = new f(this);
  private boolean jdField_c_of_type_Boolean = false;
  
  private c.a a(String paramString)
  {
    try
    {
      boolean bool = this.jdField_b_of_type_JavaUtilMap.isEmpty();
      Object localObject3;
      if (bool) {
        try
        {
          Object localObject1 = j.b("apnrecords", "", true);
          if (!((String)localObject1).isEmpty())
          {
            localObject1 = new JSONObject((String)localObject1);
            localObject3 = ((JSONObject)localObject1).keys();
            while (((Iterator)localObject3).hasNext())
            {
              String str = (String)((Iterator)localObject3).next();
              if (!TextUtils.isEmpty(str))
              {
                JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject(str);
                if (localJSONObject != null)
                {
                  c.a locala = new c.a(this, (byte)0);
                  locala.jdField_a_of_type_Int = localJSONObject.optInt("lastCode");
                  locala.jdField_a_of_type_Long = localJSONObject.optLong("lastReqTime");
                  this.jdField_b_of_type_JavaUtilMap.put(str, locala);
                }
              }
            }
          }
          localObject3 = (c.a)this.jdField_b_of_type_JavaUtilMap.get(paramString);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new c.a(this, (byte)0);
        this.jdField_b_of_type_JavaUtilMap.put(paramString, localObject2);
      }
      return localObject2;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static c c()
  {
    return jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonCBBC;
  }
  
  private void c()
  {
    try
    {
      if (!this.jdField_b_of_type_JavaUtilMap.isEmpty())
      {
        JSONObject localJSONObject1 = new JSONObject();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          c.a locala = (c.a)localEntry.getValue();
          JSONObject localJSONObject2 = new JSONObject();
          try
          {
            localJSONObject2.put("lastCode", locala.jdField_a_of_type_Int);
            localJSONObject2.put("lastReqTime", locala.jdField_a_of_type_Long);
            localJSONObject1.put((String)localEntry.getKey(), localJSONObject2);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        j.a("apnrecords", localJSONObject1.toString(), true);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final void a()
  {
    ((b)this.jdField_a_of_type_JavaUtilMap.get("accessscheduler")).a();
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
      return;
    }
    if ((paramInt == 2) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_c_of_type_Boolean = true;
      paramInt = i.a("detect_platform_update_random_interval", 0, 1440, 10);
      paramInt = new Random().nextInt(paramInt);
      o.a().a(this.jdField_a_of_type_JavaLangRunnable, paramInt * 60 * 1000 + 1000);
    }
  }
  
  public final void a(com.tencent.featuretoggle.hltxkg.common.c.b paramb)
  {
    this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonCB = paramb;
    paramb = new com.tencent.featuretoggle.hltxkg.common.c.b.b.d.a();
    this.jdField_a_of_type_JavaUtilMap.put(paramb.c(), paramb);
    paramb = new com.tencent.featuretoggle.hltxkg.common.c.b.b.b.b();
    this.jdField_a_of_type_JavaUtilMap.put(paramb.c(), paramb);
    paramb = new com.tencent.featuretoggle.hltxkg.common.c.b.b.c.a();
    this.jdField_a_of_type_JavaUtilMap.put(paramb.c(), paramb);
  }
  
  public final void a(String paramString) {}
  
  public final void a(boolean paramBoolean) {}
  
  public final void b()
  {
    ((b)this.jdField_a_of_type_JavaUtilMap.get("settings")).b();
  }
  
  public final void d()
  {
    this.jdField_a_of_type_AndroidOsHandler = com.tencent.featuretoggle.hltxkg.common.a.i();
    this.jdField_a_of_type_AndroidOsHandler.post(this);
    this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonCB.c();
  }
  
  public final com.tencent.featuretoggle.hltxkg.common.c.b e()
  {
    return this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonCB;
  }
  
  public final void run()
  {
    if (i.a("http_platform_start_update_on", 0, 1, 1) == 1)
    {
      jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.b.c
 * JD-Core Version:    0.7.0.1
 */