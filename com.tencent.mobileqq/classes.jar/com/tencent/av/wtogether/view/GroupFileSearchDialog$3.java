package com.tencent.av.wtogether.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.util.InputMethodUtil;

class GroupFileSearchDialog$3
  implements View.OnTouchListener
{
  GroupFileSearchDialog$3(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      InputMethodUtil.b(paramView);
      this.a.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.3
 * JD-Core Version:    0.7.0.1
 */