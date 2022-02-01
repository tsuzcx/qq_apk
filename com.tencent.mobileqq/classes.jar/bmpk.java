import android.view.View;
import android.view.ViewGroup;

public class bmpk
{
  private int a;
  
  public int a(int paramInt1, int paramInt2)
  {
    int i;
    if (this.a != -1) {
      if (paramInt2 == paramInt1 - 1)
      {
        if (this.a > paramInt1 - 1) {
          this.a = (paramInt1 - 1);
        }
        i = this.a;
      }
    }
    do
    {
      return i;
      if (paramInt2 == this.a) {
        return paramInt1 - 1;
      }
      i = paramInt2;
    } while (paramInt1 > paramInt2);
    return paramInt1 - 1;
  }
  
  public void a(ViewGroup paramViewGroup, View paramView)
  {
    this.a = paramViewGroup.indexOfChild(paramView);
    if (this.a != -1) {
      paramViewGroup.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpk
 * JD-Core Version:    0.7.0.1
 */