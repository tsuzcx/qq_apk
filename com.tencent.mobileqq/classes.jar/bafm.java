import android.view.View;
import java.util.List;

class bafm
  implements bhqd
{
  bafm(bafj parambafj, List paramList, bagp parambagp, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (bagq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (bafj.a(this.jdField_a_of_type_Bafj) != null) {
        bafj.a(this.jdField_a_of_type_Bafj).a(paramView.b(), this.jdField_a_of_type_Bagp);
      }
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    this.jdField_a_of_type_Bhpy.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafm
 * JD-Core Version:    0.7.0.1
 */