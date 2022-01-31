import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer;
import java.util.List;

class bdcu
  implements View.OnClickListener
{
  bdcu(bdct parambdct, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((bdct.a(this.jdField_a_of_type_Bdct) == null) || (this.jdField_a_of_type_Int >= bdct.a(this.jdField_a_of_type_Bdct).size()) || (this.jdField_a_of_type_Int < 0)) {
      return;
    }
    if ((this.jdField_a_of_type_Bdct.a.a != null) && (bdct.a(this.jdField_a_of_type_Bdct).get(this.jdField_a_of_type_Int) != null) && (OpenCardContainer.a(this.jdField_a_of_type_Bdct.a) != null)) {
      OpenCardContainer.a(this.jdField_a_of_type_Bdct.a).a(((bdcw)bdct.a(this.jdField_a_of_type_Bdct).get(this.jdField_a_of_type_Int)).a);
    }
    bdct.a(this.jdField_a_of_type_Bdct).remove(bdct.a(this.jdField_a_of_type_Bdct).get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Bdct.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdcu
 * JD-Core Version:    0.7.0.1
 */