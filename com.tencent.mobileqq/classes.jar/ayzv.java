import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.TranslateFragment;
import java.util.List;

public class ayzv
  implements PopupWindow.OnDismissListener
{
  public ayzv(TranslateFragment paramTranslateFragment, ayyd paramayyd) {}
  
  public void onDismiss()
  {
    TranslateFragment.b(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment, null);
    if ((this.jdField_a_of_type_Ayyd.c != null) && (this.jdField_a_of_type_Ayyd.c.size() > 1))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment.getResources().getDrawable(2130846171);
      TranslateFragment.b(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzv
 * JD-Core Version:    0.7.0.1
 */