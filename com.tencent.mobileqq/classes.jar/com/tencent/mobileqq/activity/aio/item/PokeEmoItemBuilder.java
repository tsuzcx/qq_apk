package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.PETextView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleReceiverAnimationRunnable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import mqq.os.MqqHandler;
import vhw;
import vhx;

public class PokeEmoItemBuilder
  extends BaseBubbleBuilder
{
  private StickerBubbleReceiverAnimationRunnable a;
  public long c;
  
  public PokeEmoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(PokeEmoItemBuilder.Holder paramHolder, MessageForPokeEmo paramMessageForPokeEmo)
  {
    int i = paramMessageForPokeEmo.pokeemoId;
    int j = paramMessageForPokeEmo.pokeemoPressCount;
    paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramMessageForPokeEmo;
    PokeItemHelper.c();
    boolean bool = PokeItemHelper.b;
    if (bool)
    {
      Drawable localDrawable = PEPanelHelper.a(i);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePETextView.setText("x" + Integer.toString(paramMessageForPokeEmo.pokeemoPressCount));
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, String.format(" initBubbleView.forbidPoke=%b,isResDownload = %b,pokeMsg.isPlay = %b,animatingCount = %d,emoId = %d", new Object[] { Boolean.valueOf(AIOUtils.k), Boolean.valueOf(bool), Boolean.valueOf(paramMessageForPokeEmo.isNeedPlayed), Integer.valueOf(AIOUtils.b), Integer.valueOf(paramMessageForPokeEmo.pokeemoId) }));
      }
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "sGesturePWDUnlockShowing: " + GesturePWDUnlockActivity.c);
      }
      if (!AIOUtils.k) {
        break label225;
      }
    }
    label225:
    label353:
    do
    {
      do
      {
        return;
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839569);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePETextView.setText("x" + paramMessageForPokeEmo.pokeemoPressCount);
        break;
        if ((!bool) || (paramMessageForPokeEmo.isSend()) || (!paramMessageForPokeEmo.isNeedPlayed) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C)) || (GesturePWDUnlockActivity.c)) {
          break label353;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PokeEmoItemBuilder", 2, "show animation from item builder");
        }
        AIOUtils.b += 1;
        paramMessageForPokeEmo.setIsNeedPlayed(false);
        paramHolder = ((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131363510);
      } while (paramHolder == null);
      paramMessageForPokeEmo = PEPanelHelper.b(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable = new StickerBubbleReceiverAnimationRunnable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, paramHolder, paramMessageForPokeEmo);
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleReceiverAnimationRunnable);
      return;
    } while (paramMessageForPokeEmo.isNeedPlayed);
    paramMessageForPokeEmo.setIsNeedPlayed(false);
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
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "type: " + paramBaseChatItemLayout.pokeemoId + " count: " + paramBaseChatItemLayout.pokeemoPressCount);
    }
    paramViewHolder = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmoItemBuilder", 2, "[getBubbleView]:content is null");
      }
      paramViewHolder = new RelativeLayout((Context)localObject);
      paramViewHolder.setId(2131362845);
      paramView = new ImageView((Context)localObject);
      paramView.setId(2131362459);
      paramViewHolder.addView(paramView, new RelativeLayout.LayoutParams(AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
      localHolder.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramView = new PETextView((Context)localObject);
      localObject = PEPanelHelper.a;
      if (localObject == null) {
        break label366;
      }
      paramView.setTypeFace((Typeface)localObject);
    }
    for (;;)
    {
      paramView.setText("x3");
      localObject = new RelativeLayout.LayoutParams(AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject).setMargins(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131362459);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePETextView = paramView;
      if ((!localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePETextView.a()) && (PEPanelHelper.a != null)) {
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePETextView.setTypeFace(PEPanelHelper.a);
      }
      paramViewHolder.setTag(localHolder);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      a(localHolder, paramBaseChatItemLayout);
      if (b)
      {
        if ((localHolder.b != null) && (localHolder.b.length() > 0)) {
          localHolder.b.setLength(0);
        }
        paramViewHolder.setContentDescription(a(paramChatMessage));
      }
      return paramViewHolder;
      label366:
      if ((PokeItemHelper.b) && (!PEPanelHelper.b))
      {
        PEPanelHelper.b = true;
        ThreadManager.executeOnSubThread(new vhw(this));
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PokeEmoItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    MessageForPokeEmo localMessageForPokeEmo = (MessageForPokeEmo)paramChatMessage;
    if (paramChatMessage.isSend()) {
      localStringBuilder.append("我向" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + String.format("发出%d个轻互动表情%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localMessageForPokeEmo.summary }));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + String.format("发来%d个轻互动表情%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localMessageForPokeEmo.summary }));
    }
  }
  
  public void a()
  {
    super.a();
    AIOUtils.b = 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131375633: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.c(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPokeEmo)AIOUtils.a(paramView);
    } while (!paramView.isSendFromLocal());
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a(2131433649, 5);
    localActionSheet.c(2131433029);
    localActionSheet.a(new vhx(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeEmoItemBuilder
 * JD-Core Version:    0.7.0.1
 */