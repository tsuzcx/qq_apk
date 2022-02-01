import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatusEditText;
import com.tencent.qphone.base.util.QLog;

public class bbso
  implements TextWatcher
{
  public bbso(EditActivity paramEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    EditActivity.a = true;
    bdll.b(this.a.app, "CliOper", "", "", "signiture", "set_clk_mdf", 0, 0, "", "", "", "");
    if ((EditActivity.a(this.a).getSelectionStart() == 7) && (EditActivity.a(this.a).getText().toString().trim().length() == 7)) {
      EditActivity.a(this.a).setSelection(paramEditable.length());
    }
    EditActivity.a(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("EditActivity", 2, "beforeTextChanged CharSequence = " + paramCharSequence + ", start = " + paramInt1 + ", count = " + paramInt2 + ", after = " + paramInt3);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("EditActivity", 2, "onTextChanged CharSequence = " + paramCharSequence + ", start = " + paramInt1 + ", count = " + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbso
 * JD-Core Version:    0.7.0.1
 */