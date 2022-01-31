import android.view.View;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class avwr
  implements bhuk
{
  public avwr(OCRResultFragmentNew paramOCRResultFragmentNew, List paramList, avvs paramavvs) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!paramView.equalsIgnoreCase(this.jdField_a_of_type_Avvs.a)) {
        break label108;
      }
      QLog.i("OCRResultFragmentNew", 2, "lanCode equals, return, selectedLan:" + paramView);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a = null;
      return;
      label108:
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), 0, 2131699605, 0).a();
      avvq.a.a(paramView);
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("OCRResultFragmentNew", 2, "requestOcr lan:" + paramView + ", ctx:" + avvq.a.a());
        }
        OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, avvq.a);
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avwr
 * JD-Core Version:    0.7.0.1
 */