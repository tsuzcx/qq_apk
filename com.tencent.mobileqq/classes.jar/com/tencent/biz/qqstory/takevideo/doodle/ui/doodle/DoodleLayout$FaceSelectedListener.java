package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.OnFaceSelectedListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class DoodleLayout$FaceSelectedListener
  implements FacePanel.OnFaceSelectedListener
{
  private DoodleLayout$FaceSelectedListener(DoodleLayout paramDoodleLayout) {}
  
  private void a()
  {
    this.a.a(new View[] { this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout });
    this.a.a(false);
    this.a.b(new View[] { this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    this.a.setDoodleGLViewVisibility(0);
    this.a.c(0);
    this.a.d(0);
  }
  
  public void a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    SLog.a("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s ", paramSelectedItem, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    a();
    FaceLayer.LayerParams localLayerParams = new FaceLayer.LayerParams(paramFloat1, paramFloat2 + this.a.a(), paramFloat3, 0.0F, 0.0F, 0.0F, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a == 3))
    {
      LpReportInfo_pf00064.allReport(615, 6);
      LpReportInfo_pf00064.allReport(615, 4, 2);
    }
    FaceLayer localFaceLayer = this.a.a();
    if ((localFaceLayer != null) && (localFaceLayer.a(paramSelectedItem.jdField_a_of_type_JavaLangString, paramSelectedItem.b, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams)))
    {
      DoodleLayout.a("clk_oneface");
      VideoEditReport.a("0X80076CA");
      VideoEditReport.b("0X80075DF");
    }
  }
  
  public void a(LocationFacePackage.Item paramItem)
  {
    SLog.b("DoodleLayout", "onLocationFaceSelected, pictureUrl:" + paramItem.d);
    a();
    this.a.a(paramItem);
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a == 3) {
      LpReportInfo_pf00064.report(615, 6);
    }
    VideoEditReport.b("0X80075E3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.FaceSelectedListener
 * JD-Core Version:    0.7.0.1
 */