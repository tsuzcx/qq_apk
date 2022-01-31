package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import sto;
import stw;
import sul;
import sup;
import sux;
import tdc;

class PreloadDownloader$DownloadRunnable
  implements Runnable
{
  public volatile boolean a;
  
  private PreloadDownloader$DownloadRunnable(PreloadDownloader paramPreloadDownloader)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue == null)
      {
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      else
      {
        if ((this.this$0.jdField_a_of_type_Sux != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.this$0.jdField_a_of_type_Sux.a(this.this$0.a());
        }
        ??? = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.this$0.jdField_a_of_type_Sul = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        sul localsul1 = this.this$0.jdField_a_of_type_Sul;
        if (localsul1 != null)
        {
          localsul1.c = ((PreloadQueue)???).getId();
          for (;;)
          {
            Iterator localIterator;
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              sup localsup = (sup)((WeakReference)localIterator.next()).get();
              if (localsup != null) {
                localsup.a(localsul1.jdField_b_of_type_JavaLangString, localsul1.jdField_a_of_type_Int, localsul1);
              }
            }
            localIterator.remove();
          }
          localsul2.jdField_b_of_type_Int = 1;
          if (TextUtils.isEmpty(localsul2.d))
          {
            ??? = ((sto)tdc.a(28)).a(localsul2.jdField_b_of_type_JavaLangString, localsul2.jdField_a_of_type_Int);
            localsul2.d = ((stw)???).jdField_b_of_type_JavaLangString;
            localsul2.jdField_a_of_type_Boolean = ((stw)???).jdField_a_of_type_Boolean;
            localsul2.f = ((stw)???).c;
            this.this$0.b(localsul2);
          }
          else
          {
            this.this$0.b(localsul2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloader.DownloadRunnable
 * JD-Core Version:    0.7.0.1
 */