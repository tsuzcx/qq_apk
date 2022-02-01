package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressNotifier;

public class RecentTroopMenuOption
{
  public QQAppInterface a;
  protected QQProgressNotifier b;
  private BaseActivity c;
  
  public RecentTroopMenuOption(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.c = paramBaseActivity;
    this.a = paramQQAppInterface;
  }
  
  public void a(RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    TroopAssistantManager.a().b(this.a, paramBoolean);
    QQAppInterface localQQAppInterface = this.a;
    String str = paramRecentBaseData.getRecentUserUin();
    if (paramBoolean) {
      paramRecentBaseData = "1";
    } else {
      paramRecentBaseData = "0";
    }
    ReportController.b(localQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_top_right", 0, 0, str, "4", paramRecentBaseData, "");
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentTroopMenuOption
 * JD-Core Version:    0.7.0.1
 */