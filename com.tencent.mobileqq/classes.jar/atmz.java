import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atmz
  implements View.OnClickListener
{
  atmz(atmx paramatmx, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (atmx.a(this.jdField_a_of_type_Atmx) != null) {}
    for (boolean bool = atmx.a(this.jdField_a_of_type_Atmx).a(paramView);; bool = false)
    {
      this.jdField_a_of_type_Atmx.hideSoftInputFromWindow();
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Atmx, 1);
      }
      if (atmx.a(this.jdField_a_of_type_Atmx))
      {
        atmx.a(this.jdField_a_of_type_Atmx).removeView(atmx.a(this.jdField_a_of_type_Atmx));
        atmx.a(this.jdField_a_of_type_Atmx, false);
      }
      try
      {
        if ((this.jdField_a_of_type_Atmx.isShowing()) && (!bool)) {
          this.jdField_a_of_type_Atmx.dismiss();
        }
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
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmz
 * JD-Core Version:    0.7.0.1
 */