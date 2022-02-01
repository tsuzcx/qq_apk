package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.tofumsg.TofuConst;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

public class TofuIntimateAnniversaryItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener
{
  int e = 0;
  int f = 0;
  int g = 0;
  String[] h;
  int[] i;
  
  public TofuIntimateAnniversaryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.g = AIOUtils.b(16.0F, paramContext.getResources());
    this.e = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296632) * 2);
    this.f = ((int)(this.e * 0.4531835F));
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 8);
    }
    this.h = paramContext.getResources().getStringArray(2130968580);
    this.i = paramContext.getResources().getIntArray(2130968579);
  }
  
  private View a(View paramView, TofuIntimateAnniversaryItemBuilder.Holder paramHolder)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624455, null);
      paramHolder.d = paramView.findViewById(2131431322);
      paramHolder.e = paramView.findViewById(2131437976);
      paramHolder.f = ((TextView)paramView.findViewById(2131437200));
      paramHolder.g = ((TextView)paramView.findViewById(2131437201));
      paramHolder.h = ((TextView)paramView.findViewById(2131437202));
      paramHolder.j = ((ImageView)paramView.findViewById(2131434906));
      paramHolder.i = ((ImageView)paramView.findViewById(2131434922));
      localObject = (ViewGroup.MarginLayoutParams)paramHolder.d.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).height = this.f;
      paramHolder.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramHolder.d.setOnTouchListener(UITools.a);
      localObject = paramView;
      if (v)
      {
        paramHolder.r = new StringBuilder();
        localObject = paramView;
      }
    }
    if (v)
    {
      ((View)localObject).setContentDescription(null);
      paramHolder.r.replace(0, paramHolder.r.length(), "");
    }
    return localObject;
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof ShapeDrawable)) {
      ((ShapeDrawable)paramDrawable).getPaint().setColor(paramInt);
    } else if ((paramDrawable instanceof GradientDrawable)) {
      ((GradientDrawable)paramDrawable).setColor(paramInt);
    }
    if (paramDrawable != null) {
      paramDrawable.invalidateSelf();
    }
  }
  
  @Nullable
  private BaseChatPie c()
  {
    boolean bool = this.c instanceof BaseActivity;
    Object localObject = null;
    if (bool)
    {
      localObject = ((BaseActivity)this.c).getChatFragment();
      if (localObject == null) {
        return null;
      }
      localObject = ((ChatFragment)localObject).k();
    }
    return localObject;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForTofuIntimateAnniversary)paramMessageRecord;
    paramViewHolder = (TofuIntimateAnniversaryItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.k = paramLinearLayout.uniseq;
    paramViewHolder.l = Long.toString(paramLinearLayout.frdUin);
    paramViewHolder.m = paramLinearLayout;
    paramMessageRecord = URLDrawable.URLDrawableOptions.obtain();
    paramMessageRecord.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
    paramMessageRecord.mFailedDrawable = URLDrawableHelper.TRANSLUCENT;
    paramMessageRecord.mRequestHeight = this.f;
    paramMessageRecord.mRequestWidth = this.e;
    paramMessageRecord = URLDrawable.getDrawable(paramLinearLayout.bgUrl, paramMessageRecord);
    paramViewHolder.d.setBackgroundDrawable(paramMessageRecord);
    paramViewHolder.f.setTextColor(paramLinearLayout.txtColor);
    paramViewHolder.g.setTextColor(paramLinearLayout.txtColor);
    paramViewHolder.h.setTextColor(paramLinearLayout.txtColor);
    a(paramViewHolder.h.getBackground(), Color.argb(25, Color.red(paramLinearLayout.txtColor), Color.green(paramLinearLayout.txtColor), Color.blue(paramLinearLayout.txtColor)));
    paramMessageRecord = this.h;
    if ((paramMessageRecord != null) && (paramMessageRecord.length > paramLinearLayout.inimateType) && (paramLinearLayout.inimateType >= 0)) {
      paramMessageRecord = this.h[paramLinearLayout.inimateType];
    } else {
      paramMessageRecord = "";
    }
    paramOnLongClickAndTouchListener = paramViewHolder.g;
    Context localContext = paramView.getContext();
    int k = 0;
    paramOnLongClickAndTouchListener.setText(localContext.getString(2131886595, new Object[] { paramMessageRecord, Integer.valueOf(paramLinearLayout.years) }));
    paramMessageRecord = Calendar.getInstance();
    paramMessageRecord.setTimeInMillis(paramLinearLayout.bindTime * 1000L);
    paramViewHolder.h.setText(paramView.getContext().getString(2131886596, new Object[] { paramMessageRecord }));
    paramMessageRecord = FaceDrawable.getFaceDrawable(this.a, 1, String.valueOf(paramLinearLayout.frdUin));
    paramViewHolder.j.setImageDrawable(paramMessageRecord);
    paramMessageRecord = FaceDrawable.getFaceDrawable(this.a, 1, this.a.getCurrentAccountUin());
    paramViewHolder.i.setImageDrawable(paramMessageRecord);
    boolean bool = ThemeUtil.isInNightMode(this.a);
    paramMessageRecord = paramViewHolder.e;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    paramMessageRecord.setVisibility(j);
    paramViewHolder.d.setTag(paramViewHolder);
    if (v)
    {
      paramMessageRecord = paramViewHolder.r;
      paramMessageRecord.append(paramViewHolder.f.getText());
      paramMessageRecord.append(paramViewHolder.g.getText());
      paramMessageRecord.append(paramViewHolder.h.getText());
      paramView.setContentDescription(paramViewHolder.r.toString());
    }
    paramViewHolder.d.setOnClickListener(this);
    paramMessageRecord = this.i;
    int j = k;
    if (paramMessageRecord != null)
    {
      j = k;
      if (paramMessageRecord.length > paramLinearLayout.inimateType)
      {
        j = k;
        if (paramLinearLayout.inimateType >= 0) {
          j = this.i[paramLinearLayout.inimateType];
        }
      }
    }
    TofuConst.a(this.a, "0X800AE61", j);
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new TofuIntimateAnniversaryItemBuilder.Holder(this);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onClick(View paramView)
  {
    TofuIntimateAnniversaryItemBuilder.Holder localHolder = (TofuIntimateAnniversaryItemBuilder.Holder)paramView.getTag();
    if (localHolder != null)
    {
      Object localObject = c();
      if ((localObject != null) && ((localObject instanceof FriendChatPie)) && (((ChatDrawerHelper)((BaseChatPie)localObject).q(124)).b != null)) {
        ((ChatDrawerHelper)((BaseChatPie)localObject).q(124)).b.b(true);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("jumpIntimatePage:");
        ((StringBuilder)localObject).append(localHolder.l);
        QLog.d("ChatItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.i;
      int j;
      if ((localObject != null) && (localObject.length > localHolder.m.inimateType) && (localHolder.m.inimateType >= 0)) {
        j = this.i[localHolder.m.inimateType];
      } else {
        j = 0;
      }
      TofuConst.a(this.a, "0X800AE62", j);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuIntimateAnniversaryItemBuilder
 * JD-Core Version:    0.7.0.1
 */