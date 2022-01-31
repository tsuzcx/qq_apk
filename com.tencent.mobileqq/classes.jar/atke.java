import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.TextView;

class atke
  extends Editable.Factory
{
  atke(atkc paramatkc, TextView paramTextView) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof axkn)) {
      return (Editable)paramCharSequence;
    }
    return new axkn(paramCharSequence, 3, (int)(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize() / this.jdField_a_of_type_AndroidWidgetTextView.getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atke
 * JD-Core Version:    0.7.0.1
 */