package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import lrn;
import lro;
import lrp;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.AccountInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoReq;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoRsp;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.HeadInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.ReqBody;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.RspBody;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoItem;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoOption;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ReadInJoyUserInfoModule
  extends ReadInJoyEngineModule
{
  private ReadInJoyUserInfoRepository jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap b = new ConcurrentHashMap();
  
  public ReadInJoyUserInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository = new ReadInJoyUserInfoRepository(paramExecutorService, this, paramEntityManager);
  }
  
  public static ReadInJoyUserInfo a(long paramLong, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    if (paramLong != 0L)
    {
      Object localObject = (QQAppInterface)ReadInJoyUtils.a();
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(162)).a().a();
        if (localObject != null) {
          return ((ReadInJoyUserInfoModule)localObject).a(String.valueOf(paramLong), paramRefreshUserInfoCallBack);
        }
      }
    }
    return null;
  }
  
  private ToServiceMsg a(ReadInJoyUserInfoModule.Request0xb81Params paramRequest0xb81Params)
  {
    if (paramRequest0xb81Params == null)
    {
      QLog.d("ReadInJoyUserInfoModule", 2, "make0x81bRequestUserInfosPkg failed, params is null.");
      return null;
    }
    oidb_cmd0xb81.ReqBody localReqBody = new oidb_cmd0xb81.ReqBody();
    localReqBody.uint32_client_type.set(ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params));
    oidb_cmd0xb81.GetUserInfoReq localGetUserInfoReq = new oidb_cmd0xb81.GetUserInfoReq();
    localGetUserInfoReq.uint32_info_priority.set(ReadInJoyUserInfoModule.Request0xb81Params.b(paramRequest0xb81Params));
    Object localObject = new oidb_cmd0xb81.UserInfoOption();
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_nick.set(ReadInJoyUserInfoModule.Request0xb81Params.c(paramRequest0xb81Params));
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_head_url.set(ReadInJoyUserInfoModule.Request0xb81Params.d(paramRequest0xb81Params));
    localGetUserInfoReq.msg_user_option.set((MessageMicro)localObject);
    localObject = new ArrayList();
    if ((ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params) != null) && (ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).size() > 0))
    {
      int i = 0;
      while (i < ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).size())
      {
        oidb_cmd0xb81.AccountInfo localAccountInfo = new oidb_cmd0xb81.AccountInfo();
        localAccountInfo.uint32_account_type.set(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$900((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).get(i)));
        localAccountInfo.uint64_uin.set(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$400((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).get(i)));
        ((List)localObject).add(localAccountInfo);
        i += 1;
      }
    }
    localGetUserInfoReq.msg_account_info.set((List)localObject);
    localReqBody.msg_get_user_info_req.set(localGetUserInfoReq);
    return a("OidbSvc.0xb81", 2945, 1, localReqBody.toByteArray());
  }
  
  private ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.str_client_version.set(AppSetting.c());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = ReadInJoyOidbHelper.a(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public static String a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo == null) {
      return "";
    }
    if ((paramReadInJoyUserInfo.faceFlag & 0x8) != 0) {
      return paramReadInJoyUserInfo.faceUrl + "140";
    }
    if ((paramReadInJoyUserInfo.faceFlag & 0x4) != 0) {
      return paramReadInJoyUserInfo.faceUrl + "100";
    }
    if ((paramReadInJoyUserInfo.faceFlag & 0x10) != 0) {
      return paramReadInJoyUserInfo.faceUrl + "0";
    }
    return paramReadInJoyUserInfo.faceUrl + "40";
  }
  
  private void a(ReadInJoyUserInfoModule.Request0xb81Params paramRequest0xb81Params)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()))
    {
      QLog.d("ReadInJoyUserInfoModule", 2, "request0xb81UserInfo error, mExecutorService is null or shutdown.");
      return;
    }
    QLog.d("ReadInJoyUserInfoModule", 2, "request0xb81UserInfo.");
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lro(this, paramRequest0xb81Params));
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    int i = 0;
    Object localObject = new oidb_cmd0xb81.RspBody();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.d("ReadInJoyUserInfoModule", 2, new Object[] { "handle0xb81UserInfo result = ", Integer.valueOf(k) });
    if (k == 0)
    {
      if ((((oidb_cmd0xb81.RspBody)localObject).msg_get_user_info_rsp.has()) && (((oidb_cmd0xb81.RspBody)localObject).msg_get_user_info_rsp.get() != null))
      {
        paramToServiceMsg = (oidb_cmd0xb81.GetUserInfoRsp)((oidb_cmd0xb81.RspBody)localObject).msg_get_user_info_rsp.get();
        if ((paramToServiceMsg.rpt_msg_user_info.has()) && (paramToServiceMsg.rpt_msg_user_info.get() != null) && (paramToServiceMsg.rpt_msg_user_info.get().size() > 0))
        {
          paramObject = paramToServiceMsg.rpt_msg_user_info.get();
          if (i < paramObject.size())
          {
            paramFromServiceMsg = "";
            localObject = new ReadInJoyUserInfo();
            oidb_cmd0xb81.UserInfoItem localUserInfoItem = (oidb_cmd0xb81.UserInfoItem)paramObject.get(i);
            paramToServiceMsg = paramFromServiceMsg;
            if (localUserInfoItem.msg_account_info.has())
            {
              paramToServiceMsg = paramFromServiceMsg;
              if (localUserInfoItem.msg_account_info.get() != null)
              {
                ((ReadInJoyUserInfo)localObject).accountType = ((oidb_cmd0xb81.AccountInfo)localUserInfoItem.msg_account_info.get()).uint32_account_type.get();
                ((ReadInJoyUserInfo)localObject).md5Uin = String.valueOf(((oidb_cmd0xb81.AccountInfo)localUserInfoItem.msg_account_info.get()).uint64_uin.get());
                paramToServiceMsg = String.valueOf(((oidb_cmd0xb81.AccountInfo)localUserInfoItem.msg_account_info.get()).uint64_uin.get());
              }
            }
            if (localUserInfoItem.bytes_nick.has())
            {
              paramFromServiceMsg = localUserInfoItem.bytes_nick.get().toStringUtf8();
              label283:
              ((ReadInJoyUserInfo)localObject).nick = paramFromServiceMsg;
              if ((localUserInfoItem.msg_head_info.has()) && (localUserInfoItem.msg_head_info.get() != null))
              {
                paramFromServiceMsg = (oidb_cmd0xb81.HeadInfo)localUserInfoItem.msg_head_info.get();
                ((ReadInJoyUserInfo)localObject).faceType = paramFromServiceMsg.uint32_face_type.get();
                ((ReadInJoyUserInfo)localObject).timestamp = paramFromServiceMsg.uint64_timestamp.get();
                ((ReadInJoyUserInfo)localObject).faceFlag = paramFromServiceMsg.uint32_face_flag.get();
                ((ReadInJoyUserInfo)localObject).systemID = paramFromServiceMsg.uint32_sysid.get();
                if (!paramFromServiceMsg.str_url.has()) {
                  break label441;
                }
              }
            }
            label441:
            for (paramFromServiceMsg = paramFromServiceMsg.str_url.get();; paramFromServiceMsg = "")
            {
              ((ReadInJoyUserInfo)localObject).faceUrl = paramFromServiceMsg;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository.a((ReadInJoyUserInfo)localObject);
              ((ReadInJoyUserInfo)localObject).requestFlag = true;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository.a(paramToServiceMsg, ((ReadInJoyUserInfo)localObject).md5Uin, (ReadInJoyUserInfo)localObject, true);
              i += 1;
              break;
              paramFromServiceMsg = "";
              break label283;
            }
          }
        }
      }
    }
    else
    {
      paramObject = (Integer)paramToServiceMsg.getAttributes().get("retry_request_count_key");
      QLog.d("ReadInJoyUserInfoModule", 2, new Object[] { "retry_count = ", paramObject });
      paramFromServiceMsg = (List)paramToServiceMsg.getAttributes().get("user_info_uin_list_key");
      if (paramFromServiceMsg != null)
      {
        QLog.d("ReadInJoyUserInfoModule", 2, new Object[] { "accountInfoReqList size = ", Integer.valueOf(paramFromServiceMsg.size()) });
        if (paramFromServiceMsg.size() > 0) {
          QLog.d("ReadInJoyUserInfoModule", 2, new Object[] { "retry accountInfoReqList [0] = ", paramFromServiceMsg.get(0) });
        }
      }
      if (paramObject.intValue() >= 1) {
        break label625;
      }
      paramToServiceMsg.addAttribute("retry_request_count_key", Integer.valueOf(paramObject.intValue() + 1));
      if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lrp(this, paramToServiceMsg));
      }
    }
    for (;;)
    {
      return;
      label625:
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        i = j;
        while (i < paramFromServiceMsg.size())
        {
          paramToServiceMsg = String.valueOf(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$400((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)paramFromServiceMsg.get(i)));
          if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramToServiceMsg) != null))
          {
            paramObject = ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramToServiceMsg)).iterator();
            while (paramObject.hasNext())
            {
              localObject = (WeakReference)paramObject.next();
              if (((WeakReference)localObject).get() != null) {
                ((ReadInJoyUserInfoModule.RefreshUserInfoCallBack)((WeakReference)localObject).get()).a(paramToServiceMsg, "request0xb81UserInfo result = " + k);
              }
            }
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramToServiceMsg);
          }
          this.b.remove(paramToServiceMsg);
          i += 1;
        }
      }
    }
  }
  
  public ReadInJoyUserInfoRepository a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository;
  }
  
  public ReadInJoyUserInfo a(String paramString, int paramInt1, int paramInt2, int paramInt3, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    ReadInJoyUserInfo localReadInJoyUserInfo;
    do
    {
      return localObject;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository == null) {
        break;
      }
      localReadInJoyUserInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository.a(paramString);
      localObject = localReadInJoyUserInfo;
    } while (localReadInJoyUserInfo != null);
    if ((paramRefreshUserInfoCallBack != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new ArrayList());
      }
      ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).add(new WeakReference(paramRefreshUserInfoCallBack));
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lrn(this, paramString, paramInt1, paramInt2, paramInt3));
    }
    return null;
  }
  
  public ReadInJoyUserInfo a(String paramString, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(paramString, 1, 1, 0, paramRefreshUserInfoCallBack);
  }
  
  public ConcurrentHashMap a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository.b();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb81")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(List paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        localArrayList.add(new ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.AccountInfoBuilder().a(Long.valueOf(str).longValue()).a());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyUserInfoModule", 2, "uin is not a long type.");
      }
    }
    if (localArrayList.size() <= 0)
    {
      QLog.d("ReadInJoyUserInfoModule", 2, "requestReadInJoyUserInfoWithParams failed, the uinList is empty.");
      return;
    }
    a(new ReadInJoyUserInfoModule.Request0xb81Params.Builder().a(paramInt1).b(paramInt2).c(paramInt3).a(localArrayList).a());
  }
  
  public ConcurrentHashMap b()
  {
    return this.b;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule
 * JD-Core Version:    0.7.0.1
 */