package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import sgs;
import sha;
import shp;
import sht;
import sib;
import sqg;

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
        if ((this.this$0.jdField_a_of_type_Sib != null) && (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue.isBusy())) {
          this.this$0.jdField_a_of_type_Sib.a(this.this$0.a());
        }
        ??? = this.this$0.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadQueue;
        this.this$0.jdField_a_of_type_Shp = ((PreloadQueue)???).getFirstAndBlockIfLowestPriority();
        shp localshp1 = this.this$0.jdField_a_of_type_Shp;
        if (localshp1 != null)
        {
          localshp1.c = ((PreloadQueue)???).getId();
          for (;;)
          {
            Iterator localIterator;
            synchronized (PreloadDownloader.jdField_a_of_type_JavaLangObject)
            {
              localIterator = this.this$0.jdField_a_of_type_JavaUtilList.iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              sht localsht = (sht)((WeakReference)localIterator.next()).get();
              if (localsht != null) {
                localsht.a(localshp1.jdField_b_of_type_JavaLangString, localshp1.jdField_a_of_type_Int, localshp1);
              }
            }
            localIterator.remove();
          }
          localshp2.jdField_b_of_type_Int = 1;
          if (TextUtils.isEmpty(localshp2.d))
          {
            ??? = ((sgs)sqg.a(28)).a(localshp2.jdField_b_of_type_JavaLangString, localshp2.jdField_a_of_type_Int);
            localshp2.d = ((sha)???).jdField_b_of_type_JavaLangString;
            localshp2.jdField_a_of_type_Boolean = ((sha)???).jdField_a_of_type_Boolean;
            localshp2.f = ((sha)???).c;
            this.this$0.b(localshp2);
          }
          else
          {
            this.this$0.b(localshp2);
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