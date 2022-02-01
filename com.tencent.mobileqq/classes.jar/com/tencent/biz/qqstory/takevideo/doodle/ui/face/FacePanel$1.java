package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FacePanel$1
  implements AdapterView.OnItemClickListener
{
  FacePanel$1(FacePanel paramFacePanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.a) {}
    for (Object localObject = "2";; localObject = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter != null)
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(paramInt);
        if ((localObject != null) && ((localObject instanceof FacePackage)))
        {
          VideoEditReport.a("0X80076C7", "", "", ((FacePackage)localObject).a, "");
          VideoEditReport.a("0X80075DC", ((FacePackage)localObject).a);
        }
      }
      if (paramInt == 1)
      {
        VideoEditReport.a("0X80076CC");
        VideoEditReport.b("0X80075E1");
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.1
 * JD-Core Version:    0.7.0.1
 */