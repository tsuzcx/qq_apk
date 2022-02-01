package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import vls;
import vma;
import vmp;
import vmt;
import vnb;
import vux;

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
        if ((this.this$0.jdField_a_of_type_Vnb != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.this$0.jdField_a_of_type_Vnb.a(this.this$0.a());
        }
        ??? = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.this$0.jdField_a_of_type_Vmp = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        vmp localvmp1 = this.this$0.jdField_a_of_type_Vmp;
        if (localvmp1 != null)
        {
          localvmp1.c = ((PreloadQueue)???).getId();
          for (;;)
          {
            Iterator localIterator;
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              vmt localvmt = (vmt)((WeakReference)localIterator.next()).get();
              if (localvmt != null) {
                localvmt.a(localvmp1.jdField_b_of_type_JavaLangString, localvmp1.jdField_a_of_type_Int, localvmp1);
              }
            }
            localIterator.remove();
          }
          localvmp2.jdField_b_of_type_Int = 1;
          if (TextUtils.isEmpty(localvmp2.d))
          {
            ??? = ((vls)vux.a(28)).a(localvmp2.jdField_b_of_type_JavaLangString, localvmp2.jdField_a_of_type_Int);
            localvmp2.d = ((vma)???).jdField_b_of_type_JavaLangString;
            localvmp2.jdField_a_of_type_Boolean = ((vma)???).jdField_a_of_type_Boolean;
            localvmp2.f = ((vma)???).c;
            this.this$0.b(localvmp2);
          }
          else
          {
            this.this$0.b(localvmp2);
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