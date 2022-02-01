package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.graphics.Color;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.control.IAEQIMManager;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"defaultConfig", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyPanelConfig;", "getDefaultConfig", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyPanelConfig;", "flashShowConfig", "getFlashShowConfig", "getTabText", "", "", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEBeautyPanelConfig;)[Ljava/lang/String;", "tabToModelIndex", "", "index", "aelight_impl_release"}, k=2, mv={1, 1, 16})
@JvmName(name="DYAEBeautyPanelConfigUtil")
public final class DYAEBeautyPanelConfigUtil
{
  @NotNull
  private static final DYAEBeautyPanelConfig a;
  @NotNull
  private static final DYAEBeautyPanelConfig b;
  
  static
  {
    Pair localPair1 = TuplesKt.to("滤镜", Integer.valueOf(0));
    Object localObject2 = Integer.valueOf(1);
    Pair localPair2 = TuplesKt.to("美颜", localObject2);
    Object localObject1 = Integer.valueOf(2);
    Pair localPair3 = TuplesKt.to("美妆", localObject1);
    int i = Color.parseColor("#8CFFFFFF");
    IAEQIMManager localIAEQIMManager = AEQIMManager.a(1);
    if (localIAEQIMManager != null)
    {
      localIAEQIMManager = (IAEQIMManager)localIAEQIMManager;
      a = new DYAEBeautyPanelConfig(2063925553, new Pair[] { localPair1, localPair2, localPair3 }, false, -1, i, localIAEQIMManager, false, 2064187441);
      localPair1 = TuplesKt.to("美颜", localObject2);
      localObject1 = TuplesKt.to("美妆", localObject1);
      i = Color.parseColor("#8CFFFFFF");
      localObject2 = AEQIMManager.a(3);
      if (localObject2 != null)
      {
        localObject2 = (IAEQIMManager)localObject2;
        b = new DYAEBeautyPanelConfig(2063925553, new Pair[] { localPair1, localObject1 }, false, -1, i, (IAEQIMManager)localObject2, true, 2064187441);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.data.AEMaterialManager");
  }
  
  public static final int a(@NotNull DYAEBeautyPanelConfig paramDYAEBeautyPanelConfig, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramDYAEBeautyPanelConfig, "$this$tabToModelIndex");
    if ((paramInt >= 0) && (paramInt < paramDYAEBeautyPanelConfig.b().length)) {
      return ((Number)paramDYAEBeautyPanelConfig.b()[paramInt].getSecond()).intValue();
    }
    return -1;
  }
  
  @NotNull
  public static final DYAEBeautyPanelConfig a()
  {
    return a;
  }
  
  @NotNull
  public static final String[] a(@NotNull DYAEBeautyPanelConfig paramDYAEBeautyPanelConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDYAEBeautyPanelConfig, "$this$getTabText");
    paramDYAEBeautyPanelConfig = paramDYAEBeautyPanelConfig.b();
    Collection localCollection = (Collection)new ArrayList(paramDYAEBeautyPanelConfig.length);
    int j = paramDYAEBeautyPanelConfig.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add((String)paramDYAEBeautyPanelConfig[i].getFirst());
      i += 1;
    }
    paramDYAEBeautyPanelConfig = ((Collection)localCollection).toArray(new String[0]);
    if (paramDYAEBeautyPanelConfig != null) {
      return (String[])paramDYAEBeautyPanelConfig;
    }
    paramDYAEBeautyPanelConfig = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramDYAEBeautyPanelConfig;
    }
  }
  
  @NotNull
  public static final DYAEBeautyPanelConfig b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyPanelConfigUtil
 * JD-Core Version:    0.7.0.1
 */