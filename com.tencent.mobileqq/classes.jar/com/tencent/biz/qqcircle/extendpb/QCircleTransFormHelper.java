package com.tencent.biz.qqcircle.extendpb;

import com.tencent.biz.qqcircle.widgets.textview.QCircleRichTextPreloadHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StRecomInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleDitto.StBackCardDP;
import qqcircle.QQCircleDitto.StCardDetail;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StFlipCard;
import qqcircle.QQCircleDitto.StFrontCardDP;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StReportInfoForClient;
import seal.SealEdgeComputing.ClientItemInfo;

public class QCircleTransFormHelper
{
  public static List<String> a = new ArrayList();
  
  static
  {
    a.add("DITTO_MAY_INTEREST_PERSON");
    a.add("DITTO_FUEL_RANK");
    a.add("DITTO_MAY_INTEREST_SMALL_WORLD");
    a.add("DITTO_FEED_DESTINED_PERSON");
    a.add("DITTO_ALLPUSH_TIANSHU_BANNER");
    a.add("DITTO_GUIDE_PUBLISH_BANNER");
    a.add("DITTO_FEED_LIKE_INFO");
    a.add("DITTO_FEED_BUSI_REQ_DATA");
    a.add("DITTO_GROUP_MORE_RECOMMEND");
    a.add("DITTO_REPORT_INFO_FOR_CLIENT");
    a.add("DITTO_FEED_SEAL_RECOMMEND_INFO");
  }
  
