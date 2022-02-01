package com.tencent.mobileqq.activity;

import aeau;
import android.app.Activity;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleChatBoxHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter.RedPointInfo;
import vqu;

public class ConversationQbossBannerTitleEntranceCtrl$1
  implements Runnable
{
  public ConversationQbossBannerTitleEntranceCtrl$1(aeau paramaeau) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject = (vqu)BaseApplicationImpl.getApplication().getRuntime().getManager(376);
    QQCircleCounter.RedPointInfo localRedPointInfo = ((vqu)localObject).b("circle_entrance");
    if (localRedPointInfo != null) {}
    for (int i = localRedPointInfo.redTotalNum.get();; i = 0)
    {
      QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, "redPointNum" + i);
      if ((aeau.a(this.this$0) != null) && (aeau.a(this.this$0).a != null)) {}
      for (int j = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();; j = 0)
      {
        QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, "chatUnReadNum" + j);
        localObject = ((vqu)localObject).a("circle_entrance");
        boolean bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((QQCircleCounter.RedPointInfo)localObject).rptRedInfo.get();
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (((List)localObject).size() > 0) {
              bool1 = true;
            }
          }
        }
        aeau.a(this.this$0).runOnUiThread(new ConversationQbossBannerTitleEntranceCtrl.1.1(this, i + j, bool1));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.1
 * JD-Core Version:    0.7.0.1
 */