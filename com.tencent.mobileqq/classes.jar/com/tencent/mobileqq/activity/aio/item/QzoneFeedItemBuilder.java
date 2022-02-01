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
  private final int b;
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
    this.jdField_a_of_type_Int = AIOUtils.b(251.0F, paramBaseAdapter);
    this.b = AIOUtils.b(131.0F, paramBaseAdapter);
    this.d = AIOUtils.b(128.5F, paramBaseAdapter);
    this.jdField_e_of_type_Int = AIOUtils.b(131.0F, paramBaseAdapter);
    this.f = AIOUtils.b(122.5F, paramBaseAdapter);
    this.g = AIOUtils.b(131.0F, paramBaseAdapter);
    this.h = AIOUtils.b(16.0F, paramBaseAdapter);
    this.l = AIOUtils.b(71.5F, paramBaseAdapter);
    this.m = AIOUtils.b(74.0F, paramBaseAdapter);
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
    if (paramMessageForQzoneFeed.mediaDatas != null)
    {
      int i2 = paramMessageForQzoneFeed.mediaDatas.size();
      int i1 = 1;
      if (i2 > 1) {
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558826, null);
      paramHolder.jdField_b_of_type_AndroidViewView = paramView;
      paramHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362461);
      paramHolder.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362452);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362472));
      paramHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362465));
      paramHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362475));
      paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362470));
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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i1 = paramString.indexOf("http");
    if (i1 < 0) {
      return null;
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("《");
    localStringBuilder.append(paramString);
    localStringBuilder.append("》");
    return localStringBuilder.toString();
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.l;
    localURLDrawableOptions.mRequestHeight = this.m;
    paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(0);
    CornerImageView localCornerImageView = paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
    int i1 = this.h;
    localCornerImageView.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, i1, i1, 0.0F, 0.0F });
    paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setAlpha(0.08F);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder, int paramInt)
  {
    if (paramHolder.jdField_e_of_type_AndroidViewView == null)
    {
      paramHolder.jdField_e_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362464)).inflate();
      paramHolder.k = ((TextView)paramHolder.jdField_e_of_type_AndroidViewView.findViewById(2131362462));
    }
    paramHolder.jdField_e_of_type_AndroidViewView.setOnClickListener(new QzoneFeedItemBuilder.2(this));
    paramHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramHolder.jdField_f_of_type_AndroidViewView != null) {
      paramHolder.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    String str;
    if (paramInt == 1) {
      str = HardCodeUtil.a(2131711765);
    } else if (paramInt == 2) {
      str = HardCodeUtil.a(2131711776);
    } else {
      str = "TA";
    }
    if (paramHolder.k != null)
    {
      paramHolder = paramHolder.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131711778));
      localStringBuilder.append(str);
      localStringBuilder.append(HardCodeUtil.a(2131711794));
      paramHolder.setText(localStringBuilder.toString());
    }
    paramHolder = new QZoneClickReport.ReportInfo();
    paramHolder.actionType = "330";
    paramHolder.subactionType = "3";
    paramHolder.reserves = "1";
    QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramHolder);
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    int i1 = a(paramMessageForQzoneFeed);
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 == 4) {
            d(paramHolder, paramMessageForQzoneFeed);
          }
        }
        else {
          e(paramHolder, paramMessageForQzoneFeed);
        }
      }
      else {
        c(paramHolder, paramMessageForQzoneFeed);
      }
    }
    else {
      b(paramHolder, paramMessageForQzoneFeed);
    }
    String str = Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.i);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramMessageForQzoneFeed.summery);
    localObject = ((StringBuilder)localObject).toString();
    paramHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    paramHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    CharSequence localCharSequence = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 7, paramMessageForQzoneFeed.feedTime * 1000L);
    if (paramMessageForQzoneFeed.isFirstMsgWithNewFriend)
    {
      a(paramHolder, paramMessageForQzoneFeed.gender);
    }
    else
    {
      boolean bool;
      if ((paramMessageForQzoneFeed.mapExt != null) && (paramMessageForQzoneFeed.mapExt.containsKey("isliked"))) {
        bool = "1".equals(paramMessageForQzoneFeed.mapExt.get("isliked"));
      } else {
        bool = false;
      }
      if ((paramMessageForQzoneFeed.mapExt != null) && (paramMessageForQzoneFeed.mapExt.containsKey("likekey"))) {
        localObject = (String)paramMessageForQzoneFeed.mapExt.get("likekey");
      } else {
        localObject = "";
      }
      a(paramHolder, localCharSequence, paramMessageForQzoneFeed, paramMessageForQzoneFeed.ulikeNum, paramMessageForQzoneFeed.uCommentNum, paramMessageForQzoneFeed.appId, bool, (String)localObject);
    }
    if (jdField_e_of_type_Boolean)
    {
      paramHolder.jdField_b_of_type_JavaLangStringBuilder.append(str);
      if (paramMessageForQzoneFeed.feedTime > 0L)
      {
        localObject = paramHolder.jdField_b_of_type_JavaLangStringBuilder;
        ((StringBuilder)localObject).append("于");
        ((StringBuilder)localObject).append(localCharSequence);
      }
      localObject = paramHolder.jdField_b_of_type_JavaLangStringBuilder;
      ((StringBuilder)localObject).append(paramMessageForQzoneFeed.summery);
      ((StringBuilder)localObject).append("内容是：");
      ((StringBuilder)localObject).append(paramMessageForQzoneFeed.title);
      ((StringBuilder)localObject).append(paramMessageForQzoneFeed.content);
      paramHolder.jdField_b_of_type_AndroidViewView.setContentDescription(paramHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  private void a(QzoneFeedItemBuilder.Holder paramHolder, CharSequence paramCharSequence, MessageForQzoneFeed paramMessageForQzoneFeed, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramHolder.jdField_f_of_type_AndroidViewView == null)
    {
      paramHolder.jdField_f_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362458)).inflate();
      paramHolder.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_f_of_type_AndroidViewView.findViewById(2131362477));
      paramHolder.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_f_of_type_AndroidViewView.findViewById(2131362474));
      paramHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramHolder.jdField_f_of_type_AndroidViewView.findViewById(2131362473));
      paramHolder.j = ((TextView)paramHolder.jdField_f_of_type_AndroidViewView.findViewById(2131362460));
    }
    paramHolder.jdField_h_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    paramHolder.jdField_i_of_type_AndroidWidgetTextView.setText(b(paramInt1));
    paramCharSequence = paramHolder.jdField_d_of_type_AndroidWidgetImageView;
    int i1;
    if (paramBoolean) {
      i1 = 2130847755;
    } else {
      i1 = 2130847754;
    }
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
  }
  
  private static void a(CornerImageView paramCornerImageView, View paramView, MessageForQzoneFeed.MediaData paramMediaData, URLDrawable.URLDrawableOptions paramURLDrawableOptions, float[] paramArrayOfFloat)
  {
    if (paramMediaData.uType == 1) {
      paramView.setVisibility(0);
    } else {
      paramView.setVisibility(8);
    }
    paramCornerImageView.setRadius(paramArrayOfFloat);
    paramView = a(paramMediaData.strImgUrl);
    if (!TextUtils.isEmpty(paramView)) {
      paramCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramURLDrawableOptions));
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
    if (paramMessageForQzoneFeed.mediaDatas != null)
    {
      if (paramMessageForQzoneFeed.mediaDatas.size() == 0) {
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
        paramHolder.jdField_g_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362476)).inflate();
        paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362466));
        paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362448));
      }
      paramHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838181);
      paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
      paramHolder.jdField_g_of_type_AndroidViewView.setVisibility(0);
      MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDataToSinglePicContainer picUrl= ");
        ((StringBuilder)localObject).append(localMediaData.strImgUrl);
        QLog.d("QzoneFeedItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      if (paramMessageForQzoneFeed.appId == 2)
      {
        paramMessageForQzoneFeed = a(paramMessageForQzoneFeed.title, this.k);
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed);
      }
      else
      {
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
      }
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.jdField_a_of_type_Int;
      paramMessageForQzoneFeed.mRequestHeight = this.b;
      Object localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
      paramHolder = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      int i1 = this.h;
      a((CornerImageView)localObject, paramHolder, localMediaData, paramMessageForQzoneFeed, new float[] { i1, i1, i1, i1, 0.0F, 0.0F, 0.0F, 0.0F });
    }
  }
  
  private void c(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if (paramMessageForQzoneFeed.mediaDatas != null)
    {
      if (paramMessageForQzoneFeed.mediaDatas.size() < 2) {
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
        paramHolder.jdField_h_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362471)).inflate();
        paramHolder.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362467));
        paramHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362478));
        paramHolder.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362468));
        paramHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362469));
        paramHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362444));
      }
      paramHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838181);
      paramHolder.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
      paramHolder.jdField_h_of_type_AndroidViewView.setVisibility(0);
      if (paramMessageForQzoneFeed.appId == 2)
      {
        localObject1 = a(paramMessageForQzoneFeed.title, this.k);
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      else
      {
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
      }
      if (paramMessageForQzoneFeed.imageCount > 2) {
        paramHolder.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("共 %s 个", new Object[] { b(paramMessageForQzoneFeed.imageCount) }));
      } else {
        paramHolder.jdField_e_of_type_AndroidWidgetTextView.setText("");
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.d;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_e_of_type_Int;
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.f;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.g;
      CornerImageView localCornerImageView = paramHolder.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
      ImageView localImageView = paramHolder.jdField_b_of_type_AndroidWidgetImageView;
      MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
      int i1 = this.h;
      a(localCornerImageView, localImageView, localMediaData, (URLDrawable.URLDrawableOptions)localObject2, new float[] { i1, i1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      localObject2 = paramHolder.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
      paramHolder = paramHolder.jdField_c_of_type_AndroidWidgetImageView;
      paramMessageForQzoneFeed = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1);
      i1 = this.h;
      a((CornerImageView)localObject2, paramHolder, paramMessageForQzoneFeed, (URLDrawable.URLDrawableOptions)localObject1, new float[] { 0.0F, 0.0F, i1, i1, 0.0F, 0.0F, 0.0F, 0.0F });
    }
  }
  
  private void d(QzoneFeedItemBuilder.Holder paramHolder, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramHolder.jdField_i_of_type_AndroidViewView == null)
    {
      paramHolder.jdField_i_of_type_AndroidViewView = ((ViewStub)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362455)).inflate();
      paramHolder.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362456));
      paramHolder.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramHolder.jdField_b_of_type_AndroidViewView.findViewById(2131362454));
    }
    paramHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838183);
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
    paramHolder.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838183);
    a(paramHolder);
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel())
    {
      paramLinearLayout = new StringBuilder();
      paramLinearLayout.append("getItemView: invoked. info: message = ");
      paramLinearLayout.append(paramMessageRecord);
      QLog.i("QzoneFeedItemBuilder", 2, paramLinearLayout.toString());
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (QzoneFeedItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramViewHolder = null;
    paramMessageRecord.jdField_b_of_type_JavaLangString = null;
    paramLinearLayout.coverImageUrl = a(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.jdField_c_of_type_AndroidViewView.setOnClickListener(new QzoneFeedItemBuilder.1(this, paramLinearLayout));
    if (!paramLinearLayout.hasExposed)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
      paramLinearLayout.hasExposed = true;
    }
    paramMessageRecord = URLUtil.a(paramLinearLayout.actionUrl);
    if (paramMessageRecord != null) {
      paramViewHolder = (String)paramMessageRecord.get("a");
    }
    if (paramViewHolder != null)
    {
      paramMessageRecord = "4";
      if (paramViewHolder.equals("4")) {
        paramMessageRecord = "1";
      } else if (paramViewHolder.equals("311")) {
        paramMessageRecord = "2";
      } else if (paramViewHolder.equals("2")) {
        paramMessageRecord = "3";
      }
      paramViewHolder = new QZoneClickReport.ReportInfo();
      paramViewHolder.actionType = "330";
      paramViewHolder.subactionType = "1";
      paramViewHolder.reserves = paramMessageRecord;
      if (paramLinearLayout.isFirstMsgWithNewFriend) {
        paramViewHolder.reserves10 = "1";
      }
      paramViewHolder.reservesExt = new ArrayList();
      paramViewHolder.reservesExt.add(paramLinearLayout.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramViewHolder);
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new QzoneFeedItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("fromAio", true);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, paramString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QzoneFeedItemBuilder
 * JD-Core Version:    0.7.0.1
 */