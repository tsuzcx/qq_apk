import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class bfeq
{
  private static Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[\\w\\d+_]+://");
  private String jdField_a_of_type_JavaLangString;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private String b;
  private String c;
  
  public bfeq(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramString;
      Object localObject = paramString;
      if (paramString.contains("://")) {
        localObject = paramString.replaceFirst("^.*://", "");
      }
      if (!((String)localObject).contains("?"))
      {
        this.b = ((String)localObject);
        return;
      }
      paramString = ((String)localObject).split("\\?");
      this.b = paramString[0];
      this.c = paramString[1];
      localObject = this.c.split("&");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramString = localObject[i];
        if (paramString.contains("="))
        {
          String[] arrayOfString = paramString.split("=");
          String str = arrayOfString[0];
          paramString = "";
          if (arrayOfString.length > 1) {
            paramString = arrayOfString[1];
          }
          this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
        }
        i += 1;
      }
    }
  }
  
  public bfeq(String paramString, Map<String, String> paramMap)
  {
    this.b = paramString;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.c = "";
    this.jdField_a_of_type_JavaLangString = paramString;
    new ArrayList();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.c = (this.c + str + "=" + (String)paramMap.get(str) + "&");
      }
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(this.c))
    {
      this.c = this.c.substring(0, this.c.length() - 1);
      this.jdField_a_of_type_JavaLangString = (paramString + "?" + this.c);
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public Map<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfeq
 * JD-Core Version:    0.7.0.1
 */