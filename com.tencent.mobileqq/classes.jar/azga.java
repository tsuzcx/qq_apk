import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime.Status;

class azga
  extends azms
{
  azga(azfn paramazfn) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    paramBundle = azfn.a(this.a).getOnlineStatus();
    long l = azhq.a().a(azfn.a(this.a));
    if ((paramBoolean) && (paramBundle == AppRuntime.Status.online) && (l == 1030L))
    {
      if (azfn.a(this.a) != null) {
        azfn.a(this.a).a(paramBundle);
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azga
 * JD-Core Version:    0.7.0.1
 */