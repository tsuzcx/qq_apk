import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.CardContainer;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qphone.base.util.QLog;

public class bioc
  extends Handler
{
  public bioc(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity, Looper paramLooper)
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
          paramMessage = bipr.a(this.a, paramMessage, 50, 50);
          localMessage = Message.obtain();
          localMessage.what = 1002;
          localMessage.obj = paramMessage;
          this.a.b.sendMessage(localMessage);
          return;
          paramMessage = (String)paramMessage.obj;
        } while (TextUtils.isEmpty(paramMessage));
        paramMessage = AuthorityActivity.a(paramMessage);
      } while (paramMessage == null);
      Message localMessage = Message.obtain();
      localMessage.what = 1003;
      localMessage.obj = paramMessage;
      this.a.b.sendMessage(localMessage);
      return;
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "--> handler message GET_ACCOUNT_LIST");
    } while (this.a.a.a == null);
    this.a.a.a.c();
    paramMessage = Message.obtain();
    paramMessage.what = 1006;
    this.a.b.sendMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bioc
 * JD-Core Version:    0.7.0.1
 */