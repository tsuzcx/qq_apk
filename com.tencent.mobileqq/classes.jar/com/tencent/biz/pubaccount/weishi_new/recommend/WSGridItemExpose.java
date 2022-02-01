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
import java.util.Map<Ljava.lang.Integer;Ljava.lang.String;>;
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
      WSLog.e("WSFeedsItemExposeLog", "[WSGridItemExpose.java][handleOnScrollForReport] mSubTabId:" + this.jdField_a_of_type_JavaLangString + ", position:" + paramInt);
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
      if (localstH5OpInfo.type == 1) {}
      for (localstReportItem.pagetype = 9;; localstReportItem.pagetype = 14)
      {
        localstReportItem.optype = 6;
        WSReportDc00898.a(6, localstH5OpInfo.type, paramInteger.intValue(), paramstSimpleMetaFeed.h5_op_info.id);
        WSGridBeaconReport.a("gzh_exposure", 0, paramstSimpleMetaFeed, this.jdField_a_of_type_JavaLangString);
        WSLog.a("weishi-report", "luopan report H5");
        return;
      }
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
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {}
    for (;;)
    {
      return;
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
    Object localObject2 = new StringBuilder();
    Object localObject1 = new StringBuilder();
    Object localObject4;
    Object localObject3;
    if (paramMap.size() > 0)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject4 = (Map.Entry)paramMap.next();
        localObject3 = (Integer)((Map.Entry)localObject4).getKey();
        localObject4 = (stSimpleMetaFeed)((Map.Entry)localObject4).getValue();
        a((stSimpleMetaFeed)localObject4, (Integer)localObject3);
        localObject3 = WeishiUtils.a((stSimpleMetaFeed)localObject4);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject1).append("0");
          ((StringBuilder)localObject1).append("_");
        }
      }
      if (((StringBuilder)localObject2).length() <= 1) {
        break label503;
      }
    }
    label486:
    label503:
    for (paramMap = new StringBuilder(((StringBuilder)localObject2).substring(0, ((StringBuilder)localObject2).length() - 1));; paramMap = (Map<Integer, stSimpleMetaFeed>)localObject2)
    {
      if (((StringBuilder)localObject1).length() > 1)
      {
        localObject2 = new StringBuilder(((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1));
        localObject1 = paramMap;
        paramMap = (Map<Integer, stSimpleMetaFeed>)localObject2;
      }
      for (;;)
      {
        if (paramMap1.size() > 0)
        {
          localObject2 = new StringBuilder();
          paramMap1 = paramMap1.entrySet().iterator();
          for (;;)
          {
            if (paramMap1.hasNext())
            {
              localObject4 = (Map.Entry)paramMap1.next();
              localObject3 = (Integer)((Map.Entry)localObject4).getKey();
              localObject4 = (String)((Map.Entry)localObject4).getValue();
              WSLog.a("weishi-report", "898实时上报:" + (String)localObject4 + ", upos:" + localObject3);
              if (!TextUtils.isEmpty((CharSequence)localObject4))
              {
                ((StringBuilder)localObject2).append((String)localObject4);
                ((StringBuilder)localObject2).append("_");
                continue;
                WSLog.c("weishi-report", "推荐上报的feeds为0个");
                paramMap = (Map<Integer, stSimpleMetaFeed>)localObject1;
                localObject1 = localObject2;
                break;
              }
            }
          }
          if (((StringBuilder)localObject2).length() <= 1) {
            break label486;
          }
        }
        for (paramMap1 = new StringBuilder(((StringBuilder)localObject2).substring(0, ((StringBuilder)localObject2).length() - 1));; paramMap1 = (Map<Integer, String>)localObject2)
        {
          localObject2 = new HashMap();
          ((Map)localObject2).put("feedid", paramMap1.toString());
          ((Map)localObject2).put("cover_type", ((StringBuilder)localObject1).toString());
          ((Map)localObject2).put("dynamic_cover", paramMap.toString());
          paramMap = new JSONObject((Map)localObject2);
          WSLog.c("weishi-report", "jsonObj:" + paramMap);
          WSReportDc00898.a(303, paramMap.toString());
          return;
          WSLog.c("weishi-report", "898上报的feeds为0个");
          return;
        }
        localObject2 = paramMap;
        paramMap = (Map<Integer, stSimpleMetaFeed>)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  private static void b(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString)
  {
    if (paramstSimpleMetaFeed != null)
    {
      localObject = paramstSimpleMetaFeed.cardInfo;
      if (localObject != null)
      {
        localObject = ((stCardInfo)localObject).collectionCardInfo;
        if (localObject != null)
        {
          localObject = ((stCollectionCardInfo)localObject).collectionList;
          if (localObject != null) {
            break label40;
          }
        }
      }
    }
    return;
    label40:
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localStringBuilder.append(i + 1).append("_").append(((stCollection)((ArrayList)localObject).get(i)).cid).append(",");
      i += 1;
    }
    Object localObject = localStringBuilder.toString();
    WSGridBeaconReport.a(paramInt, paramstSimpleMetaFeed, ((String)localObject).substring(0, ((String)localObject).length() - 1), paramString);
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
      WSLog.b("WSFeedsItemExposeLog", "HandlerThread Exception.");
    }
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
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new WSGridItemExpose.1(this, paramInt, paramstSimpleMetaFeed));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    WSLog.e("WSFeedsItemExposeLog", "[WSGridItemExpose.java][exposeRefreshCard] mSubTabId:" + this.jdField_a_of_type_JavaLangString + ", lastVisiblePosition:" + paramInt);
    this.jdField_a_of_type_AndroidOsHandler.post(new WSGridItemExpose.2(this, paramInt, paramList, paramBoolean));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSHandlerThread != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSHandlerThread.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSHandlerThread = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void c()
  {
    ThreadManager.getSubThreadHandler().post(new WSGridItemExpose.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridItemExpose
 * JD-Core Version:    0.7.0.1
 */