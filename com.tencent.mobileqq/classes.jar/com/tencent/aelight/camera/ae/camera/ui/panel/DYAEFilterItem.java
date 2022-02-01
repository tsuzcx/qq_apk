package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEFilterItem;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "filterItem", "Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem;", "(Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem;)V", "getFilterItem", "()Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem;", "icon", "", "getIcon", "()Ljava/lang/String;", "id", "getId", "name", "getName", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAEFilterItem
  extends DYAEEffectItem
{
  @NotNull
  private final QIMFilterCategoryItem a;
  
  public DYAEFilterItem(@NotNull QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    super(null, null, null, 0, false, false, 0, false, 0, 0, false, 0, 4095, null);
    this.a = paramQIMFilterCategoryItem;
  }
  
  @NotNull
  public String a()
  {
    String str = this.a.a;
    Intrinsics.checkExpressionValueIsNotNull(str, "filterItem.id");
    return str;
  }
  
  @NotNull
  public String b()
  {
    String str = this.a.b;
    Intrinsics.checkExpressionValueIsNotNull(str, "filterItem.name");
    return str;
  }
  
  @NotNull
  public String c()
  {
    String str = this.a.d;
    Intrinsics.checkExpressionValueIsNotNull(str, "filterItem.iconUrl");
    return str;
  }
  
  @NotNull
  public final QIMFilterCategoryItem g()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEFilterItem
 * JD-Core Version:    0.7.0.1
 */