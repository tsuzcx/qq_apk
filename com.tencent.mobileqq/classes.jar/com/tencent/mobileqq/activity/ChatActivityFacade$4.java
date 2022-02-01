package com.tencent.mobileqq.activity;

import com.tencent.av.utils.CharacterUtil;
import com.tencent.biz.richframework.network.servlet.QzoneAioStoryFeedServlet;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;

final class ChatActivityFacade$4
  implements Runnable
{
  ChatActivityFacade$4(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    Object localObject;
    if (ChatActivityFacade.f(this.a, this.b, true))
    {
      long l = ChatActivityFacade.l(this.a, this.b);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lastTime: ");
      ((StringBuilder)localObject).append(l);
      QLog.i("ChatActivityFacade.QZoneStoryFeeds", 1, ((StringBuilder)localObject).toString());
      localObject = new NewIntent(this.a.getApplication(), QzoneAioStoryFeedServlet.class);
      ((NewIntent)localObject).putExtra("key_last_aio_story_create_time", l);
    }
    try
    {
      ((NewIntent)localObject).putExtra("key_friend_uid", CharacterUtil.b(this.b.b));
    }
    catch (Exception localException)
    {
      label103:
      StringBuilder localStringBuilder;
      break label103;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Long.valueOf ");
    localStringBuilder.append(this.b.b);
    QLog.e("ChatActivityFacade.QZoneStoryFeeds", 1, localStringBuilder.toString());
    ChatActivityFacade.c().a = new WeakReference(this.a);
    ChatActivityFacade.c().b = this.b;
    ((NewIntent)localObject).setObserver(ChatActivityFacade.c());
    this.a.startServlet((NewIntent)localObject);
    ChatActivityFacade.e(this.a, this.b, "key_last_req_aio_story_feed_time");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.4
 * JD-Core Version:    0.7.0.1
 */