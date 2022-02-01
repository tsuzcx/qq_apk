package com.tencent.mobileqq.activity.aio.photo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import java.io.File;
import java.util.Locale;
import mqq.os.MqqHandler;

class AIOGalleryScene$8$1
  implements DialogInterface.OnClickListener
{
  AIOGalleryScene$8$1(AIOGalleryScene.8 param8, File paramFile) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append(this.a.getParentFile().getName().toLowerCase(Locale.US));
    paramDialogInterface.append(".mp4");
    paramDialogInterface = paramDialogInterface.toString();
    ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.a.getAbsolutePath(), this.b.a.aE, paramDialogInterface, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.8.1
 * JD-Core Version:    0.7.0.1
 */