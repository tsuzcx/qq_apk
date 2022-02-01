package com.tencent.biz.qqcircle.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.EventListener;
import com.tencent.biz.qqcircle.comment.QCircleCommentBusiness;
import com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow;
import com.tencent.biz.qqcircle.events.QFSCommentSendEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.lang.ref.WeakReference;

class QCircleCommentHelper$1
  implements QCircleBaseInputPopupWindow.EventListener
{
  QCircleCommentHelper$1(QCircleCommentHelper paramQCircleCommentHelper, Activity paramActivity, QCircleCommentInputPopupWindow paramQCircleCommentInputPopupWindow, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean, int paramInt, QCircleFeedCommentInfo paramQCircleFeedCommentInfo) {}
  
  public void a()
  {
    QLog.d("QCircleCommentHelper", 1, "onClickSend()");
    if (this.a.isFinishing())
    {
      QLog.d("QCircleCommentHelper", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    Object localObject3 = this.b.g();
    if (TextUtils.isEmpty(((String)localObject3).trim()))
    {
      QCircleToast.a(this.a.getString(2131889233), 0);
      return;
    }
    if (!HostNetworkUtils.isNetworkAvailable())
    {
      QCircleToast.a(QCircleToast.c, this.a.getString(2131892113), 0);
      return;
    }
    if (this.c == null)
    {
      QLog.e("QCircleCommentHelper", 1, "feed is null");
      return;
    }
    Object localObject1;
    if (QCircleCommentHelper.a(this.i) != null) {
      localObject1 = (QCircleCommentHelper.CommentInputListener)QCircleCommentHelper.a(this.i).get();
    } else {
      localObject1 = null;
    }
    Object localObject2;
    PBStringField localPBStringField;
    StringBuilder localStringBuilder;
    if (this.d != null)
    {
      localObject2 = new FeedCloudMeta.StReply();
      localPBStringField = ((FeedCloudMeta.StReply)localObject2).id;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeId_");
      localStringBuilder.append(System.currentTimeMillis());
      localPBStringField.set(localStringBuilder.toString());
      ((FeedCloudMeta.StReply)localObject2).content.set((String)localObject3);
      ((FeedCloudMeta.StReply)localObject2).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StReply)localObject2).postUser.set(QCirclePluginGlobalInfo.c());
      localObject3 = this.e;
      if ((localObject3 != null) && (!TextUtils.isEmpty(((FeedCloudMeta.StReply)localObject3).postUser.id.get()))) {
        ((FeedCloudMeta.StReply)localObject2).targetUser.set(this.e.postUser.get());
      }
      if (localObject1 != null)
      {
        QLog.d("QCircleCommentHelper", 1, "addFakeReply commentInputListener callback success");
        ((QCircleCommentHelper.CommentInputListener)localObject1).a((FeedCloudMeta.StReply)localObject2);
      }
      else
      {
        QLog.e("QCircleCommentHelper", 1, "addFakeReply commentInputListener null");
      }
      localObject3 = QCircleCommentHelper.b(this.i);
      localObject1 = this.a;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(localObject1.hashCode());
      } else {
        localObject1 = null;
      }
      ((QCircleCommentBusiness)localObject3).a(((Integer)localObject1).intValue(), this.c, this.d, (FeedCloudMeta.StReply)localObject2, this.f);
    }
    else
    {
      localObject2 = new FeedCloudMeta.StComment();
      localPBStringField = ((FeedCloudMeta.StComment)localObject2).id;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeId_");
      localStringBuilder.append(System.currentTimeMillis());
      localPBStringField.set(localStringBuilder.toString());
      ((FeedCloudMeta.StComment)localObject2).content.set((String)localObject3);
      ((FeedCloudMeta.StComment)localObject2).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StComment)localObject2).postUser.set(QCirclePluginGlobalInfo.c());
      if (localObject1 != null)
      {
        QLog.d("QCircleCommentHelper", 1, "addFakeComment commentInputListener callback success");
        ((QCircleCommentHelper.CommentInputListener)localObject1).a((FeedCloudMeta.StComment)localObject2);
      }
      else
      {
        QLog.e("QCircleCommentHelper", 1, "addFakeComment commentInputListener null");
      }
      if (this.g == 103)
      {
        localObject1 = this.a;
        int j;
        if (localObject1 != null) {
          j = ((Activity)localObject1).getIntent().getIntExtra("contextHashCode", 0);
        } else {
          j = 0;
        }
        QCircleCommentHelper.b(this.i).a(j, this.h.a, (FeedCloudMeta.StComment)localObject2, this.f, true);
      }
      else
      {
        localObject3 = QCircleCommentHelper.b(this.i);
        localObject1 = this.a;
        if (localObject1 != null) {
          localObject1 = Integer.valueOf(localObject1.hashCode());
        } else {
          localObject1 = null;
        }
        ((QCircleCommentBusiness)localObject3).a(((Integer)localObject1).intValue(), this.h.a, (FeedCloudMeta.StComment)localObject2, this.f, false);
      }
    }
    this.b.a("");
    this.b.b(null);
    this.b.dismiss();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
    SimpleEventBus.getInstance().dispatchEvent(new QFSCommentSendEvent(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleCommentHelper.1
 * JD-Core Version:    0.7.0.1
 */