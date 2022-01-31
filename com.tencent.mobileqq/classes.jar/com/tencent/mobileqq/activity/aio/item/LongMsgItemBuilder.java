package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import uxm;
import uxn;
import uxo;
import uxp;
import uxq;

public class LongMsgItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate
{
  private static final int b;
  private static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected View.OnClickListener a;
  AnimationTextView.OnDoubleClick a;
  
  static
  {
    jdField_b_of_type_Int = BaseChatItemLayout.g + BaseChatItemLayout.l;
  }
  
  public LongMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new uxp(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uxq(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public int a(MessageForLongMsg paramMessageForLongMsg)
  {
    if ((paramMessageForLongMsg != null) && (paramMessageForLongMsg.mSourceMsgInfo != null)) {
      return 2;
    }
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject2 = paramBaseChatItemLayout.getContext();
    Object localObject1 = (MessageForLongMsg)paramChatMessage;
    int i = a((MessageForLongMsg)localObject1);
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView((Context)localObject2);
        paramView.setTextColor(((Context)localObject2).getResources().getColorStateList(2131494220));
        paramView.setMaxWidth(BaseChatItemLayout.d);
        paramView.setSpannableFactory(QQText.a);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131363557);
        localHolder.jdField_a_of_type_AndroidWidgetTextView = paramView;
      }
    }
    for (;;)
    {
      if ((i == 2) && (localHolder.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a((Context)localObject2, localHolder);
      }
      for (;;)
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        if (i == 2)
        {
          localHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          ReplyTextItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHolder.jdField_a_of_type_AndroidViewViewGroup, ((MessageForLongMsg)localObject1).mSourceMsgInfo, ((MessageForLongMsg)localObject1).frienduin, ((MessageForLongMsg)localObject1).istroop, ((MessageForLongMsg)localObject1).uniseq);
          localHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramOnLongClickAndTouchListener);
          localHolder.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramOnLongClickAndTouchListener);
          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramChatMessage.senderuin)) && (!((MessageForLongMsg)localObject1).mIsCutAtInfoLocal) && (((MessageForLongMsg)localObject1).atInfoList != null) && (((MessageForLongMsg)localObject1).atInfoList.size() > 0))
          {
            localObject2 = (MessageForText.AtTroopMemberInfo)((MessageForLongMsg)localObject1).atInfoList.remove(0);
            if (((MessageForLongMsg)localObject1).msg.length() > ((MessageForText.AtTroopMemberInfo)localObject2).textLen + 1)
            {
              ((MessageForLongMsg)localObject1).msg = ((MessageForLongMsg)localObject1).msg.substring(((MessageForText.AtTroopMemberInfo)localObject2).textLen + 1);
              ((MessageForLongMsg)localObject1).sb = new QQText(((MessageForLongMsg)localObject1).msg, 13, 32, (MessageRecord)localObject1);
            }
            ((MessageForLongMsg)localObject1).mIsCutAtInfoLocal = true;
          }
          label342:
          paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
          if (!android.text.TextUtils.isEmpty(((MessageForLongMsg)localObject1).sb2)) {
            break label602;
          }
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((MessageForLongMsg)localObject1).sb);
        }
        for (;;)
        {
          if ((localHolder.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            localObject1 = (AnimationTextView)localHolder.jdField_a_of_type_AndroidWidgetTextView;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, (AnimationTextView)localObject1, paramViewHolder.jdField_b_of_type_Int, paramViewHolder.c, true);
            ((AnimationTextView)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
            ((AnimationTextView)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnSingleClick = new uxm(this, paramChatMessage.isSend());
            ((AnimationTextView)localObject1).setStrokeColor(false, 0);
          }
          if ((localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
          }
          if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
          {
            paramViewHolder = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
            if (paramViewHolder != null)
            {
              paramViewHolder = paramViewHolder.a().a;
              if (paramViewHolder != null) {
                localHolder.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder = paramViewHolder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, localHolder.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
              }
            }
          }
          return paramView;
          paramView = a((Context)localObject2, localHolder);
          break;
          if (localHolder.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label342;
          }
          localHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label342;
          label602:
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((MessageForLongMsg)localObject1).sb2);
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, LongMsgItemBuilder.Holder paramHolder)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = ReplyTextItemBuilder.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramHolder.b = ((TextView)((ViewGroup)localObject).findViewById(2131368469));
    paramHolder.c = ((TextView)((ViewGroup)localObject).findViewById(2131362736));
    paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131366618));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131494220));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.d);
    ((AnimationTextView)localObject).setSpannableFactory(QQText.a);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131363557);
    localLinearLayout.addView((View)localObject);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    return localLinearLayout;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new LongMsgItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "说" + com.tencent.mobileqq.text.TextUtils.d(paramChatMessage.msg);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131375336: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131375346: 
      super.c(paramChatMessage);
      return;
    case 2131375342: 
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage));
      return;
    case 2131375344: 
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
      return;
    case 2131363499: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
    case 2131375352: 
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_about_translate", 0, 1, 0);
      paramContext = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if ((paramChatMessage != null) && (paramChatMessage.length() > 0)) {
        paramContext.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramContext.putExtra("url", "http://183.62.127.31/MobileQQ/translate.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramContext);
      return;
    case 2131366733: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433618);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433619);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new uxn(this, paramView), new uxo(this)).show();
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
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(e, jdField_b_of_type_Int, d, c);
      return;
    }
    paramView.setPadding(d, jdField_b_of_type_Int, e, c);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if (paramInt == 1)
    {
      BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      if (localViewHolder != null) {
        a(localViewHolder, paramView, paramChatMessage, localViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      }
    }
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
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131494223);
        if (paramViewHolder != null)
        {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
          if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localHolder.b.setTextColor(paramViewHolder);
            localHolder.c.setTextColor(paramViewHolder);
            localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramViewHolder);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label164;
        }
      }
      label164:
      for (paramViewHolder = paramView.getColorStateList(2131494222);; paramViewHolder = paramView.getColorStateList(2131494221))
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
          ImmersiveUtils.a(localHolder.b, 0.5F);
          ImmersiveUtils.a(localHolder.c, 0.5F);
        }
        return;
        paramViewHolder = paramView.getColorStateList(2131494220);
        break;
      }
    }
    if (paramBubbleInfo.jdField_b_of_type_Int == 0)
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localHolder.b.setTextColor(-16777216);
        localHolder.c.setTextColor(-16777216);
        localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramBubbleInfo.c != 0) {
        break label439;
      }
      paramViewHolder = paramView.getResources().getColorStateList(2131494221);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
      if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null) {
        localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
      }
      label280:
      if ((localHolder.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramBubbleInfo.jdField_a_of_type_Boolean) {
          break label476;
        }
        ((AnimationTextView)localHolder.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramBubbleInfo.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramBubbleInfo.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.a(localHolder.b, 0.5F);
      ImmersiveUtils.a(localHolder.c, 0.5F);
      return;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      if (localHolder.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localHolder.b.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localHolder.c.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      break;
      label439:
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
      if (localHolder.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label280;
      }
      localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.c);
      break label280;
      label476:
      if ((paramBubbleInfo.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHolder.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) == 1))
      {
        paramViewHolder = (AnimationTextView)localHolder.jdField_a_of_type_AndroidWidgetTextView;
        float f2 = paramViewHolder.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        paramViewHolder.setTextColor(-1);
        paramViewHolder.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.d);
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    QfavBuilder.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForLongMsg)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localQQCustomMenu.a(2131375342, this.jdField_a_of_type_AndroidContentContext.getString(2131433700), 2130838301);
      localQQCustomMenu.a(2131375344, this.jdField_a_of_type_AndroidContentContext.getString(2131433704), 2130838313);
    }
    for (;;)
    {
      localQQCustomMenu.a(2131363499, this.jdField_a_of_type_AndroidContentContext.getString(2131435066), 2130838309);
      if ((paramView.istroop == 1) && (AIOUtils.a(4) == 1)) {
        localQQCustomMenu.a(2131375354, this.jdField_a_of_type_AndroidContentContext.getString(2131430715), 2130838317);
      }
      a(paramView, localQQCustomMenu);
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131366733, this.jdField_a_of_type_AndroidContentContext.getString(2131431546), 2130838308);
      }
      if ((paramView.vipBubbleID == 100000L) && (!paramView.isSend())) {
        localQQCustomMenu.a(2131375352, this.jdField_a_of_type_AndroidContentContext.getString(2131436433), 2130838288);
      }
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
      localQQCustomMenu.a(2131375342, "复制", 2130838301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */