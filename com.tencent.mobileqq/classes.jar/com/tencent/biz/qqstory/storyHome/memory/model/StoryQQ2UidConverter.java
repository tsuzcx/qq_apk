package com.tencent.biz.qqstory.storyHome.memory.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class StoryQQ2UidConverter
  implements GetUserInfoHandler.OnGetUserInfoCallback
{
  private StoryQQ2UidConverter.StoryQQ2UidCallback a;
  
  public void a(long paramLong)
  {
    ThreadManager.post(new StoryQQ2UidConverter.1(this, paramLong), 5, null, false);
  }
  
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if (!TextUtils.equals(paramUpdateUserInfoEvent.c, String.valueOf(hashCode()))) {
      return;
    }
    if ((paramUpdateUserInfoEvent.g.isSuccess()) && (paramUpdateUserInfoEvent.a != null))
    {
      SLog.a("Q.qqstory.memories.StoryQQ2UidConverter", "get uid by qq from net. uid = %s.", paramUpdateUserInfoEvent.a.uid);
      paramUpdateUserInfoEvent = paramUpdateUserInfoEvent.a.uid;
    }
    else
    {
      paramUpdateUserInfoEvent = null;
    }
    ThreadManager.getUIHandler().post(new StoryQQ2UidConverter.2(this, paramUpdateUserInfoEvent));
  }
  
  public void a(StoryQQ2UidConverter.StoryQQ2UidCallback paramStoryQQ2UidCallback)
  {
    this.a = paramStoryQQ2UidCallback;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SLog.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid error. uid : %s.", new Object[] { paramString });
      return;
    }
    SLog.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with default uid: %s.", paramString);
    paramString = new QQUserUIItem.UserID("", paramString);
    new GetUserInfoHandler(this).a(1, paramString, String.valueOf(hashCode()));
  }
  
  public String b(long paramLong)
  {
    return ((UserManager)SuperManager.a(2)).b(String.valueOf(paramLong), false);
  }
  
  public void c(long paramLong)
  {
    if (paramLong <= 0L)
    {
      SLog.e("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq error. qq : %d.", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    SLog.a("Q.qqstory.memories.StoryQQ2UidConverter", "request valid uid with qq: %d.", Long.valueOf(paramLong));
    QQUserUIItem.UserID localUserID = new QQUserUIItem.UserID(String.valueOf(paramLong), "");
    new GetUserInfoHandler(this).a(0, localUserID, String.valueOf(hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.StoryQQ2UidConverter
 * JD-Core Version:    0.7.0.1
 */