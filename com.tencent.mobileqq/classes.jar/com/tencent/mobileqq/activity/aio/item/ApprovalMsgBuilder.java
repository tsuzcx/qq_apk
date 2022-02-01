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
  Handler a = new Handler();
  
  public ApprovalMsgBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(ApprovalMsgBuilder.Holder paramHolder, MessageForApproval paramMessageForApproval, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramHolder.a.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramHolder.b.getLayoutParams();
    if (paramMessageForApproval.isSend())
    {
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = ((int)(this.k * 6.0F));
      localLayoutParams1.leftMargin = ((int)(this.k * 16.0F));
    }
    else
    {
      localLayoutParams.leftMargin = ((int)(this.k * 6.0F));
      localLayoutParams.rightMargin = 0;
      localLayoutParams1.leftMargin = ((int)(this.k * 24.0F));
    }
    paramHolder.a.setLayoutParams(localLayoutParams);
    paramHolder.b.setLayoutParams(localLayoutParams1);
    paramHolder.a.invalidate();
    paramHolder.b.invalidate();
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
        paramHolder.e.setText(paramMessageForApproval.summary);
        String[] arrayOfString = paramMessageForApproval.title.split("\002");
        if (arrayOfString.length == 1)
        {
          paramHolder.c.setText(paramMessageForApproval.title.substring(3));
          paramHolder.d.setVisibility(8);
          return;
        }
        localObject2 = HardCodeUtil.a(2131898872);
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
            ((StringBuilder)localObject3).append(HardCodeUtil.a(2131898869));
            localObject4 = ((StringBuilder)localObject3).toString();
          }
          paramHolder.c.setText((CharSequence)localObject2);
          paramMessageForApproval = paramHolder.d;
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
          paramHolder.c.setText(HardCodeUtil.a(2131898873));
          paramHolder.d.setText(HardCodeUtil.a(2131898870));
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
  
  private void e(View paramView)
  {
    paramView = (MessageForApproval)AIOUtils.a(paramView);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (ApprovalMsgBuilder.Holder)paramChatMessage.getTag();
    paramView.h.getLayoutParams().width = BaseChatItemLayout.e;
    if (v) {}
    try
    {
      paramView.r.append(paramView.c.getText());
      paramView.r.append(paramView.d.getText());
      paramView.r.append("审批");
      paramChatMessage.setContentDescription(paramView.r.toString());
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
      paramChatMessage = LayoutInflater.from(this.e).inflate(2131624416, null);
      paramViewHolder.c = ((TextView)paramChatMessage.findViewById(2131437927));
      paramViewHolder.d = ((TextView)paramChatMessage.findViewById(2131446620));
      paramViewHolder.e = ((TextView)paramChatMessage.findViewById(2131446627));
      paramViewHolder.a = ((LinearLayout)paramChatMessage.findViewById(2131438961));
      paramViewHolder.b = ((TextView)paramChatMessage.findViewById(2131436153));
    }
    a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramOnLongClickAndTouchListener);
    a(paramBaseChatItemLayout, paramViewHolder);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ApprovalMsgBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695) {
      return;
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.e, this.f.a);
    super.a(paramView, this.e, 2131439015, null, null);
    super.a(paramView, this.e, 2131428089, null, null);
    return paramView.d();
  }
  
  protected void b(View paramView) {}
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131898871);
    }
    return HardCodeUtil.a(2131898874);
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ApprovalMsgBuilder.Holder)AIOUtils.b(paramView);
    a((MessageForApproval)paramView.q, paramView);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.q = true;
    if (!super.c())
    {
      super.onClick(paramView);
      if (paramView.getId() == 2131430578) {
        e(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApprovalMsgBuilder
 * JD-Core Version:    0.7.0.1
 */