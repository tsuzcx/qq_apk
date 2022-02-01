package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class HomeworkTroopClassInfoTipsBar
  implements View.OnClickListener, TipsBarTask
{
  View a;
  private Activity b;
  private SessionInfo c;
  
  public HomeworkTroopClassInfoTipsBar(Activity paramActivity, SessionInfo paramSessionInfo)
  {
    this.b = paramActivity;
    this.c = paramSessionInfo;
  }
  
  public int a()
  {
    return 59;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.a == null)
    {
      this.a = LayoutInflater.from(this.b).inflate(2131626716, null);
      paramVarArgs = (TextView)this.a.findViewById(2131435208);
      if (paramVarArgs != null) {
        paramVarArgs.setText(2131890782);
      }
      this.a.setOnClickListener(this);
    }
    return this.a;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(@NonNull TipsManager paramTipsManager, boolean paramBoolean)
  {
    boolean bool = a(paramTipsManager);
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopClassInfoTipsBar", 2, new Object[] { "show() isShowing=", Boolean.valueOf(bool), ", show=", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean)
    {
      if (!bool)
      {
        paramTipsManager.a(this, new Object[0]);
        TroopReportor.a("Grp_edu", "Grp_AIO", "classinfotopGuidebar_Show", 0, 0, new String[] { this.c.b });
      }
    }
    else if (bool) {
      paramTipsManager.c();
    }
  }
  
  public boolean a(@NonNull TipsManager paramTipsManager)
  {
    int i = paramTipsManager.b();
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopClassInfoTipsBar", 2, new Object[] { "show cur type=", Integer.valueOf(i) });
    }
    return i == b();
  }
  
  public int b()
  {
    return 27;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopClassInfoTipsBar", 2, "click tips, jump to web");
    }
    HWTroopUtils.a(this.b, this.c.b, HWTroopUtils.c);
    ReportController.b(null, "dc00898", "", "", "0X800B280", "0X800B280", 0, 0, this.c.b, "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HomeworkTroopClassInfoTipsBar
 * JD-Core Version:    0.7.0.1
 */