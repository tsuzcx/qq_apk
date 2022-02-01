import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bjur
{
  protected static bjur a;
  protected static final String a;
  protected bjwa a;
  protected HashMap<String, bjup> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bjur.class.getName();
  }
  
  protected bjur()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_Bjwa == null) {
          this.jdField_a_of_type_Bjwa = bjvv.a().a(bjup.class, 0L, "http_cache_table");
        }
        int j = this.jdField_a_of_type_Bjwa.a();
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap(j);
        i = 0;
        if (i < j)
        {
          bjup localbjup = (bjup)this.jdField_a_of_type_Bjwa.a(i);
          if ((localbjup == null) || (localbjup.jdField_a_of_type_JavaLangString == null)) {
            break label108;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(localbjup.jdField_a_of_type_JavaLangString, localbjup);
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
  
  public static bjur a()
  {
    try
    {
      if (jdField_a_of_type_Bjur == null) {
        jdField_a_of_type_Bjur = new bjur();
      }
      bjur localbjur = jdField_a_of_type_Bjur;
      return localbjur;
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
        paramString = bjtz.b(paramString);
        l1 = l2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
          l1 = ((bjup)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_a_of_type_Long;
        }
      }
    }
    bjtx.c(jdField_a_of_type_JavaLangString, "Get lastModify from cache. lastModify=" + l1);
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
        paramString = bjtz.b(paramString);
        str1 = str2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
          str1 = ((bjup)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).jdField_b_of_type_JavaLangString;
        }
      }
    }
    bjtx.c(jdField_a_of_type_JavaLangString, "Get ETag from cache. ETag=" + str1);
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
          bjup localbjup = (bjup)localIterator.next();
          if (l2 - localbjup.jdField_b_of_type_Long >= 432000000L)
          {
            bjtx.c(jdField_a_of_type_JavaLangString, "Clear out of date cache. urlkey=" + localbjup.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Bjwa.b("urlKey='" + localbjup.jdField_a_of_type_JavaLangString + "'");
            localIterator.remove();
          }
          else if (l1 > localbjup.jdField_b_of_type_Long)
          {
            l1 = localbjup.jdField_b_of_type_Long;
            str = localbjup.jdField_a_of_type_JavaLangString;
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 50)
          {
            bjtx.c(jdField_a_of_type_JavaLangString, "Reached max cache count:50. Clear last cache data. urlKey=" + ((bjup)this.jdField_a_of_type_JavaUtilHashMap.get(str)).jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_JavaUtilHashMap.remove(str);
            this.jdField_a_of_type_Bjwa.b("urlKey='" + str + "'");
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
      paramString = bjtz.b(paramString);
      if (paramString != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        this.jdField_a_of_type_Bjwa.b("urlKey='" + paramString + "'");
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
          bjtx.e(jdField_a_of_type_JavaLangString, "saveResponse error. params error\n url=" + paramString1 + "; ETag=" + paramString2 + "; lastModify=" + paramLong + "; response=" + paramString3);
          return;
        }
        paramString2 = new bjup(paramString1, paramString2, paramLong, paramString3, paramString4);
        paramString1 = bjtz.b(paramString1);
        if (this.jdField_a_of_type_Bjwa == null) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
        {
          this.jdField_a_of_type_Bjwa.b(paramString2, "urlKey='" + paramString1 + "'");
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
          bjtx.c(jdField_a_of_type_JavaLangString, "Get 200, Save response data to cache. urlKey=" + paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      a();
      this.jdField_a_of_type_Bjwa.a(paramString2, 1);
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
        paramString = bjtz.b(paramString);
        str1 = str2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
          str1 = ((bjup)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).d;
        }
      }
    }
    bjtx.c(jdField_a_of_type_JavaLangString, "Get lastModify from cache. lastModify=" + str1);
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
        str2 = bjtz.b(paramString);
        paramString = str1;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str2) != null) {
          paramString = ((bjup)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).c;
        }
        bjtx.c(jdField_a_of_type_JavaLangString, "Get 304, Load response data from cache. urlKey=" + str2);
        str2 = paramString;
      }
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjur
 * JD-Core Version:    0.7.0.1
 */