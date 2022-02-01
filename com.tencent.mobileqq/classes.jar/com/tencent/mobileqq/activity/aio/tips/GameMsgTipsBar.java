package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GameMsgTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private QQAppInterface a;
  private Activity b;
  private View c;
  private String d;
  
  public GameMsgTipsBar(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.a = paramQQAppInterface;
    this.b = paramBaseActivity;
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.c == null)
    {
      this.c = LayoutInflater.from(this.b).inflate(2131624887, null);
      this.c.setOnClickListener(this);
      ((ImageView)this.c.findViewById(2131434003)).setOnClickListener(this);
      paramVarArgs = (TextView)this.c.findViewById(2131448486);
      if ((paramVarArgs != null) && (!TextUtils.isEmpty(this.d))) {
        paramVarArgs.setText(this.d);
      }
    }
    return this.c;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateTips], tips:");
      localStringBuilder.append(paramString);
      QLog.d("GameMsgTipsBar", 0, localStringBuilder.toString());
    }
    this.d = paramString;
  }
  
  public int b()
  {
    return 2003;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void d()
  {
    QLog.i("GameMsgTipsBar", 1, "[onDestory]");
    this.c = null;
    this.b = null;
    this.a = null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434003)
    {
      View localView = this.c;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.GameMsgTipsBar
 * JD-Core Version:    0.7.0.1
 */