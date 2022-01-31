import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.CardContainer;
import com.tencent.open.agent.QuickLoginAuthorityActivity;

public class bfcp
  extends Handler
{
  public bfcp(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramMessage = (Bitmap)paramMessage.obj;
          } while (paramMessage == null);
          this.a.a.a("", "", paramMessage, true);
          return;
          paramMessage = (Bitmap)paramMessage.obj;
        } while (paramMessage == null);
        this.a.a.a("", paramMessage);
        return;
        paramMessage = (String)paramMessage.obj;
      } while (TextUtils.isEmpty(paramMessage));
      this.a.a.setAppType(paramMessage);
      return;
    } while (this.a.a.a == null);
    this.a.a.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfcp
 * JD-Core Version:    0.7.0.1
 */