package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ot.a;
import com.tencent.luggage.wxa.ot.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import java.util.ArrayList;

class d$1
  implements WcwssNative.IWcWssReportListener
{
  d$1(d paramd) {}
  
  public int getNetworkType()
  {
    return d.a();
  }
  
  public void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    o.e("Luggage.WcWssNativeInstallHelper", "MMWcWss onIdKeyStat");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt1.length)
    {
      localArrayList.add(new a(paramArrayOfInt1[i], paramArrayOfInt2[i], paramArrayOfInt3[i]));
      i += 1;
    }
    ((c)e.b(c.class)).a(localArrayList, false);
  }
  
  public void onKvStat(int paramInt, String paramString)
  {
    o.e("Luggage.WcWssNativeInstallHelper", "MMWcWss onKvStat logId:%d", new Object[] { Integer.valueOf(paramInt) });
    ((com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class)).a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.d.1
 * JD-Core Version:    0.7.0.1
 */