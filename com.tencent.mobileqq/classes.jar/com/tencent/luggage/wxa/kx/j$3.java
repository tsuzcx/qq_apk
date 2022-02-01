package com.tencent.luggage.wxa.kx;

import android.os.Message;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ra.b;

class j$3
  extends b
{
  j$3(j paramj) {}
  
  public void a()
  {
    super.a();
    o.d("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateSuspend");
    this.a.e("StateSuspend");
  }
  
  public boolean a(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      paramMessage = this.a;
      j.e(paramMessage, j.d(paramMessage));
      return true;
    }
    if (4 == paramMessage.what)
    {
      paramMessage = this.a;
      j.f(paramMessage, j.a(paramMessage));
      return true;
    }
    return super.a(paramMessage);
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.q());
    localStringBuilder.append("$");
    localStringBuilder.append("StateSuspend");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.j.3
 * JD-Core Version:    0.7.0.1
 */