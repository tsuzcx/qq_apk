import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;

final class ayku
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ayks)) {
      return (Editable)paramCharSequence;
    }
    return new ayks(paramCharSequence, 3, ChatTextSizeSettingActivity.b() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayku
 * JD-Core Version:    0.7.0.1
 */