import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.TranslateFragment;
import java.util.List;

public class avtb
  implements PopupWindow.OnDismissListener
{
  public avtb(TranslateFragment paramTranslateFragment, avrj paramavrj) {}
  
  public void onDismiss()
  {
    TranslateFragment.b(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment, null);
    if ((this.jdField_a_of_type_Avrj.c != null) && (this.jdField_a_of_type_Avrj.c.size() > 1))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment.getResources().getDrawable(2130845668);
      TranslateFragment.b(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avtb
 * JD-Core Version:    0.7.0.1
 */