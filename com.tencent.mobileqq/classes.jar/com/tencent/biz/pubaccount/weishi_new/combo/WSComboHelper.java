package com.tencent.biz.pubaccount.weishi_new.combo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboHelper;", "", "()V", "currentBottomBarId", "", "getCurrentBottomBarId", "()Ljava/lang/String;", "setCurrentBottomBarId", "(Ljava/lang/String;)V", "reset", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboHelper
{
  public static final WSComboHelper a = new WSComboHelper();
  @NotNull
  private static String b = "";
  
  @NotNull
  public final String a()
  {
    return b;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    b = paramString;
  }
  
  public final void b()
  {
    b = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.WSComboHelper
 * JD-Core Version:    0.7.0.1
 */