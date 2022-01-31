package com.tencent.av.redpacket;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class RedPacketLinkMovementMethod
  extends LinkMovementMethod
{
  private static RedPacketLinkMovementMethod a;
  public int a;
  public int b = -7447805;
  
  public RedPacketLinkMovementMethod()
  {
    this.jdField_a_of_type_Int = -10864125;
  }
  
  public static MovementMethod a()
  {
    if (jdField_a_of_type_ComTencentAvRedpacketRedPacketLinkMovementMethod == null) {
      jdField_a_of_type_ComTencentAvRedpacketRedPacketLinkMovementMethod = new RedPacketLinkMovementMethod();
    }
    return jdField_a_of_type_ComTencentAvRedpacketRedPacketLinkMovementMethod;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
      localObject = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (localObject.length != 0)
      {
        if (i == 1)
        {
          localObject[0].onClick(paramTextView);
          paramSpannable.setSpan(new ForegroundColorSpan(this.b), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
        }
        for (;;)
        {
          return true;
          if (i == 0)
          {
            paramSpannable.setSpan(new ForegroundColorSpan(this.jdField_a_of_type_Int), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]));
          }
        }
      }
      Selection.removeSelection(paramSpannable);
    }
    return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.RedPacketLinkMovementMethod
 * JD-Core Version:    0.7.0.1
 */