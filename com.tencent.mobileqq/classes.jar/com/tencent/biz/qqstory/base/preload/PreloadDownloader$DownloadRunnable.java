package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import uid;
import uil;
import uja;
import uje;
import ujm;
import urr;

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
        if ((this.this$0.jdField_a_of_type_Ujm != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.this$0.jdField_a_of_type_Ujm.a(this.this$0.a());
        }
        ??? = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.this$0.jdField_a_of_type_Uja = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        uja localuja1 = this.this$0.jdField_a_of_type_Uja;
        if (localuja1 != null)
        {
          localuja1.c = ((PreloadQueue)???).getId();
          for (;;)
          {
            Iterator localIterator;
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              uje localuje = (uje)((WeakReference)localIterator.next()).get();
              if (localuje != null) {
                localuje.a(localuja1.jdField_b_of_type_JavaLangString, localuja1.jdField_a_of_type_Int, localuja1);
              }
            }
            localIterator.remove();
          }
          localuja2.jdField_b_of_type_Int = 1;
          if (TextUtils.isEmpty(localuja2.d))
          {
            ??? = ((uid)urr.a(28)).a(localuja2.jdField_b_of_type_JavaLangString, localuja2.jdField_a_of_type_Int);
            localuja2.d = ((uil)???).jdField_b_of_type_JavaLangString;
            localuja2.jdField_a_of_type_Boolean = ((uil)???).jdField_a_of_type_Boolean;
            localuja2.f = ((uil)???).c;
            this.this$0.b(localuja2);
          }
          else
          {
            this.this$0.b(localuja2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloader.DownloadRunnable
 * JD-Core Version:    0.7.0.1
 */