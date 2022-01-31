package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import ahgy;
import ahha;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class SpringHbCountDownDialog$2$2
  implements Runnable
{
  public SpringHbCountDownDialog$2$2(ahha paramahha) {}
  
  public void run()
  {
    int i = this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int j = this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    ahgy.a(this.a.jdField_a_of_type_Ahgy, i, j, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.a.jdField_a_of_type_Ahgy.a(ahgy.a(this.a.jdField_a_of_type_Ahgy), ahgy.b(this.a.jdField_a_of_type_Ahgy));
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    QLog.i("SpringHbCountDownDialog", 1, "user..default bg:intrinsicWidth:" + i + ",intrinsicHeight:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbCountDownDialog.2.2
 * JD-Core Version:    0.7.0.1
 */