package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.hiboom.HiBoomTextView.OnDoubleClick;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import uxf;
import uxg;

public class HiBoomItemBuilder
  extends QIMTailItemBubbleBuilder
{
  protected View.OnClickListener a;
  HiBoomTextView.OnDoubleClick a;
  public Context b;
  
  public HiBoomItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uxf(this);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick = new uxg(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(ChatMessage paramChatMessage, int paramInt) {}
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = paramViewGroup;
    if ((paramViewGroup instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)paramViewGroup;
      paramView = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (HiBoomItemBuilder.HiBoomHolder)paramViewHolder;
    if ((paramView instanceof HiBoomTextView)) {
      paramViewHolder = (HiBoomTextView)paramView;
    }
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick;
      if ((paramChatMessage instanceof MessageForHiBoom))
      {
        paramBaseChatItemLayout = (MessageForHiBoom)paramChatMessage;
        if (paramBaseChatItemLayout.mHiBoomMessage != null)
        {
          paramViewHolder.setHiBoom(paramBaseChatItemLayout.mHiBoomMessage.id, 1, HiBoomManager.a);
          paramViewHolder.setText(paramBaseChatItemLayout.mHiBoomMessage.text);
          if (QLog.isColorLevel())
          {
            paramView = "getBubbleView hiboom message id = " + paramBaseChatItemLayout.mHiBoomMessage.id;
            paramChatMessage = paramView;
            if (paramBaseChatItemLayout.mHiBoomMessage != null)
            {
              paramChatMessage = paramView;
              if (!TextUtils.isEmpty(paramBaseChatItemLayout.mHiBoomMessage.text)) {
                paramChatMessage = paramView + " text = " + paramBaseChatItemLayout.mHiBoomMessage.text.charAt(0);
              }
            }
            QLog.d("HiBoomFont.ItemBuilder", 2, paramChatMessage);
          }
          if (jdField_b_of_type_Boolean) {
            paramViewHolder.setContentDescription(a(paramBaseChatItemLayout));
          }
        }
      }
      return paramViewHolder;
      paramViewHolder = new HiBoomTextView(this.jdField_b_of_type_AndroidContentContext);
      paramViewHolder.setMaxSize(BaseChatItemLayout.e);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramViewHolder;
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new HiBoomItemBuilder.HiBoomHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      if (paramChatMessage.mHiBoomMessage != null) {
        return paramChatMessage.mHiBoomMessage.text;
      }
    }
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131375346: 
      super.c(paramChatMessage);
      return;
    case 2131362395: 
      a(paramChatMessage, 2);
      return;
    case 2131362396: 
      a(paramChatMessage, 1);
      return;
    case 2131375336: 
      ChatActivityFacade.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((AIOUtils.a(paramView) instanceof HiBoomItemBuilder.HiBoomHolder))
    {
      paramView = (HiBoomItemBuilder.HiBoomHolder)AIOUtils.a(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    super.b(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HiBoomItemBuilder
 * JD-Core Version:    0.7.0.1
 */