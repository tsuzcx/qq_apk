import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public class amuj
{
  String a;
  String b;
  String c;
  
  public static amuj a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        amuj localamuj = new amuj();
        paramString = new JSONObject(paramString);
        localamuj.a = paramString.getString("url");
        if (localamuj.a != null)
        {
          localamuj.a = localamuj.a.trim();
          localamuj.c = MD5.toMD5(localamuj.a);
        }
        localamuj.b = paramString.getString("md5");
        if (localamuj.b != null) {
          localamuj.b = localamuj.b.trim();
        }
        paramString = localamuj;
        if (QLog.isDevelopLevel())
        {
          awkj.a("HotchatSCMng", "parse ConfigData", new Object[] { localamuj });
          return localamuj;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[url:").append(this.a).append(",").append("md5:").append(this.b).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuj
 * JD-Core Version:    0.7.0.1
 */