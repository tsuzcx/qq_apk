package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ot.c;
import com.tencent.luggage.wxa.ot.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener;
import java.util.ArrayList;

class a$2
  implements LockStepNative.ILockStepReportListener
{
  a$2(a parama) {}
  
  public int getNetworkType()
  {
    return a.a();
  }
  
  public void onIdKeyStat(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    o.e("Luggage.LockStepNativeInstallHelper", "mmudp onIdKeyStat");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt1.length)
    {
      localArrayList.add(new com.tencent.luggage.wxa.ot.a(paramArrayOfInt1[i], paramArrayOfInt2[i], paramArrayOfInt3[i]));
      i += 1;
    }
    ((c)e.b(c.class)).a(localArrayList, false);
  }
  
  public void onKvStat(int paramInt, String paramString)
  {
    o.e("Luggage.LockStepNativeInstallHelper", "mmudp onKvStat logId:%d", new Object[] { Integer.valueOf(paramInt) });
    ((d)e.b(d.class)).a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.a.2
 * JD-Core Version:    0.7.0.1
 */