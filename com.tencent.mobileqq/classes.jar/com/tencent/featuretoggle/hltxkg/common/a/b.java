package com.tencent.featuretoggle.hltxkg.common.a;

import android.os.Handler;
import com.tencent.featuretoggle.hltxkg.common.c.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static j jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonAJ = new j();
  public static String a;
  private static Map<Integer, b.a> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static String jdField_b_of_type_JavaLangString = "halley-cloud-AccessIpMgr";
  private static Map<String, b.a> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public static com.tencent.featuretoggle.hltxkg.common.a.c.c a(String paramString)
  {
    Object localObject1 = (b.a)jdField_b_of_type_JavaUtilMap.get(paramString);
    if (localObject1 != null)
    {
      localObject2 = new com.tencent.featuretoggle.hltxkg.common.a.c.c(((b.a)localObject1).jdField_a_of_type_JavaLangString, ((b.a)localObject1).c);
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((b.a)localObject1).jdField_a_of_type_JavaUtilList);
      ((com.tencent.featuretoggle.hltxkg.common.a.c.c)localObject2).c = localArrayList;
      if (!((com.tencent.featuretoggle.hltxkg.common.a.c.c)localObject2).c.isEmpty()) {
        return localObject2;
      }
    }
    localObject1 = new a(paramString, -1);
    ((a)localObject1).a((byte)3);
    paramString = new com.tencent.featuretoggle.hltxkg.common.a.c.c(paramString, "");
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    paramString.c = ((List)localObject2);
    return paramString;
  }
  
  public static void a()
  {
    com.tencent.featuretoggle.hltxkg.common.a.i().post(new c());
  }
  
  public static void a(String paramString, a parama, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 >= 500))
    {
      paramString = (b.a)jdField_b_of_type_JavaUtilMap.get(paramString);
      if (paramString != null) {
        paramString.b(parama);
      }
    }
  }
  
  public static void b()
  {
    f.d().f();
  }
  
  public static void c()
  {
    Object localObject1 = f.d().f().a();
    if (localObject1 != null)
    {
      int i = 0;
      if (i.a("app_schdule_use_ipv6", 0, 1, 1) == 1) {
        i = 1;
      }
      jdField_b_of_type_JavaUtilMap.clear();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        com.tencent.featuretoggle.hltxkg.common.a.c.c localc = (com.tencent.featuretoggle.hltxkg.common.a.c.c)((Iterator)localObject1).next();
        b.a locala = new b.a(jdField_a_of_type_JavaLangString);
        locala.jdField_a_of_type_JavaLangString = localc.jdField_a_of_type_JavaLangString;
        locala.c = localc.jdField_b_of_type_JavaLangString;
        int j = localc.d;
        boolean bool = locala.c.startsWith("bottom");
        Object localObject2 = localc.c.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          a locala1 = (a)((Iterator)localObject2).next();
          if (((i != 0) || (!locala1.g())) && (e.f() == 1 ? !locala1.g() : (e.f() != 3) || (locala1.g())))
          {
            if (bool) {
              locala1.a((byte)5);
            }
            locala.a(locala1);
          }
        }
        localObject2 = new a(localc.jdField_a_of_type_JavaLangString, -1);
        ((a)localObject2).a((byte)3);
        locala.a((a)localObject2);
        Collections.sort(locala.jdField_a_of_type_JavaUtilList, new d(locala));
        jdField_b_of_type_JavaUtilMap.put(localc.jdField_a_of_type_JavaLangString, locala);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.b
 * JD-Core Version:    0.7.0.1
 */