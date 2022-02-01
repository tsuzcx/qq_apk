import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;

public class asqd
  implements TextWatcher
{
  public asqd(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!bhsr.a(paramEditable.toString())) {
      this.a.a.setVisibility(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqd
 * JD-Core Version:    0.7.0.1
 */