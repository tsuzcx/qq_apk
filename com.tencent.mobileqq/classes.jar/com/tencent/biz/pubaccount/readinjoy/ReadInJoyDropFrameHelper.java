package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGroundCallback;
import com.tencent.biz.pubaccount.readinjoy.weaknet.ReadInJoyPTSCostHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.content.ReadInJoyDataProviderObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class ReadInJoyDropFrameHelper
  implements ReadinjoySPEventReport.ForeBackGroundCallback
{
  private ReadInJoyDropFrameHelper.ReadInJoyFluencyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDropFrameHelper$ReadInJoyFluencyObserver = new ReadInJoyDropFrameHelper.ReadInJoyFluencyObserver();
  private Map<Integer, Double> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<Integer, List<ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener>> b = new HashMap();
  private Map<String, List<Double>> c = new HashMap();
  
  private ReadInJoyDropFrameHelper()
  {
    ReadinjoySPEventReport.ForeBackGround.a(this);
    ReadInJoyDataProviderObserver.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDropFrameHelper$ReadInJoyFluencyObserver);
  }
  
  private int a(String paramString)
  {
    int i = -1;
    if ("list_new_kandian".equals(paramString)) {
      i = 0;
    }
    do
    {
      int j;
      do
      {
        return i;
        if ("list_subscript".equals(paramString)) {
          return 70;
        }
        if ((paramString == null) || (!paramString.startsWith("list_kandian_channel_"))) {
          break;
        }
        j = "list_kandian_channel_".length();
      } while (j >= paramString.length());
      return Integer.parseInt(paramString.substring(j));
      if ("list_comment_kandian".equals(paramString)) {
        return 6666;
      }
      if ("proteus_family_feeds".equals(paramString)) {
        return 8888;
      }
      if ("list_kandian_native_web".equals(paramString)) {
        return 5555;
      }
    } while (!"list_kandian_daily_new".equals(paramString));
    return 9999;
  }
  
  public static ReadInJoyDropFrameHelper a()
  {
    return ReadInJoyDropFrameHelper.DropFrameHelperHolder.a();
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("proteus_bid", ReadInJoyHelper.a("default_feeds_proteus_offline_bid"));
    localJSONObject.put("cpu_type", DeviceInfoUtil.g());
    localJSONObject.put("cpu_frequency", DeviceInfoUtil.b());
    localJSONObject.put("cache_memory", DeviceInfoUtil.a());
    localJSONObject.put("device_model", DeviceInfoUtil.d());
    localJSONObject.put("os_version", DeviceInfoUtil.e());
    if (NetworkState.isWifiConn()) {}
    for (int i = 1;; i = 2)
    {
      localJSONObject.put("network_type", i);
      localJSONObject.put("package_name", "8.5.5.5105");
      return localJSONObject;
    }
  }
  
  private void a(String paramString, double paramDouble)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDropFrameHelper.2(this, paramString, paramDouble));
  }
  
  public void a(int paramInt, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener paramOnFeedsFluencyResultListener)
  {
    if (this.b != null) {
      if (!this.b.containsKey(Integer.valueOf(paramInt))) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (List)this.b.get(Integer.valueOf(paramInt));; localObject = new ArrayList())
    {
      if (!((List)localObject).contains(paramOnFeedsFluencyResultListener)) {
        ((List)localObject).add(paramOnFeedsFluencyResultListener);
      }
      this.b.put(Integer.valueOf(paramInt), localObject);
      return;
    }
  }
  
  public void b(int paramInt, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener paramOnFeedsFluencyResultListener)
  {
    if ((this.b != null) && (this.b.get(Integer.valueOf(paramInt)) != null)) {
      ((List)this.b.get(Integer.valueOf(paramInt))).remove(paramOnFeedsFluencyResultListener);
    }
  }
  
  public void l() {}
  
  public void m()
  {
    if ((this.c == null) || (this.c.isEmpty()))
    {
      QLog.d("ReadInJoyDropFrameHelper", 2, "background | reportMap is empty");
      return;
    }
    QLog.d("ReadInJoyDropFrameHelper", 2, "background | reporFeeds Fluency");
    Iterator localIterator1 = this.c.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      List localList = (List)this.c.get(str);
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator2 = new ArrayList(localList).iterator();
        while (localIterator2.hasNext())
        {
          Double localDouble = (Double)localIterator2.next();
          a(str, localDouble.doubleValue());
          QLog.d("ReadInJoyDropFrameHelper", 2, "background | reportFeedsFluency channelid " + str + " fluencyVal " + localDouble);
        }
        localList.clear();
      }
    }
    ReadInJoyPTSCostHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper
 * JD-Core Version:    0.7.0.1
 */