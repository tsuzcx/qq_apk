package com.tencent.av.random;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

class RandomWebProtocol$1
  extends Thread
{
  RandomWebProtocol$1(RandomWebProtocol paramRandomWebProtocol, String paramString1, String paramString2) {}
  
  public void run()
  {
    RandomWebProtocol.RspDoublePull localRspDoublePull = new RandomWebProtocol.RspDoublePull(this.this$0);
    if ((!TextUtils.isEmpty(this.a)) && (!TextUtils.equals(this.a, "null"))) {
      localRspDoublePull.a = this.this$0.a(this.b, this.a);
    }
    if (localRspDoublePull.a != null) {}
    for (int i = 0;; i = -1)
    {
      Iterator localIterator = this.this$0.a.iterator();
      while (localIterator.hasNext()) {
        ((RandomWebProtocol.OnRequestListener)localIterator.next()).a(i, localRspDoublePull);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.1
 * JD-Core Version:    0.7.0.1
 */