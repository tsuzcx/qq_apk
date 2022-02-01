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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
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
  
  private boolean a(QQCustomMenu paramQQCustomMenu, View paramView, boolean paramBoolean, ChatMessage paramChatMessage, ChatItemBuilder paramChatItemBuilder)
  {
    if (paramQQCustomMenu.a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      int i;
      if ((localObject != null) && ((localObject instanceof MessageForStructing))) {
        i = 1;
      } else {
        i = 0;
      }
      int j = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y - AIOUtils.b(10.0F, paramView.getResources());
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      int k = localObject[1] - AIOUtils.b(3.0F, paramView.getResources());
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      if (k - AIOUtils.b(72.0F, paramView.getResources()) > ((Rect)localObject).top) {
        j = k;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper = new AIOMenuWrapper(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(this);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.y);
      k = (int)this.jdField_a_of_type_AndroidGraphicsPointF.x - ViewUtils.b(14.0F);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
      ((CommonMenuWrapper)localObject).b = k;
      if (paramBoolean)
      {
        boolean bool;
        if ((paramChatMessage != null) && (paramChatMessage.isMultiMsg)) {
          bool = true;
        } else {
          bool = false;
        }
        ((CommonMenuWrapper)localObject).a(paramQQCustomMenu, bool);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(k);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.b(j);
      }
      else
      {
        CommonMenuWrapper.MenuPlaceInfo localMenuPlaceInfo = ((CommonMenuWrapper)localObject).a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null))
        {
          paramChatMessage = new int[2];
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getLocationInWindow(paramChatMessage);
        }
        else
        {
          paramChatMessage = null;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
        j = localMenuPlaceInfo.a;
        int m = localMenuPlaceInfo.b;
        if (paramChatMessage == null) {
          paramChatMessage = null;
        } else {
          paramChatMessage = Integer.valueOf(paramChatMessage[1]);
        }
        ((CommonMenuWrapper)localObject).a(paramView, k, j, paramQQCustomMenu, true, m, paramChatMessage);
      }
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
          if (paramBoolean) {
            paramQQCustomMenu.a(paramView, true);
          } else {
            paramQQCustomMenu.a(paramView, false);
          }
        }
      }
      if (paramBoolean) {
        if ((this.jdField_a_of_type_AndroidGraphicsPointF != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView, this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, 1, 2)))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ChatHistoryAdapterForC2C", 2, "performCursorTouch ");
            return true;
          }
        }
        else {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper);
        }
      }
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
    int i = paramView.getId();
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      if (i == 2131365480)
      {
        if (ChatHistoryAdapterForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C) != null) {
          ChatHistoryAdapterForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_delete", 1, 0, new String[0]);
      }
      else
      {
        Object localObject;
        if (i == 2131378344)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
          localObject = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localObject = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject);
          if (localObject != null) {
            TeamWorkConvertUtils.a((FileManagerEntity)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          } else {
            QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131719528), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299168));
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
          Context localContext = paramView.getContext();
          ((ChatItemBuilder)localObject).a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
    }
    if ((i != 2131377136) && (AIOSelectableDelegateImpl.a().c())) {
      AIOSelectableDelegateImpl.a().d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss()
  {
    this.jdField_b_of_type_Boolean = false;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
    if (localObject1 != null) {
      ((CommonMenuWrapper)localObject1).b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
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
    Object localObject2 = this.jdField_a_of_type_AndroidViewView;
    if (localObject2 != null)
    {
      ((View)localObject2).setPressed(false);
      localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
      if ((localObject2 instanceof AbsStructMsgItem))
      {
        ((AbsStructMsgItem)localObject2).b(this.jdField_a_of_type_AndroidViewView);
      }
      else if (((localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        Object localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
        if (this.jdField_a_of_type_Boolean)
        {
          if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidViewView, false);
          }
        }
        else
        {
          ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if ((localChatMessage != null) && (localChatMessage.istroop == 1008))
          {
            if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_Boolean) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838259);
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
        localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131368633);
        if ((localObject1 instanceof PAHighLightImageView))
        {
          ((PAHighLightImageView)localObject1).a();
        }
        else
        {
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131377977);
          if ((localObject1 instanceof PAHighLightImageView)) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      }
      else if ((localObject2 instanceof StructMsgItemButton))
      {
        localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
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
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      }
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_AndroidViewView = null;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_Boolean;
    int i = 0;
    if (bool) {
      bool = false;
    } else {
      bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatAdapterSelectableHelper.a(paramView);
    }
    this.jdField_b_of_type_Boolean = true;
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    if (!bool)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
      if ((localObject1 != null) && (((CommonMenuWrapper)localObject1).a()))
      {
        a(paramView);
        return false;
      }
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
        long l = FileManagerUtil.b(((FileManagerEntity)localObject3).fileName);
        localObject2 = TencentDocImportFileInfoProcessor.a().c();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = ".doc|.docx|.xls|.xlsx|";
        }
        if ((this.d) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(((FileManagerEntity)localObject3).getFilePath(), ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          localQQCustomMenu.a(2131378344, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b.getString(2131719531), 2130838924);
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
        if (((k == 2131365311) || (k == 2131377136) || (k == 2131367180) || (k == 2131366494)) && (localQQCustomMenuItem.b() != 2130838437)) {
          localQQCustomMenu.a(localQQCustomMenuItem);
        }
        i += 1;
      }
    }
    localQQCustomMenu.a(2131365480, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690788), 2130838907);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C.HistoryItemOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */