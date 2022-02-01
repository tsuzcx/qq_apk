import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auru
  implements View.OnClickListener
{
  auru(aurs paramaurs, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (aurs.a(this.jdField_a_of_type_Aurs) != null) {}
    for (boolean bool = aurs.a(this.jdField_a_of_type_Aurs).a(paramView);; bool = false)
    {
      this.jdField_a_of_type_Aurs.hideSoftInputFromWindow();
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Aurs, 1);
      }
      if (aurs.a(this.jdField_a_of_type_Aurs))
      {
        aurs.a(this.jdField_a_of_type_Aurs).removeView(aurs.a(this.jdField_a_of_type_Aurs));
        aurs.a(this.jdField_a_of_type_Aurs, false);
      }
      try
      {
        if ((this.jdField_a_of_type_Aurs.isShowing()) && (!bool)) {
          this.jdField_a_of_type_Aurs.dismiss();
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
 * Qualified Name:     auru
 * JD-Core Version:    0.7.0.1
 */