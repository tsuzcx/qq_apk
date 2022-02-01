package c.t.m.g;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class bl
{
  private static bl a = new bl();
  private Map<String, String> b = new bm();
  
  private bl()
  {
    StringBuilder localStringBuilder = new StringBuilder("HalleyOperInfo_");
    localStringBuilder.append(m.c());
    a(ck.b(localStringBuilder.toString(), ""), false);
  }
  
  public static bl a()
  {
    return a;
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
    if ((!cn.a(paramString)) && (!"unknown".equals(paramString))) {
      synchronized (this.b)
      {
        paramString = (String)this.b.get(paramString);
        if (!cn.a(paramString)) {
          return paramString;
        }
        return "";
      }
    }
    return "";
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((!cn.a(paramString1)) && (!"unknown".equals(paramString1)) && (!cn.a(paramString2)))
    {
      if ("unknown".equals(paramString2)) {
        return;
      }
      synchronized (this.b)
      {
        if (!paramString2.equals((String)this.b.get(paramString1)))
        {
          this.b.put(paramString1, paramString2);
          paramString1 = b();
          paramString2 = new StringBuilder("HalleyOperInfo_");
          paramString2.append(m.c());
          ck.a(paramString2.toString(), paramString1);
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
        if (!cn.a(paramString)) {
          synchronized (this.b)
          {
            this.b.clear();
            String[] arrayOfString = paramString.split("h;l");
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              i = 0;
              if (i < j)
              {
                Object localObject3 = arrayOfString[i].split("h,l");
                if (localObject3.length != 2) {
                  break label148;
                }
                Object localObject2 = localObject3[0];
                localObject3 = localObject3[1];
                this.b.put(localObject2, localObject3);
                break label148;
              }
            }
            if (paramBoolean)
            {
              ??? = new StringBuilder("HalleyOperInfo_");
              ((StringBuilder)???).append(m.c());
              ck.a(((StringBuilder)???).toString(), paramString);
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
      label148:
      i += 1;
    }
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.b)
    {
      ArrayList localArrayList1 = new ArrayList(this.b.keySet());
      ArrayList localArrayList2 = new ArrayList(this.b.values());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.bl
 * JD-Core Version:    0.7.0.1
 */