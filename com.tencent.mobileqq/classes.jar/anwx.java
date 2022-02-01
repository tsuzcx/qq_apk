import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public class anwx
{
  String a;
  String b;
  String c;
  
  public static anwx a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        anwx localanwx = new anwx();
        paramString = new JSONObject(paramString);
        localanwx.a = paramString.getString("url");
        if (localanwx.a != null)
        {
          localanwx.a = localanwx.a.trim();
          localanwx.c = MD5.toMD5(localanwx.a);
        }
        localanwx.b = paramString.getString("md5");
        if (localanwx.b != null) {
          localanwx.b = localanwx.b.trim();
        }
        paramString = localanwx;
        if (QLog.isDevelopLevel())
        {
          axql.a("HotchatSCMng", "parse ConfigData", new Object[] { localanwx });
          return localanwx;
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
 * Qualified Name:     anwx
 * JD-Core Version:    0.7.0.1
 */