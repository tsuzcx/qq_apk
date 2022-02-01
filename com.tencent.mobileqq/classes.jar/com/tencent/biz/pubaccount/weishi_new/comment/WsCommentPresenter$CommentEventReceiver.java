package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;

public class WsCommentPresenter$CommentEventReceiver
  extends QQUIEventReceiver<WsCommentPresenter, WSCommentEvent>
{
  private int a;
  
  WsCommentPresenter$CommentEventReceiver(@NonNull WsCommentPresenter paramWsCommentPresenter, int paramInt)
  {
    super(paramWsCommentPresenter);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@NonNull WsCommentPresenter paramWsCommentPresenter, @NonNull WSCommentEvent paramWSCommentEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEvent,commentEvent.mEventAction:");
    localStringBuilder.append(paramWSCommentEvent.jdField_a_of_type_Int);
    localStringBuilder.append(",WSHomeFragment.mCurrentPageIndex:");
    localStringBuilder.append(WSHomeFragment.jdField_a_of_type_Int);
    localStringBuilder.append(",mCurrentPageIndex:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    WSLog.c("comment", localStringBuilder.toString());
    if (WSHomeFragment.jdField_a_of_type_Int != this.jdField_a_of_type_Int)
    {
      paramWSCommentEvent = new StringBuilder();
      paramWSCommentEvent.append("commentPresenter 's hashCode:");
      paramWSCommentEvent.append(paramWsCommentPresenter.hashCode());
      paramWSCommentEvent.append(", 页面不对,不响应!");
      WSLog.d("comment", paramWSCommentEvent.toString());
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("commentPresenter 's hashCode:");
    localStringBuilder.append(paramWsCommentPresenter.hashCode());
    localStringBuilder.append(", 页面正确,开始响应~");
    WSLog.c("comment", localStringBuilder.toString());
    int i = paramWSCommentEvent.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 6)
          {
            paramWsCommentPresenter = new StringBuilder();
            paramWsCommentPresenter.append("default process,commentEvent.mEventAction:");
            paramWsCommentPresenter.append(paramWSCommentEvent.jdField_a_of_type_Int);
            WSLog.b("comment", paramWsCommentPresenter.toString());
            return;
          }
          paramWsCommentPresenter.a((Object[])paramWSCommentEvent.jdField_a_of_type_JavaLangObject);
          return;
        }
        if ((paramWSCommentEvent.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramWSCommentEvent = (Object[])paramWSCommentEvent.jdField_a_of_type_JavaLangObject;
          i = ((Integer)paramWSCommentEvent[0]).intValue();
          paramWsCommentPresenter.a(i);
          paramWSCommentEvent = ((WSVerticalItemData)paramWSCommentEvent[1]).a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("setCurrentFeed , feedId:");
          localStringBuilder.append(paramWSCommentEvent.id);
          localStringBuilder.append(", position:");
          localStringBuilder.append(i);
          localStringBuilder.append(",feed desc:");
          localStringBuilder.append(paramWSCommentEvent.feed_desc);
          WSLog.c("comment", localStringBuilder.toString());
          paramWsCommentPresenter.a(paramWSCommentEvent);
        }
        paramWSCommentEvent = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("event page change, position:");
        localStringBuilder.append(WsCommentPresenter.b(paramWsCommentPresenter));
        localStringBuilder.append(" feedId:");
        localStringBuilder.append(WsCommentPresenter.a(paramWsCommentPresenter));
        QZLog.w(paramWSCommentEvent, localStringBuilder.toString());
        WsCommentPresenter.a(paramWsCommentPresenter, null);
        WsCommentPresenter.a(paramWsCommentPresenter, "");
        WsCommentPresenter.a(paramWsCommentPresenter, 0L);
        WsCommentPresenter.a(paramWsCommentPresenter, false);
        paramWSCommentEvent = WsCommentPresenter.a(paramWsCommentPresenter);
        if ((WsCommentPresenter.c(paramWsCommentPresenter)) && (paramWSCommentEvent != null))
        {
          paramWsCommentPresenter = paramWSCommentEvent.a();
          paramWsCommentPresenter.removeMessages(11);
          paramWsCommentPresenter.sendMessageDelayed(paramWsCommentPresenter.obtainMessage(11), 20L);
        }
      }
      else
      {
        WsCommentPresenter.a(paramWsCommentPresenter);
      }
    }
    else {
      paramWsCommentPresenter.b();
    }
  }
  
  public Class acceptEventClass()
  {
    return WSCommentEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.CommentEventReceiver
 * JD-Core Version:    0.7.0.1
 */