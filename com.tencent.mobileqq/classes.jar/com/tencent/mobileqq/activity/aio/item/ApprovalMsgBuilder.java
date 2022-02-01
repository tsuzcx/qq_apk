package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ApprovalMsgBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  Handler b = new Handler();
  
  public ApprovalMsgBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(ApprovalMsgBuilder.Holder paramHolder, MessageForApproval paramMessageForApproval, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (paramMessageForApproval.isSend())
    {
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
    }
    for (localLayoutParams1.leftMargin = ((int)(16.0F * this.jdField_a_of_type_Float));; localLayoutParams1.leftMargin = ((int)(24.0F * this.jdField_a_of_type_Float)))
    {
      paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
      paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.invalidate();
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setOnClickListener(this);
      return;
      localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
      localLayoutParams.rightMargin = 0;
    }
  }
  
  private void a(MessageForApproval paramMessageForApproval, ApprovalMsgBuilder.Holder paramHolder)
  {
    for (;;)
    {
      int i;
      Object localObject5;
      Object localObject3;
      Object localObject4;
      try
      {
        paramHolder.d.setText(paramMessageForApproval.summary);
        String[] arrayOfString = paramMessageForApproval.title.split("\002");
        if (arrayOfString.length == 1)
        {
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForApproval.title.substring(3));
          paramHolder.c.setVisibility(8);
          return;
        }
        localObject1 = HardCodeUtil.a(2131700706);
        int j = arrayOfString.length;
        String str1 = "";
        paramMessageForApproval = "";
        localObject2 = "";
        i = 0;
        if (i < j)
        {
          String str2 = arrayOfString[i];
          if (str2.startsWith("000"))
          {
            localObject5 = (String)localObject1 + str2.substring(3);
            localObject3 = paramMessageForApproval;
            localObject4 = localObject2;
          }
          else if (str2.startsWith("001"))
          {
            localObject4 = str2.substring(3);
            localObject3 = paramMessageForApproval;
            localObject5 = localObject1;
          }
          else if (str2.startsWith("002"))
          {
            localObject3 = str2.substring(3);
            localObject4 = localObject2;
            localObject5 = localObject1;
          }
          else
          {
            localObject3 = paramMessageForApproval;
            localObject4 = localObject2;
            localObject5 = localObject1;
            if (str2.startsWith("003"))
            {
              str1 = str2.substring(3);
              localObject3 = paramMessageForApproval;
              localObject4 = localObject2;
              localObject5 = localObject1;
            }
          }
        }
        else
        {
          localObject3 = paramMessageForApproval;
          if ("1".equalsIgnoreCase(str1) == true) {
            localObject3 = paramMessageForApproval + HardCodeUtil.a(2131700703);
          }
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          paramHolder.c.setText((String)localObject2 + (String)localObject3);
          return;
        }
      }
      catch (Exception paramMessageForApproval)
      {
        if (QLog.isDevelopLevel())
        {
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700707));
          paramHolder.c.setText(HardCodeUtil.a(2131700704));
        }
        QLog.e("ApprovalMsgBuilder", 1, paramMessageForApproval.toString());
        return;
      }
      i += 1;
      paramMessageForApproval = (MessageForApproval)localObject3;
      Object localObject2 = localObject4;
      Object localObject1 = localObject5;
    }
  }
  
  private void c(View paramView)
  {
    paramView = (MessageForApproval)AIOUtils.a(paramView);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (ApprovalMsgBuilder.Holder)paramChatMessage.getTag();
    paramView.jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.e;
    if (e) {}
    try
    {
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.c.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append("审批");
      paramChatMessage.setContentDescription(paramView.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramChatMessage;
    }
    catch (Exception paramView) {}
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (ApprovalMsgBuilder.Holder)paramViewHolder;
    paramBaseChatItemLayout = (MessageForApproval)paramChatMessage;
    paramBaseChatItemLayout.parse();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558898, null);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131371017));
      paramViewHolder.c = ((TextView)paramChatMessage.findViewById(2131378719));
      paramViewHolder.d = ((TextView)paramChatMessage.findViewById(2131378725));
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramChatMessage.findViewById(2131371973));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131369452));
    }
    a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramOnLongClickAndTouchListener);
    a(paramBaseChatItemLayout, paramViewHolder);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new ApprovalMsgBuilder.Holder(this);
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131700705);
    }
    return HardCodeUtil.a(2131700708);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ApprovalMsgBuilder.Holder)AIOUtils.a(paramView);
    a((MessageForApproval)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.o = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      switch (paramView.getId())
      {
      case 2131364642: 
      default: 
        break;
      case 2131364634: 
        c(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApprovalMsgBuilder
 * JD-Core Version:    0.7.0.1
 */