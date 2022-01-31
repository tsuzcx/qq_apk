import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import mqq.os.MqqHandler;

class bcfv
  implements View.OnClickListener
{
  bcfv(bcfs parambcfs) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(102));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcfv
 * JD-Core Version:    0.7.0.1
 */