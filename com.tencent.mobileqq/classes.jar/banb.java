import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;

final class banb
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bamz)) {
      return (Editable)paramCharSequence;
    }
    return new bamz(paramCharSequence, 3, ChatTextSizeSettingActivity.b() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banb
 * JD-Core Version:    0.7.0.1
 */