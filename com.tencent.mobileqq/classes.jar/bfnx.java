import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class bfnx
{
  public static int a(Map<String, String> paramMap, String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt((String)paramMap.get(paramString));
      return i;
    }
    catch (Exception paramMap) {}
    return paramInt;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    int j = 0;
    int i = -1;
    int k;
    if (j < localStringBuilder.length())
    {
      if (localStringBuilder.charAt(j) != '?')
      {
        k = i;
        if (localStringBuilder.charAt(j) != '&') {}
      }
      else
      {
        if (!paramString2.equals(localStringBuilder.substring(j + 1, j + 1 + paramString2.length()))) {
          break label86;
        }
        k = j + 1;
      }
      label86:
      do
      {
        j += 1;
        i = k;
        break;
        k = i;
      } while (i <= 0);
      j += 1;
    }
    for (;;)
    {
      if (i < 0) {
        return paramString1;
      }
      int m = j;
      k = i;
      if (j < 0)
      {
        k = i - 1;
        m = localStringBuilder.length();
      }
      return localStringBuilder.substring(0, k) + localStringBuilder.substring(m, localStringBuilder.length());
      j = -1;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    char c = '?';
    int i = paramString1.indexOf('?');
    int j = paramString1.indexOf('#');
    if (i == -1) {}
    for (;;)
    {
      paramString2 = c + a(paramString2) + '=' + a(paramString3);
      if (j != -1) {
        break;
      }
      return paramString1 + paramString2;
      c = '&';
    }
    return paramString1.substring(0, j) + paramString2 + paramString1.substring(j);
  }
  
  public static Map<String, String> a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      localObject1 = localObject2;
      if (-1 != i) {
        localObject1 = b(paramString.substring(i + 1));
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = new HashMap();
    }
    return paramString;
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new URI(paramString);
        if ((paramString.getHost() != null) && ((paramString.getScheme().equalsIgnoreCase("http")) || (paramString.getScheme().equalsIgnoreCase("https")))) {
          return true;
        }
      }
      catch (URISyntaxException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static Map<String, String> b(String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        paramString = paramString.split("&");
        int j = paramString.length;
        if (i < j)
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString == null) || (arrayOfString.length != 2)) {
            break label72;
          }
          localHashMap.put(arrayOfString[0], URLDecoder.decode(arrayOfString[1]));
        }
      }
      catch (Exception paramString) {}
      return localHashMap;
      label72:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfnx
 * JD-Core Version:    0.7.0.1
 */