package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.qphone.base.util.QLog;

public class TroopAssistTipsBar
  implements TipsBarTask
{
  public TroopAioTips a;
  private boolean b = false;
  private QQAppInterface c;
  private BaseSessionInfo d;
  private TipsManager e;
  private BaseActivity f;
  private View.OnClickListener g = new TroopAssistTipsBar.2(this);
  private View.OnClickListener h = new TroopAssistTipsBar.3(this);
  
  public TroopAssistTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, BaseActivity paramBaseActivity, BaseSessionInfo paramBaseSessionInfo, TroopAioTips paramTroopAioTips)
  {
    this.c = paramQQAppInterface;
    this.e = paramTipsManager;
    this.f = paramBaseActivity;
    this.d = paramBaseSessionInfo;
    this.a = paramTroopAioTips;
  }
  
  public int a()
  {
    return 20;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = this.f.getString(2131917668);
    if (this.c.getTroopMask(this.d.b) == 3) {
      paramVarArgs = this.f.getString(2131917669);
    }
    View localView = ChatActivityUtils.a(this.f, paramVarArgs, this.h, this.g);
    ReportController.b(this.c, "P_CliOper", "Grp_msg", "", "AIOchat", "exp_setmsg", 0, 0, this.d.b, "", "", "");
    QQAppInterface localQQAppInterface = this.c;
    String str = this.d.b;
    if (this.c.getTroopMask(this.d.b) == 3) {
      paramVarArgs = "1";
    } else {
      paramVarArgs = "0";
    }
    ReportController.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "exp_topbar", 0, 0, str, paramVarArgs, "", "");
    return localView;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (this.d.a != 1) {
      return;
    }
    paramVarArgs = this.a;
    if ((paramVarArgs != null) && (paramVarArgs.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistTipsBar", 2, "navigateBar is show, return ");
      }
      return;
    }
    ThreadManager.post(new TroopAssistTipsBar.1(this), 8, null, true);
  }
  
  public int b()
  {
    return 3;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public boolean d()
  {
    return 3 == this.e.b();
  }
  
  public void e()
  {
    if ((d()) || (this.b)) {
      TroopAssistantManager.a().f(this.c, this.d.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar
 * JD-Core Version:    0.7.0.1
 */