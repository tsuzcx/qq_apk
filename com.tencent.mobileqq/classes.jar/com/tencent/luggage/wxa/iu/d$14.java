package com.tencent.luggage.wxa.iu;

import android.util.SparseArray;
import com.tencent.luggage.wxa.qz.o;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

class d$14
  implements Runnable
{
  d$14(d paramd, p paramp, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    o.d("MicroMsg.AppBrandRuntime", "addKeyEventObserver#scheduled");
    Object localObject = this.a;
    ((p)localObject).c = this.b;
    ((p)localObject).b = this.c;
    int i;
    if (d.n(this.d).get(this.a.b) != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject = (Set)d.n(this.d).get(this.a.b);
    } else {
      localObject = new CopyOnWriteArraySet();
    }
    ((Set)localObject).add(this.a);
    if (i == 0) {
      d.n(this.d).put(this.a.b, localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.14
 * JD-Core Version:    0.7.0.1
 */