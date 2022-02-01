package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;

public class QQStoryFeedItemBuilder
  extends AbstractChatItemBuilder
{
  private static SimpleDateFormat h;
  private MessageForQQStoryFeed e;
  private QQStoryFeedItemBuilder.FeedViewHolder f;
  private boolean g;
  private View.OnTouchListener i = new QQStoryFeedItemBuilder.1(this);
  
  public QQStoryFeedItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, QQStoryFeedItemBuilder.FeedViewHolder paramFeedViewHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624442, null);
      paramFeedViewHolder.d = ((ViewGroup)paramView.findViewById(2131436919));
      paramFeedViewHolder.e = ((CornerImageView)paramView.findViewById(2131436595));
      paramFeedViewHolder.f = ((ImageView)paramView.findViewById(2131436597));
      paramFeedViewHolder.g = ((TextView)paramView.findViewById(2131448576));
      paramFeedViewHolder.h = ((TextView)paramView.findViewById(2131448454));
      paramFeedViewHolder.i = ((TextView)paramView.findViewById(2131448443));
      paramFeedViewHolder.j = ((ImageView)paramView.findViewById(2131436372));
      f();
      this.f.d.setOnTouchListener(this.i);
      this.f.g.setText(d());
      this.f.h.setText(c());
      e();
      b(paramView);
      localView = paramView;
      if (v)
      {
        paramFeedViewHolder.r = new StringBuilder();
        localView = paramView;
      }
    }
    if (v)
    {
      localView.setContentDescription(null);
      paramFeedViewHolder.r.setLength(0);
    }
    return localView;
  }
  
  private URLDrawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int j = AIOUtils.b(this.c.getResources().getDimension(2131299781), this.c.getResources());
    int k = AIOUtils.b(this.c.getResources().getDimension(2131299785), this.c.getResources());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = k;
    localURLDrawableOptions.mRequestHeight = j;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public static CharSequence a(Context paramContext, long paramLong)
  {
    if (h == null) {
      h = (SimpleDateFormat)DateFormat.getDateFormat(paramContext);
    }
    h.applyPattern(String.format("M%sd%s HH:mm", new Object[] { paramContext.getString(2131891839), paramContext.getString(2131888405) }));
    return DateFormat.format(h.toLocalizedPattern(), paramLong);
  }
  
  private boolean a(View paramView, MessageForQQStoryFeed paramMessageForQQStoryFeed)
  {
    if (this.e.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setFeedViewVisibility invoked. info: empty msg. ");
      }
      paramView.setVisibility(8);
    }
    return true;
  }
  
  private void b(View paramView)
  {
    if (v)
    {
      this.f.r.append(this.f.g.getText());
      paramView.setContentDescription(this.f.r.toString());
    }
  }
  
  private CharSequence c()
  {
    long l = this.e.mFeedTime;
    return a(this.c, l * 1000L);
  }
  
  private void c(View paramView)
  {
    paramView = this.e.mUnionId;
    String str = this.e.mFeedId;
    StoryReportor.a("aio_msg", "aio_clk", 0, 0, new String[] { this.e.frienduin });
    StoryPlayerLauncher.a(BaseActivity.sTopActivity, paramView, str, 1, 109, 1, this.f.e);
  }
  
  private CharSequence d()
  {
    return this.e.mMainText;
  }
  
  private String e()
  {
    String str = Utils.b(this.e.mFeedAddress, 10);
    if (!TextUtils.isEmpty(str))
    {
      this.f.i.setText(str);
      return str;
    }
    this.f.i.setVisibility(4);
    this.f.j.setVisibility(4);
    return str;
  }
  
  private void f()
  {
    URLDrawable localURLDrawable = a(this.e.mCoverUrl);
    Object localObject;
    if (localURLDrawable == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setupCover invoked. info: drawable: ");
        ((StringBuilder)localObject).append(localURLDrawable);
        QLog.i("QQStoryFeedItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.f.e.setPressMask(true);
      int j = AIOUtils.b(10.0F, this.c.getResources());
      localObject = this.f.e;
      float f1 = j;
      ((CornerImageView)localObject).setRadius(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      this.f.e.setImageDrawable(localURLDrawable);
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (!(paramMessageRecord instanceof MessageForQQStoryFeed))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQStoryFeedItemBuilder", 2, "getItemView Failed. info: wrong message type. ");
      }
      return paramView;
    }
    paramMessageRecord = (MessageForQQStoryFeed)MessageForQQStoryFeed.class.cast(paramMessageRecord);
    if (this.e == null) {
      this.e = new MessageForQQStoryFeed(paramMessageRecord);
    }
    if (this.f == null) {
      this.f = ((QQStoryFeedItemBuilder.FeedViewHolder)QQStoryFeedItemBuilder.FeedViewHolder.class.cast(paramViewHolder));
    }
    paramMessageRecord = a(paramView, this.f);
    if (!this.g) {
      this.g = a(paramMessageRecord, this.e);
    }
    return paramMessageRecord;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new QQStoryFeedItemBuilder.FeedViewHolder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryFeedItemBuilder
 * JD-Core Version:    0.7.0.1
 */