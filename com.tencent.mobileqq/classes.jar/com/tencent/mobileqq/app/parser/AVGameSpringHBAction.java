package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AVGameSpringHBAction
  extends JumpAction
{
  public AVGameSpringHBAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    IAvGameManager localIAvGameManager = (IAvGameManager)this.a.getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager == null)
    {
      QLog.d("AVGameSpringHBAction", 1, "[jumpGameRoom] error: manager is null.");
      return;
    }
    if (!(this.b instanceof Activity))
    {
      QLog.d("AVGameSpringHBAction", 1, "[jumpGameRoom] error: context is not instanceof Activity.");
      return;
    }
    try
    {
      int i = Integer.parseInt(paramString1);
      localIAvGameManager.startSurvivalGame((Activity)this.b, i, paramBoolean, paramInt, paramString2);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("AVGameSpringHBAction", 1, "[jumpGameRoom] error: ", paramString1);
    }
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    long l1 = c();
    long l2 = i(paramString1);
    long l3 = i(paramString2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (l2 != 0L)
    {
      if (l3 == 0L) {
        return false;
      }
      bool1 = bool2;
      if (l1 >= l2)
      {
        bool1 = bool2;
        if (l1 < l3) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private long c()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  private void d()
  {
    QPublicFragmentActivity.start(this.b, AVGameRoomCenterFragment.class);
  }
  
  private long i(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("AVGameSpringHBAction", 1, "[parseTimeToLong] ", paramString);
    }
    return 0L;
  }
  
  public boolean a()
  {
    return a(1);
  }
  
  public boolean a(int paramInt)
  {
    String str1 = (String)this.f.get("pkid");
    String str2 = (String)this.f.get("starttime");
    String str3 = (String)this.f.get("endtime");
    String str4 = (String)this.f.get("iscj");
    String str6 = (String)this.f.get("fromtype");
    String str5 = (String)this.f.get("uin");
    int i;
    try
    {
      if (!TextUtils.isEmpty(str6)) {
        i = Integer.valueOf(str6).intValue();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
    }
    boolean bool;
    if ((str4 != null) && (Integer.parseInt(str4) == 1)) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramInt == 2) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVGameSpringHBAction", 2, new Object[] { "[doAction] pkID: ", str1, ", startTime: ", str2, ", endTime: ", str3, ",sourceValue: ", Integer.valueOf(i) });
    }
    if (b(str2, str3))
    {
      a(str1, bool, i, str5);
      return true;
    }
    if (paramInt == 0)
    {
      d();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameSpringHBAction
 * JD-Core Version:    0.7.0.1
 */