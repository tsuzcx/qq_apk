package com.tencent.avgame.gameroom;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class GameRoomFragment$5
  implements Runnable
{
  GameRoomFragment$5(GameRoomFragment paramGameRoomFragment, Bitmap paramBitmap, ImageView paramImageView, TextView paramTextView) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int k = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
    int m = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight();
    float f1 = k / (j / i);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    float f2 = localLayoutParams.bottomMargin;
    localLayoutParams.bottomMargin = ((int)(Math.abs(f1 - m) / 2.0F + f2));
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomFragment", 1, String.format("bit_h:%d bit_w:%d img_h:%d img_w:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(k) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.5
 * JD-Core Version:    0.7.0.1
 */