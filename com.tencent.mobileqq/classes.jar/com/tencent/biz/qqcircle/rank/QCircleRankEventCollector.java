package com.tencent.biz.qqcircle.rank;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.rank.strategy.QCircleDefaultReRankStrategy;
import com.tencent.biz.qqcircle.rank.strategy.QCircleReRankStrategy;
import com.tencent.biz.qqcircle.rank.strategy.QCircleSoReRankStrategy;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.QCircleReporter.QCircleReportListener;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomInfo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lfeedcloud.FeedCloudCommon.Entry;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import seal.SealEdgeComputing.ClientItemInfo;

public class QCircleRankEventCollector
  implements RspInterceptor<Object, BaseSenderChain>, QCircleReporter.QCircleReportListener
{
  public static final String EXTRA_KEY_RANK_ALGORITHM_EXTRA_PARAMS = "extra_key_rank_algorithm_extra_params";
  private static final String TAG = "QCircleRankEventCollector";
  private static volatile QCircleRankEventCollector sInstance;
  private String mAlgorithmExtraParams = "";
  private final ConcurrentHashMap<String, Long> mBadSampleCountsMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, Long> mCateExpTimeMap = new ConcurrentHashMap();
  private FeedCloudCommon.StCommonExt mCommonExtInfo;
  private final ConcurrentHashMap<String, Long> mMultiActionMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, Long> mOneActionMap = new ConcurrentHashMap();
  private final HashMap<String, QCircleRawFeedItem> mRawFeedItemMap = new HashMap();
  
  private void addExpTime(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong <= 0L) {
        return;
      }
      if (this.mCateExpTimeMap.containsKey(paramString))
      {
        Long localLong = (Long)this.mCateExpTimeMap.get(paramString);
        if (localLong != null) {
          this.mCateExpTimeMap.put(paramString, Long.valueOf(localLong.longValue() + paramLong));
        }
      }
      else
      {
        this.mCateExpTimeMap.put(paramString, Long.valueOf(paramLong));
      }
    }
  }
  
  private QCircleReRankStrategy getDefaultReRankStrategy()
  {
    return new QCircleDefaultReRankStrategy();
  }
  
  private String getFeedCateId(String paramString)
  {
    if (this.mRawFeedItemMap.containsKey(paramString))
    {
      paramString = (QCircleRawFeedItem)this.mRawFeedItemMap.get(paramString);
      if (paramString != null) {
        return paramString.getCateId();
      }
    }
    return "";
  }
  
  public static QCircleRankEventCollector getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleRankEventCollector();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private QCircleReRankStrategy getSoReRankStrategy()
  {
    return new QCircleSoReRankStrategy();
  }
  
  private void handle5501Report(List<FeedCloudCommon.Entry> paramList)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject3 = "";
    Object localObject2 = "";
    Object localObject1 = localObject2;
    while (localIterator.hasNext())
    {
      Object localObject4 = (FeedCloudCommon.Entry)localIterator.next();
      paramList = ((FeedCloudCommon.Entry)localObject4).value.get();
      localObject4 = ((FeedCloudCommon.Entry)localObject4).key.get();
      int i = -1;
      int j = ((String)localObject4).hashCode();
      if (j != -1278409927)
      {
        if (j != 386461872)
        {
          if ((j == 1852834416) && (((String)localObject4).equals("actiontype"))) {
            i = 1;
          }
        }
        else if (((String)localObject4).equals("subactiontype")) {
          i = 2;
        }
      }
      else if (((String)localObject4).equals("feedid")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            localObject2 = paramList;
          }
        }
        else {
          localObject3 = paramList;
        }
      }
      else {
        localObject1 = paramList;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      handleActionId((String)localObject1, QCircleRankActionHelper.Dc5501Action.getActionId(Integer.parseInt((String)localObject3), Integer.parseInt((String)localObject2)));
    }
  }
  
  private void handle5502Report(List<FeedCloudCommon.Entry> paramList)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        Iterator localIterator = paramList.iterator();
        paramList = "";
        long l = 0L;
        if (localIterator.hasNext())
        {
          Object localObject2 = (FeedCloudCommon.Entry)localIterator.next();
          localObject1 = ((FeedCloudCommon.Entry)localObject2).value.get();
          localObject2 = ((FeedCloudCommon.Entry)localObject2).key.get();
          i = -1;
          int j = ((String)localObject2).hashCode();
          if (j != -1947331341)
          {
            if ((j == -1278409927) && (((String)localObject2).equals("feedid"))) {
              i = 0;
            }
          }
          else if (((String)localObject2).equals("stay_time"))
          {
            i = 1;
            break label188;
            l = Long.parseLong((String)localObject1);
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("collect feed:");
          ((StringBuilder)localObject1).append(paramList);
          ((StringBuilder)localObject1).append("stay time:");
          ((StringBuilder)localObject1).append(l);
          QLog.d("QCircleRankEventCollector", 4, ((StringBuilder)localObject1).toString());
          addExpTime(getFeedCateId(paramList), l);
          return;
        }
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      label188:
      if (i != 0)
      {
        if (i == 1) {}
      }
      else {
        paramList = (List<FeedCloudCommon.Entry>)localObject1;
      }
    }
  }
  
  private void increaseMultiActionTime(String paramString, long paramLong)
  {
    operateMapTimes(this.mMultiActionMap, paramString, paramLong);
  }
  
  private void increaseNegativeActionTime(String paramString, long paramLong)
  {
    operateMapTimes(this.mBadSampleCountsMap, paramString, paramLong);
  }
  
  private void increaseOneActionTime(String paramString, long paramLong)
  {
    operateMapTimes(this.mOneActionMap, paramString, paramLong);
  }
  
  private void operateMapTimes(Map<String, Long> paramMap, String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject;
    if (paramMap.containsKey(paramString))
    {
      localObject = (Long)paramMap.get(paramString);
      if (localObject != null)
      {
        paramLong += ((Long)localObject).longValue();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("map:");
        ((StringBuilder)localObject).append(paramMap);
        ((StringBuilder)localObject).append(" cateId:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" totalTime:");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("QCircleRankEventCollector", 1, ((StringBuilder)localObject).toString());
        paramMap.put(paramString, Long.valueOf(paramLong));
      }
    }
    else
    {
      paramMap.put(paramString, Long.valueOf(paramLong));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("map:");
      ((StringBuilder)localObject).append(paramMap);
      ((StringBuilder)localObject).append(" cateId:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" totalTime:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("QCircleRankEventCollector", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public FeedCloudCommon.StCommonExt getExtCommonInfo()
  {
    FeedCloudCommon.StCommonExt localStCommonExt = this.mCommonExtInfo;
    if (localStCommonExt != null) {
      return localStCommonExt;
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public String getKey()
  {
    return "QCircleRankEventCollector";
  }
  
  public QCircleRawFeedItem getRawFeedItem(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (QCircleRawFeedItem)this.mRawFeedItemMap.get(paramString);
    }
    return null;
  }
  
  public QCircleRawFeedItem getRawFeedItemByFeed(FeedBlockData paramFeedBlockData)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramFeedBlockData != null)
    {
      if (paramFeedBlockData.b() == null) {
        return null;
      }
      String str = paramFeedBlockData.b().id.get();
      localObject2 = localObject1;
      try
      {
        SealEdgeComputing.ClientItemInfo localClientItemInfo;
        if (this.mRawFeedItemMap.containsKey(str))
        {
          localObject2 = localObject1;
          localObject1 = (QCircleRawFeedItem)this.mRawFeedItemMap.get(str);
        }
        else
        {
          localObject2 = localObject1;
          localClientItemInfo = new SealEdgeComputing.ClientItemInfo();
          localObject2 = localObject1;
          localClientItemInfo.mergeFrom(paramFeedBlockData.b().recomInfo.clientSealData.get().toByteArray());
          localObject2 = localObject1;
          localObject1 = new QCircleRawFeedItem();
        }
        try
        {
          if (!TextUtils.isEmpty(localClientItemInfo.cate_name.get()))
          {
            ((QCircleRawFeedItem)localObject1).setCateId(localClientItemInfo.cate_name.get());
            ((QCircleRawFeedItem)localObject1).setSubCateId(localClientItemInfo.sub_cate_name.get());
            ((QCircleRawFeedItem)localObject1).setExtend(localClientItemInfo.extend.get());
          }
          localObject2 = paramFeedBlockData.b().busiTranparent.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            FeedCloudCommon.BytesEntry localBytesEntry = (FeedCloudCommon.BytesEntry)((Iterator)localObject2).next();
            ((QCircleRawFeedItem)localObject1).setBusiTranparent(localBytesEntry.key.get(), localBytesEntry.value.get().toStringUtf8());
          }
          ((QCircleRawFeedItem)localObject1).setPreRecommendScore(BigDecimal.valueOf(localClientItemInfo.seal_score.get()));
          ((QCircleRawFeedItem)localObject1).setFeedId(str);
          this.mRawFeedItemMap.put(str, localObject1);
          localObject2 = localObject1;
          if (localObject1 == null) {
            return localObject2;
          }
          localObject2 = localObject1;
          ((QCircleRawFeedItem)localObject1).setFeedData(paramFeedBlockData);
          return localObject1;
        }
        catch (Exception paramFeedBlockData)
        {
          localObject2 = localObject1;
        }
        localObject1 = new StringBuilder();
      }
      catch (Exception paramFeedBlockData) {}
      ((StringBuilder)localObject1).append("get raw feed item error = ");
      ((StringBuilder)localObject1).append(paramFeedBlockData.getMessage());
      QLog.e("QCircleRankEventCollector", 1, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  public void handleActionId(String paramString, int paramInt)
  {
    paramString = getFeedCateId(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QCircleRankActionHelper.isOneAction(paramInt))
    {
      increaseOneActionTime(paramString, 1L);
      return;
    }
    if (QCircleRankActionHelper.isMultiAction(paramInt))
    {
      increaseMultiActionTime(paramString, 1L);
      return;
    }
    if (QCircleRankActionHelper.isNegativeAction(paramInt)) {
      increaseNegativeActionTime(paramString, 1L);
    }
  }
  
  public void init()
  {
    QCircleReporter.getInstance().setReportListener(getInstance());
  }
  
  public void interceptReturnRsp(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, BaseSenderChain paramBaseSenderChain)
  {
    try
    {
      if ((paramObject2 instanceof Collection))
      {
        Object localObject1 = (Collection)paramObject2;
        localObject2 = new ArrayList();
        localObject1 = ((Collection)localObject1).iterator();
        Object localObject3;
        Object localObject4;
        for (;;)
        {
          boolean bool = ((Iterator)localObject1).hasNext();
          if (!bool) {
            break;
          }
          localObject3 = getRawFeedItemByFeed((FeedBlockData)((Iterator)localObject1).next());
          if (localObject3 != null)
          {
            ((List)localObject2).add(localObject3);
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("feedId");
            ((StringBuilder)localObject4).append(((QCircleRawFeedItem)localObject3).getFeedId());
            ((StringBuilder)localObject4).append(" cateId:");
            ((StringBuilder)localObject4).append(((QCircleRawFeedItem)localObject3).getCateId());
            QLog.d("QCircleRankEventCollector", 1, ((StringBuilder)localObject4).toString());
          }
        }
        if (((List)localObject2).size() != 0)
        {
          localObject1 = new QCircleRawFeedSortParams();
          ((QCircleRawFeedSortParams)localObject1).setExpTime(this.mCateExpTimeMap);
          ((QCircleRawFeedSortParams)localObject1).setOneActionCounts(this.mOneActionMap);
          ((QCircleRawFeedSortParams)localObject1).setMultiActionCounts(this.mMultiActionMap);
          ((QCircleRawFeedSortParams)localObject1).setBadSampleCounts(this.mBadSampleCountsMap);
          ((QCircleRawFeedSortParams)localObject1).setSortList((List)localObject2);
          localObject3 = getSoReRankStrategy().reRank((QCircleRawFeedSortParams)localObject1, this.mAlgorithmExtraParams);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = localObject2;
          }
          localObject2 = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (QCircleRawFeedItem)((Iterator)localObject1).next();
            if (localObject3 != null)
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("reRank feedId");
              ((StringBuilder)localObject4).append(((QCircleRawFeedItem)localObject3).getFeedId());
              ((StringBuilder)localObject4).append(" cateId:");
              ((StringBuilder)localObject4).append(((QCircleRawFeedItem)localObject3).getCateId());
              ((StringBuilder)localObject4).append(" score:");
              ((StringBuilder)localObject4).append(((QCircleRawFeedItem)localObject3).getReRankScore());
              QLog.d("QCircleRankEventCollector", 1, ((StringBuilder)localObject4).toString());
              localObject4 = (QCircleRawFeedItem)this.mRawFeedItemMap.get(((QCircleRawFeedItem)localObject3).getFeedId());
              ((QCircleRawFeedItem)localObject4).setReRankScore(((QCircleRawFeedItem)localObject3).getReRankScore());
              ((List)localObject2).add(((QCircleRawFeedItem)localObject4).getFeedData());
            }
          }
          paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramObject1, localObject2);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("rank error");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("QCircleRankEventCollector", 1, ((StringBuilder)localObject2).toString(), localException);
      paramBaseSenderChain.a(false, paramLong, paramString, paramObject1, paramObject2);
    }
  }
  
  public void onAddReportData(int paramInt, List<FeedCloudCommon.Entry> paramList)
  {
    if (paramInt != 5501)
    {
      if (paramInt != 5502) {
        return;
      }
      handle5502Report(paramList);
      return;
    }
    handle5501Report(paramList);
  }
  
  protected native void rank(String paramString1, String paramString2);
  
  public void setAlgorithmExtraParams(String paramString)
  {
    this.mAlgorithmExtraParams = paramString;
  }
  
  public void setExtCommonInfo(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    this.mCommonExtInfo = paramStCommonExt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.rank.QCircleRankEventCollector
 * JD-Core Version:    0.7.0.1
 */