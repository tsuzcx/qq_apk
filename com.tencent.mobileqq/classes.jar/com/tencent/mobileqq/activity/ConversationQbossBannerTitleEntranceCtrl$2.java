package com.tencent.mobileqq.activity;

import android.app.Activity;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

class ConversationQbossBannerTitleEntranceCtrl$2
  implements Runnable
{
  ConversationQbossBannerTitleEntranceCtrl$2(ConversationQbossBannerTitleEntranceCtrl paramConversationQbossBannerTitleEntranceCtrl) {}
  
  public void run()
  {
    int k = QCircleChatBoxHelper.getInstance().getUnReadChatNum();
    ArrayList localArrayList = new ArrayList();
    Object localObject = QCircleUtils.a().getOuterEntranceRedPointInfoByAppid("circle_entrance");
    long l1;
    int i;
    boolean bool1;
    if (localObject != null)
    {
      long l2 = ((QQCircleCounter.RedPointInfo)localObject).outLayerInfo.combineRedTypes.get();
      int j = ((QQCircleCounter.RedPointInfo)localObject).redTotalNum.get();
      boolean bool2 = QCircleHostUtil.checkOperateMaskEnabled(l2, 1);
      localObject = ((QQCircleCounter.RedPointInfo)localObject).rptRedInfo.get();
      l1 = l2;
      i = j;
      bool1 = bool2;
      if (localObject != null)
      {
        l1 = l2;
        i = j;
        bool1 = bool2;
        if (((List)localObject).size() > 0)
        {
          localObject = ((List)localObject).iterator();
          for (;;)
          {
            l1 = l2;
            i = j;
            bool1 = bool2;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localArrayList.add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject).next()).headImg.get());
          }
        }
      }
    }
    else
    {
      l1 = 0L;
      i = 0;
      bool1 = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[updateQQCircleRedFlag]");
    ((StringBuilder)localObject).append("  redDotCombineTypes = ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("  pushUnReadNum = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", chatUnReadNum = ");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(", showActiveRedDot = ");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", uinList = ");
    ((StringBuilder)localObject).append(localArrayList);
    QLog.d("QCircleEeveeRedPoint_ConversationQbossBannerTitleEntranceCtrl", 2, new Object[] { localObject });
    ConversationQbossBannerTitleEntranceCtrl.a(this.this$0).runOnUiThread(new ConversationQbossBannerTitleEntranceCtrl.2.1(this, i + k, bool1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.2
 * JD-Core Version:    0.7.0.1
 */