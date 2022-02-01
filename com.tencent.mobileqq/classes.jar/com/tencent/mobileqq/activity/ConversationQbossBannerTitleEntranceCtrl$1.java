package com.tencent.mobileqq.activity;

import aejy;
import android.app.Activity;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleChatBoxHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import uzg;
import vtf;

public class ConversationQbossBannerTitleEntranceCtrl$1
  implements Runnable
{
  public ConversationQbossBannerTitleEntranceCtrl$1(aejy paramaejy) {}
  
  public void run()
  {
    Object localObject = (vtf)BaseApplicationImpl.getApplication().getRuntime().getManager(376);
    long l = 0L;
    int j = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
    ArrayList localArrayList = new ArrayList();
    localObject = ((vtf)localObject).a("circle_entrance");
    int i;
    boolean bool;
    if (localObject != null)
    {
      l = ((QQCircleCounter.RedPointInfo)localObject).outLayerInfo.combineRedTypes.get();
      i = ((QQCircleCounter.RedPointInfo)localObject).redTotalNum.get();
      if (uzg.a(l, 1))
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
      aejy.a(this.this$0).runOnUiThread(new ConversationQbossBannerTitleEntranceCtrl.1.1(this, i + j, bool));
      return;
      bool = false;
      break;
      bool = false;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.1
 * JD-Core Version:    0.7.0.1
 */