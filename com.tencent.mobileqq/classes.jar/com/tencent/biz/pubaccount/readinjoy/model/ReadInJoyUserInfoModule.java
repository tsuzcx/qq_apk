package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJUtilsHelper;
import com.tencent.biz.pubaccount.readinjoy.common.RIJUtilsHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.AccountInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.AccountLevelInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoReq;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoRsp;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.HeadDecoration;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.HeadInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.LiveStatus;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.ReqBody;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.RspBody;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoItem;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoOption;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ReadInJoyUserInfoModule
  extends ReadInJoyEngineModule
{
  private static Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ReadInJoyUserInfoRepository jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository;
  private ConcurrentHashMap<String, List<ReadInJoyUserInfoModule.RefreshUserInfoCallBack>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap();
  
  public ReadInJoyUserInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository = new ReadInJoyUserInfoRepository(paramExecutorService, this, paramEntityManager);
  }
  
  public static ReadInJoyUserInfo a(long paramLong, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    return a(paramLong, paramRefreshUserInfoCallBack, false);
  }
  
  public static ReadInJoyUserInfo a(long paramLong, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean)
  {
    if (paramLong != 0L)
    {
      Object localObject = RIJUtilsHelper.a.a();
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)localObject).a().a();
        if (localObject != null) {
          return ((ReadInJoyUserInfoModule)localObject).a(String.valueOf(paramLong), paramRefreshUserInfoCallBack, paramBoolean);
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
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_disable_comment_recommed.set(ReadInJoyUserInfoModule.Request0xb81Params.d(paramRequest0xb81Params));
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_head_url.set(ReadInJoyUserInfoModule.Request0xb81Params.e(paramRequest0xb81Params));
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_account_cc_level.set(2);
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_live_status.set(1);
    localGetUserInfoReq.msg_user_option.set((MessageMicro)localObject);
    localObject = new ArrayList();
    if ((ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params) != null) && (ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).size() > 0))
    {
      int i = 0;
      while (i < ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).size())
      {
        oidb_cmd0xb81.AccountInfo localAccountInfo = new oidb_cmd0xb81.AccountInfo();
        localAccountInfo.uint32_account_type.set(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$1000((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).get(i)));
        localAccountInfo.uint64_uin.set(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$400((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).get(i)));
        localAccountInfo.uint64_friend_status.set(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$1100((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).get(i)));
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
    paramString = ReadInJoyOidbHelper.a(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public static String a()
  {
    return HardCodeUtil.a(2131713036);
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
  
  public static String a(long paramLong, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, String paramString)
  {
    paramRefreshUserInfoCallBack = a(paramLong, paramRefreshUserInfoCallBack);
    if (paramRefreshUserInfoCallBack == null) {
      return paramString;
    }
    return paramRefreshUserInfoCallBack.nick;
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
  
  private String a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    String str = paramString;
    if (paramUserInfoItem.msg_account_info.has())
    {
      str = paramString;
      if (paramUserInfoItem.msg_account_info.get() != null)
      {
        paramReadInJoyUserInfo.accountType = ((oidb_cmd0xb81.AccountInfo)paramUserInfoItem.msg_account_info.get()).uint32_account_type.get();
        paramReadInJoyUserInfo.uin = String.valueOf(((oidb_cmd0xb81.AccountInfo)paramUserInfoItem.msg_account_info.get()).uint64_uin.get());
        str = String.valueOf(((oidb_cmd0xb81.AccountInfo)paramUserInfoItem.msg_account_info.get()).uint64_uin.get());
      }
    }
    if (paramUserInfoItem.bytes_nick.has()) {}
    for (paramString = paramUserInfoItem.bytes_nick.get().toStringUtf8();; paramString = "")
    {
      paramReadInJoyUserInfo.nick = paramString;
      return str;
    }
  }
  
  public static List<ReadInJoyUserInfo> a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    Object localObject;
    do
    {
      do
      {
        return null;
        localObject = (QQAppInterface)ReadInJoyUtils.a();
      } while (localObject == null);
      localObject = ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a();
    } while (localObject == null);
    return ((ReadInJoyUserInfoModule)localObject).a(paramList, 1, 1, 0, null);
  }
  
  private void a(int paramInt, String paramString, List<ReadInJoyUserInfoModule.RefreshUserInfoCallBack> paramList1, List<ReadInJoyUserInfoModule.RefreshUserInfoCallBack> paramList2)
  {
    Iterator localIterator = paramList2.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyUserInfoModule.RefreshUserInfoCallBack localRefreshUserInfoCallBack = (ReadInJoyUserInfoModule.RefreshUserInfoCallBack)localIterator.next();
      if (localRefreshUserInfoCallBack != null)
      {
        localRefreshUserInfoCallBack.onLoadUserInfoFailed(paramString, "request0xb81UserInfo result = " + paramInt);
        paramList1.add(localRefreshUserInfoCallBack);
      }
    }
    if (paramList1.size() > 0)
    {
      paramList2.removeAll(paramList1);
      return;
    }
    QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, tempList is null.");
  }
  
  private void a(int paramInt, List<ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        a(paramInt, paramList, i);
        i += 1;
      }
    }
  }
  
  private void a(int paramInt1, List<ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq> paramList, int paramInt2)
  {
    paramList = String.valueOf(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$400((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)paramList.get(paramInt2)));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramList);
      if (localList != null) {
        a(paramInt1, paramList, localArrayList, localList);
      }
    }
    for (;;)
    {
      this.b.remove(paramList);
      return;
      QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, uin callback list is null.");
      continue;
      QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, callback list is null.");
    }
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
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.HeadDecoration paramHeadDecoration)
  {
    if ((paramHeadDecoration != null) && (paramHeadDecoration.has()))
    {
      paramReadInJoyUserInfo.decorationName = RIJPBFieldUtils.a(paramHeadDecoration.name);
      paramReadInJoyUserInfo.decorationIcon = RIJPBFieldUtils.a(paramHeadDecoration.icon);
      paramReadInJoyUserInfo.decorationId = RIJPBFieldUtils.a(paramHeadDecoration.id);
    }
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    if (paramUserInfoItem.live_status.has()) {
      paramReadInJoyUserInfo.liveStatus = ((oidb_cmd0xb81.LiveStatus)paramUserInfoItem.live_status.get());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    Integer localInteger = (Integer)paramToServiceMsg.getAttributes().get("retry_request_count_key");
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "retry_count = ", localInteger, "handle0xb81UserInfo failed." });
    List localList = (List)paramToServiceMsg.getAttributes().get("user_info_uin_list_key");
    if (localList != null)
    {
      QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "accountInfoReqList size = ", Integer.valueOf(localList.size()) });
      if (localList.size() > 0) {
        QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "retry accountInfoReqList [0] = ", localList.get(0) });
      }
    }
    if (localInteger.intValue() < 1)
    {
      paramToServiceMsg.addAttribute("retry_request_count_key", Integer.valueOf(localInteger.intValue() + 1));
      paramToServiceMsg.addAttribute("request_begin_time", Long.valueOf(System.currentTimeMillis()));
      RIJThreadHandler.a("handle0xb81UserInfo", new ReadInJoyUserInfoModule.4(this, paramToServiceMsg), this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
      return;
    }
    a(paramInt, localList);
  }
  
  public static void a(String paramString)
  {
    QLog.i("ReadInJoyUserInfoModule", 1, "[clearCallbackList], uin = " + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (QQAppInterface)ReadInJoyUtils.a();
      if (localObject != null)
      {
        localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        if (localObject != null)
        {
          localObject = ((ReadInJoyLogicManager)localObject).a().a();
          if ((localObject != null) && (((ReadInJoyUserInfoModule)localObject).a() != null))
          {
            ((ReadInJoyUserInfoModule)localObject).a().remove(paramString);
            QLog.i("ReadInJoyUserInfoModule", 1, "[clearCallbackList] finished.");
          }
        }
      }
    }
  }
  
  private void a(String paramString, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    if (paramUserInfoItem.uint32_disable_comment_recommed.has()) {
      if (paramUserInfoItem.uint32_disable_comment_recommed.get() != 0) {
        break label28;
      }
    }
    label28:
    for (boolean bool = true;; bool = false)
    {
      ReadInJoyHelper.a(paramString, bool);
      return;
    }
  }
  
  public static void a(List<String> paramList)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a();
      if (localObject != null) {
        ((ReadInJoyUserInfoModule)localObject).a(paramList, 1, 1, 0);
      }
    }
  }
  
  private void a(List<oidb_cmd0xb81.UserInfoItem> paramList, int paramInt)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = new ReadInJoyUserInfo();
    paramList = (oidb_cmd0xb81.UserInfoItem)paramList.get(paramInt);
    String str = a("", localReadInJoyUserInfo, paramList);
    d(localReadInJoyUserInfo, paramList);
    c(localReadInJoyUserInfo, paramList);
    a(str, paramList);
    b(localReadInJoyUserInfo, paramList);
    a(localReadInJoyUserInfo, paramList);
    a(localReadInJoyUserInfo, (oidb_cmd0xb81.HeadDecoration)paramList.head_decoration.get());
    localReadInJoyUserInfo.requestFlag = true;
    localReadInJoyUserInfo.lastUpdateTimeMilliSecond = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository.a(str, localReadInJoyUserInfo, true, true);
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "handle0xb81UserInfo succeed, userInfo = ", localReadInJoyUserInfo });
  }
  
  private void a(oidb_cmd0xb81.RspBody paramRspBody)
  {
    if ((paramRspBody.msg_get_user_info_rsp.has()) && (paramRspBody.msg_get_user_info_rsp.get() != null))
    {
      paramRspBody = (oidb_cmd0xb81.GetUserInfoRsp)paramRspBody.msg_get_user_info_rsp.get();
      if (a(paramRspBody))
      {
        paramRspBody = paramRspBody.rpt_msg_user_info.get();
        int i = 0;
        while (i < paramRspBody.size())
        {
          a(paramRspBody, i);
          i += 1;
        }
      }
    }
  }
  
  private boolean a(oidb_cmd0xb81.GetUserInfoRsp paramGetUserInfoRsp)
  {
    return (paramGetUserInfoRsp.rpt_msg_user_info.has()) && (paramGetUserInfoRsp.rpt_msg_user_info.get() != null) && (paramGetUserInfoRsp.rpt_msg_user_info.get().size() > 0);
  }
  
  private void b(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    boolean bool = true;
    if (paramUserInfoItem.uint32_rt_read.has()) {
      if (paramUserInfoItem.uint32_rt_read.get() != 1) {
        break label29;
      }
    }
    for (;;)
    {
      paramReadInJoyUserInfo.readlTimeRead = bool;
      return;
      label29:
      bool = false;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xb81.RspBody localRspBody = new oidb_cmd0xb81.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("request_begin_time")).longValue();
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "handle0xb81UserInfo result = ", Integer.valueOf(i), ", cost = ", Long.valueOf(l) });
    paramFromServiceMsg = ReadInJoyUtils.a();
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      RIJStatisticCollectorReport.b(paramFromServiceMsg, bool, l, i);
      if (i != 0) {
        break;
      }
      a(localRspBody);
      return;
    }
    a(paramToServiceMsg, i);
  }
  
  private void b(List<String> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d("ReadInJoyUserInfoModule", 2, "requestReadInJoyUserInfoWithParams.");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      AppRuntime localAppRuntime = ReadInJoyUtils.a();
      long l = 0L;
      if ((localAppRuntime instanceof QQAppInterface)) {
        if (!((FriendsManager)localAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str)) {
          break label134;
        }
      }
      label134:
      for (l = 1L;; l = 2L)
      {
        try
        {
          localArrayList.add(new ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.AccountInfoBuilder().a(Long.valueOf(str).longValue()).b(l).a());
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
    a(new ReadInJoyUserInfoModule.Request0xb81Params.Builder().a(paramInt1).b(paramInt2).c(paramInt3).a(localArrayList).d(paramInt4).a());
  }
  
  private void c(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    if ((paramUserInfoItem.account_level_info.has()) && (paramUserInfoItem.account_level_info.get() != null))
    {
      oidb_cmd0xb81.AccountLevelInfo localAccountLevelInfo = (oidb_cmd0xb81.AccountLevelInfo)paramUserInfoItem.account_level_info.get();
      paramReadInJoyUserInfo.accountLevel = localAccountLevelInfo.uint32_account_cc_level.get();
      if (localAccountLevelInfo.account_cc_level_icon_s.has())
      {
        paramUserInfoItem = localAccountLevelInfo.account_cc_level_icon_s.get();
        paramReadInJoyUserInfo.smallIconUrl = paramUserInfoItem;
        if (!localAccountLevelInfo.account_cc_level_icon_l.has()) {
          break label174;
        }
        paramUserInfoItem = localAccountLevelInfo.account_cc_level_icon_l.get();
        label83:
        paramReadInJoyUserInfo.largeIconUrl = paramUserInfoItem;
        if (!localAccountLevelInfo.authorize_desc.has()) {
          break label181;
        }
      }
      label174:
      label181:
      for (paramUserInfoItem = localAccountLevelInfo.authorize_desc.get();; paramUserInfoItem = "")
      {
        paramReadInJoyUserInfo.authorizeDesc = paramUserInfoItem;
        QLog.d("ReadInJoyUserInfoModule", 2, "[handle0xb81UserInfo], accountLevel = " + paramReadInJoyUserInfo.accountLevel + ", smallIconUrl = " + paramReadInJoyUserInfo.smallIconUrl + ", largeIconUrl = " + paramReadInJoyUserInfo.largeIconUrl);
        return;
        paramUserInfoItem = "";
        break;
        paramUserInfoItem = "";
        break label83;
      }
    }
    QLog.d("ReadInJoyUserInfoModule", 2, "[handle0xb81UserInfo], accountLevelInfo is null.");
  }
  
  private void d(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    if ((paramUserInfoItem.msg_head_info.has()) && (paramUserInfoItem.msg_head_info.get() != null))
    {
      paramUserInfoItem = (oidb_cmd0xb81.HeadInfo)paramUserInfoItem.msg_head_info.get();
      paramReadInJoyUserInfo.faceType = paramUserInfoItem.uint32_face_type.get();
      paramReadInJoyUserInfo.timestamp = paramUserInfoItem.uint64_timestamp.get();
      paramReadInJoyUserInfo.faceFlag = paramUserInfoItem.uint32_face_flag.get();
      paramReadInJoyUserInfo.systemID = paramUserInfoItem.uint32_sysid.get();
      if (!paramUserInfoItem.str_url.has()) {
        break label99;
      }
    }
    label99:
    for (paramUserInfoItem = paramUserInfoItem.str_url.get();; paramUserInfoItem = "")
    {
      paramReadInJoyUserInfo.faceUrl = paramUserInfoItem;
      return;
    }
  }
  
  public ReadInJoyUserInfo a(String paramString, int paramInt1, int paramInt2, int paramInt3, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean)
  {
    return a(paramString, paramInt1, paramInt2, paramInt3, paramRefreshUserInfoCallBack, paramBoolean, false);
  }
  
  public ReadInJoyUserInfo a(String paramString, int paramInt1, int paramInt2, int paramInt3, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyUserInfoModule", 1, "getSingleReadInJoyUserInfoWithParams uin is null or empty.");
      localObject = null;
    }
    ReadInJoyUserInfo localReadInJoyUserInfo;
    do
    {
      return localObject;
      QLog.d("ReadInJoyUserInfoModule", 1, "load data from 0xb81 userinfo uin" + paramString);
      if ((paramBoolean1) || (paramBoolean2)) {
        b();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository == null) {
        break;
      }
      localReadInJoyUserInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository.a(paramString);
      if ((localReadInJoyUserInfo == null) || ((paramBoolean1) && (localReadInJoyUserInfo.isReadlTimeRead())) || (paramBoolean2)) {
        break;
      }
      if (TextUtils.isEmpty(localReadInJoyUserInfo.nick)) {
        localReadInJoyUserInfo.nick = a();
      }
      localObject = localReadInJoyUserInfo;
    } while (paramRefreshUserInfoCallBack == null);
    paramRefreshUserInfoCallBack.onLoadUserInfoSucceed(paramString, localReadInJoyUserInfo);
    return localReadInJoyUserInfo;
    if ((paramRefreshUserInfoCallBack != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new CopyOnWriteArrayList());
      }
      ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).add(paramRefreshUserInfoCallBack);
    }
    RIJThreadHandler.a("getSingleReadInJoyUserInfoWithParams", new ReadInJoyUserInfoModule.1(this, paramString, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramInt3), this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    return null;
  }
  
  public ReadInJoyUserInfo a(String paramString, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyUserInfoModule", 1, "getSingleReadInJoyUserInfo uin is null or empty.");
      return null;
    }
    return a(paramString, 1, 1, 0, paramRefreshUserInfoCallBack, paramBoolean);
  }
  
  public List<ReadInJoyUserInfo> a(List<String> paramList, int paramInt1, int paramInt2, int paramInt3, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        str = (String)paramList.next();
        if (!TextUtils.isEmpty(str))
        {
          ReadInJoyUserInfo localReadInJoyUserInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository.a(str);
          if (localReadInJoyUserInfo != null) {
            localArrayList.add(localReadInJoyUserInfo);
          } else {
            ((List)localObject).add(str);
          }
        }
      }
    }
    if ((paramRefreshUserInfoCallBack != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (((List)localObject).size() > 0))
    {
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        str = (String)paramList.next();
        if (!TextUtils.isEmpty(str))
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) == null) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new CopyOnWriteArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).add(paramRefreshUserInfoCallBack);
        }
      }
    }
    if (((List)localObject).size() > 0) {
      RIJThreadHandler.a("getBatchReadInJoyUserInfoWithParams", new ReadInJoyUserInfoModule.2(this, (List)localObject, paramInt1, paramInt2, paramInt3), this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    }
    if (localArrayList.size() > 0)
    {
      if (paramRefreshUserInfoCallBack != null)
      {
        paramList = localArrayList.iterator();
        while (paramList.hasNext())
        {
          localObject = (ReadInJoyUserInfo)paramList.next();
          paramRefreshUserInfoCallBack.onLoadUserInfoSucceed(((ReadInJoyUserInfo)localObject).uin, (ReadInJoyUserInfo)localObject);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public List<ReadInJoyUserInfo> a(List<String> paramList, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    return a(paramList, 1, 1, 0, paramRefreshUserInfoCallBack);
  }
  
  public ConcurrentHashMap<String, List<ReadInJoyUserInfoModule.RefreshUserInfoCallBack>> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoRepository.b();
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
    a(paramList, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public void a(List<String> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (RIJThreadHandler.a())
    {
      RIJThreadHandler.a("requestReadInJoyUserInfoWithParamsInSubThread", new ReadInJoyUserInfoModule.3(this, paramList, paramInt1, paramInt2, paramInt3, paramInt4), this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
      return;
    }
    b(paramList, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public ConcurrentHashMap<String, Boolean> b()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule
 * JD-Core Version:    0.7.0.1
 */