package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import vkw;
import vkx;

public class TroopWantGiftItemBuilder
  extends BaseBubbleBuilder
{
  public TroopWantGiftItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView)
  {
    int i = 0;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {}
    for (boolean bool = false;; bool = true)
    {
      TransDiskCache localTransDiskCache;
      if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000))
      {
        paramContext = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (localTransDiskCache == null) {
          break label314;
        }
      }
      label314:
      for (paramContext = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, paramContext);; paramContext = null)
      {
        if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend())) {}
        for (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool);; paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool))
        {
          if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
          }
          if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
          {
            int j = paramChatMessage.vipBubbleDiyTextId;
            i = j;
            if (j <= 0) {
              i = SVIPHandler.b(paramChatMessage.vipBubbleID);
            }
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), true, paramView, FontManager.a(paramChatMessage), i);
          }
          if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
          {
            paramContext = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
            if (paramContext != null) {
              paramContext.setAlpha(jdField_a_of_type_Int);
            }
          }
          super.a(paramView, paramChatMessage);
          return;
        }
        if (!paramChatMessage.needVipBubble()) {}
        for (;;)
        {
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), null, bool);
          break;
          i = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject2;
    Object localObject1;
    TextView localTextView;
    if (paramView == null)
    {
      localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramBaseChatItemLayout = (RelativeLayout)localObject2;
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setMaxWidth(BaseChatItemLayout.d);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494227));
      localTextView.setLinkTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494224));
      localTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      localTextView.setId(2131362150);
      ((RelativeLayout)localObject1).setId(2131362151);
      ((RelativeLayout)localObject1).addView(localTextView);
      paramView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setSingleLine(true);
      paramView.setGravity(17);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(1, 13.0F);
      paramView.setBackgroundResource(2130840645);
      paramView.setId(2131362152);
      paramView.setText("送礼物");
      paramBaseChatItemLayout.addView((View)localObject1);
      paramBaseChatItemLayout.addView(paramView);
      localObject1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131362151);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131362151);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
      localObject1 = paramView;
      ((TextView)localObject1).setPadding((int)(5.0F * this.jdField_a_of_type_Float), 0, (int)(5.0F * this.jdField_a_of_type_Float), 0);
      ((TextView)localObject1).getLayoutParams().height = ((int)(20.0F * this.jdField_a_of_type_Float));
      paramView = (MessageForWantGiftMsg)paramChatMessage;
      ((TextView)localObject1).setOnClickListener(new vkw(this, paramChatMessage, paramView));
      int j = BaseChatItemLayout.n;
      int i = BaseChatItemLayout.o;
      if (paramChatMessage.isSend())
      {
        j = BaseChatItemLayout.o;
        i = BaseChatItemLayout.n;
      }
      localTextView.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
      localTextView.setText(paramView.msg);
      localTextView.setBackgroundResource(2130837951);
      a(paramChatMessage, this.jdField_a_of_type_AndroidContentContext, paramViewHolder, paramBaseChatItemLayout.findViewById(2131362151));
      if (paramView.wantGiftSenderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break label459;
      }
      ((TextView)localObject1).setVisibility(8);
    }
    for (;;)
    {
      ((View)localObject2).setOnLongClickListener(paramOnLongClickAndTouchListener);
      ((View)localObject2).setOnTouchListener(new vkx(this, paramOnLongClickAndTouchListener));
      return localObject2;
      paramBaseChatItemLayout = (RelativeLayout)paramView;
      localTextView = (TextView)paramBaseChatItemLayout.findViewById(2131362150);
      localObject1 = (TextView)paramBaseChatItemLayout.findViewById(2131362152);
      localObject2 = paramView;
      break;
      label459:
      ((TextView)localObject1).setVisibility(0);
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_send_him").a(0).a(new String[] { paramChatMessage.frienduin + "", "29" }).a();
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopWantGiftItemBuilder.SignItemHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.msg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131375584: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, 0, 0, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(0, 0, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    a(AIOUtils.a(paramView), localQQCustomMenu);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopWantGiftItemBuilder
 * JD-Core Version:    0.7.0.1
 */