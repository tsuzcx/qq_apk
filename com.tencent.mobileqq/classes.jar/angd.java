import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku.1;

public class angd
  extends angc
{
  private anhg a;
  private boolean e;
  
  public angd(ange paramange)
  {
    super(paramange);
  }
  
  public int a()
  {
    return -2147483647;
  }
  
  public anhg a()
  {
    return this.a;
  }
  
  public anhi a(anhs paramanhs)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramanhs);
      if (localView != null) {
        anfe.a().a().a().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramanhs);
  }
  
  public void a(anhg paramanhg)
  {
    this.a = paramanhg;
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
 * Qualified Name:     angd
 * JD-Core Version:    0.7.0.1
 */