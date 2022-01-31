import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class atla
  implements BusinessObserver
{
  public void a() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 0) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atla
 * JD-Core Version:    0.7.0.1
 */