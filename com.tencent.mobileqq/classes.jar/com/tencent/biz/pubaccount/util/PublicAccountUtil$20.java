package com.tencent.biz.pubaccount.util;

import aepi;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import oxp;
import phg;
import puz;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class PublicAccountUtil$20
  implements Runnable
{
  public PublicAccountUtil$20(List paramList, int paramInt) {}
  
  public void run()
  {
    try
    {
      phg localphg = new phg(null, null, null, puz.a(), null);
      this.jdField_a_of_type_JavaUtilList.addAll(oxp.a().a(this.jdField_a_of_type_Int));
      String str = "KDreportPushEffectEvent info : eventId:" + Integer.toString(this.jdField_a_of_type_Int) + "; AttributeList:[";
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        oidb_cmd0x80a.AttributeList localAttributeList = (oidb_cmd0x80a.AttributeList)localIterator.next();
        str = str + "{ att_id:" + Integer.toString(localAttributeList.att_id.get()) + "; att_name:" + localAttributeList.att_name.get() + "; att_value:" + localAttributeList.att_value.get() + " },";
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, str);
      }
      localphg.a(this.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaUtilList);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PublicAccountUtil", 1, "reportPushEffectEvent", localException);
      aepi.a("PublicAccountUtil", localException.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.20
 * JD-Core Version:    0.7.0.1
 */