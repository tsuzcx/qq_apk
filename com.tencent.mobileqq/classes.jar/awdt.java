import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

public class awdt
  extends Editable.Factory
{
  public awdt(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ayks)) {
      return (Editable)paramCharSequence;
    }
    return new ayks(paramCharSequence, 3, (int)(SignatureHistoryFragment.a(this.a).getTextSize() / SignatureHistoryFragment.a(this.a).getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awdt
 * JD-Core Version:    0.7.0.1
 */