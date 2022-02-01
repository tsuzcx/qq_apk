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
  
  public void N_()
  {
    int i = CommentFloatDialog.a(this.a).b();
    CommentFloatDialog.a(this.a).setSelectionFromBottom(i, 0);
  }
  
  public void a()
  {
    CommentFloatDialog.a(this.a).p();
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    FeedManager localFeedManager = (FeedManager)SuperManager.a(11);
    CommentManager localCommentManager = (CommentManager)SuperManager.a(17);
    boolean bool = CommentFloatDialog.a(this.a).a();
    if ((!CommentFloatDialog.a(this.a).a(bool)) && (CommentFloatDialog.a(this.a).a(bool) == null))
    {
      CommentEntry localCommentEntry = DetailCommentHelper.a(CommentFloatDialog.a(this.a).a(bool) - CommentFloatDialog.a(this.a).a(bool).size());
      CommentFloatDialog.a(this.a).c(localCommentEntry, bool);
      CommentFloatDialog.a(this.a).a(localCommentEntry, bool);
    }
    CommentFloatDialog.a(this.a).a(paramCommentEntry, bool);
    SLog.b("Q.qqstory.player.CommentFloatDialog", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(CommentFloatDialog.a(this.a).a.mCommentCount), Integer.valueOf(CommentFloatDialog.a(this.a).a.mFanCommentCount), Integer.valueOf(CommentFloatDialog.a(this.a).a.mFriendCommentCount));
    int i;
    if (CommentFloatDialog.a(this.a).a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131702230), 0).a();
        paramCommentEntry.status = 2;
      }
      CommentFloatDialog.a(this.a).p();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.OnCommentHelperCallback.1(this), 50L);
      CommentFloatDialog.a(this.a).a = ((CommentLikeFeedItem)localFeedManager.a(CommentFloatDialog.a(this.a).a));
      if (!CommentFloatDialog.a(this.a).a()) {
        break label347;
      }
      if (!bool) {
        break label334;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label313:
      localCommentManager.a(paramCommentEntry);
    }
    for (;;)
    {
      if (i == 0) {
        b(paramCommentEntry);
      }
      return;
      i = 0;
      break;
      label334:
      paramCommentEntry.type = 3;
      paramCommentEntry.pbType = 0;
      break label313;
      label347:
      paramCommentEntry.pbType = CommentFloatDialog.a(this.a).a.getCommentLikeType();
      localCommentManager.b(paramCommentEntry);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool = CommentFloatDialog.a(this.a).a();
    Object localObject = CommentFloatDialog.a(this.a).a(bool);
    if ((paramInt < 0) || (paramInt >= ((List)localObject).size()))
    {
      SLog.d("Q.qqstory.player.CommentFloatDialog", "delete comment error , IndexOutOfBoundsException , need index = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((List)localObject).size()) });
      return;
    }
    localObject = (CommentEntry)CommentFloatDialog.a(this.a).a(bool).get(paramInt);
    if (((CommentEntry)localObject).status != 0)
    {
      CommentFloatDialog.a(this.a).a((CommentEntry)localObject, bool);
      return;
    }
    if (!NetworkUtil.d(this.a.getContext()))
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131702231), 0).a();
      SLog.d("Q.qqstory.player.CommentFloatDialog", "delete comment failed. invalidate network.");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    FeedCommentDataProvider.a((CommentEntry)localObject, new CommentFloatDialog.OnCommentHelperCallback.2(this, (CommentEntry)localObject, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    FeedCommentLego.a(CommentFloatDialog.a(this.a).a, paramCommentEntry, CommentFloatDialog.c(this.a), CommentFloatDialog.a(this.a), new CommentFloatDialog.OnCommentHelperCallback.3(this));
  }
  
  public void c()
  {
    Object localObject = CommentFloatDialog.a(this.a).a("CommentFloatDialog");
    if (localObject != null) {
      ((LoadingMoreHelper)localObject).a(false);
    }
    localObject = CommentFloatDialog.a(this.a).getLayoutParams();
    if (localObject == null) {
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131299054));
    }
    for (;;)
    {
      CommentFloatDialog.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131299056);
    }
  }
  
  public void d()
  {
    boolean bool = false;
    Object localObject = CommentFloatDialog.a(this.a).a("CommentFloatDialog");
    if (localObject != null)
    {
      if (CommentFloatDialog.a(this.a) != null)
      {
        if (!CommentFloatDialog.a(this.a).a(CommentFloatDialog.a(this.a).a())) {
          bool = true;
        }
        ((LoadingMoreHelper)localObject).a(bool);
      }
    }
    else
    {
      localObject = CommentFloatDialog.a(this.a).getLayoutParams();
      if (localObject != null) {
        break label119;
      }
      localObject = new ViewGroup.LayoutParams(-1, this.a.getContext().getResources().getDimensionPixelOffset(2131299054));
    }
    for (;;)
    {
      CommentFloatDialog.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((LoadingMoreHelper)localObject).a(false);
      break;
      label119:
      ((ViewGroup.LayoutParams)localObject).height = this.a.getContext().getResources().getDimensionPixelOffset(2131299054);
    }
  }
  
  public void h_(int paramInt)
  {
    CommentFloatDialog.a(this.a).setSelectionFromBottom(CommentFloatDialog.a(this.a).a() + paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentHelperCallback
 * JD-Core Version:    0.7.0.1
 */