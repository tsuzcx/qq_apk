package com.huawei.remoteLoader.client;

import android.annotation.TargetApi;
import java.util.Objects;

@TargetApi(19)
class a
{
  private final String a;
  private final String b;
  
  public a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        break;
      }
      paramObject = (a)paramObject;
    } while ((Objects.equals(this.a, paramObject.a)) && (Objects.equals(this.b, paramObject.b)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(this.a) * 37 + Objects.hashCode(this.b);
  }
  
  public String toString()
  {
    return "[packageName=" + a() + ",libraryName=[" + b() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.remoteLoader.client.a
 * JD-Core Version:    0.7.0.1
 */