import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer;
import java.util.List;

class bbyf
  implements View.OnClickListener
{
  bbyf(bbye parambbye, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((bbye.a(this.jdField_a_of_type_Bbye) == null) || (this.jdField_a_of_type_Int >= bbye.a(this.jdField_a_of_type_Bbye).size()) || (this.jdField_a_of_type_Int < 0)) {
      return;
    }
    if ((this.jdField_a_of_type_Bbye.a.a != null) && (bbye.a(this.jdField_a_of_type_Bbye).get(this.jdField_a_of_type_Int) != null) && (OpenCardContainer.a(this.jdField_a_of_type_Bbye.a) != null)) {
      OpenCardContainer.a(this.jdField_a_of_type_Bbye.a).a(((bbyh)bbye.a(this.jdField_a_of_type_Bbye).get(this.jdField_a_of_type_Int)).a);
    }
    bbye.a(this.jdField_a_of_type_Bbye).remove(bbye.a(this.jdField_a_of_type_Bbye).get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Bbye.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbyf
 * JD-Core Version:    0.7.0.1
 */