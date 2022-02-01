package com.tencent.biz.pubaccount.readinjoy.channelbanner;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.DynamicBannerItem;
import tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.ReqBody;
import tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule;", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;Landroid/os/Handler;)V", "bannerInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule$ChannelBannerInfo;", "requestTimeMap", "", "getChannelBannerInfoList", "channelId", "getPageName", "", "dynamicJson", "handleReceiveChannelBannerInfo", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "onReceive", "requestChannelBannerInfo", "serviceType", "unInitialize", "ChannelBannerInfo", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerModule
  extends ReadInJoyEngineModule
{
  public static final RIJChannelBannerModule.Companion a;
  private final ConcurrentHashMap<Integer, List<RIJChannelBannerModule.ChannelBannerInfo>> a;
  private final ConcurrentHashMap<Integer, Long> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerModule$Companion = new RIJChannelBannerModule.Companion(null);
  }
  
  public RIJChannelBannerModule(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("pts_page_name");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "jsonObject.optString(PTS_LITE_PAGE_NAME)");
      return paramString;
    }
    catch (JSONException paramString)
    {
      QLog.e("RIJChannelBannerModule", 1, "[getPageName] failed, e = " + paramString);
    }
    return "";
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    paramToServiceMsg = new oidb_cmd0xea0.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)paramToServiceMsg);
    QLog.i("RIJChannelBannerModule", 1, "[handleReceiveChannelBannerInfo], result = " + i);
    if (i == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.channel_id;
      label102:
      RIJChannelBannerModule.ChannelBannerInfo localChannelBannerInfo;
      if (paramFromServiceMsg != null)
      {
        i = (int)paramFromServiceMsg.get();
        paramFromServiceMsg = new ArrayList();
        paramObject = paramToServiceMsg.dynamic_banner_list;
        if ((!paramObject.has()) || (paramObject.size() <= 0)) {
          break label326;
        }
        int k = paramObject.size();
        if (j >= k) {
          break label326;
        }
        paramToServiceMsg = paramObject.get(j);
        Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "dynamicBannerList[i]");
        oidb_cmd0xea0.DynamicBannerItem localDynamicBannerItem = (oidb_cmd0xea0.DynamicBannerItem)paramToServiceMsg;
        localChannelBannerInfo = new RIJChannelBannerModule.ChannelBannerInfo();
        localChannelBannerInfo.a(i);
        paramToServiceMsg = localDynamicBannerItem.unique_id;
        if (paramToServiceMsg == null) {
          break label308;
        }
        paramToServiceMsg = paramToServiceMsg.get();
        if (paramToServiceMsg == null) {
          break label308;
        }
        paramToServiceMsg = paramToServiceMsg.toString();
        if (paramToServiceMsg == null) {
          break label308;
        }
        label172:
        localChannelBannerInfo.a(paramToServiceMsg);
        paramToServiceMsg = localDynamicBannerItem.dynamic_json;
        if (paramToServiceMsg == null) {
          break label314;
        }
        paramToServiceMsg = paramToServiceMsg.get();
        if (paramToServiceMsg == null) {
          break label314;
        }
        paramToServiceMsg = paramToServiceMsg.toString();
        if (paramToServiceMsg == null) {
          break label314;
        }
        label206:
        localChannelBannerInfo.c(paramToServiceMsg);
        paramToServiceMsg = localDynamicBannerItem.card_report_json;
        if (paramToServiceMsg == null) {
          break label320;
        }
        paramToServiceMsg = paramToServiceMsg.get();
        if (paramToServiceMsg == null) {
          break label320;
        }
        paramToServiceMsg = paramToServiceMsg.toString();
        if (paramToServiceMsg == null) {
          break label320;
        }
      }
      for (;;)
      {
        localChannelBannerInfo.d(paramToServiceMsg);
        localChannelBannerInfo.b(a(localChannelBannerInfo.c()));
        paramFromServiceMsg.add(localChannelBannerInfo);
        QLog.i("RIJChannelBannerModule", 1, "[handleReceiveChannelBannerInfo], channelBannerInfo: " + localChannelBannerInfo);
        j += 1;
        break label102;
        i = 0;
        break;
        label308:
        paramToServiceMsg = "";
        break label172;
        label314:
        paramToServiceMsg = "";
        break label206;
        label320:
        paramToServiceMsg = "";
      }
      label326:
      ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Integer.valueOf(i), paramFromServiceMsg);
      ReadInJoyLogicEngineEventDispatcher.a().d(i, (List)paramFromServiceMsg);
    }
  }
  
  @Nullable
  public final List<RIJChannelBannerModule.ChannelBannerInfo> a(int paramInt)
  {
    return (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (!RIJChannelBannerUtil.a.a(paramInt1))
    {
      QLog.i("RIJChannelBannerModule", 1, "[requestChannelBannerInfo] do not request, channelId = " + paramInt1);
      return;
    }
    RIJChannelBannerUtil localRIJChannelBannerUtil = RIJChannelBannerUtil.a;
    Object localObject = (Long)this.b.get(Integer.valueOf(paramInt1));
    if (localObject != null) {}
    while (!localRIJChannelBannerUtil.a(((Long)localObject).longValue()))
    {
      QLog.i("RIJChannelBannerModule", 1, "[requestChannelBannerInfo] do not request, limit request frequency.");
      return;
      localObject = Long.valueOf(0L);
    }
    localObject = new oidb_cmd0xea0.ReqBody();
    ((oidb_cmd0xea0.ReqBody)localObject).req_client_type.set(1);
    ((oidb_cmd0xea0.ReqBody)localObject).version.set("8.5.5");
    ((oidb_cmd0xea0.ReqBody)localObject).channel_id.set(paramInt1);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xea0", 3744, paramInt2, ((oidb_cmd0xea0.ReqBody)localObject).toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyOidbHelper.make…e, reqBody.toByteArray())");
    a((ToServiceMsg)localObject);
    long l = System.currentTimeMillis();
    ((Map)this.b).put(Integer.valueOf(paramInt1), Long.valueOf(l));
    QLog.i("RIJChannelBannerModule", 1, "[requestChannelBannerInfo], channelId = " + paramInt1 + ", serviceType = " + paramInt2 + ", timeStamp = " + l);
  }
  
  public void a(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    if (paramFromServiceMsg != null) {}
    for (String str = paramFromServiceMsg.getServiceCmd();; str = null)
    {
      if (TextUtils.equals((CharSequence)str, (CharSequence)"OidbSvc.0xea0")) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerModule
 * JD-Core Version:    0.7.0.1
 */