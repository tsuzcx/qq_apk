import android.view.View;
import android.view.View.OnClickListener;
import java.util.Iterator;
import java.util.List;

class auxh
  implements View.OnClickListener
{
  auxh(auxg paramauxg, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (auxg.a(this.jdField_a_of_type_Auxg) == this.jdField_a_of_type_Int) {
      return;
    }
    paramView = auxg.a(this.jdField_a_of_type_Auxg).iterator();
    while (paramView.hasNext()) {
      ((auxk)paramView.next()).a = false;
    }
    ((auxk)auxg.a(this.jdField_a_of_type_Auxg).get(this.jdField_a_of_type_Int)).a = true;
    auxg.a(this.jdField_a_of_type_Auxg, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Auxg.notifyDataSetChanged();
    if (auxg.a(this.jdField_a_of_type_Auxg) != null) {
      auxg.a(this.jdField_a_of_type_Auxg).a((auxk)auxg.a(this.jdField_a_of_type_Auxg).get(this.jdField_a_of_type_Int));
    }
    axqy.b(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxh
 * JD-Core Version:    0.7.0.1
 */