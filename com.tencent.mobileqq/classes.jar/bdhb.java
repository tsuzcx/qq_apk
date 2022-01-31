import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class bdhb
  implements View.OnClickListener
{
  bdhb(bdha parambdha, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick timeGap:" + (System.currentTimeMillis() - bdha.a(this.jdField_a_of_type_Bdha)) + " MANUFACTURER:" + Build.MANUFACTURER + " MODEL:" + Build.MODEL);
    }
    if ((System.currentTimeMillis() - bdha.a(this.jdField_a_of_type_Bdha) < 800L) && ("VIVO".equalsIgnoreCase(Build.MANUFACTURER)) && ((Build.MODEL.toUpperCase().contains("Y8")) || (Build.MODEL.toUpperCase().contains("V18")))) {
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick skip");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = bdha.a(this.jdField_a_of_type_Bdha).getText().toString();
        } while (paramView == null);
        if ((!baig.a(paramView)) && (!baig.b(paramView))) {
          break;
        }
        paramView = (Context)bdha.a(this.jdField_a_of_type_Bdha).get();
      } while (paramView == null);
      paramView = new QQToast(paramView);
      paramView.d(2000);
      paramView.c(2131720874);
      paramView.a();
      return;
      if ((bdha.a(this.jdField_a_of_type_Bdha) != null) || (24 >= paramView.getBytes().length)) {
        break;
      }
      paramView = (Context)bdha.a(this.jdField_a_of_type_Bdha).get();
    } while (paramView == null);
    paramView = new QQToast(paramView);
    paramView.d(2000);
    paramView.c(2131720875);
    paramView.a();
    return;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bdha, 1);
    }
    this.jdField_a_of_type_Bdha.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhb
 * JD-Core Version:    0.7.0.1
 */