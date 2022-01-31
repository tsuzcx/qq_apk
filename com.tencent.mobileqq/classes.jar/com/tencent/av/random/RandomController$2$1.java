package com.tencent.av.random;

import java.util.Iterator;
import java.util.List;
import lij;
import lin;

public class RandomController$2$1
  implements Runnable
{
  public RandomController$2$1(lij paramlij) {}
  
  public void run()
  {
    Iterator localIterator = RandomController.a(this.a.a).iterator();
    while (localIterator.hasNext()) {
      ((lin)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.random.RandomController.2.1
 * JD-Core Version:    0.7.0.1
 */