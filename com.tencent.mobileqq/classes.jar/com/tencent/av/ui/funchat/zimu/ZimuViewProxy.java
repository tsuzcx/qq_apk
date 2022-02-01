package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.ui.ScreenLayoutDoubleScreen;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ZimuViewProxy
{
  ZimuView a = null;
  EffectZimuManager b = null;
  VideoAppInterface c;
  Context d;
  
  public ZimuViewProxy(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.c = paramVideoAppInterface;
    this.d = paramContext;
  }
  
  private boolean a(long paramLong, ViewGroup paramViewGroup)
  {
    ZimuView localZimuView = this.a;
    if (localZimuView != null)
    {
      localZimuView.h();
      paramViewGroup.removeView(this.a);
      this.a = null;
      return true;
    }
    return false;
  }
  
  private boolean b(long paramLong, String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    this.a = ZimuViewFactory.a(paramLong, this.c, this.d, paramString);
    Object localObject = this.a;
    boolean bool1 = false;
    if (localObject != null)
    {
      float f1 = ((ZimuView)localObject).getViewHeight();
      localObject = this.d.getResources();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)f1);
      boolean bool2 = paramString.equals("film");
      float f2 = 0.0F;
      if (bool2)
      {
        f1 = paramInt2;
        f2 = ((Resources)localObject).getDimension(2131298445);
        localLayoutParams.addRule(12);
        f2 = f1 - f2;
        f1 = 0.0F;
      }
      else
      {
        f1 = paramInt1;
      }
      localLayoutParams.setMargins(0, (int)f1, 0, (int)f2);
      paramViewGroup.addView(this.a, localLayoutParams);
    }
    if (this.a != null) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void a()
  {
    if (this.c.d(0))
    {
      Object localObject = b();
      if (localObject != null)
      {
        localObject = (ZimuItem)((EffectZimuManager)localObject).c();
        if (localObject != null)
        {
          localObject = ((ZimuItem)localObject).getId();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            new ControlUIObserver.ZimuRequest(AudioHelper.c(), "maybeShowZimu", 1, (String)localObject).a(this.c);
          }
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    a(false);
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    ZimuView localZimuView = this.a;
    if (localZimuView != null) {
      localZimuView.a(paramSentenceInfo);
    }
  }
  
  public void a(VideoLayerUI paramVideoLayerUI, int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((ZimuView)localObject).getLayoutParams();
      Resources localResources = this.d.getResources();
      if (this.a.getID().equals("film"))
      {
        if (paramVideoLayerUI.V()) {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramVideoLayerUI.h() - ScreenLayoutDoubleScreen.c(paramVideoLayerUI.g()) + localResources.getDimension(2131298336)));
        } else {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt2 - localResources.getDimension(2131298445)));
        }
      }
      else {
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramInt1 + localResources.getDimension(2131298459)));
      }
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b();
  }
  
  public boolean a(long paramLong, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideZimuView, exchangeItem[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("ZimuViewProxy", 1, localStringBuilder.toString());
    }
    b();
    if (paramBoolean) {
      this.b.a(paramLong, null);
    }
    return a(paramLong, paramViewGroup);
  }
  
  public boolean a(long paramLong, String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    ZimuView localZimuView = this.a;
    if (localZimuView == null) {
      return b(paramLong, paramString, paramViewGroup, paramInt1, paramInt2);
    }
    if (!localZimuView.getID().equals(paramString))
    {
      a(paramLong, paramViewGroup);
      return b(paramLong, paramString, paramViewGroup, paramInt1, paramInt2);
    }
    return true;
  }
  
  public boolean a(ViewGroup paramViewGroup, long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopZimuView, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("ZimuViewProxy", 1, localStringBuilder.toString());
    }
    b();
    a(paramLong, paramViewGroup);
    this.b.a(paramLong, null);
    this.b.a("stopZimuView", paramLong);
    return true;
  }
  
  public EffectZimuManager b()
  {
    if (this.b == null) {
      this.b = ((EffectZimuManager)this.c.c(0));
    }
    return this.b;
  }
  
  public void b(boolean paramBoolean)
  {
    ZimuView localZimuView = this.a;
    if (localZimuView != null) {
      localZimuView.a(paramBoolean);
    }
  }
  
  public ZimuItem c()
  {
    if (this.c.d(0))
    {
      b();
      return (ZimuItem)this.b.c();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewProxy
 * JD-Core Version:    0.7.0.1
 */