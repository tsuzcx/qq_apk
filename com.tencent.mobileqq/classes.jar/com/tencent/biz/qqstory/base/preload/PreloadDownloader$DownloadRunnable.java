package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import wjt;
import wkb;
import wkq;
import wku;
import wlc;
import wth;

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
        if ((this.this$0.jdField_a_of_type_Wlc != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.this$0.jdField_a_of_type_Wlc.a(this.this$0.a());
        }
        ??? = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.this$0.jdField_a_of_type_Wkq = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        wkq localwkq1 = this.this$0.jdField_a_of_type_Wkq;
        if (localwkq1 != null)
        {
          localwkq1.c = ((PreloadQueue)???).getId();
          for (;;)
          {
            Iterator localIterator;
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              wku localwku = (wku)((WeakReference)localIterator.next()).get();
              if (localwku != null) {
                localwku.a(localwkq1.jdField_b_of_type_JavaLangString, localwkq1.jdField_a_of_type_Int, localwkq1);
              }
            }
            localIterator.remove();
          }
          localwkq2.jdField_b_of_type_Int = 1;
          if (TextUtils.isEmpty(localwkq2.d))
          {
            ??? = ((wjt)wth.a(28)).a(localwkq2.jdField_b_of_type_JavaLangString, localwkq2.jdField_a_of_type_Int);
            localwkq2.d = ((wkb)???).jdField_b_of_type_JavaLangString;
            localwkq2.jdField_a_of_type_Boolean = ((wkb)???).jdField_a_of_type_Boolean;
            localwkq2.f = ((wkb)???).c;
            this.this$0.b(localwkq2);
          }
          else
          {
            this.this$0.b(localwkq2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloader.DownloadRunnable
 * JD-Core Version:    0.7.0.1
 */