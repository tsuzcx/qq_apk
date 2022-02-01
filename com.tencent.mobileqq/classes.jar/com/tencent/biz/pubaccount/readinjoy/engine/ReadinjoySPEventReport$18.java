package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import uuc;

public final class ReadinjoySPEventReport$18
  implements Runnable
{
  public ReadinjoySPEventReport$18(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
    localAttributeList1.att_id.set(1);
    localAttributeList1.att_name.set("FolderStatus");
    localAttributeList1.att_value.set(String.valueOf(this.a));
    oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
    localAttributeList2.att_id.set(2);
    localAttributeList2.att_name.set("StrategyID");
    localAttributeList2.att_value.set(this.b + "");
    oidb_cmd0x80a.AttributeList localAttributeList3 = new oidb_cmd0x80a.AttributeList();
    localAttributeList3.att_id.set(3);
    localAttributeList3.att_name.set("AlgorithmID");
    localAttributeList3.att_value.set(this.c + "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localAttributeList1);
    localArrayList.add(localAttributeList2);
    localArrayList.add(localAttributeList3);
    uuc.a(this.d, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.18
 * JD-Core Version:    0.7.0.1
 */