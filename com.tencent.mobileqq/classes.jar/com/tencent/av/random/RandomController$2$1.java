package com.tencent.av.random;

import java.util.Iterator;
import java.util.List;
import lsi;
import lsm;

public class RandomController$2$1
  implements Runnable
{
  public RandomController$2$1(lsi paramlsi) {}
  
  public void run()
  {
    Iterator localIterator = RandomController.a(this.a.a).iterator();
    while (localIterator.hasNext()) {
      ((lsm)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomController.2.1
 * JD-Core Version:    0.7.0.1
 */