import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class azcn
  implements View.OnClickListener
{
  private azco jdField_a_of_type_Azco;
  private azcp jdField_a_of_type_Azcp;
  
  public azcn(azcp paramazcp)
  {
    this.jdField_a_of_type_Azcp = paramazcp;
  }
  
  public void a(azco paramazco)
  {
    this.jdField_a_of_type_Azco = paramazco;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    azcp.a(this.jdField_a_of_type_Azcp, i);
    if (this.jdField_a_of_type_Azco != null) {
      this.jdField_a_of_type_Azco.a((azcq)azcp.a(this.jdField_a_of_type_Azcp).get(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azcn
 * JD-Core Version:    0.7.0.1
 */