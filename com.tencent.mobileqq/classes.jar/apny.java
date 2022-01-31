import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class apny
  implements View.OnClickListener
{
  apny(apnw paramapnw, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((!((Activity)this.jdField_a_of_type_Apnw.a).isFinishing()) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apny
 * JD-Core Version:    0.7.0.1
 */