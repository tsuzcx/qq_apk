package com.tencent.mobileqq.activity;

import android.app.Activity;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

class ConversationTitleBtnCtrl$4
  implements Runnable
{
  ConversationTitleBtnCtrl$4(ConversationTitleBtnCtrl paramConversationTitleBtnCtrl) {}
  
  private void a(int paramInt)
  {
    if ((!QzoneConfig.getQQCircleEnableNoneRedpointReport()) && (paramInt == 3)) {
      return;
    }
    if ((!QzoneConfig.getQQCircleEnableHasRedpointReport()) && (paramInt != 3)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext1", "1");
    localHashMap.put("ext5", ConversationTitleBtnCtrl.l(this.this$0));
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(2).setSubActionType(1).setThrActionType(paramInt).setExtras(localHashMap));
  }
  
  public void run()
  {
    QQCircleCounter.RedPointInfo localRedPointInfo = QCircleUtils.b().getOuterEntranceRedPointInfoByAppid("circle_entrance");
    Object localObject1 = null;
    long l;
    int i;
    boolean bool;
    if (localRedPointInfo != null)
    {
      l = localRedPointInfo.outLayerInfo.combineRedTypes.get();
      i = localRedPointInfo.redTotalNum.get();
      bool = QCircleHostUtil.checkOperateMaskEnabled(l, 1);
      localObject1 = localRedPointInfo.rptRedInfo.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          ((List)localObject2).add(((QQCircleCounter.RedDisplayInfo)localIterator.next()).headImg.get());
        }
      }
      localObject1 = null;
      ConversationTitleBtnCtrl.a(this.this$0, localRedPointInfo.extend.get());
      if (localRedPointInfo.transInfo.get() != null)
      {
        ConversationTitleBtnCtrl.a(this.this$0, localRedPointInfo.tabType.get());
      }
      else
      {
        ConversationTitleBtnCtrl.a(this.this$0, -1);
        ConversationTitleBtnCtrl.a(this.this$0, null);
      }
    }
    else
    {
      ConversationTitleBtnCtrl.a(this.this$0, null);
      ConversationTitleBtnCtrl.a(this.this$0, null);
      ConversationTitleBtnCtrl.a(this.this$0, -1);
      l = 0L;
      i = 0;
      bool = false;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[updateQQCircleRedFlag]");
    ((StringBuilder)localObject2).append("  redDotCombineTypes = ");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("  pushUnReadNum = ");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", showActiveRedDot = ");
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append(", uinList = ");
    ((StringBuilder)localObject2).append(localObject1);
    QLog.d("QCircleEeveeRedPoint_ConversationTitleBtnCtrl", 1, new Object[] { localObject2 });
    int j;
    if (localObject1 == null) {
      j = 0;
    } else {
      j = ((List)localObject1).size();
    }
    if (ConversationTitleBtnCtrl.f(this.this$0) != i)
    {
      ConversationTitleBtnCtrl.b(this.this$0, i);
      ConversationTitleBtnCtrl.a(this.this$0, true);
    }
    if (ConversationTitleBtnCtrl.g(this.this$0) != bool)
    {
      ConversationTitleBtnCtrl.b(this.this$0, bool);
      ConversationTitleBtnCtrl.a(this.this$0, true);
    }
    if (ConversationTitleBtnCtrl.h(this.this$0) != j)
    {
      ConversationTitleBtnCtrl.c(this.this$0, j);
      ConversationTitleBtnCtrl.a(this.this$0, true);
    }
    ConversationTitleBtnCtrl.a(this.this$0).runOnUiThread(new ConversationTitleBtnCtrl.4.1(this));
    if (ConversationTitleBtnCtrl.k(this.this$0))
    {
      if (ConversationTitleBtnCtrl.f(this.this$0) > 0) {
        a(2);
      } else if (ConversationTitleBtnCtrl.g(this.this$0)) {
        a(1);
      } else {
        a(3);
      }
      ConversationTitleBtnCtrl.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.4
 * JD-Core Version:    0.7.0.1
 */