import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime.Status;

class ayzt
  extends azgm
{
  ayzt(ayzg paramayzg) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    paramBundle = ayzg.a(this.a).getOnlineStatus();
    long l = azbj.a().a(ayzg.a(this.a));
    if ((paramBoolean) && (paramBundle == AppRuntime.Status.online) && (l == 1030L))
    {
      if (ayzg.a(this.a) != null) {
        ayzg.a(this.a).a(paramBundle);
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzt
 * JD-Core Version:    0.7.0.1
 */