import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

class apjw
  implements View.OnClickListener
{
  apjw(apjo paramapjo, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Apjo.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Apjo, 0);
    }
    if (apjo.a(this.jdField_a_of_type_Apjo))
    {
      apjo.a(this.jdField_a_of_type_Apjo).removeView(apjo.a(this.jdField_a_of_type_Apjo));
      apjo.a(this.jdField_a_of_type_Apjo, false);
    }
    try
    {
      if (this.jdField_a_of_type_Apjo.isShowing()) {
        this.jdField_a_of_type_Apjo.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apjw
 * JD-Core Version:    0.7.0.1
 */