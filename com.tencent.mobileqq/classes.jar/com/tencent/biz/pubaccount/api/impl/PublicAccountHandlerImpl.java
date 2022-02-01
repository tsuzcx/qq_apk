package com.tencent.biz.pubaccount.api.impl;

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
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.jce.GetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.accountdetail.jce.SetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountDynamicMsgProcessor;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler.IWeatherInfoListener;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.FollowRet;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.GetUserFollowListRet;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.api.IPublicAccountStQWebServlet;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.biz.subscribe.servlet.CertifiedAccountAbstractServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageReq;
import com.tencent.jungle.weather.WeatherReportInfo.GetWeatherMessageRsp;
import com.tencent.jungle.weather.WeatherReportInfo.PbReqMsgHead;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.biuGuide.SSOBiuGuide.RetInfo;
import com.tencent.mobileqq.biuGuide.SSOBiuGuide.RspBody;
import com.tencent.mobileqq.biuGuide.SSOBiuGuide.UinInfo;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
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
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspFollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.RspTypeList;
import tencent.im.s2c.msgtype0x210.submsgtype0x3f.SubMsgType0x3f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3f.SubMsgType0x3f.PubUniKey;

public class PublicAccountHandlerImpl
  extends BusinessHandler
  implements IPublicAccountHandler
{
  private static final String ARG_GET_FOLLOW_LIST_BEGIN = "get_user_follow_list_begin";
  private static final String ARG_GET_FOLLOW_LIST_DATA_SEQ = "get_user_follow_list_data_seq";
  private static final String ARG_GET_FOLLOW_LIST_FOLLOW_SEQ = "get_user_follow_list_follow_seq";
  private static final String ARG_GET_FOLLOW_LIST_IS_INCREMENT = "get_user_follow_list_is_increment";
  private static final String ARG_TIME_STAMP = "time_stamp";
  public static final String CMD_PUBLICACCOUNT_SVC_SEND_LBS = "PubAccountSvc.ReportLbs";
  public static final String CMD_PUBLICACCOUNT_WEATHER_INFO = "QQWeatherReport.getWeatherInfo";
  private static final int GET_USER_FOLLOW_LIST_LIMIT = 20;
  private static final String INDEX_DATA_SEQ = "PublicAccountDataSeq2";
  private static final String INDEX_FOLLOW_SEQ = "PublicAccountFollowSeq2";
  public static final String KEY_AIO_TIME = "aio_time";
  public static final String KEY_LIST_TIME = "list_time";
  public static final String KEY_LOCATION_TIME = "location_time";
  public static final String KEY_LOC_LAT = "loc_lat";
  public static final String KEY_LOC_LNG = "loc_lng";
  public static final String KEY_SETTING_RESULT_PRE = "setting_result_";
  public static final String KEY_SETTING_STATUS_PRE = "setting_status_";
  private static final String NAME_SEARCH_SWITCH = "PublicAccount_SearchSwitch";
  private static final String NAME_TOTAL_SWITCH = "PublicAccount_TotalSwitch";
  private static final String NEW_PROTOCOL_INDEX_DATA_SEQ = "NewProtocolPublicAccountDataSeq2";
  private static final String NEW_PROTOCOL_INDEX_FOLLOW_SEQ = "NewProtocolPublicAccountFollowSeq2";
  private static final String PREF_KEY_GET_FOLLOW_LIST_NEW_PROTOCOL_ATTACH_INFO = "NewProtocolGetFollowListAttachInfo";
  public static final String PREF_KEY_SETTING_STATUS_PREFIX = "public_account_detail_setting_status";
  private static final int STATUS_FOLLOW = 1;
  private static final int STATUS_INVALID = 3;
  private static final int STATUS_UNFOLLOW = 2;
  private static final int SUB_CMD_FOLLOWING = 1;
  private static final int SUB_CMD_SETTING = 2;
  private static final String TAG = "PublicAccountHandler";
  private static final int WEATHER_LIMIT_DURATION = 3600000;
  public static final int WEATHER_TYPE_AD = 1;
  public static final int WEATHER_TYPE_CHECK = 2;
  public static final int WEATHER_TYPE_OFFLINE = -1;
  public static final int WEATHER_TYPE_SWITCH = 4;
  public static final int WEATHER_TYPE_UNKOWN = 0;
  public static long currentFansMsgId = 0L;
  public static long currentPublishMsgId = 0L;
  public static long pUIN = 0L;
  public static String publicAccountText = "";
  public static String sLocalIp;
  private QQAppInterface app;
  public List<UinPair> lbsUinList = null;
  public boolean loadAioHistroyMsg = false;
  public long loadHistoryMsgUin = 0L;
  private boolean mIsNeedUpdate;
  private boolean mSearchSwitch;
  private boolean mTotalSwitch;
  private Map<Integer, IPublicAccountHandler.IWeatherInfoListener> mWeatherInfos = new HashMap();
  
  public PublicAccountHandlerImpl()
  {
    super(null);
  }
  
  PublicAccountHandlerImpl(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
    this.mIsNeedUpdate = true;
  }
  
  private String getPreAttachInfoForNewProtocol()
  {
    return this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getString("NewProtocolGetFollowListAttachInfo", "");
  }
  
  private long getPreDataSeq(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
    String str;
    if (paramBoolean) {
      str = "NewProtocolPublicAccountDataSeq2";
    } else {
      str = "PublicAccountDataSeq2";
    }
    return localSharedPreferences.getLong(str, 0L);
  }
  
  private long getPreFollowSeq(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
    String str;
    if (paramBoolean) {
      str = "NewProtocolPublicAccountFollowSeq2";
    } else {
      str = "PublicAccountFollowSeq2";
    }
    return localSharedPreferences.getLong(str, 0L);
  }
  
  private int getUserFollowList(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUserFollowList() isNewProtocol: ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append("   followSeqNo: ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("   publicAccountSeqNo: ");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("PublicAccountHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean2)
    {
      NewIntent localNewIntent = new NewIntent(this.app.getApp(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountStQWebServlet.class));
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
      this.app.startServlet(localNewIntent);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountHandler", 2, "getUserFollowList");
      }
      paramString = new NewIntent(this.app.getApp(), PublicAccountServletImpl.class);
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
      this.app.startServlet(paramString);
    }
    return 0;
  }
  
  private void getWeatherLBSInfo(int paramInt)
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicAccountHandlerImpl.5(this, 0, true, true, 60000L, true, false, "PublicAccountHandler", paramInt));
  }
  
  private void handleGetRecommendList(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null)) {}
    int i;
    label193:
    do
    {
      try
      {
        paramIntent = new publicaccount_recommend.BusinessRecommendResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((!paramIntent.ret_info.has()) || (!((publicaccount_recommend.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
          break label193;
        }
        i = ((publicaccount_recommend.RetInfo)paramIntent.ret_info.get()).ret_code.get();
      }
      catch (Exception paramIntent)
      {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetRecommendList(): package size is ");
        paramFromServiceMsg.append(paramArrayOfByte.length);
        paramFromServiceMsg.append(" Byte");
        QLog.d("PublicAccountHandler", 2, paramFromServiceMsg.toString());
      }
      if (paramIntent.business.has())
      {
        paramIntent = PublicRecommendAccountInfo.createPublicRecommendAccountInfoList(paramIntent.business.get());
        ((IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all")).refreshPublicRecommendList(paramIntent);
        notifyUI(104, true, null);
        return;
        notifyUI(104, false, null);
      }
      return;
      i = -1;
    } while (i == 0);
  }
  
  private void handleGetUserFollowList(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    IPublicAccountObserver.GetUserFollowListRet localGetUserFollowListRet = new IPublicAccountObserver.GetUserFollowListRet();
    if (handleGetUserFollowListResendMsg(paramIntent, paramFromServiceMsg)) {
      return;
    }
    long l1;
    long l2;
    long l5;
    long l3;
    boolean bool3;
    if (handleGetUserFollowListIsResSuccess(paramIntent, paramFromServiceMsg, paramArrayOfByte))
    {
      localGetUserFollowListRet.a = 0;
      l1 = paramIntent.getLongExtra("time_stamp", 0L);
      l2 = paramIntent.getLongExtra("get_user_follow_list_begin", 0L);
      l5 = paramIntent.getLongExtra("get_user_follow_list_follow_seq", 0L);
      l3 = paramIntent.getLongExtra("get_user_follow_list_data_seq", 0L);
      bool3 = paramIntent.getBooleanExtra("get_user_follow_list_is_increment", true);
      handleGetUserFollowListQLogPreFollowData(l1, l2, l5, l3);
      if (!paramBoolean) {}
    }
    try
    {
      paramIntent = new CertifiedAccountRead.StGetFollowListRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (paramIntent.refresh.get() != 1) {
        break label690;
      }
      bool1 = true;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        label617:
        label620:
        continue;
        label659:
        boolean bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        int i = 0;
        continue;
        bool1 = false;
        continue;
        bool1 = true;
      }
    }
    if (paramIntent.has_next.get() == 1)
    {
      bool2 = true;
      l3 = paramIntent.seq.get();
      paramFromServiceMsg = paramIntent.attach_info.get();
      handleGetUserFollowListQLogRefresh(bool1, bool2);
      if (bool1)
      {
        getUserFollowList(0L, 0L, 0L, 20L, SystemClock.uptimeMillis(), false, true, paramFromServiceMsg);
        paramBoolean = false;
        bool1 = false;
      }
      else
      {
        handleGetUserFollowListInnerLogic2(paramBoolean, localGetUserFollowListRet, l1, l2, bool3, paramIntent, bool2, l3, paramFromServiceMsg);
        localGetUserFollowListRet.a = 0;
        paramBoolean = true;
        bool1 = true;
      }
      break label617;
      break label620;
      bool1 = false;
      try
      {
        paramIntent = new mobileqq_mp.GetUserFollowListResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        bool2 = paramIntent.ret_info.has();
        if ((bool2) && (((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has())) {
          i = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
        } else {
          i = 0;
        }
        localGetUserFollowListRet.a = i;
        handleGetUserFollowListQLogHasnext(paramIntent, i);
        if (i != 0)
        {
          paramBoolean = true;
          localGetUserFollowListRet.c = true;
        }
        else
        {
          bool1 = paramIntent.follow_seqno.has();
          if (bool1) {
            i = paramIntent.follow_seqno.get();
          } else {
            i = 0;
          }
          l3 = Utils.a(i);
          bool1 = paramIntent.public_account_seqno.has();
          if (bool1) {
            i = paramIntent.public_account_seqno.get();
          } else {
            i = 0;
          }
          l4 = Utils.a(i);
          if ((l3 > l5) && (l5 != 0L)) {
            l1 = SystemClock.uptimeMillis();
          }
        }
      }
      catch (Exception paramIntent)
      {
        long l4;
        break label620;
      }
      try
      {
        getUserFollowList(l3, l4, 0L, 20L, l1, false, paramBoolean, null);
        paramBoolean = false;
        bool1 = false;
        break label617;
        if (!paramIntent.total_count.has()) {
          break label702;
        }
        i = paramIntent.total_count.get();
        l5 = Utils.a(i);
        paramFromServiceMsg = PublicAccountInfo.createPublicAccountInfoList(paramIntent.info.get(), l1);
        localGetUserFollowListRet.d = paramFromServiceMsg;
        if (!paramIntent.has_next.has()) {
          break label714;
        }
        if (paramIntent.has_next.get()) {
          break label708;
        }
        break label714;
        localGetUserFollowListRet.c = bool1;
        localGetUserFollowListRet.b = l5;
        paramIntent = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
        savePublicAccountInfos(paramFromServiceMsg, l1, bool3, localGetUserFollowListRet.c);
        handleGetUserFollowListInnerLogic3(paramBoolean, localGetUserFollowListRet, l1, l2, bool3, l3, l4, (PublicAccountDataManagerImpl)paramIntent);
        setCurDataSeq(l4, paramBoolean);
        paramBoolean = true;
        bool1 = true;
      }
      catch (Exception paramIntent)
      {
        break label620;
      }
      localGetUserFollowListRet.a = -1;
      localGetUserFollowListRet.c = true;
      break label659;
      localGetUserFollowListRet.a = -1;
      localGetUserFollowListRet.c = true;
      handleGetUserFollowListQLogErrCode("<<---handleGetUserFollowList ", localGetUserFollowListRet.a);
      bool1 = false;
      paramBoolean = true;
      handleGetUserFollowListNeedNotify(localGetUserFollowListRet, paramBoolean, bool1, 100);
      return;
    }
  }
  
  private void handleGetUserFollowListInnerLogic2(boolean paramBoolean1, IPublicAccountObserver.GetUserFollowListRet paramGetUserFollowListRet, long paramLong1, long paramLong2, boolean paramBoolean2, CertifiedAccountRead.StGetFollowListRsp paramStGetFollowListRsp, boolean paramBoolean3, long paramLong3, String paramString)
  {
    paramStGetFollowListRsp = paramStGetFollowListRsp.account_list.get();
    long l = paramStGetFollowListRsp.size();
    paramStGetFollowListRsp = PublicAccountInfo.createPublicAccountInfoListCf8(paramStGetFollowListRsp, paramLong1);
    paramGetUserFollowListRet.d = paramStGetFollowListRsp;
    paramGetUserFollowListRet.c = (paramBoolean3 ^ true);
    paramGetUserFollowListRet.b = l;
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
    savePublicAccountInfos(paramStGetFollowListRsp, paramLong1, paramBoolean2, paramGetUserFollowListRet.c);
    handleGetUserFollowListRetmIsFinish(paramGetUserFollowListRet, (PublicAccountDataManagerImpl)localIPublicAccountDataManager);
    if (!paramGetUserFollowListRet.c)
    {
      if (paramBoolean2) {
        getUserFollowList(paramLong3, 0L, 0L, 20L, paramLong1, true, true, paramString);
      } else {
        getUserFollowList(paramLong3, 0L, paramLong2 + 20L, 20L, paramLong1, false, true, paramString);
      }
    }
    else
    {
      saveCurFollowSeq(paramLong3, paramBoolean1);
      saveAttachInfoForNewProtocol(paramString);
    }
    setCurDataSeq(0L, paramBoolean1);
  }
  
  private void handleGetUserFollowListInnerLogic3(boolean paramBoolean1, IPublicAccountObserver.GetUserFollowListRet paramGetUserFollowListRet, long paramLong1, long paramLong2, boolean paramBoolean2, long paramLong3, long paramLong4, PublicAccountDataManagerImpl paramPublicAccountDataManagerImpl)
  {
    if (paramGetUserFollowListRet.c)
    {
      TroopBarAssistantManager.a().a(this.app, (List)paramPublicAccountDataManagerImpl.getPublicAccountEqqInfoList());
      ServiceAccountFolderManager.a().d(this.app);
      TroopBarAssistantManager.a().m(this.app);
      ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().y();
      paramPublicAccountDataManagerImpl = new PublicAccountHandlerImpl.FolderRefreshRunnable(this.app, paramPublicAccountDataManagerImpl);
      ThreadManager.getSubThreadHandler().postDelayed(paramPublicAccountDataManagerImpl, 15000L);
      ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountHandlerImpl.2(this), 500L);
    }
    if (!paramGetUserFollowListRet.c)
    {
      if (paramBoolean2)
      {
        getUserFollowList(paramLong3, paramLong4, 0L, 20L, paramLong1, true, paramBoolean1, null);
        return;
      }
      getUserFollowList(paramLong3, paramLong4, paramLong2 + 20L, 20L, paramLong1, false, paramBoolean1, null);
      return;
    }
    saveCurFollowSeq(paramLong3, paramBoolean1);
  }
  
  private boolean handleGetUserFollowListIsResSuccess(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    return (paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null);
  }
  
  private void handleGetUserFollowListNeedNotify(IPublicAccountObserver.GetUserFollowListRet paramGetUserFollowListRet, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramBoolean1) {
      notifyUI(paramInt, paramBoolean2, paramGetUserFollowListRet);
    }
  }
  
  private void handleGetUserFollowListQLogErrCode(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramInt);
      QLog.d("PublicAccountHandler", 2, localStringBuilder.toString());
    }
  }
  
  private void handleGetUserFollowListQLogHasnext(mobileqq_mp.GetUserFollowListResponse paramGetUserFollowListResponse, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (paramGetUserFollowListResponse.has_next.has()) {
        bool = paramGetUserFollowListResponse.has_next.get();
      } else {
        bool = false;
      }
      paramGetUserFollowListResponse = new StringBuilder();
      paramGetUserFollowListResponse.append("handleGetUserFollowList        errCode: ");
      paramGetUserFollowListResponse.append(paramInt);
      paramGetUserFollowListResponse.append("    has_next: ");
      paramGetUserFollowListResponse.append(bool);
      QLog.d("PublicAccountHandler", 2, paramGetUserFollowListResponse.toString());
    }
  }
  
  private void handleGetUserFollowListQLogPreFollowData(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetUserFollowList time:  ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("  begin: ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("  preFollowSeq: ");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append("  preDataSeq: ");
      localStringBuilder.append(paramLong4);
      QLog.d("PublicAccountHandler", 2, localStringBuilder.toString());
    }
  }
  
  private void handleGetUserFollowListQLogRefresh(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetUserFollowList      refresh: ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("    has_next: ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("PublicAccountHandler", 2, localStringBuilder.toString());
    }
  }
  
  private boolean handleGetUserFollowListResendMsg(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
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
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleGetUserFollowListk_resend_cnt");
            paramFromServiceMsg.append(i);
            QLog.d("PublicAccountHandler", 2, paramFromServiceMsg.toString());
          }
          bool1 = bool2;
          if (i < 2)
          {
            bool1 = true;
            paramIntent.putExtra("k_resend_cnt", i + 1);
            this.app.startServlet((NewIntent)paramIntent);
          }
        }
      }
    }
    return bool1;
  }
  
  private void handleGetUserFollowListRetmIsFinish(IPublicAccountObserver.GetUserFollowListRet paramGetUserFollowListRet, PublicAccountDataManagerImpl paramPublicAccountDataManagerImpl)
  {
    if (paramGetUserFollowListRet.c)
    {
      TroopBarAssistantManager.a().a(this.app, (List)paramPublicAccountDataManagerImpl.getPublicAccountEqqInfoList());
      ServiceAccountFolderManager.a().d(this.app);
      TroopBarAssistantManager.a().m(this.app);
      ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().y();
      paramGetUserFollowListRet = new PublicAccountHandlerImpl.FolderRefreshRunnable(this.app, paramPublicAccountDataManagerImpl);
      ThreadManager.getSubThreadHandler().postDelayed(paramGetUserFollowListRet, 15000L);
      ThreadManager.getSubThreadHandler().postDelayed(new PublicAccountHandlerImpl.3(this), 500L);
    }
  }
  
  private void handlePushMessageFollowList(SubMsgType0x28.RspFollowList paramRspFollowList)
  {
    List localList = paramRspFollowList.rpt_msg_followlist.get();
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    Iterator localIterator = localList.iterator();
    paramRspFollowList = null;
    int j = 0;
    int i = 0;
    boolean bool;
    int k;
    for (;;)
    {
      bool = localIterator.hasNext();
      k = 2;
      if (!bool) {
        break;
      }
      Object localObject1 = (SubMsgType0x28.FollowList)localIterator.next();
      if (l == ((SubMsgType0x28.FollowList)localObject1).uint64_uin.get())
      {
        Object localObject2 = String.valueOf(((SubMsgType0x28.FollowList)localObject1).uint64_puin.get());
        k = ((SubMsgType0x28.FollowList)localObject1).uint32_type.get();
        if (k != 1)
        {
          if ((k == 2) || (k == 3))
          {
            IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
            localIPublicAccountDataManager.delPublicAccountInfo((String)localObject2);
            localIPublicAccountDataManager.delAccountDetailInfoCache((String)localObject2);
            paramRspFollowList = new IPublicAccountObserver.FollowRet();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(l);
            localStringBuilder.append("");
            paramRspFollowList.a = localIPublicAccountDataManager.getAccountInfo(localStringBuilder.toString());
            if (((SubMsgType0x28.FollowList)localObject1).uint32_disable_cancel_chat.get() != 1) {
              this.app.getMessageFacade().c((String)localObject2, 1008);
            }
            TroopBarAssistantManager.a().a(this.app, (List)localIPublicAccountDataManager.getPublicAccountEqqInfoList());
            ServiceAccountFolderManager.a().d(this.app);
            localObject1 = (EcShopAssistantManager)this.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            if (localObject1 != null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(l);
              ((StringBuilder)localObject2).append("");
              ((EcShopAssistantManager)localObject1).a(((StringBuilder)localObject2).toString(), "pushmsg");
            }
            ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().b(l, 1);
            j = 1;
          }
        }
        else
        {
          getUserFollowList();
          ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().b(l, 2);
          ((IRIJFeedsInsertUtil)QRoute.api(IRIJFeedsInsertUtil.class)).updateReqParams(((IRIJFeedsInsertUtil)QRoute.api(IRIJFeedsInsertUtil.class)).getLastClickChannelId(), (String)localObject2);
          ((IRIJFeedsInsertUtil)QRoute.api(IRIJFeedsInsertUtil.class)).requestRecommendArticleInfoList(((IRIJFeedsInsertUtil)QRoute.api(IRIJFeedsInsertUtil.class)).getLastClickChannelId());
          i = 1;
        }
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
    if (!localList.isEmpty())
    {
      if (((SubMsgType0x28.FollowList)localList.get(0)).uint32_type.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      l = ((SubMsgType0x28.FollowList)localList.get(0)).uint64_puin.get();
      ThreadManager.getUIHandler().post(new PublicAccountHandlerImpl.1(this, l, bool));
      paramRspFollowList = ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine();
      if (bool) {
        i = k;
      } else {
        i = 1;
      }
      paramRspFollowList.c(l, i);
    }
  }
  
  private void handlePushMessageTypeList(SubMsgType0x28.RspTypeList paramRspTypeList) {}
  
  private void handleSubscribeStatusGet(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new mobileqq_mp.GetMessageConfigurationResponse();
    long l = paramIntent.getLongExtra("uin", 0L);
    paramIntent = new StringBuilder();
    paramIntent.append("handleSubscribesStatusResp, uin : ");
    paramIntent.append(l);
    QLog.d("PublicAccountHandler", 1, paramIntent.toString());
    if (paramObject != null) {}
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg.ret_info.has()) && (paramFromServiceMsg.ret_info.ret_code.has()))
      {
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
            paramIntent = new StringBuilder();
            paramIntent.append("result:");
            paramIntent.append(i);
            QLog.d("PublicAccountHandler", 1, paramIntent.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("request Kandian status fail code:");
          paramIntent.append(i);
          QLog.d("PublicAccountHandler", 2, paramIntent.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountHandler", 2, "request Kandian status wrong resp");
      }
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, "request Kandian status fail data null");
    }
    notifyUI(111, false, null);
  }
  
  public static void reportClickPublicAccountEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      paramAppInterface = (QQAppInterface)paramAppInterface;
    } else {
      paramAppInterface = null;
    }
    ReportController.b(paramAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, paramString5, paramString6, "");
  }
  
  public static void reportClickPublicAccountEventInner(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      paramAppInterface = (QQAppInterface)paramAppInterface;
    } else {
      paramAppInterface = null;
    }
    ReportController.b(paramAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, "", "", "");
  }
  
  private void saveAttachInfoForNewProtocol(String paramString)
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    localEditor.putString("NewProtocolGetFollowListAttachInfo", paramString);
    localEditor.commit();
  }
  
  private void saveCurFollowSeq(long paramLong, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    String str;
    if (paramBoolean) {
      str = "NewProtocolPublicAccountFollowSeq2";
    } else {
      str = "PublicAccountFollowSeq2";
    }
    localEditor.putLong(str, paramLong);
    localEditor.commit();
  }
  
  private void savePublicAccountInfos(List<PublicAccountInfo> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = (List)((IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all")).savePublicAccountInfos(paramList, paramLong, paramBoolean1, paramBoolean2);
    paramList = this.app.getProxyManager();
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (PublicAccountInfo)((Iterator)localObject1).next();
      localObject2 = paramList.g().c(((PublicAccountInfo)localObject2).getUin(), 1008);
      if (localObject2 != null)
      {
        paramList.g().a((RecentUser)localObject2);
        i = 1;
      }
    }
    paramList = this.app.getHandler(Conversation.class);
    if ((i != 0) && (paramList != null)) {
      paramList.sendEmptyMessage(1009);
    }
  }
  
  private void sendWeatherLocRequest(int paramInt1, int paramInt2, int paramInt3, int paramInt4, SosoLbsInfo paramSosoLbsInfo)
  {
    int i;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null)) {
      try
      {
        i = Integer.parseInt(paramSosoLbsInfo.mLocation.cityCode);
      }
      catch (Throwable paramSosoLbsInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountHandler", 2, paramSosoLbsInfo, new Object[0]);
        }
      }
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("LocalInfo");
      paramSosoLbsInfo.append(i);
      QLog.d("PublicAccountHandler", 2, paramSosoLbsInfo.toString());
    }
    String str = "";
    Object localObject1 = "8.8.17".replaceAll("\\.", "");
    paramSosoLbsInfo = new WeatherReportInfo.PbReqMsgHead();
    paramSosoLbsInfo.uint32_platform_type.set(1);
    paramSosoLbsInfo.uint32_version.set(Integer.parseInt((String)localObject1));
    WeatherReportInfo.GetWeatherMessageReq localGetWeatherMessageReq = new WeatherReportInfo.GetWeatherMessageReq();
    localGetWeatherMessageReq.pbReqMsgHead.set(paramSosoLbsInfo);
    localGetWeatherMessageReq.uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localGetWeatherMessageReq.lat.set(paramInt2);
    localGetWeatherMessageReq.lng.set(paramInt3);
    localGetWeatherMessageReq.fore_flag.set(0);
    localGetWeatherMessageReq.area_id.set(paramInt4);
    localGetWeatherMessageReq.adcode_from_mapsdk.set(i);
    Object localObject2;
    try
    {
      paramSosoLbsInfo = new JSONObject();
      if (paramInt1 == 0)
      {
        localGetWeatherMessageReq.source.set(2);
      }
      else if (paramInt1 == -1)
      {
        localGetWeatherMessageReq.source.set(1);
      }
      else
      {
        paramSosoLbsInfo.put("cmd", paramInt1);
        localGetWeatherMessageReq.source.set(0);
      }
      paramSosoLbsInfo.put("platform", 109);
      paramSosoLbsInfo.put("version", "8.8.17");
      localObject1 = paramSosoLbsInfo.toString();
      localObject2 = localGetWeatherMessageReq.extra;
      paramSosoLbsInfo = (SosoLbsInfo)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramSosoLbsInfo = "";
      }
      ((PBStringField)localObject2).set(paramSosoLbsInfo);
    }
    catch (JSONException paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
    }
    paramSosoLbsInfo = sLocalIp;
    localObject1 = paramSosoLbsInfo;
    if (TextUtils.isEmpty(paramSosoLbsInfo)) {
      try
      {
        localObject2 = NetworkInterface.getNetworkInterfaces();
        for (;;)
        {
          localObject1 = paramSosoLbsInfo;
          if (!((Enumeration)localObject2).hasMoreElements()) {
            break label476;
          }
          localObject1 = ((NetworkInterface)((Enumeration)localObject2).nextElement()).getInetAddresses();
          if (((Enumeration)localObject1).hasMoreElements())
          {
            InetAddress localInetAddress = (InetAddress)((Enumeration)localObject1).nextElement();
            if ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address))) {
              break;
            }
            paramSosoLbsInfo = localInetAddress.getHostAddress().toString();
          }
        }
        paramSosoLbsInfo = (SosoLbsInfo)localObject1;
      }
      catch (Exception paramSosoLbsInfo)
      {
        paramSosoLbsInfo.printStackTrace();
        paramSosoLbsInfo = str;
      }
    }
    label476:
    int j;
    if (!TextUtils.isEmpty(paramSosoLbsInfo))
    {
      try
      {
        localObject1 = paramSosoLbsInfo.split(Pattern.quote("."));
        int m = localObject1.length;
        int k = 0;
        i = 0;
        for (;;)
        {
          j = i;
          if (k >= m) {
            break label575;
          }
          str = localObject1[k];
          j = i << 8;
          try
          {
            i = Integer.parseInt(str);
            i = j | i;
            k += 1;
          }
          catch (Exception localException1) {}
        }
        localException2.printStackTrace();
      }
      catch (Exception localException2)
      {
        j = 0;
      }
      label575:
      sLocalIp = paramSosoLbsInfo;
    }
    else
    {
      j = 0;
    }
    localGetWeatherMessageReq.ip.set(j);
    paramSosoLbsInfo = createToServiceMsg("QQWeatherReport.getWeatherInfo");
    paramSosoLbsInfo.putWupBuffer(localGetWeatherMessageReq.toByteArray());
    sendPbReq(paramSosoLbsInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountHandler", 2, String.format("send tianqi lat=%d, lng=%d, type=%d, areaid = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt4) }));
    }
  }
  
  private void setCurDataSeq(long paramLong, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    String str;
    if (paramBoolean) {
      str = "NewProtocolPublicAccountDataSeq2";
    } else {
      str = "PublicAccountDataSeq2";
    }
    localEditor.putLong(str, paramLong);
    localEditor.commit();
  }
  
  public void clearPublicAccountSeq()
  {
    setCurDataSeq(0L, true);
    setCurDataSeq(0L, false);
    saveCurFollowSeq(0L, true);
    saveCurFollowSeq(0L, false);
    saveAttachInfoForNewProtocol("");
  }
  
  public void clearWeatherInfoListener()
  {
    Map localMap = this.mWeatherInfos;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void getAIOHistoryMsg(String paramString, long paramLong, int paramInt)
  {
    getAIOHistoryMsg(paramString, paramLong, paramInt, null);
  }
  
  public void getAIOHistoryMsg(String paramString, long paramLong, int paramInt, mqq.observer.BusinessObserver paramBusinessObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "pull_aio_history_msg");
    historyMsg.AioHistoryMsgRequest localAioHistoryMsgRequest = new historyMsg.AioHistoryMsgRequest();
    localAioHistoryMsgRequest.puin.set(Long.parseLong(paramString));
    localAioHistoryMsgRequest.msg_id.set(paramLong);
    localAioHistoryMsgRequest.msg_cnt.set(paramInt);
    localNewIntent.putExtra("data", localAioHistoryMsgRequest.toByteArray());
    if (paramBusinessObserver != null) {
      localNewIntent.setObserver(paramBusinessObserver);
    } else {
      ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler(localNewIntent);
    }
    this.app.startServlet(localNewIntent);
    ReportController.b(this.app, "CliOper", "", "", "0X8006502", "0X8006502", 0, 0, "", "", "", "");
  }
  
  public int getRecommendList(Object paramObject)
  {
    SosoLbsInfo localSosoLbsInfo = (SosoLbsInfo)paramObject;
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "get_business_recommend");
    publicaccount_recommend.BusinessRecommendRequest localBusinessRecommendRequest = new publicaccount_recommend.BusinessRecommendRequest();
    localBusinessRecommendRequest.recomend_count.set(20);
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null) && (localSosoLbsInfo.mLocation.address != null)) {
        paramObject = localSosoLbsInfo.mLocation.address;
      } else {
        paramObject = "";
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRecommendList() latitude=");
        localStringBuilder.append(localSosoLbsInfo.mLocation.mLat02);
        localStringBuilder.append(" longitude=");
        localStringBuilder.append(localSosoLbsInfo.mLocation.mLon02);
        localStringBuilder.append(", address=");
        localStringBuilder.append(paramObject);
        QLog.d("PublicAccountHandler", 2, localStringBuilder.toString());
      }
      localBusinessRecommendRequest.latitude.set(String.valueOf(localSosoLbsInfo.mLocation.mLat02));
      localBusinessRecommendRequest.longitude.set(String.valueOf(localSosoLbsInfo.mLocation.mLon02));
      localBusinessRecommendRequest.city_info.set(paramObject);
    }
    localBusinessRecommendRequest.platform.set(109);
    localNewIntent.putExtra("data", localBusinessRecommendRequest.toByteArray());
    ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler(localNewIntent);
    this.app.startServlet(localNewIntent);
    return 0;
  }
  
  public boolean getSearchSwitch()
  {
    return this.mSearchSwitch;
  }
  
  public boolean getTotalSwitch()
  {
    return this.mTotalSwitch;
  }
  
  public int getUserFollowList()
  {
    boolean bool = PublicAccountConfigUtilImpl.isGetFollowListUseNewProtocol();
    long l1 = getPreFollowSeq(bool);
    long l2 = getPreDataSeq(bool);
    String str = getPreAttachInfoForNewProtocol();
    return getUserFollowList(l1, l2, 0L, 20L, SystemClock.uptimeMillis(), true, bool, str);
  }
  
  public void getWeatherInfo(Context paramContext, int paramInt, IPublicAccountHandler.IWeatherInfoListener paramIWeatherInfoListener)
  {
    if (paramIWeatherInfoListener != null) {
      this.mWeatherInfos.put(Integer.valueOf(paramInt), paramIWeatherInfoListener);
    }
    if (paramInt == 1)
    {
      sendLocRequest(paramInt, 0, 0, 0);
      return;
    }
    if (paramInt == 2)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = (AppActivity)paramContext;
        if (paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        {
          paramContext.requestPermissions(new PublicAccountHandlerImpl.4(this, paramInt, paramContext), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return;
        }
        getWeatherLBSInfo(paramInt);
        return;
      }
      getWeatherLBSInfo(paramInt);
    }
  }
  
  public void handleAIOHistoryMsg(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("handleAIOHistoryMsg onReceive :");
      paramIntent.append(bool);
      QLog.d("PublicAccountHandler", 2, paramIntent.toString());
    }
    if (bool) {}
    for (;;)
    {
      int j;
      int i;
      try
      {
        paramFromServiceMsg = new historyMsg.AioHistoryMsgResponse();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        j = paramFromServiceMsg.ret_info.ret_code.get();
        if (j != 0) {
          break label390;
        }
        i = 1;
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("result: ");
          paramIntent.append(j);
          QLog.e("PublicAccountHandler", 2, paramIntent.toString());
        }
        if (paramFromServiceMsg.msg_infos.has()) {
          break label396;
        }
        j = 2;
        notifyUI(105, true, Integer.valueOf(j));
        if ((i == 0) || (!paramFromServiceMsg.msg_infos.has()) || (!paramFromServiceMsg.puin.has())) {
          break label389;
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
          break label389;
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
      else
      {
        if (paramIntent.size() == 0) {
          return;
        }
        this.loadAioHistroyMsg = true;
        this.loadHistoryMsgUin = l;
        ((IPublicAccountDynamicMsgProcessor)QRoute.api(IPublicAccountDynamicMsgProcessor.class)).init(this.app, this.app.getMsgHandler()).processHistoryMsg(l, paramIntent);
        return;
        QLog.e("PublicAccountHandler", 2, "handleGetRecommendList onReceive fail: ", paramIntent);
        return;
        notifyUI(105, true, Integer.valueOf(1));
        label389:
        return;
        label390:
        i = 0;
        continue;
        label396:
        j = 0;
        continue;
        if (i <= 0) {
          return;
        }
        j = 0;
      }
    }
  }
  
  public void handleGetGuideFriends(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool3 = false;
    int i = 0;
    boolean bool2;
    if ((bool1) && (paramObject != null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    bool1 = bool2;
    if (bool2)
    {
      paramIntent = new SSOBiuGuide.RspBody();
      try
      {
        paramIntent.mergeFrom((byte[])paramObject);
        if (paramIntent.ret_info.has())
        {
          int j = paramIntent.ret_info.ret_code.get();
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountHandler", 1, new Object[] { "handleGetGuideFriends ret:", Integer.valueOf(j) });
          }
          if (j == 0) {
            try
            {
              if (!paramIntent.rpt_msg_uin_info.isEmpty()) {
                while (i < paramIntent.rpt_msg_uin_info.size())
                {
                  localArrayList.add(Long.valueOf(((SSOBiuGuide.UinInfo)paramIntent.rpt_msg_uin_info.get(i)).uint64_uin.get()));
                  i += 1;
                }
              }
              bool1 = true;
            }
            catch (Exception paramIntent)
            {
              bool1 = true;
              break label207;
            }
          }
        }
        bool1 = false;
      }
      catch (Exception paramIntent)
      {
        bool1 = bool3;
        label207:
        QLog.d("PublicAccountHandler", 1, "handleGetGuideFriends fail:", paramIntent);
      }
    }
    notifyUI(110, bool1, localArrayList);
  }
  
  public void handleGetRecvMsgState(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    long l = paramIntent.getLongExtra("uin", 0L);
    paramIntent = new StringBuilder();
    paramIntent.append("handleGetRecvMsgState, uin = ");
    paramIntent.append(l);
    paramIntent.append(",resp.isSuccess() = ");
    paramIntent.append(paramFromServiceMsg.isSuccess());
    QLog.d("PublicAccountHandler", 1, paramIntent.toString());
    if (paramFromServiceMsg.isSuccess()) {
      try
      {
        paramIntent = Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetRecvMsgStateRsp());
        if ((paramIntent instanceof GetRecvMsgStateRsp))
        {
          paramIntent = (GetRecvMsgStateRsp)paramIntent;
          paramFromServiceMsg = this.app.getApp().getSharedPreferences("public_account_detail_setting_status", 0).edit();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setting_result_");
          localStringBuilder.append(l);
          localStringBuilder.append("_");
          localStringBuilder.append(this.app.getCurrentAccountUin());
          paramFromServiceMsg = paramFromServiceMsg.putInt(localStringBuilder.toString(), paramIntent.result);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("setting_status_");
          localStringBuilder.append(l);
          localStringBuilder.append("_");
          localStringBuilder.append(this.app.getCurrentAccountUin());
          paramFromServiceMsg.putInt(localStringBuilder.toString(), paramIntent.state).commit();
          paramIntent = this.app.getHandler(AccountDetailGroupListContainer.class);
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
  
  public void handleKandianSubscribe(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool2 = false;
    if ((bool1) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i = paramIntent.getIntExtra("kandian_seq", 0);
    long l = paramIntent.getLongExtra("uin", 0L);
    if (bool1)
    {
      paramIntent = new mobileqq_mp.SetMessageConfigurationResponse();
      try
      {
        paramIntent.mergeFrom((byte[])paramObject);
        bool1 = bool2;
        if (paramIntent.ret_info.has())
        {
          bool1 = bool2;
          if (paramIntent.ret_info.ret_code.has())
          {
            int j = paramIntent.ret_info.ret_code.get();
            if (j == 0)
            {
              bool1 = true;
            }
            else
            {
              paramIntent = new StringBuilder();
              paramIntent.append("handleKandianSubscribe fail code:");
              paramIntent.append(j);
              QLog.d("PublicAccountHandler", 1, paramIntent.toString());
              bool1 = bool2;
            }
          }
        }
      }
      catch (Exception paramIntent)
      {
        QLog.d("PublicAccountHandler", 1, "handleKandianSubscribe fail:", paramIntent);
        bool1 = bool2;
      }
    }
    paramIntent = new StringBuilder();
    paramIntent.append("handleSetKandianSubscribeStatusRsp: ");
    paramIntent.append(l);
    paramIntent.append(", seq : ");
    paramIntent.append(i);
    QLog.d("PublicAccountHandler", 1, paramIntent.toString());
    paramIntent = new HashMap();
    paramIntent.put("uin", Long.valueOf(l));
    paramIntent.put("seq", Integer.valueOf(i));
    notifyUI(108, bool1, paramIntent);
  }
  
  public void handlePreSendMsg(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        paramIntent = new mobileqq_mp.SendPreMessageStatusResponse();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((paramIntent.ret_info.has()) && (((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.has()))
        {
          i = ((mobileqq_mp.RetInfo)paramIntent.ret_info.get()).ret_code.get();
          if (i != 0)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            paramIntent = new StringBuilder();
            paramIntent.append("handlePreSendMsg error, errcode: ");
            paramIntent.append(i);
            QLog.d("PublicAccountHandler", 2, paramIntent.toString());
            return;
          }
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("handlePreSendMsg success: package size is ");
            paramIntent.append(paramArrayOfByte.length);
            paramIntent.append(" Byte");
            QLog.d("PublicAccountHandler", 2, paramIntent.toString());
            return;
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountHandler", 2, "handlePreSendMsg  failed!");
            }
          }
          return;
        }
      }
      catch (Exception paramIntent)
      {
        return;
      }
      int i = -1;
    }
  }
  
  public void handleSetRecvMsgState(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSetRecvMsgState resp.isSuccess() = ");
      localStringBuilder.append(paramFromServiceMsg.isSuccess());
      QLog.d("PublicAccountHandler", 2, localStringBuilder.toString());
    }
    if (paramFromServiceMsg == null) {
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    if (bool) {
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
  }
  
  public boolean isNeedUpdate()
  {
    return this.mIsNeedUpdate;
  }
  
  public Object newPublicAccountCheckUpdateItem()
  {
    return new PublicAccountHandlerImpl.PublicAccountCheckUpdateItem(this);
  }
  
  protected Class<? extends com.tencent.mobileqq.app.BusinessObserver> observerClass()
  {
    return PublicAccountObserverImpl.class;
  }
  
  public void onFollowPublicAccount(Object paramObject)
  {
    IPublicAccountObserver.FollowRet localFollowRet = new IPublicAccountObserver.FollowRet();
    localFollowRet.b = 0;
    long l = SystemClock.uptimeMillis();
    Object localObject = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
    boolean bool = paramObject instanceof PublicAccountDetailImpl;
    if (bool)
    {
      localFollowRet.a = PublicAccountInfo.createPublicAccount((IPublicAccountDetail)paramObject, l);
      ((IPublicAccountDataManager)localObject).saveAccountDetailInfoCache((PublicAccountDetailImpl)paramObject);
    }
    else if ((paramObject instanceof EqqDetail))
    {
      localFollowRet.a = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l);
    }
    ((IPublicAccountDataManager)localObject).savePublicAccountInfo((PublicAccountInfo)localFollowRet.a);
    TroopBarAssistantManager.a().a(this.app, (List)((IPublicAccountDataManager)localObject).getPublicAccountEqqInfoList());
    if ((bool) && (QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) <= 0)) {
      ServiceAccountFolderManager.a().c(this.app, ((PublicAccountInfo)localFollowRet.a).getUin());
    }
    localObject = (EcShopAssistantManager)this.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localObject != null)
    {
      if (localFollowRet.a == null) {
        paramObject = null;
      } else {
        paramObject = ((PublicAccountInfo)localFollowRet.a).getUin();
      }
      ((EcShopAssistantManager)localObject).a(paramObject, "onFollow");
    }
    notifyUI(101, true, localFollowRet);
  }
  
  public void onGetPublicAccount()
  {
    notifyUI(103, true, null);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = (byte[])paramObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<---onReceive ");
      localStringBuilder.append(str);
      QLog.d("PublicAccountHandler", 2, localStringBuilder.toString());
    }
    if (str.equals("get_follow_list"))
    {
      handleGetUserFollowList(paramIntent, paramFromServiceMsg, arrayOfByte, false);
      return;
    }
    if (str.equals("CertifiedAccountSvc.certified_account_read.GetFollowList"))
    {
      handleGetUserFollowList(paramIntent, paramFromServiceMsg, arrayOfByte, true);
      return;
    }
    if (str.equals("secmsg.configs")) {
      return;
    }
    if (str.equals("get_business_recommend"))
    {
      handleGetRecommendList(paramIntent, paramFromServiceMsg, arrayOfByte);
      return;
    }
    if (str.equals("send_pre_message_status"))
    {
      handlePreSendMsg(paramIntent, paramFromServiceMsg, arrayOfByte);
      return;
    }
    if (str.equals("pull_aio_history_msg"))
    {
      handleAIOHistoryMsg(paramIntent, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equals("pull_account_detail_dynamic_list")) {
      return;
    }
    if (str.equals("PubAccountSvc.net_connect_info"))
    {
      PublicAccountWebReport.handlereportPublicAccountNetInfoResponse(paramIntent, paramFromServiceMsg, paramObject);
      return;
    }
    if (TextUtils.equals(str, "set_message_configuration"))
    {
      handleKandianSubscribe(paramIntent, paramFromServiceMsg, paramObject);
      return;
    }
    if (TextUtils.equals(str, "getGuideFriends"))
    {
      handleGetGuideFriends(paramIntent, paramFromServiceMsg, paramObject);
      return;
    }
    if (TextUtils.equals(str, "get_message_configuration"))
    {
      handleSubscribeStatusGet(paramIntent, paramFromServiceMsg, paramObject);
      return;
    }
    if (TextUtils.equals(str, "ConfigSvc.getRecvMsgState"))
    {
      handleGetRecvMsgState(paramIntent, paramFromServiceMsg);
      return;
    }
    if (TextUtils.equals(str, "ConfigSvc.setRecvMsgState")) {
      handleSetRecvMsgState(paramFromServiceMsg);
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if (paramToServiceMsg != null)
    {
      if (paramToServiceMsg.length() == 0) {
        return;
      }
      if ("PubAccountSvc.ReportLbs".equalsIgnoreCase(paramToServiceMsg))
      {
        paramFromServiceMsg.isSuccess();
        return;
      }
      if (("QQWeatherReport.getWeatherInfo".equals(paramToServiceMsg)) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
        paramToServiceMsg = new WeatherReportInfo.GetWeatherMessageRsp();
      }
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      label77:
      int i = paramToServiceMsg.cmd.get();
      paramToServiceMsg = paramToServiceMsg.string_msg.get();
      if ((i == 1) || (i == 2))
      {
        paramFromServiceMsg = (IPublicAccountHandler.IWeatherInfoListener)this.mWeatherInfos.get(Integer.valueOf(i));
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.a(paramToServiceMsg);
        }
        this.mWeatherInfos.remove(Integer.valueOf(i));
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("type = ");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append(" msg =");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.d("PublicAccountHandler", 2, paramFromServiceMsg.toString());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label77;
    }
  }
  
  public void onReceivePushMessage(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<<---onReceivePushMessage subMsgTye = ");
      ((StringBuilder)localObject1).append(Integer.toHexString((int)paramLong));
      QLog.d("PublicAccountHandler", 2, ((StringBuilder)localObject1).toString());
    }
    int i = (int)paramLong;
    if (i != 40) {
      if (i != 63) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new SubMsgType0x3f.MsgBody();
        ((SubMsgType0x3f.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((SubMsgType0x3f.MsgBody)localObject1).rpt_msg_pubunikey.get().iterator();
        if (paramArrayOfByte.hasNext())
        {
          localObject1 = (SubMsgType0x3f.PubUniKey)paramArrayOfByte.next();
          paramLong = ((SubMsgType0x3f.PubUniKey)localObject1).uint64_fromPubUin.get();
          l = ((SubMsgType0x3f.PubUniKey)localObject1).uint64_qwMsgId.get();
          localObject1 = Long.toString(paramLong);
          Iterator localIterator = this.app.getMessageFacade().a((String)localObject1, 1008, null).iterator();
          if (!localIterator.hasNext()) {
            continue;
          }
          localMessageRecord = (MessageRecord)localIterator.next();
          localObject2 = XMLMessageUtils.a(localMessageRecord);
          if ((localObject2 != null) && (((PAMessage)localObject2).mMsgId == l))
          {
            this.app.getMessageFacade().h((String)localObject1, 1008, localMessageRecord.uniseq);
            continue;
          }
          localObject2 = localMessageRecord.getExtInfoFromExtStr("pa_msgId");
          if (localObject2 == null) {
            continue;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException|Exception paramArrayOfByte)
      {
        long l;
        MessageRecord localMessageRecord;
        Object localObject2;
        return;
      }
      try
      {
        if (Long.parseLong((String)localObject2) != l) {
          continue;
        }
        this.app.getMessageFacade().h((String)localObject1, 1008, localMessageRecord.uniseq);
      }
      catch (Exception localException) {}
      paramArrayOfByte = (SubMsgType0x28.MsgBody)new SubMsgType0x28.MsgBody().mergeFrom(paramArrayOfByte);
      i = paramArrayOfByte.uint32_sub_cmd.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("<<---onReceivePushMessage subCmd = ");
        ((StringBuilder)localObject1).append(i);
        QLog.d("PublicAccountHandler", 2, ((StringBuilder)localObject1).toString());
      }
      if (i == 1)
      {
        handlePushMessageFollowList((SubMsgType0x28.RspFollowList)paramArrayOfByte.msg_rsp_followlist.get());
        return;
      }
      if (i == 2) {
        handlePushMessageTypeList((SubMsgType0x28.RspTypeList)paramArrayOfByte.msg_rsp_typelist.get());
      }
      return;
    }
  }
  
  public void onUnfollowPublicAccount(Object paramObject)
  {
    IPublicAccountObserver.FollowRet localFollowRet = new IPublicAccountObserver.FollowRet();
    localFollowRet.b = 0;
    long l = SystemClock.uptimeMillis();
    Object localObject1 = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
    boolean bool = paramObject instanceof PublicAccountDetailImpl;
    Object localObject2;
    if (bool)
    {
      localObject2 = (PublicAccountDetailImpl)paramObject;
      localFollowRet.a = PublicAccountInfo.createPublicAccount((IPublicAccountDetail)localObject2, l);
      ((IPublicAccountDataManager)localObject1).delAccountDetailInfoCache(((PublicAccountDetailImpl)localObject2).uin);
    }
    else if ((paramObject instanceof EqqDetail))
    {
      localFollowRet.a = PublicAccountInfo.createPublicAccount((EqqDetail)paramObject, l);
    }
    ((IPublicAccountDataManager)localObject1).delPublicAccountInfo(((PublicAccountInfo)localFollowRet.a).getUin());
    if ((paramObject instanceof EqqDetail))
    {
      localObject2 = (EqqDetailDataManager)this.app.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
      if (localObject2 != null) {
        ((EqqDetailDataManager)localObject2).b((EqqDetail)paramObject);
      }
    }
    TroopBarAssistantManager.a().a(this.app, (List)((IPublicAccountDataManager)localObject1).getPublicAccountEqqInfoList());
    if (bool) {
      ServiceAccountFolderManager.a().c(this.app, ((PublicAccountInfo)localFollowRet.a).getUin());
    }
    localObject1 = (EcShopAssistantManager)this.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localObject1 != null)
    {
      if (localFollowRet.a == null) {
        paramObject = null;
      } else {
        paramObject = ((PublicAccountInfo)localFollowRet.a).getUin();
      }
      ((EcShopAssistantManager)localObject1).a(paramObject, "onUnfollow");
    }
    notifyUI(102, true, localFollowRet);
  }
  
  public void reportClickPublicAccountEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    reportClickPublicAccountEventInner(paramAppInterface, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void reportClickPublicAccountEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      paramAppInterface = (QQAppInterface)paramAppInterface;
    } else {
      paramAppInterface = null;
    }
    ReportController.b(paramAppInterface, "P_CliOper", paramString2, "", paramString3, paramString4, paramInt, 0, paramString1, "", "", "");
  }
  
  public void sendLBSInfo(String paramString1, double paramDouble1, double paramDouble2, String paramString2)
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
  
  public void sendLocRequest(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QQAppInterface localQQAppInterface = this.app;
    int i;
    if ((localQQAppInterface != null) && (!localQQAppInterface.isBackgroundStop)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new PublicAccountHandlerImpl.6(this, "qq_weather", false, paramInt1, paramInt2, paramInt3, paramInt4));
      return;
    }
    sendWeatherLocRequest(paramInt1, paramInt2, paramInt3, paramInt4, ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qq_weather"));
  }
  
  public void setLocalIp(String paramString)
  {
    sLocalIp = paramString;
  }
  
  public void setNotNeedUpdate()
  {
    this.mIsNeedUpdate = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl
 * JD-Core Version:    0.7.0.1
 */