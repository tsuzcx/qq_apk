package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleLikeBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StReply;
import java.util.List;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;

class QCircleDefaultMessagePresenter$3
  implements View.OnClickListener
{
  QCircleDefaultMessagePresenter$3(QCircleDefaultMessagePresenter paramQCircleDefaultMessagePresenter) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.l;
    int j = 7;
    String str = "";
    Object localObject3;
    Object localObject1;
    if (i == 6)
    {
      localObject3 = (FeedCloudMeta.StComment)this.a.d.operation.comment.get();
      localObject1 = str;
      if (localObject3 != null)
      {
        localObject1 = str;
        if (((FeedCloudMeta.StComment)localObject3).likeInfo.get() != null) {
          localObject1 = ((FeedCloudMeta.StLike)((FeedCloudMeta.StComment)localObject3).likeInfo.get()).id.get();
        }
      }
      i = 6;
    }
    else if (this.a.l == 7)
    {
      localObject3 = (FeedCloudMeta.StComment)this.a.d.operation.comment.get();
      i = j;
      localObject1 = str;
      if (localObject3 != null)
      {
        localObject3 = ((FeedCloudMeta.StComment)localObject3).vecReply.get();
        i = j;
        localObject1 = str;
        if (localObject3 != null)
        {
          i = j;
          localObject1 = str;
          if (((List)localObject3).size() > 0)
          {
            i = j;
            localObject1 = str;
            if (((List)localObject3).get(0) != null)
            {
              i = j;
              localObject1 = str;
              if (((FeedCloudMeta.StReply)((List)localObject3).get(0)).likeInfo.get() != null)
              {
                localObject1 = ((FeedCloudMeta.StLike)((FeedCloudMeta.StReply)((List)localObject3).get(0)).likeInfo.get()).id.get();
                i = j;
              }
            }
          }
        }
      }
    }
    else
    {
      i = 2;
      localObject1 = str;
    }
    long l1 = 0L;
    if ((this.a.e != null) && (this.a.e.busiInfo.get() != null)) {
      try
      {
        j = Integer.parseInt(QCirclePluginUtil.a(this.a.e.busiInfo.get(), "unread_like_count", "0"));
        try
        {
          long l2 = Long.parseLong(QCirclePluginUtil.a(this.a.e.busiInfo.get(), "last_like_time", "0"));
          l1 = l2;
        }
        catch (Exception localException1) {}
        QLog.e("QCircleDefaultMessagePresenter", 1, localException2, new Object[0]);
      }
      catch (Exception localException2)
      {
        j = 0;
      }
    } else {
      j = 0;
    }
    Object localObject2 = new QCircleLikeBean();
    ((QCircleLikeBean)localObject2).setFeed(this.a.d.feed);
    ((QCircleLikeBean)localObject2).setRequestType(i);
    ((QCircleLikeBean)localObject2).setLikeId((String)localObject1);
    ((QCircleLikeBean)localObject2).setCount(j);
    ((QCircleLikeBean)localObject2).setTime(l1);
    ((QCircleLikeBean)localObject2).setFromReportBean(this.a.d().clone());
    QCircleLauncher.a(paramView.getContext(), (QCircleLikeBean)localObject2);
    localObject2 = new QCircleLpReportDc05504.DataBuilder().setActionType(17).setSubActionType(12).setThrActionType(1);
    if (this.a.d != null) {
      localObject1 = this.a.d.busiReport.get().toByteArray();
    } else {
      localObject1 = null;
    }
    QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject2).setMsgReportInfo((byte[])localObject1).setPageId(this.a.d().getPageId()));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleDefaultMessagePresenter.3
 * JD-Core Version:    0.7.0.1
 */