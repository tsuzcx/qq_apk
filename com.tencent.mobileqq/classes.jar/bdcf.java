import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer;
import java.util.List;

class bdcf
  implements View.OnClickListener
{
  bdcf(bdce parambdce, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((bdce.a(this.jdField_a_of_type_Bdce) == null) || (this.jdField_a_of_type_Int >= bdce.a(this.jdField_a_of_type_Bdce).size()) || (this.jdField_a_of_type_Int < 0)) {
      return;
    }
    if ((this.jdField_a_of_type_Bdce.a.a != null) && (bdce.a(this.jdField_a_of_type_Bdce).get(this.jdField_a_of_type_Int) != null) && (OpenCardContainer.a(this.jdField_a_of_type_Bdce.a) != null)) {
      OpenCardContainer.a(this.jdField_a_of_type_Bdce.a).a(((bdch)bdce.a(this.jdField_a_of_type_Bdce).get(this.jdField_a_of_type_Int)).a);
    }
    bdce.a(this.jdField_a_of_type_Bdce).remove(bdce.a(this.jdField_a_of_type_Bdce).get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Bdce.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdcf
 * JD-Core Version:    0.7.0.1
 */