package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import umm;
import umu;
import unj;
import unn;
import unv;
import uwa;

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
        if ((this.this$0.jdField_a_of_type_Unv != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.this$0.jdField_a_of_type_Unv.a(this.this$0.a());
        }
        ??? = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.this$0.jdField_a_of_type_Unj = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        unj localunj1 = this.this$0.jdField_a_of_type_Unj;
        if (localunj1 != null)
        {
          localunj1.c = ((PreloadQueue)???).getId();
          for (;;)
          {
            Iterator localIterator;
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              unn localunn = (unn)((WeakReference)localIterator.next()).get();
              if (localunn != null) {
                localunn.a(localunj1.jdField_b_of_type_JavaLangString, localunj1.jdField_a_of_type_Int, localunj1);
              }
            }
            localIterator.remove();
          }
          localunj2.jdField_b_of_type_Int = 1;
          if (TextUtils.isEmpty(localunj2.d))
          {
            ??? = ((umm)uwa.a(28)).a(localunj2.jdField_b_of_type_JavaLangString, localunj2.jdField_a_of_type_Int);
            localunj2.d = ((umu)???).jdField_b_of_type_JavaLangString;
            localunj2.jdField_a_of_type_Boolean = ((umu)???).jdField_a_of_type_Boolean;
            localunj2.f = ((umu)???).c;
            this.this$0.b(localunj2);
          }
          else
          {
            this.this$0.b(localunj2);
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