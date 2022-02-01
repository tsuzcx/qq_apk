import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;

class bhqo
  implements View.OnClickListener
{
  bhqo(bhqn parambhqn, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick timeGap:" + (System.currentTimeMillis() - bhqn.a(this.jdField_a_of_type_Bhqn)) + " MANUFACTURER:" + Build.MANUFACTURER + " MODEL:" + Build.MODEL);
    }
    if ((System.currentTimeMillis() - bhqn.a(this.jdField_a_of_type_Bhqn) < 800L) && (bhqn.a(this.jdField_a_of_type_Bhqn))) {
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick skip");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = bhqn.a(this.jdField_a_of_type_Bhqn).getText().toString();
      if (localObject != null) {
        if ((begp.a((String)localObject)) || (begp.b((String)localObject)))
        {
          localObject = (Context)bhqn.a(this.jdField_a_of_type_Bhqn).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).d(2000);
            ((QQToast)localObject).c(2131718761);
            ((QQToast)localObject).a();
          }
        }
        else if ((bhqn.a(this.jdField_a_of_type_Bhqn) == null) && (24 < ((String)localObject).getBytes().length))
        {
          localObject = (Context)bhqn.a(this.jdField_a_of_type_Bhqn).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).d(2000);
            ((QQToast)localObject).c(2131718762);
            ((QQToast)localObject).a();
          }
        }
        else
        {
          if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
            this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bhqn, 1);
          }
          this.jdField_a_of_type_Bhqn.dismiss();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhqo
 * JD-Core Version:    0.7.0.1
 */