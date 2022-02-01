package com.tencent.mobileqq.auto.engine.main.fragment;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.qphone.base.util.QLog;

class ASPluginFragment$1$1
  implements Runnable
{
  ASPluginFragment$1$1(ASPluginFragment.1 param1, Intent paramIntent) {}
  
  public void run()
  {
    ASPluginFragment.a(this.b.a, ASPluginFragment.b(this.b.a).startActivity(ASPluginFragment.a(this.b.a).getBusinessKey(), this.a).getDecorView());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPluginIntent : mFSTabView = ");
    localStringBuilder.append(ASPluginFragment.c(this.b.a));
    QLog.d("ASPluginFragment", 1, localStringBuilder.toString());
    if (ASPluginFragment.d(this.b.a) != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("add mFSTabView : ");
      localStringBuilder.append(ASPluginFragment.c(this.b.a));
      QLog.d("ASPluginFragment", 1, localStringBuilder.toString());
      ASPluginFragment.d(this.b.a).addView(ASPluginFragment.c(this.b.a), new FrameLayout.LayoutParams(-1, -1));
      ASPluginFragment.a(this.b.a, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.main.fragment.ASPluginFragment.1.1
 * JD-Core Version:    0.7.0.1
 */