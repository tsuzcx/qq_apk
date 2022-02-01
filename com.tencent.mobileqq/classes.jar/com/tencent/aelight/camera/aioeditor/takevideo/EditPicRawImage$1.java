package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.aelight.camera.log.AEQLog;

class EditPicRawImage$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  EditPicRawImage$1(EditPicRawImage paramEditPicRawImage) {}
  
  public void onGlobalLayout()
  {
    AEQLog.b("EditPicActivity.EditVideoRawImage", "[EditPicRawImage onGlobalLayout]");
    if ((this.a.b != null) && (!this.a.b.isRecycled()))
    {
      int i = this.a.a.getWidth();
      int j = this.a.a.getHeight();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("last width = ");
      localStringBuilder.append(EditPicRawImage.a(this.a));
      localStringBuilder.append(", last height = ");
      localStringBuilder.append(EditPicRawImage.b(this.a));
      AEQLog.b("EditPicActivity.EditVideoRawImage", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("current width = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", current height = ");
      localStringBuilder.append(j);
      AEQLog.b("EditPicActivity.EditVideoRawImage", localStringBuilder.toString());
      if (((int)EditPicRawImage.a(this.a) != i) || ((int)EditPicRawImage.b(this.a) != j))
      {
        EditPicRawImage.f = j;
        EditPicRawImage.c(this.a);
        this.a.a(i, j);
      }
      return;
    }
    AEQLog.b("EditPicActivity.EditVideoRawImage", "display bitmap is invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage.1
 * JD-Core Version:    0.7.0.1
 */