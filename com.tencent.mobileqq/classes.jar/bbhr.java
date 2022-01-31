import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class bbhr
  implements View.OnClickListener
{
  bbhr(bbhq parambbhq, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick timeGap:" + (System.currentTimeMillis() - bbhq.a(this.jdField_a_of_type_Bbhq)) + " MANUFACTURER:" + Build.MANUFACTURER + " MODEL:" + Build.MODEL);
    }
    if ((System.currentTimeMillis() - bbhq.a(this.jdField_a_of_type_Bbhq) < 800L) && ("VIVO".equalsIgnoreCase(Build.MANUFACTURER)) && ((Build.MODEL.toUpperCase().contains("Y8")) || (Build.MODEL.toUpperCase().contains("V18")))) {
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
          paramView = bbhq.a(this.jdField_a_of_type_Bbhq).getText().toString();
        } while (paramView == null);
        if ((!ayki.a(paramView)) && (!ayki.b(paramView))) {
          break;
        }
        paramView = (Context)bbhq.a(this.jdField_a_of_type_Bbhq).get();
      } while (paramView == null);
      paramView = new bcpw(paramView);
      paramView.d(2000);
      paramView.c(2131720327);
      paramView.a();
      return;
      if ((bbhq.a(this.jdField_a_of_type_Bbhq) != null) || (24 >= paramView.getBytes().length)) {
        break;
      }
      paramView = (Context)bbhq.a(this.jdField_a_of_type_Bbhq).get();
    } while (paramView == null);
    paramView = new bcpw(paramView);
    paramView.d(2000);
    paramView.c(2131720328);
    paramView.a();
    return;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bbhq, 1);
    }
    this.jdField_a_of_type_Bbhq.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhr
 * JD-Core Version:    0.7.0.1
 */