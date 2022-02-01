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
  public TextView a;
  public CommentLikeFeedItem b;
  public boolean c;
  public Activity d;
  public List<LikeEntry> e = new ArrayList();
  protected LikeManager f;
  protected FeedManager g;
  private SpannableStringUtils.DefaultClickNickCallback h;
  private DetailCommentSegment.CommentTextOnTouchListener i;
  private int j;
  
  public FeedLikeLego(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt)
  {
    super(paramContext, paramView);
    this.b = paramCommentLikeFeedItem;
    this.j = paramInt;
    this.d = paramActivity;
    this.h = new SpannableStringUtils.DefaultClickNickCallback(paramActivity, paramCommentLikeFeedItem, paramInt, false);
    this.i = new DetailCommentSegment.CommentTextOnTouchListener();
  }
  
  public static FeedLikeLego a(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt)
  {
    paramContext = new FeedLikeLego(paramContext, paramActivity, paramView, paramCommentLikeFeedItem, paramInt);
    paramContext.c = false;
    return paramContext;
  }
  
  public LegoEvenHandler a()
  {
    return new FeedLikeLego.1(this);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131437188));
    this.f = ((LikeManager)SuperManager.a(15));
    this.g = ((FeedManager)SuperManager.a(11));
    this.a.setOnClickListener(this.s);
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.b = paramCommentLikeFeedItem;
  }
  
  public void a(List<LikeEntry> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.e = paramList;
    int m = this.e.size();
    int n = this.b.mLikeCount;
    boolean bool = this.b.getOwner().isFriend();
    if (!bool)
    {
      if ((m == 0) && (n == 0))
      {
        this.a.setVisibility(8);
        return;
      }
      this.a.setVisibility(0);
    }
    else
    {
      if (m == 0)
      {
        this.a.setVisibility(8);
        return;
      }
      this.a.setVisibility(0);
    }
    paramList = SpannableStringUtils.a(this.b, this.e, this.h);
    int k;
    if ((!bool) && (m == 0) && (n > 0)) {
      k = 1;
    } else {
      k = 0;
    }
    if ((paramList.length() == 0) && (k == 0))
    {
      this.a.setVisibility(8);
      return;
    }
    if (!bool)
    {
      if ((m == 0) && (n > 0)) {
        paramList.append(String.format("%s次赞", new Object[] { UIUtils.a(n) }));
      } else if ((m < n) && (n > 0)) {
        paramList.append(String.format("等%s人赞了", new Object[] { UIUtils.a(n) }));
      } else {
        paramList.append("赞了");
      }
    }
    else {
      paramList.append("赞了");
    }
    this.a.setVisibility(0);
    this.a.setText(paramList);
    this.a.setOnTouchListener(this.i);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(paramList.toString());
      localStringBuilder.append(" isFriend:");
      localStringBuilder.append(bool);
      localStringBuilder.append("  likeSize:");
      localStringBuilder.append(m);
      localStringBuilder.append("  likeCount");
      localStringBuilder.append(n);
      QLog.d("FeedLikeLego", 2, localStringBuilder.toString());
    }
  }
  
  public LegoDataProvider b()
  {
    return new FeedLikeDataProvider(this, this.c);
  }
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeLego
 * JD-Core Version:    0.7.0.1
 */