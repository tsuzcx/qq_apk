package com.tencent.luggage.wxa.iu;

import android.util.SparseArray;
import java.util.Set;

class d$15
  implements Runnable
{
  d$15(d paramd, p paramp) {}
  
  public void run()
  {
    Set localSet = (Set)d.n(this.b).get(this.a.b);
    if (localSet != null) {
      localSet.remove(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.15
 * JD-Core Version:    0.7.0.1
 */