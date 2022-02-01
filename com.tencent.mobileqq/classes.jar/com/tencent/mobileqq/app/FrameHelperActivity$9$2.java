package com.tencent.mobileqq.app;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;

class FrameHelperActivity$9$2
  implements Runnable
{
  FrameHelperActivity$9$2(FrameHelperActivity.9 param9, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.b.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.b.setContentDescription(this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.a() == FrameControllerUtil.a) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.b.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.b.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.9.2
 * JD-Core Version:    0.7.0.1
 */