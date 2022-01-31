import android.content.Intent;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.observer.WtloginObserver;

public class avqa
  extends avpz
{
  protected static final String a;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new avqb(this);
  private boolean jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getBooleanExtra("key_register_from_send_sms", false);
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String b;
  private String c = "";
  private String d = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getStringExtra("key_register_fail_paid_lh");
  
  static
  {
    jdField_a_of_type_JavaLangString = avqa.class.getSimpleName();
  }
  
  public avqa(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    if (this.c == null) {
      this.c = "";
    }
  }
  
  public void a() {}
  
  public void a(Intent paramIntent)
  {
    this.c = paramIntent.getStringExtra("key_register_smscode");
    if (this.c == null) {
      this.c = "";
    }
    this.d = paramIntent.getStringExtra("key_register_from_fail_pay_lh");
    a(paramIntent.getStringExtra("key_register_nick"));
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 4, String.format(Locale.getDefault(), "doAction nick: %s, unBindUin: %s, smsCode: %s", new Object[] { paramString, this.d, this.c }));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.b(2131717069);
      if (aumi.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.app, this.c.getBytes(), paramString.getBytes(), this.d, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131717132, 1);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avqa
 * JD-Core Version:    0.7.0.1
 */