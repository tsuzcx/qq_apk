package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleChatBoxHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import uzg;
import vtf;

class Leba$36
  implements Runnable
{
  Leba$36(Leba paramLeba) {}
  
  public void run()
  {
    long l = 0L;
    int m = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
    if (m > 0) {}
    boolean bool1;
    boolean bool2;
    ArrayList localArrayList;
    Object localObject4;
    boolean bool3;
    QQCircleCounter.RedPointInfo localRedPointInfo;
    int k;
    int j;
    Object localObject1;
    for (int i = m;; i = 0)
    {
      bool1 = false;
      bool2 = false;
      localArrayList = new ArrayList();
      localObject4 = null;
      bool3 = QzoneConfig.isQQCircleUseEeveeRedPoint();
      localRedPointInfo = ((vtf)BaseApplicationImpl.getApplication().getRuntime().getManager(376)).a("circle_entrance");
      if (localRedPointInfo == null) {
        break label724;
      }
      l = localRedPointInfo.outLayerInfo.combineRedTypes.get();
      k = localRedPointInfo.redTotalNum.get();
      j = i;
      if (k > 0) {
        j = i + k;
      }
      bool1 = bool2;
      if (uzg.a(l, 1)) {
        bool1 = true;
      }
      localObject1 = localRedPointInfo.rptRedInfo.get();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject1).next()).headImg.get());
      }
    }
    Object localObject3;
    Object localObject2;
    label286:
    int n;
    if ((m <= 0) && (uzg.a(l, 3)))
    {
      localObject1 = localRedPointInfo.allPushInfo.wording.get();
      bool2 = true;
      localObject3 = localRedPointInfo.extend.get();
      if ((j > 0) || (bool1) || (bool2))
      {
        localObject2 = localRedPointInfo.transInfo.get();
        if ((localObject2 != null) && (((ByteStringMicro)localObject2).size() > 0))
        {
          localObject2 = ((ByteStringMicro)localObject2).toByteArray();
          n = localRedPointInfo.tabType.get();
          i = k;
          localObject4 = localObject2;
          k = n;
          localObject2 = localObject3;
          localObject3 = localObject4;
        }
      }
    }
    for (;;)
    {
      Leba.a(this.this$0, (String)localObject2);
      Leba.a(this.this$0, (byte[])localObject3);
      Leba.a(this.this$0, k);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[updateQQCircleRedFlag]").append("  isQQCircleUseEeveeRedPoint = ").append(bool3).append(", redDotCombineTypes = ").append(l).append(", pushUnReadNum = ").append(i).append(", chatUnReadNum = ").append(m).append(", showActiveRedDot = ").append(bool1).append(", uinList = ").append(localArrayList).append(", showRecommendRedDot = ").append(bool2).append(", recommendRedDotWording = ").append((String)localObject1).append(", entranceTargetTabType = ").append(k).append(", redDotReportExt = ").append((String)localObject2);
      QLog.d("QCircleEeveeRedPoint_Leba", 2, new Object[] { localObject3 });
      if (localArrayList == null) {}
      for (i = 0;; i = localArrayList.size())
      {
        if (Leba.b(this.this$0) != j)
        {
          Leba.b(this.this$0, j);
          Leba.e(this.this$0, true);
        }
        if (Leba.e(this.this$0) != bool1)
        {
          Leba.f(this.this$0, bool1);
          Leba.e(this.this$0, true);
        }
        if (Leba.c(this.this$0) != i)
        {
          Leba.c(this.this$0, i);
          Leba.e(this.this$0, true);
        }
        if (Leba.f(this.this$0))
        {
          Leba.g(this.this$0, false);
          Leba.e(this.this$0, true);
        }
        if (Leba.g(this.this$0) != bool2)
        {
          Leba.h(this.this$0, bool2);
          Leba.e(this.this$0, true);
        }
        if (!TextUtils.equals(Leba.a(this.this$0), (CharSequence)localObject1))
        {
          Leba.b(this.this$0, (String)localObject1);
          Leba.e(this.this$0, true);
        }
        Leba.a(this.this$0, j, bool1, localArrayList, false, bool2, (String)localObject1);
        return;
      }
      localObject2 = null;
      break label286;
      n = -1;
      localObject2 = localObject3;
      i = k;
      k = n;
      localObject3 = localObject4;
      continue;
      localObject1 = null;
      bool2 = false;
      break;
      label724:
      k = -1;
      localObject2 = null;
      n = 0;
      localObject1 = null;
      bool2 = false;
      j = i;
      localObject3 = localObject4;
      i = n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.36
 * JD-Core Version:    0.7.0.1
 */