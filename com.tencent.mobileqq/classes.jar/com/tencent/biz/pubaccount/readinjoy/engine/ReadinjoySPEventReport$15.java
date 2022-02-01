package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import ple;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import ugf;

public final class ReadinjoySPEventReport$15
  implements Runnable
{
  public ReadinjoySPEventReport$15(List paramList, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 0;
    long l2;
    ArrayList localArrayList;
    oidb_cmd0x80a.AttributeList localAttributeList;
    PBStringField localPBStringField;
    if (ple.b(60))
    {
      long l1 = ple.b();
      l2 = ple.a(l1 * 1000L) / 1000L;
      int k = this.jdField_a_of_type_JavaUtilList.size() - 1;
      int i = 0;
      if (k >= 0)
      {
        localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(k);
        if (((ChatMessage)localObject).time > l1)
        {
          if (((ChatMessage)localObject).isSendFromLocal())
          {
            i = j;
            j = 1;
          }
          for (;;)
          {
            int m = k - 1;
            k = j;
            j = i;
            i = k;
            k = m;
            break;
            m = 1;
            j = i;
            i = m;
          }
        }
      }
      localArrayList = new ArrayList();
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("aiotype");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(ple.a(this.jdField_a_of_type_Int)));
      localArrayList.add(localObject);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("unreadmsg");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + this.b);
      localArrayList.add(localObject);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(3);
      localAttributeList.att_name.set("hassendmsg");
      localPBStringField = localAttributeList.att_value;
      if (i == 0) {
        break label441;
      }
      localObject = "1";
      localPBStringField.set((String)localObject);
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(4);
      localAttributeList.att_name.set("hasrecvmsg");
      localPBStringField = localAttributeList.att_value;
      if (j == 0) {
        break label448;
      }
    }
    label441:
    label448:
    for (Object localObject = "1";; localObject = "0")
    {
      localPBStringField.set((String)localObject);
      localArrayList.add(localAttributeList);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("costtime");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + l2);
      localArrayList.add(localObject);
      ugf.a(60, localArrayList);
      return;
      localObject = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.15
 * JD-Core Version:    0.7.0.1
 */