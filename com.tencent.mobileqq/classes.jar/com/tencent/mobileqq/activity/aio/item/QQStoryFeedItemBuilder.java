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
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
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
import vin;

public class QQStoryFeedItemBuilder
  extends AbstractChatItemBuilder
{
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new vin(this);
  private QQStoryFeedManager jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager;
  private QQStoryFeedItemBuilder.FeedViewHolder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder;
  private MessageForQQStoryFeed jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed;
  private boolean jdField_a_of_type_Boolean;
  
  public QQStoryFeedItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, QQStoryFeedItemBuilder.FeedViewHolder paramFeedViewHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968764, null);
      paramFeedViewHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363656));
      paramFeedViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363659));
      paramFeedViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363657));
      paramFeedViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363666));
      paramFeedViewHolder.c = ((TextView)paramView.findViewById(2131363663));
      paramFeedViewHolder.d = ((TextView)paramView.findViewById(2131363664));
      paramFeedViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363665));
      c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(b());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.c.setText(a());
      a();
      a(paramView);
      localView = paramView;
      if (b)
      {
        paramFeedViewHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (b)
    {
      localView.setContentDescription(null);
      paramFeedViewHolder.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
    }
    return localView;
  }
  
  private URLDrawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = AIOUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131559502), this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131559500), this.jdField_a_of_type_AndroidContentContext.getResources());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = j;
    localURLDrawableOptions.mRequestHeight = i;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  private CharSequence a()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedTime;
    return a(this.jdField_a_of_type_AndroidContentContext, l * 1000L);
  }
  
  public static CharSequence a(Context paramContext, long paramLong)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null) {
      jdField_a_of_type_JavaTextSimpleDateFormat = (SimpleDateFormat)DateFormat.getDateFormat(paramContext);
    }
    jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern(String.format("M%sd%s HH:mm", new Object[] { paramContext.getString(2131434673), paramContext.getString(2131434674) }));
    return DateFormat.format(jdField_a_of_type_JavaTextSimpleDateFormat.toLocalizedPattern(), paramLong);
  }
  
  private String a()
  {
    String str = Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedAddress, 10);
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.d.setText(str);
      return str;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.d.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    return str;
  }
  
  private void a(View paramView)
  {
    if (b)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  private boolean a(View paramView, MessageForQQStoryFeed paramMessageForQQStoryFeed)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setFeedViewVisibility invoked. info: empty msg. ");
      }
      paramView.setVisibility(8);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager = ((QQStoryFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252));
      boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager.a();
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setFeedViewVisibility: invoked. Message: enable: " + bool);
      }
      if (!bool)
      {
        paramView.setVisibility(8);
        return true;
      }
      bool = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager.a(paramMessageForQQStoryFeed.frienduin);
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setFeedViewVisibility invoked. info: QZoneFeedRecently: " + bool);
      }
      if (bool)
      {
        paramView.setVisibility(8);
        return true;
      }
      bool = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager.b(paramMessageForQQStoryFeed.frienduin);
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setFeedViewVisibility invoked. info: signatureRecently: " + bool);
      }
      if (bool)
      {
        paramView.setVisibility(8);
        return true;
      }
      bool = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed);
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setFeedViewVisibility invoked. info: feedItemTimeout: " + bool);
      }
      if (bool)
      {
        paramView.setVisibility(8);
        return true;
      }
    }
    StoryReportor.a("aio_msg", "aio_push", 0, 0, new String[] { paramMessageForQQStoryFeed.frienduin });
    return true;
  }
  
  private CharSequence b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mMainText;
  }
  
  private void b()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mUnionId;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedId;
    StoryReportor.a("aio_msg", "aio_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.frienduin });
    StoryPlayVideoActivity.a(BaseActivity.sTopActivity, str1, str2, 1, 109, 1);
  }
  
  private void c()
  {
    URLDrawable localURLDrawable = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mCoverUrl);
    if (localURLDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setupCover invoked. info: drawable: " + localURLDrawable);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
    int i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F });
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(localURLDrawable);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (!(paramMessageRecord instanceof MessageForQQStoryFeed))
    {
      paramMessageRecord = paramView;
      if (QLog.isColorLevel())
      {
        QLog.e("QQStoryFeedItemBuilder", 2, "getItemView Failed. info: wrong message type. ");
        paramMessageRecord = paramView;
      }
    }
    do
    {
      return paramMessageRecord;
      paramMessageRecord = (MessageForQQStoryFeed)MessageForQQStoryFeed.class.cast(paramMessageRecord);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed = new MessageForQQStoryFeed(paramMessageRecord);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder = ((QQStoryFeedItemBuilder.FeedViewHolder)QQStoryFeedItemBuilder.FeedViewHolder.class.cast(paramViewHolder));
      }
      paramViewHolder = a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder);
      paramMessageRecord = paramViewHolder;
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = a(paramViewHolder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed);
    return paramViewHolder;
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