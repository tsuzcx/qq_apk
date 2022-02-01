package com.tencent.mobileqq.activity.recent.msgbox.config;

public class SessionKey
{
  public int a;
  public int b;
  
  public SessionKey(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SessionKey{c2CType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", serviceType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.config.SessionKey
 * JD-Core Version:    0.7.0.1
 */