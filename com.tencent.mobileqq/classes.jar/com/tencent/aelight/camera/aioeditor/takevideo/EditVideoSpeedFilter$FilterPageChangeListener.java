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
    int i = paramInt1 % this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a();
    Object localObject = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(i);
    paramInt2 = 0;
    if (localObject != null) {
      paramInt1 = ((FilterData)localObject).jdField_a_of_type_Int;
    } else {
      paramInt1 = 0;
    }
    localObject = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a((i + 1) % this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a());
    if (localObject != null) {
      paramInt2 = ((FilterData)localObject).jdField_a_of_type_Int;
    }
    localObject = (EditVideoPlayerExport)this.a.a(EditVideoPlayerExport.class);
    if (localObject != null) {
      ((EditVideoPlayerExport)localObject).a(paramInt1, paramInt2, paramFloat);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt);
    int i;
    if (localObject != null) {
      i = ((FilterData)localObject).jdField_a_of_type_Int;
    } else {
      i = 0;
    }
    this.a.jdField_a_of_type_AndroidUtilSparseArray.put(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(), localObject);
    if ((i == 2) || (i == 1) || (i == 3) || (i == 0))
    {
      localObject = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt);
      if ((localObject != null) && (TextUtils.isEmpty(((FilterData.FilterPageItem)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoFilterFilterData.b))) {
        EditVideoSpeedFilter.a((FilterData.FilterPageItem)localObject);
      }
    }
    localObject = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt - 1);
    FilterData.FilterPageItem localFilterPageItem = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt + 1);
    if (localObject != null) {
      ((FilterData.FilterPageItem)localObject).jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    if (localFilterPageItem != null) {
      localFilterPageItem.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    this.a.b = System.currentTimeMillis();
    localObject = this.a;
    ((EditVideoSpeedFilter)localObject).jdField_a_of_type_Int = i;
    EditVideoSpeedFilter.a((EditVideoSpeedFilter)localObject).put(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(), paramInt);
    localObject = (EditVideoPlayerExport)this.a.a(EditVideoPlayerExport.class);
    if (localObject != null)
    {
      ((EditVideoPlayerExport)localObject).a(i);
      if ((localObject instanceof HWEditLocalVideoPlayer)) {
        ((HWEditLocalVideoPlayer)localObject).b(i);
      }
      if ((localObject instanceof HWEditImportVideoPlayer)) {
        ((HWEditImportVideoPlayer)localObject).b(i);
      }
    }
    if (i != 0)
    {
      this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b("608", "9", "0", true);
      VideoEditReport.a("0X80076DE");
    }
    SLog.a("EditVideoSpeedFilter", "LastSelectVideoFilterTime : %s , LastSelectVideoPlayMode : %s .", Long.valueOf(this.a.b), Integer.valueOf(this.a.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSpeedFilter.FilterPageChangeListener
 * JD-Core Version:    0.7.0.1
 */