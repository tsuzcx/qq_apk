package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class QzoneRightButton$5
  implements DialogInterface.OnClickListener
{
  QzoneRightButton$5(QzoneRightButton paramQzoneRightButton) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QzoneRightButton.a(this.a).l = true;
    QzoneRightButton.b(this.a).setSelected(true);
    QzoneRightButton.a(this.a).a(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneRightButton.5
 * JD-Core Version:    0.7.0.1
 */