import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import mqq.util.WeakReference;

public class aper
  extends ClickableSpan
  implements asdp
{
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private WeakReference<View.OnClickListener> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private ColorStateList b;
  
  public aper(View.OnClickListener paramOnClickListener, int paramInt)
  {
    this(paramOnClickListener, ColorStateList.valueOf(paramInt), null);
  }
  
  public aper(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList)
  {
    this(paramOnClickListener, paramColorStateList, null);
  }
  
  public aper(View.OnClickListener paramOnClickListener, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnClickListener);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList1;
    this.b = paramColorStateList2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      View.OnClickListener localOnClickListener = (View.OnClickListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localOnClickListener != null) {
        localOnClickListener.onClick(paramView);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aper
 * JD-Core Version:    0.7.0.1
 */