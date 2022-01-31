package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.DynamicMsgProcessor;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageReq;
import com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageRsp;
import com.tencent.jungle.weather.WeatherReportInfo.PbReqMsgHead;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.historyMsg.AioHistoryMsgRequest;
import com.tencent.mobileqq.mp.historyMsg.AioHistoryMsgResponse;
import com.tencent.mobileqq.mp.historyMsg.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserFollowListResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SendLBSInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SendPreMessageStatusResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationResponse;
import com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommendRequest;
import com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommendResponse;
import com.tencent.mobileqq.mp.publicaccount_recommend.RetInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.vaswebviewplugin.PublicAccountWebReport;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.FollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspFollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspTypeList;
import zqx;
import zqy;
import zqz;
import zrb;
import zrc;
import zrd;

public class PublicAccountHandler
  extends BusinessHandler
{
  public static String a;
  public static String b;
  public long a;
  public List a;
  private Map a;
  public boolean a;
  private boolean b;
  private boolean c;
  private boolean d = true;
  
  static
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  PublicAccountHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    String str = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_TotalSwitch");
    if (str != null) {}
    try
    {
      this.jdField_b_of_type_Boolean = Boolean.parseBoolean(str);
      label43:
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "PublicAccount_SearchSwitch");
      if (paramQQAppInterface != null) {}
      try
      {
        this.c = Boolean.parseBoolean(paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface) {}
    }
    catch (Exception localException)
    {
      break label43;
    }
  }
  
  private int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "getUserFollowList");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_follow_list");
    mobileqq_mp.GetUserFollowListRequest localGetUserFollowListRequest = new mobileqq_mp.GetUserFollowListRequest();
    localGetUserFollowListRequest.follow_seqno.set(Utils.a(paramLong1));
    localGetUserFollowListRequest.public_account_seqno.set(Utils.a(paramLong2));
    localGetUserFollowListRequest.begin.set(Utils.a(paramLong3));
    localGetUserFollowListRequest.limit.set(Utils.a(paramLong4));
    localGetUserFollowListRequest.version.set(1);
    localGetUserFollowListRequest.is_increment.set(paramBoolean);
    localNewIntent.putExtra("data", localGetUserFollowListRequest.toByteArray());
    localNewIntent.putExtra("get_user_follow_list_begin", paramLong3);
    localNewIntent.putExtra("get_user_follow_list_follow_seq", paramLong1);
    localNewIntent.putExtra("get_user_follow_list_data_seq", paramLong2);
    localNewIntent.putExtra("time_stamp", paramLong5);
    localNewIntent.putExtra("get_user_follow_list_is_increment", paramBoolean);
    PublicAccountServlet.a(localNewIntent);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    return 0;
  }
  
  private long a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("PublicAccountFollowSeq2", 0L);
  }
  
  private void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("PublicAccountFollowSeq2", paramLong);
    localEditor.commit();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppInterface instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppInterface;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, paramInt, 0, paramString1, "", "", "");
  }
  
  private void a(List paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = ((PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a(paramList, paramLong, paramBoolean1, paramBoolean2);
    paramList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (PublicAccountInfo)((Iterator)localObject1).next();
      localObject2 = paramList.a().b(((PublicAccountInfo)localObject2).getUin(), 1008);
      if (localObject2 == null) {
        break label131;
      }
      paramList.a().b((RecentUser)localObject2);
      i = 1;
    }
    label131:
    for (;;)
    {
      break;
      paramList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if ((i != 0) && (paramList != null)) {
        paramList.sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  private void a(SubMsgType0x28.RspFollowList paramRspFollowList)
  {
    int k = 1;
    List localList = paramRspFollowList.rpt_msg_followlist.get();
    long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Iterator localIterator = localList.iterator();
    paramRspFollowList = null;
    int i = 0;
    int j = 0;
    Object localObject2;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localObject2 = (SubMsgType0x28.FollowList)localIterator.next();
      if (l == ((SubMsgType0x28.FollowList)localObject2).uint64_uin.get())
      {
        localObject1 = String.valueOf(((SubMsgType0x28.FollowList)localObject2).uint64_puin.get());
        switch (((SubMsgType0x28.FollowList)localObject2).uint32_type.get())
        {
        }
      }
    }
    for (;;)
    {
      break;
      localObject2 = (PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      ((PublicAccountDataManager)localObject2).b((String)localObject1);
      ((PublicAccountDataManager)localObject2).a((String)localObject1);
      paramRspFollowList = new zrc();
      paramRspFollowList.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountDataManager)localObject2).a(l + "");
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, 1008);
      TroopBarAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountDataManager)localObject2).a());
      ServiceAccountFolderManager.a().c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = (EcShopAssistantManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
      if (localObject1 != null)
      {
        ((EcShopAssistantManager)localObject1).a(l + "", "pushmsg");
        j = 1;
        continue;
        a();
        i = 1;
        continue;
        if (j != 0)
        {
          a(103, true, null);
          a(102, true, paramRspFollowList);
        }
        if (i != 0) {
          a(101, true, null);
        }
        if (!localList.isEmpty()) {
          if (((SubMsgType0x28.FollowList)localList.get(0)).uint32_type.get() != 1) {
            break label421;
          }
        }
        label421:
        for (boolean bool = true;; bool = false)
        {
          l = ((SubMsgType0x28.FollowList)localList.get(0)).uint64_puin.get();
          ThreadManager.getUIHandler().post(new zqx(this, l, bool));
          paramRspFollowList = ReadInJoyLogicEngine.a();
          i = k;
          if (bool) {
            i = 2;
          }
          paramRspFollowList.b(l, i);
          return;
        }
      }
      else
      {
        j = 1;
      }
    }
  }
  
  private void a(SubMsgType0x28.RspTypeList paramRspTypeList) {}
  
  private long b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getLong("PublicAccountDataSeq2", 0L);
  }
  
  private void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putLong("PublicAccountDataSeq2", paramLong);
    localEditor.commit();
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      int i;
      try
      {
        paramIntent = new publicaccount_recommend.BusinessRecommendResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((!paramIntent.ret_info.has()) || (!((publicaccount_recommend.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
          break label185;
        }
        i = ((publicaccount_recommend.RetInfo)paramIntent.ret_info.get()).ret_code.get();
      }
      catch (Exception paramIntent)
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "handleGetRecommendList(): package size is " + paramArrayOfByte.length + " Byte");
      }
      if (paramIntent.business.has())
      {
        paramIntent = PublicRecommendAccountInfo.createPublicRecommendAccountInfoList(paramIntent.business.get());
        ((PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a(paramIntent);
        a(104, true, null);
        return;
        a(104, false, null);
        return;
      }
      while (i != 0)
      {
        return;
        label185:
        i = -1;
      }
    }
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    zrd localzrd = new zrd();
    int j = 1;
    boolean bool2 = false;
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 2901) && (paramIntent != null))
    {
      i = paramIntent.getIntExtra("k_resend_cnt", 0);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "handleGetUserFollowListk_resend_cnt" + i);
      }
      if (i < 2)
      {
        paramIntent.putExtra("k_resend_cnt", i + 1);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)paramIntent);
        return;
      }
    }
    long l1;
    long l2;
    long l3;
    long l4;
    boolean bool1;
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null))
    {
      localzrd.jdField_a_of_type_Int = 0;
      l1 = paramIntent.getLongExtra("time_stamp", 0L);
      l2 = paramIntent.getLongExtra("get_user_follow_list_begin", 0L);
      l3 = paramIntent.getLongExtra("get_user_follow_list_follow_seq", 0L);
      l4 = paramIntent.getLongExtra("get_user_follow_list_data_seq", 0L);
      bool2 = paramIntent.getBooleanExtra("get_user_follow_list_is_increment", true);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "handleGetUserFollowListtiem: " + l1 + "begin: " + l2 + "preFollowSeq: " + l3 + "preDataSeq: " + l4);
      }
      for (;;)
      {
        try
        {
          paramIntent = new mobileqq_mp.GetUserFollowListResponse();
          paramIntent.mergeFrom(paramArrayOfByte);
          if ((!paramIntent.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
            continue;
          }
          i = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
          localzrd.jdField_a_of_type_Int = i;
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountHandler", 2, "handleGetUserFollowListerrCode: " + i);
          }
          if (i == 0) {
            continue;
          }
          localzrd.jdField_a_of_type_Boolean = true;
          bool1 = false;
          i = 1;
        }
        catch (Exception paramIntent)
        {
          label401:
          label427:
          long l5;
          label494:
          localzrd.jdField_a_of_type_Int = -1;
          localzrd.jdField_a_of_type_Boolean = true;
          bool1 = false;
          i = 1;
          continue;
          a(l4);
          continue;
        }
        if (i == 0) {
          break;
        }
        a(100, bool1, localzrd);
        return;
        i = 0;
        continue;
        if (!paramIntent.follow_seqno.has()) {
          break label840;
        }
        i = paramIntent.follow_seqno.get();
        l4 = Utils.a(i);
        if (!paramIntent.public_account_seqno.has()) {
          break label846;
        }
        i = paramIntent.public_account_seqno.get();
        l5 = Utils.a(i);
        if ((l4 > l3) && (l3 != 0L))
        {
          a(l4, l5, 0L, 20L, SystemClock.uptimeMillis(), false);
          i = 0;
          bool1 = false;
        }
        else
        {
          if (!paramIntent.total_count.has()) {
            break label858;
          }
          i = paramIntent.total_count.get();
          l3 = Utils.a(i);
          paramFromServiceMsg = PublicAccountInfo.createPublicAccountInfoList(paramIntent.info.get(), l1);
          localzrd.jdField_a_of_type_JavaUtilList = paramFromServiceMsg;
          if (!paramIntent.has_next.has()) {
            break label852;
          }
          if (paramIntent.has_next.get()) {
            break label864;
          }
          break label852;
        }
      }
    }
    for (;;)
    {
      localzrd.jdField_a_of_type_Boolean = bool1;
      localzrd.jdField_a_of_type_Long = l3;
      paramIntent = (PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      a(paramFromServiceMsg, l1, bool2, localzrd.jdField_a_of_type_Boolean);
      if (localzrd.jdField_a_of_type_Boolean)
      {
        TroopBarAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.a());
        ServiceAccountFolderManager.a().c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        TroopBarAssistantManager.a().g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        ReadInJoyLogicEngine.a().e();
        paramIntent = new zrb(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent);
        ThreadManager.getSubThreadHandler().postDelayed(paramIntent, 15000L);
        ThreadManager.getSubThreadHandler().postDelayed(new zqy(this), 500L);
      }
      if (!localzrd.jdField_a_of_type_Boolean)
      {
        if (bool2) {
          a(l4, l5, 0L, 20L, l1, true);
        }
        for (;;)
        {
          b(l5);
          bool1 = true;
          i = 1;
          break;
          a(l4, l5, l2 + 20L, 20L, l1, false);
        }
      }
      localzrd.jdField_a_of_type_Int = -1;
      localzrd.jdField_a_of_type_Boolean = true;
      bool1 = bool2;
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PublicAccountHandler", 2, "<<---handleGetUserFollowList " + localzrd.jdField_a_of_type_Int);
      bool1 = bool2;
      i = j;
      break;
      label840:
      i = 0;
      break label401;
      label846:
      i = 0;
      break label427;
      label852:
      bool1 = true;
      continue;
      label858:
      i = 0;
      break label494;
      label864:
      bool1 = false;
    }
  }
  
  public int a()
  {
    long l1 = a();
    long l2 = b();
    long l3 = SystemClock.uptimeMillis();
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(l3);
    }
    return a(l1, l2, 0L, 20L, l3, true);
  }
  
  public int a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_business_recommend");
    publicaccount_recommend.BusinessRecommendRequest localBusinessRecommendRequest = new publicaccount_recommend.BusinessRecommendRequest();
    localBusinessRecommendRequest.recomend_count.set(20);
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null) || (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString == null)) {
        break label231;
      }
    }
    label231:
    for (String str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "getRecommendList() latitude=" + paramSosoLbsInfo.a.a + " longitude=" + paramSosoLbsInfo.a.jdField_b_of_type_Double + ", address=" + str);
      }
      localBusinessRecommendRequest.latitude.set(String.valueOf(paramSosoLbsInfo.a.a));
      localBusinessRecommendRequest.longitude.set(String.valueOf(paramSosoLbsInfo.a.jdField_b_of_type_Double));
      localBusinessRecommendRequest.city_info.set(str);
      localBusinessRecommendRequest.platform.set(109);
      localNewIntent.putExtra("data", localBusinessRecommendRequest.toByteArray());
      PublicAccountServlet.a(localNewIntent);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return 0;
    }
  }
  
  protected Class a()
  {
    return PublicAccountObserver.class;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    localObject1 = new String();
    i = 0;
    while (i < "7.6.8".length())
    {
      localObject2 = localObject1;
      if ("7.6.8".charAt(i) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("7.6.8".charAt(i)));
      }
      i += 1;
      localObject1 = localObject2;
    }
    localObject2 = new WeatherReportInfo.PbReqMsgHead();
    ((WeatherReportInfo.PbReqMsgHead)localObject2).uint32_platform_type.set(1);
    ((WeatherReportInfo.PbReqMsgHead)localObject2).uint32_version.set(Integer.parseInt((String)localObject1));
    localGetWeatherMessageReq = new WeatherReportInfo.GetWeatherMessageReq();
    localGetWeatherMessageReq.pbReqMsgHead.set((MessageMicro)localObject2);
    localGetWeatherMessageReq.uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
    localGetWeatherMessageReq.lat.set(paramInt2);
    localGetWeatherMessageReq.lng.set(paramInt3);
    localGetWeatherMessageReq.fore_flag.set(0);
    localGetWeatherMessageReq.area_id.set(paramInt4);
    try
    {
      localObject1 = new JSONObject();
      if (paramInt1 != 0) {
        break label366;
      }
      localGetWeatherMessageReq.source.set(2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject3;
        int j;
        try
        {
          localObject3 = NetworkInterface.getNetworkInterfaces();
          localObject2 = localObject1;
          if (((Enumeration)localObject3).hasMoreElements())
          {
            localObject2 = ((NetworkInterface)((Enumeration)localObject3).nextElement()).getInetAddresses();
            if (!((Enumeration)localObject2).hasMoreElements()) {
              break label626;
            }
            InetAddress localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
            if ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address))) {
              continue;
            }
            localObject1 = localInetAddress.getHostAddress().toString();
            continue;
            if (paramInt1 == -1)
            {
              localGetWeatherMessageReq.source.set(1);
              continue;
              localJSONException = localJSONException;
              localJSONException.printStackTrace();
              continue;
            }
            localJSONException.put("cmd", paramInt1);
            localGetWeatherMessageReq.source.set(0);
          }
        }
        catch (Exception localException1)
        {
          localObject2 = "";
          localException1.printStackTrace();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          i = j;
          try
          {
            String[] arrayOfString = ((String)localObject2).split(Pattern.quote("."));
            i = j;
            int m = arrayOfString.length;
            int k = 0;
            int n;
            for (i = 0;; i = j | n)
            {
              j = i;
              if (k >= m) {
                break;
              }
              localObject3 = arrayOfString[k];
              j = i << 8;
              i = j;
              n = Integer.parseInt((String)localObject3);
              k += 1;
            }
            localGetWeatherMessageReq.ip.set(j);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            j = i;
            jdField_a_of_type_JavaLangString = (String)localObject2;
          }
        }
        for (;;)
        {
          ToServiceMsg localToServiceMsg = a("QQWeatherReport.getWeatherInfo");
          localToServiceMsg.putWupBuffer(localGetWeatherMessageReq.toByteArray());
          b(localToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountHandler", 2, String.format("send tianqi lat=%d, lng=%d, type=%d, areaid = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt4) }));
          }
          return;
          j = 0;
        }
      }
    }
    ((JSONObject)localObject1).put("platform", 109);
    ((JSONObject)localObject1).put("version", "7.6.8");
    localObject2 = ((JSONObject)localObject1).toString();
    localObject3 = localGetWeatherMessageReq.extra;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    ((PBStringField)localObject3).set((String)localObject1);
    j = 0;
    localObject1 = jdField_a_of_type_JavaLangString;
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
  }
  
  public void a(int paramInt, PublicAccountHandler.IWeatherInfoListener paramIWeatherInfoListener)
  {
    if (paramIWeatherInfoListener != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramIWeatherInfoListener);
    }
    if (paramInt == 1) {
      a(paramInt, 0, 0, 0);
    }
    while (paramInt != 2) {
      return;
    }
    paramIWeatherInfoListener = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
    long l = paramIWeatherInfoListener.getLong("location_time", 0L);
    if ((l != 0L) && (System.currentTimeMillis() - l < 3600000L))
    {
      int i = paramIWeatherInfoListener.getInt("loc_lat", 0);
      int j = paramIWeatherInfoListener.getInt("loc_lng", 0);
      if ((i != 0) && (j != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("PublicAccountHandler", 2, "local time less than 1 hour");
        }
        a(paramInt, i, j, 0);
        return;
      }
    }
    SosoInterface.a(new zqz(this, 0, false, true, 60000L, true, false, "PublicAccountHandler", paramInt, paramIWeatherInfoListener));
  }
  
  /* Error */
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc 68
    //   8: iconst_2
    //   9: new 326	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 866
    //   19: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: l2i
    //   24: invokestatic 870	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   27: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 337	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: lload_1
    //   37: l2i
    //   38: lookupswitch	default:+26->64, 40:+27->65, 63:+126->164
    //   65: new 872	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   68: dup
    //   69: invokespecial 873	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:<init>	()V
    //   72: aload_3
    //   73: invokevirtual 874	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   76: checkcast 872	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   79: astore_3
    //   80: aload_3
    //   81: getfield 877	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   84: invokevirtual 316	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   87: istore 4
    //   89: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +30 -> 122
    //   95: ldc 68
    //   97: iconst_2
    //   98: new 326	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 879
    //   108: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 4
    //   113: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 337	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: iload 4
    //   124: iconst_1
    //   125: if_icmpne +18 -> 143
    //   128: aload_0
    //   129: aload_3
    //   130: getfield 883	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_followlist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;
    //   133: invokevirtual 884	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: checkcast 272	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList
    //   139: invokespecial 886	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;)V
    //   142: return
    //   143: iload 4
    //   145: iconst_2
    //   146: if_icmpne -82 -> 64
    //   149: aload_0
    //   150: aload_3
    //   151: getfield 890	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_typelist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;
    //   154: invokevirtual 893	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   157: checkcast 892	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList
    //   160: invokespecial 895	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;)V
    //   163: return
    //   164: new 897	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody
    //   167: dup
    //   168: invokespecial 898	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:<init>	()V
    //   171: astore 7
    //   173: aload 7
    //   175: aload_3
    //   176: invokevirtual 899	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   179: pop
    //   180: aload 7
    //   182: getfield 902	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:rpt_msg_pubunikey	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   185: invokevirtual 282	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   188: invokeinterface 230 1 0
    //   193: astore_3
    //   194: aload_3
    //   195: invokeinterface 235 1 0
    //   200: ifeq -136 -> 64
    //   203: aload_3
    //   204: invokeinterface 239 1 0
    //   209: checkcast 904	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey
    //   212: astore 7
    //   214: aload 7
    //   216: getfield 907	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_fromPubUin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   219: invokevirtual 301	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   222: lstore_1
    //   223: aload 7
    //   225: getfield 910	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_qwMsgId	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   228: invokevirtual 301	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   231: lstore 5
    //   233: lload_1
    //   234: invokestatic 912	java/lang/Long:toString	(J)Ljava/lang/String;
    //   237: astore 7
    //   239: aload_0
    //   240: getfield 78	com/tencent/mobileqq/app/PublicAccountHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: invokevirtual 346	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   246: aload 7
    //   248: sipush 1008
    //   251: aconst_null
    //   252: invokevirtual 915	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I[I)Ljava/util/List;
    //   255: invokeinterface 230 1 0
    //   260: astore 8
    //   262: aload 8
    //   264: invokeinterface 235 1 0
    //   269: ifeq -75 -> 194
    //   272: aload 8
    //   274: invokeinterface 239 1 0
    //   279: checkcast 917	com/tencent/mobileqq/data/MessageRecord
    //   282: astore 9
    //   284: aload 9
    //   286: invokestatic 922	com/tencent/mobileqq/activity/aio/XMLMessageUtils:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/PAMessage;
    //   289: astore 10
    //   291: aload 10
    //   293: ifnull +37 -> 330
    //   296: aload 10
    //   298: getfield 927	com/tencent/mobileqq/data/PAMessage:mMsgId	J
    //   301: lload 5
    //   303: lcmp
    //   304: ifne +26 -> 330
    //   307: aload_0
    //   308: getfield 78	com/tencent/mobileqq/app/PublicAccountHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   311: invokevirtual 346	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   314: aload 7
    //   316: sipush 1008
    //   319: aload 9
    //   321: getfield 930	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   324: invokevirtual 933	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)V
    //   327: goto -133 -> 194
    //   330: aload 9
    //   332: ldc_w 935
    //   335: invokevirtual 938	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   338: astore 10
    //   340: aload 10
    //   342: ifnull -80 -> 262
    //   345: aload 10
    //   347: invokestatic 291	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   350: lload 5
    //   352: lcmp
    //   353: ifne -91 -> 262
    //   356: aload_0
    //   357: getfield 78	com/tencent/mobileqq/app/PublicAccountHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   360: invokevirtual 346	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   363: aload 7
    //   365: sipush 1008
    //   368: aload 9
    //   370: getfield 930	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   373: invokevirtual 933	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)V
    //   376: goto -182 -> 194
    //   379: astore 9
    //   381: goto -119 -> 262
    //   384: astore_3
    //   385: return
    //   386: astore_3
    //   387: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	PublicAccountHandler
    //   0	388	1	paramLong	long
    //   0	388	3	paramArrayOfByte	byte[]
    //   87	60	4	i	int
    //   231	120	5	l	long
    //   171	193	7	localObject1	Object
    //   260	13	8	localIterator	Iterator
    //   282	87	9	localMessageRecord	com.tencent.mobileqq.data.MessageRecord
    //   379	1	9	localException	Exception
    //   289	57	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   345	376	379	java/lang/Exception
    //   65	122	384	java/lang/Exception
    //   128	142	384	java/lang/Exception
    //   149	163	384	java/lang/Exception
    //   164	194	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   194	262	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   262	291	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   296	327	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   330	340	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   345	376	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = (byte[])paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "<<---onReceive " + str);
    }
    if (str.equals("get_follow_list")) {
      c(paramIntent, paramFromServiceMsg, arrayOfByte);
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (str.equals("secmsg.configs"));
        if (str.equals("get_business_recommend"))
        {
          b(paramIntent, paramFromServiceMsg, arrayOfByte);
          return;
        }
        if (str.equals("send_pre_message_status"))
        {
          a(paramIntent, paramFromServiceMsg, arrayOfByte);
          return;
        }
        if (str.equals("pull_aio_history_msg"))
        {
          d(paramIntent, paramFromServiceMsg, paramObject);
          return;
        }
      } while (str.equals("pull_account_detail_dynamic_list"));
      if (str.equals("PubAccountSvc.net_connect_info"))
      {
        PublicAccountWebReport.handlereportPublicAccountNetInfoResponse(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
      if (TextUtils.equals(str, "set_message_configuration"))
      {
        b(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!TextUtils.equals(str, "getGuideFriends"));
    c(paramIntent, paramFromServiceMsg, paramObject);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramIntent = new mobileqq_mp.SendPreMessageStatusResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((!paramIntent.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
          break label177;
        }
        i = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
        if (i != 0)
        {
          if (!QLog.isColorLevel()) {
            break label176;
          }
          QLog.d("PublicAccountHandler", 2, "handlePreSendMsg error, errcode: " + i);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label176;
        }
        QLog.d("PublicAccountHandler", 2, "handlePreSendMsg success: package size is " + paramArrayOfByte.length + " Byte");
        return;
      }
      catch (Exception paramIntent)
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "handlePreSendMsg  failed!");
      }
      label176:
      return;
      label177:
      int i = -1;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {}
    for (;;)
    {
      return;
      paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
      if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {
        continue;
      }
      if ("PubAccountSvc.ReportLbs".equalsIgnoreCase(paramToServiceMsg))
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
          continue;
        }
        return;
      }
      if ((!"QQWeatherReport.getWeatherInfo".equals(paramToServiceMsg)) || (!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
        continue;
      }
      paramToServiceMsg = new WeatherReportInfo.GetWeatherMessageRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        label84:
        if (paramToServiceMsg == null) {
          continue;
        }
        int i = paramToServiceMsg.cmd.get();
        paramToServiceMsg = paramToServiceMsg.string_msg.get();
        if ((i == 1) || (i == 2))
        {
          paramFromServiceMsg = (PublicAccountHandler.IWeatherInfoListener)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.a(paramToServiceMsg);
          }
          this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PublicAccountHandler", 2, "type = " + i + " msg =" + paramToServiceMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        break label84;
      }
    }
  }
  
  public void a(Object paramObject)
  {
    zrc localzrc = new zrc();
    localzrc.jdField_a_of_type_Int = 0;
    long l = SystemClock.uptimeMillis();
    Object localObject = (PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if ((paramObject instanceof AccountDetail))
    {
      localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l);
      ((PublicAccountDataManager)localObject).a((AccountDetail)paramObject);
      ((PublicAccountDataManager)localObject).a(localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      TroopBarAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountDataManager)localObject).a());
      if ((paramObject instanceof AccountDetail)) {
        ServiceAccountFolderManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
      }
      localObject = (EcShopAssistantManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
      if (localObject != null) {
        if (localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) {
          break label183;
        }
      }
    }
    label183:
    for (paramObject = null;; paramObject = localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin())
    {
      ((EcShopAssistantManager)localObject).a(paramObject, "onFollow");
      a(101, true, localzrc);
      return;
      if (!(paramObject instanceof EqqDetail)) {
        break;
      }
      localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l);
      break;
    }
  }
  
  public void a(String paramString1, double paramDouble1, double paramDouble2, String paramString2)
  {
    try
    {
      long l = Long.valueOf(paramString1).longValue();
      paramString1 = new mobileqq_mp.SendLBSInfoRequest();
      paramString1.luin.set(l);
      paramString1.latitude.set(paramDouble1);
      paramString1.longitude.set(paramDouble2);
      paramString1.cityinfo.set(paramString2);
      paramString2 = a("PubAccountSvc.ReportLbs");
      paramString2.putWupBuffer(paramString1.toByteArray());
      b(paramString2);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    a(paramString, paramLong, paramInt, null);
  }
  
  public void a(String paramString, long paramLong, int paramInt, BusinessObserver paramBusinessObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "pull_aio_history_msg");
    historyMsg.AioHistoryMsgRequest localAioHistoryMsgRequest = new historyMsg.AioHistoryMsgRequest();
    localAioHistoryMsgRequest.puin.set(Long.parseLong(paramString));
    localAioHistoryMsgRequest.msg_id.set(paramLong);
    localAioHistoryMsgRequest.msg_cnt.set(paramInt);
    localNewIntent.putExtra("data", localAioHistoryMsgRequest.toByteArray());
    if (paramBusinessObserver != null) {
      localNewIntent.setObserver(paramBusinessObserver);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006502", "0X8006502", 0, 0, "", "", "", "");
      return;
      PublicAccountServlet.a(localNewIntent);
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    a(103, true, null);
  }
  
  public void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      i = paramIntent.getIntExtra("kandian_seq", 0);
      if (!bool1) {
        break label175;
      }
      paramIntent = new mobileqq_mp.SetMessageConfigurationResponse();
    }
    label175:
    for (;;)
    {
      try
      {
        paramIntent.mergeFrom((byte[])paramObject);
        bool1 = bool2;
        if (paramIntent.ret_info.has())
        {
          bool1 = bool2;
          if (paramIntent.ret_info.ret_code.has())
          {
            j = paramIntent.ret_info.ret_code.get();
            if (j != 0) {
              continue;
            }
            bool1 = true;
          }
        }
      }
      catch (Exception paramIntent)
      {
        int j;
        QLog.d("PublicAccountHandler", 1, "handleKandianSubscribe fail:", paramIntent);
        bool1 = bool2;
        continue;
      }
      a(108, bool1, Integer.valueOf(i));
      return;
      bool1 = false;
      break;
      QLog.d("PublicAccountHandler", 1, "handleKandianSubscribe fail code:" + j);
      bool1 = bool2;
    }
  }
  
  public void b(Object paramObject)
  {
    zrc localzrc = new zrc();
    localzrc.jdField_a_of_type_Int = 0;
    long l = SystemClock.uptimeMillis();
    Object localObject = (PublicAccountDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    if ((paramObject instanceof AccountDetail))
    {
      localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l);
      ((PublicAccountDataManager)localObject).b((AccountDetail)paramObject);
      ((PublicAccountDataManager)localObject).b(localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      if ((paramObject instanceof EqqDetail))
      {
        EqqDetailDataManager localEqqDetailDataManager = (EqqDetailDataManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(68);
        if (localEqqDetailDataManager != null) {
          localEqqDetailDataManager.b((EqqDetail)paramObject);
        }
      }
      TroopBarAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountDataManager)localObject).a());
      if ((paramObject instanceof AccountDetail)) {
        ServiceAccountFolderManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
      }
      localObject = (EcShopAssistantManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
      if (localObject != null) {
        if (localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) {
          break label218;
        }
      }
    }
    label218:
    for (paramObject = null;; paramObject = localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin())
    {
      ((EcShopAssistantManager)localObject).a(paramObject, "onUnfollow");
      a(102, true, localzrc);
      return;
      if (!(paramObject instanceof EqqDetail)) {
        break;
      }
      localzrc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l);
      break;
    }
  }
  
  public void c()
  {
    this.d = false;
  }
  
  /* Error */
  public void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: new 1125	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 1126	java/util/ArrayList:<init>	()V
    //   13: astore 8
    //   15: aload_2
    //   16: invokevirtual 420	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +161 -> 180
    //   22: aload_3
    //   23: ifnull +157 -> 180
    //   26: iconst_1
    //   27: istore 5
    //   29: iload 5
    //   31: ifeq +194 -> 225
    //   34: new 1128	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody
    //   37: dup
    //   38: invokespecial 1129	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:<init>	()V
    //   41: astore_1
    //   42: aload_1
    //   43: aload_3
    //   44: checkcast 944	[B
    //   47: checkcast 944	[B
    //   50: invokevirtual 1130	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   53: pop
    //   54: iload 7
    //   56: istore 5
    //   58: aload_1
    //   59: getfield 1133	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:ret_info	Lcom/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo;
    //   62: invokevirtual 1136	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo:has	()Z
    //   65: ifeq +136 -> 201
    //   68: aload_1
    //   69: getfield 1133	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:ret_info	Lcom/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo;
    //   72: getfield 1137	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   75: invokevirtual 316	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   78: istore 4
    //   80: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +27 -> 110
    //   86: ldc 68
    //   88: iconst_1
    //   89: iconst_2
    //   90: anewarray 806	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: ldc_w 1139
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload 4
    //   103: invokestatic 809	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: invokestatic 1142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   110: iload 7
    //   112: istore 5
    //   114: iload 4
    //   116: ifne +85 -> 201
    //   119: aload_1
    //   120: getfield 1145	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:rpt_msg_uin_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   123: invokevirtual 1146	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   126: ifne +93 -> 219
    //   129: iconst_0
    //   130: istore 4
    //   132: iload 4
    //   134: aload_1
    //   135: getfield 1145	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:rpt_msg_uin_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   138: invokevirtual 1149	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   141: if_icmpge +78 -> 219
    //   144: aload 8
    //   146: aload_1
    //   147: getfield 1145	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:rpt_msg_uin_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   150: iload 4
    //   152: invokevirtual 1152	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   155: checkcast 1154	com/tencent/mobileqq/biuGuide/SSOBiuGuide$UinInfo
    //   158: getfield 1155	com/tencent/mobileqq/biuGuide/SSOBiuGuide$UinInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   161: invokevirtual 301	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   164: invokestatic 1158	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   167: invokevirtual 1161	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   170: pop
    //   171: iload 4
    //   173: iconst_1
    //   174: iadd
    //   175: istore 4
    //   177: goto -45 -> 132
    //   180: iconst_0
    //   181: istore 5
    //   183: goto -154 -> 29
    //   186: astore_1
    //   187: iload 6
    //   189: istore 5
    //   191: ldc 68
    //   193: iconst_1
    //   194: ldc_w 1163
    //   197: aload_1
    //   198: invokestatic 1112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload_0
    //   202: bipush 110
    //   204: iload 5
    //   206: aload 8
    //   208: invokevirtual 380	com/tencent/mobileqq/app/PublicAccountHandler:a	(IZLjava/lang/Object;)V
    //   211: return
    //   212: astore_1
    //   213: iconst_1
    //   214: istore 5
    //   216: goto -25 -> 191
    //   219: iconst_1
    //   220: istore 5
    //   222: goto -21 -> 201
    //   225: goto -24 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	PublicAccountHandler
    //   0	228	1	paramIntent	Intent
    //   0	228	2	paramFromServiceMsg	FromServiceMsg
    //   0	228	3	paramObject	Object
    //   78	98	4	i	int
    //   27	194	5	bool1	boolean
    //   4	184	6	bool2	boolean
    //   1	110	7	bool3	boolean
    //   13	194	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   42	54	186	java/lang/Exception
    //   58	110	186	java/lang/Exception
    //   119	129	212	java/lang/Exception
    //   132	171	212	java/lang/Exception
  }
  
  public void d()
  {
    b(0L);
    a(0L);
  }
  
  public void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    int k = 0;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "handleAIOHistoryMsg onReceive :" + bool);
      }
      if (!bool) {}
    }
    for (;;)
    {
      int j;
      try
      {
        paramFromServiceMsg = new historyMsg.AioHistoryMsgResponse();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        j = paramFromServiceMsg.ret_info.ret_code.get();
        if (j != 0) {
          break label385;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountHandler", 2, "result: " + j);
        }
        if (paramFromServiceMsg.msg_infos.has()) {
          break label363;
        }
        j = 2;
        a(105, true, Integer.valueOf(j));
        if ((i == 0) || (!paramFromServiceMsg.msg_infos.has()) || (!paramFromServiceMsg.puin.has())) {
          break label378;
        }
        l = paramFromServiceMsg.puin.get();
        paramIntent = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.msg_infos.get();
        if (paramFromServiceMsg == null) {
          i = 0;
        } else {
          i = paramFromServiceMsg.size();
        }
      }
      catch (Exception paramIntent)
      {
        long l;
        msg_comm.Msg localMsg;
        if (!QLog.isColorLevel()) {
          break label378;
        }
      }
      if (j < i)
      {
        paramObject = ((ByteStringMicro)paramFromServiceMsg.get(j)).toByteArray();
        localMsg = new msg_comm.Msg();
        localMsg.mergeFrom(Base64Util.decode(paramObject, 0));
        paramIntent.add(localMsg);
        j += 1;
      }
      else if ((paramIntent != null) && (paramIntent.size() != 0))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Long = l;
        new DynamicMsgProcessor(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(l, paramIntent);
        return;
        QLog.e("PublicAccountHandler", 2, "handleGetRecommendList onReceive fail: ", paramIntent);
        return;
        a(105, true, Integer.valueOf(1));
        return;
        label363:
        j = 0;
        continue;
        j = k;
        if (i > 0) {}
      }
      else
      {
        label378:
        return;
        bool = false;
        break;
        label385:
        i = 0;
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler
 * JD-Core Version:    0.7.0.1
 */