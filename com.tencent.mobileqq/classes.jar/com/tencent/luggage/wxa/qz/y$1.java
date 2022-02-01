package com.tencent.luggage.wxa.qz;

import android.telephony.PhoneStateListener;
import java.util.List;

class y$1
  extends PhoneStateListener
{
  y$1(y paramy) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    o.d("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (y.a(this.a).size() > 0)
    {
      y.a[] arrayOfa = new y.a[y.a(this.a).size()];
      arrayOfa = (y.a[])y.a(this.a).toArray(arrayOfa);
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].a(paramInt);
        i += 1;
      }
    }
    super.onCallStateChanged(paramInt, paramString);
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return;
      }
      y.a(true);
      return;
    }
    y.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.y.1
 * JD-Core Version:    0.7.0.1
 */