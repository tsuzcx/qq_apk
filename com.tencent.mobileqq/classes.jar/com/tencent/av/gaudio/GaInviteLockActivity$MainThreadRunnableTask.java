package com.tencent.av.gaudio;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

class GaInviteLockActivity$MainThreadRunnableTask
  implements Runnable
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public GaInviteLockActivity$MainThreadRunnableTask(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.this$0.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.this$0.jdField_b_of_type_AndroidWidgetTextView.setText(this.b);
    }
    if (this.this$0.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      String str = this.this$0.a(this.this$0.jdField_b_of_type_Int, this.this$0.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, true, false);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.MainThreadRunnableTask
 * JD-Core Version:    0.7.0.1
 */