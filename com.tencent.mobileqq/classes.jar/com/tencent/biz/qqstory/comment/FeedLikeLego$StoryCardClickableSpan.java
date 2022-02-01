package com.tencent.biz.qqstory.comment;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.lang.ref.WeakReference;

class FeedLikeLego$StoryCardClickableSpan
  extends ClickableSpan
{
  public LikeEntry a;
  public WeakReference<FeedLikeLego> a;
  
  public void onClick(View paramView)
  {
    paramView = (FeedLikeLego)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramView == null) {
      return;
    }
    StoryApi.a(paramView.jdField_a_of_type_AndroidAppActivity, 12, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry.unionId);
    paramView = paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.ownerId;
    if (QQStoryContext.a().a(paramView)) {}
    for (paramView = "2";; paramView = "1")
    {
      StoryReportor.a("play_video", "clk_like_name", 0, 0, new String[] { paramView, "", "", "" });
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.getColor());
    paramTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego.StoryCardClickableSpan
 * JD-Core Version:    0.7.0.1
 */