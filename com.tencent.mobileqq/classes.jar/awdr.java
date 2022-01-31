import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.TextView;

class awdr
  extends Editable.Factory
{
  awdr(awdp paramawdp, TextView paramTextView) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bamz)) {
      return (Editable)paramCharSequence;
    }
    return new bamz(paramCharSequence, 3, (int)(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize() / this.jdField_a_of_type_AndroidWidgetTextView.getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdr
 * JD-Core Version:    0.7.0.1
 */