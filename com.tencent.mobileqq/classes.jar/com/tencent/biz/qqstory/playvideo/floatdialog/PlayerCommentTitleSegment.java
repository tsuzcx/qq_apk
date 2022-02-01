package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PlayerCommentTitleSegment
  extends SegmentView
  implements View.OnClickListener
{
  public static final String KEY = "PlayerCommentTitleSegment";
  private BaseViewHolder a;
  private DetailFeedItem b;
  private PlayerCommentEventCallback c;
  
  public PlayerCommentTitleSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    if (this.b != null) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramBaseViewHolder.a(2131447463);
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131430817);
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.a = new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628119, paramViewGroup, false));
    paramViewGroup = (ImageView)this.a.a(2131430817);
    TextView localTextView = (TextView)this.a.a(2131447463);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.a;
  }
  
  public String b()
  {
    return "PlayerCommentTitleSegment";
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430817)
    {
      PlayerCommentEventCallback localPlayerCommentEventCallback = this.c;
      if (localPlayerCommentEventCallback != null) {
        localPlayerCommentEventCallback.a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.PlayerCommentTitleSegment
 * JD-Core Version:    0.7.0.1
 */