import android.widget.EditText;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.ocr.ui.SearchResultFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class avye
  extends avvk
{
  public avye(OCRTextSearchActivity paramOCRTextSearchActivity) {}
  
  public void a(int paramInt, String paramString, avwu paramavwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.OCRTextSearchActivity", 2, "onGetTextSearchResult, errorCode=" + paramInt + ", sessionID=" + paramString + ", mSessionId=" + this.a.c);
    }
    if ((paramString == null) || (this.a.c == null) || (!this.a.c.equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.OCRTextSearchActivity", 2, "onGetTextSearchResult, session error");
      }
      return;
    }
    this.a.a(false);
    if (this.a.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment == null) {
      this.a.b(1);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment.a(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), paramInt, paramavwu);
    this.a.a(1);
    if ((paramInt == 0) && (paramavwu.a != null) && (paramavwu.a.size() > 0))
    {
      azqs.b(null, "dc00898", "", "", "0X80082E8", "0X80082E8", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "dc00898", "", "", "0X80082E7", "0X80082E7", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avye
 * JD-Core Version:    0.7.0.1
 */