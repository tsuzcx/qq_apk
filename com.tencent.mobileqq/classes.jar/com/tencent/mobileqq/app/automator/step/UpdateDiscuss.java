package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;

public class UpdateDiscuss
  extends AsyncStep
{
  private DiscussionObserver a;
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new UpdateDiscuss.MyDiscussionObserver(this, null);
      this.mAutomator.k.addObserver(this.a);
    }
    ((DiscussionHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).f(Long.valueOf(this.mAutomator.k.getCurrentAccountUin()).longValue());
  }
  
  protected int doStep()
  {
    boolean bool = this.mAutomator.d.getBoolean("isDiscussionlistok", false);
    DiscussionManager localDiscussionManager = (DiscussionManager)this.mAutomator.k.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (bool)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      localDiscussionManager.a();
      localFriendListHandler.notifyUI(1000, true, null);
      this.mAutomator.notifyUI(3, true, Integer.valueOf(3));
      return 7;
    }
    localDiscussionManager.a();
    a();
    return 2;
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.k.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss
 * JD-Core Version:    0.7.0.1
 */