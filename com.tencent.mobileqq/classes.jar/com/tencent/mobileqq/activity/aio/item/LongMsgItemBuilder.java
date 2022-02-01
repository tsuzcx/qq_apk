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
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
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
  private static final int x = BaseChatItemLayout.k + BaseChatItemLayout.n;
  private static final int y = BaseChatItemLayout.l + BaseChatItemLayout.o;
  AnimationTextView.OnDoubleClick a = new LongMsgItemBuilder.4(this);
  protected View.OnClickListener w = new LongMsgItemBuilder.5(this);
  
  public LongMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(ChatMessage paramChatMessage, LongMsgItemBuilder.Holder paramHolder)
  {
    paramChatMessage = VasShieldFont.a(paramChatMessage);
    if (paramHolder.a != null) {
      paramHolder.a.setTypeface(paramChatMessage);
    }
    if (paramHolder.d != null) {
      paramHolder.d.setTypeface(paramChatMessage);
    }
    if (paramHolder.e != null) {
      paramHolder.e.setTypeface(paramChatMessage);
    }
    if (paramHolder.c != null) {
      paramHolder.c.setTypeface(paramChatMessage);
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopTodoUtils.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131430283, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131430651, paramChatMessage, null);
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
      float f1 = ((AnimationTextView)localObject).touchL - BaseChatItemLayout.getTextBubblePaddingAlignHead();
      float f2 = ((AnimationTextView)localObject).touchT;
      float f3 = x;
      if (paramBoolean) {
        f1 = ((AnimationTextView)localObject).touchL - BaseChatItemLayout.getTextBubblePaddingAlignError();
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
              localStringBuilder.append(paramView.g);
              QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
            }
            paramBoolean = paramView.g ^ true;
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
        EmoticonPanelUtils.a((EmoticonSpan[])localObject, f1, f2 - f3, bool, i, j, this.d, this.f, (Activity)this.e, paramBoolean);
      }
    }
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if ((this.e instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.e).getChatFragment().k();
      if (localObject != null)
      {
        localObject = (WriteTogetherHelper)((BaseChatPie)localObject).q(74);
        if ((localObject != null) && ((paramChatMessage instanceof MessageForLongMsg))) {
          ((WriteTogetherHelper)localObject).b(((MessageForLongMsg)paramChatMessage).sb.toString(), 3);
        }
      }
    }
  }
  
  private void b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
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
  
  private BaseChatPie i()
  {
    if (!(this.e instanceof BaseActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((BaseActivity)this.e).getChatFragment();
    if (localChatFragment == null)
    {
      QLog.e("ChatItemBuilder", 1, "[getChatPie] ChatFragment is null");
      return null;
    }
    return localChatFragment.k();
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
        paramView.setTextColor(localContext.getResources().getColorStateList(2131168016));
        paramView.setMaxWidth(BaseChatItemLayout.e);
        paramView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        paramView.setId(2131430581);
        localHolder.a = paramView;
        localHolder.f = new AIOSelectableDelegateProxy();
        localHolder.f.a(paramView);
        localHolder.f.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
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
      if (localHolder.b == null) {
        localObject = a(localContext, localHolder, paramBaseChatItemLayout);
      }
    }
    if (localHolder.a != null) {
      localHolder.a.setTextSize(0, this.f.r);
    }
    if (i == 2)
    {
      localHolder.b.setVisibility(0);
      localContext = this.e;
      QQAppInterface localQQAppInterface = this.d;
      ViewGroup localViewGroup = localHolder.b;
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = localMessageForLongMsg.mSourceMsgInfo;
      String str = localMessageForLongMsg.frienduin;
      i = localMessageForLongMsg.istroop;
      SessionInfo localSessionInfo = this.f;
      paramView = localHolder;
      ReplyTextItemBuilder.a(localContext, localQQAppInterface, localViewGroup, localSourceMsgInfo, str, i, paramChatMessage, false, localSessionInfo);
      paramView.b.setOnClickListener(this.w);
      paramView.b.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    else
    {
      paramView = localHolder;
      if (paramView.b != null) {
        paramView.b.setVisibility(8);
      }
    }
    ((View)localObject).setOnTouchListener(paramOnLongClickAndTouchListener);
    ((View)localObject).setOnLongClickListener(paramOnLongClickAndTouchListener);
    if (localHolder.a != null)
    {
      localHolder.a.setOnTouchListener(paramOnLongClickAndTouchListener);
      localHolder.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if (android.text.TextUtils.isEmpty(localMessageForLongMsg.sb2)) {
        localHolder.a.setText(localMessageForLongMsg.sb);
      } else {
        localHolder.a.setText(localMessageForLongMsg.sb2);
      }
    }
    if ((localHolder.a instanceof AnimationTextView))
    {
      paramView = (AnimationTextView)localHolder.a;
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).playApolloEmoticonAction(this.d, this.f, paramChatMessage, paramView.getText(), paramViewHolder.l, paramViewHolder.m, true);
      paramView.onDoubleClick = this.a;
      paramView.onSingleClick = new LongMsgItemBuilder.1(this, paramChatMessage.isSend());
      paramView.setStrokeColor(false, 0);
    }
    if ((localHolder.d instanceof AnimationTextView)) {
      localHolder.d.onDoubleClick = this.a;
    }
    if ((localHolder.e instanceof AnimationTextView)) {
      localHolder.e.onDoubleClick = this.a;
    }
    a(paramChatMessage, localHolder);
    if (localHolder.f != null) {
      localHolder.f.b(paramChatMessage);
    }
    if (this.d != null)
    {
      localHolder.g = super.a(localHolder.g, localHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
      super.a(localHolder.g, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
      paramViewHolder = this.d;
      paramView = localHolder.g;
      if (this.f != null) {
        paramChatMessage = this.f.b;
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
    paramHolder.b = ((ViewGroup)localObject);
    paramHolder.c = ((TextView)((ViewGroup)localObject).findViewById(2131439121));
    paramHolder.d = ((ETTextView)((ViewGroup)localObject).findViewById(2131438908));
    paramHolder.e = ((ETTextView)((ViewGroup)localObject).findViewById(2131438922));
    localObject = new AnimationTextView(paramContext);
    ((AnimationTextView)localObject).setTextColor(paramContext.getResources().getColorStateList(2131168016));
    ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
    ((AnimationTextView)localObject).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ((AnimationTextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
    ((AnimationTextView)localObject).setId(2131430581);
    localLinearLayout.addView((View)localObject);
    paramHolder.a = ((TextView)localObject);
    int i = BaseChatItemLayout.getTextPaddingAlignHead();
    int j = BaseChatItemLayout.getTextPaddingAlignError();
    ((AnimationTextView)localObject).setPadding(i, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
    paramHolder.f = new AIOSelectableDelegateProxy();
    paramHolder.f.a((SelectableComponent)localObject);
    paramHolder.f.a(paramBaseChatItemLayout, paramBaseChatItemLayout);
    return localLinearLayout;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new LongMsgItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    QQAppInterface localQQAppInterface = this.d;
    String str2 = "";
    String str1 = str2;
    if (localQQAppInterface != null)
    {
      str1 = this.d.getCurrentAccountUin();
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
    case 2131450309: 
      b(paramChatMessage);
      return;
    case 2131445511: 
      AIOSelectableDelegateImpl.a().a(paramChatMessage);
      return;
    case 2131444710: 
      if (this.d != null)
      {
        ChatActivityFacade.a(this.d, this.e, this.f, (MessageForLongMsg)paramChatMessage);
        return;
      }
      break;
    case 2131433636: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putInt("selection_mode", this.u);
      paramContext.putInt("forward_source_uin_type", this.f.a);
      if (AIOSelectableDelegateImpl.a().l())
      {
        paramChatMessage = AIOSelectableDelegateImpl.a().d();
        paramContext.putString("forward_text", paramChatMessage);
        if (paramChatMessage != null)
        {
          paramInt = j;
          if (paramChatMessage.length() == AIOSelectableDelegateImpl.a().c()) {
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
      ForwardBaseOption.a((Activity)this.e, paramChatMessage, 21);
      ReportController.b(this.d, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      if (paramInt != 0)
      {
        ReportController.b(this.d, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      return;
    case 2131432813: 
      b((MessageForLongMsg)paramChatMessage);
      return;
    case 2131431695: 
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      return;
    case 2131431492: 
      if (AIOSelectableDelegateImpl.a().l())
      {
        paramContext = AIOSelectableDelegateImpl.a().d();
        paramChatMessage = paramContext;
        paramInt = i;
        if (paramContext == null) {
          break label502;
        }
        paramChatMessage = paramContext;
        paramInt = i;
        if (paramContext.length() != AIOSelectableDelegateImpl.a().c()) {
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
      ((ClipboardManager)this.e.getSystemService("clipboard")).setText(paramChatMessage);
      if (paramInt != 0)
      {
        ReportController.b(this.d, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 3)) {
      return;
    }
    a(paramView.getBackground(), null);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignError(), x, BaseChatItemLayout.getTextBubblePaddingAlignHead(), y);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignHead(), x, BaseChatItemLayout.getTextBubblePaddingAlignError(), y);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if (paramInt == 1)
    {
      BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      if (localViewHolder != null) {
        a(localViewHolder, paramView, paramChatMessage, localViewHolder.i);
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (paramBoolean) {
      paramView = null;
    } else {
      paramView = n;
    }
    a(localDrawable, paramView);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    LongMsgItemBuilder.Holder localHolder = (LongMsgItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()))
    {
      if (paramBubbleInfo.l == 0)
      {
        localHolder.a.setTextColor(-16777216);
        if (localHolder.b != null)
        {
          localHolder.c.setTextColor(-16777216);
          localHolder.d.setTextColor(-16777216);
          localHolder.e.setTextColor(-16777216);
        }
      }
      else
      {
        localHolder.a.setTextColor(paramBubbleInfo.l);
        if (localHolder.b != null)
        {
          localHolder.c.setTextColor(paramBubbleInfo.l);
          localHolder.d.setTextColor(paramBubbleInfo.l);
          localHolder.e.setTextColor(paramBubbleInfo.l);
        }
      }
      if (paramBubbleInfo.m == 0)
      {
        paramViewHolder = paramView.getResources().getColorStateList(2131168018);
        localHolder.a.setLinkTextColor(paramViewHolder);
        if (localHolder.b != null)
        {
          localHolder.d.setLinkTextColor(paramViewHolder);
          localHolder.e.setLinkTextColor(paramViewHolder);
        }
      }
      else
      {
        localHolder.a.setLinkTextColor(paramBubbleInfo.m);
        if (localHolder.b != null)
        {
          localHolder.d.setLinkTextColor(paramBubbleInfo.m);
          localHolder.e.setLinkTextColor(paramBubbleInfo.m);
        }
      }
      if ((localHolder.a instanceof AnimationTextView)) {
        if (paramBubbleInfo.o)
        {
          ((AnimationTextView)localHolder.a).setStrokeColor(true, paramBubbleInfo.n);
          if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("bubble has stroke, color = ");
            paramViewHolder.append(paramBubbleInfo.n);
            QLog.d("ChatItemBuilder", 2, paramViewHolder.toString());
          }
        }
        else if ((paramBubbleInfo.p) && (((ChatBackgroundManager)this.d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.e, this.f, localHolder.a.getCurrentTextColor(), 10000.0D * localHolder.i.q) == 1))
        {
          paramViewHolder = (AnimationTextView)localHolder.a;
          float f2 = paramViewHolder.getTextSize() * 3.0F / 16.0F;
          float f1 = f2;
          if (f2 > 25.0F) {
            f1 = 25.0F;
          }
          paramViewHolder.setTextColor(-1);
          paramViewHolder.setShadowLayer(f1, 0.0F, 0.0F, paramBubbleInfo.n);
        }
      }
      ImmersiveUtils.setAlpha(localHolder.c, 0.5F);
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
    if (paramView != null)
    {
      localHolder.a.setTextColor(paramView);
      if (localHolder.b != null)
      {
        localHolder.c.setTextColor(paramView);
        localHolder.d.setTextColor(paramView);
        localHolder.e.setTextColor(paramView);
      }
    }
    if (paramChatMessage.isSend()) {
      paramViewHolder = paramViewHolder.getColorStateList(2131168019);
    } else {
      paramViewHolder = paramViewHolder.getColorStateList(2131168018);
    }
    localHolder.a.setLinkTextColor(paramViewHolder);
    if (localHolder.b != null)
    {
      localHolder.d.setLinkTextColor(paramViewHolder);
      localHolder.e.setLinkTextColor(paramViewHolder);
      localHolder.a.setLinkTextColor(paramViewHolder);
      ImmersiveUtils.setAlpha(localHolder.c, 0.5F);
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramQQCustomMenu != null) && (paramContext != null) && (WTUtils.a(this.f))) {
      paramQQCustomMenu.a(2131450309, paramContext.getString(2131918127), 0);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForLongMsg)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal()))
    {
      localQQCustomMenu.a(2131431492, this.e.getString(2131915629), 2130839057);
      localQQCustomMenu.a(2131444710, this.e.getString(2131915632), 2130839073);
    }
    else
    {
      localQQCustomMenu.a(2131431492, HardCodeUtil.a(2131904302), 2130839057);
    }
    localQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
    a(localQQCustomMenu, this.e, 2131444634, paramView, null);
    if ((paramView.extraflag != 32768) && (!this.d.getMsgCache().f(paramView))) {
      a(localQQCustomMenu, this.e, 2131438943, paramView, new Bundle());
    }
    a(localQQCustomMenu, this.e, 2131431695, paramView, new Bundle());
    a(localQQCustomMenu, paramView);
    if ((((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.d, this.f.b)) && (h())) {
      a(localQQCustomMenu, this.e, paramView);
    }
    if (AIOUtils.a(5) == 1) {
      localQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSearch", false);
    super.a(localQQCustomMenu, this.e, 2131449133, paramView, localBundle);
    if (paramView.msgtype == -1037) {
      b(localQQCustomMenu, paramView);
    }
    a(localQQCustomMenu, this.e, 2131444651, paramView, null);
    super.a(localQQCustomMenu, this.e, 2131439015, null, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForLongMsg)AIOUtils.a(paramView);
    String str1 = this.e.getString(2131886574);
    String str2 = this.e.getString(2131886575);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.e, 230, str1, str2, new LongMsgItemBuilder.2(this, paramView), new LongMsgItemBuilder.3(this)).show();
    }
  }
  
  protected void b(MessageForLongMsg paramMessageForLongMsg)
  {
    if (this.d != null)
    {
      String str;
      if (AIOSelectableDelegateImpl.a().l())
      {
        str = AIOSelectableDelegateImpl.a().d();
        if ((str == null) || (str.length() != AIOSelectableDelegateImpl.a().c()))
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
        QfavBuilder.a(null, str).b(this.d, paramMessageForLongMsg).a((Activity)this.e, this.d.getAccount());
        QfavReport.a(this.d, 1, 0, paramMessageForLongMsg.istroop);
      }
      else
      {
        QfavBuilder.b(paramMessageForLongMsg).b(this.d, paramMessageForLongMsg).a((Activity)this.e, this.d.getAccount());
        QfavReport.a(this.d, 4, 0, paramMessageForLongMsg.istroop);
      }
      QfavReport.a(this.d, 6, 8);
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
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
  
  protected String d(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131904303));
    localStringBuilder.append(com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(paramChatMessage.msg));
    return localStringBuilder.toString();
  }
  
  protected boolean h()
  {
    Object localObject = i();
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = (WriteTogetherHelper)((BaseChatPie)localObject).q(74);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((WriteTogetherHelper)localObject).d()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */