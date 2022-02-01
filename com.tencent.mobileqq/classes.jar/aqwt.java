import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;

public class aqwt
  implements TextWatcher
{
  public aqwt(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.a.a = true;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqwt
 * JD-Core Version:    0.7.0.1
 */