package com.tencent.mobileqq.activity;

import aejz;
import android.app.Activity;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleChatBoxHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
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
import vtq;

public class ConversationTitleBtnCtrl$1
  implements Runnable
{
  public ConversationTitleBtnCtrl$1(aejz paramaejz) {}
  
  public void run()
  {
    Object localObject1 = (vtf)BaseApplicationImpl.getApplication().getRuntime().getManager(376);
    long l = 0L;
    int j = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((vtf)localObject1).a("circle_entrance");
    int i;
    if (localObject1 != null)
    {
      l = ((QQCircleCounter.RedPointInfo)localObject1).outLayerInfo.combineRedTypes.get();
      i = ((QQCircleCounter.RedPointInfo)localObject1).redTotalNum.get();
      if (!uzg.a(l, 1)) {
        break label581;
      }
    }
    label298:
    label581:
    for (boolean bool = true;; bool = false)
    {
      Object localObject2 = ((QQCircleCounter.RedPointInfo)localObject1).rptRedInfo.get();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localArrayList.add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject2).next()).headImg.get());
        }
      }
      aejz.a(this.this$0, ((QQCircleCounter.RedPointInfo)localObject1).extend.get());
      if (((QQCircleCounter.RedPointInfo)localObject1).transInfo.get() != null)
      {
        aejz.a(this.this$0, ((QQCircleCounter.RedPointInfo)localObject1).tabType.get());
        int k = i + j;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[updateQQCircleRedFlag]").append("  redDotCombineTypes = ").append(l).append("  pushUnReadNum = ").append(i).append(", chatUnReadNum = ").append(j).append(", showActiveRedDot = ").append(bool).append(", uinList = ").append(localArrayList);
        QLog.d("QCircleEeveeRedPoint_ConversationTitleBtnCtrl", 2, new Object[] { localObject1 });
        if (localArrayList != null) {
          break label500;
        }
        i = 0;
        if (aejz.a(this.this$0) != k)
        {
          aejz.b(this.this$0, k);
          aejz.a(this.this$0, true);
        }
        if (aejz.a(this.this$0) != bool)
        {
          aejz.b(this.this$0, bool);
          aejz.a(this.this$0, true);
        }
        if (aejz.b(this.this$0) != i)
        {
          aejz.c(this.this$0, i);
          aejz.a(this.this$0, true);
        }
        aejz.a(this.this$0).runOnUiThread(new ConversationTitleBtnCtrl.1.1(this));
        if (aejz.b(this.this$0))
        {
          if (aejz.a(this.this$0) <= 0) {
            break label511;
          }
          vtq.a("", 2, 1, 2, "1", "", aejz.a(this.this$0), null, "", "", null, -1, -1);
        }
      }
      for (;;)
      {
        aejz.a(this.this$0, false);
        return;
        aejz.a(this.this$0, -1);
        break;
        aejz.a(this.this$0, null);
        aejz.a(this.this$0, -1);
        bool = false;
        i = 0;
        break;
        label500:
        i = localArrayList.size();
        break label298;
        label511:
        if (aejz.a(this.this$0)) {
          vtq.a("", 2, 1, 1, "1", "", aejz.a(this.this$0), null, "", "", null, -1, -1);
        } else {
          vtq.a("", 2, 1, 3, "1", "", aejz.a(this.this$0), null, "", "", null, -1, -1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1
 * JD-Core Version:    0.7.0.1
 */