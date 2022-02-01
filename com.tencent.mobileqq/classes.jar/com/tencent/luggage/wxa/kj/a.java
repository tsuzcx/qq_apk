package com.tencent.luggage.wxa.kj;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.ki.d;
import com.tencent.luggage.wxa.kl.j;

@TargetApi(18)
public class a
  extends com.tencent.luggage.wxa.kl.a
{
  public void a()
  {
    if (this.f.c() == null)
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "connection is not open.", new Object[0]);
      b(j.i);
      d();
      return;
    }
    this.f.a(true);
    b(j.a);
    d();
  }
  
  public String b()
  {
    return "CloseAction";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kj.a
 * JD-Core Version:    0.7.0.1
 */