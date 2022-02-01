package com.tencent.biz.pubaccount.util;

import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class PreloadManager$FeedslistDownlaodImageThread
  implements Runnable
{
  PreloadManager$FeedslistDownlaodImageThread(PreloadManager paramPreloadManager) {}
  
  PreloadManager.ImgStruct a()
  {
    Object localObject1 = this.this$0.d;
    int i = 3;
    label150:
    for (;;)
    {
      if (i > 0) {}
      try
      {
        PreloadManager.ImgStruct localImgStruct;
        do
        {
          Iterator localIterator = PreloadManager.d(this.this$0).values().iterator();
          Object localObject3;
          while (!((Iterator)localObject3).hasNext())
          {
            if (!localIterator.hasNext()) {
              break label150;
            }
            localObject3 = (ArrayList)localIterator.next();
            if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0)) {
              break;
            }
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localImgStruct = (PreloadManager.ImgStruct)((Iterator)localObject3).next();
          if (localImgStruct == null) {
            return null;
          }
        } while ((PreloadManager.c(localImgStruct.a) != 0) || (localImgStruct.b != i));
        return localImgStruct;
        return null;
      }
      finally
      {
        for (;;)
        {
          throw localObject2;
        }
        i -= 1;
      }
      return null;
    }
  }
  
  public void run()
  {
    this.this$0.c = true;
    for (;;)
    {
      PreloadManager.ImgStruct localImgStruct = a();
      if (localImgStruct == null) {
        break;
      }
      if (NetworkState.getNetworkType() != 1) {
        return;
      }
      this.this$0.g(localImgStruct.a);
    }
    this.this$0.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager.FeedslistDownlaodImageThread
 * JD-Core Version:    0.7.0.1
 */