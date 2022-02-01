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
  int e = 0;
  int f = 0;
  int g = -12541697;
  int h = -2143248129;
  ColorStateList i;
  private ColorFilter j;
  
  public MedalNewsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.e = ((int)paramContext.getResources().getDimension(2131298892));
    this.f = ((int)paramContext.getResources().getDimension(2131299072));
    paramBaseAdapter = new int[] { 16842919 };
    paramContext = new int[0];
    int k = this.h;
    int m = this.g;
    this.i = new ColorStateList(new int[][] { paramBaseAdapter, paramContext }, new int[] { k, m });
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 4);
    }
  }
  
  public static int a(String paramString)
  {
    int m = 0;
    int k = 0;
    while (m < paramString.length())
    {
      int n = paramString.codePointAt(m);
      if ((n >= 32) && (n <= 126))
      {
        k += 1;
      }
      else if (n >= 65535)
      {
        k += 2;
        m += 1;
      }
      else
      {
        k += 2;
      }
      m += 1;
    }
    return k;
  }
  
  private View a(View paramView, MedalNewsItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624428, null);
      paramHolder.g = ((TextView)paramView.findViewById(2131439121));
      paramHolder.f = ((URLImageView)paramView.findViewById(2131435219));
      paramHolder.i = ((TextView)paramView.findViewById(2131431733));
      paramHolder.e = ((TextView)paramView.findViewById(2131447463));
      paramHolder.j = ((TextView)paramView.findViewById(2131447419));
      paramHolder.h = ((ImageView)paramView.findViewById(2131431428));
      paramHolder.d = ((CornerImageView)paramView.findViewById(2131431429));
    }
    try
    {
      paramHolder.d.setImageResource(2130847027);
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
      paramHolder.d.setImageResource(2130847027);
    }
    catch (Throwable localThrowable)
    {
      break label138;
    }
    paramHolder.d.setRadius(AIOUtils.b(3.0F, paramHolder.d.getResources()));
    paramHolder.d.setPressMask(true);
    localObject = paramHolder.e.getCompoundDrawables();
    localView = localObject[0];
    localObject = localObject[2];
    localView.setColorFilter(this.j);
    ((Drawable)localObject).setColorFilter(this.j);
    localView = paramView;
    if (v)
    {
      paramHolder.r = new StringBuilder();
      localView = paramView;
    }
    if (v)
    {
      localView.setContentDescription(null);
      paramHolder.r.replace(0, paramHolder.r.length(), "");
      paramHolder.d.setContentDescription(null);
    }
    return localView;
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    int k = 0;
    while (m < paramString.length())
    {
      int n = paramString.codePointAt(m);
      if ((n >= 32) && (n <= 126))
      {
        k += 1;
      }
      else if (n >= 65535)
      {
        k += 1;
        m += 1;
      }
      else
      {
        k += 2;
      }
      if (k <= paramInt) {
        localStringBuilder.appendCodePoint(n);
      }
      if (k >= paramInt) {
        break;
      }
      m += 1;
    }
    if (localStringBuilder.length() < paramString.length()) {
      localStringBuilder.append("...");
    }
    return localStringBuilder.toString();
  }
  
  private void a(MedalNewsItemBuilder.Holder paramHolder)
  {
    int k;
    if (paramHolder.m.myLevel == 0) {
      k = 0;
    } else {
      k = 8;
    }
    if (paramHolder.j.getVisibility() != k) {
      paramHolder.j.setVisibility(k);
    }
    Object localObject = this.c.getResources().getString(2131897014);
    if (!((String)localObject).equalsIgnoreCase(paramHolder.j.getText().toString()))
    {
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new DatingCommentTextView.TouchableSpan(new MedalNewsItemBuilder.1(this), this.i), 11, 14, 33);
      paramHolder.j.setText((CharSequence)localObject);
      paramHolder.j.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  private void a(MedalNewsItemBuilder.Holder paramHolder, int paramInt)
  {
    int k;
    int m;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        k = 2130847039;
        m = this.c.getResources().getColor(2131167284);
      }
      else
      {
        k = 2130847038;
        m = this.c.getResources().getColor(2131167286);
      }
    }
    else
    {
      k = 2130847037;
      m = this.c.getResources().getColor(2131167282);
    }
    this.j = new PorterDuffColorFilter(m, PorterDuff.Mode.SRC_IN);
    Object localObject2 = paramHolder.e.getCompoundDrawables();
    Object localObject1 = localObject2[0];
    localObject2 = localObject2[2];
    localObject1.setColorFilter(this.j);
    ((Drawable)localObject2).setColorFilter(this.j);
    paramHolder.h.setColorFilter(this.j);
    paramHolder.e.setTextColor(m);
    paramHolder.g.setTextColor(m);
    paramHolder.i.setTextColor(m);
    if (paramInt <= 3)
    {
      paramHolder.h.setImageResource(k);
      paramHolder.h.setVisibility(0);
    }
    else
    {
      paramHolder.h.setVisibility(8);
    }
    paramHolder.h.setTag(Integer.valueOf(paramInt));
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if ((paramLong1 != 0L) && (paramLong2 != 0L))
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
      paramString1 = NearbyURLSafeUtil.b(paramString1);
      paramString2 = new StringBuilder();
      paramString2.append(paramInt2);
      paramString2.append("");
      paramString2 = paramString2.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("");
      localObject = ShareHelper.a(new String[] { paramString2, ((StringBuilder)localObject).toString(), paramString1, str });
      paramString2 = (MedalWallMng)this.a.getManager(QQManagerFactory.MEDAL_WALL_MNG);
      if (paramString2 == null) {
        return;
      }
      paramString2 = new StringBuilder(paramString2.e());
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
      paramString1 = new Intent(this.c, QQBrowserActivity.class);
      paramString1.putExtra("url", paramString2.toString());
      this.c.startActivity(paramString1);
      return;
    }
    a(Utils.a(this.a.getCurrentAccountUin(), paramString1), paramString1);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    MedalWallMng localMedalWallMng = (MedalWallMng)this.a.getManager(QQManagerFactory.MEDAL_WALL_MNG);
    Intent localIntent = new Intent(this.c, QQBrowserActivity.class);
    int k;
    if (paramBoolean) {
      k = MedalWallMng.h;
    } else {
      k = MedalWallMng.g;
    }
    localIntent.putExtra("url", localMedalWallMng.a(paramBoolean, paramString, k));
    this.c.startActivity(localIntent);
    if (paramBoolean) {
      ThreadManager.post(new MedalNewsItemBuilder.3(this), 0, null, false);
    }
  }
  
  @Nullable
  private URLDrawable b(String paramString)
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.f;
      localURLDrawableOptions.mRequestHeight = this.f;
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
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = (MessageForMedalNews)paramMessageRecord;
    paramLinearLayout = (MedalNewsItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramLinearLayout);
    paramLinearLayout.k = paramOnLongClickAndTouchListener.uniseq;
    paramLinearLayout.l = paramOnLongClickAndTouchListener.frienduin;
    paramLinearLayout.m = paramOnLongClickAndTouchListener;
    int i1 = paramOnLongClickAndTouchListener.level;
    paramMessageRecord = paramOnLongClickAndTouchListener.name;
    paramViewHolder = paramOnLongClickAndTouchListener.desc;
    paramOnLongClickAndTouchListener = paramOnLongClickAndTouchListener.icon;
    Object localObject = paramLinearLayout.e.getTag();
    if ((localObject != null) && ((localObject instanceof String)))
    {
      localObject = (String)localObject;
      if (paramLinearLayout.l.equalsIgnoreCase((String)localObject))
      {
        m = 0;
        break label125;
      }
    }
    int m = 1;
    label125:
    localObject = paramLinearLayout.h.getTag();
    int k;
    if ((localObject != null) && ((localObject instanceof Integer)) && (i1 == ((Integer)localObject).intValue())) {
      k = 0;
    } else {
      k = 1;
    }
    localObject = paramLinearLayout.f.getTag();
    int n;
    if ((localObject != null) && ((localObject instanceof String)) && (paramOnLongClickAndTouchListener.equalsIgnoreCase((String)localObject))) {
      n = 0;
    } else {
      n = 1;
    }
    if (m != 0)
    {
      localObject = a(this.d.e, 6);
      localObject = this.c.getResources().getString(2131897013, new Object[] { localObject });
      if (!paramLinearLayout.e.getText().equals(localObject)) {
        paramLinearLayout.e.setText((CharSequence)localObject);
      }
      paramLinearLayout.e.setTag(paramLinearLayout.l);
    }
    if (!paramLinearLayout.g.getText().equals(paramMessageRecord))
    {
      paramLinearLayout.g.setText(paramMessageRecord);
      m = a(paramMessageRecord);
      if ((m & 0x1) == 0) {
        m /= 2;
      } else {
        m = m / 2 + 1;
      }
      if (m <= 5) {
        paramLinearLayout.g.setTextSize(1, 20.0F);
      } else {
        paramLinearLayout.g.setTextSize(1, 15.0F);
      }
    }
    if (!paramLinearLayout.i.getText().equals(paramViewHolder)) {
      paramLinearLayout.i.setText(paramViewHolder);
    }
    if (n != 0)
    {
      paramViewHolder = b(paramOnLongClickAndTouchListener);
      localObject = paramLinearLayout.f;
      paramMessageRecord = paramViewHolder;
      if (paramViewHolder == null) {
        paramMessageRecord = URLDrawableHelperConstants.a;
      }
      ((URLImageView)localObject).setImageDrawable(paramMessageRecord);
      paramLinearLayout.f.setTag(paramOnLongClickAndTouchListener);
    }
    if (k != 0) {
      a(paramLinearLayout, i1);
    }
    paramLinearLayout.d.setTag(paramLinearLayout);
    paramLinearLayout.d.setOnClickListener(this);
    a(paramLinearLayout);
    if (v)
    {
      paramMessageRecord = paramLinearLayout.r;
      paramMessageRecord.append(paramLinearLayout.e.getText());
      paramMessageRecord.append(paramLinearLayout.g.getText());
      paramView.setContentDescription(paramLinearLayout.r.toString());
      paramLinearLayout.d.setContentDescription(paramLinearLayout.r.toString());
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
      ThreadManager.postImmediately(new MedalNewsItemBuilder.2(this, localHolder.m), null, true);
      ReportController.b(this.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "4", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder
 * JD-Core Version:    0.7.0.1
 */