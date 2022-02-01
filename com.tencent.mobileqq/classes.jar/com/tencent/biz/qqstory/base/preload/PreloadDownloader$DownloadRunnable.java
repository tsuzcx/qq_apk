package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import wan;
import wav;
import wbk;
import wbo;
import wbw;
import wjs;

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
        if ((this.this$0.jdField_a_of_type_Wbw != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.this$0.jdField_a_of_type_Wbw.a(this.this$0.a());
        }
        ??? = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.this$0.jdField_a_of_type_Wbk = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        wbk localwbk1 = this.this$0.jdField_a_of_type_Wbk;
        if (localwbk1 != null)
        {
          localwbk1.c = ((PreloadQueue)???).getId();
          for (;;)
          {
            Iterator localIterator;
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              wbo localwbo = (wbo)((WeakReference)localIterator.next()).get();
              if (localwbo != null) {
                localwbo.a(localwbk1.jdField_b_of_type_JavaLangString, localwbk1.jdField_a_of_type_Int, localwbk1);
              }
            }
            localIterator.remove();
          }
          localwbk2.jdField_b_of_type_Int = 1;
          if (TextUtils.isEmpty(localwbk2.d))
          {
            ??? = ((wan)wjs.a(28)).a(localwbk2.jdField_b_of_type_JavaLangString, localwbk2.jdField_a_of_type_Int);
            localwbk2.d = ((wav)???).jdField_b_of_type_JavaLangString;
            localwbk2.jdField_a_of_type_Boolean = ((wav)???).jdField_a_of_type_Boolean;
            localwbk2.f = ((wav)???).c;
            this.this$0.b(localwbk2);
          }
          else
          {
            this.this$0.b(localwbk2);
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