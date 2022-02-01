package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class LongTextItemBuilder
  extends TextItemBuilder
  implements BaseBubbleBuilder.TouchDelegate
{
  public LongTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131432608, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131432607, paramChatMessage, null);
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramChatMessage == null) {
      return null;
    }
    MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
    if ((!localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("0")) && (!localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("1")))
    {
      Object localObject1 = paramBaseChatItemLayout.getContext();
      TextItemBuilder.Holder localHolder = (TextItemBuilder.Holder)paramViewHolder;
      if ((paramView != null) && (!(paramView instanceof TextView)))
      {
        paramViewHolder = paramView;
      }
      else
      {
        paramView = this.e.getResources();
        paramViewHolder = new RelativeLayout((Context)localObject1);
        paramViewHolder.setPadding(paramView.getDimensionPixelSize(2131296611), paramView.getDimensionPixelSize(2131296614), paramView.getDimensionPixelSize(2131296609), paramView.getDimensionPixelSize(2131296613));
        localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.e, -2);
        int i = paramView.getDimensionPixelSize(2131299800);
        ((RelativeLayout.LayoutParams)localObject2).setMargins(i, 0, i, 0);
        paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i = AIOUtils.b(6.0F, ((Context)localObject1).getResources());
        int j = AIOUtils.b(7.0F, ((Context)localObject1).getResources());
        int k = AIOUtils.b(13.0F, ((Context)localObject1).getResources());
        int m = AIOUtils.b(15.0F, ((Context)localObject1).getResources());
        paramView = new LinearLayout((Context)localObject1);
        paramView.setLayoutParams(new RelativeLayout.LayoutParams(BaseChatItemLayout.f, -2));
        paramView.setId(2131430579);
        paramView.setOrientation(1);
        paramView.setBackgroundResource(2130852661);
        paramView.setPadding(k, m, k, m);
        localObject2 = new ETTextView((Context)localObject1);
        com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10((TextView)localObject2);
        ((ETTextView)localObject2).setTextSize(2, 15.0F);
        ((ETTextView)localObject2).setId(2131430581);
        ((ETTextView)localObject2).setTextColor(-16777216);
        ((ETTextView)localObject2).setPadding(0, 0, 0, i);
        localHolder.v = ((TextView)localObject2);
        paramView.addView((View)localObject2);
        localObject2 = new View((Context)localObject1);
        ((View)localObject2).setBackgroundColor(((Context)localObject1).getResources().getColor(2131167228));
        paramView.addView((View)localObject2, BaseChatItemLayout.f, 2);
        localObject1 = new ETTextView((Context)localObject1);
        ((ETTextView)localObject1).setTextSize(2, 15.0F);
        ((ETTextView)localObject1).setId(2131430580);
        ((ETTextView)localObject1).setPadding(0, j, 0, 0);
        ((ETTextView)localObject1).setTextColor(-7829368);
        paramView.addView((View)localObject1);
        paramViewHolder.addView(paramView);
      }
      localObject1 = (TextView)paramViewHolder.findViewById(2131430581);
      paramView = paramViewHolder.findViewById(2131430579);
      Object localObject2 = (TextView)paramViewHolder.findViewById(2131430580);
      ((TextView)localObject1).setMaxLines(4);
      if (!android.text.TextUtils.isEmpty(localMessageForLongTextMsg.sb))
      {
        if (!android.text.TextUtils.isEmpty(localMessageForLongTextMsg.sb2)) {
          localHolder.v.setText(localMessageForLongTextMsg.sb2);
        } else {
          localHolder.v.setText(localMessageForLongTextMsg.sb);
        }
      }
      else {
        ((TextView)localObject1).setText(localMessageForLongTextMsg.msg);
      }
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3")) && (localMessageForLongTextMsg.loading))
      {
        ((TextView)localObject2).setText(HardCodeUtil.a(2131904304));
        paramView.setTag(null);
        paramViewHolder.setClickable(false);
        paramView.setVisibility(0);
      }
      else if (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3"))
      {
        ((TextView)localObject2).setText(HardCodeUtil.a(2131904305));
        ((TextView)localObject2).setClickable(false);
        paramView.setTag(localMessageForLongTextMsg);
        paramView.setOnClickListener(this);
        paramView.setClickable(false);
        paramView.setVisibility(0);
      }
      paramView = null;
      paramOnLongClickAndTouchListener = VasShieldFont.a(paramChatMessage);
      ((TextView)localObject1).setTypeface(paramOnLongClickAndTouchListener);
      ((TextView)localObject2).setTypeface(paramOnLongClickAndTouchListener);
      if ((localHolder != null) && (this.d != null))
      {
        localHolder.A = super.a(localHolder.A, localHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
        super.a(localHolder.A, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
        paramBaseChatItemLayout = this.d;
        paramOnLongClickAndTouchListener = localHolder.A;
        paramChatMessage = paramView;
        if (this.f != null) {
          paramChatMessage = this.f.b;
        }
        TroopEssenceReportUtil.a(paramBaseChatItemLayout, paramOnLongClickAndTouchListener, paramChatMessage);
      }
      return paramViewHolder;
    }
    if ((paramView != null) && ((paramView instanceof TextView))) {
      return super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    }
    return super.a(paramChatMessage, paramViewHolder, null, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
    if (!localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("2"))
    {
      if (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3")) {
        return;
      }
      if (paramChatMessage.isSend())
      {
        paramView.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignError(), y, BaseChatItemLayout.getTextBubblePaddingAlignHead(), z);
        return;
      }
      paramView.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignHead(), y, BaseChatItemLayout.getTextBubblePaddingAlignError(), z);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (((localChatMessage instanceof MessageForLongTextMsg)) && ((localChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("3"))))
    {
      paramView = new QQCustomMenu();
      int i = localChatMessage.istroop;
      a(paramView, this.e, 2131444634, localChatMessage, null);
      ChatActivityFacade.a(paramView, this.e, this.f.a);
      if ((((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.d, this.f.b)) && (h())) {
        a(paramView, this.e, localChatMessage);
      }
      a(paramView, localChatMessage);
      a(paramView, this.e, 2131444651, localChatMessage, null);
      super.a(paramView, this.e, 2131439015, null, null);
      super.a(paramView, this.e, 2131428089, null, null);
      return paramView.d();
    }
    return super.a(paramView);
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    if (BubbleUtils.a(paramView)) {
      return this;
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430579)
    {
      if (paramView.getTag() == null) {
        break label215;
      }
      MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramView.getTag();
      Context localContext = paramView.getContext();
      Object localObject = (BaseActivity)localContext;
      if (((BaseActivity)localObject).getChatFragment() != null)
      {
        int i = ((BaseActivity)localObject).getChatFragment().k().F();
        String str1 = ((BaseActivity)localObject).getChatFragment().k().ae();
        String str2 = ((BaseActivity)localObject).getChatFragment().k().ag();
        localObject = new Intent(localContext, MultiForwardActivity.class);
        ((Intent)localObject).putExtra("chat_subType", 3);
        ((Intent)localObject).putExtra("uin", str1);
        ((Intent)localObject).putExtra("uintype", i);
        ((Intent)localObject).putExtra("troop_code", str2);
        str1 = localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_msg_resid");
        if (android.text.TextUtils.isEmpty(str1)) {
          QLog.e("ChatItemBuilder", 1, "LongTextMsg resid is null!");
        }
        ((Intent)localObject).putExtra("multi_url", str1);
        ((Intent)localObject).putExtra("multi_uniseq", localMessageForLongTextMsg.uniseq);
        ((Intent)localObject).putExtra("callback_type", 2);
        localContext.startActivity((Intent)localObject);
      }
    }
    super.onClick(paramView);
    label215:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */