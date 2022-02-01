package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.base.ToastUtil;

class QzoneRightButton$1
  implements View.OnClickListener
{
  QzoneRightButton$1(QzoneRightButton paramQzoneRightButton) {}
  
  public void onClick(View paramView)
  {
    if (!QzoneRightButton.a(this.a).h)
    {
      QzoneRightButton.b(this.a);
      return;
    }
    if (QzoneRightButton.a(this.a).y)
    {
      ToastUtil.a().a(2131915153);
      QzoneRightButton.a(this.a).y = false;
      QzoneRightButton.c(this.a).setSelected(false);
      QzoneRightButton.a(this.a).t = false;
      QzoneRightButton.a(this.a).a(3008);
      return;
    }
    ToastUtil.a().a(2131915155);
    QzoneRightButton.a(this.a).y = true;
    QzoneRightButton.c(this.a).setSelected(true);
    QzoneRightButton.a(this.a).t = true;
    QzoneRightButton.a(this.a).a(3007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneRightButton.1
 * JD-Core Version:    0.7.0.1
 */