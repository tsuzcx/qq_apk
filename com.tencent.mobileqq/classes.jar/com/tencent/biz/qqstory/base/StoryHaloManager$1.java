package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class StoryHaloManager$1
  extends FriendListObserver
{
  StoryHaloManager$1(StoryHaloManager paramStoryHaloManager) {}
  
  protected void onAddFriend(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAddFriend: invoked.  addUin: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = Long.valueOf(paramString);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      this.a.a(3, (List)localObject);
      this.a.a();
      return;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAddFriend: failed.  exception: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryHaloManager.1
 * JD-Core Version:    0.7.0.1
 */