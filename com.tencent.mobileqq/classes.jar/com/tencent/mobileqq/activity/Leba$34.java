package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import cooperation.qqcircle.chat.QCircleChatBoxHelper;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.PymkRedPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

class Leba$34
  implements Runnable
{
  Leba$34(Leba paramLeba) {}
  
  public void run()
  {
    int m = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
    if (m > 0) {}
    boolean bool2;
    boolean bool1;
    ArrayList localArrayList;
    boolean bool3;
    boolean bool4;
    Object localObject3;
    boolean bool5;
    QQCircleCounter.RedPointInfo localRedPointInfo;
    long l;
    int k;
    int j;
    Object localObject1;
    for (int i = m;; i = 0)
    {
      bool2 = false;
      bool1 = false;
      localArrayList = null;
      bool3 = false;
      bool4 = false;
      localObject3 = null;
      bool5 = QzoneConfig.isQQCircleUseEeveeRedPoint();
      localRedPointInfo = ((QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QCIRCLE_MGR_RED_TOUCH)).getOuterEntranceRedPointInfoByAppid("circle_entrance");
      if (localRedPointInfo == null) {
        break label807;
      }
      l = localRedPointInfo.outLayerInfo.combineRedTypes.get();
      k = localRedPointInfo.redTotalNum.get();
      j = i;
      if (k > 0) {
        j = i + k;
      }
      bool2 = bool1;
      if (QCircleCommonUtil.checkOperateMaskEnabled(l, 1)) {
        bool2 = true;
      }
      localObject1 = localRedPointInfo.rptRedInfo.get();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label801;
      }
      localArrayList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject1).next()).headImg.get());
      }
    }
    Object localObject2;
    label234:
    String str;
    int n;
    if (QCircleCommonUtil.checkOperateMaskEnabled(l, 6))
    {
      localObject2 = localRedPointInfo.pymkRedInfo.wording.get();
      bool1 = true;
      localObject1 = localObject2;
      bool3 = bool4;
      if (m <= 0)
      {
        localObject1 = localObject2;
        bool3 = bool4;
        if (QCircleCommonUtil.checkOperateMaskEnabled(l, 3))
        {
          localObject1 = localRedPointInfo.allPushInfo.wording.get();
          bool3 = true;
        }
      }
      str = localRedPointInfo.extend.get();
      if ((j > 0) || (bool2) || (bool3) || (bool1))
      {
        ByteStringMicro localByteStringMicro = localRedPointInfo.transInfo.get();
        localObject2 = localObject3;
        if (localByteStringMicro != null)
        {
          localObject2 = localObject3;
          if (localByteStringMicro.size() > 0) {
            localObject2 = localByteStringMicro.toByteArray();
          }
        }
        n = localRedPointInfo.tabType.get();
        i = k;
        k = n;
      }
    }
    for (;;)
    {
      Leba.a(this.this$0, str);
      Leba.a(this.this$0, (byte[])localObject2);
      Leba.a(this.this$0, k);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[updateQQCircleRedFlag]").append("  isQQCircleUseEeveeRedPoint = ").append(bool5).append(", redDotCombineTypes = ").append(l).append(", pushUnReadNum = ").append(i).append(", chatUnReadNum = ").append(m).append(", showActiveRedDot = ").append(bool2).append(", showPYMKRedDot = ").append(bool1).append(", uinList = ").append(localArrayList).append(", showRecommendRedDot = ").append(bool3).append(", recommendRedDotWording = ").append((String)localObject1).append(", entranceTargetTabType = ").append(k).append(", redDotReportExt = ").append(str);
      QLog.d("QCircleEeveeRedPoint_Leba", 2, new Object[] { localObject2 });
      if (localArrayList == null) {}
      for (i = 0;; i = localArrayList.size())
      {
        if (Leba.a(this.this$0) != j)
        {
          Leba.b(this.this$0, j);
          Leba.e(this.this$0, true);
        }
        if (Leba.e(this.this$0) != bool2)
        {
          Leba.f(this.this$0, bool2);
          Leba.e(this.this$0, true);
        }
        if (Leba.b(this.this$0) != i)
        {
          Leba.c(this.this$0, i);
          Leba.e(this.this$0, true);
        }
        if (Leba.f(this.this$0))
        {
          Leba.g(this.this$0, false);
          Leba.e(this.this$0, true);
        }
        if (Leba.g(this.this$0) != bool1)
        {
          Leba.h(this.this$0, bool1);
          Leba.e(this.this$0, true);
        }
        if (Leba.h(this.this$0) != bool3)
        {
          Leba.i(this.this$0, bool3);
          Leba.e(this.this$0, true);
        }
        if (!TextUtils.equals(Leba.a(this.this$0), (CharSequence)localObject1))
        {
          Leba.b(this.this$0, (String)localObject1);
          Leba.e(this.this$0, true);
        }
        Leba.a(this.this$0, j, bool2, localArrayList, false, bool3, bool1, (String)localObject1);
        return;
      }
      i = k;
      localObject2 = null;
      k = -1;
      continue;
      localObject2 = null;
      bool1 = false;
      break label234;
      label801:
      localArrayList = null;
      break;
      label807:
      k = -1;
      localObject1 = null;
      str = null;
      localObject2 = null;
      bool1 = false;
      n = 0;
      l = 0L;
      j = i;
      i = n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.34
 * JD-Core Version:    0.7.0.1
 */