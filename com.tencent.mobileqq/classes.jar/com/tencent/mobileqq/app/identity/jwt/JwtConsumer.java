package com.tencent.mobileqq.app.identity.jwt;

import com.tencent.qphone.base.util.QLog;
import java.security.Key;

public class JwtConsumer
{
  private SimpleKeyResolver a;
  
  public JwtConsumer(SimpleKeyResolver paramSimpleKeyResolver)
  {
    this.a = paramSimpleKeyResolver;
  }
  
  private boolean a(JwtContext paramJwtContext)
  {
    paramJwtContext = paramJwtContext.a();
    Key localKey = this.a.a();
    if (localKey == null)
    {
      QLog.e("JwtConsumer", 1, "verificationKeyResolver.resolveKey() is null");
      return false;
    }
    paramJwtContext.a(localKey);
    return paramJwtContext.a();
  }
  
  private JwtContext b(String paramString)
  {
    Object localObject2 = JsonWebSignature.a(paramString);
    Object localObject1 = null;
    if (localObject2 == null)
    {
      QLog.e("JwtConsumer", 1, "format jwt token error");
      return null;
    }
    localObject2 = new JwtContext(paramString, (JsonWebSignature)localObject2);
    paramString = localObject1;
    if (a((JwtContext)localObject2)) {
      paramString = (String)localObject2;
    }
    return paramString;
  }
  
  public String a(String paramString)
  {
    paramString = b(paramString);
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
    return paramString.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.jwt.JwtConsumer
 * JD-Core Version:    0.7.0.1
 */