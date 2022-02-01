package com.tencent.mobileqq.activity.aio.tips;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.Time;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contacts.friend.FriendsUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FriendFreqGrayTips
  implements GrayTipsTask
{
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-1014);
    long l = MessageCache.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramVarArgs.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", l, -1014, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    paramVarArgs = "";
    Object localObject1 = "step is:";
    if (paramInt != 1001) {
      return;
    }
    Object localObject3 = paramVarArgs;
    Object localObject2 = localObject1;
    int i;
    label292:
    label1003:
    boolean bool2;
    try
    {
      if (QLog.isColorLevel())
      {
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        QLog.d("FriendFreqGrayTips", 2, "onAIOEvent(): TYPE_ON_MSG_SENT_RECV ===>");
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("step is:");
          paramVarArgs.append("curType != Friend");
          QLog.d("FriendFreqGrayTips", 2, paramVarArgs.toString());
        }
        return;
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localObject5 = QQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      if (((QQOperateManager)localObject5).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2))
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("step is:");
          paramVarArgs.append("hasNetTipShow today");
          QLog.d("FriendFreqGrayTips", 2, paramVarArgs.toString());
        }
        return;
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      if (localObject4 == null)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("step is:");
          paramVarArgs.append("aioMsgList == null");
          QLog.d("FriendFreqGrayTips", 2, paramVarArgs.toString());
        }
        return;
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      i = ((List)localObject4).size();
      paramInt = i - 1;
    }
    finally
    {
      Object localObject5;
      Object localObject4;
      Object localObject6;
      long l1;
      SharedPreferences localSharedPreferences;
      Object localObject7;
      Object localObject8;
      StringBuilder localStringBuilder;
      int k;
      int m;
      int n;
      long l2;
      long l3;
      boolean bool3;
      localObject1 = localObject2;
    }
    localObject3 = paramVarArgs;
    localObject2 = localObject1;
    boolean bool1;
    int j;
    if (((ChatMessage)((List)localObject4).get(paramInt)).msgtype == -1043)
    {
      bool1 = true;
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        localObject6 = new StringBuilder();
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        ((StringBuilder)localObject6).append("findExcludeMsg :");
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        ((StringBuilder)localObject6).append(bool1);
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        QLog.d("FriendFreqGrayTips", 2, ((StringBuilder)localObject6).toString());
      }
      if (bool1)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("step is:");
          paramVarArgs.append("findExcludeMsg, just return");
          QLog.d("FriendFreqGrayTips", 2, paramVarArgs.toString());
        }
        return;
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      if (((List)localObject4).size() < 10)
      {
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        localObject5 = new StringBuilder();
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        ((StringBuilder)localObject5).append("aioMsgList msg num = ");
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        ((StringBuilder)localObject5).append(((List)localObject4).size());
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        paramVarArgs = ((StringBuilder)localObject5).toString();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("step is:");
          ((StringBuilder)localObject1).append(paramVarArgs);
          QLog.d("FriendFreqGrayTips", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      l1 = MessageCache.a() * 1000L;
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      if (this.jdField_a_of_type_AndroidTextFormatTime == null)
      {
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        this.jdField_a_of_type_AndroidTextFormatTime = new Time();
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      paramInt = this.jdField_a_of_type_AndroidTextFormatTime.year;
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      i = this.jdField_a_of_type_AndroidTextFormatTime.month;
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      j = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localObject6 = new StringBuilder();
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      ((StringBuilder)localObject6).append("voice_chat_freq_tip_msg_insert_time");
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      ((StringBuilder)localObject6).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localObject6 = ((StringBuilder)localObject6).toString();
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localObject7 = localSharedPreferences.getString((String)localObject6, "");
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      bool1 = QLog.isColorLevel();
      if (!bool1) {
        break label2480;
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localObject8 = new StringBuilder();
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      ((StringBuilder)localObject8).append(paramInt);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      ((StringBuilder)localObject8).append("-");
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      ((StringBuilder)localObject8).append(i);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      ((StringBuilder)localObject8).append("-");
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      ((StringBuilder)localObject8).append(j);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localObject8 = ((StringBuilder)localObject8).toString();
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localStringBuilder = new StringBuilder();
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localStringBuilder.append("currDate is:");
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localStringBuilder.append((String)localObject8);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localStringBuilder.append(",curr hour is:");
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localStringBuilder.append(this.jdField_a_of_type_AndroidTextFormatTime.hour);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localStringBuilder.append(",chatFreqTipMsgInsertTime is:");
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localStringBuilder.append((String)localObject7);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      QLog.d("FriendFreqGrayTips", 2, localStringBuilder.toString());
      if (localObject7 != null)
      {
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        if (((String)localObject7).trim().length() > 0)
        {
          localObject3 = paramVarArgs;
          localObject2 = localObject1;
          this.jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject7));
          localObject3 = paramVarArgs;
          localObject2 = localObject1;
          k = this.jdField_a_of_type_AndroidTextFormatTime.year;
          localObject3 = paramVarArgs;
          localObject2 = localObject1;
          m = this.jdField_a_of_type_AndroidTextFormatTime.month;
          localObject3 = paramVarArgs;
          localObject2 = localObject1;
          n = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((paramInt == k) && (i == m) && (j == n))
          {
            if (QLog.isColorLevel())
            {
              paramVarArgs = new StringBuilder();
              paramVarArgs.append("step is:");
              paramVarArgs.append("already insert chat frequent tip msg this day when insert chat frequent tip msg");
              QLog.d("FriendFreqGrayTips", 2, paramVarArgs.toString());
            }
            return;
          }
        }
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localObject7 = new StringBuilder();
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      ((StringBuilder)localObject7).append("voice_keyword_tip_msg_insert_time");
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      ((StringBuilder)localObject7).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localObject7 = localSharedPreferences.getString(((StringBuilder)localObject7).toString(), "");
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        localObject8 = new StringBuilder();
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        ((StringBuilder)localObject8).append("multiKeywordTipMsgInsertTime is:");
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        ((StringBuilder)localObject8).append((String)localObject7);
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        QLog.d("FriendFreqGrayTips", 2, ((StringBuilder)localObject8).toString());
      }
      if (localObject7 != null)
      {
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        if (((String)localObject7).length() > 0)
        {
          localObject3 = paramVarArgs;
          localObject2 = localObject1;
          localObject7 = ((String)localObject7).split("\\|");
          localObject3 = paramVarArgs;
          localObject2 = localObject1;
          this.jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong(localObject7[(localObject7.length - 1)]));
          localObject3 = paramVarArgs;
          localObject2 = localObject1;
          k = this.jdField_a_of_type_AndroidTextFormatTime.year;
          localObject3 = paramVarArgs;
          localObject2 = localObject1;
          m = this.jdField_a_of_type_AndroidTextFormatTime.month;
          localObject3 = paramVarArgs;
          localObject2 = localObject1;
          n = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((paramInt == k) && (i == m) && (j == n))
          {
            if (QLog.isColorLevel())
            {
              paramVarArgs = new StringBuilder();
              paramVarArgs.append("step is:");
              paramVarArgs.append("already insert keyword tip msg this day");
              QLog.d("FriendFreqGrayTips", 2, paramVarArgs.toString());
            }
            return;
          }
        }
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      if (!NetworkUtil.isWifiConnected(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("step is:");
          paramVarArgs.append("network is not wifi");
          QLog.d("FriendFreqGrayTips", 2, paramVarArgs.toString());
        }
        return;
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      localObject7 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject7 == null)
      {
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        localObject4 = new StringBuilder();
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        ((StringBuilder)localObject4).append("can not obtain friend by uin ");
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        paramVarArgs = ((StringBuilder)localObject4).toString();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("step is:");
          ((StringBuilder)localObject1).append(paramVarArgs);
          QLog.d("FriendFreqGrayTips", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      if ((((Friends)localObject7).abilityBits & 1L) == 0L)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("step is:");
          paramVarArgs.append("friend's qq version<4.6 or friend online status is not online or network that friend use is not wifi or 3g or 4g");
          QLog.d("FriendFreqGrayTips", 2, paramVarArgs.toString());
        }
        return;
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      k = FriendsUtils.a(((Friends)localObject7).eNetwork, ((Friends)localObject7).iTermType, ((Friends)localObject7).netTypeIconId);
      if (k == 2)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("step is:");
          paramVarArgs.append("");
          QLog.d("FriendFreqGrayTips", 2, paramVarArgs.toString());
        }
        return;
      }
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      this.jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 20, j, i, paramInt);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      l2 = this.jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      this.jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 23, j, i, paramInt);
      localObject3 = paramVarArgs;
      localObject2 = localObject1;
      l3 = this.jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
      if ((l1 >= l2) && (l1 <= l3))
      {
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        l2 = (l1 - 600000L) / 1000L;
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        paramInt = ((List)localObject4).size() - 1;
        i = 0;
        bool3 = false;
        bool2 = false;
        bool1 = false;
        label1941:
        if (paramInt < 0) {
          break label2520;
        }
        localObject3 = paramVarArgs;
        localObject2 = localObject1;
        localObject7 = (ChatMessage)((List)localObject4).get(paramInt);
      }
    }
    label2474:
    label2480:
    label2483:
    label2486:
    label2502:
    label2520:
    label2523:
    for (;;)
    {
      try
      {
        if (((ChatMessage)localObject7).time >= l2)
        {
          j = i;
          bool4 = bool2;
          bool5 = bool1;
          if (MsgProxyUtils.h(((ChatMessage)localObject7).msgtype))
          {
            j = i;
            bool4 = bool2;
            bool5 = bool1;
            if (((ChatMessage)localObject7).extraflag == 0)
            {
              if (((ChatMessage)localObject7).isSend()) {
                break label2483;
              }
              bool2 = true;
              break label2486;
            }
          }
          if (!MsgProxyUtils.j(((ChatMessage)localObject7).msgtype)) {
            break label2502;
          }
          bool3 = true;
          break label2502;
        }
        if ((i >= 10) && (bool2) && (bool1) && (!bool3))
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0])) {
            break label2523;
          }
          ((QQOperateManager)localObject5).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2);
          localObject2 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject2).putString((String)localObject6, String.valueOf(l1));
          ((SharedPreferences.Editor)localObject2).commit();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Msg_call_tips", 0, 0, "", "", "", "");
          paramVarArgs = "insert friend chat frequent tip msg success";
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sendRecvMsgNum is:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(",hasOneRecv is:");
          ((StringBuilder)localObject2).append(bool2);
          ((StringBuilder)localObject2).append(",hasOneSend is:");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append(",hasVideoMsg is:");
          ((StringBuilder)localObject2).append(bool3);
          localObject2 = ((StringBuilder)localObject2).toString();
          paramVarArgs = (Object[])localObject2;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(paramVarArgs);
          QLog.d("FriendFreqGrayTips", 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      finally
      {
        paramVarArgs = finally;
        break label2402;
      }
      localObject3 = "";
      try
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("current time not in ");
        paramVarArgs.append(20);
        paramVarArgs.append("-");
        paramVarArgs.append(23);
        paramVarArgs = paramVarArgs.toString();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("step is:");
          ((StringBuilder)localObject1).append(paramVarArgs);
          QLog.d("FriendFreqGrayTips", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      finally {}
      label2402:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append((String)localObject3);
        QLog.d("FriendFreqGrayTips", 2, ((StringBuilder)localObject2).toString());
      }
      for (;;)
      {
        throw paramVarArgs;
      }
      for (;;)
      {
        if (paramInt < 0) {
          break label2474;
        }
        if (paramInt >= i - 10) {
          break;
        }
        break label2474;
        paramInt -= 1;
      }
      bool1 = false;
      break label292;
      break label1003;
      bool1 = true;
      j = i + 1;
      boolean bool4 = bool2;
      boolean bool5 = bool1;
      continue;
      paramInt -= 1;
      i = j;
      bool2 = bool4;
      bool1 = bool5;
      break label1941;
    }
  }
  
  public int[] a()
  {
    return new int[] { 5 };
  }
  
  public int b()
  {
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FriendFreqGrayTips
 * JD-Core Version:    0.7.0.1
 */