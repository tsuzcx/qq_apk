package com.tencent.magicbrush;

import com.tencent.magicbrush.internal.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrush$Companion;", "", "()V", "DEFAULT_WINDOW_ID", "", "TAG", "", "create", "Lcom/tencent/magicbrush/MagicBrush;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "dls", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class e$a
{
  @Nullable
  public final e a(@NotNull f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "builder");
    if (!a.d(paramf)) {
      return null;
    }
    return new e(paramf, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.e.a
 * JD-Core Version:    0.7.0.1
 */