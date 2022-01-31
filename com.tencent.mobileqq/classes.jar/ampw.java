import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku.1;

public class ampw
  extends ampv
{
  private amqz a;
  private boolean e;
  
  public ampw(ampx paramampx)
  {
    super(paramampx);
  }
  
  public int a()
  {
    return -2147483647;
  }
  
  public amqz a()
  {
    return this.a;
  }
  
  public amrb a(amrl paramamrl)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramamrl);
      if (localView != null) {
        amox.a().a().a().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramamrl);
  }
  
  public void a(amqz paramamqz)
  {
    this.a = paramamqz;
  }
  
  public void e()
  {
    super.e();
    this.e = false;
  }
  
  public void f(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean i()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ampw
 * JD-Core Version:    0.7.0.1
 */