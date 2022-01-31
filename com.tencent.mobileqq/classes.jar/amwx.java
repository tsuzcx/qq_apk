import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

public class amwx
  extends ClickableSpan
  implements apqj
{
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private ColorStateList b;
  
  public amwx(View.OnClickListener paramOnClickListener, int paramInt)
  {
    this(paramOnClickListener, ColorStateList.valueOf(paramInt), null);
  }
  
  public amwx(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList)
  {
    this(paramOnClickListener, paramColorStateList, null);
  }
  
  public amwx(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList1;
    this.b = paramColorStateList2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null) {
      if (this.jdField_a_of_type_Boolean)
      {
        i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(new int[] { 16842919 }, 0);
        paramTextPaint.setColor(i);
        label46:
        if (this.b == null) {
          break label122;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label107;
        }
      }
    }
    label107:
    for (int i = this.b.getColorForState(new int[] { 16842919 }, 0);; i = this.b.getColorForState(new int[0], 0))
    {
      paramTextPaint.bgColor = i;
      return;
      i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(new int[0], 0);
      break;
      paramTextPaint.setColor(-16777216);
      break label46;
    }
    label122:
    paramTextPaint.bgColor = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amwx
 * JD-Core Version:    0.7.0.1
 */