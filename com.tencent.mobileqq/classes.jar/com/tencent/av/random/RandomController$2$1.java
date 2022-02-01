package com.tencent.av.random;

import java.util.Iterator;
import java.util.List;

class RandomController$2$1
  implements Runnable
{
  RandomController$2$1(RandomController.2 param2) {}
  
  public void run()
  {
    Iterator localIterator = RandomController.a(this.a.a).iterator();
    while (localIterator.hasNext()) {
      ((RandomController.RandomListener)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomController.2.1
 * JD-Core Version:    0.7.0.1
 */