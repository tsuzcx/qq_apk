package com.tencent.mobileqq.ar.view;

import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class QRScanEntryView$13
  implements Runnable
{
  QRScanEntryView$13(QRScanEntryView paramQRScanEntryView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      if (this.this$0.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        this.this$0.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.this$0.getContext());
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839445);
        i = AIOUtils.dp2px(25.0F, this.this$0.getResources());
        localRect = new Rect(0, 0, i, i);
        localRect.offset(QRScanEntryView.a(this.this$0).centerX() - (int)(i * 0.5F), QRScanEntryView.a(this.this$0).centerY() - (int)(i * 0.5F));
        localLayoutParams = new FrameLayout.LayoutParams(i, i);
        localLayoutParams.leftMargin = localRect.left;
        localLayoutParams.topMargin = localRect.top;
        this.this$0.addView(this.this$0.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
        ((Animatable)this.this$0.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
      }
    }
    while (this.this$0.jdField_a_of_type_AndroidWidgetImageView == null) {
      for (;;)
      {
        int i;
        Rect localRect;
        FrameLayout.LayoutParams localLayoutParams;
        return;
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    ((Animatable)this.this$0.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
    this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.13
 * JD-Core Version:    0.7.0.1
 */