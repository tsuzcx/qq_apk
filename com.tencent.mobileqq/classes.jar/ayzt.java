import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.ocr.TranslateFragment;
import java.util.List;

public class ayzt
  implements PopupWindow.OnDismissListener
{
  public ayzt(TranslateFragment paramTranslateFragment, ayyd paramayyd) {}
  
  public void onDismiss()
  {
    TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment, null);
    if ((this.jdField_a_of_type_Ayyd.b != null) && (this.jdField_a_of_type_Ayyd.b.size() > 1))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment.getResources().getDrawable(2130846171);
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzt
 * JD-Core Version:    0.7.0.1
 */