import android.view.View;
import android.view.View.OnClickListener;

public abstract class aruk
  implements View.OnClickListener
{
  private long a;
  
  public abstract void a(View paramView);
  
  public void b(View paramView) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.a >= 500L)
    {
      a(paramView);
      this.a = l;
      return;
    }
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aruk
 * JD-Core Version:    0.7.0.1
 */