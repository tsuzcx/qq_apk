import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.widget.EditText;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;

public class avzy
  extends Editable.Factory
{
  public avzy(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof baiq)) {
      return (Editable)paramCharSequence;
    }
    return new baiq(paramCharSequence, 3, (int)(AutoReplyEditActivity.a(this.a).getTextSize() / AutoReplyEditActivity.a(this.a).getPaint().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avzy
 * JD-Core Version:    0.7.0.1
 */