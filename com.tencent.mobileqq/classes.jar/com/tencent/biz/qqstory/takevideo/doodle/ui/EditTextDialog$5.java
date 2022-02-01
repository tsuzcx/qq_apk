package com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class EditTextDialog$5
  implements View.OnClickListener
{
  EditTextDialog$5(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText(this.a.jdField_a_of_type_JavaLangString);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.a.d);
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.a = this.a.d;
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.d = this.a.e;
    this.a.dismiss();
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a == 3)) {
      LpReportInfo_pf00064.allReport(615, 3, 3);
    }
    VideoEditReport.a("0X80076C5");
    VideoEditReport.b("0X80075D9");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.5
 * JD-Core Version:    0.7.0.1
 */