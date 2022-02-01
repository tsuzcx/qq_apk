package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

class ReadinjoySPEventReport$11
  implements Runnable
{
  ReadinjoySPEventReport$11(ReadinjoySPEventReport paramReadinjoySPEventReport, String paramString, long paramLong) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
    localAttributeList1.att_id.set(1);
    localAttributeList1.att_name.set("uin");
    localAttributeList1.att_value.set("" + this.jdField_a_of_type_JavaLangString);
    oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
    localAttributeList2.att_id.set(2);
    localAttributeList2.att_name.set("time");
    localAttributeList2.att_value.set(String.valueOf(ReadinjoySPEventReport.a(this.jdField_a_of_type_Long) / 1000L));
    localArrayList.add(localAttributeList1);
    localArrayList.add(localAttributeList2);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(21, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.11
 * JD-Core Version:    0.7.0.1
 */