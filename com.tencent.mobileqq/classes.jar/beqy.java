import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;

public class beqy
{
  public int a;
  public String a;
  
  public beqy(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static beqy a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramString.startsWith("wss://"))
    {
      str = paramString;
      if (paramString.length() > 6) {
        str = "https://" + paramString.substring(6);
      }
    }
    try
    {
      for (;;)
      {
        URL localURL1 = new URL(str);
        paramString = localURL1.getHost();
        i = localURL1.getPort();
        str = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          str = paramString;
          if (paramString.startsWith("www.")) {
            str = paramString.substring(4);
          }
        }
        return new beqy(str, i);
        str = paramString;
        if (!paramString.startsWith("https://")) {
          str = "https://" + paramString;
        }
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      try
      {
        URL localURL2 = new URL("https://" + str);
        paramString = localURL2.getHost();
        int i = localURL2.getPort();
      }
      catch (MalformedURLException paramString)
      {
        besl.d("[mini] http.", "getDomainConfig url error" + str, localMalformedURLException);
      }
    }
    return null;
  }
  
  public static boolean a(beqy parambeqy1, beqy parambeqy2)
  {
    int j = 0;
    if ((parambeqy1 == null) || (parambeqy2 == null)) {
      return false;
    }
    boolean bool = TextUtils.equals(parambeqy1.jdField_a_of_type_JavaLangString, parambeqy2.jdField_a_of_type_JavaLangString);
    int i;
    if (parambeqy1.jdField_a_of_type_Int == parambeqy2.jdField_a_of_type_Int)
    {
      i = 1;
      if ((i != 0) || (parambeqy1.jdField_a_of_type_Int > 0)) {
        break label124;
      }
      if ((parambeqy2.jdField_a_of_type_Int != 80) && (parambeqy2.jdField_a_of_type_Int != 8080))
      {
        i = j;
        if (parambeqy2.jdField_a_of_type_Int > 0) {}
      }
      else
      {
        i = 1;
      }
    }
    label124:
    for (;;)
    {
      if ((i == 0) && (parambeqy2.jdField_a_of_type_Int <= 0) && (parambeqy1.jdField_a_of_type_Int != 80) && (parambeqy1.jdField_a_of_type_Int != 8080) && (parambeqy1.jdField_a_of_type_Int <= 0)) {}
      return bool;
      i = 0;
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (beqy)paramObject;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int);
    return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.hashCode() * 31 + this.jdField_a_of_type_Int;
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_Int > 0) {}
    for (String str = ", port=" + this.jdField_a_of_type_Int;; str = "") {
      return "DomainConfig{host='" + this.jdField_a_of_type_JavaLangString + '\'' + str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqy
 * JD-Core Version:    0.7.0.1
 */