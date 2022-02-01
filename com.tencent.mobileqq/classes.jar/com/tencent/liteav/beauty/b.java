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
  
  private int a(float paramFloat, int paramInt)
  {
    return Math.round(paramFloat * paramInt);
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
      this.b.j(this.d.h);
      this.b.l(this.d.i);
      this.b.k(this.d.j);
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
      this.b.z(this.d.x);
      this.b.a(this.d.C, true);
    }
    this.b.a(this.d.A);
    this.b.a(this.d.B);
    this.b.a(this.d.y);
    this.b.c(this.d.z);
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
  
  public void setBeautyLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setBeautyLevel beautyLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    localObject = this.d;
    ((b.a)localObject).a = ((int)paramFloat);
    d locald = this.b;
    if ((locald != null) && (this.e)) {
      locald.c(((b.a)localObject).a);
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
  
  public void setChinLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setChinLevel chinLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.i = a(paramFloat, 15);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).l(this.d.i);
    }
  }
  
  public void setEyeAngleLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setEyeAngleLevel eyeAngleLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.s = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).u(this.d.s);
    }
  }
  
  public void setEyeDistanceLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setEyeDistanceLevel eyeDistanceLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.r = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).t(this.d.r);
    }
  }
  
  public void setEyeLightenLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setEyeLightenLevel eyeLightenLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.l = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).n(this.d.l);
    }
  }
  
  public void setEyeScaleLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setEyeScaleLevel eyeScaleLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.e = a(paramFloat, 15);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).g(this.d.e);
    }
  }
  
  public void setFaceBeautyLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFaceBeautyLevel faceBeautyLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.x = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).z(this.d.x);
    }
  }
  
  public void setFaceNarrowLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFaceNarrowLevel faceNarrowLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.g = a(paramFloat, 15);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).i(this.d.g);
    }
  }
  
  public void setFaceShortLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFaceShortLevel faceShortLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.j = a(paramFloat, 15);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).k(this.d.j);
    }
  }
  
  public void setFaceSlimLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFaceSlimLevel faceSlimLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.f = a(paramFloat, 15);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).h(this.d.f);
    }
  }
  
  public void setFaceVLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFaceVLevel faceVLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.h = a(paramFloat, 15);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).j(this.d.h);
    }
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFilter image:");
    ((StringBuilder)localObject).append(paramBitmap);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.A = paramBitmap;
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
    this.d.B = paramFloat;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).a(paramFloat);
    }
  }
  
  public void setForeheadLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setForeheadLevel foreheadLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.q = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).s(this.d.q);
    }
  }
  
  public void setGreenScreenFile(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setGreenScreenFile path:");
    ((StringBuilder)localObject).append(paramString);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.C = paramString;
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
  
  public void setLipsThicknessLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setLipsThicknessLevel lipsThicknessLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.w = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).y(this.d.w);
    }
  }
  
  public void setMotionMute(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMotionMute motionMute:");
    ((StringBuilder)localObject).append(paramBoolean);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    this.d.z = paramBoolean;
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
    this.d.y = paramString;
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).a(paramString);
    }
  }
  
  public void setMouthShapeLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMouthShapeLevel mouthShapeLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.t = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).v(this.d.t);
    }
  }
  
  public void setNosePositionLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setNosePositionLevel nosePositionLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.v = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).x(this.d.v);
    }
  }
  
  public void setNoseSlimLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setNoseSlimLevel noseSlimLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.k = a(paramFloat, 15);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).m(this.d.k);
    }
  }
  
  public void setNoseWingLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setNoseWingLevel noseWingLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.u = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).w(this.d.u);
    }
  }
  
  public void setPounchRemoveLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setPounchRemoveLevel pounchRemoveLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.o = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).q(this.d.o);
    }
  }
  
  public void setPreprocessor(d paramd)
  {
    this.b = paramd;
    if (this.b != null) {
      a();
    }
  }
  
  public void setRuddyLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setRuddyLevel ruddyLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    localObject = this.d;
    ((b.a)localObject).c = ((int)paramFloat);
    d locald = this.b;
    if ((locald != null) && (this.e)) {
      locald.e(((b.a)localObject).c);
    }
  }
  
  public void setSmileLinesRemoveLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSmileLinesRemoveLevel smileLinesRemoveLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.p = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).r(this.d.p);
    }
  }
  
  public void setToothWhitenLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setToothWhitenLevel toothWhitenLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.m = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).o(this.d.m);
    }
  }
  
  public void setWhitenessLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setWhitenessLevel whitenessLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    localObject = this.d;
    ((b.a)localObject).b = ((int)paramFloat);
    d locald = this.b;
    if ((locald != null) && (this.e)) {
      locald.d(((b.a)localObject).b);
    }
  }
  
  public void setWrinkleRemoveLevel(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setWrinkleRemoveLevel wrinkleRemoveLevel:");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.d("TXBeautyManager", ((StringBuilder)localObject).toString());
    if (!this.a.a())
    {
      TXCLog.i("TXBeautyManager", "support EnterPrise above!!!");
      return;
    }
    this.d.n = a(paramFloat, 10);
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).p(this.d.n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b
 * JD-Core Version:    0.7.0.1
 */