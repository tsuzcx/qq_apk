import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aqze
  implements aqzs
{
  aqze(aqzb paramaqzb, awcz paramawcz) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Awcz.isShowing()) {
      this.jdField_a_of_type_Awcz.dismiss();
    }
    aqzb.a(this.jdField_a_of_type_Aqzb);
    aqzb.a(this.jdField_a_of_type_Aqzb).a().b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Awcz.a(paramInt);
  }
  
  public void a(aqza paramaqza)
  {
    if ((paramaqza != null) && (!this.jdField_a_of_type_Aqzb.a.isFinishing())) {
      switch (paramaqza.a)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Awcz.isShowing()) {
        this.jdField_a_of_type_Awcz.dismiss();
      }
      aqzb.a(this.jdField_a_of_type_Aqzb);
      aqzb.a(this.jdField_a_of_type_Aqzb).a().b();
      return;
      QQToast.a(this.jdField_a_of_type_Aqzb.a.getApplicationContext(), this.jdField_a_of_type_Aqzb.a.getString(2131717775), 0).a();
      continue;
      if (paramaqza.b == 10006)
      {
        QQToast.a(this.jdField_a_of_type_Aqzb.a.getApplicationContext(), this.jdField_a_of_type_Aqzb.a.getString(2131717766), 0).a();
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_Aqzb.a.getApplicationContext(), this.jdField_a_of_type_Aqzb.a.getString(2131717770), 0).a();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "onSaveComplete " + this.jdField_a_of_type_Aqzb.a.isFinishing());
        }
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Awcz.isShowing())
    {
      this.jdField_a_of_type_Awcz.a(0);
      this.jdField_a_of_type_Awcz.a(new aqzf(this));
      if (QLog.isColorLevel()) {
        QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
      }
      this.jdField_a_of_type_Awcz.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqze
 * JD-Core Version:    0.7.0.1
 */