  private static Object a(BaseBlockData paramBaseBlockData, FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.dittoFeed.dittoId.get() == 7) {
      try
      {
        QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew = new QQCircleDitto.StCircleDittoDataNew();
        paramStFeed = ((QQCircleDitto.StCircleDittoDataNew)localStCircleDittoDataNew.mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray())).flipCard;
        Object localObject = new QQCircleDitto.StFrontCardDP();
        ((QQCircleDitto.StFrontCardDP)localObject).mergeFrom(((QQCircleDitto.StFrontCardDP)paramStFeed.cardDetail.frontCardDP.get()).toByteArray());
        paramBaseBlockData.a("DITTO_FEED_DESTINED_PERSON_FRONT", localObject);
        localObject = new QQCircleDitto.StBackCardDP();
        ((QQCircleDitto.StBackCardDP)localObject).mergeFrom(((QQCircleDitto.StBackCardDP)paramStFeed.cardDetail.backCardDP.get()).toByteArray());
        paramBaseBlockData.a("DITTO_FEED_DESTINED_PERSON_BACK", localObject);
        return localStCircleDittoDataNew;
      }
      catch (Exception paramBaseBlockData)
      {
        paramBaseBlockData.printStackTrace();
      }
    }
    return null;
  }
  
  private static Object a(BaseBlockData paramBaseBlockData, String paramString, FeedCloudMeta.StFeed paramStFeed)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2067580480: 
      if (paramString.equals("DITTO_FUEL_RANK")) {
        i = 1;
      }
      break;
    case 2033438331: 
      if (paramString.equals("DITTO_MAY_INTEREST_PERSON")) {
        i = 0;
      }
      break;
    case 2033374215: 
      if (paramString.equals("DITTO_GROUP_MORE_RECOMMEND")) {
        i = 8;
      }
      break;
    case 1183926268: 
      if (paramString.equals("DITTO_REPORT_INFO_FOR_CLIENT")) {
        i = 9;
      }
      break;
    case 1029759669: 
      if (paramString.equals("DITTO_FEED_BUSI_REQ_DATA")) {
        i = 7;
      }
      break;
    case 160121002: 
      if (paramString.equals("DITTO_FEED_LIKE_INFO")) {
        i = 6;
      }
      break;
    case -614079820: 
      if (paramString.equals("DITTO_MAY_INTEREST_SMALL_WORLD")) {
        i = 2;
      }
      break;
    case -1479260186: 
      if (paramString.equals("DITTO_ALLPUSH_TIANSHU_BANNER")) {
        i = 4;
      }
      break;
    case -1759799225: 
      if (paramString.equals("DITTO_FEED_SEAL_RECOMMEND_INFO")) {
        i = 10;
      }
      break;
    case -1912886732: 
      if (paramString.equals("DITTO_GUIDE_PUBLISH_BANNER")) {
        i = 5;
      }
      break;
    case -2069569310: 
      if (paramString.equals("DITTO_FEED_DESTINED_PERSON")) {
        i = 3;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return null;
    case 10: 
      return b(paramStFeed);
    case 9: 
      return a(paramStFeed);
    case 8: 
      return c(paramStFeed);
    case 7: 
      return d(paramStFeed);
    case 6: 
      return e(paramStFeed);
    case 5: 
      return j(paramStFeed);
    case 4: 
      return i(paramStFeed);
    case 3: 
      return a(paramBaseBlockData, paramStFeed);
    case 2: 
      return f(paramStFeed);
    case 1: 
      return g(paramStFeed);
    }
    return h(paramStFeed);
  }
  
  private static Object a(BaseBlockData paramBaseBlockData, String paramString, Object paramObject)
  {
    if ((paramObject instanceof FeedCloudMeta.StFeed)) {
      return a(paramBaseBlockData, paramString, (FeedCloudMeta.StFeed)paramObject);
    }
    return null;
  }
  
  private static Object a(FeedCloudMeta.StFeed paramStFeed)
  {
    try
    {
      QQCircleFeedBase.StReportInfoForClient localStReportInfoForClient = new QQCircleFeedBase.StReportInfoForClient();
      localStReportInfoForClient.mergeFrom(paramStFeed.reportInfoForClient.get().toByteArray());
      return localStReportInfoForClient;
    }
    catch (Exception paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList<FeedBlockData> a(List<FeedCloudMeta.StFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      try
      {
        while (paramList.hasNext())
        {
          localObject = (FeedCloudMeta.StFeed)paramList.next();
          QCircleRichTextPreloadHelper.a((FeedCloudMeta.StFeed)localObject);
          localArrayList.add(new FeedBlockData((FeedCloudMeta.StFeed)localObject).c());
        }
        return localArrayList;
      }
      catch (Exception paramList)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("transForm exception:");
        ((StringBuilder)localObject).append(paramList.getMessage());
        QLog.d("QCircleTransFormHelper", 1, ((StringBuilder)localObject).toString());
      }
    }
    return localArrayList;
  }
  
  public static void a(FeedBlockData paramFeedBlockData, FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramFeedBlockData != null)
    {
      if (paramStFeed == null) {
        return;
      }
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramFeedBlockData.a(str, a(paramFeedBlockData, str, paramStFeed));
      }
    }
  }
  
  private static Object b(FeedCloudMeta.StFeed paramStFeed)
  {
    try
    {
      SealEdgeComputing.ClientItemInfo localClientItemInfo = new SealEdgeComputing.ClientItemInfo();
      localClientItemInfo.mergeFrom(paramStFeed.recomInfo.clientSealData.get().toByteArray());
      return localClientItemInfo;
    }
    catch (Exception paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList<FeedCloudMeta.StFeed> b(List<FeedBlockData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedBlockData localFeedBlockData = (FeedBlockData)paramList.next();
      if ((localFeedBlockData != null) && (localFeedBlockData.b() != null) && (localFeedBlockData.b().dittoFeed != null) && (localFeedBlockData.b().dittoFeed.dittoId.get() == 0)) {
        localArrayList.add(localFeedBlockData.b());
      }
    }
    return localArrayList;
  }
  
  private static Object c(FeedCloudMeta.StFeed paramStFeed)
  {
    try
    {
      if (paramStFeed.dittoFeed.dittoId.get() == 12)
      {
        QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew = new QQCircleDitto.StCircleDittoDataNew();
        localStCircleDittoDataNew.mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray());
        paramStFeed = localStCircleDittoDataNew.itemContainter;
        return paramStFeed;
      }
    }
    catch (Exception paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
    return null;
  }
  
  private static Object d(FeedCloudMeta.StFeed paramStFeed)
  {
    try
    {
      QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
      localStFeedBusiReqData.mergeFrom(paramStFeed.busiData.get().toByteArray());
      return localStFeedBusiReqData;
    }
    catch (Exception paramStFeed)
    {
      QLog.e("QCircleTransFormHelper", 1, paramStFeed, new Object[0]);
    }
    return null;
  }
  
  private static Object e(FeedCloudMeta.StFeed paramStFeed)
  {
    try
    {
      QQCircleFeedBase.StLikeBusiData localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
      localStLikeBusiData.mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
      return localStLikeBusiData;
    }
    catch (Exception paramStFeed)
    {
      QLog.e("QCircleTransFormHelper", 1, paramStFeed, new Object[0]);
    }
    return null;
  }
  
  private static Object f(FeedCloudMeta.StFeed paramStFeed)
  {
    try
    {
      if (paramStFeed.dittoFeed.dittoId.get() == 6)
      {
        QQCircleDitto.StItemContainer localStItemContainer = new QQCircleDitto.StItemContainer();
        localStItemContainer.mergeFrom(paramStFeed.dittoFeed.dittoData.get().toByteArray());
        return localStItemContainer;
      }
    }
    catch (Exception paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
    return null;
  }
  
  private static Object g(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.dittoFeed.dittoId.get() == 2) {
      try
      {
        QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew = new QQCircleDitto.StCircleDittoDataNew();
        localStCircleDittoDataNew.mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray());
        return localStCircleDittoDataNew;
      }
      catch (Exception paramStFeed)
      {
        paramStFeed.printStackTrace();
      }
    }
    return null;
  }
  
  private static Object h(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.dittoFeed.dittoId.get() == 1)
    {
      QQCircleDitto.StItemContainer localStItemContainer = new QQCircleDitto.StItemContainer();
      try
      {
        localStItemContainer.mergeFrom(paramStFeed.dittoFeed.dittoData.get().toByteArray());
        return localStItemContainer;
      }
      catch (Exception paramStFeed)
      {
        paramStFeed.printStackTrace();
      }
    }
    return null;
  }
  
  private static Object i(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.dittoFeed.dittoId.get() == 10) {
      try
      {
        QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew = new QQCircleDitto.StCircleDittoDataNew();
        localStCircleDittoDataNew.mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray());
        return localStCircleDittoDataNew;
      }
      catch (Exception paramStFeed)
      {
        paramStFeed.printStackTrace();
      }
    }
    return null;
  }
  
  private static Object j(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.dittoFeed.dittoId.get() == 11) {
      try
      {
        QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew = new QQCircleDitto.StCircleDittoDataNew();
        localStCircleDittoDataNew.mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray());
        return localStCircleDittoDataNew;
      }
      catch (Exception paramStFeed)
      {
        paramStFeed.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper
 * JD-Core Version:    0.7.0.1
 */