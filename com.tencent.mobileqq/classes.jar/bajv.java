import android.view.View;
import java.util.List;

class bajv
  implements bhuk
{
  bajv(bajs parambajs, List paramList, baky parambaky, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (bakz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (bajs.a(this.jdField_a_of_type_Bajs) != null) {
        bajs.a(this.jdField_a_of_type_Bajs).a(paramView.b(), this.jdField_a_of_type_Baky);
      }
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
    }
    this.jdField_a_of_type_Bhuf.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajv
 * JD-Core Version:    0.7.0.1
 */