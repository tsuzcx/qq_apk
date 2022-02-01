import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class arqq
  implements TextWatcher
{
  arqq(arqp paramarqp) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      arqp.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqq
 * JD-Core Version:    0.7.0.1
 */