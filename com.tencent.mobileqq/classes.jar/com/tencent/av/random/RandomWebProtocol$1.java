package com.tencent.av.random;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import lvh;
import lvp;

class RandomWebProtocol$1
  extends Thread
{
  RandomWebProtocol$1(RandomWebProtocol paramRandomWebProtocol, String paramString1, String paramString2) {}
  
  public void run()
  {
    lvp locallvp = new lvp(this.this$0);
    if ((!TextUtils.isEmpty(this.a)) && (!TextUtils.equals(this.a, "null"))) {
      locallvp.a = this.this$0.a(this.b, this.a);
    }
    if (locallvp.a != null) {}
    for (int i = 0;; i = -1)
    {
      Iterator localIterator = this.this$0.a.iterator();
      while (localIterator.hasNext()) {
        ((lvh)localIterator.next()).a(i, locallvp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.1
 * JD-Core Version:    0.7.0.1
 */