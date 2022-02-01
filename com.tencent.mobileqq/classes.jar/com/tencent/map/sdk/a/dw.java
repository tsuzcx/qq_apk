package com.tencent.map.sdk.a;

public final class dw
  extends dt
{
  public final em<String, dt> a = new em();
  
  public final dt a(String paramString)
  {
    paramString = this.a.a(paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.getValue()) {
      return (dt)paramString;
    }
  }
  
  public final void a(String paramString, dt paramdt)
  {
    Object localObject = paramdt;
    if (paramdt == null) {
      localObject = dv.a;
    }
    this.a.a(paramString, localObject);
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof dw)) && (((dw)paramObject).a.equals(this.a)));
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.dw
 * JD-Core Version:    0.7.0.1
 */