import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class azay
{
  public static String a(Map<Integer, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("&");
      }
      String str = (String)paramMap.get(localObject);
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          localObject = URLEncoder.encode(localObject + "", "UTF-8");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("=");
          if (str == null) {
            break label147;
          }
          localObject = URLEncoder.encode(str, "UTF-8");
          localStringBuilder.append((String)localObject);
        }
        catch (UnsupportedEncodingException paramMap)
        {
          throw new RuntimeException("This method requires UTF-8 encoding support", paramMap);
        }
        localObject = "";
        continue;
        label147:
        localObject = "";
      }
    }
    return localStringBuilder.toString();
  }
  
  public static Map<Integer, String> a(String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int j = paramString.length;
    if (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length != 2) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localHashMap.put(Integer.valueOf(URLDecoder.decode(arrayOfString[0], "UTF-8")), URLDecoder.decode(arrayOfString[1], "UTF-8"));
        }
        catch (UnsupportedEncodingException paramString)
        {
          throw new RuntimeException("This method requires UTF-8 encoding support", paramString);
        }
      }
    }
    return localHashMap;
  }
  
  public static Map<String, String> b(String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int j = paramString.length;
    if (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length != 2) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localHashMap.put(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
        }
        catch (UnsupportedEncodingException paramString)
        {
          throw new RuntimeException("This method requires UTF-8 encoding support", paramString);
        }
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azay
 * JD-Core Version:    0.7.0.1
 */