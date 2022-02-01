package com.tencent.luggage.wxa.jr;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class f
{
  public b b;
  @Nullable
  public Map<String, a> c;
  
  public f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b = new b();
      this.c = new HashMap();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPnPMessage{headers=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", bodes=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jr.f
 * JD-Core Version:    0.7.0.1
 */