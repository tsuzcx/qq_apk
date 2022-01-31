package com.tencent.biz.qqstory.storyHome.detail.model;

import android.content.Context;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.lang.ref.WeakReference;

public class SpannableStringUtils$DefaultClickNickCallback
  implements SpannableStringUtils.ClickNickCallback
{
  private int jdField_a_of_type_Int;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public SpannableStringUtils$DefaultClickNickCallback(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(String paramString, int paramInt)
  {
    SLog.a("Q.qqstory.detail.SpannableStringUtils", "on nick click. unionId = %s.", paramString);
    if ((paramInt == 1002) || (paramInt == 1003) || (paramInt == 1001)) {}
    Object localObject;
    do
    {
      return;
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        StoryApi.a((Context)localObject, 12, paramString);
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null);
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = "clk_reply_nick";
      paramString = "2";
      if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem instanceof VideoListFeedItem)) {
        break label164;
      }
      paramString = (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      paramInt = StoryReportor.a(paramString);
      if (!paramString.getOwner().isMe()) {
        break label158;
      }
      paramString = "1";
    }
    for (;;)
    {
      StoryReportor.a("home_page", (String)localObject, paramInt, 0, new String[] { paramString, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      localObject = "clk_like_name";
      break;
      label158:
      paramString = "2";
      continue;
      label164:
      paramInt = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils.DefaultClickNickCallback
 * JD-Core Version:    0.7.0.1
 */