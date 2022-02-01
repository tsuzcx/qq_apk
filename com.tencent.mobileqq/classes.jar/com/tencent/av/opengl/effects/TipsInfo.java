package com.tencent.av.opengl.effects;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.EffectPendantTips;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class TipsInfo
{
  private static TipsInfo a;
  private final Map<String, Drawable> b = new HashMap();
  private String c = null;
  private boolean d = false;
  private boolean e = false;
  private EffectPendantTips f = null;
  private int g = 0;
  
  public static TipsInfo a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TipsInfo();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    if (!this.e) {
      return;
    }
    EffectPendantTips localEffectPendantTips = this.f;
    if (localEffectPendantTips != null) {
      localEffectPendantTips.a(paramInt, new TipsInfo.1(this));
    }
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("TipsInfo", "hideErrorTips");
    }
  }
  
  public void a(long paramLong)
  {
    g();
    f();
    a(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearState_");
    localStringBuilder.append(paramLong);
    a(localStringBuilder.toString(), null);
  }
  
  public void a(EffectPendantTips paramEffectPendantTips)
  {
    this.f = paramEffectPendantTips;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEffectPendantTips, tip[");
      localStringBuilder.append(paramEffectPendantTips);
      localStringBuilder.append("]");
      QLog.i("TipsInfo", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.b.containsKey(paramString)))
    {
      Object localObject = BaseApplicationImpl.getApplication().getResources();
      if ("fivea".equals(paramString)) {
        localObject = ((Resources)localObject).getDrawable(2130843141);
      } else if ("palmup".equals(paramString)) {
        localObject = ((Resources)localObject).getDrawable(2130843142);
      } else if ("qheart".equals(paramString)) {
        localObject = ((Resources)localObject).getDrawable(2130843143);
      } else {
        localObject = null;
      }
      this.b.put(paramString, localObject);
      if (AVCoreLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadGestureTipIcon, drawable[");
        localStringBuilder.append(localObject);
        localStringBuilder.append("], gestureType[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        AVCoreLog.i("TipsInfo", localStringBuilder.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGestureType[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], GestureTips[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("->");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.d("TipsInfo", 1, localStringBuilder.toString());
    }
    this.c = paramString2;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.g -= 1;
    } else {
      this.g += 1;
    }
    if (this.g < 0) {
      this.g = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCanShowTip, canShowTip[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], disableShowTipCount[");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]");
      QLog.i("TipsInfo", 2, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    this.b.clear();
    f();
    g();
    a(0);
  }
  
  public void b(String paramString)
  {
    if (!c()) {
      return;
    }
    f();
    g();
    EffectPendantTips localEffectPendantTips = this.f;
    if (localEffectPendantTips != null) {
      localEffectPendantTips.b(paramString);
    }
    this.e = true;
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("TipsInfo", "showErrorTips");
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (c())
    {
      if (this.e) {
        return;
      }
      if (TextUtils.equals(this.c, paramString1)) {
        return;
      }
      f();
      paramString2 = (Drawable)this.b.get(paramString2);
      Object localObject;
      if (paramString2 != null)
      {
        localObject = this.f;
        if (localObject != null) {
          ((EffectPendantTips)localObject).a(paramString2, paramString1);
        }
      }
      else
      {
        localObject = this.f;
        if (localObject != null) {
          ((EffectPendantTips)localObject).a(paramString1);
        }
      }
      a("showGestureTips", paramString1);
      if (AVCoreLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showGestureTips, wording[");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("], drawable[");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("]");
        AVCoreLog.i("TipsInfo", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public boolean c()
  {
    return this.g <= 0;
  }
  
  public void d()
  {
    this.b.clear();
  }
  
  public void e()
  {
    if (c())
    {
      if (this.e) {
        return;
      }
      if (this.d) {
        return;
      }
      g();
      EffectPendantTips localEffectPendantTips = this.f;
      if (localEffectPendantTips != null) {
        localEffectPendantTips.a(100);
      }
      this.d = true;
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("TipsInfo", "showFaceTips");
      }
    }
  }
  
  public void f()
  {
    if (!this.d) {
      return;
    }
    EffectPendantTips localEffectPendantTips = this.f;
    if (localEffectPendantTips != null) {
      localEffectPendantTips.b(0);
    }
    this.d = false;
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("TipsInfo", "hideFaceTips");
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideGestureTips, mCurGestureTip[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("]");
      QLog.w("TipsInfo", 1, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(this.c)) {
      return;
    }
    a("hideGestureTips", null);
    Object localObject = this.f;
    if (localObject != null) {
      ((EffectPendantTips)localObject).b(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.TipsInfo
 * JD-Core Version:    0.7.0.1
 */