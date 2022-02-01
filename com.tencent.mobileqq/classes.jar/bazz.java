import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.ListProcessHandler.1;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment.ListProcessHandler.2;
import java.lang.ref.WeakReference;

public class bazz
  extends Handler
{
  private WeakReference<ReceiptMessageReadMemberListContainerFragment> a;
  
  private bazz(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
  {
    this.a = new WeakReference(paramReceiptMessageReadMemberListContainerFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReceiptMessageReadMemberListContainerFragment localReceiptMessageReadMemberListContainerFragment = (ReceiptMessageReadMemberListContainerFragment)this.a.get();
    if ((localReceiptMessageReadMemberListContainerFragment == null) || (!localReceiptMessageReadMemberListContainerFragment.isAdded())) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      case 0: 
      default: 
        return;
      case -1: 
        localReceiptMessageReadMemberListContainerFragment.stopTitleProgress();
        ReceiptMessageReadMemberListContainerFragment.g(localReceiptMessageReadMemberListContainerFragment);
        return;
      case 1: 
        ReceiptMessageReadMemberListContainerFragment.b(localReceiptMessageReadMemberListContainerFragment);
        return;
      }
    } while (this.a.get() == null);
    if (ReceiptMessageReadMemberListContainerFragment.a(localReceiptMessageReadMemberListContainerFragment)) {
      ReceiptMessageReadMemberListContainerFragment.c(localReceiptMessageReadMemberListContainerFragment);
    }
    for (;;)
    {
      ReceiptMessageReadMemberListContainerFragment.d(localReceiptMessageReadMemberListContainerFragment);
      return;
      sendEmptyMessage(5);
    }
    ReceiptMessageReadMemberListContainerFragment.a(localReceiptMessageReadMemberListContainerFragment, ((Long)paramMessage.obj).longValue());
    return;
    ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.ListProcessHandler.1(this, localReceiptMessageReadMemberListContainerFragment), 8, null, true);
    return;
    ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.ListProcessHandler.2(this, localReceiptMessageReadMemberListContainerFragment), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazz
 * JD-Core Version:    0.7.0.1
 */