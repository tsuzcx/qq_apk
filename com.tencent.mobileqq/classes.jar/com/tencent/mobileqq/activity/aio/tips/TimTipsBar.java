package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TimTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private QQAppInterface a;
  private Context b;
  private TipsManager c;
  private String d;
  
  public TimTipsBar(QQAppInterface paramQQAppInterface, Context paramContext, TipsManager paramTipsManager)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.c = paramTipsManager;
  }
  
  public int a()
  {
    return 5;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = ((AppGuideTipsManager)this.a.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).e();
    this.d = paramVarArgs.tipsUrl;
    paramVarArgs = paramVarArgs.tipsMsg;
    View localView = LayoutInflater.from(this.b).inflate(2131624150, null);
    ((TextView)localView.findViewById(2131428149)).setText(paramVarArgs);
    localView.setOnClickListener(this);
    localView.findViewById(2131428147).setOnClickListener(this);
    return localView;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public int b()
  {
    return 18;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131428146: 
      if (QLog.isColorLevel()) {
        QLog.d("TimTipsBar", 2, "click tips, jump");
      }
      Intent localIntent = new Intent(this.b, QQBrowserActivity.class);
      localIntent.putExtra("url", this.d);
      localIntent.putExtra("hide_operation_bar", true);
      this.b.startActivity(localIntent);
      ReportController.b(null, "dc00898", "", "", "0X8008948", "0X8008948", 0, 0, "", "", "", "");
    case 2131428147: 
      this.c.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TimTipsBar
 * JD-Core Version:    0.7.0.1
 */