package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper
  implements ILifeCycleHelper
{
  private static Calendar d = ;
  private static int e = -1;
  private volatile AtomicInteger a = new AtomicInteger(0);
  private BaseChatPie b;
  private AIOIconChangeByTimeHelper.TimeChangeReceiver c;
  private final Object f = new Object();
  private RedpointObserver g = new AIOIconChangeByTimeHelper.3(this);
  
  AIOIconChangeByTimeHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool3 = ThemeUtil.isNowThemeIsDefault(null, false, null);
    boolean bool1;
    if (e == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i;
    if ((paramBoolean | bool1))
    {
      d.setTimeInMillis(System.currentTimeMillis());
      i = d.get(11);
      if ((i < 19) && (i >= 7))
      {
        i = 0;
        break label82;
      }
    }
    for (;;)
    {
      i = 1;
      break label82;
      if (e != 1) {
        break;
      }
    }
    label82:
    paramBoolean = bool2;
    if (i != 0)
    {
      paramBoolean = bool2;
      if (bool3) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public boolean a()
  {
    return a(false);
  }
  
  public String getTag()
  {
    return "AIOIconChangeByTimeHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject = null;
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt == 15)
        {
          this.b.d.removeObserver(this.g);
          localObject = new AIOIconChangeByTimeHelper.2(this);
        }
      }
      else
      {
        this.b.d.addObserver(this.g);
        localObject = new AIOIconChangeByTimeHelper.1(this);
      }
    }
    else {
      this.c = new AIOIconChangeByTimeHelper.TimeChangeReceiver(this.b, null);
    }
    if (localObject != null) {
      try
      {
        ((Runnable)localObject).run();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AIOIconChangeByTimeHelper", 1, localException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper
 * JD-Core Version:    0.7.0.1
 */