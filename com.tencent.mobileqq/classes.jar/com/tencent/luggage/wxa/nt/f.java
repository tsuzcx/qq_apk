package com.tencent.luggage.wxa.nt;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class f
  extends c
{
  protected i a;
  private OutputStream b;
  
  private void a(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.b != null) {
        this.b.write(paramArrayOfByte);
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private boolean a(String paramString)
  {
    try
    {
      this.a = new i(paramString);
      if (this.a.j()) {
        this.a.w();
      }
      this.a.v();
      this.b = new DataOutputStream(k.b(paramString));
      return true;
    }
    catch (Exception paramString)
    {
      o.h("Luggage.PCMAudioEncoder", "", new Object[] { paramString });
    }
    return false;
  }
  
  private void c()
  {
    OutputStream localOutputStream = this.b;
    if (localOutputStream != null) {}
    try
    {
      localOutputStream.flush();
      this.b.close();
      label20:
      this.b = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label20;
    }
  }
  
  public void a()
  {
    a(new byte[0], 0, true);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramString);
    return true;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte, paramInt, paramBoolean);
    a(paramArrayOfByte);
    return true;
  }
  
  public void b()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nt.f
 * JD-Core Version:    0.7.0.1
 */