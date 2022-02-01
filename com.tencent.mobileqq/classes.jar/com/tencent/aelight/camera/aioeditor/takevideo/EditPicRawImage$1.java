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
    if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      int i = this.a.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      int j = this.a.jdField_a_of_type_AndroidWidgetImageView.getHeight();
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
        EditPicRawImage.jdField_a_of_type_Int = j;
        EditPicRawImage.a(this.a);
        this.a.a(i, j);
      }
      return;
    }
    AEQLog.b("EditPicActivity.EditVideoRawImage", "display bitmap is invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage.1
 * JD-Core Version:    0.7.0.1
 */