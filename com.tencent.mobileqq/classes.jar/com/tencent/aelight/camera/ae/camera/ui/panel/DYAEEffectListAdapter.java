package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListAdapter$DYAEEffectVH;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function3;", "Landroid/view/View;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function3;)V", "data", "", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "defaultDrawableId", "getDefaultDrawableId", "()I", "setDefaultDrawableId", "(I)V", "selectItem", "getSelectItem", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "setSelectItem", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;)V", "getItemCount", "onBindViewHolder", "p0", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "DYAEEffectVH", "aelight_impl_release"}, k=1, mv={1, 1, 16})
final class DYAEEffectListAdapter
  extends RecyclerView.Adapter<DYAEEffectListAdapter.DYAEEffectVH>
{
  private int a;
  @Nullable
  private DYAEEffectItem b;
  @NotNull
  private List<? extends DYAEEffectItem> c;
  private final Context d;
  private final Function3<View, DYAEEffectItem, Integer, Unit> e;
  
  public DYAEEffectListAdapter(@NotNull Context paramContext, @NotNull Function3<? super View, ? super DYAEEffectItem, ? super Integer, Unit> paramFunction3)
  {
    this.d = paramContext;
    this.e = paramFunction3;
    this.a = 2130845946;
    this.c = CollectionsKt.emptyList();
  }
  
  @Nullable
  public final DYAEEffectItem a()
  {
    return this.b;
  }
  
  @NotNull
  public DYAEEffectListAdapter.DYAEEffectVH a(@Nullable ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.d).inflate(2064056501, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "LayoutInflater.from(cont…ect_item_view, p0, false)");
    return new DYAEEffectListAdapter.DYAEEffectVH(paramViewGroup);
  }
  
  public final void a(@Nullable DYAEEffectItem paramDYAEEffectItem)
  {
    this.b = paramDYAEEffectItem;
  }
  
  public void a(@Nullable DYAEEffectListAdapter.DYAEEffectVH paramDYAEEffectVH, int paramInt)
  {
    if (paramDYAEEffectVH != null)
    {
      DYAEEffectItem localDYAEEffectItem = (DYAEEffectItem)this.c.get(paramInt);
      Object localObject2 = localDYAEEffectItem.a();
      Object localObject1 = this.b;
      if (localObject1 != null) {
        localObject1 = ((DYAEEffectItem)localObject1).a();
      } else {
        localObject1 = null;
      }
      boolean bool = Intrinsics.areEqual(localObject2, localObject1);
      if (DYAEEffectItemExtKt.a(localDYAEEffectItem)) {
        paramDYAEEffectVH.a().setImageResource(2063925613);
      }
      for (;;)
      {
        i = 1;
        break label258;
        if ((!(localDYAEEffectItem instanceof DYAEBeautyItem)) || (((DYAEBeautyItem)localDYAEEffectItem).g().k() != BeautyItem.RESET)) {
          break;
        }
        paramDYAEEffectVH.a().setImageResource(2063925614);
      }
      if (((CharSequence)localDYAEEffectItem.c()).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ResourcesCompat.getDrawable(this.d.getResources(), this.a, null);
        localObject2 = this.d.getResources();
        if (localDYAEEffectItem.d() != 0) {
          i = localDYAEEffectItem.d();
        } else {
          i = this.a;
        }
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ResourcesCompat.getDrawable((Resources)localObject2, i, null);
        paramDYAEEffectVH.a().setImageDrawable((Drawable)URLDrawable.getDrawable(localDYAEEffectItem.c(), (URLDrawable.URLDrawableOptions)localObject1));
      }
      else if (localDYAEEffectItem.d() != 0)
      {
        paramDYAEEffectVH.a().setImageResource(localDYAEEffectItem.d());
      }
      int i = 0;
      label258:
      if (i != 0)
      {
        localObject1 = this.d.getResources();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources");
        i = (int)TypedValue.applyDimension(1, 12.0F, ((Resources)localObject1).getDisplayMetrics());
      }
      else
      {
        i = 0;
      }
      paramDYAEEffectVH.f().setPadding(i, i, i, i);
      paramDYAEEffectVH.a().setAlpha(1.0F);
      if (!localDYAEEffectItem.f()) {
        paramDYAEEffectVH.a().setAlpha(0.4F);
      } else if (!bool) {
        if ((localDYAEEffectItem instanceof DYAEBeautyItem))
        {
          paramDYAEEffectVH.a().setAlpha(1.0F);
        }
        else if (DYAEEffectItemExtKt.a(localDYAEEffectItem))
        {
          paramDYAEEffectVH.a().setAlpha(1.0F);
        }
        else if ((localDYAEEffectItem instanceof DYAESecondaryBeautyItem))
        {
          localObject1 = (DYAESecondaryBeautyItem)localDYAEEffectItem;
          if ((((DYAESecondaryBeautyItem)localObject1).g().k() == BeautySecondaryItem.SUB_THIN_FACE_NATURE) || (((DYAESecondaryBeautyItem)localObject1).g().k() == BeautySecondaryItem.SUB_THIN_FACE_GIRL) || (((DYAESecondaryBeautyItem)localObject1).g().k() == BeautySecondaryItem.SUB_THIN_FACE_BOY)) {
            paramDYAEEffectVH.a().setAlpha(1.0F);
          }
        }
      }
      paramDYAEEffectVH.b().setEnabled(localDYAEEffectItem.f());
      paramDYAEEffectVH.c().setText((CharSequence)localDYAEEffectItem.b());
      paramDYAEEffectVH.c().setEnabled(localDYAEEffectItem.f());
      localObject1 = paramDYAEEffectVH.d();
      if (localDYAEEffectItem.e()) {
        i = 0;
      } else {
        i = 4;
      }
      ((View)localObject1).setVisibility(i);
      localObject1 = paramDYAEEffectVH.itemView;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "p0.itemView");
      ((View)localObject1).setSelected(bool & localDYAEEffectItem.f());
      paramDYAEEffectVH.itemView.setOnClickListener((View.OnClickListener)new DYAEEffectListAdapter.onBindViewHolder.1(this, localDYAEEffectItem, paramDYAEEffectVH, paramInt));
      localObject1 = paramDYAEEffectVH.e();
      bool = localDYAEEffectItem.h();
      i = 8;
      if ((!bool) && (!localDYAEEffectItem.i()) && (localDYAEEffectItem.f())) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      ((View)localObject1).setVisibility(paramInt);
      localObject1 = paramDYAEEffectVH.g();
      paramInt = i;
      if (!localDYAEEffectItem.h())
      {
        paramInt = i;
        if (localDYAEEffectItem.i())
        {
          paramInt = i;
          if (localDYAEEffectItem.f()) {
            paramInt = 0;
          }
        }
      }
      ((AEDownLoadingView)localObject1).setVisibility(paramInt);
      paramDYAEEffectVH.g().setProgress(localDYAEEffectItem.j());
      localObject1 = paramDYAEEffectVH.itemView;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "p0.itemView");
      DYAEEffectListHolderKt.b((View)localObject1, localDYAEEffectItem);
      paramDYAEEffectVH = paramDYAEEffectVH.itemView;
      Intrinsics.checkExpressionValueIsNotNull(paramDYAEEffectVH, "p0.itemView");
      DYAEEffectListHolderKt.c(paramDYAEEffectVH, localDYAEEffectItem);
    }
  }
  
  public final void a(@NotNull List<? extends DYAEEffectItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.c = paramList;
  }
  
  @NotNull
  public final List<DYAEEffectItem> b()
  {
    return this.c;
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListAdapter
 * JD-Core Version:    0.7.0.1
 */