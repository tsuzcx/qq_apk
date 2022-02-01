package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMedalWallEntryInfo;
import com.tencent.mobileqq.tofumsg.DrawCircleCornerImageView;
import com.tencent.mobileqq.tofumsg.TofuConst;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TofuBaseProfileItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener, View.OnLayoutChangeListener
{
  int e = 0;
  int f = 0;
  int g = 0;
  int h = 0;
  int i = 0;
  int j = 0;
  
  public TofuBaseProfileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.g = AIOUtils.b(16.0F, paramContext.getResources());
    this.h = AIOUtils.b(108.0F, paramContext.getResources());
    this.e = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296632) * 2);
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 9);
    }
  }
  
  private View a(View paramView, TofuBaseProfileItemBuilder.Holder paramHolder)
  {
    Object localObject1 = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624454, null);
      paramHolder.d = paramView.findViewById(2131431322);
      paramHolder.e = ((CornerImageView)paramView.findViewById(2131437976));
      paramHolder.f = ((TextView)paramView.findViewById(2131447463));
      paramHolder.g = new TextView[3];
      paramHolder.g[0] = ((TextView)paramView.findViewById(2131437200));
      paramHolder.g[1] = ((TextView)paramView.findViewById(2131437201));
      paramHolder.g[2] = ((TextView)paramView.findViewById(2131437202));
      paramHolder.h = paramView.findViewById(2131432003);
      localObject1 = paramHolder.f.getCompoundDrawables();
      int m = localObject1.length;
      int k = 0;
      while (k < m)
      {
        Object localObject2 = localObject1[k];
        if (localObject2 != null) {
          localObject2.setColorFilter(-7894119, PorterDuff.Mode.SRC_IN);
        }
        k += 1;
      }
      paramHolder.i = ((DrawCircleCornerImageView)paramView.findViewById(2131429397));
      paramHolder.i.setRadius(this.g);
      paramHolder.i.setImageDrawable(new ColorDrawable(-657670));
      paramHolder.d.setOnTouchListener(UITools.a);
      paramHolder.d.addOnLayoutChangeListener(this);
      paramHolder.e.setRadius(this.g);
      localObject1 = paramView;
      if (v)
      {
        paramHolder.r = new StringBuilder();
        localObject1 = paramView;
      }
    }
    if (v)
    {
      ((View)localObject1).setContentDescription(null);
      paramHolder.r.replace(0, paramHolder.r.length(), "");
    }
    return localObject1;
  }
  
  private void a(TofuBaseProfileItemBuilder.Holder paramHolder, int paramInt1, int paramInt2)
  {
    paramInt1 -= AIOUtils.b(30.5F, this.c.getResources());
    paramInt2 = AIOUtils.b(54.0F, this.c.getResources());
    if (paramInt1 > 0)
    {
      paramHolder.i.setCircle(paramInt1, paramInt2, this.h, -920839);
      paramHolder.i.invalidate();
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForTofuBaseProfile)paramMessageRecord;
    paramMessageRecord = (TofuBaseProfileItemBuilder.Holder)paramViewHolder;
    paramViewHolder = a(paramView, paramMessageRecord);
    paramMessageRecord.j = paramLinearLayout.uniseq;
    paramMessageRecord.k = this.d.b;
    paramView = PLNewsItemBuilder.a(this.d.e, 6);
    paramView = paramViewHolder.getResources().getString(2131886593, new Object[] { paramView });
    paramMessageRecord.f.setText(paramView);
    int k = 0;
    int m;
    for (;;)
    {
      m = 8;
      if (k >= 3) {
        break;
      }
      if (paramMessageRecord.g[k] != null) {
        if (k < paramLinearLayout.linesCnt)
        {
          paramView = paramLinearLayout.lines[k];
          paramMessageRecord.g[k].setText(paramView);
          paramMessageRecord.g[k].setVisibility(0);
        }
        else
        {
          paramMessageRecord.g[k].setText("");
          paramMessageRecord.g[k].setVisibility(8);
        }
      }
      k += 1;
    }
    paramView = paramMessageRecord.h;
    if (paramLinearLayout.linesCnt > 3) {
      k = 0;
    } else {
      k = 8;
    }
    paramView.setVisibility(k);
    boolean bool = ThemeUtil.isInNightMode(this.a);
    paramView = paramMessageRecord.e;
    k = m;
    if (bool) {
      k = 0;
    }
    paramView.setVisibility(k);
    paramMessageRecord.d.setTag(paramMessageRecord);
    if (v)
    {
      paramView = paramMessageRecord.r;
      paramView.append(paramMessageRecord.f);
      paramView.append(paramMessageRecord.g[0].getText());
      paramView.append(paramMessageRecord.g[1].getText());
      paramView.append(paramMessageRecord.g[2].getText());
      paramViewHolder.setContentDescription(paramMessageRecord.r.toString());
    }
    paramMessageRecord.d.setOnClickListener(this);
    TofuConst.a(this.a, "0X800AE5D", 0);
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new TofuBaseProfileItemBuilder.Holder(this);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onClick(View paramView)
  {
    TofuBaseProfileItemBuilder.Holder localHolder = (TofuBaseProfileItemBuilder.Holder)paramView.getTag();
    if (localHolder != null)
    {
      Object localObject = new ProfileMedalWallEntryInfo();
      ((ProfileMedalWallEntryInfo)localObject).showMetalWall = true;
      localObject = ProfileCardUtils.getProfileDetailUrl(localHolder.k, this.a.getAppid(), "android-8.8.17", null, (ProfileMedalWallEntryInfo)localObject);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (WebViewComUtils.a(500L)))
      {
        Intent localIntent = new Intent(this.c, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("uin", this.a.getCurrentAccountUin());
        localIntent.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
        localIntent.putExtra("reqType", 1);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
        this.c.startActivity(localIntent);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("jump profile detail:");
        ((StringBuilder)localObject).append(localHolder.k);
        QLog.d("TofuBaseProfileItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      TofuConst.a(this.a, "0X800AE5E", 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramView.getMeasuredWidth();
    paramInt2 = paramView.getMeasuredHeight();
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 != this.i) && (paramInt2 != this.j))
    {
      paramView = (TofuBaseProfileItemBuilder.Holder)paramView.getTag();
      if (paramView == null) {
        return;
      }
      this.i = paramInt1;
      this.j = paramInt2;
      a(paramView, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuBaseProfileItemBuilder
 * JD-Core Version:    0.7.0.1
 */