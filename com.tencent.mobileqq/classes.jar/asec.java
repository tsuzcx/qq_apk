import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class asec
  extends ameq
{
  asec(aseb paramaseb) {}
  
  public void a(boolean paramBoolean, bcxk parambcxk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onTroopShareLink start");
    }
    this.a.x();
    if (aseb.a(this.a) != -1)
    {
      if ((!paramBoolean) || (parambcxk.jdField_a_of_type_Int != 0)) {
        break label189;
      }
      if (parambcxk.jdField_a_of_type_Boolean)
      {
        aseb.a(this.a, parambcxk.b);
        if (aseb.a(this.a) == 0) {}
      }
      else
      {
        do
        {
          return;
          aseb.b(this.a, parambcxk.b);
        } while (aseb.a(this.a) != 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + aseb.a(this.a) + " mTroopNotNeedVefifyLink=" + aseb.b(this.a));
      }
      if ((parambcxk.jdField_a_of_type_JavaLangString != null) && (parambcxk.jdField_a_of_type_JavaLangString.equals(aseb.c(this.a)))) {
        aseb.a(this.a);
      }
    }
    for (;;)
    {
      aseb.a(this.a, -1);
      return;
      label189:
      if (((parambcxk.jdField_a_of_type_Boolean) && (aseb.a(this.a) != 0)) || ((!parambcxk.jdField_a_of_type_Boolean) && (aseb.a(this.a) != 1))) {
        break;
      }
      QQToast.a(this.a.a, 1, this.a.a.getString(2131693136), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asec
 * JD-Core Version:    0.7.0.1
 */