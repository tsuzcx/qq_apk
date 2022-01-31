import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku.1;

public class angi
  extends angh
{
  private anhl a;
  private boolean e;
  
  public angi(angj paramangj)
  {
    super(paramangj);
  }
  
  public int a()
  {
    return -2147483647;
  }
  
  public anhl a()
  {
    return this.a;
  }
  
  public anhn a(anhx paramanhx)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramanhx);
      if (localView != null) {
        anfj.a().a().a().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramanhx);
  }
  
  public void a(anhl paramanhl)
  {
    this.a = paramanhl;
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
 * Qualified Name:     angi
 * JD-Core Version:    0.7.0.1
 */