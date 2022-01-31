import android.view.View;
import android.view.View.OnClickListener;
import java.util.Iterator;
import java.util.List;

class awot
  implements View.OnClickListener
{
  awot(awos paramawos, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (awos.a(this.jdField_a_of_type_Awos) == this.jdField_a_of_type_Int) {
      return;
    }
    paramView = awos.a(this.jdField_a_of_type_Awos).iterator();
    while (paramView.hasNext()) {
      ((awow)paramView.next()).a = false;
    }
    ((awow)awos.a(this.jdField_a_of_type_Awos).get(this.jdField_a_of_type_Int)).a = true;
    awos.a(this.jdField_a_of_type_Awos, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Awos.notifyDataSetChanged();
    if (awos.a(this.jdField_a_of_type_Awos) != null) {
      awos.a(this.jdField_a_of_type_Awos).a((awow)awos.a(this.jdField_a_of_type_Awos).get(this.jdField_a_of_type_Int));
    }
    azmj.b(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awot
 * JD-Core Version:    0.7.0.1
 */