import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class apav
  implements TextWatcher
{
  apav(apau paramapau) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apav
 * JD-Core Version:    0.7.0.1
 */