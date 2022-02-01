import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageButton;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;

public class ascy
  implements TextWatcher
{
  public ascy(SystemAndEmojiUniversalPanel paramSystemAndEmojiUniversalPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ImageButton localImageButton;
    if (SystemAndEmojiUniversalPanel.a(this.a) != null)
    {
      localImageButton = SystemAndEmojiUniversalPanel.a(this.a);
      if (TextUtils.isEmpty(paramEditable)) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      localImageButton.setEnabled(bool);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascy
 * JD-Core Version:    0.7.0.1
 */