import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

class aqdj
  implements View.OnClickListener
{
  aqdj(aqdb paramaqdb, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Aqdb.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Aqdb, 0);
    }
    if (aqdb.a(this.jdField_a_of_type_Aqdb))
    {
      aqdb.a(this.jdField_a_of_type_Aqdb).removeView(aqdb.a(this.jdField_a_of_type_Aqdb));
      aqdb.a(this.jdField_a_of_type_Aqdb, false);
    }
    try
    {
      if (this.jdField_a_of_type_Aqdb.isShowing()) {
        this.jdField_a_of_type_Aqdb.dismiss();
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
 * Qualified Name:     aqdj
 * JD-Core Version:    0.7.0.1
 */