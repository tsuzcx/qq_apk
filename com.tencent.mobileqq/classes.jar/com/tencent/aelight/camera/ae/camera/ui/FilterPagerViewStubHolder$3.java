package com.tencent.aelight.camera.ae.camera.ui;

import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.qphone.base.util.QLog;

class FilterPagerViewStubHolder$3
  implements Runnable
{
  FilterPagerViewStubHolder$3(FilterPagerViewStubHolder paramFilterPagerViewStubHolder, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ((CaptureComboManager)QIMManager.a(5)).a;
    VideoFilterViewPager localVideoFilterViewPager = FilterPagerViewStubHolder.a(this.this$0);
    if ((localVideoFilterViewPager != null) && (localObject != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - comboFilterData not null");
      }
      localVideoFilterViewPager.setCaptureScene(0);
      localObject = ((VideoFilterTools.ComboFilterData)localObject).a(0);
      if (localObject != null) {
        localVideoFilterViewPager.a(((VideoFilterTools.DataSet)localObject).c);
      }
      if (!this.a)
      {
        FilterPagerViewStubHolder.a(this.this$0).a(0);
        return;
      }
      FilterPagerViewStubHolder.a(this.this$0).a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - filterPager is null or comboFilterData is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder.3
 * JD-Core Version:    0.7.0.1
 */