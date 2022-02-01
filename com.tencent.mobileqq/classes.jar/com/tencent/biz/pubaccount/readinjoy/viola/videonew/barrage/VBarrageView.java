package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/VBarrageView;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageView;", "Lcom/tencent/viola/ui/view/IVView;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/VBarrage;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWeakReference", "Ljava/lang/ref/WeakReference;", "bindComponent", "", "component", "getComponent", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VBarrageView
  extends BarrageView
  implements IVView<VBarrage>
{
  private WeakReference<VBarrage> a;
  
  @JvmOverloads
  public VBarrageView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public VBarrageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public VBarrageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @Nullable
  public VBarrage a()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null) {
      return (VBarrage)localWeakReference.get();
    }
    return null;
  }
  
  public void a(@NotNull VBarrage paramVBarrage)
  {
    Intrinsics.checkParameterIsNotNull(paramVBarrage, "component");
    this.a = new WeakReference(paramVBarrage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.VBarrageView
 * JD-Core Version:    0.7.0.1
 */