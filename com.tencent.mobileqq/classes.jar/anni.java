import android.text.Editable;
import android.text.TextWatcher;
import dov.com.qq.im.capture.poi.FacePoiSearchUI;

public class anni
  implements TextWatcher
{
  public anni(FacePoiSearchUI paramFacePoiSearchUI) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    FacePoiSearchUI.a(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anni
 * JD-Core Version:    0.7.0.1
 */