package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import lrs;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.CountDetailInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.FollowCountInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.LimitInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.ReqBody;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.RspBody;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.SimpleInfo;

public class SelfInfoModule
  extends ReadInJoyEngineModule
{
  public SelfInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "construct!");
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "handle0x97bGetFollowAndFansCount!");
    }
    paramToServiceMsg = new oidb_cmd0x97b.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int k = ((oidb_cmd0x97b.FollowCountInfo)paramToServiceMsg.msg_follow_count_info.get()).uint32_my_follow_count.get();
    int m = ((oidb_cmd0x97b.FollowCountInfo)paramToServiceMsg.msg_follow_count_info.get()).uint32_my_fans_count.get();
    paramFromServiceMsg = new ArrayList();
    Object localObject;
    if (((oidb_cmd0x97b.FollowCountInfo)paramToServiceMsg.msg_follow_count_info.get()).rpt_fans_detail_info.has())
    {
      paramObject = ((oidb_cmd0x97b.FollowCountInfo)paramToServiceMsg.msg_follow_count_info.get()).rpt_fans_detail_info.get().iterator();
      while (paramObject.hasNext())
      {
        localObject = (oidb_cmd0x97b.CountDetailInfo)paramObject.next();
        if (((oidb_cmd0x97b.CountDetailInfo)localObject).enum_type.get() == 1)
        {
          SelfInfoModule.BusinessCountInfo localBusinessCountInfo = new SelfInfoModule.BusinessCountInfo();
          localBusinessCountInfo.jdField_a_of_type_Int = ((oidb_cmd0x97b.CountDetailInfo)localObject).uint32_id.get();
          localBusinessCountInfo.jdField_b_of_type_Int = 1;
          localBusinessCountInfo.jdField_a_of_type_JavaLangString = ((oidb_cmd0x97b.CountDetailInfo)localObject).bytes_name.get().toStringUtf8();
          localBusinessCountInfo.jdField_c_of_type_JavaLangString = ((oidb_cmd0x97b.CountDetailInfo)localObject).bytes_icon_url.get().toStringUtf8();
          localBusinessCountInfo.jdField_b_of_type_JavaLangString = ((oidb_cmd0x97b.CountDetailInfo)localObject).bytes_url.get().toStringUtf8();
          localBusinessCountInfo.jdField_c_of_type_Int = ((oidb_cmd0x97b.CountDetailInfo)localObject).uint32_count.get();
          ((oidb_cmd0x97b.FollowCountInfo)paramToServiceMsg.msg_follow_count_info.get()).toByteArray();
          paramFromServiceMsg.add(localBusinessCountInfo);
        }
      }
    }
    if ((paramToServiceMsg.msg_limit_info.has()) && (((oidb_cmd0x97b.LimitInfo)paramToServiceMsg.msg_limit_info.get()).uint32_forbidden_flag.has())) {}
    for (int i = ((oidb_cmd0x97b.LimitInfo)paramToServiceMsg.msg_limit_info.get()).uint32_forbidden_flag.get();; i = 0)
    {
      if (i == 1) {
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelfInfoModule", 1, "handle0x97bGetFollowAndFansCount result=" + j + ", followCnt=" + k + ", fansCnt=" + m + ", isForbidden=" + bool);
      }
      paramObject = ((oidb_cmd0x97b.SimpleInfo)paramToServiceMsg.msg_simpleinfo.get()).bytes_header_url.get().toStringUtf8();
      localObject = ((oidb_cmd0x97b.SimpleInfo)paramToServiceMsg.msg_simpleinfo.get()).bytes_nick.get().toStringUtf8();
      if (((oidb_cmd0x97b.SimpleInfo)paramToServiceMsg.msg_simpleinfo.get()).uint32_is_vip.has()) {}
      for (i = ((oidb_cmd0x97b.SimpleInfo)paramToServiceMsg.msg_simpleinfo.get()).uint32_is_vip.get();; i = -1)
      {
        ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, k, m, paramFromServiceMsg);
        ReadInJoyHelper.j(this.jdField_a_of_type_ComTencentCommonAppAppInterface, bool);
        ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramObject, (String)localObject, i);
        this.jdField_a_of_type_AndroidOsHandler.post(new lrs(this, j, k, m, bool));
        return;
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "onReceive response cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x97b")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "getSelfFollowAndFansCount uin=" + paramString);
    }
    oidb_cmd0x97b.ReqBody localReqBody = new oidb_cmd0x97b.ReqBody();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception paramString)
    {
      label51:
      break label51;
    }
    localReqBody.uint64_uin.set(l1);
    localReqBody.uint32_req_ctrl_bits.set(3);
    a(ReadInJoyOidbHelper.a("OidbSvc.0x97b", 2427, 1, localReqBody.toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SelfInfoModule
 * JD-Core Version:    0.7.0.1
 */