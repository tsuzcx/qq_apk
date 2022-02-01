import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku.1;

public class arev
  extends areu
{
  private arfy a;
  private boolean e;
  
  public arev(arew paramarew)
  {
    super(paramarew);
  }
  
  public int a()
  {
    return -2147483647;
  }
  
  public arfy a()
  {
    return this.a;
  }
  
  public arga a(argk paramargk)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramargk);
      if (localView != null) {
        ardw.a().a().a().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramargk);
  }
  
  public void a(arfy paramarfy)
  {
    this.a = paramarfy;
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
 * Qualified Name:     arev
 * JD-Core Version:    0.7.0.1
 */