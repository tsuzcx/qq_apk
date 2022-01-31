import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.theme.diy.ResData;
import java.lang.ref.WeakReference;

class anve
  implements aymu
{
  anve(anul paramanul) {}
  
  public int callback(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    paramResData = (MessengerService)this.a.a.get();
    Bundle localBundle;
    if (paramResData != null)
    {
      localBundle = new Bundle();
      localBundle.putString("themeId", paramBundle.getString("themeId"));
      if (paramInt2 != 4) {
        break label73;
      }
    }
    label73:
    for (paramInt1 = 0;; paramInt1 = -2)
    {
      localBundle.putInt("themeStatus", paramInt1);
      paramBundle.putBundle("response", localBundle);
      paramResData.a(paramBundle);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anve
 * JD-Core Version:    0.7.0.1
 */