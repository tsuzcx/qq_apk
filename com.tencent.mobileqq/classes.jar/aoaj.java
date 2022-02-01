import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public class aoaj
{
  String a;
  String b;
  String c;
  
  public static aoaj a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        aoaj localaoaj = new aoaj();
        paramString = new JSONObject(paramString);
        localaoaj.a = paramString.getString("url");
        if (localaoaj.a != null)
        {
          localaoaj.a = localaoaj.a.trim();
          localaoaj.c = MD5.toMD5(localaoaj.a);
        }
        localaoaj.b = paramString.getString("md5");
        if (localaoaj.b != null) {
          localaoaj.b = localaoaj.b.trim();
        }
        paramString = localaoaj;
        if (QLog.isDevelopLevel())
        {
          axxb.a("HotchatSCMng", "parse ConfigData", new Object[] { localaoaj });
          return localaoaj;
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
 * Qualified Name:     aoaj
 * JD-Core Version:    0.7.0.1
 */