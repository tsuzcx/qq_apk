import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.mobileqq.location.ui.LocationPickFragment;

public class avzl
  implements TextWatcher
{
  public avzl(LocationPickFragment paramLocationPickFragment, View paramView1, View paramView2, View paramView3) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
    }
    for (;;)
    {
      paramEditable = paramEditable.toString().trim();
      if (TextUtils.isEmpty(paramEditable)) {
        break;
      }
      LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).a(paramEditable);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
    }
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).a("");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzl
 * JD-Core Version:    0.7.0.1
 */