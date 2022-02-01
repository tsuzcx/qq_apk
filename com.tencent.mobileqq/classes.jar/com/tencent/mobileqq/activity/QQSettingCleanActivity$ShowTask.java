package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

class QQSettingCleanActivity$ShowTask
  implements Runnable
{
  public int a;
  
  public QQSettingCleanActivity$ShowTask(QQSettingCleanActivity paramQQSettingCleanActivity, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    int i = this.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              localObject3 = this.this$0.l;
              long l = this.this$0.u;
              localObject2 = "0M";
              if (l <= 0L)
              {
                localObject1 = "0M";
              }
              else
              {
                localObject1 = this.this$0;
                localObject1 = QQSettingCleanActivity.a((QQSettingCleanActivity)localObject1, ((QQSettingCleanActivity)localObject1).u);
              }
              ((TextView)localObject3).setText((CharSequence)localObject1);
              localObject3 = this.this$0.m;
              if (this.this$0.v <= 0L)
              {
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = this.this$0;
                localObject1 = QQSettingCleanActivity.a((QQSettingCleanActivity)localObject1, ((QQSettingCleanActivity)localObject1).v);
              }
              ((TextView)localObject3).setText((CharSequence)localObject1);
              localObject1 = this.this$0.n;
              localObject2 = this.this$0;
              ((TextView)localObject1).setText(QQSettingCleanActivity.a((QQSettingCleanActivity)localObject2, ((QQSettingCleanActivity)localObject2).t - this.this$0.u - this.this$0.w));
              localObject1 = this.this$0.o;
              localObject2 = this.this$0;
              ((TextView)localObject1).setText(QQSettingCleanActivity.a((QQSettingCleanActivity)localObject2, ((QQSettingCleanActivity)localObject2).w));
              this.this$0.p.setVisibility(0);
              this.this$0.d.setEnabled(true);
              this.this$0.e.setEnabled(true);
              this.this$0.e.setBackgroundResource(2130839460);
              this.this$0.e.setTextColor(this.this$0.getResources().getColor(2131168041));
              return;
            }
            this.this$0.r.setVisibility(8);
            this.this$0.e.setEnabled(true);
            this.this$0.e.setText(this.this$0.getString(2131916728));
            return;
          }
          FMToastUtil.a(2131892157);
          return;
        }
        this.this$0.r.setVisibility(0);
        this.this$0.e.setEnabled(false);
        this.this$0.e.setText(this.this$0.getString(2131916729));
        return;
      }
      localObject1 = this.this$0.q;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.this$0.getString(2131916737));
      localObject3 = this.this$0;
      ((StringBuilder)localObject2).append(QQSettingCleanActivity.a((QQSettingCleanActivity)localObject3, ((QQSettingCleanActivity)localObject3).u - this.this$0.x));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      this.this$0.q.setVisibility(0);
      return;
    }
    Object localObject1 = this.this$0.j;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.this$0.getString(2131916733));
    ((StringBuilder)localObject2).append("(");
    Object localObject3 = this.this$0;
    ((StringBuilder)localObject2).append(QQSettingCleanActivity.a((QQSettingCleanActivity)localObject3, ((QQSettingCleanActivity)localObject3).s));
    ((StringBuilder)localObject2).append(")");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.ShowTask
 * JD-Core Version:    0.7.0.1
 */