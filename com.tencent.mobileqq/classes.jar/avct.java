import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.12.1;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class avct
  implements avfs
{
  public avct(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public void a(int paramInt)
  {
    QLog.d("QQGamePubAccountFragment", 4, "mFeedsAdapter.onPageSelected position=" + paramInt);
    Object localObject;
    if (paramInt < QQGamePubAccountFragment.a(this.a).size())
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = paramInt;
      QQGamePubAccountFragment.a(this.a).removeMessages(1);
      QQGamePubAccountFragment.a(this.a).sendMessageDelayed((Message)localObject, 200L);
    }
    try
    {
      com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.sPlayCount = 0;
      if (paramInt < QQGamePubAccountFragment.a(this.a).size())
      {
        localObject = (MessageRecord)QQGamePubAccountFragment.a(this.a).get(paramInt);
        List localList = (List)QQGamePubAccountFragment.a(this.a).get(Long.valueOf(((MessageRecord)localObject).uniseq));
        FeedsItemData.TopCardInfo localTopCardInfo = (FeedsItemData.TopCardInfo)QQGamePubAccountFragment.b(this.a).get(Long.valueOf(((MessageRecord)localObject).uniseq));
        String str = (String)QQGamePubAccountFragment.c(this.a).get(Long.valueOf(((MessageRecord)localObject).uniseq));
        QQGamePubAccountFragment.a(this.a).a(localList, localTopCardInfo);
        QQGamePubAccountFragment.a(this.a, localTopCardInfo);
        if ((localList == null) || (localList.size() == 0)) {
          this.a.b(false);
        }
        QQGamePubAccountFragment.a(QQGamePubAccountFragment.a(this.a), paramInt);
        this.a.d();
        if (QQGamePubAccountFragment.d(this.a).containsKey(Long.valueOf(((MessageRecord)localObject).uniseq))) {}
        abuf.a(amwn.a(), "769", "205017", this.a.a(paramInt), "76901", "1", "160", new String[] { aver.a((MessageRecord)QQGamePubAccountFragment.a(this.a).get(paramInt)), "" + paramInt, "8" });
        ((VasExtensionHandler)QQGamePubAccountFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(2, ((MessageRecord)QQGamePubAccountFragment.a(this.a).get(0)).getExtInfoFromExtStr("pa_msgId"), "");
        return;
      }
      ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGamePubAccountFragment.12.1(this), 200L);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("QQGamePubAccountFragment", 4, "-->onPageSelected decode feed fail :" + localThrowable.getMessage());
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    QLog.d("QQGamePubAccountFragment", 4, "mFeedsAdapter.onPageScrolled position=" + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avct
 * JD-Core Version:    0.7.0.1
 */