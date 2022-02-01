import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime.Status;

class aynh
  extends ayuf
{
  aynh(aymu paramaymu) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    paramBundle = aymu.a(this.a).getOnlineStatus();
    long l = ayox.a().a(aymu.a(this.a));
    if ((paramBoolean) && (paramBundle == AppRuntime.Status.online) && (l == 1030L))
    {
      if (aymu.a(this.a) != null) {
        aymu.a(this.a).a(paramBundle);
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynh
 * JD-Core Version:    0.7.0.1
 */