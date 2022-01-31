package com.tencent.biz.qqcircle.comment;

import alud;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import java.util.List;
import yhn;

public class ItemReplyContainer
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private QCircleReplyActionView jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private yhn jdField_a_of_type_Yhn;
  private int b;
  
  public ItemReplyContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ItemReplyContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ItemReplyContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a() {}
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StFeed paramStFeed, List<FeedCloudMeta.StReply> paramList, int paramInt)
  {
    paramList = (FeedCloudMeta.StReply)paramList.get(paramInt);
    ItemReplyView localItemReplyView = new ItemReplyView(getContext());
    localItemReplyView.setPosition(paramInt);
    localItemReplyView.setOnCommentElementClickListener(this.jdField_a_of_type_Yhn);
    localItemReplyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localItemReplyView.setClickable(true);
    localItemReplyView.setFocusable(true);
    localItemReplyView.setData(paramStComment, paramList, paramStFeed);
    addView(localItemReplyView);
  }
  
  private void b() {}
  
  protected void a(FeedCloudMeta.StComment paramStComment, int paramInt1, FeedCloudMeta.StFeed paramStFeed, int paramInt2, boolean paramBoolean)
  {
    if ((paramStFeed == null) || (paramStComment == null) || (paramStComment.vecReply.size() == 0))
    {
      setVisibility(8);
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    List localList = paramStComment.vecReply.get();
    int i = localList.size();
    if (i > 0)
    {
      int j = i - paramInt2;
      i = j;
      if (paramInt1 > 0) {
        i = Math.min(j, paramInt1);
      }
      i += paramInt2;
      this.b = i;
      setVisibility(0);
      removeAllViews();
      paramInt1 = 0;
      while (paramInt1 < i - paramInt2)
      {
        a(paramStComment, paramStFeed, localList, paramInt1);
        paramInt1 += 1;
      }
      if (i <= localList.size())
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView = new QCircleReplyActionView(getContext());
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.setClickable(true);
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setOnClickListener(this);
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.b().setOnClickListener(this);
        }
        if (i != localList.size()) {
          break label301;
        }
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setVisibility(8);
        if ((i - paramInt2 > 3) && (!paramBoolean)) {
          break label279;
        }
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.b().setVisibility(8);
      }
      while (paramInt2 > 0)
      {
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          a(paramStComment, paramStFeed, localList, localList.size() - paramInt2 + paramInt1);
          paramInt1 += 1;
        }
        label279:
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.b().setVisibility(0);
        addView(this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView);
        continue;
        label301:
        if (i < localList.size())
        {
          paramInt1 = localList.size();
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setText(alud.a(2131713788) + (paramInt1 - i) + alud.a(2131713789));
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.b().setVisibility(8);
          addView(this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView);
        }
      }
      setVisibility(0);
      return;
    }
    setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Yhn == null);
      this.jdField_a_of_type_Yhn.a(paramView, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    } while (this.jdField_a_of_type_Yhn == null);
    FeedCloudMeta.StComment localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    int i = getHeight() / this.b;
    this.jdField_a_of_type_Yhn.a(paramView, 11, this.jdField_a_of_type_Int, new Object[] { localStComment, Integer.valueOf(i) });
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void setOnCommentElementClickListener(yhn paramyhn)
  {
    this.jdField_a_of_type_Yhn = paramyhn;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.ItemReplyContainer
 * JD-Core Version:    0.7.0.1
 */