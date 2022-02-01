package com.tencent.mobileqq.activity;

import QQService.DiscussMemberInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class JoinDiscussionActivity$FaceObserver
  extends AvatarObserver
{
  private JoinDiscussionActivity$FaceObserver(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.j != null))
    {
      if (this.a.app.getCurrentAccountUin().equals(paramString)) {
        return;
      }
      int j = 0;
      Object localObject = this.a.j.iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!String.valueOf(((DiscussMemberInfo)((Iterator)localObject).next()).Uin).equals(paramString));
      int i = 1;
      if ((i != 0) && (!this.a.p.contains(paramString)))
      {
        this.a.p.add(paramString);
        localObject = new StringBuilder();
        JoinDiscussionActivity localJoinDiscussionActivity = this.a;
        ((StringBuilder)localObject).append(localJoinDiscussionActivity.o);
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(";");
        localJoinDiscussionActivity.o = ((StringBuilder)localObject).toString();
        if (this.a.p.size() == this.a.n) {
          ThreadManager.post(new JoinDiscussionActivity.FaceObserver.1(this), 8, null, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.FaceObserver
 * JD-Core Version:    0.7.0.1
 */