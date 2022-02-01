package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.Bundle;
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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.hiboom.HiBoomTextView.OnDoubleClick;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class HiBoomItemBuilder
  extends BaseBubbleBuilder
{
  private HiBoomTextView.OnDoubleClick a;
  Context b;
  
  public HiBoomItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick = new HiBoomItemBuilder.1(this);
    this.b = paramContext;
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = HiBoomConstants.a(this.b);
      if (paramChatMessage != null)
      {
        paramChatMessage.a(HardCodeUtil.a(2131705558));
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
    if ((paramViewHolder instanceof HiBoomItemBuilder.HiBoomHolder))
    {
      paramViewHolder = (HiBoomItemBuilder.HiBoomHolder)paramViewHolder;
    }
    else
    {
      paramViewHolder = (HiBoomItemBuilder.HiBoomHolder)a();
      paramView = null;
    }
    if ((paramView instanceof HiBoomTextView))
    {
      paramBaseChatItemLayout = (HiBoomTextView)paramView;
      paramOnLongClickAndTouchListener = paramView;
    }
    else
    {
      paramView = new HiBoomTextView(this.b);
      paramView.setMaxSize(Math.min(BaseChatItemLayout.f, HiBoomConstants.a));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramView;
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setTag(paramViewHolder);
      paramOnLongClickAndTouchListener = paramView;
      paramBaseChatItemLayout = paramView;
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick;
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      if (paramChatMessage.mHiBoomMessage != null)
      {
        paramBaseChatItemLayout.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, HiBoomConstants.b);
        paramBaseChatItemLayout.setText(paramChatMessage.mHiBoomMessage.text);
        if (e) {
          paramBaseChatItemLayout.setContentDescription(a(paramChatMessage));
        }
      }
    }
    return paramOnLongClickAndTouchListener;
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
    if (paramInt != 2131365480)
    {
      if (paramInt != 2131368164)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      b(paramChatMessage);
      return;
    }
    ChatActivityFacade.b(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = AIOUtils.a(paramView);
    String str1 = this.b.getString(2131689933);
    String str2 = this.b.getString(2131689934);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.b, 230, str1, str2, new HiBoomItemBuilder.2(this, paramView), new HiBoomItemBuilder.3(this)).show();
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((AIOUtils.a(paramView) instanceof HiBoomItemBuilder.HiBoomHolder))
    {
      paramView = (HiBoomItemBuilder.HiBoomHolder)AIOUtils.a(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForHiBoom))
      {
        localQQCustomMenu.a(2131368164, this.b.getString(2131692644), 2130838912);
        if (((MessageForHiBoom)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).istroop == 0) {
          a(localQQCustomMenu, this.b, 2131376417, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localQQCustomMenu, this.b, 2131371562, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, new Bundle());
      }
      a(localQQCustomMenu, this.b, 2131365480, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, new Bundle());
    }
    super.a(localQQCustomMenu, this.b, 2131371603, null, null);
    super.a(localQQCustomMenu, this.b, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HiBoomItemBuilder
 * JD-Core Version:    0.7.0.1
 */