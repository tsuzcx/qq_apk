package com.tencent.biz.pubaccount.readinjoy.model;

import alto;
import alud;
import android.os.Handler;
import android.text.TextUtils;
import awgf;
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
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import mqq.app.AppRuntime;
import ors;
import owy;
import oxd;
import pgp;
import pgr;
import pgs;
import pgt;
import pgu;
import puz;
import pvb;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.AccountInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.AccountLevelInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoReq;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoRsp;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.HeadInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.ReqBody;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.RspBody;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoItem;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoOption;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ReadInJoyUserInfoModule
  extends pgp
{
  private static Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap<String, List<pgr>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private pgu jdField_a_of_type_Pgu;
  private ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap();
  
  public ReadInJoyUserInfoModule(AppInterface paramAppInterface, awgf paramawgf, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler)
  {
    super(paramAppInterface, paramawgf, paramExecutorService, parampuz, paramHandler);
    this.jdField_a_of_type_Pgu = new pgu(paramExecutorService, this, paramawgf);
  }
  
  public static ReadInJoyUserInfo a(long paramLong, pgr parampgr)
  {
    if (paramLong != 0L)
    {
      Object localObject = (QQAppInterface)ors.a();
      if (localObject != null)
      {
        localObject = ((oxd)((QQAppInterface)localObject).getManager(163)).a().a();
        if (localObject != null) {
          return ((ReadInJoyUserInfoModule)localObject).a(String.valueOf(paramLong), parampgr);
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
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_account_cc_level.set(2);
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
        localAccountInfo.uint64_friend_status.set(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$1000((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).get(i)));
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
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = pvb.a(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public static String a()
  {
    return alud.a(2131713468);
  }
  
  public static String a(long paramLong)
  {
    String str = a();
    if (paramLong <= 0L) {
      return str;
    }
    if ((jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty((CharSequence)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))))) {
      str = (String)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    for (;;)
    {
      return str;
    }
  }
  
  public static String a(long paramLong, pgr parampgr, String paramString)
  {
    parampgr = a(paramLong, parampgr);
    if (parampgr == null) {
      return paramString;
    }
    return parampgr.nick;
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
  
  public static void a(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      return;
    }
    if (jdField_a_of_type_JavaUtilMap == null) {
      jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramString);
  }
  
  private void a(ReadInJoyUserInfoModule.Request0xb81Params paramRequest0xb81Params)
  {
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "request0xb81UserInfo, params = \n", paramRequest0xb81Params });
    ToServiceMsg localToServiceMsg = a(paramRequest0xb81Params);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.addAttribute("user_info_uin_list_key", ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params));
      localToServiceMsg.addAttribute("retry_request_count_key", Integer.valueOf(0));
      localToServiceMsg.addAttribute("request_begin_time", Long.valueOf(System.currentTimeMillis()));
      a(localToServiceMsg);
    }
  }
  
  public static void a(String paramString)
  {
    QLog.i("ReadInJoyUserInfoModule", 1, "[clearCallbackList], uin = " + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (QQAppInterface)ors.a();
      if (localObject != null)
      {
        localObject = (oxd)((QQAppInterface)localObject).getManager(163);
        if (localObject != null)
        {
          localObject = ((oxd)localObject).a().a();
          if ((localObject != null) && (((ReadInJoyUserInfoModule)localObject).a() != null))
          {
            ((ReadInJoyUserInfoModule)localObject).a().remove(paramString);
            QLog.i("ReadInJoyUserInfoModule", 1, "[clearCallbackList] finished.");
          }
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xb81.RspBody();
    int j = pvb.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("request_begin_time")).longValue();
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "handle0xb81UserInfo result = ", Integer.valueOf(j), ", cost = ", Long.valueOf(l) });
    paramFromServiceMsg = ors.a();
    boolean bool;
    int i;
    label182:
    Object localObject2;
    if (j == 0)
    {
      bool = true;
      ors.b(paramFromServiceMsg, bool, l, j);
      if (j != 0) {
        break label704;
      }
      if ((!((oidb_cmd0xb81.RspBody)localObject1).msg_get_user_info_rsp.has()) || (((oidb_cmd0xb81.RspBody)localObject1).msg_get_user_info_rsp.get() == null)) {
        break label883;
      }
      paramToServiceMsg = (oidb_cmd0xb81.GetUserInfoRsp)((oidb_cmd0xb81.RspBody)localObject1).msg_get_user_info_rsp.get();
      if ((!paramToServiceMsg.rpt_msg_user_info.has()) || (paramToServiceMsg.rpt_msg_user_info.get() == null) || (paramToServiceMsg.rpt_msg_user_info.get().size() <= 0)) {
        break label883;
      }
      paramObject = paramToServiceMsg.rpt_msg_user_info.get();
      i = 0;
      if (i >= paramObject.size()) {
        break label883;
      }
      localObject1 = new ReadInJoyUserInfo();
      localObject2 = (oidb_cmd0xb81.UserInfoItem)paramObject.get(i);
      if ((!((oidb_cmd0xb81.UserInfoItem)localObject2).msg_account_info.has()) || (((oidb_cmd0xb81.UserInfoItem)localObject2).msg_account_info.get() == null)) {
        break label1111;
      }
      ((ReadInJoyUserInfo)localObject1).accountType = ((oidb_cmd0xb81.AccountInfo)((oidb_cmd0xb81.UserInfoItem)localObject2).msg_account_info.get()).uint32_account_type.get();
      ((ReadInJoyUserInfo)localObject1).uin = String.valueOf(((oidb_cmd0xb81.AccountInfo)((oidb_cmd0xb81.UserInfoItem)localObject2).msg_account_info.get()).uint64_uin.get());
    }
    label328:
    label1099:
    label1111:
    for (paramToServiceMsg = String.valueOf(((oidb_cmd0xb81.AccountInfo)((oidb_cmd0xb81.UserInfoItem)localObject2).msg_account_info.get()).uint64_uin.get());; paramToServiceMsg = "")
    {
      if (((oidb_cmd0xb81.UserInfoItem)localObject2).bytes_nick.has())
      {
        paramFromServiceMsg = ((oidb_cmd0xb81.UserInfoItem)localObject2).bytes_nick.get().toStringUtf8();
        ((ReadInJoyUserInfo)localObject1).nick = paramFromServiceMsg;
        if ((((oidb_cmd0xb81.UserInfoItem)localObject2).msg_head_info.has()) && (((oidb_cmd0xb81.UserInfoItem)localObject2).msg_head_info.get() != null))
        {
          paramFromServiceMsg = (oidb_cmd0xb81.HeadInfo)((oidb_cmd0xb81.UserInfoItem)localObject2).msg_head_info.get();
          ((ReadInJoyUserInfo)localObject1).faceType = paramFromServiceMsg.uint32_face_type.get();
          ((ReadInJoyUserInfo)localObject1).timestamp = paramFromServiceMsg.uint64_timestamp.get();
          ((ReadInJoyUserInfo)localObject1).faceFlag = paramFromServiceMsg.uint32_face_flag.get();
          ((ReadInJoyUserInfo)localObject1).systemID = paramFromServiceMsg.uint32_sysid.get();
          if (!paramFromServiceMsg.str_url.has()) {
            break label665;
          }
          paramFromServiceMsg = paramFromServiceMsg.str_url.get();
          ((ReadInJoyUserInfo)localObject1).faceUrl = paramFromServiceMsg;
        }
        if ((!((oidb_cmd0xb81.UserInfoItem)localObject2).account_level_info.has()) || (((oidb_cmd0xb81.UserInfoItem)localObject2).account_level_info.get() == null)) {
          break label686;
        }
        localObject2 = (oidb_cmd0xb81.AccountLevelInfo)((oidb_cmd0xb81.UserInfoItem)localObject2).account_level_info.get();
        ((ReadInJoyUserInfo)localObject1).accountLevel = ((oidb_cmd0xb81.AccountLevelInfo)localObject2).uint32_account_cc_level.get();
        if (!((oidb_cmd0xb81.AccountLevelInfo)localObject2).account_cc_level_icon_s.has()) {
          break label672;
        }
        paramFromServiceMsg = ((oidb_cmd0xb81.AccountLevelInfo)localObject2).account_cc_level_icon_s.get();
        label508:
        ((ReadInJoyUserInfo)localObject1).smallIconUrl = paramFromServiceMsg;
        if (!((oidb_cmd0xb81.AccountLevelInfo)localObject2).account_cc_level_icon_l.has()) {
          break label679;
        }
        paramFromServiceMsg = ((oidb_cmd0xb81.AccountLevelInfo)localObject2).account_cc_level_icon_l.get();
        ((ReadInJoyUserInfo)localObject1).largeIconUrl = paramFromServiceMsg;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUserInfoModule", 2, "[handle0xb81UserInfo], accountLevel = " + ((ReadInJoyUserInfo)localObject1).accountLevel + ", smallIconUrl = " + ((ReadInJoyUserInfo)localObject1).smallIconUrl + ", largeIconUrl = " + ((ReadInJoyUserInfo)localObject1).largeIconUrl);
        }
      }
      for (;;)
      {
        ((ReadInJoyUserInfo)localObject1).requestFlag = true;
        this.jdField_a_of_type_Pgu.a(paramToServiceMsg, (ReadInJoyUserInfo)localObject1, true, true);
        QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "handle0xb81UserInfo succeed, userInfo = ", localObject1 });
        i += 1;
        break label182;
        bool = false;
        break;
        paramFromServiceMsg = "";
        break label328;
        paramFromServiceMsg = "";
        break label434;
        paramFromServiceMsg = "";
        break label508;
        paramFromServiceMsg = "";
        break label534;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUserInfoModule", 2, "[handle0xb81UserInfo], accountLevelInfo is null.");
        }
      }
      paramObject = (Integer)paramToServiceMsg.getAttributes().get("retry_request_count_key");
      QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "retry_count = ", paramObject, "handle0xb81UserInfo failed." });
      paramFromServiceMsg = (List)paramToServiceMsg.getAttributes().get("user_info_uin_list_key");
      if (paramFromServiceMsg != null)
      {
        QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "accountInfoReqList size = ", Integer.valueOf(paramFromServiceMsg.size()) });
        if (paramFromServiceMsg.size() > 0) {
          QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "retry accountInfoReqList [0] = ", paramFromServiceMsg.get(0) });
        }
      }
      if (paramObject.intValue() < 1)
      {
        paramToServiceMsg.addAttribute("retry_request_count_key", Integer.valueOf(paramObject.intValue() + 1));
        paramToServiceMsg.addAttribute("request_begin_time", Long.valueOf(System.currentTimeMillis()));
        ors.a("handle0xb81UserInfo", new ReadInJoyUserInfoModule.4(this, paramToServiceMsg), this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
        label883:
        return;
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        i = 0;
        if (i < paramFromServiceMsg.size())
        {
          paramToServiceMsg = String.valueOf(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$400((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)paramFromServiceMsg.get(i)));
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            break label1099;
          }
          paramObject = new ArrayList();
          localObject1 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramToServiceMsg);
          if (localObject1 == null) {
            break label1087;
          }
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            pgr localpgr = (pgr)((Iterator)localObject2).next();
            if (localpgr != null)
            {
              localpgr.a(paramToServiceMsg, "request0xb81UserInfo result = " + j);
              paramObject.add(localpgr);
            }
          }
          if (paramObject.size() <= 0) {
            break label1075;
          }
          ((List)localObject1).removeAll(paramObject);
        }
      }
      for (;;)
      {
        this.b.remove(paramToServiceMsg);
        i += 1;
        break label900;
        break;
        break;
        QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, tempList is null.");
        continue;
        QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, uin callback list is null.");
        continue;
        QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, callback list is null.");
      }
    }
  }
  
  private void b(List<String> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyUserInfoModule", 2, "requestReadInJoyUserInfoWithParams.");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      AppRuntime localAppRuntime = ors.a();
      long l = 0L;
      if ((localAppRuntime instanceof QQAppInterface)) {
        if (!((alto)((QQAppInterface)localAppRuntime).getManager(51)).b(str)) {
          break label136;
        }
      }
      label136:
      for (l = 1L;; l = 2L)
      {
        try
        {
          localArrayList.add(new pgs().a(Long.valueOf(str).longValue()).b(l).a());
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.d("ReadInJoyUserInfoModule", 2, "uin is not a long type.");
        }
        break;
      }
    }
    if (localArrayList.size() <= 0)
    {
      QLog.d("ReadInJoyUserInfoModule", 2, "requestReadInJoyUserInfoWithParams failed, the uinList is empty.");
      return;
    }
    a(new pgt().a(paramInt1).b(paramInt2).c(paramInt3).a(localArrayList).a());
  }
  
  public ReadInJoyUserInfo a(String paramString, int paramInt1, int paramInt2, int paramInt3, pgr parampgr)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyUserInfoModule", 1, "getSingleReadInJoyUserInfoWithParams uin is null or empty.");
      paramString = null;
    }
    ReadInJoyUserInfo localReadInJoyUserInfo;
    do
    {
      return paramString;
      QLog.d("ReadInJoyUserInfoModule", 1, "load data from 0xb81 userinfo uin" + paramString);
      if (this.jdField_a_of_type_Pgu == null) {
        break;
      }
      localReadInJoyUserInfo = this.jdField_a_of_type_Pgu.a(paramString);
      if (localReadInJoyUserInfo == null) {
        break;
      }
      paramString = localReadInJoyUserInfo;
    } while (!TextUtils.isEmpty(localReadInJoyUserInfo.nick));
    localReadInJoyUserInfo.nick = a();
    return localReadInJoyUserInfo;
    if ((parampgr != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new CopyOnWriteArrayList());
      }
      ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).add(parampgr);
    }
    ors.a("getSingleReadInJoyUserInfoWithParams", new ReadInJoyUserInfoModule.1(this, paramString, paramInt1, paramInt2, paramInt3), this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    return null;
  }
  
  public ReadInJoyUserInfo a(String paramString, pgr parampgr)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyUserInfoModule", 1, "getSingleReadInJoyUserInfo uin is null or empty.");
      return null;
    }
    return a(paramString, 1, 1, 0, parampgr);
  }
  
  public ConcurrentHashMap<String, List<pgr>> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public pgu a()
  {
    return this.jdField_a_of_type_Pgu;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pgu.b();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    if (jdField_a_of_type_JavaUtilMap != null) {
      jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb81")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(List<String> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (ors.i())
    {
      ors.a("requestReadInJoyUserInfoWithParamsInSubThread", new ReadInJoyUserInfoModule.3(this, paramList, paramInt1, paramInt2, paramInt3), this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
      return;
    }
    b(paramList, paramInt1, paramInt2, paramInt3);
  }
  
  public ConcurrentHashMap<String, Boolean> b()
  {
    return this.b;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pgu != null) {
      this.jdField_a_of_type_Pgu.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule
 * JD-Core Version:    0.7.0.1
 */