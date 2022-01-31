package com.tencent.biz.pubaccount.util;

import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import seu;

class PreloadManager$FeedslistDownlaodImageThread
  implements Runnable
{
  PreloadManager$FeedslistDownlaodImageThread(PreloadManager paramPreloadManager) {}
  
  seu a()
  {
    Object localObject1 = this.this$0.a;
    int i = 3;
    while (i > 0)
    {
      try
      {
        seu localseu;
        do
        {
          Iterator localIterator = PreloadManager.a(this.this$0).values().iterator();
          Object localObject3;
          while (!((Iterator)localObject3).hasNext())
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject3 = (ArrayList)localIterator.next();
            if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0)) {
              return null;
            }
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localseu = (seu)((Iterator)localObject3).next();
          if (localseu == null) {
            return null;
          }
        } while ((PreloadManager.a(localseu.jdField_a_of_type_JavaLangString) != 0) || (localseu.jdField_a_of_type_Int != i));
        return localseu;
      }
      finally {}
      i -= 1;
    }
    return null;
  }
  
  public void run()
  {
    this.this$0.b = true;
    for (;;)
    {
      seu localseu = a();
      if (localseu == null) {
        break;
      }
      if (NetworkState.getNetworkType() != 1) {
        return;
      }
      this.this$0.b(localseu.jdField_a_of_type_JavaLangString);
    }
    this.this$0.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager.FeedslistDownlaodImageThread
 * JD-Core Version:    0.7.0.1
 */