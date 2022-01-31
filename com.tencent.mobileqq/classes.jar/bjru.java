import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public final class bjru
  implements bjmq
{
  public bjru(Handler paramHandler) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.uploadCommentVideo".equals(paramString))
    {
      paramString = new Message();
      paramString.obj = paramBundle;
      this.a.sendMessage(paramString);
      if ((paramBundle.getBundle("data") != null) && (paramBundle.getBundle("data").getInt("status") != 2)) {
        bjmn.a().b(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjru
 * JD-Core Version:    0.7.0.1
 */