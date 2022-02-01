package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import java.util.List;

public class DetailLikeListSegment
  extends SegmentView<DetailFeedItem>
{
  public static final String KEY = "DetailLikeListSegment";
  private DetailFeedItem a;
  private boolean b;
  private DetailCommentSegment.ClickNickCallback c = new DetailCommentSegment.ClickNickCallback(2);
  private DetailCommentSegment.CommentTextOnTouchListener d = new DetailCommentSegment.CommentTextOnTouchListener();
  private DetailEventCallback e;
  
  public DetailLikeListSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    if (this.m)
    {
      DetailFeedItem localDetailFeedItem = this.a;
      if ((localDetailFeedItem != null) && (localDetailFeedItem.e(this.b).size() > 0)) {
        return 1;
      }
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramBaseViewHolder.a(2131437188);
    SpannableStringBuilder localSpannableStringBuilder = SpannableStringUtils.a(this.a.a, this.a.e(this.b), this.c);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
    }
    else
    {
      if ((this.a.f(this.b) >= 30) && (this.a.f(this.b) > this.a.e(this.b).size())) {
        localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { UIUtils.a(this.a.f(this.b)) }));
      } else {
        localSpannableStringBuilder.append("赞了");
      }
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.d);
    }
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628025, paramViewGroup, false));
  }
  
  public void a(DetailEventCallback paramDetailEventCallback)
  {
    this.e = paramDetailEventCallback;
    this.c.a(paramDetailEventCallback);
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean)
  {
    this.a = paramDetailFeedItem;
    this.b = paramBoolean;
  }
  
  public String b()
  {
    return "DetailLikeListSegment";
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailLikeListSegment
 * JD-Core Version:    0.7.0.1
 */