import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auid
  implements View.OnClickListener
{
  auid(auhv paramauhv, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Auhv.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Auhv, 0);
    }
    if (auhv.a(this.jdField_a_of_type_Auhv))
    {
      auhv.a(this.jdField_a_of_type_Auhv).removeView(auhv.a(this.jdField_a_of_type_Auhv));
      auhv.a(this.jdField_a_of_type_Auhv, false);
    }
    try
    {
      if (this.jdField_a_of_type_Auhv.isShowing()) {
        this.jdField_a_of_type_Auhv.dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Forward.NewVersion.Dialog", 2, Log.getStackTraceString(localException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auid
 * JD-Core Version:    0.7.0.1
 */