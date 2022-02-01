import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import java.util.List;

public class ayrk
  implements PopupWindow.OnDismissListener
{
  public ayrk(OCRPerformFragment paramOCRPerformFragment, ayru paramayru) {}
  
  public void onDismiss()
  {
    OCRPerformFragment.b(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment, null);
    if ((this.jdField_a_of_type_Ayru.c != null) && (this.jdField_a_of_type_Ayru.c.size() > 1))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment.getResources().getDrawable(2130846151);
      OCRPerformFragment.b(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrk
 * JD-Core Version:    0.7.0.1
 */