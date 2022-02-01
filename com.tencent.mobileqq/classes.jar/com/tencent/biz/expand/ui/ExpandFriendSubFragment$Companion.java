package com.tencent.biz.expand.ui;

import android.os.Bundle;
import com.tencent.biz.expand.provider.AppRuntimeProvider;
import com.tencent.biz.expand.provider.AppRuntimeProviderImpl;
import com.tencent.mobileqq.app.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandFriendSubFragment$Companion;", "", "()V", "ARGS_TEXT", "", "TAG", "newInstance", "Lcom/tencent/biz/expand/ui/ExpandFriendSubFragment;", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "text", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFriendSubFragment$Companion
{
  @NotNull
  public final ExpandFriendSubFragment a(@NotNull BaseActivity paramBaseActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Bundle localBundle = new Bundle();
    localBundle.putString("ARGS_TEXT", paramString);
    paramBaseActivity = new ExpandFriendSubFragment((AppRuntimeProvider)new AppRuntimeProviderImpl(paramBaseActivity));
    paramBaseActivity.setArguments(localBundle);
    return paramBaseActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandFriendSubFragment.Companion
 * JD-Core Version:    0.7.0.1
 */