import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.LoginSig;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.ReqBody;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.AnonymousGroupMsg;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ExtParam;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.GPSInfo;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.LoginSig;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ReqBody;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.SendFlowerReq;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ThrowFlowerReq;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.TmpMsgToken;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.LoginSig;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.ReqBody;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ExtParam;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetExtraDataReq;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetStockReq;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.LoginSig;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ReqBody;
import tencent.im.oidb.cmd0x962.oidb_0x962.ClientInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962.ReqBody;
import tencent.im.oidb.cmd0x9e9.cmd0x9e9.ReqBody;
import tencent.im.oidb.cmd0x9e9.cmd0x9e9.User;
import tencent.im.oidb.cmd0xa48.oidb_0xa48.ReqBody;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.GetPackageShopReq;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.ReqBody;
import tencent.im.oidb.cmd0xdad.cmd0xdad.LoginSig;
import tencent.im.oidb.cmd0xdad.cmd0xdad.ReqBody;

public class bfst
  extends Observable
  implements Manager
{
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ConcurrentHashMap<String, TroopGiftBagInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bfst(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
    }
  }
  
  private int a(String paramString, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 7: 
    case 9: 
    case 10: 
    default: 
      return paramInt2;
    case 6: 
      return 504;
    case 4: 
      paramString = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(true).a(paramString);
      if (paramString != null)
      {
        if (paramString.isBuLuoHotChat()) {
          return 507;
        }
        return 503;
      }
      return -1;
    case 5: 
      return 2;
    case 8: 
      return 508;
    case 11: 
      return 1100;
    case 13: 
      return 1200;
    }
    return 1300;
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, oidb_0x6b6.SendFlowerReq paramSendFlowerReq, oidb_0x6b6.ThrowFlowerReq paramThrowFlowerReq, long paramLong, bfss parambfss)
  {
    if (parambfss == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6b6. callback=" + parambfss);
      }
      label37:
      return;
    }
    oidb_0x6b6.ReqBody localReqBody = new oidb_0x6b6.ReqBody();
    if (paramString2 != null) {}
    label1040:
    for (;;)
    {
      try
      {
        long l = Long.valueOf(paramString2).longValue();
        localReqBody.uint64_group.set(l, true);
        if (paramInt2 == 10)
        {
          localReqBody.uint32_group_type.set(2, true);
          if (paramInt5 > 0)
          {
            localReqBody.uint32_c2c_type.set(paramInt5, true);
            localReqBody.msg_tmp_msg_token.set(new oidb_0x6b6.TmpMsgToken(), true);
            localReqBody.msg_tmp_msg_token.c2c_type.set(1, true);
          }
        }
        switch (paramInt5)
        {
        default: 
          PBUInt32Field localPBUInt32Field = localReqBody.uint32_portal;
          if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
            break label985;
          }
          localPBUInt32Field.set(a(paramString2, paramInt3, paramInt4), true);
          if (paramSendFlowerReq == null) {
            break label992;
          }
          localReqBody.msg_send_flower = paramSendFlowerReq;
          if (njo.a().a(paramString2))
          {
            paramThrowFlowerReq = new oidb_0x6b6.AnonymousGroupMsg();
            paramString2 = njo.a().a(paramString2);
            paramThrowFlowerReq.uint32_flags.set(2);
            if (!TextUtils.isEmpty(paramString2.jdField_b_of_type_JavaLangString)) {
              paramThrowFlowerReq.str_anon_id.set(ByteStringMicro.copyFrom(paramString2.jdField_b_of_type_JavaLangString.getBytes()));
            }
            if (!TextUtils.isEmpty(paramString2.jdField_a_of_type_JavaLangString)) {
              paramThrowFlowerReq.str_anon_nick.set(ByteStringMicro.copyFrom(paramString2.jdField_a_of_type_JavaLangString.getBytes()));
            }
            paramThrowFlowerReq.uint32_head_portrait.set(paramString2.jdField_a_of_type_Int);
            paramThrowFlowerReq.uint32_expire_time.set(paramString2.jdField_b_of_type_Int);
            paramThrowFlowerReq.uint32_bubble_id.set((int)paramString2.jdField_a_of_type_Long);
            if (!TextUtils.isEmpty(paramString2.c)) {
              paramThrowFlowerReq.str_rank_color.set(ByteStringMicro.copyFrom(paramString2.c.getBytes()));
            }
            localReqBody.msg_anony.set(paramThrowFlowerReq);
          }
          paramThrowFlowerReq = acei.b();
          paramString2 = paramThrowFlowerReq;
          if (TextUtils.isEmpty(paramThrowFlowerReq)) {
            paramString2 = "0.0.0.0";
          }
          paramThrowFlowerReq = "" + AppSetting.a();
          paramInt4 = AppSetting.a();
          localReqBody.bytes_user_ip.set(ByteStringMicro.copyFrom(paramString2.getBytes()), true);
          localReqBody.bytes_version.set(ByteStringMicro.copyFrom(paramThrowFlowerReq.getBytes()), true);
          localReqBody.uint32_client.set(1, true);
          localReqBody.uint32_instance_id.set(paramInt4, true);
          localReqBody.setHasFlag(true);
          if (paramInt3 != 6) {
            break label1040;
          }
          localReqBody.msg_tmp_msg_token.set(new oidb_0x6b6.TmpMsgToken(), true);
          localReqBody.msg_tmp_msg_token.service_type.set(124, true);
          localReqBody.msg_tmp_msg_token.c2c_type.set(1, true);
          if (paramSendFlowerReq != null)
          {
            paramString2 = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().n(String.valueOf(paramSendFlowerReq.uint64_to_uin.get()));
            if (paramString2 != null) {
              localReqBody.msg_tmp_msg_token.buf.set(ByteStringMicro.copyFrom(paramString2), true);
            }
          }
          if ((paramInt3 >= 4) && (System.currentTimeMillis() - axhf.jdField_a_of_type_Long < 600000L))
          {
            paramString2 = new oidb_0x6b6.GPSInfo();
            paramString2.int32_gps_type.set(1, true);
            paramString2.int64_longitude.set(axhf.jdField_a_of_type_ArrayOfLong[0], true);
            paramString2.int64_latitude.set(axhf.jdField_a_of_type_ArrayOfLong[1], true);
            localReqBody.msg_gps_info.set(paramString2, true);
          }
          paramSendFlowerReq = new oidb_0x6b6.ExtParam();
          paramString2 = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
          if (paramString2 == null) {
            break label1147;
          }
          paramString2 = paramString2.getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
          paramThrowFlowerReq = new oidb_0x6b6.LoginSig();
          paramThrowFlowerReq.uint32_type.set(1);
          paramThrowFlowerReq.uint32_appid.set(0);
          if (!TextUtils.isEmpty(paramString2)) {
            paramThrowFlowerReq.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramString2));
          }
          paramSendFlowerReq.msg_login_sig.set(paramThrowFlowerReq);
          paramSendFlowerReq.uint32_business_id.set(paramInt3);
          localReqBody.msg_ext_param.set(paramSendFlowerReq);
          paramString2 = new Bundle();
          paramString2.putInt("subCmd", paramInt2);
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. serviceType=" + paramInt2);
          }
          nir.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new bfsu(this, parambfss), localReqBody.toByteArray(), paramString1 + "_" + paramInt2, paramInt1, paramInt2, paramString2, paramLong);
          return;
          if (paramInt2 != 11) {
            continue;
          }
          localReqBody.uint32_group_type.set(2, true);
          continue;
          if (!QLog.isColorLevel()) {
            break label37;
          }
        }
      }
      catch (NumberFormatException paramString1) {}
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6b6. NumberFormatException troopUin=" + paramString2);
      return;
      localReqBody.msg_tmp_msg_token.service_type.set(0, true);
      continue;
      localReqBody.msg_tmp_msg_token.service_type.set(1, true);
      continue;
      label985:
      paramInt4 = 10;
      continue;
      label992:
      if (paramThrowFlowerReq != null)
      {
        localReqBody.msg_throw_flower = paramThrowFlowerReq;
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6b6. serviceType=" + paramInt2);
        return;
        if (paramInt3 == 8)
        {
          localReqBody.msg_tmp_msg_token.set(new oidb_0x6b6.TmpMsgToken(), true);
          localReqBody.msg_tmp_msg_token.service_type.set(149, true);
          localReqBody.msg_tmp_msg_token.c2c_type.set(1, true);
          if (paramSendFlowerReq != null)
          {
            paramString2 = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().k(String.valueOf(paramSendFlowerReq.uint64_to_uin.get()));
            if (paramString2 != null)
            {
              localReqBody.msg_tmp_msg_token.buf.set(ByteStringMicro.copyFrom(paramString2), true);
              continue;
              label1147:
              paramString2 = "";
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, oidb_0x6c3.GetStockReq paramGetStockReq, oidb_0x6c3.GetExtraDataReq paramGetExtraDataReq, long paramLong, bfss parambfss)
  {
    if (parambfss == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6c3. troopUin is null. callback=" + parambfss);
      }
      return;
    }
    oidb_0x6c3.ReqBody localReqBody = new oidb_0x6c3.ReqBody();
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        long l = Long.valueOf(paramString2).longValue();
        localReqBody.uint64_group.set(l, true);
        localReqBody.uint32_portal.set(a(paramString2, paramInt2, paramInt3), true);
        if (paramGetStockReq == null) {
          break label192;
        }
        localReqBody.msg_get_stock = paramGetStockReq;
        if (paramInt4 != -1) {
          break label207;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6c3. serviceType=" + paramInt4);
        return;
      }
      catch (NumberFormatException paramString1) {}
      localReqBody.uint64_group.set(0L, true);
      continue;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6c3. NumberFormatException troopUin=" + paramString2);
      return;
      label192:
      if (paramGetExtraDataReq != null) {
        localReqBody.msg_extra_data = paramGetExtraDataReq;
      }
    }
    label207:
    paramGetExtraDataReq = acei.b();
    paramGetStockReq = paramGetExtraDataReq;
    if (TextUtils.isEmpty(paramGetExtraDataReq)) {
      paramGetStockReq = "0.0.0.0";
    }
    paramGetExtraDataReq = "" + AppSetting.a();
    paramInt3 = AppSetting.a();
    localReqBody.bytes_user_ip.set(ByteStringMicro.copyFrom(paramGetStockReq.getBytes()), true);
    localReqBody.bytes_version.set(ByteStringMicro.copyFrom(paramGetExtraDataReq.getBytes()), true);
    localReqBody.uint32_client.set(1, true);
    localReqBody.uint32_instance_id.set(paramInt3, true);
    localReqBody.uint32_business_id.set(paramInt2, true);
    localReqBody.setHasFlag(true);
    paramGetExtraDataReq = new oidb_0x6c3.ExtParam();
    paramGetStockReq = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    if (paramGetStockReq != null) {}
    for (paramGetStockReq = paramGetStockReq.getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());; paramGetStockReq = "")
    {
      oidb_0x6c3.LoginSig localLoginSig = new oidb_0x6c3.LoginSig();
      localLoginSig.uint32_type.set(1);
      localLoginSig.uint32_appid.set(0);
      if (!TextUtils.isEmpty(paramGetStockReq)) {
        localLoginSig.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramGetStockReq));
      }
      paramGetExtraDataReq.msg_login_sig.set(localLoginSig);
      localReqBody.msg_ext_param.set(paramGetExtraDataReq);
      paramGetStockReq = new Bundle();
      paramGetStockReq.putInt("subCmd", paramInt4);
      paramGetStockReq.putString("troopUin", paramString2);
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6c3. serviceType=" + paramInt4);
      }
      nir.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new bfsw(this, parambfss), localReqBody.toByteArray(), paramString1 + "_" + paramInt4, paramInt1, paramInt4, paramGetStockReq, paramLong);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong, bfss parambfss)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (parambfss == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6c2. troopUin=" + paramString1 + " giftBagID=" + paramString2 + " callback=" + parambfss);
      }
      return;
    }
    oidb_0x6c2.ReqBody localReqBody = new oidb_0x6c2.ReqBody();
    for (;;)
    {
      try
      {
        long l = Long.valueOf(paramString1).longValue();
        localReqBody.uint64_group_id.set(l, true);
        localReqBody.bytes_gift_bagid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
        localReqBody.uint32_channel.set(1, true);
        localReqBody.setHasFlag(true);
        localObject = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
        if (localObject == null) {
          break label385;
        }
        localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        oidb_0x6c2.LoginSig localLoginSig = new oidb_0x6c2.LoginSig();
        localLoginSig.uint32_type.set(1);
        localLoginSig.uint32_appid.set(0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localLoginSig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject));
        }
        localReqBody.msg_login_sig.set(localLoginSig);
        switch (paramInt3)
        {
        default: 
          localObject = new Bundle();
          ((Bundle)localObject).putInt("subCmd", paramInt3);
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "send_oidb_0x6c2. serviceType=" + paramInt3);
          }
          nir.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new bfsy(this, parambfss, paramString1, paramString2), localReqBody.toByteArray(), "OidbSvc.0x6c2_" + paramInt3, 1730, paramInt3, (Bundle)localObject, paramLong);
          return;
        }
      }
      catch (NumberFormatException paramString2) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6c2. NumberFormatException troopUin=" + paramString1);
      return;
      label385:
      Object localObject = "";
      continue;
      localReqBody.int32_page_index.set(paramInt1, true);
      localReqBody.int32_page_size.set(paramInt2, true);
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, bfss parambfss)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "send_oidb_0x962. interactId: " + paramString2 + ", cmd: " + paramInt3);
    }
    try
    {
      long l = Long.parseLong(paramString1);
      oidb_0x962.ClientInfo localClientInfo = new oidb_0x962.ClientInfo();
      localClientInfo.uint32_client_type.set(1, true);
      localClientInfo.bytes_version.set(ByteStringMicro.copyFrom(AppSetting.a().getBytes()), true);
      paramString1 = new oidb_0x962.ReqBody();
      paramString1.uint64_group_code.set(l, true);
      paramString1.bytes_id.set(ByteStringMicro.copyFrom(paramString2.getBytes()), true);
      paramString1.uint32_times.set(paramInt1, true);
      paramString1.msg_client_info.set(localClientInfo, true);
      paramString1.uint32_product_id.set(paramInt2, true);
      paramString1.uint32_cmd.set(paramInt3, true);
      paramString2 = new Bundle();
      paramString2.putInt("subCmd", paramInt3);
      nir.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new bfsz(this, parambfss), paramString1.toByteArray(), "OidbSvc.0x962_" + paramInt3, 2402, 1, paramString2, 500L);
      return;
    }
    catch (Exception paramString2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(".troop.send_gift", 2, "send_oidb_0x962. troopUin is wrong" + paramString1);
    }
  }
  
  private void b(bfss parambfss)
  {
    Oidb_0xcd1.ReqBody localReqBody = new Oidb_0xcd1.ReqBody();
    Oidb_0xcd1.GetPackageShopReq localGetPackageShopReq = new Oidb_0xcd1.GetPackageShopReq();
    localGetPackageShopReq.portal_number.set(2);
    localReqBody.get_pack_req.set(localGetPackageShopReq);
    nir.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new bfsv(this, parambfss), localReqBody.toByteArray(), "OidbSvc.0xcd1_0", 3281, 0, null, 0L);
  }
  
  private void b(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, bfss parambfss)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (parambfss == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6b5. troopUin=" + paramString2 + " giftBagID=" + paramString3 + " callback=" + parambfss);
      }
      return;
    }
    oidb_0x6b5.ReqBody localReqBody = new oidb_0x6b5.ReqBody();
    for (;;)
    {
      try
      {
        long l = Long.valueOf(paramString2).longValue();
        localReqBody.uint64_group_id.set(l, true);
        localObject = localReqBody.uint32_portal;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label408;
        }
        i = 7;
        ((PBUInt32Field)localObject).set(a(paramString2, paramInt2, i));
        localReqBody.uint32_business_id.set(paramInt2, true);
        localReqBody.bytes_gift_bagid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
        localReqBody.uint32_channel.set(1, true);
        localReqBody.setHasFlag(true);
        localObject = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
        if (localObject == null) {
          break label415;
        }
        localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        oidb_0x6b5.LoginSig localLoginSig = new oidb_0x6b5.LoginSig();
        localLoginSig.uint32_type.set(1);
        localLoginSig.uint32_appid.set(0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localLoginSig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject));
        }
        localReqBody.msg_login_sig.set(localLoginSig);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("subCmd", 0);
        if (QLog.isColorLevel()) {
          QLog.i(".troop.send_gift", 2, "send_oidb_0x6b5. serviceType=0");
        }
        if (paramInt2 < 4) {
          break label422;
        }
        paramInt2 = 1;
        nir.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new bfsx(this, parambfss, paramString2, paramString3), localReqBody.toByteArray(), paramString1 + "_" + paramInt2, paramInt1, paramInt2, (Bundle)localObject, paramLong);
        return;
      }
      catch (NumberFormatException paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6b5. NumberFormatException troopUin=" + paramString2);
      return;
      label408:
      int i = 10;
      continue;
      label415:
      Object localObject = "";
      continue;
      label422:
      paramInt2 = 0;
    }
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_troop_gift_" + paramInt, 0).getInt("gift_list_version", 0);
  }
  
  public TroopGiftBagInfo a(String paramString1, String paramString2, bfss parambfss)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift .troop.send_gift", 2, "getGrabBagInfo. troopUin:" + paramString1 + " bagID:" + paramString2);
      }
      return null;
    }
    String str = paramString1 + "_" + paramString2;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null) {
      return (TroopGiftBagInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
    TroopGiftBagInfo localTroopGiftBagInfo = (TroopGiftBagInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(TroopGiftBagInfo.class, paramString2);
    if (localTroopGiftBagInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localTroopGiftBagInfo);
      return localTroopGiftBagInfo;
    }
    a(paramString1, paramString2, 0, 0, 1000L, parambfss);
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_troop_gift_" + paramInt2, 0).edit().putInt("gift_list_version", paramInt1).commit();
  }
  
  public void a(int paramInt, bfss parambfss)
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return;
    }
    cmd0x9e9.ReqBody localReqBody = new cmd0x9e9.ReqBody();
    cmd0x9e9.User localUser = new cmd0x9e9.User();
    String str = "" + AppSetting.a();
    localUser.bytes_version.set(ByteStringMicro.copyFrom(str.getBytes()), true);
    localUser.uint32_client.set(1, true);
    localUser.uint32_portal.set(paramInt, true);
    localReqBody.msg_user.set(localUser, true);
    nir.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, new bftb(this, parambfss), localReqBody.toByteArray(), "OidbSvc.0x9e9_0", 2537, 0);
  }
  
  public void a(aasi paramaasi, int paramInt, String paramString, long paramLong, bfss parambfss)
  {
    if ((paramaasi == null) || (parambfss == null)) {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "sendAdFreeGift arg err");
      }
    }
    do
    {
      return;
      cmd0xdad.ReqBody localReqBody = new cmd0xdad.ReqBody();
      localReqBody.client.set(1L, true);
      localReqBody.product_id.set(paramaasi.jdField_a_of_type_Int, true);
      localReqBody.amount.set(paramaasi.f, true);
      localReqBody.to_uin.set(paramLong, true);
      if (paramString != null) {}
      try
      {
        paramLong = Long.valueOf(paramString).longValue();
        localReqBody.gc.set(paramLong, true);
        paramString = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
        Object localObject = new cmd0xdad.LoginSig();
        ((cmd0xdad.LoginSig)localObject).bytes_sig.set(ByteStringMicro.copyFrom(paramString.getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).getBytes()), true);
        ((cmd0xdad.LoginSig)localObject).uint32_type.set(1, true);
        ((cmd0xdad.LoginSig)localObject).uint32_appid.set(0, true);
        localReqBody.sig.set((MessageMicro)localObject, true);
        localObject = acei.b();
        paramString = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramString = "0.0.0.0";
        }
        localObject = "" + AppSetting.a();
        localReqBody.ip.set(new String(paramString.getBytes()), true);
        localReqBody.vsersion.set(new String(((String)localObject).getBytes()), true);
        localReqBody.setHasFlag(true);
        paramString = new Bundle();
        paramString.putInt("subCmd", paramInt);
        if (QLog.isColorLevel()) {
          QLog.i(".troop.send_gift", 2, "send_oidb_0xdad. serviceType=" + paramInt);
        }
        nir.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new bfta(this, parambfss, paramaasi), localReqBody.toByteArray(), "OidbSvc.0xdad_" + paramInt, 3501, paramInt, paramString, 0L);
        return;
      }
      catch (NumberFormatException paramaasi) {}
    } while (!QLog.isColorLevel());
    QLog.e(".troop.send_gift", 2, "send_oidb_0x6b6. NumberFormatException troopUin=" + paramString);
  }
  
  public void a(bfss parambfss)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchPackageGiftInfo");
    }
    b(parambfss);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, int paramInt6, int paramInt7, bfss parambfss)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "throwGift. troopUin:" + paramString2 + " entranceID:" + paramInt4 + " count:" + paramInt5 + " playRule:" + paramInt6 + " productID:" + paramInt7);
    }
    oidb_0x6b6.ThrowFlowerReq localThrowFlowerReq = new oidb_0x6b6.ThrowFlowerReq();
    localThrowFlowerReq.int32_count.set(paramInt5, true);
    localThrowFlowerReq.uint32_play_rule.set(paramInt6, true);
    localThrowFlowerReq.uint32_product_id.set(paramInt7, true);
    localThrowFlowerReq.setHasFlag(true);
    a(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramInt4, 0, null, localThrowFlowerReq, 0L, parambfss);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8, int paramInt9, bfss parambfss, int paramInt10)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "sendGift. troopUin:" + paramString2 + " entranceID:" + paramInt4 + " count:" + paramInt5 + " toUin:" + paramLong + " playRule:" + paramInt6 + " customFlag:" + paramInt7);
    }
    oidb_0x6b6.SendFlowerReq localSendFlowerReq = new oidb_0x6b6.SendFlowerReq();
    localSendFlowerReq.int32_count.set(paramInt5, true);
    localSendFlowerReq.uint64_to_uin.set(paramLong, true);
    localSendFlowerReq.uint32_play_rule.set(paramInt6, true);
    localSendFlowerReq.uint32_custom_flag.set(paramInt7, true);
    localSendFlowerReq.uint32_product_id.set(paramInt8);
    if (paramInt7 == 1) {
      localSendFlowerReq.uint32_gift_id.set(paramInt10);
    }
    localSendFlowerReq.setHasFlag(true);
    a(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramInt4, paramInt9, localSendFlowerReq, null, 0L, parambfss);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, bfss parambfss)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchExtraInfo. troopUin:" + paramString2 + " entranceID:" + paramInt3);
    }
    oidb_0x6c3.GetExtraDataReq localGetExtraDataReq = new oidb_0x6c3.GetExtraDataReq();
    localGetExtraDataReq.setHasFlag(true);
    localGetExtraDataReq.int32_config_id.set(paramInt5, true);
    a(paramString1, paramInt1, paramInt2, paramString2, paramInt3, paramInt4, null, localGetExtraDataReq, 0L, parambfss);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, bfss parambfss)
  {
    a(paramString1, paramInt1, paramInt2, paramString2, paramInt3, paramInt4, false, false, parambfss);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, bfss parambfss)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchGiftStock. troopUin:" + paramString2 + " entranceID:" + paramInt3);
    }
    oidb_0x6c3.GetStockReq localGetStockReq = new oidb_0x6c3.GetStockReq();
    localGetStockReq.setHasFlag(true);
    localGetStockReq.bool_not_need_gift_stock.set(paramBoolean1, true);
    PBUInt32Field localPBUInt32Field = localGetStockReq.uint32_imgshow_config;
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i, true);
      a(paramString1, paramInt1, paramInt2, paramString2, paramInt3, paramInt4, localGetStockReq, null, 0L, parambfss);
      return;
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, long paramLong, bfss parambfss)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "grabGift. troopUin:" + paramString2 + " bagID:" + paramString3);
    }
    b(paramString1, paramInt1, paramInt2, paramString2, paramString3, paramLong, parambfss);
  }
  
  public void a(String paramString, bfss parambfss)
  {
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new oidb_0xa48.ReqBody();
      paramString.uint64_groupcode.set(l, true);
      nir.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, new bftc(this, parambfss), paramString.toByteArray(), "OidbSvc.0xa48_1", 2632, 1, new Bundle(), 6000L);
      return;
    }
    catch (Exception paramString)
    {
      parambfss.a(-1, "troop uin error");
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, bfss parambfss)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchGrabBagInfo. troopUin:" + paramString1 + " bagID:" + paramString2 + " pageIndex" + paramInt1 + " pageSize:" + paramInt2);
    }
    a(paramString1, paramString2, paramInt1, paramInt2, 0, paramLong, parambfss);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, bfss parambfss)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift .troop.send_gift", 2, "reportInteract. troopUin:" + paramString1 + " giftID:" + paramString2);
    }
    a(paramString1, paramString2, paramInt2, paramInt1, 3, parambfss);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, bfss parambfss)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift .troop.send_gift", 2, "chechInteract. troopUin:" + paramString1 + " giftID:" + paramString2);
    }
    a(paramString1, paramString2, 0, paramInt, 1, parambfss);
  }
  
  public void a(boolean paramBoolean)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_troop_gift_panel_red_dot";
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      localBaseApplication.getSharedPreferences(str, i).edit().putBoolean("troop_gift_panel_red_dot", paramBoolean).commit();
      return;
    }
  }
  
  public boolean a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_troop_gift_panel_red_dot";
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences(str, i).getBoolean("troop_gift_panel_red_dot", false);
    }
  }
  
  public boolean a(Entity paramEntity)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (paramEntity == null)) {}
    do
    {
      do
      {
        return false;
        if (paramEntity.getStatus() != 1000) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      } while (paramEntity.getStatus() != 1001);
      return true;
    } while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002));
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
  }
  
  public void b(String paramString1, String paramString2, int paramInt, bfss parambfss)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift .troop.send_gift", 2, "startInteract. troopUin:" + paramString1 + " giftID:" + paramString2);
    }
    a(paramString1, paramString2, 0, paramInt, 2, parambfss);
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (QLog.isColorLevel())) {
      QLog.d(".troop.send_gift", 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface));
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfst
 * JD-Core Version:    0.7.0.1
 */