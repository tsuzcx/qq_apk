import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class bfyn
  implements View.OnKeyListener
{
  private bfyn(bfyl parambfyl) {}
  
  public void a()
  {
    Activity localActivity = this.a.a();
    if (localActivity != null)
    {
      this.a.a().finish();
      localActivity.overridePendingTransition(2130772037, 2130772243);
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
      switch (paramKeyEvent.getAction())
      {
      case 0: 
      default: 
        break;
      case 1: 
        bool1 = bool2;
      }
    } while (paramKeyEvent.isCanceled());
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyn
 * JD-Core Version:    0.7.0.1
 */