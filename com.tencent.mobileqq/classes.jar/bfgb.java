import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer;
import java.util.List;

class bfgb
  implements View.OnClickListener
{
  bfgb(bfga parambfga, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((bfga.a(this.jdField_a_of_type_Bfga) == null) || (this.jdField_a_of_type_Int >= bfga.a(this.jdField_a_of_type_Bfga).size()) || (this.jdField_a_of_type_Int < 0)) {
      return;
    }
    if ((this.jdField_a_of_type_Bfga.a.a != null) && (bfga.a(this.jdField_a_of_type_Bfga).get(this.jdField_a_of_type_Int) != null) && (OpenCardContainer.a(this.jdField_a_of_type_Bfga.a) != null)) {
      OpenCardContainer.a(this.jdField_a_of_type_Bfga.a).a(((bfgd)bfga.a(this.jdField_a_of_type_Bfga).get(this.jdField_a_of_type_Int)).a);
    }
    bfga.a(this.jdField_a_of_type_Bfga).remove(bfga.a(this.jdField_a_of_type_Bfga).get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Bfga.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfgb
 * JD-Core Version:    0.7.0.1
 */