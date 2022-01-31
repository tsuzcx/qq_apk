import android.view.View;
import android.view.View.OnClickListener;

class avtt
  implements View.OnClickListener
{
  avtt(avtr paramavtr, avtm paramavtm) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Avtr.dismiss();
    if (this.jdField_a_of_type_Avtm.a != null) {
      this.jdField_a_of_type_Avtm.a.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avtt
 * JD-Core Version:    0.7.0.1
 */