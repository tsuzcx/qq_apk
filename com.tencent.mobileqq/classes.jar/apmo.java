import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class apmo
  extends ajuc
{
  apmo(apmn paramapmn) {}
  
  public void a(boolean paramBoolean, azsp paramazsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onTroopShareLink start");
    }
    this.a.x();
    if (apmn.a(this.a) != -1)
    {
      if ((!paramBoolean) || (paramazsp.jdField_a_of_type_Int != 0)) {
        break label189;
      }
      if (paramazsp.jdField_a_of_type_Boolean)
      {
        apmn.a(this.a, paramazsp.b);
        if (apmn.a(this.a) == 0) {}
      }
      else
      {
        do
        {
          return;
          apmn.b(this.a, paramazsp.b);
        } while (apmn.a(this.a) != 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + apmn.a(this.a) + " mTroopNotNeedVefifyLink=" + apmn.b(this.a));
      }
      if ((paramazsp.jdField_a_of_type_JavaLangString != null) && (paramazsp.jdField_a_of_type_JavaLangString.equals(apmn.c(this.a)))) {
        apmn.a(this.a);
      }
    }
    for (;;)
    {
      apmn.a(this.a, -1);
      return;
      label189:
      if (((paramazsp.jdField_a_of_type_Boolean) && (apmn.a(this.a) != 0)) || ((!paramazsp.jdField_a_of_type_Boolean) && (apmn.a(this.a) != 1))) {
        break;
      }
      bbmy.a(this.a.a, 1, this.a.a.getString(2131627392), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmo
 * JD-Core Version:    0.7.0.1
 */