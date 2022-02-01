import android.view.View;
import java.util.List;

class bdkz
  implements bkhw
{
  bdkz(bdkw parambdkw, List paramList, bdmc parambdmc, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (bdmd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (bdkw.a(this.jdField_a_of_type_Bdkw) != null) {
        bdkw.a(this.jdField_a_of_type_Bdkw).a(paramView.b(), this.jdField_a_of_type_Bdmc);
      }
      this.jdField_a_of_type_Bkho.dismiss();
      return;
    }
    this.jdField_a_of_type_Bkho.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkz
 * JD-Core Version:    0.7.0.1
 */