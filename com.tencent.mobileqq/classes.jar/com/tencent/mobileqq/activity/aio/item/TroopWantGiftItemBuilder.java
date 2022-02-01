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
    boolean bool = this.e instanceof MultiForwardActivity;
    int i = 0;
    if ((!bool) && (!this.f.G)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000))
    {
      paramContext = LocaleUtil.a(this.e.getApplicationContext());
      TransDiskCache localTransDiskCache = TranslateCache.b(this.e.getApplicationContext());
      if (localTransDiskCache != null) {
        paramContext = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, paramContext);
      } else {
        paramContext = null;
      }
      if ((paramContext != null) && (paramContext.c().booleanValue()) && (!paramChatMessage.isSend())) {
        paramViewHolder.i = BubbleUtils.a(100001, this.d, this.e.getResources(), null, bool);
      } else {
        paramViewHolder.i = BubbleUtils.a(100000, this.d, this.e.getResources(), null, bool);
      }
    }
    else
    {
      if (paramChatMessage.needVipBubble()) {
        i = ((ISVIPHandler)this.d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b(paramChatMessage);
      }
      paramViewHolder.i = BubbleUtils.a(i, this.d, paramContext.getResources(), null, bool);
    }
    if (paramViewHolder.i != null) {
      paramViewHolder.i.a(paramViewHolder.h, null);
    }
    if (paramViewHolder.i != null)
    {
      int j = paramChatMessage.vipBubbleDiyTextId;
      i = j;
      if (j <= 0) {
        i = SVIPHandlerConstants.b(paramChatMessage.vipBubbleID);
      }
      paramViewHolder.i.a(this.d, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), true, paramView, FontManagerConstants.getSenderUin(paramChatMessage), i);
    }
    if (paramViewHolder.h != null)
    {
      paramContext = paramViewHolder.h.getBackground();
      if (paramContext != null) {
        paramContext.setAlpha(b);
      }
    }
    super.a(paramView, paramChatMessage);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    RelativeLayout localRelativeLayout;
    TextView localTextView;
    if (paramView == null)
    {
      paramView = new RelativeLayout(this.e);
      localRelativeLayout = (RelativeLayout)paramView;
      localObject = new RelativeLayout(this.e);
      localTextView = new TextView(this.e);
      localTextView.setMaxWidth(BaseChatItemLayout.e);
      localTextView.setTextColor(this.e.getResources().getColorStateList(2131168016));
      localTextView.setLinkTextColor(this.e.getResources().getColorStateList(2131168008));
      localTextView.setTextSize(0, this.f.r);
      localTextView.setId(2131441560);
      ((RelativeLayout)localObject).setId(2131441561);
      ((RelativeLayout)localObject).addView(localTextView);
      paramBaseChatItemLayout = new TextView(this.e);
      paramBaseChatItemLayout.setSingleLine(true);
      paramBaseChatItemLayout.setGravity(17);
      paramBaseChatItemLayout.setEllipsize(TextUtils.TruncateAt.END);
      paramBaseChatItemLayout.setTextColor(-1);
      paramBaseChatItemLayout.setTextSize(1, 13.0F);
      paramBaseChatItemLayout.setBackgroundResource(2130843655);
      paramBaseChatItemLayout.setId(2131441563);
      paramBaseChatItemLayout.setText(HardCodeUtil.a(2131913078));
      localRelativeLayout.addView((View)localObject);
      localRelativeLayout.addView(paramBaseChatItemLayout);
      localObject = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131441561);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131441561);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(this.k * 10.0F));
    }
    else
    {
      localRelativeLayout = (RelativeLayout)paramView;
      localTextView = (TextView)localRelativeLayout.findViewById(2131441560);
      paramBaseChatItemLayout = (TextView)localRelativeLayout.findViewById(2131441563);
    }
    paramBaseChatItemLayout.setPadding((int)(this.k * 5.0F), 0, (int)(this.k * 5.0F), 0);
    paramBaseChatItemLayout.getLayoutParams().height = ((int)(this.k * 20.0F));
    Object localObject = (MessageForWantGiftMsg)paramChatMessage;
    paramBaseChatItemLayout.setOnClickListener(new TroopWantGiftItemBuilder.1(this, paramChatMessage, (MessageForWantGiftMsg)localObject));
    int i = BaseChatItemLayout.getTextPaddingAlignHead();
    int j = BaseChatItemLayout.getTextPaddingAlignError();
    if (paramChatMessage.isSend())
    {
      i = BaseChatItemLayout.getTextPaddingAlignError();
      j = BaseChatItemLayout.getTextPaddingAlignHead();
    }
    localTextView.setPadding(i, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
    localTextView.setText(((MessageForWantGiftMsg)localObject).msg);
    localTextView.setBackgroundResource(2130838372);
    a(paramChatMessage, this.e, paramViewHolder, localRelativeLayout.findViewById(2131441561));
    if (((MessageForWantGiftMsg)localObject).wantGiftSenderUin != this.d.getLongAccountUin())
    {
      paramBaseChatItemLayout.setVisibility(8);
    }
    else
    {
      paramBaseChatItemLayout.setVisibility(0);
      paramViewHolder = new ReportTask(this.d).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_send_him").a(0);
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
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      if (paramInt != 2131444634) {
        return;
      }
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignError(), 0, 0, BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(0, 0, BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.l);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.e, 2131444634, paramView, null);
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
    return paramChatMessage.msg;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopWantGiftItemBuilder
 * JD-Core Version:    0.7.0.1
 */