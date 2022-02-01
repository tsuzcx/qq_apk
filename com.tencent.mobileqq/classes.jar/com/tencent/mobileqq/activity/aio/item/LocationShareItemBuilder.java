package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.location.LocationMessageModule;
import com.tencent.mobileqq.location.LocationMessageUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import java.util.List;

public class LocationShareItemBuilder
  extends BaseBubbleBuilder
{
  private static final int w = BaseChatItemLayout.k + BaseChatItemLayout.n;
  private static final int x = BaseChatItemLayout.l + BaseChatItemLayout.o;
  private long A;
  LocationMessageModule a = new LocationMessageModule();
  private ColorStateList y;
  private boolean z = true;
  
  public LocationShareItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.y = paramContext.getResources().getColorStateList(2131168016);
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, new Object[] { "LocationShareItemBuilder.new: invoked. ", " clickable: ", Boolean.valueOf(this.z) });
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Resources localResources = this.e.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int j = localDrawable.getIntrinsicWidth();
    int i = localDrawable.getIntrinsicHeight();
    paramInt = this.e.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      paramInt = j;
    }
    else
    {
      int k = localResources.getDimensionPixelSize(2131298365);
      int m = localResources.getDimensionPixelSize(2131298366);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      double d = j * this.f.r / paramInt + m;
      Double.isNaN(d);
      j = (int)(d * 1.6D);
      d = i * this.f.r / paramInt + m;
      Double.isNaN(d);
      i = (int)(d * 1.6D);
      paramInt = j;
    }
    localDrawable.setBounds(0, 0, paramInt, i);
    paramTextView.setCompoundDrawables(localDrawable, null, null, null);
    paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.q);
  }
  
  private void a(MessageForLocationShare paramMessageForLocationShare)
  {
    if (this.A == 0L)
    {
      List localList = LocationMessageUtil.a(this.d, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
      if ((localList != null) && (localList.size() >= 1)) {
        this.A = ((MessageRecord)localList.get(localList.size() - 1)).time;
      } else {
        this.A = (System.currentTimeMillis() / 1000L);
      }
    }
    if (this.A > paramMessageForLocationShare.time)
    {
      paramMessageForLocationShare.isSharingLocation = false;
      ThreadManager.excute(new LocationShareItemBuilder.1(this, paramMessageForLocationShare), 32, null, true);
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (LocationShareItemBuilder.Holder)paramViewHolder;
    Resources localResources = this.e.getResources();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new TextView(this.e);
      paramViewHolder.setId(2131430581);
      paramViewHolder.setTextColor(this.y);
      paramViewHolder.setTextSize(localResources.getDimensionPixelOffset(2131296688));
      paramViewHolder.setGravity(16);
      paramBaseChatItemLayout.a = paramViewHolder;
    }
    paramView = (MessageForLocationShare)paramChatMessage;
    try
    {
      a(paramView);
      label81:
      int i;
      int j;
      if (paramView.isSharingLocation)
      {
        if (!ThemeImageWrapper.isNightMode())
        {
          if (paramView.isSend()) {
            i = 2130838087;
          } else {
            i = 2130838082;
          }
        }
        else {
          i = 2130838083;
        }
        j = localResources.getColor(2131167993);
      }
      else
      {
        if (!ThemeImageWrapper.isNightMode())
        {
          if (paramView.isSend()) {
            i = 2130838086;
          } else {
            i = 2130838085;
          }
        }
        else {
          i = 2130838084;
        }
        j = Color.parseColor("#6603081A");
      }
      a(paramBaseChatItemLayout.a, i);
      paramBaseChatItemLayout.a.setTextColor(j);
      paramBaseChatItemLayout.a.setText(paramChatMessage.msg);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      this.a = new LocationMessageModule();
      this.a.a(paramView);
      paramView = this.a;
      paramView.a = this.z;
      paramViewHolder.setOnClickListener(paramView);
      if (AppSetting.e) {
        paramViewHolder.setContentDescription(paramChatMessage.msg);
      }
      return paramViewHolder;
    }
    catch (Throwable localThrowable)
    {
      break label81;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new LocationShareItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131431695)
    {
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignError(), w, BaseChatItemLayout.getTextBubblePaddingAlignHead(), x);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignHead(), w, BaseChatItemLayout.getTextBubblePaddingAlignError(), x);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    LocationShareItemBuilder.Holder localHolder = (LocationShareItemBuilder.Holder)paramViewHolder;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localHolder.a.setTextSize(0, this.f.r);
    if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()))
    {
      if (paramBubbleInfo.l == 0) {
        localHolder.a.setTextColor(-16777216);
      } else {
        localHolder.a.setTextColor(paramBubbleInfo.l);
      }
      if (paramBubbleInfo.m == 0)
      {
        localHolder.a.setLinkTextColor(paramView.getResources().getColorStateList(2131168018));
        return;
      }
      localHolder.a.setLinkTextColor(paramBubbleInfo.m);
      return;
    }
    paramViewHolder = paramView.getResources();
    paramView = (MessageForLocationShare)paramChatMessage;
    try
    {
      a(paramView);
      label141:
      if (paramView.isSharingLocation)
      {
        int i;
        if (paramChatMessage.isSend()) {
          i = 2131168020;
        } else {
          i = 2131168016;
        }
        paramViewHolder = paramViewHolder.getColorStateList(i);
        localHolder.a.setTextColor(paramViewHolder);
        return;
      }
      if ((!paramChatMessage.isSend()) && (!ThemeImageWrapper.isNightMode())) {
        paramViewHolder = paramViewHolder.getColorStateList(2131168017);
      } else {
        paramViewHolder = paramViewHolder.getColorStateList(2131168021);
      }
      localHolder.a.setTextColor(paramViewHolder);
      return;
    }
    catch (Throwable paramBubbleInfo)
    {
      break label141;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
    this.a.a = paramBoolean;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    AIOUtils.a(paramView);
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    super.a(localQQCustomMenu, this.e, 2131439015, null, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      return paramChatMessage.msg;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LocationShareItemBuilder
 * JD-Core Version:    0.7.0.1
 */