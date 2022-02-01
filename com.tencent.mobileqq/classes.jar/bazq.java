import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class bazq
  implements azpp
{
  private int jdField_a_of_type_Int;
  private WeakReference<ReceiptMessageDetailFragment> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bazq(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(azpq paramazpq)
  {
    ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localReceiptMessageDetailFragment == null) {
      return;
    }
    if ((paramazpq.b == 0) && (paramazpq.a != null))
    {
      MessageRecord localMessageRecord = ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a().a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).jdField_a_of_type_JavaLangString, ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).jdField_a_of_type_Int, ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment));
      Object localObject = localMessageRecord;
      if (localMessageRecord == null)
      {
        localObject = new MessageForStructing();
        ((MessageRecord)localObject).senderuin = "0";
        ((MessageRecord)localObject).uniseq = ReceiptMessageDetailFragment.c(localReceiptMessageDetailFragment);
      }
      paramazpq = ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a().a().a(paramazpq.a, null, (MessageRecord)localObject, null);
      if ((paramazpq != null) && (!paramazpq.isEmpty()))
      {
        ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(10);
        return;
      }
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(11);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "ReceiptMessageDownloadCallBack onDownload, download msg fail with code: " + paramazpq.b);
    }
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    if (i <= 3)
    {
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(0);
      return;
    }
    ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazq
 * JD-Core Version:    0.7.0.1
 */