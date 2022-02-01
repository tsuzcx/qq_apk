import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.text.QQTextBuilder;

public class bbus
  extends Editable.Factory
{
  public bbus(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, (int)(SignatureHistoryFragment.a(this.a).getTextSize() / SignatureHistoryFragment.a(this.a).getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbus
 * JD-Core Version:    0.7.0.1
 */