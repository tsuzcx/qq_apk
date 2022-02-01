package com.tencent.luggage.wxa.am;

import java.io.IOException;

public class s$c
  extends IOException
{
  public final int a;
  public final j b;
  
  public s$c(IOException paramIOException, j paramj, int paramInt)
  {
    super(paramIOException);
    this.b = paramj;
    this.a = paramInt;
  }
  
  public s$c(String paramString, j paramj, int paramInt)
  {
    super(paramString);
    this.b = paramj;
    this.a = paramInt;
  }
  
  public s$c(String paramString, IOException paramIOException, j paramj, int paramInt)
  {
    super(paramString, paramIOException);
    this.b = paramj;
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.s.c
 * JD-Core Version:    0.7.0.1
 */