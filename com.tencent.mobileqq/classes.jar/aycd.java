import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class aycd
  implements View.OnClickListener
{
  private ayce jdField_a_of_type_Ayce;
  private aycf jdField_a_of_type_Aycf;
  
  public aycd(aycf paramaycf)
  {
    this.jdField_a_of_type_Aycf = paramaycf;
  }
  
  public void a(ayce paramayce)
  {
    this.jdField_a_of_type_Ayce = paramayce;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    aycf.a(this.jdField_a_of_type_Aycf, i);
    if (this.jdField_a_of_type_Ayce != null) {
      this.jdField_a_of_type_Ayce.a((aycg)aycf.a(this.jdField_a_of_type_Aycf).get(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aycd
 * JD-Core Version:    0.7.0.1
 */