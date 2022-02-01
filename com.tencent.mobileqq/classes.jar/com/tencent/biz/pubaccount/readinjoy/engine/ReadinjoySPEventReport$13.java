package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import pfs;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import tzq;

public final class ReadinjoySPEventReport$13
  implements Runnable
{
  public ReadinjoySPEventReport$13(int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    oidb_cmd0x80a.AttributeList localAttributeList1;
    oidb_cmd0x80a.AttributeList localAttributeList2;
    PBStringField localPBStringField;
    if (pfs.b(7))
    {
      localAttributeList1 = new oidb_cmd0x80a.AttributeList();
      localAttributeList1.att_id.set(1);
      localAttributeList1.att_name.set("tab");
      localAttributeList1.att_value.set(String.valueOf(this.jdField_a_of_type_Int));
      localAttributeList2 = new oidb_cmd0x80a.AttributeList();
      localAttributeList2.att_id.set(4);
      localAttributeList2.att_name.set("redStatus");
      localPBStringField = localAttributeList2.att_value;
      if (!this.jdField_a_of_type_Boolean) {
        break label125;
      }
    }
    label125:
    for (Object localObject = "1";; localObject = "0")
    {
      localPBStringField.set((String)localObject);
      localObject = new ArrayList();
      ((List)localObject).add(localAttributeList1);
      ((List)localObject).add(localAttributeList2);
      tzq.a(7, (List)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.13
 * JD-Core Version:    0.7.0.1
 */