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
import com.tencent.mobileqq.activity.aio.Callback;
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
  implements Callback
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
      localLayoutParams1.leftMargin = ((int)(this.jdField_a_of_type_Float * 16.0F));
    }
    else
    {
      localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
      localLayoutParams.rightMargin = 0;
      localLayoutParams1.leftMargin = ((int)(this.jdField_a_of_type_Float * 24.0F));
    }
    paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
    paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.invalidate();
    paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramView.setOnClickListener(this);
  }
  
  private void a(MessageForApproval paramMessageForApproval, ApprovalMsgBuilder.Holder paramHolder)
  {
    for (;;)
    {
      int i;
      Object localObject4;
      Object localObject5;
      Object localObject6;
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
        localObject2 = HardCodeUtil.a(2131700848);
        int j = arrayOfString.length;
        i = 0;
        Object localObject3 = "";
        paramMessageForApproval = "";
        localObject1 = paramMessageForApproval;
        if (i < j)
        {
          String str = arrayOfString[i];
          if (str.startsWith("000"))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject2);
            ((StringBuilder)localObject4).append(str.substring(3));
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = localObject1;
            localObject6 = paramMessageForApproval;
          }
          else if (str.startsWith("001"))
          {
            localObject5 = str.substring(3);
            localObject4 = localObject2;
            localObject6 = paramMessageForApproval;
          }
          else if (str.startsWith("002"))
          {
            localObject6 = str.substring(3);
            localObject4 = localObject2;
            localObject5 = localObject1;
          }
          else
          {
            localObject4 = localObject2;
            localObject5 = localObject1;
            localObject6 = paramMessageForApproval;
            if (str.startsWith("003"))
            {
              localObject3 = str.substring(3);
              localObject4 = localObject2;
              localObject5 = localObject1;
              localObject6 = paramMessageForApproval;
            }
          }
        }
        else
        {
          localObject4 = paramMessageForApproval;
          if ("1".equalsIgnoreCase((String)localObject3) == true)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramMessageForApproval);
            ((StringBuilder)localObject3).append(HardCodeUtil.a(2131700845));
            localObject4 = ((StringBuilder)localObject3).toString();
          }
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          paramMessageForApproval = paramHolder.c;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append((String)localObject4);
          paramMessageForApproval.setText(((StringBuilder)localObject2).toString());
          return;
        }
      }
      catch (Exception paramMessageForApproval)
      {
        if (QLog.isDevelopLevel())
        {
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700849));
          paramHolder.c.setText(HardCodeUtil.a(2131700846));
        }
        QLog.e("ApprovalMsgBuilder", 1, paramMessageForApproval.toString());
        return;
      }
      i += 1;
      Object localObject2 = localObject4;
      Object localObject1 = localObject5;
      paramMessageForApproval = (MessageForApproval)localObject6;
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
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (ApprovalMsgBuilder.Holder)paramViewHolder;
    paramBaseChatItemLayout = (MessageForApproval)paramChatMessage;
    paramBaseChatItemLayout.parse();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558796, null);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131370651));
      paramViewHolder.c = ((TextView)paramChatMessage.findViewById(2131378114));
      paramViewHolder.d = ((TextView)paramChatMessage.findViewById(2131378120));
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramChatMessage.findViewById(2131371580));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131369179));
    }
    a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramOnLongClickAndTouchListener);
    a(paramBaseChatItemLayout, paramViewHolder);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ApprovalMsgBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131700847);
    }
    return HardCodeUtil.a(2131700850);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480) {
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return paramView.a();
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ApprovalMsgBuilder.Holder)AIOUtils.a(paramView);
    a((MessageForApproval)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.o = true;
    if (!super.a())
    {
      super.onClick(paramView);
      if (paramView.getId() == 2131364521) {
        c(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApprovalMsgBuilder
 * JD-Core Version:    0.7.0.1
 */