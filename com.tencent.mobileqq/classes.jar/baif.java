import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.TenDocOCRExportHandler.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.manager.TicketManager;

public class baif
  extends alpd
  implements Handler.Callback
{
  private String[] a = { "docs.qq.com" };
  
  public baif(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.app == null) {}
    while (((TicketManager)this.app.getManager(2)).GetPskey(this.app.getCurrentAccountUin(), 16L, this.a, new baig(this, paramRunnable)) == null) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void a(String paramString)
  {
    a(new TenDocOCRExportHandler.1(this, paramString));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return baih.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baif
 * JD-Core Version:    0.7.0.1
 */