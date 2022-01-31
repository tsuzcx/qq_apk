package com.tencent.av.gaudio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import muf;

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
    if (this.this$0.b != null) {
      this.this$0.b.setText(this.b);
    }
    if (this.this$0.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      float f = this.this$0.getResources().getDimensionPixelSize(2131297021);
      String str = muf.a(this.this$0.getApplicationContext(), this.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_AndroidWidgetTextView, f);
      str = String.format(this.this$0.getApplicationContext().getString(2131692965), new Object[] { String.valueOf(str) });
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.MainThreadRunnableTask
 * JD-Core Version:    0.7.0.1
 */