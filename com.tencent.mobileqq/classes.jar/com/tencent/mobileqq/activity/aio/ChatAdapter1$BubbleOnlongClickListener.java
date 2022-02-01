package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.selectable.AIOMenuWrapper;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.ChatAdapterSelectableHelper;
import com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.MenuPlaceInfo;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;
import com.tencent.widget.ListView;

public class ChatAdapter1$BubbleOnlongClickListener
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  public AIOMenuWrapper a;
  ChatMessage b;
  View c;
  View d;
  View e;
  boolean f = false;
  boolean g = false;
  private PointF i = new PointF();
  
  public ChatAdapter1$BubbleOnlongClickListener(ChatAdapter1 paramChatAdapter1) {}
  
  private void a(View paramView, ChatItemBuilder paramChatItemBuilder)
  {
    paramView.setPressed(true);
    this.c = paramView;
    Object localObject1 = this.c.getTag();
    if ((localObject1 instanceof AbsStructMsgItem))
    {
      ((AbsStructMsgItem)localObject1).c(this.c);
      return;
    }
    int j;
    int k;
    int m;
    int n;
    if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
    {
      Object localObject2 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
      if ((paramChatItemBuilder instanceof StructingMsgItemBuilder)) {
        if (((StructingMsgItemBuilder)paramChatItemBuilder).c(this.b) == 0)
        {
          if ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a.getChildCount() > 0)) {
            this.d = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a.getChildAt(0);
          }
          this.f = false;
        }
        else
        {
          this.d = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a;
          this.f = true;
        }
      }
      if ((this.d != null) && (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).g))
      {
        ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
        j = this.d.getPaddingLeft();
        k = this.d.getPaddingTop();
        m = this.d.getPaddingRight();
        n = this.d.getPaddingBottom();
        if (this.f)
        {
          if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).q.isSend()) {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).h.setBackgroundResource(2130852127);
          } else {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).h.setBackgroundResource(2130851945);
          }
        }
        else if (this.b.istroop == 1008)
        {
          this.d.setBackgroundResource(2130838320);
        }
        else
        {
          localObject2 = (MessageForStructing)this.b;
          if (((BaseBubbleBuilder)paramChatItemBuilder).d(paramView) == null) {
            ChatAdapter1.a((MessageForStructing)localObject2, (BaseBubbleBuilder.ViewHolder)localObject1, this.d, true);
          }
        }
        this.d.setLayoutParams(localLayoutParams);
        this.d.setPadding(j, k, m, n);
      }
    }
    else if ((localObject1 instanceof StructMsgItemButton))
    {
      this.d = paramView;
      paramChatItemBuilder = this.d.getLayoutParams();
      j = this.d.getPaddingLeft();
      k = this.d.getPaddingTop();
      m = this.d.getPaddingRight();
      n = this.d.getPaddingBottom();
      int i1 = ((Integer)paramView.getTag(2131446443)).intValue();
      if (i1 == 0) {
        this.d.setBackgroundResource(2130838307);
      } else if (i1 == 2) {
        this.d.setBackgroundResource(2130838311);
      } else {
        this.d.setBackgroundResource(2130838309);
      }
      this.d.setLayoutParams(paramChatItemBuilder);
      this.d.setPadding(j, k, m, n);
    }
  }
  
  private void a(BaseBubbleBuilder.TouchDelegate paramTouchDelegate)
  {
    Object localObject1 = this.c.getTag();
    if ((localObject1 instanceof AbsStructMsgItem))
    {
      ((AbsStructMsgItem)localObject1).b(this.c);
      return;
    }
    if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
    {
      Object localObject3 = this.d;
      if (localObject3 != null)
      {
        Object localObject2 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
        ((View)localObject3).getLayoutParams();
        this.d.getPaddingLeft();
        this.d.getPaddingTop();
        this.d.getPaddingRight();
        this.d.getPaddingBottom();
        if (this.f)
        {
          if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).i != null) {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).i.a(this.h.b, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).q.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).q.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).h, false);
          }
        }
        else
        {
          localObject3 = this.b;
          if ((localObject3 != null) && (((ChatMessage)localObject3).istroop == 1008))
          {
            if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).g) {
              this.d.setBackgroundResource(2130838318);
            }
          }
          else
          {
            localObject2 = this.b;
            if ((localObject2 != null) && ((localObject2 instanceof MessageForStructing)))
            {
              localObject2 = (MessageForStructing)localObject2;
              if (paramTouchDelegate == null) {
                ChatAdapter1.a((MessageForStructing)localObject2, (BaseBubbleBuilder.ViewHolder)localObject1, this.d, false);
              }
            }
          }
        }
        paramTouchDelegate = this.d.findViewById(2131435545);
        if ((paramTouchDelegate != null) && ((paramTouchDelegate instanceof PAHighLightImageView)))
        {
          ((PAHighLightImageView)paramTouchDelegate).a();
          return;
        }
        paramTouchDelegate = this.d.findViewById(2131446464);
        if ((paramTouchDelegate == null) || (!(paramTouchDelegate instanceof PAHighLightImageView))) {
          return;
        }
        ((PAHighLightImageView)paramTouchDelegate).a();
        return;
      }
    }
    if ((localObject1 instanceof StructMsgItemButton))
    {
      paramTouchDelegate = this.d.getLayoutParams();
      int j = this.d.getPaddingLeft();
      int k = this.d.getPaddingTop();
      int m = this.d.getPaddingRight();
      int n = this.d.getPaddingBottom();
      int i1 = ((Integer)this.d.getTag(2131446443)).intValue();
      if (i1 == 0) {
        this.d.setBackgroundResource(2130838306);
      } else if (i1 == 2) {
        this.d.setBackgroundResource(2130838310);
      } else {
        this.d.setBackgroundResource(2130838308);
      }
      this.d.setLayoutParams(paramTouchDelegate);
      this.d.setPadding(j, k, m, n);
    }
  }
  
  private void a(ChatItemBuilder paramChatItemBuilder)
  {
    if ((paramChatItemBuilder instanceof TextItemBuilder)) {
      paramChatItemBuilder = Integer.toString(0);
    }
    for (;;)
    {
      break;
      if ((paramChatItemBuilder instanceof PicItemBuilder)) {
        paramChatItemBuilder = Integer.toString(1);
      } else {
        paramChatItemBuilder = Integer.toString(999);
      }
    }
    ReportController.b(this.h.b, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramChatItemBuilder, "", "", "");
  }
  
  private boolean a(View paramView, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("chatAdapter onLongClick message msgUid = ");
      ((StringBuilder)localObject1).append(paramChatMessage.msgUid);
      ((StringBuilder)localObject1).append(", time = ");
      ((StringBuilder)localObject1).append(paramChatMessage.time);
      ((StringBuilder)localObject1).append(", msgtype = ");
      ((StringBuilder)localObject1).append(paramChatMessage.msgtype);
      QLog.d("ChatAdapter1", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = a(paramChatMessage, this.h);
    Object localObject2 = ((ChatItemBuilder)localObject1).a(paramView);
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      this.b = AIOUtils.a(paramView);
      int k = localObject2.length;
      int j = 0;
      while (j < k)
      {
        localQQCustomMenu.a(localObject2[j]);
        j += 1;
      }
      if (localQQCustomMenu.b() < 1) {
        return false;
      }
      localObject2 = this.b;
      if ((localObject2 != null) && ((localObject2 instanceof MessageForStructing))) {
        j = 1;
      } else {
        j = 0;
      }
      k = (int)this.i.y - AIOUtils.b(10.0F, paramView.getResources());
      localObject2 = new int[2];
      paramView.getLocationOnScreen((int[])localObject2);
      int m = localObject2[1] - AIOUtils.b(3.0F, paramView.getResources());
      localObject2 = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject2);
      if (m - AIOUtils.b(72.0F, paramView.getResources()) > ((Rect)localObject2).top) {
        k = m;
      }
      if (this.a == null)
      {
        this.a = new AIOMenuWrapper(this.h.k);
        this.a.a(this);
        this.a.a(this);
      }
      this.a.c = ((int)this.i.y);
      m = (int)this.i.x - ViewUtils.dpToPx(14.0F);
      localObject2 = this.a;
      ((AIOMenuWrapper)localObject2).d = m;
      if (paramBoolean)
      {
        ((AIOMenuWrapper)localObject2).a(localQQCustomMenu, paramChatMessage.isMultiMsg);
        this.a.a(m);
        this.a.b(k);
      }
      else
      {
        paramChatMessage = ((AIOMenuWrapper)localObject2).a(paramView, this.h.k);
        this.a.a(paramView, m, paramChatMessage.a, localQQCustomMenu, true, paramChatMessage.b, b());
      }
      if ((paramView instanceof ArkAppView))
      {
        ((ArkAppView)paramView).setViewPressed(true);
        this.e = paramView;
      }
      a(paramView);
      if (j != 0) {
        a(paramView, (ChatItemBuilder)localObject1);
      }
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        EmojiStickerManager.a().a(paramView);
        paramChatMessage = ((BaseBubbleBuilder)localObject1).d(paramView);
        if (paramChatMessage != null)
        {
          this.c = paramView;
          if (paramBoolean) {
            paramChatMessage.a(paramView, true);
          } else {
            paramChatMessage.a(paramView, false);
          }
        }
      }
      if (paramBoolean) {
        if (this.h.o.a(paramView, this.i.x, this.i.y, 1, 2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatAdapter1", 2, "performCursorTouch ");
          }
        }
        else {
          this.h.o.a(paramView, this.a);
        }
      }
      a((ChatItemBuilder)localObject1);
      com.tencent.mobileqq.utils.BubbleContextMenu.a = true;
      return true;
    }
    a(paramView);
    return false;
  }
  
  private Integer b()
  {
    int[] arrayOfInt;
    if ((this.h.k != null) && (this.h.k.X != null))
    {
      arrayOfInt = new int[2];
      this.h.k.X.getLocationInWindow(arrayOfInt);
    }
    else
    {
      arrayOfInt = null;
    }
    if (arrayOfInt == null) {
      return null;
    }
    return Integer.valueOf(arrayOfInt[1]);
  }
  
  public ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return this.h.c.a(paramChatMessage, paramBaseAdapter);
  }
  
  public ChatMessage a()
  {
    return this.b;
  }
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = a((ChatMessage)localObject, this.h);
      Context localContext = paramView.getContext();
      ((ChatItemBuilder)localObject).a(paramView.getId(), localContext, this.b);
      if ((paramView.getId() != 2131445511) && (AIOSelectableDelegateImpl.a().l())) {
        AIOSelectableDelegateImpl.a().n();
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "popup onDismiss is called");
    }
    EmojiStickerManager.a().e();
    Object localObject1 = this.a;
    if (localObject1 != null) {
      ((AIOMenuWrapper)localObject1).g();
    }
    localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = a((ChatMessage)localObject1, this.h);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        localObject1 = (BaseBubbleBuilder)localObject1;
        ((BaseBubbleBuilder)localObject1).f();
        localObject2 = ((BaseBubbleBuilder)localObject1).d(this.c);
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label103;
        }
        ((BaseBubbleBuilder.TouchDelegate)localObject2).a(this.c, true);
        localObject1 = localObject2;
        break label103;
      }
    }
    localObject1 = null;
    label103:
    this.g = false;
    com.tencent.mobileqq.utils.BubbleContextMenu.a = false;
    Object localObject2 = this.c;
    if (localObject2 != null)
    {
      ((View)localObject2).setPressed(false);
      a((BaseBubbleBuilder.TouchDelegate)localObject1);
      this.c = null;
      this.d = null;
    }
    localObject1 = this.e;
    if (localObject1 != null)
    {
      ((ArkAppView)localObject1).setViewPressed(false);
      this.e = null;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLongClick() called with: v = [");
      ((StringBuilder)localObject1).append(paramView);
      ((StringBuilder)localObject1).append("]");
      QLog.d("ChatAdapter1", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool2;
    if (this.h.h) {
      bool2 = false;
    } else {
      bool2 = this.h.o.a(paramView);
    }
    if ((paramView instanceof AnimationTextView)) {
      ((AnimationTextView)paramView).setTag(2131435345, Boolean.valueOf(true));
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    Object localObject1 = AIOUtils.a(paramView);
    boolean bool1;
    if (((ChatMessage)localObject1).isMultiMsg) {
      bool1 = MultiMsgUtil.c((ChatMessage)localObject1) ^ true;
    } else {
      bool1 = false;
    }
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 1");
      }
      return true;
    }
    if (!this.h.g.booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 2");
      }
      return true;
    }
    Object localObject2;
    if ((paramView instanceof ETTextView))
    {
      localObject2 = (ETTextView)paramView;
      if (((ETTextView)localObject2).mHasClickedArkSpan)
      {
        ((ETTextView)localObject2).mHasClickedArkSpan = false;
        a(paramView);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 3");
        }
        return true;
      }
    }
    this.g = true;
    AIOUtils.q = true;
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "bubble onLongClick() is called");
    }
    if (!bool2)
    {
      localObject2 = this.a;
      if ((localObject2 != null) && (((AIOMenuWrapper)localObject2).e()))
      {
        a(paramView);
        return false;
      }
    }
    return a(paramView, bool2, (ChatMessage)localObject1);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.i.x = paramMotionEvent.getRawX();
      this.i.y = paramMotionEvent.getRawY();
    }
    Object localObject1 = AIOUtils.a(paramView);
    if ((paramView instanceof ArkAppView))
    {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) && (this.h.l != null)) {
        if (this.h.l.a == 1008)
        {
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).onPublicAccountArkMsgClick(this.h.b, (ChatMessage)localObject1);
        }
        else if ((this.h.l.a == 1038) && ((localObject1 instanceof MessageForArkApp)))
        {
          localObject2 = (MessageForArkApp)localObject1;
          if (((MessageForArkApp)localObject2).ark_app_message != null)
          {
            localObject2 = ((MessageForArkApp)localObject2).ark_app_message.appView;
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("message", "message_aio", "click", "com.tencent.miniapp", (String)localObject2, "", "");
          }
        }
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.h.l.a == 1008) && (localObject1 != null)) {
      PublicAccountEventReport.a(118, (ChatMessage)localObject1, AIOUtils.a(((ChatMessage)localObject1).uniseq, this.h.j.getAdapter()));
    }
    Object localObject2 = paramView.findViewById(2131435545);
    if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.g))
    {
      ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
    }
    else
    {
      localObject2 = paramView.findViewById(2131446464);
      if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.g)) {
        ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
      }
    }
    localObject1 = a((ChatMessage)localObject1, this.h);
    if ((!this.g) && ((localObject1 instanceof BaseBubbleBuilder)))
    {
      localObject1 = ((BaseBubbleBuilder)localObject1).d(paramView);
      if (localObject1 != null) {
        ((BaseBubbleBuilder.TouchDelegate)localObject1).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatAdapter1.BubbleOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */