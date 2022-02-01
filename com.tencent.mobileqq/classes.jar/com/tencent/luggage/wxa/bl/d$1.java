package com.tencent.luggage.wxa.bl;

import com.tencent.luggage.wxa.gi.b.a;
import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.qz.o;

final class d$1
  implements b.a
{
  public void a(String paramString)
  {
    try
    {
      o.d("MicroMsg.MBLoadDelegateRegistry", "loadLibrary libName:%s", new Object[] { paramString });
      f.a(paramString, d.class.getClassLoader());
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      o.a("MicroMsg.MBLoadDelegateRegistry", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramString });
      d.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bl.d.1
 * JD-Core Version:    0.7.0.1
 */