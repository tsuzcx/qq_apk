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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
      paramCommentEntry = "1";
    } else {
      paramCommentEntry = "2";
    }
    StoryReportor.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, StoryReportor.a(localFeedCommentLikeLego.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView))
    {
      if (paramCommentEntry.status == 2) {
        localActionSheet.addButton(HardCodeUtil.a(2131704541));
      } else {
        localActionSheet.addButton(HardCodeUtil.a(2131704529));
      }
      localActionSheet.addButton(HardCodeUtil.a(2131704509), 3);
    }
    else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
        localActionSheet.addButton(HardCodeUtil.a(2131704539), 3);
      }
      localActionSheet.addButton(HardCodeUtil.a(2131704538));
      localActionSheet.addButton(HardCodeUtil.a(2131704536));
    }
    else
    {
      localActionSheet.addButton(HardCodeUtil.a(2131704510));
      localActionSheet.addButton(HardCodeUtil.a(2131704528));
    }
    localActionSheet.addCancelButton(HardCodeUtil.a(2131704514));
    localActionSheet.setOnButtonClickListener(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, localActionSheet, paramCommentEntry, paramInt));
    localActionSheet.show();
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      StoryPlayerLauncher.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity, paramCommentEntry.a(), null);
      StoryReportor.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      return;
    }
    Object localObject;
    if (paramCommentEntry.commentType == 4)
    {
      localObject = paramCommentEntry.getExtraJson().optString("vid");
      paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
        StoryPlayerLauncher.b(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
      }
    }
    else
    {
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = ActionSheet.create(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity);
        if (paramCommentEntry.status == 2) {
          ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131704543));
        } else {
          ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131704530));
        }
        ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131704546), 3);
        ((ActionSheet)localObject).addCancelButton(HardCodeUtil.a(2131704524));
        ((ActionSheet)localObject).setOnButtonClickListener(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, (ActionSheet)localObject, paramCommentEntry, paramInt));
        ((ActionSheet)localObject).show();
        return;
      }
      b(paramCommentEntry, paramInt);
      paramInt = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        paramCommentEntry = "1";
      } else {
        paramCommentEntry = "2";
      }
      StoryReportor.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_JavaUtilList.get(paramInt);
    FeedCommentEventHandler.FeedCommentClickEvent localFeedCommentClickEvent = this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent;
    localFeedCommentClickEvent.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    localFeedCommentClickEvent.jdField_a_of_type_AndroidViewView = paramView;
    localFeedCommentClickEvent.jdField_a_of_type_Int = paramInt;
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704518), 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    FeedCommentEventHandler.FeedCommentClickEvent localFeedCommentClickEvent = this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent;
    localFeedCommentClickEvent.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    localFeedCommentClickEvent.jdField_a_of_type_AndroidViewView = paramView;
    localFeedCommentClickEvent.jdField_a_of_type_Int = paramInt;
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364953)
    {
      if ((i != 2131366317) && (i == 2131376496))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a().a();
        if (QLog.isColorLevel()) {
          QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
        }
      }
    }
    else
    {
      i = ((Integer)paramView.getTag()).intValue();
      CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_JavaUtilList.get(i);
      ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity);
      localActionSheet.addButton(HardCodeUtil.a(2131704521));
      localActionSheet.addButton(HardCodeUtil.a(2131704507), 3);
      localActionSheet.addCancelButton(2131690728);
      localActionSheet.setOnButtonClickListener(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, localActionSheet, localCommentEntry, i));
      localActionSheet.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentEventHandler
 * JD-Core Version:    0.7.0.1
 */