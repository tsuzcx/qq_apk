package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.BaseChatPie;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;

public class LongTextItemBuilder
  extends TextItemBuilder
  implements BaseBubbleBuilder.TouchDelegate
{
  public LongTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramChatMessage == null) {
      paramViewHolder = null;
    }
    MessageForLongTextMsg localMessageForLongTextMsg;
    do
    {
      return paramViewHolder;
      localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
      if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("0")) || (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("1")))
      {
        if ((paramView != null) && ((paramView instanceof TextView))) {
          return super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
        }
        return super.a(paramChatMessage, paramViewHolder, null, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      }
      paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
      paramViewHolder = (TextItemBuilder.Holder)paramViewHolder;
      if (paramView != null)
      {
        paramChatMessage = paramView;
        if (!(paramView instanceof TextView)) {}
      }
      else
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources();
        paramChatMessage = new RelativeLayout(paramBaseChatItemLayout);
        paramChatMessage.setPadding(paramView.getDimensionPixelSize(2131558601), paramView.getDimensionPixelSize(2131558599), paramView.getDimensionPixelSize(2131558602), paramView.getDimensionPixelSize(2131558600));
        Object localObject = new RelativeLayout.LayoutParams(BaseChatItemLayout.d, -2);
        int i = paramView.getDimensionPixelSize(2131558652);
        ((RelativeLayout.LayoutParams)localObject).setMargins(i, 0, i, 0);
        paramChatMessage.setLayoutParams((ViewGroup.LayoutParams)localObject);
        i = AIOUtils.a(6.0F, paramBaseChatItemLayout.getResources());
        int j = AIOUtils.a(7.0F, paramBaseChatItemLayout.getResources());
        int k = AIOUtils.a(13.0F, paramBaseChatItemLayout.getResources());
        int m = AIOUtils.a(15.0F, paramBaseChatItemLayout.getResources());
        paramView = new LinearLayout(paramBaseChatItemLayout);
        paramView.setLayoutParams(new RelativeLayout.LayoutParams(BaseChatItemLayout.e, -2));
        paramView.setId(2131362285);
        paramView.setOrientation(1);
        paramView.setBackgroundResource(2130846170);
        paramView.setPadding(k, m, k, m);
        localObject = new ETTextView(paramBaseChatItemLayout);
        ((ETTextView)localObject).setTextSize(2, 15.0F);
        ((ETTextView)localObject).setId(2131363594);
        ((ETTextView)localObject).setTextColor(-16777216);
        ((ETTextView)localObject).setPadding(0, 0, 0, i);
        paramViewHolder.e = ((TextView)localObject);
        paramView.addView((View)localObject);
        paramViewHolder = new View(paramBaseChatItemLayout);
        paramViewHolder.setBackgroundColor(paramBaseChatItemLayout.getResources().getColor(2131493226));
        paramView.addView(paramViewHolder, BaseChatItemLayout.e, 2);
        paramViewHolder = new ETTextView(paramBaseChatItemLayout);
        paramViewHolder.setTextSize(2, 15.0F);
        paramViewHolder.setId(2131362284);
        paramViewHolder.setPadding(0, j, 0, 0);
        paramViewHolder.setTextColor(-7829368);
        paramView.addView(paramViewHolder);
        paramChatMessage.addView(paramView);
      }
      paramViewHolder = (TextView)paramChatMessage.findViewById(2131363594);
      paramView = paramChatMessage.findViewById(2131362285);
      paramBaseChatItemLayout = (TextView)paramChatMessage.findViewById(2131362284);
      paramViewHolder.setMaxLines(4);
      paramViewHolder.setText(localMessageForLongTextMsg.msg);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3")) && (localMessageForLongTextMsg.loading))
      {
        paramBaseChatItemLayout.setText("消息加载中...");
        paramView.setTag(null);
        paramChatMessage.setClickable(false);
        paramView.setVisibility(0);
        return paramChatMessage;
      }
      paramViewHolder = paramChatMessage;
    } while (!localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3"));
    paramBaseChatItemLayout.setText("点击查看完整消息");
    paramBaseChatItemLayout.setClickable(false);
    paramView.setTag(localMessageForLongTextMsg);
    paramView.setOnClickListener(this);
    paramView.setClickable(false);
    paramView.setVisibility(0);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
    if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {
      return;
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(g, d, f, e);
      return;
    }
    paramView.setPadding(f, d, g, e);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (((localChatMessage instanceof MessageForLongTextMsg)) && ((localChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("3"))))
    {
      paramView = new QQCustomMenu();
      if (localChatMessage.istroop == 1) {}
      a(localChatMessage, paramView);
      ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
      return paramView.a();
    }
    return super.a(paramView);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362285)
    {
      if (paramView.getTag() == null) {
        return;
      }
      MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramView.getTag();
      Context localContext = paramView.getContext();
      Object localObject = (FragmentActivity)localContext;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        int i = ((FragmentActivity)localObject).getChatFragment().a().b();
        String str1 = ((FragmentActivity)localObject).getChatFragment().a().a();
        String str2 = ((FragmentActivity)localObject).getChatFragment().a().c();
        localObject = new Intent(localContext, MultiForwardActivity.class);
        ((Intent)localObject).putExtra("chat_subType", 3);
        ((Intent)localObject).putExtra("uin", str1);
        ((Intent)localObject).putExtra("uintype", i);
        ((Intent)localObject).putExtra("troop_code", str2);
        str1 = localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_msg_resid");
        if (TextUtils.isEmpty(str1)) {
          QLog.e("ChatItemBuilder", 1, "LongTextMsg resid is null!");
        }
        ((Intent)localObject).putExtra("multi_url", str1);
        ((Intent)localObject).putExtra("multi_uniseq", localMessageForLongTextMsg.uniseq);
        ((Intent)localObject).putExtra("callback_type", 2);
        localContext.startActivity((Intent)localObject);
      }
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */