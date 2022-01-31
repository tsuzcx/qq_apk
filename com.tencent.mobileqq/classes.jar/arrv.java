import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class arrv
  implements BusinessObserver
{
  public void a() {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b() {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 967: 
      b(paramBoolean, paramBundle);
      return;
    case 968: 
      a(paramBoolean, paramBundle);
      return;
    case 969: 
      b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrv
 * JD-Core Version:    0.7.0.1
 */