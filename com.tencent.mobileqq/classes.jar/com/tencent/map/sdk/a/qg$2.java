package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.Set;

final class qg$2
  implements Runnable
{
  qg$2(qg paramqg, boolean paramBoolean, String paramString, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    try
    {
      Iterator localIterator = this.d.c.iterator();
      while (localIterator.hasNext())
      {
        qf localqf = (qf)localIterator.next();
        if (this.a) {
          localqf.a(this.b);
        } else if (this.c == null) {
          localqf.b(this.b);
        }
        localqf.a(this.b, this.c);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.qg.2
 * JD-Core Version:    0.7.0.1
 */