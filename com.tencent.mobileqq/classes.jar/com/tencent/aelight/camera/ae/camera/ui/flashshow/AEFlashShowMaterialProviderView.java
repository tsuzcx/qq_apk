package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.IOnTabCheckListener;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.TabIcon;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialProviderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/aelight/camera/aioeditor/capture/view/QIMSlidingTabView$IOnTabCheckListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Lcom/tencent/mobileqq/shortvideo/common/Observer;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$AEMaterialPanelListener;", "(Landroid/content/Context;Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$AEMaterialPanelListener;)V", "defaultPagerPos", "", "firstClickEvent", "", "isAccountChange", "mApp", "Lcom/tencent/common/app/AppInterface;", "mApplyNoneMaterial", "Landroid/view/View;", "mCaptureConfigUpdateObserver", "com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialProviderView$mCaptureConfigUpdateObserver$1", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialProviderView$mCaptureConfigUpdateObserver$1;", "mPageAdapter", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialTabAdapter;", "mTabList", "", "Lcom/tencent/aelight/camera/ae/data/AEMaterialCategory;", "mTemplateManager", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialManager;", "mTopTabBar", "Lcom/tencent/aelight/camera/aioeditor/capture/view/QIMSlidingTabView;", "mViewPager", "Lcom/tencent/mobileqq/widget/QQViewPager;", "materialSelected", "panelListener", "findTabName", "materialId", "", "getManager", "getTabNameList", "Ljava/util/ArrayList;", "Lcom/tencent/aelight/camera/aioeditor/capture/view/QIMSlidingTabView$TabIcon;", "getTag", "initView", "", "locatePage", "pos", "notify", "sender", "", "eventId", "args", "", "(Ljava/lang/Object;I[Ljava/lang/Object;)V", "onClear", "onDestroy", "onPageScrollStateChanged", "i", "onPageScrolled", "v", "", "i1", "onPageSelected", "onScrollChanged", "onShow", "onStop", "onTabChecked", "tabIndex", "selectCategoryAndItem", "categoryName", "itemId", "updateData", "loadRecentList", "updateNoneMaterialState", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialProviderView
  extends FrameLayout
  implements ViewTreeObserver.OnScrollChangedListener, ViewPager.OnPageChangeListener, QIMSlidingTabView.IOnTabCheckListener, Observer
{
  public static final AEFlashShowMaterialProviderView.Companion a = new AEFlashShowMaterialProviderView.Companion(null);
  private AppInterface b;
  private QIMSlidingTabView c;
  private List<? extends AEMaterialCategory> d = (List)new CopyOnWriteArrayList();
  private View e;
  private QQViewPager f;
  private AEFlashShowMaterialTabAdapter g;
  private AEFlashShowMaterialManager h;
  private AEFlashShowMaterialPanel.AEMaterialPanelListener i;
  private boolean j;
  private boolean k;
  private int l;
  private final AEFlashShowMaterialProviderView.mCaptureConfigUpdateObserver.1 m;
  
  public AEFlashShowMaterialProviderView(@NotNull Context paramContext, @Nullable AEFlashShowMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    super(paramContext);
    this.i = paramAEMaterialPanelListener;
    this.j = true;
    this.l = 1;
    this.m = new AEFlashShowMaterialProviderView.mCaptureConfigUpdateObserver.1(this);
    this.b = AECaptureContext.a();
    d();
  }
  
  private final AEMaterialCategory a(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return null;
    }
    AEMaterialCategory localAEMaterialCategory;
    AEMaterialMetaData localAEMaterialMetaData;
    do
    {
      Iterator localIterator = this.d.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localAEMaterialCategory = (AEMaterialCategory)localIterator.next();
          if (localAEMaterialCategory != null) {
            localObject = localAEMaterialCategory.a;
          } else {
            localObject = null;
          }
        } while (localObject == null);
        localObject = localAEMaterialCategory.a.iterator();
      }
      localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject).next();
    } while ((localAEMaterialMetaData == null) || (!Intrinsics.areEqual(paramString, localAEMaterialMetaData.m)));
    return localAEMaterialCategory;
    return null;
  }
  
  private final void d()
  {
    LayoutInflater.from(getContext()).inflate(2064056469, (ViewGroup)this);
    Object localObject1 = (AEFlashShowMaterialProviderView)this;
    ((AEFlashShowMaterialProviderView)localObject1).c = ((QIMSlidingTabView)((AEFlashShowMaterialProviderView)localObject1).findViewById(2063991460));
    Object localObject2 = ((AEFlashShowMaterialProviderView)localObject1).c;
    if (localObject2 != null) {
      ((QIMSlidingTabView)localObject2).setTabCheckListener((QIMSlidingTabView.IOnTabCheckListener)localObject1);
    }
    localObject2 = ((AEFlashShowMaterialProviderView)localObject1).c;
    if (localObject2 != null)
    {
      localObject2 = ((QIMSlidingTabView)localObject2).getViewTreeObserver();
      if (localObject2 != null) {
        ((ViewTreeObserver)localObject2).addOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)localObject1);
      }
    }
    ((AEFlashShowMaterialProviderView)localObject1).e = ((AEFlashShowMaterialProviderView)localObject1).findViewById(2063991201);
    ((AEFlashShowMaterialProviderView)localObject1).c();
    localObject2 = ((AEFlashShowMaterialProviderView)localObject1).e;
    if (localObject2 != null) {
      ((View)localObject2).setOnClickListener((View.OnClickListener)new AEFlashShowMaterialProviderView.initView.2.1((AEFlashShowMaterialProviderView)localObject1));
    }
    ((AEFlashShowMaterialProviderView)localObject1).f = ((QQViewPager)((AEFlashShowMaterialProviderView)localObject1).findViewById(2063991614));
    localObject2 = ((AEFlashShowMaterialProviderView)localObject1).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    ((AEFlashShowMaterialProviderView)localObject1).g = new AEFlashShowMaterialTabAdapter((Context)localObject2, ((AEFlashShowMaterialProviderView)localObject1).i);
    localObject2 = AEQIMManager.a(3);
    if (localObject2 != null)
    {
      ((AEFlashShowMaterialProviderView)localObject1).h = ((AEFlashShowMaterialManager)localObject2);
      localObject2 = ((AEFlashShowMaterialProviderView)localObject1).h;
      if (localObject2 != null) {
        ((AEFlashShowMaterialManager)localObject2).b(false);
      }
      localObject2 = ((AEFlashShowMaterialProviderView)localObject1).g;
      if (localObject2 != null) {
        ((AEFlashShowMaterialTabAdapter)localObject2).a((List)new ArrayList());
      }
      localObject2 = ((AEFlashShowMaterialProviderView)localObject1).f;
      if (localObject2 != null) {
        ((QQViewPager)localObject2).setOnPageChangeListener((ViewPager.OnPageChangeListener)localObject1);
      }
      localObject2 = ((AEFlashShowMaterialProviderView)localObject1).f;
      if (localObject2 != null) {
        ((QQViewPager)localObject2).setAdapter((PagerAdapter)((AEFlashShowMaterialProviderView)localObject1).g);
      }
      localObject1 = this.b;
      if (localObject1 != null) {
        ((AppInterface)localObject1).registObserver((BusinessObserver)this.m);
      }
      a(true);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager");
  }
  
  private final ArrayList<QIMSlidingTabView.TabIcon> getTabNameList()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = ((Collection)this.d).size();
    int n = 0;
    while (n < i1)
    {
      AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)this.d.get(n);
      if (localAEMaterialCategory != null)
      {
        if (-1 == localAEMaterialCategory.b) {
          this.l = n;
        }
        QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
        localTabIcon.a = localAEMaterialCategory.d;
        localArrayList.add(localTabIcon);
      }
      n += 1;
    }
    return localArrayList;
  }
  
  public final void a()
  {
    AEFlashShowMaterialManager localAEFlashShowMaterialManager = this.h;
    if (localAEFlashShowMaterialManager != null) {
      localAEFlashShowMaterialManager.d();
    }
  }
  
  public final void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("locatePage: ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.b("AEFlashShowMaterialProviderView", ((StringBuilder)localObject).toString());
    localObject = this.f;
    if (localObject != null) {
      ((QQViewPager)localObject).setCurrentItem(paramInt);
    }
  }
  
  public final void a(@Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "itemId");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder("selectCategoryAndItem");
      ((StringBuilder)localObject1).append(", categoryName=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", itemId=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", mTabListSize=");
      ((StringBuilder)localObject1).append(this.d.size());
      QLog.d("AEFlashShowMaterialProviderView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (AEMaterialCategory)null;
    if (this.d.isEmpty()) {
      a(true);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)paramString1);
    int i3 = 0;
    int n;
    if (bool)
    {
      paramString1 = a(paramString2);
      n = CollectionsKt.indexOf(this.d, paramString1);
    }
    else
    {
      i1 = ((Collection)this.d).size();
      n = 0;
      while (n < i1)
      {
        if (paramString1 != null)
        {
          localObject1 = (AEMaterialCategory)this.d.get(n);
          if (localObject1 != null) {
            localObject1 = ((AEMaterialCategory)localObject1).d;
          } else {
            localObject1 = null;
          }
          if (Intrinsics.areEqual(paramString1, localObject1))
          {
            paramString1 = (AEMaterialCategory)this.d.get(n);
            break label248;
          }
        }
        n += 1;
      }
      n = 0;
      paramString1 = (String)localObject2;
    }
    label248:
    if (paramString1 == null) {
      return;
    }
    localObject2 = (AEMaterialMetaData)null;
    Object localObject1 = paramString1.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "category.materialList");
    int i4 = ((Collection)localObject1).size();
    int i1 = 0;
    int i2;
    for (;;)
    {
      localObject1 = localObject2;
      i2 = i3;
      if (i1 >= i4) {
        break;
      }
      localObject1 = (AEMaterialMetaData)paramString1.a.get(i1);
      if (Intrinsics.areEqual(((AEMaterialMetaData)localObject1).m, paramString2))
      {
        i2 = i1;
        break;
      }
      i1 += 1;
    }
    ThreadManager.getUIHandler().post((Runnable)new AEFlashShowMaterialProviderView.selectCategoryAndItem.1(this, n));
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("itemInfo= ");
      paramString1.append(localObject1);
      paramString1.append(",index=");
      paramString1.append(n);
      paramString1.append(",pos=");
      paramString1.append(i2);
      QLog.d("AEFlashShowMaterialProviderView", 2, paramString1.toString());
    }
    if (localObject1 != null)
    {
      this.k = true;
      if (((AEMaterialMetaData)localObject1).a())
      {
        WeishiGuideUtils.a(getContext(), localObject1, 1);
        return;
      }
      postDelayed((Runnable)new AEFlashShowMaterialProviderView.selectCategoryAndItem.2(this, n, (AEMaterialMetaData)localObject1), 200L);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject1 = this.h;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((AEFlashShowMaterialManager)localObject1).c(paramBoolean);
    } else {
      localObject1 = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("### updateData totalList = ");
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", totalList.size = ");
    if (localObject1 != null) {
      localObject2 = Integer.valueOf(((List)localObject1).size());
    }
    localStringBuilder.append(localObject2);
    AEQLog.a("AEFlashShowMaterialProviderView", localStringBuilder.toString());
    this.d = ((List)new CopyOnWriteArrayList((Collection)localObject1));
    int i2 = this.l;
    int i1 = i2;
    if (!paramBoolean)
    {
      localObject1 = this.g;
      i1 = i2;
      if (localObject1 != null)
      {
        localObject2 = this.f;
        i1 = i2;
        if (localObject2 != null)
        {
          i1 = i2;
          if (localObject1 != null)
          {
            i1 = i2;
            if (!this.j)
            {
              localObject1 = ((AEFlashShowMaterialTabAdapter)localObject1).a(((QQViewPager)localObject2).getCurrentItem());
              i1 = i2;
              if (localObject1 != null)
              {
                int i3 = ((Collection)this.d).size();
                n = 0;
                for (;;)
                {
                  i1 = i2;
                  if (n >= i3) {
                    break;
                  }
                  localObject2 = (AEMaterialCategory)this.d.get(n);
                  if ((!TextUtils.isEmpty((CharSequence)((AEMaterialCategory)localObject2).d)) && (Intrinsics.areEqual(((AEMaterialCategory)localObject2).d, ((AEMaterialCategory)localObject1).d)))
                  {
                    i1 = n;
                    break;
                  }
                  n += 1;
                }
              }
            }
            this.j = false;
          }
        }
      }
    }
    localObject1 = this.g;
    if (localObject1 != null) {
      ((AEFlashShowMaterialTabAdapter)localObject1).a(CollectionsKt.toList((Iterable)this.d));
    }
    localObject1 = this.g;
    if (localObject1 != null) {
      ((AEFlashShowMaterialTabAdapter)localObject1).notifyDataSetChanged();
    }
    localObject1 = this.f;
    if (localObject1 != null) {
      ((QQViewPager)localObject1).setAdapter((PagerAdapter)this.g);
    }
    localObject1 = this.c;
    if (localObject1 != null) {
      ((QIMSlidingTabView)localObject1).initTabItemsWithRedDot(getTabNameList());
    }
    localObject1 = this.c;
    if (localObject1 != null) {
      ((QIMSlidingTabView)localObject1).setTabCheckListener((QIMSlidingTabView.IOnTabCheckListener)this);
    }
    int n = i1;
    if (i1 >= this.d.size())
    {
      n = i1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("resetPos ");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(" not exist, mTabList size = ");
        ((StringBuilder)localObject1).append(this.d.size());
        QLog.d("AEFlashShowMaterialProviderView", 2, ((StringBuilder)localObject1).toString());
        n = 0;
      }
    }
    if ((!this.k) && ((((Collection)this.d).isEmpty() ^ true)) && (this.f != null) && (this.c != null)) {
      a(n);
    }
  }
  
  public final void b()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((AEFlashShowMaterialManager)localObject).f();
    }
    localObject = this.h;
    if (localObject != null) {
      ((AEFlashShowMaterialManager)localObject).a(111);
    }
    localObject = this.h;
    if (localObject != null) {
      ((AEFlashShowMaterialManager)localObject).a(113);
    }
    localObject = this.h;
    if (localObject != null) {
      ((AEFlashShowMaterialManager)localObject).a(112);
    }
    localObject = this.b;
    if (localObject != null) {
      ((AppInterface)localObject).unRegistObserver((BusinessObserver)this.m);
    }
  }
  
  public final void c()
  {
    AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)AEFlashShowBottomPanelViewModel.a.a().getValue();
    View localView = this.e;
    if (localView != null)
    {
      boolean bool;
      if ((localAEMaterialMetaData != null) && (!localAEMaterialMetaData.d())) {
        bool = false;
      } else {
        bool = true;
      }
      localView.setSelected(bool);
    }
  }
  
  @Nullable
  public final AEFlashShowMaterialManager getManager()
  {
    return this.h;
  }
  
  @NotNull
  public String getTag()
  {
    return "AEFlashShowMaterialProviderView";
  }
  
  public void notify(@Nullable Object paramObject, int paramInt, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if ((paramInt == 114) && (paramVarArgs.length != 1)) {}
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QIMSlidingTabView localQIMSlidingTabView = this.c;
    if (localQIMSlidingTabView != null) {
      localQIMSlidingTabView.onTabChecked(paramInt);
    }
  }
  
  public void onScrollChanged() {}
  
  @TargetApi(9)
  public void onTabChecked(int paramInt)
  {
    QQViewPager localQQViewPager = this.f;
    if (localQQViewPager != null) {
      localQQViewPager.setCurrentItem(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialProviderView
 * JD-Core Version:    0.7.0.1
 */