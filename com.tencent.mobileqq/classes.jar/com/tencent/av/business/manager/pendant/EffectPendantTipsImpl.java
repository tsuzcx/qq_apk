package com.tencent.av.business.manager.pendant;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;

public class EffectPendantTipsImpl
  implements EffectPendantTips
{
  private VideoAppInterface a;
  private final Context b;
  private final Handler c;
  private final SparseIntArray d;
  
  public EffectPendantTipsImpl(Context paramContext)
  {
    this.b = paramContext;
    this.c = new Handler(Looper.getMainLooper());
    this.d = new SparseIntArray();
    this.d.put(PTFaceAttr.PTExpression.MOUTH_OPEN.value, 2131893225);
    this.d.put(PTFaceAttr.PTExpression.EYEBROWS_RAISE.value, 2131893223);
    this.d.put(PTFaceAttr.PTExpression.BLINK.value, 2131893222);
    this.d.put(PTFaceAttr.PTExpression.HEAD_SHAKE.value, 2131893226);
    this.d.put(PTFaceAttr.PTExpression.KISS.value, 2131893224);
    this.d.put(100, 2131893205);
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.c.post(new EffectPendantTipsImpl.5(this, paramString));
  }
  
  public String a(Context paramContext, int paramInt)
  {
    paramInt = this.d.get(paramInt);
    if (paramInt > 0) {
      return paramContext.getResources().getString(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.c.post(new EffectPendantTipsImpl.2(this, paramInt));
  }
  
  public void a(int paramInt, EffectPendantTips.ClearErrorTipsCallback paramClearErrorTipsCallback)
  {
    this.c.postDelayed(new EffectPendantTipsImpl.3(this, paramClearErrorTipsCallback), paramInt);
  }
  
  public void a(Drawable paramDrawable, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.c.post(new EffectPendantTipsImpl.1(this, paramString, paramDrawable));
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTipsManager, app[");
      localStringBuilder.append(paramVideoAppInterface);
      localStringBuilder.append("]");
      QLog.i("EffectPendantTipsImpl", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    c(paramString);
  }
  
  public void b(int paramInt)
  {
    this.c.postDelayed(new EffectPendantTipsImpl.4(this), paramInt);
  }
  
  public void b(String paramString)
  {
    c(paramString);
  }
  
  public void c(int paramInt)
  {
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTipsImpl
 * JD-Core Version:    0.7.0.1
 */