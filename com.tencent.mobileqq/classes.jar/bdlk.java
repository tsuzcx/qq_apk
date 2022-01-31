import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class bdlk
  implements View.OnClickListener
{
  bdlk(bdlj parambdlj, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick timeGap:" + (System.currentTimeMillis() - bdlj.a(this.jdField_a_of_type_Bdlj)) + " MANUFACTURER:" + Build.MANUFACTURER + " MODEL:" + Build.MODEL);
    }
    if ((System.currentTimeMillis() - bdlj.a(this.jdField_a_of_type_Bdlj) < 800L) && ("VIVO".equalsIgnoreCase(Build.MANUFACTURER)) && ((Build.MODEL.toUpperCase().contains("Y8")) || (Build.MODEL.toUpperCase().contains("V18")))) {
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
          paramView = bdlj.a(this.jdField_a_of_type_Bdlj).getText().toString();
        } while (paramView == null);
        if ((!bamp.a(paramView)) && (!bamp.b(paramView))) {
          break;
        }
        paramView = (Context)bdlj.a(this.jdField_a_of_type_Bdlj).get();
      } while (paramView == null);
      paramView = new QQToast(paramView);
      paramView.d(2000);
      paramView.c(2131720886);
      paramView.a();
      return;
      if ((bdlj.a(this.jdField_a_of_type_Bdlj) != null) || (24 >= paramView.getBytes().length)) {
        break;
      }
      paramView = (Context)bdlj.a(this.jdField_a_of_type_Bdlj).get();
    } while (paramView == null);
    paramView = new QQToast(paramView);
    paramView.d(2000);
    paramView.c(2131720887);
    paramView.a();
    return;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bdlj, 1);
    }
    this.jdField_a_of_type_Bdlj.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdlk
 * JD-Core Version:    0.7.0.1
 */