import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class asui
  implements TextWatcher
{
  asui(asuh paramasuh) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (asuh.a(this.a) != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label45;
      }
      if (!asuh.b(this.a))
      {
        asuh.b(this.a, true);
        asuh.a(this.a, 1);
      }
    }
    return;
    label45:
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asui
 * JD-Core Version:    0.7.0.1
 */