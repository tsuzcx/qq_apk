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
    WSLog.c("comment", "onEvent,commentEvent.mEventAction:" + paramWSCommentEvent.jdField_a_of_type_Int + ",WSHomeFragment.mCurrentPageIndex:" + WSHomeFragment.jdField_a_of_type_Int + ",mCurrentPageIndex:" + this.jdField_a_of_type_Int);
    if (WSHomeFragment.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
      WSLog.d("comment", "commentPresenter 's hashCode:" + paramWsCommentPresenter.hashCode() + ", 页面不对,不响应!");
    }
    do
    {
      return;
      WSLog.c("comment", "commentPresenter 's hashCode:" + paramWsCommentPresenter.hashCode() + ", 页面正确,开始响应~");
      switch (paramWSCommentEvent.jdField_a_of_type_Int)
      {
      case 3: 
      case 5: 
      default: 
        WSLog.b("comment", "default process,commentEvent.mEventAction:" + paramWSCommentEvent.jdField_a_of_type_Int);
        return;
      case 1: 
        paramWsCommentPresenter.b();
        return;
      case 2: 
        WsCommentPresenter.a(paramWsCommentPresenter);
        return;
      case 4: 
        if ((paramWSCommentEvent.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramWSCommentEvent = (Object[])paramWSCommentEvent.jdField_a_of_type_JavaLangObject;
          int i = ((Integer)paramWSCommentEvent[0]).intValue();
          paramWsCommentPresenter.a(i);
          paramWSCommentEvent = ((WSVerticalItemData)paramWSCommentEvent[1]).a();
          WSLog.c("comment", "setCurrentFeed , feedId:" + paramWSCommentEvent.id + ", position:" + i + ",feed desc:" + paramWSCommentEvent.feed_desc);
          paramWsCommentPresenter.a(paramWSCommentEvent);
        }
        QZLog.w(this.TAG, "event page change, position:" + WsCommentPresenter.b(paramWsCommentPresenter) + " feedId:" + WsCommentPresenter.a(paramWsCommentPresenter));
        WsCommentPresenter.a(paramWsCommentPresenter, null);
        WsCommentPresenter.a(paramWsCommentPresenter, "");
        WsCommentPresenter.a(paramWsCommentPresenter, 0L);
        WsCommentPresenter.a(paramWsCommentPresenter, false);
        paramWSCommentEvent = WsCommentPresenter.a(paramWsCommentPresenter);
      }
    } while ((!WsCommentPresenter.c(paramWsCommentPresenter)) || (paramWSCommentEvent == null));
    paramWsCommentPresenter = paramWSCommentEvent.a();
    paramWsCommentPresenter.removeMessages(11);
    paramWsCommentPresenter.sendMessageDelayed(paramWsCommentPresenter.obtainMessage(11), 20L);
    return;
    paramWsCommentPresenter.a((Object[])paramWSCommentEvent.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return WSCommentEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.CommentEventReceiver
 * JD-Core Version:    0.7.0.1
 */