import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class bjiz
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected boolean a(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void d(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!a(paramBoolean, paramBundle)) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        b(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1)
      {
        c(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 2)
      {
        a(paramBoolean, paramBundle);
        return;
      }
    } while (paramInt != 100);
    d(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjiz
 * JD-Core Version:    0.7.0.1
 */