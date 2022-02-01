package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qroute.QRoute;
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
import java.util.HashMap;
import java.util.Map;

public class QzoneFeedItemBuilder
  extends AbstractChatItemBuilder
{
  private static int n = -1;
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
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
  private final int m;
  
  public QzoneFeedItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = AIOUtils.a(251.0F, paramBaseAdapter);
    this.c = AIOUtils.a(131.0F, paramBaseAdapter);
    this.d = AIOUtils.a(128.5F, paramBaseAdapter);
    this.jdField_e_of_type_Int = AIOUtils.a(131.0F, paramBaseAdapter);
    this.f = AIOUtils.a(122.5F, paramBaseAdapter);
    this.g = AIOUtils.a(131.0F, paramBaseAdapter);
    this.h = AIOUtils.a(16.0F, paramBaseAdapter);
    this.l = AIOUtils.a(71.5F, paramBaseAdapter);
    this.m = AIOUtils.a(74.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.j = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedBlogTitleMaxLength", 8);
    this.k = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 2);
    }
  }
  
  private int a(MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    int i1 = 1;
    if (paramMessageForQzoneFeed.mediaDatas != null)
    {
      if (paramMessageForQzoneFeed.mediaDatas.size() > 1) {
        i1 = 2;
      }
      return i1;
    }
    if (!TextUtils.isEmpty(paramMessageForQzoneFeed.title)) {
      return 4;
    }
    return 3;
  }
  
  private View a(View paramView, QzoneFeedItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558928, null);
      paramHolder.jdField_b_of_type_AndroidViewView = paramView;
      paramHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362505);
      paramHolder.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362496);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362516));
      paramHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362509));
      paramHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362519));
      paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362514));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramHolder.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramHolder.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i1;
    do
    {
      return null;
      i1 = paramString.indexOf("http");
    } while (i1 < 0);
    paramString = paramString.substring(i1);
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
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.l;
    localURLDrawableOptions.mRequestHeight = this.m;
    paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(0);
    paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F });
    paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setAlpha(0.08F);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder, int paramInt)
  {
    if (paramHolder.jdField_e_of_type_AndroidViewView == null)
    {
      paramHolder.jdField_e_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362508)).inflate();
      paramHolder.k = ((TextView)paramHolder.jdField_e_of_type_AndroidViewView.findViewById(2131362506));
    }
    paramHolder.jdField_e_of_type_AndroidViewView.setOnClickListener(new QzoneFeedItemBuilder.2(this));
    paramHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramHolder.jdField_f_of_type_AndroidViewView != null) {
      paramHolder.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    String str = "TA";
    if (paramInt == 1) {
      str = HardCodeUtil.a(2131711790);
    }
    for (;;)
    {
      if (paramHolder.k != null) {
        paramHolder.k.setText(HardCodeUtil.a(2131711803) + str + HardCodeUtil.a(2131711819));
      }
      paramHolder = new QZoneClickReport.ReportInfo();
      paramHolder.actionType = "330";
      paramHolder.subactionType = "3";
      paramHolder.reserves = "1";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramHolder);
      return;
      if (paramInt == 2) {
        str = HardCodeUtil.a(2131711801);
      }
    }
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    boolean bool2 = false;
    String str2;
    Object localObject;
    CharSequence localCharSequence;
    switch (a(paramMessageForQzoneFeed))
    {
    default: 
      str2 = Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.i);
      localObject = str2 + paramMessageForQzoneFeed.summery;
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localCharSequence = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 7, paramMessageForQzoneFeed.feedTime * 1000L);
      if (paramMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        a(paramHolder, paramMessageForQzoneFeed.gender);
      }
      break;
    }
    for (;;)
    {
      if (jdField_e_of_type_Boolean)
      {
        paramHolder.jdField_b_of_type_JavaLangStringBuilder.append(str2);
        if (paramMessageForQzoneFeed.feedTime > 0L) {
          paramHolder.jdField_b_of_type_JavaLangStringBuilder.append("于").append(localCharSequence);
        }
        paramHolder.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageForQzoneFeed.summery).append("内容是：").append(paramMessageForQzoneFeed.title).append(paramMessageForQzoneFeed.content);
        paramHolder.jdField_b_of_type_AndroidViewView.setContentDescription(paramHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return;
      b(paramHolder, paramMessageForQzoneFeed);
      break;
      c(paramHolder, paramMessageForQzoneFeed);
      break;
      e(paramHolder, paramMessageForQzoneFeed);
      break;
      d(paramHolder, paramMessageForQzoneFeed);
      break;
      String str1 = "";
      boolean bool1 = bool2;
      if (paramMessageForQzoneFeed.mapExt != null)
      {
        bool1 = bool2;
        if (paramMessageForQzoneFeed.mapExt.containsKey("isliked")) {
          bool1 = "1".equals(paramMessageForQzoneFeed.mapExt.get("isliked"));
        }
      }
      localObject = str1;
      if (paramMessageForQzoneFeed.mapExt != null)
      {
        localObject = str1;
        if (paramMessageForQzoneFeed.mapExt.containsKey("likekey")) {
          localObject = (String)paramMessageForQzoneFeed.mapExt.get("likekey");
        }
      }
      a(paramHolder, localCharSequence, paramMessageForQzoneFeed, paramMessageForQzoneFeed.ulikeNum, paramMessageForQzoneFeed.uCommentNum, paramMessageForQzoneFeed.appId, bool1, (String)localObject);
    }
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder, CharSequence paramCharSequence, MessageForQzoneFeed paramMessageForQzoneFeed, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramHolder.jdField_f_of_type_AndroidViewView == null)
    {
      paramHolder.jdField_f_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362502)).inflate();
      paramHolder.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_f_of_type_AndroidViewView.findViewById(2131362521));
      paramHolder.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_f_of_type_AndroidViewView.findViewById(2131362518));
      paramHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramHolder.jdField_f_of_type_AndroidViewView.findViewById(2131362517));
      paramHolder.j = ((TextView)paramHolder.jdField_f_of_type_AndroidViewView.findViewById(2131362504));
    }
    paramHolder.jdField_h_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    paramHolder.jdField_i_of_type_AndroidWidgetTextView.setText(b(paramInt1));
    paramCharSequence = paramHolder.jdField_d_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i1 = 2130847887;; i1 = 2130847886)
    {
      paramCharSequence.setImageResource(i1);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new QzoneFeedItemBuilder.3(this, paramBoolean, paramInt1, paramHolder, paramString, paramInt2, paramMessageForQzoneFeed));
      paramHolder.j.setText(b(paramLong));
      paramHolder.jdField_f_of_type_AndroidViewView.setVisibility(0);
      if (paramHolder.jdField_e_of_type_AndroidViewView != null) {
        paramHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      return;
    }
  }
  
  private static void a(CornerImageView paramCornerImageView, View paramView, MessageForQzoneFeed.MediaData paramMediaData, URLDrawable.URLDrawableOptions paramURLDrawableOptions, float[] paramArrayOfFloat)
  {
    if (paramMediaData.uType == 1) {
      paramView.setVisibility(0);
    }
    for (;;)
    {
      paramCornerImageView.setRadius(paramArrayOfFloat);
      paramView = a(paramMediaData.strImgUrl);
      if (!TextUtils.isEmpty(paramView)) {
        paramCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramURLDrawableOptions));
      }
      return;
      paramView.setVisibility(8);
    }
  }
  
  private static String b(long paramLong)
  {
    if (paramLong > 100000000L) {
      return String.format("%.1f亿", new Object[] { Float.valueOf((float)paramLong / 1.0E+008F) });
    }
    if (paramLong > 10000L) {
      return String.format("%.1f万", new Object[] { Float.valueOf((float)paramLong / 10000.0F) });
    }
    return String.format("%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  private void b(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramHolder.jdField_h_of_type_AndroidViewView != null) {
      paramHolder.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramHolder.jdField_i_of_type_AndroidViewView != null) {
      paramHolder.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramHolder.jdField_g_of_type_AndroidViewView == null)
    {
      paramHolder.jdField_g_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362520)).inflate();
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362510));
      paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362492));
    }
    paramHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838352);
    paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramHolder.jdField_g_of_type_AndroidViewView.setVisibility(0);
    MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.strImgUrl);
    }
    if (paramMessageForQzoneFeed.appId == 2)
    {
      paramMessageForQzoneFeed = a(paramMessageForQzoneFeed.title, this.k);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed);
    }
    for (;;)
    {
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.jdField_a_of_type_Int;
      paramMessageForQzoneFeed.mRequestHeight = this.c;
      a(paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramHolder.jdField_a_of_type_AndroidWidgetImageView, localMediaData, paramMessageForQzoneFeed, new float[] { this.h, this.h, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
    }
  }
  
  private void c(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() < 2)) {
      return;
    }
    paramHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramHolder.jdField_g_of_type_AndroidViewView != null) {
      paramHolder.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramHolder.jdField_i_of_type_AndroidViewView != null) {
      paramHolder.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramHolder.jdField_h_of_type_AndroidViewView == null)
    {
      paramHolder.jdField_h_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362515)).inflate();
      paramHolder.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362511));
      paramHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362522));
      paramHolder.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362512));
      paramHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362513));
      paramHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362488));
    }
    paramHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838352);
    paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramHolder.jdField_h_of_type_AndroidViewView.setVisibility(0);
    Object localObject;
    if (paramMessageForQzoneFeed.appId == 2)
    {
      localObject = a(paramMessageForQzoneFeed.title, this.k);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (paramMessageForQzoneFeed.imageCount <= 2) {
        break label468;
      }
      paramHolder.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("共 %s 个", new Object[] { b(paramMessageForQzoneFeed.imageCount) }));
    }
    for (;;)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_e_of_type_Int;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.f;
      localURLDrawableOptions.mRequestHeight = this.g;
      a(paramHolder.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramHolder.jdField_b_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0), (URLDrawable.URLDrawableOptions)localObject, new float[] { this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      a(paramHolder.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramHolder.jdField_c_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1), localURLDrawableOptions, new float[] { 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
      break;
      label468:
      paramHolder.jdField_e_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private void d(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramHolder.jdField_i_of_type_AndroidViewView == null)
    {
      paramHolder.jdField_i_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362499)).inflate();
      paramHolder.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362500));
      paramHolder.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362498));
    }
    paramHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838354);
    a(paramHolder);
    paramHolder.jdField_i_of_type_AndroidViewView.setVisibility(0);
    String str = a(paramMessageForQzoneFeed.title, this.j);
    paramHolder.jdField_f_of_type_AndroidWidgetTextView.setText(str);
    paramHolder.jdField_g_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  private void e(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (paramHolder.jdField_i_of_type_AndroidViewView != null) {
      paramHolder.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838354);
    a(paramHolder);
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (QzoneFeedItemBuilder.Holder)paramViewHolder;
    paramViewHolder = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramMessageRecord.jdField_b_of_type_JavaLangString = null;
    paramLinearLayout.coverImageUrl = a(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.jdField_c_of_type_AndroidViewView.setOnClickListener(new QzoneFeedItemBuilder.1(this, paramLinearLayout));
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
        break label280;
      }
      paramMessageRecord = "1";
    }
    for (;;)
    {
      paramView = new QZoneClickReport.ReportInfo();
      paramView.actionType = "330";
      paramView.subactionType = "1";
      paramView.reserves = paramMessageRecord;
      if (paramLinearLayout.isFirstMsgWithNewFriend) {
        paramView.reserves10 = "1";
      }
      paramView.reservesExt = new ArrayList();
      paramView.reservesExt.add(paramLinearLayout.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
      return paramViewHolder;
      label280:
      if (paramMessageRecord.equals("311")) {
        paramMessageRecord = "2";
      } else if (paramMessageRecord.equals("2")) {
        paramMessageRecord = "3";
      } else {
        paramMessageRecord = "4";
      }
    }
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new QzoneFeedItemBuilder.Holder(this);
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
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, paramString);
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