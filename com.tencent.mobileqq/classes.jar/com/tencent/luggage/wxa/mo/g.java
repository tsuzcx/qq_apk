package com.tencent.luggage.wxa.mo;

import com.tencent.luggage.wxa.jx.m.a;

public class g
  extends m.a
{
  public static final g c = new g("ok", new Object[0]);
  
  public g(String paramString, Object... paramVarArgs)
  {
    super(paramString, paramVarArgs);
  }
  
  public boolean a()
  {
    return "ok".equals(this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VoiceCallResult{errMsg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mo.g
 * JD-Core Version:    0.7.0.1
 */