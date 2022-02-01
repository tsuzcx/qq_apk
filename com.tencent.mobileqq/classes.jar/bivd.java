import android.content.Context;
import android.widget.Scroller;

public class bivd
  extends Scroller
{
  private int a = 150;
  
  public bivd(Context paramContext)
  {
    super(paramContext, new bive());
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bivd
 * JD-Core Version:    0.7.0.1
 */