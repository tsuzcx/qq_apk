package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import veb;
import vec;

public class QzoneFeedItemBuilder
  extends AbstractChatItemBuilder
{
  private static int m = -1;
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  
  public QzoneFeedItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramQQAppInterface = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = AIOUtils.a(251.0F, paramQQAppInterface);
    this.jdField_b_of_type_Int = AIOUtils.a(145.0F, paramQQAppInterface);
    this.c = AIOUtils.a(128.5F, paramQQAppInterface);
    this.d = AIOUtils.a(124.5F, paramQQAppInterface);
    this.e = AIOUtils.a(122.5F, paramQQAppInterface);
    this.f = AIOUtils.a(124.5F, paramQQAppInterface);
    this.g = AIOUtils.a(11.0F, paramQQAppInterface);
    this.k = AIOUtils.a(71.5F, paramQQAppInterface);
    this.l = AIOUtils.a(74.0F, paramQQAppInterface);
    this.h = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedBlogTitleMaxLength", 8);
    this.j = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20180411173248_sbi0mX7no1.png");
  }
  
  private int a(MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    int n = 1;
    if (paramMessageForQzoneFeed.mediaDatas != null)
    {
      if (paramMessageForQzoneFeed.mediaDatas.size() > 1) {
        n = 2;
      }
      return n;
    }
    if (!TextUtils.isEmpty(paramMessageForQzoneFeed.title)) {
      return 4;
    }
    return 3;
  }
  
  private View a(View paramView, vec paramvec)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968763, null);
      paramvec.jdField_b_of_type_AndroidViewView = paramView;
      paramvec.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131363654);
      paramvec.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131363657);
      paramvec.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363660));
      paramvec.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363653));
      paramvec.h = ((TextView)paramView.findViewById(2131363663));
      paramvec.i = ((TextView)paramView.findViewById(2131363666));
      paramvec.j = ((TextView)paramView.findViewById(2131363664));
      paramvec.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363661));
      paramvec.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363655));
      localView = paramView;
      if (jdField_b_of_type_Boolean)
      {
        paramvec.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_b_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramvec.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramvec.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  private static String a(long paramLong)
  {
    if (paramLong > 100000000L) {
      return String.format("%.1f亿", new Object[] { Float.valueOf((float)paramLong / 1.0E+008F) });
    }
    if (paramLong > 10000L) {
      return String.format("%.1f万", new Object[] { Float.valueOf((float)paramLong / 10000.0F) });
    }
    return String.format("%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int n;
    do
    {
      return null;
      n = paramString.indexOf("http");
    } while (n < 0);
    paramString = paramString.substring(n);
    try
    {
      new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static String a(String paramString, int paramInt)
  {
    paramString = Utils.b(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private static void a(CornerImageView paramCornerImageView, View paramView, MessageForQzoneFeed.MediaData paramMediaData, URLDrawable.URLDrawableOptions paramURLDrawableOptions, float[] paramArrayOfFloat)
  {
    if (paramMediaData.uType == 1) {
      paramView.setVisibility(0);
    }
    for (;;)
    {
      paramCornerImageView.setRadius(paramArrayOfFloat);
      paramCornerImageView.setImageDrawable(URLDrawable.getDrawable(a(paramMediaData.strImgUrl), paramURLDrawableOptions));
      return;
      paramView.setVisibility(8);
    }
  }
  
  private void a(vec paramvec)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.k;
    localURLDrawableOptions.mRequestHeight = this.l;
    paramvec.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(0);
    paramvec.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.g, this.g, 0.0F, 0.0F });
    paramvec.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
  }
  
  private void a(vec paramvec, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    switch (a(paramMessageForQzoneFeed))
    {
    }
    for (;;)
    {
      CharSequence localCharSequence = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 7, paramMessageForQzoneFeed.feedTime * 1000L);
      paramvec.h.setText(localCharSequence);
      String str1 = Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.h);
      String str2 = str1 + paramMessageForQzoneFeed.summery;
      paramvec.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
      paramvec.i.setText(a(paramMessageForQzoneFeed.ulikeNum));
      paramvec.j.setText(a(paramMessageForQzoneFeed.uCommentNum));
      if (jdField_b_of_type_Boolean)
      {
        paramvec.jdField_b_of_type_JavaLangStringBuilder.append(str1);
        if (paramMessageForQzoneFeed.feedTime > 0L) {
          paramvec.jdField_b_of_type_JavaLangStringBuilder.append("于").append(localCharSequence);
        }
        paramvec.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageForQzoneFeed.summery).append("内容是：").append(paramMessageForQzoneFeed.title).append(paramMessageForQzoneFeed.content);
        paramvec.jdField_b_of_type_AndroidViewView.setContentDescription(paramvec.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return;
      b(paramvec, paramMessageForQzoneFeed);
      continue;
      c(paramvec, paramMessageForQzoneFeed);
      continue;
      e(paramvec, paramMessageForQzoneFeed);
      continue;
      d(paramvec, paramMessageForQzoneFeed);
    }
  }
  
  private void b(vec paramvec, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramvec.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramvec.jdField_f_of_type_AndroidViewView != null) {
      paramvec.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramvec.jdField_g_of_type_AndroidViewView != null) {
      paramvec.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    paramvec.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramvec.jdField_e_of_type_AndroidViewView == null)
    {
      paramvec.jdField_e_of_type_AndroidViewView = ((ViewStub)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363658)).inflate();
      paramvec.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363677));
      paramvec.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363678));
    }
    paramvec.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130837726);
    paramvec.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramvec.jdField_e_of_type_AndroidViewView.setVisibility(0);
    MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.strImgUrl);
    }
    if (paramMessageForQzoneFeed.appId == 2)
    {
      paramMessageForQzoneFeed = a(paramMessageForQzoneFeed.title, this.j);
      paramvec.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed);
    }
    for (;;)
    {
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.jdField_a_of_type_Int;
      paramMessageForQzoneFeed.mRequestHeight = this.jdField_b_of_type_Int;
      a(paramvec.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramvec.jdField_a_of_type_AndroidWidgetImageView, localMediaData, paramMessageForQzoneFeed, new float[] { this.g, this.g, this.g, this.g, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramvec.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
    }
  }
  
  private void c(vec paramvec, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() < 2)) {
      return;
    }
    paramvec.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramvec.jdField_e_of_type_AndroidViewView != null) {
      paramvec.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramvec.jdField_g_of_type_AndroidViewView != null) {
      paramvec.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    paramvec.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramvec.jdField_f_of_type_AndroidViewView == null)
    {
      paramvec.jdField_f_of_type_AndroidViewView = ((ViewStub)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363659)).inflate();
      paramvec.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363672));
      paramvec.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363673));
      paramvec.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363674));
      paramvec.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363675));
      paramvec.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363676));
    }
    paramvec.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130837726);
    paramvec.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramvec.jdField_f_of_type_AndroidViewView.setVisibility(0);
    Object localObject;
    if (paramMessageForQzoneFeed.appId == 2)
    {
      localObject = a(paramMessageForQzoneFeed.title, this.j);
      paramvec.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (paramMessageForQzoneFeed.imageCount <= 2) {
        break label470;
      }
      paramvec.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("+%s", new Object[] { a(paramMessageForQzoneFeed.imageCount - 2) }));
    }
    for (;;)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.c;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.d;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.e;
      localURLDrawableOptions.mRequestHeight = this.f;
      a(paramvec.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramvec.jdField_b_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0), (URLDrawable.URLDrawableOptions)localObject, new float[] { this.g, this.g, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      a(paramvec.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramvec.jdField_c_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1), localURLDrawableOptions, new float[] { 0.0F, 0.0F, this.g, this.g, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramvec.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
      break;
      label470:
      paramvec.jdField_e_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private void d(vec paramvec, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramvec.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramvec.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramvec.jdField_g_of_type_AndroidViewView == null)
    {
      paramvec.jdField_g_of_type_AndroidViewView = ((ViewStub)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363662)).inflate();
      paramvec.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363670));
      paramvec.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramvec.jdField_b_of_type_AndroidViewView.findViewById(2131363671));
    }
    paramvec.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130837729);
    a(paramvec);
    paramvec.jdField_g_of_type_AndroidViewView.setVisibility(0);
    String str = a(paramMessageForQzoneFeed.title, this.i);
    paramvec.jdField_f_of_type_AndroidWidgetTextView.setText(str);
    paramvec.jdField_g_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  private void e(vec paramvec, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramvec.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (paramvec.jdField_g_of_type_AndroidViewView != null) {
      paramvec.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    paramvec.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130837729);
    a(paramvec);
    paramvec.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramvec.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (vec)paramViewHolder;
    paramViewHolder = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramMessageRecord.jdField_b_of_type_JavaLangString = null;
    paramLinearLayout.coverImageUrl = a(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.jdField_c_of_type_AndroidViewView.setOnClickListener(new veb(this, paramLinearLayout));
    if (!paramLinearLayout.hasExposed)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
      paramLinearLayout.hasExposed = true;
    }
    paramView = URLUtil.a(paramLinearLayout.actionUrl);
    paramMessageRecord = null;
    if (paramView != null) {
      paramMessageRecord = (String)paramView.get("a");
    }
    if (paramMessageRecord != null)
    {
      if (!paramMessageRecord.equals("4")) {
        break label265;
      }
      paramMessageRecord = "1";
    }
    for (;;)
    {
      paramView = new QZoneClickReport.ReportInfo();
      paramView.c = "330";
      paramView.d = "1";
      paramView.e = paramMessageRecord;
      paramView.a = new ArrayList();
      paramView.a.add(paramLinearLayout.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
      return paramViewHolder;
      label265:
      if (paramMessageRecord.equals("311")) {
        paramMessageRecord = "2";
      } else if (paramMessageRecord.equals("2")) {
        paramMessageRecord = "3";
      } else {
        paramMessageRecord = "4";
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new vec(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("fromAio", true);
    PublicAccountUtil.a(localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QzoneFeedItemBuilder
 * JD-Core Version:    0.7.0.1
 */