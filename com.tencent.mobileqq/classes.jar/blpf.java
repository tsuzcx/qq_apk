import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;

class blpf
  implements TextWatcher
{
  blpf(blpb paramblpb) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    String str = paramEditable.toString();
    if (paramEditable.length() > 40)
    {
      QQToast.a(this.a.getContext(), blpb.a(this.a), 0).a();
      str = paramEditable.subSequence(0, 40).toString();
      blpb.a(this.a).setText(str);
      blpb.a(this.a).setSelection(str.length());
    }
    if (TextUtils.isEmpty(str.trim())) {
      blpb.a(this.a).a("");
    }
    for (;;)
    {
      blpb.a(this.a);
      return;
      blpb.a(this.a).a(str);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpf
 * JD-Core Version:    0.7.0.1
 */