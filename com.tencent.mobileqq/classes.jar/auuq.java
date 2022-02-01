import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class auuq
  extends aofu
{
  public auuq(ForwardShareCardOption paramForwardShareCardOption) {}
  
  public void onTroopShareLink(boolean paramBoolean, bgtz parambgtz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onTroopShareLink start");
    }
    this.a.z();
    if (ForwardShareCardOption.a(this.a) != -1)
    {
      if ((!paramBoolean) || (parambgtz.jdField_a_of_type_Int != 0)) {
        break label189;
      }
      if (parambgtz.jdField_a_of_type_Boolean)
      {
        ForwardShareCardOption.a(this.a, parambgtz.b);
        if (ForwardShareCardOption.a(this.a) == 0) {}
      }
      else
      {
        do
        {
          return;
          ForwardShareCardOption.b(this.a, parambgtz.b);
        } while (ForwardShareCardOption.a(this.a) != 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + ForwardShareCardOption.a(this.a) + " mTroopNotNeedVefifyLink=" + ForwardShareCardOption.b(this.a));
      }
      if ((parambgtz.jdField_a_of_type_JavaLangString != null) && (parambgtz.jdField_a_of_type_JavaLangString.equals(ForwardShareCardOption.c(this.a)))) {
        ForwardShareCardOption.a(this.a);
      }
    }
    for (;;)
    {
      ForwardShareCardOption.a(this.a, -1);
      return;
      label189:
      if (((parambgtz.jdField_a_of_type_Boolean) && (ForwardShareCardOption.a(this.a) != 0)) || ((!parambgtz.jdField_a_of_type_Boolean) && (ForwardShareCardOption.a(this.a) != 1))) {
        break;
      }
      QQToast.a(this.a.a, 1, this.a.a.getString(2131692824), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auuq
 * JD-Core Version:    0.7.0.1
 */