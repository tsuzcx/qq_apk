package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import pmy;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import tzo;

public final class ReadinjoySPEventReport$12
  implements Runnable
{
  public ReadinjoySPEventReport$12(long paramLong) {}
  
  public void run()
  {
    if (pmy.b(23))
    {
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("time");
      localAttributeList.att_value.set(String.valueOf(this.a / 1000L));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localAttributeList);
      tzo.a(23, localArrayList);
    }
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.12.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.12
 * JD-Core Version:    0.7.0.1
 */