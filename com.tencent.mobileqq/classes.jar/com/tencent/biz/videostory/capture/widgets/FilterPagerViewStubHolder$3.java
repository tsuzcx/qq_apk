package com.tencent.biz.videostory.capture.widgets;

import bhfm;
import bhgs;
import bjad;
import bjae;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import wwj;

public class FilterPagerViewStubHolder$3
  implements Runnable
{
  public FilterPagerViewStubHolder$3(wwj paramwwj, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ((bhgs)bhfm.a(5)).a;
    VideoFilterViewPager localVideoFilterViewPager = wwj.a(this.this$0);
    if ((localVideoFilterViewPager != null) && (localObject != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - comboFilterData not null");
      }
      localVideoFilterViewPager.setCaptureScene(0);
      localObject = ((bjad)localObject).a(0);
      if (localObject != null) {
        localVideoFilterViewPager.a(((bjae)localObject).c);
      }
      if (!this.a) {
        wwj.a(this.this$0).a(0);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      wwj.a(this.this$0).a();
      return;
    }
    QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - filterPager is null or comboFilterData is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.FilterPagerViewStubHolder.3
 * JD-Core Version:    0.7.0.1
 */