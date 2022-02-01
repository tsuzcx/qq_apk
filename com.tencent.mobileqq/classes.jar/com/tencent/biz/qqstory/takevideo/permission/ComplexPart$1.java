package com.tencent.biz.qqstory.takevideo.permission;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComplexPart$1
  implements View.OnClickListener
{
  ComplexPart$1(ComplexPart paramComplexPart, ComplexPart.Group paramGroup) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Group.a()) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Group.b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart.a != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart.a.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionComplexPart$Group.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.ComplexPart.1
 * JD-Core Version:    0.7.0.1
 */