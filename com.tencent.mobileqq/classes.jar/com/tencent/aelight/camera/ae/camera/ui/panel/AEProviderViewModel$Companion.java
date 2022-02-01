package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEProviderViewModel$Companion;", "", "()V", "ENABLE_SAVE_BEAUTY_VALUE", "", "getENABLE_SAVE_BEAUTY_VALUE", "()Z", "setENABLE_SAVE_BEAUTY_VALUE", "(Z)V", "ENABLE_SAVE_COSMETIC_VALUE", "getENABLE_SAVE_COSMETIC_VALUE", "setENABLE_SAVE_COSMETIC_VALUE", "ENABLE_SAVE_FILTER_VALUE", "getENABLE_SAVE_FILTER_VALUE", "setENABLE_SAVE_FILTER_VALUE", "TAB_INDEX_BEAUTY", "", "TAB_INDEX_COSMETICS", "TAB_INDEX_FILTER", "TAG", "", "beautyConfigAdjustCache", "", "Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "beautySecondaryConfigAdjustCache", "cosmeticsAdjustCache", "defaultFilterValueMap", "", "defaultStyleDefaultMap", "filterAdjustCache", "secondarySelectedCache", "getAdjustSaveKey", "model", "getAdjustValue", "getDefaultFilterStyleValue", "map", "getDefaultValue", "getFilterAdjustView", "id", "getMaxValue", "getMinValue", "getSavedAdjustValue", "defaultValue", "getSeekBarValue", "", "(Ljava/lang/Object;)[Ljava/lang/Integer;", "saveAdjustValue", "", "value", "setAdjustValue", "getSavedSecondarySelectIndex", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "getSecondarySelectIndexSaveKey", "getSecondarySelectedIndex", "getSelectedSecondaryConfigModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautySecondaryConfigModel;", "saveSecondarySelectIndex", "setSecondarySelectedIndex", "index", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEProviderViewModel$Companion
{
  private final int a(Object paramObject, Map<String, Integer> paramMap)
  {
    boolean bool = paramObject instanceof QIMFilterCategoryItem;
    int i = 100;
    if (bool)
    {
      paramObject = (QIMFilterCategoryItem)paramObject;
      j = i;
      if (paramMap.containsKey(paramObject.b))
      {
        paramObject = (Integer)paramMap.get(paramObject.b);
        j = i;
        if (paramObject != null) {
          j = paramObject.intValue();
        }
      }
      return j;
    }
    int j = i;
    if ((paramObject instanceof DYAEEffectItem))
    {
      paramObject = (DYAEEffectItem)paramObject;
      j = i;
      if (paramMap.containsKey(paramObject.b()))
      {
        paramObject = (Integer)paramMap.get(paramObject.b());
        j = i;
        if (paramObject != null) {
          j = paramObject.intValue();
        }
      }
    }
    return j;
  }
  
  @JvmStatic
  private final Integer[] f(Object paramObject)
  {
    boolean bool = paramObject instanceof AEBeautyConfigModel;
    Integer localInteger1 = Integer.valueOf(100);
    Integer localInteger2 = Integer.valueOf(0);
    if (bool)
    {
      paramObject = (AEBeautyConfigModel)paramObject;
      if (paramObject.i().isEmpty()) {
        return new Integer[] { Integer.valueOf(paramObject.c()), Integer.valueOf(paramObject.d()), Integer.valueOf(paramObject.e()) };
      }
      paramObject = ((Companion)this).b(paramObject);
      if (paramObject != null)
      {
        paramObject = AEProviderViewModel.a.f(paramObject);
        if (paramObject != null) {}
      }
      else
      {
        paramObject = new Integer[3];
        paramObject[0] = localInteger2;
        paramObject[1] = localInteger1;
        paramObject[2] = localInteger1;
      }
      return paramObject;
    }
    if ((paramObject instanceof AEBeautySecondaryConfigModel))
    {
      paramObject = (AEBeautySecondaryConfigModel)paramObject;
      return new Integer[] { Integer.valueOf(paramObject.g()), Integer.valueOf(paramObject.h()), Integer.valueOf(paramObject.i()) };
    }
    if ((paramObject instanceof QIMFilterCategoryItem)) {
      return new Integer[] { localInteger2, localInteger1, Integer.valueOf(((Companion)this).a(paramObject, AEProviderViewModel.n())) };
    }
    if ((paramObject instanceof DYAEEffectItem)) {
      return new Integer[] { localInteger2, localInteger1, Integer.valueOf(((DYAEEffectItem)paramObject).m()) };
    }
    return new Integer[] { localInteger2, localInteger1, localInteger1 };
  }
  
  @JvmStatic
  public final int a(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAEBeautyConfigModel, "$this$getSecondarySelectedIndex");
    Object localObject = (Integer)AEProviderViewModel.i().get(paramAEBeautyConfigModel.a());
    int i;
    if (localObject != null) {
      i = ((Integer)localObject).intValue();
    } else {
      i = -1;
    }
    int j = i;
    if (i < 0)
    {
      localObject = (Companion)this;
      j = ((Companion)localObject).b(paramAEBeautyConfigModel, paramAEBeautyConfigModel.j());
      ((Companion)localObject).a(paramAEBeautyConfigModel, j);
    }
    return j;
  }
  
  @JvmStatic
  public final int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    Object localObject = (Integer)AEProviderViewModel.l().get(paramString);
    int i;
    if (localObject != null) {
      i = ((Integer)localObject).intValue();
    } else {
      i = -1;
    }
    int j = i;
    if (i < 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sp_key_filter_adjust_key_-");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("-adjust");
      paramString = ((StringBuilder)localObject).toString();
      j = AECameraPrefsUtil.a().b(paramString, 100, 0);
    }
    return j;
  }
  
  @JvmStatic
  @NotNull
  public final String a(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "model");
    boolean bool = paramObject instanceof AEBeautyConfigModel;
    String str = "";
    Object localObject;
    if (bool)
    {
      Companion localCompanion = (Companion)this;
      localObject = str;
      if (localCompanion.a())
      {
        paramObject = (AEBeautyConfigModel)paramObject;
        if (paramObject.i().isEmpty())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sp_key_beauty_transform_key_-");
          ((StringBuilder)localObject).append(paramObject.a().value);
          ((StringBuilder)localObject).append("-adjust");
          return ((StringBuilder)localObject).toString();
        }
        paramObject = localCompanion.b(paramObject);
        localObject = str;
        if (paramObject != null)
        {
          paramObject = AEProviderViewModel.a.a(paramObject);
          localObject = str;
          if (paramObject != null) {
            return paramObject;
          }
        }
      }
    }
    else if ((paramObject instanceof AEBeautySecondaryConfigModel))
    {
      localObject = str;
      if (((Companion)this).a())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sp_key_beauty_transform_key_-");
        ((StringBuilder)localObject).append(((AEBeautySecondaryConfigModel)paramObject).c());
        ((StringBuilder)localObject).append("-adjust");
        return ((StringBuilder)localObject).toString();
      }
    }
    else if ((paramObject instanceof QIMFilterCategoryItem))
    {
      localObject = str;
      if (((Companion)this).b())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sp_key_filter_adjust_key_-");
        ((StringBuilder)localObject).append(((QIMFilterCategoryItem)paramObject).a);
        ((StringBuilder)localObject).append("-adjust");
        return ((StringBuilder)localObject).toString();
      }
    }
    else if ((paramObject instanceof DYAEMaterialItem))
    {
      localObject = str;
      if (((Companion)this).c())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sp_key_cosmetic_adjust_key_-");
        ((StringBuilder)localObject).append(((DYAEMaterialItem)paramObject).a());
        ((StringBuilder)localObject).append("-adjust");
        return ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = str;
      if ((paramObject instanceof DYAELocalMaterialItem))
      {
        localObject = str;
        if (((Companion)this).c())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sp_key_cosmetic_adjust_key_-");
          ((StringBuilder)localObject).append(((DYAELocalMaterialItem)paramObject).a());
          ((StringBuilder)localObject).append("-adjust");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
    }
    return localObject;
  }
  
  @JvmStatic
  public final void a(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAEBeautyConfigModel, "$this$setSecondarySelectedIndex");
    AEProviderViewModel.i().put(paramAEBeautyConfigModel.a(), Integer.valueOf(paramInt));
  }
  
  @JvmStatic
  public final void a(@NotNull Object paramObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "model");
    paramObject = ((Companion)this).a(paramObject);
    int i;
    if (((CharSequence)paramObject).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      AECameraPrefsUtil.a().a(paramObject, paramInt, 0);
    }
  }
  
  public final boolean a()
  {
    return AEProviderViewModel.f();
  }
  
  @JvmStatic
  public final int b(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAEBeautyConfigModel, "$this$getSavedSecondarySelectIndex");
    paramAEBeautyConfigModel = ((Companion)this).c(paramAEBeautyConfigModel);
    int i;
    if (((CharSequence)paramAEBeautyConfigModel).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramInt;
    if (i != 0) {
      j = AECameraPrefsUtil.a().b(paramAEBeautyConfigModel, paramInt, 0);
    }
    return j;
  }
  
  @JvmStatic
  public final int b(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "model");
    boolean bool = paramObject instanceof AEBeautyConfigModel;
    int i = -1;
    Object localObject;
    if (bool)
    {
      localObject = (AEBeautyConfigModel)paramObject;
      if (((AEBeautyConfigModel)localObject).i().isEmpty())
      {
        localObject = (Integer)AEProviderViewModel.j().get(((AEBeautyConfigModel)localObject).a());
        if (localObject != null) {
          i = ((Integer)localObject).intValue();
        }
      }
      else
      {
        localObject = ((Companion)this).b((AEBeautyConfigModel)localObject);
        if (localObject != null) {
          i = AEProviderViewModel.a.b(localObject);
        }
      }
    }
    else if ((paramObject instanceof AEBeautySecondaryConfigModel))
    {
      localObject = (Integer)AEProviderViewModel.k().get(((AEBeautySecondaryConfigModel)paramObject).c());
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      }
    }
    else if ((paramObject instanceof QIMFilterCategoryItem))
    {
      localObject = (Integer)AEProviderViewModel.l().get(((QIMFilterCategoryItem)paramObject).a);
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      }
    }
    else if ((paramObject instanceof DYAEMaterialItem))
    {
      localObject = (Integer)AEProviderViewModel.m().get(((DYAEMaterialItem)paramObject).a());
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      }
    }
    else if ((paramObject instanceof DYAELocalMaterialItem))
    {
      localObject = (Integer)AEProviderViewModel.m().get(((DYAELocalMaterialItem)paramObject).a());
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      }
    }
    else
    {
      i = 100;
    }
    int j = i;
    if (i < 0)
    {
      localObject = (Companion)this;
      j = ((Companion)localObject).b(paramObject, ((Companion)localObject).e(paramObject));
      ((Companion)localObject).c(paramObject, j);
    }
    return j;
  }
  
  public final int b(@NotNull Object paramObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "model");
    paramObject = ((Companion)this).a(paramObject);
    int i;
    if (((CharSequence)paramObject).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramInt;
    if (i != 0) {
      j = AECameraPrefsUtil.a().b(paramObject, paramInt, 0);
    }
    return j;
  }
  
  @JvmStatic
  @Nullable
  public final AEBeautySecondaryConfigModel b(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAEBeautyConfigModel, "$this$getSelectedSecondaryConfigModel");
    Collection localCollection = (Collection)paramAEBeautyConfigModel.i();
    int i;
    if ((localCollection != null) && (!localCollection.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return null;
    }
    return (AEBeautySecondaryConfigModel)paramAEBeautyConfigModel.i().get(((Companion)this).a(paramAEBeautyConfigModel));
  }
  
  public final boolean b()
  {
    return AEProviderViewModel.g();
  }
  
  @JvmStatic
  public final int c(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "model");
    return ((Companion)this).f(paramObject)[0].intValue();
  }
  
  @JvmStatic
  @NotNull
  public final String c(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAEBeautyConfigModel, "$this$getSecondarySelectIndexSaveKey");
    if (((Companion)this).a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_key_beauty_transform_key_-");
      localStringBuilder.append(paramAEBeautyConfigModel.a().value);
      localStringBuilder.append("-secondary-select-index");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  @JvmStatic
  public final void c(@NotNull Object paramObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "model");
    if ((paramObject instanceof AEBeautyConfigModel))
    {
      paramObject = (AEBeautyConfigModel)paramObject;
      if (paramObject.i().isEmpty())
      {
        AEProviderViewModel.j().put(paramObject.a(), Integer.valueOf(paramInt));
        return;
      }
      paramObject = ((Companion)this).b(paramObject);
      if (paramObject != null) {
        AEProviderViewModel.a.c(paramObject, paramInt);
      }
    }
    else
    {
      if ((paramObject instanceof AEBeautySecondaryConfigModel))
      {
        AEProviderViewModel.k().put(((AEBeautySecondaryConfigModel)paramObject).c(), Integer.valueOf(paramInt));
        return;
      }
      if ((paramObject instanceof QIMFilterCategoryItem))
      {
        localObject = AEProviderViewModel.l();
        paramObject = ((QIMFilterCategoryItem)paramObject).a;
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "model.id");
        ((Map)localObject).put(paramObject, Integer.valueOf(paramInt));
        return;
      }
      if ((paramObject instanceof DYAEMaterialItem))
      {
        AEProviderViewModel.m().put(((DYAEMaterialItem)paramObject).a(), Integer.valueOf(paramInt));
        return;
      }
      if ((paramObject instanceof DYAELocalMaterialItem))
      {
        AEProviderViewModel.m().put(((DYAELocalMaterialItem)paramObject).a(), Integer.valueOf(paramInt));
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set seek bar value to ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" with invalid data object: ");
      ((StringBuilder)localObject).append(paramObject);
      AEQLog.d("AEProviderViewModel", ((StringBuilder)localObject).toString());
    }
  }
  
  public final boolean c()
  {
    return AEProviderViewModel.h();
  }
  
  @JvmStatic
  public final int d(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "model");
    return ((Companion)this).f(paramObject)[1].intValue();
  }
  
  @JvmStatic
  public final void d(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAEBeautyConfigModel, "$this$saveSecondarySelectIndex");
    Companion localCompanion = (Companion)this;
    String str = localCompanion.c(paramAEBeautyConfigModel);
    int j = localCompanion.a(paramAEBeautyConfigModel);
    int i;
    if (((CharSequence)str).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      AECameraPrefsUtil.a().a(str, j, 0);
    }
  }
  
  @JvmStatic
  public final int e(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "model");
    return ((Companion)this).f(paramObject)[2].intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel.Companion
 * JD-Core Version:    0.7.0.1
 */