import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;

public class auba
  implements View.OnTouchListener
{
  public auba(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (EditText)paramView;
    int j = paramMotionEvent.getAction();
    if (j == 1)
    {
      Object localObject = paramView.getText();
      int m = (int)paramMotionEvent.getX();
      i = (int)paramMotionEvent.getY();
      int n = paramView.getTotalPaddingLeft();
      int k = paramView.getTotalPaddingTop();
      m = m - n + paramView.getScrollX();
      n = paramView.getScrollY();
      Layout localLayout = paramView.getLayout();
      i = localLayout.getLineForVertical(i - k + n);
      float f = localLayout.getLineWidth(i);
      if (m <= f)
      {
        i = localLayout.getOffsetForHorizontal(i, m);
        localObject = (ClickableSpan[])((Spannable)localObject).getSpans(i, i, ClickableSpan.class);
        if (localObject.length != 0)
        {
          localObject[0].onClick(paramView);
          axqy.b(null, "dc00898", "", "", "0X80082E3", "0X80082E3", 0, 0, "", "", "", "");
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        return true;
      }
      if ((j == 1) && (!paramView.isFocused())) {
        axqy.b(null, "dc00898", "", "", "0X80082E2", "0X80082E2", 0, 0, "", "", "", "");
      }
      return paramView.onTouchEvent(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auba
 * JD-Core Version:    0.7.0.1
 */