import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku.1;

public class aruk
  extends aruj
{
  private arvn a;
  private boolean e;
  
  public aruk(arul paramarul)
  {
    super(paramarul);
  }
  
  public int a()
  {
    return -2147483647;
  }
  
  public arvn a()
  {
    return this.a;
  }
  
  public arvp a(arvz paramarvz)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramarvz);
      if (localView != null) {
        artl.a().a().a().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramarvz);
  }
  
  public void a(arvn paramarvn)
  {
    this.a = paramarvn;
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
 * Qualified Name:     aruk
 * JD-Core Version:    0.7.0.1
 */