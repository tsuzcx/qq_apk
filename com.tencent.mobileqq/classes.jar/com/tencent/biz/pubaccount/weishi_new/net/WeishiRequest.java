package com.tencent.biz.pubaccount.weishi_new.net;

import NS_KING_INTERFACE.stDelCommentReplyRsp;
import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_INTERFACE.stGetCommentReplyListRsp;
import NS_KING_INTERFACE.stPostCommentDingRsp;
import NS_KING_INTERFACE.stPostFeedDingRsp;
import NS_KING_PUBLIC.stReqHeader;
import NS_KING_PUBLIC.stRspHeader;
import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.QmfServerInfo;
import QMF_PROTOCAL.RetryInfo;
import UserGrowth.stBlockRecommPersonRsp;
import UserGrowth.stCompressedData;
import UserGrowth.stFollowFeedsRsp;
import UserGrowth.stFollowRsp;
import UserGrowth.stFriendFeedRsp;
import UserGrowth.stGetAIOFeedDetailRsp;
import UserGrowth.stGetAllABTestPolicyRsp;
import UserGrowth.stGetCollectionRsp;
import UserGrowth.stGetFeedIconOpRsp;
import UserGrowth.stGetPersonalFeedListRsp;
import UserGrowth.stGetTabsRsp;
import UserGrowth.stNotificationRsp;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stPublisherRsp;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import UserGrowth.stQQGroupDetailRsp;
import UserGrowth.stRedDotRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleGetFeedDetailRsp;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stUserConfigRsp;
import UserGrowth.stWeishiDengtaReportRsp;
import UserGrowth.stWeishiReportReq;
import UserGrowth.stWeishiReportRsp;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSGzipCompressInfo;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetUtil;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.now.netchannel.tool.GZipUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.WNSStream;
import cooperation.qzone.statistic.serverip.WebAppIpManager;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.WnsError;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;

