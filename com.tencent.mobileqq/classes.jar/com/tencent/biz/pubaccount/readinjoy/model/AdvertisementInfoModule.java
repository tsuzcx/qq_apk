package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import lor;
import los;
import lot;
import lou;
import lov;
import low;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ArticleSummary;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.FeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PhoneInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PosAdInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.RspBody;

public class AdvertisementInfoModule
  extends ReadInJoyEngineModule
{
  private final long jdField_a_of_type_Long = 86400000L;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public AdvertisementInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "construct!");
    }
  }
  
  private int a()
  {
    switch (NetworkUtil.a(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  private List a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "loadFromDb with selection=" + "mChannelID = ?" + ", channelId=" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(AdvertisementInfo.class, true, "mChannelID = ?", new String[] { String.valueOf(paramInt) }, null, null, "mAdFetchTime desc", null);
    if (localList != null)
    {
      ReadInJoyMSFHandlerUtils.a(new ArrayList(localList));
      localArrayList.addAll(localList);
    }
    if ((localArrayList.isEmpty()) && (QLog.isColorLevel())) {
      QLog.d("AdvertisementInfoModule", 2, "loadFromDb mEntityManager.query return empty!");
    }
    return localArrayList;
  }
  
  private void a(long paramLong, ConcurrentHashMap paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap != null) && (paramConcurrentHashMap.size() > 0))
    {
      paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
      while (paramConcurrentHashMap.hasNext())
      {
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramConcurrentHashMap.next();
        if ((localAdvertisementInfo != null) && (paramLong - localAdvertisementInfo.mAdFetchTime > 86400000L))
        {
          paramConcurrentHashMap.remove();
          if (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) {
            this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lor(this, localAdvertisementInfo));
          }
          if (QLog.isColorLevel()) {
            QLog.d("AdvertisementInfoModule", 2, "filterOverTimeAdvertisement traceId=" + localAdvertisementInfo.mAdTraceId + ", fetchTime=" + localAdvertisementInfo.mAdFetchTime);
          }
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList!");
    }
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    long l = -1L;
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    if (i == 0)
    {
      if (localRspBody.uint64_uin.has()) {
        l = localRspBody.uint64_uin.get();
      }
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null) && (String.valueOf(l).equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        paramToServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        if ((paramToServiceMsg.rpt_advertise_list.has()) && (paramToServiceMsg.rpt_advertise_list.get() != null))
        {
          i = (int)paramToServiceMsg.uint64_channel_id.get();
          a(paramToServiceMsg);
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i)))
          {
            paramToServiceMsg = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
            if ((paramToServiceMsg != null) && (paramToServiceMsg.get() != null)) {
              ((FixPosArticleInterface.FixPosArticleAsyncListener)paramToServiceMsg.get()).a(i);
            }
          }
        }
      }
    }
    int j;
    do
    {
      return;
      j = ((Integer)paramToServiceMsg.getAttribute(g)).intValue();
    } while ((i != 154) || (j != 1));
    paramToServiceMsg.getAttributes().put(g, Integer.valueOf(2));
    a(paramToServiceMsg);
  }
  
  private boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    while ((TextUtils.isEmpty(paramAdvertisementInfo.mTitle)) || ((!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList)) && ((TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage)) || (TextUtils.isEmpty(paramAdvertisementInfo.mSubscribeName)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl))))) {
      return true;
    }
    return false;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x886AdvertisementReportResp!");
    }
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
    if (i != 0)
    {
      int j = ((Integer)paramToServiceMsg.getAttribute(h)).intValue();
      if ((i == 154) && (j == 1))
      {
        paramToServiceMsg.getAttributes().put(h, Integer.valueOf(2));
        a(paramToServiceMsg);
      }
    }
  }
  
  public ArrayList a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "getFixPosArticleListSync channelId=" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(b(paramInt));
    return localArrayList;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "makeReqAdvertisePara channelID=" + paramInt);
    }
    oidb_cmd0x68b.ReqAdvertisePara localReqAdvertisePara = new oidb_cmd0x68b.ReqAdvertisePara();
    localReqAdvertisePara.uint64_channel_id.set(paramInt, true);
    Object localObject = localReqAdvertisePara.uint64_last_time;
    long l;
    String str;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt)) == null)
    {
      l = 0L;
      ((PBUInt64Field)localObject).set(l, true);
      localObject = new oidb_cmd0x68b.PhoneInfo();
      str = DeviceInfoUtil.a();
      if (TextUtils.isEmpty(str)) {
        break label298;
      }
      str = MD5Utils.d(str.toLowerCase()).toLowerCase();
      ((oidb_cmd0x68b.PhoneInfo)localObject).bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
      ((oidb_cmd0x68b.PhoneInfo)localObject).uint32_muid_type.set(1);
    }
    for (;;)
    {
      paramInt = PublicAccountAdUtil.a();
      ((oidb_cmd0x68b.PhoneInfo)localObject).uint32_conn.set(paramInt);
      paramInt = 0;
      try
      {
        int i = DeviceInfoUtil.e();
        paramInt = i;
      }
      catch (Exception localException)
      {
        label160:
        break label160;
      }
      ((oidb_cmd0x68b.PhoneInfo)localObject).uint32_carrier.set(paramInt);
      str = DeviceInfoUtil.f();
      ((oidb_cmd0x68b.PhoneInfo)localObject).bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str));
      str = DeviceInfoUtil.d();
      ((oidb_cmd0x68b.PhoneInfo)localObject).bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str));
      paramInt = AppSetting.a;
      ((oidb_cmd0x68b.PhoneInfo)localObject).bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramInt)));
      str = DatalineMathUtil.a(DatalineMathUtil.a());
      ((oidb_cmd0x68b.PhoneInfo)localObject).bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str));
      ((oidb_cmd0x68b.PhoneInfo)localObject).uint32_os_type.set(2);
      ((oidb_cmd0x68b.PhoneInfo)localObject).uint64_func_flag.set(1L);
      localReqAdvertisePara.msg_phone_info.set((MessageMicro)localObject, true);
      return localReqAdvertisePara;
      l = ((Long)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt))).longValue();
      break;
      label298:
      str = DeviceInfoUtil.c(BaseApplication.getContext());
      if (!TextUtils.isEmpty(str))
      {
        str = MD5Utils.d(str.replaceAll(":", "").toUpperCase()).toLowerCase();
        ((oidb_cmd0x68b.PhoneInfo)localObject).bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
        ((oidb_cmd0x68b.PhoneInfo)localObject).uint32_muid_type.set(3);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitialize!");
    }
    this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new los(this, paramInt));
  }
  
  public void a(int paramInt, FixPosArticleInterface.FixPosArticleAsyncListener paramFixPosArticleAsyncListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "setFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), new WeakReference(paramFixPosArticleAsyncListener));
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "doUninterestAdvertisement tagId=" + paramLong + ", channelId=" + paramAdvertisementInfo.mChannelID + ", pos=" + paramAdvertisementInfo.mAdKdPos + ", traceID=" + paramAdvertisementInfo.mAdTraceId);
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf((int)paramAdvertisementInfo.mChannelID));
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.containsKey(Integer.valueOf(paramAdvertisementInfo.mAdKdPos)))) {
      localConcurrentHashMap.remove(Integer.valueOf(paramAdvertisementInfo.mAdKdPos));
    }
    if (paramAdvertisementInfo.mChannelID == 56L)
    {
      NativeAdUtils.a(null, paramContext, NativeAdUtils.c, NativeAdUtils.l, paramAdvertisementInfo, null, (int)paramLong);
      label155:
      if (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) {
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lov(this, paramAdvertisementInfo));
      }
    }
    else
    {
      if (!ReadInJoyUtils.a(paramAdvertisementInfo)) {
        break label216;
      }
    }
    label216:
    for (int i = NativeAdUtils.o;; i = NativeAdUtils.k)
    {
      NativeAdUtils.a(null, paramContext, NativeAdUtils.c, i, paramAdvertisementInfo, null, (int)paramLong);
      break label155;
      break;
    }
  }
  
  public void a(AppInterface paramAppInterface, AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      Object localObject2 = new JSONObject(paramAdvertisementInfo.mAdExt);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("traceid", paramAdvertisementInfo.mAdTraceId);
      ((JSONObject)localObject1).put("rl", paramAdvertisementInfo.mAdRl);
      ((JSONObject)localObject1).put("productid", paramAdvertisementInfo.mAdProductId);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "native object is null");
        }
      }
      else
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoUrl", paramAdvertisementInfo.mVideoVid);
        localJSONObject.put("coverUrl", paramAdvertisementInfo.mVideoCoverUrl);
        localJSONObject.put("duration", paramAdvertisementInfo.mVideoDuration);
        ((JSONObject)localObject1).put("video", localJSONObject);
        ((JSONObject)localObject1).put("native", ((JSONObject)localObject2).getJSONObject("native"));
        localObject2 = new JSONArray();
        ((JSONArray)localObject2).put(localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("uin", paramAppInterface.getAccount());
        ((JSONObject)localObject1).put("type", 3);
        ((JSONObject)localObject1).put("ads", localObject2);
        localObject2 = ((JSONObject)localObject1).toString();
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "get ad app json: " + (String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new WebSsoBody.WebSsoRequestBody();
          ((WebSsoBody.WebSsoRequestBody)localObject1).data.set((String)localObject2);
          localObject2 = new NewIntent(paramAppInterface.getApplication(), PublicAccountServlet.class);
          ((NewIntent)localObject2).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.proxy.kandian_ad_native");
          ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
          ((NewIntent)localObject2).setObserver(new low(this, paramAdvertisementInfo));
          paramAppInterface.startServlet((NewIntent)localObject2);
          return;
        }
      }
    }
    catch (JSONException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "onReceive response cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x886")) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (paramRspChannelArticle == null) {
      return;
    }
    int i = (int)paramRspChannelArticle.uint64_channel_id.get();
    long l1 = paramRspChannelArticle.uint64_pos_ad_time.get();
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp channelID=" + i + ", fetchTime=" + l1);
    }
    Object localObject1;
    Object localObject2;
    if ((paramRspChannelArticle.rpt_advertise_list.has()) && (paramRspChannelArticle.rpt_advertise_list.get() != null))
    {
      paramRspChannelArticle = paramRspChannelArticle.rpt_advertise_list.get().iterator();
      while (paramRspChannelArticle.hasNext())
      {
        localObject1 = (oidb_cmd0x68b.ArticleSummary)paramRspChannelArticle.next();
        if ((((oidb_cmd0x68b.ArticleSummary)localObject1).msg_feeds_info.has()) && (((oidb_cmd0x68b.ArticleSummary)localObject1).msg_feeds_info.get() != null) && (((oidb_cmd0x68b.FeedsInfo)((oidb_cmd0x68b.ArticleSummary)localObject1).msg_feeds_info.get()).msg_pos_ad_info.has()))
        {
          localObject2 = (oidb_cmd0x68b.PosAdInfo)((oidb_cmd0x68b.FeedsInfo)((oidb_cmd0x68b.ArticleSummary)localObject1).msg_feeds_info.get()).msg_pos_ad_info.get();
          if ((localObject2 != null) && (((oidb_cmd0x68b.PosAdInfo)localObject2).int32_ret.get() == 0))
          {
            int j = ((oidb_cmd0x68b.PosAdInfo)localObject2).enum_pos_layout.get();
            long l2 = ((oidb_cmd0x68b.PosAdInfo)localObject2).uint64_pos_id.get();
            localObject2 = new AdvertisementInfo((oidb_cmd0x68b.AdInfo)((oidb_cmd0x68b.PosAdInfo)localObject2).msg_ad_info.get());
            ReadInJoyMSFHandlerUtils.a((oidb_cmd0x68b.ArticleSummary)localObject1, i, (ArticleInfo)localObject2);
            ((AdvertisementInfo)localObject2).mAdFetchTime = l1;
            ((AdvertisementInfo)localObject2).mAdPosLayout = j;
            ((AdvertisementInfo)localObject2).mAdPosID = l2;
            if (!b((AdvertisementInfo)localObject2)) {
              localArrayList.add(localObject2);
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(i), Long.valueOf(l1));
      paramRspChannelArticle = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(i));
      if (paramRspChannelArticle != null) {
        break label665;
      }
      paramRspChannelArticle = new ConcurrentHashMap();
      this.jdField_b_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(i), paramRspChannelArticle);
    }
    label665:
    for (;;)
    {
      localObject1 = paramRspChannelArticle.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AdvertisementInfo)((Iterator)localObject1).next();
        ReadInJoyLogicEngine.a().a(i, (BaseArticleInfo)localObject2);
      }
      paramRspChannelArticle.clear();
      if (QLog.isColorLevel()) {}
      for (localObject1 = new StringBuilder("handleAdvertisementResp channelID=" + i + ", fetchTime=" + l1 + "\n");; localObject1 = null)
      {
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)((Iterator)localObject2).next();
          paramRspChannelArticle.put(Integer.valueOf(localAdvertisementInfo.mAdKdPos), localAdvertisementInfo);
          if ((QLog.isColorLevel()) && (localObject1 != null)) {
            ((StringBuilder)localObject1).append("[pos=").append(localAdvertisementInfo.mAdKdPos).append(", traceID=").append(localAdvertisementInfo.mAdTraceId).append("]\n");
          }
        }
        if ((QLog.isColorLevel()) && (localObject1 != null)) {
          QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject1).toString());
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) {
          break;
        }
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lou(this, i, localArrayList));
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp channelID=" + i + ", fetchTime=" + l1 + " parsedAdvertisementList empty!");
        return;
      }
    }
  }
  
  /* Error */
  public boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 488	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mChannelID	J
    //   6: l2i
    //   7: istore_2
    //   8: aload_0
    //   9: getfield 33	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: iload_2
    //   13: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 760	java/util/HashSet
    //   22: astore 5
    //   24: aload 5
    //   26: astore 4
    //   28: aload 5
    //   30: ifnonnull +26 -> 56
    //   33: new 760	java/util/HashSet
    //   36: dup
    //   37: invokespecial 761	java/util/HashSet:<init>	()V
    //   40: astore 4
    //   42: aload_0
    //   43: getfield 33	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   46: iload_2
    //   47: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aload 4
    //   52: invokevirtual 482	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: aload 4
    //   58: aload_1
    //   59: getfield 177	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   62: invokevirtual 764	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   65: ifne +19 -> 84
    //   68: aload 4
    //   70: aload_1
    //   71: getfield 177	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdTraceId	Ljava/lang/String;
    //   74: invokevirtual 765	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: iconst_1
    //   79: istore_3
    //   80: aload_0
    //   81: monitorexit
    //   82: iload_3
    //   83: ireturn
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -6 -> 80
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	AdvertisementInfoModule
    //   0	94	1	paramAdvertisementInfo	AdvertisementInfo
    //   7	40	2	i	int
    //   79	7	3	bool	boolean
    //   26	43	4	localHashSet1	HashSet
    //   22	7	5	localHashSet2	HashSet
    // Exception table:
    //   from	to	target	type
    //   2	24	89	finally
    //   33	56	89	finally
    //   56	78	89	finally
  }
  
  public int[] a(int paramInt)
  {
    ArrayList localArrayList = b(paramInt);
    if (localArrayList.size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "getFixPositionSync channelID=" + paramInt + " return empty!");
      }
      return new int[0];
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((AdvertisementInfo)localArrayList.get(i)).mAdKdPos;
      localStringBuilder.append(arrayOfInt[i]);
      if (i != localArrayList.size() - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "getFixPositionSync channelID=" + paramInt + " return " + localStringBuilder.toString());
    }
    return arrayOfInt;
  }
  
  public ArrayList b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((AdvertisementInfo)((Iterator)localObject).next());
      }
      Collections.sort(localArrayList, new lot(this));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("\n");
      int i = 0;
      while (i < localArrayList.size())
      {
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localArrayList.get(i);
        ((StringBuilder)localObject).append("[pos=").append(localAdvertisementInfo.mAdKdPos).append(", traceID=").append(localAdvertisementInfo.mAdTraceId).append("]");
        if (i != localArrayList.size() - 1) {
          ((StringBuilder)localObject).append("\n");
        }
        i += 1;
      }
      QLog.d("AdvertisementInfoModule", 2, "loadChannelAdvertisement channelId=" + paramInt + ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitModel!");
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (this.jdField_b_of_type_JavaUtilLinkedHashMap.size() > 0)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.values().iterator();
      while (localIterator.hasNext()) {
        a(l, (ConcurrentHashMap)localIterator.next());
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "removeFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "refreshChannelAdvertisementFormServer channelId=" + paramInt);
    }
    Object localObject = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(ReadInJoyUtils.a()).longValue();
    ((oidb_cmd0x68b.ReqBody)localObject).uint64_uin.set(l);
    ((oidb_cmd0x68b.ReqBody)localObject).uint32_network_type.set(a());
    ((oidb_cmd0x68b.ReqBody)localObject).req_advertise_para.set(a(paramInt));
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0x68b", 1675, 0, ((oidb_cmd0x68b.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put(g, Integer.valueOf(1));
    a((ToServiceMsg)localObject);
    PublicAccountReportUtils.a(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "clearAdvertisementExposureReport channelId=" + paramInt);
    }
    HashSet localHashSet = (HashSet)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localHashSet != null) {
      localHashSet.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule
 * JD-Core Version:    0.7.0.1
 */