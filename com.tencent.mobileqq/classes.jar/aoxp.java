import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku.1;

public class aoxp
  extends aoxo
{
  private aoys a;
  private boolean e;
  
  public aoxp(aoxq paramaoxq)
  {
    super(paramaoxq);
  }
  
  public int a()
  {
    return -2147483647;
  }
  
  public aoys a()
  {
    return this.a;
  }
  
  public aoyu a(aoze paramaoze)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramaoze);
      if (localView != null) {
        aowq.a().a().a().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramaoze);
  }
  
  public void a(aoys paramaoys)
  {
    this.a = paramaoys;
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
 * Qualified Name:     aoxp
 * JD-Core Version:    0.7.0.1
 */