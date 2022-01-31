import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;

class aqdl
  implements View.OnClickListener
{
  aqdl(aqdd paramaqdd, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Aqdd.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Aqdd, 0);
    }
    if (aqdd.a(this.jdField_a_of_type_Aqdd))
    {
      aqdd.a(this.jdField_a_of_type_Aqdd).removeView(aqdd.a(this.jdField_a_of_type_Aqdd));
      aqdd.a(this.jdField_a_of_type_Aqdd, false);
    }
    try
    {
      if (this.jdField_a_of_type_Aqdd.isShowing()) {
        this.jdField_a_of_type_Aqdd.dismiss();
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
 * Qualified Name:     aqdl
 * JD-Core Version:    0.7.0.1
 */