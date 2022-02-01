package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.license.e;
import com.tencent.liteav.basic.log.TXCLog;

public class b
  implements TXBeautyManager
{
  private e a;
  private d b;
  private int c;
  private b.a d;
  private boolean e = true;
  
  public b(e parame)
  {
    this.a = parame;
    this.d = new b.a(this);
    enableSharpnessEnhancement(true);
    setFilterStrength(0.5F);
  }
  
  private void a()
  {
    TXCLog.d("TXBeautyManager", "applyBeautyParams");
    this.b.b(this.c);
    b(this.e);
    if (this.a.a())
    {
      this.b.g(this.d.e);
      this.b.h(this.d.f);
      this.b.i(this.d.g);
      this.b.k(this.d.h);
      this.b.j(this.d.i);
      this.b.l(this.d.j);
      this.b.m(this.d.k);
      this.b.n(this.d.l);
      this.b.o(this.d.m);
      this.b.p(this.d.n);
      this.b.q(this.d.o);
      this.b.r(this.d.p);
      this.b.s(this.d.q);
      this.b.t(this.d.r);
      this.b.u(this.d.s);
      this.b.v(this.d.t);
      this.b.w(this.d.u);
      this.b.x(this.d.v);
      this.b.y(this.d.w);
      this.b.a(this.d.B, true);
    }
    this.b.a(this.d.z);
    this.b.a(this.d.A);
    this.b.a(this.d.x);
    this.b.c(this.d.y);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.c(this.d.a);
      this.b.d(this.d.b);
      this.b.e(this.d.c);
      this.b.f(this.d.d);
      return;
    }
    this.b.c(0);
    this.b.d(0);
    this.b.e(0);
    this.b.f(0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    b(paramBoolean);
  }
  
  public void enableSharpnessEnhancement(boolean paramBoolean)
  {
    int i = 0;
    TXCLog.d("TXBeautyManager", "enableSharpnessEnhancement enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.d;
    if (paramBoolean) {
      i = 4;
    }
    ((b.a)localObject).d = i;
    localObject = this.b;
    if ((localObject != null) && (this.e)) {
      ((d)localObject).f(this.d.d);
    }
  }
  
  public void setBeautyLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setBeautyLevel beautyLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.a = paramInt;
    localObject = this.b;
    if ((localObject != null) && (this.e)) {
      ((d)localObject).c(paramInt);
    }
  }
  
  public void setBeautyStyle(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setBeautyStyle beautyStyle:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.c = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).b(paramInt);
    }
  }
  
  public void setChinLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setChinLevel chinLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.h = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).k(paramInt);
    }
  }
  
  public void setEyeAngleLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setEyeAngleLevel eyeAngleLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.r = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).t(paramInt);
    }
  }
  
  public void setEyeDistanceLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setEyeDistanceLevel eyeDistanceLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.q = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).s(paramInt);
    }
  }
  
  public void setEyeLightenLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setEyeLightenLevel eyeLightenLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.k = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).m(paramInt);
    }
  }
  
  public void setEyeScaleLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setEyeScaleLevel eyeScaleLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.e = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).g(paramInt);
    }
  }
  
  public void setFaceBeautyLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFaceBeautyLevel faceBeautyLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.w = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).y(paramInt);
    }
  }
  
  public void setFaceShortLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFaceShortLevel faceShortLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.i = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).j(paramInt);
    }
  }
  
  public void setFaceSlimLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFaceSlimLevel faceSlimLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.f = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).h(paramInt);
    }
  }
  
  public void setFaceVLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFaceVLevel faceVLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.g = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).i(paramInt);
    }
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFilter image:");
    ((StringBuilder)localObject).append(paramBitmap);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.z = paramBitmap;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).a(paramBitmap);
    }
  }
  
  public void setFilterStrength(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFilterStrength strength:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.A = paramFloat;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).a(paramFloat);
    }
  }
  
  public void setForeheadLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setForeheadLevel foreheadLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.p = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).r(paramInt);
    }
  }
  
  public void setGreenScreenFile(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setGreenScreenFile path:");
    ((StringBuilder)localObject).append(paramString);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.B = paramString;
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e("TXBeautyManager", "setGreenScreenFile system version below 18");
      return;
    }
    if (!this.a.a())
    {
      TXCLog.e("TXBeautyManager", "setGreenScreenFile is only supported in EnterprisePro license");
      return;
    }
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).a(paramString, true);
    }
  }
  
  public void setLipsThicknessLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setLipsThicknessLevel lipsThicknessLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.v = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).x(paramInt);
    }
  }
  
  public void setMotionMute(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMotionMute motionMute:");
    ((StringBuilder)localObject).append(paramBoolean);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.y = paramBoolean;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).c(paramBoolean);
    }
  }
  
  public void setMotionTmpl(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMotionTmpl tmplPath:");
    ((StringBuilder)localObject).append(paramString);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.x = paramString;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).a(paramString);
    }
  }
  
  public void setMouthShapeLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMouthShapeLevel mouthShapeLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.s = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).u(paramInt);
    }
  }
  
  public void setNosePositionLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setNosePositionLevel nosePositionLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.u = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).w(paramInt);
    }
  }
  
  public void setNoseSlimLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setNoseSlimLevel noseSlimLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.j = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).l(paramInt);
    }
  }
  
  public void setNoseWingLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setNoseWingLevel noseWingLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.t = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).v(paramInt);
    }
  }
  
  public void setPounchRemoveLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setPounchRemoveLevel pounchRemoveLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.n = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).p(paramInt);
    }
  }
  
  public void setPreprocessor(d paramd)
  {
    this.b = paramd;
    if (this.b != null) {
      a();
    }
  }
  
  public void setRuddyLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setRuddyLevel ruddyLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.c = paramInt;
    localObject = this.b;
    if ((localObject != null) && (this.e)) {
      ((d)localObject).e(paramInt);
    }
  }
  
  public void setSmileLinesRemoveLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSmileLinesRemoveLevel smileLinesRemoveLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.o = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).q(paramInt);
    }
  }
  
  public void setToothWhitenLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setToothWhitenLevel toothWhitenLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.l = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).n(paramInt);
    }
  }
  
  public void setWhitenessLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setWhitenessLevel whitenessLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.b = paramInt;
    localObject = this.b;
    if ((localObject != null) && (this.e)) {
      ((d)localObject).d(paramInt);
    }
  }
  
  public void setWrinkleRemoveLevel(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setWrinkleRemoveLevel wrinkleRemoveLevel:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.m = paramInt;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).o(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.b
 * JD-Core Version:    0.7.0.1
 */