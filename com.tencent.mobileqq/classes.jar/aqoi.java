import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku.1;

public class aqoi
  extends aqoh
{
  private aqpl a;
  private boolean e;
  
  public aqoi(aqoj paramaqoj)
  {
    super(paramaqoj);
  }
  
  public int a()
  {
    return -2147483647;
  }
  
  public aqpl a()
  {
    return this.a;
  }
  
  public aqpn a(aqpx paramaqpx)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramaqpx);
      if (localView != null) {
        aqnj.a().a().a().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramaqpx);
  }
  
  public void a(aqpl paramaqpl)
  {
    this.a = paramaqpl;
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
 * Qualified Name:     aqoi
 * JD-Core Version:    0.7.0.1
 */