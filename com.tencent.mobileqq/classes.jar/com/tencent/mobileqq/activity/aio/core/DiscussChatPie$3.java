package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import java.util.ArrayList;

class DiscussChatPie$3
  extends DiscussionObserver
{
  DiscussChatPie$3(DiscussChatPie paramDiscussChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(this.a.ah.b);
    if ((i != -1) && (paramBoolean))
    {
      if (((Boolean)paramObject.get(i + 1)).booleanValue()) {
        this.a.a(false, false);
      }
      if (this.a.ah.a == 3000)
      {
        paramObject = ((DiscussionManager)this.a.d.getManager(QQManagerFactory.DISCUSSION_MANAGER)).d(this.a.ah.b);
        if ((paramObject != null) && (paramObject.discussionName != null))
        {
          this.a.ah.e = paramObject.discussionName;
          DiscussChatPie localDiscussChatPie = this.a;
          localDiscussChatPie.a(localDiscussChatPie.ah.e, paramObject.uin, this.a.C);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.ah.b.equals(paramString)) && (this.a.ah.a == 3000))
    {
      paramString = ((DiscussionManager)this.a.d.getManager(QQManagerFactory.DISCUSSION_MANAGER)).d(paramString);
      if ((paramString != null) && (paramString.discussionName != null))
      {
        this.a.ah.e = paramString.discussionName;
        DiscussChatPie localDiscussChatPie = this.a;
        localDiscussChatPie.a(localDiscussChatPie.ah.e, paramString.uin, this.a.C);
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (this.a.ah.b.equals(paramString)) {
      this.a.L();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.3
 * JD-Core Version:    0.7.0.1
 */