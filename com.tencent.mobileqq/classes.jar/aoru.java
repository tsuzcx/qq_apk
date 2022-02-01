import com.tencent.qphone.base.util.QLog;
import java.security.Key;

public class aoru
{
  private aorx a;
  
  public aoru(aorx paramaorx)
  {
    this.a = paramaorx;
  }
  
  private aorv a(String paramString)
  {
    aort localaort = aort.a(paramString);
    if (localaort == null)
    {
      QLog.e("JwtConsumer", 1, "format jwt token error");
      return null;
    }
    paramString = new aorv(paramString, localaort);
    if (a(paramString)) {}
    for (;;)
    {
      return paramString;
      paramString = null;
    }
  }
  
  private boolean a(aorv paramaorv)
  {
    paramaorv = paramaorv.a();
    Key localKey = this.a.a();
    if (localKey == null)
    {
      QLog.e("JwtConsumer", 1, "verificationKeyResolver.resolveKey() is null");
      return false;
    }
    paramaorv.a(localKey);
    return paramaorv.a();
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
 * Qualified Name:     aoru
 * JD-Core Version:    0.7.0.1
 */