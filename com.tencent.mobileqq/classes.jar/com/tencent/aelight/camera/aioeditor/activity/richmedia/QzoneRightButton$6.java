package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class QzoneRightButton$6
  implements DialogInterface.OnClickListener
{
  QzoneRightButton$6(QzoneRightButton paramQzoneRightButton) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QzoneRightButton.a(this.a).z = false;
    QzoneRightButton.e(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneRightButton.6
 * JD-Core Version:    0.7.0.1
 */