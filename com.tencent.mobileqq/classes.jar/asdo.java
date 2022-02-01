import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class asdo
  implements asec
{
  asdo(asdl paramasdl, axjb paramaxjb) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Axjb.isShowing()) {
      this.jdField_a_of_type_Axjb.dismiss();
    }
    asdl.a(this.jdField_a_of_type_Asdl);
    asdl.a(this.jdField_a_of_type_Asdl).a().b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Axjb.a(paramInt);
  }
  
  public void a(asdk paramasdk)
  {
    if ((paramasdk != null) && (!this.jdField_a_of_type_Asdl.a.isFinishing())) {
      switch (paramasdk.a)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Axjb.isShowing()) {
        this.jdField_a_of_type_Axjb.dismiss();
      }
      asdl.a(this.jdField_a_of_type_Asdl);
      asdl.a(this.jdField_a_of_type_Asdl).a().b();
      return;
      QQToast.a(this.jdField_a_of_type_Asdl.a.getApplicationContext(), this.jdField_a_of_type_Asdl.a.getString(2131718157), 0).a();
      continue;
      if (paramasdk.b == 10006)
      {
        QQToast.a(this.jdField_a_of_type_Asdl.a.getApplicationContext(), this.jdField_a_of_type_Asdl.a.getString(2131718148), 0).a();
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_Asdl.a.getApplicationContext(), this.jdField_a_of_type_Asdl.a.getString(2131718152), 0).a();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "onSaveComplete " + this.jdField_a_of_type_Asdl.a.isFinishing());
        }
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Axjb.isShowing())
    {
      this.jdField_a_of_type_Axjb.a(0);
      this.jdField_a_of_type_Axjb.a(new asdp(this));
      if (QLog.isColorLevel()) {
        QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
      }
      this.jdField_a_of_type_Axjb.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdo
 * JD-Core Version:    0.7.0.1
 */