package com.tencent.mars.cdn;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a
{
  private final int a;
  private final boolean b;
  private final List<X509Certificate> c;
  private final boolean d;
  
  public a(int paramInt)
  {
    this.a = paramInt;
    this.b = false;
    this.c = Collections.emptyList();
    this.d = false;
  }
  
  public a(int paramInt, boolean paramBoolean1, List<X509Certificate> paramList, boolean paramBoolean2)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = new ArrayList(paramList);
    this.d = paramBoolean2;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public byte[][] d()
  {
    byte[][] arrayOfByte = new byte[this.c.size()][];
    int i = 0;
    try
    {
      while (i < this.c.size())
      {
        arrayOfByte[i] = ((X509Certificate)this.c.get(i)).getEncoded();
        i += 1;
      }
      return arrayOfByte;
    }
    catch (CertificateEncodingException localCertificateEncodingException)
    {
      label56:
      break label56;
    }
    return new byte[0][];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.a
 * JD-Core Version:    0.7.0.1
 */