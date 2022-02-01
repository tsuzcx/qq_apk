import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class azhk
  implements BusinessObserver
{
  public void a(int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    if (paramInt == 0)
    {
      paramInt = i;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("KEY_BATTERY", 0);
      }
      a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhk
 * JD-Core Version:    0.7.0.1
 */