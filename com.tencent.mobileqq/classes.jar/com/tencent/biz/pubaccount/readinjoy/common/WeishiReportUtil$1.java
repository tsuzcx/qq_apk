package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import pai;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import tzq;

public final class WeishiReportUtil$1
  implements Runnable
{
  public WeishiReportUtil$1(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("EnterType");
    localAttributeList.att_value.set(pai.a(this.jdField_a_of_type_Int));
    localArrayList.add(localAttributeList);
    localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(2);
    localAttributeList.att_name.set("FolderStatus");
    localAttributeList.att_value.set("" + this.jdField_a_of_type_JavaLangString);
    localArrayList.add(localAttributeList);
    if (!"1".equals(this.jdField_a_of_type_JavaLangString))
    {
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(3);
      localAttributeList.att_name.set("StrategyID");
      localAttributeList.att_value.set(this.b);
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(4);
      localAttributeList.att_name.set("AlgorithmID");
      localAttributeList.att_value.set(this.c);
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(5);
      localAttributeList.att_name.set("costtime");
      localAttributeList.att_value.set("" + this.d);
      localArrayList.add(localAttributeList);
    }
    tzq.a(25, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.1
 * JD-Core Version:    0.7.0.1
 */