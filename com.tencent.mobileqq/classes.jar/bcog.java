import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class bcog
  implements View.OnKeyListener
{
  bcog(bcof parambcof) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      bcof.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcog
 * JD-Core Version:    0.7.0.1
 */