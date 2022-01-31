import android.os.Bundle;
import mqq.observer.BusinessObserver;

final class azbp
  implements azbr
{
  azbp(BusinessObserver paramBusinessObserver) {}
  
  public void a(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dataErrorMsg", paramString);
    localBundle.putInt("dataErrorCode", paramInt);
    this.a.onReceive(0, false, localBundle);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("data", paramString.getBytes());
    localBundle.putString("cmd", "getAppConfig");
    this.a.onReceive(0, true, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbp
 * JD-Core Version:    0.7.0.1
 */