package com.tencent.biz.qqstory.network.handler;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.ConvertUinAndUnionIdRequest;
import com.tencent.biz.qqstory.network.response.ConvertUinAndUnionIdResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class GetUserInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<ConvertUinAndUnionIdRequest, ConvertUinAndUnionIdResponse>
{
  public int c;
  public List<QQUserUIItem.UserID> d;
  public SoftReference<GetUserInfoHandler.OnGetUserInfoCallback> e;
  public String f;
  private List<QQUserUIItem.UserID> g = new ArrayList();
  private Set<String> h = new HashSet();
  private AtomicBoolean i = new AtomicBoolean(false);
  private final Object j = new Object();
  
  public GetUserInfoHandler() {}
  
  public GetUserInfoHandler(int paramInt, List<QQUserUIItem.UserID> paramList)
  {
    this.c = paramInt;
    this.d = paramList;
  }
  
  public GetUserInfoHandler(GetUserInfoHandler.OnGetUserInfoCallback paramOnGetUserInfoCallback)
  {
    this.e = new SoftReference(paramOnGetUserInfoCallback);
  }
  
  public static void e()
  {
    GetUserInfoHandler localGetUserInfoHandler = new GetUserInfoHandler();
    if (TextUtils.isEmpty(QQStoryContext.a().i()))
    {
      long l = QQStoryContext.a().h();
      localGetUserInfoHandler.a(0, new QQUserUIItem.UserID(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().i();
    localGetUserInfoHandler.a(1, new QQUserUIItem.UserID("", str), str);
  }
  
  public void a()
  {
    ConvertUinAndUnionIdRequest localConvertUinAndUnionIdRequest = new ConvertUinAndUnionIdRequest();
    localConvertUinAndUnionIdRequest.e = this.c;
    localConvertUinAndUnionIdRequest.f.addAll(this.d);
    CmdTaskManger.a().a(localConvertUinAndUnionIdRequest, this);
  }
  
  public void a(int paramInt, QQUserUIItem.UserID paramUserID, String paramString)
  {
    a(paramInt, paramUserID, paramString, false, false);
  }
  
  public void a(int paramInt, QQUserUIItem.UserID paramUserID, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {
      localObject = "unionId";
    } else {
      localObject = "uin";
    }
    SLog.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramUserID, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    Object localObject = new ConvertUinAndUnionIdRequest();
    ((ConvertUinAndUnionIdRequest)localObject).j = paramString;
    ((ConvertUinAndUnionIdRequest)localObject).e = paramInt;
    ((ConvertUinAndUnionIdRequest)localObject).f.add(paramUserID);
    ((ConvertUinAndUnionIdRequest)localObject).i = paramUserID.a();
    ((ConvertUinAndUnionIdRequest)localObject).g = paramBoolean1;
    ((ConvertUinAndUnionIdRequest)localObject).h = paramBoolean2;
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
  }
  
  public void a(int paramInt, List<QQUserUIItem.UserID> paramList)
  {
    if (paramInt == 1) {
      localObject = "unionId";
    } else {
      localObject = "uin";
    }
    SLog.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
    Object localObject = new ConvertUinAndUnionIdRequest();
    ((ConvertUinAndUnionIdRequest)localObject).e = paramInt;
    ((ConvertUinAndUnionIdRequest)localObject).f.addAll(paramList);
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
  }
  
  public void a(@NonNull ConvertUinAndUnionIdRequest paramConvertUinAndUnionIdRequest, @Nullable ConvertUinAndUnionIdResponse arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    GetUserInfoHandler.UpdateUserInfoEvent localUpdateUserInfoEvent = new GetUserInfoHandler.UpdateUserInfoEvent();
    localUpdateUserInfoEvent.d = this.f;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.a;
      ??? = new ArrayList();
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localUserManager.a(localQQUserUIItem));
      }
      localUpdateUserInfoEvent.g = paramErrorMessage;
      localUpdateUserInfoEvent.b = ???;
      localUpdateUserInfoEvent.c = paramConvertUinAndUnionIdRequest.j;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localUpdateUserInfoEvent.a = ???;
        if (paramConvertUinAndUnionIdRequest.i)
        {
          ((StoryConfigManager)SuperManager.a(10)).d("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      StoryDispatcher.a().dispatch(localUpdateUserInfoEvent);
      c();
    }
    else
    {
      SLog.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localUpdateUserInfoEvent.g = paramErrorMessage;
      localUpdateUserInfoEvent.c = paramConvertUinAndUnionIdRequest.j;
      StoryDispatcher.a().dispatch(localUpdateUserInfoEvent);
      d();
    }
    synchronized (this.j)
    {
      if ((paramConvertUinAndUnionIdRequest.e == 1) && (paramConvertUinAndUnionIdRequest.f != null))
      {
        paramConvertUinAndUnionIdRequest = paramConvertUinAndUnionIdRequest.f.iterator();
        while (paramConvertUinAndUnionIdRequest.hasNext())
        {
          paramErrorMessage = ((QQUserUIItem.UserID)paramConvertUinAndUnionIdRequest.next()).b;
          if (!TextUtils.isEmpty(paramErrorMessage)) {
            this.h.remove(paramErrorMessage);
          }
        }
      }
      paramConvertUinAndUnionIdRequest = this.e;
      if ((paramConvertUinAndUnionIdRequest != null) && (paramConvertUinAndUnionIdRequest.get() != null)) {
        ((GetUserInfoHandler.OnGetUserInfoCallback)this.e.get()).a(localUpdateUserInfoEvent);
      }
      return;
    }
    for (;;)
    {
      throw paramConvertUinAndUnionIdRequest;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.j)
    {
      if (!this.h.contains(paramString))
      {
        this.g.add(new QQUserUIItem.UserID("", paramString));
        this.h.add(paramString);
      }
      if (this.i.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserInfoHandler
 * JD-Core Version:    0.7.0.1
 */