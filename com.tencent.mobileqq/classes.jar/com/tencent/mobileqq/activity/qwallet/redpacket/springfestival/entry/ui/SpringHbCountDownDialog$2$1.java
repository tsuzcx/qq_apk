package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import ahgw;
import ahgy;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class SpringHbCountDownDialog$2$1
  implements Runnable
{
  public SpringHbCountDownDialog$2$1(ahgy paramahgy, BitmapFactory.Options paramOptions, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    ahgw.a(this.jdField_a_of_type_Ahgy.jdField_a_of_type_Ahgw, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, this.jdField_a_of_type_Ahgy.jdField_a_of_type_Int, this.jdField_a_of_type_Ahgy.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Ahgy.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new SpringHbCountDownDialog.2.1.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbCountDownDialog.2.1
 * JD-Core Version:    0.7.0.1
 */