import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.LangSettingFragment;
import java.util.List;

public class aqhr
  implements View.OnClickListener
{
  public aqhr(LangSettingFragment paramLangSettingFragment, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Int < LangSettingFragment.a().size()))
    {
      LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment, this.jdField_a_of_type_Int);
      LangSettingFragment.c(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment, ((Integer)LangSettingFragment.a().get(this.jdField_a_of_type_Int)).intValue());
    }
    if ((LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment) != null) && (LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment).isShowing())) {
      LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment).dismiss();
    }
    if ((LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment) != null) && (LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment).isShowing())) {
      LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqhr
 * JD-Core Version:    0.7.0.1
 */