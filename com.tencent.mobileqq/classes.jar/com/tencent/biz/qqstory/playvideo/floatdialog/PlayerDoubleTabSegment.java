package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PlayerDoubleTabSegment
  extends SegmentView
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private int a = 1;
  private DetailFeedItem b;
  private CommentFloatDialogController c;
  private BaseViewHolder d;
  
  public PlayerDoubleTabSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.e()) {
        paramTextView.setBackgroundResource(2130848255);
      } else {
        paramTextView.setBackgroundResource(2130848254);
      }
      paramTextView.setTextColor(this.l.getResources().getColor(2131167372));
      return;
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.e())
    {
      paramTextView.setTextColor(this.l.getResources().getColor(2131167385));
      return;
    }
    paramTextView.setTextColor(this.l.getResources().getColor(2131167373));
  }
  
  public int a()
  {
    if (this.m)
    {
      DetailFeedItem localDetailFeedItem = this.b;
      if ((localDetailFeedItem != null) && (localDetailFeedItem.c())) {
        return 1;
      }
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramBaseViewHolder.a(2131446406);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131446405);
    if (QQStoryContext.e())
    {
      paramViewGroup.setBackgroundColor(this.l.getResources().getColor(2131167383));
      localTextView.setBackgroundColor(this.l.getResources().getColor(2131167383));
      paramBaseViewHolder.a(2131442655).setBackgroundColor(this.l.getResources().getColor(2131167385));
    }
    if (this.a == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    else
    {
      a(paramViewGroup, false);
      a(localTextView, true);
    }
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.d = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628019, paramViewGroup, false));
    paramViewGroup = (TextView)this.d.a(2131446406);
    TextView localTextView = (TextView)this.d.a(2131446405);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.d;
  }
  
  public void a(CommentFloatDialogController paramCommentFloatDialogController)
  {
    this.c = paramCommentFloatDialogController;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    this.b = paramDetailFeedItem;
    if (this.b.b()) {
      this.a = this.c.d();
    }
  }
  
  public String b()
  {
    return "PlayerDoubleTabSegment";
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131446406: 
      this.c.a(1);
      StoryReportor.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", StoryReportor.b(4444), this.b.a.feedId });
      break;
    case 2131446405: 
      this.c.a(2);
      StoryReportor.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", StoryReportor.b(4444), this.b.a.feedId });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerDoubleTabSegment
 * JD-Core Version:    0.7.0.1
 */