package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongMsgItemTitleImageView;
import cooperation.dingdong.DingdongPluginHelper;
import uqx;

public class ApprovalMsgBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  Handler b;
  
  public ApprovalMsgBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(MessageForApproval paramMessageForApproval, uqx paramuqx)
  {
    for (;;)
    {
      int i;
      Object localObject5;
      Object localObject3;
      Object localObject4;
      try
      {
        paramuqx.d.setText(paramMessageForApproval.summary);
        String[] arrayOfString = paramMessageForApproval.title.split("\002");
        if (arrayOfString.length == 1)
        {
          paramuqx.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForApproval.title.substring(3));
          paramuqx.c.setVisibility(8);
          return;
        }
        int j = arrayOfString.length;
        String str1 = "";
        paramMessageForApproval = "";
        localObject2 = "";
        localObject1 = "申请";
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
            localObject3 = paramMessageForApproval + "(含周末)";
          }
          paramuqx.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          paramuqx.c.setText((String)localObject2 + (String)localObject3);
          return;
        }
      }
      catch (Exception paramMessageForApproval)
      {
        if (QLog.isDevelopLevel())
        {
          paramuqx.jdField_b_of_type_AndroidWidgetTextView.setText("解析出错了，快查!");
          paramuqx.c.setText("解析出错了，快查!");
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
  
  private void a(uqx paramuqx, MessageForApproval paramMessageForApproval, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramuqx.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramuqx.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    int i;
    if (paramMessageForApproval.isSend())
    {
      i = 2130838170;
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
    }
    for (localLayoutParams1.leftMargin = ((int)(16.0F * this.jdField_a_of_type_Float));; localLayoutParams1.leftMargin = ((int)(24.0F * this.jdField_a_of_type_Float)))
    {
      paramuqx.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      paramuqx.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
      paramuqx.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
      paramuqx.jdField_a_of_type_AndroidWidgetTextView.invalidate();
      paramuqx.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.setBackgroundResource(i);
      paramuqx.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.buildDrawingCache();
      paramuqx.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.setReplaceColor(Color.rgb(38, 209, 166));
      paramuqx.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView.invalidate();
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setOnClickListener(this);
      return;
      i = 2130838169;
      localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
      localLayoutParams.rightMargin = 0;
    }
  }
  
  private void d(View paramView)
  {
    MessageForApproval localMessageForApproval = (MessageForApproval)AIOUtils.a(paramView);
    DingdongPluginHelper.a((Activity)paramView.getContext(), localMessageForApproval.subType, localMessageForApproval.workId);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (uqx)paramChatMessage.getTag();
    paramView.jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.d;
    if (jdField_b_of_type_Boolean) {}
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
    paramViewHolder = (uqx)paramViewHolder;
    paramBaseChatItemLayout = (MessageForApproval)paramChatMessage;
    paramBaseChatItemLayout.parse();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968740, null);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131363506));
      paramViewHolder.c = ((TextView)paramChatMessage.findViewById(2131363507));
      paramViewHolder.d = ((TextView)paramChatMessage.findViewById(2131363509));
      paramViewHolder.jdField_a_of_type_CooperationDingdongDingdongMsgItemTitleImageView = ((DingdongMsgItemTitleImageView)paramChatMessage.findViewById(2131363503));
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramChatMessage.findViewById(2131363505));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131363504));
    }
    a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramOnLongClickAndTouchListener);
    a(paramBaseChatItemLayout, paramViewHolder);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new uqx(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "收到审批";
    }
    return "发来审批";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView) {}
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (uqx)AIOUtils.a(paramView);
    a((MessageForApproval)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.m = true;
    if (super.a()) {
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131361862: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApprovalMsgBuilder
 * JD-Core Version:    0.7.0.1
 */