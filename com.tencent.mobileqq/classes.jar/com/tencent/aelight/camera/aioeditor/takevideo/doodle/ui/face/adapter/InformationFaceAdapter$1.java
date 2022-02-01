package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class InformationFaceAdapter$1
  implements URLDrawable.URLDrawableListener
{
  InformationFaceAdapter$1(InformationFaceAdapter paramInformationFaceAdapter, String paramString, InformationFacePackage.Item paramItem) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramThrowable = new StringBuilder();
    paramThrowable.append("applyNormalPaster onLoadFialed path:");
    paramThrowable.append(this.a);
    SLog.b("InformationFaceAdapter", paramThrowable.toString());
    InformationFaceAdapter.a(this.c, this.a);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("applyNormalPaster onLoadSuccessed path:");
    localStringBuilder.append(this.a);
    SLog.b("InformationFaceAdapter", localStringBuilder.toString());
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    InformationFaceAdapter.a(this.c).a(this.a, paramURLDrawable);
    InformationFaceAdapter.a(this.c, paramURLDrawable, this.a, this.b.b, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.1
 * JD-Core Version:    0.7.0.1
 */