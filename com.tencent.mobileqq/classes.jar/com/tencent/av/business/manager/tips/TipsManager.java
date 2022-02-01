package com.tencent.av.business.manager.tips;

import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.tips.IAvTipsView;
import com.tencent.av.tips.data.AVTipsItemFactory;
import com.tencent.av.tips.data.AvTipsItemBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class TipsManager
  extends BusinessManager
{
  private WeakReference<IAvTipsView> d;
  private final TipsViewTimerRunnable e;
  private volatile AvTipsItemBase f = null;
  private volatile AvTipsItemBase g = null;
  @Deprecated
  private volatile AvTipsItemBase h = null;
  
  public TipsManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.e = new TipsViewTimerRunnable(paramVideoAppInterface);
  }
  
  public static void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if ((QLog.isColorLevel()) || (QLog.isDebugVersion())) {
      QLog.d("NewTipsManager", 2, paramString);
    }
  }
  
  private boolean d(AvTipsItemBase paramAvTipsItemBase)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showSubTips begin avTipsItem = ");
    if (paramAvTipsItemBase != null) {
      localObject1 = Integer.valueOf(paramAvTipsItemBase.b());
    } else {
      localObject1 = "null";
    }
    ((StringBuilder)localObject2).append(localObject1);
    b(((StringBuilder)localObject2).toString());
    Object localObject1 = f();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAvTipsItemBase != null)
    {
      bool1 = bool2;
      if (localObject1 != null)
      {
        if (!((IAvTipsView)localObject1).c()) {
          return false;
        }
        localObject2 = this.e.d();
        boolean bool3 = AvTipsItemBase.a((AvTipsItemBase)localObject2, paramAvTipsItemBase);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showSubTips canShow = ");
        localStringBuilder.append(bool3);
        b(localStringBuilder.toString());
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (((IAvTipsView)localObject1).b(paramAvTipsItemBase))
          {
            b("showSubTips ShowSubTipsView success");
            this.e.b(paramAvTipsItemBase);
            bool2 = true;
            bool1 = bool2;
            if (localObject2 != null)
            {
              bool1 = bool2;
              if (((AvTipsItemBase)localObject2).g())
              {
                if (paramAvTipsItemBase.g())
                {
                  this.h = null;
                  return true;
                }
                this.h = ((AvTipsItemBase)localObject2);
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean e(AvTipsItemBase paramAvTipsItemBase)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showMainTips begin avTipsItem = ");
    Object localObject1;
    if (paramAvTipsItemBase != null) {
      localObject1 = Integer.valueOf(paramAvTipsItemBase.b());
    } else {
      localObject1 = "null";
    }
    ((StringBuilder)localObject2).append(localObject1);
    b(((StringBuilder)localObject2).toString());
    localObject2 = f();
    boolean bool2 = false;
    if ((paramAvTipsItemBase != null) && (localObject2 != null))
    {
      if (!((IAvTipsView)localObject2).a()) {
        return false;
      }
      localObject1 = this.e.c();
      boolean bool1 = paramAvTipsItemBase.g();
      int j;
      if ((localObject1 != null) && (!((AvTipsItemBase)localObject1).g())) {
        j = 1;
      } else {
        j = 0;
      }
      int i;
      if (paramAvTipsItemBase.b() == 1070) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.g = paramAvTipsItemBase;
        bool1 = bool2;
        if (localObject1 == null)
        {
          bool1 = bool2;
          if (((IAvTipsView)localObject2).a(paramAvTipsItemBase))
          {
            b("showMainTips ShowMainTipsView success");
            this.e.a(paramAvTipsItemBase);
            bool1 = true;
          }
        }
        return bool1;
      }
      bool2 = AvTipsItemBase.a((AvTipsItemBase)localObject1, paramAvTipsItemBase);
      if ((bool1) && (j != 0) && (!bool2)) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        this.f = paramAvTipsItemBase;
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showMainTips canShow = ");
      localStringBuilder.append(bool2);
      b(localStringBuilder.toString());
      if (bool2)
      {
        if (((IAvTipsView)localObject2).a(paramAvTipsItemBase))
        {
          b("showMainTips ShowMainTipsView success");
          this.e.a(paramAvTipsItemBase);
          if ((localObject1 != null) && (((AvTipsItemBase)localObject1).g())) {
            if ((!bool1) && (i == 0)) {
              this.f = ((AvTipsItemBase)localObject1);
            } else {
              this.f = null;
            }
          }
          return true;
        }
      }
      else
      {
        paramAvTipsItemBase = new StringBuilder();
        paramAvTipsItemBase.append("showMainTips canShow is false current = ");
        paramAvTipsItemBase.append(((AvTipsItemBase)localObject1).b());
        b(paramAvTipsItemBase.toString());
      }
    }
    return false;
  }
  
  private void f(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return;
    }
    Object localObject = this.e.c();
    StringBuilder localStringBuilder;
    if (paramAvTipsItemBase.equals(this.f))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = ");
      localStringBuilder.append(paramAvTipsItemBase.b());
      b(localStringBuilder.toString());
      this.f = null;
    }
    if (paramAvTipsItemBase.equals(this.g))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = ");
      localStringBuilder.append(paramAvTipsItemBase.b());
      b(localStringBuilder.toString());
      this.g = null;
    }
    if (paramAvTipsItemBase.equals(localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = ");
      ((StringBuilder)localObject).append(paramAvTipsItemBase.b());
      b(((StringBuilder)localObject).toString());
      this.e.a();
    }
  }
  
  private void g()
  {
    IAvTipsView localIAvTipsView = f();
    b("hiddenMainTipsReal");
    if (localIAvTipsView != null)
    {
      if (!localIAvTipsView.a()) {
        return;
      }
      localIAvTipsView.b();
    }
  }
  
  private void g(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (paramAvTipsItemBase.equals(this.e.d()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = ");
      localStringBuilder.append(paramAvTipsItemBase.b());
      b(localStringBuilder.toString());
      this.e.b();
      return;
    }
    if (paramAvTipsItemBase.equals(this.h))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = ");
      localStringBuilder.append(paramAvTipsItemBase.b());
      b(localStringBuilder.toString());
      this.h = null;
    }
  }
  
  private void h()
  {
    IAvTipsView localIAvTipsView = f();
    b("hiddenSubTipsReal");
    if (localIAvTipsView != null)
    {
      if (!localIAvTipsView.c()) {
        return;
      }
      localIAvTipsView.d();
    }
  }
  
  public int a(long paramLong, boolean paramBoolean)
  {
    if ((paramLong != 0L) && (paramLong < 1000L)) {
      return 3;
    }
    if (paramBoolean) {
      return 0;
    }
    return (int)(paramLong / 1000L);
  }
  
  protected void a() {}
  
  public void a(IAvTipsView paramIAvTipsView)
  {
    if (paramIAvTipsView == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAvTipsView avTipsView is ");
    localStringBuilder.append(paramIAvTipsView.getClass());
    b(localStringBuilder.toString());
    this.d = new WeakReference(paramIAvTipsView);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      AvTipsItemBase localAvTipsItemBase = this.e.c();
      if (localAvTipsItemBase != null)
      {
        if ((localAvTipsItemBase != null) && (localAvTipsItemBase.b() == 1070)) {
          return;
        }
        if ((1075 < localAvTipsItemBase.b()) || (localAvTipsItemBase.b() < 1062)) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hiddenDeviceTips current id = ");
        localStringBuilder.append(localAvTipsItemBase.b());
        b(localStringBuilder.toString());
        b(localAvTipsItemBase.b());
      }
    }
    else
    {
      b(1070);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.c == null) {
      return false;
    }
    return a(AVTipsItemFactory.a(paramInt, this.c));
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    if (this.c == null) {
      return false;
    }
    return a(AVTipsItemFactory.a(paramInt, this.c, a(paramLong, false)));
  }
  
  public boolean a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.c == null) {
      return false;
    }
    return a(AVTipsItemFactory.a(paramInt, this.c, a(paramLong, paramBoolean)));
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (this.c == null) {
      return false;
    }
    return a(AVTipsItemFactory.a(paramInt, this.c, paramString));
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.c == null) {
      return false;
    }
    return a(AVTipsItemFactory.a(paramInt1, this.c, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.c == null) {
      return false;
    }
    return a(AVTipsItemFactory.a(paramInt1, this.c, paramString1, paramString2, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  public boolean a(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null)
    {
      b("showTips (tipsItem == null)");
      return false;
    }
    int i = paramAvTipsItemBase.d();
    if (i != 0)
    {
      if (i != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showTips tipsItem.getShowType() = ");
        localStringBuilder.append(paramAvTipsItemBase.d());
        b(localStringBuilder.toString());
        return false;
      }
      return d(paramAvTipsItemBase);
    }
    return e(paramAvTipsItemBase);
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString, long paramLong, boolean paramBoolean)
  {
    if (this.c == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showDeviceTips TTL = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("    resident = ");
    localStringBuilder.append(paramBoolean);
    b(localStringBuilder.toString());
    return a(AVTipsItemFactory.a(1075, this.c, paramString, a(paramLong, paramBoolean)));
  }
  
  public boolean a(String paramString1, String paramString2, View.OnClickListener paramOnClickListener, long paramLong, boolean paramBoolean)
  {
    return a(AVTipsItemFactory.a(paramString1, paramString2, this.c, paramOnClickListener, a(paramLong, paramBoolean)));
  }
  
  public void b()
  {
    AvTipsItemBase localAvTipsItemBase = this.e.c();
    int i;
    if ((localAvTipsItemBase != null) && (localAvTipsItemBase.b() == 1070)) {
      i = 1;
    } else {
      i = 0;
    }
    if (localAvTipsItemBase != null)
    {
      if (i != 0) {
        return;
      }
      this.e.a();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.c == null)
    {
      b("HiddenTips (mApp == null)");
      return;
    }
    AvTipsItemBase localAvTipsItemBase = AVTipsItemFactory.a(paramInt, this.c);
    if (localAvTipsItemBase == null)
    {
      b("HiddenTips (tipsItem == null)");
      return;
    }
    paramInt = localAvTipsItemBase.d();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("HiddenTips tipsItem.getShowType() = ");
        localStringBuilder.append(localAvTipsItemBase.d());
        b(localStringBuilder.toString());
        return;
      }
      g(localAvTipsItemBase);
      return;
    }
    f(localAvTipsItemBase);
  }
  
  public void b(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NotifyHiddenMainTipsByRunner item");
    localStringBuilder.append(paramAvTipsItemBase.b());
    b(localStringBuilder.toString());
    if ((!paramAvTipsItemBase.g()) && (this.f != null))
    {
      e(this.f);
      return;
    }
    g();
    if (this.g != null) {
      a(this.g);
    }
  }
  
  public void c()
  {
    b("RemoveAllTips");
    this.f = null;
    this.g = null;
    this.e.a();
    this.e.b();
    this.h = null;
  }
  
  public void c(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NotifyHiddenSubTipsByRunner item");
    localStringBuilder.append(paramAvTipsItemBase.b());
    b(localStringBuilder.toString());
    if ((!paramAvTipsItemBase.g()) && (this.h != null))
    {
      d(this.h);
      return;
    }
    h();
  }
  
  public void d()
  {
    IAvTipsView localIAvTipsView = f();
    b("HiddenViewContainer");
    if (localIAvTipsView != null)
    {
      if (!localIAvTipsView.c()) {
        return;
      }
      localIAvTipsView.e();
    }
  }
  
  public void e()
  {
    IAvTipsView localIAvTipsView = f();
    b("ShowViewContainer");
    if (localIAvTipsView != null)
    {
      if (!localIAvTipsView.c()) {
        return;
      }
      localIAvTipsView.f();
    }
  }
  
  public IAvTipsView f()
  {
    WeakReference localWeakReference = this.d;
    if ((localWeakReference != null) && (!localWeakReference.isEnqueued())) {
      return (IAvTipsView)this.d.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.tips.TipsManager
 * JD-Core Version:    0.7.0.1
 */