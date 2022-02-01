package com.tencent.aelight.camera.aioeditor.takevideo;

import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.aelight.camera.aioeditor.takevideo.filter.FilterData;
import com.tencent.aelight.camera.aioeditor.takevideo.filter.FilterData.FilterPageItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;

class EditVideoSpeedFilter$FilterPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private EditVideoSpeedFilter$FilterPageChangeListener(EditVideoSpeedFilter paramEditVideoSpeedFilter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i = paramInt1 % this.a.k.a();
    Object localObject = this.a.k.a(i);
    paramInt2 = 0;
    if (localObject != null) {
      paramInt1 = ((FilterData)localObject).a;
    } else {
      paramInt1 = 0;
    }
    localObject = this.a.k.a((i + 1) % this.a.k.a());
    if (localObject != null) {
      paramInt2 = ((FilterData)localObject).a;
    }
    localObject = (EditVideoPlayerExport)this.a.b(EditVideoPlayerExport.class);
    if (localObject != null) {
      ((EditVideoPlayerExport)localObject).a(paramInt1, paramInt2, paramFloat);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.a.k.a(paramInt);
    int i;
    if (localObject != null) {
      i = ((FilterData)localObject).a;
    } else {
      i = 0;
    }
    this.a.l.put(this.a.t.m(), localObject);
    if ((i == 2) || (i == 1) || (i == 3) || (i == 0))
    {
      localObject = this.a.k.c(paramInt);
      if ((localObject != null) && (TextUtils.isEmpty(((FilterData.FilterPageItem)localObject).b.d))) {
        EditVideoSpeedFilter.a((FilterData.FilterPageItem)localObject);
      }
    }
    localObject = this.a.k.c(paramInt - 1);
    FilterData.FilterPageItem localFilterPageItem = this.a.k.c(paramInt + 1);
    if (localObject != null) {
      ((FilterData.FilterPageItem)localObject).a.clearAnimation();
    }
    if (localFilterPageItem != null) {
      localFilterPageItem.a.clearAnimation();
    }
    this.a.h = System.currentTimeMillis();
    localObject = this.a;
    ((EditVideoSpeedFilter)localObject).i = i;
    EditVideoSpeedFilter.c((EditVideoSpeedFilter)localObject).put(this.a.t.m(), paramInt);
    localObject = (EditVideoPlayerExport)this.a.b(EditVideoPlayerExport.class);
    if (localObject != null)
    {
      ((EditVideoPlayerExport)localObject).b(i);
      if ((localObject instanceof HWEditLocalVideoPlayer)) {
        ((HWEditLocalVideoPlayer)localObject).c(i);
      }
      if ((localObject instanceof HWEditImportVideoPlayer)) {
        ((HWEditImportVideoPlayer)localObject).c(i);
      }
    }
    if (i != 0)
    {
      this.a.t.b("608", "9", "0", true);
      VideoEditReport.a("0X80076DE");
    }
    SLog.a("EditVideoSpeedFilter", "LastSelectVideoFilterTime : %s , LastSelectVideoPlayMode : %s .", Long.valueOf(this.a.h), Integer.valueOf(this.a.i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSpeedFilter.FilterPageChangeListener
 * JD-Core Version:    0.7.0.1
 */