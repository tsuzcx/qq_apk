package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.content.Context;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;

public class DetailShareGroupCommentEventProxy
  implements IDetailCommentEventProxy
{
  private Context a;
  private int b;
  private CommentLikeFeedItem c;
  private DetailGeneralCommentEventProxy.ActionSheetEventCallback d;
  
  public DetailShareGroupCommentEventProxy(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, DetailGeneralCommentEventProxy.ActionSheetEventCallback paramActionSheetEventCallback)
  {
    this.a = paramContext;
    this.b = paramInt;
    this.c = paramCommentLikeFeedItem;
    this.d = paramActionSheetEventCallback;
    if ((paramCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      return;
    }
    throw new IllegalStateException("initial comment event proxy while owner is not share group item.");
  }
  
  public boolean a()
  {
    SLog.c("Q.qqstory.detail.DetailShareGroupCommentEventProxy", "on comment button click.");
    if (!NetworkUtil.isNetSupport(this.a))
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131901278), 0).show();
      return false;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.c.getOwner();
    if ((!localShareGroupItem.isPublic()) && (!localShareGroupItem.isSubscribe()))
    {
      QQToast.makeText(BaseApplication.getContext(), 1, StoryApi.b(2131897962), 0).show();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(this.a)) {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131901279), 0).show();
    }
    for (;;)
    {
      bool = false;
      break label175;
      if (QQStoryContext.a().b(paramCommentEntry.authorUnionId))
      {
        ActionSheet localActionSheet = ActionSheet.create(this.a);
        if (paramCommentEntry.status == 2) {
          localActionSheet.addButton(DetailGeneralCommentEventProxy.d);
        } else {
          localActionSheet.addButton(DetailGeneralCommentEventProxy.e);
        }
        localActionSheet.addButton(DetailGeneralCommentEventProxy.a, 3);
        localActionSheet.addCancelButton(DetailGeneralCommentEventProxy.f);
        localActionSheet.setOnButtonClickListener(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener(localActionSheet, paramCommentEntry, paramInt1, this.d));
        localActionSheet.show();
      }
      else
      {
        paramCommentEntry = (ShareGroupItem)this.c.getOwner();
        if ((paramCommentEntry.isPublic()) || (paramCommentEntry.isSubscribe())) {
          break;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, StoryApi.b(2131897962), 0).show();
      }
    }
    boolean bool = true;
    label175:
    paramInt1 = StoryReportor.a(this.c);
    if (this.c.getOwner().isMe()) {
      paramCommentEntry = "1";
    } else {
      paramCommentEntry = "2";
    }
    StoryReportor.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, StoryReportor.b(this.b), "", this.c.feedId });
    return bool;
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.c.getOwner();
    ActionSheet localActionSheet = ActionSheet.create(this.a);
    if (QQStoryContext.a().b(paramCommentEntry.authorUnionId))
    {
      if (paramCommentEntry.status == 2) {
        localActionSheet.addButton(DetailGeneralCommentEventProxy.d);
      } else {
        localActionSheet.addButton(DetailGeneralCommentEventProxy.e);
      }
      localActionSheet.addButton(DetailGeneralCommentEventProxy.a, 3);
    }
    else if ((localShareGroupItem.isPublic()) && (localShareGroupItem.isOwner()))
    {
      localActionSheet.addButton(DetailGeneralCommentEventProxy.c);
      localActionSheet.addButton(DetailGeneralCommentEventProxy.a, 3);
      localActionSheet.addButton(DetailGeneralCommentEventProxy.e);
    }
    else
    {
      localActionSheet.addButton(DetailGeneralCommentEventProxy.c);
      localActionSheet.addButton(DetailGeneralCommentEventProxy.e);
    }
    localActionSheet.addCancelButton(DetailGeneralCommentEventProxy.f);
    localActionSheet.setOnButtonClickListener(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener(localActionSheet, paramCommentEntry, paramInt1, this.d));
    localActionSheet.show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailShareGroupCommentEventProxy
 * JD-Core Version:    0.7.0.1
 */