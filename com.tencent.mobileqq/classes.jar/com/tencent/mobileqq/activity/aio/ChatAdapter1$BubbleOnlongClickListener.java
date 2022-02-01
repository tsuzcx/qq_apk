package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
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
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  public AIOMenuWrapper a;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  View c;
  
  public ChatAdapter1$BubbleOnlongClickListener(ChatAdapter1 paramChatAdapter1) {}
  
  private Integer a()
  {
    int[] arrayOfInt;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null))
    {
      arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getLocationInWindow(arrayOfInt);
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
  
  private void a(View paramView, ChatItemBuilder paramChatItemBuilder)
  {
    paramView.setPressed(true);
    this.jdField_a_of_type_AndroidViewView = paramView;
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof AbsStructMsgItem))
    {
      ((AbsStructMsgItem)localObject1).c(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    int i;
    int j;
    int k;
    int m;
    if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
    {
      Object localObject2 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
      if ((paramChatItemBuilder instanceof StructingMsgItemBuilder)) {
        if (((StructingMsgItemBuilder)paramChatItemBuilder).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
        {
          if ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
            this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
          }
          this.jdField_a_of_type_Boolean = false;
        }
        else
        {
          this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout;
          this.jdField_a_of_type_Boolean = true;
        }
      }
      if ((this.jdField_b_of_type_AndroidViewView != null) && (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_Boolean))
      {
        ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
        j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
        k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
        m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
        if (this.jdField_a_of_type_Boolean)
        {
          if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850336);
          } else {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850160);
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
        {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838261);
        }
        else
        {
          localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (((BaseBubbleBuilder)paramChatItemBuilder).a(paramView) == null) {
            ChatAdapter1.a((MessageForStructing)localObject2, (BaseBubbleBuilder.ViewHolder)localObject1, this.jdField_b_of_type_AndroidViewView, true);
          }
        }
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      }
    }
    else if ((localObject1 instanceof StructMsgItemButton))
    {
      this.jdField_b_of_type_AndroidViewView = paramView;
      paramChatItemBuilder = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)paramView.getTag(2131377956)).intValue();
      if (n == 0) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838248);
      } else if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838252);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838250);
      }
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramChatItemBuilder);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
    }
  }
  
  private void a(BaseBubbleBuilder.TouchDelegate paramTouchDelegate)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof AbsStructMsgItem))
    {
      ((AbsStructMsgItem)localObject1).b(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
    {
      Object localObject3 = this.jdField_b_of_type_AndroidViewView;
      if (localObject3 != null)
      {
        Object localObject2 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
        ((View)localObject3).getLayoutParams();
        this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
        this.jdField_b_of_type_AndroidViewView.getPaddingTop();
        this.jdField_b_of_type_AndroidViewView.getPaddingRight();
        this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
        if (this.jdField_a_of_type_Boolean)
        {
          if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidViewView, false);
          }
        }
        else
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if ((localObject3 != null) && (((ChatMessage)localObject3).istroop == 1008))
          {
            if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_Boolean) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838259);
            }
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if ((localObject2 != null) && ((localObject2 instanceof MessageForStructing)))
            {
              localObject2 = (MessageForStructing)localObject2;
              if (paramTouchDelegate == null) {
                ChatAdapter1.a((MessageForStructing)localObject2, (BaseBubbleBuilder.ViewHolder)localObject1, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
        }
        paramTouchDelegate = this.jdField_b_of_type_AndroidViewView.findViewById(2131368633);
        if ((paramTouchDelegate != null) && ((paramTouchDelegate instanceof PAHighLightImageView)))
        {
          ((PAHighLightImageView)paramTouchDelegate).a();
          return;
        }
        paramTouchDelegate = this.jdField_b_of_type_AndroidViewView.findViewById(2131377977);
        if ((paramTouchDelegate == null) || (!(paramTouchDelegate instanceof PAHighLightImageView))) {
          return;
        }
        ((PAHighLightImageView)paramTouchDelegate).a();
        return;
      }
    }
    if ((localObject1 instanceof StructMsgItemButton))
    {
      paramTouchDelegate = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131377956)).intValue();
      if (n == 0) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838247);
      } else if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838251);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838249);
      }
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramTouchDelegate);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
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
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramChatItemBuilder, "", "", "");
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    Object localObject2 = ((ChatItemBuilder)localObject1).a(paramView);
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = AIOUtils.a(paramView);
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        localQQCustomMenu.a(localObject2[i]);
        i += 1;
      }
      if (localQQCustomMenu.a() < 1) {
        return false;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localObject2 != null) && ((localObject2 instanceof MessageForStructing))) {
        i = 1;
      } else {
        i = 0;
      }
      j = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y - AIOUtils.b(10.0F, paramView.getResources());
      localObject2 = new int[2];
      paramView.getLocationOnScreen((int[])localObject2);
      int k = localObject2[1] - AIOUtils.b(3.0F, paramView.getResources());
      localObject2 = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject2);
      if (k - AIOUtils.b(72.0F, paramView.getResources()) > ((Rect)localObject2).top) {
        j = k;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper = new AIOMenuWrapper(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
      k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - ViewUtils.b(14.0F);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper;
      ((AIOMenuWrapper)localObject2).b = k;
      if (paramBoolean)
      {
        ((AIOMenuWrapper)localObject2).a(localQQCustomMenu, paramChatMessage.isMultiMsg);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a(k);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.b(j);
      }
      else
      {
        paramChatMessage = ((AIOMenuWrapper)localObject2).a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a(paramView, k, paramChatMessage.a, localQQCustomMenu, true, paramChatMessage.b, a());
      }
      if ((paramView instanceof ArkAppView))
      {
        ((ArkAppView)paramView).setViewPressed(true);
        this.c = paramView;
      }
      a(paramView);
      if (i != 0) {
        a(paramView, (ChatItemBuilder)localObject1);
      }
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        EmojiStickerManager.a().a(paramView);
        paramChatMessage = ((BaseBubbleBuilder)localObject1).a(paramView);
        if (paramChatMessage != null)
        {
          this.jdField_a_of_type_AndroidViewView = paramView;
          if (paramBoolean) {
            paramChatMessage.a(paramView, true);
          } else {
            paramChatMessage.a(paramView, false);
          }
        }
      }
      if (paramBoolean) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatAdapter1", 2, "performCursorTouch ");
          }
        }
        else {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper);
        }
      }
      a((ChatItemBuilder)localObject1);
      com.tencent.mobileqq.utils.BubbleContextMenu.jdField_a_of_type_Boolean = true;
      return true;
    }
    a(paramView);
    return false;
  }
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      Context localContext = paramView.getContext();
      localChatItemBuilder.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((paramView.getId() != 2131377136) && (AIOSelectableDelegateImpl.a().c())) {
        AIOSelectableDelegateImpl.a().d();
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
    EmojiStickerManager.a().b();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper;
    if (localObject1 != null) {
      ((AIOMenuWrapper)localObject1).b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        localObject1 = (BaseBubbleBuilder)localObject1;
        ((BaseBubbleBuilder)localObject1).d();
        localObject2 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label110;
        }
        ((BaseBubbleBuilder.TouchDelegate)localObject2).a(this.jdField_a_of_type_AndroidViewView, true);
        localObject1 = localObject2;
        break label110;
      }
    }
    localObject1 = null;
    label110:
    this.jdField_b_of_type_Boolean = false;
    com.tencent.mobileqq.utils.BubbleContextMenu.jdField_a_of_type_Boolean = false;
    Object localObject2 = this.jdField_a_of_type_AndroidViewView;
    if (localObject2 != null)
    {
      ((View)localObject2).setPressed(false);
      a((BaseBubbleBuilder.TouchDelegate)localObject1);
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_AndroidViewView = null;
    }
    localObject1 = this.c;
    if (localObject1 != null)
    {
      ((ArkAppView)localObject1).setViewPressed(false);
      this.c = null;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_Boolean) {
      bool2 = false;
    } else {
      bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView);
    }
    if ((paramView instanceof AnimationTextView)) {
      ((AnimationTextView)paramView).setTag(2131368449, Boolean.valueOf(true));
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    Object localObject1 = AIOUtils.a(paramView);
    boolean bool1;
    if (((ChatMessage)localObject1).isMultiMsg) {
      bool1 = MultiMsgUtil.b((ChatMessage)localObject1) ^ true;
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
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean.booleanValue())
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
    this.jdField_b_of_type_Boolean = true;
    AIOUtils.o = true;
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "bubble onLongClick() is called");
    }
    if (!bool2)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper;
      if ((localObject2 != null) && (((AIOMenuWrapper)localObject2).a()))
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
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    Object localObject1 = AIOUtils.a(paramView);
    if ((paramView instanceof ArkAppView))
    {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008)
        {
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).onPublicAccountArkMsgClick(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1);
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1038) && ((localObject1 instanceof MessageForArkApp)))
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
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) && (localObject1 != null)) {
      PublicAccountEventReport.a(118, (ChatMessage)localObject1, AIOUtils.a(((ChatMessage)localObject1).uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentWidgetListView.getAdapter()));
    }
    Object localObject2 = paramView.findViewById(2131368633);
    if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean))
    {
      ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
    }
    else
    {
      localObject2 = paramView.findViewById(2131377977);
      if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
        ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a((ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject1 instanceof BaseBubbleBuilder)))
    {
      localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
      if (localObject1 != null) {
        ((BaseBubbleBuilder.TouchDelegate)localObject1).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatAdapter1.BubbleOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */