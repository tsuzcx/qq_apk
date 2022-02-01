package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;

class EditJumpToPtu$2
  implements Runnable
{
  EditJumpToPtu$2(EditJumpToPtu paramEditJumpToPtu, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a(this.a);
    if (localBitmap != null) {
      VideoFilterTools.a().a(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditJumpToPtu.2
 * JD-Core Version:    0.7.0.1
 */