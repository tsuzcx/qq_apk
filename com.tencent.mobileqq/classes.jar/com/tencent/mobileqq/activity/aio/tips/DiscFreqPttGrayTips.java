package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import mqq.app.MobileQQ;

public class DiscFreqPttGrayTips
  implements GrayTipsTask
{
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public DiscFreqPttGrayTips(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-1016);
    long l = MessageCache.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramVarArgs.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131691846), l, -1017, 3000, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1001) {}
    String str;
    boolean bool;
    label452:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV =====>");
        }
        str = "";
        for (;;)
        {
          try
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "curType != disscusion");
              return;
            }
            localObject1 = QQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (((QQOperateManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "hasNetTipShow today");
              return;
            }
            localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
            if (localList == null)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "aioMsgList == null");
              return;
            }
            if (!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "not wifi");
              return;
            }
            if (localList.size() < 5)
            {
              paramVarArgs = "msgList size < 5, size = " + localList.size();
              return;
            }
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
            paramInt = UITools.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramInt, l1))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "current discussion is on voice chating");
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
            Object localObject3;
            int k;
            int m;
            int n;
            long l2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + str);
          }
          if (QLog.isColorLevel()) {
            QLog.d("DiscFreqPttGrayTips", 2, "findExcludeMsg :" + bool);
          }
          if (!bool) {
            continue;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "findExcludeMsg, just return");
          return;
          if (((ChatMessage)localList.get(paramInt)).msgtype != -1043) {
            break label1231;
          }
          bool = true;
        }
        l1 = 1000L * MessageCache.a();
        if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
          this.jdField_a_of_type_AndroidTextFormatTime = new Time();
        }
        this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
        paramInt = this.jdField_a_of_type_AndroidTextFormatTime.year;
        i = this.jdField_a_of_type_AndroidTextFormatTime.month;
        j = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
        paramVarArgs = "voice_disc_ptt_freq_tip_msg_insert_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
        localObject2 = localSharedPreferences.getString(paramVarArgs, null);
        if (QLog.isColorLevel())
        {
          localObject3 = paramInt + "-" + i + "-" + j;
          QLog.d("VoiceTipMsg", 2, "currDate is:" + (String)localObject3 + ",curr hour is:" + this.jdField_a_of_type_AndroidTextFormatTime.hour + ",discPttFreqTipMsgInsertTime is:" + (String)localObject2);
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        this.jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject2));
        k = this.jdField_a_of_type_AndroidTextFormatTime.year;
        m = this.jdField_a_of_type_AndroidTextFormatTime.month;
        n = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
        if ((paramInt != k) || (i != m) || (j != n)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "already insert discuss ppt frequent tip msg this day");
      return;
      localObject2 = localSharedPreferences.getString("start_group_audio_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (l1 - Long.parseLong((String)localObject2) > 600000L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "has startGroupAudio in less 10 mins, just return");
    return;
    l2 = (l1 - 600000L) / 1000L;
    int i = localList.size();
    paramInt = 0;
    localObject2 = new HashSet();
    int j = i - 1;
    for (;;)
    {
      if (j >= 0)
      {
        localObject3 = (ChatMessage)localList.get(j);
        i = paramInt;
        if (((ChatMessage)localObject3).time >= l2)
        {
          i = paramInt;
          if (((ChatMessage)localObject3).msgtype == -2002)
          {
            i = paramInt;
            if (((ChatMessage)localObject3).extraflag == 0)
            {
              i = paramInt + 1;
              ((HashSet)localObject2).add(((ChatMessage)localObject3).senderuin);
            }
          }
        }
      }
      else
      {
        i = ((HashSet)localObject2).size();
        if ((paramInt >= 5) && (i >= 2))
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0])) {
            break label1201;
          }
          ((QQOperateManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2);
          localObject1 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putString(paramVarArgs, String.valueOf(l1));
          ((SharedPreferences.Editor)localObject1).commit();
        }
        for (;;)
        {
          try
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F01", "0X8003F01", 0, 0, "", "", "", "");
            paramVarArgs = "insert discuss ppt frequent tip msg success";
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("DiscFreqPttGrayTips", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + paramVarArgs);
            return;
          }
          finally
          {
            str = "insert discuss ppt frequent tip msg success";
          }
          paramVarArgs = "pttMsgNum : " + paramInt + ", msgUinNum : " + i;
          continue;
          label1201:
          paramVarArgs = "";
        }
        label1231:
        label1236:
        for (;;)
        {
          bool = false;
          break;
          for (;;)
          {
            if (paramInt < 0) {
              break label1236;
            }
            if (paramInt >= i - 10) {
              break label452;
            }
            bool = false;
            break;
            paramInt -= 1;
          }
        }
      }
      j -= 1;
      paramInt = i;
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 1001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.DiscFreqPttGrayTips
 * JD-Core Version:    0.7.0.1
 */