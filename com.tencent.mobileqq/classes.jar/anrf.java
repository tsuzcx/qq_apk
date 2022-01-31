import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;

class anrf
  implements anrt
{
  anrf(anrc paramanrc, asun paramasun) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Asun.isShowing()) {
      this.jdField_a_of_type_Asun.dismiss();
    }
    anrc.a(this.jdField_a_of_type_Anrc);
    anrc.a(this.jdField_a_of_type_Anrc).a().b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Asun.a(paramInt);
  }
  
  public void a(anrb paramanrb)
  {
    if ((paramanrb != null) && (!this.jdField_a_of_type_Anrc.a.isFinishing())) {
      switch (paramanrb.a)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Asun.isShowing()) {
        this.jdField_a_of_type_Asun.dismiss();
      }
      anrc.a(this.jdField_a_of_type_Anrc);
      anrc.a(this.jdField_a_of_type_Anrc).a().b();
      return;
      bcql.a(this.jdField_a_of_type_Anrc.a.getApplicationContext(), this.jdField_a_of_type_Anrc.a.getString(2131718834), 0).a();
      continue;
      if (paramanrb.b == 10006)
      {
        bcql.a(this.jdField_a_of_type_Anrc.a.getApplicationContext(), this.jdField_a_of_type_Anrc.a.getString(2131718825), 0).a();
      }
      else
      {
        bcql.a(this.jdField_a_of_type_Anrc.a.getApplicationContext(), this.jdField_a_of_type_Anrc.a.getString(2131718829), 0).a();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "onSaveComplete " + this.jdField_a_of_type_Anrc.a.isFinishing());
        }
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Asun.isShowing())
    {
      this.jdField_a_of_type_Asun.a(0);
      this.jdField_a_of_type_Asun.a(new anrg(this));
      if (QLog.isColorLevel()) {
        QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
      }
      this.jdField_a_of_type_Asun.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anrf
 * JD-Core Version:    0.7.0.1
 */