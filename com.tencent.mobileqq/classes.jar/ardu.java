import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class ardu
  implements TextWatcher
{
  ardu(ardt paramardt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (ardt.a(this.a) != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label45;
      }
      if (!ardt.b(this.a))
      {
        ardt.b(this.a, true);
        ardt.a(this.a, 1);
      }
    }
    return;
    label45:
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ardu
 * JD-Core Version:    0.7.0.1
 */