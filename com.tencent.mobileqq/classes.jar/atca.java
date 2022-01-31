import android.view.View;
import android.view.View.OnClickListener;

class atca
  implements View.OnClickListener
{
  atca(atby paramatby, atbt paramatbt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Atby.dismiss();
    if (this.jdField_a_of_type_Atbt.a != null) {
      this.jdField_a_of_type_Atbt.a.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atca
 * JD-Core Version:    0.7.0.1
 */