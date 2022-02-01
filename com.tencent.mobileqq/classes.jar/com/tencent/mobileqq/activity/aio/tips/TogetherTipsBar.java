package com.tencent.mobileqq.activity.aio.tips;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.ui.WatchPanelView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;

public class TogetherTipsBar
  implements TipsBarTask
{
  private WatchPanelView a;
  protected BaseChatPie b;
  protected QQBlurView c;
  protected View.OnClickListener d;
  protected ViewGroup e;
  protected boolean f = false;
  
  public TogetherTipsBar(BaseChatPie paramBaseChatPie, View.OnClickListener paramOnClickListener)
  {
    this.b = paramBaseChatPie;
    this.d = paramOnClickListener;
  }
  
  private void b(TogetherSession paramTogetherSession, QQAppInterface paramQQAppInterface)
  {
    paramTogetherSession = paramTogetherSession.b(paramQQAppInterface);
    this.a.a(0, paramTogetherSession);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.e != null)
    {
      f();
      return this.e;
    }
    this.e = ((ViewGroup)LayoutInflater.from(this.b.aX()).inflate(2131627290, null));
    f();
    paramVarArgs = new FrameLayout.LayoutParams(-1, AIOUtils.b(56.0F, this.e.getResources()));
    View localView = this.e.findViewById(d());
    if (localView != null) {
      this.e.removeView(localView);
    }
    a(paramVarArgs);
    return this.e;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000)
    {
      paramVarArgs = this.c;
      if (paramVarArgs != null)
      {
        paramVarArgs.a();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("resumeBlurView called mBlurBgView = ");
          paramVarArgs.append(Integer.toHexString(System.identityHashCode(this.c)));
          QLog.d("TogetherTipsBar", 2, paramVarArgs.toString());
        }
      }
    }
    else if (paramInt == 1003)
    {
      paramVarArgs = this.c;
      if (paramVarArgs != null)
      {
        paramVarArgs.b();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("pauseBlurView called mBlurBgView = ");
          paramVarArgs.append(Integer.toHexString(System.identityHashCode(this.c)));
          QLog.d("TogetherTipsBar", 2, paramVarArgs.toString());
        }
      }
    }
    else if (paramInt == 1004)
    {
      g();
    }
  }
  
  protected void a(FrameLayout.LayoutParams paramLayoutParams)
  {
    this.a = new WatchPanelView(this.b.aX());
    WatchPanelView localWatchPanelView = this.a;
    localWatchPanelView.h = this.d;
    localWatchPanelView.setLayoutParams(paramLayoutParams);
    this.a.setId(d());
    this.a.setOnClickListener(this.d);
    this.a.setVisibility(0);
    this.e.addView(this.a);
  }
  
  public void a(TogetherSession paramTogetherSession, QQAppInterface paramQQAppInterface)
  {
    WatchPanelView localWatchPanelView = this.a;
    if (localWatchPanelView != null)
    {
      localWatchPanelView.c(0);
      localWatchPanelView = this.a;
      localWatchPanelView.b(localWatchPanelView.getResources().getString(paramTogetherSession.h()));
      this.a.a(paramTogetherSession.a(paramQQAppInterface), 2131167972);
      b(paramTogetherSession, paramQQAppInterface);
      this.a.a(paramTogetherSession.b());
      this.a.b(paramTogetherSession.c());
      this.a.a(paramTogetherSession.a());
      this.a.a(paramTogetherSession.r, paramQQAppInterface);
    }
  }
  
  public int b()
  {
    return 26;
  }
  
  public int[] c()
  {
    return null;
  }
  
  protected int d()
  {
    return 2131447678;
  }
  
  public View e()
  {
    return this.a;
  }
  
  protected void f()
  {
    this.c = ((QQBlurView)this.e.findViewById(2131447679));
    h();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.c)));
      QLog.d("TogetherTipsBar", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e.findViewById(2131439721);
    if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false)))
    {
      ((View)localObject).setBackgroundColor(this.e.getResources().getColor(2131167964));
      ((View)localObject).setVisibility(0);
      this.c.setVisibility(8);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showBlurView() gone called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.c)));
        QLog.d("TogetherTipsBar", 2, ((StringBuilder)localObject).toString());
      }
      this.c = null;
      return;
    }
    ((View)localObject).setVisibility(8);
    this.c.setVisibility(0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() visibility called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.c)));
      QLog.d("TogetherTipsBar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherTipsBar", 2, "destroyUI()");
    }
    this.b.bx().d().d().a(null);
    if (this.f)
    {
      this.c = ((QQBlurView)this.e.findViewById(2131447679));
      this.f = false;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("destroyBlurView called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.c)));
        QLog.d("TogetherTipsBar", 2, ((StringBuilder)localObject).toString());
      }
      this.c = null;
    }
    localObject = this.a;
    if (localObject != null) {
      ((WatchPanelView)localObject).a();
    }
  }
  
  @TargetApi(19)
  protected void h()
  {
    if (this.f) {
      return;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((QQBlurView)localObject).a(this.b.aZ);
      localObject = this.c;
      ((QQBlurView)localObject).b((View)localObject);
      this.c.b(0);
      this.c.a(8.0F);
      this.c.a(4);
      this.c.d();
      this.c.a();
      this.f = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initBlurView called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.c)));
        QLog.d("TogetherTipsBar", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TogetherTipsBar
 * JD-Core Version:    0.7.0.1
 */