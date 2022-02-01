package com.tencent.biz.qqcircle.richframework.sender.iml.rsp;

import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.datacenter.request.QCircleFeedDetailListRequest;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StBatchGetFeedDetailReq;
import feedcloud.FeedCloudRead.StBatchGetFeedDetailRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QCircleGlobalFeedCenterRspInterceptor
  implements RspInterceptor<Object, BaseSenderChain<Object>>
{
  private Map<Integer, FeedBlockData> a;
  
  public QCircleGlobalFeedCenterRspInterceptor(Map<Integer, FeedBlockData> paramMap)
  {
    this.a = paramMap;
  }
  
  private List<FeedCloudMeta.StFeed> a(FeedCloudRead.StBatchGetFeedDetailRsp paramStBatchGetFeedDetailRsp, QCircleFeedDetailListRequest paramQCircleFeedDetailListRequest)
  {
    List localList = null;
    Object localObject = localList;
    if (paramStBatchGetFeedDetailRsp != null)
    {
      localObject = localList;
      if (paramStBatchGetFeedDetailRsp.feeds != null)
      {
        if (paramStBatchGetFeedDetailRsp.feeds.get() == null) {
          return null;
        }
        localObject = localList;
        if (paramQCircleFeedDetailListRequest != null)
        {
          localObject = localList;
          if (paramQCircleFeedDetailListRequest.mRequest != null)
          {
            localObject = localList;
            if (paramQCircleFeedDetailListRequest.mRequest.feedIndex != null)
            {
              if (paramQCircleFeedDetailListRequest.mRequest.feedIndex.get() == null) {
                return null;
              }
              int i = paramQCircleFeedDetailListRequest.mRequest.feedIndex.get().size();
              int j = paramStBatchGetFeedDetailRsp.feeds.get().size();
              localList = paramStBatchGetFeedDetailRsp.feeds.get();
              if (i > j)
              {
                paramQCircleFeedDetailListRequest = paramQCircleFeedDetailListRequest.mRequest.feedIndex.get();
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("req feeds size = ");
                ((StringBuilder)localObject).append(i);
                ((StringBuilder)localObject).append(", rsp feeds size = ");
                ((StringBuilder)localObject).append(j);
                QLog.i("QCircleGlobalFeedCenterRspInterceptor", 1, ((StringBuilder)localObject).toString());
              }
              else
              {
                paramQCircleFeedDetailListRequest = paramStBatchGetFeedDetailRsp.feeds.get();
              }
              localObject = new ArrayList(paramQCircleFeedDetailListRequest);
              a(localList, (List)localObject);
              paramStBatchGetFeedDetailRsp.feeds.set(localList);
            }
          }
        }
      }
    }
    return localObject;
  }
  
  private void a(List<FeedCloudMeta.StFeed> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      QCircleFeedDataCenter.a().c("QCircleSealRawDataStore", QCircleTransFormHelper.a(paramList));
      QCircleFeedDataCenter.a().b("QCircleFeedStore", QCircleTransFormHelper.a(paramList));
    }
  }
  
  private void a(List<FeedCloudMeta.StFeed> paramList1, List<FeedCloudMeta.StFeed> paramList2)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((Map)localObject).size() > 0)) {
      try
      {
        localObject = this.a.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i = ((Integer)((Map.Entry)((Iterator)localObject).next()).getKey()).intValue();
          if (i > paramList1.size())
          {
            paramList1.add(((FeedBlockData)this.a.get(Integer.valueOf(i))).b());
            paramList2.add(((FeedBlockData)this.a.get(Integer.valueOf(i))).b());
          }
          else
          {
            paramList1.add(i, ((FeedBlockData)this.a.get(Integer.valueOf(i))).b());
            paramList2.add(i, ((FeedBlockData)this.a.get(Integer.valueOf(i))).b());
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("insert ditto feed index = ");
          localStringBuilder.append(i);
          QLog.d("QCircleGlobalFeedCenterRspInterceptor", 1, localStringBuilder.toString());
        }
        this.a.clear();
        return;
      }
      catch (Exception paramList1)
      {
        paramList2 = new StringBuilder();
        paramList2.append("insert ditto feed error: ");
        paramList2.append(paramList1.getMessage());
        QLog.e("QCircleGlobalFeedCenterRspInterceptor", 1, paramList2.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, BaseSenderChain<Object> paramBaseSenderChain)
  {
    if (((paramObject2 instanceof FeedCloudRead.StBatchGetFeedDetailRsp)) && ((paramObject1 instanceof QCircleFeedDetailListRequest))) {
      a(a((FeedCloudRead.StBatchGetFeedDetailRsp)paramObject2, (QCircleFeedDetailListRequest)paramObject1));
    }
    paramBaseSenderChain.a(paramBoolean, paramLong, paramString, paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.rsp.QCircleGlobalFeedCenterRspInterceptor
 * JD-Core Version:    0.7.0.1
 */