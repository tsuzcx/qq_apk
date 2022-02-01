package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

class ReadinjoySPEventReport$7
  implements Runnable
{
  ReadinjoySPEventReport$7(ReadinjoySPEventReport paramReadinjoySPEventReport) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("OneClickRead");
    localAttributeList.att_value.set(String.valueOf(System.currentTimeMillis() / 1000L));
    localArrayList.add(localAttributeList);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(13, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.7
 * JD-Core Version:    0.7.0.1
 */