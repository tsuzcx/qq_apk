package com.tencent.mobileqq.activity.aio.item;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;

class ReplyTextItemBuilder$1
  implements OnLongClickAndTouchListener
{
  ReplyTextItemBuilder$1(ReplyTextItemBuilder paramReplyTextItemBuilder) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = (ReplyTextItemBuilder.ReplyTextViewHolder)((View)paramView.getParent().getParent().getParent()).getTag();
    if (paramView != null) {
      paramView.a.performLongClick();
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */