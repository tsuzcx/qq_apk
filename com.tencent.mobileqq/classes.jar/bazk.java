import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.DetailHandler.1;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class bazk
  extends Handler
{
  private WeakReference<ReceiptMessageDetailFragment> a;
  
  public bazk(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.a.get();
    if ((localReceiptMessageDetailFragment == null) || (!localReceiptMessageDetailFragment.isAdded())) {}
    label124:
    int i;
    label126:
    do
    {
      return;
      switch (paramMessage.what)
      {
      case 8: 
      case 9: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        i = 0;
      }
    } while (i == 0);
    localReceiptMessageDetailFragment.stopTitleProgress();
    ReceiptMessageDetailFragment.m(localReceiptMessageDetailFragment);
    if ((ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a == 0) && (!ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment)))
    {
      if (!ReceiptMessageDetailFragment.b(localReceiptMessageDetailFragment)) {
        break label399;
      }
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, 1, true);
    }
    while (ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment))
    {
      ReceiptMessageDetailFragment.h(localReceiptMessageDetailFragment);
      return;
      if (!(paramMessage.obj instanceof MessageForText)) {
        break;
      }
      ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment, 1);
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, (MessageForText)paramMessage.obj);
      i = 1;
      break label126;
      if (!(paramMessage.obj instanceof MessageForPic)) {
        break;
      }
      ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment, 2);
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, (MessageForPic)paramMessage.obj);
      i = 1;
      break label126;
      if (!(paramMessage.obj instanceof MessageForPtt)) {
        break;
      }
      ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment, 3);
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, (MessageForPtt)paramMessage.obj);
      ReceiptMessageDetailFragment.h(localReceiptMessageDetailFragment);
      i = 1;
      break label126;
      ReceiptMessageDetailFragment.i(localReceiptMessageDetailFragment);
      i = 0;
      break label126;
      ReceiptMessageDetailFragment.j(localReceiptMessageDetailFragment);
      i = 0;
      break label126;
      ReceiptMessageDetailFragment.h(localReceiptMessageDetailFragment);
      i = 0;
      break label126;
      QQToast.a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).getApp(), 1, 2131697803, 0).a(localReceiptMessageDetailFragment);
      i = 0;
      break label126;
      i = ahnz.a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment));
      localReceiptMessageDetailFragment.a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), i, false);
      i = 0;
      break label126;
      ReceiptMessageDetailFragment.k(localReceiptMessageDetailFragment);
      i = 0;
      break label126;
      ThreadManager.post(new ReceiptMessageDetailFragment.DetailHandler.1(this, localReceiptMessageDetailFragment), 8, null, false);
      i = 0;
      break label126;
      ReceiptMessageDetailFragment.l(localReceiptMessageDetailFragment);
      break label124;
      label399:
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment, 0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazk
 * JD-Core Version:    0.7.0.1
 */