package com.tencent.luggage.wxa.qz;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

public class y
{
  private static boolean a;
  private TelephonyManager b;
  private PhoneStateListener c;
  private List<y.a> d = new LinkedList();
  
  public static boolean b()
  {
    o.d("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", new Object[] { Boolean.valueOf(a) });
    return a;
  }
  
  public void a()
  {
    this.d.clear();
  }
  
  public void a(Context paramContext)
  {
    o.d("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
    if (this.b == null) {
      this.b = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
    if (this.c == null) {
      this.c = new y.1(this);
    }
    this.b.listen(this.c, 32);
  }
  
  public void a(y.a parama)
  {
    this.d.add(parama);
  }
  
  public void c()
  {
    o.d("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
    TelephonyManager localTelephonyManager = this.b;
    if (localTelephonyManager != null)
    {
      localTelephonyManager.listen(this.c, 0);
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.y
 * JD-Core Version:    0.7.0.1
 */