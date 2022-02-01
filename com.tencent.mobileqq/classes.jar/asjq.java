import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.profile.like.PraiseManager;
import java.lang.ref.WeakReference;

class asjq
  implements baaa
{
  asjq(asiw paramasiw) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    MessengerService localMessengerService = (MessengerService)this.a.a.get();
    if (localMessengerService != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", paramInt2);
      localBundle.putInt("code", paramInt1);
      localBundle.putString("url", paramString);
      paramBundle.putBundle("response", localBundle);
      localMessengerService.a(paramBundle);
      if ((paramInt1 == 0) && (MessengerService.e(localMessengerService) != null) && ((MessengerService.f(localMessengerService) instanceof QQAppInterface))) {
        ((PraiseManager)((QQAppInterface)MessengerService.g(localMessengerService)).getManager(209)).a(paramInt2, true, "from_praise_mall");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjq
 * JD-Core Version:    0.7.0.1
 */