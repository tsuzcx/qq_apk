import android.view.View;
import android.view.View.OnClickListener;

class avpk
  implements View.OnClickListener
{
  avpk(avpi paramavpi, avpd paramavpd) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Avpi.dismiss();
    if (this.jdField_a_of_type_Avpd.a != null) {
      this.jdField_a_of_type_Avpd.a.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avpk
 * JD-Core Version:    0.7.0.1
 */