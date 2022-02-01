package com.tencent.mobileqq.app;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowListReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowListRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetail.jce.GetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.DynamicMsgProcessor;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.api.IPublicAccountStQWebServlet;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertUtil;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.biz.subscribe.servlet.CertifiedAccountAbstractServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageReq;
import com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageRsp;
import com.tencent.jungle.weather.WeatherReportInfo.PbReqMsgHead;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.mp.historyMsg.AioHistoryMsgRequest;
import com.tencent.mobileqq.mp.historyMsg.AioHistoryMsgResponse;
import com.tencent.mobileqq.mp.historyMsg.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationResponse;
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
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.vaswebviewplugin.PublicAccountWebReport;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
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
import mqq.app.AppActivity;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.FollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspFollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspTypeList;

public class PublicAccountHandler
  extends BusinessHandler
{
  public static String a;
  public static long b;
  public static String b;
  public static long c;
  public long a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public List<UinPair> a;
  private Map<Integer, PublicAccountHandler.IWeatherInfoListener> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_Long = 0L;
    c = 0L;
    jdField_b_of_type_JavaLangString = "";
  }
  
  PublicAccountHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "getUserFollowList() isNewProtocol: " + paramBoolean2 + "   followSeqNo: " + paramLong1 + "   publicAccountSeqNo: " + paramLong2);
    }
    Object localObject;
    if (paramBoolean2)
    {
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountStQWebServlet.class));
      localNewIntent.putExtra("cmd", "CertifiedAccountSvc.certified_account_read.GetFollowList");
      localObject = new CertifiedAccountRead.StGetFollowListReq();
      ((CertifiedAccountRead.StGetFollowListReq)localObject).seq.set(Utils.a(paramLong1));
      ((CertifiedAccountRead.StGetFollowListReq)localObject).count.set(Utils.a(paramLong4));
      if (!TextUtils.isEmpty(paramString)) {
        ((CertifiedAccountRead.StGetFollowListReq)localObject).attach_info.set(paramString);
      }
      paramString = new PROTOCAL.StQWebReq();
      paramString.Seq.set(-1L);
      paramString.qua.set(QUA.getQUA3());
      paramString.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
      paramString.busiBuff.set(ByteStringMicro.copyFrom(((CertifiedAccountRead.StGetFollowListReq)localObject).toByteArray()));
      String str = CertifiedAccountAbstractServlet.a();
      if (!TextUtils.isEmpty(str)) {
        paramString.traceid.set(str);
      }
      localObject = paramString.toByteArray();
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new byte[4];
      }
      localNewIntent.putExtra("traceid", str);
      localNewIntent.putExtra("data", paramString);
      localNewIntent.putExtra("get_user_follow_list_begin", paramLong3);
      localNewIntent.putExtra("get_user_follow_list_follow_seq", paramLong1);
      localNewIntent.putExtra("get_user_follow_list_data_seq", paramLong2);
      localNewIntent.putExtra("time_stamp", paramLong5);
      localNewIntent.putExtra("get_user_follow_list_is_increment", paramBoolean1);
      ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler(localNewIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    }
    for (;;)
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "getUserFollowList");
      }
      paramString = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), PublicAccountServletImpl.class);
      paramString.putExtra("cmd", "get_follow_list");
      localObject = new mobileqq_mp.GetUserFollowListRequest();
      ((mobileqq_mp.GetUserFollowListRequest)localObject).follow_seqno.set(Utils.a(paramLong1));
      ((mobileqq_mp.GetUserFollowListRequest)localObject).public_account_seqno.set(Utils.a(paramLong2));
      ((mobileqq_mp.GetUserFollowListRequest)localObject).begin.set(Utils.a(paramLong3));
      ((mobileqq_mp.GetUserFollowListRequest)localObject).limit.set(Utils.a(paramLong4));
      ((mobileqq_mp.GetUserFollowListRequest)localObject).version.set(1);
      ((mobileqq_mp.GetUserFollowListRequest)localObject).is_increment.set(paramBoolean1);
      paramString.putExtra("data", ((mobileqq_mp.GetUserFollowListRequest)localObject).toByteArray());
      paramString.putExtra("get_user_follow_list_begin", paramLong3);
      paramString.putExtra("get_user_follow_list_follow_seq", paramLong1);
      paramString.putExtra("get_user_follow_list_data_seq", paramLong2);
      paramString.putExtra("time_stamp", paramLong5);
      paramString.putExtra("get_user_follow_list_is_increment", paramBoolean1);
      ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler(paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
    }
  }
  
  private long a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (paramBoolean) {}
    for (String str = "NewProtocolPublicAccountFollowSeq2";; str = "PublicAccountFollowSeq2") {
      return localSharedPreferences.getLong(str, 0L);
    }
  }
  
  private String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("NewProtocolGetFollowListAttachInfo", "");
  }
  
  private void a(int paramInt)
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicAccountHandler.5(this, 0, true, true, 60000L, true, false, "PublicAccountHandler", paramInt));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, SosoLbsInfo paramSosoLbsInfo)
  {
    j = 0;
    i = j;
    if (paramSosoLbsInfo != null)
    {
      i = j;
      if (paramSosoLbsInfo.mLocation == null) {}
    }
    try
    {
      i = Integer.parseInt(paramSosoLbsInfo.mLocation.cityCode);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "LocalInfo" + i);
      }
      localObject1 = "8.5.5".replaceAll("\\.", "");
      paramSosoLbsInfo = new WeatherReportInfo.PbReqMsgHead();
      paramSosoLbsInfo.uint32_platform_type.set(1);
      paramSosoLbsInfo.uint32_version.set(Integer.parseInt((String)localObject1));
      localGetWeatherMessageReq = new WeatherReportInfo.GetWeatherMessageReq();
      localGetWeatherMessageReq.pbReqMsgHead.set(paramSosoLbsInfo);
      localGetWeatherMessageReq.uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
      localGetWeatherMessageReq.lat.set(paramInt2);
      localGetWeatherMessageReq.lng.set(paramInt3);
      localGetWeatherMessageReq.fore_flag.set(0);
      localGetWeatherMessageReq.area_id.set(paramInt4);
      localGetWeatherMessageReq.adcode_from_mapsdk.set(i);
      try
      {
        paramSosoLbsInfo = new JSONObject();
        if (paramInt1 != 0) {
          break label414;
        }
        localGetWeatherMessageReq.source.set(2);
      }
      catch (JSONException paramSosoLbsInfo)
      {
        for (;;)
        {
          Object localObject2;
          InetAddress localInetAddress;
          paramSosoLbsInfo.printStackTrace();
          continue;
          paramSosoLbsInfo.put("cmd", paramInt1);
          localGetWeatherMessageReq.source.set(0);
          continue;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            i = j;
            try
            {
              paramSosoLbsInfo = ((String)localObject1).split(Pattern.quote("."));
              i = j;
              int m = paramSosoLbsInfo.length;
              int k = 0;
              int n;
              for (i = 0;; i = j | n)
              {
                j = i;
                if (k >= m) {
                  break;
                }
                localObject2 = paramSosoLbsInfo[k];
                j = i << 8;
                i = j;
                n = Integer.parseInt((String)localObject2);
                k += 1;
              }
              localGetWeatherMessageReq.ip.set(j);
            }
            catch (Exception paramSosoLbsInfo)
            {
              paramSosoLbsInfo.printStackTrace();
              j = i;
              jdField_a_of_type_JavaLangString = (String)localObject1;
            }
          }
          for (;;)
          {
            paramSosoLbsInfo = createToServiceMsg("QQWeatherReport.getWeatherInfo");
            paramSosoLbsInfo.putWupBuffer(localGetWeatherMessageReq.toByteArray());
            sendPbReq(paramSosoLbsInfo);
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountHandler", 2, String.format("send tianqi lat=%d, lng=%d, type=%d, areaid = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt4) }));
            }
            return;
            j = 0;
          }
        }
      }
      paramSosoLbsInfo.put("platform", 109);
      paramSosoLbsInfo.put("version", "8.5.5");
      localObject1 = paramSosoLbsInfo.toString();
      localObject2 = localGetWeatherMessageReq.extra;
      paramSosoLbsInfo = (SosoLbsInfo)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramSosoLbsInfo = "";
      }
      ((PBStringField)localObject2).set(paramSosoLbsInfo);
      j = 0;
      paramSosoLbsInfo = jdField_a_of_type_JavaLangString;
      localObject1 = paramSosoLbsInfo;
      if (!TextUtils.isEmpty(paramSosoLbsInfo)) {}
    }
    catch (Throwable paramSosoLbsInfo)
    {
      for (;;)
      {
        try
        {
          localObject2 = NetworkInterface.getNetworkInterfaces();
          localObject1 = paramSosoLbsInfo;
          if (!((Enumeration)localObject2).hasMoreElements()) {
            break label473;
          }
          localObject1 = ((NetworkInterface)((Enumeration)localObject2).nextElement()).getInetAddresses();
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break label674;
          }
          localInetAddress = (InetAddress)((Enumeration)localObject1).nextElement();
          if ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address))) {
            continue;
          }
          paramSosoLbsInfo = localInetAddress.getHostAddress().toString();
          continue;
          paramSosoLbsInfo = paramSosoLbsInfo;
          if (QLog.isColorLevel()) {
            QLog.e("PublicAccountHandler", 2, paramSosoLbsInfo, new Object[0]);
          }
          i = 0;
        }
        catch (Exception paramSosoLbsInfo)
        {
          label414:
          localObject1 = "";
          paramSosoLbsInfo.printStackTrace();
        }
        if (paramInt1 != -1) {
          continue;
        }
        localGetWeatherMessageReq.source.set(1);
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "handleGetUserFollowList time:  " + paramLong1 + "  begin: " + paramLong2 + "  preFollowSeq: " + paramLong3 + "  preDataSeq: " + paramLong4);
    }
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    if (paramBoolean) {}
    for (String str = "NewProtocolPublicAccountFollowSeq2";; str = "PublicAccountFollowSeq2")
    {
      localEditor.putLong(str, paramLong);
      localEditor.commit();
      return;
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    PublicAccountObserver.GetUserFollowListRet localGetUserFollowListRet = new PublicAccountObserver.GetUserFollowListRet();
    boolean bool3 = true;
    boolean bool1 = false;
    if (a(paramIntent, paramFromServiceMsg)) {
      return;
    }
    long l1;
    long l2;
    long l3;
    long l4;
    boolean bool4;
    int i;
    label397:
    label416:
    label442:
    long l5;
    if (a(paramIntent, paramFromServiceMsg, paramArrayOfByte))
    {
      localGetUserFollowListRet.jdField_a_of_type_Int = 0;
      l1 = paramIntent.getLongExtra("time_stamp", 0L);
      l2 = paramIntent.getLongExtra("get_user_follow_list_begin", 0L);
      l3 = paramIntent.getLongExtra("get_user_follow_list_follow_seq", 0L);
      l4 = paramIntent.getLongExtra("get_user_follow_list_data_seq", 0L);
      bool4 = paramIntent.getBooleanExtra("get_user_follow_list_is_increment", true);
      a(l1, l2, l3, l4);
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          paramIntent = new CertifiedAccountRead.StGetFollowListRsp();
          paramIntent.mergeFrom(paramArrayOfByte);
          if (paramIntent.refresh.get() != 1) {
            continue;
          }
          bool1 = true;
          if (paramIntent.has_next.get() != 1) {
            continue;
          }
          bool2 = true;
          l3 = paramIntent.seq.get();
          paramFromServiceMsg = paramIntent.attach_info.get();
          a(bool1, bool2);
          if (!bool1) {
            continue;
          }
          a(0L, 0L, 0L, 20L, SystemClock.uptimeMillis(), false, true, paramFromServiceMsg);
          paramBoolean = false;
          bool1 = false;
          bool2 = bool1;
          bool1 = paramBoolean;
          paramBoolean = bool2;
        }
        catch (Exception paramIntent)
        {
          localGetUserFollowListRet.jdField_a_of_type_Int = -1;
          localGetUserFollowListRet.jdField_a_of_type_Boolean = true;
          paramBoolean = false;
          bool1 = bool3;
          continue;
          i = 0;
          continue;
        }
        a(localGetUserFollowListRet, bool1, paramBoolean, 100);
        return;
        bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        a(paramBoolean, localGetUserFollowListRet, l1, l2, bool4, paramIntent, bool2, l3, paramFromServiceMsg);
        bool1 = true;
        localGetUserFollowListRet.jdField_a_of_type_Int = 0;
        paramBoolean = true;
        continue;
        paramIntent = new mobileqq_mp.GetUserFollowListResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((paramIntent.ret_info.has()) && (((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has()))
        {
          i = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
          localGetUserFollowListRet.jdField_a_of_type_Int = i;
          a(paramIntent, i);
          if (i == 0) {
            break label397;
          }
          localGetUserFollowListRet.jdField_a_of_type_Boolean = true;
          paramBoolean = bool1;
          bool1 = bool3;
        }
        if (!paramIntent.follow_seqno.has()) {
          break label692;
        }
        i = paramIntent.follow_seqno.get();
        l4 = Utils.a(i);
        if (!paramIntent.public_account_seqno.has()) {
          break label698;
        }
        i = paramIntent.public_account_seqno.get();
        l5 = Utils.a(i);
        if ((l4 <= l3) || (l3 == 0L)) {
          break;
        }
        a(l4, l5, 0L, 20L, SystemClock.uptimeMillis(), false, paramBoolean, null);
        bool2 = false;
        paramBoolean = bool1;
        bool1 = bool2;
      }
      if (paramIntent.total_count.has())
      {
        i = paramIntent.total_count.get();
        label517:
        l3 = Utils.a(i);
        paramFromServiceMsg = PublicAccountInfo.createPublicAccountInfoList(paramIntent.info.get(), l1);
        localGetUserFollowListRet.jdField_a_of_type_JavaUtilList = paramFromServiceMsg;
        if (!paramIntent.has_next.has()) {
          break label704;
        }
        if (paramIntent.has_next.get()) {
          break label651;
        }
        break label704;
      }
    }
    for (;;)
    {
      localGetUserFollowListRet.jdField_a_of_type_Boolean = bool1;
      localGetUserFollowListRet.jdField_a_of_type_Long = l3;
      paramIntent = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      a(paramFromServiceMsg, l1, bool4, localGetUserFollowListRet.jdField_a_of_type_Boolean);
      a(paramBoolean, localGetUserFollowListRet, l1, l2, bool4, l4, l5, paramIntent);
      b(l5, paramBoolean);
      paramBoolean = true;
      bool1 = bool3;
      break;
      i = 0;
      break label517;
      label651:
      bool1 = false;
      continue;
      localGetUserFollowListRet.jdField_a_of_type_Int = -1;
      localGetUserFollowListRet.jdField_a_of_type_Boolean = true;
      a("<<---handleGetUserFollowList ", localGetUserFollowListRet.jdField_a_of_type_Int);
      paramBoolean = bool1;
      bool1 = bool3;
      break;
      label692:
      i = 0;
      break label416;
      label698:
      i = 0;
      break label442;
      label704:
      bool1 = true;
    }
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
  
  private void a(PublicAccountObserver.GetUserFollowListRet paramGetUserFollowListRet, PublicAccountDataManager paramPublicAccountDataManager)
  {
    if (paramGetUserFollowListRet.jdField_a_of_type_Boolean)
    {
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPublicAccountDataManager.a());
      ServiceAccountFolderManager.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      TroopBarAssistantManager.a().g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ReadInJoyLogicEngine.a().e();
      paramGetUserFollowListRet = new PublicAccountHandler.FolderRefreshRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPublicAccountDataManager);
      ThreadManager.getSubThreadHandler().postDelayed(paramGetUserFollowListRet, 15000L);
      ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountHandler.3(this), 500L);
    }
  }
  
  private void a(PublicAccountObserver.GetUserFollowListRet paramGetUserFollowListRet, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramBoolean1) {
      notifyUI(paramInt, paramBoolean2, paramGetUserFollowListRet);
    }
  }
  
  private void a(mobileqq_mp.GetUserFollowListResponse paramGetUserFollowListResponse, int paramInt)
  {
    if (QLog.isColorLevel()) {
      if (!paramGetUserFollowListResponse.has_next.has()) {
        break label61;
      }
    }
    label61:
    for (boolean bool = paramGetUserFollowListResponse.has_next.get();; bool = false)
    {
      QLog.d("PublicAccountHandler", 2, "handleGetUserFollowList        errCode: " + paramInt + "    has_next: " + bool);
      return;
    }
  }
  
  private void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    localEditor.putString("NewProtocolGetFollowListAttachInfo", paramString);
    localEditor.commit();
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, paramString + paramInt);
    }
  }
  
  private void a(List<PublicAccountInfo> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(paramList, paramLong, paramBoolean1, paramBoolean2);
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (PublicAccountInfo)((Iterator)localObject1).next();
      localObject2 = paramList.a().b(((PublicAccountInfo)localObject2).getUin(), 1008);
      if (localObject2 == null) {
        break label136;
      }
      paramList.a().a((RecentUser)localObject2);
      i = 1;
    }
    label136:
    for (;;)
    {
      break;
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if ((i != 0) && (paramList != null)) {
        paramList.sendEmptyMessage(1009);
      }
      return;
    }
  }
  
  private void a(SubMsgType0x28.RspFollowList paramRspFollowList)
  {
    int j = 0;
    int i = 0;
    Object localObject = null;
    List localList = paramRspFollowList.rpt_msg_followlist.get();
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Iterator localIterator = localList.iterator();
    paramRspFollowList = (SubMsgType0x28.RspFollowList)localObject;
    if (localIterator.hasNext())
    {
      localObject = (SubMsgType0x28.FollowList)localIterator.next();
      String str;
      if (l == ((SubMsgType0x28.FollowList)localObject).uint64_uin.get())
      {
        str = String.valueOf(((SubMsgType0x28.FollowList)localObject).uint64_puin.get());
        switch (((SubMsgType0x28.FollowList)localObject).uint32_type.get())
        {
        }
      }
      for (;;)
      {
        break;
        PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        localPublicAccountDataManager.b(str);
        localPublicAccountDataManager.a(str);
        paramRspFollowList = new PublicAccountObserver.FollowRet();
        paramRspFollowList.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localPublicAccountDataManager.a(l + "");
        if (((SubMsgType0x28.FollowList)localObject).uint32_disable_cancel_chat.get() != 1) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str, 1008);
        }
        TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPublicAccountDataManager.a());
        ServiceAccountFolderManager.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
        if (localObject != null) {
          ((EcShopAssistantManager)localObject).a(l + "", "pushmsg");
        }
        ReadInJoyLogicEngine.a().b(l, 1);
        j = 1;
        continue;
        a();
        ReadInJoyLogicEngine.a().b(l, 2);
        RIJFeedsInsertUtil.a.a(RIJFeedsInsertUtil.a.a(), str);
        RIJFeedsInsertUtil.a.a(RIJFeedsInsertUtil.a.a());
        i = 1;
      }
    }
    if (j != 0)
    {
      notifyUI(103, true, null);
      notifyUI(102, true, paramRspFollowList);
    }
    if (i != 0) {
      notifyUI(101, true, null);
    }
    boolean bool;
    if (!localList.isEmpty())
    {
      if (((SubMsgType0x28.FollowList)localList.get(0)).uint32_type.get() != 1) {
        break label476;
      }
      bool = true;
      l = ((SubMsgType0x28.FollowList)localList.get(0)).uint64_puin.get();
      ThreadManager.getUIHandler().post(new PublicAccountHandler.1(this, l, bool));
      paramRspFollowList = ReadInJoyLogicEngine.a();
      if (!bool) {
        break label482;
      }
    }
    label476:
    label482:
    for (i = 2;; i = 1)
    {
      paramRspFollowList.c(l, i);
      return;
      bool = false;
      break;
    }
  }
  
  private void a(SubMsgType0x28.RspTypeList paramRspTypeList) {}
  
  private void a(boolean paramBoolean1, PublicAccountObserver.GetUserFollowListRet paramGetUserFollowListRet, long paramLong1, long paramLong2, boolean paramBoolean2, long paramLong3, long paramLong4, PublicAccountDataManager paramPublicAccountDataManager)
  {
    if (paramGetUserFollowListRet.jdField_a_of_type_Boolean)
    {
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPublicAccountDataManager.a());
      ServiceAccountFolderManager.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      TroopBarAssistantManager.a().g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ReadInJoyLogicEngine.a().e();
      paramPublicAccountDataManager = new PublicAccountHandler.FolderRefreshRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPublicAccountDataManager);
      ThreadManager.getSubThreadHandler().postDelayed(paramPublicAccountDataManager, 15000L);
      ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountHandler.2(this), 500L);
    }
    if (!paramGetUserFollowListRet.jdField_a_of_type_Boolean)
    {
      if (paramBoolean2)
      {
        a(paramLong3, paramLong4, 0L, 20L, paramLong1, true, paramBoolean1, null);
        return;
      }
      a(paramLong3, paramLong4, paramLong2 + 20L, 20L, paramLong1, false, paramBoolean1, null);
      return;
    }
    a(paramLong3, paramBoolean1);
  }
  
  private void a(boolean paramBoolean1, PublicAccountObserver.GetUserFollowListRet paramGetUserFollowListRet, long paramLong1, long paramLong2, boolean paramBoolean2, CertifiedAccountRead.StGetFollowListRsp paramStGetFollowListRsp, boolean paramBoolean3, long paramLong3, String paramString)
  {
    paramStGetFollowListRsp = paramStGetFollowListRsp.account_list.get();
    long l = paramStGetFollowListRsp.size();
    paramStGetFollowListRsp = PublicAccountInfo.createPublicAccountInfoListCf8(paramStGetFollowListRsp, paramLong1);
    paramGetUserFollowListRet.jdField_a_of_type_JavaUtilList = paramStGetFollowListRsp;
    if (!paramBoolean3)
    {
      paramBoolean3 = true;
      paramGetUserFollowListRet.jdField_a_of_type_Boolean = paramBoolean3;
      paramGetUserFollowListRet.jdField_a_of_type_Long = l;
      PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      a(paramStGetFollowListRsp, paramLong1, paramBoolean2, paramGetUserFollowListRet.jdField_a_of_type_Boolean);
      a(paramGetUserFollowListRet, localPublicAccountDataManager);
      if (paramGetUserFollowListRet.jdField_a_of_type_Boolean) {
        break label156;
      }
      if (!paramBoolean2) {
        break label131;
      }
      a(paramLong3, 0L, 0L, 20L, paramLong1, true, true, paramString);
    }
    for (;;)
    {
      b(0L, paramBoolean1);
      return;
      paramBoolean3 = false;
      break;
      label131:
      a(paramLong3, 0L, paramLong2 + 20L, 20L, paramLong1, false, true, paramString);
      continue;
      label156:
      a(paramLong3, paramBoolean1);
      a(paramString);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "handleGetUserFollowList      refresh: " + paramBoolean1 + "    has_next: " + paramBoolean2);
    }
  }
  
  private boolean a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFromServiceMsg != null)
    {
      bool1 = bool2;
      if (paramFromServiceMsg.getResultCode() == 2901)
      {
        bool1 = bool2;
        if (paramIntent != null)
        {
          int i = paramIntent.getIntExtra("k_resend_cnt", 0);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountHandler", 2, "handleGetUserFollowListk_resend_cnt" + i);
          }
          bool1 = bool2;
          if (i < 2)
          {
            paramIntent.putExtra("k_resend_cnt", i + 1);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)paramIntent);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    return (paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null);
  }
  
  private long b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (paramBoolean) {}
    for (String str = "NewProtocolPublicAccountDataSeq2";; str = "PublicAccountDataSeq2") {
      return localSharedPreferences.getLong(str, 0L);
    }
  }
  
  private void b(long paramLong, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    if (paramBoolean) {}
    for (String str = "NewProtocolPublicAccountDataSeq2";; str = "PublicAccountDataSeq2")
    {
      localEditor.putLong(str, paramLong);
      localEditor.commit();
      return;
    }
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
          break label186;
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
        ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(paramIntent);
        notifyUI(104, true, null);
        return;
        notifyUI(104, false, null);
        return;
      }
      while (i != 0)
      {
        return;
        label186:
        i = -1;
      }
    }
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new mobileqq_mp.GetMessageConfigurationResponse();
    long l = paramIntent.getLongExtra("uin", 0L);
    QLog.d("PublicAccountHandler", 1, "handleSubscribesStatusResp, uin : " + l);
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((!paramFromServiceMsg.ret_info.has()) || (!paramFromServiceMsg.ret_info.ret_code.has())) {
          continue;
        }
        int i = paramFromServiceMsg.ret_info.ret_code.get();
        if (i == 0)
        {
          if (paramFromServiceMsg.type.has())
          {
            i = paramFromServiceMsg.type.get();
            paramIntent = new HashMap();
            paramIntent.put("uin", Long.valueOf(l));
            paramIntent.put("status", Integer.valueOf(i));
            notifyUI(111, true, paramIntent);
            QLog.d("PublicAccountHandler", 1, "result:" + i);
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.d("PublicAccountHandler", 2, "request Kandian status fail code:" + i);
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        continue;
      }
      notifyUI(111, false, null);
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountHandler", 2, "request Kandian status wrong resp");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountHandler", 2, "request Kandian status fail data null");
        }
      }
    }
  }
  
  public int a()
  {
    boolean bool = PublicAccountConfigUtilImpl.isGetFollowListUseNewProtocol();
    long l1 = a(bool);
    long l2 = b(bool);
    String str = a();
    return a(l1, l2, 0L, 20L, SystemClock.uptimeMillis(), true, bool, str);
  }
  
  public int a(SosoLbsInfo paramSosoLbsInfo)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "get_business_recommend");
    publicaccount_recommend.BusinessRecommendRequest localBusinessRecommendRequest = new publicaccount_recommend.BusinessRecommendRequest();
    localBusinessRecommendRequest.recomend_count.set(20);
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null)) {
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.mLocation == null) || (paramSosoLbsInfo.mLocation.address == null)) {
        break label241;
      }
    }
    label241:
    for (String str = paramSosoLbsInfo.mLocation.address;; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "getRecommendList() latitude=" + paramSosoLbsInfo.mLocation.mLat02 + " longitude=" + paramSosoLbsInfo.mLocation.mLon02 + ", address=" + str);
      }
      localBusinessRecommendRequest.latitude.set(String.valueOf(paramSosoLbsInfo.mLocation.mLat02));
      localBusinessRecommendRequest.longitude.set(String.valueOf(paramSosoLbsInfo.mLocation.mLon02));
      localBusinessRecommendRequest.city_info.set(str);
      localBusinessRecommendRequest.platform.set(109);
      localNewIntent.putExtra("data", localBusinessRecommendRequest.toByteArray());
      ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler(localNewIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return 0;
    }
  }
  
  public void a()
  {
    notifyUI(103, true, null);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new PublicAccountHandler.6(this, "qq_weather", false, paramInt1, paramInt2, paramInt3, paramInt4));
      return;
    }
    a(paramInt1, paramInt2, paramInt3, paramInt4, ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qq_weather"));
  }
  
  /* Error */
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc 58
    //   8: iconst_2
    //   9: new 60	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1081
    //   19: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: l2i
    //   24: invokestatic 1085	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   27: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: lload_1
    //   37: l2i
    //   38: lookupswitch	default:+26->64, 40:+27->65, 63:+126->164
    //   65: new 1087	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   68: dup
    //   69: invokespecial 1088	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:<init>	()V
    //   72: aload_3
    //   73: invokevirtual 1089	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   76: checkcast 1087	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody
    //   79: astore_3
    //   80: aload_3
    //   81: getfield 1092	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   84: invokevirtual 575	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   87: istore 4
    //   89: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +30 -> 122
    //   95: ldc 58
    //   97: iconst_2
    //   98: new 60	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 1094
    //   108: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 4
    //   113: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: iload 4
    //   124: iconst_1
    //   125: if_icmpne +18 -> 143
    //   128: aload_0
    //   129: aload_3
    //   130: getfield 1098	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_followlist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;
    //   133: invokevirtual 1099	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: checkcast 810	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList
    //   139: invokespecial 1101	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspFollowList;)V
    //   142: return
    //   143: iload 4
    //   145: iconst_2
    //   146: if_icmpne -82 -> 64
    //   149: aload_0
    //   150: aload_3
    //   151: getfield 1105	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$MsgBody:msg_rsp_typelist	Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;
    //   154: invokevirtual 1108	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   157: checkcast 1107	tencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList
    //   160: invokespecial 1110	com/tencent/mobileqq/app/PublicAccountHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x28/SubMsgType0x28$RspTypeList;)V
    //   163: return
    //   164: new 1112	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody
    //   167: dup
    //   168: invokespecial 1113	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:<init>	()V
    //   171: astore 7
    //   173: aload 7
    //   175: aload_3
    //   176: invokevirtual 1114	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   179: pop
    //   180: aload 7
    //   182: getfield 1117	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$MsgBody:rpt_msg_pubunikey	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   185: invokevirtual 641	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   188: invokeinterface 771 1 0
    //   193: astore_3
    //   194: aload_3
    //   195: invokeinterface 776 1 0
    //   200: ifeq -136 -> 64
    //   203: aload_3
    //   204: invokeinterface 779 1 0
    //   209: checkcast 1119	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey
    //   212: astore 7
    //   214: aload 7
    //   216: getfield 1122	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_fromPubUin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   219: invokevirtual 824	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   222: lstore_1
    //   223: aload 7
    //   225: getfield 1125	tencent/im/s2c/msgtype0x210/submsgtype0x3f/SubMsgType0x3f$PubUniKey:uint64_qwMsgId	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   228: invokevirtual 824	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   231: lstore 5
    //   233: lload_1
    //   234: invokestatic 1127	java/lang/Long:toString	(J)Ljava/lang/String;
    //   237: astore 7
    //   239: aload_0
    //   240: getfield 47	com/tencent/mobileqq/app/PublicAccountHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: invokevirtual 853	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   246: aload 7
    //   248: sipush 1008
    //   251: aconst_null
    //   252: invokevirtual 1130	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;I[I)Ljava/util/List;
    //   255: invokeinterface 771 1 0
    //   260: astore 8
    //   262: aload 8
    //   264: invokeinterface 776 1 0
    //   269: ifeq -75 -> 194
    //   272: aload 8
    //   274: invokeinterface 779 1 0
    //   279: checkcast 1132	com/tencent/mobileqq/data/MessageRecord
    //   282: astore 9
    //   284: aload 9
    //   286: invokestatic 1137	com/tencent/mobileqq/activity/aio/XMLMessageUtils:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/PAMessage;
    //   289: astore 10
    //   291: aload 10
    //   293: ifnull +37 -> 330
    //   296: aload 10
    //   298: getfield 1142	com/tencent/mobileqq/data/PAMessage:mMsgId	J
    //   301: lload 5
    //   303: lcmp
    //   304: ifne +26 -> 330
    //   307: aload_0
    //   308: getfield 47	com/tencent/mobileqq/app/PublicAccountHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   311: invokevirtual 853	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   314: aload 7
    //   316: sipush 1008
    //   319: aload 9
    //   321: getfield 1145	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   324: invokevirtual 1148	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)V
    //   327: goto -133 -> 194
    //   330: aload 9
    //   332: ldc_w 1150
    //   335: invokevirtual 1153	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   338: astore 10
    //   340: aload 10
    //   342: ifnull -80 -> 262
    //   345: aload 10
    //   347: invokestatic 817	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   350: lload 5
    //   352: lcmp
    //   353: ifne -91 -> 262
    //   356: aload_0
    //   357: getfield 47	com/tencent/mobileqq/app/PublicAccountHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   360: invokevirtual 853	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   363: aload 7
    //   365: sipush 1008
    //   368: aload 9
    //   370: getfield 1145	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   373: invokevirtual 1148	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)V
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
  
  public void a(Context paramContext, int paramInt, PublicAccountHandler.IWeatherInfoListener paramIWeatherInfoListener)
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
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramContext = (AppActivity)paramContext;
      if (paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        paramContext.requestPermissions(new PublicAccountHandler.4(this, paramInt, paramContext), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      a(paramInt);
      return;
    }
    a(paramInt);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {}
    for (;;)
    {
      return;
      long l = paramIntent.getLongExtra("uin", 0L);
      QLog.d("PublicAccountHandler", 1, "handleGetRecvMsgState, uin = " + l + ",resp.isSuccess() = " + paramFromServiceMsg.isSuccess());
      if (paramFromServiceMsg.isSuccess()) {
        try
        {
          paramIntent = Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetRecvMsgStateRsp());
          if ((paramIntent instanceof GetRecvMsgStateRsp))
          {
            paramIntent = (GetRecvMsgStateRsp)paramIntent;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("public_account_detail_setting_status", 0).edit().putInt("setting_result_" + l + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramIntent.result).putInt("setting_status_" + l + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramIntent.state).commit();
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(AccountDetailGroupListContainer.class);
            if (paramIntent != null)
            {
              paramIntent.sendEmptyMessage(1000);
              return;
            }
          }
        }
        catch (Throwable paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = (byte[])paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "<<---onReceive " + str);
    }
    if (str.equals("get_follow_list")) {
      a(paramIntent, paramFromServiceMsg, arrayOfByte, false);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (str.equals("CertifiedAccountSvc.certified_account_read.GetFollowList"))
          {
            a(paramIntent, paramFromServiceMsg, arrayOfByte, true);
            return;
          }
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
      if (TextUtils.equals(str, "getGuideFriends"))
      {
        c(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
      if (TextUtils.equals(str, "get_message_configuration"))
      {
        e(paramIntent, paramFromServiceMsg, paramObject);
        return;
      }
      if (TextUtils.equals(str, "ConfigSvc.getRecvMsgState"))
      {
        a(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!TextUtils.equals(str, "ConfigSvc.setRecvMsgState"));
    a(paramFromServiceMsg);
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
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "handleSetRecvMsgState resp.isSuccess() = " + paramFromServiceMsg.isSuccess());
    }
    if (paramFromServiceMsg == null) {}
    boolean bool;
    do
    {
      return;
      bool = paramFromServiceMsg.isSuccess();
    } while (!bool);
    try
    {
      notifyUI(112, bool, Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new SetRecvMsgStateRsp()));
      return;
    }
    catch (Throwable paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  public void a(Object paramObject)
  {
    PublicAccountObserver.FollowRet localFollowRet = new PublicAccountObserver.FollowRet();
    localFollowRet.jdField_a_of_type_Int = 0;
    long l = SystemClock.uptimeMillis();
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if ((paramObject instanceof AccountDetail))
    {
      localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l);
      ((PublicAccountDataManager)localObject).a((AccountDetail)paramObject);
      ((PublicAccountDataManager)localObject).a(localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountDataManager)localObject).a());
      if (((paramObject instanceof AccountDetail)) && (QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) <= 0)) {
        ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
      }
      localObject = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if (localObject != null) {
        if (localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) {
          break label201;
        }
      }
    }
    label201:
    for (paramObject = null;; paramObject = localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin())
    {
      ((EcShopAssistantManager)localObject).a(paramObject, "onFollow");
      notifyUI(101, true, localFollowRet);
      return;
      if (!(paramObject instanceof EqqDetail)) {
        break;
      }
      localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l);
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
      paramString2 = createToServiceMsg("PubAccountSvc.ReportLbs");
      paramString2.putWupBuffer(paramString1.toByteArray());
      sendPbReq(paramString2);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    a(paramString, paramLong, paramInt, null);
  }
  
  public void a(String paramString, long paramLong, int paramInt, mqq.observer.BusinessObserver paramBusinessObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), PublicAccountServletImpl.class);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006502", "0X8006502", 0, 0, "", "", "", "");
      return;
      ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler(localNewIntent);
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    int i;
    long l;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      i = paramIntent.getIntExtra("kandian_seq", 0);
      l = paramIntent.getLongExtra("uin", 0L);
      if (!bool1) {
        break label253;
      }
      paramIntent = new mobileqq_mp.SetMessageConfigurationResponse();
    }
    label253:
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
      QLog.d("PublicAccountHandler", 1, "handleSetKandianSubscribeStatusRsp: " + l + ", seq : " + i);
      paramIntent = new HashMap();
      paramIntent.put("uin", Long.valueOf(l));
      paramIntent.put("seq", Integer.valueOf(i));
      notifyUI(108, bool1, paramIntent);
      return;
      bool1 = false;
      break;
      QLog.d("PublicAccountHandler", 1, "handleKandianSubscribe fail code:" + j);
      bool1 = bool2;
    }
  }
  
  public void b(Object paramObject)
  {
    PublicAccountObserver.FollowRet localFollowRet = new PublicAccountObserver.FollowRet();
    localFollowRet.jdField_a_of_type_Int = 0;
    long l = SystemClock.uptimeMillis();
    Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if ((paramObject instanceof AccountDetail))
    {
      localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((AccountDetail)paramObject, l);
      ((PublicAccountDataManager)localObject).b((AccountDetail)paramObject);
      ((PublicAccountDataManager)localObject).b(localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
      if ((paramObject instanceof EqqDetail))
      {
        EqqDetailDataManager localEqqDetailDataManager = (EqqDetailDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
        if (localEqqDetailDataManager != null) {
          localEqqDetailDataManager.b((EqqDetail)paramObject);
        }
      }
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountDataManager)localObject).a());
      if ((paramObject instanceof AccountDetail)) {
        ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
      }
      localObject = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      if (localObject != null) {
        if (localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) {
          break label221;
        }
      }
    }
    label221:
    for (paramObject = null;; paramObject = localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin())
    {
      ((EcShopAssistantManager)localObject).a(paramObject, "onUnfollow");
      notifyUI(102, true, localFollowRet);
      return;
      if (!(paramObject instanceof EqqDetail)) {
        break;
      }
      localFollowRet.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l);
      break;
    }
  }
  
  public void c()
  {
    b(0L, true);
    b(0L, false);
    a(0L, true);
    a(0L, false);
    a("");
  }
  
  /* Error */
  public void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: new 1413	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 1414	java/util/ArrayList:<init>	()V
    //   13: astore 8
    //   15: aload_2
    //   16: invokevirtual 942	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +161 -> 180
    //   22: aload_3
    //   23: ifnull +157 -> 180
    //   26: iconst_1
    //   27: istore 5
    //   29: iload 5
    //   31: ifeq +194 -> 225
    //   34: new 1416	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody
    //   37: dup
    //   38: invokespecial 1417	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:<init>	()V
    //   41: astore_1
    //   42: aload_1
    //   43: aload_3
    //   44: checkcast 987	[B
    //   47: checkcast 987	[B
    //   50: invokevirtual 1418	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   53: pop
    //   54: iload 7
    //   56: istore 5
    //   58: aload_1
    //   59: getfield 1421	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:ret_info	Lcom/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo;
    //   62: invokevirtual 1424	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo:has	()Z
    //   65: ifeq +136 -> 201
    //   68: aload_1
    //   69: getfield 1421	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:ret_info	Lcom/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo;
    //   72: getfield 1425	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   75: invokevirtual 575	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   78: istore 4
    //   80: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +27 -> 110
    //   86: ldc 58
    //   88: iconst_1
    //   89: iconst_2
    //   90: anewarray 465	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: ldc_w 1427
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload 4
    //   103: invokestatic 510	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: invokestatic 1430	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   110: iload 7
    //   112: istore 5
    //   114: iload 4
    //   116: ifne +85 -> 201
    //   119: aload_1
    //   120: getfield 1433	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:rpt_msg_uin_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   123: invokevirtual 1434	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   126: ifne +93 -> 219
    //   129: iconst_0
    //   130: istore 4
    //   132: iload 4
    //   134: aload_1
    //   135: getfield 1433	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:rpt_msg_uin_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   138: invokevirtual 1435	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   141: if_icmpge +78 -> 219
    //   144: aload 8
    //   146: aload_1
    //   147: getfield 1433	com/tencent/mobileqq/biuGuide/SSOBiuGuide$RspBody:rpt_msg_uin_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   150: iload 4
    //   152: invokevirtual 1438	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   155: checkcast 1440	com/tencent/mobileqq/biuGuide/SSOBiuGuide$UinInfo
    //   158: getfield 1441	com/tencent/mobileqq/biuGuide/SSOBiuGuide$UinInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   161: invokevirtual 824	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   164: invokestatic 995	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   167: invokevirtual 1444	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   191: ldc 58
    //   193: iconst_1
    //   194: ldc_w 1446
    //   197: aload_1
    //   198: invokestatic 1397	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload_0
    //   202: bipush 110
    //   204: iload 5
    //   206: aload 8
    //   208: invokevirtual 750	com/tencent/mobileqq/app/PublicAccountHandler:notifyUI	(IZLjava/lang/Object;)V
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
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
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
        notifyUI(105, true, Integer.valueOf(j));
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
        new DynamicMsgProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler()).a(l, paramIntent);
        return;
        QLog.e("PublicAccountHandler", 2, "handleGetRecommendList onReceive fail: ", paramIntent);
        return;
        notifyUI(105, true, Integer.valueOf(1));
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return PublicAccountObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler
 * JD-Core Version:    0.7.0.1
 */