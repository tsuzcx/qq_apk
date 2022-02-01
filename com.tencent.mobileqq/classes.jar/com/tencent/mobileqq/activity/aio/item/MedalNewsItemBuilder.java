package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.medalwall.ShareHelper;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import org.jetbrains.annotations.Nullable;

public class MedalNewsItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  int b = 0;
  int d = -12541697;
  int e;
  
  public MedalNewsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_e_of_type_Int = -2143248129;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131298193));
    this.b = ((int)paramContext.getResources().getDimension(2131298358));
    paramBaseAdapter = new int[0];
    int i = this.jdField_e_of_type_Int;
    int j = this.d;
    this.jdField_a_of_type_AndroidContentResColorStateList = new ColorStateList(new int[][] { { 16842919 }, paramBaseAdapter }, new int[] { i, j });
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 4);
    }
  }
  
  public static int a(String paramString)
  {
    int j = 0;
    int i = 0;
    while (j < paramString.length())
    {
      int k = paramString.codePointAt(j);
      if ((k >= 32) && (k <= 126))
      {
        i += 1;
      }
      else if (k >= 65535)
      {
        i += 2;
        j += 1;
      }
      else
      {
        i += 2;
      }
      j += 1;
    }
    return i;
  }
  
  private View a(View paramView, MedalNewsItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558808, null);
      paramHolder.c = ((TextView)paramView.findViewById(2131371697));
      paramHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368343));
      paramHolder.d = ((TextView)paramView.findViewById(2131365517));
      paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378784));
      paramHolder.e = ((TextView)paramView.findViewById(2131378745));
      paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365257));
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131365258));
    }
    try
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageResource(2130845563);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label123:
      Object localObject;
      label138:
      break label123;
    }
    try
    {
      System.gc();
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageResource(2130845563);
    }
    catch (Throwable localThrowable)
    {
      break label138;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(AIOUtils.b(3.0F, paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getResources()));
    paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
    localObject = paramHolder.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
    localView = localObject[0];
    localObject = localObject[2];
    localView.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
    ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
    localView = paramView;
    if (jdField_e_of_type_Boolean)
    {
      paramHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
      localView = paramView;
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramHolder.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramHolder.jdField_b_of_type_JavaLangStringBuilder.length(), "");
      paramHolder.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setContentDescription(null);
    }
    return localView;
  }
  
  @Nullable
  private URLDrawable a(String paramString)
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.b;
      localURLDrawableOptions.mRequestHeight = this.b;
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      return paramString;
    }
    catch (Exception paramString)
    {
      label42:
      break label42;
    }
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    int i = 0;
    while (j < paramString.length())
    {
      int k = paramString.codePointAt(j);
      if ((k >= 32) && (k <= 126))
      {
        i += 1;
      }
      else if (k >= 65535)
      {
        i += 1;
        j += 1;
      }
      else
      {
        i += 2;
      }
      if (i <= paramInt) {
        localStringBuilder.appendCodePoint(k);
      }
      if (i >= paramInt) {
        break;
      }
      j += 1;
    }
    if (localStringBuilder.length() < paramString.length()) {
      localStringBuilder.append("...");
    }
    return localStringBuilder.toString();
  }
  
  private void a(MedalNewsItemBuilder.Holder paramHolder)
  {
    int i;
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForMedalNews.myLevel == 0) {
      i = 0;
    } else {
      i = 8;
    }
    if (paramHolder.e.getVisibility() != i) {
      paramHolder.e.setVisibility(i);
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699010);
    if (!((String)localObject).equalsIgnoreCase(paramHolder.e.getText().toString()))
    {
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new DatingCommentTextView.TouchableSpan(new MedalNewsItemBuilder.1(this), this.jdField_a_of_type_AndroidContentResColorStateList), 11, 14, 33);
      paramHolder.e.setText((CharSequence)localObject);
      paramHolder.e.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  private void a(MedalNewsItemBuilder.Holder paramHolder, int paramInt)
  {
    int i;
    int j;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        i = 2130845575;
        j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166442);
      }
      else
      {
        i = 2130845574;
        j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166444);
      }
    }
    else
    {
      i = 2130845573;
      j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166440);
    }
    this.jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(j, PorterDuff.Mode.SRC_IN);
    Object localObject2 = paramHolder.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
    Object localObject1 = localObject2[0];
    localObject2 = localObject2[2];
    localObject1.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
    ((Drawable)localObject2).setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
    paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(j);
    paramHolder.c.setTextColor(j);
    paramHolder.d.setTextColor(j);
    if (paramInt <= 3)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    else
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if ((paramLong1 != 0L) && (paramLong2 != 0L))
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
      paramString1 = NearbyURLSafeUtil.a(paramString1);
      paramString2 = new StringBuilder();
      paramString2.append(paramInt2);
      paramString2.append("");
      paramString2 = paramString2.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("");
      localObject = ShareHelper.a(new String[] { paramString2, ((StringBuilder)localObject).toString(), paramString1, str });
      paramString2 = (MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG);
      if (paramString2 == null) {
        return;
      }
      paramString2 = new StringBuilder(paramString2.a());
      paramString2.append("&uincode=");
      paramString2.append(paramString1);
      paramString2.append("&id=");
      paramString2.append(paramInt2);
      paramString2.append("&level=");
      paramString2.append(paramInt1);
      paramString2.append("&nick=");
      paramString2.append(URLEncoder.encode(str));
      paramString2.append("&en=");
      paramString2.append((String)localObject);
      paramString2.append("&fromId=");
      paramString2.append(1);
      if (paramInt2 == 0)
      {
        try
        {
          paramString1 = ShareHelper.a(Long.valueOf(paramLong1 * 1000L)).substring(0, 4);
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShareHelper", 2, paramString1.getMessage(), paramString1);
          }
          paramString1 = "0";
        }
        paramString2.append("&year=");
        paramString2.append(paramString1);
        paramString2.append("&seq=");
        paramString2.append(paramLong2);
      }
      else
      {
        paramString2.append("&time=");
        paramString2.append(paramLong1);
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("goto medal share:");
        paramString1.append(paramString2.toString());
        QLog.i("MedalNewsItemBuilder", 4, paramString1.toString());
      }
      paramString1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramString1.putExtra("url", paramString2.toString());
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString1);
      return;
    }
    a(Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1), paramString1);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    MedalWallMng localMedalWallMng = (MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    int i;
    if (paramBoolean) {
      i = MedalWallMng.f;
    } else {
      i = MedalWallMng.jdField_e_of_type_Int;
    }
    localIntent.putExtra("url", localMedalWallMng.a(paramBoolean, paramString, i));
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (paramBoolean) {
      ThreadManager.post(new MedalNewsItemBuilder.3(this), 0, null, false);
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = (MessageForMedalNews)paramMessageRecord;
    paramLinearLayout = (MedalNewsItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramLinearLayout);
    paramLinearLayout.jdField_a_of_type_Long = paramOnLongClickAndTouchListener.uniseq;
    paramLinearLayout.jdField_a_of_type_JavaLangString = paramOnLongClickAndTouchListener.frienduin;
    paramLinearLayout.jdField_a_of_type_ComTencentMobileqqDataMessageForMedalNews = paramOnLongClickAndTouchListener;
    int m = paramOnLongClickAndTouchListener.level;
    paramMessageRecord = paramOnLongClickAndTouchListener.name;
    paramViewHolder = paramOnLongClickAndTouchListener.desc;
    paramOnLongClickAndTouchListener = paramOnLongClickAndTouchListener.icon;
    Object localObject = paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getTag();
    if ((localObject != null) && ((localObject instanceof String)))
    {
      localObject = (String)localObject;
      if (paramLinearLayout.jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject))
      {
        j = 0;
        break label125;
      }
    }
    int j = 1;
    label125:
    localObject = paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.getTag();
    int i;
    if ((localObject != null) && ((localObject instanceof Integer)) && (m == ((Integer)localObject).intValue())) {
      i = 0;
    } else {
      i = 1;
    }
    localObject = paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView.getTag();
    int k;
    if ((localObject != null) && ((localObject instanceof String)) && (paramOnLongClickAndTouchListener.equalsIgnoreCase((String)localObject))) {
      k = 0;
    } else {
      k = 1;
    }
    if (j != 0)
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699009, new Object[] { localObject });
      if (!paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getText().equals(localObject)) {
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setTag(paramLinearLayout.jdField_a_of_type_JavaLangString);
    }
    if (!paramLinearLayout.c.getText().equals(paramMessageRecord))
    {
      paramLinearLayout.c.setText(paramMessageRecord);
      j = a(paramMessageRecord);
      if ((j & 0x1) == 0) {
        j /= 2;
      } else {
        j = j / 2 + 1;
      }
      if (j <= 5) {
        paramLinearLayout.c.setTextSize(1, 20.0F);
      } else {
        paramLinearLayout.c.setTextSize(1, 15.0F);
      }
    }
    if (!paramLinearLayout.d.getText().equals(paramViewHolder)) {
      paramLinearLayout.d.setText(paramViewHolder);
    }
    if (k != 0)
    {
      paramViewHolder = a(paramOnLongClickAndTouchListener);
      localObject = paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView;
      paramMessageRecord = paramViewHolder;
      if (paramViewHolder == null) {
        paramMessageRecord = URLDrawableHelperConstants.a;
      }
      ((URLImageView)localObject).setImageDrawable(paramMessageRecord);
      paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramOnLongClickAndTouchListener);
    }
    if (i != 0) {
      a(paramLinearLayout, m);
    }
    paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(paramLinearLayout);
    paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setOnClickListener(this);
    a(paramLinearLayout);
    if (jdField_e_of_type_Boolean)
    {
      paramMessageRecord = paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder;
      paramMessageRecord.append(paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramMessageRecord.append(paramLinearLayout.c.getText());
      paramView.setContentDescription(paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.toString());
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setContentDescription(paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.toString());
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new MedalNewsItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onClick(View paramView)
  {
    MedalNewsItemBuilder.Holder localHolder = (MedalNewsItemBuilder.Holder)paramView.getTag();
    if (localHolder != null)
    {
      ThreadManager.postImmediately(new MedalNewsItemBuilder.2(this, localHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForMedalNews), null, true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "4", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder
 * JD-Core Version:    0.7.0.1
 */