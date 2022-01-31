package com.tencent.mobileqq.activity.aio.photo;

import adzh;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

public class PhotoListPanel$PhotoPanelAdapter$RecyclerHolder$1
  implements Runnable
{
  public PhotoListPanel$PhotoPanelAdapter$RecyclerHolder$1(adzh paramadzh, View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getHitRect(localRect);
    localRect.left -= this.jdField_a_of_type_Int;
    localRect.top -= this.jdField_b_of_type_Int;
    localRect.right += this.c;
    localRect.bottom += this.d;
    this.jdField_b_of_type_AndroidViewView.setTouchDelegate(new TouchDelegate(localRect, this.jdField_a_of_type_AndroidViewView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.RecyclerHolder.1
 * JD-Core Version:    0.7.0.1
 */