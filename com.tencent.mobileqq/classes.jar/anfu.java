import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;

public class anfu
  extends ResourcePluginListener
{
  private anfu(GetConfig paramGetConfig) {}
  
  public void a(byte paramByte)
  {
    if (this.a.b == 44)
    {
      if ((paramByte != 2) && (paramByte == 3)) {}
      this.a.a.app.removeLebaListener(GetConfig.a(this.a));
      this.a.a(7);
    }
  }
  
  public void b(byte paramByte)
  {
    if ((paramByte != 2) && (paramByte == 3)) {}
    this.a.a.app.removeAboutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anfu
 * JD-Core Version:    0.7.0.1
 */