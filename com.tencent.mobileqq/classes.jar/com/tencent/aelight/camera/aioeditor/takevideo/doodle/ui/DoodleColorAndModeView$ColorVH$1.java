package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;

class DoodleColorAndModeView$ColorVH$1
  implements View.OnClickListener
{
  DoodleColorAndModeView$ColorVH$1(DoodleColorAndModeView.ColorVH paramColorVH, DoodleColorAndModeView paramDoodleColorAndModeView) {}
  
  public void onClick(View paramView)
  {
    if (DoodleColorAndModeView.c(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView))
    {
      AEQLog.a("DoodleColorAndModeView", "click color item, but now is disable");
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.getAdapterPosition();
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView;
    boolean bool;
    if (i >= DoodleColorAndModeView.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView)) {
      bool = true;
    } else {
      bool = false;
    }
    DoodleColorAndModeView.a(paramView, bool);
    if (i < DoodleColorAndModeView.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView))
    {
      if (DoodleColorAndModeView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView) != null) {
        DoodleColorAndModeView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView).a(0, 0);
      }
    }
    else
    {
      i = ((Integer)DoodleColorAndModeView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView).get(i - DoodleColorAndModeView.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView))).intValue();
      if (DoodleColorAndModeView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView) != null) {
        DoodleColorAndModeView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView).a(1, i);
      }
      DoodleColorAndModeView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView, i);
    }
    DoodleColorAndModeView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView$ColorVH.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleColorAndModeView).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.ColorVH.1
 * JD-Core Version:    0.7.0.1
 */