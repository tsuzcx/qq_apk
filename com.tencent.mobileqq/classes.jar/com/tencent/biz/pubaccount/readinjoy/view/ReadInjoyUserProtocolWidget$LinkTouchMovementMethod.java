package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

public class ReadInjoyUserProtocolWidget$LinkTouchMovementMethod
  extends LinkMovementMethod
{
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 0)) {
      Selection.removeSelection(paramSpannable);
    }
    paramTextView.setPressed(false);
    paramTextView.setFocusable(false);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyUserProtocolWidget.LinkTouchMovementMethod
 * JD-Core Version:    0.7.0.1
 */