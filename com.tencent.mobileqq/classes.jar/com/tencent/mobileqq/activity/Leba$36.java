package com.tencent.mobileqq.activity;

import com.tencent.biz.qqcircle.list.bizblocks.QCircleChatBoxHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import vqu;

class Leba$36
  implements Runnable
{
  Leba$36(Leba paramLeba) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (vqu)BaseApplicationImpl.getApplication().getRuntime().getManager(376);
    Object localObject2 = ((vqu)localObject1).b("circle_entrance");
    int i;
    if (localObject2 != null)
    {
      i = ((QQCircleCounter.RedPointInfo)localObject2).redTotalNum.get();
      Leba.a(this.this$0, ((QQCircleCounter.RedPointInfo)localObject2).extend.get());
    }
    for (;;)
    {
      localObject1 = ((vqu)localObject1).a("circle_entrance");
      if (localObject1 == null) {
        break label246;
      }
      localObject2 = ((QQCircleCounter.RedPointInfo)localObject1).rptRedInfo.get();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label260;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList.add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject2).next()).headImg.get());
      }
      Leba.a(this.this$0, null);
      i = 0;
    }
    label260:
    for (boolean bool = true;; bool = false)
    {
      Leba.b(this.this$0, ((QQCircleCounter.RedPointInfo)localObject1).extend.get());
      for (;;)
      {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_PASSIVE_FEED freshEntryItemUI pushUnReadNum = " + i + " chatUnReadNum = " + 0);
        int j = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
        Leba.a(this.this$0, j + i, bool, localArrayList);
        return;
        label246:
        Leba.b(this.this$0, null);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.36
 * JD-Core Version:    0.7.0.1
 */