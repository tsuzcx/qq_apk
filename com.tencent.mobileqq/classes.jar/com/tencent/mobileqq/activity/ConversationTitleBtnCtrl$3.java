package com.tencent.mobileqq.activity;

import adtz;
import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qqcircle.chat.QCircleChatBoxHelper;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class ConversationTitleBtnCtrl$3
  implements Runnable
{
  public ConversationTitleBtnCtrl$3(adtz paramadtz) {}
  
  public void run()
  {
    Object localObject1 = (QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QCIRCLE_MGR_RED_TOUCH);
    int j = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
    Object localObject2 = ((QCircleRedPointManager)localObject1).getOuterEntranceRedPointInfoByAppid("circle_entrance");
    long l;
    int i;
    if (localObject2 != null)
    {
      l = ((QQCircleCounter.RedPointInfo)localObject2).outLayerInfo.combineRedTypes.get();
      i = ((QQCircleCounter.RedPointInfo)localObject2).redTotalNum.get();
      if (!QCircleCommonUtil.checkOperateMaskEnabled(l, 1)) {
        break label608;
      }
    }
    label295:
    label608:
    for (boolean bool = true;; bool = false)
    {
      Object localObject3 = ((QQCircleCounter.RedPointInfo)localObject2).rptRedInfo.get();
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject3).next()).headImg.get());
        }
      }
      for (;;)
      {
        adtz.a(this.this$0, ((QQCircleCounter.RedPointInfo)localObject2).extend.get());
        if (((QQCircleCounter.RedPointInfo)localObject2).transInfo.get() != null)
        {
          adtz.a(this.this$0, ((QQCircleCounter.RedPointInfo)localObject2).tabType.get());
          int k = i + j;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[updateQQCircleRedFlag]").append("  redDotCombineTypes = ").append(l).append("  pushUnReadNum = ").append(i).append(", chatUnReadNum = ").append(j).append(", showActiveRedDot = ").append(bool).append(", uinList = ").append(localObject1);
          QLog.d("QCircleEeveeRedPoint_ConversationTitleBtnCtrl", 1, new Object[] { localObject2 });
          if (localObject1 != null) {
            break label521;
          }
          i = 0;
          if (adtz.a(this.this$0) != k)
          {
            adtz.b(this.this$0, k);
            adtz.a(this.this$0, true);
          }
          if (adtz.a(this.this$0) != bool)
          {
            adtz.b(this.this$0, bool);
            adtz.a(this.this$0, true);
          }
          if (adtz.b(this.this$0) != i)
          {
            adtz.c(this.this$0, i);
            adtz.a(this.this$0, true);
          }
          adtz.a(this.this$0).runOnUiThread(new ConversationTitleBtnCtrl.3.1(this));
          if (adtz.b(this.this$0))
          {
            if (adtz.a(this.this$0) <= 0) {
              break label532;
            }
            QCircleLpReportDc05504.report("", 2, 1, 2, "1", "", adtz.a(this.this$0), null, "", "", null, -1, -1);
          }
        }
        for (;;)
        {
          adtz.a(this.this$0, false);
          return;
          adtz.a(this.this$0, -1);
          adtz.a(this.this$0, null);
          break;
          adtz.a(this.this$0, null);
          adtz.a(this.this$0, null);
          adtz.a(this.this$0, -1);
          localObject1 = null;
          bool = false;
          l = 0L;
          i = 0;
          break;
          i = ((List)localObject1).size();
          break label295;
          if (adtz.a(this.this$0)) {
            QCircleLpReportDc05504.report("", 2, 1, 1, "1", "", adtz.a(this.this$0), null, "", "", null, -1, -1);
          } else {
            QCircleLpReportDc05504.report("", 2, 1, 3, "1", "", adtz.a(this.this$0), null, "", "", null, -1, -1);
          }
        }
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.3
 * JD-Core Version:    0.7.0.1
 */