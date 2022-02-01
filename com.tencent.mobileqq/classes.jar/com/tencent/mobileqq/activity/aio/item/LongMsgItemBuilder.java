package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
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
  private static final int jdField_a_of_type_Int = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected View.OnClickListener a;
  AnimationTextView.OnDoubleClick jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new LongMsgItemBuilder.4(this);
  
  public LongMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new LongMsgItemBuilder.5(this);
  }
  
  private BaseChatPie a()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
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
    if (i == 2)
    {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366309, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366308, paramChatMessage, null);
    }
  }
  
  private void b(View paramView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LongMsgItemBuilder", 2, "SingleTap invoked!");
    }
    if ((paramView instanceof AnimationTextView))
    {
      Object localObject = (AnimationTextView)paramView;
      float f1 = ((AnimationTextView)localObject).touchL - e;
      float f2 = ((AnimationTextView)localObject).touchT;
      float f3 = jdField_a_of_type_Int;
      if (paramBoolean) {
        f1 = ((AnimationTextView)localObject).touchL - f;
      }
      localObject = ((AnimationTextView)localObject).getText();
      if ((localObject instanceof QQText))
      {
        localObject = (QQText)localObject;
        localObject = (EmoticonSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), EmoticonSpan.class);
        int i;
        int j;
        if ((paramView instanceof ETTextView))
        {
          paramView = (ETTextView)paramView;
          i = paramView.mClickEpId;
          j = paramView.mClickcEId;
          if ((paramView.mFont != null) && (paramView.mFont.mFontId != 0) && (paramView.mFont.mFontType == 1)) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          if ((paramBoolean) && (paramView.getETLayout() != null))
          {
            paramView = paramView.getETLayout();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("isHanYiFont, onlyEmoji: ");
              localStringBuilder.append(paramView.jdField_a_of_type_Boolean);
              QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
            }
            paramBoolean = paramView.jdField_a_of_type_Boolean ^ true;
          }
        }
        else
        {
          i = -1;
          j = -1;
          paramBoolean = false;
        }
        boolean bool;
        if ((i != -1) && (j != -1)) {
          bool = true;
        } else {
          bool = false;
        }
        EmoticonPanelUtils.a((EmoticonSpan[])localObject, f1, f2 - f3, bool, i, j, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Activity)this.jdField_a_of_type_AndroidContentContext, paramBoolean);
      }
    }
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
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
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    MessageForLongMsg localMessageForLongMsg = (MessageForLongMsg)paramChatMessage;
    int i = a(localMessageForLongMsg);
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    if (paramView == null) {
      if (i == 1)
      {
        paramView = new AnimationTextView(localContext);
        paramView.setTextColor(localContext.getResources().getColorStateList(2131167075));
        paramView.setMaxWidth(BaseChatItemLayout.e);
        paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131364524);
        localHolder.jdField_a_of_type_AndroidWidgetTextView = paramView;
        localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
        localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramView);
        localHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
      }
      else
      {
        paramView = a(localContext, localHolder, paramBaseChatItemLayout);
      }
    }
    Object localObject = paramView;
    if (i == 2)
    {
      localObject = paramView;
      if (localHolder.jdField_a_of_type_AndroidViewViewGroup == null) {
        localObject = a(localContext, localHolder, paramBaseChatItemLayout);
      }
    }
    if (localHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    }
    if (i == 2)
    {
      localHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      localContext = this.jdField_a_of_type_AndroidContentContext;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      ViewGroup localViewGroup = localHolder.jdField_a_of_type_AndroidViewViewGroup;
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = localMessageForLongMsg.mSourceMsgInfo;
      String str = localMessageForLongMsg.frienduin;
      i = localMessageForLongMsg.istroop;
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      paramView = localHolder;
      ReplyTextItemBuilder.a(localContext, localQQAppInterface, localViewGroup, localSourceMsgInfo, str, i, paramChatMessage, false, localSessionInfo);
      paramView.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    else
    {
      paramView = localHolder;
      if (paramView.jdField_a_of_type_AndroidViewViewGroup != null) {
        paramView.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    ((View)localObject).setOnTouchListener(paramOnLongClickAndTouchListener);
    ((View)localObject).setOnLongClickListener(paramOnLongClickAndTouchListener);
    if (localHolder.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if (android.text.TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb);
      } else {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForLongMsg.sb2);
      }
    }
    if ((localHolder.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView))
    {
      paramView = (AnimationTextView)localHolder.jdField_a_of_type_AndroidWidgetTextView;
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).playApolloEmoticonAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramView.getText(), paramViewHolder.jdField_b_of_type_Int, paramViewHolder.c, true);
      paramView.onDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      paramView.onSingleClick = new LongMsgItemBuilder.1(this, paramChatMessage.isSend());
      paramView.setStrokeColor(false, 0);
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
      paramView = localHolder.c;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      } else {
        paramChatMessage = null;
      }
      TroopEssenceReportUtil.a(paramViewHolder, paramView, paramChatMessage);
      return localObject;
    }
    return localObject;
  }
  
  public LinearLayout a(Context paramContext, LongMsgItemBuilder.Holder paramHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = ReplyTextItemBuilder.a(paramContext);
    localLinearLayout.addView((View)localObject);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    paramHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131371697));
    paramHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371529));
    paramHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)((ViewGroup)localObject).findViewById(2131371543));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131167075));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
    ((AnimationTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131364524);
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
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    Object localObject = null;
    paramView = localObject;
    if (localChatMessage != null)
    {
      paramView = localObject;
      if (localChatMessage.vipBubbleID == 0L) {
        paramView = this;
      }
    }
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new LongMsgItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131706444));
    localStringBuilder.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg));
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str2 = "";
    String str1 = str2;
    if (localQQAppInterface != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (android.text.TextUtils.isEmpty(str1)) {
        str1 = str2;
      }
    }
    int i = 0;
    int j = 0;
    int k = 1;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131381261: 
      b(paramChatMessage);
      return;
    case 2131377136: 
      AIOSelectableDelegateImpl.a().a(paramChatMessage);
      return;
    case 2131376471: 
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
        return;
      }
      break;
    case 2131367180: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putInt("selection_mode", this.c);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (AIOSelectableDelegateImpl.a().c())
      {
        paramChatMessage = AIOSelectableDelegateImpl.a().b();
        paramContext.putString("forward_text", paramChatMessage);
        if (paramChatMessage != null)
        {
          paramInt = j;
          if (paramChatMessage.length() == AIOSelectableDelegateImpl.a().a()) {
            paramInt = 1;
          }
        }
        else
        {
          paramInt = 0;
        }
      }
      else
      {
        paramContext.putString("forward_text", MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString());
        paramInt = k;
      }
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      if (paramInt != 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      return;
    case 2131366494: 
      a((MessageForLongMsg)paramChatMessage);
      return;
    case 2131365480: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131365311: 
      if (AIOSelectableDelegateImpl.a().c())
      {
        paramContext = AIOSelectableDelegateImpl.a().b();
        paramChatMessage = paramContext;
        paramInt = i;
        if (paramContext == null) {
          break label502;
        }
        paramChatMessage = paramContext;
        paramInt = i;
        if (paramContext.length() != AIOSelectableDelegateImpl.a().a()) {
          break label502;
        }
      }
      else
      {
        paramContext = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
      }
      paramInt = 1;
      paramChatMessage = paramContext;
      label502:
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramChatMessage);
      if (paramInt != 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForLongMsg)AIOUtils.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689933);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689934);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new LongMsgItemBuilder.2(this, paramView), new LongMsgItemBuilder.3(this)).show();
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 3)) {
      return;
    }
    paramView = paramView.getBackground();
    if (paramView != null)
    {
      paramView.setColorFilter(null);
      paramView.invalidateSelf();
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(f, jdField_a_of_type_Int, e, d);
      return;
    }
    paramView.setPadding(e, jdField_a_of_type_Int, f, d);
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
    if (localDrawable != null)
    {
      if (paramBoolean) {
        paramView = null;
      } else {
        paramView = jdField_a_of_type_AndroidGraphicsColorFilter;
      }
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a()))
    {
      if (paramBubbleInfo.jdField_b_of_type_Int == 0)
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
          localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        }
      }
      else
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
          localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
          localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        }
      }
      if (paramBubbleInfo.c == 0)
      {
        paramViewHolder = paramView.getResources().getColorStateList(2131167077);
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
          localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
        }
      }
      else
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
        if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.c);
          localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.c);
        }
      }
      if ((localHolder.jdField_a_of_type_AndroidWidgetTextView instanceof AnimationTextView)) {
        if (paramBubbleInfo.jdField_a_of_type_Boolean)
        {
          ((AnimationTextView)localHolder.jdField_a_of_type_AndroidWidgetTextView).setStrokeColor(true, paramBubbleInfo.d);
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("bubble has stroke, color = ");
            paramViewHolder.append(paramBubbleInfo.d);
            QLog.d("ChatItemBuilder", 2, paramViewHolder.toString());
          }
        }
        else if ((paramBubbleInfo.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localHolder.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Double) == 1))
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
      ImmersiveUtils.setAlpha(localHolder.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
      return;
    }
    paramViewHolder = paramView.getResources();
    int i;
    if (paramChatMessage.isSend()) {
      i = 2131167079;
    } else {
      i = 2131167075;
    }
    paramView = paramViewHolder.getColorStateList(i);
    if (paramView != null)
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
      if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramView);
        localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramView);
        localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramView);
      }
    }
    if (paramChatMessage.isSend()) {
      paramViewHolder = paramViewHolder.getColorStateList(2131167078);
    } else {
      paramViewHolder = paramViewHolder.getColorStateList(2131167077);
    }
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
    if (localHolder.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
      localHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
      ImmersiveUtils.setAlpha(localHolder.jdField_b_of_type_AndroidWidgetTextView, 0.5F);
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
  }
  
  protected void a(MessageForLongMsg paramMessageForLongMsg)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str;
      if (AIOSelectableDelegateImpl.a().c())
      {
        str = AIOSelectableDelegateImpl.a().b();
        if ((str == null) || (str.length() != AIOSelectableDelegateImpl.a().a()))
        {
          i = 0;
          break label52;
        }
      }
      else
      {
        str = null;
      }
      int i = 1;
      label52:
      if ((i == 0) && (str != null))
      {
        QfavBuilder.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramMessageForLongMsg.istroop);
      }
      else
      {
        QfavBuilder.b(paramMessageForLongMsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLongMsg).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramMessageForLongMsg.istroop);
      }
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramQQCustomMenu != null) && (paramContext != null) && (WTUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))) {
      paramQQCustomMenu.a(2131381261, paramContext.getString(2131720451), 0);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForLongMsg)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localQQCustomMenu.a(2131365311, this.jdField_a_of_type_AndroidContentContext.getString(2131718151), 2130838903);
      localQQCustomMenu.a(2131376471, this.jdField_a_of_type_AndroidContentContext.getString(2131718154), 2130838919);
    }
    else
    {
      localQQCustomMenu.a(2131365311, HardCodeUtil.a(2131706443), 2130838903);
    }
    localQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView, null);
    if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramView, new Bundle());
    }
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramView, new Bundle());
    if ((((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (b())) {
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, paramView);
    }
    if (AIOUtils.a(5) == 1) {
      localQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692184), 2130838911);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSearch", false);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380215, paramView, localBundle);
    if (paramView.msgtype == -1037) {
      a(localQQCustomMenu, paramView);
    }
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  protected boolean b()
  {
    Object localObject = a();
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = (WriteTogetherHelper)((BaseChatPie)localObject).a(74);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((WriteTogetherHelper)localObject).a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */