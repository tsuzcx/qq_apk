import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class aqgc
  extends akim
{
  aqgc(aqgb paramaqgb) {}
  
  public void a(boolean paramBoolean, batt parambatt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onTroopShareLink start");
    }
    this.a.x();
    if (aqgb.a(this.a) != -1)
    {
      if ((!paramBoolean) || (parambatt.jdField_a_of_type_Int != 0)) {
        break label189;
      }
      if (parambatt.jdField_a_of_type_Boolean)
      {
        aqgb.a(this.a, parambatt.b);
        if (aqgb.a(this.a) == 0) {}
      }
      else
      {
        do
        {
          return;
          aqgb.b(this.a, parambatt.b);
        } while (aqgb.a(this.a) != 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + aqgb.a(this.a) + " mTroopNotNeedVefifyLink=" + aqgb.b(this.a));
      }
      if ((parambatt.jdField_a_of_type_JavaLangString != null) && (parambatt.jdField_a_of_type_JavaLangString.equals(aqgb.c(this.a)))) {
        aqgb.a(this.a);
      }
    }
    for (;;)
    {
      aqgb.a(this.a, -1);
      return;
      label189:
      if (((parambatt.jdField_a_of_type_Boolean) && (aqgb.a(this.a) != 0)) || ((!parambatt.jdField_a_of_type_Boolean) && (aqgb.a(this.a) != 1))) {
        break;
      }
      bcpw.a(this.a.a, 1, this.a.a.getString(2131693032), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgc
 * JD-Core Version:    0.7.0.1
 */