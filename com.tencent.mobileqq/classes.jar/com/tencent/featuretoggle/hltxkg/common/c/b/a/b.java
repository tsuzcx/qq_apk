package com.tencent.featuretoggle.hltxkg.common.c.b.a;

import com.tencent.featuretoggle.hltxkg.common.a;
import com.tencent.featuretoggle.hltxkg.common.c.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b
{
  private static b jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonCBAB = new b();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new c(this, 8, 1.0F, true);
  
  private b()
  {
    StringBuilder localStringBuilder = new StringBuilder("HalleyOperInfo_");
    localStringBuilder.append(a.c());
    a(j.b(localStringBuilder.toString(), "", true), false);
  }
  
  public static b a()
  {
    return jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonCBAB;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "cm";
    }
    if (paramInt == 3) {
      return "ct";
    }
    if (paramInt == 2) {
      return "uni";
    }
    return "";
  }
  
  public final String a(String paramString)
  {
    if ((!com.tencent.featuretoggle.hltxkg.common.e.c.a(paramString)) && (!"unknown".equals(paramString))) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if (!com.tencent.featuretoggle.hltxkg.common.e.c.a(paramString)) {
          return paramString;
        }
        return "";
      }
    }
    return "";
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((!com.tencent.featuretoggle.hltxkg.common.e.c.a(paramString1)) && (!"unknown".equals(paramString1)) && (!com.tencent.featuretoggle.hltxkg.common.e.c.a(paramString2)))
    {
      if ("unknown".equals(paramString2)) {
        return;
      }
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (!paramString2.equals((String)this.jdField_a_of_type_JavaUtilMap.get(paramString1)))
        {
          this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
          paramString1 = b();
          paramString2 = new StringBuilder("HalleyOperInfo_");
          paramString2.append(a.c());
          j.a(paramString2.toString(), paramString1, true);
        }
        return;
      }
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!com.tencent.featuretoggle.hltxkg.common.e.c.a(paramString)) {
          synchronized (this.jdField_a_of_type_JavaUtilMap)
          {
            this.jdField_a_of_type_JavaUtilMap.clear();
            String[] arrayOfString = paramString.split("h;l");
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              i = 0;
              if (i < j)
              {
                Object localObject3 = arrayOfString[i].split("h,l");
                if (localObject3.length != 2) {
                  break label149;
                }
                Object localObject2 = localObject3[0];
                localObject3 = localObject3[1];
                this.jdField_a_of_type_JavaUtilMap.put(localObject2, localObject3);
                break label149;
              }
            }
            if (paramBoolean)
            {
              ??? = new StringBuilder("HalleyOperInfo_");
              ((StringBuilder)???).append(a.c());
              j.a(((StringBuilder)???).toString(), paramString, true);
              return;
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label149:
      i += 1;
    }
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilMap.keySet());
      ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
      int i = 0;
      while (i < localArrayList1.size())
      {
        String str1 = (String)localArrayList1.get(i);
        String str2 = (String)localArrayList2.get(i);
        localStringBuilder.append(str1);
        localStringBuilder.append("h,l");
        localStringBuilder.append(str2);
        localStringBuilder.append("h;l");
        i += 1;
      }
      return localStringBuilder.toString();
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.a.b
 * JD-Core Version:    0.7.0.1
 */