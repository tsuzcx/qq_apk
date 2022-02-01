package com.tencent.mobileqq.activity.chathistory;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.selectable.AIOMenuWrapper;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.ChatAdapterSelectableHelper;
import com.tencent.mobileqq.activity.selectable.CommonMenuWrapper;
import com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.MenuPlaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

class ChatHistoryBubbleListAdapter$HistoryItemOnlongClickListener
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  CommonMenuWrapper jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  
  private ChatHistoryBubbleListAdapter$HistoryItemOnlongClickListener(ChatHistoryBubbleListAdapter paramChatHistoryBubbleListAdapter) {}
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    label157:
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      if (i == 2131365636)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter$HistoryDeleteOperator != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter$HistoryDeleteOperator.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_del", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
      for (;;)
      {
        if ((i != 2131377708) && (AIOSelectableDelegateImpl.a().c())) {
          AIOSelectableDelegateImpl.a().d();
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((i != 2131365448) || ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPtt))) {
          break label317;
        }
        if (!AIOSelectableDelegateImpl.a().c()) {
          break;
        }
        localObject1 = AIOSelectableDelegateImpl.a().b();
        ((ClipboardManager)BaseApplicationImpl.getApplication().getSystemService("clipboard")).setText((CharSequence)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_copy", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))
      {
        localObject2 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg;
        if ((localObject2 == null) || (((MessageForStructing)localObject2).structingMsg == null) || (!"web".equals(((MessageForStructing)localObject2).structingMsg.mMsgAction)) || (((MessageForStructing)localObject2).structingMsg.mMsgUrl == null)) {
          break label381;
        }
        localObject1 = ((MessageForStructing)localObject2).structingMsg.mMsgUrl;
      }
    }
    label317:
    label381:
    for (;;)
    {
      break label157;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg;
      break label157;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter);
      localObject2 = paramView.getContext();
      ((ChatItemBuilder)localObject1).b = 2;
      ((ChatItemBuilder)localObject1).a(paramView.getId(), (Context)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      break;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
      break;
    }
  }
  
  public void onDismiss()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.b();
    }
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((BaseBubbleBuilder.TouchDelegate)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
        if ((localObject2 == null) || (!(localObject2 instanceof AbsStructMsgItem))) {
          break label153;
        }
        ((AbsStructMsgItem)localObject2).b(this.jdField_a_of_type_AndroidViewView);
      }
      label153:
      label378:
      do
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView = null;
          this.jdField_b_of_type_AndroidViewView = null;
          return;
          if ((!(localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
          this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          if (this.jdField_a_of_type_Boolean) {
            if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368907);
            if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
              break label378;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838423);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                ChatHistoryBubbleListAdapter.c((MessageForStructing)localObject3, (BaseBubbleBuilder.ViewHolder)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131378566);
          if ((localObject1 != null) && ((localObject1 instanceof PAHighLightImageView))) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof StructMsgItemButton));
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
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
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838415);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838413);
        }
      }
      localObject1 = null;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_Boolean) {}
    for (boolean bool1 = false; (!bool1) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a()); bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView))
    {
      a(paramView);
      return false;
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    Object localObject3 = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    Object localObject2 = new QQCustomMenu();
    Object localObject1 = ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a((ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter);
    Object localObject4 = localChatItemBuilder.a(paramView);
    int j;
    int k;
    if ((localObject4 != null) && (localObject4.length > 0))
    {
      j = localObject4.length;
      i = 0;
      while (i < j)
      {
        QQCustomMenuItem localQQCustomMenuItem = localObject4[i];
        k = localQQCustomMenuItem.a();
        if ((k == 2131365448) || (k == 2131377708) || (k == 2131367398) || (k == 2131366625)) {
          ((QQCustomMenu)localObject2).a(localQQCustomMenuItem);
        }
        i += 1;
      }
    }
    ((QQCustomMenu)localObject2).a(2131365636, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690860), 2130839054);
    if (((QQCustomMenu)localObject2).a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatItemBuilder.BaseHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)) {
        break label1244;
      }
    }
    label539:
    label582:
    label841:
    label970:
    label984:
    label1244:
    for (int i = 1;; i = 0)
    {
      k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = AIOUtils.a(10.0F, paramView.getResources());
      localObject3 = new int[2];
      paramView.getLocationOnScreen((int[])localObject3);
      j = localObject3[1] - AIOUtils.a(3.0F, paramView.getResources());
      localObject3 = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject3);
      if (j - AIOUtils.a(72.0F, paramView.getResources()) > ((Rect)localObject3).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper = new AIOMenuWrapper(ChatHistoryBubbleListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter));
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(this);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - ViewUtils.b(14.0F);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.b = k;
        if (bool1)
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
          if ((localObject1 != null) && (((ChatMessage)localObject1).isMultiMsg)) {}
          for (boolean bool2 = true;; bool2 = false)
          {
            ((CommonMenuWrapper)localObject3).a((QQCustomMenu)localObject2, bool2);
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(k);
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.b(j);
            a(paramView);
            if (i != 0)
            {
              paramView.setPressed(true);
              this.jdField_a_of_type_AndroidViewView = paramView;
              localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
              if (!(localObject1 instanceof AbsStructMsgItem)) {
                break;
              }
              ((AbsStructMsgItem)localObject1).c(this.jdField_a_of_type_AndroidViewView);
            }
            if ((localChatItemBuilder instanceof BaseBubbleBuilder))
            {
              localObject1 = ((BaseBubbleBuilder)localChatItemBuilder).a(paramView);
              if (localObject1 != null)
              {
                this.jdField_a_of_type_AndroidViewView = paramView;
                if (!bool1) {
                  break label1192;
                }
                ((BaseBubbleBuilder.TouchDelegate)localObject1).a(paramView, true);
              }
            }
            if (bool1)
            {
              if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
                break label1204;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryBubbleListAdapter", 2, "performCursorTouch ");
              }
            }
            return true;
          }
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(paramView, ChatHistoryBubbleListAdapter.b(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter));
        if ((ChatHistoryBubbleListAdapter.c(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter) != null) && (ChatHistoryBubbleListAdapter.d(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter).a != null))
        {
          localObject1 = new int[2];
          ChatHistoryBubbleListAdapter.e(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter).a.getLocationInWindow((int[])localObject1);
        }
        for (;;)
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
          j = ((CommonMenuWrapper.MenuPlaceInfo)localObject3).jdField_a_of_type_Int;
          m = ((CommonMenuWrapper.MenuPlaceInfo)localObject3).b;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = Integer.valueOf(localObject1[1]))
          {
            ((CommonMenuWrapper)localObject4).a(paramView, k, j, (QQCustomMenu)localObject2, true, m, (Integer)localObject1);
            break;
          }
          if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
          {
            localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
            if ((localChatItemBuilder instanceof StructingMsgItemBuilder))
            {
              if (((StructingMsgItemBuilder)localChatItemBuilder).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
              {
                if ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                  this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
                }
                this.jdField_a_of_type_Boolean = false;
              }
            }
            else
            {
              if ((this.jdField_b_of_type_AndroidViewView == null) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_Boolean)) {
                break label968;
              }
              localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
              i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
              j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
              k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
              m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
              if (!this.jdField_a_of_type_Boolean) {
                break label984;
              }
              if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
                break label970;
              }
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850409);
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
              break;
              this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout;
              this.jdField_a_of_type_Boolean = true;
              break label841;
              break;
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850233);
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
              {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838425);
              }
              else
              {
                localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                if (((BaseBubbleBuilder)localChatItemBuilder).a(paramView) == null) {
                  ChatHistoryBubbleListAdapter.b((MessageForStructing)localObject3, (BaseBubbleBuilder.ViewHolder)localObject1, this.jdField_b_of_type_AndroidViewView, true);
                }
              }
            }
          }
          if (!(localObject1 instanceof StructMsgItemButton)) {
            break label539;
          }
          this.jdField_b_of_type_AndroidViewView = paramView;
          localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          int n = ((Integer)paramView.getTag(2131378545)).intValue();
          if (n == 0) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838412);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
            break;
            if (n == 2) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838416);
            } else {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838414);
            }
          }
          ((BaseBubbleBuilder.TouchDelegate)localObject1).a(paramView, false);
          break label582;
          this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper);
          break label640;
          a(paramView);
          return false;
          localObject1 = null;
        }
        j = k - m;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).a(paramView);
      if (localObject != null) {
        ((BaseBubbleBuilder.TouchDelegate)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter.HistoryItemOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */