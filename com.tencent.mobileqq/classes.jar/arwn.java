import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

class arwn
  implements View.OnClickListener
{
  arwn(arwl paramarwl, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Arwl.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Arwl, 1);
    }
    if (arwl.a(this.jdField_a_of_type_Arwl))
    {
      arwl.a(this.jdField_a_of_type_Arwl).removeView(arwl.a(this.jdField_a_of_type_Arwl));
      arwl.a(this.jdField_a_of_type_Arwl, false);
    }
    try
    {
      if (this.jdField_a_of_type_Arwl.isShowing()) {
        this.jdField_a_of_type_Arwl.dismiss();
      }
      return;
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Forward.NewVersion.Dialog", 2, Log.getStackTraceString(paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwn
 * JD-Core Version:    0.7.0.1
 */