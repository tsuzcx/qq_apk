package com.tencent.mobileqq.apollo.player.manager;

import android.widget.FrameLayout;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSFramePlayerManager;", "", "()V", "playFrameAnimation", "", "container", "Landroid/widget/FrameLayout;", "frame", "Ljava/io/File;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSFramePlayerManager
{
  public static final CMSFramePlayerManager a = new CMSFramePlayerManager();
  
  public final void a(@NotNull FrameLayout paramFrameLayout, @NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFrameLayout, "container");
    Intrinsics.checkParameterIsNotNull(paramFile, "frame");
    CMSHelper.a.a((Function0)new CMSFramePlayerManager.playFrameAnimation.1(paramFrameLayout, paramFile));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSFramePlayerManager
 * JD-Core Version:    0.7.0.1
 */