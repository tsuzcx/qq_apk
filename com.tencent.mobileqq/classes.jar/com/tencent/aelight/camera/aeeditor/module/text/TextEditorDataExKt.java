package com.tencent.aelight.camera.aeeditor.module.text;

import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"value", "", "backgroundColor", "Lcom/tencent/tavcut/bean/TextEditorData;", "getBackgroundColor", "(Lcom/tencent/tavcut/bean/TextEditorData;)I", "setBackgroundColor", "(Lcom/tencent/tavcut/bean/TextEditorData;I)V", "aelight_impl_release"}, k=2, mv={1, 1, 16})
public final class TextEditorDataExKt
{
  public static final int a(@NotNull TextEditorData paramTextEditorData)
  {
    Intrinsics.checkParameterIsNotNull(paramTextEditorData, "$this$backgroundColor");
    Integer localInteger = Integer.valueOf(0);
    if (!CollectionUtil.isEmptyMap(paramTextEditorData.getColorList())) {
      paramTextEditorData = (Integer)paramTextEditorData.getColorList().get("bgcolor");
    } else {
      paramTextEditorData = localInteger;
    }
    Object localObject = paramTextEditorData;
    if (paramTextEditorData == null) {
      localObject = localInteger;
    }
    return ((Integer)localObject).intValue();
  }
  
  public static final void a(@NotNull TextEditorData paramTextEditorData, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTextEditorData, "$this$backgroundColor");
    paramTextEditorData.setBackGroundColor("bgcolor", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.TextEditorDataExKt
 * JD-Core Version:    0.7.0.1
 */