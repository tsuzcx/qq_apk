import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public class anoi
{
  String a;
  String b;
  String c;
  
  public static anoi a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        anoi localanoi = new anoi();
        paramString = new JSONObject(paramString);
        localanoi.a = paramString.getString("url");
        if (localanoi.a != null)
        {
          localanoi.a = localanoi.a.trim();
          localanoi.c = MD5.toMD5(localanoi.a);
        }
        localanoi.b = paramString.getString("md5");
        if (localanoi.b != null) {
          localanoi.b = localanoi.b.trim();
        }
        paramString = localanoi;
        if (QLog.isDevelopLevel())
        {
          axei.a("HotchatSCMng", "parse ConfigData", new Object[] { localanoi });
          return localanoi;
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
 * Qualified Name:     anoi
 * JD-Core Version:    0.7.0.1
 */