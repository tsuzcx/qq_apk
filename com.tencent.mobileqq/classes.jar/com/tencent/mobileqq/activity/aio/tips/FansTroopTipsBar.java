package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FansTroopTipsBar
  implements View.OnClickListener, TipsBarTask
{
  View a;
  private Activity b;
  private QQAppInterface c;
  private SessionInfo d;
  private TroopChatPie e;
  
  public FansTroopTipsBar(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, TroopChatPie paramTroopChatPie)
  {
    this.e = paramTroopChatPie;
    this.c = paramQQAppInterface;
    this.b = paramActivity;
    this.d = paramSessionInfo;
  }
  
  public int a()
  {
    return 59;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.a == null)
    {
      this.a = LayoutInflater.from(this.b).inflate(2131626688, null);
      this.a.setOnClickListener(this);
    }
    return this.a;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public boolean a(@NonNull TipsManager paramTipsManager)
  {
    int i = paramTipsManager.b();
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBar", 2, new Object[] { "show cur type=", Integer.valueOf(i) });
    }
    return i == b();
  }
  
  public boolean a(TipsManager paramTipsManager, boolean paramBoolean)
  {
    if (paramTipsManager == null) {
      return false;
    }
    boolean bool = a(paramTipsManager);
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBar", 2, new Object[] { "show() isShowing=", Boolean.valueOf(bool), ", show=", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean)
    {
      if (!bool)
      {
        if (paramTipsManager.a(this, new Object[0]))
        {
          ReportController.b(this.c, "dc00898", "", "", "0X800B57A", "0X800B57A", 0, 0, "", "", "", "");
          return true;
        }
        return false;
      }
    }
    else if (bool) {
      paramTipsManager.c();
    }
    return false;
  }
  
  public int b()
  {
    return 31;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBar", 2, "click tips, jump to web");
    }
    Object localObject = this.d;
    if (localObject != null) {
      FansTroopUtils.a(this.b, ((SessionInfo)localObject).b);
    }
    localObject = this.e;
    if (localObject != null) {
      ((TroopChatPie)localObject).ca().c();
    }
    ReportController.b(this.c, "dc00898", "", "", "0X800B57B", "0X800B57B", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FansTroopTipsBar
 * JD-Core Version:    0.7.0.1
 */