import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.statemachine.QuitVoicePanelState.1;
import mqq.os.MqqHandler;

public class bamb
  extends bamd
{
  private bamm a;
  
  public bamb(bamm parambamm)
  {
    this.a = parambamm;
  }
  
  public String a()
  {
    return bamb.class.getSimpleName();
  }
  
  public void a()
  {
    super.a();
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.a(paramMessage);
    }
    if (this.a != null)
    {
      if (((paramMessage.obj instanceof Boolean)) && (this.a.a() != null))
      {
        boolean bool = ((Boolean)paramMessage.obj).booleanValue();
        ThreadManager.getUIHandler().post(new QuitVoicePanelState.1(this, bool));
      }
      if (this.a.a() != null) {
        this.a.a().b();
      }
      this.a.c(1);
      this.a.a(1);
    }
    return true;
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamb
 * JD-Core Version:    0.7.0.1
 */