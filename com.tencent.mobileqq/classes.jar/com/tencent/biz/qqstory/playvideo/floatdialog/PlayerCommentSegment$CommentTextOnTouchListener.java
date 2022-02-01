package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class PlayerCommentSegment$CommentTextOnTouchListener
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (TextView)paramView;
    Object localObject = paramView.getText();
    localObject = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject);
    int i = paramMotionEvent.getAction();
    boolean bool2 = false;
    boolean bool1;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 0) {}
    }
    else
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramView.getTotalPaddingLeft();
      int n = paramView.getTotalPaddingTop();
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      paramMotionEvent = paramView.getLayout();
      j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
      paramMotionEvent = (ClickableSpan[])((Spannable)localObject).getSpans(j, j, ClickableSpan.class);
      bool1 = bool2;
      if (paramMotionEvent.length != 0)
      {
        if (i == 1) {
          paramMotionEvent[0].onClick(paramView);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerCommentSegment.CommentTextOnTouchListener
 * JD-Core Version:    0.7.0.1
 */