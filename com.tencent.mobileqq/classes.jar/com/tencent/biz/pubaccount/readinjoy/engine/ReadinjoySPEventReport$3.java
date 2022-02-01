package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$3
  implements Runnable
{
  ReadinjoySPEventReport$3(boolean paramBoolean) {}
  
  public void run()
  {
    if ((!this.a) && (!ReadinjoySPEventReport.c())) {}
    label295:
    label303:
    label309:
    label314:
    for (;;)
    {
      return;
      if (this.a)
      {
        ReadinjoySPEventReport.c(System.currentTimeMillis());
        ReadinjoySPEventReport.a(true);
      }
      ReadinjoySPEventReport.b(this.a);
      Object localObject;
      if (ReadinjoySPEventReport.b(9))
      {
        ArrayList localArrayList = new ArrayList();
        oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(1);
        localAttributeList.att_name.set("isOn");
        PBStringField localPBStringField = localAttributeList.att_value;
        if (!this.a) {
          break label295;
        }
        localObject = String.valueOf(1);
        localPBStringField.set((String)localObject);
        localArrayList.add(localAttributeList);
        if (!this.a)
        {
          long l = ReadinjoySPEventReport.e();
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
          if (!ReadinjoySPEventReport.d()) {
            break label303;
          }
          localObject = "1";
          label231:
          localPBStringField.set((String)localObject);
          localArrayList.add(localAttributeList);
        }
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(9, localArrayList);
        if (!this.a) {
          break label309;
        }
        ReadinjoySPEventReport.d(System.currentTimeMillis());
        ReadinjoySPEventReport.c(0);
      }
      for (;;)
      {
        if (ReadinjoySPEventReport.ForeBackGround.a != 1) {
          break label314;
        }
        ReadinjoySPEventReport.d(false);
        return;
        localObject = String.valueOf(0);
        break;
        localObject = "0";
        break label231;
        ReadinjoySPEventReport.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.3
 * JD-Core Version:    0.7.0.1
 */