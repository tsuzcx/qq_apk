package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserSimpleInfo;
import com.tencent.biz.qqstory.network.request.GetVideoWatcherListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoWatcherListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class QQStoryWatcherListActivity$GetWatcherHelper
  extends CmdTaskManger.UIThreadCallback<GetVideoWatcherListRequest, GetVideoWatcherListResponse>
  implements GetUserInfoHandler.OnGetUserInfoCallback
{
  final QQStoryWatcherListActivity b;
  final String c;
  final GetUserInfoHandler d;
  boolean e = true;
  List<qqstory_struct.UserSimpleInfo> f;
  List<qqstory_struct.UserSimpleInfo> g;
  int h = 0;
  protected long i = 0L;
  protected long j = 0L;
  
  public QQStoryWatcherListActivity$GetWatcherHelper(QQStoryWatcherListActivity paramQQStoryWatcherListActivity, String paramString)
  {
    this.b = paramQQStoryWatcherListActivity;
    this.c = paramString;
    this.d = new GetUserInfoHandler(this);
  }
  
  private void b()
  {
    Object localObject1 = this.f;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (this.h >= this.f.size())
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("GetWatcherHelper: requireWatcherByPage return, currentReqSeek = ");
          ((StringBuilder)localObject1).append(this.h);
          ((StringBuilder)localObject1).append(", uinCount = ");
          ((StringBuilder)localObject1).append(this.f.size());
          QLog.e("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject1).toString());
        }
        QQStoryWatcherListActivity.b(this.b, true, true, null);
        return;
      }
      localObject1 = this.f;
      int k = this.h;
      this.g = ((List)localObject1).subList(k, Math.min(k + 20, ((List)localObject1).size()));
      k = this.g.size();
      if (this.g.isEmpty())
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("GetWatcherHelper: requireWatcherByPage return, because toRequireList.isEmpty(), currentReqSeek = ");
          ((StringBuilder)localObject1).append(this.h);
          ((StringBuilder)localObject1).append(", uinCount = ");
          ((StringBuilder)localObject1).append(this.f.size());
          QLog.e("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject1).toString());
        }
        QQStoryWatcherListActivity.b(this.b, true, true, null);
        return;
      }
      Object localObject3 = (UserManager)SuperManager.a(2);
      localObject1 = new ArrayList(k);
      Object localObject2 = new ArrayList(k);
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        String str = ((qqstory_struct.UserSimpleInfo)localIterator.next()).union_id.get().toStringUtf8();
        QQUserUIItem localQQUserUIItem = ((UserManager)localObject3).b(str);
        if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
          ((List)localObject2).add(localQQUserUIItem);
        } else {
          ((List)localObject1).add(new QQUserUIItem.UserID("", str));
        }
      }
      if (((List)localObject1).isEmpty())
      {
        if (QLog.isDevelopLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("GetWatcherHelper: requireWatcherByPage load localData userIDS = ");
          ((StringBuilder)localObject3).append(localObject1);
          QLog.e("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject3).toString());
        }
        this.h += k;
        localObject1 = this.b;
        boolean bool;
        if (this.h >= this.f.size()) {
          bool = true;
        } else {
          bool = false;
        }
        QQStoryWatcherListActivity.b((QQStoryWatcherListActivity)localObject1, true, bool, (List)localObject2);
        return;
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("GetWatcherHelper: requireWatcherByPage requestUserIds = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.e("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject2).toString());
      }
      this.d.a(1, (List)localObject1);
      return;
    }
    QQStoryWatcherListActivity.b(this.b, true, true, null);
  }
  
  public void a()
  {
    Object localObject = new GetVideoWatcherListRequest();
    ((GetVideoWatcherListRequest)localObject).f = this.c;
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetWatcherHelper: requireWatcherIds feedId = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.w("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetWatcherHelper: onCallback errorInfo = ");
      ((StringBuilder)localObject).append(paramUpdateUserInfoEvent.g);
      QLog.e("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool3 = paramUpdateUserInfoEvent.g.isSuccess();
    boolean bool1 = true;
    boolean bool2 = false;
    if (bool3)
    {
      int k = this.g.size();
      localObject = (UserManager)SuperManager.a(2);
      paramUpdateUserInfoEvent = new ArrayList(k);
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = ((UserManager)localObject).b(((qqstory_struct.UserSimpleInfo)localIterator.next()).union_id.get().toStringUtf8());
        if (localQQUserUIItem != null) {
          paramUpdateUserInfoEvent.add(localQQUserUIItem);
        }
      }
      this.h += k;
      localObject = this.b;
      bool1 = bool2;
      if (this.h >= this.f.size()) {
        bool1 = true;
      }
      QQStoryWatcherListActivity.b((QQStoryWatcherListActivity)localObject, true, bool1, paramUpdateUserInfoEvent);
      return;
    }
    if (this.b.m)
    {
      paramUpdateUserInfoEvent = this.b;
      if (this.h < this.f.size()) {
        bool1 = false;
      }
      QQStoryWatcherListActivity.b(paramUpdateUserInfoEvent, false, bool1, null);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new QQStoryWatcherListActivity.GetWatcherHelper.1(this));
  }
  
  public void a(@NonNull GetVideoWatcherListRequest paramGetVideoWatcherListRequest, @Nullable GetVideoWatcherListResponse paramGetVideoWatcherListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isDevelopLevel())
    {
      paramGetVideoWatcherListRequest = new StringBuilder();
      paramGetVideoWatcherListRequest.append("GetWatcherHelper: onResponseOnUIThread errorMsg = ");
      paramGetVideoWatcherListRequest.append(paramErrorMessage);
      QLog.w("Q.qqstory.player.watcherlist.activity", 2, paramGetVideoWatcherListRequest.toString());
    }
    boolean bool = paramErrorMessage.isSuccess();
    int k = 0;
    if ((bool) && (paramGetVideoWatcherListResponse != null))
    {
      this.i = paramGetVideoWatcherListResponse.a;
      this.j = paramGetVideoWatcherListResponse.b;
      long l1 = this.j;
      long l2 = this.i;
      if (l1 < l2) {
        this.j = l2;
      }
      if (this.j > 0L)
      {
        paramGetVideoWatcherListRequest = this.b;
        paramErrorMessage = new StringBuilder();
        paramErrorMessage.append(QQStoryWatcherListActivity.a());
        paramErrorMessage.append(UIUtils.a(this.j));
        paramGetVideoWatcherListRequest.setTitle(paramErrorMessage.toString());
      }
      this.f = paramGetVideoWatcherListResponse.e;
      if (QLog.isDevelopLevel())
      {
        paramGetVideoWatcherListRequest = new StringBuilder();
        paramGetVideoWatcherListRequest.append("GetWatcherHelper: onResponseOnUIThread isSuccess mTotalWatcherCount = ");
        paramGetVideoWatcherListRequest.append(this.i);
        paramGetVideoWatcherListRequest.append(", mTotalReadTime = ");
        paramGetVideoWatcherListRequest.append(this.j);
        paramGetVideoWatcherListRequest.append(", uinCount = ");
        paramGetVideoWatcherListResponse = this.f;
        if (paramGetVideoWatcherListResponse != null) {
          k = paramGetVideoWatcherListResponse.size();
        }
        paramGetVideoWatcherListRequest.append(k);
        QLog.w("Q.qqstory.player.watcherlist.activity", 2, paramGetVideoWatcherListRequest.toString());
      }
      if (this.b.k != null)
      {
        this.b.k.mViewTotalTime = this.j;
        ((FeedManager)SuperManager.a(11)).a(this.b.k);
      }
      b();
      return;
    }
    QQStoryWatcherListActivity.b(this.b, false, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity.GetWatcherHelper
 * JD-Core Version:    0.7.0.1
 */