package com.tencent.biz.pubaccount.readinjoy.share.watchword;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"replaceSymbol", "", "wording", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJWatchWordShareManager$getClipWording$1
  extends Lambda
  implements Function1<String, String>
{
  public RIJWatchWordShareManager$getClipWording$1(String paramString1, String paramString2)
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    return StringsKt.replace$default(StringsKt.replace$default(paramString, ";;", this.$title, false, 4, null), "||", this.$watchWord, false, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.getClipWording.1
 * JD-Core Version:    0.7.0.1
 */