package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqstory.comment.FeedCommentDataProvider;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.CommentHelperCallback;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import mqq.os.MqqHandler;

class CommentFloatDialog$OnCommentHelperCallback
  implements DetailCommentHelper.CommentHelperCallback
{
  private CommentFloatDialog$OnCommentHelperCallback(CommentFloatDialog paramCommentFloatDialog) {}
  
  public void a()
  {
    CommentFloatDialog.i(this.a).q();
  }
  
  public void a(int paramInt)
  {
    CommentFloatDialog.i(this.a).setSelectionFromBottom(CommentFloatDialog.i(this.a).getCommentSegmentIndex() + paramInt, 0);
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    CommentManager localCommentManager = (CommentManager)SuperManager.a(17);
    boolean bool = CommentFloatDialog.g(this.a).e();
    if ((!CommentFloatDialog.b(this.a).b(bool)) && (CommentFloatDialog.b(this.a).h(bool) == null))
    {
      CommentEntry localCommentEntry = DetailCommentHelper.a(CommentFloatDialog.b(this.a).d(bool) - CommentFloatDialog.b(this.a).a(bool).size());
      CommentFloatDialog.b(this.a).c(localCommentEntry, bool);
      CommentFloatDialog.b(this.a).a(localCommentEntry, bool);
    }
    CommentFloatDialog.b(this.a).a(paramCommentEntry, bool);
    SLog.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(CommentFloatDialog.b(this.a).a.mCommentCount), Integer.valueOf(CommentFloatDialog.b(this.a).a.mFanCommentCount), Integer.valueOf(CommentFloatDialog.b(this.a).a.mFriendCommentCount));
    int i;
    if (CommentFloatDialog.b(this.a).a.mDenyComment == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131900368), 0).show();
      paramCommentEntry.status = 2;
    }
    CommentFloatDialog.i(this.a).q();
    ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
    CommentFloatDialog.b(this.a).a = ((CommentLikeFeedItem)localFeedManager.a(CommentFloatDialog.b(this.a).a));
    if (CommentFloatDialog.b(this.a).b())
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
      localCommentManager.a(paramCommentEntry);
    }
    else
    {
      paramCommentEntry.pbType = CommentFloatDialog.b(this.a).a.getCommentLikeType();
      localCommentManager.b(paramCommentEntry);
    }
    if (i == 0) {
      b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = CommentFloatDialog.g(this.a).e();
    Object localObject = CommentFloatDialog.b(this.a).a(bool);
    if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (CommentEntry)CommentFloatDialog.b(this.a).a(bool).get(paramInt);
      if (((CommentEntry)localObject).status != 0)
      {
        CommentFloatDialog.i(this.a).a((CommentEntry)localObject, bool);
        return;
      }
      if (!NetworkUtil.isNetSupport(this.a.getContext()))
      {
        QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131900369), 0).show();
        SLog.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
        return;
      }
      ((CommentEntry)localObject).status = 1;
      FeedCommentDataProvider.a((CommentEntry)localObject, new CommentFloatDialog.OnCommentHelperCallback.2(this, (CommentEntry)localObject, bool));
      return;
    }
    SLog.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    FeedCommentLego.a(CommentFloatDialog.b(this.a).a, paramCommentEntry, CommentFloatDialog.k(this.a), CommentFloatDialog.c(this.a), new CommentFloatDialog.OnCommentHelperCallback.3(this));
  }
  
  public void bq_()
  {
    int i = CommentFloatDialog.i(this.a).getLastCommentPoi();
    CommentFloatDialog.i(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void c()
  {
    Object localObject = CommentFloatDialog.i(this.a).c("CommentFloatDialog");
    if (localObject != null) {
      ((LoadingMoreHelper)localObject).a(false);
    }
    localObject = CommentFloatDialog.i(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131299787));
    } else {
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131299789);
    }
    CommentFloatDialog.i(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void d()
  {
    Object localObject = CommentFloatDialog.i(this.a).c("CommentFloatDialog");
    if (localObject != null) {
      if (CommentFloatDialog.b(this.a) != null) {
        ((LoadingMoreHelper)localObject).a(CommentFloatDialog.b(this.a).b(CommentFloatDialog.g(this.a).e()) ^ true);
      } else {
        ((LoadingMoreHelper)localObject).a(false);
      }
    }
    localObject = CommentFloatDialog.i(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131299787));
    } else {
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131299787);
    }
    CommentFloatDialog.i(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentHelperCallback
 * JD-Core Version:    0.7.0.1
 */