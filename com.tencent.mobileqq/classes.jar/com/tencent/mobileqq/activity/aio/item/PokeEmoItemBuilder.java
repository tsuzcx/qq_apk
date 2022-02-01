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
  protected long a = 0L;
  private StickerBubbleReceiverAnimationRunnable w;
  private Drawable x;
  
  public PokeEmoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(PokeEmoItemBuilder.Holder paramHolder, MessageForPokeEmo paramMessageForPokeEmo)
  {
    int i = paramMessageForPokeEmo.pokeemoId;
    int j = paramMessageForPokeEmo.pokeemoPressCount;
    paramHolder.q = paramMessageForPokeEmo;
    PokeItemHelper.g(this.d);
    boolean bool = PokeItemHelper.I;
    Object localObject;
    StringBuilder localStringBuilder;
    if (i == 13)
    {
      if (paramMessageForPokeEmo.emoIndex >= 0)
      {
        localObject = QQSysFaceUtil.getFaceGifDrawable(QQSysFaceUtil.convertToLocal(paramMessageForPokeEmo.emoIndex));
        paramHolder.a.setImageDrawable((Drawable)localObject);
        localObject = paramHolder.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("x");
        localStringBuilder.append(Integer.toString(paramMessageForPokeEmo.pokeemoPressCount));
        ((PokeEmoItemView)localObject).setText(localStringBuilder.toString());
      }
      else
      {
        if (this.x == null) {
          this.x = this.e.getResources().getDrawable(2130842390);
        }
        paramHolder.a.setImageDrawable(this.x);
        localObject = paramHolder.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("x");
        localStringBuilder.append(paramMessageForPokeEmo.pokeemoPressCount);
        ((PokeEmoItemView)localObject).setText(localStringBuilder.toString());
      }
    }
    else if (bool)
    {
      localObject = PEPanelHelper.c(i);
      paramHolder.a.setImageDrawable((Drawable)localObject);
      localObject = paramHolder.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("x");
      localStringBuilder.append(Integer.toString(paramMessageForPokeEmo.pokeemoPressCount));
      ((PokeEmoItemView)localObject).setText(localStringBuilder.toString());
    }
    else
    {
      if (this.x == null) {
        this.x = this.e.getResources().getDrawable(2130842390);
      }
      paramHolder.a.setImageDrawable(this.x);
      localObject = paramHolder.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("x");
      localStringBuilder.append(paramMessageForPokeEmo.pokeemoPressCount);
      ((PokeEmoItemView)localObject).setText(localStringBuilder.toString());
    }
    paramHolder.a.setIsSend(paramMessageForPokeEmo.isSend());
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmoItemBuilder", 2, String.format(" initBubbleView.forbidPoke=%b,isResDownload = %b,pokeMsg.isPlay = %b,animatingCount = %d,emoId = %d", new Object[] { Boolean.valueOf(AIOUtils.l), Boolean.valueOf(bool), Boolean.valueOf(paramMessageForPokeEmo.isNeedPlayed), Integer.valueOf(AIOUtils.p), Integer.valueOf(paramMessageForPokeEmo.pokeemoId) }));
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
    if ((bool) && (!paramMessageForPokeEmo.isSend()) && (paramMessageForPokeEmo.isNeedPlayed) && (!(this.e instanceof ChatHistoryActivity)) && (!GesturePWDUnlockActivity.sGesturePWDUnlockShowing))
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
      AIOUtils.p += 1;
      paramMessageForPokeEmo.setIsNeedPlayed(false);
      paramMessageForPokeEmo.isread = true;
      paramHolder = ((ViewGroup)((Activity)this.e).getWindow().getDecorView()).getChildAt(0).findViewById(2131427887);
      if (paramHolder != null)
      {
        localObject = PEPanelHelper.b(i);
        this.w = new StickerBubbleReceiverAnimationRunnable(this.d, j, paramHolder, (String)localObject);
        ThreadManager.getUIHandler().post(this.w);
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
    this.d.getMessageFacade().a(this.f.b, this.f.a, paramMessageForPokeEmo.uniseq, paramMessageForPokeEmo.msgData);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = this.e;
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
      paramViewHolder.setId(2131445137);
      paramView = new PokeEmoItemView((Context)localObject);
      paramView.setId(2131440489);
      paramViewHolder.addView(paramView, new ViewGroup.LayoutParams(-1, AIOUtils.b(80.0F, ((Context)localObject).getResources())));
      localHolder.a = paramView;
      localObject = PEPanelHelper.k;
      if (localObject != null)
      {
        QLog.e("PokeEmoItemBuilder", 1, "mTypeface  != null ");
        paramView.setTypeFace((Typeface)localObject);
      }
      else if ((PokeItemHelper.I) && (!PEPanelHelper.l))
      {
        PEPanelHelper.l = true;
        ThreadManager.executeOnSubThread(new PokeEmoItemBuilder.1(this));
      }
      paramView.setText("x3");
      AccessibilityUtil.a(paramView, false);
    }
    if ((!localHolder.a.a()) && (PEPanelHelper.k != null)) {
      localHolder.a.setTypeFace(PEPanelHelper.k);
    }
    paramView = new StringBuilder();
    paramView.append("PEPanelHelper.mTypeface != null :");
    paramView.append(PEPanelHelper.k);
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
    if (v)
    {
      if ((localHolder.r != null) && (localHolder.r.length() > 0)) {
        localHolder.r.setLength(0);
      }
      paramViewHolder.setContentDescription(d(paramChatMessage));
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PokeEmoItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
  }
  
  protected void a(MessageForPokeEmo paramMessageForPokeEmo)
  {
    ViewGroup localViewGroup = (ViewGroup)((ViewGroup)((Activity)this.e).getWindow().getDecorView()).getChildAt(0).findViewById(2131427887);
    AIOPopOutEmoticonConfig localAIOPopOutEmoticonConfig = new AIOPopOutEmoticonConfig(null, localViewGroup);
    localAIOPopOutEmoticonConfig.init();
    ((IPopOutEmoticonAnim)QRoute.api(IPopOutEmoticonAnim.class)).playPopEmoAnimation(localViewGroup, localAIOPopOutEmoticonConfig, paramMessageForPokeEmo.emoIndex, paramMessageForPokeEmo.pokeemoPressCount);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.b(paramView);
    if ((paramView != null) && (paramView.q != null) && ((paramView.q instanceof MessageForPokeEmo)) && (paramView.q.istroop == 0)) {
      a(localQQCustomMenu, this.e, 2131444634, paramView.q, null);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    super.b();
    AIOUtils.p = 0;
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForPokeEmo)AIOUtils.a(paramView);
    if (paramView.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.e, null);
      localActionSheet.addButton(2131886574, 5);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new PokeEmoItemBuilder.2(this, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L)
    {
      localStringBuilder.append(TimeFormatterUtils.a(this.e, 3, paramChatMessage.time * 1000L));
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
      paramChatMessage.append(this.f.e);
      paramChatMessage.append(String.format("发出%d个%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localObject }));
      localStringBuilder.append(paramChatMessage.toString());
    }
    else
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append(this.f.e);
      paramChatMessage.append(String.format("发来%d个%s", new Object[] { Integer.valueOf(localMessageForPokeEmo.pokeemoPressCount), localObject }));
      localStringBuilder.append(paramChatMessage.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeEmoItemBuilder
 * JD-Core Version:    0.7.0.1
 */