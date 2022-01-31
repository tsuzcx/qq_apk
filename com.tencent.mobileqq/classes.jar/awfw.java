import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class awfw
  extends LinkMovementMethod
{
  private static awfw jdField_a_of_type_Awfw;
  awfu jdField_a_of_type_Awfu;
  boolean jdField_a_of_type_Boolean;
  
  public static MovementMethod a()
  {
    if (jdField_a_of_type_Awfw == null) {
      jdField_a_of_type_Awfw = new awfw();
    }
    return jdField_a_of_type_Awfw;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0) || (i == 3))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
      localObject = (awfu[])paramSpannable.getSpans(j, j, awfu.class);
      if (QLog.isColorLevel()) {
        QLog.i("StateColorMovementMethod", 2, String.format("onTouch action[%d] links=[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(localObject.length) }));
      }
      if (localObject.length != 0)
      {
        this.jdField_a_of_type_Boolean = false;
        paramSpannable = localObject[0];
        if (i == 1)
        {
          if (this.jdField_a_of_type_Awfu != null)
          {
            this.jdField_a_of_type_Awfu.a(paramTextView, false);
            this.jdField_a_of_type_Awfu = null;
          }
          paramSpannable.onClick(paramTextView);
        }
        for (;;)
        {
          return true;
          if (i == 0)
          {
            paramSpannable.a(paramTextView, true);
            this.jdField_a_of_type_Awfu = paramSpannable;
          }
          else if ((i == 3) && (this.jdField_a_of_type_Awfu != null))
          {
            this.jdField_a_of_type_Awfu.a(paramTextView, false);
            this.jdField_a_of_type_Awfu = null;
          }
        }
      }
      if (i != 1) {
        break label312;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        paramTextView.performClick();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Awfu != null)
      {
        this.jdField_a_of_type_Awfu.a(paramTextView, false);
        this.jdField_a_of_type_Awfu = null;
      }
      return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      label312:
      if (i == 0) {
        this.jdField_a_of_type_Boolean = true;
      } else if (i == 3) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awfw
 * JD-Core Version:    0.7.0.1
 */