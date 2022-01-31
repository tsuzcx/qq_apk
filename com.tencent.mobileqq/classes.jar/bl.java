import android.text.Editable;
import android.text.TextWatcher;
import com.dataline.activities.LiteActivity;

public class bl
  implements TextWatcher
{
  public bl(LiteActivity paramLiteActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.a.p();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bl
 * JD-Core Version:    0.7.0.1
 */