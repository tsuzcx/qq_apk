import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime.Status;

class axti
  extends ayaa
{
  axti(axsv paramaxsv) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    paramBundle = axsv.a(this.a).getOnlineStatus();
    long l = axuy.a().a(axsv.a(this.a));
    if ((paramBoolean) && (paramBundle == AppRuntime.Status.online) && (l == 1030L))
    {
      if (axsv.a(this.a) != null) {
        axsv.a(this.a).a(paramBundle);
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axti
 * JD-Core Version:    0.7.0.1
 */