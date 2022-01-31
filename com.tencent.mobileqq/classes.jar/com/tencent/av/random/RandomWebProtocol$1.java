package com.tencent.av.random;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import lta;
import lti;

class RandomWebProtocol$1
  extends Thread
{
  RandomWebProtocol$1(RandomWebProtocol paramRandomWebProtocol, String paramString1, String paramString2) {}
  
  public void run()
  {
    lti locallti = new lti(this.this$0);
    if ((!TextUtils.isEmpty(this.a)) && (!TextUtils.equals(this.a, "null"))) {
      locallti.a = this.this$0.a(this.b, this.a);
    }
    if (locallti.a != null) {}
    for (int i = 0;; i = -1)
    {
      Iterator localIterator = this.this$0.a.iterator();
      while (localIterator.hasNext()) {
        ((lta)localIterator.next()).a(i, locallti);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.1
 * JD-Core Version:    0.7.0.1
 */