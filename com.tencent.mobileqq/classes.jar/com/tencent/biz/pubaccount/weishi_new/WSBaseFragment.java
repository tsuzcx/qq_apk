package com.tencent.biz.pubaccount.weishi_new;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.drama.part.IWSPartLifeCycle;
import com.tencent.biz.pubaccount.weishi_new.drama.part.IWSPartLifeOwner;
import com.tencent.biz.pubaccount.weishi_new.drama.part.WSPartLifeCycleDelegate;
import com.tencent.biz.pubaccount.weishi_new.main.WSTopEdgeGestureLayout;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashSet;

public abstract class WSBaseFragment<V extends IWSBaseView, P extends IWSPresenter<V>>
  extends PublicBaseFragment
  implements IWSBaseView, IWSDelegateCallback<V, P>, WSFragmentUserVisibleController.UserVisibleCallback, IWSPartLifeOwner
{
  protected Context a;
  protected P b;
  protected WSTopEdgeGestureLayout c;
  protected boolean d;
  public boolean e;
  private IWSFragmentDelegate<V, P> f;
  private WSPartLifeCycleDelegate g;
  private final WSFragmentUserVisibleController h = new WSFragmentUserVisibleController(this, this);
  private MiniMsgUser i;
  private boolean j;
  
  protected void a(@NonNull Activity paramActivity)
  {
    if (paramActivity.getWindow() == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    if ((paramActivity instanceof PublicTransFragmentActivity)) {
      paramActivity.setTheme(1929904128);
    }
  }
  
  public void a(P paramP)
  {
    this.b = paramP;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSBaseFragment.java][onVisibleToUserChanged] isVisibleToUser:");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", invokeInResumeOrPause:");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(", this:");
    localStringBuilder.append(this);
    WSLog.e("WSLifecycleLog", localStringBuilder.toString());
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (getBaseActivity() == null) {
      return false;
    }
    int m = Build.VERSION.SDK_INT;
    int k = 9216;
    if ((m >= 23) && (!SystemUtil.g()) && (!SystemUtil.d()))
    {
      if (!paramBoolean) {
        k = 1280;
      }
      getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(k);
      return paramBoolean;
    }
    boolean bool;
    if (ImmersiveUtils.supportStatusBarDarkMode())
    {
      ImmersiveUtils.setStatusBarDarkMode(getBaseActivity().getWindow(), paramBoolean);
      bool = paramBoolean;
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool = paramBoolean;
        if (SystemUtil.d())
        {
          if (!paramBoolean) {
            k = 1280;
          }
          getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(k);
          return paramBoolean;
        }
      }
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public V aH_()
  {
    return this;
  }
  
  @NonNull
  protected IWSFragmentDelegate<V, P> aM_()
  {
    if (this.f == null) {
      this.f = new WSFragmentDelegateImpl(this);
    }
    return this.f;
  }
  
  protected boolean aN_()
  {
    return ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  public P aO_()
  {
    return this.b;
  }
  
  protected MiniMsgUserParam aV_()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 6;
    localMiniMsgUserParam.accessType = 2;
    localMiniMsgUserParam.filterMsgType = 0;
    localMiniMsgUserParam.entryType = 0;
    localMiniMsgUserParam.positionX = -1;
    localMiniMsgUserParam.positionY = -1;
    localMiniMsgUserParam.colorType = 0;
    return localMiniMsgUserParam;
  }
  
  public boolean aW_()
  {
    return this.h.e();
  }
  
  public MiniMsgUser aY_()
  {
    return this.i;
  }
  
  public void aZ_()
  {
    Object localObject = getActivity();
    if (!(localObject instanceof PublicFragmentActivity)) {
      return;
    }
    localObject = ((PublicFragmentActivity)localObject).mSystemBarComp;
    ((SystemBarCompact)localObject).setStatusBarVisible(2, 0);
    ((SystemBarCompact)localObject).setStatusBarColor(0);
  }
  
  public boolean ba_()
  {
    boolean bool = this.h.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSBaseFragment.java][isVisibleToUser] isVisibleToUser:");
    localStringBuilder.append(bool);
    localStringBuilder.append(", this:");
    localStringBuilder.append(this);
    WSLog.e("WSLifecycleLog", localStringBuilder.toString());
    return bool;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h.b(paramBoolean);
  }
  
  public void d(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
  }
  
  protected void d_(boolean paramBoolean)
  {
    WSTopEdgeGestureLayout localWSTopEdgeGestureLayout = this.c;
    if (localWSTopEdgeGestureLayout != null) {
      localWSTopEdgeGestureLayout.setIsIntercept(paramBoolean);
    }
  }
  
  protected boolean h()
  {
    return false;
  }
  
  protected void i() {}
  
  public void initSideFling(Context paramContext, FlingHandler paramFlingHandler)
  {
    super.initSideFling(paramContext, paramFlingHandler);
    this.c = new WSTopEdgeGestureLayout(paramContext);
    if ((paramFlingHandler != null) && ((paramFlingHandler instanceof FlingGestureHandler)))
    {
      paramContext = (FlingGestureHandler)paramFlingHandler;
      paramContext.setTopLayout(this.c);
      paramContext.mTopLayout.setInterceptScrollLRFlag(true);
    }
  }
  
  public HashSet<IWSPartLifeCycle> j()
  {
    return null;
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.h.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getContext();
    this.e = aN_();
    aM_().a(paramBundle);
    if (h())
    {
      paramBundle = aV_();
      this.i = new MiniMsgUser(getBaseActivity(), paramBundle);
    }
    this.g = new WSPartLifeCycleDelegate();
    this.g.m();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aM_().b();
    if (h())
    {
      MiniMsgUser localMiniMsgUser = this.i;
      if (localMiniMsgUser != null) {
        localMiniMsgUser.destroy();
      }
    }
    this.g.n();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    aM_().a();
    this.g.d();
  }
  
  public void onPause()
  {
    super.onPause();
    this.h.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSBaseFragment.java][onPause] mIsUserVisibleHint:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", this:");
    ((StringBuilder)localObject).append(this);
    WSLog.e("WSLifecycleLog", ((StringBuilder)localObject).toString());
    if (h())
    {
      localObject = this.i;
      if (localObject != null) {
        ((MiniMsgUser)localObject).onBackground();
      }
    }
    this.g.f();
  }
  
  public void onResume()
  {
    super.onResume();
    this.h.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSBaseFragment.java][onResume] mIsUserVisibleHint:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", this:");
    ((StringBuilder)localObject).append(this);
    WSLog.e("WSLifecycleLog", ((StringBuilder)localObject).toString());
    if (h())
    {
      localObject = this.i;
      if (localObject != null) {
        ((MiniMsgUser)localObject).onForeground();
      }
    }
    i();
    this.g.e();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    aM_().a(paramView, paramBundle);
    this.g.a(j());
    this.g.c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.j))
    {
      if (h())
      {
        MiniMsgUser localMiniMsgUser = this.i;
        if (localMiniMsgUser != null) {
          localMiniMsgUser.showOnFirst();
        }
      }
      this.j = true;
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.h.a(paramBoolean);
    this.d = getUserVisibleHint();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSBaseFragment.java][setUserVisibleHint] mIsUserVisibleHint:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", this:");
    localStringBuilder.append(this);
    WSLog.g("WSLifecycleLog", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseFragment
 * JD-Core Version:    0.7.0.1
 */