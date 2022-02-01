import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class arps
  implements arqg
{
  arps(arpp paramarpp, awwz paramawwz) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Awwz.isShowing()) {
      this.jdField_a_of_type_Awwz.dismiss();
    }
    arpp.a(this.jdField_a_of_type_Arpp);
    arpp.a(this.jdField_a_of_type_Arpp).a().b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Awwz.a(paramInt);
  }
  
  public void a(arpo paramarpo)
  {
    if ((paramarpo != null) && (!this.jdField_a_of_type_Arpp.a.isFinishing())) {
      switch (paramarpo.a)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Awwz.isShowing()) {
        this.jdField_a_of_type_Awwz.dismiss();
      }
      arpp.a(this.jdField_a_of_type_Arpp);
      arpp.a(this.jdField_a_of_type_Arpp).a().b();
      return;
      QQToast.a(this.jdField_a_of_type_Arpp.a.getApplicationContext(), this.jdField_a_of_type_Arpp.a.getString(2131717408), 0).a();
      continue;
      if (paramarpo.b == 10006)
      {
        QQToast.a(this.jdField_a_of_type_Arpp.a.getApplicationContext(), this.jdField_a_of_type_Arpp.a.getString(2131717399), 0).a();
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_Arpp.a.getApplicationContext(), this.jdField_a_of_type_Arpp.a.getString(2131717403), 0).a();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "onSaveComplete " + this.jdField_a_of_type_Arpp.a.isFinishing());
        }
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Awwz.isShowing())
    {
      this.jdField_a_of_type_Awwz.a(0);
      this.jdField_a_of_type_Awwz.a(new arpt(this));
      if (QLog.isColorLevel()) {
        QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
      }
      this.jdField_a_of_type_Awwz.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arps
 * JD-Core Version:    0.7.0.1
 */