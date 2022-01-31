import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.method.Touch;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public class avfe
  extends BaseMovementMethod
{
  private int jdField_a_of_type_Int;
  private BackgroundColorSpan jdField_a_of_type_AndroidTextStyleBackgroundColorSpan;
  public final String a;
  private boolean jdField_a_of_type_Boolean = true;
  private ClickableSpan[] jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan;
  private int b;
  
  public avfe(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = "CommentMovementMethod";
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = paramTextView.getTotalPaddingLeft();
      int m = paramTextView.getTotalPaddingTop();
      int n = paramTextView.getScrollX();
      int i1 = paramTextView.getScrollY();
      Layout localLayout = paramTextView.getLayout();
      i = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(j - m + i1), i - k + n);
      this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan = ((ClickableSpan[])paramSpannable.getSpans(i, i, ClickableSpan.class));
      if (this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan.length > 0)
      {
        a(false);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan[0]), paramSpannable.getSpanEnd(this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan[0]));
        this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan = new BackgroundColorSpan(this.b);
        paramSpannable.setSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan, paramSpannable.getSpanStart(this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan[0]), paramSpannable.getSpanEnd(this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan[0]), 33);
      }
    }
    for (;;)
    {
      return Touch.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      a(true);
      paramTextView.setBackgroundColor(this.jdField_a_of_type_Int);
      continue;
      if (i == 1)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan.length > 0)
        {
          this.jdField_a_of_type_ArrayOfAndroidTextStyleClickableSpan[0].onClick(paramTextView);
          if (this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan != null) {
            paramSpannable.removeSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan);
          }
        }
        Selection.removeSelection(paramSpannable);
        paramTextView.setBackgroundResource(2131101491);
      }
      else if (i != 2)
      {
        if (this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan != null) {
          paramSpannable.removeSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan);
        }
        paramTextView.setBackgroundResource(2131101491);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avfe
 * JD-Core Version:    0.7.0.1
 */