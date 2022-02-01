import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class avcr
  extends aojs
{
  public avcr(ForwardShareCardOption paramForwardShareCardOption) {}
  
  public void a(boolean paramBoolean, bhbw parambhbw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onTroopShareLink start");
    }
    this.a.z();
    if (ForwardShareCardOption.a(this.a) != -1)
    {
      if ((!paramBoolean) || (parambhbw.jdField_a_of_type_Int != 0)) {
        break label189;
      }
      if (parambhbw.jdField_a_of_type_Boolean)
      {
        ForwardShareCardOption.a(this.a, parambhbw.b);
        if (ForwardShareCardOption.a(this.a) == 0) {}
      }
      else
      {
        do
        {
          return;
          ForwardShareCardOption.b(this.a, parambhbw.b);
        } while (ForwardShareCardOption.a(this.a) != 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + ForwardShareCardOption.a(this.a) + " mTroopNotNeedVefifyLink=" + ForwardShareCardOption.b(this.a));
      }
      if ((parambhbw.jdField_a_of_type_JavaLangString != null) && (parambhbw.jdField_a_of_type_JavaLangString.equals(ForwardShareCardOption.c(this.a)))) {
        ForwardShareCardOption.a(this.a);
      }
    }
    for (;;)
    {
      ForwardShareCardOption.a(this.a, -1);
      return;
      label189:
      if (((parambhbw.jdField_a_of_type_Boolean) && (ForwardShareCardOption.a(this.a) != 0)) || ((!parambhbw.jdField_a_of_type_Boolean) && (ForwardShareCardOption.a(this.a) != 1))) {
        break;
      }
      QQToast.a(this.a.a, 1, this.a.a.getString(2131692671), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcr
 * JD-Core Version:    0.7.0.1
 */