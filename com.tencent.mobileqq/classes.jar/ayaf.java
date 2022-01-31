import android.text.TextUtils;
import android.view.View;

class ayaf
  implements bhuk
{
  ayaf(ayaa paramayaa, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_Bhuf.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
    }
    this.jdField_a_of_type_Bhuf.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayaf
 * JD-Core Version:    0.7.0.1
 */