import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.TeamWorkFileExportHandler.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.manager.TicketManager;

public class beaq
  extends anud
  implements Handler.Callback
{
  private String[] a = { "docs.qq.com" };
  
  public beaq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.app == null) {}
    while (((TicketManager)this.app.getManager(2)).getPskey(this.app.getCurrentAccountUin(), 16L, this.a, new bear(this, paramRunnable)) == null) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(new TeamWorkFileExportHandler.1(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected Class<? extends anui> observerClass()
  {
    return beao.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beaq
 * JD-Core Version:    0.7.0.1
 */