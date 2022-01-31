import android.text.TextUtils;
import android.view.View;

class axvw
  implements bhqd
{
  axvw(axvr paramaxvr, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_Bhpy.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    this.jdField_a_of_type_Bhpy.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvw
 * JD-Core Version:    0.7.0.1
 */