import android.view.View;
import java.util.List;

class axhk
  implements begw
{
  axhk(axhh paramaxhh, List paramList, axin paramaxin, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (axio)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (axhh.a(this.jdField_a_of_type_Axhh) != null) {
        axhh.a(this.jdField_a_of_type_Axhh).a(paramView.b(), this.jdField_a_of_type_Axin);
      }
      this.jdField_a_of_type_Begr.dismiss();
      return;
    }
    this.jdField_a_of_type_Begr.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axhk
 * JD-Core Version:    0.7.0.1
 */