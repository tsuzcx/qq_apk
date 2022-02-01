package com.tencent.luggage.wxa.hq;

import android.os.IBinder.DeathRecipient;

public class a
  implements IBinder.DeathRecipient
{
  private final String a;
  
  public a(String paramString)
  {
    this.a = paramString;
  }
  
  public void binderDied()
  {
    com.tencent.luggage.wxa.hs.b.a("IPC.DeathRecipientImpl", "binderDied(%s)", new Object[] { this.a });
    String str = this.a;
    if (str != null)
    {
      if (str.length() == 0) {
        return;
      }
      b.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hq.a
 * JD-Core Version:    0.7.0.1
 */