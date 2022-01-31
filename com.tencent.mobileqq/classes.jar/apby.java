import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku.1;

public class apby
  extends apbx
{
  private apdb a;
  private boolean e;
  
  public apby(apbz paramapbz)
  {
    super(paramapbz);
  }
  
  public int a()
  {
    return -2147483647;
  }
  
  public apdb a()
  {
    return this.a;
  }
  
  public apdd a(apdn paramapdn)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramapdn);
      if (localView != null) {
        apaz.a().a().a().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramapdn);
  }
  
  public void a(apdb paramapdb)
  {
    this.a = paramapdb;
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
 * Qualified Name:     apby
 * JD-Core Version:    0.7.0.1
 */