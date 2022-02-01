package com.tencent.mobileqq.adapter;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class MayKnowAdapter$2
  implements View.OnTouchListener
{
  MayKnowAdapter$2(MayKnowAdapter paramMayKnowAdapter) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && ((paramView instanceof ImageView))) {
        ((ImageView)paramView).getDrawable().clearColorFilter();
      }
    }
    else if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).getDrawable().setColorFilter(855638016, PorterDuff.Mode.SRC_ATOP);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter.2
 * JD-Core Version:    0.7.0.1
 */