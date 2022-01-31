import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class arka
  implements BusinessObserver
{
  public void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, paramBundle.getInt("appId"), paramBundle.getLong("uin", 0L), paramBundle.getString("openId"), paramBundle.getString("error_msg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arka
 * JD-Core Version:    0.7.0.1
 */