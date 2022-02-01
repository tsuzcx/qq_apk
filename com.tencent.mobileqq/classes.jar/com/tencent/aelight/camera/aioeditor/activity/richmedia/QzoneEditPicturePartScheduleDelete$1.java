package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class QzoneEditPicturePartScheduleDelete$1
  implements View.OnClickListener
{
  QzoneEditPicturePartScheduleDelete$1(QzoneEditPicturePartScheduleDelete paramQzoneEditPicturePartScheduleDelete) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!this.a.b().e())
    {
      QzoneEditPicturePartScheduleDelete.a(this.a);
      return;
    }
    this.a.b().a(false);
    QzoneEditPicturePartScheduleDelete.b(this.a).setSelected(false);
    this.a.b().a(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPicturePartScheduleDelete.1
 * JD-Core Version:    0.7.0.1
 */