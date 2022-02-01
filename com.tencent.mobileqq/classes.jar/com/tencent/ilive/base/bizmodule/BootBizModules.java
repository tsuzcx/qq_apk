package com.tencent.ilive.base.bizmodule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ilive.base.component.ComponentFactory;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilivesdk.domain.factory.LiveCaseFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class BootBizModules
  implements LifecycleObserver
{
  public static final int BOTTOM_EXTERNAL_LEVEL0 = 0;
  public static final int BOTTOM_EXTERNAL_LEVEL1 = 1;
  public static final int BOTTOM_LAYOUT_LEVEL = 2;
  public static final int MAX_LAYOUT_NUM = 7;
  public static final int NORMAL_LAYOUT_LEVEL = 3;
  public static final int TOP_EXTERNAL_LEVEL0 = 5;
  public static final int TOP_EXTERNAL_LEVEL1 = 6;
  public static final int TOP_LAYOUT_LEVEL = 4;
  protected Set<BizModule> bizModules = new HashSet();
  protected ComponentFactory componentFactory;
  protected Context context;
  protected LifecycleOwner lifecycleOwner;
  protected LiveCaseFactory liveCaseFactory;
  protected ModuleEvent moduleEvent = new ModuleEvent();
  protected ViewGroup rootView;
  protected List<ViewGroup> uiLayoutList = new ArrayList();
  
  private void initBizModulesAdapter()
  {
    BizModuleBaseAdapter localBizModuleBaseAdapter = getBizModuleAdapter();
    if (localBizModuleBaseAdapter == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext())
      {
        BizModule localBizModule = (BizModule)localIterator.next();
        if (localBizModule != null) {
          localBizModule.setBizModuleBaseAdapter(localBizModuleBaseAdapter);
        }
      }
    }
  }
  
  private void onCreateBizLayoutList()
  {
    int i = 0;
    while (i < 7)
    {
      this.uiLayoutList.add(i, null);
      i += 1;
    }
  }
  
  public abstract void addBizModuleExtData(BizModule paramBizModule);
  
  public boolean addBizModules(BizModule paramBizModule)
  {
    boolean bool = false;
    if (getBizModuleContext() == null) {
      throw new RuntimeException("biz module context is null");
    }
    if (getComponentFactory() == null) {
      throw new RuntimeException("biz module create ui factory is null");
    }
    if (this.lifecycleOwner == null) {
      throw new RuntimeException("BootBizModules has not lifecycleOwner !");
    }
    if (this.bizModules.contains(paramBizModule)) {
      return false;
    }
    if (getScreenOrientation() == 0) {
      bool = true;
    }
    paramBizModule.setOrientation(bool);
    paramBizModule.setBizLogicContext(getBizModuleContext());
    paramBizModule.setComponentFactory(getComponentFactory());
    paramBizModule.setLiveCaseFactory(getLiveCaseFactory());
    addBizModuleExtData(paramBizModule);
    paramBizModule.setEvent(this.moduleEvent);
    this.lifecycleOwner.getLifecycle().addObserver(paramBizModule);
    paramBizModule.onCreate(this.context);
    this.bizModules.add(paramBizModule);
    return true;
  }
  
  protected boolean addBottomLayoutBizModules(BizModule paramBizModule)
  {
    if (paramBizModule == null) {
      throw new RuntimeException("biz module is null");
    }
    if ((this.uiLayoutList.size() < 7) || (this.uiLayoutList.get(2) == null)) {
      throw new RuntimeException("uiLayoutList bottom has not bottom layout, please check getBottomLayout()");
    }
    paramBizModule.setRootView((ViewGroup)this.uiLayoutList.get(2));
    return addBizModules(paramBizModule);
  }
  
  protected boolean addNormalLayoutBizModules(BizModule paramBizModule)
  {
    if ((this.uiLayoutList.size() < 7) || (this.uiLayoutList.get(3) == null)) {
      throw new RuntimeException("uiLayoutList normal has not normal layout, please check getNormalLayout()");
    }
    paramBizModule.setRootView((ViewGroup)this.uiLayoutList.get(3));
    return addBizModules(paramBizModule);
  }
  
  protected boolean addTopLayoutBizModules(BizModule paramBizModule)
  {
    if ((this.uiLayoutList.size() < 7) || (this.uiLayoutList.get(4) == null)) {
      throw new RuntimeException("uiLayoutList top has not top layout, please check getTopLayout()");
    }
    paramBizModule.setRootView((ViewGroup)this.uiLayoutList.get(4));
    return addBizModules(paramBizModule);
  }
  
  public void bindLifeCycleOwner(LifecycleOwner paramLifecycleOwner)
  {
    this.lifecycleOwner = paramLifecycleOwner;
  }
  
  public void finish()
  {
    Iterator localIterator = this.bizModules.iterator();
    while (localIterator.hasNext()) {
      ((BizModule)localIterator.next()).finish();
    }
  }
  
  protected abstract BizModuleBaseAdapter getBizModuleAdapter();
  
  public abstract <T extends BizModuleContext> T getBizModuleContext();
  
  public ComponentFactory getComponentFactory()
  {
    return this.componentFactory;
  }
  
  public ViewGroup getLayout()
  {
    return this.rootView;
  }
  
  public LiveCaseFactory getLiveCaseFactory()
  {
    return this.liveCaseFactory;
  }
  
  public ModuleEvent getModuleEvent()
  {
    return this.moduleEvent;
  }
  
  protected abstract int getScreenOrientation();
  
  public List<ViewGroup> getUiLayoutList()
  {
    return this.uiLayoutList;
  }
  
  public boolean onBackPressed()
  {
    if ((this.bizModules == null) || (this.bizModules.size() == 0)) {
      return true;
    }
    Iterator localIterator = this.bizModules.iterator();
    while (localIterator.hasNext()) {
      ((BizModule)localIterator.next()).onBackPressed();
    }
    return false;
  }
  
  public void onCreate(Context paramContext)
  {
    this.context = paramContext;
    this.moduleEvent.onCreate(this.lifecycleOwner);
    onCreateBizLayoutList();
    onCreateBizLayout();
    onCreateBizModules();
  }
  
  protected void onCreateBizLayout()
  {
    this.rootView = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131559369, null));
    ViewGroup localViewGroup1 = onCreateBottomLayout();
    ViewGroup localViewGroup2 = onNormalLayoutCreated(onCreateNormalLayout());
    ViewGroup localViewGroup3 = onCreateTopLayout();
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    if (localViewGroup1 != null)
    {
      this.rootView.addView(localViewGroup1, localLayoutParams);
      this.uiLayoutList.set(2, localViewGroup1);
    }
    if (localViewGroup2 != null)
    {
      this.rootView.addView(localViewGroup2, localLayoutParams);
      this.uiLayoutList.set(3, localViewGroup2);
    }
    if (localViewGroup3 != null)
    {
      this.rootView.addView(localViewGroup3, localLayoutParams);
      this.uiLayoutList.set(4, localViewGroup3);
    }
  }
  
  protected void onCreateBizModules()
  {
    onCreateBottomBizModules();
    onCreateNormalBizModules();
    onCreateTopBizModules();
    initBizModulesAdapter();
  }
  
  protected abstract void onCreateBottomBizModules();
  
  protected abstract ViewGroup onCreateBottomLayout();
  
  protected abstract void onCreateNormalBizModules();
  
  protected abstract ViewGroup onCreateNormalLayout();
  
  protected abstract void onCreateTopBizModules();
  
  protected abstract ViewGroup onCreateTopLayout();
  
  public void onCreateView()
  {
    if ((this.bizModules == null) || (this.bizModules.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BizModule)localIterator.next()).onCreateView();
      }
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.bizModules.iterator();
    while (localIterator.hasNext())
    {
      BizModule localBizModule = (BizModule)localIterator.next();
      this.lifecycleOwner.getLifecycle().removeObserver(localBizModule);
      localBizModule.onDestroy();
    }
    this.moduleEvent.onDestroy();
    this.bizModules.clear();
    this.bizModules = null;
    this.context = null;
    this.componentFactory = null;
    this.uiLayoutList.clear();
    this.uiLayoutList = null;
    this.lifecycleOwner = null;
  }
  
  public void onDestroyView()
  {
    if ((this.bizModules == null) || (this.bizModules.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BizModule)localIterator.next()).onDestroyView();
      }
    }
  }
  
  public void onExtActive()
  {
    if ((this.bizModules == null) || (this.bizModules.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BizModule)localIterator.next()).onExtActive();
      }
    }
  }
  
  public void onExtDeActive()
  {
    if ((this.bizModules == null) || (this.bizModules.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BizModule)localIterator.next()).onExtDeActive();
      }
    }
  }
  
  protected ViewGroup onNormalLayoutCreated(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public abstract <T extends BizModuleContext> void setBizModuleContext(T paramT);
  
  public void setComponentFactory(ComponentFactory paramComponentFactory)
  {
    this.componentFactory = paramComponentFactory;
  }
  
  public void setLiveCaseFactory(LiveCaseFactory paramLiveCaseFactory)
  {
    this.liveCaseFactory = paramLiveCaseFactory;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if ((this.bizModules == null) || (this.bizModules.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((BizModule)localIterator.next()).onVisibleToUser(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.bizmodule.BootBizModules
 * JD-Core Version:    0.7.0.1
 */