package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.aioeditor.capture.util.PasterUtil;
import com.tencent.aelight.camera.aioeditor.capture.util.PasterUtil.Position;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
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
    this.b.t().dismissLoadingDialog();
    QQToast.makeText(this.b.u(), HardCodeUtil.a(2131901821), 1).show();
    SLog.e("Q.qqstory.publish.edit.StoryDoodle", "onLoadFailed");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    this.b.t().dismissLoadingDialog();
    this.a.e = paramURLDrawable;
    paramURLDrawable = PasterUtil.a();
    this.b.b.a(this.a, paramURLDrawable.a, paramURLDrawable.b);
    SLog.e("Q.qqstory.publish.edit.StoryDoodle", "onLoadSucceed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.8
 * JD-Core Version:    0.7.0.1
 */