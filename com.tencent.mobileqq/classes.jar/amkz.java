import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;

public final class amkz
  implements WebEventListener
{
  public amkz(Handler paramHandler) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.uploadCommentVideo".equals(paramString))
    {
      paramString = new Message();
      paramString.obj = paramBundle;
      this.a.sendMessage(paramString);
      if ((paramBundle.getBundle("data") != null) && (paramBundle.getBundle("data").getInt("status") != 2)) {
        RemoteHandleManager.a().b(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkz
 * JD-Core Version:    0.7.0.1
 */