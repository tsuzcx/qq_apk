package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"NONE_ICON", "", "makeEmptyCosmeticItem", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEMaterialItem;", "makeEmptyLocalCosmeticItem", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAELocalMaterialItem;", "isEmptyEffect", "", "", "aelight_impl_release"}, k=2, mv={1, 1, 16})
public final class DYAEEffectItemExtKt
{
  @NotNull
  public static final DYAELocalMaterialItem a()
  {
    return new DYAELocalMaterialItem("cosmetic_none", "原图", "https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none2.png", "");
  }
  
  public static final boolean a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof DYAELocalMaterialItem))
    {
      if (((CharSequence)((DYAELocalMaterialItem)paramObject).g()).length() != 0) {}
    }
    else {
      do
      {
        for (;;)
        {
          return true;
          if ((paramObject instanceof DYAEMaterialItem)) {
            return Intrinsics.areEqual(((DYAEMaterialItem)paramObject).a(), "0");
          }
          if ((paramObject instanceof DYAEFilterItem)) {
            return ((DYAEFilterItem)paramObject).g().d();
          }
          if ((paramObject instanceof DYAEBeautyItem))
          {
            if (((DYAEBeautyItem)paramObject).g().a() != BeautyItem.NONE.getType()) {
              break label184;
            }
          }
          else
          {
            if (!(paramObject instanceof DYAESecondaryBeautyItem)) {
              break;
            }
            if (((DYAESecondaryBeautyItem)paramObject).g().a() != BeautyItem.NONE) {
              break label184;
            }
          }
        }
        if ((paramObject instanceof QIMFilterCategoryItem)) {
          return ((QIMFilterCategoryItem)paramObject).d();
        }
      } while ((paramObject instanceof AEBeautyConfigModel) ? ((AEBeautyConfigModel)paramObject).a() == BeautyItem.NONE.getType() : (!(paramObject instanceof AEBeautySecondaryConfigModel)) || (((AEBeautySecondaryConfigModel)paramObject).a() == BeautyItem.NONE));
    }
    label184:
    return false;
  }
  
  @NotNull
  public static final DYAEMaterialItem b()
  {
    AEMaterialMetaData localAEMaterialMetaData = AEMaterialMetaData.l;
    localAEMaterialMetaData.t = "原图";
    localAEMaterialMetaData.X = "原图";
    localAEMaterialMetaData.A = true;
    Intrinsics.checkExpressionValueIsNotNull(localAEMaterialMetaData, "material");
    return new DYAEMaterialItem(localAEMaterialMetaData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectItemExtKt
 * JD-Core Version:    0.7.0.1
 */