package com.app.hubert.guide.core;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.app.hubert.guide.lifecycle.ListenerFragment;
import com.app.hubert.guide.lifecycle.V4ListenerFragment;
import com.app.hubert.guide.listener.OnGuideChangedListener;
import com.app.hubert.guide.listener.OnPageChangedListener;
import com.app.hubert.guide.model.GuidePage;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.List;

public class Controller
{
  private static final String LISTENER_FRAGMENT = "listener_fragment";
  private Activity activity;
  private boolean alwaysShow;
  private int current;
  private GuideLayout currentLayout;
  private android.app.Fragment fragment;
  private List<GuidePage> guidePages;
  private int indexOfChild = -1;
  private boolean isShowing;
  private String label;
  private FrameLayout mParentView;
  private OnGuideChangedListener onGuideChangedListener;
  private OnPageChangedListener onPageChangedListener;
  private int showCounts;
  private SharedPreferences sp;
  private android.support.v4.app.Fragment v4Fragment;
  
  public Controller(Builder paramBuilder)
  {
    this.activity = paramBuilder.activity;
    this.fragment = paramBuilder.fragment;
    this.v4Fragment = paramBuilder.v4Fragment;
    this.onGuideChangedListener = paramBuilder.onGuideChangedListener;
    this.onPageChangedListener = paramBuilder.onPageChangedListener;
    this.label = paramBuilder.label;
    this.alwaysShow = paramBuilder.alwaysShow;
    this.guidePages = paramBuilder.guidePages;
    this.showCounts = paramBuilder.showCounts;
    Object localObject = paramBuilder.anchor;
    paramBuilder = (Builder)localObject;
    if (localObject == null) {
      paramBuilder = this.activity.findViewById(16908290);
    }
    if ((paramBuilder instanceof FrameLayout))
    {
      this.mParentView = ((FrameLayout)paramBuilder);
      this.sp = this.activity.getSharedPreferences("NewbieGuide", 0);
      return;
    }
    localObject = new FrameLayout(this.activity);
    ViewGroup localViewGroup = (ViewGroup)paramBuilder.getParent();
    this.indexOfChild = localViewGroup.indexOfChild(paramBuilder);
    localViewGroup.removeView(paramBuilder);
    if (this.indexOfChild >= 0) {
      localViewGroup.addView((View)localObject, this.indexOfChild, paramBuilder.getLayoutParams());
    }
    for (;;)
    {
      ((FrameLayout)localObject).addView(paramBuilder, new ViewGroup.LayoutParams(-1, -1));
      this.mParentView = ((FrameLayout)localObject);
      break;
      localViewGroup.addView((View)localObject, paramBuilder.getLayoutParams());
    }
  }
  
