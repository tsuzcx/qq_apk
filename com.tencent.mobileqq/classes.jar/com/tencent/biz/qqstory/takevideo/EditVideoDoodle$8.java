package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.utils.UIUtils.LoadImageCallback;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class EditVideoDoodle$8
  extends UIUtils.LoadImageCallback
{
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    super.onLoadCanceled(paramURLDrawable);
    SLog.e("Q.qqstory.publish.edit.StoryDoodle", "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a().b();
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a(), HardCodeUtil.a(2131703845), 1).a();
    SLog.e("Q.qqstory.publish.edit.StoryDoodle", "onLoadFailed");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a().b();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item.a = paramURLDrawable;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item);
    SLog.e("Q.qqstory.publish.edit.StoryDoodle", "onLoadSucceed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoDoodle.8
 * JD-Core Version:    0.7.0.1
 */