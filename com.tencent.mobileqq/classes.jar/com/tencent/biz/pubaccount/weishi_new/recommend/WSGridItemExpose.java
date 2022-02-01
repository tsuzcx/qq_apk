package com.tencent.biz.pubaccount.weishi_new.recommend;

import UserGrowth.stCardInfo;
import UserGrowth.stCollection;
import UserGrowth.stCollectionCardInfo;
import UserGrowth.stH5OpInfo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSHandlerThread;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.Integer;LUserGrowth.stSimpleMetaFeed;>;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class WSGridItemExpose
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private WSHandlerThread jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSHandlerThread;
  private final String jdField_a_of_type_JavaLangString;
  private final Map<Integer, String> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private final Map<Integer, stSimpleMetaFeed> b = new ConcurrentHashMap();
  private final Map<Integer, String> c = new ConcurrentHashMap();
  
  public WSGridItemExpose(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  private void a(stReportItem paramstReportItem, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if ((paramstSimpleMetaFeed.video_type != 1) && (paramstSimpleMetaFeed.video_type != 6))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSGridItemExpose.java][handleOnScrollForReport] mSubTabId:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", position:");
      localStringBuilder.append(paramInt);
      WSLog.e("WSFeedsItemExposeLog", localStringBuilder.toString());
      WSGridBeaconReport.a("gzh_exposure", paramstSimpleMetaFeed, paramstReportItem, 0, this.jdField_a_of_type_JavaLangString);
    }
    this.b.put(Integer.valueOf(paramInt), paramstSimpleMetaFeed);
    this.c.put(Integer.valueOf(paramInt), paramstSimpleMetaFeed.id);
    if (this.b.size() == 8)
    {
      a(this.b, this.c);
      this.b.clear();
      this.c.clear();
    }
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, Integer paramInteger)
  {
    stH5OpInfo localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
    if ((localstH5OpInfo != null) && (localstH5OpInfo.type > 0))
    {
      stReportItem localstReportItem = UserActionReportPresenter.a(paramstSimpleMetaFeed, paramInteger.intValue());
      if (localstH5OpInfo.type == 1) {
        localstReportItem.pagetype = 9;
      } else {
        localstReportItem.pagetype = 14;
      }
      localstReportItem.optype = 6;
      WSReportDc00898.a(6, localstH5OpInfo.type, paramInteger.intValue(), paramstSimpleMetaFeed.h5_op_info.id);
      WSGridBeaconReport.a("gzh_exposure", 0, paramstSimpleMetaFeed, this.jdField_a_of_type_JavaLangString);
      WSLog.a("weishi-report", "luopan report H5");
      return;
    }
    if (paramstSimpleMetaFeed.video_type == 6)
    {
      WSReportDc00898.a(false);
      WSLog.a("weishi-report", "luopan report NOW");
      return;
    }
    WSLog.b("weishi-report", "luopan normal is no need report");
  }
  
  public static void a(HashMap<Integer, stSimpleMetaFeed> paramHashMap, String paramString)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() <= 0) {
        return;
      }
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        Integer localInteger = (Integer)((Map.Entry)localObject).getKey();
        localObject = (stSimpleMetaFeed)((Map.Entry)localObject).getValue();
        stReportItem localstReportItem = UserActionReportPresenter.a((stSimpleMetaFeed)localObject, localInteger.intValue());
        if (localstReportItem.video_type == 9) {
          b((stSimpleMetaFeed)localObject, localInteger.intValue(), paramString);
        } else if ((localstReportItem.video_type != 1) && (localstReportItem.video_type != 6)) {
          WSGridBeaconReport.a("gzh_exposure", (stSimpleMetaFeed)localObject, localstReportItem, 0, paramString);
        }
      }
    }
  }
  
  private void a(Map<Integer, stSimpleMetaFeed> paramMap, Map<Integer, String> paramMap1)
  {
    Object localObject1 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject3;
    Object localObject2;
    if (paramMap.size() > 0)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject3 = (Map.Entry)paramMap.next();
        localObject2 = (Integer)((Map.Entry)localObject3).getKey();
        localObject3 = (stSimpleMetaFeed)((Map.Entry)localObject3).getValue();
        a((stSimpleMetaFeed)localObject3, (Integer)localObject2);
        localObject2 = WeishiUtils.a((stSimpleMetaFeed)localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("_");
          localStringBuilder1.append("0");
          localStringBuilder1.append("_");
        }
      }
      paramMap = (Map<Integer, stSimpleMetaFeed>)localObject1;
      if (((StringBuilder)localObject1).length() > 1) {
        paramMap = new StringBuilder(((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1));
      }
      localObject1 = paramMap;
      localObject2 = localStringBuilder1;
      if (localStringBuilder1.length() > 1)
      {
        localObject2 = new StringBuilder(localStringBuilder1.substring(0, localStringBuilder1.length() - 1));
        localObject1 = paramMap;
      }
    }
    else
    {
      WSLog.c("weishi-report", "推荐上报的feeds为0个");
      localObject2 = localStringBuilder1;
    }
    if (paramMap1.size() > 0)
    {
      localStringBuilder1 = new StringBuilder();
      paramMap = paramMap1.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject3 = (Map.Entry)paramMap.next();
        paramMap1 = (Integer)((Map.Entry)localObject3).getKey();
        localObject3 = (String)((Map.Entry)localObject3).getValue();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("898实时上报:");
        localStringBuilder2.append((String)localObject3);
        localStringBuilder2.append(", upos:");
        localStringBuilder2.append(paramMap1);
        WSLog.a("weishi-report", localStringBuilder2.toString());
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localStringBuilder1.append((String)localObject3);
          localStringBuilder1.append("_");
        }
      }
      paramMap = localStringBuilder1;
      if (localStringBuilder1.length() > 1) {
        paramMap = new StringBuilder(localStringBuilder1.substring(0, localStringBuilder1.length() - 1));
      }
      paramMap1 = new HashMap();
      paramMap1.put("feedid", paramMap.toString());
      paramMap1.put("cover_type", ((StringBuilder)localObject1).toString());
      paramMap1.put("dynamic_cover", ((StringBuilder)localObject2).toString());
      paramMap = new JSONObject(paramMap1);
      paramMap1 = new StringBuilder();
      paramMap1.append("jsonObj:");
      paramMap1.append(paramMap);
      WSLog.c("weishi-report", paramMap1.toString());
      WSReportDc00898.a(303, paramMap.toString());
      return;
    }
    WSLog.c("weishi-report", "898上报的feeds为0个");
  }
  
  private static void b(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString)
  {
    if (paramstSimpleMetaFeed != null)
    {
      Object localObject = paramstSimpleMetaFeed.cardInfo;
      if (localObject != null)
      {
        localObject = ((stCardInfo)localObject).collectionCardInfo;
        if (localObject != null)
        {
          localObject = ((stCollectionCardInfo)localObject).collectionList;
          if (localObject == null) {
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          int j;
          for (int i = 0; i < ((ArrayList)localObject).size(); i = j)
          {
            j = i + 1;
            localStringBuilder.append(j);
            localStringBuilder.append("_");
            localStringBuilder.append(((stCollection)((ArrayList)localObject).get(i)).cid);
            localStringBuilder.append(",");
          }
          localObject = localStringBuilder.toString();
          WSGridBeaconReport.a(paramInt, paramstSimpleMetaFeed, ((String)localObject).substring(0, ((String)localObject).length() - 1), paramString);
        }
      }
    }
  }
  
  private void d()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSHandlerThread = new WSHandlerThread();
      HandlerThread localHandlerThread = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSHandlerThread.a();
      if (!localHandlerThread.isAlive()) {
        localHandlerThread.start();
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
      return;
    }
    catch (Exception localException)
    {
      label46:
      break label46;
    }
    WSLog.b("WSFeedsItemExposeLog", "HandlerThread Exception.");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler == null) {
      return;
    }
    localHandler.post(new WSGridItemExpose.1(this, paramInt, paramstSimpleMetaFeed));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridItemExpose.java][exposeRefreshCard] mSubTabId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", lastVisiblePosition:");
    localStringBuilder.append(paramInt);
    WSLog.e("WSFeedsItemExposeLog", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new WSGridItemExpose.2(this, paramInt, paramList, paramBoolean));
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSHandlerThread;
    if (localObject != null)
    {
      ((WSHandlerThread)localObject).a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSHandlerThread = null;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void c()
  {
    ThreadManager.getSubThreadHandler().post(new WSGridItemExpose.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridItemExpose
 * JD-Core Version:    0.7.0.1
 */