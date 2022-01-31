import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public abstract class bgpw
{
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgpw
 * JD-Core Version:    0.7.0.1
 */