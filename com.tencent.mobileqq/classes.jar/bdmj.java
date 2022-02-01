import android.text.Layout;
import android.text.SpannedString;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class bdmj
  implements View.OnTouchListener
{
  bdmj(bdmh parambdmh) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    TextView localTextView = (TextView)paramView;
    CharSequence localCharSequence = localTextView.getText();
    if (((localCharSequence instanceof SpannedString)) && (i == 1))
    {
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = localTextView.getTotalPaddingLeft();
      int m = localTextView.getTotalPaddingTop();
      int n = localTextView.getScrollX();
      int i1 = localTextView.getScrollY();
      paramMotionEvent = localTextView.getLayout();
      i = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(j - m + i1), i - k + n);
      paramMotionEvent = (ClickableSpan[])((SpannedString)localCharSequence).getSpans(i, i, ClickableSpan.class);
      if (paramMotionEvent.length != 0) {
        paramMotionEvent[0].onClick(localTextView);
      }
    }
    else
    {
      return true;
    }
    paramView.performClick();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmj
 * JD-Core Version:    0.7.0.1
 */