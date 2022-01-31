import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class bbif
  implements View.OnClickListener
{
  bbif(bbie parambbie, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick timeGap:" + (System.currentTimeMillis() - bbie.a(this.jdField_a_of_type_Bbie)) + " MANUFACTURER:" + Build.MANUFACTURER + " MODEL:" + Build.MODEL);
    }
    if ((System.currentTimeMillis() - bbie.a(this.jdField_a_of_type_Bbie) < 800L) && ("VIVO".equalsIgnoreCase(Build.MANUFACTURER)) && ((Build.MODEL.toUpperCase().contains("Y8")) || (Build.MODEL.toUpperCase().contains("V18")))) {
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
          paramView = bbie.a(this.jdField_a_of_type_Bbie).getText().toString();
        } while (paramView == null);
        if ((!aykk.a(paramView)) && (!aykk.b(paramView))) {
          break;
        }
        paramView = (Context)bbie.a(this.jdField_a_of_type_Bbie).get();
      } while (paramView == null);
      paramView = new bcql(paramView);
      paramView.d(2000);
      paramView.c(2131720338);
      paramView.a();
      return;
      if ((bbie.a(this.jdField_a_of_type_Bbie) != null) || (24 >= paramView.getBytes().length)) {
        break;
      }
      paramView = (Context)bbie.a(this.jdField_a_of_type_Bbie).get();
    } while (paramView == null);
    paramView = new bcql(paramView);
    paramView.d(2000);
    paramView.c(2131720339);
    paramView.a();
    return;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bbie, 1);
    }
    this.jdField_a_of_type_Bbie.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbif
 * JD-Core Version:    0.7.0.1
 */