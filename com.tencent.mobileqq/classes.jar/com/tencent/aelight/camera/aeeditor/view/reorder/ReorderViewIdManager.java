package com.tencent.aelight.camera.aeeditor.view.reorder;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/aeeditor/view/reorder/ReorderViewIdManager;", "", "()V", "INVALID_ID", "", "ids", "", "", "clear", "", "get", "key", "put", "id", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderViewIdManager
{
  public static final ReorderViewIdManager a;
  private static final Map<String, Integer> a;
  
  static
  {
    jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderReorderViewIdManager = new ReorderViewIdManager();
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  }
  
  public final int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    paramString = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderViewIdManager
 * JD-Core Version:    0.7.0.1
 */