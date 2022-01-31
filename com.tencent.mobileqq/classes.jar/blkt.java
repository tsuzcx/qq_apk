import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;

class blkt
  implements TextWatcher
{
  blkt(blkp paramblkp) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    String str = paramEditable.toString();
    if (paramEditable.length() > 40)
    {
      QQToast.a(this.a.getContext(), blkp.a(this.a), 0).a();
      str = paramEditable.subSequence(0, 40).toString();
      blkp.a(this.a).setText(str);
      blkp.a(this.a).setSelection(str.length());
    }
    if (TextUtils.isEmpty(str.trim())) {
      blkp.a(this.a).a("");
    }
    for (;;)
    {
      blkp.a(this.a);
      return;
      blkp.a(this.a).a(str);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkt
 * JD-Core Version:    0.7.0.1
 */