package com.tencent.av.random;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import ltf;
import ltn;

class RandomWebProtocol$1
  extends Thread
{
  RandomWebProtocol$1(RandomWebProtocol paramRandomWebProtocol, String paramString1, String paramString2) {}
  
  public void run()
  {
    ltn localltn = new ltn(this.this$0);
    if ((!TextUtils.isEmpty(this.a)) && (!TextUtils.equals(this.a, "null"))) {
      localltn.a = this.this$0.a(this.b, this.a);
    }
    if (localltn.a != null) {}
    for (int i = 0;; i = -1)
    {
      Iterator localIterator = this.this$0.a.iterator();
      while (localIterator.hasNext()) {
        ((ltf)localIterator.next()).a(i, localltn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.1
 * JD-Core Version:    0.7.0.1
 */