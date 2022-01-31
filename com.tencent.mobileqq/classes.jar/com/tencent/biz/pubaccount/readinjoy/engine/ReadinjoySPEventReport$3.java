package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import ohp;
import ohs;
import rtr;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class ReadinjoySPEventReport$3
  implements Runnable
{
  public ReadinjoySPEventReport$3(boolean paramBoolean) {}
  
  public void run()
  {
    if ((!this.a) && (!ohp.c())) {}
    label285:
    label293:
    label299:
    label304:
    for (;;)
    {
      return;
      if (this.a)
      {
        ohp.c(System.currentTimeMillis());
        ohp.a(true);
      }
      ohp.b(this.a);
      Object localObject;
      if (ohp.b(9))
      {
        ArrayList localArrayList = new ArrayList();
        oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(1);
        localAttributeList.att_name.set("isOn");
        PBStringField localPBStringField = localAttributeList.att_value;
        if (!this.a) {
          break label285;
        }
        localObject = String.valueOf(1);
        localPBStringField.set((String)localObject);
        localArrayList.add(localAttributeList);
        if (!this.a)
        {
          long l = ohp.e();
          l = (System.currentTimeMillis() - l) / 1000L;
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("time");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(l));
          localArrayList.add(localObject);
          localAttributeList = new oidb_cmd0x80a.AttributeList();
          localAttributeList.att_id.set(3);
          localAttributeList.att_name.set("isScreenTime");
          localPBStringField = localAttributeList.att_value;
          if (!ohp.d()) {
            break label293;
          }
          localObject = "1";
          label231:
          localPBStringField.set((String)localObject);
          localArrayList.add(localAttributeList);
        }
        rtr.a(9, localArrayList);
        if (!this.a) {
          break label299;
        }
        ohp.d(System.currentTimeMillis());
        ohp.c(0);
      }
      for (;;)
      {
        if (ohs.a != 1) {
          break label304;
        }
        ohp.d(false);
        return;
        localObject = String.valueOf(0);
        break;
        localObject = "0";
        break label231;
        ohp.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.3
 * JD-Core Version:    0.7.0.1
 */