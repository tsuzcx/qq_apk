package com.tencent.biz.qqcircle.datacenter;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.winkpublish.event.PublishUploadTaskResultEvent;
import com.tencent.mobileqq.winkpublish.event.QCirclePublishBoxStatusEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.BaseDataWorker;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.base.UIStateData.ModifyListRecord;
import com.tencent.richframework.data.idata.IDataCenter;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class QCircleSimpleEventFeedWorker
  extends BaseDataWorker
  implements SimpleEventReceiver
{
  private final int a = 0;
  
  QCircleSimpleEventFeedWorker(IDataCenter paramIDataCenter)
  {
    a(paramIDataCenter);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private int a(List<FeedBlockData> paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)paramList.get(i)).b();
      if ((paramString.startsWith("qcircle_fakeid_")) && (!localStFeed.id.get().startsWith("qcircle_fakeid_")))
      {
        QLog.d("QCircleSimpleEventFeedWorker", 2, "has none fakeFeeds");
        break;
      }
      if (localStFeed.isRecomFd.get())
      {
        if (paramString.equals(localStFeed.recomForward.id.get())) {
          return i;
        }
      }
      else if (paramString.equals(localStFeed.id.get()))
      {
        paramList = new StringBuilder();
        paramList.append("find fakeid:");
        paramList.append(paramString);
        QLog.d("QCircleSimpleEventFeedWorker", 2, paramList.toString());
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (paramQCircleFeedEvent == null)
    {
      QLog.e("QCircleSimpleEventFeedWorker", 1, "handleFakeEvent error fakeEvent is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeFeed state:");
    localStringBuilder.append(paramQCircleFeedEvent.mState);
    localStringBuilder.append(",fakeId:");
    localStringBuilder.append(paramQCircleFeedEvent.mTargetId);
    localStringBuilder.append(",fake listSize:");
    if (paramQCircleFeedEvent.mFakeFeedDataList == null) {
      i = 0;
    } else {
      i = paramQCircleFeedEvent.mFakeFeedDataList.size();
    }
    localStringBuilder.append(i);
    QLog.d("QCircleSimpleEventFeedWorker", 2, localStringBuilder.toString());
    int i = paramQCircleFeedEvent.mState;
    if ((i != 1) && (i != 2) && (i != 3)) {}
  }
  
  private void a(PublishUploadTaskResultEvent paramPublishUploadTaskResultEvent)
  {
    if (paramPublishUploadTaskResultEvent == null)
    {
      QLog.e("QCircleSimpleEventFeedWorker", 1, "handlePublishEvent error: event is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleSimpleEventFeedWorker", 2, new Object[] { "handlePublishEvent: ", paramPublishUploadTaskResultEvent.toString() });
    }
    if (paramPublishUploadTaskResultEvent.isUploadSuccess()) {
      b(paramPublishUploadTaskResultEvent);
    }
  }
  
  private void a(FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, PublishUploadTaskResultEvent paramPublishUploadTaskResultEvent)
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      if (((Collection)localObject1).size() == 0) {
        return;
      }
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        IDataDisplaySurface localIDataDisplaySurface = (IDataDisplaySurface)((Iterator)localObject1).next();
        if ((localIDataDisplaySurface != null) && ((paramPublishUploadTaskResultEvent.getTargetPage() == -1) || (paramPublishUploadTaskResultEvent.getTargetPage() == localIDataDisplaySurface.c())))
        {
          Object localObject2 = localIDataDisplaySurface.a(new Object[0]);
          if (localObject2 != null)
          {
            localObject2 = (UIStateData)((MutableLiveData)localObject2).getValue();
            if ((localObject2 != null) && (((UIStateData)localObject2).e() != null))
            {
              int i = a((List)((UIStateData)localObject2).e(), paramPublishUploadTaskResultEvent.getFeedId());
              List localList = (List)((UIStateData)localObject2).e();
              if (i == -1)
              {
                if (localList.isEmpty()) {
                  localList.add(new FeedBlockData(paramStGetFeedDetailRsp.feed));
                } else {
                  localList.add(0, new FeedBlockData(paramStGetFeedDetailRsp.feed));
                }
              }
              else {
                localList.set(i, new FeedBlockData(paramStGetFeedDetailRsp.feed));
              }
              ((UIStateData)localObject2).a(UIStateData.ModifyListRecord.a());
              localIDataDisplaySurface.a(new Object[0]).postValue(localObject2);
            }
          }
        }
      }
    }
  }
  
  private void b(PublishUploadTaskResultEvent paramPublishUploadTaskResultEvent)
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetFeedDetailRequest(paramPublishUploadTaskResultEvent.getFeedId(), HostDataTransUtils.getAccount(), paramPublishUploadTaskResultEvent.getCreateTime(), true), new QCircleSimpleEventFeedWorker.1(this, paramPublishUploadTaskResultEvent));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCirclePublishBoxStatusEvent.class);
    localArrayList.add(PublishUploadTaskResultEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      a((QCircleFeedEvent)paramSimpleBaseEvent);
    }
    if ((paramSimpleBaseEvent instanceof PublishUploadTaskResultEvent)) {
      a((PublishUploadTaskResultEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.QCircleSimpleEventFeedWorker
 * JD-Core Version:    0.7.0.1
 */