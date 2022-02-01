package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class QzoneRightButton$2
  implements View.OnClickListener
{
  QzoneRightButton$2(QzoneRightButton paramQzoneRightButton) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!QzoneRightButton.a(this.a).z)
    {
      QzoneRightButton.d(this.a);
      return;
    }
    QzoneRightButton.a(this.a).z = false;
    QzoneRightButton.e(this.a).setSelected(false);
    QzoneRightButton.a(this.a).a(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneRightButton.2
 * JD-Core Version:    0.7.0.1
 */