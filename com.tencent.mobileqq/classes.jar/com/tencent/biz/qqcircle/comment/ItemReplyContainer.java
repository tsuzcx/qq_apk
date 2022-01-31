package com.tencent.biz.qqcircle.comment;

import alpo;
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
import yde;

public class ItemReplyContainer
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private QCircleReplyActionView jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private yde jdField_a_of_type_Yde;
  private int b;
  private int c;
  
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
  
  private void b() {}
  
  protected void a(FeedCloudMeta.StComment paramStComment, int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed == null) || (paramStComment == null) || (paramStComment.vecReply.size() == 0))
    {
      setVisibility(8);
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    List localList = paramStComment.vecReply.get();
    int j = localList.size();
    if (j > 0) {
      if (paramInt <= 0) {
        break label446;
      }
    }
    label290:
    label446:
    for (paramInt = Math.min(j, paramInt);; paramInt = j)
    {
      this.c = paramInt;
      setVisibility(0);
      removeAllViews();
      int i = 0;
      while (i < paramInt)
      {
        FeedCloudMeta.StReply localStReply = (FeedCloudMeta.StReply)localList.get(i);
        ItemReplyView localItemReplyView = new ItemReplyView(getContext());
        localItemReplyView.setPosition(i);
        localItemReplyView.setOnCommentElementClickListener(this.jdField_a_of_type_Yde);
        localItemReplyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        localItemReplyView.setClickable(true);
        localItemReplyView.setFocusable(true);
        localItemReplyView.setData(paramStComment, localStReply, paramStFeed);
        addView(localItemReplyView);
        i += 1;
      }
      if (paramInt <= j)
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView = new QCircleReplyActionView(getContext());
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.setClickable(true);
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setOnClickListener(this);
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.b().setOnClickListener(this);
        }
        if (paramInt <= this.b) {
          break label331;
        }
        if (paramInt != j) {
          break label290;
        }
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.b().setVisibility(0);
      }
      for (;;)
      {
        addView(this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView);
        setVisibility(0);
        return;
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setText(alpo.a(2131713778));
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.b().setVisibility(8);
        continue;
        label331:
        if (j > paramInt)
        {
          paramInt = j - paramInt;
          if (paramInt > 0)
          {
            this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setText(alpo.a(2131713776) + paramInt + alpo.a(2131713777));
            this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setVisibility(0);
            this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.b().setVisibility(8);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.a().setVisibility(8);
          this.jdField_a_of_type_ComTencentBizQqcircleCommentQCircleReplyActionView.b().setVisibility(8);
        }
      }
      setVisibility(8);
      return;
    }
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
      } while (this.jdField_a_of_type_Yde == null);
      this.jdField_a_of_type_Yde.a(paramView, 10, this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
      return;
    } while (this.jdField_a_of_type_Yde == null);
    FeedCloudMeta.StComment localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
    int i = getHeight() / this.c;
    this.jdField_a_of_type_Yde.a(paramView, 11, this.jdField_a_of_type_Int, new Object[] { localStComment, Integer.valueOf(i) });
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void setDisplayNum(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setOnCommentElementClickListener(yde paramyde)
  {
    this.jdField_a_of_type_Yde = paramyde;
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