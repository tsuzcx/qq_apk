package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;

public abstract class VideoInviteUIBase
{
  protected final VideoInviteActivity a;
  protected int b = 0;
  protected int c = 0;
  protected int d = 0;
  protected long e;
  protected long f = 0L;
  protected long g = 0L;
  
  public VideoInviteUIBase(VideoInviteActivity paramVideoInviteActivity)
  {
    this.a = paramVideoInviteActivity;
    this.e = AudioHelper.c();
    this.c = UITools.a(this.a);
    this.c = UITools.b(this.a);
  }
  
  public void BtnOnClick(View paramView) {}
  
  public int a()
  {
    return this.b;
  }
  
  public String a(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent) {}
  
  public void a(VideoInviteUIBase paramVideoInviteUIBase)
  {
    if (paramVideoInviteUIBase != null)
    {
      this.f = paramVideoInviteUIBase.f;
      this.g = paramVideoInviteUIBase.g;
    }
  }
  
  protected void a(String paramString)
  {
    ReportController.b(null, "CliOper", "", "", paramString, paramString, 0, 0, Integer.toString(this.a.i), Integer.toString(this.a.K), Integer.toString(this.a.M), "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f = SystemClock.elapsedRealtime();
      return;
    }
    this.g = SystemClock.elapsedRealtime();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public Resources b()
  {
    return this.a.getResources();
  }
  
  public <T extends View> T b(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteUIBase
 * JD-Core Version:    0.7.0.1
 */