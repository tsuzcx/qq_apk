package com.tencent.biz.pubaccount.ecshopassit;

import acvb;
import acwb;
import acwc;
import acwd;
import bhsr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import oer;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet;

public class EcshopAdHandler$4
  implements Runnable
{
  public EcshopAdHandler$4(oer paramoer, int paramInt, List paramList1, List paramList2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        qq_ad.QQAdGet localQQAdGet = new qq_ad.QQAdGet();
        localQQAdGet.trigger_type.set(this.jdField_a_of_type_Int);
        Object localObject1 = new acwc();
        ((acwc)localObject1).jdField_a_of_type_JavaLangString = "cd22b9";
        long l = System.currentTimeMillis();
        localObject1 = acwb.a(BaseApplicationImpl.getApplication().getApplicationContext(), (acwc)localObject1);
        if (localObject1 == null) {
          break label403;
        }
        localObject1 = ((acwd)localObject1).a;
        Object localObject3 = acvb.a((PBField)localObject1);
        if ((localObject3 != null) && (localObject3 != JSONObject.NULL))
        {
          localObject3 = localObject3.toString();
          if (QLog.isColorLevel()) {
            QLog.i("Ecshop_EcshopAdHandler", 2, (String)localObject3);
          }
          if (!bhsr.a((String)localObject3)) {
            localQQAdGet.device_info.set((String)localObject3);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("get deviceInfo cost：").append(System.currentTimeMillis() - l).append(", result = ");
          if (localObject1 != null) {
            bool = true;
          }
          QLog.i("Ecshop_EcshopAdHandler", 2, bool);
        }
        if (this.jdField_a_of_type_JavaUtilList != null) {
          localQQAdGet.pos_id.set(this.jdField_a_of_type_JavaUtilList);
        }
        if (this.b != null) {
          localQQAdGet.ad_count.set(this.b);
        }
        localQQAdGet.get_back.set(this.jdField_a_of_type_Boolean);
        localQQAdGet.last_req_time.set(this.this$0.jdField_a_of_type_Long);
        if (this.this$0.jdField_a_of_type_JavaUtilSet.size() > 5)
        {
          int i = this.this$0.jdField_a_of_type_JavaUtilSet.size();
          localObject1 = new Long[5];
          System.arraycopy(this.this$0.jdField_a_of_type_JavaUtilSet.toArray(), i - 5, localObject1, 0, 5);
          localObject1 = Arrays.asList((Object[])localObject1);
          break label395;
          localObject1 = new ToServiceMsg("mobileqq.service", this.this$0.app.c(), this.jdField_a_of_type_JavaLangString);
          ((ToServiceMsg)localObject1).putWupBuffer(localQQAdGet.toByteArray());
          this.this$0.sendPbReq((ToServiceMsg)localObject1);
          this.this$0.jdField_a_of_type_Long = (System.currentTimeMillis() / 1000L);
        }
        else
        {
          localObject1 = new ArrayList(this.this$0.jdField_a_of_type_JavaUtilSet);
        }
      }
      catch (Exception localException)
      {
        return;
      }
      label395:
      if (localException != null)
      {
        continue;
        label403:
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.4
 * JD-Core Version:    0.7.0.1
 */