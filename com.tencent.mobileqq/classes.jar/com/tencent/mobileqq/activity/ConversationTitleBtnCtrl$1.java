package com.tencent.mobileqq.activity;

import aeav;
import android.app.Activity;
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
import vrf;

public class ConversationTitleBtnCtrl$1
  implements Runnable
{
  public ConversationTitleBtnCtrl$1(aeav paramaeav) {}
  
  public void run()
  {
    Object localObject2 = (vqu)BaseApplicationImpl.getApplication().getRuntime().getManager(376);
    Object localObject1 = new ArrayList();
    Object localObject3 = ((vqu)localObject2).b("circle_entrance");
    int i;
    if (localObject3 != null)
    {
      i = ((QQCircleCounter.RedPointInfo)localObject3).redTotalNum.get();
      aeav.a(this.this$0, ((QQCircleCounter.RedPointInfo)localObject3).extend.get());
      if ((aeav.a(this.this$0) == null) || (aeav.a(this.this$0).a == null)) {
        break label603;
      }
    }
    label430:
    label597:
    label603:
    for (int j = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();; j = 0)
    {
      int k = i + j;
      localObject2 = ((vqu)localObject2).a("circle_entrance");
      if (localObject2 != null)
      {
        localObject3 = ((QQCircleCounter.RedPointInfo)localObject2).rptRedInfo.get();
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          break label597;
        }
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((List)localObject1).add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject3).next()).headImg.get());
            continue;
            aeav.a(this.this$0, null);
            i = 0;
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        aeav.b(this.this$0, ((QQCircleCounter.RedPointInfo)localObject2).extend.get());
        QLog.d("ConversationTitleBtnCtrl", 1, "isEevee: " + vqu.a() + ", showActiveRedDot: " + bool + ", redPointNum: " + i + ", uinList: " + localObject1 + ", chatUnReadNum: " + j);
        if (aeav.a(this.this$0) != k)
        {
          aeav.a(this.this$0, k);
          aeav.a(this.this$0, true);
        }
        if (aeav.a(this.this$0) != bool)
        {
          aeav.b(this.this$0, bool);
          aeav.a(this.this$0, true);
        }
        if (aeav.b(this.this$0) != ((List)localObject1).size())
        {
          aeav.b(this.this$0, ((List)localObject1).size());
          aeav.a(this.this$0, true);
        }
        aeav.a(this.this$0).runOnUiThread(new ConversationTitleBtnCtrl.1.1(this));
        if (aeav.b(this.this$0))
        {
          if (!vqu.a()) {
            break label498;
          }
          localObject1 = "1";
          if (aeav.a(this.this$0) <= 0) {
            break label505;
          }
          vrf.a("", 2, 1, 2, (String)localObject1, "", aeav.a(this.this$0), aeav.b(this.this$0), "", "", null, -1, -1);
        }
        for (;;)
        {
          aeav.a(this.this$0, false);
          return;
          aeav.b(this.this$0, null);
          bool = false;
          break;
          label498:
          localObject1 = "0";
          break label430;
          label505:
          if ((aeav.a(this.this$0)) && (aeav.b(this.this$0) > 0)) {
            vrf.a("", 2, 1, 1, (String)localObject1, "", aeav.a(this.this$0), aeav.b(this.this$0), "", "", null, -1, -1);
          } else {
            vrf.a("", 2, 1, 3, (String)localObject1, "", aeav.a(this.this$0), aeav.b(this.this$0), "", "", null, -1, -1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1
 * JD-Core Version:    0.7.0.1
 */