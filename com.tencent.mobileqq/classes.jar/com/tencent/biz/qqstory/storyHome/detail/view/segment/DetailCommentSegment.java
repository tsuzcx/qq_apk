package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.StoryQQTextCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.text.QQText;
import java.util.List;

public class DetailCommentSegment
  extends SegmentView
{
  public static final String KEY = "DetailCommentSegment";
  private DetailEventCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback;
  public DetailFeedItem a;
  private DetailCommentSegment.ClickNickCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$ClickNickCallback = new DetailCommentSegment.ClickNickCallback(1);
  private DetailCommentSegment.CommentTextOnTouchListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$CommentTextOnTouchListener = new DetailCommentSegment.CommentTextOnTouchListener();
  private boolean b;
  
  public DetailCommentSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public void J_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem != null)) {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(this.b).size();
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null) || (paramInt > this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(this.b).size()))
    {
      SLog.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramBaseViewHolder.a();
    }
    Object localObject1 = (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(this.b).get(paramInt);
    if (localObject1 == null)
    {
      SLog.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramBaseViewHolder.a();
    }
    paramViewGroup = (TextView)paramBaseViewHolder.a(2131371686);
    if (((CommentEntry)localObject1).type == 1)
    {
      paramViewGroup.setTextColor(-4473925);
      paramViewGroup.setText(((CommentEntry)localObject1).content);
      return paramBaseViewHolder.a();
    }
    String str = ((CommentEntry)localObject1).commentId + ((CommentEntry)localObject1).feedId + ((CommentEntry)localObject1).status + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$ClickNickCallback.hashCode();
    Object localObject2 = StoryQQTextCacher.a().a(str);
    if (localObject2 != null) {
      paramViewGroup.setText((CharSequence)localObject2);
    }
    for (;;)
    {
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$CommentTextOnTouchListener);
      paramViewGroup.setSpannableFactory(QQText.a);
      paramViewGroup.setTextColor(-16777216);
      break;
      localObject2 = SpannableStringUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a, (CommentEntry)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$ClickNickCallback);
      paramViewGroup.setText((CharSequence)localObject2);
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      QQUserUIItem localQQUserUIItem = localUserManager.b(((CommentEntry)localObject1).authorUnionId);
      if (((CommentEntry)localObject1).isReply())
      {
        localObject1 = localUserManager.b(((CommentEntry)localObject1).replierUnionId);
        if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable()) && (localObject1 != null) && (((QQUserUIItem)localObject1).isAvailable())) {
          StoryQQTextCacher.a().a(str, (CharSequence)localObject2);
        }
      }
      else if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable()))
      {
        StoryQQTextCacher.a().a(str, (CharSequence)localObject2);
      }
    }
  }
  
  public CommentEntry a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem == null) || (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(this.b).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(this.b).get(paramInt);
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970739, paramViewGroup, false));
  }
  
  public String a()
  {
    return "DetailCommentSegment";
  }
  
  public void a(DetailEventCallback paramDetailEventCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailEventCallback = paramDetailEventCallback;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$ClickNickCallback.a(paramDetailEventCallback);
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment
 * JD-Core Version:    0.7.0.1
 */