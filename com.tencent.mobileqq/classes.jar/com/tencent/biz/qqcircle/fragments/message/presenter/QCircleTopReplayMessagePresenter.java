package com.tencent.biz.qqcircle.fragments.message.presenter;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean.QCircleActionBean;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StReply;
import java.util.List;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class QCircleTopReplayMessagePresenter
  extends QCircleDefaultMessagePresenter
{
  public QCircleTopReplayMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  public void a(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      Object localObject = (FeedCloudMeta.StComment)this.d.operation.comment.get();
      if (localObject != null)
      {
        localStBusiInfoCommentListData.comment.set((MessageMicro)localObject);
        localObject = ((FeedCloudMeta.StComment)localObject).vecReply.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int i = ((List)localObject).size();
          localStBusiInfoCommentListData.reply.set((MessageMicro)((List)localObject).get(i - 1));
        }
        localObject = new QCircleInitBean.QCircleActionBean();
        ((QCircleInitBean.QCircleActionBean)localObject).mShowInputKeyboard = false;
        paramQCircleInitBean.setBusiInfoData(localStBusiInfoCommentListData.toByteArray());
        paramQCircleInitBean.setActionBean((QCircleInitBean.QCircleActionBean)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleTopReplayMessagePresenter
 * JD-Core Version:    0.7.0.1
 */