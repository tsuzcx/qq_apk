import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

class asaw
  implements View.OnClickListener
{
  asaw(asau paramasau, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Asau.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Asau, 1);
    }
    if (asau.a(this.jdField_a_of_type_Asau))
    {
      asau.a(this.jdField_a_of_type_Asau).removeView(asau.a(this.jdField_a_of_type_Asau));
      asau.a(this.jdField_a_of_type_Asau, false);
    }
    try
    {
      if (this.jdField_a_of_type_Asau.isShowing()) {
        this.jdField_a_of_type_Asau.dismiss();
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
 * Qualified Name:     asaw
 * JD-Core Version:    0.7.0.1
 */