package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

public final class RIJConfigVideoItem$6
  implements Runnable
{
  public RIJConfigVideoItem$6(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.getHitRect((Rect)localObject);
    ((Rect)localObject).left -= this.jdField_a_of_type_Int;
    ((Rect)localObject).top -= this.jdField_b_of_type_Int;
    ((Rect)localObject).right += this.c;
    ((Rect)localObject).bottom += this.d;
    localObject = new TouchDelegate((Rect)localObject, this.jdField_a_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setTouchDelegate((TouchDelegate)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJConfigVideoItem.6
 * JD-Core Version:    0.7.0.1
 */