package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class AEHorizontalSelectColorLayout$ColorListAdapter$1
  implements View.OnClickListener
{
  AEHorizontalSelectColorLayout$ColorListAdapter$1(AEHorizontalSelectColorLayout.ColorListAdapter paramColorListAdapter, AEHorizontalSelectColorLayout.ColorVH paramColorVH) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorVH.getAdapterPosition();
    AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter, i);
    if (i < AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter))
    {
      if (AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter) != null) {
        AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter).a(0, 0);
      }
    }
    else
    {
      i = ((Integer)AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter).get(i - AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter))).intValue();
      if (AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter) != null) {
        AEHorizontalSelectColorLayout.ColorListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter).a(1, i);
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$ColorListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout.ColorListAdapter.1
 * JD-Core Version:    0.7.0.1
 */