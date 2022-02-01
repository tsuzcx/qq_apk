package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.util.Pair;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

class ConversationTitleBtnCtrl$3
  implements Runnable
{
  ConversationTitleBtnCtrl$3(ConversationTitleBtnCtrl paramConversationTitleBtnCtrl) {}
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext1", "1");
    localHashMap.put("ext5", ConversationTitleBtnCtrl.a(this.this$0));
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 2, 1, paramInt, localHashMap, null, null);
  }
  
  public void run()
  {
    long l = 0L;
    int j = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
    Object localObject1 = QCircleUtils.a().getOuterEntranceRedPointInfoByAppid("circle_entrance");
    int i;
    if (localObject1 != null)
    {
      l = ((QQCircleCounter.RedPointInfo)localObject1).outLayerInfo.combineRedTypes.get();
      i = ((QQCircleCounter.RedPointInfo)localObject1).redTotalNum.get();
      if (!QCircleHostUtil.checkOperateMaskEnabled(l, 1)) {
        break label528;
      }
    }
    label528:
    for (boolean bool = true;; bool = false)
    {
      Object localObject2 = ((QQCircleCounter.RedPointInfo)localObject1).rptRedInfo.get();
      ArrayList localArrayList;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localArrayList = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localArrayList.add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject2).next()).headImg.get());
        }
      }
      for (;;)
      {
        ConversationTitleBtnCtrl.a(this.this$0, ((QQCircleCounter.RedPointInfo)localObject1).extend.get());
        if (((QQCircleCounter.RedPointInfo)localObject1).transInfo.get() != null)
        {
          ConversationTitleBtnCtrl.a(this.this$0, ((QQCircleCounter.RedPointInfo)localObject1).tabType.get());
          int k = i + j;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[updateQQCircleRedFlag]").append("  redDotCombineTypes = ").append(l).append("  pushUnReadNum = ").append(i).append(", chatUnReadNum = ").append(j).append(", showActiveRedDot = ").append(bool).append(", uinList = ").append(localArrayList);
          QLog.d("QCircleEeveeRedPoint_ConversationTitleBtnCtrl", 1, new Object[] { localObject1 });
          if (localArrayList != null) {
            break label485;
          }
          i = 0;
          label284:
          if (ConversationTitleBtnCtrl.a(this.this$0) != k)
          {
            ConversationTitleBtnCtrl.b(this.this$0, k);
            ConversationTitleBtnCtrl.a(this.this$0, true);
          }
          if (ConversationTitleBtnCtrl.a(this.this$0) != bool)
          {
            ConversationTitleBtnCtrl.b(this.this$0, bool);
            ConversationTitleBtnCtrl.a(this.this$0, true);
          }
          if (ConversationTitleBtnCtrl.b(this.this$0) != i)
          {
            ConversationTitleBtnCtrl.c(this.this$0, i);
            ConversationTitleBtnCtrl.a(this.this$0, true);
          }
          ConversationTitleBtnCtrl.a(this.this$0).runOnUiThread(new ConversationTitleBtnCtrl.3.1(this));
          if (ConversationTitleBtnCtrl.b(this.this$0))
          {
            if (ConversationTitleBtnCtrl.a(this.this$0) <= 0) {
              break label496;
            }
            a(2);
          }
        }
        for (;;)
        {
          ConversationTitleBtnCtrl.a(this.this$0, false);
          return;
          ConversationTitleBtnCtrl.a(this.this$0, -1);
          ConversationTitleBtnCtrl.a(this.this$0, null);
          break;
          ConversationTitleBtnCtrl.a(this.this$0, null);
          ConversationTitleBtnCtrl.a(this.this$0, null);
          ConversationTitleBtnCtrl.a(this.this$0, -1);
          localArrayList = null;
          bool = false;
          i = 0;
          break;
          label485:
          i = localArrayList.size();
          break label284;
          label496:
          if (ConversationTitleBtnCtrl.a(this.this$0)) {
            a(1);
          } else {
            a(3);
          }
        }
        localArrayList = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.3
 * JD-Core Version:    0.7.0.1
 */