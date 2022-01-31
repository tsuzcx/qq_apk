package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.hiboom.HiBoomTextView.OnDoubleClick;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import vfi;
import vfj;
import vfk;

public class HiBoomItemBuilder
  extends BaseBubbleBuilder
{
  private HiBoomTextView.OnDoubleClick a;
  public Context b;
  
  public HiBoomItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick = new vfi(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
  }
  
  private void e(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = HiBoomManager.a(this.jdField_b_of_type_AndroidContentContext);
      if (paramChatMessage != null)
      {
        paramChatMessage.a("正在转发嗨爆消息...");
        paramChatMessage.show();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
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
        paramChatMessage = (MessageForHiBoom)paramChatMessage;
        if (paramChatMessage.mHiBoomMessage != null)
        {
          paramViewHolder.setHiBoom(paramChatMessage.mHiBoomMessage.id, 1, HiBoomManager.a);
          paramViewHolder.setText(paramChatMessage.mHiBoomMessage.text);
          if (jdField_b_of_type_Boolean) {
            paramViewHolder.setContentDescription(a(paramChatMessage));
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
    case 2131375643: 
      super.c(paramChatMessage);
      return;
    case 2131362399: 
      e(paramChatMessage);
      return;
    case 2131375633: 
      ChatActivityFacade.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = AIOUtils.a(paramView);
    String str1 = this.jdField_b_of_type_AndroidContentContext.getString(2131433649);
    String str2 = this.jdField_b_of_type_AndroidContentContext.getString(2131433650);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.jdField_b_of_type_AndroidContentContext, 230, str1, str2, new vfj(this, paramView), new vfk(this)).show();
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((AIOUtils.a(paramView) instanceof HiBoomItemBuilder.HiBoomHolder))
    {
      paramView = (HiBoomItemBuilder.HiBoomHolder)AIOUtils.a(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForHiBoom)) {
        localQQCustomMenu.a(2131362399, this.jdField_b_of_type_AndroidContentContext.getString(2131435099), 2130838318);
      }
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