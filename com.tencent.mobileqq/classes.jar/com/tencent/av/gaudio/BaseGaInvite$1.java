package com.tencent.av.gaudio;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

class BaseGaInvite$1
  implements BaseGaInvite.GetGaFaceRunnable.OnGetSink
{
  BaseGaInvite$1(BaseGaInvite paramBaseGaInvite) {}
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    for (boolean bool = true;; bool = false)
    {
      if (this.a.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        paramBitmap = BaseGaInvite.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.a.jdField_b_of_type_AndroidWidgetTextView, paramString, this.a.jdField_b_of_type_Int, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_ArrayOfLong);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(paramBitmap);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite.1
 * JD-Core Version:    0.7.0.1
 */