import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class bbex
  implements View.OnClickListener
{
  private bbey jdField_a_of_type_Bbey;
  private bbez jdField_a_of_type_Bbez;
  
  public bbex(bbez parambbez)
  {
    this.jdField_a_of_type_Bbez = parambbez;
  }
  
  public void a(bbey parambbey)
  {
    this.jdField_a_of_type_Bbey = parambbey;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    bbez.a(this.jdField_a_of_type_Bbez, i);
    if (this.jdField_a_of_type_Bbey != null) {
      this.jdField_a_of_type_Bbey.a((bbfa)bbez.a(this.jdField_a_of_type_Bbez).get(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbex
 * JD-Core Version:    0.7.0.1
 */