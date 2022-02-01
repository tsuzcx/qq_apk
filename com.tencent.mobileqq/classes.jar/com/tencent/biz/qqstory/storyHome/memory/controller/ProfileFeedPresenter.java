package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetProfileYearNodeListRequest;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedData;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.HomeFeedPresenterListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ProfileFeedPresenter
  extends HomeFeedPresenter
{
  private static String d = "feed_data_request";
  private static String e = "year_node_data_request";
  public boolean a = false;
  public List<MomeriesYearNode> b = new ArrayList();
  private List<String> f = new ArrayList();
  private HomeFeedData g;
  private ProfileFeedPresenter.GetYearNodeListEvent h;
  private ProfileFeedPresenter.FeedPresenterListener i;
  private ProfileFeedPresenter.VideoDeleteReceiver j;
  private ProfileFeedPresenter.UploadStatusReceiver k;
  private ProfileFeedPresenter.GetYearNodeListReceiver l;
  
  public ProfileFeedPresenter(int paramInt, @NonNull HomeFeedPresenter.HomeFeedPresenterListener paramHomeFeedPresenterListener, @NonNull ProfileFeedPresenter.FeedPresenterListener paramFeedPresenterListener, boolean paramBoolean)
  {
    super(paramInt, paramHomeFeedPresenterListener, paramBoolean);
    this.i = paramFeedPresenterListener;
  }
  
  private void a(List<MomeriesYearNode> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.clear();
    }
    this.b.addAll(paramList);
  }
  
  private void b(boolean paramBoolean)
  {
    SLog.a("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    GetProfileYearNodeListRequest localGetProfileYearNodeListRequest = new GetProfileYearNodeListRequest();
    localGetProfileYearNodeListRequest.e = QQStoryContext.a().i();
    CmdTaskManger.a().a(localGetProfileYearNodeListRequest, new ProfileFeedPresenter.1(this, paramBoolean));
  }
  
  private void j()
  {
    SLog.b("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.f.size()));
    if (!this.f.isEmpty()) {
      return;
    }
    HomeFeedData localHomeFeedData = this.g;
    if ((localHomeFeedData != null) && (this.h != null))
    {
      if ((!localHomeFeedData.g.isFail()) && (!this.h.g.isFail()))
      {
        SLog.b("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
        this.a = true;
        a(this.h.b, true);
        b(this.g);
        return;
      }
      SLog.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.g.g.isFail()), Boolean.valueOf(this.h.g.isFail()) });
      this.i.a(false);
      return;
    }
    SLog.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.g, this.h });
  }
  
  public void a()
  {
    super.a();
    this.j = new ProfileFeedPresenter.VideoDeleteReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.j);
    this.k = new ProfileFeedPresenter.UploadStatusReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.k);
    this.l = new ProfileFeedPresenter.GetYearNodeListReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.l);
  }
  
  public void a(HomeFeedData paramHomeFeedData)
  {
    SLog.b("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(paramHomeFeedData.d ^ true));
    ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramHomeFeedData));
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.a(true);
      a(((MemoryManager)SuperManager.a(19)).c(), true);
      if ((i().size() > 0) && (this.b.size() > 0)) {
        this.a = true;
      }
    }
    else
    {
      this.f.clear();
      this.g = null;
      this.h = null;
      super.a(false);
      this.f.add(d);
      b(false);
      this.f.add(e);
    }
  }
  
  public void b()
  {
    super.b();
    StoryDispatcher.a().unRegisterSubscriber(this.j);
    StoryDispatcher.a().unRegisterSubscriber(this.k);
    StoryDispatcher.a().unRegisterSubscriber(this.l);
  }
  
  protected void b(HomeFeedData paramHomeFeedData)
  {
    super.a(paramHomeFeedData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter
 * JD-Core Version:    0.7.0.1
 */