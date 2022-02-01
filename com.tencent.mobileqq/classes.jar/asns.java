import android.text.Editable;
import android.text.TextWatcher;

class asns
  implements TextWatcher
{
  asns(asnp paramasnp) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.a.a(paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asns
 * JD-Core Version:    0.7.0.1
 */