package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class QzoneEditPicturePartScheduleDelete$3
  implements DialogInterface.OnClickListener
{
  QzoneEditPicturePartScheduleDelete$3(QzoneEditPicturePartScheduleDelete paramQzoneEditPicturePartScheduleDelete) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((QzoneEditPicturePartManager)this.a.a).a(false);
    QzoneEditPicturePartScheduleDelete.a(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPicturePartScheduleDelete.3
 * JD-Core Version:    0.7.0.1
 */