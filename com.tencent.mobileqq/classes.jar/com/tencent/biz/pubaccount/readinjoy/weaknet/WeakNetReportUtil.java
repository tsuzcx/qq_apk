package com.tencent.biz.pubaccount.readinjoy.weaknet;

import android.content.Context;
import android.os.Build;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/weaknet/WeakNetReportUtil;", "", "()V", "ACTION_FEEDS_REFRESH", "", "ACTION_NETWORK_CHANGED", "TAG", "feedsReportSwitch", "", "report68bFeedsRequest", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "report68bRequestNetworkChanged", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "result", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeakNetReportUtil
{
  public static final WeakNetReportUtil a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyWeaknetWeakNetReportUtil = new WeakNetReportUtil();
  }
  
  public final void a(@NotNull ToServiceMsg paramToServiceMsg, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    QLog.i("WeakNetReportUtil", 1, "[report68bRequestNetworkChanged]");
    Object localObject = paramToServiceMsg.getAttribute("sendNetType");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    int i = ((Integer)localObject).intValue();
    localObject = paramToServiceMsg.getAttribute("sendIsNetConnected");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    }
    boolean bool1 = ((Boolean)localObject).booleanValue();
    paramToServiceMsg = paramToServiceMsg.getAttribute("retryIndex");
    if (paramToServiceMsg == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    int j = ((Integer)paramToServiceMsg).intValue();
    localObject = ReadInJoyUtils.a();
    int k = com.tencent.biz.common.util.NetworkUtil.a((Context)BaseApplicationImpl.context);
    boolean bool2 = com.tencent.mobileqq.utils.NetworkUtil.a();
    paramToServiceMsg = new JSONObject();
    for (;;)
    {
      try
      {
        paramToServiceMsg.put("sendNetType", i);
        if (!bool1) {
          continue;
        }
        i = 1;
        paramToServiceMsg.put("sendIsNetConnected", i);
        paramToServiceMsg.put("retryIndex", j);
        paramToServiceMsg.put("receiveNetType", k);
        if (!bool2) {
          continue;
        }
        i = 1;
        paramToServiceMsg.put("receiveNetConnected", i);
        paramToServiceMsg.put("retCode", paramInt);
        paramToServiceMsg.put("uin", localObject);
        paramToServiceMsg.put("brand", Build.BRAND);
        paramToServiceMsg.put("model", Build.MODEL);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("WeakNetReportUtil", 1, "[report68bRequestNetworkChanged], e = " + localJSONException);
        continue;
      }
      QLog.i("WeakNetReportUtil", 1, "[report68bRequestNetworkChanged], actionName = 0X800B6B4, r5 = " + paramToServiceMsg);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B6B4", "0X800B6B4", 0, 0, "", "", "", paramToServiceMsg.toString(), false);
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final void a(@NotNull HashMap<String, String> paramHashMap)
  {
    boolean bool = false;
    Intrinsics.checkParameterIsNotNull(paramHashMap, "params");
    label242:
    label245:
    for (;;)
    {
      int i;
      try
      {
        localObject = Aladdin.getConfig(405);
        if (localObject == null) {
          break label242;
        }
        i = ((AladdinConfig)localObject).getIntegerFromString("feedsReportSwitch", 0);
      }
      catch (Exception paramHashMap)
      {
        Map.Entry localEntry;
        QLog.e("WeakNetReportUtil", 1, "[report68bFeedsRequest] error, e = " + paramHashMap);
        return;
      }
      jdField_a_of_type_Boolean = bool;
      if (!jdField_a_of_type_Boolean)
      {
        QLog.i("WeakNetReportUtil", 1, "[report68bFeedsRequest] do not report.");
        return;
      }
      Object localObject = RIJTransMergeKanDianReport.a();
      paramHashMap = ((Map)paramHashMap).entrySet().iterator();
      if (paramHashMap.hasNext())
      {
        localEntry = (Map.Entry)paramHashMap.next();
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      else
      {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("brand", Build.BRAND);
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("model", Build.MODEL);
        paramHashMap = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a();
        QLog.i("WeakNetReportUtil", 1, "[report68bFeedsRequest], r5String = " + paramHashMap);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B8DE", "0X800B8DE", 0, 0, "", "", "", paramHashMap, false);
        return;
        for (;;)
        {
          if (i != 1) {
            break label245;
          }
          bool = true;
          break;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.WeakNetReportUtil
 * JD-Core Version:    0.7.0.1
 */