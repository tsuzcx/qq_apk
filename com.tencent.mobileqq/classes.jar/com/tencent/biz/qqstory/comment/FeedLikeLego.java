package com.tencent.biz.qqstory.comment;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.lego.LegoBase;
import com.tencent.biz.qqstory.comment.lego.LegoDataProvider;
import com.tencent.biz.qqstory.comment.lego.LegoEvenHandler;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils.DefaultClickNickCallback;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment.CommentTextOnTouchListener;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FeedLikeLego
  extends LegoBase<LikeEntry>
{
  private int jdField_a_of_type_Int;
  public Activity a;
  public TextView a;
  protected LikeManager a;
  private SpannableStringUtils.DefaultClickNickCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelSpannableStringUtils$DefaultClickNickCallback;
  private DetailCommentSegment.CommentTextOnTouchListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$CommentTextOnTouchListener;
  public CommentLikeFeedItem a;
  protected FeedManager a;
  public List<LikeEntry> a;
  public boolean a;
  
  public FeedLikeLego(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelSpannableStringUtils$DefaultClickNickCallback = new SpannableStringUtils.DefaultClickNickCallback(paramActivity, paramCommentLikeFeedItem, paramInt, false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$CommentTextOnTouchListener = new DetailCommentSegment.CommentTextOnTouchListener();
  }
  
  public static FeedLikeLego a(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt)
  {
    paramContext = new FeedLikeLego(paramContext, paramActivity, paramView, paramCommentLikeFeedItem, paramInt);
    paramContext.jdField_a_of_type_Boolean = false;
    return paramContext;
  }
  
  public LegoDataProvider a()
  {
    return new FeedLikeDataProvider(this, this.jdField_a_of_type_Boolean);
  }
  
  public LegoEvenHandler a()
  {
    return new FeedLikeLego.1(this);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370032));
    this.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager = ((LikeManager)SuperManager.a(15));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(List<LikeEntry> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int k = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isFriend();
    if (!bool)
    {
      if ((j == 0) && (k == 0))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      if (j == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    paramList = SpannableStringUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelSpannableStringUtils$DefaultClickNickCallback);
    int i;
    if ((!bool) && (j == 0) && (k > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramList.length() == 0) && (i == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (!bool)
    {
      if ((j == 0) && (k > 0)) {
        paramList.append(String.format("%s次赞", new Object[] { UIUtils.a(k) }));
      } else if ((j < k) && (k > 0)) {
        paramList.append(String.format("等%s人赞了", new Object[] { UIUtils.a(k) }));
      } else {
        paramList.append("赞了");
      }
    }
    else {
      paramList.append("赞了");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$CommentTextOnTouchListener);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(paramList.toString());
      localStringBuilder.append(" isFriend:");
      localStringBuilder.append(bool);
      localStringBuilder.append("  likeSize:");
      localStringBuilder.append(j);
      localStringBuilder.append("  likeCount");
      localStringBuilder.append(k);
      QLog.d("FeedLikeLego", 2, localStringBuilder.toString());
    }
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego
 * JD-Core Version:    0.7.0.1
 */