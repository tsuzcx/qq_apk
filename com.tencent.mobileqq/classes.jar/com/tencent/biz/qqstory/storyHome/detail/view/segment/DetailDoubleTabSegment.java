package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DetailDoubleTabSegment
  extends SegmentView
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private int a = 1;
  private DetailEventCallback b;
  private DetailFeedItem c;
  private BaseViewHolder d;
  
  public DetailDoubleTabSegment(Context paramContext)
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
      DetailFeedItem localDetailFeedItem = this.c;
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
    if (QQStoryContext.e())
    {
      paramViewGroup.setBackgroundColor(this.l.getResources().getColor(2131167383));
      localTextView.setBackgroundColor(this.l.getResources().getColor(2131167383));
      this.d.a(2131442655).setBackgroundColor(this.l.getResources().getColor(2131167385));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.d;
  }
  
  public void a(DetailEventCallback paramDetailEventCallback)
  {
    this.b = paramDetailEventCallback;
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    this.c = paramDetailFeedItem;
    if (this.c.b())
    {
      if (paramBoolean)
      {
        this.a = 2;
        return;
      }
      this.a = 1;
    }
  }
  
  public String b()
  {
    return "DetailDoubleTabSegment";
  }
  
  public void br_()
  {
    if (((StoryDetailListView)w()).b())
    {
      this.m = true;
      return;
    }
    this.m = false;
  }
  
  public int d()
  {
    return this.a;
  }
  
  public int e()
  {
    BaseViewHolder localBaseViewHolder = this.d;
    if (localBaseViewHolder == null) {
      return 0;
    }
    return localBaseViewHolder.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    if (this.b != null) {
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131446406: 
        if (this.a != 1) {
          this.b.h_(1);
        }
        break;
      case 2131446405: 
        if (this.a != 2) {
          this.b.h_(2);
        }
        break;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailDoubleTabSegment
 * JD-Core Version:    0.7.0.1
 */