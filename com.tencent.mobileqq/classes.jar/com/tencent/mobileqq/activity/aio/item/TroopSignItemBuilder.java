package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class TroopSignItemBuilder
  extends BaseBubbleBuilder
{
  protected int A = 12303291;
  protected int B = 0;
  protected int a;
  protected int w;
  protected int x;
  protected int y;
  protected int z;
  
  public TroopSignItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a = DisplayUtil.a(paramContext, 151.5F);
    this.w = DisplayUtil.a(paramContext, 125.5F);
    this.x = DisplayUtil.a(paramContext, 152.0F);
    this.y = DisplayUtil.a(this.e, 14.0F);
    this.z = DisplayUtil.a(this.e, 10.0F);
    this.B = DisplayUtil.a(this.e, 50.0F);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      if (paramInt != 2131444634)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    int i = this.y / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (paramInt == 7)
    {
      localLayoutParams.topMargin = this.y;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(14, -1);
      localLayoutParams.addRule(10, -1);
    }
    else
    {
      localLayoutParams.topMargin = i;
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(14, 0);
      localLayoutParams.addRule(10, -1);
      if (paramBoolean) {
        localLayoutParams.rightMargin = (i + this.z);
      } else {
        localLayoutParams.rightMargin = i;
      }
    }
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.k, 0, BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(0, BaseChatItemLayout.k, BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.l);
  }
  
  public void a(TroopSignItemBuilder.SignItemHolder paramSignItemHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramSignItemHolder.q;
    Resources localResources;
    Object localObject;
    TextView localTextView;
    boolean bool;
    Drawable localDrawable;
    ColorDrawable localColorDrawable;
    if (paramSignItemHolder.t == null)
    {
      localResources = this.e.getResources();
      paramSignItemHolder.t = new FrameLayout(this.e);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      localTextView = new TextView(this.e);
      bool = true;
      localTextView.setSingleLine(true);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 12.0F);
      localTextView.setBackgroundResource(2130843655);
      paramSignItemHolder.t.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      paramSignItemHolder.u = localTextView;
      paramSignItemHolder.u.setText(localMessageForTroopSign.srcName);
      if (!TextUtils.isEmpty(localMessageForTroopSign.srcIconUrl))
      {
        localObject = localMessageForTroopSign.srcIconUrl;
        localDrawable = localResources.getDrawable(2130852668);
        localDrawable.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
        localColorDrawable = new ColorDrawable(15790320);
        localColorDrawable.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
      }
    }
    for (;;)
    {
      try
      {
        localObject = URLDrawable.getDrawable((String)localObject, localDrawable, localColorDrawable);
        if (URLDrawableHelper.isMobileNetAndAutodownDisabled(this.e)) {
          break label484;
        }
        ((URLDrawable)localObject).setAutoDownload(bool);
      }
      catch (Exception localException)
      {
        localObject = localColorDrawable;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setSourceView exception");
          ((StringBuilder)localObject).append(localException.toString());
          QLog.e("TroopSignItemBuilder", 2, ((StringBuilder)localObject).toString());
          localObject = localColorDrawable;
        }
      }
      ((Drawable)localObject).setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
      localTextView.setCompoundDrawablePadding(AIOUtils.b(3.0F, localResources));
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      break label366;
      localTextView.setCompoundDrawables(null, null, null, null);
      label366:
      localTextView.setPadding(AIOUtils.b(5.0F, localResources), 0, AIOUtils.b(5.0F, localResources), 0);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131430578);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131430578);
      paramBaseChatItemLayout.addView(paramSignItemHolder.t, (ViewGroup.LayoutParams)localObject);
      paramSignItemHolder.t.setOnClickListener(this);
      paramBaseChatItemLayout = (FrameLayout.LayoutParams)paramSignItemHolder.u.getLayoutParams();
      if (localMessageForTroopSign.isSend()) {
        paramBaseChatItemLayout.leftMargin = BaseChatItemLayout.getBubblePaddingAlignError();
      } else {
        paramBaseChatItemLayout.leftMargin = this.z;
      }
      paramSignItemHolder.u.setLayoutParams(paramBaseChatItemLayout);
      return;
      label484:
      bool = false;
    }
  }
  
  public void a(TroopSignItemBuilder.SignItemHolder paramSignItemHolder, MessageForTroopSign paramMessageForTroopSign)
  {
    boolean bool = paramMessageForTroopSign.isSend();
    if ((paramMessageForTroopSign.markType != 1) && (paramMessageForTroopSign.markType != 2))
    {
      paramSignItemHolder.c.setImageDrawable(null);
    }
    else if (!TextUtils.isEmpty(paramMessageForTroopSign.markIconUrl))
    {
      try
      {
        Object localObject = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.B;
        localURLDrawableOptions.mRequestHeight = this.B;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(paramMessageForTroopSign.markIconUrl, localURLDrawableOptions);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        paramSignItemHolder.c.setImageDrawable((Drawable)localObject);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label159;
        }
      }
      QLog.d("TroopSignItemBuilder", 2, QLog.getStackTraceString(localException));
    }
    else
    {
      paramSignItemHolder.c.setImageDrawable(null);
    }
    label159:
    if (paramMessageForTroopSign.markType == 1)
    {
      paramSignItemHolder.s.setVisibility(4);
      paramSignItemHolder.e.setVisibility(0);
      paramSignItemHolder.d.setVisibility(4);
      a(paramSignItemHolder.e, paramMessageForTroopSign.positonType, bool);
      return;
    }
    if (paramMessageForTroopSign.markType == 2)
    {
      paramSignItemHolder.s.setVisibility(4);
      paramSignItemHolder.e.setVisibility(0);
      paramSignItemHolder.d.setVisibility(0);
      paramSignItemHolder.d.setText(paramMessageForTroopSign.markDesc);
      a(paramSignItemHolder.e, paramMessageForTroopSign.positonType, bool);
      return;
    }
    if (paramMessageForTroopSign.markType == 3)
    {
      paramSignItemHolder.s.setVisibility(0);
      paramSignItemHolder.e.setVisibility(4);
      paramSignItemHolder.f.setText(paramMessageForTroopSign.markWord);
      paramSignItemHolder.g.setText(paramMessageForTroopSign.markDesc);
      a(paramSignItemHolder.s, paramMessageForTroopSign.positonType, bool);
      return;
    }
    paramSignItemHolder.s.setVisibility(4);
    paramSignItemHolder.e.setVisibility(4);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (MessageForTroopSign)((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q;
    super.a(localQQCustomMenu, this.e, 2131444634, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    a(localQQCustomMenu, this.e, 2131444651, paramView, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return ((MessageForTroopSign)paramChatMessage).getSummaryMsg();
  }
  
  public void onClick(View paramView)
  {
    if ((!c()) && (!(this.e instanceof MultiForwardActivity)) && (!this.f.G))
    {
      Object localObject1 = (TroopSignItemBuilder.SignItemHolder)AIOUtils.b(paramView);
      Object localObject2 = (MessageForTroopSign)((TroopSignItemBuilder.SignItemHolder)localObject1).q;
      if (paramView == ((TroopSignItemBuilder.SignItemHolder)localObject1).t)
      {
        localObject2 = ((MessageForTroopSign)localObject2).srcAction;
        ReportController.b(this.d, "dc00899", "Grp_checkin", "", "entry", "clk_obj_graybar", 0, 0, "", "", "", "");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onSrcClick actionURL:");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("TroopSignItemBuilder", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      else if (paramView == ((TroopSignItemBuilder.SignItemHolder)localObject1).h)
      {
        localObject2 = ((MessageForTroopSign)localObject2).msgAction;
        ReportController.b(this.d, "dc00899", "Grp_checkin", "", "entry", "clk_obj", 0, 0, "", "", "", "");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onContentClick actionURL:");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("TroopSignItemBuilder", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = "";
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        try
        {
          localObject2 = new Intent(this.e, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded((Intent)localObject2, (String)localObject1);
          this.e.startActivity((Intent)localObject2);
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label324;
          }
        }
        QLog.w("TroopSignItemBuilder", 2, "onClick exp:", localException);
      }
      else
      {
        super.onClick(paramView);
      }
    }
    label324:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder
 * JD-Core Version:    0.7.0.1
 */