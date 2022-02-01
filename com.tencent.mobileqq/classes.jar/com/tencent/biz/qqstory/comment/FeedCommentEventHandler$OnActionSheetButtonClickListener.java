package com.tencent.biz.qqstory.comment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class FeedCommentEventHandler$OnActionSheetButtonClickListener
  implements ActionSheet.OnButtonClickListener
{
  private final int jdField_a_of_type_Int;
  private final CommentEntry jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry;
  private final ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  public FeedCommentEventHandler$OnActionSheetButtonClickListener(FeedCommentEventHandler paramFeedCommentEventHandler, ActionSheet paramActionSheet, CommentEntry paramCommentEntry, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry = paramCommentEntry;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCommentItemClick.ActionSheet click: which=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", text = ");
      ((StringBuilder)localObject).append(paramView);
      QLog.d("FeedCommentEventHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (HardCodeUtil.a(2131704544).equals(paramView))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a(this.jdField_a_of_type_Int);
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((paramView != null) && (paramView.isVip())) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUin.equals(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_JavaLangString)) {
        paramView = "2";
      } else {
        paramView = "1";
      }
      StoryReportor.a("play_video", "del_reply", paramInt, 0, new String[] { paramView, "", "", this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
    }
    else if (HardCodeUtil.a(2131704533).equals(paramView))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedCommentEventHandler.OnActionSheetButtonClickListener.1(this), 500L);
    }
    else if (HardCodeUtil.a(2131704525).equals(paramView))
    {
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      StoryReportor.a("play_video", "report_reply", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { "", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
    }
    else if (HardCodeUtil.a(2131704548).equals(paramView))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.e();
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.pbType = this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
      StoryQQTextCacher.a().jdField_a_of_type_JavaLangString = "";
      FeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, false, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_Int, new FeedCommentEventHandler.OnActionSheetButtonClickListener.2(this));
    }
    else if (HardCodeUtil.a(2131704520).equals(paramView))
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.content;
        paramView = (View)localObject;
        if (TextUtils.hasSysEmotion((String)localObject)) {
          paramView = EmotionCodecUtils.b((String)localObject);
        }
        localObject = (ClipboardManager)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard");
        paramView = ClipData.newPlainText("comment content", paramView);
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject, paramView);
        ((ClipboardManager)localObject).setPrimaryClip(paramView);
      }
      catch (Exception paramView)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FeedCommentEventHandler", 2, paramView.toString());
        }
        return;
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentEventHandler.OnActionSheetButtonClickListener
 * JD-Core Version:    0.7.0.1
 */