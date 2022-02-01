import com.tencent.qphone.base.util.QLog;
import java.security.Key;

public class aoni
{
  private aonl a;
  
  public aoni(aonl paramaonl)
  {
    this.a = paramaonl;
  }
  
  private aonj a(String paramString)
  {
    aonh localaonh = aonh.a(paramString);
    if (localaonh == null)
    {
      QLog.e("JwtConsumer", 1, "format jwt token error");
      return null;
    }
    paramString = new aonj(paramString, localaonh);
    if (a(paramString)) {}
    for (;;)
    {
      return paramString;
      paramString = null;
    }
  }
  
  private boolean a(aonj paramaonj)
  {
    paramaonj = paramaonj.a();
    Key localKey = this.a.a();
    if (localKey == null)
    {
      QLog.e("JwtConsumer", 1, "verificationKeyResolver.resolveKey() is null");
      return false;
    }
    paramaonj.a(localKey);
    return paramaonj.a();
  }
  
  public String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null)
    {
      QLog.e("JwtConsumer", 1, "process jwt token error, process is null");
      return null;
    }
    paramString = paramString.a();
    if (paramString == null)
    {
      QLog.e("JwtConsumer", 1, "process jwt token error, joseObject is null");
      return null;
    }
    return paramString.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoni
 * JD-Core Version:    0.7.0.1
 */