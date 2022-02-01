package com.tencent.mobileqq.activity.richmedia;

import android.graphics.Bitmap;
import android.widget.ImageView;

class NewFlowCameraActivity$RunnableUpdate
  implements Runnable
{
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  
  NewFlowCameraActivity$RunnableUpdate(Bitmap paramBitmap, ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.RunnableUpdate
 * JD-Core Version:    0.7.0.1
 */