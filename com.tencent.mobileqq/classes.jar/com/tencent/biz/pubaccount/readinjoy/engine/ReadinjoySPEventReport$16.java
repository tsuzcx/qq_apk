package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import oxp;
import oyb;
import oyc;
import syb;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class ReadinjoySPEventReport$16
  implements Runnable
{
  public ReadinjoySPEventReport$16(List paramList) {}
  
  public void run()
  {
    if (oxp.b(19))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new StringBuilder();
      int j = 0;
      long l = 0L;
      int k = 0;
      int i = 0;
      if (j < this.a.size())
      {
        localObject2 = (oyc)this.a.get(j);
        ((StringBuilder)localObject1).append(((oyc)localObject2).jdField_a_of_type_Int + "-" + ((oyc)localObject2).jdField_a_of_type_Long + "-" + ((oyc)localObject2).b + "-" + ((oyc)localObject2).c);
        if (j != this.a.size() - 1) {
          ((StringBuilder)localObject1).append(":");
        }
        for (;;)
        {
          i += ((oyc)localObject2).b;
          l += ((oyc)localObject2).jdField_a_of_type_Long;
          j += 1;
          break;
          k = ((oyc)localObject2).d;
        }
      }
      Object localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("scrollstep");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((StringBuilder)localObject1).toString());
      localArrayList.add(localObject2);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("distancetotal");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set("" + i);
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("scrolltimetotal");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set("" + l);
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(4);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("items");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set("" + k);
      localArrayList.add(localObject1);
      syb.a(19, localArrayList);
    }
    oyb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.16
 * JD-Core Version:    0.7.0.1
 */