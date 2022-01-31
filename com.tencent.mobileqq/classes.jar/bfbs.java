import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer;
import java.util.List;

class bfbs
  implements View.OnClickListener
{
  bfbs(bfbr parambfbr, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((bfbr.a(this.jdField_a_of_type_Bfbr) == null) || (this.jdField_a_of_type_Int >= bfbr.a(this.jdField_a_of_type_Bfbr).size()) || (this.jdField_a_of_type_Int < 0)) {
      return;
    }
    if ((this.jdField_a_of_type_Bfbr.a.a != null) && (bfbr.a(this.jdField_a_of_type_Bfbr).get(this.jdField_a_of_type_Int) != null) && (OpenCardContainer.a(this.jdField_a_of_type_Bfbr.a) != null)) {
      OpenCardContainer.a(this.jdField_a_of_type_Bfbr.a).a(((bfbu)bfbr.a(this.jdField_a_of_type_Bfbr).get(this.jdField_a_of_type_Int)).a);
    }
    bfbr.a(this.jdField_a_of_type_Bfbr).remove(bfbr.a(this.jdField_a_of_type_Bfbr).get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Bfbr.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbs
 * JD-Core Version:    0.7.0.1
 */