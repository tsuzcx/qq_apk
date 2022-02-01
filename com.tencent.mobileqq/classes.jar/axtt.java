import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQTextBuilder;

class axtt
  extends Editable.Factory
{
  axtt(axtr paramaxtr, TextView paramTextView) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, (int)(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize() / this.jdField_a_of_type_AndroidWidgetTextView.getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtt
 * JD-Core Version:    0.7.0.1
 */