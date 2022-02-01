package com.tencent.luggage.wxa.jj;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public final class a$e
{
  public final String a;
  public final String b;
  
  public a$e(String paramString, @NotNull JSONObject paramJSONObject)
  {
    this.a = paramString;
    this.b = paramJSONObject.getString("desc");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Permission{name='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.a.e
 * JD-Core Version:    0.7.0.1
 */