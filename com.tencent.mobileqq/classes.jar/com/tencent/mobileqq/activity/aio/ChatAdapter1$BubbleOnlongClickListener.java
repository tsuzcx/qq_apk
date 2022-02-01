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
    for (;;)
    {
      if (arrayOfInt == null) {
        return null;
      }
      return Integer.valueOf(arrayOfInt[1]);
      arrayOfInt = null;
    }
  }
  
  private void a(View paramView, ChatItemBuilder paramChatItemBuilder)
  {
    paramView.setPressed(true);
    this.jdField_a_of_type_AndroidViewView = paramView;
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof AbsStructMsgItem)) {
      ((AbsStructMsgItem)localObject1).c(this.jdField_a_of_type_AndroidViewView);
    }
    label113:
    label254:
    do
    {
      return;
      if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
      {
        Object localObject2 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
        ViewGroup.LayoutParams localLayoutParams;
        if ((paramChatItemBuilder instanceof StructingMsgItemBuilder))
        {
          if (((StructingMsgItemBuilder)paramChatItemBuilder).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
          {
            if ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
              this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            }
            this.jdField_a_of_type_Boolean = false;
          }
        }
        else
        {
          if ((this.jdField_b_of_type_AndroidViewView == null) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_Boolean)) {
            break label239;
          }
          localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          if (!this.jdField_a_of_type_Boolean) {
            break label254;
          }
          if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            break label241;
          }
          ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850409);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
          return;
          this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout;
          this.jdField_a_of_type_Boolean = true;
          break label113;
          break;
          ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850233);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
          {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838425);
          }
          else
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (((BaseBubbleBuilder)paramChatItemBuilder).a(paramView) == null) {
              ChatAdapter1.a((MessageForStructing)localObject2, (BaseBubbleBuilder.ViewHolder)localObject1, this.jdField_b_of_type_AndroidViewView, true);
            }
          }
        }
      }
    } while (!(localObject1 instanceof StructMsgItemButton));
    label239:
    label241:
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramChatItemBuilder = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)paramView.getTag(2131378545)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838412);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramChatItemBuilder);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838416);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838414);
      }
    }
  }
  
  private void a(BaseBubbleBuilder.TouchDelegate paramTouchDelegate)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject1 instanceof AbsStructMsgItem)) {
      ((AbsStructMsgItem)localObject1).b(this.jdField_a_of_type_AndroidViewView);
    }
    do
    {
      do
      {
        return;
        if ((!(localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) || (this.jdField_b_of_type_AndroidViewView == null)) {
          break;
        }
        Object localObject2 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
        this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
        this.jdField_b_of_type_AndroidViewView.getPaddingTop();
        this.jdField_b_of_type_AndroidViewView.getPaddingRight();
        this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
        if (this.jdField_a_of_type_Boolean) {
          if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_AndroidViewView, false);
          }
        }
        for (;;)
        {
          paramTouchDelegate = this.jdField_b_of_type_AndroidViewView.findViewById(2131368907);
          if ((paramTouchDelegate == null) || (!(paramTouchDelegate instanceof PAHighLightImageView))) {
            break;
          }
          ((PAHighLightImageView)paramTouchDelegate).a();
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
          {
            if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).jdField_a_of_type_Boolean) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838423);
            }
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
          {
            localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
            if (paramTouchDelegate == null) {
              ChatAdapter1.a((MessageForStructing)localObject2, (BaseBubbleBuilder.ViewHolder)localObject1, this.jdField_b_of_type_AndroidViewView, false);
            }
          }
        }
        paramTouchDelegate = this.jdField_b_of_type_AndroidViewView.findViewById(2131378566);
      } while ((paramTouchDelegate == null) || (!(paramTouchDelegate instanceof PAHighLightImageView)));
      ((PAHighLightImageView)paramTouchDelegate).a();
      return;
    } while (!(localObject1 instanceof StructMsgItemButton));
    paramTouchDelegate = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131378545)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838411);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramTouchDelegate);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      return;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838415);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838413);
      }
    }
  }
  
  private void a(ChatItemBuilder paramChatItemBuilder)
  {
    if ((paramChatItemBuilder instanceof TextItemBuilder)) {
      paramChatItemBuilder = Integer.toString(0);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramChatItemBuilder, "", "", "");
      return;
      if ((paramChatItemBuilder instanceof PicItemBuilder)) {
        paramChatItemBuilder = Integer.toString(1);
      } else {
        paramChatItemBuilder = Integer.toString(999);
      }
    }
  }
  
  private boolean a(View paramView, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "chatAdapter onLongClick message msgUid = " + paramChatMessage.msgUid + ", time = " + paramChatMessage.time + ", msgtype = " + paramChatMessage.msgtype);
    }
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    Object localObject = localChatItemBuilder.a(paramView);
    int j;
    if ((localObject != null) && (localObject.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = AIOUtils.a(paramView);
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localQQCustomMenu.a(localObject[i]);
        i += 1;
      }
      if (localQQCustomMenu.a() < 1) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))) {
        break label613;
      }
    }
    label462:
    label613:
    for (int i = 1;; i = 0)
    {
      int k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = AIOUtils.a(10.0F, paramView.getResources());
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      j = localObject[1] - AIOUtils.a(3.0F, paramView.getResources());
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      if (j - AIOUtils.a(72.0F, paramView.getResources()) > ((Rect)localObject).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper = new AIOMenuWrapper(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a(this);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - ViewUtils.b(14.0F);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.b = k;
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a(localQQCustomMenu, paramChatMessage.isMultiMsg);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a(k);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.b(j);
          if ((paramView instanceof ArkAppView))
          {
            ((ArkAppView)paramView).setViewPressed(true);
            this.c = paramView;
          }
          a(paramView);
          if (i != 0) {
            a(paramView, localChatItemBuilder);
          }
          if ((localChatItemBuilder instanceof BaseBubbleBuilder))
          {
            EmojiStickerManager.a().a(paramView);
            paramChatMessage = ((BaseBubbleBuilder)localChatItemBuilder).a(paramView);
            if (paramChatMessage != null)
            {
              this.jdField_a_of_type_AndroidViewView = paramView;
              if (!paramBoolean) {
                break label567;
              }
              paramChatMessage.a(paramView, true);
            }
          }
          if (paramBoolean)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2)) {
              break label578;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ChatAdapter1", 2, "performCursorTouch ");
            }
          }
        }
        for (;;)
        {
          a(localChatItemBuilder);
          com.tencent.mobileqq.utils.BubbleContextMenu.jdField_a_of_type_Boolean = true;
          return true;
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a(paramView, k, paramChatMessage.a, localQQCustomMenu, true, paramChatMessage.b, a());
          break;
          paramChatMessage.a(paramView, false);
          break label462;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper);
        }
        a(paramView);
        return false;
        j = k - m;
      }
    }
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
      if ((paramView.getId() != 2131377708) && (AIOSelectableDelegateImpl.a().c())) {
        AIOSelectableDelegateImpl.a().d();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
      }
    }
  }
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "popup onDismiss is called");
    }
    EmojiStickerManager.a().b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.b();
    }
    BaseBubbleBuilder.TouchDelegate localTouchDelegate;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      if ((localObject instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject).d();
        localTouchDelegate = ((BaseBubbleBuilder)localObject).a(this.jdField_a_of_type_AndroidViewView);
        localObject = localTouchDelegate;
        if (localTouchDelegate != null) {
          localTouchDelegate.a(this.jdField_a_of_type_AndroidViewView, true);
        }
      }
    }
    for (Object localObject = localTouchDelegate;; localObject = null)
    {
      this.jdField_b_of_type_Boolean = false;
      com.tencent.mobileqq.utils.BubbleContextMenu.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        a((BaseBubbleBuilder.TouchDelegate)localObject);
        this.jdField_a_of_type_AndroidViewView = null;
        this.jdField_b_of_type_AndroidViewView = null;
      }
      if (this.c != null)
      {
        ((ArkAppView)this.c).setViewPressed(false);
        this.c = null;
      }
      return;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatAdapter1", 2, "onLongClick() called with: v = [" + paramView + "]");
    }
    boolean bool;
    ChatMessage localChatMessage;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_Boolean)
    {
      bool = false;
      if ((paramView instanceof AnimationTextView)) {
        ((AnimationTextView)paramView).setTag(2131368717, Boolean.valueOf(true));
      }
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      localChatMessage = AIOUtils.a(paramView);
      if (!localChatMessage.isMultiMsg) {
        break label293;
      }
      if (MultiMsgUtil.b(localChatMessage)) {
        break label147;
      }
      i = 1;
    }
    for (;;)
    {
      label111:
      if (i != 0) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 1");
        }
      }
      label147:
      label182:
      do
      {
        do
        {
          return true;
          bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView);
          break;
          i = 0;
          break label111;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            break label182;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 2");
        return true;
        if (!(paramView instanceof ETTextView)) {
          break label231;
        }
        ETTextView localETTextView = (ETTextView)paramView;
        if (!localETTextView.mHasClickedArkSpan) {
          break label231;
        }
        localETTextView.mHasClickedArkSpan = false;
        a(paramView);
      } while (!QLog.isColorLevel());
      QLog.d("ChatAdapter1", 2, "onLongClick() called with: return 3");
      return true;
      label231:
      this.jdField_b_of_type_Boolean = true;
      AIOUtils.o = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "bubble onLongClick() is called");
      }
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOMenuWrapper.a()))
      {
        a(paramView);
        return false;
      }
      return a(paramView, bool, localChatMessage);
      label293:
      i = 0;
    }
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
      if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1008) {
          break label249;
        }
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).onPublicAccountArkMsgClick(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1);
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) && (localObject1 != null)) {
      PublicAccountEventReport.a(118, (ChatMessage)localObject1, AIOUtils.a(((ChatMessage)localObject1).uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentWidgetListView.getAdapter()));
    }
    Object localObject2 = paramView.findViewById(2131368907);
    if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
      ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a((ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      if ((!this.jdField_b_of_type_Boolean) && ((localObject1 instanceof BaseBubbleBuilder)))
      {
        localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
        if (localObject1 != null) {
          ((BaseBubbleBuilder.TouchDelegate)localObject1).a(paramView, paramMotionEvent);
        }
      }
      return false;
      label249:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1038) || (!(localObject1 instanceof MessageForArkApp))) {
        break;
      }
      localObject2 = (MessageForArkApp)localObject1;
      if (((MessageForArkApp)localObject2).ark_app_message == null) {
        break;
      }
      localObject2 = ((MessageForArkApp)localObject2).ark_app_message.appView;
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("message", "message_aio", "click", "com.tencent.miniapp", (String)localObject2, "", "");
      break;
      localObject2 = paramView.findViewById(2131378566);
      if ((localObject2 != null) && ((localObject2 instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
        ((PAHighLightImageView)localObject2).a(paramView, paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatAdapter1.BubbleOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */