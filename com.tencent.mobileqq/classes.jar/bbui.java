import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

public class bbui
  extends Editable.Factory
{
  public bbui(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof begz)) {
      return (Editable)paramCharSequence;
    }
    return new begz(paramCharSequence, 3, (int)(SignatureHistoryFragment.a(this.a).getTextSize() / SignatureHistoryFragment.a(this.a).getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbui
 * JD-Core Version:    0.7.0.1
 */