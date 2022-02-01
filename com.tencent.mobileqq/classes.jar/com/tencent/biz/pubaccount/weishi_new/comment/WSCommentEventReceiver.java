package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class WSCommentEventReceiver
  extends QQUIEventReceiver<WsCommentPresenter, WSCommentEvent>
{
  WSCommentEventReceiver(@NonNull WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(@NonNull WsCommentPresenter paramWsCommentPresenter, @NonNull WSCommentEvent paramWSCommentEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSCommentEventReceiver.java][onEvent] commentEvent.mEventAction:");
    localStringBuilder.append(paramWSCommentEvent.a);
    WSLog.a("comment", localStringBuilder.toString());
    int i = paramWSCommentEvent.a;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 6)
          {
            paramWsCommentPresenter = new StringBuilder();
            paramWsCommentPresenter.append("[WSCommentEventReceiver.java][onEvent] default process,commentEvent.mEventAction:");
            paramWsCommentPresenter.append(paramWSCommentEvent.a);
            WSLog.a("comment", paramWsCommentPresenter.toString());
            return;
          }
          paramWsCommentPresenter.a((Object[])paramWSCommentEvent.b);
          return;
        }
        if ((paramWSCommentEvent.b instanceof Object[]))
        {
          paramWSCommentEvent = (Object[])paramWSCommentEvent.b;
          i = ((Integer)paramWSCommentEvent[0]).intValue();
          paramWsCommentPresenter.a(i);
          paramWSCommentEvent = ((WSVerticalItemData)paramWSCommentEvent[1]).b();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[WSCommentEventReceiver.java][onEvent] , feedId:");
          localStringBuilder.append(paramWSCommentEvent.id);
          localStringBuilder.append(", position:");
          localStringBuilder.append(i);
          localStringBuilder.append(",feed desc:");
          localStringBuilder.append(paramWSCommentEvent.feed_desc);
          WSLog.a("comment", localStringBuilder.toString());
          paramWsCommentPresenter.a(paramWSCommentEvent);
        }
        paramWSCommentEvent = new StringBuilder();
        paramWSCommentEvent.append("[WSCommentEventReceiver.java][onEvent] event page change, position:");
        paramWSCommentEvent.append(paramWsCommentPresenter.o());
        paramWSCommentEvent.append(" feedId:");
        paramWSCommentEvent.append(paramWsCommentPresenter.g());
        WSLog.a("comment", paramWSCommentEvent.toString());
        paramWsCommentPresenter.s();
        paramWSCommentEvent = paramWsCommentPresenter.h();
        if ((paramWsCommentPresenter.q()) && (paramWSCommentEvent != null))
        {
          paramWsCommentPresenter = paramWSCommentEvent.a();
          paramWsCommentPresenter.removeMessages(11);
          paramWsCommentPresenter.sendMessageDelayed(paramWsCommentPresenter.obtainMessage(11), 20L);
        }
      }
      else
      {
        paramWsCommentPresenter.k();
      }
    }
    else {
      paramWsCommentPresenter.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return WSCommentEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentEventReceiver
 * JD-Core Version:    0.7.0.1
 */