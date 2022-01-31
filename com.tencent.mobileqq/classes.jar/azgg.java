import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class azgg
  implements TextWatcher
{
  public azgg(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!TextUtils.isEmpty(this.a.a.b)) && (paramInt1 > 0) && (paramInt1 < this.a.a.b.length() + this.a.a.c.length() + this.a.a.a.length() + this.a.J.length()) && (paramInt2 > paramInt3))
    {
      this.a.e(false);
      return;
    }
    TroopBarPublishActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azgg
 * JD-Core Version:    0.7.0.1
 */