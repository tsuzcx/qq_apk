package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfUtil;
import com.tencent.biz.pubaccount.ecshopassit.view.QggMinusOneViewTitleLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ArkAppPublicAccountItemBuilder
  extends ArkAppItemBuilder
{
  private long c;
  private long d;
  
  public ArkAppPublicAccountItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (paramChatMessage.istroop == 1038)
    {
      long l = System.currentTimeMillis();
      if ((this.c != paramChatMessage.msgUid) || (l - this.d > 1000L))
      {
        this.c = paramChatMessage.msgUid;
        this.d = l;
        if ((paramChatMessage instanceof MessageForArkApp))
        {
          Object localObject = (MessageForArkApp)paramChatMessage;
          if (((MessageForArkApp)localObject).ark_app_message != null)
          {
            this.d = System.currentTimeMillis();
            localObject = ((MessageForArkApp)localObject).ark_app_message.appView;
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("message", "message_aio", "expo", "com.tencent.miniapp", (String)localObject, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("xiaoyong", 2, "ArkAppPublicAccountItemBuilder report");
            }
          }
        }
      }
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    EcshopAdHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramView);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && ((paramViewHolder instanceof ArkAppPublicAccountItemBuilder.ArkPublicAccountHolder)))
        {
          localArkPublicAccountHolder = (ArkAppPublicAccountItemBuilder.ArkPublicAccountHolder)paramViewHolder;
          if ((paramChatMessage instanceof MessageForArkApp))
          {
            if (paramView == null) {
              localArkPublicAccountHolder.a = new QggMinusOneViewTitleLayout(this.jdField_a_of_type_AndroidContentContext);
            }
            if ((localArkPublicAccountHolder.a != null) && (paramBaseChatItemLayout != null))
            {
              String str = paramChatMessage.getExtInfoFromExtStr("add_title");
              if ((!str.equals("minus_view_title_first")) && (!str.equals("minus_view_title_second"))) {
                continue;
              }
              if (paramBaseChatItemLayout.a != null) {
                paramBaseChatItemLayout.a.setText("");
              }
              if (!str.equals("minus_view_title_first")) {
                continue;
              }
              localArkPublicAccountHolder.a.setMinusViewTitle(EcshopConfUtil.a());
              localArkPublicAccountHolder.a.setId(2131364665);
              paramBaseChatItemLayout.removeView(localArkPublicAccountHolder.a);
              paramBaseChatItemLayout.addView(localArkPublicAccountHolder.a);
              if (!str.equals("minus_view_title_second")) {
                continue;
              }
              localArkPublicAccountHolder.a.setPadding((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296446), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296447), -UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        ArkAppPublicAccountItemBuilder.ArkPublicAccountHolder localArkPublicAccountHolder;
        QLog.e("ArkAppPublicAccountItemBuilder", 1, localThrowable, new Object[0]);
        continue;
        localThrowable.a.setPadding((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296446), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F), (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296447), -UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
        continue;
        paramBaseChatItemLayout.removeView(localThrowable.a);
        continue;
      }
      return super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      localArkPublicAccountHolder.a.setQggTitle(EcshopConfUtil.a());
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppPublicAccountItemBuilder.ArkPublicAccountHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppPublicAccountItemBuilder
 * JD-Core Version:    0.7.0.1
 */