import android.os.Bundle;
import mqq.observer.BusinessObserver;

final class axcb
  implements axce
{
  axcb(BusinessObserver paramBusinessObserver) {}
  
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
    localBundle.putString("cmd", "getTmpkey");
    this.a.onReceive(0, true, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axcb
 * JD-Core Version:    0.7.0.1
 */