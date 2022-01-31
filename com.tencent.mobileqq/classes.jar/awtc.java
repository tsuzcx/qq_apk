import android.view.View;
import android.view.View.OnClickListener;
import java.util.Iterator;
import java.util.List;

class awtc
  implements View.OnClickListener
{
  awtc(awtb paramawtb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (awtb.a(this.jdField_a_of_type_Awtb) == this.jdField_a_of_type_Int) {
      return;
    }
    paramView = awtb.a(this.jdField_a_of_type_Awtb).iterator();
    while (paramView.hasNext()) {
      ((awtf)paramView.next()).a = false;
    }
    ((awtf)awtb.a(this.jdField_a_of_type_Awtb).get(this.jdField_a_of_type_Int)).a = true;
    awtb.a(this.jdField_a_of_type_Awtb, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Awtb.notifyDataSetChanged();
    if (awtb.a(this.jdField_a_of_type_Awtb) != null) {
      awtb.a(this.jdField_a_of_type_Awtb).a((awtf)awtb.a(this.jdField_a_of_type_Awtb).get(this.jdField_a_of_type_Int));
    }
    azqs.b(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awtc
 * JD-Core Version:    0.7.0.1
 */