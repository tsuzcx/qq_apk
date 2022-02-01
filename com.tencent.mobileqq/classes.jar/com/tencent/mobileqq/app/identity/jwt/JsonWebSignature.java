package com.tencent.mobileqq.app.identity.jwt;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.Key;
import java.security.interfaces.RSAKey;

class JsonWebSignature
{
  private String jdField_a_of_type_JavaLangString;
  private Key jdField_a_of_type_JavaSecurityKey;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public static JsonWebSignature a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JsonWebSignature", 1, "token is null");
      return null;
    }
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length != 3)
    {
      QLog.e("JsonWebSignature", 1, new Object[] { "jwt token illegal, length is ", Integer.valueOf(arrayOfString.length) });
      return null;
    }
    JsonWebSignature localJsonWebSignature = new JsonWebSignature();
    localJsonWebSignature.jdField_a_of_type_JavaLangString = paramString;
    localJsonWebSignature.b = arrayOfString[0];
    localJsonWebSignature.c = new String(Base64.decode(arrayOfString[0], 11));
    localJsonWebSignature.d = arrayOfString[1];
    localJsonWebSignature.e = new String(Base64.decode(arrayOfString[1], 11));
    localJsonWebSignature.f = arrayOfString[2];
    return localJsonWebSignature;
  }
  
  public static String a(String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      String str;
      if (paramVarArgs[i] == null) {
        str = "";
      } else {
        str = paramVarArgs[i];
      }
      localStringBuilder.append(str);
      if (i != paramVarArgs.length - 1) {
        localStringBuilder.append(".");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private byte[] a()
  {
    Object localObject = a(new String[] { this.b, this.d });
    try
    {
      localObject = ((String)localObject).getBytes("US-ASCII");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label31:
      break label31;
    }
    return null;
  }
  
  public String a()
  {
    return this.e;
  }
  
  public void a(Key paramKey)
  {
    this.jdField_a_of_type_JavaSecurityKey = paramKey;
  }
  
  public boolean a()
  {
    RsaUsingShaAlgorithm localRsaUsingShaAlgorithm = new RsaUsingShaAlgorithm();
    Object localObject = this.jdField_a_of_type_JavaSecurityKey;
    if (((localObject instanceof RSAKey)) && (((RSAKey)localObject).getModulus().bitLength() < 2048)) {
      return false;
    }
    localObject = Base64.decode(this.f, 11);
    byte[] arrayOfByte = a();
    return localRsaUsingShaAlgorithm.a((byte[])localObject, this.jdField_a_of_type_JavaSecurityKey, arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.jwt.JsonWebSignature
 * JD-Core Version:    0.7.0.1
 */