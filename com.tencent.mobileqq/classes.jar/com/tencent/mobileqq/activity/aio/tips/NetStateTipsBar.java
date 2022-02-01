package com.tencent.mobileqq.activity.aio.tips;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;

public class NetStateTipsBar
  implements TipsBarTask
{
  private QQAppInterface a;
  private BaseActivity b;
  private TipsManager c;
  private final View.OnClickListener d = new NetStateTipsBar.1(this);
  
  public NetStateTipsBar(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TipsManager paramTipsManager)
  {
    this.a = paramQQAppInterface;
    this.b = paramBaseActivity;
    this.c = paramTipsManager;
  }
  
  public int a()
  {
    return 99;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = new TipsBar(this.b);
    paramVarArgs.setBarType(4);
    paramVarArgs.setTipsText(this.b.getString(2131892107));
    paramVarArgs.setTipsIcon(this.b.getResources().getDrawable(2130839452));
    paramVarArgs.setOnClickListener(this.d);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if ((!NetworkUtil.isNetSupport(this.b)) && (this.c.b() != b()))
    {
      this.c.a(this, new Object[0]);
      ReportController.b(this.a, "dc00898", "", "", "0X800BC3C", "0X800BC3C", 0, 0, "", "", "", "");
      return;
    }
    if ((NetworkUtil.isNetSupport(this.b)) && (this.c.b() == b())) {
      this.c.c();
    }
  }
  
  public int b()
  {
    return 32;
  }
  
  public int[] c()
  {
    return new int[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.NetStateTipsBar
 * JD-Core Version:    0.7.0.1
 */