import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OCRPerformFragment;

public class ayrq
  implements ayvp
{
  public ayrq(OCRPerformFragment paramOCRPerformFragment, ayru paramayru) {}
  
  public void a(int paramInt, ayvq paramayvq)
  {
    if ((paramayvq != null) && (!TextUtils.isEmpty(paramayvq.b)))
    {
      if (!this.jdField_a_of_type_Ayru.b.equalsIgnoreCase(paramayvq.b)) {
        OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment, paramayvq.b, this.jdField_a_of_type_Ayru.b(paramayvq.b), false);
      }
      ayrt.a("0X800B559", ayrt.a(paramayvq.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrq
 * JD-Core Version:    0.7.0.1
 */