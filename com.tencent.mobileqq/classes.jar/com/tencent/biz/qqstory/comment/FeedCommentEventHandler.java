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
  protected Handler a;
  private FeedCommentEventHandler.FeedCommentClickEvent a;
  protected FeedCommentLego a;
  public CommentLikeFeedItem a;
  public String a;
  
  public FeedCommentEventHandler(FeedCommentLego paramFeedCommentLego)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego = paramFeedCommentLego;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent = new FeedCommentEventHandler.FeedCommentClickEvent(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$KeyBoardUpCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$KeyBoardUpCallback.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_Int, paramCommentEntry);
    }
    FeedCommentLikeLego localFeedCommentLikeLego = (FeedCommentLikeLego)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a();
    paramInt = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      StoryReportor.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, StoryReportor.a(localFeedCommentLikeLego.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localActionSheet.addButton(HardCodeUtil.a(2131704451));
        localActionSheet.addButton(HardCodeUtil.a(2131704419), 3);
      }
    }
    for (;;)
    {
      localActionSheet.addCancelButton(HardCodeUtil.a(2131704424));
      localActionSheet.setOnButtonClickListener(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, localActionSheet, paramCommentEntry, paramInt));
      localActionSheet.show();
      return;
      localActionSheet.addButton(HardCodeUtil.a(2131704439));
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localActionSheet.addButton(HardCodeUtil.a(2131704449), 3);
        }
        localActionSheet.addButton(HardCodeUtil.a(2131704448));
        localActionSheet.addButton(HardCodeUtil.a(2131704446));
      }
      else
      {
        localActionSheet.addButton(HardCodeUtil.a(2131704420));
        localActionSheet.addButton(HardCodeUtil.a(2131704438));
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      StoryPlayerLauncher.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      StoryReportor.a("play_video", "multishoot_icon", 0, 0, new String[0]);
    }
    Object localObject;
    do
    {
      return;
      if (paramCommentEntry.commentType != 4) {
        break;
      }
      localObject = paramCommentEntry.getExtraJson().optString("vid");
      paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramCommentEntry)));
    StoryPlayerLauncher.b(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
    return;
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      localObject = ActionSheet.create(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131704453));
      }
      for (;;)
      {
        ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131704456), 3);
        ((ActionSheet)localObject).addCancelButton(HardCodeUtil.a(2131704434));
        ((ActionSheet)localObject).setOnButtonClickListener(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, (ActionSheet)localObject, paramCommentEntry, paramInt));
        ((ActionSheet)localObject).show();
        return;
        ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131704440));
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      StoryReportor.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_Int = paramInt;
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704428), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_Int = paramInt;
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_JavaUtilList.get(i);
      ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity);
      localActionSheet.addButton(HardCodeUtil.a(2131704431));
      localActionSheet.addButton(HardCodeUtil.a(2131704417), 3);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, localActionSheet, localCommentEntry, i));
      localActionSheet.show();
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a().a();
      if (QLog.isColorLevel()) {
        QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentEventHandler
 * JD-Core Version:    0.7.0.1
 */