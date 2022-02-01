package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import wfy;
import wgg;
import wgv;
import wgz;
import whh;
import wpm;

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
        if ((this.this$0.jdField_a_of_type_Whh != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.this$0.jdField_a_of_type_Whh.a(this.this$0.a());
        }
        ??? = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.this$0.jdField_a_of_type_Wgv = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        wgv localwgv1 = this.this$0.jdField_a_of_type_Wgv;
        if (localwgv1 != null)
        {
          localwgv1.c = ((PreloadQueue)???).getId();
          for (;;)
          {
            Iterator localIterator;
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              wgz localwgz = (wgz)((WeakReference)localIterator.next()).get();
              if (localwgz != null) {
                localwgz.a(localwgv1.jdField_b_of_type_JavaLangString, localwgv1.jdField_a_of_type_Int, localwgv1);
              }
            }
            localIterator.remove();
          }
          localwgv2.jdField_b_of_type_Int = 1;
          if (TextUtils.isEmpty(localwgv2.d))
          {
            ??? = ((wfy)wpm.a(28)).a(localwgv2.jdField_b_of_type_JavaLangString, localwgv2.jdField_a_of_type_Int);
            localwgv2.d = ((wgg)???).jdField_b_of_type_JavaLangString;
            localwgv2.jdField_a_of_type_Boolean = ((wgg)???).jdField_a_of_type_Boolean;
            localwgv2.f = ((wgg)???).c;
            this.this$0.b(localwgv2);
          }
          else
          {
            this.this$0.b(localwgv2);
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