import android.text.Editable;
import android.text.TextWatcher;
import dov.com.qq.im.capture.poi.FacePoiSearchUI;

public class anvv
  implements TextWatcher
{
  public anvv(FacePoiSearchUI paramFacePoiSearchUI) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    FacePoiSearchUI.a(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvv
 * JD-Core Version:    0.7.0.1
 */