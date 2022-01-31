import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bfia
{
  protected static bfia a;
  protected static final String a;
  protected bfjk a;
  protected HashMap<String, bfhy> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bfia.class.getName();
  }
  
  protected bfia()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_Bfjk == null) {
          this.jdField_a_of_type_Bfjk = bfjf.a().a(bfhy.class, 0L, "http_cache_table");
        }
        int j = this.jdField_a_of_type_Bfjk.a();
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap(j);
        i = 0;
        if (i < j)
        {
          bfhy localbfhy = (bfhy)this.jdField_a_of_type_Bfjk.a(i);
          if ((localbfhy == null) || (localbfhy.jdField_a_of_type_JavaLangString == null)) {
            break label108;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(localbfhy.jdField_a_of_type_JavaLangString, localbfhy);
        }
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      return;
      label108:
      i += 1;
    }
  }
  
  public static bfia a()
  {
    try
    {
      if (jdField_a_of_type_Bfia == null) {
        jdField_a_of_type_Bfia = new bfia();
      }
      bfia localbfia = jdField_a_of_type_Bfia;
      return localbfia;
    }
    finally {}
  }
  
  public long a(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      l1 = l2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        paramString = bfhi.b(paramString);
        l1 = l2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
          l1 = ((bfhy)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_Long;
        }
      }
    }
    bfhg.c(jdField_a_of_type_JavaLangString, "Get lastModify from cache. lastModify=" + l1);
    return l1;
  }
  
  public String a(String paramString)
  {
    String str2 = "\"\"";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        paramString = bfhi.b(paramString);
        str1 = str2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
          str1 = ((bfhy)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_b_of_type_JavaLangString;
        }
      }
    }
    bfhg.c(jdField_a_of_type_JavaLangString, "Get ETag from cache. ETag=" + str1);
    return str1;
  }
  
  protected void a()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
        long l2 = System.currentTimeMillis();
        long l1 = 9223372036854775807L;
        String str = null;
        if (localIterator.hasNext())
        {
          bfhy localbfhy = (bfhy)localIterator.next();
          if (l2 - localbfhy.jdField_b_of_type_Long >= 432000000L)
          {
            bfhg.c(jdField_a_of_type_JavaLangString, "Clear out of date cache. urlkey=" + localbfhy.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Bfjk.b("urlKey='" + localbfhy.jdField_a_of_type_JavaLangString + "'");
            localIterator.remove();
          }
          else if (l1 > localbfhy.jdField_b_of_type_Long)
          {
            l1 = localbfhy.jdField_b_of_type_Long;
            str = localbfhy.jdField_a_of_type_JavaLangString;
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 50)
          {
            bfhg.c(jdField_a_of_type_JavaLangString, "Reached max cache count:50. Clear last cache data. urlKey=" + ((bfhy)this.jdField_a_of_type_JavaUtilHashMap.get(str)).jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_JavaUtilHashMap.remove(str);
            this.jdField_a_of_type_Bfjk.b("urlKey='" + str + "'");
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = bfhi.b(paramString);
      if (paramString != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        this.jdField_a_of_type_Bfjk.b("urlKey='" + paramString + "'");
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        if (("".equals(paramString1.trim())) || (paramString3 == null))
        {
          bfhg.e(jdField_a_of_type_JavaLangString, "saveResponse error. params error\n url=" + paramString1 + "; ETag=" + paramString2 + "; lastModify=" + paramLong + "; response=" + paramString3);
          return;
        }
        paramString2 = new bfhy(paramString1, paramString2, paramLong, paramString3, paramString4);
        paramString1 = bfhi.b(paramString1);
        if (this.jdField_a_of_type_Bfjk == null) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
        {
          this.jdField_a_of_type_Bfjk.b(paramString2, "urlKey='" + paramString1 + "'");
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
          bfhg.c(jdField_a_of_type_JavaLangString, "Get 200, Save response data to cache. urlKey=" + paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      a();
      this.jdField_a_of_type_Bfjk.a(paramString2, 1);
    }
  }
  
  public String b(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        paramString = bfhi.b(paramString);
        str1 = str2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
          str1 = ((bfhy)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).d;
        }
      }
    }
    bfhg.c(jdField_a_of_type_JavaLangString, "Get lastModify from cache. lastModify=" + str1);
    return str1;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String c(String paramString)
  {
    String str1 = "";
    String str2 = str1;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      str2 = str1;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        str2 = bfhi.b(paramString);
        paramString = str1;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str2) != null) {
          paramString = ((bfhy)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).c;
        }
        bfhg.c(jdField_a_of_type_JavaLangString, "Get 304, Load response data from cache. urlKey=" + str2);
        str2 = paramString;
      }
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfia
 * JD-Core Version:    0.7.0.1
 */