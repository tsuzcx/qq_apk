import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class avrh
  implements TextWatcher
{
  avrh(avrg paramavrg) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (avrg.a(this.a) != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label45;
      }
      if (!avrg.b(this.a))
      {
        avrg.b(this.a, true);
        avrg.a(this.a, 1);
      }
    }
    return;
    label45:
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrh
 * JD-Core Version:    0.7.0.1
 */