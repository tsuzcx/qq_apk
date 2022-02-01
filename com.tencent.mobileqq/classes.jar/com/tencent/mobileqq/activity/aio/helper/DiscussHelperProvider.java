package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.bubble.LeftSwipeReplyHelper;

public class DiscussHelperProvider
  extends HelperProvider
{
  public DiscussHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(DiscussChatPie paramDiscussChatPie)
  {
    a(50, new LeftSwipeReplyHelper(paramDiscussChatPie));
    a(109, new DiscTipsHelper(paramDiscussChatPie.b()));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((DiscussChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.DiscussHelperProvider
 * JD-Core Version:    0.7.0.1
 */