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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopWantGiftItemBuilder
  extends BaseBubbleBuilder
{
  public TroopWantGiftItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView)
  {
    boolean bool = this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity;
    int i = 0;
    if ((!bool) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000))
    {
      paramContext = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache != null) {
        paramContext = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, paramContext);
      } else {
        paramContext = null;
      }
      if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend())) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool);
      } else {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool);
      }
    }
    else
    {
      if (paramChatMessage.needVipBubble()) {
        i = ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramChatMessage);
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), null, bool);
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
    {
      int j = paramChatMessage.vipBubbleDiyTextId;
      i = j;
      if (j <= 0) {
        i = SVIPHandlerConstants.b(paramChatMessage.vipBubbleID);
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), true, paramView, FontManagerConstants.getSenderUin(paramChatMessage), i);
    }
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
    {
      paramContext = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
      if (paramContext != null) {
        paramContext.setAlpha(b);
      }
    }
    super.a(paramView, paramChatMessage);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    RelativeLayout localRelativeLayout;
    TextView localTextView;
    if (paramView == null)
    {
      paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout = (RelativeLayout)paramView;
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setMaxWidth(BaseChatItemLayout.e);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167075));
      localTextView.setLinkTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167068));
      localTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      localTextView.setId(2131373886);
      ((RelativeLayout)localObject).setId(2131373887);
      ((RelativeLayout)localObject).addView(localTextView);
      paramBaseChatItemLayout = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramBaseChatItemLayout.setSingleLine(true);
      paramBaseChatItemLayout.setGravity(17);
      paramBaseChatItemLayout.setEllipsize(TextUtils.TruncateAt.END);
      paramBaseChatItemLayout.setTextColor(-1);
      paramBaseChatItemLayout.setTextSize(1, 13.0F);
      paramBaseChatItemLayout.setBackgroundResource(2130842702);
      paramBaseChatItemLayout.setId(2131373889);
      paramBaseChatItemLayout.setText(HardCodeUtil.a(2131715606));
      localRelativeLayout.addView((View)localObject);
      localRelativeLayout.addView(paramBaseChatItemLayout);
      localObject = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131373887);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131373887);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_a_of_type_Float * 10.0F));
    }
    else
    {
      localRelativeLayout = (RelativeLayout)paramView;
      localTextView = (TextView)localRelativeLayout.findViewById(2131373886);
      paramBaseChatItemLayout = (TextView)localRelativeLayout.findViewById(2131373889);
    }
    paramBaseChatItemLayout.setPadding((int)(this.jdField_a_of_type_Float * 5.0F), 0, (int)(this.jdField_a_of_type_Float * 5.0F), 0);
    paramBaseChatItemLayout.getLayoutParams().height = ((int)(this.jdField_a_of_type_Float * 20.0F));
    Object localObject = (MessageForWantGiftMsg)paramChatMessage;
    paramBaseChatItemLayout.setOnClickListener(new TroopWantGiftItemBuilder.1(this, paramChatMessage, (MessageForWantGiftMsg)localObject));
    int i = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    if (paramChatMessage.isSend())
    {
      i = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
    }
    localTextView.setPadding(i, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    localTextView.setText(((MessageForWantGiftMsg)localObject).msg);
    localTextView.setBackgroundResource(2130838324);
    a(paramChatMessage, this.jdField_a_of_type_AndroidContentContext, paramViewHolder, localRelativeLayout.findViewById(2131373887));
    if (((MessageForWantGiftMsg)localObject).wantGiftSenderUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
    {
      paramBaseChatItemLayout.setVisibility(8);
    }
    else
    {
      paramBaseChatItemLayout.setVisibility(0);
      paramViewHolder = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_send_him").a(0);
      paramBaseChatItemLayout = new StringBuilder();
      paramBaseChatItemLayout.append(paramChatMessage.frienduin);
      paramBaseChatItemLayout.append("");
      paramViewHolder.a(new String[] { paramBaseChatItemLayout.toString(), "29" }).a();
    }
    paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramView.setOnTouchListener(new TroopWantGiftItemBuilder.2(this, paramOnLongClickAndTouchListener));
    return paramView;
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
    if (paramInt != 2131365480)
    {
      if (paramInt != 2131376417) {
        return;
      }
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, 0, 0, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(0, 0, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopWantGiftItemBuilder
 * JD-Core Version:    0.7.0.1
 */