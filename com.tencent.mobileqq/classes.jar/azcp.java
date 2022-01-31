import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class azcp
  implements View.OnClickListener
{
  private azcq jdField_a_of_type_Azcq;
  private azcr jdField_a_of_type_Azcr;
  
  public azcp(azcr paramazcr)
  {
    this.jdField_a_of_type_Azcr = paramazcr;
  }
  
  public void a(azcq paramazcq)
  {
    this.jdField_a_of_type_Azcq = paramazcq;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    azcr.a(this.jdField_a_of_type_Azcr, i);
    if (this.jdField_a_of_type_Azcq != null) {
      this.jdField_a_of_type_Azcq.a((azcs)azcr.a(this.jdField_a_of_type_Azcr).get(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azcp
 * JD-Core Version:    0.7.0.1
 */