package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;

public class GetUserSelfInfoStep
  extends SimpleStep
  implements CmdTaskManger.CommandCallback<GetUserSelfInfoStep.Request, GetUserSelfInfoStep.Response>
{
  private boolean a = false;
  private Repository b;
  
  public GetUserSelfInfoStep(Repository paramRepository)
  {
    this.b = paramRepository;
  }
  
  public static boolean a(MyStorys paramMyStorys)
  {
    if (paramMyStorys != null)
    {
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      paramMyStorys.i = ((Integer)localStoryConfigManager.c("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      boolean bool;
      if (((Integer)localStoryConfigManager.c("qqstory_i_am_vip", Integer.valueOf(0))).intValue() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramMyStorys.h = bool;
      paramMyStorys.j = ((Integer)localStoryConfigManager.c("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      paramMyStorys.k = ((Integer)localStoryConfigManager.c("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      paramMyStorys.l = ((String)localStoryConfigManager.c("qqstory_my_newest_video_cover", ""));
      paramMyStorys.m = ((String)localStoryConfigManager.c("qqstory_my_newest_video_vid", ""));
      return true;
    }
    throw new IllegalArgumentException("argument can't be null");
  }
  
  public void a(@NonNull GetUserSelfInfoStep.Request paramRequest, @Nullable GetUserSelfInfoStep.Response paramResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.d("Q.qqstory.home.GetUserSelfInfoStep", "onCmdRespond");
    if (g())
    {
      SLog.e("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest was reseted !");
      h();
      return;
    }
    if (paramErrorMessage.isFail())
    {
      SLog.c("Q.qqstory.home.GetUserSelfInfoStep", "GetUserSelfInfoRequest is failed", paramErrorMessage);
      b(paramErrorMessage);
      return;
    }
    paramRequest = (UserManager)SuperManager.a(2);
    if (paramRequest.b(paramResponse.b) == null)
    {
      paramErrorMessage = new QQUserUIItem();
      paramErrorMessage.uid = paramResponse.b;
      int i = paramResponse.a;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      paramErrorMessage.isVip = bool;
      paramRequest.a(paramErrorMessage);
    }
    paramRequest = this.b;
    if (paramRequest != null)
    {
      paramRequest.a(new GetUserSelfInfoStep.1(this, paramResponse));
      return;
    }
    SLog.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self2 info: %s", paramResponse);
    paramRequest = (StoryConfigManager)SuperManager.a(10);
    paramRequest.d("qqstory_my_fans_count", Integer.valueOf(paramResponse.e));
    paramRequest.d("qqstory_i_am_vip", Integer.valueOf(paramResponse.a));
    paramRequest.d("qqstory_my_vidoe_count", Integer.valueOf(paramResponse.f));
    paramRequest.d("qqstory_my_visiter_count", Integer.valueOf(paramResponse.g));
    paramRequest.d("qqstory_my_newest_video_cover", paramResponse.h);
    paramRequest.d("qqstory_my_newest_video_vid", paramResponse.i);
    QQStoryContext.a().a(paramResponse.b);
    h();
  }
  
  public void b()
  {
    SLog.d("Q.qqstory.home.GetUserSelfInfoStep", "run");
    GetUserSelfInfoStep.Request localRequest = new GetUserSelfInfoStep.Request();
    CmdTaskManger.a().a(localRequest, this);
  }
  
  public String c()
  {
    return "GetUserSelfInfoStep";
  }
  
  public void e() {}
  
  public void f()
  {
    try
    {
      this.a = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean g()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep
 * JD-Core Version:    0.7.0.1
 */