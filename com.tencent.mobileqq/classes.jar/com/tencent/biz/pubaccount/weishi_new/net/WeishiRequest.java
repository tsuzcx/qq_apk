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
import com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSGzipCompressInfo;
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
  public static String a;
  public static Map<Integer, Map<String, String>> a;
  protected int a;
  public long a;
  public JceStruct a;
  protected transient IWeishiProtocolListener a;
  public WSUniPacket a;
  private final WSGzipCompressInfo a;
  protected HashMap<Object, Object> a;
  protected boolean a;
  public int b;
  public long b;
  public String b;
  protected volatile boolean b;
  private int jdField_c_of_type_Int;
  public long c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  public long d;
  private String jdField_d_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  public long e;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  protected long f;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private long g;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QzoneNewService.";
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public WeishiRequest(String paramString)
  {
    this("WeishiGZH.", paramString, false);
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public WeishiRequest(String paramString, int paramInt)
  {
    this("WeishiGZH.", paramString, false);
    this.jdField_f_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public WeishiRequest(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_f_of_type_Long = 30000L;
    this.jdField_b_of_type_Int = 100000;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = (paramString1 + paramString2);
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.g = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetCommonWSGzipCompressInfo = new WSGzipCompressInfo();
  }
  
  private long a(Bundle paramBundle, String paramString)
  {
    if ((paramBundle == null) || (paramString == null)) {}
    while (!paramBundle.containsKey(paramString)) {
      return 0L;
    }
    return paramBundle.getLong(paramString);
  }
  
  private stReqHeader a()
  {
    stReqHeader localstReqHeader = new stReqHeader();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ((AppRuntime)localObject1).getAccount();
    Object localObject3 = (TicketManager)((AppRuntime)localObject1).getManager(2);
    if ((localObject3 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())))
    {
      localObject1 = ((TicketManager)localObject3).getSkey(((AppRuntime)localObject1).getAccount());
      Log.e("weishi", "session key:" + (String)localObject1);
    }
    for (;;)
    {
      localstReqHeader.authInfo = WSQQConnectAuthManager.a().a((String)localObject2, (String)localObject1, b());
      localstReqHeader.iChid = 0;
      localstReqHeader.person_id = WeishiHeaderConst.jdField_a_of_type_JavaLangString;
      localstReqHeader.platform = "Android";
      localstReqHeader.appversion = WSDeviceUtils.a(BaseApplicationImpl.getContext());
      localstReqHeader.user_ip = WSDeviceUtils.a();
      localstReqHeader.strQua = QUA.getQUA3();
      localstReqHeader.device_info = WSDeviceUtils.b();
      WSLog.b("weishi-810", "device_info:" + localstReqHeader.device_info);
      localstReqHeader.h265key = a();
      localstReqHeader.appid = 1101083114;
      if ("stWeishiReportReq".equals(uniKey()))
      {
        localstReqHeader.mapExt = a();
        if (localstReqHeader.mapExt == null) {
          break label525;
        }
        localstReqHeader.mapExt.put("iAuthType", "2");
        localObject3 = localstReqHeader.mapExt;
        if (localObject2 != null) {
          break label522;
        }
        localObject2 = "";
        label242:
        ((Map)localObject3).put("sUid", localObject2);
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
        localObject2 = UserActionReportPresenter.c(BaseApplicationImpl.getContext());
        localObject3 = localstReqHeader.mapExt;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((Map)localObject3).put("ssid", localObject1);
        localObject2 = a(UserActionReportPresenter.a(BaseApplicationImpl.getContext()));
        localObject3 = localstReqHeader.mapExt;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((Map)localObject3).put("ssid_ip", localObject1);
        localstReqHeader.mapExt.put("ab_policy_info", b());
        WSLog.e("weishi-Request", "[WeishiRequest.java][getHeader] mCmd:" + this.jdField_e_of_type_JavaLangString + ", mReqScene:" + this.jdField_a_of_type_Int + ", header:" + localstReqHeader.mapExt.toString());
      }
      for (;;)
      {
        localstReqHeader.iAppVersion = WSDeviceUtils.a();
        return localstReqHeader;
        localstReqHeader.mapExt = new HashMap();
        break;
        label522:
        break label242;
        label525:
        WSLog.a("weishi-Request", "header mapExt is null.");
      }
      localObject1 = "test-key";
    }
  }
  
  @NotNull
  private RspHeaderBean a(QmfDownstream paramQmfDownstream, int paramInt)
  {
    paramQmfDownstream = (stRspHeader)a(paramQmfDownstream.BusiBuff, "stRspHeader", new stRspHeader());
    RspHeaderBean localRspHeaderBean = new RspHeaderBean();
    if ((paramQmfDownstream != null) && (paramQmfDownstream.mapExt != null))
    {
      localRspHeaderBean.jdField_a_of_type_JavaUtilMap = paramQmfDownstream.mapExt;
      Object localObject = paramQmfDownstream.mapExt;
      jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        Log.i("weishi-Request", c() + " 存进去 》》》 key: " + (String)localEntry.getKey() + ", value: " + (String)localEntry.getValue());
      }
      localObject = (String)paramQmfDownstream.mapExt.get("qq_abtest");
      Log.i("weishi-Request", "stRspHeader: {iRet=" + paramQmfDownstream.iRet + ", sErrMsg=" + paramQmfDownstream.sErrmsg + ", scene=" + paramInt + ", abTestId=" + (String)localObject + "}");
      if ("SimpleGetFeedList".equals(e())) {
        LocalMultiProcConfig.putString4Uin("key_default_test_id", (String)localObject, WeishiUtils.a());
      }
      localRspHeaderBean.jdField_a_of_type_JavaLangString = ((String)localObject);
      WSReportUtils.a(paramInt, (String)localObject);
      localObject = (String)paramQmfDownstream.mapExt.get("person_id");
      Log.d("weishi-Request", "stRspHeader: {personId=" + (String)localObject + "}");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        WeishiUtils.b((String)localObject);
      }
      if ((paramQmfDownstream.iRet == -99) && (b())) {
        WSQQConnectAuthManager.a().b();
      }
    }
    return localRspHeaderBean;
  }
  
  private Object a(QmfDownstream paramQmfDownstream, Class paramClass)
  {
    if (paramClass == stSimpleGetFeedListRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stSimpleGetFeedListRsp());
    }
    if (paramClass == stNotificationRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stNotificationRsp());
    }
    if (paramClass == stQQGetFeedCommentListV2Rsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stQQGetFeedCommentListV2Rsp());
    }
    if (paramClass == stPostFeedCommentV2Rsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stPostFeedCommentV2Rsp());
    }
    if (paramClass == stPostCommentReplyV2Rsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stPostCommentReplyV2Rsp());
    }
    if (paramClass == stGetCommentReplyListRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stGetCommentReplyListRsp());
    }
    if (paramClass == stDelCommentReplyRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stDelCommentReplyRsp());
    }
    if (paramClass == stPostCommentDingRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stPostCommentDingRsp());
    }
    if (paramClass == stDeleteFeedCommentRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stDeleteFeedCommentRsp());
    }
    if (paramClass == stPostFeedDingRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stPostFeedDingRsp());
    }
    if (paramClass == stWeishiReportRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stWeishiReportRsp());
    }
    if (paramClass == stFollowFeedsRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stFollowFeedsRsp());
    }
    if (paramClass == stRedDotRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stRedDotRsp());
    }
    if (paramClass == stSimpleGetFeedDetailRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stSimpleGetFeedDetailRsp());
    }
    if (paramClass == stBlockRecommPersonRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stBlockRecommPersonRsp());
    }
    if (paramClass == stFollowRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stFollowRsp());
    }
    if (paramClass == stPublisherRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stPublisherRsp());
    }
    if (paramClass == stWeishiDengtaReportRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stWeishiDengtaReportRsp());
    }
    if (paramClass == stUserConfigRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stUserConfigRsp());
    }
    if (paramClass == stGetCollectionRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stGetCollectionRsp());
    }
    if (paramClass == stFriendFeedRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stFriendFeedRsp());
    }
    if (paramClass == stGetPersonalFeedListRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stGetPersonalFeedListRsp());
    }
    if (paramClass == stQQGroupDetailRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stQQGroupDetailRsp());
    }
    if (paramClass == stGetAIOFeedDetailRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stGetAIOFeedDetailRsp());
    }
    if (paramClass == stGetAllABTestPolicyRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stGetAllABTestPolicyRsp());
    }
    if (paramClass == stGetTabsRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stGetTabsRsp());
    }
    if (paramClass == stGetFeedIconOpRsp.class) {
      return a(paramQmfDownstream.BusiBuff, c(), new stGetFeedIconOpRsp());
    }
    Log.e("weishi-Request", "response无法匹配");
    return null;
  }
  
  public static String a()
  {
    String str = "" + Build.MODEL;
    str = str + "&";
    str = str + Build.VERSION.RELEASE;
    str = str + "&";
    str = str + Build.VERSION.SDK_INT;
    str = str + "&";
    return str + WSDeviceUtils.b();
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  private Map<String, String> a()
  {
    if ((this.jdField_a_of_type_ComQqTafJceJceStruct instanceof stWeishiReportReq))
    {
      Object localObject = ((stWeishiReportReq)this.jdField_a_of_type_ComQqTafJceJceStruct).report_list;
      if (((ArrayList)localObject).size() > 0)
      {
        stReportItem localstReportItem = (stReportItem)((ArrayList)localObject).get(0);
        Log.i("weishi-Request", "上报取 pageType: " + localstReportItem.pagetype);
        Map localMap = (Map)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localstReportItem.pagetype));
        if ((localMap != null) && (localMap.size() > 0))
        {
          Iterator localIterator = localMap.entrySet().iterator();
          for (;;)
          {
            localObject = localMap;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (Map.Entry)localIterator.next();
            Log.i("weishi-Request", "取出来" + uniKey() + " --- key: " + (String)((Map.Entry)localObject).getKey() + ", value: " + (String)((Map.Entry)localObject).getValue());
            if (("qq_abtest".equals(((Map.Entry)localObject).getKey())) && (localstReportItem.optype == 121))
            {
              ((Map.Entry)localObject).setValue("");
              Log.w("weishi-Request", "初始化上报，qq_abtest");
              Log.w("weishi-Request", "清空后qq_abtest的值是" + (String)((Map.Entry)localObject).getValue());
            }
          }
        }
        Log.i("weishi-Request", "没有pageType为" + localstReportItem.pagetype + "的extMap");
        localObject = new HashMap();
        return localObject;
      }
    }
    return new HashMap();
  }
  
  private static boolean a(RspHeaderBean paramRspHeaderBean)
  {
    if ((paramRspHeaderBean == null) || (paramRspHeaderBean.jdField_a_of_type_JavaUtilMap == null))
    {
      WSLog.e("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] rspHeader or mapExt is null");
      return false;
    }
    if (!paramRspHeaderBean.jdField_a_of_type_JavaUtilMap.containsKey("qq_compressed"))
    {
      WSLog.e("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] rsp is not compress");
      return false;
    }
    return true;
  }
  
  private <T extends JceStruct> byte[] a(byte[] paramArrayOfByte)
  {
    long l = System.currentTimeMillis();
    a(true);
    paramArrayOfByte = (stCompressedData)a(paramArrayOfByte, "stCompressedData", new stCompressedData());
    if (paramArrayOfByte == null)
    {
      WSLog.e("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] rsp is compress, but decodeJce failure");
      return null;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = paramArrayOfByte.compressed;
        i = paramArrayOfByte.length;
        paramArrayOfByte = GZipUtil.a(paramArrayOfByte);
        int j;
        Object localObject;
        WSLog.d("weishi-Request", "[WSResponseDecoder.java][checkRspCompress] exception:" + localException1.getLocalizedMessage());
      }
      catch (Exception localException1)
      {
        try
        {
          j = paramArrayOfByte.length;
          localObject = Arrays.copyOfRange(paramArrayOfByte, 1, j);
          paramArrayOfByte = (byte[])localObject;
        }
        catch (Exception localException2)
        {
          int i;
          break label159;
        }
        try
        {
          localObject = a();
          ((WSGzipCompressInfo)localObject).a(i);
          ((WSGzipCompressInfo)localObject).b(j);
          ((WSGzipCompressInfo)localObject).a(i / j);
          localObject = new StringBuilder().append("[WSResponseDecoder.java][checkRspCompress] decompress and decodeJce success. dataSize:");
          if (paramArrayOfByte == null) {
            break label192;
          }
          i = paramArrayOfByte.length;
          WSLog.e("weishi-Request", i + ", cost:" + (System.currentTimeMillis() - l));
          return paramArrayOfByte;
        }
        catch (Exception localException3)
        {
          break label159;
        }
        localException1 = localException1;
        paramArrayOfByte = null;
      }
      label159:
      continue;
      label192:
      i = 0;
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    return this.g;
  }
  
  public WSGzipCompressInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetCommonWSGzipCompressInfo;
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
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  protected void a(UniAttribute paramUniAttribute, int paramInt1, int paramInt2, String paramString)
  {
    a(paramUniAttribute, paramInt1, paramInt2, paramString, true);
  }
  
  public void a(IWeishiProtocolListener paramIWeishiProtocolListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetIWeishiProtocolListener = paramIWeishiProtocolListener;
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = true;
    Object localObject1 = null;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (paramFromServiceMsg != null)
    {
      Object localObject2 = paramFromServiceMsg.getAttribute("_tag_socket");
      if (localObject2 != null)
      {
        localObject2 = localObject2.toString().split(":");
        if ((localObject2 != null) && (localObject2.length > 1))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("key_request_server_ip", localObject2[0]);
          this.jdField_a_of_type_JavaUtilHashMap.put("key_request_server_port", localObject2[1]);
        }
      }
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject2 = paramFromServiceMsg.getWupBuffer();
        if (localObject2 != null) {
          this.jdField_d_of_type_Long = localObject2.length;
        }
        this.jdField_c_of_type_Long = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
        Log.w("weishi-Server", "old cost=" + this.jdField_c_of_type_Long);
        Log.i("weishi-Server", "cmd=" + d() + ",response size=" + this.jdField_d_of_type_Long + ",request size=" + this.jdField_e_of_type_Long);
        if (localObject2 != null) {
          localObject1 = WupUtil.b((byte[])localObject2);
        }
        a((byte[])localObject1, paramFromServiceMsg);
        return;
      }
      localObject1 = paramFromServiceMsg.extraData;
      localObject2 = paramFromServiceMsg.getBusinessFailMsg();
      Log.e("weishi-Request", "errMsg:" + (String)localObject2);
      a("key_report_detail_msg", "errMsg:" + (String)localObject2);
      if ((!this.jdField_b_of_type_Boolean) && (f()) && (localObject1 != null))
      {
        if (a((Bundle)localObject1, "timestamp_msf2net_atMsfSite") <= 0L) {
          break label448;
        }
        bool1 = bool2;
        if (paramFromServiceMsg.getResultCode() != 1002) {
          if (paramFromServiceMsg.getResultCode() != 1013) {
            break label448;
          }
        }
      }
      label448:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jdField_b_of_type_Boolean = bool1;
        Log.i("weishi-Request", "cmd=" + uniKey() + ", appSeq:" + paramFromServiceMsg.getAppSeq() + ", resultcode:" + paramFromServiceMsg.getResultCode() + " need retry send request");
        a(null, paramFromServiceMsg.getResultCode() + 300000, paramFromServiceMsg.getResultCode() + 300000, null);
        return;
      }
    }
    Log.e("weishi-Request", uniKey() + " MSF response is null");
    a(null, 1000000, 1000000, "");
  }
  
  protected void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Log.i("weishi-request", "doSuccessCallback!!");
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetIWeishiProtocolListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetIWeishiProtocolListener.a(paramObject, paramInt1, paramInt2, paramString, paramBoolean, null);
    }
  }
  
  protected void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, RspHeaderBean paramRspHeaderBean)
  {
    Log.i("weishi-request", "doSuccessCallback!!");
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetIWeishiProtocolListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetIWeishiProtocolListener.a(paramObject, paramInt1, paramInt2, paramString, paramBoolean, paramRspHeaderBean);
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramObject1, paramObject2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte, FromServiceMsg paramFromServiceMsg)
  {
    if (paramArrayOfByte == null)
    {
      QZLog.e("QZLog", "cmd=" + uniKey() + " QZoneRequest decodeAndCallback() data is null");
      a(null, 1000003, 1000003, "");
      return;
    }
    Object localObject1 = new WNSStream();
    Object localObject2;
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject2 = ((WNSStream)localObject1).unpack(paramArrayOfByte);
        paramArrayOfByte = new UniAttributeW();
        if ((localObject2 == null) || (((QmfDownstream)localObject2).WnsCode != 0)) {
          break label521;
        }
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject2).Extra);
        localObject1 = (QmfServerInfo)paramArrayOfByte.get("server_info");
        if (WebAppIpManager.isValidServerInfo((QmfServerInfo)localObject1))
        {
          WebAppIpManager.getInstance().addWebAppIpRecord((QmfServerInfo)localObject1);
          this.jdField_a_of_type_JavaUtilHashMap.put("key_report_busi_serverip", NetworkState.IntAddr2Ip(((QmfServerInfo)localObject1).ipWebapp.ClientIpv4));
        }
        localObject1 = (QmfBusiControl)paramArrayOfByte.get("busiCompCtl");
        if ((localObject1 != null) && (1 == ((QmfBusiControl)localObject1).compFlag))
        {
          localObject1 = WNSStream.decompress(((QmfDownstream)localObject2).BusiBuff);
          if (localObject1 != null) {
            ((QmfDownstream)localObject2).BusiBuff = ((byte[])localObject1);
          }
        }
        else
        {
          localObject3 = (ParameterizedType)getClass().getGenericSuperclass();
          if (localObject3 == null) {
            break;
          }
          localObject1 = a((QmfDownstream)localObject2, this.jdField_a_of_type_Int);
          localObject3 = (Class)localObject3.getActualTypeArguments()[0];
          if (!a((RspHeaderBean)localObject1)) {
            break label475;
          }
          localObject2 = a(((QmfDownstream)localObject2).BusiBuff);
          if (localObject2 == null) {
            break label460;
          }
          paramArrayOfByte = JceUtils.decodeWup((Class)localObject3, (byte[])localObject2);
          if (paramArrayOfByte == null) {
            Log.w("weishi-Request", "微视公众号 解包失败!!");
          }
          Log.i("weishi-Request", "pageType scene：" + this.jdField_a_of_type_Int);
          a(paramArrayOfByte, paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getBusinessFailMsg(), this.jdField_d_of_type_Boolean, (RspHeaderBean)localObject1);
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = QZLog.getStackTraceString(paramArrayOfByte);
        if (paramArrayOfByte != null) {
          a("key_report_detail_msg", paramArrayOfByte);
        }
        QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decodeAndCallback occur exception. stack info:" + paramArrayOfByte);
        a(null, 1000001, 1000001, "");
        return;
      }
      QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decompress error");
      a(paramArrayOfByte, 1000002, 1000002, "");
      return;
      label460:
      a(paramArrayOfByte, 2000003, 2000003, "rsp gzip decompress error");
      return;
      label475:
      paramArrayOfByte = a((QmfDownstream)localObject2, (Class)localObject3);
    }
    Log.w("weishi-Request", "泛型匹配错误");
    a(paramArrayOfByte, ((QmfDownstream)localObject2).WnsCode, ((QmfDownstream)localObject2).WnsCode, WnsError.getErrorMessage(((QmfDownstream)localObject2).WnsCode));
    return;
    label521:
    if (localObject2 != null)
    {
      QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decodeAndCallback wnscode=" + ((QmfDownstream)localObject2).WnsCode + ",msg=" + WnsError.getErrorMessage(((QmfDownstream)localObject2).WnsCode));
      a(paramArrayOfByte, ((QmfDownstream)localObject2).WnsCode, ((QmfDownstream)localObject2).WnsCode, WnsError.getErrorMessage(((QmfDownstream)localObject2).WnsCode));
      return;
    }
    QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest unpack error,result is null");
    a(paramArrayOfByte, 1000003, 1000003, "");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected String b()
  {
    if (a())
    {
      String str = WSExpABTestManager.a().a();
      if (str != null) {
        return str;
      }
      return "";
    }
    return "";
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public String c()
  {
    return "st" + this.jdField_f_of_type_JavaLangString + "Rsp";
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public String d()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public String e()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean e()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public byte[] encode()
  {
    Object localObject1 = getDeviceInfo();
    Object localObject2 = QUA.getQUA3();
    long l = getLoginUserId();
    RetryInfo localRetryInfo = (RetryInfo)getRetryInfo();
    localObject1 = new WNSStream(1000027, (String)localObject2, l, new byte[0], (String)localObject1, localRetryInfo);
    localObject2 = getEncodedUniParameter();
    if (localObject2 != null) {
      return WupUtil.a(((WNSStream)localObject1).pack(MsfSdkUtils.getNextAppSeq(), getCmdString(), (byte[])localObject2, this.jdField_a_of_type_Boolean));
    }
    return null;
  }
  
  protected boolean f()
  {
    return false;
  }
  
  public String getCmdString()
  {
    return this.jdField_d_of_type_JavaLangString + this.jdField_e_of_type_JavaLangString;
  }
  
  public byte[] getEncodedUniParameter()
  {
    stReqHeader localstReqHeader = a();
    if (localstReqHeader != null) {}
    try
    {
      Log.d("weishi-Request", "encode, reqHeader = " + localstReqHeader.toString());
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWSUniPacket = new WSUniPacket();
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWSUniPacket.b(this.jdField_b_of_type_Int);
        this.jdField_b_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWSUniPacket.a("king");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWSUniPacket.b(e());
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWSUniPacket.setEncodeName("UTF-8");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWSUniPacket.put("stReqHeader", localstReqHeader);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWSUniPacket.a(9999);
        if ((this.jdField_a_of_type_ComQqTafJceJceStruct != null) && (!TextUtils.isEmpty(d())))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWSUniPacket.put("st" + e() + "Req", this.jdField_a_of_type_ComQqTafJceJceStruct);
          Log.i("weishi-Request", "req名 :st" + e() + "Req");
        }
        return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWSUniPacket.encode();
        Log.d("weishi-Request", "encode, reqHeader = null");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("weishi-Request", "encode get header error, e = " + localException.toString());
      }
    }
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public Object getRetryInfo()
  {
    if (c()) {}
    for (int i = 1;; i = 0) {
      return new RetryInfo((short)i, (short)a(), a());
    }
  }
  
  public String uniKey()
  {
    return "st" + this.jdField_f_of_type_JavaLangString + "Req";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest
 * JD-Core Version:    0.7.0.1
 */