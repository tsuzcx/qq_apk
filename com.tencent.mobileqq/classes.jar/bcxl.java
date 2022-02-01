import android.view.View;
import java.util.List;

class bcxl
  implements bjoe
{
  bcxl(bcxi parambcxi, List paramList, bcyo parambcyo, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (bcyp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (bcxi.a(this.jdField_a_of_type_Bcxi) != null) {
        bcxi.a(this.jdField_a_of_type_Bcxi).a(paramView.b(), this.jdField_a_of_type_Bcyo);
      }
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
    }
    this.jdField_a_of_type_Bjnw.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxl
 * JD-Core Version:    0.7.0.1
 */