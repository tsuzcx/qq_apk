package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sgj;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class ReadinjoySPEventReport$19
  implements Runnable
{
  public ReadinjoySPEventReport$19(int paramInt1, Map paramMap, int paramInt2) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("op_type");
    localAttributeList.att_value.set(this.jdField_a_of_type_Int + "");
    localArrayList.add(localAttributeList);
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(2);
      localAttributeList.att_name.set("subscribe_folderstatus");
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey("folder_status")) {
        break label385;
      }
      localAttributeList.att_value.set((String)this.jdField_a_of_type_JavaUtilMap.get("folder_status"));
    }
    for (;;)
    {
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(3);
      localAttributeList.att_name.set("strategy_id");
      localAttributeList.att_value.set((String)this.jdField_a_of_type_JavaUtilMap.get("strategy_id"));
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(4);
      localAttributeList.att_name.set("algorithm_id");
      localAttributeList.att_value.set((String)this.jdField_a_of_type_JavaUtilMap.get("algorithm_id"));
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(5);
      localAttributeList.att_name.set("action_data");
      localAttributeList.att_value.set((String)this.jdField_a_of_type_JavaUtilMap.get("action_data"));
      localArrayList.add(localAttributeList);
      if (this.jdField_a_of_type_Int == 1)
      {
        localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(6);
        localAttributeList.att_name.set("operation_bitmap");
        localAttributeList.att_value.set(this.b + "");
        localArrayList.add(localAttributeList);
      }
      sgj.a(70, localArrayList);
      return;
      label385:
      localAttributeList.att_value.set("1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.19
 * JD-Core Version:    0.7.0.1
 */