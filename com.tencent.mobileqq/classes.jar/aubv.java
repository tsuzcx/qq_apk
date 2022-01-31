import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.TranslateFragment;
import java.util.List;

public class aubv
  implements PopupWindow.OnDismissListener
{
  public aubv(TranslateFragment paramTranslateFragment, auaf paramauaf) {}
  
  public void onDismiss()
  {
    TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment, null);
    if ((this.jdField_a_of_type_Auaf.b != null) && (this.jdField_a_of_type_Auaf.b.size() > 1))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment.getResources().getDrawable(2130845299);
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubv
 * JD-Core Version:    0.7.0.1
 */