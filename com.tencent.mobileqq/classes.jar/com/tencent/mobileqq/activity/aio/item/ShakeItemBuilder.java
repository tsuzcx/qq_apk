package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class ShakeItemBuilder
  extends BaseBubbleBuilder
{
  private long a = -1L;
  private View.OnClickListener w = new ShakeItemBuilder.1(this);
  
  public ShakeItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    ShakeItemBuilder.Holder localHolder = (ShakeItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new LinearLayout(paramBaseChatItemLayout);
      paramViewHolder.setOrientation(0);
      paramView = new ImageView(paramBaseChatItemLayout);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131168016));
      ((TextView)localObject).setMaxWidth(BaseChatItemLayout.f);
      ((TextView)localObject).setId(2131430581);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramViewHolder.addView((View)localObject, localLayoutParams);
      localHolder.b = paramView;
      localHolder.a = ((TextView)localObject);
    }
    localHolder.a.setTextSize(0, this.f.r);
    int i = BaseChatItemLayout.getTextPaddingAlignHead();
    int j = BaseChatItemLayout.getTextPaddingAlignError();
    int k = BaseChatItemLayout.getTextPaddingAlignHead();
    localHolder.b.setImageResource(2130846263);
    if (paramChatMessage.isSend())
    {
      i = BaseChatItemLayout.getTextPaddingAlignError();
      j = BaseChatItemLayout.getTextPaddingAlignHead();
      k = BaseChatItemLayout.getTextPaddingAlignError();
      localHolder.b.setImageResource(2130846264);
    }
    localHolder.b.setPadding(k, 0, 0, 0);
    localHolder.a.setPadding(i, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
    localHolder.a.setText(paramBaseChatItemLayout.getResources().getString(2131916393));
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this.w);
    if (v)
    {
      if ((localHolder.r != null) && (localHolder.r.length() > 0)) {
        localHolder.r.setLength(0);
      }
      paramView = new StringBuilder();
      if (paramChatMessage.time > 0L)
      {
        paramView.append(TimeFormatterUtils.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L));
        paramView.append(" ");
      }
      if (paramChatMessage.isSend())
      {
        paramView.append("我抖了");
        paramView.append(this.f.e);
        paramView.append("一下");
      }
      else
      {
        paramView.append(this.f.e);
        paramView.append("抖了你一下");
      }
      paramViewHolder.setContentDescription(paramView.toString());
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShakeItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      if (paramInt != 2131439015) {
        return;
      }
      super.a(paramInt, this.e, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    ShakeItemBuilder.Holder localHolder = (ShakeItemBuilder.Holder)paramViewHolder;
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
    int i;
    if (paramChatMessage.isSend()) {
      i = 2131168020;
    } else {
      i = 2131168016;
    }
    paramView = paramViewHolder.getColorStateList(i);
    if (paramView != null) {
      localHolder.a.setTextColor(paramView);
    }
    if (paramChatMessage.isSend()) {
      paramViewHolder = paramViewHolder.getColorStateList(2131168019);
    } else {
      paramViewHolder = paramViewHolder.getColorStateList(2131168018);
    }
    localHolder.a.setLinkTextColor(paramViewHolder);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.e, this.f.a);
    super.a(paramView, this.e, 2131439015, null, null);
    super.a(paramView, this.e, 2131428089, null, null);
    return paramView.d();
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    paramView = (MessageForShakeWindow)AIOUtils.a(paramView);
    String str1 = this.e.getString(2131886574);
    String str2 = this.e.getString(2131886575);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.e, 230, str1, str2, new ShakeItemBuilder.2(this, paramView), new ShakeItemBuilder.3(this)).show();
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L)
    {
      localStringBuilder.append(TimeFormatterUtils.a(this.e, 3, paramChatMessage.time * 1000L));
      localStringBuilder.append(" ");
    }
    if (paramChatMessage.isSend())
    {
      localStringBuilder.append("我抖了");
      localStringBuilder.append(this.f.e);
      localStringBuilder.append("一下");
    }
    else
    {
      localStringBuilder.append(this.f.e);
      localStringBuilder.append("抖了你一下");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder
 * JD-Core Version:    0.7.0.1
 */