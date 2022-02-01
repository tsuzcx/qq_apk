package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.util.Pair;
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
    long l = 0L;
    int j = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
    ArrayList localArrayList = new ArrayList();
    Object localObject = QCircleUtils.a().getOuterEntranceRedPointInfoByAppid("circle_entrance");
    int i;
    boolean bool;
    if (localObject != null)
    {
      l = ((QQCircleCounter.RedPointInfo)localObject).outLayerInfo.combineRedTypes.get();
      i = ((QQCircleCounter.RedPointInfo)localObject).redTotalNum.get();
      if (QCircleHostUtil.checkOperateMaskEnabled(l, 1))
      {
        bool = true;
        localObject = ((QQCircleCounter.RedPointInfo)localObject).rptRedInfo.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject).next()).headImg.get());
          }
        }
      }
    }
    for (;;)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[updateQQCircleRedFlag]").append("  redDotCombineTypes = ").append(l).append("  pushUnReadNum = ").append(i).append(", chatUnReadNum = ").append(j).append(", showActiveRedDot = ").append(bool).append(", uinList = ").append(localArrayList);
      QLog.d("QCircleEeveeRedPoint_ConversationQbossBannerTitleEntranceCtrl", 2, new Object[] { localObject });
      ConversationQbossBannerTitleEntranceCtrl.a(this.this$0).runOnUiThread(new ConversationQbossBannerTitleEntranceCtrl.2.1(this, i + j, bool));
      return;
      bool = false;
      break;
      bool = false;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.2
 * JD-Core Version:    0.7.0.1
 */