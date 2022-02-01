package com.tencent.biz.qqstory.storyHome.detail.view;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.FeedCommentDataProvider;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.comment.FeedLikeDataProvider;
import com.tencent.biz.qqstory.comment.StoryFailCommentCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TagManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.OnFeedItemPullListener;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.CommentHelperCallback;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class StoryDetailPresenter
  implements DetailEventCallback, DetailFeedAllInfoPuller.OnFeedItemPullListener, DetailCommentHelper.CommentHelperCallback, IEventReceiver
{
  private FeedManager A;
  private LikeManager B;
  private CommentManager C;
  private FeedVideoManager D;
  protected StoryDetailPresenter.DetailFeedPushObserver a;
  private final String b;
  private final int c;
  private final int d;
  private final StoryDetailFragment e;
  private AtomicBoolean f = new AtomicBoolean(false);
  private DetailFeedItem g;
  private int h = -1;
  private DetailFeedAllInfoPuller i;
  private VideoListPageLoader j;
  private DetailLikeListLoader k;
  private DetailLikeListLoader l;
  private CommentListPageLoader m;
  private CommentListPageLoader n;
  private StoryDetailPresenter.FeedVideoListReceiver o;
  private StoryDetailPresenter.LikeListReceiver p;
  private StoryDetailPresenter.CommentListReceiver q;
  private StoryDetailPresenter.FeedInfoUpdateReceiver r;
  private StoryDetailPresenter.UploadStatusReceiver s;
  private StoryDetailPresenter.VideoDeleteReceiver t;
  private StoryDetailPresenter.VideoNoInterestingReceiver u;
  private StoryDetailPresenter.GetFeedFeatureReceiver v;
  private StoryDetailPresenter.FeedVideoCookieUpdate w;
  private StoryDetailPresenter.GetUserInfoReceiver x;
  private StoryDetailPresenter.TroopNickNameUpdateEventReceiver y;
  private StoryDetailPresenter.GetTagInfoListReceiver z;
  
  public StoryDetailPresenter(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.e = paramStoryDetailFragment;
    this.b = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
    this.a = new StoryDetailPresenter.DetailFeedPushObserver(this.b, new StoryDetailPresenter.1(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    if ((paramInt != 2) && (paramInt != 1))
    {
      paramCommentEntry = new FeedInfoChangeEvent(2, this.g.a.feedId, paramInt, this.g.a);
    }
    else
    {
      FeedInfoChangeEvent localFeedInfoChangeEvent = new FeedInfoChangeEvent(2, paramCommentEntry.feedId, paramInt);
      localFeedInfoChangeEvent.e = paramCommentEntry.commentId;
      paramCommentEntry = localFeedInfoChangeEvent;
    }
    paramCommentEntry.c = this.g.a;
    StoryDispatcher.a().dispatch(paramCommentEntry);
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.g.b(paramCommentEntry, paramBoolean);
    DetailFeedItem localDetailFeedItem = this.g;
    localDetailFeedItem.a = ((CommentLikeFeedItem)this.A.a(localDetailFeedItem.a));
    this.C.d(paramCommentEntry);
    StoryFailCommentCacher.a().b();
    QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.a(2131911730), 0).show();
    a(this.g);
    this.e.a(this.g, j());
    a(2, paramCommentEntry);
  }
  
  private void a(DetailFeedItem paramDetailFeedItem)
  {
    if (paramDetailFeedItem == null) {
      return;
    }
    if (paramDetailFeedItem.b())
    {
      if (paramDetailFeedItem.c())
      {
        if (this.h == -1) {
          this.h = 1;
        }
      }
      else {
        this.h = 1;
      }
    }
    else if (this.h != -1) {
      this.h = -1;
    }
  }
  
  private void a(String paramString)
  {
    int i1 = StoryReportor.b(this.g.a);
    String str;
    if ((this.g.a.getOwner() instanceof ShareGroupItem)) {
      str = this.g.a.getOwner().getUnionId();
    } else {
      str = "";
    }
    StoryReportor.a("home_page", paramString, StoryReportor.a(this.g.a), 0, new String[] { String.valueOf(i1), StoryReportor.b(this.c), this.g.a.feedId, str });
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = QQStoryContext.a().i();
    String str = PlayModeUtils.b().getCurrentUin();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.b;
    localObject = ((UserManager)SuperManager.a(2)).b((String)localObject);
    if (localObject != null)
    {
      long l1;
      if (((QQUserUIItem)localObject).isVip) {
        l1 = 2L;
      } else {
        l1 = 0L;
      }
      localLikeEntry.role = l1;
    }
    if (paramBoolean1)
    {
      this.g.a.mHadLike = 1;
      this.g.a(localLikeEntry, paramBoolean2);
      this.A.a(this.g.a);
      this.B.a(localLikeEntry);
    }
    else
    {
      this.g.a.mHadLike = 0;
      this.g.b(localLikeEntry, paramBoolean2);
      this.A.a(this.g.a);
      this.B.b(localLikeEntry);
    }
    SLog.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.g.a.mHadLike), Integer.valueOf(this.g.a.mLikeCount), Integer.valueOf(this.g.f(true)), Integer.valueOf(this.g.e(true).size()), Integer.valueOf(this.g.f(false)), Integer.valueOf(this.g.e(false).size()) });
  }
  
  private void b(DetailFeedItem paramDetailFeedItem)
  {
    int i1 = this.c;
    String str2 = "2";
    String str1;
    if (i1 != 23)
    {
      if (i1 != 210)
      {
        if (i1 != 211)
        {
          if ((i1 != 220) && (i1 != 221)) {
            str1 = "";
          } else {
            str1 = "2";
          }
        }
        else {
          str1 = "4";
        }
      }
      else {
        str1 = "1";
      }
    }
    else {
      str1 = "3";
    }
    i1 = StoryReportor.a(paramDetailFeedItem.a);
    if (paramDetailFeedItem.a.getOwner().isMe()) {
      str2 = "1";
    }
    StoryReportor.a("home_page", "exp_detail", i1, 0, new String[] { str2, str1, "", paramDetailFeedItem.a.feedId });
  }
  
  private static void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull String paramString1, String paramString2)
  {
    if (paramStoryDetailPresenter.g == null)
    {
      SLog.b(paramString2, "ignore this video delete event. %s.", paramString1);
      return;
    }
    SLog.a(paramString2, "receive video delete event. %s.", paramString1);
    Iterator localIterator = paramStoryDetailPresenter.g.a().iterator();
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (localStoryVideoItem.mVid.equals(paramString1))
      {
        paramStoryDetailPresenter.g.a().remove(localStoryVideoItem);
        SLog.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramStoryDetailPresenter.g.a().size()));
        if (paramStoryDetailPresenter.g.a().size() == 0) {
          paramStoryDetailPresenter.e.b();
        } else {
          paramStoryDetailPresenter.a();
        }
        if (localStoryVideoItem.mTagInfoBase != null) {
          paramStoryDetailPresenter.m();
        }
        return;
      }
    }
    SLog.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramStoryDetailPresenter.g.a().size()) });
  }
  
  private void d(int paramInt)
  {
    if (paramInt != -1)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        if (this.k == null) {
          this.k = new DetailLikeListLoader(this.b, true, 1);
        }
      }
      else if (this.l == null)
      {
        this.l = new DetailLikeListLoader(this.b, true, 0);
      }
    }
    else if (this.k == null) {
      this.k = new DetailLikeListLoader(this.b, true);
    }
  }
  
  private void e(int paramInt)
  {
    if (paramInt != -1)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        if (this.m == null) {
          this.m = new CommentListPageLoader(new FeedCommentSync(this.b, 2, this.g.c(true), 1), "StoryDetailPresenter");
        }
      }
      else if (this.n == null)
      {
        this.n = new CommentListPageLoader(new FeedCommentSync(this.b, 2, this.g.c(false), 0), "StoryDetailPresenter");
      }
    }
    else if (this.m == null) {
      this.m = new CommentListPageLoader(new FeedCommentSync(this.b, 2, this.g.c(true)), "StoryDetailPresenter");
    }
  }
  
  private boolean j()
  {
    int i1 = this.h;
    return (i1 == -1) || (i1 == 2);
  }
  
  private void k()
  {
    if (!this.g.b())
    {
      d(-1);
      this.k.a(true);
      return;
    }
    d(1);
    this.l.a(true);
    d(2);
    this.k.a(true);
  }
  
  private void l()
  {
    if (!this.g.b())
    {
      if (this.g.b(true))
      {
        e(-1);
        this.m.c();
      }
    }
    else
    {
      if (this.g.b(false))
      {
        e(1);
        this.n.c();
      }
      if (this.g.b(true))
      {
        e(2);
        this.m.c();
      }
    }
  }
  
  private void m()
  {
    if (TextUtils.isEmpty(this.b))
    {
      SLog.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    SLog.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    TagManager localTagManager = (TagManager)SuperManager.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    localTagManager.a(localArrayList);
  }
  
  private void n()
  {
    List localList = ((TagManager)SuperManager.a(27)).a(this.g.a.feedId, this.g.a());
    this.g.b(localList, true);
    SLog.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.g.d());
  }
  
  private void o()
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((CommentListPageLoader)localObject).b(this.g.c(true));
    }
    localObject = this.n;
    if (localObject != null) {
      ((CommentListPageLoader)localObject).b(this.g.c(false));
    }
    if (this.j != null)
    {
      if (!this.g.e())
      {
        SLog.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      localObject = this.g.f().getVideoInfo();
      this.j.a(((FeedVideoInfo)localObject).mVideoPullType, ((FeedVideoInfo)localObject).mVideoNextCookie, ((FeedVideoInfo)localObject).mVideoSeq);
    }
  }
  
  public void a()
  {
    this.e.c();
  }
  
  public void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    SLog.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.e.getBaseActivity() == null) {
      return;
    }
    StoryApi.a(this.e.getBaseActivity(), 12, paramString);
    if (paramInt == 1) {
      paramString = "clk_reply_nick";
    } else {
      paramString = "clk_like_name";
    }
    a(paramString);
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    boolean bool = j();
    if ((!this.g.b(bool)) && (this.g.h(bool) == null))
    {
      localObject = DetailCommentHelper.a(this.g.d(bool) - this.g.a(bool).size());
      this.g.c((CommentEntry)localObject, bool);
      this.g.a((CommentEntry)localObject, bool);
    }
    this.g.a(paramCommentEntry, bool);
    SLog.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.g.a.mCommentCount), Integer.valueOf(this.g.a.mFanCommentCount), Integer.valueOf(this.g.a.mFriendCommentCount));
    int i1;
    if (this.g.a.mDenyComment == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131911733), 0).show();
      paramCommentEntry.status = 2;
    }
    this.e.c();
    bq_();
    Object localObject = this.g;
    ((DetailFeedItem)localObject).a = ((CommentLikeFeedItem)this.A.a(((DetailFeedItem)localObject).a));
    if (this.g.b())
    {
      if (bool)
      {
        paramCommentEntry.type = 4;
        paramCommentEntry.pbType = 1;
      }
      else
      {
        paramCommentEntry.type = 3;
        paramCommentEntry.pbType = 0;
      }
      this.C.a(paramCommentEntry);
    }
    else
    {
      paramCommentEntry.pbType = this.g.a.getCommentLikeType();
      this.C.b(paramCommentEntry);
    }
    if (i1 == 0) {
      b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.e.b == null) {
      return;
    }
    this.e.b.a(paramCommentEntry, paramInt, h());
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    if (this.f.get())
    {
      SLog.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramDetailFeedItem);
    if ((this.g == null) && (paramErrorMessage.isSuccess())) {
      b(paramDetailFeedItem);
    }
    boolean bool = false;
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.g = paramDetailFeedItem;
        this.e.a(this.g, j());
      }
      a(false);
    }
    else
    {
      if (paramErrorMessage.isSuccess())
      {
        this.g = paramDetailFeedItem;
        n();
        if ((this.g.g()) && (!this.g.h().mIsVideoEnd)) {
          m();
        }
        o();
        this.e.a(this.g, j());
      }
      else if (paramErrorMessage.errorCode == 2222)
      {
        this.e.b();
      }
      else if (this.g == null)
      {
        this.e.b();
      }
      if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
        bool = true;
      }
      StoryDetailFragment localStoryDetailFragment = this.e;
      localStoryDetailFragment.a(bool, localStoryDetailFragment.c(paramDetailFeedItem, j()));
    }
    bool = paramErrorMessage.isSuccess();
    if (paramErrorMessage.isSuccess()) {
      paramDetailFeedItem = this.g.toString();
    } else {
      paramDetailFeedItem = "null";
    }
    SLog.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramDetailFeedItem);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.i.a();
      return;
    }
    this.i.b();
  }
  
  public void b()
  {
    SLog.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.j == null)
    {
      if (!this.g.e())
      {
        SLog.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.j = new VideoListPageLoader(2, this.g.f().getVideoInfo());
      this.j.b("StoryDetailPresenter");
    }
    this.j.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = j();
    CommentEntry localCommentEntry = (CommentEntry)this.g.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!NetworkUtil.isNetSupport(this.e.getBaseActivity()))
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131911732), 0).show();
      SLog.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    FeedCommentDataProvider.a(localCommentEntry, new StoryDetailPresenter.3(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    FeedCommentLego.a(this.g.a, paramCommentEntry, false, this.c, new StoryDetailPresenter.2(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.e.b == null) {
      return;
    }
    Object localObject = this.g;
    if ((localObject != null) && (((DetailFeedItem)localObject).a != null))
    {
      if (this.g.a.getOwner().isMe()) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      StoryReportor.a("home_page", "press_reply", 0, 0, new String[] { localObject, StoryReportor.b(this.c) });
    }
    this.e.b.b(paramCommentEntry, paramInt, h());
  }
  
  public void b(boolean paramBoolean)
  {
    this.e.c();
    StoryDetailFragment localStoryDetailFragment = this.e;
    localStoryDetailFragment.a(paramBoolean, localStoryDetailFragment.c(this.g, j()));
  }
  
  public void bo_()
  {
    SLog.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.h);
    if (j()) {
      this.m.c();
    } else {
      this.n.c();
    }
    StoryReportor.a("home_page", "load_detail", 0, 0, new String[] { "", StoryReportor.b(this.c), "", this.b });
  }
  
  public void bp_()
  {
    SLog.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    boolean bool2 = NetworkUtil.isNetSupport(this.e.getBaseActivity());
    boolean bool1 = true;
    if (!bool2)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131911729), 0).show();
      return;
    }
    if (((this.g.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.g.a.getOwner()).isPublic()) && (!this.g.a.getOwner().isSubscribe()))
    {
      QQToast.makeText(BaseApplication.getContext(), 1, StoryApi.b(2131897963), 0).show();
      return;
    }
    if (this.g.a.mHadLike != 0) {
      bool1 = false;
    }
    bool2 = j();
    FeedLikeDataProvider.a(this.g.a, bool1, -1, 0);
    a(bool1, bool2);
    this.e.c();
    a(3, null);
    a("clk_like");
  }
  
  public void bq_()
  {
    this.e.e();
  }
  
  public void c()
  {
    LoadingMoreHelper localLoadingMoreHelper = this.e.a.c("StoryDetailFragment");
    if (localLoadingMoreHelper != null) {
      localLoadingMoreHelper.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      SLog.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    SLog.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.h = paramInt;
  }
  
  public void d()
  {
    LoadingMoreHelper localLoadingMoreHelper = this.e.a.c("StoryDetailFragment");
    if (localLoadingMoreHelper != null)
    {
      if (this.g.b(j()))
      {
        localLoadingMoreHelper.a(false);
        return;
      }
      localLoadingMoreHelper.a(true);
    }
  }
  
  public void e()
  {
    this.o = new StoryDetailPresenter.FeedVideoListReceiver(this);
    StoryDispatcher.a().registerSubscriber("StoryDetailPresenter", this.o);
    this.p = new StoryDetailPresenter.LikeListReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.p);
    this.q = new StoryDetailPresenter.CommentListReceiver(this);
    StoryDispatcher.a().registerSubscriber("StoryDetailPresenter", this.q);
    this.r = new StoryDetailPresenter.FeedInfoUpdateReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.r);
    this.s = new StoryDetailPresenter.UploadStatusReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.s);
    this.t = new StoryDetailPresenter.VideoDeleteReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.t);
    this.u = new StoryDetailPresenter.VideoNoInterestingReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.u);
    this.v = new StoryDetailPresenter.GetFeedFeatureReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.v);
    this.w = new StoryDetailPresenter.FeedVideoCookieUpdate(this);
    StoryDispatcher.a().registerSubscriber(this.w);
    this.x = new StoryDetailPresenter.GetUserInfoReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.x);
    this.y = new StoryDetailPresenter.TroopNickNameUpdateEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.y);
    this.z = new StoryDetailPresenter.GetTagInfoListReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.z);
    QQStoryContext.a();
    QQStoryContext.j().addObserver(this.a);
    this.i = new DetailFeedAllInfoPuller(this.b, this, true);
    this.A = ((FeedManager)SuperManager.a(11));
    this.B = ((LikeManager)SuperManager.a(15));
    this.C = ((CommentManager)SuperManager.a(17));
    this.D = ((FeedVideoManager)SuperManager.a(12));
  }
  
  public void f()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.o);
    StoryDispatcher.a().unRegisterSubscriber(this.p);
    StoryDispatcher.a().unRegisterSubscriber(this.q);
    StoryDispatcher.a().unRegisterSubscriber(this.r);
    StoryDispatcher.a().unRegisterSubscriber(this.s);
    StoryDispatcher.a().unRegisterSubscriber(this.t);
    StoryDispatcher.a().unRegisterSubscriber(this.u);
    StoryDispatcher.a().unRegisterSubscriber(this.v);
    StoryDispatcher.a().unRegisterSubscriber(this.w);
    StoryDispatcher.a().unRegisterSubscriber(this.x);
    StoryDispatcher.a().unRegisterSubscriber(this.y);
    StoryDispatcher.a().unRegisterSubscriber(this.z);
    QQStoryContext.a();
    QQStoryContext.j().removeObserver(this.a);
    this.f.set(true);
    this.k = null;
    this.l = null;
    Object localObject = this.i;
    if (localObject != null) {
      ((DetailFeedAllInfoPuller)localObject).c();
    }
    localObject = this.j;
    if (localObject != null) {
      ((VideoListPageLoader)localObject).d();
    }
    localObject = this.m;
    if (localObject != null) {
      ((CommentListPageLoader)localObject).d();
    }
    localObject = this.n;
    if (localObject != null) {
      ((CommentListPageLoader)localObject).d();
    }
  }
  
  public void g()
  {
    this.e.b.a();
  }
  
  public int h()
  {
    return this.h;
  }
  
  public void h_(int paramInt)
  {
    SLog.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.h = paramInt;
    this.e.b(this.g, j());
    if (j()) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    StoryReportor.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", StoryReportor.b(this.c), this.g.a.feedId });
  }
  
  public void i()
  {
    if (!TextUtils.isEmpty(this.b)) {
      GetFeedFeatureHandler.a(Collections.singletonList(this.b));
    }
  }
  
  public boolean isValidate()
  {
    return this.f.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter
 * JD-Core Version:    0.7.0.1
 */