@Deprecated
public class WeishiRequest<T1>
  extends QzoneExternalRequest
  implements INetworkCallback
{
  public static String a = "QzoneNewService.";
  public static Map<Integer, Map<String, String>> n = new HashMap();
  private boolean A;
  private boolean B;
  protected HashMap<Object, Object> b = new HashMap();
  public JceStruct c;
  public String d;
  protected boolean e = false;
  protected volatile boolean f = false;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  protected transient IWeishiProtocolListener l;
  public WSUniPacket m;
  protected int o;
  protected long p = 30000L;
  public int q = 100000;
  private String r;
  private String s = a;
  private final WSGzipCompressInfo t;
  private String u;
  private int v;
  private boolean w;
  private long x;
  private String y;
  private boolean z = false;
  
  public WeishiRequest(String paramString)
  {
    this("WeishiGZH.", paramString, false);
    this.y = paramString;
  }
  
  public WeishiRequest(String paramString, int paramInt)
  {
    this("WeishiGZH.", paramString, false);
    this.y = paramString;
    this.o = paramInt;
  }
  
  public WeishiRequest(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.r = paramString2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    this.u = localStringBuilder.toString();
    this.w = paramBoolean;
    this.x = System.currentTimeMillis();
    this.t = new WSGzipCompressInfo();
    setLoginUserId(WeishiUtils.b());
  }
  
  private long a(Bundle paramBundle, String paramString)
  {
    if (paramBundle != null)
    {
      if (paramString == null) {
        return 0L;
      }
      if (paramBundle.containsKey(paramString)) {
        return paramBundle.getLong(paramString);
      }
    }
    return 0L;
  }
  
  @NotNull
  private RspHeaderBean a(QmfDownstream paramQmfDownstream, int paramInt)
  {
    paramQmfDownstream = (stRspHeader)a(paramQmfDownstream.BusiBuff, "stRspHeader", new stRspHeader());
    RspHeaderBean localRspHeaderBean = new RspHeaderBean();
    if ((paramQmfDownstream != null) && (paramQmfDownstream.mapExt != null))
    {
      localRspHeaderBean.a = paramQmfDownstream.mapExt;
      Object localObject1 = paramQmfDownstream.mapExt;
      n.put(Integer.valueOf(paramInt), localObject1);
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(e());
        localStringBuilder.append(" 存进去 》》》 key: ");
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        localStringBuilder.append(", value: ");
        localStringBuilder.append((String)((Map.Entry)localObject2).getValue());
        Log.i("weishi-Request", localStringBuilder.toString());
      }
      localObject1 = (String)paramQmfDownstream.mapExt.get("qq_abtest");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("stRspHeader: {iRet=");
      ((StringBuilder)localObject2).append(paramQmfDownstream.iRet);
      ((StringBuilder)localObject2).append(", sErrMsg=");
      ((StringBuilder)localObject2).append(paramQmfDownstream.sErrmsg);
      ((StringBuilder)localObject2).append(", scene=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", abTestId=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("}");
      Log.i("weishi-Request", ((StringBuilder)localObject2).toString());
      if ("SimpleGetFeedList".equals(j())) {
        LocalMultiProcConfig.putString4Uin("key_default_test_id", (String)localObject1, WeishiUtils.b());
      }
      localRspHeaderBean.b = ((String)localObject1);
      WSReportUtils.a(paramInt, (String)localObject1);
      localObject1 = (String)paramQmfDownstream.mapExt.get("person_id");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("stRspHeader: {personId=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("}");
      Log.d("weishi-Request", ((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        WeishiUtils.k((String)localObject1);
      }
      if ((paramQmfDownstream.iRet == -99) && (d())) {
        WSQQConnectAuthManager.a().d();
      }
    }
    return localRspHeaderBean;
  }
  
  private Object a(QmfDownstream paramQmfDownstream, Class paramClass)
  {
    if (paramClass == stSimpleGetFeedListRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stSimpleGetFeedListRsp());
    }
    if (paramClass == stNotificationRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stNotificationRsp());
    }
    if (paramClass == stQQGetFeedCommentListV2Rsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stQQGetFeedCommentListV2Rsp());
    }
    if (paramClass == stPostFeedCommentV2Rsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stPostFeedCommentV2Rsp());
    }
    if (paramClass == stPostCommentReplyV2Rsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stPostCommentReplyV2Rsp());
    }
    if (paramClass == stGetCommentReplyListRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stGetCommentReplyListRsp());
    }
    if (paramClass == stDelCommentReplyRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stDelCommentReplyRsp());
    }
    if (paramClass == stPostCommentDingRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stPostCommentDingRsp());
    }
    if (paramClass == stDeleteFeedCommentRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stDeleteFeedCommentRsp());
    }
    if (paramClass == stPostFeedDingRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stPostFeedDingRsp());
    }
    if (paramClass == stWeishiReportRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stWeishiReportRsp());
    }
    if (paramClass == stFollowFeedsRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stFollowFeedsRsp());
    }
    if (paramClass == stRedDotRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stRedDotRsp());
    }
    if (paramClass == stSimpleGetFeedDetailRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stSimpleGetFeedDetailRsp());
    }
    if (paramClass == stBlockRecommPersonRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stBlockRecommPersonRsp());
    }
    if (paramClass == stFollowRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stFollowRsp());
    }
    if (paramClass == stPublisherRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stPublisherRsp());
    }
    if (paramClass == stWeishiDengtaReportRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stWeishiDengtaReportRsp());
    }
    if (paramClass == stUserConfigRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stUserConfigRsp());
    }
    if (paramClass == stGetCollectionRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stGetCollectionRsp());
    }
    if (paramClass == stFriendFeedRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stFriendFeedRsp());
    }
    if (paramClass == stGetPersonalFeedListRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stGetPersonalFeedListRsp());
    }
    if (paramClass == stQQGroupDetailRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stQQGroupDetailRsp());
    }
    if (paramClass == stGetAIOFeedDetailRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stGetAIOFeedDetailRsp());
    }
    if (paramClass == stGetAllABTestPolicyRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stGetAllABTestPolicyRsp());
    }
    if (paramClass == stGetTabsRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stGetTabsRsp());
    }
    if (paramClass == stGetFeedIconOpRsp.class) {
      return a(paramQmfDownstream.BusiBuff, e(), new stGetFeedIconOpRsp());
    }
    Log.e("weishi-Request", "response无法匹配");
    return null;
  }
  
  public static String a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(Build.VERSION.RELEASE);
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(WSDeviceUtils.e());
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  private static boolean a(RspHeaderBean paramRspHeaderBean)
  {
    if ((paramRspHeaderBean != null) && (paramRspHeaderBean.a != null))
    {
      if (!paramRspHeaderBean.a.containsKey("qq_compressed"))
      {
        WSLog.e("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] rsp is not compress");
        return false;
      }
      return true;
    }
    WSLog.e("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] rspHeader or mapExt is null");
    return false;
  }
  
  private <T extends JceStruct> byte[] a(byte[] paramArrayOfByte)
  {
    long l1 = System.currentTimeMillis();
    a(true);
    Object localObject = (stCompressedData)a(paramArrayOfByte, "stCompressedData", new stCompressedData());
    byte[] arrayOfByte = null;
    if (localObject == null)
    {
      WSLog.e("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] rsp is compress, but decodeJce failure");
      return null;
    }
    paramArrayOfByte = arrayOfByte;
    int i1;
    try
    {
      localObject = ((stCompressedData)localObject).compressed;
      paramArrayOfByte = arrayOfByte;
      i1 = localObject.length;
      paramArrayOfByte = arrayOfByte;
      arrayOfByte = GZipUtil.a((byte[])localObject);
      paramArrayOfByte = arrayOfByte;
      int i2 = arrayOfByte.length;
      paramArrayOfByte = arrayOfByte;
      arrayOfByte = Arrays.copyOfRange(arrayOfByte, 1, i2);
      paramArrayOfByte = arrayOfByte;
      localObject = n();
      paramArrayOfByte = arrayOfByte;
      ((WSGzipCompressInfo)localObject).a(i1);
      paramArrayOfByte = arrayOfByte;
      ((WSGzipCompressInfo)localObject).b(i2);
      paramArrayOfByte = arrayOfByte;
      ((WSGzipCompressInfo)localObject).a(i1 / i2);
      paramArrayOfByte = arrayOfByte;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSResponseDecoder.java][checkRspCompress] exception:");
      ((StringBuilder)localObject).append(localException.getLocalizedMessage());
      WSLog.d("weishi-Request", ((StringBuilder)localObject).toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSResponseDecoder.java][checkRspCompress] decompress and decodeJce success. dataSize:");
    if (paramArrayOfByte != null) {
      i1 = paramArrayOfByte.length;
    } else {
      i1 = 0;
    }
    localStringBuilder.append(i1);
    localStringBuilder.append(", cost:");
    localStringBuilder.append(System.currentTimeMillis() - l1);
    WSLog.e("weishi-Request", localStringBuilder.toString());
    return paramArrayOfByte;
  }
  
  private stReqHeader p()
  {
    stReqHeader localstReqHeader = new stReqHeader();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = ((AppRuntime)localObject1).getAccount();
    Object localObject2 = (TicketManager)((AppRuntime)localObject1).getManager(2);
    if ((localObject2 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())))
    {
      localObject1 = ((TicketManager)localObject2).getSkey(((AppRuntime)localObject1).getAccount());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("session key:");
      ((StringBuilder)localObject2).append((String)localObject1);
      Log.e("weishi", ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject1 = "test-key";
    }
    localstReqHeader.authInfo = WSQQConnectAuthManager.a().a((String)localObject3, (String)localObject1, d());
    localstReqHeader.iChid = 0;
    localstReqHeader.person_id = WeishiHeaderConst.a;
    localstReqHeader.platform = "Android";
    localstReqHeader.appversion = WSDeviceUtils.b(BaseApplicationImpl.getContext());
    localstReqHeader.user_ip = WSDeviceUtils.b();
    localstReqHeader.strQua = QUA.getQUA3();
    localstReqHeader.device_info = WSDeviceUtils.c();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("device_info:");
    ((StringBuilder)localObject2).append(localstReqHeader.device_info);
    WSLog.b("weishi-810", ((StringBuilder)localObject2).toString());
    localstReqHeader.h265key = a();
    localstReqHeader.appid = 1101083114;
    if ("stWeishiReportReq".equals(uniKey())) {
      localstReqHeader.mapExt = q();
    } else {
      localstReqHeader.mapExt = new HashMap();
    }
    if (localstReqHeader.mapExt != null)
    {
      localstReqHeader.mapExt.put("iAuthType", "2");
      Map localMap = localstReqHeader.mapExt;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localMap.put("sUid", localObject2);
      localObject3 = localstReqHeader.mapExt;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      ((Map)localObject3).put("sSessionKey", localObject2);
      localObject2 = UserActionReportPresenter.a(BaseApplicationImpl.getContext());
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "000000000000000";
      }
      localstReqHeader.mapExt.put("imei", localObject1);
      localObject2 = UserActionReportPresenter.b(BaseApplicationImpl.getContext());
      localObject3 = localstReqHeader.mapExt;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((Map)localObject3).put("qimei", localObject1);
      localObject2 = UserAction.getQimeiNew();
      localObject3 = localstReqHeader.mapExt;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((Map)localObject3).put("qimei36", localObject1);
      localObject2 = UserActionReportPresenter.c(BaseApplicationImpl.getContext());
      localObject3 = localstReqHeader.mapExt;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((Map)localObject3).put("ssid", localObject1);
      localObject2 = a(UserActionReportPresenter.d(BaseApplicationImpl.getContext()));
      localObject3 = localstReqHeader.mapExt;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((Map)localObject3).put("ssid_ip", localObject1);
      localstReqHeader.mapExt.put("ab_policy_info", b());
      localstReqHeader.mapExt.put("teen_mode", String.valueOf(WSNetUtil.b()));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[WeishiRequest.java][getHeader] mCmd:");
      ((StringBuilder)localObject1).append(this.u);
      ((StringBuilder)localObject1).append(", mReqScene:");
      ((StringBuilder)localObject1).append(this.o);
      ((StringBuilder)localObject1).append(", header:");
      ((StringBuilder)localObject1).append(localstReqHeader.mapExt.toString());
      WSLog.e("weishi-Request", ((StringBuilder)localObject1).toString());
    }
    else
    {
      WSLog.a("weishi-Request", "header mapExt is null.");
    }
    localstReqHeader.iAppVersion = WSDeviceUtils.a();
    return localstReqHeader;
  }
  
  private Map<String, String> q()
  {
    Object localObject1 = this.c;
    if ((localObject1 instanceof stWeishiReportReq))
    {
      localObject1 = ((stWeishiReportReq)localObject1).report_list;
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject1 = (stReportItem)((ArrayList)localObject1).get(0);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("上报取 pageType: ");
        ((StringBuilder)localObject2).append(((stReportItem)localObject1).pagetype);
        Log.i("weishi-Request", ((StringBuilder)localObject2).toString());
        localObject2 = (Map)n.get(Integer.valueOf(((stReportItem)localObject1).pagetype));
        if ((localObject2 != null) && (((Map)localObject2).size() > 0))
        {
          Iterator localIterator = ((Map)localObject2).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("取出来");
            localStringBuilder.append(uniKey());
            localStringBuilder.append(" --- key: ");
            localStringBuilder.append((String)localEntry.getKey());
            localStringBuilder.append(", value: ");
            localStringBuilder.append((String)localEntry.getValue());
            Log.i("weishi-Request", localStringBuilder.toString());
            if (("qq_abtest".equals(localEntry.getKey())) && (((stReportItem)localObject1).optype == 121))
            {
              localEntry.setValue("");
              Log.w("weishi-Request", "初始化上报，qq_abtest");
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("清空后qq_abtest的值是");
              localStringBuilder.append((String)localEntry.getValue());
              Log.w("weishi-Request", localStringBuilder.toString());
            }
          }
          return localObject2;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("没有pageType为");
        ((StringBuilder)localObject2).append(((stReportItem)localObject1).pagetype);
        ((StringBuilder)localObject2).append("的extMap");
        Log.i("weishi-Request", ((StringBuilder)localObject2).toString());
        return new HashMap();
      }
    }
    return new HashMap();
  }
  
  public final <T1> T1 a(byte[] paramArrayOfByte, String paramString, T1 paramT1)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT1);
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("weishi-Request", paramArrayOfByte.getLocalizedMessage());
    }
    return null;
  }
  
  protected void a(UniAttribute paramUniAttribute, int paramInt1, int paramInt2, String paramString)
  {
    a(paramUniAttribute, paramInt1, paramInt2, paramString, true);
  }
  
  public void a(IWeishiProtocolListener paramIWeishiProtocolListener)
  {
    this.l = paramIWeishiProtocolListener;
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    this.h = System.currentTimeMillis();
    Object localObject1 = null;
    if (paramFromServiceMsg != null)
    {
      Object localObject2 = paramFromServiceMsg.getAttribute("_tag_socket");
      boolean bool2 = false;
      if (localObject2 != null)
      {
        localObject2 = localObject2.toString().split(":");
        if ((localObject2 != null) && (localObject2.length > 1))
        {
          this.b.put("key_request_server_ip", localObject2[0]);
          this.b.put("key_request_server_port", localObject2[1]);
        }
      }
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject2 = paramFromServiceMsg.getWupBuffer();
        if (localObject2 != null) {
          this.j = localObject2.length;
        }
        this.i = (this.h - this.g);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("old cost=");
        localStringBuilder.append(this.i);
        Log.w("weishi-Server", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("cmd=");
        localStringBuilder.append(i());
        localStringBuilder.append(",response size=");
        localStringBuilder.append(this.j);
        localStringBuilder.append(",request size=");
        localStringBuilder.append(this.k);
        Log.i("weishi-Server", localStringBuilder.toString());
        if (localObject2 != null) {
          localObject1 = WupUtil.b((byte[])localObject2);
        }
        a((byte[])localObject1, paramFromServiceMsg);
        return;
      }
      localObject1 = paramFromServiceMsg.extraData;
      localObject2 = paramFromServiceMsg.getBusinessFailMsg();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errMsg:");
      localStringBuilder.append((String)localObject2);
      Log.e("weishi-Request", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errMsg:");
      localStringBuilder.append((String)localObject2);
      a("key_report_detail_msg", localStringBuilder.toString());
      if ((!this.f) && (o()) && (localObject1 != null))
      {
        boolean bool1 = bool2;
        if (a((Bundle)localObject1, "timestamp_msf2net_atMsfSite") > 0L) {
          if (paramFromServiceMsg.getResultCode() != 1002)
          {
            bool1 = bool2;
            if (paramFromServiceMsg.getResultCode() != 1013) {}
          }
          else
          {
            bool1 = true;
          }
        }
        this.f = bool1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("cmd=");
        ((StringBuilder)localObject1).append(uniKey());
        ((StringBuilder)localObject1).append(", appSeq:");
        ((StringBuilder)localObject1).append(paramFromServiceMsg.getAppSeq());
        ((StringBuilder)localObject1).append(", resultcode:");
        ((StringBuilder)localObject1).append(paramFromServiceMsg.getResultCode());
        ((StringBuilder)localObject1).append(" need retry send request");
        Log.i("weishi-Request", ((StringBuilder)localObject1).toString());
      }
      a(null, paramFromServiceMsg.getResultCode() + 300000, paramFromServiceMsg.getResultCode() + 300000, null);
      return;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append(uniKey());
    paramFromServiceMsg.append(" MSF response is null");
    Log.e("weishi-Request", paramFromServiceMsg.toString());
    a(null, 1000000, 1000000, "");
  }
  
  protected void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Log.i("weishi-request", "doSuccessCallback!!");
    IWeishiProtocolListener localIWeishiProtocolListener = this.l;
    if (localIWeishiProtocolListener != null) {
      localIWeishiProtocolListener.a(paramObject, paramInt1, paramInt2, paramString, paramBoolean, null);
    }
  }
  
  protected void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, RspHeaderBean paramRspHeaderBean)
  {
    Log.i("weishi-request", "doSuccessCallback!!");
    IWeishiProtocolListener localIWeishiProtocolListener = this.l;
    if (localIWeishiProtocolListener != null) {
      localIWeishiProtocolListener.a(paramObject, paramInt1, paramInt2, paramString, paramBoolean, paramRspHeaderBean);
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    this.b.put(paramObject1, paramObject2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte, FromServiceMsg paramFromServiceMsg)
  {
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("cmd=");
      paramArrayOfByte.append(uniKey());
      paramArrayOfByte.append(" QZoneRequest decodeAndCallback() data is null");
      QZLog.e("QZLog", paramArrayOfByte.toString());
      a(null, 1000003, 1000003, "");
      return;
    }
    Object localObject1 = new WNSStream();
    try
    {
      Object localObject2 = ((WNSStream)localObject1).unpack(paramArrayOfByte);
      paramArrayOfByte = new UniAttributeW();
      if ((localObject2 != null) && (((QmfDownstream)localObject2).WnsCode == 0))
      {
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject2).Extra);
        localObject1 = (QmfServerInfo)paramArrayOfByte.get("server_info");
        if (WebAppIpManager.isValidServerInfo((QmfServerInfo)localObject1))
        {
          WebAppIpManager.getInstance().addWebAppIpRecord((QmfServerInfo)localObject1);
          this.b.put("key_report_busi_serverip", NetworkState.IntAddr2Ip(((QmfServerInfo)localObject1).ipWebapp.ClientIpv4));
        }
        localObject1 = (QmfBusiControl)paramArrayOfByte.get("busiCompCtl");
        if ((localObject1 != null) && (1 == ((QmfBusiControl)localObject1).compFlag))
        {
          localObject1 = WNSStream.decompress(((QmfDownstream)localObject2).BusiBuff);
          if (localObject1 != null)
          {
            ((QmfDownstream)localObject2).BusiBuff = ((byte[])localObject1);
          }
          else
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("cmd=");
            paramFromServiceMsg.append(uniKey());
            paramFromServiceMsg.append(" WeishiRequest decompress error");
            QZLog.e("QZLog", paramFromServiceMsg.toString());
            a(paramArrayOfByte, 1000002, 1000002, "");
            return;
          }
        }
        Object localObject3 = (ParameterizedType)getClass().getGenericSuperclass();
        if (localObject3 != null)
        {
          localObject1 = a((QmfDownstream)localObject2, this.o);
          localObject3 = (Class)localObject3.getActualTypeArguments()[0];
          if (a((RspHeaderBean)localObject1))
          {
            localObject2 = a(((QmfDownstream)localObject2).BusiBuff);
            if (localObject2 != null) {
              paramArrayOfByte = JceUtils.decodeWup((Class)localObject3, (byte[])localObject2);
            } else {
              a(paramArrayOfByte, 2000003, 2000003, "rsp gzip decompress error");
            }
          }
          else
          {
            paramArrayOfByte = a((QmfDownstream)localObject2, (Class)localObject3);
          }
          if (paramArrayOfByte == null) {
            Log.w("weishi-Request", "微视公众号 解包失败!!");
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pageType scene：");
          ((StringBuilder)localObject2).append(this.o);
          Log.i("weishi-Request", ((StringBuilder)localObject2).toString());
          a(paramArrayOfByte, paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getBusinessFailMsg(), this.z, (RspHeaderBean)localObject1);
          return;
        }
        Log.w("weishi-Request", "泛型匹配错误");
        a(paramArrayOfByte, ((QmfDownstream)localObject2).WnsCode, ((QmfDownstream)localObject2).WnsCode, WnsError.getErrorMessage(((QmfDownstream)localObject2).WnsCode));
        return;
      }
      if (localObject2 != null)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("cmd=");
        paramFromServiceMsg.append(uniKey());
        paramFromServiceMsg.append(" WeishiRequest decodeAndCallback wnscode=");
        paramFromServiceMsg.append(((QmfDownstream)localObject2).WnsCode);
        paramFromServiceMsg.append(",msg=");
        paramFromServiceMsg.append(WnsError.getErrorMessage(((QmfDownstream)localObject2).WnsCode));
        QZLog.e("QZLog", paramFromServiceMsg.toString());
        a(paramArrayOfByte, ((QmfDownstream)localObject2).WnsCode, ((QmfDownstream)localObject2).WnsCode, WnsError.getErrorMessage(((QmfDownstream)localObject2).WnsCode));
        return;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("cmd=");
      paramFromServiceMsg.append(uniKey());
      paramFromServiceMsg.append(" WeishiRequest unpack error,result is null");
      QZLog.e("QZLog", paramFromServiceMsg.toString());
      a(paramArrayOfByte, 1000003, 1000003, "");
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = QZLog.getStackTraceString(paramArrayOfByte);
      if (paramArrayOfByte != null) {
        a("key_report_detail_msg", paramArrayOfByte);
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("cmd=");
      paramFromServiceMsg.append(uniKey());
      paramFromServiceMsg.append(" WeishiRequest decodeAndCallback occur exception. stack info:");
      paramFromServiceMsg.append(paramArrayOfByte);
      QZLog.e("QZLog", paramFromServiceMsg.toString());
      a(null, 1000001, 1000001, "");
    }
  }
  
  protected String b()
  {
    if (c())
    {
      String str = WSExpABTestManager.a().d();
      if (str != null) {
        return str;
      }
      return "";
    }
    return "";
  }
  
  public void b(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return true;
  }
  
  public String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("st");
    localStringBuilder.append(this.y);
    localStringBuilder.append("Rsp");
    return localStringBuilder.toString();
  }
  
  public byte[] encode()
  {
    Object localObject1 = getDeviceInfo();
    Object localObject2 = QUA.getQUA3();
    long l1 = getLoginUserId();
    RetryInfo localRetryInfo = (RetryInfo)getRetryInfo();
    localObject1 = new WNSStream(1000027, (String)localObject2, l1, new byte[0], (String)localObject1, localRetryInfo);
    localObject2 = getEncodedUniParameter();
    if (localObject2 != null) {
      return WupUtil.a(((WNSStream)localObject1).pack(MsfSdkUtils.getNextAppSeq(), getCmdString(), (byte[])localObject2, this.e));
    }
    return null;
  }
  
  public int f()
  {
    return this.v;
  }
  
  public boolean g()
  {
    return this.w;
  }
  
  public String getCmdString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.s);
    localStringBuilder.append(this.u);
    return localStringBuilder.toString();
  }
  
  protected byte[] getEncodedUniParameter()
  {
    Object localObject = p();
    if (localObject != null) {}
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("encode, reqHeader = ");
      localStringBuilder1.append(((stReqHeader)localObject).toString());
      Log.d("weishi-Request", localStringBuilder1.toString());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("encode get header error, e = ");
      localStringBuilder3.append(localException.toString());
      Log.e("weishi-Request", localStringBuilder3.toString());
    }
    Log.d("weishi-Request", "encode, reqHeader = null");
    this.m = new WSUniPacket();
    this.m.b(this.q);
    this.q += 1;
    this.m.a("king");
    this.m.b(j());
    this.m.setEncodeName("UTF-8");
    this.m.put("stReqHeader", localObject);
    this.m.a(9999);
    if ((this.c != null) && (!TextUtils.isEmpty(i())))
    {
      localObject = this.m;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("st");
      localStringBuilder2.append(j());
      localStringBuilder2.append("Req");
      ((WSUniPacket)localObject).put(localStringBuilder2.toString(), this.c);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("req名 :st");
      ((StringBuilder)localObject).append(j());
      ((StringBuilder)localObject).append("Req");
      Log.i("weishi-Request", ((StringBuilder)localObject).toString());
    }
    return this.m.encode();
  }
  
  public JceStruct getReq()
  {
    return this.c;
  }
  
  public Object getRetryInfo()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public long h()
  {
    return this.x;
  }
  
  public String i()
  {
    return this.u;
  }
  
  public String j()
  {
    return this.r;
  }
  
  public int k()
  {
    return this.o;
  }
  
  public boolean l()
  {
    return this.A;
  }
  
  public boolean m()
  {
    return this.B;
  }
  
  public WSGzipCompressInfo n()
  {
    return this.t;
  }
  
  protected boolean o()
  {
    return false;
  }
  
  public String uniKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("st");
    localStringBuilder.append(this.y);
    localStringBuilder.append("Req");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest
 * JD-Core Version:    0.7.0.1
 */