package com.tencent.biz.qqcircle.comment;

import aakb;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import vbc;

public class QCircleMoreReplyItemView
  extends QCircleBaseWidgetView<vbc>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private aakb jdField_a_of_type_Aakb;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private vbc jdField_a_of_type_Vbc;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public QCircleMoreReplyItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560697;
  }
  
  public String a()
  {
    return "QCircleMoreReplyItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379952));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379922));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  protected void a(vbc paramvbc) {}
  
  public void a(vbc paramvbc, int paramInt)
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (paramvbc == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Vbc = paramvbc;
      this.jdField_b_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Vbc.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131697190, new Object[] { Integer.valueOf(this.jdField_a_of_type_Vbc.jdField_b_of_type_Int) }));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
    } while (this.jdField_a_of_type_Vbc.jdField_a_of_type_Int != 3);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
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
      if (this.jdField_a_of_type_Aakb != null)
      {
        FeedCloudMeta.StComment localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
        int i = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Aakb.a(paramView, 10, this.jdField_a_of_type_Int, new Object[] { localStComment, Integer.valueOf(i) });
        continue;
        if (this.jdField_a_of_type_Aakb != null)
        {
          localStComment = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
          i = this.jdField_b_of_type_Int;
          this.jdField_a_of_type_Aakb.a(paramView, 11, this.jdField_a_of_type_Int, new Object[] { localStComment, Integer.valueOf(i) });
        }
      }
    }
  }
  
  public void setOnCommentElementClickListener(aakb paramaakb)
  {
    this.jdField_a_of_type_Aakb = paramaakb;
  }
  
  public void setPreData(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleMoreReplyItemView
 * JD-Core Version:    0.7.0.1
 */