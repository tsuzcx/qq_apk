import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;

public class atku
  extends Editable.Factory
{
  public atku(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof axkn)) {
      return (Editable)paramCharSequence;
    }
    return new axkn(paramCharSequence, 3, (int)(AutoReplyEditActivity.a(this.a).getTextSize() / AutoReplyEditActivity.a(this.a).getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atku
 * JD-Core Version:    0.7.0.1
 */