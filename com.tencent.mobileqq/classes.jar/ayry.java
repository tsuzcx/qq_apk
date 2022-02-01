import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.widget.OCRBottomTabView;

public class ayry
  implements TextWatcher
{
  public ayry(OCRResultActivity paramOCRResultActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().trim().length() == 0)
    {
      this.a.c.setEnabled(false);
      this.a.d.setEnabled(false);
      this.a.b.setEnabled(false);
      return;
    }
    this.a.c.setEnabled(true);
    this.a.d.setEnabled(true);
    this.a.b.setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayry
 * JD-Core Version:    0.7.0.1
 */