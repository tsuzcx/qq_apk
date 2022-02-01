package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$20
  implements Runnable
{
  ReadinjoySPEventReport$20(int paramInt1, Map paramMap, int paramInt2) {}
  
  public void run()
  {
    long l2 = 0L;
    ArrayList localArrayList = new ArrayList();
    Object localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("op_type");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(this.jdField_a_of_type_Int + "");
    localArrayList.add(localObject);
    oidb_cmd0x80a.AttributeList localAttributeList;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("daily_folderstatus");
      if (this.jdField_a_of_type_JavaUtilMap.containsKey("folder_status"))
      {
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set((String)this.jdField_a_of_type_JavaUtilMap.get("folder_status"));
        localArrayList.add(localObject);
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("strategy_id");
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set((String)this.jdField_a_of_type_JavaUtilMap.get("strategy_id"));
        localArrayList.add(localObject);
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(4);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("algorithm_id");
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set((String)this.jdField_a_of_type_JavaUtilMap.get("algorithm_id"));
        localArrayList.add(localObject);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label758;
      }
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("operation_bitmap");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(this.b + "");
      localArrayList.add(localObject);
      localObject = ReadinjoySPEventReport.a().b;
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(7);
      localAttributeList.att_name.set("staticDurationAfterEnter");
      if (((ReadinjoySPEventReport.UserOptInfo)localObject).a <= 0L) {
        break label753;
      }
    }
    label753:
    for (long l1 = ((ReadinjoySPEventReport.UserOptInfo)localObject).a - ((ReadinjoySPEventReport.UserOptInfo)localObject).d;; l1 = 0L)
    {
      localAttributeList.att_value.set(l1 + "");
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(8);
      localAttributeList.att_name.set("staticDurationBeforeExit");
      l1 = l2;
      if (((ReadinjoySPEventReport.UserOptInfo)localObject).c > 0L) {
        l1 = ((ReadinjoySPEventReport.UserOptInfo)localObject).e - ((ReadinjoySPEventReport.UserOptInfo)localObject).c;
      }
      localAttributeList.att_value.set(l1 + "");
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(9);
      localAttributeList.att_name.set("articleInfoList");
      localAttributeList.att_value.set(((ReadinjoySPEventReport.UserOptInfo)localObject).a());
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(10);
      localAttributeList.att_name.set("scrollInfoList");
      localAttributeList.att_value.set(((ReadinjoySPEventReport.UserOptInfo)localObject).b());
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(11);
      localAttributeList.att_name.set("stayDuration");
      localAttributeList.att_value.set(((ReadinjoySPEventReport.UserOptInfo)localObject).e - ((ReadinjoySPEventReport.UserOptInfo)localObject).d + "");
      localArrayList.add(localAttributeList);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(90, localArrayList);
      return;
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("1");
      break;
    }
    label758:
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(6);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("durationBeforeEnter");
    l2 = System.currentTimeMillis();
    if (ReadinjoySPEventReport.f() <= 0L) {}
    for (l1 = ReadinjoySPEventReport.a;; l1 = ReadinjoySPEventReport.f())
    {
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(l2 - l1 + "");
      localArrayList.add(localObject);
      ReadinjoySPEventReport.n();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.20
 * JD-Core Version:    0.7.0.1
 */