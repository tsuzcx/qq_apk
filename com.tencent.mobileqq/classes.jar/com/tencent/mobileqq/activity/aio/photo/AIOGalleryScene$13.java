package com.tencent.mobileqq.activity.aio.photo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class AIOGalleryScene$13
  implements DialogInterface.OnClickListener
{
  AIOGalleryScene$13(AIOGalleryScene paramAIOGalleryScene, int paramInt, Object paramObject, AIORichMediaInfo paramAIORichMediaInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = this.a;
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (QLog.isColorLevel())
        {
          paramDialogInterface = new StringBuilder();
          paramDialogInterface.append("showSaveFileTips type = ");
          paramDialogInterface.append(this.a);
          QLog.d("AIOGalleryScene", 2, paramDialogInterface.toString());
        }
      }
      else
      {
        paramDialogInterface = this.b;
        if ((paramDialogInterface instanceof AIOShortVideoData))
        {
          AIOGalleryScene.a(this.d, (AIOShortVideoData)paramDialogInterface, this.c);
          this.c.d.b = true;
          this.d.E();
        }
      }
    }
    else
    {
      paramDialogInterface = this.b;
      if ((paramDialogInterface instanceof AIOImageData))
      {
        AIOGalleryScene.a(this.d, (AIOImageData)paramDialogInterface, this.c);
        this.d.E();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.13
 * JD-Core Version:    0.7.0.1
 */