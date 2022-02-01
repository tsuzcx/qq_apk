package com.tencent.mobileqq.activity.aio.audiopanel.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelCallback;
import com.tencent.mobileqq.activity.aio.audiopanel.CircleProgressView;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class CommonListenPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, VoicePlayer.VoicePlayerListener
{
  public static int a = 1;
  public static int b = a + 1;
  Handler c;
  private AppRuntime d;
  private AppActivity e;
  private String f;
  private VoicePlayer g;
  private TextView h;
  private CircleProgressView i;
  private int j;
  private double k;
  private boolean l = false;
  private int m = a;
  
  public CommonListenPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonListenPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  void a()
  {
    VoicePlayer localVoicePlayer = this.g;
    if (localVoicePlayer != null)
    {
      localVoicePlayer.f();
      this.g = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.i.setProgress(0);
    this.i.setImageResource(2130846188);
    this.i.setContentDescription(HardCodeUtil.a(2131900415));
    a();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (paramInt2 > paramInt1) {
        paramInt1 = 100;
      } else {
        paramInt1 = paramInt2 * 100 / paramInt1;
      }
    }
    else {
      paramInt1 = 0;
    }
    this.i.setProgress(paramInt1);
    this.h.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(paramInt2));
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel.onBackEvent() is called,audioPath is:");
      localStringBuilder.append(this.f);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    a();
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel.onPause() is called,audioPath is:");
      localStringBuilder.append(this.f);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (this.g != null)
    {
      a();
      this.h.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.k));
      this.i.setProgress(0);
      this.i.setImageResource(2130846188);
      this.i.setContentDescription(HardCodeUtil.a(2131900414));
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel.onDestroy() is called,audioPath is:");
      localStringBuilder.append(this.f);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    a();
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    Object localObject;
    if (n == 2131437323)
    {
      if (!this.l)
      {
        this.l = true;
        localObject = this.d;
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.m == b) {
          n = 1;
        } else {
          n = 2;
        }
        localStringBuilder.append(n);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, localStringBuilder.toString(), "", "", "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ListenPanel listened, jump source = ");
          ((StringBuilder)localObject).append(this.m);
          QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
        }
        this.c.sendEmptyMessage(103);
      }
      if (this.g == null)
      {
        this.g = new VoicePlayer(this.f, new Handler(), 1);
        this.g.a(getContext());
        this.g.h();
        this.g.a(this);
        this.g.c();
        this.i.setImageResource(2130846190);
        this.i.setContentDescription(HardCodeUtil.a(2131900411));
      }
      else
      {
        a();
        this.h.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.k));
        this.i.setProgress(0);
        this.i.setImageResource(2130846188);
        this.i.setContentDescription(HardCodeUtil.a(2131900412));
      }
    }
    else if (n == 2131437322)
    {
      a();
      if (this.j == 2)
      {
        setVisibility(8);
        this.c.sendEmptyMessage(101);
      }
    }
    else if (n == 2131437325)
    {
      a();
      if (this.k < 1000.0D)
      {
        localObject = this.e;
        QQToast.makeText((Context)localObject, ((AppActivity)localObject).getString(2131896542), 0).show();
      }
      else if (this.j == 2)
      {
        setVisibility(8);
        this.c.sendEmptyMessage(102);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble)
  {
    this.f = paramString;
    this.k = paramDouble;
    this.h.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(paramDouble));
    this.i.setProgress(0);
    this.i.setImageResource(2130846188);
    this.i.setContentDescription(HardCodeUtil.a(2131900413));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel.setAudioPath() is called,path is:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",recordTime is:");
      localStringBuilder.append(paramDouble);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.m = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.view.CommonListenPanel
 * JD-Core Version:    0.7.0.1
 */