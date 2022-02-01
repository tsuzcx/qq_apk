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

class bgqm
  implements View.OnClickListener
{
  bgqm(bgql parambgql, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick timeGap:" + (System.currentTimeMillis() - bgql.a(this.jdField_a_of_type_Bgql)) + " MANUFACTURER:" + Build.MANUFACTURER + " MODEL:" + Build.MODEL);
    }
    if ((System.currentTimeMillis() - bgql.a(this.jdField_a_of_type_Bgql) < 800L) && (bgql.a(this.jdField_a_of_type_Bgql))) {
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick skip");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = bgql.a(this.jdField_a_of_type_Bgql).getText().toString();
      if (localObject != null) {
        if ((bdnt.a((String)localObject)) || (bdnt.b((String)localObject)))
        {
          localObject = (Context)bgql.a(this.jdField_a_of_type_Bgql).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).d(2000);
            ((QQToast)localObject).c(2131718625);
            ((QQToast)localObject).a();
          }
        }
        else if ((bgql.a(this.jdField_a_of_type_Bgql) == null) && (24 < ((String)localObject).getBytes().length))
        {
          localObject = (Context)bgql.a(this.jdField_a_of_type_Bgql).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).d(2000);
            ((QQToast)localObject).c(2131718626);
            ((QQToast)localObject).a();
          }
        }
        else
        {
          if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
            this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bgql, 1);
          }
          this.jdField_a_of_type_Bgql.dismiss();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgqm
 * JD-Core Version:    0.7.0.1
 */