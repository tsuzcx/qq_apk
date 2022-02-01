package com.tencent.biz.qqcircle.flutter;

import android.os.Handler;
import android.text.TextUtils;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.event.QCircleFlutterUpdateFuelEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPushList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QcircleFlutterEventReceiver
  implements SimpleEventReceiver
{
  public static QcircleFlutterEventReceiver a()
  {
    return QcircleFlutterEventReceiver.SingleHolder.a;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QQCircleMethodImpl.getInstance().getCurrentFeed() != null)
    {
      if (QQCircleMethodImpl.getInstance().getCurrentFeed().likeInfo == null) {
        return;
      }
      QQCircleMethodImpl.getInstance().getCurrentFeed().likeInfo.count.set(paramInt2);
      new QQCircleFeedBase.StLikeBusiData();
      try
      {
        QQCircleFeedBase.StLikeBusiData localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
        localStLikeBusiData.mergeFrom(QQCircleMethodImpl.getInstance().getCurrentFeed().likeInfo.busiData.get().toByteArray());
        if (paramInt1 == 0)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = localStLikeBusiData.likeIDs.get().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((TextUtils.equals(str, "206008")) || (TextUtils.equals(str, "205993"))) {
              localArrayList.add(str);
            }
          }
          localStLikeBusiData.likeIDs.set(localArrayList);
        }
        else
        {
          if (localStLikeBusiData.likeIDs.get().contains("6")) {
            return;
          }
          localStLikeBusiData.likeIDs.add("6");
        }
        QQCircleMethodImpl.getInstance().getCurrentFeed().likeInfo.busiData.set(ByteStringMicro.copyFrom(localStLikeBusiData.toByteArray()));
        return;
      }
      catch (Exception localException)
      {
        QLog.e("QcircleFlutterEventReceiver", 1, "", localException);
      }
    }
  }
  
  private void a(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if ((paramQCircleCommentUpdateEvent.eventStatus == 3) || (paramQCircleCommentUpdateEvent.eventStatus == 4))
    {
      if (!paramQCircleCommentUpdateEvent.feedId.equals(QQCircleMethodImpl.getInstance().getCurrentFeed().id.get())) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("eventType", "commentCountChange");
      localHashMap.put("feedId", paramQCircleCommentUpdateEvent.feedId);
      localHashMap.put("commentCount", Integer.valueOf(paramQCircleCommentUpdateEvent.commentTotalNum));
      TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", localHashMap);
    }
  }
  
  private void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if ((QQCircleMethodImpl.getInstance().getCurrentFeed() != null) && (paramQCircleFeedEvent != null) && (paramQCircleFeedEvent.mTargetId != null))
    {
      if (!paramQCircleFeedEvent.mTargetId.equals(QQCircleMethodImpl.getInstance().getCurrentFeed().id.get())) {
        return;
      }
      if (paramQCircleFeedEvent.mState == 3)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("feedId", paramQCircleFeedEvent.mTargetId);
        localHashMap.put("eventType", "deleteFeed");
        TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", localHashMap);
      }
    }
  }
  
  private void a(QCirclePolyPraiseUpdateEvent paramQCirclePolyPraiseUpdateEvent)
  {
    if (!paramQCirclePolyPraiseUpdateEvent.mTargetFeedId.equals(QQCircleMethodImpl.getInstance().getCurrentFeed().id.get())) {
      return;
    }
    if (paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("feedId", paramQCirclePolyPraiseUpdateEvent.mTargetFeedId);
    localHashMap.put("totalLikeCount", Integer.valueOf(paramQCirclePolyPraiseUpdateEvent.mPraisedNum));
    localHashMap.put("likeStatus", Integer.valueOf(paramQCirclePolyPraiseUpdateEvent.mPraisedStatus));
    localHashMap.put("likeID", paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike.polyLikeID.get());
    localHashMap.put("likeIcon", paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike.polyIconUrl.get());
    localHashMap.put("eventType", "polyLike");
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", localHashMap);
    if (paramQCirclePolyPraiseUpdateEvent.moldStPolyLike == null)
    {
      a(1, paramQCirclePolyPraiseUpdateEvent.mPraisedNum);
      return;
    }
    a(paramQCirclePolyPraiseUpdateEvent.moldStPolyLike, paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike, paramQCirclePolyPraiseUpdateEvent.mPraisedNum);
  }
  
  private void a(QCircleFollowUpdateEvent paramQCircleFollowUpdateEvent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onReceiveEvent] userId=");
      ((StringBuilder)localObject).append(paramQCircleFollowUpdateEvent.mUserId);
      ((StringBuilder)localObject).append(", followType=");
      ((StringBuilder)localObject).append(paramQCircleFollowUpdateEvent.mFollowStatus);
      QLog.d("QcircleFlutterEventReceiver", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("userId", paramQCircleFollowUpdateEvent.mUserId);
    ((Map)localObject).put("followType", Integer.valueOf(paramQCircleFollowUpdateEvent.mFollowStatus));
    ((Map)localObject).put("eventType", "followUser");
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", (Map)localObject);
    QQCircleMethodMine.updateFollowStatus(paramQCircleFollowUpdateEvent.mUserId, paramQCircleFollowUpdateEvent.mFollowStatus);
  }
  
  private void a(String paramString)
  {
    Object localObject = QCirclePushInfoManager.a().a(paramString);
    if (localObject == null)
    {
      QLog.w("QcircleFlutterEventReceiver", 1, "[onReceiveEvent] undo push, invalid pushList");
      return;
    }
    int i = ((FeedCloudMeta.StPushList)localObject).hasClickCount.get();
    int j = ((FeedCloudMeta.StPushList)localObject).totalClickCount.get();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onReceiveEvent] undo push, hasClickCount=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", totalClickCount=");
      ((StringBuilder)localObject).append(j);
      QLog.d("QcircleFlutterEventReceiver", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new HashMap();
    ((Map)localObject).put("eventType", "pushFeed");
    ((Map)localObject).put("feedId", paramString);
    ((Map)localObject).put("hasClickCount", Integer.valueOf(i));
    ((Map)localObject).put("totalClickCount", Integer.valueOf(j));
    TencentQQCirclePlugin.sendEvent("tencent_qqcircle/dataChange", (Map)localObject);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveEvent] userId=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", fuelCount=");
      localStringBuilder.append(paramInt);
      QLog.d("QcircleFlutterEventReceiver", 2, localStringBuilder.toString());
    }
    RFThreadManager.getUIHandler().post(new QcircleFlutterEventReceiver.1(this, paramString, paramInt));
  }
  
  private void a(QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2, int paramInt)
  {
    if ((paramStPolyLike1 != null) && (paramStPolyLike2 != null) && (!paramStPolyLike1.polyLikeID.get().equals(paramStPolyLike2.polyLikeID.get())))
    {
      QQCircleFeedBase.StLikeBusiData localStLikeBusiData1 = new QQCircleFeedBase.StLikeBusiData();
      localStLikeBusiData1.curPolyLikeInfo.set(paramStPolyLike2);
      try
      {
        QQCircleFeedBase.StLikeBusiData localStLikeBusiData2 = new QQCircleFeedBase.StLikeBusiData();
        localStLikeBusiData2.mergeFrom(QQCircleMethodImpl.getInstance().getCurrentFeed().likeInfo.busiData.get().toByteArray());
        localStLikeBusiData1.polyLikeInfo.set(localStLikeBusiData2.polyLikeInfo.get());
        if ((paramStPolyLike2.articleType.get() == 1) || (localStLikeBusiData2.rewardstatus.get() == 1)) {
          localStLikeBusiData1.rewardstatus.set(1);
        }
        if (!localStLikeBusiData2.likeIDs.get().contains(paramStPolyLike2.polyLikeID.get())) {
          localStLikeBusiData2.likeIDs.get().add(paramStPolyLike2.polyLikeID.get());
        }
        if (("".equals(paramStPolyLike2.polyLikeID.get())) && ("6".equals(paramStPolyLike1.polyLikeID.get())))
        {
          localStLikeBusiData2.likeIDs.get().remove(paramStPolyLike1.polyLikeID.get());
          QQCircleMethodImpl.getInstance().getCurrentFeed().likeInfo.count.set(paramInt);
        }
        localStLikeBusiData1.likeIDs.addAll(new ArrayList(localStLikeBusiData2.likeIDs.get()));
        QQCircleMethodImpl.getInstance().getCurrentFeed().likeInfo.busiData.set(ByteStringMicro.copyFrom(localStLikeBusiData1.toByteArray()));
        return;
      }
      catch (Exception paramStPolyLike1)
      {
        QLog.e("QcircleFlutterEventReceiver", 1, "[updatePraiseView]", paramStPolyLike1);
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleFollowUpdateEvent.class);
    localArrayList.add(QCircleUndoPushUpdateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    localArrayList.add(QCircleFlutterUpdateFuelEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent))
    {
      a((QCircleCommentUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent))
    {
      a((QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent))
    {
      a((QCircleFeedEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent))
    {
      a((QCircleFollowUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleUndoPushUpdateEvent))
    {
      a(((QCircleUndoPushUpdateEvent)paramSimpleBaseEvent).mTargetFeedId);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCirclePushUpdateEvent))
    {
      a(((QCirclePushUpdateEvent)paramSimpleBaseEvent).mTargetFeedId);
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleFlutterUpdateFuelEvent))
    {
      paramSimpleBaseEvent = (QCircleFlutterUpdateFuelEvent)paramSimpleBaseEvent;
      a(paramSimpleBaseEvent.uin, paramSimpleBaseEvent.fuelCount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QcircleFlutterEventReceiver
 * JD-Core Version:    0.7.0.1
 */