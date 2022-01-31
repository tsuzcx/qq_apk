import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.widget.OCRBottomTabView;

public class avsb
  implements TextWatcher
{
  public avsb(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().trim().length() == 0)
    {
      this.a.b.setEnabled(false);
      this.a.a.setEnabled(false);
      return;
    }
    this.a.b.setEnabled(true);
    this.a.a.setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avsb
 * JD-Core Version:    0.7.0.1
 */