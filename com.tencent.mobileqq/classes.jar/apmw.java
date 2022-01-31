import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class apmw
  implements apnk
{
  apmw(apmt paramapmt, aupt paramaupt) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Aupt.isShowing()) {
      this.jdField_a_of_type_Aupt.dismiss();
    }
    apmt.a(this.jdField_a_of_type_Apmt);
    apmt.a(this.jdField_a_of_type_Apmt).a().b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Aupt.a(paramInt);
  }
  
  public void a(apms paramapms)
  {
    if ((paramapms != null) && (!this.jdField_a_of_type_Apmt.a.isFinishing())) {
      switch (paramapms.a)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aupt.isShowing()) {
        this.jdField_a_of_type_Aupt.dismiss();
      }
      apmt.a(this.jdField_a_of_type_Apmt);
      apmt.a(this.jdField_a_of_type_Apmt).a().b();
      return;
      QQToast.a(this.jdField_a_of_type_Apmt.a.getApplicationContext(), this.jdField_a_of_type_Apmt.a.getString(2131719321), 0).a();
      continue;
      if (paramapms.b == 10006)
      {
        QQToast.a(this.jdField_a_of_type_Apmt.a.getApplicationContext(), this.jdField_a_of_type_Apmt.a.getString(2131719312), 0).a();
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_Apmt.a.getApplicationContext(), this.jdField_a_of_type_Apmt.a.getString(2131719316), 0).a();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "onSaveComplete " + this.jdField_a_of_type_Apmt.a.isFinishing());
        }
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Aupt.isShowing())
    {
      this.jdField_a_of_type_Aupt.a(0);
      this.jdField_a_of_type_Aupt.a(new apmx(this));
      if (QLog.isColorLevel()) {
        QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
      }
      this.jdField_a_of_type_Aupt.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmw
 * JD-Core Version:    0.7.0.1
 */