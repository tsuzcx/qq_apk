package com.tencent.biz.pubaccount.util;

import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import swo;

class PreloadManager$FeedslistDownlaodImageThread
  implements Runnable
{
  PreloadManager$FeedslistDownlaodImageThread(PreloadManager paramPreloadManager) {}
  
  swo a()
  {
    Object localObject1 = this.this$0.a;
    int i = 3;
    while (i > 0)
    {
      try
      {
        swo localswo;
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
          localswo = (swo)((Iterator)localObject3).next();
          if (localswo == null) {
            return null;
          }
        } while ((PreloadManager.a(localswo.jdField_a_of_type_JavaLangString) != 0) || (localswo.jdField_a_of_type_Int != i));
        return localswo;
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
      swo localswo = a();
      if (localswo == null) {
        break;
      }
      if (NetworkState.getNetworkType() != 1) {
        return;
      }
      this.this$0.b(localswo.jdField_a_of_type_JavaLangString);
    }
    this.this$0.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager.FeedslistDownlaodImageThread
 * JD-Core Version:    0.7.0.1
 */