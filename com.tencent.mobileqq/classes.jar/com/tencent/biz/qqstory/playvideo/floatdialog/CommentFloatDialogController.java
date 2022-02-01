package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.DetailFeedPushObserver;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.lang.ref.WeakReference;

public class CommentFloatDialogController
  implements IEventReceiver
{
  public CharSequence a;
  private CommentManager b = (CommentManager)SuperManager.a(17);
  private FeedManager c = (FeedManager)SuperManager.a(11);
  private Stream<DetailFeedItem> d;
  private CommentListPageLoader e;
  private CommentListPageLoader f;
  private boolean g = false;
  private CommentFloatDialogController.CommentListReceiver h;
  private CommentFloatDialogController.GetUserInfoReceiver i;
  private CommentFloatDialogController.FeedInfoUpdateReceiver j;
  private StoryDetailPresenter.DetailFeedPushObserver k;
  private String l;
  private int m = -1;
  private DetailFeedItem n = new DetailFeedItem();
  private WeakReference<CommentFloatDialogController.OnDataChangeListener> o;
  
  private void a(DetailFeedItem paramDetailFeedItem)
  {
    if (paramDetailFeedItem == null) {
      return;
    }
    if (paramDetailFeedItem.b())
    {
      if (paramDetailFeedItem.c())
      {
        if (this.m == -1) {
          this.m = 1;
        }
      }
      else {
        this.m = 1;
      }
    }
    else if (this.m != -1) {
      this.m = -1;
    }
  }
  
  private void a(@NonNull DetailFeedItem paramDetailFeedItem, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    if (paramErrorMessage.isSuccess()) {
      localObject = "suc";
    } else {
      localObject = "fail";
    }
    String str;
    if (paramBoolean) {
      str = "updated";
    } else {
      str = "not updated";
    }
    SLog.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramDetailFeedItem });
    if (paramErrorMessage.isSuccess())
    {
      this.n = paramDetailFeedItem;
      a(paramDetailFeedItem);
      g();
      i();
      if (paramBoolean)
      {
        this.f.a(null, 0);
        this.e.a(null, 0);
      }
    }
    Object localObject = c();
    if (localObject != null) {
      ((CommentFloatDialogController.OnDataChangeListener)localObject).a(paramDetailFeedItem, paramErrorMessage, paramBoolean);
    }
  }
  
  private void h()
  {
    SLog.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.g = true;
    this.l = null;
    this.n = new DetailFeedItem();
    this.h = new CommentFloatDialogController.CommentListReceiver(this);
    StoryDispatcher.a().registerSubscriber("CommentFloatDialogController", this.h);
    this.i = new CommentFloatDialogController.GetUserInfoReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.i);
    this.j = new CommentFloatDialogController.FeedInfoUpdateReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.j);
  }
  
  private void i()
  {
    StoryDetailPresenter.DetailFeedPushObserver localDetailFeedPushObserver = this.k;
    if (localDetailFeedPushObserver == null)
    {
      this.k = new StoryDetailPresenter.DetailFeedPushObserver(this.l, new CommentFloatDialogController.1(this));
      QQStoryContext.a();
      QQStoryContext.j().addObserver(this.k);
      return;
    }
    localDetailFeedPushObserver.a = this.l;
  }
  
  public void a()
  {
    SLog.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.g = false;
    this.l = null;
    this.n = new DetailFeedItem();
    if (this.h != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.h);
    }
    if (this.i != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.i);
    }
    if (this.j != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.j);
    }
    if (this.k != null)
    {
      QQStoryContext.a();
      QQStoryContext.j().removeObserver(this.k);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.m != paramInt)
    {
      this.m = paramInt;
      a(this.n, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.n.b(paramCommentEntry, paramBoolean);
    DetailFeedItem localDetailFeedItem = this.n;
    localDetailFeedItem.a = ((CommentLikeFeedItem)this.c.a(localDetailFeedItem.a));
    this.b.d(paramCommentEntry);
    a(this.n);
  }
  
  public void a(CommentFloatDialogController.OnDataChangeListener paramOnDataChangeListener)
  {
    this.o = new WeakReference(paramOnDataChangeListener);
  }
  
  public void a(@NonNull String paramString)
  {
    if (!this.g) {
      h();
    }
    if (!TextUtils.equals(this.l, paramString))
    {
      this.a = null;
      Stream localStream = this.d;
      if (localStream != null) {
        localStream.cancel();
      }
      this.n = new DetailFeedItem();
      g();
    }
    this.l = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.f.c();
    } else {
      this.e.c();
    }
    StoryReportor.a("home_page", "load_detail", 0, 0, new String[] { "", StoryReportor.b(4444), "", this.l });
  }
  
  public void b()
  {
    Stream localStream = this.d;
    if (localStream != null) {
      localStream.cancel();
    }
    this.d = Stream.of(this.l).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new CommentFloatDialogController.GetFeedItemSegment(this)).map(new CommentFloatDialogController.GetCachedCommentListSegment(this)).map(new UIThreadOffFunction(null));
    this.d.subscribe(new CommentFloatDialogController.GetDetailFeedItemObserver(this));
    SLog.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.l });
  }
  
  @Nullable
  public CommentFloatDialogController.OnDataChangeListener c()
  {
    WeakReference localWeakReference = this.o;
    if (localWeakReference != null) {
      return (CommentFloatDialogController.OnDataChangeListener)localWeakReference.get();
    }
    return null;
  }
  
  public int d()
  {
    return this.m;
  }
  
  public boolean e()
  {
    int i1 = this.m;
    return (i1 == -1) || (i1 == 2);
  }
  
  public DetailFeedItem f()
  {
    return this.n;
  }
  
  public void g()
  {
    SLog.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.l);
    if (!this.n.b())
    {
      this.f = new CommentListPageLoader(new FeedCommentSync(this.l, 2, this.n.c(true)), "CommentFloatDialogController");
      this.e = new CommentListPageLoader(new FeedCommentSync(this.l, 2, this.n.c(false), 0), "CommentFloatDialogController");
      return;
    }
    this.e = new CommentListPageLoader(new FeedCommentSync(this.l, 2, this.n.c(false), 1), "CommentFloatDialogController");
    this.f = new CommentListPageLoader(new FeedCommentSync(this.l, 2, this.n.c(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController
 * JD-Core Version:    0.7.0.1
 */