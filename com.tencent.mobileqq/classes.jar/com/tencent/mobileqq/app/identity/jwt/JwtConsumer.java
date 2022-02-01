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
  
  private JwtContext a(String paramString)
  {
    JsonWebSignature localJsonWebSignature = JsonWebSignature.a(paramString);
    if (localJsonWebSignature == null)
    {
      QLog.e("JwtConsumer", 1, "format jwt token error");
      return null;
    }
    paramString = new JwtContext(paramString, localJsonWebSignature);
    if (a(paramString)) {}
    for (;;)
    {
      return paramString;
      paramString = null;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.jwt.JwtConsumer
 * JD-Core Version:    0.7.0.1
 */