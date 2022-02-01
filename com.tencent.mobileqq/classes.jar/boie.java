import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.bean.TextEditorData;

class boie
  implements TextWatcher
{
  boie(boib paramboib) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    String str = paramEditable.toString();
    if (paramEditable.length() > 20)
    {
      QQToast.a(this.a.getContext(), boib.a(this.a), 0).a();
      str = paramEditable.subSequence(0, 20).toString();
      boib.a(this.a).setText(str);
      boib.a(this.a).setSelection(str.length());
    }
    if (TextUtils.isEmpty(str.trim())) {
      boib.a(this.a).setContent("");
    }
    for (;;)
    {
      boib.b(this.a);
      return;
      boib.a(this.a).setContent(str);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boie
 * JD-Core Version:    0.7.0.1
 */