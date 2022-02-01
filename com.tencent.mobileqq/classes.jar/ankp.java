import com.tencent.qphone.base.util.QLog;
import java.security.Key;

public class ankp
{
  private anks a;
  
  public ankp(anks paramanks)
  {
    this.a = paramanks;
  }
  
  private ankq a(String paramString)
  {
    anko localanko = anko.a(paramString);
    if (localanko == null)
    {
      QLog.e("JwtConsumer", 1, "format jwt token error");
      return null;
    }
    paramString = new ankq(paramString, localanko);
    if (a(paramString)) {}
    for (;;)
    {
      return paramString;
      paramString = null;
    }
  }
  
  private boolean a(ankq paramankq)
  {
    paramankq = paramankq.a();
    Key localKey = this.a.a();
    if (localKey == null)
    {
      QLog.e("JwtConsumer", 1, "verificationKeyResolver.resolveKey() is null");
      return false;
    }
    paramankq.a(localKey);
    return paramankq.a();
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
 * Qualified Name:     ankp
 * JD-Core Version:    0.7.0.1
 */