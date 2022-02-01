package com.tencent.mobileqq.app.identity.jwt;

import java.security.Key;

public class SimpleKeyResolver
{
  private Key a;
  
  public SimpleKeyResolver(Key paramKey)
  {
    this.a = paramKey;
  }
  
  public Key a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.jwt.SimpleKeyResolver
 * JD-Core Version:    0.7.0.1
 */