package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialTabAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "mContext", "Landroid/content/Context;", "mMaterialPanelListener", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$AEMaterialPanelListener;", "(Landroid/content/Context;Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$AEMaterialPanelListener;)V", "mGridViewMap", "Ljava/util/HashMap;", "", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowGridView;", "getMGridViewMap", "()Ljava/util/HashMap;", "setMGridViewMap", "(Ljava/util/HashMap;)V", "mTabList", "", "Lcom/tencent/aelight/camera/ae/data/AEMaterialCategory;", "mTemplateManager", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialManager;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "object", "", "getCount", "getItemAt", "index", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "setTabList", "tabList", "setupAdapterObservers", "ptvTemplateAdapter", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialAdapter;", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialTabAdapter
  extends PagerAdapter
{
  public static final AEFlashShowMaterialTabAdapter.Companion a = new AEFlashShowMaterialTabAdapter.Companion(null);
  private List<? extends AEMaterialCategory> b;
  @NotNull
  private HashMap<Integer, AEFlashShowGridView> c;
  private AEFlashShowMaterialManager d;
  private final Context e;
  private final AEFlashShowMaterialPanel.AEMaterialPanelListener f;
  
  public AEFlashShowMaterialTabAdapter(@NotNull Context paramContext, @Nullable AEFlashShowMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    this.e = paramContext;
    this.f = paramAEMaterialPanelListener;
    this.c = new HashMap();
    paramContext = AEQIMManager.a(3);
    if (paramContext != null)
    {
      this.d = ((AEFlashShowMaterialManager)paramContext);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager");
  }
  
  private final void a(AEFlashShowMaterialAdapter paramAEFlashShowMaterialAdapter, int paramInt)
  {
    AEFlashShowMaterialManager localAEFlashShowMaterialManager = this.d;
    paramAEFlashShowMaterialAdapter = (Observer)paramAEFlashShowMaterialAdapter;
    localAEFlashShowMaterialManager.a(paramAEFlashShowMaterialAdapter, 112);
    this.d.a(paramAEFlashShowMaterialAdapter, 113);
    this.d.a(paramAEFlashShowMaterialAdapter, 1024);
    this.d.a(paramAEFlashShowMaterialAdapter, 114);
    this.d.a(paramAEFlashShowMaterialAdapter, 111);
    this.d.a(paramAEFlashShowMaterialAdapter, 115);
  }
  
  @Nullable
  public final AEMaterialCategory a(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() > paramInt) && (paramInt >= 0)) {
      return (AEMaterialCategory)localList.get(paramInt);
    }
    return null;
  }
  
  @NotNull
  public final HashMap<Integer, AEFlashShowGridView> a()
  {
    return this.c;
  }
  
  public final void a(@Nullable List<? extends AEMaterialCategory> paramList)
  {
    this.b = paramList;
  }
  
  public void destroyItem(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    paramViewGroup.removeView((View)this.c.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEFlashShowGridView)this.c.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = paramViewGroup.getAdapter();
      if (paramViewGroup != null)
      {
        paramViewGroup = (AEFlashShowMaterialAdapter)paramViewGroup;
        this.d.a((Observer)paramViewGroup);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialAdapter");
    }
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  @NotNull
  public Object instantiateItem(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    AEFlashShowGridView localAEFlashShowGridView = (AEFlashShowGridView)this.c.get(Integer.valueOf(paramInt));
    Object localObject1;
    if (localAEFlashShowGridView == null)
    {
      localAEFlashShowGridView = new AEFlashShowGridView(this.e);
      localObject1 = this.e;
      localObject2 = this.f;
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localObject1 = new AEFlashShowMaterialAdapter((Context)localObject1, localAEFlashShowGridView, (AEFlashShowMaterialPanel.AEMaterialPanelListener)localObject2, bool);
      a((AEFlashShowMaterialAdapter)localObject1, paramInt);
      ((Map)this.c).put(Integer.valueOf(paramInt), localAEFlashShowGridView);
    }
    else
    {
      localObject1 = localAEFlashShowGridView.getAdapter();
      if (localObject1 == null) {
        break label242;
      }
      localObject1 = (AEFlashShowMaterialAdapter)localObject1;
      a((AEFlashShowMaterialAdapter)localObject1, paramInt);
    }
    this.d.e();
    Object localObject2 = this.b;
    if (localObject2 != null) {
      ((AEFlashShowMaterialAdapter)localObject1).a((AEMaterialCategory)((List)localObject2).get(paramInt), ((AEMaterialCategory)((List)localObject2).get(paramInt)).a);
    }
    localAEFlashShowGridView.setAdapter((RecyclerView.Adapter)localObject1);
    paramViewGroup.addView((View)localAEFlashShowGridView);
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("instantiateItem: invoked. info: ptvTemplateAdapter = ");
      paramViewGroup.append(localObject1);
      QLog.i("AEFlashShowMaterialTabAdapter", 2, paramViewGroup.toString());
    }
    return localAEFlashShowGridView;
    label242:
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialAdapter");
  }
  
  public boolean isViewFromObject(@NotNull View paramView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialTabAdapter
 * JD-Core Version:    0.7.0.1
 */