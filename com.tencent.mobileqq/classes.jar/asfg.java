import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class asfg
  implements asfu
{
  asfg(asfd paramasfd, axps paramaxps) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Axps.isShowing()) {
      this.jdField_a_of_type_Axps.dismiss();
    }
    asfd.a(this.jdField_a_of_type_Asfd);
    asfd.a(this.jdField_a_of_type_Asfd).a().b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Axps.a(paramInt);
  }
  
  public void a(asfc paramasfc)
  {
    if ((paramasfc != null) && (!this.jdField_a_of_type_Asfd.a.isFinishing())) {
      switch (paramasfc.a)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Axps.isShowing()) {
        this.jdField_a_of_type_Axps.dismiss();
      }
      asfd.a(this.jdField_a_of_type_Asfd);
      asfd.a(this.jdField_a_of_type_Asfd).a().b();
      return;
      QQToast.a(this.jdField_a_of_type_Asfd.a.getApplicationContext(), this.jdField_a_of_type_Asfd.a.getString(2131717539), 0).a();
      continue;
      if (paramasfc.b == 10006)
      {
        QQToast.a(this.jdField_a_of_type_Asfd.a.getApplicationContext(), this.jdField_a_of_type_Asfd.a.getString(2131717530), 0).a();
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_Asfd.a.getApplicationContext(), this.jdField_a_of_type_Asfd.a.getString(2131717534), 0).a();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "onSaveComplete " + this.jdField_a_of_type_Asfd.a.isFinishing());
        }
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Axps.isShowing())
    {
      this.jdField_a_of_type_Axps.a(0);
      this.jdField_a_of_type_Axps.a(new asfh(this));
      if (QLog.isColorLevel()) {
        QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
      }
      this.jdField_a_of_type_Axps.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfg
 * JD-Core Version:    0.7.0.1
 */