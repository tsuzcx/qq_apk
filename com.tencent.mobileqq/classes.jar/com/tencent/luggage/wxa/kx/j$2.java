package com.tencent.luggage.wxa.kx;

import android.os.Message;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.pg.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ra.b;

class j$2
  extends b
{
  j$2(j paramj) {}
  
  public void a()
  {
    super.a();
    o.d("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateListening");
    ((a)e.a(a.class)).registerLocation("gcj02", j.b(this.a), j.c(this.a));
    j.a(this.a, true);
    this.a.e("StateListening");
  }
  
  public boolean a(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      paramMessage = this.a;
      j.c(paramMessage, j.d(paramMessage));
      return true;
    }
    if (3 == paramMessage.what)
    {
      paramMessage = this.a;
      j.d(paramMessage, j.e(paramMessage));
      return true;
    }
    return super.a(paramMessage);
  }
  
  public void b()
  {
    super.b();
    ((a)e.a(a.class)).unregisterLocation("gcj02", j.b(this.a), j.c(this.a));
    j.a(this.a, false);
    this.a.e("StateNotListening");
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.q());
    localStringBuilder.append("$");
    localStringBuilder.append("StateNotListening");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.j.2
 * JD-Core Version:    0.7.0.1
 */