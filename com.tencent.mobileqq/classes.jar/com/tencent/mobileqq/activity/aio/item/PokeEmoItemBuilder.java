package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.PokeEmoItemView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleReceiverAnimationRunnable;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.AIOPopOutEmoticonConfig;
import com.tencent.mobileqq.popanim.IPopOutEmoticonAnim;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import mqq.os.MqqHandler;

public class PokeEmoItemBuilder
  extends BaseBubbleBuilder
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StickerBubbleReceiverAnimationRunnable jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable;
  protected long c = 0L;
  
  public PokeEmoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(PokeEmoItemBuilder.Holder paramHolder, MessageForPokeEmo paramMessageForPokeEmo)
  {
    int i = paramMessageForPokeEmo.pokeemoId;
    int j = paramMessageForPokeEmo.pokeemoPressCount;
    paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramMessageForPokeEmo;
    PokeItemHelper.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool = PokeItemHelper.b;
    Object localObject;
    StringBuilder localStringBuilder;
    if (i == 13)
    {
      if (paramMessageForPokeEmo.emoIndex >= 0)
      {
        localObject = QQSysFaceUtil.getFaceGifDrawable(QQSysFaceUtil.convertToLocal(paramMessageForPokeEmo.emoIndex));
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable((Drawable)localObject);
        localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("x");
        localStringBuilder.append(Integer.toString(paramMessageForPokeEmo.pokeemoPressCount));
        ((PokeEmoItemView)localObject).setText(localStringBuilder.toString());
      }
      else
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841546);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("x");
        localStringBuilder.append(paramMessageForPokeEmo.pokeemoPressCount);
        ((PokeEmoItemView)localObject).setText(localStringBuilder.toString());
      }
    }
    else if (bool)
    {
      localObject = PEPanelHelper.a(i);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable((Drawable)localObject);
      localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("x");
      localStringBuilder.append(Integer.toString(paramMessageForPokeEmo.pokeemoPressCount));
      ((PokeEmoItemView)localObject).setText(localStringBuilder.toString());
    }
    else
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841546);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("x");
      localStringBuilder.append(paramMessageForPokeEmo.pokeemoPressCount);
      ((PokeEmoItemView)localObject).setText(localStringBuilder.toString());
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setIsSend(paramMessageForPokeEmo.isSend());
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmoItemBuilder", 2, String.format(" initBubbleView.forbidPoke=%b,isResDownload = %b,pokeMsg.isPlay = %b,animatingCount = %d,emoId = %d", new Object[] { Boolean.valueOf(AIOUtils.l), Boolean.valueOf(bool), Boolean.valueOf(paramMessageForPokeEmo.isNeedPlayed), Integer.valueOf(AIOUtils.b), Integer.valueOf(paramMessageForPokeEmo.pokeemoId) }));
    }
    if (QLog.isColorLevel())
    {
      paramHolder = new StringBuilder();
      paramHolder.append("sGesturePWDUnlockShowing: ");
      paramHolder.append(GesturePWDUnlockActivity.sGesturePWDUnlockShowing);
      QLog.d("PokeEmoItemBuilder", 2, paramHolder.toString());
    }
    if (AIOUtils.l) {
      return;
    }
    if ((bool) && (!paramMessageForPokeEmo.isSend()) && (paramMessageForPokeEmo.isNeedPlayed) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!GesturePWDUnlockActivity.sGesturePWDUnlockShowing))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "show animation from item builder");
      }
      if (i == 13)
      {
        a(paramMessageForPokeEmo);
        paramMessageForPokeEmo.isread = true;
        paramMessageForPokeEmo.setIsNeedPlayed(false);
        b(paramMessageForPokeEmo);
        return;
      }
      AIOUtils.b += 1;
      paramMessageForPokeEmo.setIsNeedPlayed(false);
      paramMessageForPokeEmo.isread = true;
      paramHolder = ((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362288);
      if (paramHolder != null)
      {
        localObject = PEPanelHelper.b(i);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable = new StickerBubbleReceiverAnimationRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, paramHolder, (String)localObject);
        ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable);
      }
      b(paramMessageForPokeEmo);
      return;
    }
    if (!paramMessageForPokeEmo.isNeedPlayed) {
      paramMessageForPokeEmo.setIsNeedPlayed(false);
    }
  }
  
  private void b(MessageForPokeEmo paramMessageForPokeEmo)
  {
    paramMessageForPokeEmo.isread = true;
    paramMessageForPokeEmo.prewrite();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPokeEmo.uniseq, paramMessageForPokeEmo.msgData);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    paramBaseChatItemLayout = (MessageForPokeEmo)paramChatMessage;
    PokeEmoItemBuilder.Holder localHolder = (PokeEmoItemBuilder.Holder)paramViewHolder;
    if (QLog.isColorLevel())
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("type: ");
      paramViewHolder.append(paramBaseChatItemLayout.pokeemoId);
      paramViewHolder.append(" count: ");
      paramViewHolder.append(paramBaseChatItemLayout.pokeemoPressCount);
      QLog.d("PokeMsg", 2, paramViewHolder.toString());
    }
    paramViewHolder = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "[getBubbleView]:content is null");
      }
      paramViewHolder = new RelativeLayout((Context)localObject);
      paramViewHolder.setId(2131376809);
      paramView = new PokeEmoItemView((Context)localObject);
      paramView.setId(2131372926);
      paramViewHolder.addView(paramView, new ViewGroup.LayoutParams(-1, AIOUtils.b(80.0F, ((Context)localObject).getResources())));
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView = paramView;
      localObject = PEPanelHelper.a;
      if (localObject != null)
      {
        QLog.e("PokeEmoItemBuilder", 1, "mTypeface  != null ");
        paramView.setTypeFace((Typeface)localObject);
      }
      else if ((PokeItemHelper.b) && (!PEPanelHelper.b))
      {
        PEPanelHelper.b = true;
        ThreadManager.executeOnSubThread(new PokeEmoItemBuilder.1(this));
      }
      paramView.setText("x3");
      AccessibilityUtil.a(paramView, false);
    }
    if ((!localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.a()) && (PEPanelHelper.a != null)) {
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePokeEmoItemView.setTypeFace(PEPanelHelper.a);
    }
    paramView = new StringBuilder();
    paramView.append("PEPanelHelper.mTypeface != null :");
    paramView.append(PEPanelHelper.a);
    boolean bool;
    if (paramView.toString() != null) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.e("PokeEmoItemBuilder", 1, new Object[] { Boolean.valueOf(bool) });
    paramViewHolder.setTag(localHolder);
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    a(localHolder, paramBaseChatItemLayout);
    if (e)
    {
      if ((localHolder.b != null) && (localHolder.b.length() > 0)) {
        localHolder.b.setLength(0);
      }
      paramViewHolder.setContentDescription(a(paramChatMessage));
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PokeEmoItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L)
    {
      localStringBuilder.append(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L));
      localStringBuilder.append(" ");
    }
    MessageForPokeEmo localMessageForPokeEmo = (MessageForPokeEmo)paramChatMessage;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("轻互动表情");
    ((StringBuilder)localObject).append(localMessageForPokeEmo.summary);
    localObject = ((StringBuilder)localObject).toString();
    if (localMessageForPokeEmo.pokeemoId == 13)
    {
      localObject = "弹射表情";
      if (localMessageForPokeEmo.emoIndex >= 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("弹射表情");
        ((StringBuilder)localObject).append(localMessageForPokeEmo.emoCompat);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    if (paramChatMessage.isSend())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("我向");
      paramChatMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      paramChatMessage.append(String.format("发出%d个%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localObject }));
      localStringBuilder.append(paramChatMessage.toString());
    }
    else
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      paramChatMessage.append(String.format("发来%d个%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localObject }));
      localStringBuilder.append(paramChatMessage.toString());
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    super.a();
    AIOUtils.b = 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForPokeEmo)AIOUtils.a(paramView);
    if (paramView.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.addButton(2131689933, 5);
      localActionSheet.addCancelButton(2131690728);
      localActionSheet.setOnButtonClickListener(new PokeEmoItemBuilder.2(this, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  protected void a(MessageForPokeEmo paramMessageForPokeEmo)
  {
    ViewGroup localViewGroup = (ViewGroup)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362288);
    AIOPopOutEmoticonConfig localAIOPopOutEmoticonConfig = new AIOPopOutEmoticonConfig(null, localViewGroup);
    localAIOPopOutEmoticonConfig.init();
    ((IPopOutEmoticonAnim)QRoute.api(IPopOutEmoticonAnim.class)).playPopEmoAnimation(localViewGroup, localAIOPopOutEmoticonConfig, paramMessageForPokeEmo.emoIndex, paramMessageForPokeEmo.pokeemoPressCount);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPokeEmo)) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 0)) {
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeEmoItemBuilder
 * JD-Core Version:    0.7.0.1
 */