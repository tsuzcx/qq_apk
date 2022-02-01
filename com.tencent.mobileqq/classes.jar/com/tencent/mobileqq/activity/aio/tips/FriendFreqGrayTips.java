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
    if (paramInt != 1001) {}
    int i;
    boolean bool1;
    label255:
    int j;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    for (;;)
    {
      return;
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendFreqGrayTips", 2, "onAIOEvent(): TYPE_ON_MSG_SENT_RECV ===>");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
            return;
          }
          localObject1 = QQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((QQOperateManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2)) {
            return;
          }
          localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
          if (localList == null) {
            return;
          }
          i = localList.size();
          paramInt = i - 1;
        }
        finally
        {
          Object localObject1;
          List localList;
          long l1;
          SharedPreferences localSharedPreferences;
          Object localObject2;
          String str;
          int k;
          int m;
          int n;
          long l2;
          long l3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FriendFreqGrayTips", 2, "step is:" + "");
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendFreqGrayTips", 2, "findExcludeMsg :" + bool1);
        }
        if (!bool1) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FriendFreqGrayTips", 2, "step is:" + "findExcludeMsg, just return");
        return;
        if (((ChatMessage)localList.get(paramInt)).msgtype != -1043) {
          break label1621;
        }
        bool1 = true;
      }
      if (localList.size() < 10)
      {
        paramVarArgs = "aioMsgList msg num = " + localList.size();
        if (QLog.isColorLevel()) {
          QLog.d("FriendFreqGrayTips", 2, "step is:" + paramVarArgs);
        }
      }
      else
      {
        l1 = MessageCache.a() * 1000L;
        if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
          this.jdField_a_of_type_AndroidTextFormatTime = new Time();
        }
        this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
        paramInt = this.jdField_a_of_type_AndroidTextFormatTime.year;
        i = this.jdField_a_of_type_AndroidTextFormatTime.month;
        j = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
        paramVarArgs = "voice_chat_freq_tip_msg_insert_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
        localObject2 = localSharedPreferences.getString(paramVarArgs, "");
        if (QLog.isColorLevel())
        {
          str = paramInt + "-" + i + "-" + j;
          QLog.d("FriendFreqGrayTips", 2, "currDate is:" + str + ",curr hour is:" + this.jdField_a_of_type_AndroidTextFormatTime.hour + ",chatFreqTipMsgInsertTime is:" + (String)localObject2);
        }
        if ((localObject2 != null) && (((String)localObject2).trim().length() > 0))
        {
          this.jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject2));
          k = this.jdField_a_of_type_AndroidTextFormatTime.year;
          m = this.jdField_a_of_type_AndroidTextFormatTime.month;
          n = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((paramInt == k) && (i == m) && (j == n))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("FriendFreqGrayTips", 2, "step is:" + "already insert chat frequent tip msg this day when insert chat frequent tip msg");
            return;
          }
        }
        localObject2 = localSharedPreferences.getString("voice_keyword_tip_msg_insert_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
        if (QLog.isColorLevel()) {
          QLog.d("FriendFreqGrayTips", 2, "multiKeywordTipMsgInsertTime is:" + (String)localObject2);
        }
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          this.jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong(localObject2[(localObject2.length - 1)]));
          k = this.jdField_a_of_type_AndroidTextFormatTime.year;
          m = this.jdField_a_of_type_AndroidTextFormatTime.month;
          n = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((paramInt == k) && (i == m) && (j == n))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("FriendFreqGrayTips", 2, "step is:" + "already insert keyword tip msg this day");
            return;
          }
        }
        if (!NetworkUtil.h(BaseApplication.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendFreqGrayTips", 2, "step is:" + "network is not wifi");
          }
        }
        else
        {
          localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject2 == null)
          {
            paramVarArgs = "can not obtain friend by uin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            if (QLog.isColorLevel()) {
              QLog.d("FriendFreqGrayTips", 2, "step is:" + paramVarArgs);
            }
          }
          else if ((((Friends)localObject2).abilityBits & 1L) == 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendFreqGrayTips", 2, "step is:" + "friend's qq version<4.6 or friend online status is not online or network that friend use is not wifi or 3g or 4g");
            }
          }
          else
          {
            k = FriendsUtils.a(((Friends)localObject2).eNetwork, ((Friends)localObject2).iTermType, ((Friends)localObject2).netTypeIconId);
            if (k == 2)
            {
              if (QLog.isColorLevel()) {
                QLog.d("FriendFreqGrayTips", 2, "step is:" + "");
              }
            }
            else
            {
              this.jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 20, j, i, paramInt);
              l2 = this.jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
              this.jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 23, j, i, paramInt);
              l3 = this.jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
              if ((l1 < l2) || (l1 > l3))
              {
                paramVarArgs = "current time not in " + 20 + "-" + 23;
                if (QLog.isColorLevel()) {
                  QLog.d("FriendFreqGrayTips", 2, "step is:" + paramVarArgs);
                }
              }
              else
              {
                l2 = (l1 - 600000L) / 1000L;
                paramInt = localList.size();
                i = 0;
                bool2 = false;
                bool3 = false;
                bool1 = false;
                paramInt -= 1;
                if (paramInt >= 0)
                {
                  localObject2 = (ChatMessage)localList.get(paramInt);
                  if (((ChatMessage)localObject2).time >= l2)
                  {
                    bool4 = bool3;
                    bool5 = bool2;
                    j = i;
                    if (MsgProxyUtils.h(((ChatMessage)localObject2).msgtype))
                    {
                      bool4 = bool3;
                      bool5 = bool2;
                      j = i;
                      if (((ChatMessage)localObject2).extraflag == 0)
                      {
                        if (((ChatMessage)localObject2).isSend()) {
                          break label1662;
                        }
                        bool2 = true;
                        break label1628;
                      }
                    }
                    label1329:
                    if (!MsgProxyUtils.j(((ChatMessage)localObject2).msgtype)) {
                      break;
                    }
                    bool1 = true;
                    break;
                  }
                }
                if ((i >= 10) && (bool2) && (bool3) && (!bool1))
                {
                  if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0])) {
                    break label1588;
                  }
                  ((QQOperateManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2);
                  localObject1 = localSharedPreferences.edit();
                  ((SharedPreferences.Editor)localObject1).putString(paramVarArgs, String.valueOf(l1));
                  ((SharedPreferences.Editor)localObject1).commit();
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Msg_call_tips", 0, 0, "", "", "", "");
                  paramVarArgs = "insert friend chat frequent tip msg success";
                }
                while (QLog.isColorLevel())
                {
                  QLog.d("FriendFreqGrayTips", 2, "step is:" + paramVarArgs);
                  return;
                  paramVarArgs = "sendRecvMsgNum is:" + i + ",hasOneRecv is:" + bool2 + ",hasOneSend is:" + bool3 + ",hasVideoMsg is:" + bool1;
                  continue;
                  label1588:
                  paramVarArgs = "";
                }
              }
            }
          }
        }
      }
    }
    break label1644;
    label1621:
    label1626:
    for (;;)
    {
      bool1 = false;
      break;
      for (;;)
      {
        if (paramInt < 0) {
          break label1626;
        }
        if (paramInt >= i - 10) {
          break label255;
        }
        bool1 = false;
        break;
        paramInt -= 1;
      }
    }
    for (;;)
    {
      label1628:
      j = i + 1;
      bool4 = bool3;
      bool5 = bool2;
      break label1329;
      label1644:
      paramInt -= 1;
      bool3 = bool4;
      bool2 = bool5;
      i = j;
      break;
      label1662:
      bool3 = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FriendFreqGrayTips
 * JD-Core Version:    0.7.0.1
 */