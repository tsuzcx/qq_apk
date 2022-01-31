package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
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
import nqx;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet.Phone;
import yys;
import yyt;
import yyu;
import yyv;

public class EcshopAdHandler$4
  implements Runnable
{
  public EcshopAdHandler$4(nqx paramnqx, List paramList1, List paramList2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        qq_ad.QQAdGet localQQAdGet = new qq_ad.QQAdGet();
        qq_ad.QQAdGet.Phone localPhone = new qq_ad.QQAdGet.Phone();
        Object localObject1 = new yyt();
        ((yyt)localObject1).jdField_a_of_type_JavaLangString = "cd22b9";
        long l = System.currentTimeMillis();
        localObject1 = yys.a(BaseApplicationImpl.getApplication().getApplicationContext(), (yyt)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((yyu)localObject1).a;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("get deviceInfo cost：").append(System.currentTimeMillis() - l).append(", result = ");
            if (localObject1 != null) {
              bool = true;
            }
            QLog.i("EcshopAdHandler", 2, bool);
          }
          if (localObject1 != null)
          {
            localPhone.carrier.set(yyv.a(this.this$0.app.getApplication()));
            localPhone.muid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid.get());
            localPhone.muid_type.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).muid_type.get());
            localPhone.conn.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).conn.get());
            localPhone.os_ver.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).os_ver.get());
            localPhone.qq_ver.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qq_ver.get());
            localPhone.app_id.set(AppSetting.a());
            localPhone.os_type.set(2);
            if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).location != null)
            {
              localPhone.latitude.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.latitude.get());
              localPhone.longitude.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).location.longitude.get());
            }
            localPhone.manufacturer.set(ByteStringMicro.copyFromUtf8(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).manufacturer.get()));
            localPhone.device_brand_and_model.set(ByteStringMicro.copyFromUtf8(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).device_brand_and_model.get()));
            localPhone.qadid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
            localPhone.is_googleplay_version.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).is_googleplay_version.get());
            if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.has())
            {
              if (QLog.isColorLevel()) {
                QLog.d("EcshopAdHandler", 2, "---taid_ticket---: " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
              }
              localPhone.taid_ticket.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
            }
            if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.has())
            {
              if (QLog.isColorLevel()) {
                QLog.d("EcshopAdHandler", 2, "---aid_ticket---: " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
              }
              localPhone.aid_ticket.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
            }
            if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.has())
            {
              if (QLog.isColorLevel()) {
                QLog.d("EcshopAdHandler", 2, "---md5_android_id---: " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
              }
              localPhone.md5_android_id.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
            }
            if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.has())
            {
              if (QLog.isColorLevel()) {
                QLog.d("EcshopAdHandler", 2, "---md5_mac---: " + ((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
              }
              localPhone.md5_mac.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
            }
          }
          localQQAdGet.net_info.set(localPhone);
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
            if (localObject1 != null) {
              localQQAdGet.last_adid.set((List)localObject1);
            }
            localObject1 = new ToServiceMsg("mobileqq.service", this.this$0.app.c(), this.jdField_a_of_type_JavaLangString);
            ((ToServiceMsg)localObject1).putWupBuffer(localQQAdGet.toByteArray());
            this.this$0.sendPbReq((ToServiceMsg)localObject1);
            this.this$0.jdField_a_of_type_Long = (System.currentTimeMillis() / 1000L);
            return;
          }
          localObject1 = new ArrayList(this.this$0.jdField_a_of_type_JavaUtilSet);
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.4
 * JD-Core Version:    0.7.0.1
 */