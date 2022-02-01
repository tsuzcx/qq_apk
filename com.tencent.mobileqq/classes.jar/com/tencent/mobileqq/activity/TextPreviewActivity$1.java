package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.NoSelLinkMovementMethod;

class TextPreviewActivity$1
  extends Handler
{
  TextPreviewActivity$1(TextPreviewActivity paramTextPreviewActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 16)
    {
      if (i != 100)
      {
        switch (i)
        {
        default: 
          return;
        case 20: 
          this.a.a();
          return;
        case 19: 
          if (!(paramMessage.obj instanceof Bitmap)) {
            break;
          }
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
          return;
        case 18: 
          if (!(paramMessage.obj instanceof Drawable)) {
            break;
          }
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramMessage.obj);
          return;
        }
      }
      else
      {
        if (this.a.jdField_a_of_type_JavaLangCharSequence != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(this.a.jdField_a_of_type_JavaLangCharSequence);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a.setMovementMethod(ContainerView.NoSelLinkMovementMethod.a());
      }
    }
    else {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService.getFontNameDrawable(this.a.e));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */