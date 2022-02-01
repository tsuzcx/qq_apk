import android.os.Message;
import com.tencent.qphone.base.util.QLog;

public class bamm
  extends bame
{
  private bakj jdField_a_of_type_Bakj;
  private bakz jdField_a_of_type_Bakz;
  private balo jdField_a_of_type_Balo;
  private bals jdField_a_of_type_Bals;
  private balt jdField_a_of_type_Balt;
  private balx jdField_a_of_type_Balx;
  private balz jdField_a_of_type_Balz;
  private bama jdField_a_of_type_Bama;
  private bamb jdField_a_of_type_Bamb;
  private bamc jdField_a_of_type_Bamc;
  private bamn jdField_a_of_type_Bamn;
  
  public bamm(String paramString, bakz parambakz)
  {
    super(paramString);
    this.jdField_a_of_type_Bakz = parambakz;
    k();
  }
  
  private void k()
  {
    this.jdField_a_of_type_Balz = new balz(this);
    this.jdField_a_of_type_Bamn = new bamn(this);
    this.jdField_a_of_type_Bamc = new bamc(this);
    this.jdField_a_of_type_Balx = new balx(this);
    this.jdField_a_of_type_Bamb = new bamb(this);
    this.jdField_a_of_type_Bama = new bama(this);
    a(this.jdField_a_of_type_Balz);
    a(this.jdField_a_of_type_Bamn);
    a(this.jdField_a_of_type_Bamc);
    a(this.jdField_a_of_type_Balx);
    a(this.jdField_a_of_type_Bamb);
    a(this.jdField_a_of_type_Bama);
    b(this.jdField_a_of_type_Balz);
  }
  
  public bajj a()
  {
    if ((this.jdField_a_of_type_Balx != null) && (this.jdField_a_of_type_Balx.a() != null)) {
      return this.jdField_a_of_type_Balx.a().a();
    }
    return null;
  }
  
  public bakj a()
  {
    if (this.jdField_a_of_type_Bakj == null) {
      this.jdField_a_of_type_Bakj = new bakj();
    }
    return this.jdField_a_of_type_Bakj;
  }
  
  public bakz a()
  {
    return this.jdField_a_of_type_Bakz;
  }
  
  public balo a()
  {
    return this.jdField_a_of_type_Balo;
  }
  
  public bals a()
  {
    return this.jdField_a_of_type_Bals;
  }
  
  public void a(bali parambali)
  {
    b(4, parambali);
    if (this.jdField_a_of_type_Bals != null) {
      this.jdField_a_of_type_Bals.e();
    }
  }
  
  public void a(balo parambalo)
  {
    this.jdField_a_of_type_Balo = parambalo;
  }
  
  public void a(bals parambals)
  {
    this.jdField_a_of_type_Bals = parambals;
  }
  
  public void a(balu parambalu)
  {
    if ((parambalu != null) && (this.jdField_a_of_type_Balx != null) && (this.jdField_a_of_type_Balx.a() != null))
    {
      this.jdField_a_of_type_Balx.a().a(parambalu);
      this.jdField_a_of_type_Balt = this.jdField_a_of_type_Balx.a();
      return;
    }
    this.jdField_a_of_type_Balt = null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bakj != null) && (this.jdField_a_of_type_Bakj.a());
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantStateMachine", 2, "doSendMessage what = " + paramInt + ", currentState = " + a());
    }
    a(paramInt);
  }
  
  public void b(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Balt != null) {}
    switch (paramInt)
    {
    default: 
      bakl.a("VoiceAssistantStateMachine", "onVoiceMessageCallBack status error = " + paramInt);
      return;
    case 1: 
      bhcl.b(2131230733, false);
      this.jdField_a_of_type_Balt.d();
      return;
    case 2: 
      this.jdField_a_of_type_Balt.e();
      bhcl.b(2131230732, false);
      return;
    case 3: 
      this.jdField_a_of_type_Balt.f();
      bhcl.b(2131230732, false);
      return;
    }
    this.jdField_a_of_type_Balt.a(paramObject);
    bhcl.b(2131230732, false);
  }
  
  protected void b(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.b(paramMessage);
      return;
      c(5);
      a(paramMessage);
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantStateMachine", 2, "transitionToState type = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantStateMachine", 2, "transitionToState exception type = " + paramInt);
      }
      return;
    case 1: 
      a(this.jdField_a_of_type_Balz);
      return;
    case 2: 
      a(this.jdField_a_of_type_Bamn);
      return;
    case 3: 
      a(this.jdField_a_of_type_Bamc);
      return;
    case 4: 
      a(this.jdField_a_of_type_Balx);
      return;
    case 5: 
      a(this.jdField_a_of_type_Bamb);
      return;
    }
    a(this.jdField_a_of_type_Bama);
  }
  
  public void e()
  {
    d();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bakj != null) {
      this.jdField_a_of_type_Bakj.a();
    }
  }
  
  public void g()
  {
    b(2, null);
    if (this.jdField_a_of_type_Bals != null) {
      this.jdField_a_of_type_Bals.c();
    }
  }
  
  public void h()
  {
    b(1, null);
    if (this.jdField_a_of_type_Bals != null) {
      this.jdField_a_of_type_Bals.d();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bals != null) {
      this.jdField_a_of_type_Bals.g();
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantStateMachine", 2, "doQuit");
    }
    c(6);
    a(null);
    a(null);
    a(null);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamm
 * JD-Core Version:    0.7.0.1
 */