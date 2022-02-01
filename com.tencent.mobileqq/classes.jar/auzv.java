import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auzv
  implements View.OnClickListener
{
  auzv(auzt paramauzt, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (auzt.a(this.jdField_a_of_type_Auzt) != null) {}
    for (boolean bool = auzt.a(this.jdField_a_of_type_Auzt).a(paramView);; bool = false)
    {
      this.jdField_a_of_type_Auzt.hideSoftInputFromWindow();
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Auzt, 1);
      }
      if (auzt.a(this.jdField_a_of_type_Auzt))
      {
        auzt.a(this.jdField_a_of_type_Auzt).removeView(auzt.a(this.jdField_a_of_type_Auzt));
        auzt.a(this.jdField_a_of_type_Auzt, false);
      }
      try
      {
        if ((this.jdField_a_of_type_Auzt.isShowing()) && (!bool)) {
          this.jdField_a_of_type_Auzt.dismiss();
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
 * Qualified Name:     auzv
 * JD-Core Version:    0.7.0.1
 */