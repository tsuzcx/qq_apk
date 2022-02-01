import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class avym
  implements TextWatcher
{
  avym(avyl paramavyl) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (avyl.a(this.a) != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label45;
      }
      if (!avyl.b(this.a))
      {
        avyl.b(this.a, true);
        avyl.a(this.a, 1);
      }
    }
    return;
    label45:
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avym
 * JD-Core Version:    0.7.0.1
 */