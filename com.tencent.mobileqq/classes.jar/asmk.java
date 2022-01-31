import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.13.1;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.13.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class asmk
  implements asoe
{
  public asmk(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public void a(int paramInt)
  {
    QLog.d("QQGamePubAccountFragment", 2, "mFeedsAdapter.onPageSelected position=" + paramInt);
    if ((paramInt != 0) && (QQGamePubAccountFragment.a(this.a) != null)) {
      QQGamePubAccountFragment.a(this.a).c = false;
    }
    com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.a = 0;
    if (paramInt < QQGamePubAccountFragment.a(this.a).size())
    {
      MessageRecord localMessageRecord = (MessageRecord)QQGamePubAccountFragment.a(this.a).get(paramInt);
      List localList = (List)QQGamePubAccountFragment.a(this.a).get(Long.valueOf(localMessageRecord.uniseq));
      FeedsItemData.TopCardInfo localTopCardInfo = (FeedsItemData.TopCardInfo)QQGamePubAccountFragment.b(this.a).get(Long.valueOf(localMessageRecord.uniseq));
      if (TextUtils.isEmpty((String)QQGamePubAccountFragment.c(this.a).get(Long.valueOf(localMessageRecord.uniseq)))) {
        String str = asnl.a;
      }
      QQGamePubAccountFragment.a(this.a).a(localList, localTopCardInfo);
      QQGamePubAccountFragment.a(this.a, localTopCardInfo);
      if ((localList != null) && (localList.size() > 0)) {}
      for (;;)
      {
        QQGamePubAccountFragment.a(QQGamePubAccountFragment.a(this.a), paramInt);
        if (QQGamePubAccountFragment.d(this.a).containsKey(Long.valueOf(localMessageRecord.uniseq))) {
          QQGamePubAccountFragment.a(this.a).scrollToPosition(((Integer)QQGamePubAccountFragment.d(this.a).get(Long.valueOf(localMessageRecord.uniseq))).intValue());
        }
        aahi.a(akwd.a(), "769", "205017", this.a.a(paramInt), "76901", "1", "160", new String[] { asnl.a((MessageRecord)QQGamePubAccountFragment.a(this.a).get(paramInt)), "" + paramInt, "8" });
        ((bdug)QQGamePubAccountFragment.a(this.a).a(71)).a(2, ((MessageRecord)QQGamePubAccountFragment.a(this.a).get(0)).getExtInfoFromExtStr("pa_msgId"), "");
        return;
        this.a.b(false);
      }
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGamePubAccountFragment.13.1(this), 200L);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGamePubAccountFragment.13.2(this), 1200L);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    QLog.d("QQGamePubAccountFragment", 2, "mFeedsAdapter.onPageScrolled position=" + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmk
 * JD-Core Version:    0.7.0.1
 */