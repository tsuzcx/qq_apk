package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.medalwall.ShareHelper;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import vgv;
import vgx;
import vgy;
import vgz;

public class MedalNewsItemBuilder
  extends AbstractChatItemBuilder
{
  int jdField_a_of_type_Int = 0;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  int b;
  int c = Color.rgb(26, 144, 240);
  int d = Color.argb(80, 26, 144, 240);
  
  public MedalNewsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131559448));
    this.jdField_b_of_type_Int = ((int)paramContext.getResources().getDimension(2131559465));
    paramQQAppInterface = new int[] { 16842919 };
    paramBaseAdapter = new int[0];
    int i = this.d;
    int j = this.c;
    this.jdField_a_of_type_AndroidContentResColorStateList = new ColorStateList(new int[][] { paramQQAppInterface, paramBaseAdapter }, new int[] { i, j });
  }
  
  public static int a(String paramString)
  {
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      int k = paramString.codePointAt(j);
      if ((k >= 32) && (k <= 126)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (k >= 65535)
        {
          i += 2;
          j += 1;
        }
        else
        {
          i += 2;
        }
      }
    }
    return i;
  }
  
  private View a(View paramView, vgz paramvgz)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968754, null);
      paramvgz.c = ((TextView)paramView.findViewById(2131362759));
      paramvgz.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362724));
      paramvgz.d = ((TextView)paramView.findViewById(2131363598));
      paramvgz.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363397));
      paramvgz.e = ((TextView)paramView.findViewById(2131362733));
      paramvgz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363422));
      paramvgz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363596));
    }
    try
    {
      paramvgz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageResource(2130842757);
      paramvgz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(AIOUtils.a(3.0F, paramvgz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getResources()));
      paramvgz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      Object localObject = paramvgz.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      localView = localObject[0];
      localObject = localObject[2];
      localView.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      localView = paramView;
      if (jdField_b_of_type_Boolean)
      {
        paramvgz.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
      if (jdField_b_of_type_Boolean)
      {
        localView.setContentDescription(null);
        paramvgz.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramvgz.jdField_b_of_type_JavaLangStringBuilder.length(), "");
        paramvgz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setContentDescription(null);
      }
      return localView;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        try
        {
          System.gc();
          paramvgz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageResource(2130842757);
        }
        catch (Throwable localThrowable) {}
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      int k;
      if (j < paramString.length())
      {
        k = paramString.codePointAt(j);
        if ((k < 32) || (k > 126)) {
          break label90;
        }
        i += 1;
      }
      for (;;)
      {
        if (i <= paramInt) {
          localStringBuilder.appendCodePoint(k);
        }
        if (i < paramInt) {
          break;
        }
        if (localStringBuilder.length() < paramString.length()) {
          localStringBuilder.append("...");
        }
        return localStringBuilder.toString();
        label90:
        if (k >= 65535)
        {
          i += 1;
          j += 1;
        }
        else
        {
          i += 2;
        }
      }
      j += 1;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      a(Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1), paramString1);
    }
    String str;
    do
    {
      return;
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
      paramString1 = NearbyURLSafeUtil.a(paramString1);
      paramString2 = ShareHelper.a(new String[] { paramInt2 + "", paramInt1 + "", paramString1, str });
      localObject = (MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
    } while (localObject == null);
    Object localObject = new StringBuilder(((MedalWallMng)localObject).a());
    ((StringBuilder)localObject).append("&uincode=").append(paramString1);
    ((StringBuilder)localObject).append("&id=").append(paramInt2);
    ((StringBuilder)localObject).append("&level=").append(paramInt1);
    ((StringBuilder)localObject).append("&nick=").append(URLEncoder.encode(str));
    ((StringBuilder)localObject).append("&en=").append(paramString2);
    ((StringBuilder)localObject).append("&fromId=").append(1);
    if (paramInt2 == 0) {
      paramString2 = "0";
    }
    for (;;)
    {
      try
      {
        paramString1 = ShareHelper.a(Long.valueOf(1000L * paramLong1)).substring(0, 4);
        ((StringBuilder)localObject).append("&year=").append(paramString1);
        ((StringBuilder)localObject).append("&seq=").append(paramLong2);
        if (QLog.isColorLevel()) {
          QLog.i("MedalNewsItemBuilder", 4, "goto medal share:" + ((StringBuilder)localObject).toString());
        }
        paramString1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramString1.putExtra("url", ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramString1);
        return;
      }
      catch (Exception localException)
      {
        paramString1 = paramString2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ShareHelper", 2, localException.getMessage(), localException);
        paramString1 = paramString2;
        continue;
      }
      ((StringBuilder)localObject).append("&time=").append(paramLong1);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    MedalWallMng localMedalWallMng = (MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    if (paramBoolean) {}
    for (int i = MedalWallMng.f;; i = MedalWallMng.e)
    {
      localIntent.putExtra("url", localMedalWallMng.a(paramBoolean, paramString, i));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (paramBoolean) {
        ThreadManager.post(new vgy(this), 0, null, false);
      }
      return;
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = (MessageForMedalNews)paramMessageRecord;
    paramLinearLayout = (vgz)paramViewHolder;
    paramView = a(paramView, paramLinearLayout);
    paramLinearLayout.jdField_a_of_type_Long = paramOnLongClickAndTouchListener.uniseq;
    paramLinearLayout.jdField_a_of_type_JavaLangString = paramOnLongClickAndTouchListener.frienduin;
    int n = paramOnLongClickAndTouchListener.level;
    paramMessageRecord = paramOnLongClickAndTouchListener.name;
    paramViewHolder = paramOnLongClickAndTouchListener.desc;
    String str = paramOnLongClickAndTouchListener.icon;
    int i = 1;
    int k = 1;
    int m = 1;
    Object localObject = paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getTag();
    int j = i;
    if (localObject != null)
    {
      j = i;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        j = i;
        if (paramLinearLayout.jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject)) {
          j = 0;
        }
      }
    }
    localObject = paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.getTag();
    i = k;
    if (localObject != null)
    {
      i = k;
      if ((localObject instanceof Integer))
      {
        i = k;
        if (n == ((Integer)localObject).intValue()) {
          i = 0;
        }
      }
    }
    localObject = paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView.getTag();
    k = m;
    if (localObject != null)
    {
      k = m;
      if ((localObject instanceof String))
      {
        k = m;
        if (str.equalsIgnoreCase((String)localObject)) {
          k = 0;
        }
      }
    }
    if (j != 0)
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131439148, new Object[] { localObject });
      if (!paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getText().equals(localObject)) {
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setTag(paramLinearLayout.jdField_a_of_type_JavaLangString);
    }
    if (!paramLinearLayout.c.getText().equals(paramMessageRecord))
    {
      paramLinearLayout.c.setText(paramMessageRecord);
      j = a(paramMessageRecord);
      if ((j & 0x1) == 0)
      {
        j /= 2;
        if (j > 5) {
          break label870;
        }
        paramLinearLayout.c.setTextSize(1, 20.0F);
      }
    }
    else
    {
      label378:
      if (!paramLinearLayout.d.getText().equals(paramViewHolder)) {
        paramLinearLayout.d.setText(paramViewHolder);
      }
      if (k != 0) {
        paramMessageRecord = null;
      }
    }
    label431:
    label870:
    try
    {
      paramViewHolder = URLDrawable.getDrawable(str, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, URLDrawableHelper.a, URLDrawableHelper.a);
      paramMessageRecord = paramViewHolder;
    }
    catch (Exception paramViewHolder)
    {
      label628:
      break label431;
    }
    localObject = paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView;
    paramViewHolder = paramMessageRecord;
    if (paramMessageRecord == null) {
      paramViewHolder = URLDrawableHelper.a;
    }
    ((URLImageView)localObject).setImageDrawable(paramViewHolder);
    paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView.setTag(str);
    if (i != 0) {}
    switch (n)
    {
    default: 
      j = 2130842769;
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493410);
      label512:
      this.jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN);
      paramViewHolder = paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      paramMessageRecord = paramViewHolder[0];
      paramViewHolder = paramViewHolder[2];
      paramMessageRecord.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramViewHolder.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
      paramLinearLayout.c.setTextColor(i);
      paramLinearLayout.d.setTextColor(i);
      if (n <= 3)
      {
        paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
        paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(n));
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(paramLinearLayout);
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setOnClickListener(new vgv(this, paramOnLongClickAndTouchListener));
        if (paramOnLongClickAndTouchListener.myLevel != 0) {
          break label944;
        }
      }
      break;
    }
    label944:
    for (i = 0;; i = 8)
    {
      if (paramLinearLayout.e.getVisibility() != i) {
        paramLinearLayout.e.setVisibility(i);
      }
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131439149);
      if (!paramMessageRecord.equalsIgnoreCase(paramLinearLayout.e.getText().toString()))
      {
        paramMessageRecord = new SpannableString(paramMessageRecord);
        paramMessageRecord.setSpan(new DatingCommentTextView.TouchableSpan(new vgx(this), this.jdField_a_of_type_AndroidContentResColorStateList), 11, 14, 33);
        paramLinearLayout.e.setText(paramMessageRecord);
        paramLinearLayout.e.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (jdField_b_of_type_Boolean)
      {
        paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.append(paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getText()).append(paramLinearLayout.c.getText());
        paramView.setContentDescription(paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.toString());
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setContentDescription(paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return paramView;
      j = j / 2 + 1;
      break;
      paramLinearLayout.c.setTextSize(1, 15.0F);
      break label378;
      j = 2130842767;
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493412);
      break label512;
      j = 2130842768;
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493411);
      break label512;
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label628;
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new vgz(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder
 * JD-Core Version:    0.7.0.1
 */