  private void addListenerFragment()
  {
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((this.fragment != null) && (Build.VERSION.SDK_INT > 16))
    {
      compatibleFragment(this.fragment);
      localObject3 = this.fragment.getChildFragmentManager();
      localObject2 = (ListenerFragment)((android.app.FragmentManager)localObject3).findFragmentByTag("listener_fragment");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ListenerFragment();
        ((android.app.FragmentManager)localObject3).beginTransaction().add((android.app.Fragment)localObject1, "listener_fragment").commitAllowingStateLoss();
      }
      ((ListenerFragment)localObject1).setFragmentLifecycle(new Controller.4(this));
    }
    if ((this.v4Fragment != null) && (this.v4Fragment.isAdded()))
    {
      localObject3 = this.v4Fragment.getChildFragmentManager();
      localObject2 = (V4ListenerFragment)((android.support.v4.app.FragmentManager)localObject3).findFragmentByTag("listener_fragment");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new V4ListenerFragment();
        ((android.support.v4.app.FragmentManager)localObject3).beginTransaction().add((android.support.v4.app.Fragment)localObject1, "listener_fragment").commitAllowingStateLoss();
      }
      ((V4ListenerFragment)localObject1).setFragmentLifecycle(new Controller.5(this));
    }
  }
  
  private void compatibleFragment(android.app.Fragment paramFragment)
  {
    try
    {
      Field localField = android.app.Fragment.class.getDeclaredField("mChildFragmentManager");
      localField.setAccessible(true);
      localField.set(paramFragment, null);
      return;
    }
    catch (NoSuchFieldException paramFragment)
    {
      throw new RuntimeException(paramFragment);
    }
    catch (IllegalAccessException paramFragment)
    {
      throw new RuntimeException(paramFragment);
    }
  }
  
  private void removeListenerFragment()
  {
    Object localObject1;
    Object localObject2;
    if ((this.fragment != null) && (Build.VERSION.SDK_INT > 16))
    {
      localObject1 = this.fragment.getChildFragmentManager();
      localObject2 = (ListenerFragment)((android.app.FragmentManager)localObject1).findFragmentByTag("listener_fragment");
      if (localObject2 != null) {
        ((android.app.FragmentManager)localObject1).beginTransaction().remove((android.app.Fragment)localObject2).commitAllowingStateLoss();
      }
    }
    if (this.v4Fragment != null)
    {
      localObject1 = this.v4Fragment.getChildFragmentManager();
      localObject2 = (V4ListenerFragment)((android.support.v4.app.FragmentManager)localObject1).findFragmentByTag("listener_fragment");
      if (localObject2 != null) {
        ((android.support.v4.app.FragmentManager)localObject1).beginTransaction().remove((android.support.v4.app.Fragment)localObject2).commitAllowingStateLoss();
      }
    }
  }
  
  private void showGuidePage()
  {
    Object localObject = (GuidePage)this.guidePages.get(this.current);
    localObject = new GuideLayout(this.activity, (GuidePage)localObject, this);
    ((GuideLayout)localObject).setOnGuideLayoutDismissListener(new Controller.3(this));
    this.mParentView.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    this.currentLayout = ((GuideLayout)localObject);
    if (this.onPageChangedListener != null) {
      this.onPageChangedListener.onPageChanged(this.current);
    }
    this.isShowing = true;
  }
  
  private void showNextOrRemove()
  {
    if (this.current < this.guidePages.size() - 1)
    {
      this.current += 1;
      showGuidePage();
      return;
    }
    if (this.onGuideChangedListener != null) {
      this.onGuideChangedListener.onRemoved(this);
    }
    removeListenerFragment();
    this.isShowing = false;
  }
  
  public boolean isShowing()
  {
    return this.isShowing;
  }
  
  public void remove()
  {
    ViewGroup localViewGroup1;
    ViewGroup localViewGroup2;
    View localView;
    if ((this.currentLayout != null) && (this.currentLayout.getParent() != null))
    {
      localViewGroup1 = (ViewGroup)this.currentLayout.getParent();
      localViewGroup1.removeView(this.currentLayout);
      if (!(localViewGroup1 instanceof FrameLayout))
      {
        localViewGroup2 = (ViewGroup)localViewGroup1.getParent();
        localView = localViewGroup1.getChildAt(0);
        localViewGroup1.removeAllViews();
        if (localView != null)
        {
          if (this.indexOfChild <= 0) {
            break label113;
          }
          localViewGroup2.addView(localView, this.indexOfChild, localViewGroup1.getLayoutParams());
        }
      }
    }
    for (;;)
    {
      if (this.onGuideChangedListener != null) {
        this.onGuideChangedListener.onRemoved(this);
      }
      this.currentLayout = null;
      this.isShowing = false;
      return;
      label113:
      localViewGroup2.addView(localView, localViewGroup1.getLayoutParams());
    }
  }
  
  public void resetLabel()
  {
    resetLabel(this.label);
  }
  
  public void resetLabel(String paramString)
  {
    this.sp.edit().putInt(paramString, 0).apply();
  }
  
  public void show()
  {
    int i = this.sp.getInt(this.label, 0);
    if ((!this.alwaysShow) && (i >= this.showCounts)) {}
    while (this.isShowing) {
      return;
    }
    this.isShowing = true;
    this.mParentView.post(new Controller.1(this, i));
  }
  
  public void showPage(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.guidePages.size() - 1)) {
      throw new InvalidParameterException("The Guide page position is out of range. current:" + paramInt + ", range: [ 0, " + this.guidePages.size() + " )");
    }
    if (this.current == paramInt) {
      return;
    }
    this.current = paramInt;
    if (this.currentLayout != null)
    {
      this.currentLayout.setOnGuideLayoutDismissListener(new Controller.2(this));
      this.currentLayout.remove();
      return;
    }
    showGuidePage();
  }
  
  public void showPreviewPage()
  {
    int i = this.current - 1;
    this.current = i;
    showPage(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.app.hubert.guide.core.Controller
 * JD-Core Version:    0.7.0.1
 */