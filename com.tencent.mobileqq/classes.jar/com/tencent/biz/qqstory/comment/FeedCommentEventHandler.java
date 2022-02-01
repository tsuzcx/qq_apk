package com.tencent.biz.qqstory.comment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.lego.LegoDataProvider;
import com.tencent.biz.qqstory.comment.lego.LegoEvenHandler;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.biz.qqstory.view.widget.InnerListView.OnItemClickListener;
import com.tencent.biz.qqstory.view.widget.InnerListView.OnItemLongClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.List;
import org.json.JSONObject;

public class FeedCommentEventHandler
  extends LegoEvenHandler
  implements View.OnClickListener, InnerListView.OnItemClickListener, InnerListView.OnItemLongClickListener
{
  protected FeedCommentLego a;
  protected Handler b = new Handler();
  public String c;
  public CommentLikeFeedItem d;
  private FeedCommentEventHandler.FeedCommentClickEvent e;
  
  public FeedCommentEventHandler(FeedCommentLego paramFeedCommentLego)
  {
    this.a = paramFeedCommentLego;
    this.c = QQStoryContext.a().g();
    this.d = this.a.g;
    this.e = new FeedCommentEventHandler.FeedCommentClickEvent(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.a.l != null) {
      this.a.l.a(this.a, this.e.a, this.e.b, this.e.c, paramCommentEntry);
    }
    FeedCommentLikeLego localFeedCommentLikeLego = (FeedCommentLikeLego)this.a.m();
    paramInt = StoryReportor.a(this.d);
    if (this.d.getOwner().isMe()) {
      paramCommentEntry = "1";
    } else {
      paramCommentEntry = "2";
    }
    StoryReportor.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, StoryReportor.b(localFeedCommentLikeLego.e), "", this.d.feedId });
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().i();
    ActionSheet localActionSheet = ActionSheet.create(this.a.c);
    if (paramCommentEntry.authorUnionId.equals(paramView))
    {
      if (paramCommentEntry.status == 2) {
        localActionSheet.addButton(HardCodeUtil.a(2131902451));
      } else {
        localActionSheet.addButton(HardCodeUtil.a(2131902439));
      }
      localActionSheet.addButton(HardCodeUtil.a(2131902421), 3);
    }
    else if (this.d.getOwner().isMe())
    {
      if (this.d.getOwner().isVip()) {
        localActionSheet.addButton(HardCodeUtil.a(2131902449), 3);
      }
      localActionSheet.addButton(HardCodeUtil.a(2131902448));
      localActionSheet.addButton(HardCodeUtil.a(2131902446));
    }
    else
    {
      localActionSheet.addButton(HardCodeUtil.a(2131902422));
      localActionSheet.addButton(HardCodeUtil.a(2131902438));
    }
    localActionSheet.addCancelButton(HardCodeUtil.a(2131898212));
    localActionSheet.setOnButtonClickListener(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, localActionSheet, paramCommentEntry, paramInt));
    localActionSheet.show();
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      StoryPlayerLauncher.a(this.a.c, paramCommentEntry.f(), null);
      StoryReportor.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      return;
    }
    Object localObject;
    if (paramCommentEntry.commentType == 4)
    {
      localObject = paramCommentEntry.getExtraJson().optString("vid");
      paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
        StoryPlayerLauncher.b(this.a.p, (String)localObject, paramCommentEntry, 74);
      }
    }
    else
    {
      if (QQStoryContext.a().b(paramCommentEntry.authorUnionId))
      {
        localObject = ActionSheet.create(this.a.c);
        if (paramCommentEntry.status == 2) {
          ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131902453));
        } else {
          ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131902440));
        }
        ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131902456), 3);
        ((ActionSheet)localObject).addCancelButton(HardCodeUtil.a(2131898212));
        ((ActionSheet)localObject).setOnButtonClickListener(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, (ActionSheet)localObject, paramCommentEntry, paramInt));
        ((ActionSheet)localObject).show();
        return;
      }
      b(paramCommentEntry, paramInt);
      paramInt = StoryReportor.a(this.d);
      if (this.d.getOwner().isMe()) {
        paramCommentEntry = "1";
      } else {
        paramCommentEntry = "2";
      }
      StoryReportor.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, StoryReportor.b(this.a.h), "", this.d.feedId });
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.d = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.a.d.get(paramInt);
    FeedCommentEventHandler.FeedCommentClickEvent localFeedCommentClickEvent = this.e;
    localFeedCommentClickEvent.a = paramInnerListView;
    localFeedCommentClickEvent.b = paramView;
    localFeedCommentClickEvent.c = paramInt;
    if (!NetworkUtil.isNetSupport(this.a.p))
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131902429), 0).show();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean b(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.a.d.get(paramInt), paramInt);
    FeedCommentEventHandler.FeedCommentClickEvent localFeedCommentClickEvent = this.e;
    localFeedCommentClickEvent.a = paramInnerListView;
    localFeedCommentClickEvent.b = paramView;
    localFeedCommentClickEvent.c = paramInt;
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131431079)
    {
      if ((i != 2131432617) && (i == 2131444737))
      {
        this.a.b().a();
        if (QLog.isColorLevel()) {
          QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
        }
      }
    }
    else
    {
      i = ((Integer)paramView.getTag()).intValue();
      CommentEntry localCommentEntry = (CommentEntry)this.a.d.get(i);
      ActionSheet localActionSheet = ActionSheet.create(this.a.c);
      localActionSheet.addButton(HardCodeUtil.a(2131902432));
      localActionSheet.addButton(HardCodeUtil.a(2131902419), 3);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, localActionSheet, localCommentEntry, i));
      localActionSheet.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentEventHandler
 * JD-Core Version:    0.7.0.1
 */