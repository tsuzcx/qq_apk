package com.tencent.map.sdk.a;

public final class iw
  extends qe
{
  private iy a;
  
  public iw(iy paramiy)
  {
    this.a = paramiy;
  }
  
  public final byte[] a(String paramString)
  {
    if ((nl.a(paramString)) || (!paramString.startsWith("tileOverlay")) || (this.a == null)) {
      return null;
    }
    return this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.iw
 * JD-Core Version:    0.7.0.1
 */