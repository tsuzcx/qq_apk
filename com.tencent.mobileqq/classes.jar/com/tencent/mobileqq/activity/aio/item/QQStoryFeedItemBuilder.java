package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import vaj;

public class QQStoryFeedItemBuilder
  extends AbstractChatItemBuilder
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vaj(this);
  private QQStoryFeedManager jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager;
  private QQStoryFeedItemBuilder.FeedViewHolder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder;
  private MessageForQQStoryFeed jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed;
  private List jdField_a_of_type_JavaUtilList;
  
  public QQStoryFeedItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramContext = System.getProperty("line.separator");
      paramQQAppInterface.append("adapter: ").append(paramBaseAdapter.getCount()).append(paramContext).append("info: ").append(paramSessionInfo.d).append(paramContext);
      QLog.i("QQStoryFeedItemBuilder", 2, "QQStoryFeedItemBuilder: invoked. info: b: " + paramQQAppInterface);
    }
  }
  
  private View a(View paramView, QQStoryFeedItemBuilder.FeedViewHolder paramFeedViewHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968761, null);
      paramFeedViewHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131363620));
      paramFeedViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363619));
      paramFeedViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363621));
      paramFeedViewHolder.c = ((TextView)paramView.findViewById(2131363624));
      paramFeedViewHolder.d = ((TextView)paramView.findViewById(2131363622));
      paramFeedViewHolder.e = ((TextView)paramView.findViewById(2131363625));
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
    int i = AIOUtils.a(59.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2 + 1;
    paramString = URLDrawable.getDrawable(paramString, i, i);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "fetchSuitableCover invoked. info: drawable.getStatus(): " + paramString.getStatus());
    }
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    paramString.setTag(URLDrawableDecodeHandler.a(i, i, (int)(2.0F * DeviceInfoUtil.a())));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.g);
    return paramString;
  }
  
  private CharSequence a()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.uint64_time;
    return TimeFormatterUtils.b(this.jdField_a_of_type_AndroidContentContext, 7, l * 1000L, true);
  }
  
  private String a(String paramString)
  {
    if (QQStoryFeedManager.a(this.jdField_a_of_type_AndroidContentContext)) {
      return paramString + "&qimInstalled=true";
    }
    return paramString + "&qimInstalled=false";
  }
  
  private List a()
  {
    ArrayList localArrayList = new ArrayList();
    URLDrawable localURLDrawable = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.str_cover);
    localArrayList.add(new AbstractMap.SimpleEntry(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.str_jump_url, localURLDrawable));
    return localArrayList;
  }
  
  private void a(View paramView)
  {
    if (b)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText()).append("时间").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.c.getText());
      paramView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  private void a(String paramString)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80088E0", "0X80088E0", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramString = a(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "jumpToWeb invoked. info: url: " + paramString);
    }
    localIntent.putExtra("url", paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private boolean a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.frienduin;
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.uint64_time;
    int i = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager.a(str);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "isFeedItemTimeout invoked. info: keepTimeSecond: " + i + " curServerTimeSecond - msgTimeSecond: " + (l1 - l2));
    }
    return l1 - l2 > i;
  }
  
  private boolean a(String paramString)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager.c(paramString);
    long l3 = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "isSignatureRecently invoked. info: qzoneExceedSecond: " + l2 + " latestSignatureFeedSecond: " + l3);
    }
    return l1 - l3 < l2;
  }
  
  private CharSequence b()
  {
    String str = Utils.b(this.a.d, 10);
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.uint32_video_num;
    return str + "与你分享" + i + "个小视频";
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.e.setText(a());
  }
  
  private boolean b()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_a_of_type_ComTencentImageURLImageView == null) {
      i = 0;
    }
    while (i == 0)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    long l1 = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager.a(paramString);
    long l2 = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager.c(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "isQZoneFeedRecently invoked. info: qzoneExceedSecond: " + l2 + " latestQZoneFeedSecond: " + l1);
    }
    return NetConnInfoCenter.getServerTime() - l1 < l2;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() < 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
    }
    URLDrawable localURLDrawable;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localURLDrawable = (URLDrawable)((Map.Entry)this.jdField_a_of_type_JavaUtilList.get(0)).getValue();
      if (localURLDrawable != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QQStoryFeedItemBuilder", 2, "setupFirstCover invoked. info: error, cannot be null. drawable: " + localURLDrawable);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
  }
  
  private void d()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.uint32_video_num;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.d.setText(String.valueOf(i));
  }
  
  private void e()
  {
    CharSequence localCharSequence = b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.c.setText(localCharSequence);
  }
  
  private void f()
  {
    String str = Utils.b(this.a.d, 10);
    str = str + "有新视频";
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(str);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    try
    {
      paramLinearLayout = (MessageForQQStoryFeed)MessageForQQStoryFeed.class.cast(paramMessageRecord);
      if (paramLinearLayout == null)
      {
        paramView.setVisibility(8);
        return paramView;
      }
    }
    catch (ClassCastException paramMessageRecord)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQStoryFeedItemBuilder", 2, "getItemView Failed. info: exception: ", paramMessageRecord);
      }
      paramView.setVisibility(8);
      return paramView;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryFeedManager = ((QQStoryFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed = new MessageForQQStoryFeed(paramLinearLayout);
    }
    this.jdField_a_of_type_JavaUtilList = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder = ((QQStoryFeedItemBuilder.FeedViewHolder)QQStoryFeedItemBuilder.FeedViewHolder.class.cast(paramViewHolder));
    paramViewHolder = a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder);
    boolean bool = b();
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "getItemView invoked. info: noCoverCanShow: " + bool);
    }
    if (bool)
    {
      paramViewHolder.setVisibility(8);
      return paramViewHolder;
    }
    bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.isEmpty();
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "getItemView invoked. info: isEmpty: " + bool);
    }
    if (bool)
    {
      paramViewHolder.setVisibility(8);
      return paramViewHolder;
    }
    bool = a();
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "getItemView invoked. info: feedItemTimeout: " + bool);
    }
    if (bool)
    {
      paramViewHolder.setVisibility(8);
      return paramViewHolder;
    }
    bool = b(paramMessageRecord.frienduin);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "getItemView invoked. info: QZoneFeedRecently: " + bool);
    }
    if (bool)
    {
      paramViewHolder.setVisibility(8);
      return paramViewHolder;
    }
    bool = a(paramMessageRecord.frienduin);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "getItemView invoked. info: signatureRecently: " + bool);
    }
    if (bool)
    {
      paramViewHolder.setVisibility(8);
      return paramViewHolder;
    }
    c();
    e();
    b();
    f();
    d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder$FeedViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(paramViewHolder);
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