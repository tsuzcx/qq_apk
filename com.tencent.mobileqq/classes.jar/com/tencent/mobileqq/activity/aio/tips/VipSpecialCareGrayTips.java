package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class VipSpecialCareGrayTips
  implements GrayTipsTask, Runnable
{
  private final int jdField_a_of_type_Int = 30;
  private final long jdField_a_of_type_Long = 604800000L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  private final int b = 20;
  private final int c = 2;
  
  public VipSpecialCareGrayTips(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
  }
  
  private boolean a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    if (!QvipSpecialCareUtil.a(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("specialcare_already_set");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      if (!localSharedPreferences.getBoolean(localStringBuilder.toString(), false)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_specialcare_tips_count_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 0) >= 2;
  }
  
  private boolean b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_specialcare_gray_tips_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString((String)localObject, "");
    long l1 = MessageCache.a() * 1000L;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
        this.jdField_a_of_type_AndroidTextFormatTime = new Time();
      }
      this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
      int i = this.jdField_a_of_type_AndroidTextFormatTime.year;
      int j = this.jdField_a_of_type_AndroidTextFormatTime.month;
      int k = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      int m = this.jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("curDate :");
        localStringBuilder.append(i);
        localStringBuilder.append(" - ");
        localStringBuilder.append(j);
        localStringBuilder.append(" - ");
        localStringBuilder.append(k);
        localStringBuilder.append(" - ");
        localStringBuilder.append(m);
        QLog.d("VipSpecialCareGrayTips", 2, localStringBuilder.toString());
      }
      long l2 = Long.parseLong((String)localObject);
      this.jdField_a_of_type_AndroidTextFormatTime.set(l2);
      i = this.jdField_a_of_type_AndroidTextFormatTime.year;
      j = this.jdField_a_of_type_AndroidTextFormatTime.month;
      k = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      m = this.jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("lastShowDate :");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" - ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" - ");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" - ");
        ((StringBuilder)localObject).append(m);
        QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject).toString());
      }
      if (l1 - l2 <= 604800000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipSpecialCareGrayTips", 2, "has show in a week, just return;");
        }
        return false;
      }
    }
    return true;
  }
  
  private boolean c()
  {
    if ((b()) && (!a()) && (!a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      long l = System.currentTimeMillis() / 1000L;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipSpecialCareGrayTips", 2, "no message. shouldShowTips=false ");
        }
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      int k = 0;
      int i2 = 0;
      int i5;
      for (int i = 0; ((Iterator)localObject1).hasNext(); i = i5)
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        int i3 = k;
        int i4 = i2;
        i5 = i;
        if (((MessageRecord)localObject2).time >= l - 86400L)
        {
          i3 = k;
          i4 = i2;
          i5 = i;
          if (((MessageRecord)localObject2).time <= l)
          {
            int j = k;
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
                i3 = j;
                i4 = i2;
                i5 = i;
                if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b((MessageRecord)localObject2))
                {
                  i3 = j;
                  i4 = i2;
                  i5 = i;
                  if (((MessageRecord)localObject2).extraflag == 32768) {}
                }
              }
              else
              {
                i4 = i2 + 1;
                i3 = j;
                i5 = i;
              }
            }
            else
            {
              i3 = j;
              i4 = i2;
              i5 = i;
              if (((MessageRecord)localObject2).msgtype == -2009)
              {
                i3 = j;
                i4 = i2;
                i5 = i;
                if ((localObject2 instanceof MessageForVideo))
                {
                  localObject2 = (MessageForVideo)localObject2;
                  ((MessageForVideo)localObject2).parse();
                  i3 = j;
                  i4 = i2;
                  i5 = i;
                  if (((MessageForVideo)localObject2).text != null)
                  {
                    i3 = j;
                    i4 = i2;
                    i5 = i;
                    if (((MessageForVideo)localObject2).text.contains(BaseApplicationImpl.getApplication().getResources().getString(2131720243)))
                    {
                      localObject2 = UITools.a(((MessageForVideo)localObject2).text);
                      int m;
                      int n;
                      if ((localObject2 != null) && (localObject2.length == 3))
                      {
                        m = Integer.valueOf(localObject2[0]).intValue();
                        n = Integer.valueOf(localObject2[1]).intValue();
                        k = Integer.valueOf(localObject2[2]).intValue();
                      }
                      else if ((localObject2 != null) && (localObject2.length == 2))
                      {
                        n = Integer.valueOf(localObject2[0]).intValue();
                        k = Integer.valueOf(localObject2[1]).intValue();
                        m = 0;
                      }
                      else
                      {
                        k = 0;
                        m = 0;
                        n = 0;
                      }
                      int i1;
                      if (m <= 0)
                      {
                        i1 = i;
                        if (n < 10) {}
                      }
                      else
                      {
                        i1 = i + 1;
                      }
                      i3 = j;
                      i4 = i2;
                      i5 = i1;
                      if (QLog.isColorLevel())
                      {
                        localObject2 = new StringBuilder();
                        ((StringBuilder)localObject2).append("video msg,hour=");
                        ((StringBuilder)localObject2).append(m);
                        ((StringBuilder)localObject2).append(",minute=");
                        ((StringBuilder)localObject2).append(n);
                        ((StringBuilder)localObject2).append(",second=");
                        ((StringBuilder)localObject2).append(k);
                        QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject2).toString());
                        i5 = i1;
                        i4 = i2;
                        i3 = j;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        if (i3 > 30)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("sendMsgCount>30. shouldShowTips=true , count=");
            ((StringBuilder)localObject1).append(i3);
            QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
        if (i4 > 20)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("pttMsgCount>20. shouldShowTips=true , count=");
            ((StringBuilder)localObject1).append(i4);
            QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
        if (i5 > 2)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("longVideoMsgCount>2. shouldShowTips=true , count=");
            ((StringBuilder)localObject1).append(i5);
            QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
        k = i3;
        i2 = i4;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("shouldShowTips=false , sendMsgCount=");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(", pttMsgCount=");
        ((StringBuilder)localObject1).append(i2);
        ((StringBuilder)localObject1).append(", longVideoMsgCount=");
        ((StringBuilder)localObject1).append(i);
        QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    return false;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-5005);
    long l = MessageCache.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramVarArgs.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, str, "", l, -5005, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 0))
    {
      if (paramInt != 1001) {
        return;
      }
      ThreadManager.getSubThreadHandler().post(this);
    }
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, true);
    long l2 = System.currentTimeMillis();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAIOList cost:");
      ((StringBuilder)localObject2).append(l2 - l1);
      ((StringBuilder)localObject2).append(" ms");
      QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipSpecialCareGrayTips", 2, "aioMsgList == null");
      }
      return;
    }
    if ((c()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0])))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("key_specialcare_gray_tips_");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putString((String)localObject2, String.valueOf(MessageCache.a() * 1000L));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("key_specialcare_tips_count_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = ((StringBuilder)localObject2).toString();
      ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, this.jdField_a_of_type_AndroidContentSharedPreferences.getInt((String)localObject2, 0) + 1);
      ((SharedPreferences.Editor)localObject1).commit();
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Vip_SpecialRemind", "0X8005056", "0X8005056", 0, 1, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips
 * JD-Core Version:    0.7.0.1
 */