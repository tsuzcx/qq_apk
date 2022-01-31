import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class arzt
  extends amab
{
  arzt(arzs paramarzs) {}
  
  public void a(boolean paramBoolean, bctb parambctb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onTroopShareLink start");
    }
    this.a.x();
    if (arzs.a(this.a) != -1)
    {
      if ((!paramBoolean) || (parambctb.jdField_a_of_type_Int != 0)) {
        break label189;
      }
      if (parambctb.jdField_a_of_type_Boolean)
      {
        arzs.a(this.a, parambctb.b);
        if (arzs.a(this.a) == 0) {}
      }
      else
      {
        do
        {
          return;
          arzs.b(this.a, parambctb.b);
        } while (arzs.a(this.a) != 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + arzs.a(this.a) + " mTroopNotNeedVefifyLink=" + arzs.b(this.a));
      }
      if ((parambctb.jdField_a_of_type_JavaLangString != null) && (parambctb.jdField_a_of_type_JavaLangString.equals(arzs.c(this.a)))) {
        arzs.a(this.a);
      }
    }
    for (;;)
    {
      arzs.a(this.a, -1);
      return;
      label189:
      if (((parambctb.jdField_a_of_type_Boolean) && (arzs.a(this.a) != 0)) || ((!parambctb.jdField_a_of_type_Boolean) && (arzs.a(this.a) != 1))) {
        break;
      }
      QQToast.a(this.a.a, 1, this.a.a.getString(2131693134), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzt
 * JD-Core Version:    0.7.0.1
 */