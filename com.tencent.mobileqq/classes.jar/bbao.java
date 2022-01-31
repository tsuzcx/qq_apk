import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class bbao
  implements View.OnClickListener
{
  private bbap jdField_a_of_type_Bbap;
  private bbaq jdField_a_of_type_Bbaq;
  
  public bbao(bbaq parambbaq)
  {
    this.jdField_a_of_type_Bbaq = parambbaq;
  }
  
  public void a(bbap parambbap)
  {
    this.jdField_a_of_type_Bbap = parambbap;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    bbaq.a(this.jdField_a_of_type_Bbaq, i);
    if (this.jdField_a_of_type_Bbap != null) {
      this.jdField_a_of_type_Bbap.a((bbar)bbaq.a(this.jdField_a_of_type_Bbaq).get(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbao
 * JD-Core Version:    0.7.0.1
 */