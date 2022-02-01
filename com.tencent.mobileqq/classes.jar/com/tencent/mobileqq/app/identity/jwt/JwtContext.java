package com.tencent.mobileqq.app.identity.jwt;

public class JwtContext
{
  private String a;
  private JsonWebSignature b;
  
  public JwtContext(String paramString, JsonWebSignature paramJsonWebSignature)
  {
    this.a = paramString;
    this.b = paramJsonWebSignature;
  }
  
  public JsonWebSignature a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.jwt.JwtContext
 * JD-Core Version:    0.7.0.1
 */