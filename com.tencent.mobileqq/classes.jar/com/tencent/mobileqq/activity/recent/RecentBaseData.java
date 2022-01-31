package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.utils.UITools;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class RecentBaseData
{
  public int a;
  public volatile long a;
  public MsgSummary a;
  public CharSequence a;
  public boolean a;
  public int b;
  public CharSequence b;
  public String b;
  public boolean b;
  public int c;
  public CharSequence c;
  public String c;
  public int d;
  public CharSequence d;
  public String d;
  public int e;
  public String e;
  public int f = 0;
  public String f;
  public int g;
  public int h;
  public int i;
  
  public RecentBaseData()
  {
    this.jdField_b_of_type_Int = 1;
    this.f |= 0x1;
  }
  
  public abstract int a();
  
  public abstract long a();
  
  public final MsgSummary a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary = new MsgSummary();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary.a();
    }
  }
  
  public abstract String a();
  
  public void a()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(1024);
      String str2 = "null";
      String str1 = "null";
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        str1 = "lenth=" + this.jdField_b_of_type_JavaLangString.length();
      }
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) {
        str2 = "lenth=" + this.jdField_c_of_type_JavaLangCharSequence.length();
      }
      localStringBuilder.append("[").append("type:").append(a()).append(", uin:").append(a()).append(", unreadNum:").append(this.jdField_c_of_type_Int).append(", titleName:").append(str1).append(", mMenuFlag:").append(this.f).append(", status:").append(this.jdField_a_of_type_Int).append(", authenIcon:").append(this.jdField_d_of_type_Int).append(", showTime:").append(this.jdField_c_of_type_JavaLangString).append(", lastmsg:").append(str2).append(", extrainfo:").append(this.jdField_b_of_type_JavaLangCharSequence).append(", lastmsgtime:").append(a()).append(", lastdrafttime:").append(b()).append("]");
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    int m = a();
    long l;
    int n;
    Object localObject;
    if ((m == 3000) || (m == 1)) {
      try
      {
        l = Long.parseLong(a());
        n = UITools.a(m);
        if (paramQQAppInterface.a().a(n, l) > 0L) {
          if (paramQQAppInterface.a().a(n, l))
          {
            this.jdField_a_of_type_Int = 2;
            if ((m == 0) && (paramQQAppInterface.a().d(a()))) {
              this.jdField_a_of_type_Int = 5;
            }
            if (this.jdField_a_of_type_Int == 0)
            {
              paramQQAppInterface = paramQQAppInterface.a();
              if ((paramQQAppInterface == null) || (!paramQQAppInterface.e(a(), m))) {
                break label331;
              }
              this.jdField_a_of_type_Int = 4;
            }
            return;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          l = 0L;
          continue;
          this.jdField_a_of_type_Int = 3;
        }
        localObject = paramQQAppInterface.a().a(l, 2);
        if (localObject == null) {}
      }
    }
    for (int j = ((AVNotifyCenter.VideoRoomInfo)localObject).jdField_a_of_type_Int + 0;; j = 0)
    {
      localObject = paramQQAppInterface.a().a(l, 10);
      int k = j;
      if (localObject != null) {
        k = j + ((AVNotifyCenter.VideoRoomInfo)localObject).jdField_a_of_type_Int;
      }
      if (k <= 0) {
        break;
      }
      if (paramQQAppInterface.a().a(n, l))
      {
        this.jdField_a_of_type_Int = 2;
        break;
      }
      this.jdField_a_of_type_Int = 3;
      break;
      if ((!paramQQAppInterface.c()) || ((paramQQAppInterface.a().e() != 1) && (paramQQAppInterface.a().e() != 2))) {
        break;
      }
      j = paramQQAppInterface.a().f();
      localObject = paramQQAppInterface.a().c();
      String str = paramQQAppInterface.a().d();
      if ((m != j) || ((!a().equals(localObject)) && (!a().equals(str)))) {
        break;
      }
      this.jdField_a_of_type_Int = 1;
      break;
      label331:
      this.jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public abstract void a(QQAppInterface paramQQAppInterface, Context paramContext);
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = a();
    }
    if (paramMsgSummary != null)
    {
      this.jdField_c_of_type_JavaLangCharSequence = paramMsgSummary.a(paramContext);
      if (((this.jdField_c_of_type_JavaLangCharSequence instanceof SpannableStringBuilder)) && (DeviceInfoUtil.b())) {
        this.jdField_c_of_type_JavaLangCharSequence = ((SpannableStringBuilder)this.jdField_c_of_type_JavaLangCharSequence).append(" ");
      }
      paramQQAppInterface = this.jdField_c_of_type_JavaLangCharSequence;
      if ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 168)) {}
    }
    try
    {
      this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.subSequence(0, 168);
      if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
        this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          paramQQAppInterface.printStackTrace();
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.a = false;
          paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = null;
        } while (this.jdField_a_of_type_Long > b());
        paramQQAppInterface = paramQQAppInterface.a();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a(a(), a());
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramMsgSummary.a = true;
    paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (paramMessage != null) {}
    for (String str = paramMessage.nickName;; str = null)
    {
      MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, paramInt, paramMsgSummary, str, false, false);
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public final int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public abstract long b();
  
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final void b()
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  public long c()
  {
    return 5L;
  }
  
  public final void c()
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  public void d()
  {
    StringBuilder localStringBuilder;
    if (AppSetting.b)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString).append(",");
      if (this.jdField_c_of_type_Int != 0) {
        break label67;
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_JavaLangCharSequence != null) {
        localStringBuilder.append(this.jdField_d_of_type_JavaLangCharSequence).append(",");
      }
      this.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
      return;
      label67:
      if (this.jdField_c_of_type_Int == 1) {
        localStringBuilder.append("有一条未读");
      } else if (this.jdField_c_of_type_Int == 2) {
        localStringBuilder.append("有两条未读");
      } else if (this.jdField_c_of_type_Int > 0) {
        localStringBuilder.append("有").append(this.jdField_c_of_type_Int).append("条未读,");
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (boolean bool = true; (!bool) && ((paramObject instanceof RecentBaseData)); bool = false)
    {
      paramObject = (RecentBaseData)paramObject;
      if ((paramObject.a() != a()) || (!Utils.a(paramObject.a(), a()))) {
        break;
      }
      return true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentBaseData
 * JD-Core Version:    0.7.0.1
 */