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
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.WriteTogetherHelper;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.SelectableComponent;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.together.writetogether.WTUtils;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;

public class LongMsgItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate
{
  private static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected View.OnClickListener a;
  AnimationTextView.OnDoubleClick a;
  
  public LongMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new LongMsgItemBuilder.4(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new LongMsgItemBuilder.5(this);
  }
  
  private BaseChatPie a()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if (localChatFragment == null)
    {
      QLog.e("ChatItemBuilder", 1, "[getChatPie] ChatFragment is null");
      return null;
    }
    return localChatFragment.a();
  }
  
  private void a(ChatMessage paramChatMessage, LongMsgItemBuilder.Holder paramHolder)
  {
    paramChatMessage = VasShieldFont.a(paramChatMessage);
    if (paramHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
    }
    if (paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
      paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
    if (paramHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null) {
      paramHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
    }
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
  
  private void b(View paramView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LongMsgItemBuilder", 2, "SingleTap invoked!");
    }
    Object localObject;
    float f1;
    float f2;
    float f3;
    int k;
    boolean bool;
    int j;
    if ((paramView instanceof AnimationTextView))
    {
      localObject = (AnimationTextView)paramView;
      f1 = ((AnimationTextView)localObject).touchL - e;
      f2 = ((AnimationTextView)localObject).touchT;
      f3 = c;
      if (paramBoolean) {
        f1 = ((AnimationTextView)localObject).touchL - f;
      }
      localObject = ((AnimationTextView)localObject).getText();
      if ((localObject instanceof QQText))
      {
        localObject = (QQText)localObject;
        localObject = (EmoticonSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), EmoticonSpan.class);
        if (!(paramView instanceof ETTextView)) {
          break label317;
        }
        paramView = (ETTextView)paramView;
        k = paramView.mClickEpId;
        int m = paramView.mClickcEId;
        if ((paramView.mFont == null) || (paramView.mFont.mFontId == 0) || (paramView.mFont.mFontType != 1)) {
          break label300;
        }
        bool = true;
        i = k;
        j = m;
        paramBoolean = bool;
        if (bool)
        {
          i = k;
          j = m;
          paramBoolean = bool;
          if (paramView.getETLayout() != null)
          {
            paramView = paramView.getETLayout();
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "isHanYiFont, onlyEmoji: " + paramView.jdField_a_of_type_Boolean);
            }
            if (paramView.jdField_a_of_type_Boolean) {
              break label306;
            }
            paramBoolean = true;
            label243:
            j = m;
          }
        }
      }
    }
    for (int i = k;; i = -1)
    {
      if ((i != -1) && (j != -1)) {}
      for (bool = true;; bool = false)
      {
        EmoticonUtils.clickSmallEmoticon((EmoticonSpan[])localObject, f1, f2 - f3, bool, i, j, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Activity)this.jdField_a_of_type_AndroidContentContext, paramBoolean);
        return;
        label300:
        bool = false;
        break;
        label306:
        paramBoolean = false;
        break label243;
      }
      label317:
      paramBoolean = false;
      j = -1;
    }
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      if (localObject != null)
      {
        localObject = (WriteTogetherHelper)((BaseChatPie)localObject).a(74);
        if ((localObject != null) && ((paramChatMessage instanceof MessageForLongMsg))) {
          ((WriteTogetherHelper)localObject).b(((MessageForLongMsg)paramChatMessage).sb.toString(), 3);
        }
      }
    }
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
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131167052));
        paramView.setMaxWidth(BaseChatItemLayout.e);
        paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364637);
        localHolder.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
        localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramView);
        localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      if ((i == 2) && (localHolder.jdField_a_of_type_AndroidViewViewGroup == null)) {
        paramView = a(localContext, localHolder, paramBaseChatItemLayout);
      }
      for (;;)
      {
        if (localHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        }
        if (i == 2)
        {
          localHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          ReplyTextItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHolder.jdField_a_of_type_AndroidViewViewGroup, localMessageForLongMsg.mSourceMsgInfo, localMessageForLongMsg.frienduin, localMessageForLongMsg.istroop, paramChatMessage, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramOnLongClickAndTouchListener);
          localHolder.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramOnLongClickAndTouchListener);
          label263:
          paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
          if (localHolder.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
            if (!android.text.TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
              break label609;
            }
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
          }
          label327:
          if ((localHolder.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
          {
            paramOnLongClickAndTouchListener = (AnimationTextView)localHolder.jdField_a_of_type_AndroidWidgetTextView;
            ((IApolloUtil)QRoute.api(IApolloUtil.class)).playApolloEmoticonAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramOnLongClickAndTouchListener, paramViewHolder.jdField_b_of_type_Int, paramViewHolder.c, true);
            paramOnLongClickAndTouchListener.onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
            paramOnLongClickAndTouchListener.onSingleClick = new LongMsgItemBuilder.1(this, paramChatMessage.isSend());
            paramOnLongClickAndTouchListener.setStrokeColor(false, 0);
          }
          if ((localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
          }
          if ((localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView instanceof AnimationTextView)) {
            localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
          }
          a(paramChatMessage, localHolder);
          if (localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy != null) {
            localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b(paramChatMessage);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localHolder.c = super.a(localHolder.c, localHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
            super.a(localHolder.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
            paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            paramBaseChatItemLayout = localHolder.c;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
              break label625;
            }
          }
        }
        label609:
        label625:
        for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; paramChatMessage = null)
        {
          TroopEssenceReportUtil.a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage);
          return paramView;
          paramView = a(localContext, localHolder, paramBaseChatItemLayout);
          break;
          if (localHolder.jdField_a_of_type_AndroidViewViewGroup == null) {
            break label263;
          }
          localHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          break label263;
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
          break label327;
        }
      }
    }
  }
  
  public LinearLayout a(Context paramContext, LongMsgItemBuilder.Holder paramHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = ReplyTextItemBuilder.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131372115));
    paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371908));
    paramHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371926));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167052));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
    ((AnimationTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364637);
    localLinearLayout.addView((View)localObject);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    int i = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a((SelectableComponent)localObject);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
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
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new LongMsgItemBuilder.Holder(this);
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131706393) + com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      str1 = str2;
      if (android.text.TextUtils.isEmpty(str2)) {
        str1 = "";
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131365636: 
    case 2131365448: 
    case 2131376982: 
      do
      {
        return;
        str1 = "";
        break;
        ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
        if (AIOSelectableDelegateImpl.a().c())
        {
          paramContext = AIOSelectableDelegateImpl.a().b();
          if (paramContext != null) {
            if (paramContext.length() == AIOSelectableDelegateImpl.a().a()) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext);
          if (paramInt == 0) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
          paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
          paramInt = 1;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
      return;
    case 2131367398: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (AIOSelectableDelegateImpl.a().c())
      {
        paramChatMessage = AIOSelectableDelegateImpl.a().b();
        paramContext.putString("forward_text", paramChatMessage);
        if (paramChatMessage != null) {
          if (paramChatMessage.length() == AIOSelectableDelegateImpl.a().a()) {
            paramInt = 1;
          }
        }
      }
      for (;;)
      {
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        if (paramInt == 0) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
        return;
        paramInt = 0;
        continue;
        paramInt = 0;
        continue;
        paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
        paramInt = 1;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      return;
    case 2131366625: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131377708: 
      AIOSelectableDelegateImpl.a().a(paramChatMessage);
      return;
    }
    b(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForLongMsg)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690018);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690019);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new LongMsgItemBuilder.2(this, paramView), new LongMsgItemBuilder.3(this)).show();
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
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(f, c, e, d);
      return;
    }
    paramView.setPadding(e, c, f, d);
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
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      int i;
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131167056);
        if (paramViewHolder != null)
        {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
          if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
            localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramViewHolder);
            localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramViewHolder);
          }
        }
        if (LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          if (!paramChatMessage.isSend()) {
            break label240;
          }
          i = -1;
          label110:
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
          if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
          {
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
            localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
            localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
          }
        }
        if (!paramChatMessage.isSend()) {
          break label248;
        }
      }
      label240:
      label248:
      for (paramViewHolder = paramView.getColorStateList(2131167055);; paramViewHolder = paramView.getColorStateList(2131167054))
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
          localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
          ImmersiveUtils.setAlpha(localHolder.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
        }
        return;
        paramViewHolder = paramView.getColorStateList(2131167052);
        break;
        i = -16777216;
        break label110;
      }
    }
    if (paramBubbleInfo.jdField_b_of_type_Int == 0)
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      }
      if (paramBubbleInfo.c != 0) {
        break label520;
      }
      paramViewHolder = paramView.getResources().getColorStateList(2131167054);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
      if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
        localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
      }
      label373:
      if ((localHolder.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
      {
        if (!paramBubbleInfo.jdField_a_of_type_Boolean) {
          break label570;
        }
        ((AnimationTextView)localHolder.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramBubbleInfo.d);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble has stroke, color = " + paramBubbleInfo.d);
        }
      }
    }
    for (;;)
    {
      ImmersiveUtils.setAlpha(localHolder.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      if (localHolder.jdField_a_of_type_AndroidViewViewGroup == null) {
        break;
      }
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      break;
      label520:
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
      if (localHolder.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label373;
      }
      localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.c);
      localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.c);
      break label373;
      label570:
      if ((paramBubbleInfo.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHolder.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) == 1))
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!AIOSelectableDelegateImpl.a().c()) {
        break label115;
      }
      str = AIOSelectableDelegateImpl.a().b();
      if (str == null) {
        break label110;
      }
      if (str.length() != AIOSelectableDelegateImpl.a().a()) {
        break label105;
      }
      i = 1;
      if ((i == 0) && (str != null)) {
        break label122;
      }
      QfavBuilder.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramMessageForLongMsg.istroop);
    }
    for (;;)
    {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
      return;
      label105:
      i = 0;
      break;
      label110:
      i = 0;
      break;
      label115:
      str = null;
      i = 1;
      break;
      label122:
      QfavBuilder.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramMessageForLongMsg.istroop);
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramQQCustomMenu != null) && (paramContext != null) && (WTUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      paramQQCustomMenu.a(2131382059, paramContext.getString(2131720726), 0);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForLongMsg)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (ApolloGameUtil.a(paramView)) {
      return localQQCustomMenu.a();
    }
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localQQCustomMenu.a(2131365448, this.jdField_a_of_type_AndroidContentContext.getString(2131718486), 2130839050);
      localQQCustomMenu.a(2131376982, this.jdField_a_of_type_AndroidContentContext.getString(2131718489), 2130839066);
    }
    for (;;)
    {
      localQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramView, null);
      if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramView, new Bundle());
      }
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramView, new Bundle());
      if ((((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (b())) {
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, paramView);
      }
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isSearch", false);
      super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380949, paramView, localBundle);
      if (paramView.msgtype == -1037) {
        a(localQQCustomMenu, paramView);
      }
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramView, null);
      super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
      super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return localQQCustomMenu.a();
      localQQCustomMenu.a(2131365448, HardCodeUtil.a(2131706392), 2130839050);
    }
  }
  
  protected boolean b()
  {
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    localObject = (WriteTogetherHelper)((BaseChatPie)localObject).a(74);
    if ((localObject != null) && (((WriteTogetherHelper)localObject).a())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */