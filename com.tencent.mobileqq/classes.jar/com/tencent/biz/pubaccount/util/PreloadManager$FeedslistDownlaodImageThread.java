package com.tencent.biz.pubaccount.util;

import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import sex;

class PreloadManager$FeedslistDownlaodImageThread
  implements Runnable
{
  PreloadManager$FeedslistDownlaodImageThread(PreloadManager paramPreloadManager) {}
  
  sex a()
  {
    Object localObject1 = this.this$0.a;
    int i = 3;
    while (i > 0)
    {
      try
      {
        sex localsex;
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
          localsex = (sex)((Iterator)localObject3).next();
          if (localsex == null) {
            return null;
          }
        } while ((PreloadManager.a(localsex.jdField_a_of_type_JavaLangString) != 0) || (localsex.jdField_a_of_type_Int != i));
        return localsex;
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
      sex localsex = a();
      if (localsex == null) {
        break;
      }
      if (NetworkState.getNetworkType() != 1) {
        return;
      }
      this.this$0.b(localsex.jdField_a_of_type_JavaLangString);
    }
    this.this$0.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager.FeedslistDownlaodImageThread
 * JD-Core Version:    0.7.0.1
 */