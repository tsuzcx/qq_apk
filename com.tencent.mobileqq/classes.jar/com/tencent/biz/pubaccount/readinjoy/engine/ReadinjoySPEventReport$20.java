package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ota;
import oto;
import sgj;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class ReadinjoySPEventReport$20
  implements Runnable
{
  public ReadinjoySPEventReport$20(int paramInt1, Map paramMap, int paramInt2) {}
  
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
        break label748;
      }
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("operation_bitmap");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(this.b + "");
      localArrayList.add(localObject);
      localObject = ota.a().b;
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(7);
      localAttributeList.att_name.set("staticDurationAfterEnter");
      if (((oto)localObject).a <= 0L) {
        break label743;
      }
    }
    label743:
    for (long l1 = ((oto)localObject).a - ((oto)localObject).d;; l1 = 0L)
    {
      localAttributeList.att_value.set(l1 + "");
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(8);
      localAttributeList.att_name.set("staticDurationBeforeExit");
      l1 = l2;
      if (((oto)localObject).c > 0L) {
        l1 = ((oto)localObject).e - ((oto)localObject).c;
      }
      localAttributeList.att_value.set(l1 + "");
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(9);
      localAttributeList.att_name.set("articleInfoList");
      localAttributeList.att_value.set(((oto)localObject).a());
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(10);
      localAttributeList.att_name.set("scrollInfoList");
      localAttributeList.att_value.set(((oto)localObject).b());
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(11);
      localAttributeList.att_name.set("stayDuration");
      localAttributeList.att_value.set(((oto)localObject).e - ((oto)localObject).d + "");
      localArrayList.add(localAttributeList);
      sgj.a(90, localArrayList);
      return;
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("1");
      break;
    }
    label748:
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(6);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("durationBeforeEnter");
    l2 = System.currentTimeMillis();
    if (ota.f() <= 0L) {}
    for (l1 = ota.a;; l1 = ota.f())
    {
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(l2 - l1 + "");
      localArrayList.add(localObject);
      ota.n();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.20
 * JD-Core Version:    0.7.0.1
 */