package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.UITools;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;

public class DiscActiveTipsBar
  implements TipsBarTask
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public DiscActiveTipsBar(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramAIOContext.a();
    this.jdField_a_of_type_AndroidAppActivity = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramAIOContext.a();
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560946, null);
    ((TextView)paramVarArgs.findViewById(2131374123)).setText(2131691768);
    ((ImageView)paramVarArgs.findViewById(2131374121)).setImageResource(2130850188);
    paramVarArgs.findViewById(2131374120).setOnClickListener(new DiscActiveTipsBar.1(this));
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1001) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscActiveTipsBar", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV =====>");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 3000)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
          paramVarArgs.append("curType != disscusion");
          QLog.d("DiscActiveTipsBar", 2, paramVarArgs.toString());
        }
        return;
      }
      if (QQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, 1))
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
          paramVarArgs.append("hasNetTipShow today");
          QLog.d("DiscActiveTipsBar", 2, paramVarArgs.toString());
        }
        return;
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
      if (paramVarArgs == null)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
          paramVarArgs.append("aioMsgList == null");
          QLog.d("DiscActiveTipsBar", 2, paramVarArgs.toString());
        }
        return;
      }
      if (paramVarArgs.size() < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("msgList size < 10, size = ");
        ((StringBuilder)localObject1).append(paramVarArgs.size());
        paramVarArgs = ((StringBuilder)localObject1).toString();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
          ((StringBuilder)localObject1).append(paramVarArgs);
          QLog.d("DiscActiveTipsBar", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      paramInt = UITools.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramInt, l1))
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
          paramVarArgs.append("current discussion is on voice chating");
          QLog.d("DiscActiveTipsBar", 2, paramVarArgs.toString());
        }
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("voice_disc_chat_freq_bar_show_count");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
      paramInt = ((SharedPreferences)localObject1).getInt((String)localObject2, 0);
      if (paramInt >= 3)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
          paramVarArgs.append("show times >= 3,just return");
          QLog.d("DiscActiveTipsBar", 2, paramVarArgs.toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("discChatFreqBarShowCount : ");
        ((StringBuilder)localObject2).append(paramInt);
        QLog.d("DiscActiveTipsBar", 2, ((StringBuilder)localObject2).toString());
      }
      l1 = MessageCache.a() * 1000L;
      if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
        this.jdField_a_of_type_AndroidTextFormatTime = new Time();
      }
      this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
      paramInt = this.jdField_a_of_type_AndroidTextFormatTime.year;
      i = this.jdField_a_of_type_AndroidTextFormatTime.month;
      j = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      this.jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 20, j, i, paramInt);
      long l2 = this.jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
      this.jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 23, j, i, paramInt);
      long l3 = this.jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
      if ((l1 < l2) || (l1 > l3)) {
        break label1241;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("voice_disc_chat_freq_bar_show_time");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), null);
      if (!QLog.isColorLevel()) {
        break label1378;
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append("-");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("-");
      ((StringBuilder)localObject3).append(j);
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("currDate is:");
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(",curr hour is:");
      localStringBuilder.append(this.jdField_a_of_type_AndroidTextFormatTime.hour);
      localStringBuilder.append(",discPttFreqTipMsgInsertTime is:");
      localStringBuilder.append((String)localObject2);
      QLog.d("DiscActiveTipsBar", 2, localStringBuilder.toString());
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        long l1;
        Object localObject2;
        int i;
        int j;
        int k;
        int m;
        int n;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
          ((StringBuilder)localObject1).append("");
          QLog.d("DiscActiveTipsBar", 2, ((StringBuilder)localObject1).toString());
        }
        for (;;)
        {
          throw paramVarArgs;
        }
        continue;
        i -= 1;
        paramInt = j;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      this.jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject2));
      k = this.jdField_a_of_type_AndroidTextFormatTime.year;
      m = this.jdField_a_of_type_AndroidTextFormatTime.month;
      n = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      if ((paramInt == k) && (i == m) && (j == n))
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
          paramVarArgs.append("already show discuss ppt frequent bar this day");
          QLog.d("DiscActiveTipsBar", 2, paramVarArgs.toString());
        }
        return;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("start_group_audio_time");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject1 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), null);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (l1 - Long.parseLong((String)localObject1) <= 600000L))
    {
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
        paramVarArgs.append("has startGroupAudio in less 10 mins, just return");
        QLog.d("DiscActiveTipsBar", 2, paramVarArgs.toString());
      }
      return;
    }
    l1 = (l1 - 600000L) / 1000L;
    paramInt = paramVarArgs.size();
    localObject1 = new HashSet();
    i = paramInt - 1;
    paramInt = 0;
    if (i >= 0)
    {
      localObject2 = (ChatMessage)paramVarArgs.get(i);
      j = paramInt;
      if (((ChatMessage)localObject2).time >= l1)
      {
        j = paramInt;
        if (MsgProxyUtils.h(((ChatMessage)localObject2).msgtype))
        {
          j = paramInt;
          if (((ChatMessage)localObject2).extraflag == 0)
          {
            j = paramInt + 1;
            ((HashSet)localObject1).add(((ChatMessage)localObject2).senderuin);
          }
        }
      }
    }
    else
    {
      i = ((HashSet)localObject1).size();
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("basicMsgNum : ");
        paramVarArgs.append(paramInt);
        paramVarArgs.append(", msgUinNum : ");
        paramVarArgs.append(i);
        QLog.d("DiscActiveTipsBar", 2, paramVarArgs.toString());
      }
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
        paramVarArgs.append("");
        QLog.d("DiscActiveTipsBar", 2, paramVarArgs.toString());
      }
      return;
      label1241:
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("current time not in ");
      paramVarArgs.append(20);
      paramVarArgs.append("-");
      paramVarArgs.append(23);
      paramVarArgs = paramVarArgs.toString();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:");
        ((StringBuilder)localObject1).append(paramVarArgs);
        QLog.d("DiscActiveTipsBar", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
  }
  
  public int[] a()
  {
    return new int[] { 2000 };
  }
  
  public int b()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.DiscActiveTipsBar
 * JD-Core Version:    0.7.0.1
 */