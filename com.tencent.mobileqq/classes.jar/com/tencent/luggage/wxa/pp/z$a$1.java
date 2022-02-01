package com.tencent.luggage.wxa.pp;

import com.tencent.luggage.wxa.qz.o;

class z$a$1
  implements Runnable
{
  z$a$1(z.a parama, boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.a) {
      this.e.b.b(this.b);
    } else {
      this.e.b.setText(this.b);
    }
    try
    {
      this.e.b.setSelection(Math.min(this.c + this.d, this.b.length()));
      return;
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", new Object[] { localException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.z.a.1
 * JD-Core Version:    0.7.0.1
 */