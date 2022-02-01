import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku.1;

public class arrt
  extends arrs
{
  private arsw a;
  private boolean e;
  
  public arrt(arru paramarru)
  {
    super(paramarru);
  }
  
  public int a()
  {
    return -2147483647;
  }
  
  public arsw a()
  {
    return this.a;
  }
  
  public arsy a(arti paramarti)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramarti);
      if (localView != null) {
        arqu.a().a().a().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramarti);
  }
  
  public void a(arsw paramarsw)
  {
    this.a = paramarsw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrt
 * JD-Core Version:    0.7.0.1
 */