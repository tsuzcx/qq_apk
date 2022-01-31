import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class asyr
  implements TextWatcher
{
  asyr(asyq paramasyq) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (asyq.a(this.a) != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label45;
      }
      if (!asyq.b(this.a))
      {
        asyq.b(this.a, true);
        asyq.a(this.a, 1);
      }
    }
    return;
    label45:
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyr
 * JD-Core Version:    0.7.0.1
 */