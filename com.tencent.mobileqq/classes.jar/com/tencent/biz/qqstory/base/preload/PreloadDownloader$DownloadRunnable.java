package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import stl;
import stt;
import sui;
import sum;
import suu;
import tcz;

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
        if ((this.this$0.jdField_a_of_type_Suu != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.this$0.jdField_a_of_type_Suu.a(this.this$0.a());
        }
        ??? = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.this$0.jdField_a_of_type_Sui = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        sui localsui1 = this.this$0.jdField_a_of_type_Sui;
        if (localsui1 != null)
        {
          localsui1.c = ((PreloadQueue)???).getId();
          for (;;)
          {
            Iterator localIterator;
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              sum localsum = (sum)((WeakReference)localIterator.next()).get();
              if (localsum != null) {
                localsum.a(localsui1.jdField_b_of_type_JavaLangString, localsui1.jdField_a_of_type_Int, localsui1);
              }
            }
            localIterator.remove();
          }
          localsui2.jdField_b_of_type_Int = 1;
          if (TextUtils.isEmpty(localsui2.d))
          {
            ??? = ((stl)tcz.a(28)).a(localsui2.jdField_b_of_type_JavaLangString, localsui2.jdField_a_of_type_Int);
            localsui2.d = ((stt)???).jdField_b_of_type_JavaLangString;
            localsui2.jdField_a_of_type_Boolean = ((stt)???).jdField_a_of_type_Boolean;
            localsui2.f = ((stt)???).c;
            this.this$0.b(localsui2);
          }
          else
          {
            this.this$0.b(localsui2);
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