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
    if (!QzoneRightButton.a(this.a).a)
    {
      QzoneRightButton.a(this.a);
      return;
    }
    if (QzoneRightButton.a(this.a).k)
    {
      ToastUtil.a().a(2131717678);
      QzoneRightButton.a(this.a).k = false;
      QzoneRightButton.a(this.a).setSelected(false);
      QzoneRightButton.a(this.a).h = false;
      QzoneRightButton.a(this.a).a(3008);
      return;
    }
    ToastUtil.a().a(2131717680);
    QzoneRightButton.a(this.a).k = true;
    QzoneRightButton.a(this.a).setSelected(true);
    QzoneRightButton.a(this.a).h = true;
    QzoneRightButton.a(this.a).a(3007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneRightButton.1
 * JD-Core Version:    0.7.0.1
 */