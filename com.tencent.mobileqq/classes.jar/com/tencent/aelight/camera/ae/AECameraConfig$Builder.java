package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.mobileqq.activity.richmedia.Size;
import dov.com.qq.im.ae.current.SessionWrap;

public class AECameraConfig$Builder
{
  private boolean A = true;
  private boolean B = true;
  private boolean C = true;
  private boolean D = true;
  private AECameraConfig.LogicPartsGenerator E;
  private int F = -1;
  public int a = -1;
  public int b = -1;
  public boolean c = true;
  public int d = -1;
  private int e = 14;
  private Float f = null;
  private Integer g = null;
  private boolean h = true;
  private boolean i = true;
  private int j = -1;
  private boolean k = true;
  private Size l = null;
  private boolean m = true;
  private int n = -1;
  private int o = 2;
  private int p = AEVideoStoryTopBarViewModel.Ratio.R_1_1.code;
  private int q = AECameraEntry.a.a();
  private int r = 0;
  private int s = 200;
  private int t = 120;
  private AECaptureMode u = AECaptureMode.NORMAL;
  private AECaptureMode[] v = { AECaptureMode.NORMAL, AECaptureMode.PLAY, AECaptureMode.GIF };
  private boolean w = false;
  private SessionWrap x = null;
  private String y = null;
  private boolean z = true;
  
  public Builder a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Builder a(AECaptureMode paramAECaptureMode)
  {
    this.u = paramAECaptureMode;
    return this;
  }
  
  public Builder a(SessionWrap paramSessionWrap)
  {
    this.x = paramSessionWrap;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.y = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public Builder a(AECaptureMode[] paramArrayOfAECaptureMode)
  {
    this.v = paramArrayOfAECaptureMode;
    return this;
  }
  
  public AECameraConfig a()
  {
    return new AECameraConfig(this, null);
  }
  
  public Builder b(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.D = paramBoolean;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.C = paramBoolean;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder d(boolean paramBoolean)
  {
    this.B = paramBoolean;
    return this;
  }
  
  public Builder e(int paramInt)
  {
    this.r = paramInt;
    return this;
  }
  
  public Builder e(boolean paramBoolean)
  {
    this.A = paramBoolean;
    return this;
  }
  
  public Builder f(int paramInt)
  {
    this.q = paramInt;
    return this;
  }
  
  public Builder f(boolean paramBoolean)
  {
    this.z = paramBoolean;
    return this;
  }
  
  public Builder g(int paramInt)
  {
    this.n = paramInt;
    return this;
  }
  
  public Builder g(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public Builder h(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public Builder h(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public Builder i(int paramInt)
  {
    this.o = paramInt;
    return this;
  }
  
  public Builder i(boolean paramBoolean)
  {
    this.w = paramBoolean;
    return this;
  }
  
  public Builder j(int paramInt)
  {
    this.p = paramInt;
    return this;
  }
  
  public Builder k(int paramInt)
  {
    this.s = paramInt;
    return this;
  }
  
  public Builder l(int paramInt)
  {
    this.t = paramInt;
    return this;
  }
  
  public Builder m(int paramInt)
  {
    this.F = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECameraConfig.Builder
 * JD-Core Version:    0.7.0.1
 */