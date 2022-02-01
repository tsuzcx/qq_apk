import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class azms
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azms
 * JD-Core Version:    0.7.0.1
 */