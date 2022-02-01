package com.tencent.mobileqq.activity.aio;

import android.view.View;
import com.tencent.image.URLDrawable;

final class AIOUtils$4
  implements Runnable
{
  AIOUtils$4(URLDrawable paramURLDrawable, View paramView) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0) || (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 4)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOUtils.4
 * JD-Core Version:    0.7.0.1
 */