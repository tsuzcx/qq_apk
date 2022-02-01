package com.tencent.luggage.wxa.kx;

import android.os.Message;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.pg.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ra.b;

class j$1
  extends b
{
  j$1(j paramj) {}
  
  public void a()
  {
    super.a();
    o.d("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateNotListening");
    ((a)e.a(a.class)).unregisterLocation("gcj02", j.b(this.a), j.c(this.a));
    j.a(this.a, false);
    this.a.e("StateNotListening");
  }
  
  public boolean a(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      paramMessage = this.a;
      j.a(paramMessage, j.a(paramMessage));
      return true;
    }
    if (4 == paramMessage.what)
    {
      paramMessage = this.a;
      j.b(paramMessage, j.a(paramMessage));
      return true;
    }
    return super.a(paramMessage);
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.q());
    localStringBuilder.append("$");
    localStringBuilder.append("StateListening");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.j.1
 * JD-Core Version:    0.7.0.1
 */