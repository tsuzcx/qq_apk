package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.IOnTabCheckListener;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.TabIcon;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "categoryList", "", "Lcom/tencent/aelight/camera/ae/data/AEMaterialCategory;", "clearButton", "Landroid/view/View;", "currentPosition", "environment", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AEMaterialEnvironment;", "repository", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AEMaterialRepository;", "tabBar", "Lcom/tencent/aelight/camera/aioeditor/capture/view/QIMSlidingTabView;", "viewPager", "Lcom/tencent/mobileqq/widget/QQViewPager;", "close", "", "callback", "Ljava/lang/Runnable;", "hidePanelAnimatedly", "initView", "open", "categoryName", "", "itemId", "refreshWatermarkEditState", "id", "enable", "", "selectCategoryAndItem", "showPanelAnimatedly", "updateData", "", "updateDataAt", "category", "position", "updateSelectedMaterial", "updateSpecificPositionData", "Companion", "PanelPageAdapter", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AENewMaterialPanel
  extends FrameLayout
{
  public static final AENewMaterialPanel.Companion a = new AENewMaterialPanel.Companion(null);
  private QIMSlidingTabView b;
  private QQViewPager c;
  private View d;
  private AEMaterialRepository e;
  private AEMaterialEnvironment f;
  private final List<AEMaterialCategory> g = (List)new ArrayList();
  private int h = -1;
  
  public AENewMaterialPanel(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AENewMaterialPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AENewMaterialPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2064056469, (ViewGroup)this);
    paramContext = findViewById(2063991460);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.stv_tab_bar)");
    this.b = ((QIMSlidingTabView)paramContext);
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabBar");
    }
    paramContext.setTabCheckListener((QIMSlidingTabView.IOnTabCheckListener)new AENewMaterialPanel.1(this));
    paramContext = findViewById(2063991201);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_none_material)");
    this.d = paramContext;
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("clearButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new AENewMaterialPanel.2(this));
    paramContext = findViewById(2063991614);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.vp_materials)");
    this.c = ((QQViewPager)paramContext);
    paramContext = this.c;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    paramContext.setOnPageChangeListener((ViewPager.OnPageChangeListener)new AENewMaterialPanel.3(this));
  }
  
  private final void a(int paramInt)
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    localObject = ((QQViewPager)localObject).getAdapter();
    if ((localObject instanceof AENewMaterialPanel.PanelPageAdapter))
    {
      localObject = (AENewMaterialPanel.PanelPageAdapter)localObject;
      AENewMaterialAdapter localAENewMaterialAdapter = ((AENewMaterialPanel.PanelPageAdapter)localObject).d(paramInt);
      if (localAENewMaterialAdapter != null)
      {
        localObject = ((AENewMaterialPanel.PanelPageAdapter)localObject).c(paramInt);
        localAENewMaterialAdapter.a((AEMaterialCategory)localObject);
        if (localObject != null)
        {
          localObject = ((AEMaterialCategory)localObject).a;
          if (localObject != null) {}
        }
        else
        {
          localObject = CollectionsKt.emptyList();
        }
        localAENewMaterialAdapter.a((List)localObject);
      }
    }
  }
  
  private final void b(Runnable paramRunnable)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation((Animation)new AlphaAnimation(0.0F, 1.0F));
    localAnimationSet.addAnimation((Animation)new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F));
    localAnimationSet.setDuration(300L);
    localAnimationSet.setInterpolator((Interpolator)new DecelerateInterpolator());
    localAnimationSet.setAnimationListener((Animation.AnimationListener)new AENewMaterialPanel.showPanelAnimatedly..inlined.apply.lambda.1(paramRunnable));
    setVisibility(0);
    startAnimation((Animation)localAnimationSet);
  }
  
  private final void c(Runnable paramRunnable)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation((Animation)new AlphaAnimation(1.0F, 0.0F));
    localAnimationSet.addAnimation((Animation)new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F));
    localAnimationSet.setDuration(300L);
    localAnimationSet.setInterpolator((Interpolator)new DecelerateInterpolator());
    localAnimationSet.setAnimationListener((Animation.AnimationListener)new AENewMaterialPanel.hidePanelAnimatedly..inlined.apply.lambda.1(this, paramRunnable));
    startAnimation((Animation)localAnimationSet);
  }
  
  public final void a()
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    PagerAdapter localPagerAdapter = ((QQViewPager)localObject).getAdapter();
    localObject = localPagerAdapter;
    if (!(localPagerAdapter instanceof AENewMaterialPanel.PanelPageAdapter)) {
      localObject = null;
    }
    localObject = (AENewMaterialPanel.PanelPageAdapter)localObject;
    if (localObject != null) {
      ((AENewMaterialPanel.PanelPageAdapter)localObject).a();
    }
  }
  
  public final void a(@NotNull AEMaterialRepository paramAEMaterialRepository, @NotNull AEMaterialEnvironment paramAEMaterialEnvironment)
  {
    Intrinsics.checkParameterIsNotNull(paramAEMaterialRepository, "repository");
    Intrinsics.checkParameterIsNotNull(paramAEMaterialEnvironment, "environment");
    AEQLog.b("AEBottomPanelPart", "init View");
    this.e = paramAEMaterialRepository;
    this.f = paramAEMaterialEnvironment;
  }
  
  public final void a(@NotNull AEMaterialCategory paramAEMaterialCategory, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAEMaterialCategory, "category");
    if (paramInt >= 0)
    {
      if (paramInt >= this.g.size()) {
        return;
      }
      this.g.set(paramInt, paramAEMaterialCategory);
      paramAEMaterialCategory = this.c;
      if (paramAEMaterialCategory == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
      }
      PagerAdapter localPagerAdapter = paramAEMaterialCategory.getAdapter();
      paramAEMaterialCategory = localPagerAdapter;
      if (!(localPagerAdapter instanceof AENewMaterialPanel.PanelPageAdapter)) {
        paramAEMaterialCategory = null;
      }
      paramAEMaterialCategory = (AENewMaterialPanel.PanelPageAdapter)paramAEMaterialCategory;
      if (paramAEMaterialCategory != null) {
        paramAEMaterialCategory.a(paramInt);
      }
    }
  }
  
  public final void a(@Nullable Runnable paramRunnable)
  {
    if (getVisibility() != 0)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
    }
    else {
      c(paramRunnable);
    }
  }
  
  public final void a(@Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "itemId");
    int m = -1;
    int k = 0;
    if (paramString1 == null)
    {
      paramString1 = this.g.iterator();
      i = 0;
      while (paramString1.hasNext())
      {
        localObject = (AEMaterialCategory)paramString1.next();
        if (((AEMaterialCategory)localObject).a != null)
        {
          localObject = ((AEMaterialCategory)localObject).a;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "cat.materialList");
          localObject = ((List)localObject).iterator();
          j = 0;
          while (((Iterator)localObject).hasNext())
          {
            if (Intrinsics.areEqual(((AEMaterialMetaData)((Iterator)localObject).next()).m, paramString2)) {
              break label129;
            }
            j += 1;
          }
          j = -1;
          label129:
          if (j >= 0)
          {
            j = 1;
            break label143;
          }
        }
        j = 0;
        label143:
        if (j != 0) {
          break label213;
        }
        i += 1;
      }
    }
    Object localObject = this.g.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (Intrinsics.areEqual(((AEMaterialCategory)((Iterator)localObject).next()).d, paramString1)) {
        break label213;
      }
      i += 1;
    }
    i = -1;
    label213:
    if (i < 0) {
      return;
    }
    post((Runnable)new AENewMaterialPanel.selectCategoryAndItem.1(this, i));
    localObject = (AEMaterialCategory)this.g.get(i);
    paramString1 = ((AEMaterialCategory)localObject).a;
    if (paramString1 == null) {
      paramString1 = CollectionsKt.emptyList();
    }
    paramString1 = paramString1.iterator();
    int j = k;
    for (;;)
    {
      k = m;
      if (!paramString1.hasNext()) {
        break;
      }
      if (Intrinsics.areEqual(((AEMaterialMetaData)paramString1.next()).m, paramString2))
      {
        k = j;
        break;
      }
      j += 1;
    }
    if (k >= 0) {
      paramString1 = (AEMaterialMetaData)((AEMaterialCategory)localObject).a.get(k);
    } else {
      paramString1 = null;
    }
    if (paramString1 != null)
    {
      if (paramString1.a())
      {
        WeishiGuideUtils.a(getContext(), paramString1, 1);
        return;
      }
      postDelayed((Runnable)new AENewMaterialPanel.selectCategoryAndItem.2(this, i, k, paramString1), 500L);
    }
  }
  
  public final void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("open material panel with categoryName [");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], materialId [");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(']');
    AEQLog.b("AEBottomPanelPart", localStringBuilder.toString());
    paramString1 = (Runnable)new AENewMaterialPanel.open.callbackWrapper.1(this, paramRunnable, paramString2, paramString1);
    if (getVisibility() == 0)
    {
      paramString1.run();
      return;
    }
    b(paramString1);
    paramString1 = this.c;
    if (paramString1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    a(paramString1.getCurrentItem());
  }
  
  public final void a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    Object localObject1 = (List)new ArrayList();
    Iterator localIterator = ((Iterable)this.g).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject2 = (AEMaterialCategory)localObject2;
      if (((AEMaterialCategory)localObject2).a != null)
      {
        localObject2 = ((AEMaterialCategory)localObject2).a;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "cat.materialList");
        localObject2 = ((Iterable)localObject2).iterator();
        int j = 0;
        while (((Iterator)localObject2).hasNext())
        {
          AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject2).next();
          if (Intrinsics.areEqual(localAEMaterialMetaData.m, paramString))
          {
            localAEMaterialMetaData.u = paramBoolean;
            j = 1;
          }
        }
        if (j != 0) {
          ((List)localObject1).add(Integer.valueOf(i));
        }
      }
      i += 1;
    }
    localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      i = ((Number)localIterator.next()).intValue();
      paramString = this.c;
      if (paramString == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
      }
      localObject1 = paramString.getAdapter();
      paramString = (String)localObject1;
      if (!(localObject1 instanceof AENewMaterialPanel.PanelPageAdapter)) {
        paramString = null;
      }
      paramString = (AENewMaterialPanel.PanelPageAdapter)paramString;
      if (paramString != null) {
        paramString.a(i);
      }
    }
  }
  
  public final void a(@NotNull List<? extends AEMaterialCategory> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "categoryList");
    AEQLog.b("AEBottomPanelPart", "update data");
    int i;
    if (paramList.size() != this.g.size()) {
      i = 1;
    } else {
      i = 0;
    }
    this.g.clear();
    this.g.addAll((Collection)paramList);
    Object localObject1 = this.b;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tabBar");
    }
    Object localObject3 = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)((Iterator)localObject3).next();
      QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
      localTabIcon.a = localAEMaterialCategory.d;
      ((Collection)localObject2).add(localTabIcon);
    }
    ((QIMSlidingTabView)localObject1).initTabItemsWithRedDot(new ArrayList((Collection)localObject2));
    localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    }
    localObject2 = ((QQViewPager)localObject1).getAdapter();
    localObject1 = localObject2;
    if (!(localObject2 instanceof AENewMaterialPanel.PanelPageAdapter)) {
      localObject1 = null;
    }
    localObject1 = (AENewMaterialPanel.PanelPageAdapter)localObject1;
    if (localObject1 == null)
    {
      localObject2 = this.c;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
      }
      ((QQViewPager)localObject2).setAdapter((PagerAdapter)new AENewMaterialPanel.PanelPageAdapter(this));
    }
    else
    {
      ((AENewMaterialPanel.PanelPageAdapter)localObject1).a();
      if (i != 0) {
        ((AENewMaterialPanel.PanelPageAdapter)localObject1).notifyDataSetChanged();
      }
    }
    if ((localObject1 == null) || (i != 0)) {
      this.h = Math.max(0, Math.min(1, paramList.size() - 1));
    }
    post((Runnable)new AENewMaterialPanel.updateData.2(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel
 * JD-Core Version:    0.7.0.1
 */