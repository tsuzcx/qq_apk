import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class aqge
  extends akil
{
  aqge(aqgd paramaqgd) {}
  
  public void a(boolean paramBoolean, bauh parambauh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onTroopShareLink start");
    }
    this.a.x();
    if (aqgd.a(this.a) != -1)
    {
      if ((!paramBoolean) || (parambauh.jdField_a_of_type_Int != 0)) {
        break label189;
      }
      if (parambauh.jdField_a_of_type_Boolean)
      {
        aqgd.a(this.a, parambauh.b);
        if (aqgd.a(this.a) == 0) {}
      }
      else
      {
        do
        {
          return;
          aqgd.b(this.a, parambauh.b);
        } while (aqgd.a(this.a) != 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + aqgd.a(this.a) + " mTroopNotNeedVefifyLink=" + aqgd.b(this.a));
      }
      if ((parambauh.jdField_a_of_type_JavaLangString != null) && (parambauh.jdField_a_of_type_JavaLangString.equals(aqgd.c(this.a)))) {
        aqgd.a(this.a);
      }
    }
    for (;;)
    {
      aqgd.a(this.a, -1);
      return;
      label189:
      if (((parambauh.jdField_a_of_type_Boolean) && (aqgd.a(this.a) != 0)) || ((!parambauh.jdField_a_of_type_Boolean) && (aqgd.a(this.a) != 1))) {
        break;
      }
      bcql.a(this.a.a, 1, this.a.a.getString(2131693033), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqge
 * JD-Core Version:    0.7.0.1
 */