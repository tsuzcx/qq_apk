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
  private final long a = 604800000L;
  private final int b = 30;
  private final int c = 20;
  private final int d = 2;
  private QQAppInterface e;
  private TipsManager f;
  private BaseSessionInfo g;
  private Time h;
  private boolean i = false;
  private SharedPreferences j;
  
  public VipSpecialCareGrayTips(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo)
  {
    this.e = paramQQAppInterface;
    this.f = paramTipsManager;
    this.g = paramBaseSessionInfo;
    this.j = BaseApplication.getContext().getSharedPreferences("free_call", 0);
  }
  
  private boolean a()
  {
    SharedPreferences localSharedPreferences = this.e.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e.getCurrentAccountUin());
    localStringBuilder.append(this.g.b);
    if (!QvipSpecialCareUtil.a(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("specialcare_already_set");
      localStringBuilder.append(this.g.b);
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
    localStringBuilder.append(this.e.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    return this.j.getInt(paramString, 0) >= 2;
  }
  
  private boolean d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_specialcare_gray_tips_");
    ((StringBuilder)localObject).append(this.e.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.g.b);
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.j.getString((String)localObject, "");
    long l1 = MessageCache.c() * 1000L;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (this.h == null) {
        this.h = new Time();
      }
      this.h.set(l1);
      int k = this.h.year;
      int m = this.h.month;
      int n = this.h.monthDay;
      int i1 = this.h.hour;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("curDate :");
        localStringBuilder.append(k);
        localStringBuilder.append(" - ");
        localStringBuilder.append(m);
        localStringBuilder.append(" - ");
        localStringBuilder.append(n);
        localStringBuilder.append(" - ");
        localStringBuilder.append(i1);
        QLog.d("VipSpecialCareGrayTips", 2, localStringBuilder.toString());
      }
      long l2 = Long.parseLong((String)localObject);
      this.h.set(l2);
      k = this.h.year;
      m = this.h.month;
      n = this.h.monthDay;
      i1 = this.h.hour;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("lastShowDate :");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" - ");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(" - ");
        ((StringBuilder)localObject).append(n);
        ((StringBuilder)localObject).append(" - ");
        ((StringBuilder)localObject).append(i1);
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
  
  private boolean e()
  {
    if ((d()) && (!a()) && (!a(this.g.b)))
    {
      long l = System.currentTimeMillis() / 1000L;
      Object localObject1 = this.e.getMessageFacade().h(this.g.b, this.g.a);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VipSpecialCareGrayTips", 2, "no message. shouldShowTips=false ");
        }
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      int n = 0;
      int i4 = 0;
      int i7;
      for (int k = 0; ((Iterator)localObject1).hasNext(); k = i7)
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        int i5 = n;
        int i6 = i4;
        i7 = k;
        if (((MessageRecord)localObject2).time >= l - 86400L)
        {
          i5 = n;
          i6 = i4;
          i7 = k;
          if (((MessageRecord)localObject2).time <= l)
          {
            int m = n;
            if (((MessageRecord)localObject2).isSend())
            {
              m = n;
              if (((MessageRecord)localObject2).msgtype == -1000)
              {
                m = n;
                if (!this.e.getMsgCache().f((MessageRecord)localObject2))
                {
                  m = n;
                  if (((MessageRecord)localObject2).extraflag != 32768) {
                    m = n + 1;
                  }
                }
              }
            }
            if (((MessageRecord)localObject2).msgtype == -2002)
            {
              if (((MessageRecord)localObject2).isSend())
              {
                i5 = m;
                i6 = i4;
                i7 = k;
                if (!this.e.getMsgCache().f((MessageRecord)localObject2))
                {
                  i5 = m;
                  i6 = i4;
                  i7 = k;
                  if (((MessageRecord)localObject2).extraflag == 32768) {}
                }
              }
              else
              {
                i6 = i4 + 1;
                i5 = m;
                i7 = k;
              }
            }
            else
            {
              i5 = m;
              i6 = i4;
              i7 = k;
              if (((MessageRecord)localObject2).msgtype == -2009)
              {
                i5 = m;
                i6 = i4;
                i7 = k;
                if ((localObject2 instanceof MessageForVideo))
                {
                  localObject2 = (MessageForVideo)localObject2;
                  ((MessageForVideo)localObject2).parse();
                  i5 = m;
                  i6 = i4;
                  i7 = k;
                  if (((MessageForVideo)localObject2).text != null)
                  {
                    i5 = m;
                    i6 = i4;
                    i7 = k;
                    if (((MessageForVideo)localObject2).text.contains(BaseApplicationImpl.getApplication().getResources().getString(2131917877)))
                    {
                      localObject2 = UITools.b(((MessageForVideo)localObject2).text);
                      int i1;
                      int i2;
                      if ((localObject2 != null) && (localObject2.length == 3))
                      {
                        i1 = Integer.valueOf(localObject2[0]).intValue();
                        i2 = Integer.valueOf(localObject2[1]).intValue();
                        n = Integer.valueOf(localObject2[2]).intValue();
                      }
                      else if ((localObject2 != null) && (localObject2.length == 2))
                      {
                        i2 = Integer.valueOf(localObject2[0]).intValue();
                        n = Integer.valueOf(localObject2[1]).intValue();
                        i1 = 0;
                      }
                      else
                      {
                        n = 0;
                        i1 = 0;
                        i2 = 0;
                      }
                      int i3;
                      if (i1 <= 0)
                      {
                        i3 = k;
                        if (i2 < 10) {}
                      }
                      else
                      {
                        i3 = k + 1;
                      }
                      i5 = m;
                      i6 = i4;
                      i7 = i3;
                      if (QLog.isColorLevel())
                      {
                        localObject2 = new StringBuilder();
                        ((StringBuilder)localObject2).append("video msg,hour=");
                        ((StringBuilder)localObject2).append(i1);
                        ((StringBuilder)localObject2).append(",minute=");
                        ((StringBuilder)localObject2).append(i2);
                        ((StringBuilder)localObject2).append(",second=");
                        ((StringBuilder)localObject2).append(n);
                        QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject2).toString());
                        i7 = i3;
                        i6 = i4;
                        i5 = m;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        if (i5 > 30)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("sendMsgCount>30. shouldShowTips=true , count=");
            ((StringBuilder)localObject1).append(i5);
            QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
        if (i6 > 20)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("pttMsgCount>20. shouldShowTips=true , count=");
            ((StringBuilder)localObject1).append(i6);
            QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
        if (i7 > 2)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("longVideoMsgCount>2. shouldShowTips=true , count=");
            ((StringBuilder)localObject1).append(i7);
            QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
        n = i5;
        i4 = i6;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("shouldShowTips=false , sendMsgCount=");
        ((StringBuilder)localObject1).append(n);
        ((StringBuilder)localObject1).append(", pttMsgCount=");
        ((StringBuilder)localObject1).append(i4);
        ((StringBuilder)localObject1).append(", longVideoMsgCount=");
        ((StringBuilder)localObject1).append(k);
        QLog.d("VipSpecialCareGrayTips", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    return false;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((UinTypeUtil.b(this.g.a)) && (this.g.a == 0))
    {
      if (paramInt != 1001) {
        return;
      }
      ThreadManager.getSubThreadHandler().post(this);
    }
  }
  
  public MessageRecord a_(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-5005);
    long l = MessageCache.c();
    String str = this.e.getCurrentAccountUin();
    paramVarArgs.init(str, this.g.b, str, "", l, -5005, this.g.a, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public int b()
  {
    return 2001;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareGrayTips", 2, ".....run......");
    }
    if (!this.i) {
      this.i = true;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = this.e.getMessageFacade().b(this.g.b, this.g.a, true);
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
    if ((e()) && (this.f.a(this, new Object[0])))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("key_specialcare_gray_tips_");
      ((StringBuilder)localObject1).append(this.e.getCurrentAccountUin());
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(this.g.b);
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = this.j.edit();
      ((SharedPreferences.Editor)localObject1).putString((String)localObject2, String.valueOf(MessageCache.c() * 1000L));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("key_specialcare_tips_count_");
      ((StringBuilder)localObject2).append(this.e.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(this.g.b);
      localObject2 = ((StringBuilder)localObject2).toString();
      ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, this.j.getInt((String)localObject2, 0) + 1);
      ((SharedPreferences.Editor)localObject1).commit();
      VipUtils.a(this.e, "Vip_SpecialRemind", "0X8005056", "0X8005056", 0, 1, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips
 * JD-Core Version:    0.7.0.1
 */