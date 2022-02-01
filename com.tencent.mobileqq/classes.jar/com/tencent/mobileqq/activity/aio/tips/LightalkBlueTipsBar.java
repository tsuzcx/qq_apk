package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.os.MqqHandler;

public class LightalkBlueTipsBar
  implements View.OnClickListener, TipsBarTask
{
  public String a;
  public String b;
  private QQAppInterface c;
  private TipsManager d;
  private BaseSessionInfo e;
  private Activity f;
  private View g = null;
  private BitmapDrawable h = null;
  private boolean i = true;
  private long j = 0L;
  
  public LightalkBlueTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, BaseSessionInfo paramBaseSessionInfo, Activity paramActivity)
  {
    this.c = paramQQAppInterface;
    this.d = paramTipsManager;
    this.e = paramBaseSessionInfo;
    this.f = paramActivity;
    ThreadManager.post(new LightalkBlueTipsBar.1(this), 5, null, true);
  }
  
  public static boolean d()
  {
    return LightalkBlueTipsBarData.a() != null;
  }
  
  public int a()
  {
    return 45;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightalkBlueTipsBar", 2, "getBarView()");
    }
    if (this.g == null)
    {
      this.g = LayoutInflater.from(this.f).inflate(2131624112, null);
      paramVarArgs = (ImageView)this.g.findViewById(2131437170);
      BitmapDrawable localBitmapDrawable = this.h;
      Object localObject;
      if (localBitmapDrawable != null)
      {
        paramVarArgs.setImageDrawable(localBitmapDrawable);
      }
      else
      {
        if (new File(LightalkBlueTipsBarData.c).exists()) {
          try
          {
            this.h = new BitmapDrawable(this.f.getResources(), BitmapManager.a(LightalkBlueTipsBarData.c));
            if (QLog.isDevelopLevel()) {
              QLog.i("LightalkBlueTipsBar", 4, "load icon to bitmap ");
            }
          }
          catch (Throwable localThrowable)
          {
            if (QLog.isColorLevel()) {
              QLog.e("LightalkBlueTipsBar", 2, "decodeFile Failed!", localThrowable);
            }
            this.h = ((BitmapDrawable)this.f.getResources().getDrawable(2130846267));
            localThrowable.printStackTrace();
          }
        }
        localObject = this.h;
        if (localObject == null) {
          break label322;
        }
        paramVarArgs.setImageDrawable((Drawable)localObject);
      }
      paramVarArgs = (TextView)this.g.findViewById(2131437173);
      if (this.a != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getBarView() mTextWording =");
          ((StringBuilder)localObject).append(this.a);
          QLog.d("LightalkBlueTipsBar", 2, ((StringBuilder)localObject).toString());
        }
        paramVarArgs.setText(this.a);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131903978));
        paramVarArgs.setContentDescription(((StringBuilder)localObject).toString());
        paramVarArgs.setOnClickListener(this);
        paramVarArgs = (ImageView)this.g.findViewById(2131437172);
        if (AppSetting.e) {
          paramVarArgs.setContentDescription(HardCodeUtil.a(2131903977));
        }
        paramVarArgs.setOnClickListener(this);
      }
      else
      {
        label322:
        return null;
      }
    }
    else
    {
      this.i = false;
    }
    return this.g;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (this.e.a != 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW");
    }
    paramVarArgs = this.c.getPreferences();
    Object localObject = AIOUtils.a();
    ((StringBuilder)localObject).append("lightalk_tip_");
    ((StringBuilder)localObject).append(this.c.getCurrentAccountUin());
    if (!paramVarArgs.getBoolean(((StringBuilder)localObject).toString(), false)) {
      return;
    }
    localObject = paramVarArgs.getString("Lightalk_tips_frdUin", null);
    if (localObject != null)
    {
      if (!((String)localObject).equals(this.e.b)) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LT_tip_show_times");
      ((StringBuilder)localObject).append(this.c.getCurrentAccountUin());
      paramInt = paramVarArgs.getInt(((StringBuilder)localObject).toString(), 0);
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("onAIOEvent() : TYPE_ON_SHOW =====> tipsum = ");
        paramVarArgs.append(paramInt);
        QLog.d("LightalkBlueTipsBar", 2, paramVarArgs.toString());
      }
      if (paramInt >= 3)
      {
        if ((this.d.a() instanceof LightalkBlueTipsBar)) {
          this.d.c();
        }
      }
      else if (this.d.a(this, new Object[0]))
      {
        paramVarArgs = this.c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramInt + 1);
        ReportController.b(paramVarArgs, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
        if (this.i) {
          ThreadManager.getSubThreadHandler().post(new LightalkBlueTipsBar.2(this));
        }
      }
    }
  }
  
  public int b()
  {
    return 12;
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
    case 2131437173: 
      long l = System.currentTimeMillis();
      if (l - this.j < 200L) {
        break label201;
      }
      this.j = l;
      Intent localIntent = new Intent(this.f, QQBrowserActivity.class);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("url", this.b);
      this.f.startActivity(localIntent);
      ReportController.b(this.c, "CliOper", "", "", "0X8005111", "0X8005111", 0, 0, "", "", "", "");
      break;
    case 2131437172: 
      ReportController.b(this.c, "CliOper", "", "", "0X8005110", "0X8005110", 0, 0, "", "", "", "");
    }
    this.d.c();
    ThreadManager.getSubThreadHandler().post(new LightalkBlueTipsBar.3(this));
    label201:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar
 * JD-Core Version:    0.7.0.1
 */