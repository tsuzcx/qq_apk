package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ArkAppPublicAccountItemBuilder
  extends ArkAppItemBuilder
{
  private final List<MessageRecord> a;
  private long c;
  private long d;
  
  public ArkAppPublicAccountItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramMessageRecord))
    {
      if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).reportArkExposure(paramView.getContext(), paramMessageRecord);
      }
      this.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
    }
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      ((IQQGameSubscribeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQGameSubscribeService.class, "all")).handleSubscribeGrayTipsUi(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramChatMessage, paramBaseChatItemLayout, -5008);
    }
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
    ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).bindViewForGdtReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramView);
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, @NonNull BaseBubbleBuilder.ViewHolder paramViewHolder, @NonNull View paramView, @NonNull BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    try
    {
      c(paramChatMessage, paramBaseChatItemLayout);
      a(paramBaseChatItemLayout, paramChatMessage);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ArkAppPublicAccountItemBuilder", 1, localThrowable, new Object[0]);
    }
    return super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppPublicAccountItemBuilder
 * JD-Core Version:    0.7.0.1
 */