import android.view.View;
import android.view.View.OnClickListener;
import java.util.Iterator;
import java.util.List;

class auxf
  implements View.OnClickListener
{
  auxf(auxe paramauxe, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (auxe.a(this.jdField_a_of_type_Auxe) == this.jdField_a_of_type_Int) {
      return;
    }
    paramView = auxe.a(this.jdField_a_of_type_Auxe).iterator();
    while (paramView.hasNext()) {
      ((auxi)paramView.next()).a = false;
    }
    ((auxi)auxe.a(this.jdField_a_of_type_Auxe).get(this.jdField_a_of_type_Int)).a = true;
    auxe.a(this.jdField_a_of_type_Auxe, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Auxe.notifyDataSetChanged();
    if (auxe.a(this.jdField_a_of_type_Auxe) != null) {
      auxe.a(this.jdField_a_of_type_Auxe).a((auxi)auxe.a(this.jdField_a_of_type_Auxe).get(this.jdField_a_of_type_Int));
    }
    axqw.b(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxf
 * JD-Core Version:    0.7.0.1
 */