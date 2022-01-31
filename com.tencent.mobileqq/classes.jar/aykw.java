import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;

final class aykw
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ayku)) {
      return (Editable)paramCharSequence;
    }
    return new ayku(paramCharSequence, 3, ChatTextSizeSettingActivity.b() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aykw
 * JD-Core Version:    0.7.0.1
 */