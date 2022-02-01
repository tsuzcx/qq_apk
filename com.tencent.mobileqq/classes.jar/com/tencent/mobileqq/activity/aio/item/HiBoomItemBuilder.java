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
  Context a;
  private HiBoomTextView.OnDoubleClick w = new HiBoomItemBuilder.1(this);
  
  public HiBoomItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a = paramContext;
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((ISVIPHandler)this.d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = HiBoomConstants.a(this.a);
      if (paramChatMessage != null)
      {
        paramChatMessage.a(HardCodeUtil.a(2131903445));
        paramChatMessage.show();
      }
    }
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
      paramView = new HiBoomTextView(this.a);
      paramView.setMaxSize(Math.min(BaseChatItemLayout.f, HiBoomConstants.a));
      paramViewHolder.a = paramView;
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setTag(paramViewHolder);
      paramOnLongClickAndTouchListener = paramView;
      paramBaseChatItemLayout = paramView;
    }
    paramViewHolder.a.h = this.w;
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      if (paramChatMessage.mHiBoomMessage != null)
      {
        paramBaseChatItemLayout.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.f, HiBoomConstants.e);
        paramBaseChatItemLayout.setText(paramChatMessage.mHiBoomMessage.text);
        if (v) {
          paramBaseChatItemLayout.setContentDescription(d(paramChatMessage));
        }
      }
    }
    return paramOnLongClickAndTouchListener;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new HiBoomItemBuilder.HiBoomHolder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      if (paramInt != 2131435025)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      b(paramChatMessage);
      return;
    }
    ChatActivityFacade.b(paramContext, this.d, paramChatMessage);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((AIOUtils.b(paramView) instanceof HiBoomItemBuilder.HiBoomHolder))
    {
      paramView = (HiBoomItemBuilder.HiBoomHolder)AIOUtils.b(paramView);
      if ((paramView.q instanceof MessageForHiBoom))
      {
        localQQCustomMenu.a(2131435025, this.a.getString(2131889668), 2130839066);
        if (((MessageForHiBoom)paramView.q).istroop == 0) {
          a(localQQCustomMenu, this.a, 2131444634, paramView.q, null);
        }
      }
      if ((paramView.q.extraflag != 32768) && (!this.d.getMsgCache().f(paramView.q))) {
        a(localQQCustomMenu, this.a, 2131438943, paramView.q, new Bundle());
      }
      a(localQQCustomMenu, this.a, 2131431695, paramView.q, new Bundle());
    }
    super.a(localQQCustomMenu, this.a, 2131439015, null, null);
    super.a(localQQCustomMenu, this.a, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    paramView = AIOUtils.a(paramView);
    String str1 = this.a.getString(2131886574);
    String str2 = this.a.getString(2131886575);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.a, 230, str1, str2, new HiBoomItemBuilder.2(this, paramView), new HiBoomItemBuilder.3(this)).show();
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HiBoomItemBuilder
 * JD-Core Version:    0.7.0.1
 */