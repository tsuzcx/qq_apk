package com.tencent.mobileqq.ar.view;

import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class QRScanEntryView$13
  implements Runnable
{
  QRScanEntryView$13(QRScanEntryView paramQRScanEntryView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      if (this.this$0.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        Object localObject1 = this.this$0;
        ((QRScanEntryView)localObject1).jdField_a_of_type_AndroidWidgetImageView = new ImageView(((QRScanEntryView)localObject1).getContext());
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839401);
        int i = AIOUtils.b(25.0F, this.this$0.getResources());
        Object localObject2 = new Rect(0, 0, i, i);
        int j = QRScanEntryView.a(this.this$0).centerX();
        int k = (int)(i * 0.5F);
        ((Rect)localObject2).offset(j - k, QRScanEntryView.a(this.this$0).centerY() - k);
        localObject1 = new FrameLayout.LayoutParams(i, i);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = ((Rect)localObject2).left;
        ((FrameLayout.LayoutParams)localObject1).topMargin = ((Rect)localObject2).top;
        localObject2 = this.this$0;
        ((QRScanEntryView)localObject2).addView(((QRScanEntryView)localObject2).jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      ((Animatable)this.this$0.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
      return;
    }
    if (this.this$0.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      ((Animatable)this.this$0.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.13
 * JD-Core Version:    0.7.0.1
 */