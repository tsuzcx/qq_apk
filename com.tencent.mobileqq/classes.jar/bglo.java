import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class bglo
{
  public static String a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.getBytes();
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuffer.append(Integer.toHexString(new Integer(paramString[i] & 0xFF).intValue())).append(" ");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.appendCodePoint(paramArrayOfByte[i] & 0xFF);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static HashMap<String, String> a(JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramJSONObject.getString(str));
      }
      return localHashMap;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static byte[] a(String paramString)
  {
    paramString = paramString.toCharArray();
    int m = paramString.length / 2;
    byte[] arrayOfByte = new byte[m];
    int i = 0;
    while (i < m)
    {
      int k = Character.digit(paramString[(i * 2)], 16) << 4 | Character.digit(paramString[(i * 2 + 1)], 16);
      int j = k;
      if (k > 127) {
        j = k - 256;
      }
      arrayOfByte[i] = ((byte)j);
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglo
 * JD-Core Version:    0.7.0.1
 */