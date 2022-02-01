package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

class ChatHistoryAdapterForC2C$HistoryItemOnlongClickListener
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  CommonMenuWrapper jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d = false;
  
  private ChatHistoryAdapterForC2C$HistoryItemOnlongClickListener(ChatHistoryAdapterForC2C paramChatHistoryAdapterForC2C) {}
  
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
  
  private boolean a(QQCustomMenu paramQQCustomMenu, View paramView, boolean paramBoolean, ChatMessage paramChatMessage, ChatItemBuilder paramChatItemBuilder)
  {
    if (paramQQCustomMenu.a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))) {
        break label549;
      }
    }
    label549:
    for (int i = 1;; i = 0)
    {
      int k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int m = AIOUtils.a(10.0F, paramView.getResources());
      Object localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      int j = localObject[1] - AIOUtils.a(3.0F, paramView.getResources());
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      if (j - AIOUtils.a(72.0F, paramView.getResources()) > ((Rect)localObject).top) {}
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper = new AIOMenuWrapper(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(this);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
        k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - ViewUtils.b(14.0F);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.b = k;
        if (paramBoolean)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
          if ((paramChatMessage != null) && (paramChatMessage.isMultiMsg)) {}
          for (boolean bool = true;; bool = false)
          {
            ((CommonMenuWrapper)localObject).a(paramQQCustomMenu, bool);
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(k);
            this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.b(j);
            a(paramView);
            if (i != 0) {
              a(paramView, paramChatItemBuilder);
            }
            if ((paramChatItemBuilder instanceof BaseBubbleBuilder))
            {
              paramQQCustomMenu = ((BaseBubbleBuilder)paramChatItemBuilder).a(paramView);
              if (paramQQCustomMenu != null)
              {
                this.jdField_a_of_type_AndroidViewView = paramView;
                if (!paramBoolean) {
                  break;
                }
                paramQQCustomMenu.a(paramView, true);
              }
            }
            label313:
            if (paramBoolean)
            {
              if ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2))) {
                break label508;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryAdapterForC2C", 2, "performCursorTouch ");
              }
            }
            label370:
            return true;
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null))
        {
          paramChatMessage = new int[2];
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getLocationInWindow(paramChatMessage);
        }
        for (;;)
        {
          CommonMenuWrapper localCommonMenuWrapper = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
          j = ((CommonMenuWrapper.MenuPlaceInfo)localObject).a;
          m = ((CommonMenuWrapper.MenuPlaceInfo)localObject).b;
          if (paramChatMessage == null) {}
          for (paramChatMessage = null;; paramChatMessage = Integer.valueOf(paramChatMessage[1]))
          {
            localCommonMenuWrapper.a(paramView, k, j, paramQQCustomMenu, true, m, paramChatMessage);
            break;
          }
          paramQQCustomMenu.a(paramView, false);
          break label313;
          label508:
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper);
          break label370;
          a(paramView);
          return false;
          paramChatMessage = null;
        }
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
    int i = paramView.getId();
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      if (i == 2131365636)
      {
        if (ChatHistoryAdapterForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C) != null) {
          ChatHistoryAdapterForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_delete", 1, 0, new String[0]);
      }
    }
    for (;;)
    {
      if ((i != 2131377708) && (AIOSelectableDelegateImpl.a().c())) {
        AIOSelectableDelegateImpl.a().d();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (i == 2131378967)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
        localObject = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject);
        if (localObject != null) {
          TeamWorkConvertUtils.a((FileManagerEntity)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        } else {
          QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131719804), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299166));
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
        Context localContext = paramView.getContext();
        ((ChatItemBuilder)localObject).a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
        }
      }
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
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
        if (!(localObject2 instanceof AbsStructMsgItem)) {
          break label148;
        }
        ((AbsStructMsgItem)localObject2).b(this.jdField_a_of_type_AndroidViewView);
      }
      label148:
      label328:
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
          if (this.jdField_a_of_type_Boolean) {
            if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368907);
            if (!(localObject1 instanceof PAHighLightImageView)) {
              break label328;
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
                ChatAdapter1.a((MessageForStructing)localObject3, (BaseBubbleBuilder.ViewHolder)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131378566);
          if ((localObject1 instanceof PAHighLightImageView)) {
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
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Boolean) {}
    for (boolean bool = false;; bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView))
    {
      this.jdField_b_of_type_Boolean = true;
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onLongClick(paramView);
      }
      if ((bool) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a())) {
        break;
      }
      a(paramView);
      return false;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgtype;
    if ((j == -2014) || (j == -2005))
    {
      if (this.c)
      {
        this.d = TencentDocConvertConfigProcessor.a().c();
        this.c = false;
      }
      localObject1 = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject3 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject1);
      if ((localObject3 != null) && (((FileManagerEntity)localObject3).status != 16))
      {
        long l = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject3).fileName);
        localObject2 = TencentDocImportFileInfoProcessor.a().c();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = TeamWorkUtils.a;
        }
        if ((this.d) && (TeamWorkUtils.a(((FileManagerEntity)localObject3).getFilePath(), ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          localQQCustomMenu.a(2131378967, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b.getString(2131719807), 2130839071);
        }
      }
    }
    Object localObject1 = ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a((ChatMessage)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
    Object localObject3 = ((ChatItemBuilder)localObject2).a(paramView);
    if ((localObject3 != null) && (localObject3.length > 0))
    {
      j = localObject3.length;
      while (i < j)
      {
        QQCustomMenuItem localQQCustomMenuItem = localObject3[i];
        int k = localQQCustomMenuItem.a();
        if (((k == 2131365448) || (k == 2131377708) || (k == 2131367398) || (k == 2131366625)) && (localQQCustomMenuItem.b() != 2130838595)) {
          localQQCustomMenu.a(localQQCustomMenuItem);
        }
        i += 1;
      }
    }
    localQQCustomMenu.a(2131365636, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690860), 2130839054);
    return a(localQQCustomMenu, paramView, bool, (ChatMessage)localObject1, (ChatItemBuilder)localObject2);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C.HistoryItemOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */