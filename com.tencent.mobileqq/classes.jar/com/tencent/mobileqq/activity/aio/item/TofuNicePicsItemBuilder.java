package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTofuNicePics;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.tofumsg.TofuConst;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.jetbrains.annotations.NotNull;

public class TofuNicePicsItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener
{
  int e = 0;
  int f = 0;
  
  public TofuNicePicsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.e = AIOUtils.b(251.0F, paramContext.getResources());
    this.f = AIOUtils.b(131.0F, paramContext.getResources());
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 10);
    }
  }
  
  @NotNull
  private Drawable a(boolean paramBoolean, String paramString)
  {
    Drawable localDrawable = URLDrawableHelper.TRANSLUCENT;
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSLUCENT;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.f;
    int i;
    if (paramBoolean) {
      i = this.e;
    } else {
      i = (int)(this.e * 0.5F);
    }
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      return paramString;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDrawable ex=");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.d("TofuNicePicsItemBuilder", 1, ((StringBuilder)localObject).toString(), paramString);
    }
    return localDrawable;
  }
  
  private View a(View paramView, TofuNicePicsItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624456, null);
      paramHolder.d = paramView.findViewById(2131431322);
      paramHolder.e = paramView.findViewById(2131437976);
      paramHolder.i = ((ImageView)paramView.findViewById(2131429440));
      paramHolder.j = ((ImageView)paramView.findViewById(2131437123));
      paramHolder.k = ((ImageView)paramView.findViewById(2131444843));
      paramHolder.f = ((TextView)paramView.findViewById(2131437200));
      paramHolder.g = ((TextView)paramView.findViewById(2131437201));
      paramHolder.h = ((TextView)paramView.findViewById(2131447419));
      paramHolder.d.setOnTouchListener(UITools.a);
      localView = paramView;
      if (v)
      {
        paramHolder.r = new StringBuilder();
        localView = paramView;
      }
    }
    if (v)
    {
      localView.setContentDescription(null);
      paramHolder.r.replace(0, paramHolder.r.length(), "");
    }
    return localView;
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable)
  {
    int i;
    if (paramDrawable != null) {
      i = 0;
    } else {
      i = 8;
    }
    paramImageView.setVisibility(i);
    paramImageView.setImageDrawable(paramDrawable);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForTofuNicePics)paramMessageRecord;
    paramMessageRecord = (TofuNicePicsItemBuilder.Holder)paramViewHolder;
    paramViewHolder = a(paramView, paramMessageRecord);
    paramMessageRecord.l = paramLinearLayout.uniseq;
    paramMessageRecord.m = Long.toString(paramLinearLayout.frdUin);
    paramMessageRecord.n = paramLinearLayout;
    if ((!TextUtils.isEmpty(paramLinearLayout.url1)) && (!TextUtils.isEmpty(paramLinearLayout.url2)))
    {
      paramView = a(false, paramLinearLayout.url1);
      paramOnLongClickAndTouchListener = a(false, paramLinearLayout.url2);
      a(paramMessageRecord.j, paramView);
      a(paramMessageRecord.k, paramOnLongClickAndTouchListener);
      a(paramMessageRecord.i, null);
    }
    else
    {
      paramView = a(true, paramLinearLayout.url1);
      a(paramMessageRecord.j, null);
      a(paramMessageRecord.k, null);
      a(paramMessageRecord.i, paramView);
    }
    paramView = PLNewsItemBuilder.a(this.d.e, 6);
    paramView = this.c.getResources().getString(2131886597, new Object[] { paramView, Integer.valueOf(paramLinearLayout.countInc) });
    paramMessageRecord.f.setText(paramView);
    int j = paramLinearLayout.countInc;
    int i = 8;
    if (j > 1)
    {
      paramView = paramMessageRecord.h;
      paramOnLongClickAndTouchListener = new StringBuilder();
      paramOnLongClickAndTouchListener.append("共");
      paramOnLongClickAndTouchListener.append(paramLinearLayout.countInc);
      paramOnLongClickAndTouchListener.append("张");
      paramView.setText(paramOnLongClickAndTouchListener.toString());
      paramMessageRecord.h.setVisibility(0);
    }
    else
    {
      paramMessageRecord.h.setVisibility(8);
    }
    paramView = TimeFormatterUtils.a(this.c, 7, paramLinearLayout.upTime * 1000L);
    paramMessageRecord.g.setText(paramView);
    boolean bool = ThemeUtil.isInNightMode(this.a);
    paramView = paramMessageRecord.e;
    if (bool) {
      i = 0;
    }
    paramView.setVisibility(i);
    paramMessageRecord.d.setTag(paramMessageRecord);
    if (v)
    {
      paramView = paramMessageRecord.r;
      paramView.append(paramMessageRecord.f.getText());
      paramView.append(paramMessageRecord.g.getText());
      paramViewHolder.setContentDescription(paramMessageRecord.r.toString());
    }
    paramMessageRecord.d.setOnClickListener(this);
    TofuConst.a(this.a, "0X800AE5F", 0);
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new TofuNicePicsItemBuilder.Holder(this);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onClick(View paramView)
  {
    TofuNicePicsItemBuilder.Holder localHolder = (TofuNicePicsItemBuilder.Holder)paramView.getTag();
    if (localHolder != null)
    {
      PhotoWallView.jumpToPhotoWall((Activity)paramView.getContext(), localHolder.m, false);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jump photowall:");
        localStringBuilder.append(localHolder.m);
        QLog.d("TofuNicePicsItemBuilder", 2, localStringBuilder.toString());
      }
      TofuConst.a(this.a, "0X800AE60", 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuNicePicsItemBuilder
 * JD-Core Version:    0.7.0.1
 */