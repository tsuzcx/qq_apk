package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
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
    int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 2) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366428, paramChatMessage, null);
    }
    while (i != 1) {
      return;
    }
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366427, paramChatMessage, null);
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramChatMessage == null) {
      paramView = null;
    }
    MessageForLongTextMsg localMessageForLongTextMsg;
    Object localObject1;
    TextItemBuilder.Holder localHolder;
    Object localObject2;
    label577:
    do
    {
      do
      {
        return paramView;
        localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
        if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("0")) || (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("1")))
        {
          if ((paramView != null) && ((paramView instanceof TextView))) {
            return super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
          }
          return super.a(paramChatMessage, paramViewHolder, null, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
        }
        localObject1 = paramBaseChatItemLayout.getContext();
        localHolder = (TextItemBuilder.Holder)paramViewHolder;
        if (paramView != null)
        {
          paramViewHolder = paramView;
          if (!(paramView instanceof TextView)) {}
        }
        else
        {
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources();
          paramViewHolder = new RelativeLayout((Context)localObject1);
          paramViewHolder.setPadding(paramView.getDimensionPixelSize(2131296401), paramView.getDimensionPixelSize(2131296403), paramView.getDimensionPixelSize(2131296400), paramView.getDimensionPixelSize(2131296402));
          localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.e, -2);
          int i = paramView.getDimensionPixelSize(2131299067);
          ((RelativeLayout.LayoutParams)localObject2).setMargins(i, 0, i, 0);
          paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          i = AIOUtils.a(6.0F, ((Context)localObject1).getResources());
          int j = AIOUtils.a(7.0F, ((Context)localObject1).getResources());
          int k = AIOUtils.a(13.0F, ((Context)localObject1).getResources());
          int m = AIOUtils.a(15.0F, ((Context)localObject1).getResources());
          paramView = new LinearLayout((Context)localObject1);
          paramView.setLayoutParams(new RelativeLayout.LayoutParams(BaseChatItemLayout.f, -2));
          paramView.setId(2131364635);
          paramView.setOrientation(1);
          paramView.setBackgroundResource(2130850889);
          paramView.setPadding(k, m, k, m);
          localObject2 = new ETTextView((Context)localObject1);
          com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10((TextView)localObject2);
          ((ETTextView)localObject2).setTextSize(2, 15.0F);
          ((ETTextView)localObject2).setId(2131364637);
          ((ETTextView)localObject2).setTextColor(-16777216);
          ((ETTextView)localObject2).setPadding(0, 0, 0, i);
          localHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject2);
          paramView.addView((View)localObject2);
          localObject2 = new View((Context)localObject1);
          ((View)localObject2).setBackgroundColor(((Context)localObject1).getResources().getColor(2131166381));
          paramView.addView((View)localObject2, BaseChatItemLayout.f, 2);
          localObject1 = new ETTextView((Context)localObject1);
          ((ETTextView)localObject1).setTextSize(2, 15.0F);
          ((ETTextView)localObject1).setId(2131364636);
          ((ETTextView)localObject1).setPadding(0, j, 0, 0);
          ((ETTextView)localObject1).setTextColor(-7829368);
          paramView.addView((View)localObject1);
          paramViewHolder.addView(paramView);
        }
        paramView = (TextView)paramViewHolder.findViewById(2131364637);
        localObject2 = paramViewHolder.findViewById(2131364635);
        localObject1 = (TextView)paramViewHolder.findViewById(2131364636);
        paramView.setMaxLines(4);
        if (android.text.TextUtils.isEmpty(localMessageForLongTextMsg.sb)) {
          break label709;
        }
        if (android.text.TextUtils.isEmpty(localMessageForLongTextMsg.sb2)) {
          break;
        }
        localHolder.jdField_d_of_type_AndroidWidgetTextView.setText(localMessageForLongTextMsg.sb2);
        ((View)localObject2).setOnTouchListener(paramOnLongClickAndTouchListener);
        ((View)localObject2).setOnLongClickListener(paramOnLongClickAndTouchListener);
        if ((!localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3")) || (!localMessageForLongTextMsg.loading)) {
          break label721;
        }
        ((TextView)localObject1).setText(HardCodeUtil.a(2131706394));
        ((View)localObject2).setTag(null);
        paramViewHolder.setClickable(false);
        ((View)localObject2).setVisibility(0);
        paramOnLongClickAndTouchListener = VasShieldFont.a(paramChatMessage);
        paramView.setTypeface(paramOnLongClickAndTouchListener);
        ((TextView)localObject1).setTypeface(paramOnLongClickAndTouchListener);
        paramView = paramViewHolder;
      } while (localHolder == null);
      paramView = paramViewHolder;
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    localHolder.jdField_d_of_type_AndroidViewView = super.a(localHolder.jdField_d_of_type_AndroidViewView, localHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
    super.a(localHolder.jdField_d_of_type_AndroidViewView, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramBaseChatItemLayout = localHolder.jdField_d_of_type_AndroidViewView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {}
    for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; paramChatMessage = null)
    {
      TroopEssenceReportUtil.a(paramView, paramBaseChatItemLayout, paramChatMessage);
      return paramViewHolder;
      localHolder.jdField_d_of_type_AndroidWidgetTextView.setText(localMessageForLongTextMsg.sb);
      break;
      label709:
      paramView.setText(localMessageForLongTextMsg.msg);
      break;
      label721:
      if (!localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3")) {
        break label577;
      }
      ((TextView)localObject1).setText(HardCodeUtil.a(2131706395));
      ((TextView)localObject1).setClickable(false);
      ((View)localObject2).setTag(localMessageForLongTextMsg);
      ((View)localObject2).setOnClickListener(this);
      ((View)localObject2).setClickable(false);
      ((View)localObject2).setVisibility(0);
      break label577;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (BubbleUtils.a(paramView)) {
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
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramChatMessage;
    if ((localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localMessageForLongTextMsg.getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {
      return;
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(f, c, e, d);
      return;
    }
    paramView.setPadding(e, c, f, d);
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
      a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131376927, localChatMessage, null);
      ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if ((((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (b())) {
        a(paramView, this.jdField_a_of_type_AndroidContentContext, localChatMessage);
      }
      a(paramView, localChatMessage);
      a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131376940, localChatMessage, null);
      super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
      super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return paramView.a();
    }
    return super.a(paramView);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364635) {
      if (paramView.getTag() != null) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)paramView.getTag();
      Context localContext = paramView.getContext();
      Object localObject = (FragmentActivity)localContext;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        int i = ((FragmentActivity)localObject).getChatFragment().a().b();
        String str1 = ((FragmentActivity)localObject).getChatFragment().a().b();
        String str2 = ((FragmentActivity)localObject).getChatFragment().a().d();
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
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */