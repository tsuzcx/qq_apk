package com.tencent.mobileqq.activity.aio.tips;

import acnh;
import aikq;
import ailr;
import amci;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.Time;
import bcrg;
import bcsa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class VipSpecialCareGrayTips
  implements aikq, Runnable
{
  private final int jdField_a_of_type_Int = 30;
  private final long jdField_a_of_type_Long = 604800000L;
  private ailr jdField_a_of_type_Ailr;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private final int b = 20;
  private final int c = 2;
  
  public VipSpecialCareGrayTips(QQAppInterface paramQQAppInterface, ailr paramailr, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ailr = paramailr;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
  }
  
  private boolean a()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    if ((amci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (localSharedPreferences.getBoolean("specialcare_already_set" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, false))) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    paramString = "key_specialcare_tips_count_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 0) >= 2) {
      bool = true;
    }
    return bool;
  }
  
  private boolean b()
  {
    boolean bool2 = true;
    String str = "key_specialcare_gray_tips_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(str, "");
    long l1 = bcrg.a() * 1000L;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
        this.jdField_a_of_type_AndroidTextFormatTime = new Time();
      }
      this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
      int i = this.jdField_a_of_type_AndroidTextFormatTime.year;
      int j = this.jdField_a_of_type_AndroidTextFormatTime.month;
      int k = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      int m = this.jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel()) {
        QLog.d("VipSpecialCareGrayTips", 2, "curDate :" + i + " - " + j + " - " + k + " - " + m);
      }
      long l2 = Long.parseLong(str);
      this.jdField_a_of_type_AndroidTextFormatTime.set(l2);
      i = this.jdField_a_of_type_AndroidTextFormatTime.year;
      j = this.jdField_a_of_type_AndroidTextFormatTime.month;
      k = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      m = this.jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel()) {
        QLog.d("VipSpecialCareGrayTips", 2, "lastShowDate :" + i + " - " + j + " - " + k + " - " + m);
      }
      bool1 = bool2;
      if (l1 - l2 <= 604800000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipSpecialCareGrayTips", 2, "has show in a week, just return;");
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private boolean c()
  {
    if ((!b()) || (a()) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {
      return false;
    }
    long l = System.currentTimeMillis() / 1000L;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipSpecialCareGrayTips", 2, "no message. shouldShowTips=false ");
      }
      return false;
    }
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    int m = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      int i2 = i;
      int i1 = k;
      int j;
      int n;
      int i4;
      if (((MessageRecord)localObject2).time >= l - 86400L)
      {
        i2 = i;
        i1 = k;
        if (((MessageRecord)localObject2).time <= l)
        {
          j = k;
          if (((MessageRecord)localObject2).isSend())
          {
            j = k;
            if (((MessageRecord)localObject2).msgtype == -1000)
            {
              j = k;
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b((MessageRecord)localObject2))
              {
                j = k;
                if (((MessageRecord)localObject2).extraflag != 32768) {
                  j = k + 1;
                }
              }
            }
          }
          if (((MessageRecord)localObject2).msgtype == -2002)
          {
            if (((MessageRecord)localObject2).isSend())
            {
              i2 = i;
              i1 = j;
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b((MessageRecord)localObject2))
              {
                i2 = i;
                i1 = j;
                if (((MessageRecord)localObject2).extraflag == 32768) {}
              }
            }
            else
            {
              m += 1;
              k = j;
              j = m;
              if (k <= 30) {
                break label639;
              }
              if (QLog.isColorLevel()) {
                QLog.d("VipSpecialCareGrayTips", 2, "sendMsgCount>30. shouldShowTips=true , count=" + k);
              }
              return true;
            }
          }
          else
          {
            i2 = i;
            i1 = j;
            if (((MessageRecord)localObject2).msgtype == -2009)
            {
              i2 = i;
              i1 = j;
              if ((localObject2 instanceof MessageForVideo))
              {
                localObject2 = (MessageForVideo)localObject2;
                ((MessageForVideo)localObject2).parse();
                i2 = i;
                i1 = j;
                if (((MessageForVideo)localObject2).text != null)
                {
                  i2 = i;
                  i1 = j;
                  if (((MessageForVideo)localObject2).text.contains(BaseApplicationImpl.getApplication().getResources().getString(2131719957)))
                  {
                    localObject2 = ((MessageForVideo)localObject2).text;
                    localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(':') - 2, ((String)localObject2).lastIndexOf(':') + 3).split(":");
                    i1 = 0;
                    n = 0;
                    k = 0;
                    if (localObject2.length != 3) {
                      break label598;
                    }
                    i4 = Integer.valueOf(localObject2[0]).intValue();
                    n = Integer.valueOf(localObject2[1]).intValue();
                    k = Integer.valueOf(localObject2[2]).intValue();
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        int i3;
        if (i4 <= 0)
        {
          i3 = i;
          if (n < 10) {}
        }
        else
        {
          i3 = i + 1;
        }
        i2 = i3;
        i1 = j;
        if (QLog.isColorLevel())
        {
          QLog.d("VipSpecialCareGrayTips", 2, "video msg,hour=" + i4 + ",minute=" + n + ",second=" + k);
          i1 = j;
          i2 = i3;
        }
        i = i2;
        j = m;
        k = i1;
        break;
        label598:
        i4 = i1;
        if (localObject2.length == 2)
        {
          n = Integer.valueOf(localObject2[0]).intValue();
          k = Integer.valueOf(localObject2[1]).intValue();
          i4 = i1;
        }
      }
      label639:
      if (j > 20)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipSpecialCareGrayTips", 2, "pttMsgCount>20. shouldShowTips=true , count=" + j);
        }
        return true;
      }
      if (i > 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipSpecialCareGrayTips", 2, "longVideoMsgCount>2. shouldShowTips=true , count=" + i);
        }
        return true;
      }
      m = j;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareGrayTips", 2, "shouldShowTips=false , sendMsgCount=" + k + ", pttMsgCount=" + m + ", longVideoMsgCount=" + i);
    }
    return false;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = bcsa.a(-5005);
    long l = bcrg.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramVarArgs.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, str, "", l, -5005, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((!acnh.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0) || (paramInt != 1001)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(this);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 2001;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareGrayTips", 2, ".....run......");
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = true;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAIOList(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, true);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareGrayTips", 2, "getAIOList cost:" + (l2 - l1) + " ms");
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VipSpecialCareGrayTips", 2, "aioMsgList == null");
      }
    }
    while ((!c()) || (!this.jdField_a_of_type_Ailr.a(this, new Object[0]))) {
      return;
    }
    String str = "key_specialcare_gray_tips_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putString(str, String.valueOf(bcrg.a() * 1000L));
    str = "key_specialcare_tips_count_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    ((SharedPreferences.Editor)localObject).putInt(str, this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(str, 0) + 1);
    ((SharedPreferences.Editor)localObject).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Vip_SpecialRemind", "0X8005056", "0X8005056", 0, 1, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips
 * JD-Core Version:    0.7.0.1
 */