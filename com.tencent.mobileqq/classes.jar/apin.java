import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class apin
  implements apjb
{
  apin(apik paramapik, aulk paramaulk) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Aulk.isShowing()) {
      this.jdField_a_of_type_Aulk.dismiss();
    }
    apik.a(this.jdField_a_of_type_Apik);
    apik.a(this.jdField_a_of_type_Apik).a().b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Aulk.a(paramInt);
  }
  
  public void a(apij paramapij)
  {
    if ((paramapij != null) && (!this.jdField_a_of_type_Apik.a.isFinishing())) {
      switch (paramapij.a)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aulk.isShowing()) {
        this.jdField_a_of_type_Aulk.dismiss();
      }
      apik.a(this.jdField_a_of_type_Apik);
      apik.a(this.jdField_a_of_type_Apik).a().b();
      return;
      QQToast.a(this.jdField_a_of_type_Apik.a.getApplicationContext(), this.jdField_a_of_type_Apik.a.getString(2131719309), 0).a();
      continue;
      if (paramapij.b == 10006)
      {
        QQToast.a(this.jdField_a_of_type_Apik.a.getApplicationContext(), this.jdField_a_of_type_Apik.a.getString(2131719300), 0).a();
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_Apik.a.getApplicationContext(), this.jdField_a_of_type_Apik.a.getString(2131719304), 0).a();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "onSaveComplete " + this.jdField_a_of_type_Apik.a.isFinishing());
        }
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Aulk.isShowing())
    {
      this.jdField_a_of_type_Aulk.a(0);
      this.jdField_a_of_type_Aulk.a(new apio(this));
      if (QLog.isColorLevel()) {
        QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
      }
      this.jdField_a_of_type_Aulk.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apin
 * JD-Core Version:    0.7.0.1
 */