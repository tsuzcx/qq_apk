package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

class PublicAccountUtilImpl$20
  implements Runnable
{
  PublicAccountUtilImpl$20(PublicAccountUtilImpl paramPublicAccountUtilImpl, List paramList, int paramInt) {}
  
  public void run()
  {
    try
    {
      UserOperationModule localUserOperationModule = new UserOperationModule(null, null, null, ReadInJoyMSFService.a(), null);
      this.jdField_a_of_type_JavaUtilList.addAll(ReadinjoySPEventReport.a().a(this.jdField_a_of_type_Int));
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
      localUserOperationModule.a(this.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaUtilList);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PublicAccountUtil", 1, "reportPushEffectEvent", localException);
      AIOUtils.a("PublicAccountUtil", localException.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.20
 * JD-Core Version:    0.7.0.1
 */