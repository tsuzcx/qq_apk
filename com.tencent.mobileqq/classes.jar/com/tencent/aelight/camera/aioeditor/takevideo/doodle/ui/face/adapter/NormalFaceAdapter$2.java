package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class NormalFaceAdapter$2
  implements URLDrawable.URLDrawableListener
{
  NormalFaceAdapter$2(NormalFaceAdapter paramNormalFaceAdapter, String paramString1, NormalFacePackage paramNormalFacePackage, ImageView paramImageView, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("applyNormalPaster onLoadFialed path:");
    paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
    SLog.b("NormalFaceAdapter", paramURLDrawable.toString());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("applyNormalPaster onLoadSuccessed path:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    SLog.b("NormalFaceAdapter", localStringBuilder.toString());
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    NormalFaceAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterNormalFaceAdapter).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    NormalFaceAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterNormalFaceAdapter, this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceNormalFacePackage, paramURLDrawable, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString, this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.NormalFaceAdapter.2
 * JD-Core Version:    0.7.0.1
 */