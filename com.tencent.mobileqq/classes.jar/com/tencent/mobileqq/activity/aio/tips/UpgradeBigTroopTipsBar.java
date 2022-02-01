package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class UpgradeBigTroopTipsBar
  implements View.OnClickListener, TipsBarTask
{
  public static String a = "https://imgcache.qq.com/club/client/group/release/index.html?_bid=199&groupId=";
  private QQAppInterface b;
  private Context c;
  private TipsManager d;
  private String e;
  
  public UpgradeBigTroopTipsBar(QQAppInterface paramQQAppInterface, Context paramContext, TipsManager paramTipsManager)
  {
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.d = paramTipsManager;
  }
  
  public int a()
  {
    return 25;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.c).inflate(2131624151, null);
    paramVarArgs.setOnClickListener(this);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public int b()
  {
    return 21;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131428133)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeBigTroopTipsBar", 2, "click tips, jump");
      }
      Intent localIntent = new Intent(this.c, QQBrowserActivity.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(this.e);
      localStringBuilder.append("&from=aio");
      localIntent.putExtra("url", localStringBuilder.toString());
      localIntent.putExtra("hide_operation_bar", true);
      this.c.startActivity(localIntent);
      ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.e, 3);
      this.d.c();
      ReportController.b(this.b, "dc00899", "Grp_up", "", "Grp_AIO", "clk", 0, 0, this.e, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.UpgradeBigTroopTipsBar
 * JD-Core Version:    0.7.0.1
 */